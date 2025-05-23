package com.tencent.mobileqq.guild.live.fragment.audience.module.gamedatabar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.fragment.audience.module.gamedatabar.QQGuildGameDataBarFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import kf4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nf4.c;
import nq1.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\t*\u0001 \u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "Lnq1/b;", "", "sh", "xh", "", "newHeight", "vh", "(Ljava/lang/Integer;)V", "getLayoutId", "Landroid/view/View;", "view", "initView", "onDestroyView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Context;", "context", "onAttach", "onDetach", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "th", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "D", "I", "itemHeight", "com/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment$b", "E", "Lcom/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment$b;", "barHeightChangedListener", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildGameDataBarFragment extends QQGuildLiveModuleBaseFragment implements nq1.b {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private int itemHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b barHeightChangedListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment$a;", "", "Lcom/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.fragment.audience.module.gamedatabar.QQGuildGameDataBarFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QQGuildGameDataBarFragment a() {
            return new QQGuildGameDataBarFragment();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/gamedatabar/QQGuildGameDataBarFragment$b", "Lnf4/c$a;", "", "newHeight", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements c.a {
        b() {
        }

        @Override // nf4.c.a
        public void a(int newHeight) {
            ViewGroup.LayoutParams layoutParams;
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildGameDataBarFragment", 2, "onHeightChange(from banner listener): " + newHeight);
            }
            View mRootView = QQGuildGameDataBarFragment.this.getMRootView();
            if (mRootView != null) {
                layoutParams = mRootView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = newHeight;
            }
            QQGuildGameDataBarFragment.this.vh(Integer.valueOf(newHeight));
        }
    }

    private final void sh() {
        View view;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        c e16 = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getTimiLiveApi().e(new a(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId()), getActivity());
        if (e16 != null && (view = e16.getView()) != null) {
            View view2 = this.mRootView;
            if (view2 instanceof FrameLayout) {
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.FrameLayout");
                ((FrameLayout) view2).addView(view);
                nq1.c a16 = this.mLiveModuleControl.a();
                if (a16 != null) {
                    a16.onLiveBusinessBarHeightChanged(0);
                }
                QLog.i("QGL.QQGuildGameDataBarFragment", 1, "generateLiveBanner addLiveBanner");
            } else {
                QLog.e("QGL.QQGuildGameDataBarFragment", 1, "generateLiveBanner addLiveBanner failed");
            }
        }
        if (e16 != null) {
            e16.setBannerStatusListener(this.barHeightChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(QQGuildGameDataBarFragment this$0, Boolean isEnterSuccess) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGL.QQGuildGameDataBarFragment", 1, "enter room result: " + isEnterSuccess);
        Intrinsics.checkNotNullExpressionValue(isEnterSuccess, "isEnterSuccess");
        if (isEnterSuccess.booleanValue() && GLiveChannelCore.f226698a.r().e()) {
            this$0.sh();
        } else {
            this$0.xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(final Integer newHeight) {
        int i3 = this.itemHeight;
        if (newHeight == null || newHeight.intValue() != i3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kq1.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQGuildGameDataBarFragment.wh(newHeight, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Integer num, QQGuildGameDataBarFragment this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGL.QQGuildGameDataBarFragment", 1, "onGameDataBarHeightChanged " + num);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        this$0.itemHeight = i3;
        nq1.c a16 = this$0.mLiveModuleControl.a();
        if (a16 != null) {
            a16.onLiveBusinessBarHeightChanged(this$0.itemHeight);
        }
    }

    private final void xh() {
        FrameLayout frameLayout;
        View view = this.mRootView;
        if (view instanceof FrameLayout) {
            if (view instanceof FrameLayout) {
                frameLayout = (FrameLayout) view;
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            QLog.i("QGL.QQGuildGameDataBarFragment", 1, "removeLiveBanner");
            vh(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.exa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        this.mRootView = view;
        LiveData<Boolean> n3 = GLiveChannelCore.f226698a.t().n();
        if (n3 != null) {
            n3.observe(getViewLifecycleOwner(), new Observer() { // from class: kq1.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildGameDataBarFragment.uh(QQGuildGameDataBarFragment.this, (Boolean) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildGameDataBarFragment", 1, "onAttach ");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.d(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.mRootView;
        if (view != null) {
            view.clearAnimation();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildGameDataBarFragment", 1, "onDetach ");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.d(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.mRootView;
        if (view2 != null) {
            num = Integer.valueOf(view2.getHeight());
        } else {
            num = null;
        }
        QLog.i("QGL.QQGuildGameDataBarFragment", 1, "onViewCreated " + num);
    }

    @Nullable
    /* renamed from: th, reason: from getter */
    protected final View getMRootView() {
        return this.mRootView;
    }
}
