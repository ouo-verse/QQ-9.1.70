package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.Switch;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends j implements View.OnClickListener, SimpleEventReceiver {
    private RelativeLayout C;
    private PublishViewModel D;
    private Switch E;
    private Switch G;

    /* renamed from: d, reason: collision with root package name */
    private View f325886d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f325887e;

    /* renamed from: f, reason: collision with root package name */
    private CoordinatorLayout f325888f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f325889h;

    /* renamed from: i, reason: collision with root package name */
    private BottomSheetBehavior<LinearLayout> f325890i;

    /* renamed from: m, reason: collision with root package name */
    private View f325891m;
    private boolean F = true;
    private boolean H = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.publish.part.c$c, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class ViewOnClickListenerC9084c implements View.OnClickListener {
        ViewOnClickListenerC9084c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.K9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.K9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            c.this.F = z16;
            if (c.this.D != null) {
                c.this.D.H0 = c.this.F;
            }
            c cVar = c.this;
            cVar.z9(cVar.F);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    private void J9(boolean z16) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_DOWNLOAD_BUTTON);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_DOWNLOAD_BEGIN_STATUS, Integer.valueOf(z16 ? 1 : 0));
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9() {
        Z9();
    }

    private void L9(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, map);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void M9(View view) {
        if (view == null) {
            return;
        }
        this.E = (Switch) view.findViewById(R.id.f67683e0);
        PublishViewModel publishViewModel = this.D;
        if (publishViewModel != null) {
            publishViewModel.E3(R9());
            this.E.setChecked(!this.D.E2());
        }
        this.E.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.publish.part.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                c.this.T9(compoundButton, z16);
            }
        });
    }

    private void N9() {
        if (!this.H) {
            M9(this.f325886d);
        }
    }

    private void O9() {
        int i3;
        ms.a.f("PublishAdvancedSettingPart", "HD UI show:" + this.D.H2());
        LinearLayout linearLayout = (LinearLayout) this.f325886d.findViewById(R.id.f58242ph);
        if (this.D.H2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        Switch r06 = (Switch) this.f325886d.findViewById(R.id.f67693e1);
        r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.publish.part.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                c.this.U9(compoundButton, z16);
            }
        });
        r06.setChecked(this.D.J2());
        VideoReport.setElementId(r06, WinkDaTongReportConstant.ElementId.EM_XSJ_HIGH_DEFINITION_BUTTON);
        VideoReport.setElementClickPolicy(r06, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(r06, ExposurePolicy.REPORT_ALL);
    }

    private void Q9(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f30620ou);
        this.f325887e = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f325888f = (CoordinatorLayout) view.findViewById(R.id.f58402px);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f58462q3);
        this.f325889h = linearLayout;
        linearLayout.setClickable(true);
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from(this.f325889h);
        this.f325890i = from;
        from.addBottomSheetCallback(new a());
        this.f325891m = view.findViewById(R.id.f58392pw);
        this.C = (RelativeLayout) view.findViewById(R.id.f58382pv);
        initView();
        this.f325888f.setVisibility(8);
        L9(this.f325887e, WinkDaTongReportConstant.ElementParamKey.EM_XSJ_ADVANCED_SETTINGS_BUTTON, WinkDTParamBuilder.buildElementParams());
    }

    private boolean R9() {
        return QMMKV.from(getContext(), "QCIRCLE_MMKV_COMMON").decodeBool(PublishViewModel.R0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        QLog.d("PublishAdvancedSettingPart", 1, "download is checked " + z16);
        J9(z16 ^ true);
        PublishViewModel publishViewModel = this.D;
        if (publishViewModel != null) {
            publishViewModel.E3(!z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        this.D.H3(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void V9() {
        this.C.setOnClickListener(new ViewOnClickListenerC9084c());
        this.f325891m.setOnClickListener(new d());
    }

    private void W9() {
        SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
        this.f325888f.setVisibility(0);
        X9();
    }

    private void X9() {
        QLog.d("PublishAdvancedSettingPart", 1, "JurisdictionPanel is showing.");
        this.f325888f.setVisibility(0);
        Y9();
        this.f325890i.setState(3);
    }

    private void Y9() {
        QLog.d("PublishAdvancedSettingPart", 1, "start multiselect panel enter animation");
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154922tr);
        this.f325889h.clearAnimation();
        this.f325889h.startAnimation(loadAnimation);
    }

    private void Z9() {
        QLog.d("PublishAdvancedSettingPart", 2, "start multiselect panel exit animation");
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154923ts);
        loadAnimation.setAnimationListener(new b());
        this.f325889h.clearAnimation();
        this.f325889h.startAnimation(loadAnimation);
    }

    private void initView() {
        N9();
        P9(this.f325886d);
        this.H = true;
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return "PublishAdvancedSettingPart";
    }

    public void P9(View view) {
        if (!this.H && uq3.c.B6()) {
            view.findViewById(R.id.f31520r_).setVisibility(0);
            Switch r46 = (Switch) view.findViewById(R.id.f32540u1);
            this.G = r46;
            r46.setOnCheckedChangeListener(new e());
            boolean A9 = A9();
            this.F = A9;
            QLog.d("PublishAdvancedSettingPart", 1, "onInitView... mIsNeedSaveGridContent:", Boolean.valueOf(A9));
            PublishViewModel publishViewModel = this.D;
            if (publishViewModel != null) {
                publishViewModel.H0 = this.F;
            }
            this.G.setChecked(this.F);
        }
    }

    public boolean S9() {
        return this.F;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f30620ou) {
            W9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = (PublishViewModel) getViewModel(PublishViewModel.class);
        this.f325886d = view;
        Q9(view);
        V9();
        O9();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            c.this.f325888f.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 5) {
                c.this.f325888f.setVisibility(8);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
