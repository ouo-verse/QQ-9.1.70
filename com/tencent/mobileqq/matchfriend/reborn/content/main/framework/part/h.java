package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareScrollToTopEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.TitleBarViewBinding;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerOnPageBackEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0003J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/h;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "view", "", "Q9", "J9", "L9", "K9", "D9", "E9", "H9", "G9", "F9", "S9", "R9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "", "onBackEvent", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "leftView", "e", "centerView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "rightSettingView", tl.h.F, "rightEnterNearByView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "matchHelper", "Ll82/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ll82/f;", "nearbyEntryGuideElement", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout leftView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout centerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView rightSettingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView rightEnterNearByView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.matchfriend.reborn.content.main.matching.i matchHelper = new com.tencent.mobileqq.matchfriend.reborn.content.main.matching.i();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private l82.f nearbyEntryGuideElement;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/h$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e16) {
            SimpleEventBus.getInstance().dispatchEvent(QQStrangerSquareScrollToTopEvent.INSTANCE);
            return true;
        }
    }

    private final void D9() {
        ImageView imageView = null;
        if (com.tencent.mobileqq.matchfriend.reborn.utils.k.f245485a.c()) {
            ImageView imageView2 = this.rightEnterNearByView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightEnterNearByView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.rightEnterNearByView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterNearByView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void E9() {
        View findViewById = getPartRootView().findViewById(R.id.ooo);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = RFWImmersiveUtils.getStatusBarHeight();
            findViewById.setLayoutParams(marginLayoutParams);
        }
    }

    private final void F9() {
        com.tencent.mobileqq.matchfriend.reborn.utils.k kVar = com.tencent.mobileqq.matchfriend.reborn.utils.k.f245485a;
        ImageView imageView = this.rightEnterNearByView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterNearByView");
            imageView = null;
        }
        kVar.f(imageView);
    }

    private final void G9() {
        ImageView imageView = this.rightSettingView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightSettingView");
            imageView = null;
        }
        VideoReport.setElementId(imageView, "em_bas_filter");
        VideoReport.setElementExposePolicy(imageView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_NONE);
    }

    private final void H9() {
        View findViewById = getPartRootView().findViewById(R.id.ooo);
        final GestureDetector gestureDetector = new GestureDetector(findViewById.getContext(), new b());
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean I9;
                I9 = h.I9(gestureDetector, view, motionEvent);
                return I9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I9(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gestureDetector, "$gestureDetector");
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void J9() {
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerOnPageBackEvent());
    }

    private final void K9() {
        if (u.a().b()) {
            return;
        }
        com.tencent.mobileqq.matchfriend.reborn.utils.k kVar = com.tencent.mobileqq.matchfriend.reborn.utils.k.f245485a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        kVar.h(context);
        ImageView imageView = this.rightEnterNearByView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterNearByView");
            imageView = null;
        }
        kVar.j(imageView);
    }

    private final void L9() {
        Activity activity;
        if (u.a().b() || (activity = getActivity()) == null) {
            return;
        }
        y72.f.f449542a.m(activity);
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(View centerInnerView, h this$0, View view) {
        Intrinsics.checkNotNullParameter(centerInnerView, "$centerInnerView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a("QQStrangerMainTitlePart")) {
            return;
        }
        if (centerInnerView.getAlpha() > 0.3f) {
            if (QQStrangerGuestHelper.f245363a.b(view.getContext())) {
                return;
            }
            this$0.Q9(centerInnerView);
        } else {
            QLog.i("QQStrangerMainTitlePart", 4, "alpha \u592a\u5c0f\uff0c\u4e0d\u5904\u7406\u70b9\u51fb\u65f6\u95f4:" + centerInnerView.getAlpha());
        }
    }

    private final void Q9(View view) {
        QQStrangerMatchingPart.Companion companion = QQStrangerMatchingPart.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (companion.b(activity)) {
            this.matchHelper.start();
        }
        VideoReport.reportEvent("dt_clck", view, new HashMap());
    }

    private final void R9() {
        ImageView imageView = this.rightSettingView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightSettingView");
            imageView = null;
        }
        VideoReport.reportEvent("dt_clck", imageView, new HashMap());
    }

    private final void S9() {
        ImageView imageView = this.rightSettingView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightSettingView");
            imageView = null;
        }
        VideoReport.reportEvent("dt_imp", imageView, new HashMap());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!this.matchHelper.j() ? this.matchHelper.k() : false) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.tencent.mobileqq.matchfriend.reborn.content.main.matching.i iVar = this.matchHelper;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iVar.A(activity);
        E9();
        H9();
        rootView.findViewById(R.id.ool).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.M9(h.this, view);
            }
        });
        ImageView imageView = (ImageView) rootView.findViewById(R.id.oot);
        Intrinsics.checkNotNullExpressionValue(imageView, "this");
        this.rightSettingView = imageView;
        imageView.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.register.guest.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.N9(h.this, view);
            }
        }));
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.ooq);
        Intrinsics.checkNotNullExpressionValue(imageView2, "this");
        this.rightEnterNearByView = imageView2;
        imageView2.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.register.guest.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.O9(h.this, view);
            }
        }));
        View findViewById = rootView.findViewById(R.id.oor);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ger_main_title_left_view)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.leftView = relativeLayout;
        ImageView imageView3 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftView");
            relativeLayout = null;
        }
        TitleBarViewBinding.Companion companion = TitleBarViewBinding.INSTANCE;
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        relativeLayout.addView(companion.b(context));
        View findViewById2 = rootView.findViewById(R.id.oop);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026r_main_title_center_view)");
        this.centerView = (RelativeLayout) findViewById2;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        final View a16 = companion.a(context2);
        a16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.P9(a16, this, view);
            }
        });
        RelativeLayout relativeLayout2 = this.centerView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            relativeLayout2 = null;
        }
        relativeLayout2.addView(a16);
        ImageView imageView4 = this.rightEnterNearByView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterNearByView");
        } else {
            imageView3 = imageView4;
        }
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        l82.f fVar = new l82.f(imageView3, activity2);
        this.nearbyEntryGuideElement = fVar;
        m82.a aVar = m82.a.f416439a;
        aVar.b().addElement(fVar);
        aVar.b().notifyGroupActivate(fVar, RFWOrderElementManager.OrderMode.WAIT_MODE, 1000L);
        G9();
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        y72.f.f449542a.h();
        l82.f fVar = this.nearbyEntryGuideElement;
        if (fVar != null) {
            m82.a.f416439a.b().inactivateElement((IOrderElement) fVar, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        D9();
        S9();
    }
}
