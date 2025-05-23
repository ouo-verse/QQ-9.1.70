package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalHintViewChangeEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalQzoneAlumView;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class y extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener, SimpleEventReceiver {
    private v.a C;
    private View D;
    private QUIEmptyState E;
    private ViewGroup G;
    private View.OnClickListener H;

    /* renamed from: d, reason: collision with root package name */
    private QFSPersonalQzoneAlumView f88955d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f88956e;

    /* renamed from: f, reason: collision with root package name */
    private View f88957f;

    /* renamed from: h, reason: collision with root package name */
    private AlphaAnimation f88958h;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t f88960m;

    /* renamed from: i, reason: collision with root package name */
    private String f88959i = QCircleDaTongConstant.ElementParamValue.NO_PRODUCTS;
    private boolean F = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Collections.singletonList("update_version_op_urge");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            boolean z16;
            y yVar = y.this;
            if (wVar.e().urgeStatus.get() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            yVar.U9(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f88962d;

        b(View.OnClickListener onClickListener) {
            this.f88962d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (y.this.H != null) {
                y.this.H.onClick(view);
            }
            View.OnClickListener onClickListener = this.f88962d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f88965d;

        d(String str) {
            this.f88965d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String b16 = com.tencent.biz.qqcircle.immersive.utils.ae.b(this.f88965d);
            if (TextUtils.isEmpty(b16)) {
                b16 = "https://m.xsj.qq.com/operation/xsj-act/activity/page?id=3f743d789c059f390cf10de0702b6530&_wv=1025";
            }
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), b16);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<y> f88967a;

        public e(y yVar) {
            this.f88967a = new WeakReference<>(yVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            y yVar = this.f88967a.get();
            if (yVar != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_VOID_ITEM_STATUS, yVar.f88959i);
            }
            return buildElementParams;
        }
    }

    private void B9(View view) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_VOID_ITEM);
        VideoReport.setEventDynamicParams(view, new e(this));
    }

    private void C9(QFSPersonalHintViewChangeEvent qFSPersonalHintViewChangeEvent) {
        int i3 = qFSPersonalHintViewChangeEvent.actionType;
        if (i3 == 0) {
            Q9();
        } else if (i3 == 1) {
            E9();
        } else if (i3 == 2) {
            M9(uq3.c.E1(), uq3.c.D1());
        }
    }

    private void D9() {
        QUIEmptyState qUIEmptyState = this.E;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9() {
        FrameLayout frameLayout = this.f88956e;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private void I9(int i3, String str, String str2) {
        J9(i3, str, str2, "", null);
    }

    private void J9(int i3, String str, String str2, String str3, View.OnClickListener onClickListener) {
        QUIEmptyState qUIEmptyState = this.E;
        if (qUIEmptyState != null) {
            if (!this.F) {
                qUIEmptyState.setGravity(1);
            }
            this.E.setImageView(i3);
            QUIEmptyState qUIEmptyState2 = this.E;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            qUIEmptyState2.setTitle(str);
            QUIEmptyState qUIEmptyState3 = this.E;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            qUIEmptyState3.setDesc(str2);
            QUIEmptyState qUIEmptyState4 = this.E;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            qUIEmptyState4.setBtnText(str3, 1, onClickListener);
            this.E.setVisibility(0);
            return;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(this.D.getContext());
        builder.setImageType(i3);
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setDesc(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setButton(str3, new b(onClickListener));
        }
        builder.setHalfScreenState(true);
        QUIEmptyState build = builder.build();
        this.E = build;
        build.setOnClickListener(new c());
        if (!this.F) {
            this.E.setGravity(1);
            this.E.setPadding(0, cx.a(56.0f), 0, 0);
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.addView(this.E, new ViewGroup.LayoutParams(-1, -1));
        } else {
            View view = this.D;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(this.E, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        B9(this.E);
    }

    private void initViewModel() {
        this.f88960m = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.C = new a();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.f88960m;
        if (tVar != null && tVar.O1() != null) {
            this.f88960m.O1().observeForever(this.C);
        }
    }

    public void E9() {
        if (this.f88957f == null) {
            RFWLog.e("FSPersonalFeedPart", RFWLog.USR, "[hideHintView] mFeedHintView = " + this.E + " mLoadingView = " + this.f88957f);
            return;
        }
        D9();
        this.f88957f.clearAnimation();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.x
            @Override // java.lang.Runnable
            public final void run() {
                y.this.F9();
            }
        }, 16L);
    }

    public void G9(FrameLayout frameLayout) {
        this.G = frameLayout;
    }

    public void H9(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void K9(boolean z16) {
        this.F = z16;
    }

    public void L9() {
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showCollectPrivate]");
        if (this.f88956e == null) {
            return;
        }
        I9(1, uq3.c.s1(), uq3.c.r1());
        this.f88956e.setVisibility(8);
        this.f88959i = QCircleDaTongConstant.ElementParamValue.SET_PERMISSION;
    }

    public void M9(String str, String str2) {
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showEmpty] title = " + str);
        if (this.f88956e == null) {
            return;
        }
        I9(16, str, str2);
        this.f88956e.setVisibility(8);
        this.f88959i = QCircleDaTongConstant.ElementParamValue.NO_PRODUCTS;
    }

    public void N9(String str) {
        O9(str, 5);
    }

    public void O9(String str, int i3) {
        String str2;
        String str3;
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showError] -> errorMsg " + str);
        if (this.f88956e == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = uq3.c.c4();
        }
        String[] f16 = cu.f(str, "\n");
        if (f16.length >= 2) {
            str3 = f16[0];
            str2 = f16[1];
        } else {
            str2 = str;
            str3 = "";
        }
        I9(i3, str3, str2);
        this.f88956e.setVisibility(8);
    }

    public void P9(String str, long j3) {
        String str2;
        if (QCirclePluginUtil.isRequestSecurityHit(j3)) {
            CharSequence a16 = com.tencent.biz.qqcircle.immersive.utils.ae.a(str);
            if (!TextUtils.isEmpty(a16)) {
                str2 = a16.toString();
            } else {
                str2 = "";
            }
            J9(13, com.tencent.biz.qqcircle.utils.h.a(R.string.f194924d8), str2, com.tencent.biz.qqcircle.utils.h.a(R.string.f1915044z), new d(str));
            return;
        }
        O9(str, 5);
    }

    public void Q9() {
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showLoading]");
        if (this.f88956e != null && this.f88957f != null) {
            D9();
            this.f88956e.setVisibility(0);
            if (this.f88958h == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
                this.f88958h = alphaAnimation;
                alphaAnimation.setRepeatMode(2);
                this.f88958h.setRepeatCount(Integer.MAX_VALUE);
                this.f88958h.setDuration(1000L);
            }
            this.f88957f.startAnimation(this.f88958h);
        }
    }

    public void R9() {
        if (this.f88955d != null) {
            M9(uq3.c.F1(), "");
            this.f88955d.c(0, 2);
            this.f88955d.setVisibility(0);
            return;
        }
        M9(uq3.c.E1(), uq3.c.D1());
    }

    public void S9() {
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showPraisePrivate]");
        if (this.f88956e == null) {
            return;
        }
        I9(1, uq3.c.L1(), uq3.c.K1());
        this.f88956e.setVisibility(8);
        this.f88959i = QCircleDaTongConstant.ElementParamValue.SET_PERMISSION;
    }

    public void T9() {
        RFWLog.i("FSPersonalFeedPart", RFWLog.USR, "[showPushedPrivate]");
        if (this.f88956e == null) {
            return;
        }
        String[] f16 = cu.f(uq3.c.M1(), "\n");
        if (f16.length >= 2) {
            I9(1, f16[0], f16[1]);
        } else {
            I9(1, f16[0], null);
        }
        this.f88956e.setVisibility(8);
        this.f88959i = QCircleDaTongConstant.ElementParamValue.SET_PERMISSION;
    }

    public void U9(boolean z16) {
        String a16;
        QUIEmptyState qUIEmptyState = this.E;
        if (qUIEmptyState == null) {
            return;
        }
        if (z16) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1908843a);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194334bm);
        }
        qUIEmptyState.setBtnText(a16, 1);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalHintViewChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FSPersonalFeedPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = view;
        this.f88956e = (FrameLayout) view.findViewById(R.id.f41821i4);
        this.f88955d = (QFSPersonalQzoneAlumView) view.findViewById(R.id.tbt);
        FrameLayout frameLayout = this.f88956e;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        this.f88957f = view.findViewById(R.id.f46341ub);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.f88960m;
        if (tVar != null) {
            tVar.O1().removeObserver(this.C);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalHintViewChangeEvent) {
            C9((QFSPersonalHintViewChangeEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
