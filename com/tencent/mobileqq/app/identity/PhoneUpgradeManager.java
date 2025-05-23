package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.PhoneUpgradeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;
import tencent.im.trpc.TrpcMbm$ErrorInfo;
import tencent.im.trpc.TrpcMbm$MbManagementResponse;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u00010,8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/app/identity/PhoneUpgradeManager;", "Lcom/tencent/mobileqq/app/identity/a;", "", "r", "", "v", "isSuccess", "Ltencent/im/oidb/cmd0x9ae/cmd0x9ae$RspBody;", "rspBody", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "o", HippyTKDListViewAdapter.X, "", "text", "highlight", "Landroid/text/Spannable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "token", ReportConstant.COSTREPORT_PREFIX, "url", "l", DomainData.DOMAIN_NAME, "t", BdhLogUtil.LogTag.Tag_Conn, "onPreloadEveryLogin", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityDestroy", "release", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "requesting", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "b", "Lmqq/util/WeakReference;", "upgradeDialogRef", "Landroid/content/BroadcastReceiver;", "c", "Landroid/content/BroadcastReceiver;", "bindFinishReceiver", "Lcom/tencent/common/app/AppInterface;", "p", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "d", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhoneUpgradeManager extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean requesting;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Dialog> upgradeDialogRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BroadcastReceiver bindFinishReceiver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/identity/PhoneUpgradeManager$a;", "", "", "KEY_JWT_PHONE_UPGRADE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.identity.PhoneUpgradeManager$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/app/identity/PhoneUpgradeManager$b", "Lcom/tencent/mobileqq/app/identity/i;", "", "isSuccess", "", "a", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.identity.i
        public void a(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
                return;
            }
            QLog.i("PhoneUpgradeManager", 1, "onCancelPhoneUpgrade isSuccess:" + isSuccess);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/app/identity/PhoneUpgradeManager$c", "Lcom/tencent/mobileqq/app/identity/i;", "", "isSuccess", "Ltencent/im/trpc/TrpcMbm$MbManagementResponse;", "rsp", "", "b", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUpgradeManager.this);
            }
        }

        @Override // com.tencent.mobileqq.app.identity.i
        public void b(boolean isSuccess, @Nullable TrpcMbm$MbManagementResponse rsp) {
            Integer num;
            TrpcMbm$ErrorInfo trpcMbm$ErrorInfo;
            PBStringField pBStringField;
            TrpcMbm$ErrorInfo trpcMbm$ErrorInfo2;
            PBUInt32Field pBUInt32Field;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), rsp);
                return;
            }
            String str = null;
            if (rsp != null && (trpcMbm$ErrorInfo2 = rsp.error_info) != null && (pBUInt32Field = trpcMbm$ErrorInfo2.err_code) != null) {
                num = Integer.valueOf(pBUInt32Field.get());
            } else {
                num = null;
            }
            if (rsp != null && (trpcMbm$ErrorInfo = rsp.error_info) != null && (pBStringField = trpcMbm$ErrorInfo.err_msg) != null) {
                str = pBStringField.get();
            }
            QLog.i("PhoneUpgradeManager", 1, "onQuickPhoneUpgrade isSuccess=" + isSuccess + " errCode=" + num + " errMsg=" + str);
            if (isSuccess && num != null && num.intValue() == 0) {
                ReportController.y(PhoneUpgradeManager.this.p(), "0X800C536");
                QQToast.makeText(BaseApplication.getContext(), R.string.f174082uw, 0).show();
                PhoneUpgradeManager.this.o();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f174072uv, 0).show();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/app/identity/PhoneUpgradeManager$d", "Lcom/tencent/mobileqq/app/identity/i;", "", "isSuccess", "Ltencent/im/oidb/cmd0x9ae/cmd0x9ae$RspBody;", "rsp", "", "c", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends i {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUpgradeManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(PhoneUpgradeManager this$0, boolean z16, cmd0x9ae$RspBody cmd0x9ae_rspbody) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q(z16, cmd0x9ae_rspbody);
        }

        @Override // com.tencent.mobileqq.app.identity.i
        public void c(final boolean isSuccess, @Nullable final cmd0x9ae$RspBody rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), rsp);
                return;
            }
            QLog.i("PhoneUpgradeManager", 1, "onReqPhoneUpgrade isSuccess=" + isSuccess + " rsp=" + rsp);
            PhoneUpgradeManager.this.requesting.set(false);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final PhoneUpgradeManager phoneUpgradeManager = PhoneUpgradeManager.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.app.identity.q
                @Override // java.lang.Runnable
                public final void run() {
                    PhoneUpgradeManager.d.e(PhoneUpgradeManager.this, isSuccess, rsp);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhoneUpgradeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.requesting = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(PhoneUpgradeManager this$0, String str, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(PhoneUpgradeManager this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        if (this.bindFinishReceiver != null) {
            try {
                QLog.i("PhoneUpgradeManager", 1, "unregisterBindFinishReceiver");
                BaseApplication.getContext().unregisterReceiver(this.bindFinishReceiver);
            } catch (Exception e16) {
                QLog.e("PhoneUpgradeManager", 1, "unregisterReceiver error:", e16);
            }
            this.bindFinishReceiver = null;
        }
    }

    private final void l(String url) {
        boolean z16;
        QLog.i("PhoneUpgradeManager", 1, "bind other phone");
        ReportController.y(p(), "0X800C534");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("PhoneUpgradeManager", 1, "jump web url is null");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        QRoute.createNavigator(qBaseActivity, RouterConstants.UI_ROUTE_BROWSER).withString("url", url).request();
        t();
    }

    private final Spannable m(String text, String highlight) {
        boolean z16;
        int indexOf$default;
        boolean z17 = false;
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new SpannableString("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        if (highlight == null || highlight.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) text, highlight, 0, false, 6, (Object) null);
            if (indexOf$default < 0) {
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(BaseApplication.getContext().getColor(R.color.qui_common_text_link)), indexOf$default, highlight.length() + indexOf$default, 33);
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    private final void n(byte[] token) {
        BusinessHandler businessHandler;
        QLog.i("PhoneUpgradeManager", 1, "cancel upgrade");
        ReportController.y(p(), "0X800C535");
        if (token == null) {
            QLog.e("PhoneUpgradeManager", 1, "cancel upgrade token is null");
            return;
        }
        AppInterface p16 = p();
        PhoneBusinessHandler phoneBusinessHandler = null;
        if (p16 != null) {
            businessHandler = p16.getBusinessHandler(PhoneBusinessHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof PhoneBusinessHandler) {
            phoneBusinessHandler = (PhoneBusinessHandler) businessHandler;
        }
        if (phoneBusinessHandler == null) {
            return;
        }
        phoneBusinessHandler.D2(token, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.upgradeDialogRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null && dialog.isShowing()) {
            QLog.i("PhoneUpgradeManager", 1, "dismiss dialog");
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInterface p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(boolean isSuccess, cmd0x9ae$RspBody rspBody) {
        boolean z16;
        Dialog dialog;
        if (isSuccess && rspBody != null) {
            w(rspBody);
            if (rspBody.uint32_scene.get() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("PhoneUpgradeManager", 1, "do not need show upgrade dialog");
                o();
                return;
            }
            WeakReference<Dialog> weakReference = this.upgradeDialogRef;
            if (weakReference != null) {
                dialog = weakReference.get();
            } else {
                dialog = null;
            }
            if (dialog != null && dialog.isShowing()) {
                return;
            }
            QLog.i("PhoneUpgradeManager", 1, "show upgrade dialog");
            x(rspBody);
            return;
        }
        o();
    }

    private final boolean r() {
        String str;
        AppInterface p16 = p();
        if (p16 != null) {
            str = p16.getCurrentAccountUin();
        } else {
            str = null;
        }
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("phone_upgrade_jwt_" + str, null);
        if (decodeString == null || decodeString.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return !g.c(decodeString, NetConnInfoCenter.getServerTime());
    }

    private final void s(byte[] token) {
        BusinessHandler businessHandler;
        QLog.i("PhoneUpgradeManager", 1, "quick upgrade");
        ReportController.y(p(), "0X800C533");
        if (token == null) {
            QLog.e("PhoneUpgradeManager", 1, "quick upgrade token is null");
            return;
        }
        AppInterface p16 = p();
        PhoneBusinessHandler phoneBusinessHandler = null;
        if (p16 != null) {
            businessHandler = p16.getBusinessHandler(PhoneBusinessHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof PhoneBusinessHandler) {
            phoneBusinessHandler = (PhoneBusinessHandler) businessHandler;
        }
        if (phoneBusinessHandler == null) {
            return;
        }
        phoneBusinessHandler.K2(token, new c());
    }

    private final void t() {
        if (this.bindFinishReceiver == null) {
            this.bindFinishReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.app.identity.PhoneUpgradeManager$registerBindFinishReceiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUpgradeManager.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    QLog.i("PhoneUpgradeManager", 1, "onReceive");
                    PhoneUpgradeManager.this.C();
                    PhoneUpgradeManager.this.v();
                }
            };
            try {
                BaseApplication.getContext().registerReceiver(this.bindFinishReceiver, new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify"));
            } catch (Exception e16) {
                QLog.e("PhoneUpgradeManager", 1, "registerReceiver error:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(PhoneUpgradeManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        BusinessHandler businessHandler;
        QLog.i("PhoneUpgradeManager", 1, "requestPhoneUpgradeInfo");
        if (this.requesting.getAndSet(true)) {
            QLog.i("PhoneUpgradeManager", 1, "requesting now");
            return;
        }
        AppInterface p16 = p();
        PhoneBusinessHandler phoneBusinessHandler = null;
        if (p16 != null) {
            businessHandler = p16.getBusinessHandler(PhoneBusinessHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof PhoneBusinessHandler) {
            phoneBusinessHandler = (PhoneBusinessHandler) businessHandler;
        }
        if (phoneBusinessHandler == null) {
            return;
        }
        phoneBusinessHandler.G2(new d());
    }

    private final void w(cmd0x9ae$RspBody rspBody) {
        boolean z16;
        String str;
        String h16 = g.h(rspBody.bytes_jwt.get().toStringUtf8());
        if (h16 != null && h16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("PhoneUpgradeManager", 1, "jwt payload is null");
            return;
        }
        QLog.i("PhoneUpgradeManager", 1, "save jwt " + h16);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        AppInterface p16 = p();
        if (p16 != null) {
            str = p16.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        from.encodeString("phone_upgrade_jwt_" + str, h16);
    }

    private final void x(cmd0x9ae$RspBody rspBody) {
        final byte[] byteArray = rspBody.bytes_token.get().toByteArray();
        String str = rspBody.msg_auth_tips.string_tips_title.get();
        String str2 = rspBody.msg_auth_tips.string_tips_context.get();
        String str3 = rspBody.msg_auth_tips.string_tbutton.get();
        String str4 = rspBody.msg_auth_tips.string_mbutton.get();
        String str5 = rspBody.msg_auth_tips.string_bbutton.get();
        String str6 = rspBody.msg_auth_tips.string_mask_phone.get();
        final String str7 = rspBody.msg_auth_tips.string_tips_action_url.get();
        Spannable m3 = m(str2, str6);
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(qBaseActivity, 0, str, m3, str3, str4, str5, null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.identity.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PhoneUpgradeManager.y(PhoneUpgradeManager.this, byteArray, dialogInterface, i3);
                }
            });
            createVerticalThreeBtnDialog.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.identity.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PhoneUpgradeManager.z(PhoneUpgradeManager.this, byteArray, dialogInterface, i3);
                }
            }, false);
            createVerticalThreeBtnDialog.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.identity.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PhoneUpgradeManager.A(PhoneUpgradeManager.this, str7, dialogInterface, i3);
                }
            }, false);
            createVerticalThreeBtnDialog.setCancelable(false);
            createVerticalThreeBtnDialog.setCanceledOnTouchOutside(false);
            createVerticalThreeBtnDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.app.identity.p
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PhoneUpgradeManager.B(PhoneUpgradeManager.this, dialogInterface);
                }
            });
            this.upgradeDialogRef = new WeakReference<>(createVerticalThreeBtnDialog);
            createVerticalThreeBtnDialog.show();
            ReportController.y(p(), "0X800C532");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(PhoneUpgradeManager this$0, byte[] bArr, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n(bArr);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(PhoneUpgradeManager this$0, byte[] bArr, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(bArr);
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onActivityDestroy(@Nullable Activity activity) {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onActivityDestroy(activity);
        WeakReference<Dialog> weakReference = this.upgradeDialogRef;
        if (weakReference != null && (dialog = weakReference.get()) != null && g.a(dialog, activity)) {
            o();
            C();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onPreloadEveryLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onPreloadEveryLogin();
        QLog.i("PhoneUpgradeManager", 1, "onPreloadEveryLogin");
        if (!r()) {
            return;
        }
        v();
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.release();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.identity.l
                @Override // java.lang.Runnable
                public final void run() {
                    PhoneUpgradeManager.u(PhoneUpgradeManager.this);
                }
            });
        }
    }
}
