package com.tencent.biz.troop.feeds;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.utils.as;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import cooperation.qzone.api.QZoneContant;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TroopNewGuidePopWindow extends QQCustomDialog implements View.OnClickListener, Observer, ComponentCallbacks {
    FragmentActivity C;
    View D;
    View E;
    View F;
    View G;
    TextView H;
    Button I;
    Button J;
    ImageView K;
    TextView L;
    TextView M;
    TextView N;
    TextView P;
    LinearLayout Q;
    ImageView R;
    BounceScrollView S;
    protected String T;
    boolean U;
    QQAppInterface V;
    protected TroopFeedsDataManager W;
    String X;
    protected TroopFeedsDataManager.f Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    boolean f96779a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f96780b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f96781c0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f96782d0;

    /* renamed from: e0, reason: collision with root package name */
    protected Handler f96783e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.troop.feeds.TroopNewGuidePopWindow$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f96784d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f96785e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f96786f;

        AnonymousClass4(JSONObject jSONObject, int i3, boolean z16) {
            this.f96784d = jSONObject;
            this.f96785e = i3;
            this.f96786f = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(int i3, boolean z16, TroopMemberNickInfo troopMemberNickInfo) {
            if (troopMemberNickInfo != null) {
                TroopNewGuidePopWindow.this.Y.f294833k = troopMemberNickInfo.getShowName();
            }
            TroopNewGuidePopWindow.this.a0(i3, z16);
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            TroopNewGuidePopWindow.this.Y = TroopFeedsDataManager.f.a(this.f96784d);
            TroopNewGuidePopWindow troopNewGuidePopWindow = TroopNewGuidePopWindow.this;
            if (troopNewGuidePopWindow.Y == null) {
                troopNewGuidePopWindow.a0(this.f96785e, this.f96786f);
                return;
            }
            ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
            TroopNewGuidePopWindow troopNewGuidePopWindow2 = TroopNewGuidePopWindow.this;
            String str = troopNewGuidePopWindow2.X;
            String str2 = troopNewGuidePopWindow2.Y.f294832j;
            final int i3 = this.f96785e;
            final boolean z16 = this.f96786f;
            iTroopMemberListRepoApi.fetchTroopMemberName(str, str2, "TroopTipsPopWindow", new Function1() { // from class: com.tencent.biz.troop.feeds.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b16;
                    b16 = TroopNewGuidePopWindow.AnonymousClass4.this.b(i3, z16, (TroopMemberNickInfo) obj);
                    return b16;
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            TroopNewGuidePopWindow troopNewGuidePopWindow = TroopNewGuidePopWindow.this;
            troopNewGuidePopWindow.W.deleteObserver(troopNewGuidePopWindow);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TroopNewGuidePopWindow.this.M.setMaxWidth((int) ((TroopNewGuidePopWindow.this.Q.getMeasuredWidth() - TroopNewGuidePopWindow.this.N.getMeasuredWidth()) - al.a(TroopNewGuidePopWindow.this.C, 5.0f)));
            TroopNewGuidePopWindow troopNewGuidePopWindow = TroopNewGuidePopWindow.this;
            troopNewGuidePopWindow.M.setText(new com.tencent.mobileqq.text.c(troopNewGuidePopWindow.Y.f294833k, 16).j());
            TroopNewGuidePopWindow.this.N.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            TroopFeedsDataManager.f fVar;
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (32768 == accessibilityEvent.getEventType()) {
                TroopNewGuidePopWindow troopNewGuidePopWindow = TroopNewGuidePopWindow.this;
                if (troopNewGuidePopWindow.L != null && (fVar = troopNewGuidePopWindow.Y) != null && !TextUtils.isEmpty(fVar.f294826d)) {
                    TroopNewGuidePopWindow troopNewGuidePopWindow2 = TroopNewGuidePopWindow.this;
                    FragmentActivity fragmentActivity = troopNewGuidePopWindow2.C;
                    TroopFeedsDataManager.f fVar2 = troopNewGuidePopWindow2.Y;
                    view.setContentDescription(fragmentActivity.getString(R.string.f181013cm, fVar2.f294833k, TroopNewGuidePopWindow.f0(fVar2.f294834l, true, true, false), Html.fromHtml(TroopNewGuidePopWindow.this.Y.f294826d).toString()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            TroopNewGuidePopWindow.this.D.removeOnLayoutChangeListener(this);
            int screenHeightByContext = ViewUtils.getScreenHeightByContext(TroopNewGuidePopWindow.this.C);
            int min = Math.min((int) (screenHeightByContext * 0.55d), screenHeightByContext - (TroopNewGuidePopWindow.this.f96781c0 * 3));
            ViewGroup.LayoutParams layoutParams = TroopNewGuidePopWindow.this.D.getLayoutParams();
            layoutParams.width = TroopNewGuidePopWindow.this.U();
            layoutParams.height = Math.min(i18 - i16, min);
            TroopNewGuidePopWindow.this.D.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + TroopNewGuidePopWindow.this.Y);
                }
                TroopNewGuidePopWindow.this.o0();
            }
        }
    }

    public TroopNewGuidePopWindow(QQAppInterface qQAppInterface, FragmentActivity fragmentActivity, String str, int i3) {
        super(fragmentActivity, R.style.qZoneInputDialog);
        this.S = null;
        this.T = "";
        this.U = false;
        this.Y = null;
        this.Z = false;
        this.f96779a0 = false;
        this.f96780b0 = false;
        this.f96781c0 = 0;
        this.f96782d0 = false;
        this.f96783e0 = new f();
        this.C = fragmentActivity;
        this.V = qQAppInterface;
        this.f96781c0 = i3;
        try {
            this.W = ((com.tencent.mobileqq.model.d) qQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).e(Long.valueOf(Long.parseLong(str)), true);
            this.X = str;
            if (Z()) {
                this.Z = true;
            }
            setOnDismissListener(new a());
        } catch (Exception e16) {
            QLog.e("TroopTipsPopWindow", 1, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int U() {
        return (int) (ViewUtils.getScreenWidthByContext(this.C) * 0.8d);
    }

    public static String W(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP).decodeString("qbiz_host_ip_map" + str, "");
    }

    private QQText X() {
        QQText qQText = new QQText(Html.fromHtml(this.Y.f294826d), 8);
        LinkSpan[] linkSpanArr = (LinkSpan[]) qQText.getSpans(0, qQText.length(), LinkSpan.class);
        if (linkSpanArr != null && linkSpanArr.length != 0) {
            for (LinkSpan linkSpan : linkSpanArr) {
                boolean contains = linkSpan.f292710d.contains("h5.qun.qq.com/h5/jump/?m=qevent");
                QLog.i("TroopTipsPopWindow", 1, "[getNoticeContentQQText] isContains: " + contains + ", url: " + linkSpan.f292710d);
                if (contains) {
                    int spanStart = qQText.getSpanStart(linkSpan);
                    int spanFlags = qQText.getSpanFlags(linkSpan);
                    String string = this.C.getString(R.string.f181003cl);
                    QQText qQText2 = new QQText(qQText.toString().replace(linkSpan.f292710d, string), 8);
                    qQText2.addSpan(new LinkSpan(string), spanStart, string.length() + spanStart, spanFlags);
                    return qQText2;
                }
            }
        }
        return qQText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y() {
        if (!this.Z) {
            this.W.deleteObserver(this);
            return false;
        }
        if (QLog.isColorLevel()) {
            if (this.Y == null) {
                QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
            } else {
                QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.Y.toString());
            }
        }
        TroopFeedsDataManager.f fVar = this.Y;
        if (fVar == null) {
            dismiss();
            return false;
        }
        if (!TextUtils.isEmpty(fVar.f294831i)) {
            this.R.setVisibility(0);
        }
        this.L.setText(X());
        this.P.setText(this.Y.f294837o + HardCodeUtil.qqStr(R.string.f172847uo2));
        this.N.setText(e0(this.Y.f294834l));
        if (this.Y.f294836n) {
            this.J.setVisibility(0);
            this.J.setOnClickListener(this);
            ReportController.o(this.V, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.X, "", "", "");
        } else {
            this.J.setVisibility(8);
        }
        if (this.Y.f294839q) {
            this.H.setText(R.string.w3q);
            this.I.setText(R.string.w3n);
            this.I.setContentDescription(this.C.getString(R.string.w3n));
        }
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        if (!TextUtils.isEmpty(this.Y.f294827e)) {
            m0(this.Y);
        }
        l0();
        if (AppSetting.f99565y) {
            FragmentActivity fragmentActivity = this.C;
            TroopFeedsDataManager.f fVar2 = this.Y;
            this.T = fragmentActivity.getString(R.string.esh, Html.fromHtml(this.Y.f294825c).toString(), fVar2.f294833k, f0(fVar2.f294834l, true, true, false), Html.fromHtml(this.Y.f294826d).toString());
        }
        TroopFeedsDataManager troopFeedsDataManager = this.W;
        if (troopFeedsDataManager == null || troopFeedsDataManager.f294800c != 1) {
            this.f96783e0.sendEmptyMessage(1001);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i3, boolean z16) {
        this.f96780b0 = z16;
        TroopFeedsDataManager.f fVar = this.Y;
        if (fVar != null) {
            fVar.f294823a = i3;
            boolean i16 = aw.i(this.V, this.X, fVar.f294840r);
            aw.m(this.V, this.X);
            if (QLog.isColorLevel()) {
                QLog.d("TroopTipsPopWindow", 2, "initViewInThread, isRead = " + i16 + ", mTroopNotify.isRead = " + this.Y.f294841s + ", mTroopNotify. mTroopNotify.isShowTipWindow = " + this.Y.f294838p + ", isRemindNotice = " + z16);
            }
            if (!this.Y.f294832j.equals(this.V.getCurrentUin())) {
                TroopFeedsDataManager.f fVar2 = this.Y;
                if ((fVar2.f294838p && !i16 && !fVar2.f294841s) || z16) {
                    i0();
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
                    }
                    this.f96783e0.post(new Runnable() { // from class: com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.5
                        @Override // java.lang.Runnable
                        public void run() {
                            TroopNewGuidePopWindow.this.Y();
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
        }
        aw.m(this.V, this.X);
    }

    private boolean c0() {
        if (!this.f96779a0 && !this.C.isFinishing() && !this.C.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        TroopInfo troopInfo;
        String str;
        int i3;
        TroopManager troopManager = (TroopManager) this.V.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopInfo = troopManager.k(this.X);
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            str = "";
        } else {
            str = "" + troopInfo.dwGroupClassExt;
        }
        int i16 = 2;
        if (troopInfo != null && troopInfo.isHomeworkTroop()) {
            QQAppInterface qQAppInterface = this.V;
            String str2 = this.X;
            eu.h(qQAppInterface, str2, "Grp_notice", "AioNotice_Show", 0, 0, str2, "", "", "");
        }
        QQAppInterface qQAppInterface2 = this.V;
        String str3 = this.X;
        if (this.Y.f294839q) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        String valueOf = String.valueOf(i3);
        if (!this.f96780b0) {
            i16 = 1;
        }
        ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, str3, str, valueOf, String.valueOf(i16));
    }

    public static String e0(long j3) {
        long currentTimeMillis;
        Date date = new Date(j3 * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        try {
            currentTimeMillis = NetConnInfoCenter.getServerTime();
        } catch (Exception unused) {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        Date date2 = new Date(currentTimeMillis * 1000);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
        if (calendar.get(1) == calendar2.get(1)) {
            return new SimpleDateFormat("M\u6708d\u65e5").format(date) + " " + simpleDateFormat.format(date);
        }
        return new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(date);
    }

    public static String f0(long j3, boolean z16, boolean z17, boolean z18) {
        long currentTimeMillis;
        Date date;
        Date date2 = new Date(j3 * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        try {
            currentTimeMillis = NetConnInfoCenter.getServerTime();
        } catch (Exception unused) {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        Date date3 = new Date(1000 * currentTimeMillis);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Date date4 = null;
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(date3));
            try {
                date4 = new Date(date.getTime() - 86400000);
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsPopWindow", 2, "get today failed! msg = " + e.getMessage());
                }
                return date == null ? "unknown" : "unknown";
            }
        } catch (Exception e17) {
            e = e17;
            date = null;
        }
        if (date == null && date4 != null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
            long j16 = currentTimeMillis - j3;
            if (j16 < 0) {
                j16 = 0;
            }
            if (j16 < 60) {
                return HardCodeUtil.qqStr(R.string.uo9);
            }
            if (j16 < 3600) {
                long j17 = (((float) j16) / ((float) 60)) + 0.5f;
                if (j17 == 0) {
                    j17 = 1;
                }
                return j17 + HardCodeUtil.qqStr(R.string.f172849uo4);
            }
            if (j16 < 86400) {
                if (date2.getDate() != date.getDate()) {
                    if (z16) {
                        return HardCodeUtil.qqStr(R.string.uo5) + " " + simpleDateFormat2.format(date2);
                    }
                    return HardCodeUtil.qqStr(R.string.uo7);
                }
                if (z18) {
                    return HardCodeUtil.qqStr(R.string.uo8) + simpleDateFormat2.format(date2);
                }
                return ((long) ((((float) j16) / ((float) 3600)) + 0.5d)) + HardCodeUtil.qqStr(R.string.uo6);
            }
            if (z17 && j16 < 259200 && date4.getTime() - date2.getTime() <= 86400000) {
                if (z16) {
                    return HardCodeUtil.qqStr(R.string.f172845uo0) + " " + simpleDateFormat2.format(date2);
                }
                return HardCodeUtil.qqStr(R.string.f172848uo3);
            }
            if (j16 < 172800 && date.getTime() - date2.getTime() <= 86400000) {
                if (z16) {
                    return HardCodeUtil.qqStr(R.string.f172846uo1) + " " + simpleDateFormat2.format(date2);
                }
                return HardCodeUtil.qqStr(R.string.uoa);
            }
            if (calendar.get(1) == calendar2.get(1)) {
                SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM-dd");
                if (z16) {
                    return simpleDateFormat3.format(date2) + " " + simpleDateFormat2.format(date2);
                }
                return simpleDateFormat3.format(date2);
            }
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(date2);
        }
    }

    private void i0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.troop.feeds.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopNewGuidePopWindow.this.d0();
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.width = U();
        this.D.setLayoutParams(layoutParams);
        this.D.addOnLayoutChangeListener(new e());
    }

    public static void k0(final String str) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URL url = new URL(str);
                    String hostAddress = InetAddress.getByName(url.getHost()).getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP).encodeString("qbiz_host_ip_map" + url.getHost(), hostAddress);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }, 5, null, false);
    }

    private void l0() {
        BounceScrollView bounceScrollView;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable") && AppSetting.f99565y && (bounceScrollView = this.S) != null) {
            ViewCompat.setAccessibilityDelegate(bounceScrollView, new c());
        }
    }

    private void m0(TroopFeedsDataManager.f fVar) {
        int i3;
        int U = U();
        int dpToPx = ViewUtils.dpToPx(25.0f);
        int width = this.E.getWidth();
        if (width <= 0) {
            width = U - (dpToPx * 2);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        int i16 = fVar.f294828f;
        if (i16 > 0 && (i3 = fVar.f294829g) > 0) {
            int i17 = (int) (width * (i3 / i16));
            layoutParams.height = i17;
            obtain.mRequestWidth = width;
            obtain.mRequestHeight = i17;
        } else {
            layoutParams.height = -2;
            obtain.mRequestWidth = (int) (this.C.getResources().getDisplayMetrics().widthPixels - al.a(this.C, 60.0f));
            obtain.mRequestHeight = (int) al.a(this.C, 150.0f);
        }
        this.E.setLayoutParams(layoutParams);
        String str = fVar.f294827e;
        if (!TextUtils.isEmpty(str)) {
            this.U = true;
            this.K.setVisibility(0);
            this.E.setVisibility(0);
            try {
                URL url = new URL(str);
                String W = W(url.getHost());
                if (!TextUtils.isEmpty(W)) {
                    str = new URL("http", W, url.getFile()).toString();
                }
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
            }
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable.getStatus() != 1) {
                drawable.setURLDrawableListener(new d());
            }
            this.K.setImageDrawable(drawable);
            this.K.setContentDescription(this.C.getString(R.string.esd));
        }
    }

    public boolean Z() {
        try {
            View inflate = LayoutInflater.from(this.C).inflate(R.layout.ak6, (ViewGroup) null);
            this.D = inflate;
            this.F = inflate.findViewById(R.id.b9w);
            View findViewById = this.D.findViewById(R.id.jp7);
            this.G = findViewById;
            findViewById.setOnClickListener(this);
            BounceScrollView bounceScrollView = (BounceScrollView) this.D.findViewById(R.id.ii_);
            this.S = bounceScrollView;
            bounceScrollView.setOverScrollMode(2);
            this.H = (TextView) this.D.findViewById(R.id.h4o);
            this.I = (Button) this.D.findViewById(R.id.az7);
            this.J = (Button) this.D.findViewById(R.id.eym);
            ImageView imageView = (ImageView) this.D.findViewById(R.id.jmf);
            this.K = imageView;
            imageView.setOnClickListener(this);
            TextView textView = (TextView) this.D.findViewById(R.id.jma);
            this.L = textView;
            textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
            this.L.setMovementMethod(LinkMovementMethod.getInstance());
            this.L.setOnClickListener(this);
            this.Q = (LinearLayout) this.D.findViewById(R.id.dlj);
            this.M = (TextView) this.D.findViewById(R.id.dll);
            this.N = (TextView) this.D.findViewById(R.id.dlp);
            this.P = (TextView) this.D.findViewById(R.id.dlk);
            this.I.setOnClickListener(this);
            this.I.setContentDescription(this.C.getString(R.string.w3o));
            ImageView imageView2 = (ImageView) this.D.findViewById(R.id.ksh);
            this.R = imageView2;
            imageView2.setOnClickListener(this);
            this.E = this.D.findViewById(R.id.f165782dh4);
            setContentView(this.D);
            setCancelable(true);
            setCanceledOnTouchOutside(false);
            return true;
        } catch (InflateException e16) {
            hide();
            QLog.e("TroopTipsPopWindow", 1, "InflateException, " + e16.toString());
            return false;
        }
    }

    public void b0(JSONObject jSONObject, int i3, boolean z16) {
        ThreadManagerV2.post(new AnonymousClass4(jSONObject, i3, z16), 8, null, true);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        TroopFeedsDataManager troopFeedsDataManager = this.W;
        if (troopFeedsDataManager != null) {
            troopFeedsDataManager.deleteObserver(this);
        }
        super.dismiss();
        this.f96779a0 = true;
        this.C.unregisterComponentCallbacks(this);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (AppSetting.f99565y && !TextUtils.isEmpty(this.T) && !this.f96782d0) {
            com.tencent.mobileqq.util.c.a(this.D, this.T);
            this.f96782d0 = true;
        }
        return true;
    }

    void g0(String str) {
        ReportController.o(this.V, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", str, 0, 0, this.X, "" + this.Y.f294823a, "", "");
    }

    public void n0(as asVar) {
        if (this.Z && this.W != null) {
            if (asVar == null) {
                QLog.e("TroopTipsPopWindow", 1, "show. GET_NOR_NOTICE, msg = null");
                return;
            }
            QLog.d("TroopTipsPopWindow", 1, "showTroopNotice type=" + asVar.f302082b);
            int i3 = asVar.f302082b;
            if (i3 == 1) {
                this.W.addObserver(this);
                this.W.l(1007, asVar.f302081a);
                return;
            } else if (i3 == 2) {
                this.W.addObserver(this);
                this.W.n(1003);
                return;
            } else {
                this.W.addObserver(this);
                this.W.n(1004);
                return;
            }
        }
        QLog.e("TroopTipsPopWindow", 1, "showTroopNotice error: isInit=" + this.Z);
    }

    void o0() {
        if (c0()) {
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.setFlags(512, 512);
        }
        j0();
        if (!c0()) {
            show();
        }
        g0("exp_bulletin");
        if (this.Y.f294823a == 2) {
            ReportController.o(this.V, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.X, "", "", "");
        }
        if (!TextUtils.isEmpty(this.Y.f294831i)) {
            g0("exp_vid");
        } else if (!TextUtils.isEmpty(this.Y.f294827e)) {
            g0("exp_pic");
        }
        try {
            QQText qQText = (QQText) this.L.getText();
            LinkSpan[] linkSpanArr = (LinkSpan[]) qQText.getSpans(0, qQText.length(), LinkSpan.class);
            if (linkSpanArr != null && linkSpanArr.length != 0) {
                g0("exp_link");
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i3 = 2;
        String str2 = "";
        if (id5 == R.id.eym) {
            TroopManager troopManager = (TroopManager) this.V.getManager(QQManagerFactory.TROOP_MANAGER);
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(this.X, this.V.getCurrentUin(), this.C, "TroopTipsPopWindow");
            if (troopMemberInfoSync == null || (str = troopMemberInfoSync.troopColorNick) == null) {
                str = "";
            }
            TroopInfo k3 = troopManager.k(this.X);
            if (k3 != null) {
                str2 = "" + k3.dwGroupClassExt;
            }
            String str3 = str2;
            Intent intent = new Intent();
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 5);
            intent.putExtra("edit_mode", 0);
            intent.putExtra("title", getContext().getResources().getString(R.string.eqr));
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
            if (troopMemberInfoSync != null) {
                intent.putExtra("default_nick_id", troopMemberInfoSync.troopColorNickId);
            }
            intent.putExtra("troopUin", this.X);
            intent.putExtra("uin", this.V.getAccount());
            intent.putExtra("max_num", 60);
            intent.putExtra("from", 0);
            RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY);
            ReportController.o(this.V, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.X, "", "", "");
            QQAppInterface qQAppInterface = this.V;
            String str4 = this.X;
            if (!this.Y.f294839q) {
                i3 = 1;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, str4, str3, String.valueOf(i3), "");
            dismiss();
        } else if (id5 != R.id.jma && id5 != R.id.az7 && id5 != R.id.jp7 && id5 != R.id.jmf) {
            if (id5 == R.id.ksh) {
                if (!TextUtils.isEmpty(this.Y.f294831i)) {
                    Intent intent2 = new Intent(this.C, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("url", this.Y.f294831i);
                    intent2.putExtra("webStyle", "noBottomBar");
                    this.C.startActivity(intent2);
                    g0("clk_vid");
                } else if (!TextUtils.isEmpty(this.Y.f294830h)) {
                    ArrayList arrayList = new ArrayList();
                    String str5 = this.Y.f294830h;
                    try {
                        URL url = new URL(str5);
                        String W = W(url.getHost());
                        if (!TextUtils.isEmpty(W)) {
                            str5 = new URL("http", W, url.getFile()).toString();
                        }
                    } catch (MalformedURLException e16) {
                        e16.printStackTrace();
                    }
                    arrayList.add(str5);
                    TroopNoticeJsHandler.w(this.C, 0, arrayList, true, "", -1);
                    g0("clk_pic");
                }
            }
        } else {
            Intent intent3 = new Intent(this.C, (Class<?>) QQBrowserActivity.class);
            TroopInfo k16 = ((TroopManager) this.V.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.X);
            String currentAccountUin = this.V.getCurrentAccountUin();
            if (k16 != null && currentAccountUin != null) {
                str2 = "" + k16.dwGroupClassExt;
            }
            String str6 = str2;
            intent3.putExtra("url", "https://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=" + this.Y.f294840r + "&gc=" + this.X);
            intent3.putExtra("webStyle", "noBottomBar");
            intent3.putExtra("startOpenPageTime", System.currentTimeMillis());
            this.C.startActivity(intent3);
            g0("clk_history");
            if (this.Y.f294839q) {
                QQAppInterface qQAppInterface2 = this.V;
                String str7 = this.X;
                if (!this.f96780b0) {
                    i3 = 1;
                }
                ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, str7, str6, "", String.valueOf(i3));
            } else {
                ReportController.o(this.V, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.X, str6, "", "");
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.D.post(new Runnable() { // from class: com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.10
            @Override // java.lang.Runnable
            public void run() {
                TroopNewGuidePopWindow.this.j0();
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        this.C.registerComponentCallbacks(this);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        TroopFeedsDataManager troopFeedsDataManager = this.W;
        if (troopFeedsDataManager != null) {
            troopFeedsDataManager.deleteObserver(this);
        }
        if (!c0() && (obj instanceof Integer)) {
            Integer num = (Integer) obj;
            if (QLog.isColorLevel()) {
                QLog.d("TroopTipsPopWindow", 2, "update, notifyType = " + num);
            }
            if (num.intValue() == 106) {
                TroopFeedsDataManager troopFeedsDataManager2 = this.W;
                if (troopFeedsDataManager2 != null && (jSONObject3 = troopFeedsDataManager2.f294798a) != null) {
                    b0(jSONObject3, 2, false);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
                        return;
                    }
                    return;
                }
            }
            if (num.intValue() == 1007) {
                TroopFeedsDataManager troopFeedsDataManager3 = this.W;
                if (troopFeedsDataManager3 != null && (jSONObject2 = troopFeedsDataManager3.f294799b) != null) {
                    b0(jSONObject2, 1, false);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
                        return;
                    }
                    return;
                }
            }
            if (num.intValue() == 1011) {
                TroopFeedsDataManager troopFeedsDataManager4 = this.W;
                if (troopFeedsDataManager4 != null && (jSONObject = troopFeedsDataManager4.f294799b) != null) {
                    b0(jSONObject, 1, true);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
                        return;
                    }
                    return;
                }
            }
            if (num.intValue() == 1012) {
                aw.m(this.V, this.X);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements URLDrawable.URLDrawableListener {
        d() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d("TroopTipsPopWindow", 1, "onLoadCanceled");
            TroopNewGuidePopWindow.this.K.setVisibility(8);
            TroopNewGuidePopWindow.this.U = false;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d("TroopTipsPopWindow", 1, "onLoadFialed: ", th5);
            TroopNewGuidePopWindow.this.K.setVisibility(8);
            TroopNewGuidePopWindow.this.U = false;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            TroopNewGuidePopWindow.this.K.setImageDrawable(null);
            TroopNewGuidePopWindow.this.K.setImageDrawable(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
