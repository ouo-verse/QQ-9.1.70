package com.tencent.mobileqq.vas.pay.api.impl.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqgift.utils.QQGiftPanelUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$ChargeProductItem;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$GetChargeProductRsp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import g23.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import org.slf4j.Marker;

/* loaded from: classes20.dex */
public class NativePayPopView implements View.OnClickListener {

    /* renamed from: w0, reason: collision with root package name */
    private static final boolean f310153w0 = ar.b("shouyouye", "2024-06-19", "vas_bug_126020073").isEnable(true);

    /* renamed from: x0, reason: collision with root package name */
    private static final boolean f310154x0 = ar.b("shouyouye", "2024-07-16", "vas_bug_127451675").isEnable(true);

    /* renamed from: y0, reason: collision with root package name */
    private static final boolean f310155y0 = ar.b("shouyouye", "2024-07-16", "vas_bug_127417031").isEnable(true);

    /* renamed from: z0, reason: collision with root package name */
    private static final boolean f310156z0 = ar.b("shouyouye", "2024-10-09", "vas_bug_131799736").isEnable(true);
    private ImageView C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private LinearLayout I;
    private ImageView J;
    private RelativeLayout K;
    private RelativeLayout L;
    private RelativeLayout M;
    private RelativeLayout N;
    private RelativeLayout P;
    private RelativeLayout Q;
    private TextView R;
    private CustomValueView S;
    private Button T;
    private TextView U;
    private TextView V;
    protected RelativeLayout W;
    private FirstPayIconShowPanel X;
    private RelativeLayout Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private URLImageView f310157a0;

    /* renamed from: d, reason: collision with root package name */
    public Activity f310160d;

    /* renamed from: e, reason: collision with root package name */
    public PayHelper f310162e;

    /* renamed from: f, reason: collision with root package name */
    public IVasNativePayManager.PayObserver f310164f;

    /* renamed from: h, reason: collision with root package name */
    public PopupWindow f310167h;

    /* renamed from: i, reason: collision with root package name */
    private View f310169i;

    /* renamed from: i0, reason: collision with root package name */
    private int f310170i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f310171j0;

    /* renamed from: l0, reason: collision with root package name */
    private b.a f310173l0;

    /* renamed from: m, reason: collision with root package name */
    private View f310174m;

    /* renamed from: m0, reason: collision with root package name */
    private VasNativePayManagerImpl f310175m0;

    /* renamed from: s0, reason: collision with root package name */
    private IVasNativePayManager.ReportData f310181s0;

    /* renamed from: t0, reason: collision with root package name */
    private long f310182t0;

    /* renamed from: u0, reason: collision with root package name */
    public PayHelper.b f310183u0;

    /* renamed from: v0, reason: collision with root package name */
    public IVasNativePayManager.PayObserver f310184v0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout[] f310158b0 = new RelativeLayout[6];

    /* renamed from: c0, reason: collision with root package name */
    private String f310159c0 = IVasNativePayManager.TITLE_RECHARGE;

    /* renamed from: d0, reason: collision with root package name */
    private String f310161d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    private String f310163e0 = "0";

    /* renamed from: f0, reason: collision with root package name */
    private String f310165f0 = "\u6211\u7684\u8d44\u4ea7";

    /* renamed from: g0, reason: collision with root package name */
    private String f310166g0 = "\u7acb\u5373\u5145\u503cN\u5143";

    /* renamed from: h0, reason: collision with root package name */
    private String f310168h0 = "";

    /* renamed from: k0, reason: collision with root package name */
    private boolean f310172k0 = QQTheme.isNowThemeIsNight();

    /* renamed from: n0, reason: collision with root package name */
    private int f310176n0 = 1;

    /* renamed from: o0, reason: collision with root package name */
    private int f310177o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    private List<midasPayCoinb$ChargeProductItem> f310178p0 = new ArrayList(6);

    /* renamed from: q0, reason: collision with root package name */
    private boolean f310179q0 = true;

    /* renamed from: r0, reason: collision with root package name */
    private String f310180r0 = VasNativePayManagerImpl.OFFER_ID_B_DEFAULT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NativePayPopView nativePayPopView = NativePayPopView.this;
            nativePayPopView.A(g23.a.f401118a.a("payWebUrl", nativePayPopView.f310181s0.mBusinessId));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements PayHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVasNativePayManager.PayObserver f310191a;

        c(IVasNativePayManager.PayObserver payObserver) {
            this.f310191a = payObserver;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void a(int i3) {
            NativePayPopView.this.D(i3, this.f310191a);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void onPayError(int i3) {
            NativePayPopView.this.H(i3, this.f310191a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NativePayPopView.this.v();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NativePayPopView nativePayPopView = NativePayPopView.this;
            nativePayPopView.A(nativePayPopView.f310173l0.f401124e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f implements com.tencent.mobileqq.vas.pay.api.impl.view.a {
        f() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.view.a
        public void onClick(int i3) {
            NativePayPopView.this.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g implements IElementDynamicParams {
        g() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
        @Nullable
        public Map<String, Object> getElementDynamicParams() {
            int i3;
            HashMap hashMap = new HashMap();
            NativePayPopView nativePayPopView = NativePayPopView.this;
            if (nativePayPopView.W != null) {
                String w3 = nativePayPopView.w();
                String charSequence = ((TextView) NativePayPopView.this.W.findViewById(R.id.f95665fl)).getText().toString();
                int intValue = ((Integer) NativePayPopView.this.W.getTag()).intValue();
                if (intValue < NativePayPopView.this.f310178p0.size()) {
                    i3 = ((midasPayCoinb$ChargeProductItem) NativePayPopView.this.f310178p0.get(intValue)).coin_present_num.get();
                } else {
                    i3 = 0;
                }
                VideoReport.setPageParams(NativePayPopView.this.T, "actual_topup_coin", w3 + "\u91d1\u5e01");
                VideoReport.setPageParams(NativePayPopView.this.T, "actual_topup_money", charSequence);
                VideoReport.setPageParams(NativePayPopView.this.T, "gifted_coin_amount", i3 + "\u91d1\u5e01");
                return hashMap;
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class h implements PayHelper.b {
        h() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void a(int i3) {
            NativePayPopView.this.a0(i3);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void onPayError(int i3) {
            NativePayPopView.this.Z(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class i implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f310198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IVasNativePayManager.PayObserver f310199e;

        i(boolean z16, IVasNativePayManager.PayObserver payObserver) {
            this.f310198d = z16;
            this.f310199e = payObserver;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || i3 != 0 || obj == null) {
                NativePayPopView.this.W(this.f310199e);
            } else {
                NativePayPopView.this.E((byte[]) obj, this.f310198d, this.f310199e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class j extends PayHelper.a<NativePayPopView> {
        public j(String str, NativePayPopView nativePayPopView) {
            super(str, nativePayPopView);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void a(int i3) {
            NativePayPopView b16 = b();
            if (b16 != null) {
                b16.a0(i3);
            }
        }

        @Override // com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.b
        public void onPayError(int i3) {
            NativePayPopView b16 = b();
            if (b16 != null) {
                b16.Z(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final String f310201d;

        public k(String str) {
            this.f310201d = str;
        }

        private void a(String str) {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                Intent intent = new Intent(topActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                topActivity.startActivity(intent);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a(this.f310201d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        Activity z16 = z();
        if (z16 != null) {
            Intent intent = new Intent(z16, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            z16.startActivity(intent);
        }
    }

    private void B() {
        if (TextUtils.isEmpty(this.f310168h0)) {
            return;
        }
        A(this.f310168h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i3, IVasNativePayManager.PayObserver payObserver) {
        QLog.i("VasNativePayViewImpl", 1, "onPaySuccess " + i3);
        if (payObserver != null) {
            payObserver.onPaySuccess();
        }
        e0(i3);
        this.f310184v0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(byte[] bArr, boolean z16, IVasNativePayManager.PayObserver payObserver) {
        midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp = new midasPayCoinb$GetChargeProductRsp();
        try {
            midaspaycoinb_getchargeproductrsp.mergeFrom(bArr);
            s0(midaspaycoinb_getchargeproductrsp, z16, payObserver);
        } catch (InvalidProtocolBufferMicroException e16) {
            W(payObserver);
            QLog.e("VasNativePayViewImpl", 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3, IVasNativePayManager.PayObserver payObserver) {
        QLog.i("VasNativePayViewImpl", 1, "onPayError " + i3);
        if (payObserver != null) {
            payObserver.onPayError(i3);
        }
        e0(i3);
        this.f310184v0 = null;
    }

    private void J() {
        this.E.setText(this.f310159c0);
        this.E.setTypeface(Typeface.createFromAsset(this.f310169i.getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
        this.G.setText(this.f310163e0);
        this.V.setText(this.f310165f0);
        this.T.setText(this.f310166g0);
        this.R.setText(this.f310161d0 + "\u4f59\u989d");
        this.J.setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/QQMonetary/questionmarkdarkandroid.png"));
        AccessibilityUtil.c(this.J, "\u8bf4\u660e", Button.class.getName());
    }

    private void K() {
        if (TextUtils.isEmpty(this.f310161d0) && "1000".equals(this.f310181s0.mBusinessId)) {
            this.V.setVisibility(8);
        }
    }

    private void L() {
        PopupWindow popupWindow = new PopupWindow(this.f310169i, -1, (int) TypedValue.applyDimension(1, 540.0f, this.f310169i.getResources().getDisplayMetrics()));
        this.f310167h = popupWindow;
        popupWindow.setAnimationStyle(R.style.f173923av4);
        this.f310167h.setBackgroundDrawable(new ColorDrawable(0));
        this.f310167h.setFocusable(true);
        this.f310167h.setOutsideTouchable(true);
        this.f310167h.update();
        if (Build.VERSION.SDK_INT >= 26) {
            ((Application) BaseApplication.context.getApplicationContext()).registerActivityLifecycleCallbacks(this.f310175m0);
        }
        this.f310167h.setOnDismissListener(this.f310175m0);
        if (this.f310176n0 == 2 && !((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.context.getApplicationContext())) {
            b0();
        } else {
            c0();
        }
    }

    private boolean N(int i3) {
        if (i3 != R.id.f166002yd1 && i3 != R.id.f166003yd2 && i3 != R.id.f166004yd3 && i3 != R.id.f166005yd4 && i3 != R.id.yd5 && i3 != R.id.yd6) {
            return false;
        }
        return true;
    }

    private boolean O() {
        if (this.S.getVisibility() == 0 && this.f310174m.getVisibility() != 0) {
            return true;
        }
        return false;
    }

    private boolean P() {
        return MMKV.a0("vas_native_pay", 2).getBoolean("mmkv_key_first_open", true);
    }

    private boolean Q() {
        if (System.currentTimeMillis() - this.f310182t0 < 2000) {
            return true;
        }
        return false;
    }

    private boolean R() {
        return QQPermissionConstants.Business.ID.QQ_LIVE.equals(QQGiftPanelUtil.a(this.f310181s0.mBusinessId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(IVasNativePayManager.ReportData reportData, Activity activity, IVasNativePayManager.PayObserver payObserver, int i3, int i16, boolean z16, Object obj) {
        if (z16 && i16 == 0 && obj != null) {
            midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp = new midasPayCoinb$GetChargeProductRsp();
            try {
                midaspaycoinb_getchargeproductrsp.mergeFrom((byte[]) obj);
                if (!TextUtils.isEmpty(midaspaycoinb_getchargeproductrsp.coinb_offerid.get())) {
                    String str = midaspaycoinb_getchargeproductrsp.coinb_offerid.get();
                    PayHelper payHelper = new PayHelper(reportData, activity);
                    this.f310184v0 = payObserver;
                    payHelper.g(str, "PRO-M5LFH55JIINU", i3, String.valueOf(i3), true, new c(payObserver));
                } else {
                    QLog.i("VasNativePayViewImpl", 1, "rsp failed. ");
                    W(payObserver);
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                W(payObserver);
                QLog.e("VasNativePayViewImpl", 1, "", e16);
                return;
            }
        }
        W(payObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(int i3) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(IVasNativePayManager.PayObserver payObserver) {
        if (payObserver != null) {
            payObserver.onOpenPayViewFail();
        }
    }

    private void X(IVasNativePayManager.PayObserver payObserver) {
        if (payObserver != null) {
            payObserver.onOpenPayViewSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        PayHelper.b hVar;
        if (S()) {
            return;
        }
        if (f310154x0) {
            hVar = new j("onPayBtnClick", this);
        } else {
            hVar = new h();
        }
        PayHelper.b bVar = hVar;
        this.f310183u0 = bVar;
        if (bVar instanceof PayHelper.a) {
            ((PayHelper.a) bVar).c();
        }
        if (this.f310179q0) {
            this.f310162e.g(this.f310180r0, x(), y(), w(), O(), bVar);
        } else {
            this.f310162e.h(w(), O(), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i3) {
        QLog.i("VasNativePayViewImpl", 1, "onPayError " + i3);
        this.f310182t0 = 0L;
        n0();
        e0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i3) {
        QLog.i("VasNativePayViewImpl", 1, "onPaySuccess " + i3);
        this.f310182t0 = 0L;
        r0(false, null);
        u();
        IVasNativePayManager.PayObserver payObserver = this.f310164f;
        if (payObserver != null) {
            payObserver.onPaySuccess();
        }
        e0(i3);
    }

    private void b0() {
        if (this.f310177o0 == 0) {
            return;
        }
        this.f310176n0 = 2;
        float applyDimension = TypedValue.applyDimension(1, 540.0f, this.f310169i.getResources().getDisplayMetrics());
        int i3 = this.f310177o0;
        float f16 = i3 / applyDimension;
        float f17 = 1.0f - f16;
        this.S.setTranslationX((i3 * f17) / 2.0f);
        this.f310174m.setTranslationX((this.f310177o0 * f17) / 2.0f);
        this.f310169i.setPivotY(0.0f);
        this.f310169i.setScaleY(f16);
        this.S.setScaleX(f16);
        this.f310174m.setScaleX(f16);
        i0();
        this.f310167h.setWidth(this.f310177o0);
        this.f310167h.setAnimationStyle(R.style.av5);
        if (this.f310167h.isShowing()) {
            this.f310167h.update();
        }
        u();
    }

    private void c0() {
        if (this.f310177o0 == 0) {
            return;
        }
        p0();
        this.f310169i.setTranslationX(0.0f);
        this.f310169i.setScaleX(1.0f);
        this.f310169i.setScaleY(1.0f);
        this.f310176n0 = 1;
        this.f310167h.setWidth(-1);
        this.f310167h.setAnimationStyle(R.style.f173923av4);
        if (this.f310167h.isShowing()) {
            this.f310167h.update();
        }
    }

    private void d0(Activity activity) {
        boolean z16;
        String str;
        String str2;
        String str3;
        try {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(this.f310174m, "pg_huobi_topup");
            Iterator<midasPayCoinb$ChargeProductItem> it = this.f310178p0.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().coin_present_num.get() > 0) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06MK9E48EOTF");
            hashMap.put("huobi_sdkversion", VasNativePayManagerImpl.PAY_VERSION);
            if (this.f310179q0) {
                str = this.f310180r0;
            } else {
                str = VasNativePayManagerImpl.OFFER_ID_C;
            }
            hashMap.put("huobi_extra_param", str);
            hashMap.put("pgid", "pg_huobi_topup");
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put("huobi_is_gift", str2);
            if (this.f310176n0 == 2) {
                str3 = "heng";
            } else {
                str3 = "shu";
            }
            hashMap.put("screen_type", str3);
            for (String str4 : this.f310181s0.mDtData.keySet()) {
                hashMap.put(str4, this.f310181s0.mDtData.get(str4));
            }
            VideoReport.setPageParams(this.f310174m, new PageParams(hashMap));
            VideoReport.setElementId(this.V, "em_huobi_my_asset");
            VideoReport.setElementId(this.T, "em_huobi_confirm");
            VideoReport.setElementId(this.U, "em_huobi_topup_agreement");
            VideoReport.setElementDynamicParams(this.T, new g());
            VideoReport.reportEvent("pgin", this.f310174m, hashMap);
            VideoReport.reportEvent("imp", this.V, hashMap);
            VideoReport.reportEvent("imp", this.T, hashMap);
            VideoReport.reportEvent("imp", this.U, hashMap);
        } catch (Exception e16) {
            QLog.e("VasNativePayViewImpl", 1, "", e16);
        }
    }

    private void e0(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("topup_status_info", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_topup_succeed", this.T, hashMap);
    }

    @SuppressLint({"WrongViewCast"})
    private void f0(RelativeLayout relativeLayout) {
        if (((TextView) relativeLayout.findViewById(R.id.f95245eg)).getVisibility() == 0) {
            l0();
            return;
        }
        RelativeLayout relativeLayout2 = this.W;
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.f95665fl)).setTextColor(Color.parseColor("#FF999999"));
            this.W.findViewById(R.id.f165849xt3).setVisibility(8);
            this.W.findViewById(R.id.yib).setVisibility(0);
            this.W.setSelected(false);
        }
        this.W = relativeLayout;
        relativeLayout.findViewById(R.id.yib).setVisibility(8);
        this.W.findViewById(R.id.f165849xt3).setVisibility(0);
        TextView textView = (TextView) this.W.findViewById(R.id.f95665fl);
        textView.setTextColor(-1);
        this.T.setText("\u7acb\u5373\u5145\u503c" + ((Object) textView.getText()));
        this.W.setSelected(true);
    }

    private void g0() {
        MMKV.a0("vas_native_pay", 2).putBoolean("mmkv_key_first_open", false).apply();
    }

    private void i0() {
        View decorView;
        Activity z16 = z();
        if (z16 == null || this.f310169i == null || z16.getWindow() == null || (decorView = z16.getWindow().getDecorView()) == null) {
            return;
        }
        this.f310169i.setSystemUiVisibility(decorView.getSystemUiVisibility());
    }

    private void k0(midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp) {
        String a16;
        if (this.f310176n0 == 2) {
            return;
        }
        if (this.f310177o0 > ((int) TypedValue.applyDimension(1, 600.0f, this.f310169i.getResources().getDisplayMetrics()))) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (midaspaycoinb_getchargeproductrsp.is_rebate.get()) {
            a16 = midaspaycoinb_getchargeproductrsp.rebate_banner_image_url.get();
            this.f310168h0 = midaspaycoinb_getchargeproductrsp.rebate_banner_jump_url.get();
            this.D.setVisibility(8);
        } else if (midaspaycoinb_getchargeproductrsp.balance.first_save.get() == 1) {
            g23.a aVar = g23.a.f401118a;
            a16 = aVar.a("bannerImageUrl", this.f310181s0.mBusinessId);
            this.f310168h0 = aVar.a("bannerJumpUrl", this.f310181s0.mBusinessId);
            this.D.setVisibility(0);
        } else {
            return;
        }
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        this.C.setImageDrawable(URLDrawable.getDrawable(a16, obtain));
        this.C.setVisibility(0);
        AccessibilityUtil.c(this.C, "QQ\u91d1\u5e01\u80fd\u591f\u4e70QQ\u5185\u865a\u62df\u5546\u54c1\uff0c\u53ef\u5728\u591a\u4e2a\u573a\u666f\u5185\u4f7f\u7528", Button.class.getName());
        v0(600);
    }

    private void l0() {
        this.f310174m.setVisibility(4);
        this.S.setVisibility(0);
    }

    private void m0() {
        Activity z16 = z();
        if (z16 == null || this.f310176n0 == 2) {
            return;
        }
        FirstPayIconShowPanel firstPayIconShowPanel = new FirstPayIconShowPanel();
        this.X = firstPayIconShowPanel;
        if (firstPayIconShowPanel.showFirstPayIconShowPanel(z16, this.f310181s0, this.f310173l0, this.f310179q0)) {
            g0();
        }
    }

    private void p0() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        if (ViewUtils.getScreenWidth() > 0) {
            layoutParams.height = ViewUtils.getScreenWidth() / 10;
            this.C.setLayoutParams(layoutParams);
        }
    }

    private void t(boolean z16) {
        Activity z17;
        Window window;
        if (f310156z0 || (z17 = z()) == null || (window = z17.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z16) {
            attributes.alpha = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
        } else {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
            window.clearFlags(2);
        }
    }

    private void t0(boolean z16) {
        if (this.f310178p0.size() != this.f310158b0.length) {
            return;
        }
        int i3 = 0;
        while (true) {
            RelativeLayout[] relativeLayoutArr = this.f310158b0;
            if (i3 < relativeLayoutArr.length) {
                relativeLayoutArr[i3].setTag(Integer.valueOf(i3));
                TextView textView = (TextView) this.f310158b0[i3].findViewById(R.id.f95245eg);
                textView.setTypeface(Typeface.createFromAsset(this.f310169i.getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
                RelativeLayout relativeLayout = (RelativeLayout) this.f310158b0[i3].findViewById(R.id.f166020yf1);
                if (i3 == this.f310158b0.length - 1) {
                    textView.setVisibility(0);
                    relativeLayout.setVisibility(8);
                    if (VasToggle.RECHARGE_MAX_PAY_NUM.isEnable(true)) {
                        ((TextView) this.f310158b0[i3].findViewById(R.id.f95665fl)).setText("0-" + (this.S.getMaxPay() / 10) + "\u5143");
                        return;
                    }
                    return;
                }
                textView.setVisibility(8);
                relativeLayout.setVisibility(0);
                TextView textView2 = (TextView) this.f310158b0[i3].findViewById(R.id.f95395ev);
                textView2.setText("" + this.f310178p0.get(i3).coin_num.get());
                textView2.setTypeface(Typeface.createFromAsset(this.f310169i.getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
                ((TextView) this.f310158b0[i3].findViewById(R.id.f95665fl)).setText("" + (this.f310178p0.get(i3).product_price.get() / 100) + "\u5143");
                String str = this.f310178p0.get(i3).first_save_present.get();
                if (!TextUtils.isEmpty(str) && z16) {
                    ((TextView) this.f310158b0[i3].findViewById(R.id.f95725fr)).setText(str);
                    this.f310158b0[i3].findViewById(R.id.f95725fr).setVisibility(0);
                } else {
                    this.f310158b0[i3].findViewById(R.id.f95725fr).setVisibility(8);
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void u() {
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        v0(540);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp) {
        URLImageView uRLImageView;
        if (midaspaycoinb_getchargeproductrsp.balance.balance.has()) {
            this.f310170i0 = midaspaycoinb_getchargeproductrsp.balance.balance.get();
        } else {
            this.f310170i0 = 0;
        }
        if (midaspaycoinb_getchargeproductrsp.balance.marketing_balance.has()) {
            this.f310171j0 = midaspaycoinb_getchargeproductrsp.balance.marketing_balance.get();
        } else {
            this.f310171j0 = 0;
        }
        int i3 = this.f310171j0;
        if (i3 > 0) {
            this.H.setText(String.valueOf(i3));
            this.I.setVisibility(0);
            String a16 = g23.a.f401118a.a("marketCoinIcon", "");
            if (!TextUtils.isEmpty(a16) && (uRLImageView = this.f310157a0) != null) {
                uRLImageView.setBackgroundURL(a16);
                return;
            }
            return;
        }
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f310174m.setVisibility(0);
        this.S.setVisibility(8);
    }

    private void v0(int i3) {
        this.f310167h.setHeight((int) TypedValue.applyDimension(1, i3, this.f310169i.getResources().getDisplayMetrics()));
        this.f310167h.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        if (O()) {
            return this.S.o();
        }
        return ((TextView) this.W.findViewById(R.id.f95395ev)).getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(boolean z16, midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp, View view, IVasNativePayManager.PayObserver payObserver) {
        Activity z17 = z();
        if (z16 && z17 != null) {
            if (midaspaycoinb_getchargeproductrsp.products.has()) {
                this.f310178p0 = midaspaycoinb_getchargeproductrsp.products.get();
                t0(midaspaycoinb_getchargeproductrsp.is_first_save.get());
            }
            k0(midaspaycoinb_getchargeproductrsp);
            if (midaspaycoinb_getchargeproductrsp.is_first_save.get()) {
                this.Y.setVisibility(0);
                this.Z.setText(midaspaycoinb_getchargeproductrsp.first_save_title.get());
            } else {
                this.Y.setVisibility(4);
            }
            if (!TextUtils.isEmpty(midaspaycoinb_getchargeproductrsp.coinb_offerid.get())) {
                this.f310180r0 = midaspaycoinb_getchargeproductrsp.coinb_offerid.get();
            }
            if (midaspaycoinb_getchargeproductrsp.default_coin_num.has()) {
                int i3 = midaspaycoinb_getchargeproductrsp.default_coin_num.get();
                int i16 = 0;
                while (true) {
                    if (i16 >= this.f310178p0.size()) {
                        break;
                    }
                    if (this.f310178p0.get(i16).coin_num.get() == i3) {
                        RelativeLayout[] relativeLayoutArr = this.f310158b0;
                        if (i16 < relativeLayoutArr.length) {
                            f0(relativeLayoutArr[i16]);
                            break;
                        }
                    }
                    i16++;
                }
            }
            this.f310167h.update();
            d0(z17);
            this.f310179q0 = midaspaycoinb_getchargeproductrsp.is_coinb.get();
            this.f310167h.showAtLocation(view, 85, 0, 0);
            if (!this.f310172k0) {
                t(true);
            }
            X(payObserver);
            return;
        }
        W(payObserver);
    }

    private String x() {
        if (O()) {
            return "PRO-M5LFH55JIINU";
        }
        return this.f310178p0.get(((Integer) this.W.getTag()).intValue()).product_id.get();
    }

    private int y() {
        if (O()) {
            try {
                return Integer.parseInt(this.S.o());
            } catch (Exception e16) {
                QLog.e("VasNativePayViewImpl", 1, "", e16);
                return 0;
            }
        }
        return this.f310178p0.get(((Integer) this.W.getTag()).intValue()).quantity.get();
    }

    private Activity z() {
        Activity activity = this.f310160d;
        if (activity != null) {
            return activity;
        }
        return Foreground.getTopActivity();
    }

    public void C(final Activity activity, final int i3, final IVasNativePayManager.ReportData reportData, final IVasNativePayManager.PayObserver payObserver) {
        int i16;
        if (com.tencent.mobileqq.vas.pay.api.impl.helper.a.a() == null) {
            W(payObserver);
            return;
        }
        try {
            i16 = Integer.parseInt(reportData.mBusinessId);
        } catch (NumberFormatException e16) {
            W(payObserver);
            QLog.e("VasNativePayViewImpl", 1, "", e16);
            i16 = 0;
        }
        f23.a.a().b(i16, new BusinessObserver() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.m
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i17, boolean z16, Object obj) {
                NativePayPopView.this.T(reportData, activity, payObserver, i3, i17, z16, obj);
            }
        });
    }

    public void F() {
        PopupWindow popupWindow = this.f310167h;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f310167h.getContentView().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.NativePayPopView.12
                @Override // java.lang.Runnable
                public void run() {
                    NativePayPopView.this.f310167h.setAnimationStyle(0);
                    NativePayPopView.this.f310167h.update();
                }
            });
        }
    }

    public void G() {
        PopupWindow popupWindow = this.f310167h;
        if (popupWindow != null) {
            popupWindow.getContentView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.NativePayPopView.13
                @Override // java.lang.Runnable
                public void run() {
                    PopupWindow popupWindow2 = NativePayPopView.this.f310167h;
                    if (popupWindow2 != null && popupWindow2.isShowing()) {
                        NativePayPopView.this.f310167h.setAnimationStyle(R.style.f173923av4);
                        NativePayPopView.this.f310167h.update();
                    }
                }
            }, 200L);
        }
    }

    public void I() {
        PopupWindow popupWindow = this.f310167h;
        if (popupWindow != null && popupWindow.getContentView() != null) {
            this.f310167h.getContentView().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.NativePayPopView.1
                @Override // java.lang.Runnable
                public void run() {
                    NativePayPopView.this.f310167h.dismiss();
                }
            });
        }
    }

    public void M(Activity activity, String str, String str2, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        boolean z16;
        String str3;
        int i3;
        if (!f310153w0) {
            this.f310160d = activity;
        }
        this.f310181s0 = reportData;
        this.f310162e = new PayHelper(reportData, activity);
        if (!QQTheme.isNowThemeIsNight() && !R()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f310172k0 = z16;
        this.f310161d0 = str2;
        this.f310173l0 = g23.b.c().b();
        if (!TextUtils.isEmpty(str)) {
            this.f310159c0 = str;
        }
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration != null) {
            this.f310176n0 = configuration.orientation;
        }
        if (payObserver != null) {
            this.f310164f = payObserver;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (screenWidth >= screenHeight) {
            screenWidth = screenHeight;
        }
        this.f310177o0 = screenWidth;
        if (this.f310172k0) {
            str3 = this.f310173l0.f401121b;
        } else {
            str3 = this.f310173l0.f401120a;
        }
        URLDrawable.getDrawable(str3).startDownload();
        LayoutInflater from = LayoutInflater.from(activity);
        if (this.f310172k0) {
            i3 = R.layout.hh8;
        } else {
            i3 = R.layout.hh7;
        }
        View inflate = from.inflate(i3, (ViewGroup) null);
        this.f310169i = inflate;
        this.f310174m = inflate.findViewById(R.id.f72623rc);
        this.C = (ImageView) this.f310169i.findViewById(R.id.du8);
        this.D = (ImageView) this.f310169i.findViewById(R.id.y0q);
        this.E = (TextView) this.f310169i.findViewById(R.id.jj7);
        this.F = (TextView) this.f310169i.findViewById(R.id.f108636dn);
        this.G = (TextView) this.f310169i.findViewById(R.id.f95575fc);
        this.H = (TextView) this.f310169i.findViewById(R.id.f109206f7);
        this.f310157a0 = (URLImageView) this.f310169i.findViewById(R.id.y5l);
        this.I = (LinearLayout) this.f310169i.findViewById(R.id.f166102yp3);
        this.J = (ImageView) this.f310169i.findViewById(R.id.y7l);
        RelativeLayout relativeLayout = (RelativeLayout) this.f310169i.findViewById(R.id.f166002yd1);
        this.K = relativeLayout;
        this.f310158b0[0] = relativeLayout;
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f310169i.findViewById(R.id.f166003yd2);
        this.L = relativeLayout2;
        this.f310158b0[1] = relativeLayout2;
        RelativeLayout relativeLayout3 = (RelativeLayout) this.f310169i.findViewById(R.id.f166004yd3);
        this.M = relativeLayout3;
        this.f310158b0[2] = relativeLayout3;
        RelativeLayout relativeLayout4 = (RelativeLayout) this.f310169i.findViewById(R.id.f166005yd4);
        this.N = relativeLayout4;
        this.f310158b0[3] = relativeLayout4;
        RelativeLayout relativeLayout5 = (RelativeLayout) this.f310169i.findViewById(R.id.yd5);
        this.P = relativeLayout5;
        this.f310158b0[4] = relativeLayout5;
        RelativeLayout relativeLayout6 = (RelativeLayout) this.f310169i.findViewById(R.id.yd6);
        this.Q = relativeLayout6;
        this.f310158b0[5] = relativeLayout6;
        this.T = (Button) this.f310169i.findViewById(R.id.tjy);
        this.U = (TextView) this.f310169i.findViewById(R.id.f95135e6);
        this.V = (TextView) this.f310169i.findViewById(R.id.f95145e7);
        this.R = (TextView) this.f310169i.findViewById(R.id.f95935gb);
        this.S = (CustomValueView) this.f310169i.findViewById(R.id.f164943ud4);
        this.Y = (RelativeLayout) this.f310169i.findViewById(R.id.f72593r_);
        this.Z = (TextView) this.f310169i.findViewById(R.id.f107216_t);
        this.f310169i.setOnClickListener(this);
        this.f310174m.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.J.setOnClickListener(this);
        if (f310155y0) {
            this.S.B(new com.tencent.mobileqq.vas.pay.api.impl.view.a() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.k
                @Override // com.tencent.mobileqq.vas.pay.api.impl.view.a
                public final void onClick(int i16) {
                    NativePayPopView.this.U(i16);
                }
            }).A(new k(this.f310173l0.f401124e)).setOnBackKeyClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NativePayPopView.this.V(view);
                }
            }, this.f310172k0);
        } else {
            this.S.B(new f()).A(new e()).setOnBackKeyClickListener(new d(), this.f310172k0);
        }
        this.S.D(this.f310172k0);
        d0(activity);
        K();
        L();
        J();
        r0(true, payObserver);
    }

    protected boolean S() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f310182t0 < 2000) {
            return true;
        }
        this.f310182t0 = currentTimeMillis;
        return false;
    }

    public void j0(VasNativePayManagerImpl vasNativePayManagerImpl) {
        this.f310175m0 = vasNativePayManagerImpl;
    }

    protected void n0() {
        Activity z16 = z();
        if (z16 == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(z16, 230, "\u5145\u503c\u5931\u8d25", "\u5145\u503c\u5931\u8d25\uff0c\u53ef\u4f7f\u7528\u7f51\u9875\u5145\u503c\u8bd5\u8bd5", "", "\u7f51\u9875\u5145\u503c", new a(), (DialogInterface.OnClickListener) null);
        createCustomDialog.setNegativeButton("\u53d6\u6d88", new b());
        createCustomDialog.show();
    }

    protected void o0() {
        Activity z16;
        long j3 = this.f310171j0;
        g23.a aVar = g23.a.f401118a;
        if (com.tencent.mobileqq.vas.pay.api.impl.helper.a.a() == null || (z16 = z()) == null) {
            return;
        }
        IVasTempApi.INSTANCE.get().showCoinExplainDialog(z16, new BalanceExplainDialogData(this.f310170i0, j3, aVar.a("explainText", this.f310181s0.mBusinessId), QQGiftPanelUtil.a(this.f310181s0.mBusinessId), aVar.a(WadlProxyConsts.KEY_JUMP_URL, this.f310181s0.mBusinessId), aVar.a("marketCoinIcon", "")));
        if (!this.f310172k0) {
            t(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!Q()) {
            int id5 = view.getId();
            if (N(id5)) {
                f0((RelativeLayout) view);
            } else if (id5 == R.id.tjy) {
                Y();
            } else if (id5 == R.id.f95135e6) {
                A(this.f310173l0.f401124e);
            } else if (id5 == R.id.f95145e7) {
                A(this.f310173l0.f401123d + "&traceid=" + this.f310181s0.mBusinessId);
            } else if (id5 == R.id.f108636dn) {
                A("https://act.qzone.qq.com/v2/vip/tx/p/7310_3e9a8b1e?_wv=2");
            } else if (id5 == R.id.y7l) {
                o0();
            } else if (id5 == R.id.du8) {
                B();
            } else if (id5 == R.id.y0q) {
                u();
            } else if (view == this.f310169i) {
                I();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void q0(boolean z16, midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp, IVasNativePayManager.PayObserver payObserver) {
        int i3;
        try {
            if (midaspaycoinb_getchargeproductrsp.balance.has() && midaspaycoinb_getchargeproductrsp.balance.balance.has() && this.f310167h.isShowing()) {
                int i16 = midaspaycoinb_getchargeproductrsp.balance.balance.get();
                int intValue = Integer.valueOf(String.valueOf(this.G.getText())).intValue();
                this.G.setText("" + i16);
                int i17 = i16 - intValue;
                if (!z16 && i17 > 0) {
                    Iterator<midasPayCoinb$ChargeProductItem> it = this.f310178p0.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            midasPayCoinb$ChargeProductItem next = it.next();
                            if (i17 == next.coin_num.get() && next.coin_present_num.get() > 0) {
                                i3 = next.coin_present_num.get();
                                break;
                            }
                        } else {
                            i3 = 0;
                            break;
                        }
                    }
                    String str = "\u6210\u529f\u8d2d\u4e70" + (i17 - i3) + "\u91d1\u5e01";
                    if (i3 != 0) {
                        str = str + Marker.ANY_NON_NULL_MARKER + i3 + this.f310161d0 + "\u6d3b\u52a8\u5e01";
                    }
                    QQToast.makeText(BaseApplication.context, 2, str, 1).show();
                    if (P()) {
                        m0();
                    } else {
                        this.f310175m0.hidePayPanel();
                    }
                }
            }
        } catch (NumberFormatException e16) {
            W(payObserver);
            QLog.e("VasNativePayViewImpl", 1, "", e16);
        }
    }

    public void r0(boolean z16, IVasNativePayManager.PayObserver payObserver) {
        int i3;
        if (com.tencent.mobileqq.vas.pay.api.impl.helper.a.a() == null) {
            W(payObserver);
            return;
        }
        try {
            i3 = Integer.valueOf(this.f310181s0.mBusinessId).intValue();
        } catch (NumberFormatException e16) {
            W(payObserver);
            QLog.e("VasNativePayViewImpl", 1, "", e16);
            i3 = 0;
        }
        f23.a.a().b(i3, new i(z16, payObserver));
    }

    protected void s0(final midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp, final boolean z16, final IVasNativePayManager.PayObserver payObserver) {
        Activity z17 = z();
        if (z17 == null) {
            W(payObserver);
        } else {
            final View decorView = z17.getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.NativePayPopView.9
                @Override // java.lang.Runnable
                public void run() {
                    boolean z18 = z16;
                    if (z18) {
                        NativePayPopView.this.w0(z18, midaspaycoinb_getchargeproductrsp, decorView, payObserver);
                    }
                    NativePayPopView.this.q0(z16, midaspaycoinb_getchargeproductrsp, payObserver);
                    NativePayPopView.this.u0(midaspaycoinb_getchargeproductrsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
