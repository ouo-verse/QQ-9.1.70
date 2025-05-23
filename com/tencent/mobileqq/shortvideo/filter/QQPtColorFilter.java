package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class QQPtColorFilter extends QQBaseFilter {
    public static final String TAG = "QQPtColorFilter";
    private static HashSet blackList;
    private boolean bwork;
    private String currentFilterPath;
    private VideoFilterBase effectFilter;
    private boolean hasinit;
    private GPUImageLookupFilter internalFilter;
    private boolean isLoadSoSuccess;
    private int lastHeight;
    private int lastWidth;
    private Frame mCacheFrame;
    private int[] mPtColorTextureId;
    private boolean needChange;
    private String newFilterPath;

    static {
        HashSet hashSet = new HashSet();
        blackList = hashSet;
        hashSet.add("HUAWEI_ALP-AL00");
    }

    public QQPtColorFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(999, qQFilterRenderManager);
        this.mCacheFrame = new Frame();
        this.mPtColorTextureId = new int[1];
        this.internalFilter = new GPUImageLookupFilter();
        this.hasinit = false;
        this.isLoadSoSuccess = false;
        this.lastWidth = 0;
        this.lastHeight = 0;
        this.newFilterPath = null;
        this.needChange = false;
        this.bwork = false;
        GPUImageLookupFilter.jarPath = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QQPtColorFilterInfo getColorFilterInfo(String str) {
        JSONObject jSONObject;
        int i3;
        String str2;
        String str3;
        JSONArray jSONArray;
        InputStream inputStreamFromPath;
        String convertStreamToString;
        try {
            inputStreamFromPath = CommonUtils.getInputStreamFromPath(SdkContext.getInstance().getApplication(), str + File.separator + IVideoFilterTools.CONFIG_FILE);
        } catch (Exception e16) {
            SLog.e("QQPtColorFilterInfo", "getColorFilterInfo:" + e16);
        }
        if (inputStreamFromPath != null && (convertStreamToString = CommonUtils.convertStreamToString(inputStreamFromPath)) != null) {
            jSONObject = new JSONObject(convertStreamToString);
            if (jSONObject != null) {
                if (SLog.isEnable()) {
                    SLog.e("QQPtColorFilterInfo", "filterConfig == null!");
                }
                return null;
            }
            try {
                int i16 = -1;
                if (jSONObject.has(ShortVideoConstants.PARAM_KEY_FILTER_ID)) {
                    i3 = Integer.valueOf(jSONObject.getString(ShortVideoConstants.PARAM_KEY_FILTER_ID)).intValue();
                } else {
                    i3 = -1;
                }
                if (jSONObject.has("name")) {
                    str2 = jSONObject.getString("name");
                } else {
                    str2 = null;
                }
                if (jSONObject.has("subId")) {
                    i16 = Integer.valueOf(jSONObject.getString("subId")).intValue();
                }
                if (jSONObject.has("resourceList") && (jSONArray = jSONObject.getJSONArray("resourceList")) != null && jSONArray.length() > 0) {
                    str3 = jSONArray.get(0).toString();
                } else {
                    str3 = null;
                }
                return new QQPtColorFilterInfo(i3, str2, i16, str3);
            } catch (Exception unused) {
                return null;
            }
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    private void init(int i3, int i16) {
        release();
        this.internalFilter.applyFilterChain(true, i3, i16);
        int[] iArr = this.mPtColorTextureId;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        this.hasinit = true;
    }

    private void release() {
        if (!this.isLoadSoSuccess) {
            return;
        }
        GPUImageLookupFilter gPUImageLookupFilter = this.internalFilter;
        if (gPUImageLookupFilter != null) {
            gPUImageLookupFilter.clearGLSL();
        }
        this.mCacheFrame.clear();
        int[] iArr = this.mPtColorTextureId;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        if (SLog.isEnable()) {
            SLog.d(TAG, "reslease internalFilter");
        }
        this.hasinit = false;
    }

    private synchronized void setNeedChangeFilter(String str, boolean z16) {
        this.newFilterPath = str;
        this.needChange = z16;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.bwork;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        if (TextUtils.isEmpty(this.newFilterPath) && TextUtils.isEmpty(this.currentFilterPath) && this.effectFilter == null) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        this.lastWidth = getQQFilterRenderManager().getFilterWidth();
        this.lastHeight = getQQFilterRenderManager().getFilterHeight();
        if (!this.isLoadSoSuccess) {
            this.isLoadSoSuccess = getQQFilterRenderManager().loadFilterSoSuccess();
        }
        if (!this.isLoadSoSuccess) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        if (!this.hasinit) {
            init(this.lastWidth, this.lastHeight);
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        VideoFilterBase videoFilterBase = this.effectFilter;
        if (videoFilterBase != null && videoFilterBase.isValid()) {
            this.mOutputTextureID = this.effectFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight).getTextureId();
            return;
        }
        String str = this.newFilterPath;
        if (this.needChange) {
            setNeedChangeFilter(null, false);
            this.currentFilterPath = str;
            this.internalFilter.updateLut(str);
        }
        if (TextUtils.isEmpty(this.currentFilterPath)) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        this.internalFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mPtColorTextureId[0], 0.0d, this.mCacheFrame);
        if (blackList.contains(DeviceInstance.getInstance().getDeviceName())) {
            Bitmap saveTexture = RendererUtils.saveTexture(this.mCacheFrame);
            Log.e(TAG, "Save bitmap to avoid black lines " + saveTexture.getWidth());
            saveTexture.recycle();
        }
        this.mOutputTextureID = this.mPtColorTextureId[0];
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        if (!this.isLoadSoSuccess) {
            return;
        }
        int i17 = this.lastHeight;
        if (i17 != i3 || i17 != i16) {
            init(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        if (this.hasinit) {
            release();
            VideoFilterBase videoFilterBase = this.effectFilter;
            if (videoFilterBase != null) {
                videoFilterBase.clearGLSLSelf();
            }
        }
    }

    public void setEffectFilter(VideoFilterBase videoFilterBase) {
        VideoFilterBase videoFilterBase2 = this.effectFilter;
        if (videoFilterBase2 != null) {
            videoFilterBase2.clearGLSLSelf();
            this.effectFilter = null;
        }
        this.effectFilter = videoFilterBase;
    }

    public void setLutResPath(FilterDesc filterDesc) {
        String resFold;
        if (filterDesc == null) {
            setNeedChangeFilter(null, true);
            this.bwork = false;
            return;
        }
        String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (!TextUtils.isEmpty(filterDesc.resRootPath)) {
            resFold = filterDesc.getResFold(filterDesc.resRootPath);
        } else {
            resFold = filterDesc.getResFold(filterResPath);
        }
        String str = resFold + filterDesc.respicname;
        if (new File(str).exists()) {
            setNeedChangeFilter(str, true);
            this.bwork = true;
        }
    }
}
