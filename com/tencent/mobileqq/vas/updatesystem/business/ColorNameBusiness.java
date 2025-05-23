package com.tencent.mobileqq.vas.updatesystem.business;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import p33.ScannerData;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorNameBusiness extends QQVasUpdateBusiness {
    public static final long BID = 57;
    public static final String SCID_PREFIX = "colorfulnickname.";
    protected static final String TAG = "color_name";
    private HashMap<Integer, p33.a> configCache = new HashMap<>();

    private Bitmap getShaderBitmap(int i3) {
        return new BitmapDrawable(getSavePath(i3) + "/image.png").getBitmap();
    }

    private void setBitmapShader(p33.a aVar, JSONObject jSONObject, int i3) {
        boolean z16;
        if (jSONObject.optInt("image") > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Bitmap shaderBitmap = getShaderBitmap(i3);
            if (shaderBitmap != null) {
                aVar.l(true);
                aVar.k(shaderBitmap);
            } else {
                QLog.e(TAG, 1, "shader bitmap is null!");
            }
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 57L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return TAG;
    }

    public p33.a getColorNameData(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.configCache.containsKey(Integer.valueOf(i3))) {
            return this.configCache.get(Integer.valueOf(i3));
        }
        if (!isFileExist(getScid(i3))) {
            startDownload(i3);
            return null;
        }
        p33.a aVar = new p33.a();
        File file = new File(getSavePath(i3), "config.json");
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (!file.exists()) {
            QLog.i(TAG, 1, "getColorNameData file does not exist, " + file.getAbsolutePath());
            return aVar;
        }
        JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
        JSONArray jSONArray = jSONObject.getJSONArray(NodeProps.COLORS);
        int length = jSONArray.length();
        int[] iArr = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            String optString = jSONArray.optString(i16);
            iArr[i16] = Color.parseColor(optString);
            VasLogNtReporter.getVipColorName().reportLow("parse color:" + i3 + "-" + optString);
        }
        aVar.h(iArr);
        int optInt = jSONObject.optInt("sweep_type", 0);
        aVar.i(jSONObject.optString("normal_color", ""));
        if (jSONObject.optInt("bold") > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.g(z16);
        setBitmapShader(aVar, jSONObject, i3);
        if (optInt != 0) {
            if (optInt == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            String optString2 = jSONObject.optString("sweep_color");
            if (jSONObject.optInt("has_cover_animation") == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.j(new ScannerData(z17, optString2, z18));
        }
        this.configCache.put(Integer.valueOf(i3), aVar);
        return aVar;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return SCID_PREFIX + i3 + ".common.zip";
    }

    public boolean hasCache(int i3) {
        return this.configCache.containsKey(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
