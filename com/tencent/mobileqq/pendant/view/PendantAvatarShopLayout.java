package com.tencent.mobileqq.pendant.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b03.c;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment;
import com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.INtVipStatus;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PendantAvatarShopLayout {
    static IPatchRedirector $redirector_;
    public static int A;
    public static long B;
    public static String C;
    public static boolean D;
    public static int E;

    /* renamed from: a, reason: collision with root package name */
    public int f257520a;

    /* renamed from: b, reason: collision with root package name */
    public int f257521b;

    /* renamed from: c, reason: collision with root package name */
    public AvatarPendantItem f257522c;

    /* renamed from: d, reason: collision with root package name */
    public AvatarPendantItem f257523d;

    /* renamed from: e, reason: collision with root package name */
    public int f257524e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.mobileqq.pendant.handler.a f257525f;

    /* renamed from: g, reason: collision with root package name */
    public int f257526g;

    /* renamed from: h, reason: collision with root package name */
    private View f257527h;

    /* renamed from: i, reason: collision with root package name */
    private ShopBlockContainer f257528i;

    /* renamed from: j, reason: collision with root package name */
    private QQViewPager f257529j;

    /* renamed from: k, reason: collision with root package name */
    private QUIPageTabBar f257530k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f257531l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f257532m;

    /* renamed from: n, reason: collision with root package name */
    private Button f257533n;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f257534o;

    /* renamed from: p, reason: collision with root package name */
    private Button f257535p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f257536q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f257537r;

    /* renamed from: s, reason: collision with root package name */
    private Context f257538s;

    /* renamed from: t, reason: collision with root package name */
    private AvatarPendantShopFragment f257539t;

    /* renamed from: u, reason: collision with root package name */
    private LinearLayout f257540u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f257541v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f257542w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f257543x;

    /* renamed from: y, reason: collision with root package name */
    private List<ShopBlockContainer> f257544y;

    /* renamed from: z, reason: collision with root package name */
    private AvatarShopItemBlockAdapter.b f257545z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements c.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AvatarPendantItem f257558a;

        a(AvatarPendantItem avatarPendantItem) {
            this.f257558a = avatarPendantItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this, (Object) avatarPendantItem);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
        @Override // b03.c.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(b03.d dVar) {
            int i3;
            PendantAvatarShopLayout pendantAvatarShopLayout;
            int i16;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                return;
            }
            int i18 = this.f257558a.price;
            if (((INtVipStatus) QRoute.api(INtVipStatus.class)).isSVip()) {
                AvatarPendantItem avatarPendantItem = this.f257558a;
                if (avatarPendantItem.discountReason == 5 && (i17 = avatarPendantItem.discountPrice) > 0 && avatarPendantItem.feeType == 2 && avatarPendantItem.userCanDiscount) {
                    i3 = i17;
                    pendantAvatarShopLayout = PendantAvatarShopLayout.this;
                    int i19 = pendantAvatarShopLayout.f257524e;
                    if (pendantAvatarShopLayout.f257526g != 4) {
                        i16 = 3;
                    } else {
                        i16 = 0;
                    }
                    pendantAvatarShopLayout.C(true, dVar, i3, i19, i16, this.f257558a);
                }
            }
            i3 = i18;
            pendantAvatarShopLayout = PendantAvatarShopLayout.this;
            int i192 = pendantAvatarShopLayout.f257524e;
            if (pendantAvatarShopLayout.f257526g != 4) {
            }
            pendantAvatarShopLayout.C(true, dVar, i3, i192, i16, this.f257558a);
        }

        @Override // b03.c.g
        public void onError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements QUIPageTabBar.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
            }
        }

        @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
        public void I0(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            PendantAvatarShopLayout.E = i3;
            PendantAvatarShopLayout.this.f257532m.setVisibility(8);
            PendantAvatarShopLayout.this.f257534o.setVisibility(8);
            if (z16) {
                int i16 = PendantAvatarShopLayout.this.f257526g;
                if (i16 == 23) {
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalTab(102, i3);
                } else if (i16 == 4) {
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantTab(102, i3);
                }
            }
            int i17 = PendantAvatarShopLayout.this.f257526g;
            if (i17 == 23) {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalTabItemExpose(i3);
            } else if (i17 == 4) {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantTabItemExpose(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PendantAvatarShopLayout.this.w("https://h5.qzone.qq.com/v2/vip/treasury/portal?_wv=16777216", (Activity) view.getContext());
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).goSplendidShop();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b03.d f257562d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f257563e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f257564f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AvatarPendantItem f257565h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f257566i;

        d(b03.d dVar, int i3, int i16, AvatarPendantItem avatarPendantItem, String str) {
            this.f257562d = dVar;
            this.f257563e = i3;
            this.f257564f = i16;
            this.f257565h = avatarPendantItem;
            this.f257566i = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PendantAvatarShopLayout.this, dVar, Integer.valueOf(i3), Integer.valueOf(i16), avatarPendantItem, str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!PendantAvatarShopLayout.D && (view != PendantAvatarShopLayout.this.f257533n || !PendantAvatarShopLayout.this.f257533n.getText().equals("\u5df2\u88c5\u626e"))) {
                HashMap hashMap = new HashMap();
                b03.d dVar = this.f257562d;
                if (dVar.f27638c == 0) {
                    PendantAvatarShopLayout.this.x(view, hashMap, this.f257563e, dVar, this.f257564f, this.f257565h);
                } else if (!TextUtils.isEmpty(this.f257566i)) {
                    PendantAvatarShopLayout.D = true;
                    PendantAvatarShopLayout.this.f257525f.removeMessages(1);
                    PendantAvatarShopLayout.this.f257525f.sendEmptyMessageDelayed(1, 1000L);
                    b03.d dVar2 = this.f257562d;
                    PendantAvatarShopLayout.A = dVar2.f27636a;
                    PendantAvatarShopLayout.B = dVar2.f27637b;
                    PendantAvatarShopLayout.C = this.f257565h.operateId;
                    if (dVar2.f27638c != 6002) {
                        hashMap.put("dt_pgid", "pg_user_avatar");
                        int i3 = PendantAvatarShopLayout.this.f257526g;
                        if (i3 == 23) {
                            IPendantAvatarShopReport iPendantAvatarShopReport = (IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class);
                            int i16 = (int) this.f257562d.f27637b;
                            int i17 = this.f257564f;
                            AvatarPendantItem avatarPendantItem = this.f257565h;
                            iPendantAvatarShopReport.onPersonalTryPay(i16, i17, avatarPendantItem.feeType, avatarPendantItem.strRuleid);
                            hashMap.put("pendant_set_type", 6);
                            VideoReport.reportEvent("ev_avatar_set", hashMap);
                        } else if (i3 == 4) {
                            IPendantAvatarShopReport iPendantAvatarShopReport2 = (IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class);
                            int i18 = (int) this.f257562d.f27637b;
                            int i19 = this.f257564f;
                            AvatarPendantItem avatarPendantItem2 = this.f257565h;
                            iPendantAvatarShopReport2.onPendantTryPay(i18, i19, avatarPendantItem2.feeType, avatarPendantItem2.strRuleid);
                            hashMap.put("pendant_set_type", 2);
                            hashMap.put("pendant_type", Integer.valueOf(this.f257564f + 1));
                            VideoReport.reportEvent("ev_pendant_set", hashMap);
                        }
                        PendantAvatarShopLayout pendantAvatarShopLayout = PendantAvatarShopLayout.this;
                        pendantAvatarShopLayout.v(this.f257566i, (Activity) pendantAvatarShopLayout.f257533n.getContext());
                    } else {
                        PendantAvatarShopLayout pendantAvatarShopLayout2 = PendantAvatarShopLayout.this;
                        pendantAvatarShopLayout2.w(this.f257566i, (Activity) pendantAvatarShopLayout2.f257533n.getContext());
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes16.dex */
    class e implements AvatarShopItemBlockAdapter.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.b
        public void a(AvatarPendantItem avatarPendantItem) {
            PendantAvatarShopLayout pendantAvatarShopLayout;
            AvatarPendantItem avatarPendantItem2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarPendantItem);
                return;
            }
            if (avatarPendantItem != null && avatarPendantItem.appid == 23) {
                PendantAvatarShopLayout pendantAvatarShopLayout2 = PendantAvatarShopLayout.this;
                AvatarPendantItem avatarPendantItem3 = pendantAvatarShopLayout2.f257522c;
                if (avatarPendantItem3 != null && avatarPendantItem3.itemId == avatarPendantItem.itemId && pendantAvatarShopLayout2.f257539t != null) {
                    PendantAvatarShopLayout.this.f257539t.Eh().cancelPreviewAvatar();
                }
                PendantAvatarShopLayout.this.f257522c = null;
            } else if (avatarPendantItem != null && (avatarPendantItem2 = (pendantAvatarShopLayout = PendantAvatarShopLayout.this).f257523d) != null && avatarPendantItem.appid == 4) {
                if (avatarPendantItem2.itemId == avatarPendantItem.itemId && pendantAvatarShopLayout.f257539t != null) {
                    PendantAvatarShopLayout.this.f257539t.Eh().cancelPreviewPendant();
                }
                PendantAvatarShopLayout.this.f257523d = null;
            }
            PendantAvatarShopLayout.this.C(false, null, 0, 0, 0, avatarPendantItem);
        }

        @Override // com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.b
        public void b(AvatarPendantItem avatarPendantItem, boolean z16, int i3) {
            int i16;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, avatarPendantItem, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (avatarPendantItem == null) {
                return;
            }
            PendantAvatarShopLayout pendantAvatarShopLayout = PendantAvatarShopLayout.this;
            pendantAvatarShopLayout.f257524e = i3;
            int i18 = avatarPendantItem.appid;
            if (i18 == 23) {
                pendantAvatarShopLayout.f257522c = avatarPendantItem;
                if (pendantAvatarShopLayout.f257539t != null) {
                    PendantAvatarShopLayout.this.f257539t.Eh().previewAvatar(avatarPendantItem.itemId, !z16);
                }
                i16 = PendantAvatarShopLayout.this.f257520a;
            } else if (i18 == 4) {
                pendantAvatarShopLayout.f257523d = avatarPendantItem;
                if (pendantAvatarShopLayout.f257539t != null) {
                    PendantAvatarShopLayout.this.f257539t.Eh().previewPendant(avatarPendantItem.itemId, true);
                }
                i16 = PendantAvatarShopLayout.this.f257521b;
            } else {
                i16 = 0;
            }
            for (int i19 = 0; i19 < PendantAvatarShopLayout.this.f257544y.size(); i19++) {
                AvatarShopItemBlockAdapter a16 = ((ShopBlockContainer) PendantAvatarShopLayout.this.f257544y.get(i19)).a();
                if (a16 != null) {
                    a16.notifyDataSetChanged();
                }
            }
            if (i16 == avatarPendantItem.itemId) {
                PendantAvatarShopLayout.this.D();
                return;
            }
            if (avatarPendantItem.feeType == -1) {
                b03.d dVar = new b03.d(new qcUserinfoServer.ItemCheckInfo());
                dVar.f27638c = 0;
                dVar.f27636a = avatarPendantItem.appid;
                dVar.f27637b = avatarPendantItem.itemId;
                PendantAvatarShopLayout pendantAvatarShopLayout2 = PendantAvatarShopLayout.this;
                int i26 = avatarPendantItem.price;
                if (z16) {
                    i17 = 2;
                } else {
                    i17 = 1;
                }
                pendantAvatarShopLayout2.C(true, dVar, i26, i3, i17, avatarPendantItem);
                return;
            }
            PendantAvatarShopLayout.this.r(avatarPendantItem);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(HiHealthStatusCodes.APP_ALREADY_IN_WORKOUT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        A = 0;
        B = 0L;
        C = "";
        D = false;
        E = 0;
    }

    public PendantAvatarShopLayout(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f257520a = 0;
        this.f257521b = 0;
        this.f257522c = null;
        this.f257523d = null;
        this.f257524e = 0;
        this.f257544y = new ArrayList();
        this.f257545z = new e();
        this.f257538s = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        TextView textView = this.f257537r;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        PendantAvatarShopLayout.this.f257537r.setVisibility(8);
                        PendantAvatarShopLayout.this.f257536q.setVisibility(0);
                    }
                }
            });
        }
    }

    private void B() {
        this.f257537r.setVisibility(0);
        this.f257536q.setVisibility(4);
        this.f257528i.setVisibility(4);
        this.f257530k.setVisibility(4);
        this.f257529j.setVisibility(4);
        this.f257540u.setVisibility(4);
        this.f257531l.setVisibility(8);
        this.f257532m.setVisibility(4);
        this.f257534o.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16, b03.d dVar, int i3, int i16, int i17, AvatarPendantItem avatarPendantItem) {
        this.f257532m.post(new Runnable(dVar, z16, i3, avatarPendantItem, i16, i17) { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b03.d f257552d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f257553e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f257554f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f257555h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f257556i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ int f257557m;

            {
                this.f257552d = dVar;
                this.f257553e = z16;
                this.f257554f = i3;
                this.f257555h = avatarPendantItem;
                this.f257556i = i16;
                this.f257557m = i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PendantAvatarShopLayout.this, dVar, Boolean.valueOf(z16), Integer.valueOf(i3), avatarPendantItem, Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:29:0x0154  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0195  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                String str2;
                String str3;
                String str4;
                int i18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f257552d == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PendantAvatarShopView", 2, "showPayButton isShow : " + this.f257553e + " ret : " + this.f257552d.f27638c + " itemid : " + this.f257552d.f27637b);
                }
                if (!this.f257553e) {
                    if (PendantAvatarShopLayout.this.f257532m != null && PendantAvatarShopLayout.this.f257534o != null) {
                        PendantAvatarShopLayout.this.f257532m.setVisibility(8);
                        PendantAvatarShopLayout.this.f257534o.setVisibility(8);
                        return;
                    }
                    return;
                }
                b03.d dVar2 = this.f257552d;
                String str5 = dVar2.f27641f;
                String str6 = dVar2.f27640e;
                int i19 = dVar2.f27638c;
                if (i19 != 0) {
                    if (i19 == 2002) {
                        str = "" + (this.f257554f / 100) + "\u5143\u7acb\u5373\u88c5\u626e";
                    } else if (i19 == 4002) {
                        str = "\u5f00\u901a\u4f1a\u5458";
                    } else if (i19 == 5002) {
                        str = "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458";
                    } else if (i19 == 6002) {
                        IPendantAvatarShopReport iPendantAvatarShopReport = (IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class);
                        int i26 = PendantAvatarShopLayout.this.f257526g;
                        AvatarPendantItem avatarPendantItem2 = this.f257555h;
                        int i27 = avatarPendantItem2.itemId;
                        int i28 = this.f257556i;
                        int i29 = avatarPendantItem2.feeType;
                        String str7 = avatarPendantItem2.strRuleid;
                        if (i26 == 23) {
                            str2 = "3001017";
                        } else {
                            str2 = "3001011";
                        }
                        String traceDetail = iPendantAvatarShopReport.getTraceDetail(i26, i27, i28, i29, str7, str2);
                        if (!TextUtils.isEmpty(traceDetail)) {
                            if (str6.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                str3 = str6 + "&trace_num=1&trace_detail=" + traceDetail;
                            } else {
                                str3 = str6 + "?trace_num=1&trace_detail=" + traceDetail;
                            }
                            str6 = str3;
                        }
                    } else if (i19 == 14002) {
                        str = "\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458";
                    } else if (i19 == 15002) {
                        str = "\u7eed\u8d39\u4f1a\u5458";
                    }
                    str4 = str6;
                    boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
                    PendantAvatarShopLayout.this.z(this.f257552d, this.f257557m, this.f257556i, str4, this.f257555h);
                    if (!str.equals("\u7acb\u5373\u8bbe\u7f6e")) {
                        Button button = PendantAvatarShopLayout.this.f257533n;
                        if (isNowThemeIsNight) {
                            i18 = R.drawable.kp3;
                        } else {
                            i18 = R.drawable.f161718kp2;
                        }
                        button.setBackgroundResource(i18);
                        PendantAvatarShopLayout.this.f257533n.setTextColor(-1);
                        PendantAvatarShopLayout.this.f257533n.setText(str);
                        PendantAvatarShopLayout.this.f257533n.setVisibility(0);
                        PendantAvatarShopLayout.this.f257532m.setVisibility(0);
                        PendantAvatarShopLayout.this.f257534o.setVisibility(8);
                        return;
                    }
                    PendantAvatarShopLayout.this.f257535p.setBackgroundResource(R.drawable.kp6);
                    PendantAvatarShopLayout.this.f257535p.setTextColor(Color.parseColor("#915B23"));
                    PendantAvatarShopLayout.this.f257535p.setText(str);
                    PendantAvatarShopLayout.this.f257534o.setVisibility(0);
                    PendantAvatarShopLayout.this.f257532m.setVisibility(8);
                    if (TextUtils.isEmpty(str5)) {
                        PendantAvatarShopLayout.this.f257543x.setVisibility(8);
                        return;
                    } else {
                        PendantAvatarShopLayout.this.f257543x.setText(str5);
                        PendantAvatarShopLayout.this.f257543x.setVisibility(0);
                        return;
                    }
                }
                str4 = str6;
                str = "\u7acb\u5373\u8bbe\u7f6e";
                boolean isNowThemeIsNight2 = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
                PendantAvatarShopLayout.this.z(this.f257552d, this.f257557m, this.f257556i, str4, this.f257555h);
                if (!str.equals("\u7acb\u5373\u8bbe\u7f6e")) {
                }
            }
        });
    }

    private void G(b03.a aVar) {
        this.f257528i.setAvatarPendantItems(aVar, 0);
        this.f257528i.setVisibility(0);
        this.f257537r.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<b03.b> list) {
        if (list.size() <= 0) {
            return;
        }
        String[] strArr = new String[list.size()];
        this.f257544y.clear();
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            b03.b bVar = list.get(i3);
            strArr[i3] = bVar.f27627d;
            ShopBlockContainer shopBlockContainer = new ShopBlockContainer(this.f257538s);
            this.f257544y.add(shopBlockContainer);
            shopBlockContainer.b(this.f257539t, this.f257545z, this);
            shopBlockContainer.setAvatarPendantItems(bVar, i3);
            hashMap.put(Integer.valueOf(i3), shopBlockContainer);
        }
        this.f257529j.setAdapter(new com.tencent.mobileqq.pendant.adapter.a(hashMap));
        this.f257530k.setTabData(strArr);
        this.f257530k.setCurrentPosition(0);
        this.f257530k.setViewPager(this.f257529j);
        E = 0;
        this.f257537r.setVisibility(8);
        this.f257530k.setVisibility(0);
        this.f257529j.setVisibility(0);
        int i16 = this.f257526g;
        if (i16 == 23) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalTab(101, 0);
        } else if (i16 == 4) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantTab(101, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", str);
        intent.setData(Uri.parse(str));
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view, Map<String, Object> map, int i3, b03.d dVar, int i16, AvatarPendantItem avatarPendantItem) {
        map.put("dt_pgid", "pg_user_avatar");
        if (i3 == 3) {
            AvatarPendantShopFragment avatarPendantShopFragment = this.f257539t;
            if (avatarPendantShopFragment != null) {
                avatarPendantShopFragment.Eh().setPendant((int) dVar.f27637b);
            }
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantSet((int) dVar.f27637b, i16, avatarPendantItem.strRuleid);
            map.put("pendant_set_type", 1);
            map.put("pendant_type", Integer.valueOf(i16 + 1));
            VideoReport.reportEvent("ev_pendant_set", map);
            D();
            this.f257521b = (int) dVar.f27637b;
            return;
        }
        if (i3 == 0) {
            map.put("avatar_set_type", 7);
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalSet((int) dVar.f27637b, i16, avatarPendantItem.strRuleid);
        } else if (i3 == 1) {
            map.put("avatar_set_type", 4);
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onQQShowSet((int) dVar.f27637b);
        } else if (i3 == 2) {
            map.put("avatar_set_type", 5);
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onSplendidShopSet((int) dVar.f27637b);
        }
        AvatarPendantShopFragment avatarPendantShopFragment2 = this.f257539t;
        if (avatarPendantShopFragment2 != null) {
            avatarPendantShopFragment2.Eh().setAvatar((int) dVar.f27637b, avatarPendantItem.operateId);
        }
        VideoReport.reportEvent("ev_avatar_set", map);
        D();
        this.f257520a = (int) dVar.f27637b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(b03.d dVar, int i3, int i16, String str, AvatarPendantItem avatarPendantItem) {
        d dVar2 = new d(dVar, i3, i16, avatarPendantItem, str);
        this.f257533n.setOnClickListener(dVar2);
        this.f257535p.setOnClickListener(dVar2);
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f257533n.setText("\u5df2\u88c5\u626e");
        this.f257533n.setBackgroundResource(R.drawable.f161719kp4);
        this.f257532m.setVisibility(0);
        this.f257532m.setOnClickListener(null);
        this.f257533n.setTextColor(Color.parseColor("#7affffff"));
        this.f257533n.setVisibility(0);
        this.f257534o.setVisibility(8);
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            B();
            b03.c.g(4, new c.f() { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
                    }
                }

                @Override // b03.c.f
                public void onError(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        PendantAvatarShopLayout.this.A();
                    } else {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                    }
                }

                @Override // b03.c.f
                public void onSuccess(List<b03.b> list) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    } else {
                        PendantAvatarShopLayout.this.f257530k.post(new Runnable(list) { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.5.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f257550d;

                            {
                                this.f257550d = list;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) list);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    PendantAvatarShopLayout.this.I(this.f257550d);
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        B();
        b03.c.g(23, new c.f() { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PendantAvatarShopLayout.this);
                }
            }

            @Override // b03.c.f
            public void onError(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    PendantAvatarShopLayout.this.A();
                } else {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                }
            }

            @Override // b03.c.f
            public void onSuccess(List<b03.b> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                } else {
                    PendantAvatarShopLayout.this.f257530k.post(new Runnable(list) { // from class: com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ List f257547d;

                        {
                            this.f257547d = list;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) list);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                PendantAvatarShopLayout.this.I(this.f257547d);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        });
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalShopExpose();
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        B();
        if (this.f257539t != null) {
            b03.a aVar = new b03.a();
            aVar.f27625b = 0;
            aVar.f27626c = true;
            List<AvatarPendantItem> zplanData = this.f257539t.Eh().getZplanData();
            aVar.f27624a = zplanData;
            if (zplanData != null) {
                Iterator<AvatarPendantItem> it = zplanData.iterator();
                while (it.hasNext()) {
                    it.next().feeType = -1;
                }
            }
            G(aVar);
        }
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onQQShowShopExpose();
    }

    public void r(AvatarPendantItem avatarPendantItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) avatarPendantItem);
        } else if (avatarPendantItem == null) {
            C(false, null, 0, 0, 0, avatarPendantItem);
        } else {
            b03.c.d(avatarPendantItem.appid, avatarPendantItem.itemId, new a(avatarPendantItem));
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f257526g == 23 && this.f257533n.getVisibility() == 0 && this.f257533n.getText().equals("\u5df2\u88c5\u626e")) {
            this.f257533n.setVisibility(4);
            this.f257532m.setVisibility(4);
            this.f257522c = null;
            int i3 = 0;
            this.f257520a = 0;
            while (true) {
                List<ShopBlockContainer> list = this.f257544y;
                if (list != null && i3 < list.size()) {
                    AvatarShopItemBlockAdapter a16 = this.f257544y.get(i3).a();
                    if (a16 != null) {
                        a16.notifyDataSetChanged();
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public View t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f257527h;
    }

    public AvatarPendantItem u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AvatarPendantItem) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 == 23) {
            return this.f257522c;
        }
        return this.f257523d;
    }

    public void y(AvatarPendantShopFragment avatarPendantShopFragment) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarPendantShopFragment);
            return;
        }
        this.f257539t = avatarPendantShopFragment;
        this.f257525f = new com.tencent.mobileqq.pendant.handler.a(avatarPendantShopFragment.Eh());
        this.f257527h = LayoutInflater.from(this.f257538s).inflate(R.layout.fux, (ViewGroup) null);
        int i17 = -1;
        this.f257527h.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        QQViewPager qQViewPager = (QQViewPager) this.f257527h.findViewById(R.id.vyy);
        this.f257529j = qQViewPager;
        qQViewPager.disableGesture(true);
        this.f257529j.disableDrop(true);
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) this.f257527h.findViewById(R.id.f220702q);
        this.f257530k = qUIPageTabBar;
        qUIPageTabBar.setTabChangeListener(new b());
        TextView textView = (TextView) this.f257527h.findViewById(R.id.f87444ud);
        this.f257531l = textView;
        textView.setText("\u63a2\u7d22\u66f4\u591a" + com.tencent.mobileqq.vip.api.b.a().getSplendidTitle() + "\u5934\u50cf");
        this.f257531l.setOnClickListener(new c());
        this.f257532m = (RelativeLayout) this.f257527h.findViewById(R.id.yfy);
        this.f257533n = (Button) this.f257527h.findViewById(R.id.tke);
        this.f257534o = (RelativeLayout) this.f257527h.findViewById(R.id.yfz);
        this.f257535p = (Button) this.f257527h.findViewById(R.id.tki);
        this.f257543x = (TextView) this.f257527h.findViewById(R.id.f95815g0);
        Drawable drawable = t().getResources().getDrawable(R.drawable.f162467ln4);
        drawable.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
        Drawable drawable2 = t().getResources().getDrawable(R.drawable.f162466ln3);
        drawable2.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
        TextView textView2 = (TextView) this.f257527h.findViewById(R.id.f95515f7);
        this.f257537r = textView2;
        textView2.setCompoundDrawables(drawable, null, null, null);
        TextView textView3 = (TextView) this.f257527h.findViewById(R.id.f95315en);
        this.f257536q = textView3;
        textView3.setCompoundDrawables(drawable2, null, null, null);
        ShopBlockContainer shopBlockContainer = (ShopBlockContainer) this.f257527h.findViewById(R.id.t8y);
        this.f257528i = shopBlockContainer;
        shopBlockContainer.b(avatarPendantShopFragment, this.f257545z, this);
        this.f257540u = (LinearLayout) this.f257527h.findViewById(R.id.f26740ec);
        this.f257542w = (ImageView) this.f257527h.findViewById(R.id.f26730eb);
        this.f257541v = (TextView) this.f257527h.findViewById(R.id.f26750ed);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
        RelativeLayout relativeLayout = this.f257532m;
        if (isNowThemeIsNight) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        relativeLayout.setBackgroundColor(i3);
        RelativeLayout relativeLayout2 = this.f257534o;
        if (isNowThemeIsNight) {
            i17 = -16777216;
        }
        relativeLayout2.setBackgroundColor(i17);
        QUIPageTabBar qUIPageTabBar2 = this.f257530k;
        if (isNowThemeIsNight) {
            i16 = 1000;
        } else {
            i16 = 1001;
        }
        qUIPageTabBar2.setThemeId(i16);
    }
}
