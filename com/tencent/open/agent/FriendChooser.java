package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import gp3.e;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class FriendChooser extends QBaseActivity implements e.b, View.OnClickListener, Animation.AnimationListener {

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/OpenSdkApi/Inject_open_app_client.yml", version = 1)
    private static ArrayList<Class<? extends com.tencent.open.adapter.b>> N0;
    protected gp3.b C0;
    protected float D0;
    public boolean E0;
    protected TranslateAnimation G0;
    protected TranslateAnimation H0;
    protected AlphaAnimation I0;
    protected ImageView J0;

    /* renamed from: a0, reason: collision with root package name */
    protected View f339787a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f339788b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f339789c0;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f339790d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f339791e0;

    /* renamed from: f0, reason: collision with root package name */
    protected LinearLayout f339792f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ViewStub f339793g0;

    /* renamed from: h0, reason: collision with root package name */
    protected InnerFrameManager f339794h0;

    /* renamed from: i0, reason: collision with root package name */
    protected HorizontalScrollView f339795i0;

    /* renamed from: j0, reason: collision with root package name */
    protected GridView f339796j0;

    /* renamed from: k0, reason: collision with root package name */
    protected Button f339797k0;

    /* renamed from: l0, reason: collision with root package name */
    protected Button f339798l0;

    /* renamed from: m0, reason: collision with root package name */
    protected TextView f339799m0;

    /* renamed from: n0, reason: collision with root package name */
    protected RelativeLayout f339800n0;

    /* renamed from: o0, reason: collision with root package name */
    protected View f339801o0;

    /* renamed from: p0, reason: collision with root package name */
    protected EditText f339802p0;

    /* renamed from: q0, reason: collision with root package name */
    protected ImageButton f339803q0;

    /* renamed from: r0, reason: collision with root package name */
    protected Button f339804r0;

    /* renamed from: s0, reason: collision with root package name */
    protected View f339805s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f339806t0;

    /* renamed from: u0, reason: collision with root package name */
    protected String f339807u0;

    /* renamed from: v0, reason: collision with root package name */
    protected String f339808v0;

    /* renamed from: w0, reason: collision with root package name */
    protected XListView f339809w0;

    /* renamed from: x0, reason: collision with root package name */
    protected e f339810x0;

    /* renamed from: y0, reason: collision with root package name */
    protected g f339811y0;

    /* renamed from: z0, reason: collision with root package name */
    protected ArrayList<String> f339812z0;
    protected List<Friend> A0 = new ArrayList();
    protected ArrayList<Friend> B0 = new ArrayList<>();
    protected InputMethodManager F0 = null;
    protected int K0 = 99999;
    protected int L0 = 99999;
    final Handler M0 = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            Friend friend = (Friend) FriendChooser.this.f339810x0.getItem(i3);
            if (friend != null && FriendChooser.this.C0.n(friend.f340346d)) {
                FriendChooser.this.C0.o(friend.f340346d);
                FriendChooser.this.B0.remove(friend);
                FriendChooser.this.setupDoneBtn();
                ((OpenFrame) FriendChooser.this.f339794h0.getCurrentView()).o();
                FriendChooser.this.adjustGridView(false);
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        float f339814d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        float f339815e = 0.0f;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f339814d = motionEvent.getRawX();
                this.f339815e = motionEvent.getRawY();
            } else if (action == 2 && (motionEvent.getRawX() - this.f339814d > 10.0f || motionEvent.getRawY() - this.f339815e > 10.0f)) {
                FriendChooser.this.F0.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(com.tencent.widget.AdapterView<?> adapterView, View view, int i3, long j3) {
            Friend friend = FriendChooser.this.A0.get(i3);
            if (friend != null && !FriendChooser.this.C0.n(friend.f340346d)) {
                int k3 = FriendChooser.this.C0.k();
                FriendChooser friendChooser = FriendChooser.this;
                if (k3 >= friendChooser.K0) {
                    friendChooser.K2();
                    return;
                }
                OpenFrame openFrame = (OpenFrame) friendChooser.f339794h0.getCurrentView();
                FriendChooser.this.B0.add(friend);
                FriendChooser.this.C0.m(friend.f340346d);
                FriendChooser.this.setupDoneBtn();
                openFrame.o();
                FriendChooser.this.adjustGridView(false);
                FriendChooser.this.f339802p0.setText("");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                FriendChooser friendChooser = FriendChooser.this;
                friendChooser.f339795i0.scrollTo(friendChooser.f339796j0.getLayoutParams().width, 0);
                if (QLog.isColorLevel()) {
                    QLog.e("qqBaseActivity", 2, "" + FriendChooser.this.f339796j0.getLayoutParams().width);
                }
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e extends gp3.a {

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements e.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImageView f339820d;

            a(ImageView imageView) {
                this.f339820d = imageView;
            }

            @Override // gp3.e.b
            public void onImageLoaded(String str, Bitmap bitmap, String str2) {
                this.f339820d.setImageBitmap(bitmap);
            }
        }

        protected e() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FriendChooser.this.B0.size();
        }

        @Override // gp3.a, android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 >= 0 && i3 < FriendChooser.this.B0.size()) {
                return FriendChooser.this.B0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            i iVar;
            Friend friend = (Friend) getItem(i3);
            if (view == null) {
                i iVar2 = new i();
                View inflate = FriendChooser.this.getLayoutInflater().inflate(R.layout.f168221pn, (ViewGroup) null);
                iVar2.f339830c = (ImageView) inflate.findViewById(R.id.c0o);
                inflate.setTag(iVar2);
                iVar = iVar2;
                view = inflate;
            } else {
                iVar = (i) view.getTag();
            }
            if (friend == null) {
                QLog.e("qqBaseActivity", 1, "FriendChooser rr == nul pos=", Integer.valueOf(i3));
            } else {
                String str = friend.f340349h;
                if (str == null || "".equals(str)) {
                    friend.f340349h = gp3.f.a(FriendChooser.this.F2(), friend.f340346d);
                }
                Bitmap b16 = gp3.e.a().b(friend.f340349h);
                if (b16 == null) {
                    iVar.f339830c.setImageResource(R.drawable.f160830com);
                    gp3.e.a().c(friend.f340349h, new a(iVar.f339830c));
                } else {
                    iVar.f339830c.setImageBitmap(b16);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements Comparator<Friend> {
        protected f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Friend friend, Friend friend2) {
            return friend.F.compareToIgnoreCase(friend2.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g extends gp3.a {

        /* renamed from: d, reason: collision with root package name */
        protected List<Friend> f339823d;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements e.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImageView f339825d;

            a(ImageView imageView) {
                this.f339825d = imageView;
            }

            @Override // gp3.e.b
            public void onImageLoaded(String str, Bitmap bitmap, String str2) {
                this.f339825d.setImageBitmap(bitmap);
            }
        }

        public g(List<Friend> list) {
            this.f339823d = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f339823d.size();
        }

        @Override // gp3.a, android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 >= 0 && i3 < this.f339823d.size()) {
                return this.f339823d.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            i iVar;
            if (view == null) {
                view = FriendChooser.this.getLayoutInflater().inflate(R.layout.byh, viewGroup, false);
                iVar = new i();
                iVar.f339830c = (ImageView) view.findViewById(R.id.dvo);
                iVar.f339828a = (TextView) view.findViewById(R.id.tv_name);
                iVar.f339829b = (TextView) view.findViewById(R.id.kaw);
                view.setTag(iVar);
            } else {
                iVar = (i) view.getTag();
            }
            List<Friend> list = this.f339823d;
            if (list != null && list.size() != 0) {
                Friend friend = this.f339823d.get(i3);
                String str = friend.f340348f;
                if (str != null && !"".equals(str)) {
                    iVar.f339828a.setText(friend.f340348f);
                } else {
                    iVar.f339828a.setText(friend.f340347e);
                }
                String str2 = friend.f340349h;
                if (str2 == null || "".equals(str2)) {
                    friend.f340349h = gp3.f.a(FriendChooser.this.F2(), friend.f340346d);
                }
                Bitmap b16 = gp3.e.a().b(friend.f340349h);
                if (b16 == null) {
                    iVar.f339830c.setImageResource(R.drawable.f160830com);
                    gp3.e.a().c(friend.f340349h, new a(iVar.f339830c));
                } else {
                    iVar.f339830c.setImageBitmap(b16);
                }
                if (FriendChooser.this.C0.n(friend.f340346d)) {
                    iVar.f339829b.setText(R.string.asy);
                } else {
                    iVar.f339829b.setText("");
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static class i {

        /* renamed from: a, reason: collision with root package name */
        TextView f339828a;

        /* renamed from: b, reason: collision with root package name */
        TextView f339829b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f339830c;

        i() {
        }
    }

    static {
        ArrayList<Class<? extends com.tencent.open.adapter.b>> arrayList = new ArrayList<>();
        N0 = arrayList;
        arrayList.add(com.tencent.open.adapter.c.class);
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    public abstract String F2();

    protected void G2() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f339793g0.inflate();
        this.f339800n0 = relativeLayout;
        this.f339802p0 = (EditText) relativeLayout.findViewById(R.id.et_search_keyword);
        this.f339803q0 = (ImageButton) this.f339800n0.findViewById(R.id.ib_clear_text);
        this.f339804r0 = (Button) this.f339800n0.findViewById(R.id.btn_cancel_search);
        this.f339801o0 = this.f339800n0.findViewById(R.id.result_layout);
        this.f339809w0 = (XListView) this.f339800n0.findViewById(R.id.search_result_list);
        this.f339805s0 = this.f339800n0.findViewById(R.id.f166412fa0);
        this.f339802p0.addTextChangedListener(new h());
        this.f339803q0.setOnClickListener(this);
        this.f339804r0.setOnClickListener(this);
        this.f339809w0.setBackgroundResource(R.drawable.bg_texture);
        this.f339809w0.setDividerHeight(0);
        g gVar = new g(this.A0);
        this.f339811y0 = gVar;
        this.f339809w0.setAdapter((ListAdapter) gVar);
        this.f339801o0.setOnClickListener(this);
        this.f339809w0.setOnTouchListener(new b());
        this.f339809w0.setOnItemClickListener(new c());
    }

    @SuppressLint({"NewApi"})
    protected void H2() {
        this.f339795i0.setOverScrollMode(2);
        e eVar = new e();
        this.f339810x0 = eVar;
        this.f339796j0.setAdapter((ListAdapter) eVar);
        this.f339796j0.setSmoothScrollbarEnabled(false);
        this.f339797k0.setVisibility(0);
        this.f339797k0.setText(this.f339807u0);
        this.f339797k0.setEnabled(false);
        this.f339798l0.setVisibility(4);
        this.f339798l0.setText(this.f339808v0);
        this.f339796j0.setOnItemClickListener(new a());
        this.f339798l0.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I2() {
        if (this.F0 == null) {
            this.F0 = (InputMethodManager) super.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.f339787a0.getHeight());
        this.G0 = translateAnimation;
        translateAnimation.setDuration(300L);
        this.G0.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.I0 = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.G0.setAnimationListener(this);
        this.f339792f0.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f339792f0.getHeight() + this.f339787a0.getHeight()));
        this.f339792f0.startAnimation(this.G0);
        this.F0.toggleSoftInput(0, 0);
        this.E0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J2(Friend friend) {
        boolean z16;
        if (this.C0.n(friend.f340346d)) {
            this.B0.remove(friend);
            this.C0.o(friend.f340346d);
            z16 = false;
        } else if (this.C0.k() >= this.K0) {
            K2();
            return;
        } else {
            this.B0.add(friend);
            this.C0.m(friend.f340346d);
            z16 = true;
        }
        adjustGridView(z16);
        setupDoneBtn();
    }

    public abstract void K2();

    /* JADX INFO: Access modifiers changed from: protected */
    public void L2(boolean z16, boolean z17, String str, String str2) {
        if (z16) {
            this.f339789c0.setVisibility(0);
            this.f339789c0.setText(str);
            this.f339790d0.setVisibility(4);
            setLayerType(this.f339789c0);
        } else {
            this.f339789c0.setVisibility(4);
            this.f339790d0.setVisibility(4);
        }
        if (z17) {
            this.f339791e0.setVisibility(0);
        } else {
            this.f339791e0.setVisibility(4);
        }
        this.f339788b0.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M2(boolean z16, boolean z17, String str, String str2, String str3) {
        if (z16) {
            this.f339789c0.setVisibility(0);
            this.f339789c0.setText(str);
            this.f339790d0.setVisibility(4);
            setLayerType(this.f339789c0);
        } else {
            this.f339789c0.setVisibility(4);
            this.f339790d0.setVisibility(4);
        }
        if (z17) {
            this.f339791e0.setVisibility(0);
            this.f339791e0.setText(str3);
        } else {
            this.f339791e0.setVisibility(4);
        }
        this.f339788b0.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustGridView(boolean z16) {
        this.f339799m0.setText(this.B0.size() + "/" + this.K0);
        this.f339796j0.setNumColumns(this.B0.size());
        ViewGroup.LayoutParams layoutParams = this.f339796j0.getLayoutParams();
        layoutParams.width = (int) (((float) ((this.B0.size() * 36) + (this.B0.size() * 10))) * this.D0);
        this.f339796j0.setLayoutParams(layoutParams);
        if (this.C0.k() == this.K0) {
            this.J0.setVisibility(4);
        } else {
            this.J0.setVisibility(0);
        }
        if (z16) {
            this.M0.sendEmptyMessageDelayed(100, 200L);
        }
        this.f339810x0.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void initTitleBar() {
        this.f339806t0 = super.getString(R.string.hdb);
        this.f339807u0 = super.getString(R.string.a5q);
        this.f339808v0 = super.getString(R.string.a5q);
        this.f339789c0.setVisibility(4);
        this.f339790d0.setVisibility(4);
        this.f339791e0.setVisibility(0);
        this.f339791e0.setText(R.string.f170190ih);
        this.f339788b0.setText(this.f339806t0);
        this.f339789c0.setOnClickListener(this);
        this.f339791e0.setOnClickListener(this);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.H0) {
            this.f339792f0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else if (animation == this.G0) {
            if (this.f339800n0 == null) {
                G2();
            }
            this.f339801o0.startAnimation(this.I0);
            this.f339800n0.setVisibility(0);
            this.f339802p0.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        RelativeLayout relativeLayout = this.f339800n0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            quitSearchState();
            return true;
        }
        if (this.f339794h0.b() != 1) {
            return super.onBackEvent();
        }
        this.f339794h0.i(0);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f339789c0) {
            onBackEvent();
        } else if (view == this.f339791e0) {
            super.finish();
        } else if (view == this.f339798l0) {
            startCreateOrAdd();
        } else if (view == this.f339803q0) {
            this.f339802p0.setText("");
            this.F0.showSoftInput(this.f339802p0, 0);
        } else if (view == this.f339804r0) {
            quitSearchState();
        } else if (view == this.f339801o0) {
            quitSearchState();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BaseQQAppInterface baseQQAppInterface;
        super.requestWindowFeature(1);
        super.onCreate(bundle);
        super.setTheme(R.style.f173428d2);
        super.setContentView(getLayoutId());
        AppRuntime appRuntime = getAppRuntime();
        try {
            N0.get(0).newInstance().a((AppInterface) appRuntime);
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, e16, new Object[0]);
        }
        this.C0 = gp3.b.g();
        this.f339787a0 = super.findViewById(R.id.jo9);
        this.f339788b0 = (TextView) super.findViewById(R.id.ivTitleName);
        this.f339789c0 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        this.f339790d0 = (TextView) super.findViewById(R.id.ivTitleBtnLeftButton);
        this.f339791e0 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        this.f339792f0 = (LinearLayout) super.findViewById(R.id.fdr);
        this.f339793g0 = (ViewStub) super.findViewById(R.id.ik_);
        this.f339794h0 = (InnerFrameManager) super.findViewById(R.id.f166469fe1);
        this.f339795i0 = (HorizontalScrollView) super.findViewById(R.id.iig);
        this.f339796j0 = (GridView) super.findViewById(R.id.imn);
        this.f339797k0 = (Button) super.findViewById(R.id.f165007bo1);
        this.f339798l0 = (Button) super.findViewById(R.id.f165008bo2);
        this.f339799m0 = (TextView) super.findViewById(R.id.ilz);
        this.J0 = (ImageView) super.findViewById(R.id.f8c);
        initTitleBar();
        this.f339794h0.c(this);
        if (appRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        } else {
            baseQQAppInterface = null;
        }
        this.f339794h0.setAppIntf(baseQQAppInterface);
        this.f339794h0.i(0);
        H2();
        this.D0 = getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f339794h0.d();
        if (this.f339811y0 != null) {
            this.f339811y0 = null;
        }
    }

    @Override // gp3.e.b
    public void onImageLoaded(String str, Bitmap bitmap, String str2) {
        this.f339811y0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f339794h0.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f339794h0.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getWindow().setSoftInputMode(16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.getWindow().setSoftInputMode(48);
        this.f339794h0.g();
    }

    protected void quitSearchState() {
        this.f339802p0.setText("");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -this.f339787a0.getHeight(), 0.0f);
        this.H0 = translateAnimation;
        translateAnimation.setDuration(300L);
        this.H0.setAnimationListener(this);
        this.f339800n0.setVisibility(8);
        this.f339792f0.startAnimation(this.H0);
        this.F0.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        this.E0 = false;
    }

    protected void refreshSearchResultList(String str) {
        String str2;
        this.A0.clear();
        if (!str.equals("") && str.trim().length() != 0) {
            this.f339803q0.setVisibility(0);
            this.f339809w0.setVisibility(0);
            this.A0.clear();
            List<Friend> n3 = ((OpenFrame) this.f339794h0.getCurrentView()).n();
            if (n3 != null) {
                String lowerCase = str.toLowerCase();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Friend friend : n3) {
                    if (!lowerCase.equals(friend.E) && !lowerCase.equals(friend.F) && !lowerCase.equals(friend.f340348f) && !lowerCase.equals(friend.f340347e)) {
                        String str3 = friend.f340348f;
                        if ((str3 != null && str3.indexOf(lowerCase) >= 0) || (((str2 = friend.f340347e) != null && str2.indexOf(lowerCase) >= 0) || friend.E.indexOf(lowerCase) >= 0 || friend.F.indexOf(lowerCase) >= 0)) {
                            arrayList2.add(friend);
                        }
                    } else {
                        arrayList.add(friend);
                    }
                }
                Collections.sort(arrayList2, new f());
                this.A0.addAll(arrayList);
                this.A0.addAll(arrayList2);
            }
            if (this.A0.isEmpty()) {
                this.f339805s0.setVisibility(0);
            } else {
                this.f339805s0.setVisibility(8);
            }
        } else {
            this.f339803q0.setVisibility(8);
            this.f339809w0.setVisibility(8);
            this.f339805s0.setVisibility(8);
        }
        this.f339811y0.notifyDataSetChanged();
    }

    protected void setDoneBtnEnabled(boolean z16) {
        String format;
        int size = this.B0.size();
        if (size <= 1) {
            format = this.f339807u0;
        } else {
            format = MessageFormat.format(this.f339808v0, Integer.valueOf(size));
        }
        if (z16) {
            this.f339797k0.setVisibility(4);
            this.f339798l0.setVisibility(0);
            this.f339798l0.setText(format);
        } else {
            this.f339797k0.setVisibility(0);
            this.f339797k0.setText(format);
            this.f339798l0.setVisibility(4);
        }
    }

    protected void setupDoneBtn() {
        this.f339799m0.setText(this.B0.size() + "/" + this.K0);
        if (this.B0.size() > 0) {
            setDoneBtnEnabled(true);
        } else {
            setDoneBtnEnabled(false);
        }
    }

    protected abstract void startCreateOrAdd();

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class h implements TextWatcher {
        protected h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FriendChooser.this.refreshSearchResultList(FriendChooser.this.f339802p0.getText().toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
