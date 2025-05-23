package com.tencent.mobileqq.profilecard.template;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface ITemplateUtils {
    Drawable getTemplateDrawable(ProfileCardTemplate profileCardTemplate, boolean z16, boolean z17, String str);

    boolean initTemplateConfig(ProfileCardTemplate profileCardTemplate, long j3, long j16);

    @SuppressLint({"NewApi"})
    void updateViewAttr(View view, String str, ProfileCardTemplate profileCardTemplate, String str2);
}
