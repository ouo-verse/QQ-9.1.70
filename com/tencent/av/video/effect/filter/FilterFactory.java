package com.tencent.av.video.effect.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageBlackNoiseFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorAmaroFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorEffectFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageColorEffectNewFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageComicFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGrayscaleFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageShifterEffectFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageSingleCurvePicFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoCurvePicFilter;
import com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoSrcFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FilterFactory {
    private static final String CONFIG_FILE = "params.json";
    private static final String PARAM_FILTER_ID = "filterId";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_RESOURCE_LIST = "resourceList";
    private static final String PARAM_SUB_ID = "subId";
    private static final String TAG = "FilterFactory";
    private WeakReference<Context> mContextReference;
    private QQAVImageFilter mFilter;
    private String mFilterPath;

    public FilterFactory(Context context) {
        this.mContextReference = new WeakReference<>(context);
    }

    public static QQAVImageFilter createFilter(Context context, JSONObject jSONObject, String str) {
        int i3;
        JSONArray jSONArray;
        QQAVImageFilter qQAVImageColorEffectFilter;
        QQAVImageFilter qQAVImageFilter = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            int i16 = -1;
            if (jSONObject.has("filterId")) {
                i3 = Integer.valueOf(jSONObject.getString("filterId")).intValue();
            } else {
                i3 = -1;
            }
            String str2 = "none";
            if (jSONObject.has("name")) {
                str2 = jSONObject.getString("name");
            }
            if (jSONObject.has(PARAM_SUB_ID)) {
                i16 = Integer.valueOf(jSONObject.getString(PARAM_SUB_ID)).intValue();
            }
            if (jSONObject.has(PARAM_RESOURCE_LIST)) {
                jSONArray = jSONObject.getJSONArray(PARAM_RESOURCE_LIST);
            } else {
                jSONArray = null;
            }
            switch (i3) {
                case 1:
                    qQAVImageColorEffectFilter = new QQAVImageColorEffectFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 2:
                    qQAVImageColorEffectFilter = new QQAVImageColorAmaroFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 3:
                    qQAVImageColorEffectFilter = new QQAVImageComicFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 6:
                    qQAVImageColorEffectFilter = new QQAVImageGrayscaleFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 7:
                    qQAVImageColorEffectFilter = new QQAVImageTwoCurvePicFilter(i16);
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 8:
                    qQAVImageColorEffectFilter = new QQAVImageSingleCurvePicFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 11:
                    qQAVImageColorEffectFilter = new QQAVImageColorEffectNewFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 12:
                    qQAVImageColorEffectFilter = new QQAVImageShifterEffectFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 13:
                    qQAVImageColorEffectFilter = new QQAVImageBlackNoiseFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
                case 14:
                    qQAVImageColorEffectFilter = new QQAVImageTwoSrcFilter();
                    qQAVImageFilter = qQAVImageColorEffectFilter;
                    break;
            }
            if (qQAVImageFilter != null) {
                qQAVImageFilter.setQQAVEffectType(i3);
                qQAVImageFilter.setQQAVEffectID(str2);
                qQAVImageFilter.setQQAVEffectName(str2);
                prepareResource(context, qQAVImageFilter, str, jSONArray);
            }
        } catch (Exception e16) {
            Log.e(TAG, "createFilter:" + e16);
        }
        return qQAVImageFilter;
    }

    private void destroyFilter() {
        QQAVImageFilter qQAVImageFilter = this.mFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
        }
        this.mFilter = null;
        this.mFilterPath = null;
    }

    public static void prepareResource(Context context, QQAVImageFilter qQAVImageFilter, String str, JSONArray jSONArray) {
        if (qQAVImageFilter != null && jSONArray != null && jSONArray.length() != 0 && context != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(context, str + File.separator + jSONArray.get(i3).toString()));
                    if (decodeStream != null) {
                        qQAVImageFilter.setBitmap(i3, decodeStream);
                    }
                } catch (Throwable th5) {
                    Log.e(TAG, "prepareResource:" + th5);
                    return;
                }
            }
        }
    }

    public QQAVImageFilter getFilter(String str) {
        String convertStreamToString;
        QQAVImageFilter qQAVImageFilter;
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            destroyFilter();
            return null;
        }
        String str2 = this.mFilterPath;
        if (str2 != null && str2.equals(str) && (qQAVImageFilter = this.mFilter) != null) {
            return qQAVImageFilter;
        }
        destroyFilter();
        this.mFilterPath = str;
        WeakReference<Context> weakReference = this.mContextReference;
        if (weakReference != null && weakReference.get() != null) {
            try {
                InputStream inputStreamFromPath = CommonUtils.getInputStreamFromPath(this.mContextReference.get(), this.mFilterPath + File.separator + "params.json");
                if (inputStreamFromPath != null && (convertStreamToString = CommonUtils.convertStreamToString(inputStreamFromPath)) != null) {
                    jSONObject = new JSONObject(convertStreamToString);
                }
            } catch (Exception e16) {
                Log.e(TAG, "parseJson:" + e16);
            }
            this.mFilter = createFilter(this.mContextReference.get(), jSONObject, this.mFilterPath);
        }
        return this.mFilter;
    }
}
