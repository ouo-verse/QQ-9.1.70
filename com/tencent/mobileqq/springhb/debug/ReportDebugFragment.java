package com.tencent.mobileqq.springhb.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.impl.SpringHbReportApiImpl;
import com.tencent.mobileqq.springhb.debug.DebugMonitorHelper;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u000fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010`\u0011H\u0016J&\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/ReportDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "yh", "", "info", OcrConfig.CHINESE, "xh", "", "getContentLayoutId", "onDestroyView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ReportDebugFragment extends QIphoneTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/ReportDebugFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.debug.ReportDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ReportDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.springhb.util.a.j(com.tencent.mobileqq.springhb.util.a.f289630a, "hook_real_time", z16, "2024_spring_hb_debug_", false, null, 24, null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.springhb.util.a.j(com.tencent.mobileqq.springhb.util.a.f289630a, "hook_svr_switch", z16, "2024_spring_hb_debug_", false, null, 24, null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(View view) {
        int random;
        boolean z16;
        int random2;
        boolean z17;
        ISpringHbReportApi iSpringHbReportApi;
        EventCollector.getInstance().onViewClickedBefore(view);
        IntRange intRange = new IntRange(1, 2);
        Random.Companion companion = Random.INSTANCE;
        random = RangesKt___RangesKt.random(intRange, companion);
        if (random == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        random2 = RangesKt___RangesKt.random(new IntRange(1, 2), companion);
        if (random2 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.report(b.f289046a.e(z16, z17, false), 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(View view) {
        int random;
        boolean z16;
        int random2;
        ISpringHbReportApi iSpringHbReportApi;
        EventCollector.getInstance().onViewClickedBefore(view);
        IntRange intRange = new IntRange(1, 2);
        Random.Companion companion = Random.INSTANCE;
        random = RangesKt___RangesKt.random(intRange, companion);
        boolean z17 = false;
        if (random == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        random2 = RangesKt___RangesKt.random(new IntRange(1, 2), companion);
        if (random2 == 1) {
            z17 = true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.report(b.f289046a.e(z16, z17, true), 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void xh() {
        LinearLayout linearLayout = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xas);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DebugMockEditView debugMockEditView = new DebugMockEditView(requireActivity);
        debugMockEditView.setTitle("random\uff1a");
        com.tencent.mobileqq.springhb.util.a aVar = com.tencent.mobileqq.springhb.util.a.f289630a;
        debugMockEditView.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.d(aVar, "report_random", 5, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView.setSureTextClick(ReportDebugFragment$initHookConfig$1$1$1.INSTANCE);
        linearLayout.addView(debugMockEditView);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        DebugMockEditView debugMockEditView2 = new DebugMockEditView(requireActivity2);
        debugMockEditView2.setTitle("rspTimeOut\uff1a");
        debugMockEditView2.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.d(aVar, "rsp_time_out", 30000, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView2.setSureTextClick(ReportDebugFragment$initHookConfig$1$2$1.INSTANCE);
        linearLayout.addView(debugMockEditView2);
        FragmentActivity requireActivity3 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
        DebugMockEditView debugMockEditView3 = new DebugMockEditView(requireActivity3);
        debugMockEditView3.setTitle("retCode\uff1a");
        debugMockEditView3.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.d(aVar, "ret_code", 0, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView3.setSureTextClick(ReportDebugFragment$initHookConfig$1$3$1.INSTANCE);
        linearLayout.addView(debugMockEditView3);
        FragmentActivity requireActivity4 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity()");
        DebugMockEditView debugMockEditView4 = new DebugMockEditView(requireActivity4);
        debugMockEditView4.setTitle("batchSize\uff1a");
        debugMockEditView4.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.d(aVar, "batch_size", 18, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView4.setSureTextClick(ReportDebugFragment$initHookConfig$1$4$1.INSTANCE);
        linearLayout.addView(debugMockEditView4);
        FragmentActivity requireActivity5 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity5, "requireActivity()");
        DebugMockEditView debugMockEditView5 = new DebugMockEditView(requireActivity5);
        debugMockEditView5.setTitle("reportInterval\uff1a");
        debugMockEditView5.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.f(aVar, "report_interval", 1200L, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView5.setSureTextClick(ReportDebugFragment$initHookConfig$1$5$1.INSTANCE);
        linearLayout.addView(debugMockEditView5);
        FragmentActivity requireActivity6 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity6, "requireActivity()");
        DebugMockEditView debugMockEditView6 = new DebugMockEditView(requireActivity6);
        debugMockEditView6.setTitle("switchToBgInterval\uff1a");
        debugMockEditView6.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.f(aVar, "switch_to_bg_interval", 5L, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView6.setSureTextClick(ReportDebugFragment$initHookConfig$1$6$1.INSTANCE);
        linearLayout.addView(debugMockEditView6);
        FragmentActivity requireActivity7 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity7, "requireActivity()");
        DebugMockEditView debugMockEditView7 = new DebugMockEditView(requireActivity7);
        debugMockEditView7.setTitle("reportLevel\uff1a");
        debugMockEditView7.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.d(aVar, "report_level", 0, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView7.setSureTextClick(ReportDebugFragment$initHookConfig$1$7$1.INSTANCE);
        linearLayout.addView(debugMockEditView7);
        FragmentActivity requireActivity8 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity8, "requireActivity()");
        DebugMockEditView debugMockEditView8 = new DebugMockEditView(requireActivity8);
        debugMockEditView8.setTitle("reportLevelTime\uff1a");
        debugMockEditView8.setEditText(String.valueOf(com.tencent.mobileqq.springhb.util.a.f(aVar, "report_level_time", 86400L, "2024_spring_hb_debug_", false, null, 24, null)));
        debugMockEditView8.setSureTextClick(ReportDebugFragment$initHookConfig$1$8$1.INSTANCE);
        linearLayout.addView(debugMockEditView8);
    }

    private final void yh() {
        AppInterface appInterface;
        Object obj;
        DebugMonitorHelper debugMonitorHelper;
        String h16;
        SimpleEventBus.getInstance().registerReceiver(this);
        final Button initMonitorInfo$lambda$10 = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.uer);
        b bVar = b.f289046a;
        Intrinsics.checkNotNullExpressionValue(initMonitorInfo$lambda$10, "initMonitorInfo$lambda$10");
        final long j3 = 200;
        initMonitorInfo$lambda$10.setOnClickListener(new View.OnClickListener(initMonitorInfo$lambda$10, j3) { // from class: com.tencent.mobileqq.springhb.debug.ReportDebugFragment$initMonitorInfo$lambda$10$$inlined$setSingleClickListener$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f289042d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f289043e;

            {
                this.f289042d = initMonitorInfo$lambda$10;
                this.f289043e = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, initMonitorInfo$lambda$10, Long.valueOf(j3));
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                AppInterface appInterface2;
                Object obj2;
                DebugMonitorHelper debugMonitorHelper2;
                EventCollector.getInstance().onViewClickedBefore(it);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    this.f289042d.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    SpringHbReportApiImpl springHbReportApiImpl = null;
                    if (peekAppRuntime instanceof AppInterface) {
                        appInterface2 = (AppInterface) peekAppRuntime;
                    } else {
                        appInterface2 = null;
                    }
                    if (appInterface2 != null) {
                        obj2 = appInterface2.getRuntimeService(ISpringHbReportApi.class, "");
                    } else {
                        obj2 = null;
                    }
                    if (obj2 instanceof SpringHbReportApiImpl) {
                        springHbReportApiImpl = (SpringHbReportApiImpl) obj2;
                    }
                    if (springHbReportApiImpl != null && (debugMonitorHelper2 = springHbReportApiImpl.getDebugMonitorHelper()) != null) {
                        debugMonitorHelper2.l();
                    }
                    View view = this.f289042d;
                    view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.springhb.debug.ReportDebugFragment$initMonitorInfo$lambda$10$$inlined$setSingleClickListener$1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f289044d;

                        {
                            this.f289044d = view;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) view);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f289044d.setClickable(true);
                            }
                        }
                    }, this.f289043e);
                }
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.beb);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SpringHbReportApiImpl springHbReportApiImpl = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str = "";
        if (appInterface != null) {
            obj = appInterface.getRuntimeService(ISpringHbReportApi.class, "");
        } else {
            obj = null;
        }
        if (obj instanceof SpringHbReportApiImpl) {
            springHbReportApiImpl = (SpringHbReportApiImpl) obj;
        }
        if (springHbReportApiImpl != null && (debugMonitorHelper = springHbReportApiImpl.getDebugMonitorHelper()) != null && (h16 = debugMonitorHelper.h()) != null) {
            str = h16;
        }
        textView.setText(str);
    }

    private final void zh(String info) {
        ((TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.beb)).setText(info);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle("\u6570\u636e\u4e0a\u62a5");
        xh();
        yh();
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xat);
        formSwitchItem.setText("RealTime Hook");
        com.tencent.mobileqq.springhb.util.a aVar = com.tencent.mobileqq.springhb.util.a.f289630a;
        formSwitchItem.setChecked(com.tencent.mobileqq.springhb.util.a.b(aVar, "hook_real_time", false, "2024_spring_hb_debug_", false, null, 24, null));
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.springhb.debug.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ReportDebugFragment.th(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xau);
        formSwitchItem2.setText("Svr Hook");
        formSwitchItem2.setChecked(com.tencent.mobileqq.springhb.util.a.b(aVar, "hook_svr_switch", false, "2024_spring_hb_debug_", false, null, 24, null));
        formSwitchItem2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.springhb.debug.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ReportDebugFragment.uh(compoundButton, z16);
            }
        });
        Button button = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.thc);
        button.setText("\u975e\u5b9e\u65f6\u4e0a\u62a5");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.debug.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportDebugFragment.vh(view);
            }
        });
        Button button2 = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.thd);
        button2.setText("\u5b9e\u65f6\u4e0a\u62a5");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportDebugFragment.wh(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.hq_;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(DebugMonitorHelper.DebugMonitorEvent.class);
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroyView();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
        } else if (event instanceof DebugMonitorHelper.DebugMonitorEvent) {
            zh(((DebugMonitorHelper.DebugMonitorEvent) event).getInfo());
        }
    }
}
