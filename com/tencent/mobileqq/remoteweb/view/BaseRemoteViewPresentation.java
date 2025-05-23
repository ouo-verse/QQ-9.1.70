package com.tencent.mobileqq.remoteweb.view;

import android.app.Presentation;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remoteweb.RemoteBusinessEvent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 .2\u00020\u0001:\u0004567\nB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\bR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\"\u0010+\u001a\u00020\u00188\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u00100\u001a\u00020,8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u0010-\u001a\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;", "Landroid/app/Presentation;", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "containerView", "c", "o", "p", "d", "Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent;", "type", "extraInfo", "f", "", "url", "urlExtraInfo", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "j", HippyNestedScrollComponent.PRIORITY_PARENT, "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "view", "", "r", "t", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View$OnFocusChangeListener;", "focusChangeListener", h.F, "()Landroid/widget/FrameLayout;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/widget/FrameLayout;)V", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$b;", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$b;", "i", "()Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$b;", "state", "Landroid/view/Display;", "display", "<init>", "(Landroid/content/Context;Landroid/view/Display;)V", "a", "FakeWindowViewGroup", "b", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseRemoteViewPresentation extends Presentation {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnFocusChangeListener focusChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected FrameLayout container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b state;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0014R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "Landroid/view/ViewGroup;", "", "changed", "", "l", "t", "r", "b", "", "onLayout", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "viewBounds", "e", "childRect", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class FakeWindowViewGroup extends ViewGroup {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect viewBounds;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect childRect;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup$a;", "", "", "measureSpec", "b", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation$FakeWindowViewGroup$a, reason: from kotlin metadata */
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

            /* JADX INFO: Access modifiers changed from: private */
            public final int b(int measureSpec) {
                return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), Integer.MIN_VALUE);
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39708);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeWindowViewGroup(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.viewBounds = new Rect();
                this.childRect = new Rect();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
                return;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                this.viewBounds.set(l3, t16, r16, b16);
                Gravity.apply(layoutParams2.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams2.x, layoutParams2.y, this.childRect);
                Rect rect = this.childRect;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
                return;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                Companion companion = INSTANCE;
                childAt.measure(companion.b(widthMeasureSpec), companion.b(heightMeasureSpec));
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$b;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "e", "(Landroid/view/View;)V", "childView", "b", "c", "g", "reuseChildView", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$c;", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$c;", "d", "()Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$c;", h.F, "(Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$c;)V", "windowManagerHandler", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "()Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "f", "(Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;)V", "fakeWindowViewGroup", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View childView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View reuseChildView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c windowManagerHandler;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FakeWindowViewGroup fakeWindowViewGroup;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.childView;
        }

        @Nullable
        public final FakeWindowViewGroup b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (FakeWindowViewGroup) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.fakeWindowViewGroup;
        }

        @Nullable
        public final View c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.reuseChildView;
        }

        @Nullable
        public final c d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.windowManagerHandler;
        }

        public final void e(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                this.childView = view;
            }
        }

        public final void f(@Nullable FakeWindowViewGroup fakeWindowViewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) fakeWindowViewGroup);
            } else {
                this.fakeWindowViewGroup = fakeWindowViewGroup;
            }
        }

        public final void g(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            } else {
                this.reuseChildView = view;
            }
        }

        public final void h(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
            } else {
                this.windowManagerHandler = cVar;
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$c;", "Ljava/lang/reflect/InvocationHandler;", "", "", "args", "", "a", "([Ljava/lang/Object;)V", "b", "c", "d", "proxy", "Ljava/lang/reflect/Method;", "method", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/view/WindowManager;", "Landroid/view/WindowManager;", "delegate", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;", "fakeWindowRootView", "<init>", "(Landroid/view/WindowManager;Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation$FakeWindowViewGroup;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements InvocationHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WindowManager delegate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FakeWindowViewGroup fakeWindowRootView;

        public c(@NotNull WindowManager delegate, @Nullable FakeWindowViewGroup fakeWindowViewGroup) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegate, (Object) fakeWindowViewGroup);
            } else {
                this.delegate = delegate;
                this.fakeWindowRootView = fakeWindowViewGroup;
            }
        }

        private final void a(Object[] args) {
            View view;
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            WindowManager.LayoutParams layoutParams = null;
            if (fakeWindowViewGroup != null && args.length >= 2) {
                Object obj = args[0];
                if (obj instanceof View) {
                    view = (View) obj;
                } else {
                    view = null;
                }
                if (view == null) {
                    return;
                }
                Object obj2 = args[1];
                if (obj2 instanceof WindowManager.LayoutParams) {
                    layoutParams = (WindowManager.LayoutParams) obj2;
                }
                if (layoutParams != null && fakeWindowViewGroup != null) {
                    fakeWindowViewGroup.addView(view, layoutParams);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            String str = "Embedded view called addView while detached from presentation, size " + args.length;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), null);
            }
        }

        private final void b(Object[] args) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            View view = null;
            if (fakeWindowViewGroup == null) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                bVar.a().add("Embedded view called removeView while detached from presentation");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), null);
                }
                return;
            }
            Object obj = args[0];
            if (obj instanceof View) {
                view = (View) obj;
            }
            if (view != null && fakeWindowViewGroup != null) {
                fakeWindowViewGroup.removeView(view);
            }
        }

        private final void c(Object[] args) {
            View view = null;
            if (this.fakeWindowRootView == null) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                bVar.a().add("Embedded view called removeViewImmediate while detached from presentation");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), null);
                }
                return;
            }
            Object obj = args[0];
            if (obj instanceof View) {
                view = (View) obj;
            }
            if (view == null) {
                return;
            }
            view.clearAnimation();
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup != null) {
                fakeWindowViewGroup.removeView(view);
            }
        }

        private final void d(Object[] args) {
            View view;
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            WindowManager.LayoutParams layoutParams = null;
            if (fakeWindowViewGroup != null && args.length >= 2) {
                Object obj = args[0];
                if (obj instanceof View) {
                    view = (View) obj;
                } else {
                    view = null;
                }
                if (view == null) {
                    return;
                }
                Object obj2 = args[1];
                if (obj2 instanceof WindowManager.LayoutParams) {
                    layoutParams = (WindowManager.LayoutParams) obj2;
                }
                if (layoutParams != null && fakeWindowViewGroup != null) {
                    fakeWindowViewGroup.updateViewLayout(view, layoutParams);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            bVar.a().add("Embedded view called updateViewLayout while detached from presentation");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), null);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@NotNull Object proxy, @NotNull Method method, @NotNull Object[] args) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, proxy, method, args);
            }
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(args, "args");
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.BaseRemoteViewPresentation", 1, "method " + method.getName());
            String name = method.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1148522778:
                        if (name.equals("addView")) {
                            a(args);
                            return null;
                        }
                        break;
                    case 542766184:
                        if (name.equals("removeViewImmediate")) {
                            c(args);
                            return null;
                        }
                        break;
                    case 931413976:
                        if (name.equals("updateViewLayout")) {
                            d(args);
                            return null;
                        }
                        break;
                    case 1098630473:
                        if (name.equals("removeView")) {
                            b(args);
                            return null;
                        }
                        break;
                    case 1756853807:
                        name.equals("setLocalFocus");
                        break;
                }
            }
            try {
                return method.invoke(this.delegate, Arrays.copyOf(args, args.length));
            } catch (InvocationTargetException e16) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str = "WindowManagerHandler InvocationTargetException " + e16;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), e16);
                }
                return Unit.INSTANCE;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39742);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRemoteViewPresentation(@NotNull Context context, @NotNull Display display) {
        super(context, display);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(display, "display");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) display);
            return;
        }
        this.focusChangeListener = new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.remoteweb.view.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                BaseRemoteViewPresentation.g(view, z16);
            }
        };
        this.state = new b();
        Window window = getWindow();
        if (window != null) {
            window.setFlags(8, 8);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setType(2030);
        }
    }

    private final void e() {
        h().removeAllViews();
        FrameLayout frameLayout = this.rootView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            frameLayout = null;
        }
        frameLayout.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, boolean z16) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.BaseRemoteViewPresentation", 1, " has focus : " + z16);
    }

    private final void m() {
        if (this.state.a() == null) {
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return;
            } else {
                throw new RuntimeException("BaseRemoteViewPresentation.createChildView is null!");
            }
        }
        View a16 = this.state.a();
        if (a16 == null) {
            return;
        }
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.BaseRemoteViewPresentation", 1, "[onCreate] currentDM  " + displayMetrics);
        h().addView(a16);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.rootView = frameLayout;
        frameLayout.addView(h());
        FrameLayout frameLayout2 = this.rootView;
        FrameLayout frameLayout3 = null;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            frameLayout2 = null;
        }
        frameLayout2.addView(this.state.b());
        a16.setOnFocusChangeListener(this.focusChangeListener);
        FrameLayout frameLayout4 = this.rootView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            frameLayout4 = null;
        }
        frameLayout4.setFocusableInTouchMode(true);
        a16.requestFocus();
        FrameLayout frameLayout5 = this.rootView;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            frameLayout3 = frameLayout5;
        }
        setContentView(frameLayout3);
    }

    @Nullable
    public abstract View c(@NotNull View containerView);

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        boolean isShowing = isShowing();
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.BaseRemoteViewPresentation", 1, "destroy isShow " + isShowing);
        if (isShowing) {
            try {
                super.dismiss();
            } catch (Throwable th5) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str = "destroy error " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.BaseRemoteViewPresentation", 1, (String) it.next(), th5);
                }
            }
            e();
        }
    }

    public void f(@NotNull RemoteBusinessEvent type, @NotNull Bundle extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) type, (Object) extraInfo);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FrameLayout h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.state;
    }

    @NotNull
    public FrameLayout j(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new FrameLayout(context);
    }

    public void k(@NotNull FrameLayout parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parent);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View c16 = this.state.c();
        if (c16 != null && r(c16)) {
            this.state.e(c16);
            this.state.g(null);
        }
        if (this.state.a() == null) {
            this.state.e(c(parent));
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.state.b() == null) {
            b bVar = this.state;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bVar.f(new FakeWindowViewGroup(context));
        }
        if (this.state.d() == null) {
            Object systemService = getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            b bVar2 = this.state;
            bVar2.h(new c((WindowManager) systemService, bVar2.b()));
        }
    }

    public void n(@NotNull String url, @NotNull Bundle urlExtraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) url, (Object) urlExtraInfo);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(urlExtraInfo, "urlExtraInfo");
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        l();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        s(j(context));
        k(h());
        m();
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Nullable
    public View q() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        View a16 = this.state.a();
        if (a16 == null || a16.getParent() == null) {
            return null;
        }
        ViewParent parent = a16.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(a16);
        }
        this.state.e(null);
        return a16;
    }

    public boolean r(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) view)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    protected final void s(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.container = frameLayout;
        }
    }

    public final void t(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.state.g(view);
        }
    }
}
