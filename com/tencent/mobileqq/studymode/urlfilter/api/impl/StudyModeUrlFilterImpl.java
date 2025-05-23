package com.tencent.mobileqq.studymode.urlfilter.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.urlfilter.StudyModeUrlFilterCheckMainFragment;
import com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter;
import hr2.a;
import hr2.d;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/studymode/urlfilter/api/impl/StudyModeUrlFilterImpl;", "Lcom/tencent/mobileqq/studymode/urlfilter/api/IStudyModeUrlFilter;", "()V", "initUrlFilterFlagFirstEnter", "", "openUrlFilterMainFragment", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registerStudyModeSetting", "registerThreadMessage", "urlFilterCheckedSupportOpen", "", "url", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class StudyModeUrlFilterImpl implements IStudyModeUrlFilter {
    @Override // com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter
    public void initUrlFilterFlagFirstEnter() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && StudyModeManager.f(96)) {
            KidModeServlet.w((QQAppInterface) peekAppRuntime, 80, 1);
        }
    }

    @Override // com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter
    public void openUrlFilterMainFragment(Context context, Intent intent) {
        QPublicFragmentActivity.start(context, intent, StudyModeUrlFilterCheckMainFragment.class);
    }

    @Override // com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter
    public void registerStudyModeSetting() {
        d.f406079a.k();
    }

    @Override // com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter
    public void registerThreadMessage() {
        a.b().register();
    }

    @Override // com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter
    public boolean urlFilterCheckedSupportOpen(String url) {
        return d.f406079a.r(url);
    }
}
