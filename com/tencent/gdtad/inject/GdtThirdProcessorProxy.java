package com.tencent.gdtad.inject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.impl.b;
import com.tencent.gdtad.params.GetUserInfoCallback;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.gdt.qq_ad_get;

/* loaded from: classes6.dex */
public class GdtThirdProcessorProxy implements IGdtThirdProcessor {
    public static final String TAG = "GdtThirdProcessorProxy";

    @NonNull
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAdApi/Inject_AdInject.yml", version = 1)
    public static ArrayList<Class<? extends IGdtThirdProcessor>> gdtThirdProcessorClasses;

    @Nullable
    public IGdtThirdProcessor processor = null;

    static {
        ArrayList<Class<? extends IGdtThirdProcessor>> arrayList = new ArrayList<>();
        gdtThirdProcessorClasses = arrayList;
        arrayList.add(b.class);
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void addReadInJoyCb(Intent intent, String str) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            iGdtThirdProcessor.addReadInJoyCb(intent, str);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void c2sReportAsync(int i3, int i16, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            iGdtThirdProcessor.c2sReportAsync(i3, i16, adInfo);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Deprecated
    public void doCallbackBeforeFinish(GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, long j16, boolean z16) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            iGdtThirdProcessor.doCallbackBeforeFinish(gdtMotiveVideoPageData, j3, j16, z16);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Nullable
    public Drawable gdtADBoxItemDrawable(Context context, String str) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            return iGdtThirdProcessor.gdtADBoxItemDrawable(context, str);
        }
        return null;
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void gdtGetCurrentUserInfo(GetUserInfoCallback getUserInfoCallback) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            iGdtThirdProcessor.gdtGetCurrentUserInfo(getUserInfoCallback);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Nullable
    public Drawable gdtMvIcon(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, int i16) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            return iGdtThirdProcessor.gdtMvIcon(context, gdtMotiveVideoPageData, i3, i16);
        }
        return null;
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Nullable
    public Drawable getPreViewImage(Context context, String str) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            return iGdtThirdProcessor.getPreViewImage(context, str);
        }
        return null;
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Nullable
    public String getProductId(Context context) {
        initProcessor();
        IGdtThirdProcessor iGdtThirdProcessor = this.processor;
        if (iGdtThirdProcessor != null) {
            return iGdtThirdProcessor.getProductId(context);
        }
        return null;
    }

    public synchronized void initProcessor() {
        if (this.processor == null) {
            ArrayList<Class<? extends IGdtThirdProcessor>> arrayList = gdtThirdProcessorClasses;
            if (arrayList != null && !arrayList.isEmpty()) {
                try {
                    this.processor = gdtThirdProcessorClasses.get(0).newInstance();
                } catch (Exception e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
                QLog.i(TAG, 1, "initProcessor size = " + gdtThirdProcessorClasses.size());
            } else {
                QLog.i(TAG, 1, "initProcessor is empty ");
            }
        }
    }
}
