package com.qwallet.authorize.verify;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$SendSMSReq;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0004J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010#\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001a\u0010(\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b'\u0010\"R\u001a\u0010-\u001a\u00020)8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00106\u001a\u00020\u00138\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b4\u0010\u0015\u001a\u0004\b5\u0010\u0017R\u001a\u0010<\u001a\u0002078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010>\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u00100\u001a\u0004\b=\u00102R$\u0010D\u001a\u0004\u0018\u00010?8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010@\u001a\u0004\b4\u0010A\"\u0004\bB\u0010CR\"\u0010J\u001a\u00020E8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010F\u001a\u0004\b$\u0010G\"\u0004\bH\u0010IR\"\u0010O\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010K\u001a\u0004\b8\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010K\u001a\u0004\b\u001f\u0010L\"\u0004\bP\u0010NR$\u0010S\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010K\u001a\u0004\b/\u0010L\"\u0004\bR\u0010N\u00a8\u0006X"}, d2 = {"Lcom/qwallet/authorize/verify/AuthorizeBaseVerifyVC;", "", "", "p", "", "smsType", "", "plainPhoneStr", "maskPhoneStr", BaseConstants.ATTR_KET_PHONE_TOKEN, "v", "b", ReportConstant.COSTREPORT_PREFIX, "t", "code", "u", "pnum", "", "r", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "f", "()Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "e", "()Landroid/widget/TextView;", "authorizeTitle", "d", "getAddPhoneBack", "addPhoneBack", "j", "phoneInputText", "Landroid/widget/EditText;", "Landroid/widget/EditText;", DomainData.DOMAIN_NAME, "()Landroid/widget/EditText;", "smsInputText", "Landroid/widget/Button;", "g", "Landroid/widget/Button;", "k", "()Landroid/widget/Button;", "resendSmsBtn", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "saveSwitchContainer", "Lcom/tencent/widget/Switch;", "i", "Lcom/tencent/widget/Switch;", "l", "()Lcom/tencent/widget/Switch;", "saveSwitch", "o", "verifyPhoneBtn", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "()Landroid/os/CountDownTimer;", "y", "(Landroid/os/CountDownTimer;)V", "mTimer", "", "J", "()J", "setAppId", "(J)V", "appId", "Ljava/lang/String;", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "openId", "setAccessToken", CommonConstant.KEY_ACCESS_TOKEN, HippyTKDListViewAdapter.X, "lastPhoneNum", "Landroid/os/Bundle;", "arguments", "<init>", "(Landroid/view/View;Landroid/os/Bundle;Lcom/tencent/mobileqq/base/QWalletBaseFragment;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public abstract class AuthorizeBaseVerifyVC {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletBaseFragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView authorizeTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView addPhoneBack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView phoneInputText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText smsInputText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Button resendSmsBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View saveSwitchContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Switch saveSwitch;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Button verifyPhoneBtn;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer mTimer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long appId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String openId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String accessToken;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lastPhoneNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qwallet/authorize/verify/AuthorizeBaseVerifyVC$b", "Lx05/b;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b extends x05.b {
        b() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            if (AuthorizeBaseVerifyVC.this.r(s16.toString())) {
                if (AuthorizeBaseVerifyVC.this.getMTimer() == null) {
                    AuthorizeBaseVerifyVC.this.getResendSmsBtn().setEnabled(true);
                    return;
                }
                return;
            }
            AuthorizeBaseVerifyVC.this.getResendSmsBtn().setEnabled(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qwallet/authorize/verify/AuthorizeBaseVerifyVC$c", "Lx05/b;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c extends x05.b {
        c() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(s16, "s");
            String obj = s16.toString();
            boolean z17 = true;
            int length = obj.length() - 1;
            int i16 = 0;
            boolean z18 = false;
            while (i16 <= length) {
                if (!z18) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z18) {
                    if (!z16) {
                        z18 = true;
                    } else {
                        i16++;
                    }
                } else if (!z16) {
                    break;
                } else {
                    length--;
                }
            }
            String obj2 = obj.subSequence(i16, length + 1).toString();
            Button verifyPhoneBtn = AuthorizeBaseVerifyVC.this.getVerifyPhoneBtn();
            if (obj2.length() <= 0) {
                z17 = false;
            }
            verifyPhoneBtn.setEnabled(z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/verify/AuthorizeBaseVerifyVC$d", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$SendSMSReq;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class d implements o<QWalletAuthorize$SendSMSReq> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qwallet/authorize/verify/AuthorizeBaseVerifyVC$d$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes3.dex */
        public static final class a extends CountDownTimer {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AuthorizeBaseVerifyVC f41464a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AuthorizeBaseVerifyVC authorizeBaseVerifyVC) {
                super(60000L, 1000L);
                this.f41464a = authorizeBaseVerifyVC;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                QLog.d(QPublicBaseFragment.TAG, 1, "time finished...");
                AuthorizeBaseVerifyVC authorizeBaseVerifyVC = this.f41464a;
                if (authorizeBaseVerifyVC.r(authorizeBaseVerifyVC.getPhoneInputText().getText().toString())) {
                    this.f41464a.getResendSmsBtn().setEnabled(true);
                    this.f41464a.getResendSmsBtn().setText("\u91cd\u65b0\u83b7\u53d6");
                } else {
                    this.f41464a.getResendSmsBtn().setEnabled(false);
                    this.f41464a.getResendSmsBtn().setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                QLog.d(QPublicBaseFragment.TAG, 1, "time: " + millisUntilFinished);
                this.f41464a.getResendSmsBtn().setEnabled(false);
                this.f41464a.getResendSmsBtn().setText("\u5df2\u53d1\u9001 (" + (millisUntilFinished / 1000) + ")");
            }
        }

        d() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$SendSMSReq rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            CountDownTimer mTimer = AuthorizeBaseVerifyVC.this.getMTimer();
            if (mTimer != null) {
                mTimer.cancel();
            }
            AuthorizeBaseVerifyVC.this.y(null);
            AuthorizeBaseVerifyVC authorizeBaseVerifyVC = AuthorizeBaseVerifyVC.this;
            a aVar = new a(AuthorizeBaseVerifyVC.this);
            aVar.start();
            authorizeBaseVerifyVC.y(aVar);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d(QPublicBaseFragment.TAG, 1, "requestSendSms onFail errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    public AuthorizeBaseVerifyVC(@NotNull View view, @Nullable Bundle bundle, @NotNull QWalletBaseFragment fragment) {
        long j3;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.view = view;
        this.fragment = fragment;
        View findViewById = view.findViewById(R.id.szj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorize_title)");
        this.authorizeTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.syw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.authorize_add_phone_back)");
        this.addPhoneBack = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.sz6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.authorize_input_phone)");
        this.phoneInputText = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.sz7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.authorize_input_sms)");
        this.smsInputText = (EditText) findViewById4;
        View findViewById5 = view.findViewById(R.id.sze);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.authorize_resend_sms_btn)");
        this.resendSmsBtn = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.szc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.a\u2026ne_save_switch_container)");
        this.saveSwitchContainer = findViewById6;
        View findViewById7 = view.findViewById(R.id.szb);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.a\u2026horize_phone_save_switch)");
        this.saveSwitch = (Switch) findViewById7;
        View findViewById8 = view.findViewById(R.id.szm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.authorize_verify_phone_btn)");
        this.verifyPhoneBtn = (Button) findViewById8;
        if (bundle != null) {
            j3 = bundle.getLong("extra_key_authorize_appid");
        } else {
            j3 = 0;
        }
        this.appId = j3;
        String str = "";
        this.openId = (bundle == null || (string2 = bundle.getString("extra_key_authorize_openid")) == null) ? "" : string2;
        if (bundle != null && (string = bundle.getString("extra_key_authorize_access_token")) != null) {
            str = string;
        }
        this.accessToken = str;
        p();
    }

    private final void p() {
        this.addPhoneBack.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.verify.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizeBaseVerifyVC.q(AuthorizeBaseVerifyVC.this, view);
            }
        });
        k.d(this.resendSmsBtn, 0L, new Function0<Unit>() { // from class: com.qwallet.authorize.verify.AuthorizeBaseVerifyVC$initHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AuthorizeBaseVerifyVC.this.t();
            }
        }, 1, null);
        k.d(this.verifyPhoneBtn, 0L, new Function0<Unit>() { // from class: com.qwallet.authorize.verify.AuthorizeBaseVerifyVC$initHandle$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String obj = AuthorizeBaseVerifyVC.this.getSmsInputText().getText().toString();
                int length = obj.length() - 1;
                int i3 = 0;
                boolean z16 = false;
                while (i3 <= length) {
                    boolean z17 = Intrinsics.compare((int) obj.charAt(!z16 ? i3 : length), 32) <= 0;
                    if (z16) {
                        if (!z17) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z17) {
                        i3++;
                    } else {
                        z16 = true;
                    }
                }
                AuthorizeBaseVerifyVC.this.u(obj.subSequence(i3, length + 1).toString());
            }
        }, 1, null);
        this.phoneInputText.addTextChangedListener(new b());
        this.smsInputText.addTextChangedListener(new c());
        this.phoneInputText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AuthorizeBaseVerifyVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void w(AuthorizeBaseVerifyVC authorizeBaseVerifyVC, int i3, String str, String str2, String str3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                str = null;
            }
            if ((i16 & 4) != 0) {
                str2 = null;
            }
            if ((i16 & 8) != 0) {
                str3 = null;
            }
            authorizeBaseVerifyVC.v(i3, str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestSendSms");
    }

    public final void b() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: from getter */
    public final long getAppId() {
        return this.appId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: e, reason: from getter */
    public final TextView getAuthorizeTitle() {
        return this.authorizeTitle;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final QWalletBaseFragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getLastPhoneNum() {
        return this.lastPhoneNum;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    protected final CountDownTimer getMTimer() {
        return this.mTimer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: j, reason: from getter */
    public final TextView getPhoneInputText() {
        return this.phoneInputText;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    protected final Button getResendSmsBtn() {
        return this.resendSmsBtn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: l, reason: from getter */
    public final Switch getSaveSwitch() {
        return this.saveSwitch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: m, reason: from getter */
    public final View getSaveSwitchContainer() {
        return this.saveSwitchContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: n, reason: from getter */
    public final EditText getSmsInputText() {
        return this.smsInputText;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    protected final Button getVerifyPhoneBtn() {
        return this.verifyPhoneBtn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r(@NotNull String pnum) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(pnum, "pnum");
        if (!TextUtils.isEmpty(pnum) && pnum.length() == 11) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pnum, "1", false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    public final void s() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public abstract void t();

    public abstract void u(@NotNull String code);

    protected final void v(int smsType, @Nullable String plainPhoneStr, @Nullable String maskPhoneStr, @Nullable String phoneToken) {
        QWalletAuthorize$SendSMSReq qWalletAuthorize$SendSMSReq = new QWalletAuthorize$SendSMSReq();
        qWalletAuthorize$SendSMSReq.appid.set(this.appId);
        qWalletAuthorize$SendSMSReq.openid.set(this.openId);
        qWalletAuthorize$SendSMSReq.access_token.set(this.accessToken);
        if (plainPhoneStr != null) {
            qWalletAuthorize$SendSMSReq.phone_no.set(plainPhoneStr);
        }
        qWalletAuthorize$SendSMSReq.check_type.set(smsType);
        if (maskPhoneStr != null) {
            qWalletAuthorize$SendSMSReq.mask_phone_no.set(maskPhoneStr);
        }
        if (phoneToken != null) {
            qWalletAuthorize$SendSMSReq.qpay_token.set(phoneToken);
        }
        d dVar = new d();
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$SendSMSReq.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "SendSMS", qWalletAuthorize$SendSMSReq, (MessageMicro) newInstance, false, false, false, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x(@Nullable String str) {
        this.lastPhoneNum = str;
    }

    protected final void y(@Nullable CountDownTimer countDownTimer) {
        this.mTimer = countDownTimer;
    }
}
