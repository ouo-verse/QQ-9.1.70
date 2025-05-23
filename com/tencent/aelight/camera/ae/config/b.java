package com.tencent.aelight.camera.ae.config;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.common.util.k;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static MutableLiveData<Boolean> f63477a = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name */
    private static MutableLiveData<Boolean> f63478b = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name */
    private static MutableLiveData<Boolean> f63479c = new MutableLiveData<>();

    public static MutableLiveData<Boolean> b() {
        return f63477a;
    }

    public static MutableLiveData<Boolean> c() {
        return f63479c;
    }

    public static MutableLiveData<Boolean> d() {
        return f63478b;
    }

    public static String e() {
        return AECameraPrefsUtil.f().j(AECameraConstants.SP_KEY_AE_CAMERA_TAB_EXPERIMENT_IDS, "", 4);
    }

    public static String a(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(AECameraConstants.CAMERA_STORY_DEFAULT_JSON);
            String h16 = k.h(inputStream);
            if (inputStream == null) {
                return h16;
            }
            try {
                inputStream.close();
                return h16;
            } catch (IOException e16) {
                e16.printStackTrace();
                return h16;
            }
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                return "";
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }
}
