package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderMainPageSelectedEvent;
import com.tencent.biz.qqcircle.immersive.part.addtabguide.QFSQCircleAddTabManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 j2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001kB\u0011\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010(\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u001c\u0010.\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u0012\u00102\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00106\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030403j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000304`5H\u0016R\u0014\u00109\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010I\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00108R\u0016\u0010K\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00108R\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00108R\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010OR\u0016\u0010R\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00108R#\u0010Y\u001a\n T*\u0004\u0018\u00010S0S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR#\u0010^\u001a\n T*\u0004\u0018\u00010Z0Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0014\u0010g\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSQCircleTabGuideTipExpPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "action", "", "M9", "X9", "T9", "Q9", "", "showPop", "S9", "(Ljava/lang/Boolean;)V", "", "tabSourceType", "R9", "O9", "L9", "N9", "freeCheckLimit", "ea", "withAnimation", "H9", "da", "ca", "aa", "ba", "subAction", "Y9", "Z9", "Landroid/view/View;", "settingBtn", "F9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Z", "isMainFragment", "", "e", UserInfo.SEX_FEMALE, "startTranslationY", "Landroid/widget/PopupWindow;", "f", "Landroid/widget/PopupWindow;", "popupWindow", tl.h.F, "Landroid/view/View;", "containerView", "i", "backgroundView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "isResumed", "D", "shouldShowPopupWindow", "E", "hasForceHidePopupWindow", "Lcom/tencent/biz/qqcircle/events/QCirclePanelStateEvent;", "Lcom/tencent/biz/qqcircle/events/QCirclePanelStateEvent;", "panelStateEvent", "G", "hasForceHidePopByChangeVpPage", "Lf70/a;", "kotlin.jvm.PlatformType", "H", "Lkotlin/Lazy;", "K9", "()Lf70/a;", "interactActionVM", "Lf70/b;", "I", "J9", "()Lf70/b;", "feedExposeVM", "Landroid/animation/AnimatorSet;", "J", "Landroid/animation/AnimatorSet;", "showAnimatorSet", "K", "dismissAnimatorSet", "I9", "()Z", "canShowGuideUI", "<init>", "(Z)V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSQCircleTabGuideTipExpPart extends u implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isResumed;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean shouldShowPopupWindow;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasForceHidePopupWindow;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QCirclePanelStateEvent panelStateEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasForceHidePopByChangeVpPage;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy interactActionVM;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedExposeVM;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private AnimatorSet showAnimatorSet;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private AnimatorSet dismissAnimatorSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isMainFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float startTranslationY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View backgroundView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View settingBtn;

    public QFSQCircleTabGuideTipExpPart() {
        this(false, 1, null);
    }

    private final void F9(View settingBtn) {
        if (settingBtn != null) {
            VideoReport.setElementId(settingBtn, QCircleDaTongConstant.ElementId.EM_XSJ_SET_TAB_BTN);
            VideoReport.setEventDynamicParams(settingBtn, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.part.ev
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map G9;
                    G9 = QFSQCircleTabGuideTipExpPart.G9(QFSQCircleTabGuideTipExpPart.this, str);
                    return G9;
                }
            });
            VideoReport.setElementExposePolicy(settingBtn, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(settingBtn, ClickPolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map G9(QFSQCircleTabGuideTipExpPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("dt_pgid", this$0.J9().N1());
        return buildElementParams;
    }

    private final void H9(boolean withAnimation) {
        PopupWindow popupWindow = this.popupWindow;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (z16) {
            if (withAnimation) {
                this.dismissAnimatorSet.start();
                return;
            }
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
        }
    }

    private final boolean I9() {
        return uq3.c.a();
    }

    private final f70.b J9() {
        return (f70.b) this.feedExposeVM.getValue();
    }

    private final f70.a K9() {
        return (f70.a) this.interactActionVM.getValue();
    }

    private final void L9() {
        QCircleHostUtil.setQCircleToBottomTab();
        if (getContext() != null) {
            QCircleToast.k(QCircleToast.f91646f, getContext().getString(R.string.f184823mx), 0, true);
        }
    }

    private final void M9(String action) {
        boolean z16;
        QLog.d("QFSQCircleTabGuideTipExpPart", 1, "hidePopupWindowByAction:" + action);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.hasForceHidePopupWindow = true;
            H9(false);
        }
    }

    private final void N9() {
        this.startTranslationY = DisplayUtil.dip2px(getContext(), 280.0f);
        jc0.a aVar = new jc0.a(0.4f, 0.0f, 0.5f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.backgroundView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.containerView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat2.setDuration(100L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.containerView, (Property<View, Float>) View.TRANSLATION_Y, this.startTranslationY, 0.0f);
        ofFloat3.setDuration(100L);
        ofFloat3.setInterpolator(aVar);
        AnimatorSet animatorSet = this.showAnimatorSet;
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat3).after(100L);
        animatorSet.play(ofFloat2).after(200L);
        animatorSet.setDuration(300L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.backgroundView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.containerView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat5.setDuration(100L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.containerView, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, this.startTranslationY);
        ofFloat6.setDuration(100L);
        ofFloat6.setInterpolator(aVar);
        AnimatorSet animatorSet2 = this.dismissAnimatorSet;
        animatorSet2.play(ofFloat6);
        animatorSet2.play(ofFloat5);
        animatorSet2.play(ofFloat4).after(100L);
        animatorSet2.setDuration(300L);
        animatorSet2.addListener(new b());
    }

    private final void O9() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g5y, (ViewGroup) null);
        this.backgroundView = inflate.findViewById(R.id.a4j);
        this.containerView = inflate.findViewById(R.id.b8q);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.uhr);
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(R.id.dialog_icon)");
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(imageView.getLayoutParams().width).setRequestHeight(imageView.getLayoutParams().height).setUrl("https://qq-video.cdn-go.cn/ios/latest/defaultmode/9110/detailpagemedia/qvideo_detailpagemedia_logo_mono.png").setTargetView(imageView));
        }
        View findViewById = inflate.findViewById(R.id.aek);
        this.settingBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.eu
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSQCircleTabGuideTipExpPart.P9(QFSQCircleTabGuideTipExpPart.this, view);
                }
            });
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.popupWindow = popupWindow;
        popupWindow.setAnimationStyle(R.style.avp);
        F9(this.settingBtn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QFSQCircleTabGuideTipExpPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        this$0.H9(true);
        this$0.aa();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q9(String action) {
        QLog.d(getTAG(), 1, "observeInteractAction, action:" + action);
        switch (action.hashCode()) {
            case -1641853112:
                if (!action.equals("action_on_follow")) {
                    return;
                }
                ga(this, false, 1, null);
                return;
            case -282679530:
                if (!action.equals("action_on_click_send_comment")) {
                    return;
                }
                break;
            case 338216241:
                if (!action.equals("action_on_click_share")) {
                    return;
                }
                break;
            case 1053211886:
                if (!action.equals("action_on_like")) {
                    return;
                }
                ga(this, false, 1, null);
                return;
            case 1053342833:
                if (!action.equals("action_on_push")) {
                    return;
                }
                ga(this, false, 1, null);
                return;
            default:
                return;
        }
        this.shouldShowPopupWindow = true;
    }

    private final void R9(int tabSourceType) {
        QLog.d(getTAG(), 1, "observePageIdChanged, tabSourceType:" + tabSourceType);
        if (J9().L1()) {
            M9("page_changed");
        } else {
            da();
        }
    }

    private final void S9(Boolean showPop) {
        QLog.d(getTAG(), 1, "observeVvTogglePopWindow, showPop:" + showPop);
        if (Intrinsics.areEqual(showPop, Boolean.TRUE)) {
            ga(this, false, 1, null);
        } else {
            H9(true);
            ba();
        }
    }

    private final void T9() {
        K9().onCreate();
        K9().L1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.er
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSQCircleTabGuideTipExpPart.U9(QFSQCircleTabGuideTipExpPart.this, (String) obj);
            }
        });
        J9().onCreate();
        J9().O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.es
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSQCircleTabGuideTipExpPart.V9(QFSQCircleTabGuideTipExpPart.this, (Boolean) obj);
            }
        });
        J9().M1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.et
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSQCircleTabGuideTipExpPart.W9(QFSQCircleTabGuideTipExpPart.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QFSQCircleTabGuideTipExpPart this$0, String action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(action, "action");
        this$0.Q9(action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QFSQCircleTabGuideTipExpPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QFSQCircleTabGuideTipExpPart this$0, Integer tabSourceType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(tabSourceType, "tabSourceType");
        this$0.R9(tabSourceType.intValue());
    }

    private final void X9() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void Y9(int subAction) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setPageId(getPageId()).setToUin(HostDataTransUtils.getAccount()).setActionType(606).setSubActionType(subAction).setExt7(QCircleNativeSessionManager.g().getSession()));
    }

    private final void Z9() {
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_TAB_BTN);
        params.put("xsj_custom_pgid", J9().N1());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    private final void aa() {
        Y9(2);
    }

    private final void ba() {
        Y9(3);
    }

    private final void ca() {
        Y9(1);
        Z9();
    }

    private final void da() {
        boolean z16;
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (this.hasForceHidePopupWindow) {
            ea(true);
            this.hasForceHidePopupWindow = false;
        } else if (this.shouldShowPopupWindow && K9().M1()) {
            ga(this, false, 1, null);
        }
    }

    private final void ea(boolean freeCheckLimit) {
        boolean z16;
        boolean z17;
        QLog.i(getTAG(), 1, "tryShowGuidePop, freeCheckLimit:" + freeCheckLimit + ", hashCode:" + hashCode());
        QFSQCircleAddTabManager qFSQCircleAddTabManager = QFSQCircleAddTabManager.f87671a;
        if (!qFSQCircleAddTabManager.g()) {
            QLog.e(getTAG(), 1, "Feat disable, do nothing.");
            return;
        }
        if (!I9()) {
            QLog.d(getTAG(), 1, "canShowGuideUI: false.");
            return;
        }
        if (!qFSQCircleAddTabManager.l() && !freeCheckLimit) {
            QLog.d(getTAG(), 1, "Exceed count limit, do nothing.");
            return;
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e(getTAG(), 1, "PopupWindow is already showing, do nothing.");
            return;
        }
        QCirclePanelStateEvent qCirclePanelStateEvent = this.panelStateEvent;
        if (qCirclePanelStateEvent != null && qCirclePanelStateEvent.isShowing()) {
            z17 = true;
        } else {
            z17 = false;
        }
        Integer num = null;
        if (z17) {
            String tag = getTAG();
            QCirclePanelStateEvent qCirclePanelStateEvent2 = this.panelStateEvent;
            if (qCirclePanelStateEvent2 != null) {
                num = Integer.valueOf(qCirclePanelStateEvent2.getPanelType());
            }
            QLog.e(tag, 1, "Panel is showing, do nothing, type:" + num);
            this.shouldShowPopupWindow = true;
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(getTAG(), 1, "In studyMode, do nothing.");
            return;
        }
        if (J9().L1()) {
            String tag2 = getTAG();
            QFSBaseFragment hostFragment = getHostFragment();
            if (hostFragment != null) {
                num = Integer.valueOf(hostFragment.getPageId());
            }
            QLog.d(tag2, 1, "curPage do not show, pageId:" + num);
            return;
        }
        if (QFSTeenModePopWindowPart.T9()) {
            QLog.d(getTAG(), 1, "TeenModePopWindowShow, do nothing.");
            return;
        }
        if (!this.isResumed) {
            this.shouldShowPopupWindow = true;
            QLog.d(getTAG(), 1, "part is not resumed, do nothing.");
            return;
        }
        this.shouldShowPopupWindow = false;
        QLog.i(getTAG(), 1, "tryShowGuidePop-startShow, hashCode:" + hashCode());
        View view = this.backgroundView;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        View view2 = this.containerView;
        if (view2 != null) {
            view2.setTranslationY(this.startTranslationY);
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(getPartRootView(), 80, 0, 0);
        }
        this.showAnimatorSet.start();
        J9().S1();
        qFSQCircleAddTabManager.k();
        ca();
    }

    static /* synthetic */ void ga(QFSQCircleTabGuideTipExpPart qFSQCircleTabGuideTipExpPart, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        qFSQCircleTabGuideTipExpPart.ea(z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QFSFolderMainPageSelectedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSQCircleTabGuideTipExpPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "qfs_action_add_to_main_tab_success")) {
            QLog.d(getTAG(), 1, "receive action:" + action);
            H9(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (!I9()) {
            QLog.i(getTAG(), 1, "onInitView, can not show guide ui, do nothing.");
            return;
        }
        X9();
        T9();
        O9();
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QLog.d("QFSQCircleTabGuideTipExpPart", 1, "onPartCreate, hashCode:" + hashCode());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        K9().onDestroy();
        J9().onDestroy();
        H9(false);
        this.showAnimatorSet.cancel();
        this.dismissAnimatorSet.cancel();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        QLog.d(getTAG(), 1, "onPartPause, hashCode:" + hashCode());
        this.isResumed = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        QLog.d(getTAG(), 1, "onPartResume, hashCode:" + hashCode());
        this.isResumed = true;
        if (this.shouldShowPopupWindow && K9().M1()) {
            ga(this, false, 1, null);
        } else if (this.hasForceHidePopByChangeVpPage) {
            this.hasForceHidePopByChangeVpPage = false;
            da();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCirclePanelStateEvent) {
            QCirclePanelStateEvent qCirclePanelStateEvent = (QCirclePanelStateEvent) event;
            QLog.d("QFSQCircleTabGuideTipExpPart", 1, "panel type:" + qCirclePanelStateEvent.getPanelType() + ", showing:" + qCirclePanelStateEvent.isShowing());
            this.panelStateEvent = qCirclePanelStateEvent;
            if (qCirclePanelStateEvent.isShowing()) {
                M9("show panel type:" + qCirclePanelStateEvent.getPanelType());
                return;
            }
            da();
            return;
        }
        if (event instanceof QFSFolderMainPageSelectedEvent) {
            QFSFolderMainPageSelectedEvent qFSFolderMainPageSelectedEvent = (QFSFolderMainPageSelectedEvent) event;
            QLog.d("QFSQCircleTabGuideTipExpPart", 1, "mIsFolderMainPageSelected:" + qFSFolderMainPageSelectedEvent.mIsFolderMainPageSelected);
            PopupWindow popupWindow = this.popupWindow;
            boolean z16 = false;
            if (popupWindow != null && popupWindow.isShowing()) {
                z16 = true;
            }
            if (z16 && !qFSFolderMainPageSelectedEvent.mIsFolderMainPageSelected) {
                M9("folder main page not selected.");
                this.hasForceHidePopByChangeVpPage = true;
            }
        }
    }

    public QFSQCircleTabGuideTipExpPart(boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        this.isMainFragment = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<f70.a>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSQCircleTabGuideTipExpPart$interactActionVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f70.a invoke() {
                return (f70.a) QFSQCircleTabGuideTipExpPart.this.getViewModel(f70.a.class);
            }
        });
        this.interactActionVM = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<f70.b>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSQCircleTabGuideTipExpPart$feedExposeVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f70.b invoke() {
                boolean z17;
                f70.b bVar = (f70.b) QFSQCircleTabGuideTipExpPart.this.getViewModel(f70.b.class);
                z17 = QFSQCircleTabGuideTipExpPart.this.isMainFragment;
                bVar.Q1(z17);
                return bVar;
            }
        });
        this.feedExposeVM = lazy2;
        this.showAnimatorSet = new AnimatorSet();
        this.dismissAnimatorSet = new AnimatorSet();
    }

    public /* synthetic */ QFSQCircleTabGuideTipExpPart(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/QFSQCircleTabGuideTipExpPart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            PopupWindow popupWindow = QFSQCircleTabGuideTipExpPart.this.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
