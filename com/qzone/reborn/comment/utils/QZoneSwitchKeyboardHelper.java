package com.qzone.reborn.comment.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import cd.e;
import cd.n;
import cd.o;
import com.qzone.reborn.comment.bean.QZoneMenuModeView;
import com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper;
import com.qzone.reborn.configx.g;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.window.inset.KeyboardAdjustingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0004\u001c\u0084\u0001\"B\u0019\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u001b\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R*\u0010/\u001a\n (*\u0004\u0018\u00010'0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00107\u001a\n (*\u0004\u0018\u000100008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010?\u001a\n (*\u0004\u0018\u000108088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010HR\u0014\u0010K\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010JR\u0017\u0010Q\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR(\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010\u0010R\"\u0010\\\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010J\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010^\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010J\u001a\u0004\bW\u0010Y\"\u0004\b]\u0010[R\"\u0010a\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010J\u001a\u0004\b_\u0010Y\"\u0004\b`\u0010[R\"\u0010e\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010J\u001a\u0004\bc\u0010Y\"\u0004\bd\u0010[R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010s\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010y\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010u\u001a\u0004\bM\u0010v\"\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\"\u0010~\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010J\u001a\u0004\b}\u0010Y\"\u0004\bz\u0010[R\u0016\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u0080\u0001\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "", "Landroid/view/View;", "view", "", "u", "", "keyboardHeight", "D", "Landroidx/fragment/app/Fragment;", "fragment", "g", "", "Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "menuModeView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;)V", "v", "Landroidx/lifecycle/LifecycleOwner;", "owner", DomainData.DOMAIN_NAME, "r", "", "E", BdhLogUtil.LogTag.Tag_Conn, "k", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "c", "Landroid/view/ViewGroup;", "i", "()Landroid/view/ViewGroup;", "setMenuViewContainer", "(Landroid/view/ViewGroup;)V", "menuViewContainer", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", h.F, "()Landroid/widget/EditText;", "setEtContent", "(Landroid/widget/EditText;)V", "etContent", "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView;", "e", "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView;", "getKeyboardAdjustView", "()Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView;", "setKeyboardAdjustView", "(Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView;)V", "keyboardAdjustView", "Lcd/n;", "f", "Lcd/n;", "keyboardUtils", "Lcd/o;", "Lcd/o;", "toggleMenuHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Z", "canUseKeyboardAdjustingView", "Lcd/e;", "j", "Lcd/e;", "getAnimalHelper", "()Lcd/e;", "animalHelper", "[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "getMenuModeViews", "()[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "setMenuModeViews", "menuModeViews", "l", "getKeyboardAdjustOpen", "()Z", "setKeyboardAdjustOpen", "(Z)V", "keyboardAdjustOpen", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isShowMenu", "getKeyboardIsShow", HippyTKDListViewAdapter.X, "keyboardIsShow", "o", "getEtContentIsActionMove", "setEtContentIsActionMove", "etContentIsActionMove", "p", "I", "getKeyboardHeight", "()I", "w", "(I)V", "Landroid/view/View$OnTouchListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnTouchListener;", "getEtContentOnTouchListener", "()Landroid/view/View$OnTouchListener;", "t", "(Landroid/view/View$OnTouchListener;)V", "etContentOnTouchListener", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "()Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "y", "(Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;)V", "onKeyboardMenuListener", ReportConstant.COSTREPORT_PREFIX, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getAutoShowKeyboard", "autoShowKeyboard", "Lcd/n$b;", "Lcd/n$b;", "onKeyBoardListener", "<init>", "(Landroid/view/View;Landroid/app/Activity;)V", "MyLifecycleEventObserver", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneSwitchKeyboardHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ViewGroup menuViewContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EditText etContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private KeyboardAdjustingView keyboardAdjustView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final n keyboardUtils;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final o toggleMenuHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean canUseKeyboardAdjustingView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final e animalHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private QZoneMenuModeView[] menuModeViews;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean keyboardAdjustOpen;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowMenu;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean keyboardIsShow;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean etContentIsActionMove;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int keyboardHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private View.OnTouchListener etContentOnTouchListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private b onKeyboardMenuListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean autoShowKeyboard;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final n.b onKeyBoardListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$MyLifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "(Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public final class MyLifecycleEventObserver implements LifecycleEventObserver {
        public MyLifecycleEventObserver() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_CREATE) {
                QZoneSwitchKeyboardHelper.this.n(source);
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                QZoneSwitchKeyboardHelper.this.r(source);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "", "", "d", "x3", "h5", "onKeyboardHide", "", "keyboardHeight", "M", "Landroid/view/ViewGroup;", "layoutView", "i4", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void M(int keyboardHeight);

        void d();

        void h5();

        void i4(ViewGroup layoutView);

        void onKeyboardHide();

        void x3();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$c", "Lcd/n$b;", "", "height", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(QZoneSwitchKeyboardHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getEtContent().requestFocus();
        }

        @Override // cd.n.b
        public void a(int height) {
            QLog.i("QZoneSwitchKeyboardHelper", 1, "[onShow] height =" + height + " isShowMenu=" + QZoneSwitchKeyboardHelper.this.getIsShowMenu());
            QZoneSwitchKeyboardHelper.this.w(height);
            QZoneSwitchKeyboardHelper.this.D(height);
            b onKeyboardMenuListener = QZoneSwitchKeyboardHelper.this.getOnKeyboardMenuListener();
            if (onKeyboardMenuListener != null) {
                onKeyboardMenuListener.M(height);
            }
            b onKeyboardMenuListener2 = QZoneSwitchKeyboardHelper.this.getOnKeyboardMenuListener();
            if (onKeyboardMenuListener2 != null) {
                onKeyboardMenuListener2.d();
            }
            QZoneSwitchKeyboardHelper.this.x(true);
            QZoneSwitchKeyboardHelper.this.toggleMenuHelper.h(QZoneSwitchKeyboardHelper.this.toggleMenuHelper.getIDLE());
            QZoneSwitchKeyboardHelper.this.z(false);
            EditText etContent = QZoneSwitchKeyboardHelper.this.getEtContent();
            final QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper = QZoneSwitchKeyboardHelper.this;
            etContent.post(new Runnable() { // from class: cd.m
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneSwitchKeyboardHelper.c.d(QZoneSwitchKeyboardHelper.this);
                }
            });
        }

        @Override // cd.n.b
        public void b(int height) {
            QLog.i("QZoneSwitchKeyboardHelper", 1, "[onHide] height =" + height + " mode=" + QZoneSwitchKeyboardHelper.this.toggleMenuHelper.getMenuMode());
            if (Intrinsics.areEqual(QZoneSwitchKeyboardHelper.this.toggleMenuHelper.getMenuMode(), QZoneSwitchKeyboardHelper.this.toggleMenuHelper.getIDLE())) {
                QZoneSwitchKeyboardHelper.this.getMenuViewContainer().setVisibility(8);
            }
            b onKeyboardMenuListener = QZoneSwitchKeyboardHelper.this.getOnKeyboardMenuListener();
            if (onKeyboardMenuListener != null) {
                onKeyboardMenuListener.onKeyboardHide();
            }
            QZoneSwitchKeyboardHelper.this.x(false);
        }
    }

    public QZoneSwitchKeyboardHelper(View rootView, Activity activity) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.rootView = rootView;
        this.activity = activity;
        this.menuViewContainer = (ViewGroup) rootView.findViewById(R.id.f162813ms0);
        this.etContent = (EditText) rootView.findViewById(R.id.ms_);
        this.keyboardAdjustView = (KeyboardAdjustingView) rootView.findViewById(R.id.mrt);
        this.keyboardUtils = new n(rootView);
        this.toggleMenuHelper = new o(this);
        this.handler = new Handler(Looper.getMainLooper());
        this.canUseKeyboardAdjustingView = RFWConfig.getConfigValue("qzone_can_use_keyboard_adjustView", false);
        this.animalHelper = new e();
        this.menuModeViews = new QZoneMenuModeView[0];
        this.autoShowKeyboard = true;
        this.onKeyBoardListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int keyboardHeight) {
        ViewGroup toggleViewContainer;
        this.animalHelper.d();
        int height = this.menuViewContainer.getHeight();
        if (height < keyboardHeight && !this.keyboardAdjustOpen) {
            ViewGroup.LayoutParams layoutParams = this.menuViewContainer.getLayoutParams();
            layoutParams.height = keyboardHeight;
            this.menuViewContainer.setLayoutParams(layoutParams);
        } else {
            e eVar = this.animalHelper;
            ViewGroup menuViewContainer = this.menuViewContainer;
            Intrinsics.checkNotNullExpressionValue(menuViewContainer, "menuViewContainer");
            eVar.b(menuViewContainer, height, keyboardHeight);
        }
        this.menuViewContainer.setVisibility(0);
        for (QZoneMenuModeView qZoneMenuModeView : this.menuModeViews) {
            if (this.isShowMenu && (toggleViewContainer = qZoneMenuModeView.getToggleViewContainer()) != null) {
                toggleViewContainer.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QZoneSwitchKeyboardHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(QZoneSwitchKeyboardHelper this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this$0.keyboardIsShow && !this$0.etContentIsActionMove && event.getAction() == 1) {
            this$0.C();
        }
        this$0.etContentIsActionMove = event.getAction() == 2;
        View.OnTouchListener onTouchListener = this$0.etContentOnTouchListener;
        if (onTouchListener == null) {
            return false;
        }
        Intrinsics.checkNotNull(onTouchListener);
        return onTouchListener.onTouch(view, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QZoneSwitchKeyboardHelper this$0, QZoneMenuModeView menuModeView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuModeView, "$menuModeView");
        this$0.toggleMenuHelper.k(menuModeView);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void A(QZoneMenuModeView[] menuModeView) {
        Intrinsics.checkNotNullParameter(menuModeView, "menuModeView");
        this.menuModeViews = menuModeView;
        this.toggleMenuHelper.i(menuModeView);
    }

    public final boolean E() {
        QLog.i("QZoneSwitchKeyboardHelper", 1, "[toggleMenuView] isShowMenu =" + this.isShowMenu);
        this.etContent.setVisibility(0);
        if (!this.isShowMenu) {
            this.isShowMenu = true;
            this.menuViewContainer.setVisibility(0);
            k();
        } else {
            this.isShowMenu = false;
            B();
        }
        b bVar = this.onKeyboardMenuListener;
        if (bVar != null) {
            bVar.d();
        }
        return this.isShowMenu;
    }

    public final void g(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.lifecycleOwner = fragment;
        fragment.getLifecycle().addObserver(new MyLifecycleEventObserver());
    }

    /* renamed from: h, reason: from getter */
    public final EditText getEtContent() {
        return this.etContent;
    }

    /* renamed from: i, reason: from getter */
    public final ViewGroup getMenuViewContainer() {
        return this.menuViewContainer;
    }

    /* renamed from: j, reason: from getter */
    public final b getOnKeyboardMenuListener() {
        return this.onKeyboardMenuListener;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsShowMenu() {
        return this.isShowMenu;
    }

    public final void m() {
        k();
        this.menuViewContainer.setVisibility(8);
    }

    public final void n(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.keyboardUtils.i(this.onKeyBoardListener);
        this.keyboardHeight = this.keyboardUtils.d();
        EditText etContent = this.etContent;
        Intrinsics.checkNotNullExpressionValue(etContent, "etContent");
        u(etContent);
        ViewGroup menuViewContainer = this.menuViewContainer;
        Intrinsics.checkNotNullExpressionValue(menuViewContainer, "menuViewContainer");
        u(menuViewContainer);
        if (this.autoShowKeyboard) {
            this.handler.postDelayed(new Runnable() { // from class: cd.j
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneSwitchKeyboardHelper.o(QZoneSwitchKeyboardHelper.this);
                }
            }, this.keyboardAdjustOpen ? 0L : g.f53821a.b().e1());
        }
        this.etContent.setOnTouchListener(new View.OnTouchListener() { // from class: cd.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean p16;
                p16 = QZoneSwitchKeyboardHelper.p(QZoneSwitchKeyboardHelper.this, view, motionEvent);
                return p16;
            }
        });
        for (final QZoneMenuModeView qZoneMenuModeView : this.menuModeViews) {
            View clickToggleView = qZoneMenuModeView.getClickToggleView();
            if (clickToggleView != null) {
                clickToggleView.setClickable(true);
            }
            View clickToggleView2 = qZoneMenuModeView.getClickToggleView();
            if (clickToggleView2 != null) {
                clickToggleView2.setOnClickListener(new View.OnClickListener() { // from class: cd.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneSwitchKeyboardHelper.q(QZoneSwitchKeyboardHelper.this, qZoneMenuModeView, view);
                    }
                });
            }
        }
    }

    public final void r(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.i("QZoneSwitchKeyboardHelper", 1, "[onDestroy]");
        this.keyboardUtils.g();
        this.handler.removeCallbacksAndMessages(null);
        this.animalHelper.d();
        k();
    }

    public final void s(boolean z16) {
        this.autoShowKeyboard = z16;
    }

    public final void t(View.OnTouchListener onTouchListener) {
        this.etContentOnTouchListener = onTouchListener;
    }

    public final void v() {
        this.keyboardAdjustView.enableOpen(this.canUseKeyboardAdjustingView || !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion());
        boolean isOpen = this.keyboardAdjustView.getIsOpen();
        this.keyboardAdjustOpen = isOpen;
        this.keyboardUtils.j(!isOpen);
        this.keyboardAdjustView.setKeyboardListener(new d());
    }

    public final void w(int i3) {
        this.keyboardHeight = i3;
    }

    public final void x(boolean z16) {
        this.keyboardIsShow = z16;
    }

    public final void y(b bVar) {
        this.onKeyboardMenuListener = bVar;
    }

    public final void z(boolean z16) {
        this.isShowMenu = z16;
    }

    private final void u(View view) {
        view.setFitsSystemWindows(false);
        if (view.getParent() instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            if (((ViewGroup) parent).getId() != 16908290) {
                Object parent2 = view.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
                u((View) parent2);
            }
        }
    }

    public final void B() {
        QLog.i("QZoneSwitchKeyboardHelper", 1, "[showKeyboard]");
        b bVar = this.onKeyboardMenuListener;
        if (bVar != null) {
            bVar.x3();
        }
        EditText editText = this.etContent;
        editText.setSelection(editText.getText().length());
        this.etContent.requestFocus();
        o oVar = this.toggleMenuHelper;
        oVar.h(oVar.getIDLE());
        n.Companion companion = n.INSTANCE;
        EditText etContent = this.etContent;
        Intrinsics.checkNotNullExpressionValue(etContent, "etContent");
        companion.c(etContent, this.activity);
    }

    public final void C() {
        int height;
        int i3;
        QLog.i("QZoneSwitchKeyboardHelper", 1, "[showKeyboardAnim]");
        if (this.keyboardAdjustOpen || (height = this.menuViewContainer.getHeight()) == (i3 = this.keyboardHeight) || i3 <= 0) {
            return;
        }
        this.animalHelper.d();
        e eVar = this.animalHelper;
        ViewGroup menuViewContainer = this.menuViewContainer;
        Intrinsics.checkNotNullExpressionValue(menuViewContainer, "menuViewContainer");
        eVar.b(menuViewContainer, height, this.keyboardHeight);
    }

    public final void k() {
        QLog.i("QZoneSwitchKeyboardHelper", 1, "[hideKeyboard]");
        b bVar = this.onKeyboardMenuListener;
        if (bVar != null) {
            bVar.h5();
        }
        n.INSTANCE.b(this.activity);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$d", "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView$KeyboardEventListener;", "", "onDrop", "", "currentKeyboardHeight", "onProcess", "keyboardHeight", "onShow", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements KeyboardAdjustingView.KeyboardEventListener {
        d() {
        }

        @Override // com.tencent.richframework.compat.window.inset.KeyboardAdjustingView.KeyboardEventListener
        public void onDrop() {
            QZoneSwitchKeyboardHelper.this.onKeyBoardListener.b(0);
        }

        @Override // com.tencent.richframework.compat.window.inset.KeyboardAdjustingView.KeyboardEventListener
        public void onShow(float keyboardHeight) {
            QZoneSwitchKeyboardHelper.this.onKeyBoardListener.a((int) keyboardHeight);
        }

        @Override // com.tencent.richframework.compat.window.inset.KeyboardAdjustingView.KeyboardEventListener
        public void onProcess(float currentKeyboardHeight) {
        }
    }
}
