package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/B#\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u00101J(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\"\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "childView", "", "blur", "corner", "color", "", "b", "setShadowColor", "", "scrolling", "setScrolling", "yOffset", "setYOffset", "margin", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadow;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadow;", "getBoxShadowView", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadow;", "setBoxShadowView", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadow;)V", "boxShadowView", "e", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "f", "I", tl.h.F, "getMBlur", "()I", "setMBlur", "(I)V", "mBlur", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class BoxShadowLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BoxShadow boxShadowView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int yOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBlur;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout$a;", "", "", "SHADOW_MARGIN_V_RATIO", UserInfo.SEX_FEMALE, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.BoxShadowLayout$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadowLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    public final void a(int margin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, margin);
            return;
        }
        BoxShadow boxShadow = this.boxShadowView;
        Intrinsics.checkNotNull(boxShadow);
        ViewGroup.LayoutParams layoutParams = boxShadow.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int i3 = this.mBlur;
        layoutParams2.leftMargin = margin - ((int) (i3 * 0.5f));
        layoutParams2.rightMargin = margin - ((int) (i3 * 0.5f));
        View view = this.contentView;
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.leftMargin = margin;
        layoutParams4.rightMargin = margin;
        layoutParams4.bottomMargin = (int) (this.mBlur * 0.75f);
        View view2 = this.contentView;
        Intrinsics.checkNotNull(view2);
        view2.setMinimumHeight(0);
        View view3 = this.contentView;
        Intrinsics.checkNotNull(view3);
        view3.setLayoutParams(layoutParams4);
    }

    public final void b(@Nullable View childView, int blur, int corner, int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, childView, Integer.valueOf(blur), Integer.valueOf(corner), Integer.valueOf(color));
            return;
        }
        this.boxShadowView = new BoxShadow(getContext(), blur, corner, color);
        this.contentView = childView;
        this.mBlur = blur;
        int i3 = (int) (blur * 0.5f);
        addView(this.boxShadowView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = i3;
        layoutParams.bottomMargin = blur;
        addView(this.contentView, layoutParams);
    }

    public final void setBoxShadowView(@Nullable BoxShadow boxShadow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) boxShadow);
        } else {
            this.boxShadowView = boxShadow;
        }
    }

    public final void setContentView(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.contentView = view;
        }
    }

    public final void setMBlur(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mBlur = i3;
        }
    }

    public final void setScrolling(boolean scrolling) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, scrolling);
        }
    }

    public final void setShadowColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, color);
            return;
        }
        BoxShadow boxShadow = this.boxShadowView;
        Intrinsics.checkNotNull(boxShadow);
        boxShadow.setShadowColor(color);
    }

    public final void setYOffset(int yOffset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, yOffset);
            return;
        }
        this.yOffset = yOffset;
        BoxShadow boxShadow = this.boxShadowView;
        Intrinsics.checkNotNull(boxShadow);
        ViewGroup.LayoutParams layoutParams = boxShadow.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin += yOffset;
        View view = this.contentView;
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin += yOffset;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, context, attributeSet, Integer.valueOf(i3));
    }
}
