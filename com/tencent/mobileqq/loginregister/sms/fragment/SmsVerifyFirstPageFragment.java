package com.tencent.mobileqq.loginregister.sms.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyBaseFragment;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyFirstPageFragment;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.av;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyFirstPageFragment;", "Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "root", "", "initViews", "Uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "qh", "v", NodeProps.ON_CLICK, "onDetach", "Landroid/widget/Button;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/Button;", "confirmBtn", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "layoutPhoneNum", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "textPhoneNum", "T", "textCountryCode", "U", "space", "V", "textTips", "Lcom/tencent/mobileqq/loginregister/sms/e;", "W", "Lcom/tencent/mobileqq/loginregister/sms/e;", "smsVerifyApi", "<init>", "()V", "X", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SmsVerifyFirstPageFragment extends SmsVerifyBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private Button confirmBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private View layoutPhoneNum;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView textPhoneNum;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView textCountryCode;

    /* renamed from: U, reason: from kotlin metadata */
    private View space;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView textTips;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.sms.e smsVerifyApi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyFirstPageFragment$a;", "", "", "QUERY_LOGIN_VERIFY_REASON_TIMEOUT", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyFirstPageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyFirstPageFragment$b", "Lcom/tencent/mobileqq/loginregister/callback/a;", "", "reason", "", "onResult", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.loginregister.callback.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmsVerifyFirstPageFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String str, SmsVerifyFirstPageFragment this$0) {
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            TextView textView = null;
            if (z16) {
                TextView textView2 = this$0.textTips;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textTips");
                } else {
                    textView = textView2;
                }
                textView.setText(R.string.f200074r5);
                return;
            }
            TextView textView3 = this$0.textTips;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textTips");
            } else {
                textView = textView3;
            }
            textView.setText(str);
        }

        @Override // com.tencent.mobileqq.loginregister.callback.a
        public void onResult(@Nullable final String reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TextView textView = SmsVerifyFirstPageFragment.this.textTips;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textTips");
                    textView = null;
                }
                final SmsVerifyFirstPageFragment smsVerifyFirstPageFragment = SmsVerifyFirstPageFragment.this;
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmsVerifyFirstPageFragment.b.b(reason, smsVerifyFirstPageFragment);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reason);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SmsVerifyFirstPageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Uh(View root) {
        if (z.b(getContext())) {
            z.w(root.findViewById(R.id.f86614s5));
        } else {
            z.A(root.findViewById(R.id.f86614s5));
        }
    }

    private final void initViews(View root) {
        List listOf;
        Intent intent;
        CharSequence trim;
        boolean startsWith$default;
        View findViewById = root.findViewById(R.id.b7p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.confirm_btn)");
        this.confirmBtn = (Button) findViewById;
        View findViewById2 = root.findViewById(R.id.tfu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.b\u2026her_verification_methods)");
        Oh((TextView) findViewById2);
        View findViewById3 = root.findViewById(R.id.e4r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.layout_phone_num)");
        this.layoutPhoneNum = findViewById3;
        View findViewById4 = root.findViewById(R.id.f109946h7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.tv_phone_num)");
        this.textPhoneNum = (TextView) findViewById4;
        View findViewById5 = root.findViewById(R.id.f107076_f);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.tv_country_code)");
        this.textCountryCode = (TextView) findViewById5;
        View findViewById6 = root.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.back_btn)");
        Jh(findViewById6);
        View findViewById7 = root.findViewById(R.id.iz9);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.space)");
        this.space = findViewById7;
        View findViewById8 = root.findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.tv_tips)");
        this.textTips = (TextView) findViewById8;
        View[] viewArr = new View[3];
        viewArr[0] = Bh();
        Button button = this.confirmBtn;
        View view = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            button = null;
        }
        viewArr[1] = button;
        viewArr[2] = sh();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        QBaseActivity xh5 = xh();
        if (xh5 != null) {
            intent = xh5.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AppConstants.Key.PHONENUM);
            Intrinsics.checkNotNull(stringExtra);
            Ph(stringExtra);
            Mh(intent.getStringExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE));
            Nh(intent.getIntExtra("key_sms_verify_function_code", 0));
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            String string = extras.getString("key");
            if (!TextUtils.isEmpty(string)) {
                QLog.e("SmsVerifyFirstPageFragment", 1, "onCreateView countryCode is empty, use default");
                Intrinsics.checkNotNull(string);
                Lh(string);
            }
        }
        if (!TextUtils.isEmpty(uh())) {
            String uh5 = uh();
            Intrinsics.checkNotNull(uh5);
            trim = StringsKt__StringsKt.trim((CharSequence) uh5);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(trim.toString(), Marker.ANY_NON_NULL_MARKER, false, 2, null);
            if (!startsWith$default) {
                String str = Marker.ANY_NON_NULL_MARKER + uh();
                TextView textView = this.textCountryCode;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView = null;
                }
                textView.setText(str);
            } else {
                TextView textView2 = this.textCountryCode;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView2 = null;
                }
                textView2.setText(uh());
            }
        }
        TextView textView3 = this.textPhoneNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textPhoneNum");
            textView3 = null;
        }
        textView3.setText(zh());
        if (FontSettingManager.isFontSizeLarge()) {
            View view2 = this.space;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("space");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        }
        com.tencent.mobileqq.loginregister.sms.e eVar = this.smsVerifyApi;
        if (eVar != null) {
            eVar.d(xh(), 1000L, new b());
        }
        Uh(root);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        com.tencent.mobileqq.loginregister.sms.e eVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.b7p) {
                SmsVerifyBaseFragment.a Dh = Dh();
                if (Dh != null) {
                    Dh.N1(true);
                }
                SmsVerifyBaseFragment.Ih(this, SmsVerifySecondPageFragment.class, false, 2, null);
            } else if (num != null && num.intValue() == R.id.tfu) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - th() >= 500) {
                    Kh(currentTimeMillis);
                    if (xh() != null && (eVar = this.smsVerifyApi) != null) {
                        eVar.e(xh());
                    }
                }
            } else if (num != null && num.intValue() == R.id.a47) {
                qh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Uh(getRoot());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.gyo, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      \u2026          false\n        )");
            Qh(inflate);
            QLog.i("SmsVerifyFirstPageFragment", 2, "onCreateView " + getView());
            if (!Fh()) {
                root = getRoot();
            } else {
                com.tencent.mobileqq.loginregister.sms.e eVar = new com.tencent.mobileqq.loginregister.sms.e();
                this.smsVerifyApi = eVar;
                eVar.h(xh(), null);
                Rh((SmsVerifyBaseFragment.a) new ViewModelProvider(requireActivity()).get(SmsVerifyBaseFragment.a.class));
                initViews(getRoot());
                root = getRoot();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDetach();
            av.f306600a.a(getActivity());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    @Override // com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyBaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean qh() {
        boolean z16;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.loginregister.sms.e eVar = this.smsVerifyApi;
        int i3 = 0;
        if (eVar != null) {
            QBaseActivity qBaseActivity = getQBaseActivity();
            SmsVerifyBaseFragment.a Dh = Dh();
            if (Dh != null && Dh.L1()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (eVar.f(qBaseActivity, z17, th())) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                FragmentActivity activity = getActivity();
                if (activity != null && (supportFragmentManager2 = activity.getSupportFragmentManager()) != null) {
                    i3 = supportFragmentManager2.getBackStackEntryCount();
                }
                if (i3 > 0) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
                        supportFragmentManager.popBackStack();
                    }
                    return true;
                }
                Gh();
                finishActivity();
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }
}
