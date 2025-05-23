package com.tencent.mobileqq.setting.main.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.main.processor.PhoneNumItemProcessor;
import com.tencent.mobileqq.setting.utils.o;
import com.tencent.mobileqq.widget.listitem.g;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/setting/main/account/c;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends com.tencent.mobileqq.setting.processor.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, 7);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(c this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity e16 = this$0.e();
        if (e16 != null) {
            Intent intent = new Intent();
            com.tencent.mobileqq.setting.processor.c h16 = this$0.h(11);
            PhoneNumItemProcessor phoneNumItemProcessor = h16 instanceof PhoneNumItemProcessor ? (PhoneNumItemProcessor) h16 : null;
            boolean isPhoneVerified = true ^ (phoneNumItemProcessor != null ? phoneNumItemProcessor.getIsPhoneVerified() : true);
            intent.putExtra("bind_phone_data", phoneNumItemProcessor != null ? phoneNumItemProcessor.d() : null);
            intent.putExtra("has_unverified_phone", isPhoneVerified);
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(e16, intent, 2003);
        }
        o oVar = o.f286768a;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        o.g(oVar, view, "em_bas_more_security_settings", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        o.f286768a.h(view, "em_bas_more_security_settings", null);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        String string = BaseApplication.getContext().getString(R.string.f2039351j);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026fe_more_security_setting)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_safety), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.account.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.x(c.this, view);
            }
        });
        xVar.w(new g() { // from class: com.tencent.mobileqq.setting.main.account.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                c.y(view);
            }
        });
        return xVar;
    }
}
