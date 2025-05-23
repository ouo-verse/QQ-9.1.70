package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001\u0003B+\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b(\u0010)J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J0\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/MsgTailFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "a", "", "b", "", "msg", "", "c", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "mode", "setOrderMode", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "e", "Landroid/view/View;", "contentReplyView", "", "f", UserInfo.SEX_FEMALE, "extraLeft", h.F, "Z", "needLayoutLeft", "i", "isMixedSort", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;F)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class MsgTailFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentReplyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float extraLeft;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean needLayoutLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isMixedSort;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/MsgTailFrameLayout$a;", "", "", "EXTRA_LEFT_PADDING", UserInfo.SEX_FEMALE, "", "MODE_EMO_REPLY", "I", "MODE_MIXED", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.MsgTailFrameLayout$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgTailFrameLayout(@NotNull Context context, @Nullable RecyclerView recyclerView, @NotNull View contentReplyView, float f16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentReplyView, "contentReplyView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, recyclerView, contentReplyView, Float.valueOf(f16));
            return;
        }
        this.recyclerView = recyclerView;
        this.contentReplyView = contentReplyView;
        this.extraLeft = f16;
        this.needLayoutLeft = true;
        this.isMixedSort = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x000f, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View a() {
        ViewGroup viewGroup;
        ViewParent parent = this.contentReplyView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
            while (viewGroup != null && !(viewGroup instanceof TemplateLayout)) {
                ViewParent parent2 = viewGroup.getParent();
                if (parent2 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent2;
                }
            }
            if (viewGroup == null) {
                return null;
            }
            return viewGroup.findViewById(R.id.lcq);
        }
        viewGroup = null;
    }

    private final int b() {
        boolean z16;
        View a16 = a();
        if (a16 != null) {
            if (a16.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return x.a(35.3f);
            }
            return x.a(8.0f);
        }
        int a17 = x.a(8.0f);
        c("getTargetPaddingLeft=" + a17);
        return a17;
    }

    private final void c(String msg2) {
        if (QLog.isDevelopLevel()) {
            QLog.d("MsgTailFrameLayout", 4, msg2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        if (this.recyclerView == null) {
            c("recyclerView == null");
            super.onLayout(changed, left, top, right, bottom);
        } else if (this.needLayoutLeft) {
            int left2 = this.contentReplyView.getLeft() + this.contentReplyView.getPaddingLeft() + b() + x.a(1.5f) + x.a(this.extraLeft);
            RecyclerView recyclerView = this.recyclerView;
            recyclerView.layout(left2, 0, recyclerView.getMeasuredWidth() + left2, this.recyclerView.getMeasuredHeight());
        } else {
            int right2 = (this.contentReplyView.getRight() - this.contentReplyView.getPaddingRight()) - x.a(4.0f);
            RecyclerView recyclerView2 = this.recyclerView;
            recyclerView2.layout(right2 - recyclerView2.getMeasuredWidth(), 0, right2, this.recyclerView.getMeasuredHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            c("recyclerView == null");
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        measureChildWithMargins(recyclerView, widthMeasureSpec, 0, heightMeasureSpec, 0);
        if (this.recyclerView.getMeasuredWidth() >= (((this.contentReplyView.getMeasuredWidth() - this.contentReplyView.getPaddingLeft()) - this.contentReplyView.getPaddingRight()) - b()) - x.a(4.0f) || !this.isMixedSort) {
            z16 = false;
        }
        this.needLayoutLeft = z16;
        c("recyclerView.measuredWidth=" + this.recyclerView.getMeasuredWidth() + "  \ncontentReplyView.measuredWidth=" + this.contentReplyView.getMeasuredWidth() + " \ncontentReplyView.paddingLeft=" + this.contentReplyView.getPaddingLeft() + " \ncontentReplyView.paddingRight=" + this.contentReplyView.getPaddingRight() + " \nrest=" + x.a(4.0f));
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.recyclerView.getMeasuredHeight());
    }

    public final void setOrderMode(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, mode);
            return;
        }
        boolean z16 = true;
        if (mode == 1 || mode == 2) {
            if (mode != 2) {
                z16 = false;
            }
            this.isMixedSort = z16;
        }
    }
}
