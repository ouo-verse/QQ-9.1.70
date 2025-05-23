package com.tencent.mobileqq.qqlive.sail.ui.preview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyModule;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropPanelPopupWindow;
import com.tencent.mobileqq.qqlive.anchor.live.effect.a;
import com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001zB\u0007\u00a2\u0006\u0004\bw\u0010xJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001c\u0010&\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010\u00182\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0016J,\u0010/\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016J$\u00100\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u00101\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0012\u00104\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\u0012\u00105\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\u0012\u00106\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J,\u0010<\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u00010#2\b\u00108\u001a\u0004\u0018\u00010#2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0016J\u0012\u0010=\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J,\u0010@\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u00010#2\b\u00108\u001a\u0004\u0018\u00010#2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209H\u0016J\u0012\u0010A\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010B\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010C\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010F\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016R\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u0018\u0010a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010s\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/preview/QQLiveCameraPreviewPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/BeautyProcessor$b;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/api/b;", "", "titleTxt", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "sa", "", "Ea", "Fa", "Landroid/view/ViewGroup;", "displayView", "Ga", "Landroid/graphics/Bitmap;", "wa", "Da", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "ua", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Y9", "aa", NodeProps.ON_CLICK, "tips", "tipsIcon", "", "type", "durationMs", "N", "D", "B", "onGlobalLayout", "e", "onDown", "onShowPress", "onSingleTapUp", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/bean/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d2", "Lcom/tencent/mobileqq/qqlive/sail/ui/preview/a;", "Lkotlin/Lazy;", "va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/preview/a;", "beautyViewModel", "f", "Landroid/view/ViewGroup;", "prepareContainer", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "previewLayout", "i", "Landroid/view/View;", "beautyLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "propLayout", BdhLogUtil.LogTag.Tag_Conn, "virtualAnchorLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "topTipsTextView", "E", "tipsTextView", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "customDialog", "Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a;", "G", "Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a;", "effectUI", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/BeautyProcessor;", "H", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/BeautyProcessor;", "beautyProcessor", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/BeautyModule;", "I", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/BeautyModule;", "beautyModule", "Landroid/view/GestureDetector;", "J", "Landroid/view/GestureDetector;", "gestureDetector", "K", "Z", "isRoomStarted", "L", "isBeautyOK", "<init>", "()V", "M", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCameraPreviewPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, BeautyProcessor.b, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View virtualAnchorLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView topTipsTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView tipsTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog customDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.anchor.live.effect.a effectUI;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private BeautyProcessor beautyProcessor;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final BeautyModule beautyModule;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GestureDetector gestureDetector;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean isRoomStarted;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile boolean isBeautyOK;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy beautyViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup prepareContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout previewLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View beautyLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View propLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/preview/QQLiveCameraPreviewPart$a;", "", "", "PREVIEW_RATIO", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/preview/QQLiveCameraPreviewPart$b", "Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a$b;", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCameraPreviewPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.live.effect.a.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> propCategories = com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.a();
            com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar = QQLiveCameraPreviewPart.this.effectUI;
            Intrinsics.checkNotNullExpressionValue(propCategories, "propCategories");
            aVar.i(propCategories);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/preview/QQLiveCameraPreviewPart$c", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/h;", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "", "a", "", "errorCode", "", "desc", "onFailure", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements com.tencent.mobileqq.qqlive.anchor.beauty.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCameraPreviewPart.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(QQLiveCameraPreviewPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BeautyProcessor beautyProcessor = this$0.beautyProcessor;
            if (beautyProcessor != null) {
                ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
                beautyProcessor.o(BaseApplication.context);
                beautyProcessor.v(this$0);
                beautyProcessor.f(this$0);
            }
            this$0.isBeautyOK = true;
            this$0.Fa();
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.h
        public void a(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) process);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraPreviewPart", "setupBeauty", "success");
            final QQLiveCameraPreviewPart qQLiveCameraPreviewPart = QQLiveCameraPreviewPart.this;
            qQLiveCameraPreviewPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCameraPreviewPart.c.c(QQLiveCameraPreviewPart.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.h
        public void onFailure(int errorCode, @Nullable String desc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) desc);
                return;
            }
            AegisLogger.INSTANCE.w("Open_Live|QQLiveCameraPreviewPart", "setupBeauty", "failed, errCode=" + errorCode + ", msg=" + desc);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCameraPreviewPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart$beautyViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraPreviewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) QQLiveCameraPreviewPart.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.beautyViewModel = lazy;
            this.effectUI = new com.tencent.mobileqq.qqlive.anchor.live.effect.a();
            this.beautyModule = new BeautyModule();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(QQLiveCameraPreviewPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.tipsTextView;
        if (textView != null) {
            textView.setText((CharSequence) null);
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(int i3, QQLiveCameraPreviewPart this$0, String str) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && (textView = this$0.tipsTextView) != null) {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    private final void Da() {
        View view = this.propLayout;
        if (view != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("qqlive_anchor_button_type", "5");
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(view, false, null, "em_qqlive_beauty_button", concurrentHashMap);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", view, concurrentHashMap);
        }
    }

    private final void Ea() {
        this.beautyModule.z(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa() {
        com.tencent.mobileqq.qqlive.sail.room.d ua5;
        AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraPreviewPart", "trySetVideoProcessor", "isBeautyOK=" + this.isBeautyOK + ", isStarted=" + this.isRoomStarted);
        if (this.isBeautyOK && this.isRoomStarted && (ua5 = ua()) != null) {
            ua5.l(this.beautyProcessor);
        }
    }

    private final void Ga(ViewGroup displayView) {
        FrameLayout frameLayout = this.previewLayout;
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Open_Live|QQLiveCameraPreviewPart", "updatePreviewLayout", "layout size: " + frameLayout.getWidth() + HippyTKDListViewAdapter.X + frameLayout.getHeight());
            if (frameLayout.getWidth() > 0 && frameLayout.getHeight() > 0) {
                if (frameLayout.getWidth() / frameLayout.getHeight() <= 0.5625f) {
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    float height = frameLayout.getHeight() * 0.5625f;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) height, frameLayout.getHeight());
                    int width = (int) ((frameLayout.getWidth() - height) / 2);
                    layoutParams2.setMargins(width, 0, width, 0);
                    layoutParams = layoutParams2;
                }
            }
            companion.i("Open_Live|QQLiveCameraPreviewPart", "updatePreviewLayout", "new layout size: " + layoutParams.width + HippyTKDListViewAdapter.X + layoutParams.height);
            if (displayView != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(displayView, layoutParams);
            }
        }
    }

    private final QQCustomDialog sa(String titleTxt) {
        if (this.customDialog == null) {
            this.customDialog = DialogUtil.createCustomDialog(getContext(), 230, titleTxt, null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQLiveCameraPreviewPart.ta(dialogInterface, i3);
                }
            });
        }
        return this.customDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    private final com.tencent.mobileqq.qqlive.sail.room.d ua() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.d) {
            return (com.tencent.mobileqq.qqlive.sail.room.d) F9;
        }
        return null;
    }

    private final a va() {
        Object value = this.beautyViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-beautyViewModel>(...)");
        return (a) value;
    }

    private final Bitmap wa() {
        if (this.previewLayout != null) {
            int screenWidth = ScreenUtils.getScreenWidth(getContext());
            Bitmap createBitmap = Bitmap.createBitmap(screenWidth, ScreenUtils.getScreenHeight(getContext()), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(com.tencent.timi.game.utils.b.c(14));
            textPaint.setColor(-1);
            textPaint.setAntiAlias(true);
            StaticLayout staticLayout = new StaticLayout("\u4e3b\u64ad\u6682\u65f6\u79bb\u5f00\uff0c\u5343\u4e07\u522b\u8d70\u5f00\u9a6c\u4e0a\u56de\u6765", textPaint, screenWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            canvas.translate((screenWidth - staticLayout.getWidth()) / 2, (r9 - staticLayout.getHeight()) / 2);
            staticLayout.draw(canvas);
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QQLiveCameraPreviewPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog sa5 = this$0.sa(str);
        if (sa5 != null && !sa5.isShowing()) {
            sa5.setTitle(str);
            sa5.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.b
    public void B(@Nullable final String titleTxt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) titleTxt);
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCameraPreviewPart.xa(QQLiveCameraPreviewPart.this, titleTxt);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.b
    public void D(@Nullable String tips, @Nullable String tipsIcon, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, tips, tipsIcon, Integer.valueOf(type));
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCameraPreviewPart.Ba(QQLiveCameraPreviewPart.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.b
    public void N(@Nullable final String tips, @Nullable String tipsIcon, final int type, int durationMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tips, tipsIcon, Integer.valueOf(type), Integer.valueOf(durationMs));
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCameraPreviewPart.Ca(type, this, tips);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.V9();
        this.isRoomStarted = false;
        FrameLayout frameLayout = this.previewLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            frameLayout.setOnTouchListener(null);
        }
        BeautyProcessor beautyProcessor = this.beautyProcessor;
        if (beautyProcessor != null) {
            beautyProcessor.v(this);
        }
        this.effectUI.c();
        this.beautyModule.l();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void Y9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            Da();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.d ua5 = ua();
        if (ua5 != null) {
            Ga(ua5.getDisplayView());
            ua5.g(wa());
        }
        this.isRoomStarted = true;
        Fa();
        com.tencent.mobileqq.qqlive.anchor.live.effect.a.INSTANCE.a(new b());
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b
    public void d2(@Nullable com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) item);
        } else if (item == null) {
            D(null, null, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60292v1) {
                com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar = this.effectUI;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                aVar.e(activity);
            } else if (num != null && num.intValue() == R.id.f60362v8) {
                com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar2 = this.effectUI;
                Activity activity2 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                aVar2.f(activity2);
            } else if (num != null && num.intValue() == R.id.f61712yv) {
                com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar3 = this.effectUI;
                Activity activity3 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity3, "activity");
                aVar3.g(activity3, PropPanelPopupWindow.t());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraPreviewPart", "onConfigurationChanged", "orientation=" + configuration.orientation);
        FrameLayout frameLayout = this.previewLayout;
        if (frameLayout != null && (viewTreeObserver2 = frameLayout.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this);
        }
        FrameLayout frameLayout2 = this.previewLayout;
        if (frameLayout2 != null && (viewTreeObserver = frameLayout2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) e16)).booleanValue();
        }
        if (R9()) {
            return false;
        }
        boolean N1 = va().N1();
        if (N1) {
            ViewGroup viewGroup = this.prepareContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            TextView textView = this.topTipsTextView;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            ViewGroup viewGroup2 = this.prepareContainer;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            TextView textView2 = this.topTipsTextView;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        va().O1(!N1);
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 19, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        FrameLayout frameLayout = this.previewLayout;
        if (frameLayout != null) {
            frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            com.tencent.mobileqq.qqlive.sail.room.d ua5 = ua();
            if (ua5 != null) {
                viewGroup = ua5.getDisplayView();
            } else {
                viewGroup = null;
            }
            Ga(viewGroup);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        View view3 = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f61372xy);
        } else {
            viewGroup = null;
        }
        this.prepareContainer = viewGroup;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61432y4);
        } else {
            frameLayout = null;
        }
        this.previewLayout = frameLayout;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f60292v1);
        } else {
            view = null;
        }
        this.beautyLayout = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f60362v8);
        } else {
            view2 = null;
        }
        this.propLayout = view2;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f61412y2);
        } else {
            textView = null;
        }
        this.tipsTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f61422y3);
        } else {
            textView2 = null;
        }
        this.topTipsTextView = textView2;
        FrameLayout frameLayout2 = this.previewLayout;
        if (frameLayout2 != null) {
            frameLayout2.setOnTouchListener(this);
        }
        boolean z16 = true;
        if (ht3.a.b("qqlive_camera_anchor_prepare_clear_screen_enable", 1) != 0) {
            GestureDetector gestureDetector = new GestureDetector(getContext(), this);
            this.gestureDetector = gestureDetector;
            gestureDetector.setOnDoubleTapListener(this);
        }
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f61712yv);
        }
        this.virtualAnchorLayout = view3;
        if (ht3.a.b("qqlive_enable_virtual_human", 1) != 1) {
            z16 = false;
        }
        if (!z16) {
            View view4 = this.virtualAnchorLayout;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        } else {
            View view5 = this.virtualAnchorLayout;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            View view6 = this.virtualAnchorLayout;
            if (view6 != null) {
                view6.setOnClickListener(this);
            }
        }
        this.effectUI.d(this);
        View view7 = this.beautyLayout;
        if (view7 != null) {
            view7.setOnClickListener(this);
        }
        View view8 = this.propLayout;
        if (view8 != null) {
            view8.setOnClickListener(this);
        }
        this.beautyProcessor = BeautyProcessor.n();
        a va5 = va();
        MutableLiveData<Boolean> M1 = va5.M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart$onInitView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                if (QQLiveCameraPreviewPart.this.H9() > 0) {
                    com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar = QQLiveCameraPreviewPart.this.effectUI;
                    Activity activity = QQLiveCameraPreviewPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    aVar.h(activity, QQLiveCameraPreviewPart.this.H9());
                    return;
                }
                AegisLogger.INSTANCE.w("Open_Live|QQLiveCameraPreviewPart", "beautySelect", "invalid roomId");
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveCameraPreviewPart.za(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> L1 = va5.L1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart$onInitView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                com.tencent.mobileqq.qqlive.anchor.live.effect.a aVar = QQLiveCameraPreviewPart.this.effectUI;
                Activity activity = QQLiveCameraPreviewPart.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.g(activity, it.intValue());
            }
        };
        L1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.preview.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveCameraPreviewPart.Aa(Function1.this, obj);
            }
        });
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            Ea();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 17, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) e16);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        BeautyProcessor beautyProcessor = this.beautyProcessor;
        if (beautyProcessor != null) {
            int i16 = 0;
            if (v3 != null) {
                i3 = v3.getWidth();
            } else {
                i3 = 0;
            }
            if (v3 != null) {
                i16 = v3.getHeight();
            }
            beautyProcessor.J(event, i3, i16);
        }
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(event);
            return true;
        }
        return true;
    }
}
