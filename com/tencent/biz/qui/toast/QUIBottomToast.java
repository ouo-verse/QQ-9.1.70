package com.tencent.biz.qui.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\bH\u0007R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qui/toast/QUIBottomToast;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View;", "e", "", "iconType", "Landroid/graphics/drawable/Drawable;", "f", "", h.F, "o", DomainData.DOMAIN_NAME, "j", "", IMiniCardBeancurd.SIGN_PLAIN_TEXT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "clickText", "i", "Landroid/view/View$OnClickListener;", "onClickListener", "l", "offset", "k", DKHippyEvent.EVENT_STOP, "d", "I", "Ljava/lang/String;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/qui/toast/QUIBottomToast$ClickToast;", "Lcom/tencent/biz/qui/toast/QUIBottomToast$ClickToast;", "toast", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "E", "ClickToast", "a", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIBottomToast implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int iconType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String plainText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String clickText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int offset;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ClickToast toast;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final ToastManager D = new ToastManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIBottomToast$ClickToast;", "Landroid/widget/PopupWindow;", "Lcom/tencent/biz/qui/toast/a;", "", "dismiss", "Lkotlin/Function0;", "dismissCallback", "a", "Landroid/app/Activity;", "getActivity", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "cancelRunnable", "e", "Lkotlin/jvm/functions/Function0;", "finalCallback", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", h.F, "I", "offset", "i", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "delayTime", "Landroid/view/View;", "contentView", "width", "<init>", "(Landroid/app/Activity;Landroid/view/View;IILkotlin/jvm/functions/Function0;J)V", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class ClickToast extends PopupWindow implements a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Runnable cancelRunnable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Function0<Unit> finalCallback;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Activity activity;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int offset;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private Function0<Unit> callback;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final long delayTime;

        public /* synthetic */ ClickToast(Activity activity, View view, int i3, int i16, Function0 function0, long j3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(activity, view, i3, i16, function0, (i17 & 32) != 0 ? 3000L : j3);
        }

        @Override // com.tencent.biz.qui.toast.a
        public void a(@NotNull final Function0<Unit> dismissCallback) {
            Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
            this.finalCallback = new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.QUIBottomToast$ClickToast$show$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0 function0;
                    function0 = QUIBottomToast.ClickToast.this.callback;
                    function0.invoke();
                    dismissCallback.invoke();
                }
            };
            Activity activity = this.activity;
            if (activity != null && !activity.isFinishing() && !this.activity.isDestroyed()) {
                setAnimationStyle(R.style.f173934na);
                try {
                    Window window = this.activity.getWindow();
                    Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                    View decorView = window.getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                    View rootView = decorView.getRootView();
                    int e16 = this.offset + e.e(this.activity);
                    this.offset = e16;
                    showAtLocation(rootView, 80, 0, e16);
                } catch (WindowManager.BadTokenException e17) {
                    d.b("QUIBottomToast", d.f438811e, "show error:" + e17);
                }
                getContentView().postDelayed(this.cancelRunnable, this.delayTime);
                return;
            }
            d.b("QUIBottomToast", d.f438811e, "show error");
            this.finalCallback.invoke();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            super.dismiss();
            this.finalCallback.invoke();
            getContentView().removeCallbacks(this.cancelRunnable);
        }

        @Override // com.tencent.biz.qui.toast.a
        @Nullable
        public Activity getActivity() {
            return this.activity;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickToast(@Nullable Activity activity, @NotNull View contentView, int i3, int i16, @NotNull Function0<Unit> callback, long j3) {
            super(contentView, i3, -2);
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.activity = activity;
            this.offset = i16;
            this.callback = callback;
            this.delayTime = j3;
            this.cancelRunnable = new Runnable() { // from class: com.tencent.biz.qui.toast.QUIBottomToast$ClickToast$cancelRunnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    QUIBottomToast.ClickToast.this.dismiss();
                }
            };
            this.finalCallback = new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.QUIBottomToast$ClickToast$finalCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0 function0;
                    function0 = QUIBottomToast.ClickToast.this.callback;
                    function0.invoke();
                }
            };
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJB\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIBottomToast$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "iconType", "", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "clickText", "Landroid/view/View$OnClickListener;", "onClickListener", "offset", "Lcom/tencent/biz/qui/toast/QUIBottomToast;", "a", "", "DELAY_TIME", "J", "", "MAX_WIDTH", UserInfo.SEX_FEMALE, "TAG", "Ljava/lang/String;", "Lcom/tencent/biz/qui/toast/ToastManager;", "toastManager", "Lcom/tencent/biz/qui/toast/ToastManager;", "<init>", "()V", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.biz.qui.toast.QUIBottomToast$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ QUIBottomToast b(Companion companion, Activity activity, int i3, String str, String str2, View.OnClickListener onClickListener, int i16, int i17, Object obj) {
            if ((i17 & 32) != 0) {
                i16 = 0;
            }
            return companion.a(activity, i3, str, str2, onClickListener, i16);
        }

        @JvmStatic
        @NotNull
        public final QUIBottomToast a(@Nullable Activity activity, int iconType, @Nullable String plainText, @Nullable String clickText, @Nullable View.OnClickListener onClickListener, int offset) {
            return new QUIBottomToast(activity).j(iconType).m(plainText).i(clickText).l(onClickListener).k(offset);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View.OnClickListener onClickListener = QUIBottomToast.this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            ClickToast clickToast = QUIBottomToast.this.toast;
            if (clickToast != null) {
                clickToast.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QUIBottomToast(@Nullable Activity activity) {
        this.activity = activity;
        h();
    }

    private final View e() {
        View view = LayoutInflater.from(this.activity).inflate(R.layout.hft, (ViewGroup) null);
        ((ImageView) view.findViewById(R.id.toast_icon)).setImageDrawable(f(this.iconType));
        View findViewById = view.findViewById(R.id.f110036hf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<TextView>(R.id.tv_plain_text)");
        ((TextView) findViewById).setText(this.plainText);
        if (!TextUtils.isEmpty(this.clickText) && this.onClickListener != null) {
            TextView clickTextView = (TextView) view.findViewById(R.id.f1068069p);
            Intrinsics.checkNotNullExpressionValue(clickTextView, "clickTextView");
            clickTextView.setText(this.clickText);
            clickTextView.setOnClickListener(new b());
        }
        View backgroundView = view.findViewById(R.id.js9);
        Intrinsics.checkNotNullExpressionValue(backgroundView, "backgroundView");
        backgroundView.setBackground(ie0.a.f().k(this.activity, R.color.qui_common_bg_top_light, e.a(12.0f), 1000));
        backgroundView.setElevation(10.0f);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable f(int iconType) {
        int i3;
        if (iconType != 1) {
            if (iconType != 2) {
                i3 = R.drawable.qui_info_filled_feedback_normal;
            } else {
                i3 = R.drawable.qui_tick_filled_feedback_success;
            }
        } else {
            i3 = R.drawable.qui_caution_filled_feedback_error;
        }
        Activity activity = this.activity;
        if (activity != null) {
            return activity.getDrawable(i3);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final QUIBottomToast g(@Nullable Activity activity, int i3, @Nullable String str, @Nullable String str2, @Nullable View.OnClickListener onClickListener, int i16) {
        return INSTANCE.a(activity, i3, str, str2, onClickListener, i16);
    }

    private final void h() {
        ComponentCallbacks2 componentCallbacks2 = this.activity;
        if (componentCallbacks2 instanceof LifecycleOwner) {
            if (componentCallbacks2 != null) {
                LifecycleOwner lifecycleOwner = (LifecycleOwner) componentCallbacks2;
                lifecycleOwner.getLifecycle().removeObserver(this);
                lifecycleOwner.getLifecycle().addObserver(this);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        ComponentCallbacks2 componentCallbacks2 = this.activity;
        if (componentCallbacks2 instanceof LifecycleOwner) {
            if (componentCallbacks2 != null) {
                ((LifecycleOwner) componentCallbacks2).getLifecycle().removeObserver(this);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
    }

    @NotNull
    public final QUIBottomToast i(@Nullable String clickText) {
        this.clickText = clickText;
        return this;
    }

    @NotNull
    public final QUIBottomToast j(int iconType) {
        this.iconType = iconType;
        return this;
    }

    @NotNull
    public final QUIBottomToast k(int offset) {
        this.offset = offset;
        return this;
    }

    @NotNull
    public final QUIBottomToast l(@Nullable View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    @NotNull
    public final QUIBottomToast m(@Nullable String plainText) {
        this.plainText = plainText;
        return this;
    }

    public final void n() {
        int coerceAtMost;
        if (this.activity != null && !TextUtils.isEmpty(this.plainText)) {
            View e16 = e();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(e.i(), e.a(475.0f));
            final ClickToast clickToast = new ClickToast(this.activity, e16, coerceAtMost, this.offset, new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.QUIBottomToast$show$toast$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QUIBottomToast.this.o();
                }
            }, 0L, 32, null);
            this.toast = clickToast;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.biz.qui.toast.QUIBottomToast$show$1
                @Override // java.lang.Runnable
                public final void run() {
                    ToastManager toastManager;
                    toastManager = QUIBottomToast.D;
                    toastManager.d(QUIBottomToast.ClickToast.this);
                }
            });
            return;
        }
        d.a("QUIBottomToast", d.f438811e, "toast show error, context: " + this.activity + ", text: " + this.plainText);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        D.c(this.activity);
        ClickToast clickToast = this.toast;
        if (clickToast != null) {
            clickToast.dismiss();
        }
        this.toast = null;
    }
}
