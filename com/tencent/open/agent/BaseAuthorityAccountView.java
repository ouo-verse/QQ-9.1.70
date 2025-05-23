package com.tencent.open.agent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.manager.WtloginManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseAuthorityAccountView extends LinearLayout {
    protected QQCustomDialog C;
    protected float D;
    protected float E;
    protected View F;
    protected View G;
    protected RelativeLayout H;
    protected LinearLayout I;
    protected ActionSheet J;
    protected FixedBounceScrollView K;
    protected boolean L;

    /* renamed from: d, reason: collision with root package name */
    protected SharedPreferences f339577d;

    /* renamed from: e, reason: collision with root package name */
    protected SharedPreferences.Editor f339578e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f339579f;

    /* renamed from: h, reason: collision with root package name */
    protected WtloginManager f339580h;

    /* renamed from: i, reason: collision with root package name */
    protected ArrayList<String> f339581i;

    /* renamed from: m, reason: collision with root package name */
    protected LinearLayout f339582m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class DelAccountRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f339584d;

        public DelAccountRunnable(String str) {
            this.f339584d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BaseAuthorityAccountView.this.b(this.f339584d);
            String d16 = BaseAuthorityAccountView.this.d();
            t.f("BaseAuthorityAccountView", "delAccountRunnable curUin: " + d16);
            if (d16 != null && d16.equals(this.f339584d)) {
                final String str = null;
                if (BaseAuthorityAccountView.this.f339581i.size() == 1) {
                    if (!BaseAuthorityAccountView.this.m() && (context = BaseAuthorityAccountView.this.f339579f) != null && (context instanceof QuickLoginAuthorityActivity)) {
                        ((QuickLoginAuthorityActivity) context).f339988a0 = null;
                        ((QuickLoginAuthorityActivity) context).F0(null);
                    }
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= BaseAuthorityAccountView.this.f339581i.size()) {
                            break;
                        }
                        String str2 = BaseAuthorityAccountView.this.f339581i.get(i3);
                        if (!this.f339584d.equals(str2)) {
                            str = str2;
                            break;
                        }
                        i3++;
                    }
                    BaseAuthorityAccountView.this.post(new Runnable() { // from class: com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!BaseAuthorityAccountView.this.l(str, false)) {
                                Context context2 = BaseAuthorityAccountView.this.f339579f;
                                if (context2 instanceof QuickLoginAuthorityActivity) {
                                    ((QuickLoginAuthorityActivity) context2).H2(str, false);
                                }
                            }
                            QQCustomDialog qQCustomDialog = BaseAuthorityAccountView.this.C;
                            if (qQCustomDialog != null) {
                                qQCustomDialog.dismiss();
                                BaseAuthorityAccountView.this.C = null;
                            }
                        }
                    });
                }
            }
            t.b("BaseAuthorityAccountView", "--> after delete account");
            BaseAuthorityAccountView.this.k();
            BaseAuthorityAccountView.this.post(new Runnable() { // from class: com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseAuthorityAccountView.this.s();
                    QQCustomDialog qQCustomDialog = BaseAuthorityAccountView.this.C;
                    if (qQCustomDialog != null) {
                        qQCustomDialog.dismiss();
                        BaseAuthorityAccountView.this.C = null;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f339588d;

        a(RelativeLayout relativeLayout) {
            this.f339588d = relativeLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            t.b("BaseAuthorityAccountView", "onLayoutChange height=" + view.getHeight() + ", contentHeight=" + this.f339588d.getHeight());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f339588d.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams.height = -2;
            }
            layoutParams.addRule(12);
            this.f339588d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag instanceof String) {
                BaseAuthorityAccountView.this.n((String) tag);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f339591d;

        c(String str) {
            this.f339591d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BaseAuthorityAccountView.this.l(this.f339591d, true)) {
                Context context = BaseAuthorityAccountView.this.f339579f;
                if (context instanceof QuickLoginAuthorityActivity) {
                    ((QuickLoginAuthorityActivity) context).H2(this.f339591d, true);
                }
            }
            BaseAuthorityAccountView.this.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f339593d;

        d(String str) {
            this.f339593d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQCustomDialog qQCustomDialog;
            if (i3 == 1) {
                ThreadManagerV2.executeOnSubThread(new DelAccountRunnable(this.f339593d));
            } else if (i3 == 0 && (qQCustomDialog = BaseAuthorityAccountView.this.C) != null) {
                qQCustomDialog.dismiss();
                BaseAuthorityAccountView.this.C = null;
            }
        }
    }

    public BaseAuthorityAccountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f339580h = null;
        this.C = null;
        this.L = false;
        this.f339579f = context;
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        t.b("BaseAuthorityAccountView", "-->deleteAccount--account to delete is " + com.tencent.open.agent.util.g.C(str));
        up3.b.g(str);
        SharedPreferences sharedPreferences = this.f339577d;
        if (sharedPreferences == null) {
            return;
        }
        String[] n3 = com.tencent.open.agent.util.g.n(sharedPreferences);
        ArrayList arrayList = new ArrayList();
        if (n3 != null) {
            for (String str2 : n3) {
                arrayList.add(str2);
            }
        }
        while (arrayList.contains("")) {
            arrayList.remove("");
        }
        if (arrayList.contains(str)) {
            arrayList.remove(str);
            Iterator it = arrayList.iterator();
            String str3 = "";
            while (it.hasNext()) {
                str3 = str3 + "," + ((String) it.next());
            }
            this.f339578e.putString("accList", str3);
            this.f339578e.commit();
        }
        if (str.equals(this.f339577d.getString("last_account", ""))) {
            t.b("BaseAuthorityAccountView", "-->deleteAccount--account to delete equals last account, clear last account");
            this.f339578e.remove("last_account").commit();
        }
        File file = new File(OpenSdkVirtualUtil.n(OpenSdkVirtualUtil.b(str)));
        if (!file.exists()) {
            file.delete();
        }
    }

    private int g() {
        float c16 = x.c(this.f339579f, 72.0f);
        float f16 = ((((int) (((this.E * 2.0d) / 3.0d) / c16)) - 2) * c16) + (c16 / 2.0f);
        t.b("BaseAuthorityAccountView", "-->getMaxListHeight maxHeight = " + f16);
        return (int) f16;
    }

    private void j() {
        AppInterface appInterface = (AppInterface) ((AppActivity) this.f339579f).getAppRuntime();
        this.f339580h = (WtloginManager) appInterface.getManager(1);
        SharedPreferences sharedPreferences = this.f339579f.getSharedPreferences("accountList", 0);
        this.f339577d = sharedPreferences;
        this.f339578e = sharedPreferences.edit();
        if (!TextUtils.isEmpty(appInterface.getAccount())) {
            up3.b.b(appInterface.getAccount());
        }
        String i3 = up3.b.i();
        if (!TextUtils.isEmpty(i3)) {
            up3.b.b(i3);
        }
        DisplayMetrics displayMetrics = this.f339579f.getResources().getDisplayMetrics();
        this.D = displayMetrics.widthPixels;
        this.E = displayMetrics.heightPixels;
    }

    public void c() {
        ActionSheet actionSheet = this.J;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.J.dismiss();
        }
    }

    protected String d() {
        View findViewById = this.I.findViewById(R.id.f163902bs);
        if (findViewById == null) {
            t.e("BaseAuthorityAccountView", "--> DelAccountRunnable null == currUinView");
            return null;
        }
        CharSequence text = ((TextView) findViewById).getText();
        if (TextUtils.isEmpty(text)) {
            t.e("BaseAuthorityAccountView", "--> DelAccountRunnable text isEmpty");
            return null;
        }
        return text.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        return R.layout.f168453wk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return R.layout.f168451wi;
    }

    protected void h() {
        ActionSheet b16 = AuthUIUtil.b(getContext(), null);
        this.J = b16;
        b16.setActionContentView(this.G, null);
        ViewGroup rootView = this.J.getRootView();
        if (rootView instanceof DispatchActionMoveScrollView) {
            ((DispatchActionMoveScrollView) rootView).dispatchActionMove = true;
        }
        RelativeLayout actionContentView = this.J.getActionContentView();
        actionContentView.addOnLayoutChangeListener(new a(actionContentView));
        FixedBounceScrollView fixedBounceScrollView = (FixedBounceScrollView) this.G.findViewById(R.id.f163887b9);
        this.K = fixedBounceScrollView;
        fixedBounceScrollView.setMaxHeight(g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        t.b("BaseAuthorityAccountView", "-->initBaseUI");
        View inflate = LayoutInflater.from(this.f339579f).inflate(e(), (ViewGroup) null);
        this.G = inflate;
        this.H = (RelativeLayout) inflate.findViewById(R.id.a0v);
        this.I = (LinearLayout) this.G.findViewById(R.id.f163848aa);
        LinearLayout linearLayout = new LinearLayout(this.f339579f);
        this.f339582m = linearLayout;
        linearLayout.setOrientation(1);
        this.I.addView(this.f339582m);
        k();
        s();
    }

    public void k() {
        ArrayList<String> j3 = up3.b.j();
        this.f339581i = j3;
        if (j3 != null) {
            t.b("BaseAuthorityAccountView", "-->initOrUpdateAccountList");
            for (int i3 = 0; i3 < this.f339581i.size(); i3++) {
                t.b("BaseAuthorityAccountView", " \u7b2c" + i3 + "\u8d26\u53f7: " + this.f339581i.get(i3));
            }
            return;
        }
        t.b("BaseAuthorityAccountView", "-->initOrUpdateAccountList account list = null");
    }

    abstract boolean l(String str, boolean z16);

    abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(String str) {
        t.b("BaseAuthorityAccountView", "-->showAccountConfirm uin = " + com.tencent.open.agent.util.g.C(str));
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f339579f, 230);
        this.C = createCustomDialog;
        createCustomDialog.setContentView(R.layout.custom_dialog);
        this.C.setTitle(getResources().getString(R.string.f9u));
        this.C.setMessageTextSize(18.0f);
        this.C.setMessage(str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        d dVar = new d(str);
        this.C.setNegativeButton(R.string.f211115jy, dVar);
        this.C.setPositiveButton(R.string.f211125jz, dVar);
        this.C.show();
    }

    public void o() {
        if (this.J == null) {
            h();
        }
        if (!this.J.isShowing()) {
            this.J.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, ImageView imageView) {
        t.b("BaseAuthorityAccountView", "-->updateAccountFace uin=" + com.tencent.open.agent.util.g.C(str));
        com.tencent.open.virtual.f.l(imageView, str, 140);
    }

    protected void q(String str, QQProAvatarView qQProAvatarView) {
        t.b("BaseAuthorityAccountView", "-->updateAccountFace uin=" + com.tencent.open.agent.util.g.C(str));
        com.tencent.open.virtual.f.m(qQProAvatarView, str, 140);
    }

    public void r() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.open.agent.BaseAuthorityAccountView.2
            @Override // java.lang.Runnable
            public void run() {
                t.b("BaseAuthorityAccountView", "--> handler message UPDATE_DROP_DOWN_VIEWS");
                BaseAuthorityAccountView.this.k();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.BaseAuthorityAccountView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseAuthorityAccountView.this.s();
                    }
                });
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        t.b("BaseAuthorityAccountView", "-->updateDropDownViews");
        this.f339582m.removeAllViews();
        ArrayList<String> arrayList = this.f339581i;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i3 = 0; i3 < this.f339581i.size(); i3++) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f339579f).inflate(f(), (ViewGroup) this.f339582m, false);
                viewGroup.setBackgroundResource(R.drawable.f161303ue);
                String str = this.f339581i.get(i3);
                ((TextView) viewGroup.findViewById(R.id.f163902bs)).setText(str);
                TextView textView = (TextView) viewGroup.findViewById(R.id.f163889bb);
                textView.setMaxWidth((int) ((this.D * 3.0f) / 5.0f));
                String c16 = com.tencent.mobileqq.login.account.b.c(str);
                if (TextUtils.isEmpty(c16)) {
                    c16 = str;
                }
                textView.setText(c16);
                QQProAvatarView qQProAvatarView = (QQProAvatarView) viewGroup.findViewById(R.id.f163882b4);
                ((ImageView) viewGroup.findViewById(R.id.dql)).setVisibility(8);
                ImageView imageView = (ImageView) viewGroup.findViewById(R.id.dps);
                imageView.setVisibility(0);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(R.drawable.anc);
                imageView.setTag(str);
                imageView.setOnClickListener(new b());
                q(str, qQProAvatarView);
                viewGroup.setOnClickListener(new c(str));
                this.f339582m.addView(viewGroup);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(String str) {
        String c16 = com.tencent.mobileqq.login.account.b.c(str);
        if (TextUtils.isEmpty(c16)) {
            c16 = str;
        }
        View view = this.F;
        if (view != null) {
            QQProAvatarView qQProAvatarView = (QQProAvatarView) view.findViewById(R.id.a0s);
            ((TextView) this.F.findViewById(R.id.a0t)).setText(com.tencent.open.base.j.i(c16, 12, true));
            q(str, qQProAvatarView);
        }
        t.b("BaseAuthorityAccountView", "\u5f53\u524d\u8d26\u53f7\uff1a" + com.tencent.open.agent.util.g.C(str));
    }
}
