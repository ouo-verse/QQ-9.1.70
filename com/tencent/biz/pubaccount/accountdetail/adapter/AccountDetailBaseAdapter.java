package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.model.b;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailBaseAdapter extends BaseAdapter implements View.OnClickListener, b.InterfaceC0800b {
    private static int M0 = 10;
    private static int N0 = 20;
    private int A0;
    private boolean B0;
    final int C;
    private AccountDetailTopGestureLayout C0;
    final int D;
    private MqqHandler D0;
    final int E;
    private ArrayList<zx.b> E0;
    final int F;
    private ArrayList<zx.b> F0;
    final int G;
    private ArrayList<IPublicAccountConfigAttr> G0;
    final int H;
    private ArrayList<IPublicAccountConfigAttr> H0;
    final int I;
    private AbsListView.OnScrollListener I0;
    final int J;
    private URLDrawableDownListener.Adapter J0;
    private LayoutInflater K;
    private q K0;
    String L;
    private long L0;
    String M;
    PublicAccountDetailImpl N;
    View P;
    EqqDetail Q;
    boolean R;
    boolean S;
    QQAppInterface T;
    Context U;
    Activity V;
    ay.a W;
    boolean X;
    View Y;
    Drawable Z;

    /* renamed from: a0, reason: collision with root package name */
    Drawable f78861a0;

    /* renamed from: b0, reason: collision with root package name */
    Drawable f78862b0;

    /* renamed from: c0, reason: collision with root package name */
    public Button f78863c0;

    /* renamed from: d, reason: collision with root package name */
    final int f78864d;

    /* renamed from: d0, reason: collision with root package name */
    AccountDetailXListView f78865d0;

    /* renamed from: e, reason: collision with root package name */
    final int f78866e;

    /* renamed from: e0, reason: collision with root package name */
    AccountDetailGroupListContainer f78867e0;

    /* renamed from: f, reason: collision with root package name */
    final int f78868f;

    /* renamed from: f0, reason: collision with root package name */
    public ImageView f78869f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageView f78870g0;

    /* renamed from: h, reason: collision with root package name */
    final int f78871h;

    /* renamed from: h0, reason: collision with root package name */
    public ImageView f78872h0;

    /* renamed from: i, reason: collision with root package name */
    final int f78873i;

    /* renamed from: i0, reason: collision with root package name */
    public Button f78874i0;

    /* renamed from: j0, reason: collision with root package name */
    float f78875j0;

    /* renamed from: k0, reason: collision with root package name */
    int f78876k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f78877l0;

    /* renamed from: m, reason: collision with root package name */
    final int f78878m;

    /* renamed from: m0, reason: collision with root package name */
    private int f78879m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f78880n0;

    /* renamed from: o0, reason: collision with root package name */
    int f78881o0;

    /* renamed from: p0, reason: collision with root package name */
    int f78882p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f78883q0;

    /* renamed from: r0, reason: collision with root package name */
    com.tencent.biz.pubaccount.accountdetail.model.b f78884r0;

    /* renamed from: s0, reason: collision with root package name */
    m f78885s0;

    /* renamed from: t0, reason: collision with root package name */
    protected TranslateAnimation f78886t0;

    /* renamed from: u0, reason: collision with root package name */
    protected TranslateAnimation f78887u0;

    /* renamed from: v0, reason: collision with root package name */
    protected AnimatorSet f78888v0;

    /* renamed from: w0, reason: collision with root package name */
    private Handler f78889w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f78890x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f78891y0;

    /* renamed from: z0, reason: collision with root package name */
    boolean f78892z0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            ((PublicAccountDetailActivityImpl) AccountDetailBaseAdapter.this.V).gotoMoreInfoActivity();
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            String str2 = accountDetailBaseAdapter.L;
            if (accountDetailBaseAdapter.N.followType == 1) {
                str = "02";
            } else {
                str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007CA4", "0X8007CA4", 0, 0, str, String.valueOf(accountDetailBaseAdapter.A0), "", "", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            accountDetailBaseAdapter.F(accountDetailBaseAdapter.r());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            ((PublicAccountDetailActivityImpl) AccountDetailBaseAdapter.this.V).gotoMoreInfoActivity();
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            String str2 = accountDetailBaseAdapter.L;
            if (accountDetailBaseAdapter.N.followType == 1) {
                str = "02";
            } else {
                str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007CA4", "0X8007CA4", 0, 0, str, String.valueOf(accountDetailBaseAdapter.A0), "", "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f78915d;

        g(l lVar) {
            this.f78915d = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f78915d.f78933a.setText(R.string.d6p);
            this.f78915d.f78935c.setVisibility(4);
            this.f78915d.f78934b.setVisibility(4);
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            com.tencent.biz.pubaccount.accountdetail.model.a.c(accountDetailBaseAdapter.T, Long.parseLong(accountDetailBaseAdapter.L), ((PublicAccountDetailActivityImpl) AccountDetailBaseAdapter.this.V).getPublicAccountObserver());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78917d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78918e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ zx.b f78919f;

        h(int i3, String str, zx.b bVar) {
            this.f78917d = i3;
            this.f78918e = str;
            this.f78919f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ay.a aVar;
            String str;
            ay.a aVar2;
            int i3 = this.f78917d;
            if (i3 == 1) {
                if (!TextUtils.isEmpty(this.f78918e) && (aVar2 = AccountDetailBaseAdapter.this.W) != null) {
                    aVar2.e(this.f78918e);
                }
            } else if (i3 == 2 && (aVar = AccountDetailBaseAdapter.this.W) != null) {
                aVar.f(this.f78919f);
            }
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            ReportController.o(accountDetailBaseAdapter.T, "dc00899", IPublicAccountHandler.MAIN_ACTION, accountDetailBaseAdapter.L, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.f78919f.f453630d.f453634a), String.valueOf(this.f78919f.f453630d.f453640g), String.valueOf(this.f78919f.f453630d.f453637d), String.valueOf(this.f78919f.f453630d.f453638e));
            JSONObject jSONObject = new JSONObject();
            if (AccountDetailBaseAdapter.this.R) {
                return;
            }
            try {
                jSONObject.put("cha_1", this.f78919f.f453630d.f453641h);
                jSONObject.put("cha_2", AccountDetailBaseAdapter.this.A0);
                AccountDetailBaseAdapter accountDetailBaseAdapter2 = AccountDetailBaseAdapter.this;
                QQAppInterface qQAppInterface = accountDetailBaseAdapter2.T;
                String str2 = accountDetailBaseAdapter2.L;
                String valueOf = String.valueOf(this.f78919f.f453630d.f453637d);
                String valueOf2 = String.valueOf(this.f78919f.f453630d.f453634a);
                if (AccountDetailBaseAdapter.this.N.followType == 1) {
                    str = "02";
                } else {
                    str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
                }
                ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str2, "0X80077FA", "0X80077FA", 0, 0, valueOf, valueOf2, str, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements AccountDetailXListView.a {
        j() {
        }

        @Override // com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView.a
        public void a(int i3) {
            if (AccountDetailBaseAdapter.this.f78865d0.getFirstVisiblePosition() == 0) {
                AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
                if (accountDetailBaseAdapter.S) {
                    int i16 = -accountDetailBaseAdapter.r();
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountDetailBaseAdapter", 2, "onEndScroll scrollY = " + i16 + " ,isScrollUp = " + AccountDetailBaseAdapter.this.f78890x0);
                    }
                    AccountDetailBaseAdapter accountDetailBaseAdapter2 = AccountDetailBaseAdapter.this;
                    float f16 = accountDetailBaseAdapter2.f78875j0 * 150.0f;
                    if (i16 != 0) {
                        if (accountDetailBaseAdapter2.f78890x0) {
                            if (i16 > f16) {
                                accountDetailBaseAdapter2.F(i16);
                                return;
                            } else {
                                accountDetailBaseAdapter2.E();
                                return;
                            }
                        }
                        if (i16 > accountDetailBaseAdapter2.f78882p0 - f16) {
                            accountDetailBaseAdapter2.F(i16);
                        } else {
                            accountDetailBaseAdapter2.E();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class k {

        /* renamed from: a, reason: collision with root package name */
        URLImageView f78925a;

        /* renamed from: b, reason: collision with root package name */
        TextView f78926b;

        /* renamed from: c, reason: collision with root package name */
        TextView f78927c;

        /* renamed from: d, reason: collision with root package name */
        TextView f78928d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f78929e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f78930f;

        /* renamed from: g, reason: collision with root package name */
        boolean f78931g;

        k() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class l {

        /* renamed from: a, reason: collision with root package name */
        TextView f78933a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f78934b;

        /* renamed from: c, reason: collision with root package name */
        TextView f78935c;

        l() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class m {

        /* renamed from: a, reason: collision with root package name */
        URLImageView f78937a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f78938b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f78939c;

        /* renamed from: d, reason: collision with root package name */
        TextView f78940d;

        /* renamed from: e, reason: collision with root package name */
        TextView f78941e;

        /* renamed from: f, reason: collision with root package name */
        Button f78942f;

        /* renamed from: g, reason: collision with root package name */
        View f78943g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f78944h;

        /* renamed from: i, reason: collision with root package name */
        ImageView f78945i;

        /* renamed from: j, reason: collision with root package name */
        FrameLayout f78946j;

        /* renamed from: k, reason: collision with root package name */
        ImageView f78947k;

        /* renamed from: l, reason: collision with root package name */
        TextView f78948l;

        public m() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class n {

        /* renamed from: a, reason: collision with root package name */
        TextView f78950a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f78951b;

        /* renamed from: c, reason: collision with root package name */
        TextView f78952c;

        n() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class o {

        /* renamed from: a, reason: collision with root package name */
        PublicAccountMenuBar f78954a;

        o() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class p {

        /* renamed from: a, reason: collision with root package name */
        View f78956a;

        /* renamed from: b, reason: collision with root package name */
        View f78957b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f78958c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f78959d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f78960e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f78961f;

        /* renamed from: g, reason: collision with root package name */
        TextView f78962g;

        /* renamed from: h, reason: collision with root package name */
        TextView f78963h;

        /* renamed from: i, reason: collision with root package name */
        TextView f78964i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f78965j;

        /* renamed from: k, reason: collision with root package name */
        TextView f78966k;

        /* renamed from: l, reason: collision with root package name */
        View f78967l;

        /* renamed from: m, reason: collision with root package name */
        View f78968m;

        p() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface q {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class r {

        /* renamed from: a, reason: collision with root package name */
        public URL f78970a;

        /* renamed from: b, reason: collision with root package name */
        public Pair<Integer, Integer> f78971b;

        r() {
        }

        public static r a(URL url, Pair<Integer, Integer> pair) {
            r rVar = new r();
            rVar.f78970a = url;
            rVar.f78971b = pair;
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class s {

        /* renamed from: a, reason: collision with root package name */
        ImageView f78972a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f78973b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f78974c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f78975d;

        /* renamed from: e, reason: collision with root package name */
        TextView f78976e;

        /* renamed from: f, reason: collision with root package name */
        TextView f78977f;

        /* renamed from: g, reason: collision with root package name */
        TextView f78978g;

        /* renamed from: h, reason: collision with root package name */
        Button f78979h;

        s() {
        }
    }

    public AccountDetailBaseAdapter(QQAppInterface qQAppInterface, Context context, PublicAccountDetailImpl publicAccountDetailImpl, String str, boolean z16, AccountDetailXListView accountDetailXListView, AccountDetailTopGestureLayout accountDetailTopGestureLayout) {
        this.f78864d = -1;
        this.f78866e = 0;
        this.f78868f = 1;
        this.f78871h = 2;
        this.f78873i = 3;
        this.f78878m = 4;
        this.C = 5;
        this.D = 6;
        this.E = 7;
        this.F = 8;
        this.G = 9;
        this.H = 10;
        this.I = 11;
        this.J = 13;
        this.R = false;
        this.S = false;
        this.X = false;
        this.f78877l0 = false;
        this.f78879m0 = PublicAccountDetailActivityImpl.NETWORK_UNKNOW;
        this.f78880n0 = true;
        this.f78881o0 = 0;
        this.f78882p0 = 0;
        this.f78883q0 = true;
        this.f78885s0 = null;
        this.f78889w0 = null;
        this.f78890x0 = false;
        this.f78891y0 = false;
        this.f78892z0 = false;
        this.A0 = 1;
        this.B0 = false;
        this.D0 = new MqqHandler(Looper.getMainLooper());
        this.E0 = new ArrayList<>();
        this.F0 = new ArrayList<>();
        this.G0 = new ArrayList<>();
        this.H0 = new ArrayList<>();
        this.I0 = new i();
        this.J0 = new c();
        this.L0 = 0L;
        this.T = qQAppInterface;
        this.K = LayoutInflater.from(context);
        this.U = context;
        this.V = (Activity) context;
        this.N = publicAccountDetailImpl;
        if (publicAccountDetailImpl != null) {
            this.A0 = PublicAccountDetailImpl.getReportAccountType(qQAppInterface, str, publicAccountDetailImpl);
        }
        this.X = z16;
        this.L = str;
        this.M = qQAppInterface.getCurrentUin();
        this.f78889w0 = new Handler();
        this.f78865d0 = accountDetailXListView;
        this.f78875j0 = accountDetailXListView.getResources().getDisplayMetrics().density;
        this.f78882p0 = ((PublicAccountDetailActivityImpl) this.V).getAccurateScreenDpi()[1];
        this.f78876k0 = ((PublicAccountDetailActivityImpl) this.V).getAccurateScreenDpi()[0];
        h();
        if (z16) {
            this.W = new ay.a(qQAppInterface, context, publicAccountDetailImpl);
            zx.a aVar = (zx.a) ((IPublicAccountDetailDynamicDataManagerService) qQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(str);
            if (aVar != null) {
                e0(aVar.c(), aVar.f453624d);
                c0(aVar.b());
            }
            PublicAccountDetailImpl publicAccountDetailImpl2 = this.N;
            if (publicAccountDetailImpl2 != null && publicAccountDetailImpl2.cardStyle == 1) {
                this.S = true;
                f0();
            }
            d0();
            boolean z17 = z();
            this.f78877l0 = z17;
            this.f78865d0.j0(!z17);
        }
        this.C0 = accountDetailTopGestureLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "prefetch data");
        }
        q qVar = this.K0;
        if (qVar != null) {
            qVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i3, final int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "preloadImg start:" + i3 + " count:" + i16);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (NetworkUtil.isWifiConnected(this.U)) {
            final ArrayList arrayList = new ArrayList(this.E0);
            final long j3 = this.L0;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.14
                @Override // java.lang.Runnable
                public void run() {
                    if (AccountDetailBaseAdapter.this.L0 != j3) {
                        return;
                    }
                    List list = arrayList;
                    int size = list == null ? 0 : list.size();
                    LinkedList<r> linkedList = new LinkedList();
                    for (int i17 = i3; i17 < i3 + i16; i17++) {
                        if (i17 < size && i17 >= 0) {
                            if (AccountDetailBaseAdapter.this.L0 != j3) {
                                return;
                            }
                            try {
                                zx.b bVar = (zx.b) arrayList.get(i17);
                                if (bVar != null) {
                                    if (bVar.f453630d.f453637d == 2) {
                                        zx.e eVar = bVar.f453632f;
                                        if (eVar != null) {
                                            if (eVar.f453652h == 1) {
                                                linkedList.add(r.a(new URL(bVar.f453632f.f453653i), ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
                                            } else {
                                                linkedList.add(r.a(new URL(bVar.f453632f.f453646b), ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
                                            }
                                        }
                                    } else {
                                        zx.d dVar = bVar.f453631e;
                                        if (dVar != null) {
                                            if (dVar.f453643b == 1) {
                                                linkedList.add(r.a(new URL(bVar.f453631e.f453644c), ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsBigPictureSize()));
                                            } else {
                                                linkedList.add(r.a(new URL(bVar.f453631e.f453642a), ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getReadinjoyFeedsSmallPictureSize()));
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                if (AccountDetailBaseAdapter.this.L0 != j3) {
                                    return;
                                }
                            }
                        }
                    }
                    if (AccountDetailBaseAdapter.this.L0 != j3) {
                        return;
                    }
                    for (r rVar : linkedList) {
                        if (rVar != null && rVar.f78970a != null) {
                            com.tencent.mobileqq.kandian.base.image.b bVar2 = new com.tencent.mobileqq.kandian.base.image.b();
                            bVar2.f239004a = rVar.f78970a;
                            bVar2.f239005b = ((Integer) rVar.f78971b.first).intValue();
                            bVar2.f239006c = ((Integer) rVar.f78971b.second).intValue();
                            ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar2, null);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountDetailBaseAdapter", 2, "preloadImg size:" + linkedList.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 5, null, true);
        }
    }

    private String C(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view, View view2, long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "runShowAnimation");
        }
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view2.setAlpha(0.0f);
        view2.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        ofFloat.setDuration(JoinTimeType.THIRTY_MINUTES);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setStartDelay(j3);
        ofFloat2.setDuration(JoinTimeType.THIRTY_MINUTES);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ofFloat2.setStartDelay(j16);
        if (this.f78888v0 == null) {
            this.f78888v0 = new AnimatorSet();
        }
        this.f78888v0.playTogether(ofFloat, ofFloat2);
        this.f78888v0.start();
    }

    private void b0() {
        m mVar = this.f78885s0;
        if (mVar == null || mVar.f78943g.getVisibility() == 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "startShowArrowAnimation");
        }
        TranslateAnimation translateAnimation = this.f78886t0;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        TranslateAnimation translateAnimation2 = this.f78887u0;
        if (translateAnimation2 != null) {
            translateAnimation2.cancel();
        }
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -0.2f);
        this.f78886t0 = translateAnimation3;
        translateAnimation3.setDuration(200L);
        this.f78886t0.setFillAfter(true);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.2f, 1, 0.0f);
        this.f78887u0 = translateAnimation4;
        translateAnimation4.setDuration(300L);
        this.f78887u0.setFillAfter(true);
        this.f78886t0.setAnimationListener(new a());
        this.f78887u0.setAnimationListener(new b());
        this.f78885s0.f78943g.startAnimation(this.f78886t0);
    }

    private void d0() {
        List<IPublicAccountConfigAttr> list;
        this.G0.clear();
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        if (publicAccountDetailImpl == null || (list = publicAccountDetailImpl.customConfigAttrs) == null || list.size() <= 0) {
            return;
        }
        for (IPublicAccountConfigAttr iPublicAccountConfigAttr : this.N.customConfigAttrs) {
            int type = iPublicAccountConfigAttr.getType();
            if (type == 2 || type == 3 || type == 4) {
                if (l(iPublicAccountConfigAttr)) {
                    this.G0.add(iPublicAccountConfigAttr);
                }
            }
        }
    }

    private void f0() {
        List<IPublicAccountConfigAttr> list;
        this.H0.clear();
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        if (publicAccountDetailImpl == null || (list = publicAccountDetailImpl.fullscreenConfigAttrs) == null || list.size() <= 0) {
            return;
        }
        for (IPublicAccountConfigAttr iPublicAccountConfigAttr : this.N.fullscreenConfigAttrs) {
            int type = iPublicAccountConfigAttr.getType();
            if (type == 5 || type == 6 || type == 7) {
                if (k(iPublicAccountConfigAttr)) {
                    this.H0.add(iPublicAccountConfigAttr);
                }
            }
        }
    }

    private void i() {
        m mVar = this.f78885s0;
        if (mVar == null) {
            return;
        }
        if (mVar.f78943g.getAnimation() != null) {
            this.f78885s0.f78943g.getAnimation().setAnimationListener(null);
            this.f78885s0.f78943g.getAnimation().cancel();
            this.f78885s0.f78943g.clearAnimation();
        }
        TranslateAnimation translateAnimation = this.f78886t0;
        if (translateAnimation != null) {
            translateAnimation.setAnimationListener(null);
            this.f78886t0.cancel();
            this.f78886t0 = null;
        }
        TranslateAnimation translateAnimation2 = this.f78887u0;
        if (translateAnimation2 != null) {
            translateAnimation2.setAnimationListener(null);
            this.f78887u0.cancel();
            this.f78887u0 = null;
        }
        AnimatorSet animatorSet = this.f78888v0;
        if (animatorSet != null) {
            Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                next.end();
                next.cancel();
            }
            this.f78888v0.end();
            this.f78888v0.cancel();
        }
        this.f78888v0 = null;
    }

    private boolean k(IPublicAccountConfigAttr iPublicAccountConfigAttr) {
        ArrayList arrayList = new ArrayList();
        if (iPublicAccountConfigAttr != null && iPublicAccountConfigAttr.getConfigs() != null) {
            for (IPublicAccountConfigAttr.a aVar : iPublicAccountConfigAttr.getConfigs()) {
                int type = iPublicAccountConfigAttr.getType();
                if (type != 5 && type != 6) {
                    if (type == 7 && !TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79346r)) {
                        arrayList.add(aVar);
                    }
                } else if (!TextUtils.isEmpty(aVar.f79339k)) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList.size() != 0;
    }

    private boolean l(IPublicAccountConfigAttr iPublicAccountConfigAttr) {
        ArrayList arrayList = new ArrayList();
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        int i3 = publicAccountDetailImpl != null ? publicAccountDetailImpl.followType : -1;
        if (iPublicAccountConfigAttr != null && iPublicAccountConfigAttr.getConfigs() != null) {
            for (IPublicAccountConfigAttr.a aVar : iPublicAccountConfigAttr.getConfigs()) {
                int i16 = aVar.f79332d;
                if (i16 == 0 || (i16 == 1 && i3 == 1)) {
                    int type = iPublicAccountConfigAttr.getType();
                    if (type != 2) {
                        if (type == 3 || type == 4) {
                            if (aVar.f79333e == 23) {
                                if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79330b) && !TextUtils.isEmpty(aVar.f79331c)) {
                                    arrayList.add(aVar);
                                }
                            } else if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79330b)) {
                                arrayList.add(aVar);
                            }
                        }
                    } else if (aVar.f79333e == 23) {
                        if (!TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(aVar.f79331c)) {
                            arrayList.add(aVar);
                        }
                    } else if (!TextUtils.isEmpty(aVar.f79339k)) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        if (iPublicAccountConfigAttr != null && iPublicAccountConfigAttr.getType() == 4 && arrayList.size() % 2 != 0) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList.size() != 0;
    }

    private int q() {
        Resources resources = this.V.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    private boolean x() {
        return false;
    }

    void E() {
        this.f78865d0.smoothScrollToPosition(0);
        u();
    }

    void F(int i3) {
        PublicAccountDetailImpl publicAccountDetailImpl;
        this.f78865d0.smoothScrollBy((this.f78882p0 - i3) - this.P.getHeight(), 500);
        a0();
        if (!this.X || (publicAccountDetailImpl = this.N) == null || publicAccountDetailImpl.followType == 1) {
            return;
        }
        l0(i3);
    }

    public void G(PublicAccountDetailImpl publicAccountDetailImpl) {
        this.N = publicAccountDetailImpl;
        if (this.X) {
            this.W = new ay.a(this.T, this.U, publicAccountDetailImpl);
            d0();
            if (publicAccountDetailImpl.cardStyle == 1) {
                Q(true);
            } else {
                Q(false);
            }
        }
    }

    void I(m mVar) {
        List<IPublicAccountConfigAttr.a> list;
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        if (publicAccountDetailImpl == null) {
            return;
        }
        this.f78885s0 = mVar;
        int length = publicAccountDetailImpl.name.length();
        if (length > 8 && length < 13) {
            mVar.f78940d.setTextSize(2, 20.0f);
        }
        mVar.f78940d.setText(this.N.name);
        if (this.N.certifiedGrade != 0) {
            mVar.f78939c.setVisibility(0);
        } else {
            mVar.f78939c.setVisibility(8);
        }
        if (this.X) {
            mVar.f78941e.setVisibility(0);
            mVar.f78941e.setText(this.N.summary.trim());
        }
        mVar.f78938b.setImageDrawable(this.f78862b0);
        if (this.N.followType == 1) {
            if (this.f78892z0) {
                mVar.f78942f.setVisibility(0);
                mVar.f78942f.setText((CharSequence) null);
                mVar.f78942f.setBackgroundResource(R.drawable.byt);
            } else {
                mVar.f78942f.setVisibility(8);
            }
            this.f78874i0.setText(R.string.d7i);
        } else {
            mVar.f78942f.setVisibility(0);
            mVar.f78942f.setText(this.U.getResources().getString(R.string.d5m));
            this.f78874i0.setText(R.string.d7j);
        }
        PublicAccountConfigAttrImpl publicAccountConfigAttrImpl = (PublicAccountConfigAttrImpl) getItem(0);
        if (publicAccountConfigAttrImpl == null || (list = publicAccountConfigAttrImpl.configs) == null || list.size() == 0) {
            return;
        }
        String str = publicAccountConfigAttrImpl.configs.get(0).f79339k;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        if (publicAccountConfigAttrImpl.type == 6) {
            obtain.mPlayGifImage = true;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable != null && drawable.getStatus() == 2) {
            drawable.restartDownload();
        }
        if (drawable != null && drawable.getStatus() == 1) {
            t();
        } else {
            mVar.f78937a.setURLDrawableDownListener(this.J0);
            if (this.f78884r0 == null || !this.f78891y0) {
                Z();
            }
        }
        mVar.f78937a.setImageDrawable(drawable);
        b0();
        if (publicAccountConfigAttrImpl.type == 7) {
            if (this.f78884r0 == null) {
                this.f78884r0 = new com.tencent.biz.pubaccount.accountdetail.model.b(this.V, this);
            }
            mVar.f78946j.setVisibility(0);
            this.f78884r0.b(publicAccountConfigAttrImpl, mVar.f78946j);
        }
    }

    void J(p pVar) {
        if (this.R) {
            if (this.Q == null) {
                return;
            }
            pVar.f78958c.setBackgroundColor(Color.parseColor("#3d7fe3"));
            int length = this.Q.name.length();
            if (length > 8 && length < 13) {
                pVar.f78962g.setTextSize(2, 20.0f);
            }
            pVar.f78962g.setText(this.Q.name);
            if (!TextUtils.isEmpty(this.Q.displayNumber)) {
                pVar.f78963h.setText(this.Q.displayNumber);
            } else {
                pVar.f78963h.setVisibility(8);
            }
            if (this.Q.certifiedGrade != 0) {
                pVar.f78961f.setVisibility(0);
            } else {
                pVar.f78961f.setVisibility(8);
            }
            pVar.f78968m.setVisibility(8);
        } else {
            PublicAccountDetailImpl publicAccountDetailImpl = this.N;
            if (publicAccountDetailImpl == null) {
                return;
            }
            if (publicAccountDetailImpl.protocolVersion == 0) {
                pVar.f78958c.setBackgroundDrawable(this.Z);
                pVar.f78958c.setImageDrawable(this.f78861a0);
                pVar.f78958c.setVisibility(0);
                pVar.f78957b.setVisibility(8);
                pVar.f78966k.setVisibility(8);
                pVar.f78956a.setBackgroundColor(0);
                pVar.f78968m.setVisibility(8);
                pVar.f78967l.setVisibility(8);
            } else {
                pVar.f78958c.setVisibility(8);
                pVar.f78957b.setVisibility(0);
                pVar.f78964i.setText(this.N.summary);
                pVar.f78964i.setMaxWidth((int) (this.f78876k0 - (this.f78875j0 * 105.0f)));
                pVar.f78966k.setVisibility(0);
                pVar.f78966k.setText(this.N.sharedFollowerCount + "\u4f4d\u597d\u53cb\u5173\u6ce8");
                if (PublicAccountUtilImpl.getMessageHistoryInfo(this.N) != null) {
                    pVar.f78968m.setVisibility(0);
                    pVar.f78967l.setVisibility(0);
                } else {
                    pVar.f78968m.setVisibility(8);
                    pVar.f78967l.setVisibility(8);
                }
            }
            String str = this.N.name;
            int length2 = str.length();
            if (length2 > 8 && length2 < 13) {
                pVar.f78962g.setTextSize(2, 20.0f);
            }
            pVar.f78962g.setText(str);
            if (!TextUtils.isEmpty(this.N.certifiedDescription)) {
                pVar.f78963h.setText(this.N.certifiedDescription);
            } else {
                pVar.f78963h.setVisibility(8);
            }
            if (this.N.certifiedGrade != 0) {
                pVar.f78961f.setVisibility(0);
            } else {
                pVar.f78961f.setVisibility(8);
            }
        }
        pVar.f78959d.setImageDrawable(this.f78862b0);
    }

    void K(s sVar) {
        if (this.N == null) {
            return;
        }
        sVar.f78972a.setBackgroundDrawable(this.Z);
        sVar.f78972a.setImageDrawable(this.f78861a0);
        int length = this.N.name.length();
        if (length > 8 && length < 13) {
            sVar.f78976e.setTextSize(2, 20.0f);
        }
        sVar.f78976e.setText(this.N.name);
        if (this.N.certifiedGrade != 0) {
            sVar.f78975d.setVisibility(0);
        } else {
            sVar.f78975d.setVisibility(8);
        }
        if (v(this.N) && !TextUtils.isEmpty(this.N.certifiedDescription)) {
            sVar.f78978g.setText(this.N.certifiedDescription);
        } else {
            sVar.f78978g.setVisibility(8);
        }
        sVar.f78977f.setText(C(this.N.summary));
        sVar.f78973b.setImageDrawable(this.f78862b0);
        if (this.N.followType == 1) {
            if (this.f78892z0) {
                sVar.f78979h.setVisibility(0);
                sVar.f78979h.setBackgroundResource(R.drawable.byt);
                sVar.f78979h.setText((CharSequence) null);
            } else {
                sVar.f78979h.setVisibility(8);
            }
            this.f78874i0.setText(R.string.d7i);
            return;
        }
        sVar.f78979h.setVisibility(0);
        sVar.f78979h.setBackgroundResource(R.drawable.common_btn_blue);
        sVar.f78979h.setText(this.U.getResources().getString(R.string.d5m));
        sVar.f78979h.setTextColor(-1);
        this.f78874i0.setText(R.string.d7j);
    }

    void L(View view) {
        if (this.S) {
            view.findViewById(R.id.f166552g41).setVisibility(8);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f166551g40);
        if (textView != null) {
            if (this.G0.size() > 0) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void M(EqqDetail eqqDetail) {
        this.Q = eqqDetail;
    }

    public void N(View view) {
        this.Y = view;
    }

    public void O(int i3) {
        this.f78879m0 = i3;
    }

    public void P(Drawable drawable) {
        this.f78862b0 = drawable;
    }

    void Q(boolean z16) {
        this.S = z16;
        if (z16) {
            f0();
        } else {
            this.H0.clear();
        }
    }

    public void R(boolean z16) {
        this.X = z16;
    }

    public void S(int i3) {
        this.f78881o0 = i3;
    }

    public void T(boolean z16) {
        this.f78883q0 = z16;
    }

    public void U(Drawable drawable) {
        this.Z = drawable;
    }

    public void V(Drawable drawable) {
        this.f78861a0 = drawable;
    }

    public void W(q qVar) {
        this.K0 = qVar;
    }

    public void X(ImageView imageView, ImageView imageView2, View view, ImageView imageView3, Button button) {
        this.f78869f0 = imageView;
        this.f78870g0 = imageView2;
        this.P = view;
        this.f78872h0 = imageView3;
        this.f78874i0 = button;
    }

    void Y() {
        m mVar = this.f78885s0;
        if (mVar == null) {
            return;
        }
        mVar.f78947k.clearAnimation();
        this.f78885s0.f78947k.setVisibility(0);
        this.f78885s0.f78947k.setImageDrawable(this.U.getResources().getDrawable(R.drawable.byw));
        this.f78885s0.f78948l.setVisibility(0);
    }

    void Z() {
        if (this.f78885s0 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
        }
        this.f78885s0.f78947k.setVisibility(0);
        this.f78885s0.f78947k.setImageDrawable(this.U.getResources().getDrawable(R.drawable.dud));
        this.f78885s0.f78947k.clearAnimation();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setStartTime(-1L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f78885s0.f78947k.startAnimation(rotateAnimation);
        this.f78885s0.f78948l.setVisibility(8);
    }

    void a0() {
        this.P.setBackgroundColor(s());
        this.f78869f0.setVisibility(0);
        this.f78869f0.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.T, 1, this.L));
        this.f78870g0.setVisibility(0);
        this.f78872h0.setVisibility(8);
    }

    public void c0(ArrayList<zx.b> arrayList) {
        this.F0.clear();
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.F0.addAll(arrayList);
    }

    public void destroy() {
        AccountDetailGroupListContainer accountDetailGroupListContainer = this.f78867e0;
        if (accountDetailGroupListContainer != null) {
            accountDetailGroupListContainer.I();
        }
        Handler handler = this.f78889w0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f78889w0 = null;
        }
        i();
        j();
        ((IImageManager) QRoute.api(IImageManager.class)).clean();
    }

    void g0(o oVar, View view) {
        List<mobileqq_mp$ButtonInfo> buttonInfo = this.N.getButtonInfo();
        if (buttonInfo != null) {
            oVar.f78954a.j(this.T, this.L, this.D0);
            oVar.f78954a.setData(buttonInfo);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        int i3 = 1;
        if (publicAccountDetailImpl == null && this.Q == null) {
            return 1;
        }
        if (publicAccountDetailImpl != null && publicAccountDetailImpl.protocolVersion == 1) {
            return publicAccountDetailImpl.getButtonInfo() != null ? 2 : 1;
        }
        if (!this.X) {
            return 2;
        }
        int size = this.G0.size() + 1;
        if (this.E0.size() > 0) {
            i3 = 1 + this.E0.size();
        } else if (!this.f78877l0) {
            i3 = 0;
        }
        return size + i3;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<IPublicAccountConfigAttr> arrayList;
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        if (publicAccountDetailImpl == null && this.Q == null) {
            return null;
        }
        if ((publicAccountDetailImpl != null && publicAccountDetailImpl.protocolVersion == 1) || !this.X) {
            return null;
        }
        if (i3 == 0) {
            if (!this.S || (arrayList = this.H0) == null || arrayList.size() == 0) {
                return null;
            }
            return this.H0.get(i3);
        }
        if (i3 <= this.G0.size()) {
            return this.G0.get(i3 - 1);
        }
        if (this.f78877l0 || i3 == this.G0.size() + 1) {
            return null;
        }
        return this.E0.get((i3 - this.G0.size()) - 2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        PublicAccountDetailImpl publicAccountDetailImpl = this.N;
        if (publicAccountDetailImpl == null && this.Q == null) {
            return 9;
        }
        if (!this.X) {
            if (publicAccountDetailImpl == null || publicAccountDetailImpl.protocolVersion != 1) {
                return i3 == 0 ? 0 : 7;
            }
            if (i3 != 0) {
                return i3 != 1 ? -1 : 11;
            }
            return 0;
        }
        if (i3 == 0) {
            return this.S ? 10 : 8;
        }
        if (i3 <= this.G0.size()) {
            int type = this.G0.get(i3 - 1).getType();
            if (type == 2) {
                return 3;
            }
            if (type != 3) {
                return type != 4 ? -1 : 5;
            }
            return 4;
        }
        if (this.f78877l0) {
            return 2;
        }
        return i3 == this.G0.size() + 1 ? 6 : 1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:92:0x00d1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$n] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r4v11, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v27, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v26, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v123, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$k] */
    /* JADX WARN: Type inference failed for: r6v126, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$l] */
    /* JADX WARN: Type inference failed for: r6v134, types: [com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter$m] */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        s sVar;
        m mVar;
        l lVar;
        o oVar;
        ?? r142;
        boolean z16;
        k kVar;
        View view2;
        k kVar2;
        View view3;
        o oVar2;
        k kVar3;
        m mVar2;
        o oVar3;
        o oVar4;
        m mVar3;
        k kVar4;
        View view4;
        View view5;
        boolean z17;
        View view6;
        View view7;
        k kVar5;
        m mVar4;
        o oVar5;
        View view8;
        k kVar6;
        l lVar2;
        m mVar5;
        View view9;
        View view10;
        p pVar;
        o oVar6;
        Object obj;
        o oVar7;
        Object obj2;
        o oVar8;
        o oVar9;
        o oVar10;
        int itemViewType = getItemViewType(i3);
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "getView->pos:" + i3 + ", type:" + itemViewType);
        }
        View view11 = view;
        p pVar2 = null;
        if (y(itemViewType, view11, i3)) {
            if (itemViewType == 0) {
                pVar = (p) view.getTag();
                sVar = null;
                oVar6 = null;
            } else if (itemViewType == 1) {
                ?? r65 = (k) view.getTag();
                oVar6 = null;
                oVar7 = null;
                oVar = null;
                obj = null;
                z16 = w(i3);
                pVar2 = r65;
                sVar = null;
                pVar = null;
                kVar = pVar2;
                pVar2 = pVar;
                mVar = oVar6;
                view10 = view11;
                lVar = oVar7;
                r142 = obj;
            } else if (itemViewType != 2) {
                switch (itemViewType) {
                    case 8:
                        sVar = (s) view.getTag();
                        pVar = null;
                        oVar6 = pVar;
                        break;
                    case 9:
                        obj2 = (n) view.getTag();
                        sVar = null;
                        pVar = null;
                        oVar6 = null;
                        oVar8 = null;
                        oVar = null;
                        break;
                    case 10:
                        ?? r66 = (m) view.getTag();
                        com.tencent.biz.pubaccount.accountdetail.model.b bVar = this.f78884r0;
                        if (bVar != null) {
                            bVar.f79114d = false;
                        }
                        oVar6 = r66;
                        sVar = null;
                        pVar = null;
                        oVar10 = null;
                        oVar = oVar10;
                        oVar9 = oVar10;
                        obj2 = oVar;
                        oVar8 = oVar9;
                        break;
                    case 11:
                        oVar = (o) view.getTag();
                        sVar = null;
                        pVar = null;
                        oVar6 = null;
                        oVar8 = null;
                        obj2 = null;
                        break;
                    default:
                        sVar = null;
                        pVar = null;
                        oVar6 = pVar;
                        break;
                }
                z16 = false;
                oVar7 = oVar8;
                obj = obj2;
                kVar = pVar2;
                pVar2 = pVar;
                mVar = oVar6;
                view10 = view11;
                lVar = oVar7;
                r142 = obj;
            } else {
                oVar9 = (l) view.getTag();
                sVar = null;
                pVar = null;
                oVar6 = null;
                oVar = null;
                obj2 = oVar;
                oVar8 = oVar9;
                z16 = false;
                oVar7 = oVar8;
                obj = obj2;
                kVar = pVar2;
                pVar2 = pVar;
                mVar = oVar6;
                view10 = view11;
                lVar = oVar7;
                r142 = obj;
            }
            oVar10 = oVar6;
            oVar = oVar10;
            oVar9 = oVar10;
            obj2 = oVar;
            oVar8 = oVar9;
            z16 = false;
            oVar7 = oVar8;
            obj = obj2;
            kVar = pVar2;
            pVar2 = pVar;
            mVar = oVar6;
            view10 = view11;
            lVar = oVar7;
            r142 = obj;
        } else if (itemViewType != 0) {
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    switch (itemViewType) {
                        case 6:
                            z17 = false;
                            View inflate = this.K.inflate(R.layout.f167513c, viewGroup, false);
                            inflate.setOnClickListener(null);
                            view6 = inflate;
                            z16 = z17;
                            kVar2 = null;
                            sVar = null;
                            view3 = view6;
                            break;
                        case 7:
                            if (this.R) {
                                view7 = this.Y;
                            } else {
                                if (this.f78867e0 == null) {
                                    this.f78867e0 = new AccountDetailGroupListContainer(this.T, this.U, this.L, this.N, false);
                                }
                                view7 = this.f78867e0.L();
                            }
                            z17 = false;
                            view7.setPadding(0, BaseAIOUtils.f(7.0f, this.U.getResources()), 0, 0);
                            view7.setMinimumHeight(this.f78881o0);
                            view6 = view7;
                            z16 = z17;
                            kVar2 = null;
                            sVar = null;
                            view3 = view6;
                            break;
                        case 8:
                            View inflate2 = this.K.inflate(R.layout.f167518i, viewGroup, false);
                            inflate2.setOnClickListener(null);
                            s sVar2 = new s();
                            sVar2.f78972a = (ImageView) inflate2.findViewById(R.id.elv);
                            sVar2.f78973b = (ImageView) inflate2.findViewById(R.id.icon);
                            sVar2.f78974c = (ImageView) inflate2.findViewById(R.id.d__);
                            sVar2.f78975d = (ImageView) inflate2.findViewById(R.id.asu);
                            sVar2.f78976e = (TextView) inflate2.findViewById(R.id.f163873ax);
                            sVar2.f78977f = (TextView) inflate2.findViewById(R.id.f163875az);
                            sVar2.f78978g = (TextView) inflate2.findViewById(R.id.f163872aw);
                            Button button = (Button) inflate2.findViewById(R.id.f163871av);
                            sVar2.f78979h = button;
                            this.f78863c0 = button;
                            button.setOnClickListener(this);
                            inflate2.findViewById(R.id.f163877b0).setOnClickListener(new d());
                            float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
                            if (fontLevel > 1.0f) {
                                sVar2.f78977f.setTextSize(14 / fontLevel);
                            } else {
                                sVar2.f78977f.setTextSize(14);
                            }
                            inflate2.setTag(sVar2);
                            sVar = sVar2;
                            kVar5 = null;
                            mVar4 = null;
                            oVar5 = null;
                            view8 = inflate2;
                            oVar = oVar5;
                            view5 = view8;
                            kVar3 = kVar5;
                            mVar2 = mVar4;
                            oVar2 = oVar5;
                            break;
                        case 9:
                            ?? inflate3 = this.K.inflate(R.layout.f167514d, viewGroup, false);
                            inflate3.setLayoutParams(new AbsListView.LayoutParams(this.U.getResources().getDisplayMetrics().widthPixels, this.U.getResources().getDisplayMetrics().heightPixels));
                            inflate3.setOnClickListener(null);
                            ?? nVar = new n();
                            nVar.f78950a = (TextView) inflate3.findViewById(R.id.efo);
                            nVar.f78951b = (ImageView) inflate3.findViewById(R.id.eff);
                            nVar.f78952c = (TextView) inflate3.findViewById(R.id.i96);
                            inflate3.setTag(nVar);
                            oVar3 = nVar;
                            kVar4 = null;
                            sVar = null;
                            mVar3 = null;
                            oVar4 = null;
                            oVar = null;
                            view4 = inflate3;
                            z16 = false;
                            view10 = view4;
                            kVar = kVar4;
                            mVar = mVar3;
                            lVar = oVar4;
                            r142 = oVar3;
                            break;
                        case 10:
                            View inflate4 = this.K.inflate(R.layout.f167517h, viewGroup, false);
                            ViewGroup.LayoutParams layoutParams = inflate4.getLayoutParams();
                            layoutParams.height = this.f78882p0;
                            if (x()) {
                                layoutParams.height -= q();
                            }
                            inflate4.setLayoutParams(layoutParams);
                            inflate4.setOnClickListener(null);
                            m mVar6 = new m();
                            mVar6.f78937a = (URLImageView) inflate4.findViewById(R.id.kq_);
                            mVar6.f78938b = (ImageView) inflate4.findViewById(R.id.icon);
                            mVar6.f78939c = (ImageView) inflate4.findViewById(R.id.asu);
                            mVar6.f78940d = (TextView) inflate4.findViewById(R.id.f163873ax);
                            mVar6.f78941e = (TextView) inflate4.findViewById(R.id.f163875az);
                            mVar6.f78946j = (FrameLayout) inflate4.findViewById(R.id.ksl);
                            mVar6.f78942f = (Button) inflate4.findViewById(R.id.f163871av);
                            mVar6.f78943g = inflate4.findViewById(R.id.f163869at);
                            mVar6.f78944h = (ImageView) inflate4.findViewById(R.id.f163867ar);
                            mVar6.f78945i = (ImageView) inflate4.findViewById(R.id.f163868as);
                            mVar6.f78947k = (ImageView) inflate4.findViewById(R.id.loading);
                            mVar6.f78948l = (TextView) inflate4.findViewById(R.id.jmp);
                            float fontLevel2 = FontSettingManager.getFontLevel() / 16.0f;
                            if (fontLevel2 > 1.0f) {
                                mVar6.f78941e.setTextSize(14 / fontLevel2);
                            } else {
                                mVar6.f78941e.setTextSize(14);
                            }
                            Button button2 = mVar6.f78942f;
                            this.f78863c0 = button2;
                            button2.setOnClickListener(this);
                            mVar6.f78943g.setOnClickListener(new e());
                            inflate4.findViewById(R.id.f163877b0).setOnClickListener(new f());
                            inflate4.setTag(mVar6);
                            com.tencent.biz.pubaccount.accountdetail.model.b bVar2 = this.f78884r0;
                            if (bVar2 != null) {
                                bVar2.f79114d = true;
                            }
                            kVar5 = null;
                            sVar = null;
                            oVar5 = null;
                            view8 = inflate4;
                            mVar4 = mVar6;
                            oVar = oVar5;
                            view5 = view8;
                            kVar3 = kVar5;
                            mVar2 = mVar4;
                            oVar2 = oVar5;
                            break;
                        case 11:
                            View inflate5 = this.K.inflate(R.layout.dpx, viewGroup, false);
                            o oVar11 = new o();
                            oVar11.f78954a = (PublicAccountMenuBar) inflate5.findViewById(R.id.z4t);
                            inflate5.setTag(oVar11);
                            oVar = oVar11;
                            kVar6 = null;
                            sVar = null;
                            lVar2 = null;
                            mVar5 = null;
                            view9 = inflate5;
                            z16 = false;
                            mVar = mVar5;
                            view10 = view9;
                            kVar = kVar6;
                            lVar = lVar2;
                            r142 = mVar5;
                            break;
                        default:
                            kVar6 = null;
                            sVar = null;
                            lVar2 = null;
                            oVar = null;
                            mVar5 = null;
                            view9 = view11;
                            z16 = false;
                            mVar = mVar5;
                            view10 = view9;
                            kVar = kVar6;
                            lVar = lVar2;
                            r142 = mVar5;
                            break;
                    }
                } else {
                    ?? inflate6 = this.K.inflate(R.layout.c4y, viewGroup, false);
                    ?? lVar3 = new l();
                    lVar3.f78933a = (TextView) inflate6.findViewById(R.id.f163870au);
                    lVar3.f78934b = (ImageView) inflate6.findViewById(R.id.g3z);
                    lVar3.f78935c = (TextView) inflate6.findViewById(R.id.g4e);
                    inflate6.setTag(lVar3);
                    inflate6.setMinimumHeight(this.f78882p0);
                    oVar2 = lVar3;
                    kVar3 = null;
                    sVar = null;
                    mVar2 = null;
                    oVar = null;
                    view5 = inflate6;
                }
                oVar3 = oVar;
                view4 = view5;
                kVar4 = kVar3;
                mVar3 = mVar2;
                oVar4 = oVar2;
                z16 = false;
                view10 = view4;
                kVar = kVar4;
                mVar = mVar3;
                lVar = oVar4;
                r142 = oVar3;
            } else {
                z16 = w(i3);
                if (z16) {
                    view2 = this.K.inflate(R.layout.f168416vj, viewGroup, false);
                } else {
                    view2 = this.K.inflate(R.layout.c4z, viewGroup, false);
                }
                k kVar7 = new k();
                kVar7.f78925a = (URLImageView) view2.findViewById(R.id.bqx);
                kVar7.f78926b = (TextView) view2.findViewById(R.id.f165038br0);
                kVar7.f78927c = (TextView) view2.findViewById(R.id.bqz);
                kVar7.f78928d = (TextView) view2.findViewById(R.id.bra);
                kVar7.f78929e = (ImageView) view2.findViewById(R.id.br_);
                kVar7.f78930f = (ImageView) view2.findViewById(R.id.bqy);
                kVar7.f78931g = z16;
                view2.setTag(kVar7);
                sVar = null;
                view3 = view2;
                kVar2 = kVar7;
            }
            o oVar12 = sVar;
            o oVar13 = oVar12;
            oVar = oVar13;
            r142 = oVar;
            view10 = view3;
            kVar = kVar2;
            mVar = oVar12;
            lVar = oVar13;
        } else {
            View inflate7 = this.K.inflate(R.layout.f167516g, viewGroup, false);
            inflate7.setOnClickListener(null);
            p pVar3 = new p();
            pVar3.f78956a = inflate7.findViewById(R.id.jt9);
            pVar3.f78958c = (ImageView) inflate7.findViewById(R.id.elv);
            pVar3.f78957b = inflate7.findViewById(R.id.f907353_);
            pVar3.f78959d = (ImageView) inflate7.findViewById(R.id.icon);
            pVar3.f78960e = (ImageView) inflate7.findViewById(R.id.d__);
            pVar3.f78961f = (ImageView) inflate7.findViewById(R.id.asu);
            pVar3.f78962g = (TextView) inflate7.findViewById(R.id.f163873ax);
            pVar3.f78963h = (TextView) inflate7.findViewById(R.id.f163872aw);
            pVar3.f78964i = (TextView) inflate7.findViewById(R.id.f163875az);
            pVar3.f78965j = (ImageView) inflate7.findViewById(R.id.f163876s83);
            pVar3.f78966k = (TextView) inflate7.findViewById(R.id.f84524mh);
            pVar3.f78957b.setOnClickListener(this);
            pVar3.f78967l = inflate7.findViewById(R.id.bmt);
            View findViewById = inflate7.findViewById(R.id.f165698xa3);
            pVar3.f78968m = findViewById;
            findViewById.setOnClickListener(this);
            inflate7.setTag(pVar3);
            sVar = null;
            mVar = null;
            lVar = null;
            oVar = null;
            r142 = 0;
            z16 = false;
            pVar2 = pVar3;
            kVar = null;
            view10 = inflate7;
        }
        if (itemViewType == 0) {
            J(pVar2);
            return view10;
        }
        if (itemViewType == 8) {
            K(sVar);
            return view10;
        }
        if (itemViewType == 10) {
            I(mVar);
            return view10;
        }
        if (itemViewType == 1) {
            H(kVar, view10, i3, z16);
            return view10;
        }
        if (itemViewType == 6) {
            L(view10);
            return view10;
        }
        if (itemViewType == 2) {
            n0(lVar, view10);
            return view10;
        }
        if (itemViewType == 9) {
            if (this.f78883q0) {
                if (r142 == 0) {
                    return view10;
                }
                r142.f78950a.setVisibility(0);
                r142.f78951b.setVisibility(0);
                r142.f78952c.setVisibility(8);
                return view10;
            }
            if (r142 == 0) {
                return view10;
            }
            r142.f78950a.setVisibility(8);
            r142.f78951b.setVisibility(8);
            r142.f78952c.setVisibility(0);
            return view10;
        }
        if (itemViewType == 11) {
            g0(oVar, view10);
            return view10;
        }
        PublicAccountConfigAttrImpl publicAccountConfigAttrImpl = (PublicAccountConfigAttrImpl) getItem(i3);
        if (itemViewType == 3) {
            View f16 = com.tencent.biz.pubaccount.accountdetail.view.a.f(this.U, view10, viewGroup, publicAccountConfigAttrImpl, this.N.followType, this.W, this.L, this.M);
            AccountDetailTopGestureLayout accountDetailTopGestureLayout = this.C0;
            if (accountDetailTopGestureLayout == null) {
                return f16;
            }
            accountDetailTopGestureLayout.e(f16);
            return f16;
        }
        if (itemViewType != 4) {
            if (itemViewType != 5) {
                return view10;
            }
            return com.tencent.biz.pubaccount.accountdetail.view.c.e(this.U, view10, viewGroup, publicAccountConfigAttrImpl, this.N.followType, this.W, this.L, this.M);
        }
        View e16 = com.tencent.biz.pubaccount.accountdetail.view.d.e(this.U, view10, viewGroup, publicAccountConfigAttrImpl, this.N.followType, this.W, this.L, this.M);
        AccountDetailTopGestureLayout accountDetailTopGestureLayout2 = this.C0;
        if (accountDetailTopGestureLayout2 == null) {
            return e16;
        }
        accountDetailTopGestureLayout2.e(e16);
        return e16;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 13;
    }

    public void h() {
        this.f78865d0.setOnScrollListener(this.I0);
        this.f78865d0.setOnEndScrollListener(new j());
    }

    void j() {
        Button button = this.f78874i0;
        if (button == null || button.getAnimation() == null) {
            return;
        }
        this.f78874i0.getAnimation().cancel();
        this.f78874i0.clearAnimation();
    }

    void l0(int i3) {
        float f16;
        float f17;
        if (this.S) {
            if (v(this.N)) {
                f16 = 258.0f;
                f17 = this.f78875j0;
            } else {
                f16 = 234.0f;
                f17 = this.f78875j0;
            }
        } else if (v(this.N)) {
            f16 = 217.0f;
            f17 = this.f78875j0;
        } else {
            f16 = 173.0f;
            f17 = this.f78875j0;
        }
        int i16 = (int) (f17 * f16);
        if (this.f78874i0.getVisibility() == 8 && i3 >= i16) {
            this.f78874i0.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            alphaAnimation.setFillBefore(true);
            this.f78874i0.startAnimation(alphaAnimation);
            return;
        }
        if (i3 >= i16 || this.f78874i0.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(100L);
        this.f78874i0.startAnimation(alphaAnimation2);
        this.f78874i0.setVisibility(8);
    }

    public com.tencent.biz.pubaccount.accountdetail.model.b m() {
        com.tencent.biz.pubaccount.accountdetail.model.b bVar = this.f78884r0;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public PublicAccountDetailImpl n() {
        return this.N;
    }

    void n0(l lVar, View view) {
        float f16 = this.U.getResources().getDisplayMetrics().density;
        view.setClickable(false);
        view.setOnClickListener(null);
        if (this.f78880n0) {
            int i3 = this.f78879m0;
            if (i3 == PublicAccountDetailActivityImpl.NETWORK_UNKNOW) {
                lVar.f78933a.setText(R.string.f169988bi);
                lVar.f78933a.setVisibility(0);
                lVar.f78935c.setVisibility(4);
                lVar.f78934b.setVisibility(4);
            } else if (i3 == PublicAccountDetailActivityImpl.NETWORK_ERROR) {
                lVar.f78933a.setText(R.string.d6b);
                int i16 = (int) (f16 * 5.0f);
                lVar.f78933a.setPadding(0, i16, 0, i16);
                lVar.f78934b.setImageResource(R.drawable.cgc);
                lVar.f78935c.setVisibility(0);
            } else if (i3 == PublicAccountDetailActivityImpl.NO_MORE_DATA) {
                lVar.f78933a.setText(R.string.f169991bl);
                lVar.f78934b.setImageResource(R.drawable.d7u);
                int i17 = (int) (f16 * 5.0f);
                lVar.f78933a.setPadding(0, i17, 0, i17);
                lVar.f78935c.setVisibility(4);
            }
        }
        lVar.f78935c.setOnClickListener(new g(lVar));
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (this.f78877l0 && !z()) {
            this.f78877l0 = false;
            this.f78865d0.setAdapter((ListAdapter) null);
            this.f78865d0.j0(true);
            this.f78865d0.setAdapter((ListAdapter) this);
        }
        super.notifyDataSetChanged();
    }

    public int o() {
        return this.F0.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ComponentCallbacks2 componentCallbacks2 = this.V;
        if (componentCallbacks2 == null || !(componentCallbacks2 instanceof View.OnClickListener)) {
            return;
        }
        if (view == this.f78863c0) {
            this.f78892z0 = true;
        }
        ((View.OnClickListener) componentCallbacks2).onClick(view);
    }

    public EqqDetail p() {
        return this.Q;
    }

    public int r() {
        View childAt = this.f78865d0.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    protected int s() {
        PublicAccountDetailImpl publicAccountDetailImpl;
        if (!this.R && (publicAccountDetailImpl = this.N) != null) {
            String str = publicAccountDetailImpl.configBackgroundColor;
            if (str == null || str.equals("")) {
                this.N.configBackgroundColor = "3d7fe3";
            }
            return Color.parseColor("#" + this.N.configBackgroundColor.substring(0, 6));
        }
        return Color.parseColor("#3d7fe3");
    }

    void t() {
        if (this.f78885s0 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
        }
        this.f78885s0.f78947k.clearAnimation();
        this.f78885s0.f78947k.setVisibility(8);
        this.f78885s0.f78948l.setVisibility(8);
    }

    void u() {
        this.P.setBackgroundColor(0);
        this.f78869f0.setVisibility(8);
        this.f78870g0.setVisibility(8);
        this.f78872h0.setVisibility(8);
        if (this.X) {
            this.f78874i0.setVisibility(8);
        }
    }

    public boolean w(int i3) {
        zx.b bVar = this.E0.get((i3 - this.G0.size()) - 2);
        if (bVar != null) {
            zx.d dVar = bVar.f453631e;
            if (dVar != null && dVar.f453643b == 1) {
                return true;
            }
            zx.e eVar = bVar.f453632f;
            if (eVar != null && eVar.f453652h == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean z() {
        int i3;
        boolean z16 = this.E0.size() == 0;
        this.f78880n0 = z16;
        return z16 && ((i3 = this.f78879m0) == PublicAccountDetailActivityImpl.NETWORK_UNKNOW || i3 == PublicAccountDetailActivityImpl.NETWORK_ERROR || i3 == PublicAccountDetailActivityImpl.NO_MORE_DATA);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class i implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        int f78921d;

        /* renamed from: e, reason: collision with root package name */
        int f78922e;

        i() {
            this.f78922e = (int) (AccountDetailBaseAdapter.this.f78875j0 * 2.0f);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (AccountDetailBaseAdapter.this.f78865d0.getFirstVisiblePosition() == 0) {
                AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
                PublicAccountDetailImpl publicAccountDetailImpl = accountDetailBaseAdapter.N;
                if (publicAccountDetailImpl != null && publicAccountDetailImpl.protocolVersion == 0) {
                    int i18 = -accountDetailBaseAdapter.r();
                    View childAt = AccountDetailBaseAdapter.this.f78865d0.getChildAt(0);
                    AccountDetailBaseAdapter accountDetailBaseAdapter2 = AccountDetailBaseAdapter.this;
                    if (accountDetailBaseAdapter2.X) {
                        if (accountDetailBaseAdapter2.S) {
                            accountDetailBaseAdapter2.j0((int) (i18 - (accountDetailBaseAdapter2.f78875j0 * 262.0f)), childAt);
                        } else {
                            accountDetailBaseAdapter2.k0(i18, childAt);
                        }
                    } else if (accountDetailBaseAdapter2.N != null || accountDetailBaseAdapter2.Q != null) {
                        accountDetailBaseAdapter2.i0(i18, childAt);
                    }
                    AccountDetailBaseAdapter accountDetailBaseAdapter3 = AccountDetailBaseAdapter.this;
                    com.tencent.biz.pubaccount.accountdetail.model.b bVar = accountDetailBaseAdapter3.f78884r0;
                    if (bVar != null && i18 != 0) {
                        if (i18 < accountDetailBaseAdapter3.f78882p0 - (accountDetailBaseAdapter3.f78875j0 * 75.0f)) {
                            bVar.d(false);
                        } else {
                            bVar.a();
                        }
                    }
                }
            } else {
                AccountDetailBaseAdapter.this.a0();
                com.tencent.biz.pubaccount.accountdetail.model.b bVar2 = AccountDetailBaseAdapter.this.f78884r0;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
            int r16 = AccountDetailBaseAdapter.this.r();
            if (Math.abs(this.f78921d - r16) > this.f78922e) {
                if (this.f78921d > r16) {
                    AccountDetailBaseAdapter.this.f78890x0 = true;
                } else {
                    AccountDetailBaseAdapter.this.f78890x0 = false;
                }
            }
            this.f78921d = r16;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                ((IImageManager) QRoute.api(IImageManager.class)).resume();
                AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
                if (accountDetailBaseAdapter.f78890x0) {
                    accountDetailBaseAdapter.B(absListView.getLastVisiblePosition(), AccountDetailBaseAdapter.M0);
                } else {
                    accountDetailBaseAdapter.B(absListView.getFirstVisiblePosition() - AccountDetailBaseAdapter.M0, AccountDetailBaseAdapter.M0);
                }
                if (AccountDetailBaseAdapter.this.getCount() - absListView.getLastVisiblePosition() < AccountDetailBaseAdapter.N0) {
                    AccountDetailBaseAdapter accountDetailBaseAdapter2 = AccountDetailBaseAdapter.this;
                    if (accountDetailBaseAdapter2.f78865d0.D) {
                        accountDetailBaseAdapter2.A();
                    }
                }
            }
            if (absListView instanceof AccountDetailXListView) {
                ((AccountDetailXListView) absListView).onScrollStateChanged(absListView, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends URLDrawableDownListener.Adapter {
        c() {
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            super.onLoadCancelled(view, uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            super.onLoadFailed(view, uRLDrawable, th5);
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            if (!accountDetailBaseAdapter.f78891y0) {
                accountDetailBaseAdapter.Y();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "onLoadFailed ,cause = " + th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            if (view == null) {
                return;
            }
            AccountDetailBaseAdapter.this.t();
            if (view instanceof ImageView) {
                ((URLImageView) view).setImageDrawable(uRLDrawable);
                view.requestLayout();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "onLoadSuccessed");
            }
        }
    }

    public void e0(ArrayList<zx.b> arrayList, boolean z16) {
        int i3;
        int i16;
        if (z16) {
            this.E0.clear();
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            this.E0.addAll(arrayList);
            this.L0 = System.nanoTime();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<zx.b> it = this.E0.iterator();
        while (it.hasNext()) {
            zx.b next = it.next();
            zx.e eVar = next.f453632f;
            if (eVar != null && (i16 = eVar.f453645a) != 1 && i16 != 2) {
                arrayList2.add(next);
            } else {
                zx.c cVar = next.f453630d;
                if (cVar != null && (i3 = cVar.f453637d) != 1 && i3 != 2) {
                    arrayList2.add(next);
                }
            }
        }
        this.E0.removeAll(arrayList2);
    }

    void i0(int i3, View view) {
        float f16;
        float f17;
        if (view == null) {
            return;
        }
        final p pVar = (p) view.getTag();
        if (x()) {
            f16 = 76.0f;
            f17 = this.f78875j0;
        } else {
            f16 = 65.0f;
            f17 = this.f78875j0;
        }
        float f18 = f17 * f16;
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pVar.f78959d.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pVar.f78960e.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) pVar.f78961f.getLayoutParams();
        if (i3 < f18) {
            float f19 = 100.0f - ((i3 * 70) / f18);
            float f26 = this.f78875j0;
            int i16 = (int) (f19 * f26);
            layoutParams.width = i16;
            layoutParams.height = i16;
            int i17 = (int) (90.0f * f26);
            layoutParams.topMargin = i17;
            int i18 = i16 + ((int) (4.0f * f26));
            layoutParams2.width = i18;
            layoutParams2.height = i18;
            layoutParams2.topMargin = i17 - ((int) (2.0f * f26));
            int i19 = (int) ((20.0f - ((i3 * 20) / f18)) * f26);
            layoutParams3.width = i19;
            layoutParams3.height = i19;
            if (i3 == 0) {
                layoutParams3.topMargin = (int) (165.0f * f26);
                layoutParams3.leftMargin = (int) (f26 * 72.0f);
            } else {
                int i26 = layoutParams.topMargin;
                int i27 = layoutParams.height;
                float f27 = (i3 * 2) / f18;
                layoutParams3.topMargin = i26 + ((int) (i27 * 0.72d)) + ((int) (f27 * f26));
                layoutParams3.leftMargin = ((int) (i27 * 0.72d)) + ((int) (f27 * f26));
            }
        } else {
            float f28 = this.f78875j0;
            int i28 = (int) (30.0f * f28);
            layoutParams.width = i28;
            layoutParams.height = i28;
            layoutParams.topMargin = (int) (22.0f * f28);
            int i29 = (int) (32.0f * f28);
            layoutParams2.width = i29;
            layoutParams2.height = i29;
            layoutParams2.topMargin = (int) (20.0f * f28);
            int i36 = (int) (f28 * 8.0f);
            layoutParams3.height = i36;
            layoutParams3.width = i36;
        }
        pVar.f78959d.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                pVar.f78959d.setLayoutParams(layoutParams);
                pVar.f78960e.setLayoutParams(layoutParams2);
                pVar.f78961f.setLayoutParams(layoutParams3);
            }
        });
        m0(i3, f18);
    }

    void j0(int i3, View view) {
        float f16;
        float f17;
        if (view == null) {
            return;
        }
        final m mVar = (m) view.getTag();
        float f18 = this.f78875j0 * 170.0f;
        if (x()) {
            f16 = 64.0f;
            f17 = this.f78875j0;
        } else {
            f16 = 75.0f;
            f17 = this.f78875j0;
        }
        float f19 = f18 - ((f17 * f16) / 2.0f);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mVar.f78938b.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) mVar.f78939c.getLayoutParams();
        float f26 = i3;
        if (f26 < f19) {
            mVar.f78938b.setVisibility(0);
            if (this.N.certifiedGrade != 0) {
                mVar.f78939c.setVisibility(0);
            } else {
                mVar.f78939c.setVisibility(8);
            }
            if (i3 <= 0) {
                float f27 = this.f78875j0;
                int i16 = (int) (90.0f * f27);
                layoutParams.width = i16;
                layoutParams.height = i16;
                int i17 = (int) (20.0f * f27);
                layoutParams2.width = i17;
                layoutParams2.height = i17;
                layoutParams2.topMargin = (int) (f27 * 58.0f);
                layoutParams2.leftMargin = (int) (f27 * 58.0f);
            } else {
                float f28 = this.f78875j0;
                int i18 = (int) ((90.0f - ((i3 * 50) / f19)) * f28);
                layoutParams.width = i18;
                layoutParams.height = i18;
                int i19 = (int) ((20.0f - ((i3 * 20) / f19)) * f28);
                layoutParams2.width = i19;
                layoutParams2.height = i19;
                int i26 = layoutParams.height;
                float f29 = (i3 * 2) / f19;
                layoutParams2.topMargin = ((int) (i26 * 0.64d)) + ((int) (f29 * f28));
                layoutParams2.leftMargin = ((int) (i26 * 0.64d)) + ((int) (f29 * f28));
            }
            mVar.f78938b.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.9
                @Override // java.lang.Runnable
                public void run() {
                    mVar.f78938b.setLayoutParams(layoutParams);
                    mVar.f78939c.setLayoutParams(layoutParams2);
                }
            });
        } else if (f26 >= f19) {
            mVar.f78938b.setVisibility(4);
            mVar.f78939c.setVisibility(4);
        }
        m0(i3, f19);
    }

    void k0(int i3, View view) {
        float f16;
        float f17;
        if (view == null) {
            return;
        }
        final s sVar = (s) view.getTag();
        if (x()) {
            f16 = 41.0f;
            f17 = this.f78875j0;
        } else {
            f16 = 30.0f;
            f17 = this.f78875j0;
        }
        float f18 = f17 * f16;
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sVar.f78973b.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) sVar.f78974c.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) sVar.f78975d.getLayoutParams();
        if (i3 < f18) {
            sVar.f78973b.setVisibility(0);
            sVar.f78974c.setVisibility(0);
            if (this.N.certifiedGrade != 0) {
                sVar.f78975d.setVisibility(0);
            } else {
                sVar.f78975d.setVisibility(8);
            }
            float f19 = 90.0f - ((i3 * 50) / f18);
            float f26 = this.f78875j0;
            int i16 = (int) (f19 * f26);
            layoutParams.width = i16;
            layoutParams.height = i16;
            layoutParams.topMargin = (int) (60.0f * f26);
            int i17 = i16 + ((int) (4.0f * f26));
            layoutParams2.width = i17;
            layoutParams2.height = i17;
            layoutParams2.topMargin = (int) (58.0f * f26);
            int i18 = (int) ((20.0f - ((i3 * 20) / f18)) * f26);
            layoutParams3.width = i18;
            layoutParams3.height = i18;
            if (i3 == 0) {
                int i19 = (int) (f26 * 65.0f);
                layoutParams3.leftMargin = i19;
                layoutParams3.topMargin = i19;
            } else {
                int i26 = ((int) (layoutParams.height * 0.72d)) + ((int) (((i3 * 2) / f18) * f26));
                layoutParams3.leftMargin = i26;
                layoutParams3.topMargin = i26;
            }
            sVar.f78973b.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.10
                @Override // java.lang.Runnable
                public void run() {
                    sVar.f78973b.setLayoutParams(layoutParams);
                    sVar.f78974c.setLayoutParams(layoutParams2);
                    sVar.f78975d.setLayoutParams(layoutParams3);
                }
            });
        } else {
            sVar.f78973b.setVisibility(4);
            sVar.f78974c.setVisibility(4);
            sVar.f78975d.setVisibility(4);
        }
        m0(i3, f18);
    }

    protected static boolean v(PublicAccountDetailImpl publicAccountDetailImpl) {
        return publicAccountDetailImpl != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag) == -2;
    }

    void m0(int i3, float f16) {
        PublicAccountDetailImpl publicAccountDetailImpl;
        if (i3 >= f16) {
            a0();
            if (!this.X || (publicAccountDetailImpl = this.N) == null || publicAccountDetailImpl.followType == 1) {
                return;
            }
            l0(i3);
            return;
        }
        u();
    }

    void H(k kVar, View view, int i3, boolean z16) {
        URLDrawable drawable;
        String str;
        String str2;
        if (kVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
                return;
            }
            return;
        }
        zx.b bVar = (zx.b) getItem(i3);
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.L + "\u52a8\u6001\u6d88\u606f\u4e3a\u7a7a");
                return;
            }
            return;
        }
        if (bVar.f453630d == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.L + "\u52a8\u6001\u6d88\u606f\u7684\u6d88\u606f\u5c5e\u6027\u4e3a\u7a7a");
                return;
            }
            return;
        }
        if (!bVar.f453633g) {
            bVar.f453633g = true;
            JSONObject jSONObject = new JSONObject();
            if (!this.R) {
                try {
                    jSONObject.put("cha_1", bVar.f453630d.f453641h);
                    jSONObject.put("cha_2", this.A0);
                    QQAppInterface qQAppInterface = this.T;
                    String str3 = this.L;
                    if (this.N.followType == 1) {
                        str2 = "02";
                    } else {
                        str2 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
                    }
                    ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str3, "0X8007CA2", "0X8007CA2", 0, 0, str2, String.valueOf(bVar.f453630d.f453637d), String.valueOf(bVar.f453630d.f453634a), jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: item:= " + i3 + "report msg: artical id=" + bVar.f453630d.f453634a + "   artical name=" + bVar.f453627a + " json=" + jSONObject.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        zx.c cVar = bVar.f453630d;
        int i16 = cVar.f453637d;
        boolean z17 = i16 == 2;
        String str4 = bVar.f453627a;
        Long valueOf = Long.valueOf(cVar.f453639f);
        String str5 = bVar.f453630d.f453636c;
        String str6 = "";
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:title =" + str4 + "--coverUrl=--jumpUrl=" + str5 + "--isVideoMsg =" + z17);
        }
        if (z17) {
            kVar.f78928d.setVisibility(0);
            kVar.f78930f.setVisibility(0);
            kVar.f78929e.setVisibility(0);
            zx.e eVar = bVar.f453632f;
            if (eVar != null) {
                if (z16) {
                    str = eVar.f453653i;
                } else {
                    str = eVar.f453646b;
                }
                str6 = str;
                kVar.f78928d.setText(ba.formatTime(eVar.f453648d));
            }
        } else {
            kVar.f78928d.setVisibility(4);
            kVar.f78930f.setVisibility(4);
            kVar.f78929e.setVisibility(4);
            zx.d dVar = bVar.f453631e;
            if (dVar != null) {
                str6 = z16 ? dVar.f453644c : dVar.f453642a;
            }
        }
        String str7 = str6;
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "\u5f53\u524d\u7684url\u662f" + str7);
        }
        if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str4) && valueOf.longValue() > 0) {
            Resources resources = this.U.getResources();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
            try {
                if (z16) {
                    drawable = URLDrawable.getDrawable(str7, (Drawable) colorDrawable, (Drawable) colorDrawable, true);
                } else {
                    drawable = URLDrawable.getDrawable(str7, BaseAIOUtils.f(124.0f, resources), BaseAIOUtils.f(95.0f, resources), (Drawable) colorDrawable, (Drawable) colorDrawable, true);
                }
                kVar.f78925a.setImageDrawable(drawable);
                kVar.f78926b.setText(str4);
                kVar.f78927c.setText(((IReadInJoyTimeUtils) QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(valueOf.longValue()));
                view.setOnClickListener(new h(i16, str5, bVar));
                return;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + e17);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.L + "\u52a8\u6001\u6d88\u606f\u5185\u5bb9\u4e0d\u5408\u6cd5");
        }
    }

    boolean y(int i3, View view, int i16) {
        if (view == null) {
            return false;
        }
        if (i3 == 1) {
            return view.getTag() != null && (view.getTag() instanceof k) && w(i16) == ((k) view.getTag()).f78931g;
        }
        if (i3 == 2) {
            return view.getTag() != null && (view.getTag() instanceof l);
        }
        if (i3 == 0) {
            return view.getTag() != null && (view.getTag() instanceof p);
        }
        if (i3 == 8) {
            return view.getTag() != null && (view.getTag() instanceof s);
        }
        if (i3 == 9) {
            return view.getTag() != null && (view.getTag() instanceof n);
        }
        if (i3 == 10) {
            return view.getTag() != null && (view.getTag() instanceof m);
        }
        if (i3 == 11) {
            return view.getTag() != null && (view.getTag() instanceof o);
        }
        return true;
    }

    public AccountDetailBaseAdapter(QQAppInterface qQAppInterface, Context context, String str, AccountDetailXListView accountDetailXListView, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, ImageView imageView3, AccountDetailTopGestureLayout accountDetailTopGestureLayout) {
        this.f78864d = -1;
        this.f78866e = 0;
        this.f78868f = 1;
        this.f78871h = 2;
        this.f78873i = 3;
        this.f78878m = 4;
        this.C = 5;
        this.D = 6;
        this.E = 7;
        this.F = 8;
        this.G = 9;
        this.H = 10;
        this.I = 11;
        this.J = 13;
        this.R = false;
        this.S = false;
        this.X = false;
        this.f78877l0 = false;
        this.f78879m0 = PublicAccountDetailActivityImpl.NETWORK_UNKNOW;
        this.f78880n0 = true;
        this.f78881o0 = 0;
        this.f78882p0 = 0;
        this.f78883q0 = true;
        this.f78885s0 = null;
        this.f78889w0 = null;
        this.f78890x0 = false;
        this.f78891y0 = false;
        this.f78892z0 = false;
        this.A0 = 1;
        this.B0 = false;
        this.D0 = new MqqHandler(Looper.getMainLooper());
        this.E0 = new ArrayList<>();
        this.F0 = new ArrayList<>();
        this.G0 = new ArrayList<>();
        this.H0 = new ArrayList<>();
        this.I0 = new i();
        this.J0 = new c();
        this.L0 = 0L;
        this.T = qQAppInterface;
        this.K = LayoutInflater.from(context);
        this.U = context;
        this.L = str;
        this.R = true;
        this.f78865d0 = accountDetailXListView;
        this.f78869f0 = imageView;
        this.f78870g0 = imageView2;
        this.P = relativeLayout;
        this.f78872h0 = imageView3;
        this.f78875j0 = accountDetailXListView.getResources().getDisplayMetrics().density;
        h();
        this.C0 = accountDetailTopGestureLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AccountDetailBaseAdapter.this.f78885s0.f78943g.setVisibility(0);
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            accountDetailBaseAdapter.f78885s0.f78943g.startAnimation(accountDetailBaseAdapter.f78887u0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AccountDetailBaseAdapter accountDetailBaseAdapter = AccountDetailBaseAdapter.this;
            m mVar = accountDetailBaseAdapter.f78885s0;
            accountDetailBaseAdapter.D(mVar.f78944h, mVar.f78945i, 100L, 240L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
