package com.tencent.mobileqq.ar.ARRenderModel;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l extends e {

    /* renamed from: i, reason: collision with root package name */
    public String f197287i;

    /* renamed from: j, reason: collision with root package name */
    public String f197288j;

    public l(String str, int i3, int i16, int i17, float f16, float f17, float f18, String str2, String str3) {
        super(str, i3, i16, i17, f16, f17, f18);
        if (!TextUtils.isEmpty(str2)) {
            String[] split = str2.split("\\|");
            if (split.length > 0) {
                this.f197287i = split[0];
            }
        }
        this.f197288j = str3;
        QLog.d("GreetingCardResourceInfo", 2, String.format("GreetingCardResourceInfo mLuaScriptPath=%s mResourceDirPath=%s", this.f197287i, str3));
    }
}
