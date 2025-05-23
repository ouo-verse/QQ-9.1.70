package com.tencent.mobileqq.guild.widget.selector;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.j;
import com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.data.AddressInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLocationActionSheet {

    /* renamed from: a, reason: collision with root package name */
    public GProLocationInfo f236543a;

    /* renamed from: b, reason: collision with root package name */
    public Context f236544b;

    /* renamed from: c, reason: collision with root package name */
    public QBaseActivity f236545c;

    /* renamed from: d, reason: collision with root package name */
    public BaseQQAppInterface f236546d;

    /* renamed from: e, reason: collision with root package name */
    public GuildActionSheetProfileEdit f236547e;

    /* renamed from: f, reason: collision with root package name */
    private String f236548f;

    /* renamed from: g, reason: collision with root package name */
    private String f236549g;

    /* renamed from: h, reason: collision with root package name */
    private String f236550h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f236551i;

    /* renamed from: j, reason: collision with root package name */
    private String[] f236552j;

    /* renamed from: l, reason: collision with root package name */
    private long f236554l;

    /* renamed from: m, reason: collision with root package name */
    private AddressInfo f236555m;

    /* renamed from: n, reason: collision with root package name */
    private AddressInfo[] f236556n;

    /* renamed from: o, reason: collision with root package name */
    private Object f236557o;

    /* renamed from: p, reason: collision with root package name */
    private View f236558p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f236559q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f236560r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f236561s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f236562t;

    /* renamed from: u, reason: collision with root package name */
    private GuildProvinceSelectorView f236563u;

    /* renamed from: v, reason: collision with root package name */
    private j f236564v;

    /* renamed from: w, reason: collision with root package name */
    private QQPermission f236565w;

    /* renamed from: y, reason: collision with root package name */
    public g f236567y;

    /* renamed from: z, reason: collision with root package name */
    private BusinessObserver f236568z;

    /* renamed from: k, reason: collision with root package name */
    private String f236553k = "1";

    /* renamed from: x, reason: collision with root package name */
    private boolean f236566x = false;
    IProfileEditBusinessApi.OnCheckCSMListener A = new IProfileEditBusinessApi.OnCheckCSMListener() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.1
        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
        public void onCheckDone(boolean z16) {
            GuildLocationActionSheet.this.C();
            if (z16) {
                GuildLocationActionSheet guildLocationActionSheet = GuildLocationActionSheet.this;
                guildLocationActionSheet.K(guildLocationActionSheet.f236543a);
                GuildLocationActionSheet.this.f236546d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildLocationActionSheet.this.I();
                    }
                });
            } else {
                QQToast.makeText(GuildLocationActionSheet.this.f236544b, R.string.f142600jt, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(GuildLocationActionSheet.this.f236544b));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildLocationActionSheet", 2, "onCheckDone ", Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
        public void onUpdateResult(int i3) {
            if (i3 != -2) {
                if (i3 == -1) {
                    QQToast.makeText(GuildLocationActionSheet.this.f236544b, R.string.f1510616o, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(GuildLocationActionSheet.this.f236544b));
                }
            } else {
                GuildLocationActionSheet guildLocationActionSheet = GuildLocationActionSheet.this;
                Context context = guildLocationActionSheet.f236544b;
                guildLocationActionSheet.S(context, context.getString(R.string.f142610ju));
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildLocationActionSheet.this.C();
                        QQToast.makeText(GuildLocationActionSheet.this.f236544b, R.string.f142600jt, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(GuildLocationActionSheet.this.f236544b));
                    }
                }, 20000L);
            }
        }
    };
    IProfileEditBusinessApi.OnGetUserLocationListener B = new IProfileEditBusinessApi.OnGetUserLocationListener() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.2
        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnGetUserLocationListener
        public void onGetUserLocation(final boolean z16, final String[] strArr, boolean z17) {
            GuildActionSheetProfileEdit guildActionSheetProfileEdit = GuildLocationActionSheet.this.f236547e;
            if (guildActionSheetProfileEdit != null && z17 && !guildActionSheetProfileEdit.isShowing()) {
                GuildLocationActionSheet.this.f236547e.show();
            }
            if (Math.abs(System.currentTimeMillis() - GuildLocationActionSheet.this.f236554l) > 1200) {
                GuildLocationActionSheet.this.D(z16, strArr);
            } else {
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildLocationActionSheet.this.D(z16, strArr);
                    }
                }, 1200L);
            }
        }
    };
    IProfileEditBusinessApi.OnLocationUpdateListener C = new IProfileEditBusinessApi.OnLocationUpdateListener() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.3
        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnLocationUpdateListener
        public void OnLocationUpdate(final boolean z16, final String str, final String str2, final String str3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GuildLocationActionSheet.this.f236562t != null) {
                        GuildLocationActionSheet.this.f236562t.setVisibility(8);
                    }
                    if (z16) {
                        if (GuildLocationActionSheet.this.f236560r != null) {
                            GuildLocationActionSheet.this.f236560r.setText(str);
                            GuildLocationActionSheet.this.f236560r.setContentDescription(HardCodeUtil.qqStr(R.string.f152341_5) + str);
                        }
                        if (GuildLocationActionSheet.this.f236561s != null && GuildLocationActionSheet.this.f236559q != null) {
                            String str4 = "";
                            if (TextUtils.isEmpty(str2)) {
                                GuildLocationActionSheet.this.f236558p.setClickable(false);
                                GuildLocationActionSheet.this.f236561s.setText("");
                                GuildLocationActionSheet.this.f236559q.setTextColor(ContextCompat.getColorStateList(GuildLocationActionSheet.this.f236559q.getContext(), R.color.qui_common_text_secondary));
                            } else {
                                GuildLocationActionSheet.this.f236558p.setClickable(true);
                                TextView textView = GuildLocationActionSheet.this.f236561s;
                                if (!str2.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                                    str4 = str2;
                                }
                                textView.setText(str4);
                                GuildLocationActionSheet.this.f236559q.setTextColor(ContextCompat.getColorStateList(GuildLocationActionSheet.this.f236559q.getContext(), R.color.qui_common_text_primary));
                                GuildLocationActionSheet.this.f236561s.setContentDescription(HardCodeUtil.qqStr(R.string.f152351_6) + str2);
                            }
                        }
                        GuildLocationActionSheet.this.f236550h = str3;
                        return;
                    }
                    if (GuildLocationActionSheet.this.f236566x) {
                        GuildLocationActionSheet.this.f236566x = false;
                    }
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements IProfileEditBusinessApi.OnGetUserLocationListener {
        a() {
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnGetUserLocationListener
        public void onGetUserLocation(boolean z16, String[] strArr, boolean z17) {
            GuildLocationActionSheet.this.B.onGetUserLocation(z16, strArr, z17);
            if (!z16) {
                QQToastUtil.showQQToast(1, R.string.f142590js);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QQGuildUIUtil.v()) {
                GuildLocationActionSheet.this.M();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f236584d;

        c(boolean z16) {
            this.f236584d = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QQGuildUIUtil.v()) {
                GuildLocationActionSheet guildLocationActionSheet = GuildLocationActionSheet.this;
                com.tencent.mobileqq.guild.widget.countrySelect.a aVar = new com.tencent.mobileqq.guild.widget.countrySelect.a(guildLocationActionSheet.f236544b, guildLocationActionSheet.f236553k, this.f236584d);
                aVar.setOnGetUserLocationListener(GuildLocationActionSheet.this.B);
                aVar.show();
                GuildLocationActionSheet.this.f236547e.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f236586d;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements GuildActionSheetProfileEdit.d {
            a() {
            }

            @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
            public void onConfirm() {
                boolean z16;
                String[] l3 = GuildLocationActionSheet.this.f236563u.l();
                IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener = GuildLocationActionSheet.this.B;
                if (l3 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                onGetUserLocationListener.onGetUserLocation(z16, l3, true);
            }

            @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
            public void onDismiss() {
                GuildLocationActionSheet.this.B.onGetUserLocation(false, null, true);
            }
        }

        d(boolean z16) {
            this.f236586d = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QQGuildUIUtil.v()) {
                GuildLocationActionSheet guildLocationActionSheet = GuildLocationActionSheet.this;
                if (guildLocationActionSheet.f236552j != null) {
                    strArr = GuildLocationActionSheet.this.f236552j;
                } else {
                    strArr = new String[]{"0", "0", "0"};
                }
                guildLocationActionSheet.f236552j = strArr;
                if (GuildLocationActionSheet.this.f236563u == null) {
                    GuildLocationActionSheet guildLocationActionSheet2 = GuildLocationActionSheet.this;
                    guildLocationActionSheet2.f236563u = new GuildProvinceSelectorView(guildLocationActionSheet2.f236545c, this.f236586d);
                    GuildLocationActionSheet.this.f236563u.c("\u9009\u62e9\u7701\u4efd");
                }
                GuildLocationActionSheet.this.f236563u.n(GuildLocationActionSheet.this.f236553k, GuildLocationActionSheet.this.f236552j);
                if (GuildLocationActionSheet.this.f236563u.a() == null) {
                    GuildLocationActionSheet.this.f236563u.b(new a());
                }
                GuildLocationActionSheet.this.f236563u.d();
                GuildLocationActionSheet.this.f236547e.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements GuildActionSheetProfileEdit.d {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
        public void onConfirm() {
            String str;
            GuildLocationActionSheet guildLocationActionSheet = GuildLocationActionSheet.this;
            if (guildLocationActionSheet.f236550h != null) {
                str = GuildLocationActionSheet.this.f236550h;
            } else {
                str = "";
            }
            guildLocationActionSheet.f236550h = str;
            GuildLocationActionSheet guildLocationActionSheet2 = GuildLocationActionSheet.this;
            guildLocationActionSheet2.f236567y.a(guildLocationActionSheet2.f236550h, GuildLocationActionSheet.this.z());
            GuildLocationActionSheet.this.L();
            GuildLocationActionSheet.this.B();
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
        public void onDismiss() {
            GuildLocationActionSheet.this.L();
            GuildLocationActionSheet.this.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f extends QQPermission.BasePermissionsListener {
        f() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildLocationActionSheet.this.N();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildLocationActionSheet", 1, "deny permissions:" + list);
            }
            GuildLocationActionSheet.this.f236566x = true;
            GuildLocationActionSheet.this.D(false, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface g {
        void a(String str, GProLocationInfo gProLocationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.10
            @Override // java.lang.Runnable
            public void run() {
                if (GuildLocationActionSheet.this.f236564v != null) {
                    GuildLocationActionSheet.this.f236564v.dismiss();
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        QQProgressDialog qQProgressDialog = this.f236551i;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f236551i.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z16, String[] strArr) {
        AddressInfo addressInfo;
        if (z16 && strArr != null && strArr.length == 4) {
            if (!TextUtils.isEmpty(strArr[0])) {
                addressInfo = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getCountryByCode(this.f236546d, strArr[0]);
            } else {
                addressInfo = null;
            }
            if (addressInfo == null) {
                this.C.OnLocationUpdate(false, "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("GuildLocationActionSheet", 2, "invalid country code!! | cournty code is :" + strArr[0]);
                    return;
                }
                return;
            }
            this.f236553k = strArr[0];
            P();
            int length = strArr.length;
            int i3 = 0;
            for (int i16 = 1; i16 < length; i16++) {
                if (!TextUtils.isEmpty(strArr[i16])) {
                    this.f236552j[i3] = strArr[i16];
                    i3++;
                }
            }
            J();
            AddressInfo addressInfo2 = this.f236555m;
            if (addressInfo2 == null) {
                this.C.OnLocationUpdate(false, "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("GuildLocationActionSheet", 2, "invalid country!! | cournty is : null");
                    return;
                }
                return;
            }
            this.f236548f = addressInfo2.name;
            this.f236550h = E();
            IProfileEditBusinessApi.OnLocationUpdateListener onLocationUpdateListener = this.C;
            AddressInfo addressInfo3 = this.f236555m;
            onLocationUpdateListener.OnLocationUpdate(true, addressInfo3.name, A(addressInfo3.count), this.f236550h);
            return;
        }
        this.C.OnLocationUpdate(false, "", "", "");
        if (QLog.isColorLevel()) {
            QLog.e("GuildLocationActionSheet", 2, "doOnGetUserLocation error");
        }
    }

    private void F() {
        if (this.f236565w == null) {
            this.f236565w = QQPermissionFactory.getQQPermission(this.f236545c, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_PROFILE_LOCATION));
        }
        if (!y()) {
            O();
        } else {
            N();
        }
    }

    private void H(GProLocationInfo gProLocationInfo) {
        String[] strArr;
        if (gProLocationInfo != null) {
            strArr = T(gProLocationInfo);
        } else {
            strArr = null;
        }
        P();
        if (strArr != null) {
            if (((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).isFirstPickLocation(this.f236546d) && strArr[0].equals("0")) {
                return;
            }
            this.f236553k = strArr[0];
            int length = strArr.length;
            for (int i3 = 1; i3 < length; i3++) {
                this.f236552j[i3 - 1] = strArr[i3];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.f236546d, false, null);
        GuildActionSheetProfileEdit X = GuildActionSheetProfileEdit.X(this.f236544b, isNowThemeIsNight);
        this.f236547e = X;
        ((TextView) X.findViewById(R.id.title)).setText(HardCodeUtil.qqStr(R.string.f142390j9));
        View findViewById = this.f236547e.findViewById(R.id.f82364go);
        View findViewById2 = this.f236547e.findViewById(R.id.f82294gh);
        this.f236558p = this.f236547e.findViewById(R.id.f82334gl);
        this.f236559q = (TextView) this.f236547e.findViewById(R.id.f82344gm);
        this.f236560r = (TextView) this.f236547e.findViewById(R.id.f82314gj);
        this.f236561s = (TextView) this.f236547e.findViewById(R.id.f82354gn);
        this.f236562t = (ImageView) this.f236547e.findViewById(R.id.f82324gk);
        if (!TextUtils.isEmpty(this.f236548f)) {
            this.f236560r.setText(this.f236548f);
            this.f236560r.setContentDescription(HardCodeUtil.qqStr(R.string.f152341_5) + this.f236548f);
        }
        findViewById.setOnClickListener(new b());
        findViewById2.setOnClickListener(new c(isNowThemeIsNight));
        this.f236558p.setOnClickListener(new d(isNowThemeIsNight));
        this.f236547e.a0(new e());
        String str = "";
        if (TextUtils.isEmpty(this.f236549g)) {
            TextView textView = this.f236559q;
            textView.setTextColor(ContextCompat.getColorStateList(textView.getContext(), R.color.qui_common_text_secondary));
            this.f236561s.setText("");
            this.f236558p.setClickable(false);
        } else {
            TextView textView2 = this.f236559q;
            textView2.setTextColor(ContextCompat.getColorStateList(textView2.getContext(), R.color.qui_common_text_primary));
            this.f236558p.setClickable(true);
            TextView textView3 = this.f236561s;
            if (!this.f236549g.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                str = this.f236549g;
            }
            textView3.setText(str);
            this.f236561s.setContentDescription(HardCodeUtil.qqStr(R.string.f152351_6) + this.f236549g);
        }
        try {
            QBaseActivity qBaseActivity = this.f236545c;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                R();
                this.f236547e.show();
            }
        } catch (Exception e16) {
            QLog.e("GuildLocationActionSheet", 1, "action sheet show error", e16);
        }
    }

    private void J() {
        AddressInfo countryByCode = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getCountryByCode(this.f236546d, this.f236553k);
        this.f236555m = countryByCode;
        if (countryByCode == null) {
            return;
        }
        int i3 = countryByCode.count;
        this.f236556n = new AddressInfo[i3];
        if (i3 == 0) {
            return;
        }
        int length = this.f236552j.length;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (!"0".equals(this.f236552j[i17])) {
                AddressInfo[] addressInfoArr = this.f236556n;
                countryByCode = countryByCode.dataMap.get(this.f236552j[i17]);
                addressInfoArr[i16] = countryByCode;
                i16++;
                if (countryByCode == null) {
                    return;
                }
            }
        }
        if (i16 == 0) {
            this.f236556n[i16] = countryByCode.dataMap.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ImageView imageView = this.f236562t;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (!NetworkUtil.isNetSupport(this.f236544b)) {
            QQToast.makeText(this.f236544b, R.string.f1510616o, 0).show(this.f236545c.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            this.f236554l = System.currentTimeMillis();
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).requestUserLocation(this.f236546d);
        }
    }

    private void O() {
        this.f236565w.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new f());
    }

    private void P() {
        this.f236552j = new String[]{"0", "0", "0"};
        this.f236556n = null;
    }

    private void R() {
        if (this.f236564v == null) {
            this.f236564v = new j(this.f236544b);
        }
        this.f236564v.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Context context, String str) {
        if (this.f236551i == null) {
            this.f236551i = new QQProgressDialog(context, 44);
        }
        this.f236551i.setMessage(str);
        try {
            QBaseActivity qBaseActivity = this.f236545c;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                this.f236551i.show();
            }
        } catch (Exception e16) {
            QLog.e("GuildLocationActionSheet", 1, "showWaitingDialog error", e16);
        }
    }

    private String[] T(GProLocationInfo gProLocationInfo) {
        return new String[]{ProfileCodecUtils.decodeRemoteCode(gProLocationInfo.g()), ProfileCodecUtils.decodeRemoteCode(gProLocationInfo.k()), ProfileCodecUtils.decodeRemoteCode(gProLocationInfo.b()), ProfileCodecUtils.decodeRemoteCode(gProLocationInfo.e())};
    }

    private boolean y() {
        if (this.f236565w.hasPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GProLocationInfo z() {
        if (TextUtils.isEmpty(this.f236550h)) {
            return null;
        }
        GProLocationInfo gProLocationInfo = new GProLocationInfo();
        gProLocationInfo.q(this.f236548f);
        gProLocationInfo.r(ProfileCodecUtils.encodeLocCode(this.f236553k));
        String[] split = this.f236550h.split("-");
        int length = split.length;
        if (length > 0) {
            int i3 = 1;
            if (!gProLocationInfo.l() || length != 1) {
                if (!TextUtils.equals(this.f236548f, split[0]) || length <= 1) {
                    i3 = 0;
                }
                int length2 = this.f236552j.length;
                for (int i16 = 0; i16 < length; i16++) {
                    String str = split[i16];
                    if (i16 == i3 + 0) {
                        gProLocationInfo.s(str);
                        int i17 = i16 - i3;
                        if (i17 < length2) {
                            gProLocationInfo.t(ProfileCodecUtils.encodeLocCode(this.f236552j[i17]));
                        }
                    } else if (i16 == i3 + 1) {
                        gProLocationInfo.m(str);
                        int i18 = i16 - i3;
                        if (i18 < length2) {
                            gProLocationInfo.n(ProfileCodecUtils.encodeLocCode(this.f236552j[i18]));
                        }
                    } else if (i16 == i3 + 2) {
                        gProLocationInfo.o(str);
                        int i19 = i16 - i3;
                        if (i19 < length2) {
                            gProLocationInfo.p(ProfileCodecUtils.encodeLocCode(this.f236552j[i19]));
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GuildLocationActionSheet", 2, "concatLocationInfo gProLocationInfo: " + gProLocationInfo);
                }
            }
        }
        return gProLocationInfo;
    }

    public String A(int i3) {
        AddressInfo addressInfo;
        if (i3 == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            AddressInfo[] addressInfoArr = this.f236556n;
            if (addressInfoArr != null && (addressInfo = addressInfoArr[i16]) != null && !"0".equals(addressInfo.code)) {
                sb5.append(this.f236556n[i16].name);
                sb5.append("-");
            }
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        return sb6.substring(0, sb6.length() - 1);
    }

    public String E() {
        String[] strArr = new String[4];
        strArr[0] = this.f236553k;
        strArr[1] = "0";
        strArr[2] = "0";
        strArr[3] = "0";
        AddressInfo[] addressInfoArr = this.f236556n;
        if (addressInfoArr != null) {
            int length = addressInfoArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                AddressInfo addressInfo = this.f236556n[i3];
                if (addressInfo == null) {
                    break;
                }
                strArr[addressInfo.addressType] = addressInfo.code;
            }
        }
        return ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).generateLocationString(this.f236546d, strArr);
    }

    public void G(@NonNull Context context, BaseQQAppInterface baseQQAppInterface, GProLocationInfo gProLocationInfo, g gVar) {
        this.f236546d = baseQQAppInterface;
        this.f236543a = gProLocationInfo;
        this.f236544b = context;
        this.f236545c = (QBaseActivity) context;
        this.f236567y = gVar;
        if (this.B != null) {
            BusinessObserver createLBSObserver = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).createLBSObserver(new a());
            this.f236568z = createLBSObserver;
            this.f236546d.addObserver(createLBSObserver);
        }
    }

    public void K(GProLocationInfo gProLocationInfo) {
        H(gProLocationInfo);
        J();
        this.f236550h = E();
        AddressInfo addressInfo = this.f236555m;
        if (addressInfo != null) {
            this.f236548f = addressInfo.name;
            this.f236549g = A(addressInfo.count);
        }
    }

    public void L() {
        this.f236546d.removeObserver(this.f236568z);
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).destroyLocationSearchManager(this.f236546d, this.f236544b, this.f236557o);
        if (QLog.isColorLevel()) {
            QLog.d("GuildLocationActionSheet", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    public void Q() {
        if (this.f236546d != null && this.f236543a != null && this.f236544b != null && this.f236567y != null) {
            Object initSearchManager = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).initSearchManager(this.f236546d, this.f236544b, this.A);
            if (initSearchManager != null) {
                this.f236557o = initSearchManager;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildLocationActionSheet", 2, "show");
            }
        }
    }
}
