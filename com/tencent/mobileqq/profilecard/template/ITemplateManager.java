package com.tencent.mobileqq.profilecard.template;

import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface ITemplateManager {
    long getDiyTemplateVersion(@NotNull Card card);

    boolean preNotifyOnCardUpdate(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo);

    void updateViewAttrForTemplate(View view, String str, ProfileCardTemplate profileCardTemplate, String str2);
}
