package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel;
import com.tencent.mobileqq.wink.publish.widget.FSCheckBox;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.IQZoneVideoApi;
import java.io.File;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* loaded from: classes21.dex */
public class PublishSharePart extends j implements View.OnClickListener, SimpleEventReceiver {
    public static final String H = UploadConstants.TAG + "FSPublishSharePart";
    private static final String I = WinkEditorResourceManager.a1().L1();
    private com.tencent.mobileqq.wink.publish.viewmodel.r C;
    private PublishBubbleViewModel D;
    private View.OnClickListener E;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f325760d;

    /* renamed from: e, reason: collision with root package name */
    private volatile FSCheckBox f325761e;

    /* renamed from: f, reason: collision with root package name */
    private View f325762f;

    /* renamed from: h, reason: collision with root package name */
    private VasPagView f325763h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f325764i;

    /* renamed from: m, reason: collision with root package name */
    private long f325765m = 0;
    private boolean F = true;
    private Runnable G = new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishSharePart.5
        @Override // java.lang.Runnable
        public void run() {
            if (PublishSharePart.this.getActivity() != null && !PublishSharePart.this.getActivity().isFinishing()) {
                PublishSharePart.this.U9();
            }
        }
    };

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0021, code lost:
        
            if (r0.K9(r0.f325765m) < 3000) goto L8;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PublishSharePart.this.f325765m != 0) {
                PublishSharePart publishSharePart = PublishSharePart.this;
            }
            FSToastUtil.makeTextAndShow("\u5f53\u524d\u6743\u9650\u72b6\u6001\u4e0b\u65e0\u6cd5\u540c\u6b65\u5230qq\u7a7a\u95f4", 1);
            PublishSharePart.this.f325765m = System.currentTimeMillis();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            PublishSharePart.this.f325761e.setChecked(bool.booleanValue());
            PublishSharePart.this.F = bool.booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements Function1<PAGView, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            String str = PublishSharePart.H;
            QLog.d(str, 1, "showPag invoke method be invoke");
            if (pAGView != null && !TextUtils.isEmpty(PublishSharePart.I) && !pAGView.isPlaying()) {
                QLog.d(str, 1, "pagView = " + pAGView + ",pagPath = " + PublishSharePart.I + ",pagView.isPlaying() = " + pAGView.isPlaying());
                PublishSharePart.this.N9(pAGView, PublishSharePart.I);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements Function1<PAGView, Unit> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            if (pAGView != null && pAGView.isPlaying()) {
                pAGView.stop();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(Boolean bool) {
        if (bool.booleanValue()) {
            S9();
        }
    }

    private void M9() {
        com.tencent.mobileqq.wink.publish.viewmodel.r rVar = (com.tencent.mobileqq.wink.publish.viewmodel.r) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.r.class);
        this.C = rVar;
        rVar.f326065i.observe(getHostFragment(), new b());
        this.C.M1(getHostFragment());
        if (this.D == null) {
            this.D = (PublishBubbleViewModel) getViewModel(PublishBubbleViewModel.class);
        }
        this.D.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishSharePart.this.L9((Boolean) obj);
            }
        });
        this.D.R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(PAGView pAGView, String str) {
        File file = new File(str);
        if (file.exists()) {
            String str2 = H;
            QLog.d(str2, 1, "pagLocalFile \u5b58\u5728");
            PAGFile Load = PagViewMonitor.Load(file.getAbsolutePath());
            O9(pAGView, Load);
            QLog.d(str2, 1, "playPag -> pagFile = " + Load);
            return;
        }
        String str3 = H;
        QLog.e(str3, 1, "pagLocalFile \u7edd\u5bf9\u8def\u5f84\u4e0d\u5b58\u5728");
        PAGFile Load2 = PagViewMonitor.Load(getContext().getAssets(), "wink/pag/icon_share_qcircle.pag");
        if (Load2 != null) {
            O9(pAGView, Load2);
        } else {
            QLog.e(str3, 1, "pagLocalFile \u76f8\u5bf9\u8def\u5f84\u4e0d\u5b58\u5728");
        }
    }

    private void O9(PAGView pAGView, PAGFile pAGFile) {
        if (pAGFile != null) {
            this.f325763h.setVisibility(0);
            this.f325761e.setVisibility(8);
            R9();
            pAGView.setComposition(pAGFile);
            pAGView.setRepeatCount(0);
            pAGView.play();
            QLog.d(H, 1, "pagView.play() be invoke");
            getMainHandler().postDelayed(this.G, 4000L);
            return;
        }
        QLog.e(H, 1, "pagFile = null");
    }

    private void Q9() {
        this.f325763h.api().build().postAction(new c());
    }

    private void R9() {
        FrameLayout frameLayout;
        if (this.f325763h != null && (frameLayout = this.f325760d) != null && frameLayout.getVisibility() != 8) {
            QUIDefaultBubbleTip.r(getContext()).g0(false).o0(getActivity().getResources().getString(R.string.f185163nu)).k0(2).S(this.f325763h).f0(false).m0(3).R(0).s0();
            QLog.d(H, 1, "mPublishBubblePopupView has shown");
            PublishBubbleViewModel.INSTANCE.i();
            return;
        }
        if (QLog.isColorLevel()) {
            String str = H;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(",syncQzonePagView = ");
            sb5.append(this.f325763h);
            sb5.append(",mSyncQzoneLayout = ");
            sb5.append(this.f325760d);
            sb5.append(",mSyncQzoneLayout.getVisibility() = ");
            FrameLayout frameLayout2 = this.f325760d;
            String str2 = "gone";
            if (frameLayout2 != null && frameLayout2.getVisibility() != 8) {
                str2 = NodeProps.VISIBLE;
            }
            sb5.append(str2);
            QLog.d(str, 2, sb5.toString());
        }
    }

    private void S9() {
        if (!this.F && getActivity() != null && !getActivity().isFinishing()) {
            Q9();
        } else {
            U9();
        }
    }

    private void T9() {
        this.f325763h.api().postAction(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        this.f325761e.setVisibility(0);
        this.f325763h.setVisibility(8);
        T9();
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return H;
    }

    public long K9(long j3) {
        return System.currentTimeMillis() - j3;
    }

    public void P9(boolean z16) {
        if (this.f325761e.f326081d == z16) {
            return;
        }
        this.f325761e.f326081d = z16;
        if (!z16) {
            this.f325761e.setSyncChecked(false);
            if (this.C == null) {
                this.C = (com.tencent.mobileqq.wink.publish.viewmodel.r) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.r.class);
            }
            this.C.O1(getHostFragment(), false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f58492q6 || id5 == R.id.f58482q5 || id5 == R.id.thb) {
            MutableLiveData<Boolean> mutableLiveData = this.C.f326065i;
            if (mutableLiveData != null && mutableLiveData.getValue() != null && !this.C.f326065i.getValue().booleanValue()) {
                U9();
            }
            this.C.L1(getHostFragment());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.f58472q4);
        this.f325762f = findViewById;
        findViewById.setVisibility(0);
        VasPagView vasPagView = (VasPagView) view.findViewById(R.id.thb);
        this.f325763h = vasPagView;
        vasPagView.setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f58492q6);
        this.f325760d = frameLayout;
        frameLayout.setOnClickListener(this);
        this.f325764i = (TextView) view.findViewById(R.id.f58502q7);
        if (((IQZoneVideoApi) QRoute.api(IQZoneVideoApi.class)).isHitQQVideoExperiment()) {
            this.f325764i.setText(getContext().getResources().getString(R.string.f196734i4));
        } else {
            this.f325764i.setText(getContext().getResources().getString(R.string.f196744i5));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getActivity().getResources().getDrawable(R.drawable.f161678om2);
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, getActivity().getResources().getDrawable(R.drawable.f161677om1));
        stateListDrawable.addState(new int[]{-16842912}, drawable);
        stateListDrawable.addState(new int[0], drawable);
        this.f325761e = (FSCheckBox) view.findViewById(R.id.f58482q5);
        this.f325761e.setOnClickListener(this);
        this.f325761e.setBackgroundDrawable(stateListDrawable);
        this.f325761e.setGravity(16);
        this.E = new a();
        this.f325761e.setmShareClickListener(this.E);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        if (this.G != null) {
            getMainHandler().removeCallbacks(this.G);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
