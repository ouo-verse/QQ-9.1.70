package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent;
import com.tencent.biz.qui.dragrefresh.QUIDragRefreshView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.view.RefreshView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b(\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003J0\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0018\u0010%\u001a\u00020\b*\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView;", "Lcom/qqnt/widget/smartrefreshlayout/layout/simple/SimpleComponent;", "Lq3/d;", "", "isNight", "Landroid/view/View;", tl.h.F, "i", "", "padding", "", "setTopPadding", NodeProps.VISIBLE, "setProgressViewVisible", "isDragging", "", "percent", "offset", "height", "maxDragHeight", "onMoving", "Lq3/f;", "refreshLayout", "c", "success", "b", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "j", "Landroid/view/View;", "refreshProgressView", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "curState", "g", "(I)I", "dp", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AnimRefreshHeaderView extends SimpleComponent implements q3.d {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View refreshProgressView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState curState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView$a;", "", "", "COMPLETE_LOTTIE_PROGRESS", UserInfo.SEX_FEMALE, "COMPLETE_QUI_ANIM_PROGRESS", "", "QUI_REFRESH_VIEW_HEIGHT", "I", "QUI_REFRESH_VIEW_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.AnimRefreshHeaderView$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimRefreshHeaderView(@NotNull Context context) {
        this(context, null, false);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final int g(int i3) {
        return ViewUtils.dpToPx(i3);
    }

    private final View h(boolean isNight) {
        View refreshView;
        RelativeLayout.LayoutParams layoutParams;
        boolean a16 = ChatsListConfig.f354433a.a();
        QLog.i("RefreshHeaderView", 1, "quiLoadingSwitch: " + a16);
        if (a16) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            refreshView = new QUIDragRefreshView(context, null, 0, 6, null);
        } else {
            refreshView = new RefreshView(getContext(), (RefreshView.b) null, isNight);
        }
        if (a16) {
            layoutParams = new RelativeLayout.LayoutParams(g(64), g(64));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(g(40), g(40));
        }
        layoutParams.addRule(14);
        layoutParams.addRule(8);
        addView(refreshView, layoutParams);
        setPadding(getPaddingLeft(), g(72), getPaddingRight(), g(16));
        setTranslationY(-g(40));
        if (refreshView instanceof QUIDragRefreshView) {
            ((QUIDragRefreshView) refreshView).p();
        }
        return refreshView;
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.a
    public int b(@NotNull q3.f refreshLayout, boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, refreshLayout, Boolean.valueOf(success))).intValue();
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        View view = this.refreshProgressView;
        if (!(view instanceof RefreshView)) {
            return 0;
        }
        return (int) (((RefreshView) view).c() * 1000);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.a
    public void c(@NotNull q3.f refreshLayout, int height, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, refreshLayout, Integer.valueOf(height), Integer.valueOf(maxDragHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        super.c(refreshLayout, height, maxDragHeight);
        View view = this.refreshProgressView;
        if (view instanceof QUIDragRefreshView) {
            ((QUIDragRefreshView) view).r();
        } else if (view instanceof RefreshView) {
            ((RefreshView) view).j();
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NotNull q3.f refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, refreshLayout, oldState, newState);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        super.d(refreshLayout, oldState, newState);
        this.curState = newState;
        if ((oldState == RefreshState.PullUpCanceled || oldState == RefreshState.RefreshFinish || oldState == RefreshState.PullDownCanceled) && newState == RefreshState.None) {
            QLog.d("RefreshHeaderView", 4, "finish Anim");
            View view = this.refreshProgressView;
            if (view instanceof QUIDragRefreshView) {
                ((QUIDragRefreshView) view).t();
                getView().setVisibility(8);
            } else if (view instanceof RefreshView) {
                ((RefreshView) view).k();
            }
        }
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.refreshProgressView instanceof QUIDragRefreshView;
    }

    public final void j(boolean isNight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isNight);
            return;
        }
        View view = this.refreshProgressView;
        if (view instanceof RefreshView) {
            ((RefreshView) view).i(isNight);
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.a
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(height), Integer.valueOf(maxDragHeight));
            return;
        }
        super.onMoving(isDragging, percent, offset, height, maxDragHeight);
        float f16 = offset / height;
        if (!i()) {
            f16 -= 0.4f;
        }
        float f17 = ((f16 * 0.5f) * 7) / 5;
        if (i()) {
            if (f17 > 1.0f) {
                f17 = 1.0f;
            }
        } else if (f17 > 0.5f) {
            f17 = 0.5f;
        }
        View view = this.refreshProgressView;
        if (view instanceof QUIDragRefreshView) {
            RefreshState refreshState = this.curState;
            if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshReleased) {
                ((QUIDragRefreshView) view).setDragProgress(f17);
                return;
            }
            return;
        }
        if ((view instanceof RefreshView) && isDragging) {
            RefreshView refreshView = (RefreshView) view;
            refreshView.setProgress(f17);
            float f18 = ((f17 * 6) / 5) + 0.5f;
            refreshView.setPivotX(this.refreshProgressView.getMeasuredWidth() / 2.0f);
            refreshView.setPivotY(this.refreshProgressView.getMeasuredHeight());
            refreshView.setScaleY(f18);
            refreshView.setScaleX(f18);
        }
    }

    public final void setProgressViewVisible(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, visible);
            return;
        }
        View view = this.refreshProgressView;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view.setVisibility(i3);
    }

    public final void setTopPadding(int padding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, padding);
        } else {
            setPadding(getPaddingLeft(), padding, getPaddingRight(), getPaddingBottom());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimRefreshHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Boolean.valueOf(z16));
        } else {
            this.curState = RefreshState.None;
            this.refreshProgressView = h(z16);
        }
    }
}
