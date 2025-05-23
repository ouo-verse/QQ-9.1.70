package com.tencent.mobileqq.multiforward.msglist;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgListMviIntent;
import com.tencent.mobileqq.aio.msglist.aa;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.multiforward.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J \u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", "startPos", "itemCount", "", "payload", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "", "O1", "Landroid/os/Bundle;", "bundle", "", "Q1", "P1", "index", "R1", "Landroid/view/View;", "itemView", "S1", "M1", "view", "Landroid/animation/AnimatorSet;", "N1", "Lcom/tencent/aio/base/mvvm/b;", "F0", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "childView", "T0", "S0", "state", "u0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "M", "I", "mBounceState", "N", "Landroid/animation/AnimatorSet;", "highlightAnimator", "Landroidx/recyclerview/widget/AIORecycleView;", "P", "Landroidx/recyclerview/widget/AIORecycleView;", "mRecyclerView", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    private int mBounceState;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet highlightAnimator;

    /* renamed from: P, reason: from kotlin metadata */
    private AIORecycleView mRecyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/multiforward/msglist/b$a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements AbsMsgListVB.b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multiforward/msglist/b$a$a", "Lxs/a$b;", "Landroid/view/View;", "targetView", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.multiforward.msglist.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static final class C8114a implements a.b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f251517a;

            C8114a(b bVar) {
                this.f251517a = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
                }
            }

            @Override // xs.a.b
            public void b(@Nullable View targetView) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    this.f251517a.S1(targetView);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetView);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
        public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
            int i3;
            AIORecycleView aIORecycleView;
            C8114a c8114a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) helper);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(helper, "helper");
            if (b.this.Q1(state.getExtra())) {
                Bundle extra = state.getExtra();
                if (extra != null) {
                    i3 = extra.getInt("navigate_pos");
                } else {
                    i3 = -1;
                }
                int i16 = i3;
                if (i16 < 0) {
                    return;
                }
                Bundle extra2 = state.getExtra();
                boolean z16 = false;
                if (extra2 != null) {
                    z16 = extra2.getBoolean(HippyQQPagView.FunctionName.FLUSH, false);
                }
                b bVar = b.this;
                AIORecycleView aIORecycleView2 = bVar.mRecyclerView;
                if (aIORecycleView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    aIORecycleView = null;
                } else {
                    aIORecycleView = aIORecycleView2;
                }
                com.tencent.aio.data.msglist.a aVar = state.get(i16);
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                if (!aa.b(bVar, aIORecycleView, (AIOMsgItem) aVar, 0, null, 12, null)) {
                    QLog.i("AbsMsgListVB", 1, "[createFocusIndex]: item is not in currentScreen");
                    if (z16) {
                        c8114a = new C8114a(b.this);
                    } else {
                        c8114a = null;
                    }
                    a.C11562a.a(helper, i16, false, c8114a, 2, null);
                    return;
                }
                QLog.i("AbsMsgListVB", 1, "[createFocusIndex]: item is in currentScreen");
                if (z16) {
                    b.this.R1(i16);
                    return;
                }
                return;
            }
            if (b.this.P1(state.getExtra())) {
                a.C11562a.a(helper, 0, false, null, 6, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/multiforward/msglist/b$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multiforward.msglist.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C8115b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        C8115b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
            } else {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                b.this.sendIntent(new AIOMsgListMviIntent.m(newState, false, 2, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/multiforward/msglist/b$c", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IBounceScrollApi.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(moveType), Integer.valueOf(moveDistance), Float.valueOf(totalDistance));
                return;
            }
            b.this.sendIntent(new AIOMsgListMviIntent.j(moveType, moveDistance, totalDistance));
            if (totalDistance == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (b.this.mBounceState == 1) {
                    b.this.mBounceState = 0;
                    b bVar = b.this;
                    bVar.sendIntent(new AIOMsgListMviIntent.d(bVar.mBounceState));
                    return;
                }
                return;
            }
            if (b.this.mBounceState == 0) {
                b.this.mBounceState = 1;
                b bVar2 = b.this;
                bVar2.sendIntent(new AIOMsgListMviIntent.d(bVar2.mBounceState));
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void M1() {
        AnimatorSet animatorSet = this.highlightAnimator;
        if (animatorSet != null && animatorSet.isStarted()) {
            animatorSet.end();
        }
    }

    private final AnimatorSet N1(View view) {
        int i3;
        int color = ResourcesCompat.getColor(view.getResources(), R.color.qui_common_brand_standard, view.getContext().getTheme());
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 51;
        } else {
            i3 = 25;
        }
        int alphaComponent = ColorUtils.setAlphaComponent(color, i3);
        ObjectAnimator duration = ObjectAnimator.ofInt(view, "backgroundColor", 16643300, alphaComponent).setDuration(16L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofInt(view, \"backgroundC\u2026inkColor).setDuration(16)");
        duration.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration2 = ObjectAnimator.ofInt(view, "backgroundColor", alphaComponent, alphaComponent).setDuration(1000L);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofInt(view, \"backgroundC\u2026kColor).setDuration(1000)");
        duration2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration3 = ObjectAnimator.ofInt(view, "backgroundColor", alphaComponent, 16643300).setDuration(100L);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofInt(view, \"backgroundC\u2026inColor).setDuration(100)");
        duration3.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    private final void O1(int startPos, int itemCount, Object payload, IListUIOperationApi uiHelper) {
        if (startPos >= 0) {
            uiHelper.u(startPos, itemCount, payload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P1(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(QCircleDaTongConstant.ElementParamValue.SET_TOP, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q1(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.containsKey("navigate_pos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(int index) {
        AIORecycleView aIORecycleView = this.mRecyclerView;
        View view = null;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = aIORecycleView.findViewHolderForAdapterPosition(index);
        if (findViewHolderForAdapterPosition != null) {
            view = findViewHolderForAdapterPosition.itemView;
        }
        S1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(View itemView) {
        boolean z16;
        if (itemView == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("AbsMsgListVB", 1, "highlightItemView " + z16);
        if (itemView != null) {
            M1();
            AnimatorSet N1 = N1(itemView);
            this.highlightAnimator = N1;
            if (N1 != null) {
                N1.start();
            }
            if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                AccessibilityUtil.m(itemView);
            }
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @Nullable
    public AbsMsgListVB.b E1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AbsMsgListVB.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.multiforward.msglist.c();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.S0();
            sendIntent(b.a.f251500d);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, createViewParams, childView, uiHelper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        View T0 = super.T0(createViewParams, childView, uiHelper);
        this.mRecyclerView = uiHelper.i();
        AIORecycleView i3 = uiHelper.i();
        i3.setClipToPadding(false);
        i3.addOnScrollListener(new C8115b());
        i3.setItemAnimator(null);
        i3.getLayoutManager().setNeedAnsyAnchor(true);
        uiHelper.a(false);
        uiHelper.setEnableLoadMore(false);
        uiHelper.i0(1);
        uiHelper.C(new c());
        return T0;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof AIOMsgListViewState.AIOMsgItemChangedState) {
            AIOMsgListViewState.AIOMsgItemChangedState aIOMsgItemChangedState = (AIOMsgListViewState.AIOMsgItemChangedState) state;
            O1(aIOMsgItemChangedState.c(), aIOMsgItemChangedState.a(), aIOMsgItemChangedState.b(), uiHelper);
        } else {
            super.u0(state, uiHelper);
            uiHelper.k();
        }
    }
}
