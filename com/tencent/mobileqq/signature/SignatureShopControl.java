package com.tencent.mobileqq.signature;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b03.c;
import b03.d;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter;
import com.tencent.mobileqq.signature.view.SignatureShopBlockContainer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureShopControl {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static int f288388n;

    /* renamed from: o, reason: collision with root package name */
    public static long f288389o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f288390p;

    /* renamed from: a, reason: collision with root package name */
    public AvatarPendantItem f288391a;

    /* renamed from: b, reason: collision with root package name */
    public int f288392b;

    /* renamed from: c, reason: collision with root package name */
    private View f288393c;

    /* renamed from: d, reason: collision with root package name */
    private QQViewPager f288394d;

    /* renamed from: e, reason: collision with root package name */
    private QUIPageTabBar f288395e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f288396f;

    /* renamed from: g, reason: collision with root package name */
    private Button f288397g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f288398h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f288399i;

    /* renamed from: j, reason: collision with root package name */
    private Context f288400j;

    /* renamed from: k, reason: collision with root package name */
    private SignTextEditFragment f288401k;

    /* renamed from: l, reason: collision with root package name */
    private List<SignatureShopBlockContainer> f288402l;

    /* renamed from: m, reason: collision with root package name */
    private SignatureShopItemBlockAdapter.a f288403m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements QUIPageTabBar.i {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f288411d;

        a(String[] strArr) {
            this.f288411d = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureShopControl.this, (Object) strArr);
            }
        }

        @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
        public void I0(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            SignatureShopControl.this.f288396f.setVisibility(8);
            String[] strArr = this.f288411d;
            if (strArr != null && strArr.length > i3 && z16) {
                com.tencent.mobileqq.signature.report.a.c().n(102, this.f288411d[i3]);
            }
            com.tencent.mobileqq.signature.report.a.c().o(this.f288411d[i3]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements SignatureShopItemBlockAdapter.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements c.g {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f288414a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f288415b;

            a(int i3, AvatarPendantItem avatarPendantItem) {
                this.f288414a = i3;
                this.f288415b = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, Integer.valueOf(i3), avatarPendantItem);
                }
            }

            @Override // b03.c.g
            public void a(d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                } else {
                    SignatureShopControl.this.o(true, dVar, this.f288414a, this.f288415b);
                }
            }

            @Override // b03.c.g
            public void onError(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureShopControl.this);
            }
        }

        @Override // com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter.a
        public void a(AvatarPendantItem avatarPendantItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarPendantItem);
                return;
            }
            if (SignatureShopControl.this.f288401k != null && SignatureShopControl.this.f288401k.I != null && SignatureShopControl.this.f288401k.H != null && avatarPendantItem != null) {
                SignatureShopControl.this.l(null);
                SignatureShopControl.this.f288401k.H.tplId = SignatureShopControl.this.f288401k.I.tplId;
                SignatureShopControl.this.r(SignatureManagerForTool.j().m(SignatureShopControl.this.f288401k.I.tplId, true));
                SignatureShopControl.this.o(false, null, 0, avatarPendantItem);
            }
        }

        @Override // com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter.a
        public void b(AvatarPendantItem avatarPendantItem, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarPendantItem, i3);
                return;
            }
            if (SignatureShopControl.this.f288401k != null && SignatureShopControl.this.f288401k.H != null && avatarPendantItem != null) {
                SignatureShopControl.this.l(avatarPendantItem);
                SignatureTemplateInfo m3 = SignatureManagerForTool.j().m(avatarPendantItem.itemId, true);
                SignatureShopControl.this.f288401k.H.tplId = avatarPendantItem.itemId;
                SignatureShopControl.this.f288401k.li();
                SignatureShopControl.this.r(m3);
                b03.c.d(9, avatarPendantItem.itemId, new a(i3, avatarPendantItem));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f288388n = 0;
        f288389o = 0L;
        f288390p = false;
    }

    public SignatureShopControl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f288391a = null;
        this.f288402l = new ArrayList();
        this.f288403m = new b();
        this.f288400j = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        TextView textView = this.f288399i;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.signature.SignatureShopControl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureShopControl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        SignatureShopControl.this.f288399i.setVisibility(8);
                        SignatureShopControl.this.f288398h.setVisibility(0);
                    }
                }
            });
        }
    }

    private void n() {
        this.f288399i.setVisibility(0);
        this.f288398h.setVisibility(4);
        this.f288395e.setVisibility(4);
        this.f288394d.setVisibility(4);
        this.f288396f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(List<b03.b> list) {
        if (list != null && list.size() != 0) {
            String[] strArr = new String[list.size()];
            this.f288402l.clear();
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < list.size(); i3++) {
                b03.b bVar = list.get(i3);
                int i16 = 0;
                while (true) {
                    List<AvatarPendantItem> list2 = bVar.f27624a;
                    if (list2 != null && i16 < list2.size()) {
                        int i17 = bVar.f27624a.get(i16).itemId;
                        if (i17 > 1) {
                            SignatureManagerForTool.j().m(i17, true);
                        }
                        i16++;
                    }
                }
                strArr[i3] = bVar.f27627d;
                SignatureShopBlockContainer signatureShopBlockContainer = new SignatureShopBlockContainer(this.f288400j);
                this.f288402l.add(signatureShopBlockContainer);
                signatureShopBlockContainer.b(this.f288401k, this.f288403m, this);
                signatureShopBlockContainer.setAvatarPendantItems(bVar, i3);
                hashMap.put(Integer.valueOf(i3), signatureShopBlockContainer);
                com.tencent.mobileqq.signature.report.a.c().n(101, bVar.f27627d);
            }
            this.f288394d.setAdapter(new com.tencent.mobileqq.signature.adapter.a(hashMap));
            this.f288395e.setTabData(strArr);
            this.f288395e.setImportantForAccessibility(2);
            this.f288395e.setCurrentPosition(0);
            this.f288395e.setViewPager(this.f288394d);
            this.f288395e.setTabChangeListener(new a(strArr));
            this.f288399i.setVisibility(8);
            this.f288395e.setVisibility(0);
            this.f288394d.setVisibility(0);
            return;
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(SignatureTemplateInfo signatureTemplateInfo) {
        if (signatureTemplateInfo != null) {
            if (!TextUtils.isEmpty(signatureTemplateInfo.fontColor)) {
                this.f288401k.J.setTextColor(Color.parseColor(signatureTemplateInfo.fontColor));
                this.f288401k.M.setTextColor(Color.parseColor(signatureTemplateInfo.fontColor));
            }
            this.f288401k.M.setText(signatureTemplateInfo.defText);
            if (!"1".equals(signatureTemplateInfo.f307842id)) {
                VasResDrawable Fh = this.f288401k.Fh(Integer.parseInt(signatureTemplateInfo.f307842id));
                if (Fh != null) {
                    this.f288401k.J.setBackground(Fh);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(signatureTemplateInfo.dot9png)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                this.f288401k.J.setBackground(URLDrawable.getDrawable(SignatureManagerForTool.k(0, signatureTemplateInfo.dot9png), obtain));
                return;
            }
            return;
        }
        this.f288401k.J.setBackground(com.tencent.mobileqq.urldrawable.b.f306350a);
    }

    public View i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f288393c;
    }

    public AvatarPendantItem j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AvatarPendantItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f288391a == null) {
            this.f288391a = new AvatarPendantItem();
        }
        return this.f288391a;
    }

    public void k(SignTextEditFragment signTextEditFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) signTextEditFragment);
            return;
        }
        this.f288401k = signTextEditFragment;
        this.f288393c = LayoutInflater.from(this.f288400j).inflate(R.layout.fux, (ViewGroup) null);
        this.f288393c.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        QQViewPager qQViewPager = (QQViewPager) this.f288393c.findViewById(R.id.vyy);
        this.f288394d = qQViewPager;
        qQViewPager.disableGesture(true);
        this.f288394d.disableDrop(true);
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) this.f288393c.findViewById(R.id.f220702q);
        this.f288395e = qUIPageTabBar;
        qUIPageTabBar.setIsShowLine(false);
        this.f288395e.setThemeId(1001);
        this.f288396f = (RelativeLayout) this.f288393c.findViewById(R.id.yfy);
        this.f288397g = (Button) this.f288393c.findViewById(R.id.tke);
        Drawable drawable = i().getResources().getDrawable(R.drawable.f162467ln4);
        drawable.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
        Drawable drawable2 = i().getResources().getDrawable(R.drawable.f162466ln3);
        drawable2.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
        TextView textView = (TextView) this.f288393c.findViewById(R.id.f95515f7);
        this.f288399i = textView;
        textView.setCompoundDrawables(drawable, null, null, null);
        TextView textView2 = (TextView) this.f288393c.findViewById(R.id.f95315en);
        this.f288398h = textView2;
        textView2.setCompoundDrawables(drawable2, null, null, null);
    }

    public void l(AvatarPendantItem avatarPendantItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) avatarPendantItem);
            return;
        }
        this.f288391a = avatarPendantItem;
        for (int i3 = 0; i3 < this.f288402l.size(); i3++) {
            this.f288402l.get(i3).a().notifyDataSetChanged();
        }
    }

    public void o(boolean z16, d dVar, int i3, AvatarPendantItem avatarPendantItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), dVar, Integer.valueOf(i3), avatarPendantItem);
        } else {
            this.f288396f.post(new Runnable(z16, dVar, avatarPendantItem) { // from class: com.tencent.mobileqq.signature.SignatureShopControl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f288407d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ d f288408e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ AvatarPendantItem f288409f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.signature.SignatureShopControl$4$a */
                /* loaded from: classes18.dex */
                class a implements View.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            if (SignatureShopControl.this.f288401k != null) {
                                SignatureShopControl.this.f288401k.Uh();
                            }
                            SignatureShopControl.this.f288396f.setVisibility(4);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                {
                    this.f288407d = z16;
                    this.f288408e = dVar;
                    this.f288409f = avatarPendantItem;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SignatureShopControl.this, Boolean.valueOf(z16), dVar, avatarPendantItem);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String str;
                    boolean isNowThemeIsNight;
                    int i16;
                    int i17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!this.f288407d) {
                        if (SignatureShopControl.this.f288396f != null) {
                            SignatureShopControl.this.f288396f.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    int i18 = this.f288408e.f27638c;
                    if (i18 != 0) {
                        if (i18 == 2002) {
                            str = "" + (this.f288409f.price / 100) + "\u5143\u8d2d\u4e70\u5e76\u53d1\u5e03";
                        } else if (i18 == 4002) {
                            str = "\u5f00\u901a\u4f1a\u5458\u5e76\u53d1\u5e03";
                        } else if (i18 == 5002) {
                            str = "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u5e76\u53d1\u5e03";
                        } else if (i18 != 6002) {
                            if (i18 == 14002) {
                                str = "\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458\u5e76\u53d1\u5e03";
                            } else if (i18 == 15002) {
                                str = "\u7eed\u8d39\u4f1a\u5458\u5e76\u53d1\u5e03";
                            }
                        }
                        isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
                        RelativeLayout relativeLayout = SignatureShopControl.this.f288396f;
                        if (!isNowThemeIsNight) {
                            i16 = -16777216;
                        } else {
                            i16 = -1;
                        }
                        relativeLayout.setBackgroundColor(i16);
                        if (!str.equals("\u4fdd\u5b58\u5e76\u53d1\u5e03")) {
                            Button button = SignatureShopControl.this.f288397g;
                            if (isNowThemeIsNight) {
                                i17 = R.drawable.kp3;
                            } else {
                                i17 = R.drawable.f161718kp2;
                            }
                            button.setBackgroundResource(i17);
                            SignatureShopControl.this.f288397g.setTextColor(-1);
                        } else {
                            SignatureShopControl.this.f288397g.setBackgroundResource(R.drawable.kp6);
                            SignatureShopControl.this.f288397g.setTextColor(Color.parseColor("#915B23"));
                        }
                        SignatureShopControl.this.f288397g.setText(str);
                        SignatureShopControl.this.f288396f.setVisibility(0);
                        SignatureShopControl.this.f288397g.setOnClickListener(new a());
                    }
                    str = "\u4fdd\u5b58\u5e76\u53d1\u5e03";
                    isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
                    RelativeLayout relativeLayout2 = SignatureShopControl.this.f288396f;
                    if (!isNowThemeIsNight) {
                    }
                    relativeLayout2.setBackgroundColor(i16);
                    if (!str.equals("\u4fdd\u5b58\u5e76\u53d1\u5e03")) {
                    }
                    SignatureShopControl.this.f288397g.setText(str);
                    SignatureShopControl.this.f288396f.setVisibility(0);
                    SignatureShopControl.this.f288397g.setOnClickListener(new a());
                }
            });
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            n();
            b03.c.g(9, new c.f() { // from class: com.tencent.mobileqq.signature.SignatureShopControl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SignatureShopControl.this);
                    }
                }

                @Override // b03.c.f
                public void onError(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        SignatureShopControl.this.m();
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
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(list) { // from class: com.tencent.mobileqq.signature.SignatureShopControl.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f288405d;

                            {
                                this.f288405d = list;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) list);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    SignatureShopControl.this.q(this.f288405d);
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
}
