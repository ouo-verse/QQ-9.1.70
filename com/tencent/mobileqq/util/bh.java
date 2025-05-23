package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.utils.ActivityResultHelper;
import com.tencent.mobileqq.pb.oidb_0xeb2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.servlet.PhoneBindAccountHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.bh;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010%\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/util/bh;", "", "Landroid/content/Context;", "context", "", "phoneNum", "countryCode", "", "requestCode", "Landroid/os/Bundle;", "bundle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", PreloadTRTCPlayerParams.KEY_SIG, "j", "Lcom/tencent/mobileqq/pb/oidb_0xeb2$RspBody;", "data", "p", "str", "", "i", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", tl.h.F, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "code", "message", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "phone", DomainData.DOMAIN_NAME, "uin", "k", "r", "b", "I", "mRequestCode", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bh f306610a = new bh();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mRequestCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/bh$a", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements PhoneBindAccountHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f306612a;

        a(Context context) {
            this.f306612a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(oidb_0xeb2.RspBody rspBody, Context context) {
            Intrinsics.checkNotNullParameter(context, "$context");
            bh.f306610a.p(rspBody, context);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            QLog.i("PhoneBindAccountManager", 1, "getPhoneBindAccountInfo  errorCode = " + errorCode);
            bh.f306610a.m((QBaseActivity) this.f306612a, errorCode, errorMsg);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onSuccess(@NotNull Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            final oidb_0xeb2.RspBody rspBody = (oidb_0xeb2.RspBody) data;
            final Context context = this.f306612a;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.util.bg
                @Override // java.lang.Runnable
                public final void run() {
                    bh.a.b(oidb_0xeb2.RspBody.this, context);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/bh$b", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements PhoneBindAccountHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f306613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f306614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f306615c;

        b(Context context, String str, String str2) {
            this.f306613a = context;
            this.f306614b = str;
            this.f306615c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Context context, String phoneNum, String str) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(phoneNum, "$phoneNum");
            bh.f306610a.s(context, phoneNum, str);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            QLog.i("PhoneBindAccountManager", 1, "getSmsCode  errorCode = " + errorCode);
            bh.f306610a.m((QBaseActivity) this.f306613a, errorCode, errorMsg);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onSuccess(@NotNull Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            final Context context = this.f306613a;
            final String str = this.f306614b;
            final String str2 = this.f306615c;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.util.bi
                @Override // java.lang.Runnable
                public final void run() {
                    bh.b.b(context, str, str2);
                }
            });
        }
    }

    bh() {
    }

    private final List<AccountInfo> h(oidb_0xeb2.RspBody data) {
        List<oidb_0xeb2.UinInfo> list = data.msg_uin_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "data.msg_uin_info.get()");
        ArrayList arrayList = new ArrayList();
        for (oidb_0xeb2.UinInfo uinInfo : list) {
            arrayList.add(new AccountInfo(uinInfo.str_nick.get(), uinInfo.str_mask_uin.get(), uinInfo.bytes_encrypt_uin.get().toByteArray(), uinInfo.str_image_url.get(), "", null));
        }
        return arrayList;
    }

    private final CharSequence i(String str, Context context) {
        Matcher matcher = Pattern.compile("\\+[ \\d*]+").matcher(str);
        if (!matcher.find()) {
            QLog.d("PhoneBindAccountManager", 1, "getColorSpan, no phone num");
            return str;
        }
        int start = matcher.start();
        int end = matcher.end();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.qui_common_feedback_warning)), start, end, 17);
        return spannableString;
    }

    private final void j(byte[] sig, Context context) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PhoneBindAccountHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.PhoneBindAccountHandler");
        ((PhoneBindAccountHandler) businessHandler).D2(sig, new a(context));
    }

    @JvmStatic
    @NotNull
    public static final String k(@Nullable String uin) {
        if (TextUtils.isEmpty(uin)) {
            QLog.w("PhoneBindAccountManager", 1, "getPhoneFromMMKV uin is null");
            return "";
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("qq_login" + uin + "key_bind_phone", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(\"${C\u2026uin}$KEY_BIND_PHONE\", \"\")");
        return decodeString;
    }

    private final boolean l(QBaseActivity activity) {
        if (activity != null && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(QBaseActivity activity, int code, String message) {
        if (l(activity)) {
            QLog.e("PhoneBindAccountManager", 1, "onFailedResponse, but context is invalid");
            return;
        }
        if (code == -1) {
            message = null;
        }
        if (TextUtils.isEmpty(message)) {
            Intrinsics.checkNotNull(activity);
            message = activity.getString(R.string.g0j);
        }
        QQToast.makeText(activity, 1, message, 0).show();
    }

    @JvmStatic
    public static final void n(@Nullable final String phone) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.bd
            @Override // java.lang.Runnable
            public final void run() {
                bh.o(phone);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str) {
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            QLog.w("PhoneBindAccountManager", 1, "setPhoneToMMKV uin is null");
            return;
        }
        String k3 = k(currentAccountUin);
        if (Intrinsics.areEqual(k3, str)) {
            return;
        }
        com.tencent.mobileqq.login.account.d.o(currentAccountUin, "+86 " + k3);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("qq_login" + currentAccountUin + "key_bind_phone", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(oidb_0xeb2.RspBody data, Context context) {
        LoginReportConstants.f241792b = 3;
        LoginReportConstants.f241793c = "5";
        HashMap hashMap = new HashMap();
        String str = data.str_title.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.str_title.get()");
        hashMap.put("key_dialog_title", str);
        String str2 = data.str_subtitle.get();
        Intrinsics.checkNotNullExpressionValue(str2, "data.str_subtitle.get()");
        hashMap.put("key_dialog_msg", i(str2, context));
        hashMap.put("key_unbind_account_list", h(data));
        String str3 = data.str_unbind_url.get();
        Intrinsics.checkNotNullExpressionValue(str3, "data.str_unbind_url.get()");
        hashMap.put("key_unbind_account_tip", str3);
        hashMap.put("key_unbind_account_show_login_btn", Boolean.FALSE);
        com.tencent.mobileqq.widget.bm c16 = ck.f306664a.c(context, hashMap, null, null);
        if (c16 != null) {
            c16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Context context, String phoneNum, String countryCode, int requestCode, Bundle bundle) {
        mRequestCode = requestCode;
        if (System.currentTimeMillis() - com.tencent.mobileqq.loginregister.y.f243060b >= 60000) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PhoneBindAccountHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.PhoneBindAccountHandler");
            ((PhoneBindAccountHandler) businessHandler).E2(bundle, new b(context, phoneNum, countryCode));
            return;
        }
        s(context, phoneNum, countryCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final Context context, final String phoneNum, final String countryCode) {
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity != null) {
            new ActivityResultHelper(fragmentActivity).b(new ActivityResultHelper.c() { // from class: com.tencent.mobileqq.util.be
                @Override // com.tencent.mobileqq.loginregister.utils.ActivityResultHelper.c
                public final void a(ActivityResultHelper.ForResultFragment forResultFragment) {
                    bh.t(context, phoneNum, countryCode, forResultFragment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final Context context, String phoneNum, String str, ActivityResultHelper.ForResultFragment fragment) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(phoneNum, "$phoneNum");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        fragment.qh(mRequestCode, new ActivityResultHelper.b() { // from class: com.tencent.mobileqq.util.bf
            @Override // com.tencent.mobileqq.loginregister.utils.ActivityResultHelper.b
            public final void onActivityResult(int i3, int i16, Intent intent) {
                bh.u(context, i3, i16, intent);
            }
        });
        Navigator createNavigator = QRoute.createNavigator(context, "/base/login/authDevVerifyCode");
        Intrinsics.checkNotNullExpressionValue(createNavigator, "createNavigator(context,\u2026UTE_AUTH_DEV_VERIFY_CODE)");
        Navigator withString = Navigator.withRequestCode$default(createNavigator, fragment, mRequestCode, (Bundle) null, 4, (Object) null).withString(MQPSecJsPlugin.KEY_FROM, "from_phone_bind_account_manager").withString(AuthDevOpenUgActivity.KEY_PHONE_NUM, phoneNum);
        if (str == null) {
            str = "";
        }
        withString.withString("country_code", str).request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Context context, int i3, int i16, Intent intent) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i("PhoneBindAccountManager", 2, "onActivityResult  requestCode1 = " + i3 + ", resultCode = " + i16);
        if (i16 == -1 && i3 == mRequestCode) {
            if (intent != null) {
                bArr = intent.getByteArrayExtra(PreloadTRTCPlayerParams.KEY_SIG);
            } else {
                bArr = null;
            }
            if (bArr != null) {
                f306610a.j(bArr, context);
            }
            ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), LoginReportConstants.f241794d);
        }
    }

    public final void r(@NotNull Context context, @NotNull String phoneNum, @Nullable String countryCode, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneNum, "phoneNum");
        new PuzzleVerifyComponent().d(4, "https://ti.qq.com/safe/tools/captcha/sms-verify-login", new c(context, phoneNum, countryCode, requestCode));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/bh$c", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements PuzzleVerifyComponent.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f306616a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f306617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f306618c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f306619d;

        c(Context context, String str, String str2, int i3) {
            this.f306616a = context;
            this.f306617b = str;
            this.f306618c = str2;
            this.f306619d = i3;
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
            Bundle bundle = new Bundle();
            bundle.putString("ticket", ticket);
            bundle.putString("rand_str", randStr);
            bh.f306610a.q(this.f306616a, this.f306617b, this.f306618c, this.f306619d, bundle);
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
        }
    }
}
