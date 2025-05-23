package mq2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lmq2/e;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends jq2.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"mq2/e$a", "Lcom/tencent/mobileqq/app/cx;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "c", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends cx {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f417192d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f417193e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f417194f;

        a(Dialog dialog, Intent intent, Context context) {
            this.f417192d = dialog;
            this.f417193e = intent;
            this.f417194f = context;
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void c(boolean isSuccess, Bundle data) {
            this.f417192d.dismiss();
            if (!isSuccess) {
                QQToast.makeText(BaseApplication.getContext(), R.string.f173742tz, 0).show();
            } else {
                this.f417193e.putExtra("bind_phone_data", data);
                ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this.f417194f, this.f417193e, -1);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (qQAppInterface != null) {
                qQAppInterface.removeObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PhoneUnityManager phoneUnityManager, Dialog dialog, Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(context, "$context");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(new a(dialog, intent, context));
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        SecSvcHandler secSvcHandler = (SecSvcHandler) (appInterface != null ? appInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER) : null);
        if (phoneUnityManager != null) {
            phoneUnityManager.G = System.currentTimeMillis();
        }
        if (phoneUnityManager != null) {
            phoneUnityManager.f181279d = false;
        }
        if (secSvcHandler != null) {
            secSvcHandler.G2(2);
        }
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        String string = BaseApplication.context.getString(R.string.f2039351j);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026fe_more_security_setting)");
        return string;
    }

    @Override // jq2.c
    public void f(String title, final Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        final Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        final PhoneUnityManager phoneUnityManager = (PhoneUnityManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        Bundle bundle = phoneUnityManager != null ? phoneUnityManager.D : null;
        if (bundle != null) {
            intent.putExtra("bind_phone_data", bundle);
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(context, intent, -1);
            return;
        }
        final Dialog showLoadingDialog = DialogUtil.showLoadingDialog(QBaseActivity.sTopActivity, "\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019\u2026", false);
        try {
            showLoadingDialog.show();
        } catch (Exception e16) {
            QLog.e("MoreSecuritySettingNode", 1, "show dialog error: " + e16);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: mq2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(PhoneUnityManager.this, showLoadingDialog, intent, context);
            }
        }, 128, null, true);
    }

    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new oq2.b(), new oq2.a(), new oq2.c());
        return arrayListOf;
    }
}
