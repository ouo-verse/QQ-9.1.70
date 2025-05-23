package com.tencent.mobileqq.matchfriend.reborn.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.matchfriend.reborn.QQStrangerFragment;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerMainActivity;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.api.a;
import com.tencent.mobileqq.matchfriend.reborn.config.c;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishGuideHelper;
import com.tencent.mobileqq.matchfriend.reborn.register.fragment.QQStrangerRegisterProfileFragment;
import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerFeedPublishGuideHelper;
import com.tencent.mobileqq.matchfriend.reborn.utils.h;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerEntryApiImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerEntryApi;", "Landroid/content/Context;", "context", "", "sourceType", "subSourceType", "", "enterHomePage", "tabId", "", "forwardUri", "Lcom/tencent/mobileqq/matchfriend/reborn/api/a;", "param", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "startRegisterForResult", "enterLiteActionListPage", "launchFeedPublish", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerEntryApiImpl implements IQQStrangerEntryApi {
    public static final String QQSTRANGER_FORWARD_URI_FROM_HOME = "forward_uri";
    private static final String TAG = "QQStrangerEntryApiImpl";

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void enterHomePage(Context context, int sourceType, int subSourceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        enterHomePage(context, new a(sourceType, subSourceType, 0, null, 0, false, 60, null));
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void enterLiteActionListPage(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QQStrangerPublicFragmentActivity.INSTANCE.a(context, intent, QQStrangerLiteActionFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void launchFeedPublish(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.mobileqq.matchfriend.reborn.publish.a.f245245a.a(context, intent);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void startRegisterForResult(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QQStrangerPublicFragmentActivity.INSTANCE.b(activity, intent, QQStrangerRegisterProfileFragment.class, 1000);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void enterHomePage(Context context, int sourceType, int subSourceType, int tabId) {
        Intrinsics.checkNotNullParameter(context, "context");
        enterHomePage(context, new a(sourceType, subSourceType, tabId, null, 0, false, 56, null));
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void enterHomePage(Context context, int sourceType, int subSourceType, String forwardUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(forwardUri, "forwardUri");
        enterHomePage(context, new a(sourceType, subSourceType, 0, forwardUri, 0, false, 52, null));
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi
    public void enterHomePage(final Context context, final a param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        h.m();
        c.f244198a.d(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.api.impl.QQStrangerEntryApiImpl$enterHomePage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    v72.c.h("first_page_screen");
                    v72.c.a("first_page_screen");
                    com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.c.f244287a.c();
                    QQStrangerFeedPublishGuideHelper.f245463a.g();
                    QQStrangerSignalPublishGuideHelper.INSTANCE.a();
                    c.g();
                    Intent intent = new Intent();
                    intent.putExtra("from_intent_key", a.this.d());
                    intent.putExtra("scheme_from_intent_key", a.this.e());
                    intent.putExtra(QQStrangerEntryApiImpl.QQSTRANGER_FORWARD_URI_FROM_HOME, a.this.c());
                    if (a.this.f() >= 0) {
                        intent.putExtra("key_tab_id", a.this.f());
                    }
                    intent.putExtra("key_action_type", a.this.a());
                    intent.putExtra("key_forbidden_guest", a.this.b());
                    intent.setFlags(603979776);
                    QQStrangerMainActivity.INSTANCE.a(context, intent, QQStrangerFragment.class);
                    return;
                }
                QQToastUtil.showQQToastInUiThread(0, "\u8bf7\u7a0d\u540e\u8fdb\u5165");
            }
        });
    }
}
