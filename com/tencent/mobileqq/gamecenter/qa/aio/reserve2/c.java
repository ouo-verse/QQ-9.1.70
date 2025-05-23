package com.tencent.mobileqq.gamecenter.qa.aio.reserve2;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.GameQAUIState;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.b;
import com.tencent.mobileqq.gamecenter.qa.view.GameQAUI;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00100\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/b;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "Lsd1/e;", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "b1", "state", "c1", "", "Ljava/lang/Class;", "getObserverStates", "", "topMargin", "V", "Lvd1/b;", "sessionInfo", "o0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mRootContainer", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", "e", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", "mGameQAUI", "f", "Lvd1/b;", "mSessionInfo", "", h.F, "Z", "mFirstResume", "<init>", "()V", "i", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends com.tencent.aio.base.mvvm.a<b, GameQAUIState> implements sd1.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mRootContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GameQAUI mGameQAUI;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private vd1.b mSessionInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mFirstResume;

    @Override // sd1.e
    public void V(int topMargin) {
        sendIntent(new b.C7646b(topMargin));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<b, GameQAUIState> createVM() {
        QLog.i("GameQAViewBinder", 1, "createVM");
        return new GameQAViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        QLog.i("GameQAViewBinder", 1, "bindViewAndData");
        GameQAUI gameQAUI = this.mGameQAUI;
        if (gameQAUI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            gameQAUI = null;
        }
        gameQAUI.k0();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GameQAUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.i("GameQAViewBinder", 1, "handleUIState, state:" + state);
        GameQAUI gameQAUI = null;
        if (state instanceof GameQAUIState.InitState) {
            GameQAUIState.InitState initState = (GameQAUIState.InitState) state;
            this.mSessionInfo = initState.getGameSessionInfo();
            GameQAUI gameQAUI2 = this.mGameQAUI;
            if (gameQAUI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI2;
            }
            gameQAUI.a1(initState.getGameSessionInfo());
            return;
        }
        if (state instanceof GameQAUIState.OnResumeState) {
            GameQAUI gameQAUI3 = this.mGameQAUI;
            if (gameQAUI3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
                gameQAUI3 = null;
            }
            gameQAUI3.A0();
            if (!this.mFirstResume) {
                GameQAUI gameQAUI4 = this.mGameQAUI;
                if (gameQAUI4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
                } else {
                    gameQAUI = gameQAUI4;
                }
                V(gameQAUI.Y());
            }
            this.mFirstResume = true;
            return;
        }
        if (state instanceof GameQAUIState.OnPauseState) {
            GameQAUI gameQAUI5 = this.mGameQAUI;
            if (gameQAUI5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI5;
            }
            gameQAUI.z0();
            return;
        }
        if (state instanceof GameQAUIState.KeyboardStatusChange) {
            GameQAUI gameQAUI6 = this.mGameQAUI;
            if (gameQAUI6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI6;
            }
            gameQAUI.w0(Intrinsics.areEqual(((GameQAUIState.KeyboardStatusChange) state).getShow(), Boolean.TRUE));
            return;
        }
        if (state instanceof GameQAUIState.AioFoldFinish) {
            GameQAUI gameQAUI7 = this.mGameQAUI;
            if (gameQAUI7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI7;
            }
            gameQAUI.z0();
            return;
        }
        if (state instanceof GameQAUIState.AioUnFoldFinish) {
            GameQAUI gameQAUI8 = this.mGameQAUI;
            if (gameQAUI8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI8;
            }
            gameQAUI.A0();
            return;
        }
        if (state instanceof GameQAUIState.MultiSelectModeChange) {
            GameQAUI gameQAUI9 = this.mGameQAUI;
            if (gameQAUI9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            } else {
                gameQAUI = gameQAUI9;
            }
            gameQAUI.x0(Intrinsics.areEqual(((GameQAUIState.MultiSelectModeChange) state).getIsMutliSelect(), Boolean.TRUE));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GameQAUIState>> getObserverStates() {
        List<Class<? extends GameQAUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GameQAUIState.InitState.class, GameQAUIState.OnResumeState.class, GameQAUIState.OnPauseState.class, GameQAUIState.KeyboardStatusChange.class, GameQAUIState.MultiSelectModeChange.class, GameQAUIState.AioFoldFinish.class, GameQAUIState.AioUnFoldFinish.class});
        return listOf;
    }

    @Override // sd1.e
    public void o0(@NotNull vd1.b sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        sendIntent(new b.a(sessionInfo));
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("GameQAViewBinder", 1, "onCreateView");
        this.mRootContainer = new RelativeLayout(params.a());
        GameQAUI gameQAUI = new GameQAUI(this);
        this.mGameQAUI = gameQAUI;
        Context a16 = params.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) a16;
        RelativeLayout relativeLayout = this.mRootContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            relativeLayout = null;
        }
        gameQAUI.t0(qBaseActivity, relativeLayout);
        RelativeLayout relativeLayout2 = this.mRootContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            return null;
        }
        return relativeLayout2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        QLog.i("GameQAViewBinder", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        GameQAUI gameQAUI = this.mGameQAUI;
        if (gameQAUI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameQAUI");
            gameQAUI = null;
        }
        gameQAUI.u0();
    }
}
