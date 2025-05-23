package com.tencent.aio.part.root.panel.bottomdialog.mvx.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.BottomDialogScrollRootLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J0\u0010\r\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0003J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a;", "Landroid/widget/PopupWindow;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout$b;", "", "dismiss", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "", LayoutAttrDefine.Gravity.Gravity, HippyTKDListViewAdapter.X, "y", "", "aplha", "d", "anchor", "xoff", "yoff", "showAsDropDown", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a$b;", "listener", "c", "e", "", "up", "a", "mode", "b", "scrollToTop", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/view/animation/Animation;", "Landroid/view/animation/Animation;", "mInAnimation", "f", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a$b;", "dialogStatusListener", "Landroid/content/Context;", "context", "width", "height", "<init>", "(Landroid/content/Context;II)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends PopupWindow implements BottomDialogScrollRootLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Animation mInAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b dialogStatusListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogPopWindow$1$1"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class ViewOnClickListenerC0636a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f69504e;

        ViewOnClickListenerC0636a(Context context) {
            this.f69504e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a$b;", "", "", ViewStickEventHelper.IS_SHOW, "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean isShow);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, int i3, int i16) {
        super(i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        BottomDialogScrollRootLayout bottomDialogScrollRootLayout = new BottomDialogScrollRootLayout(context, null);
        this.container = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        bottomDialogScrollRootLayout.addView(this.container, layoutParams);
        bottomDialogScrollRootLayout.setDisableMinScrollY(false);
        bottomDialogScrollRootLayout.setAtPanelTouchListener(this);
        bottomDialogScrollRootLayout.setOnClickListener(new ViewOnClickListenerC0636a(context));
        Unit unit = Unit.INSTANCE;
        setContentView(bottomDialogScrollRootLayout);
    }

    @Override // com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.BottomDialogScrollRootLayout.b
    public void a(boolean up5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, up5);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("BottomDialogTag", "ScrollMoving, isUp: " + up5);
    }

    @Override // com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.BottomDialogScrollRootLayout.b
    public void b(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, mode);
        } else {
            com.tencent.aio.base.log.a.f69187b.d("BottomDialogTag", "scrollToBottomEnd");
            dismiss();
        }
    }

    public final void c(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogStatusListener = listener;
        }
    }

    public final void d(@Nullable View parent, int gravity, int x16, int y16, float aplha) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, parent, Integer.valueOf(gravity), Integer.valueOf(x16), Integer.valueOf(y16), Float.valueOf(aplha));
            return;
        }
        super.showAtLocation(parent, gravity, x16, y16);
        if (parent != null) {
            context = parent.getContext();
        } else {
            context = null;
        }
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = aplha;
            window.setAttributes(attributes);
        }
        b bVar = this.dialogStatusListener;
        if (bVar != null) {
            bVar.a(true);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        super.dismiss();
        View contentView = getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        Context context = contentView.getContext();
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        b bVar = this.dialogStatusListener;
        if (bVar != null) {
            bVar.a(false);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        getContentView().scrollTo(0, 0);
        Animation animation = this.mInAnimation;
        if (animation != null && animation != null && animation.hasEnded()) {
            return;
        }
        if (this.mInAnimation == null) {
            this.mInAnimation = AnimationUtils.loadAnimation(this.container.getContext(), R.anim.f155117wn);
        }
        getContentView().startAnimation(this.mInAnimation);
    }

    @Override // com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.BottomDialogScrollRootLayout.b
    public void scrollToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            com.tencent.aio.base.log.a.f69187b.d("BottomDialogTag", "scrollToTop");
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@NotNull View anchor, int xoff, int yoff, int gravity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, anchor, Integer.valueOf(xoff), Integer.valueOf(yoff), Integer.valueOf(gravity));
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        super.showAsDropDown(anchor, xoff, yoff, gravity);
        b bVar = this.dialogStatusListener;
        if (bVar != null) {
            bVar.a(true);
        }
    }
}
