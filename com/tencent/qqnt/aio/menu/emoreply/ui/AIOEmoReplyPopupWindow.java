package com.tencent.qqnt.aio.menu.emoreply.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u00102J\"\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\u001cR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010%R\u0016\u0010(\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b$\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;", "", "Landroid/view/View;", "anchorView", "", "offsetY", "", "location", "c", "offsetX", "b", "a", "contentView", "", "k", "j", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/VerticalAlign;", "align", "p", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/HorizontalAlign;", "l", "bottom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "", h.F, "I", "g", "()I", "w", "e", "Landroid/view/View;", "f", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/VerticalAlign;", "verticalAlign", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/HorizontalAlign;", "horizontalAlign", "anchorOffsetY", "maxBottom", "Landroid/widget/PopupWindow;", "Lkotlin/Lazy;", "()Landroid/widget/PopupWindow;", "popupWindow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;II)V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyPopupWindow {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int w;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int h;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View anchorView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int offsetX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int offsetY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VerticalAlign verticalAlign;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HorizontalAlign horizontalAlign;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int anchorOffsetY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int maxBottom;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupWindow;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyPopupWindow$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351381a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f351382b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33695);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[VerticalAlign.values().length];
            try {
                iArr[VerticalAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerticalAlign.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f351381a = iArr;
            int[] iArr2 = new int[HorizontalAlign.values().length];
            try {
                iArr2[HorizontalAlign.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[HorizontalAlign.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f351382b = iArr2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoReplyPopupWindow(@NotNull final Context context, int i3, int i16) {
        int realWidth;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.w = i3;
        this.h = i16;
        this.verticalAlign = VerticalAlign.BOTTOM;
        this.horizontalAlign = HorizontalAlign.LEFT;
        if (context.getResources().getConfiguration().orientation == 1) {
            realWidth = ScreenUtil.getRealHeight(context);
        } else {
            realWidth = ScreenUtil.getRealWidth(context);
        }
        this.maxBottom = realWidth;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PopupWindow>(context, this) { // from class: com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyPopupWindow$popupWindow$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ AIOEmoReplyPopupWindow this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PopupWindow invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (PopupWindow) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                PopupWindow popupWindow = new PopupWindow(this.$context);
                AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow = this.this$0;
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(false);
                popupWindow.setTouchable(true);
                popupWindow.setSoftInputMode(1);
                popupWindow.setInputMethodMode(2);
                popupWindow.setWidth(aIOEmoReplyPopupWindow.g());
                popupWindow.setHeight(aIOEmoReplyPopupWindow.e());
                popupWindow.setAnimationStyle(0);
                return popupWindow;
            }
        });
        this.popupWindow = lazy;
    }

    private final int a(int offsetY, int[] location) {
        int i3 = location[1] + this.anchorOffsetY;
        location[1] = i3;
        int i16 = i3 + offsetY;
        int height = f().getHeight() + i16;
        int i17 = this.maxBottom;
        if (height > i17) {
            return i17 - f().getHeight();
        }
        return i16;
    }

    private final int b(View anchorView, int offsetX, int[] location) {
        if (anchorView == null) {
            return offsetX;
        }
        int i3 = b.f351382b[this.horizontalAlign.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return ((location[0] + anchorView.getWidth()) - f().getWidth()) + offsetX;
            }
            throw new NoWhenBranchMatchedException();
        }
        return location[0] + offsetX;
    }

    private final int c(View anchorView, int offsetY, int[] location) {
        if (anchorView == null) {
            return offsetY;
        }
        int i3 = b.f351381a[this.verticalAlign.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return a(offsetY + anchorView.getHeight(), location);
            }
            throw new NoWhenBranchMatchedException();
        }
        return a(offsetY, location);
    }

    private final PopupWindow f() {
        return (PopupWindow) this.popupWindow.getValue();
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (f().isShowing()) {
            f().dismiss();
        }
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.h;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.w;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return f().isShowing();
    }

    public final void i(int offsetY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, offsetY);
        } else {
            this.anchorOffsetY = offsetY;
        }
    }

    public final void j(@NotNull View anchorView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anchorView);
        } else {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            this.anchorView = anchorView;
        }
    }

    public final void k(@NotNull View contentView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) contentView);
        } else {
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            this.contentView = contentView;
        }
    }

    public final void l(@NotNull HorizontalAlign align) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) align);
        } else {
            Intrinsics.checkNotNullParameter(align, "align");
            this.horizontalAlign = align;
        }
    }

    public final void m(int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, bottom);
        } else {
            this.maxBottom = bottom;
        }
    }

    public final void n(int offsetX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, offsetX);
        } else {
            this.offsetX = offsetX;
        }
    }

    public final void o(int offsetY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, offsetY);
        } else {
            this.offsetY = offsetY;
        }
    }

    public final void p(@NotNull VerticalAlign align) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) align);
        } else {
            Intrinsics.checkNotNullParameter(align, "align");
            this.verticalAlign = align;
        }
    }

    public final void q() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.contentView != null && (view = this.anchorView) != null) {
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
            }
            f().setContentView(this.contentView);
            PopupWindow f16 = f();
            View view2 = this.anchorView;
            f16.showAtLocation(view2, 0, b(view2, this.offsetX, iArr), c(this.anchorView, this.offsetY, iArr));
            return;
        }
        QLog.i("AIOEmoReplyPopupWindow", 4, "[show] contentView or anchorView is null");
    }
}
