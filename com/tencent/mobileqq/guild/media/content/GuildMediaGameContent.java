package com.tencent.mobileqq.guild.media.content;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.game.widget.GameContentView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/GuildMediaGameContent;", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", "", "C0", "E", "Landroid/view/View;", "xh", "()Landroid/view/View;", OcrConfig.CHINESE, "(Landroid/view/View;)V", "mRootView", "Lcom/tencent/mobileqq/guild/media/game/widget/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/game/widget/a;", "wh", "()Lcom/tencent/mobileqq/guild/media/game/widget/a;", "yh", "(Lcom/tencent/mobileqq/guild/media/game/widget/a;)V", "mGameViewPresenter", "Lbt1/h;", "G", "Lbt1/h;", "roomViewModel", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaGameContent extends GuildMediaContentFragmentBase {

    /* renamed from: E, reason: from kotlin metadata */
    public View mRootView;

    /* renamed from: F, reason: from kotlin metadata */
    public com.tencent.mobileqq.guild.media.game.widget.a mGameViewPresenter;

    /* renamed from: G, reason: from kotlin metadata */
    private bt1.h roomViewModel;

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean C0() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("QMGame.GuildMediaGameContent", 1, "[onConfigurationChanged] ");
        super.onConfigurationChanged(newConfig);
        wh().h(newConfig);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModel viewModel = new ViewModelProvider(activity, new bt1.a(1L)).get(bt1.h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     \u2026oomViewModel::class.java]");
        bt1.h hVar = (bt1.h) viewModel;
        this.roomViewModel = hVar;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        hVar.z2();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("QMGame.GuildMediaGameContent", 1, "[onCreateView] ");
        View inflate = inflater.inflate(R.layout.ey5, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026t_game, container, false)");
        zh(inflate);
        WeakReference weakReference = new WeakReference(getActivity());
        View findViewById = xh().findViewById(R.id.viq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.game_content_view)");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "this.viewLifecycleOwner");
        yh(new com.tencent.mobileqq.guild.media.game.widget.a((GameContentView) findViewById, viewLifecycleOwner, weakReference));
        com.tencent.mobileqq.guild.media.game.widget.a wh5 = wh();
        bt1.h hVar = this.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        wh5.j(hVar);
        View xh5 = xh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, xh5);
        return xh5;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.i("QMGame.GuildMediaGameContent", 1, "[onDestroyView] ");
        super.onDestroyView();
        wh().g();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.i("QMGame.GuildMediaGameContent", 1, "[onViewCreated] ");
        super.onViewCreated(view, savedInstanceState);
        wh().i();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.media.game.widget.a wh() {
        com.tencent.mobileqq.guild.media.game.widget.a aVar = this.mGameViewPresenter;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGameViewPresenter");
        return null;
    }

    @NotNull
    public final View xh() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public final void yh(@NotNull com.tencent.mobileqq.guild.media.game.widget.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mGameViewPresenter = aVar;
    }

    public final void zh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }
}
