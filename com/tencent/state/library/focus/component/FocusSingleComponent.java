package com.tencent.state.library.focus.component;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.SingleAvatarAnimator;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.map.MapViewConfigKt;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.databinding.VasSquareLibrarySingleViewBinding;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.template.data.User;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u000f0\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusSingleComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "Lcom/tencent/state/library/focus/IFocusParentView;", "()V", "animator", "Lcom/tencent/state/library/focus/SingleAvatarAnimator;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibrarySingleViewBinding;", "fromPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCommonView", "Lcom/tencent/state/library/focus/view/FocusCommonView;", "getView", "Landroid/view/View;", "initAvatar", "", "initView", "onFragmentPaused", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentResumed", "onFragmentViewCreated", "v", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "playAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lkotlin/Function1;", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusSingleComponent extends FocusBaseComponent implements IFocusParentView {
    private SingleAvatarAnimator animator;
    private VasSquareLibrarySingleViewBinding binding;
    private AtomicBoolean fromPause = new AtomicBoolean(false);

    private final void initAvatar() {
        SquareAvatarView it;
        FocusItem singleItem;
        Resource focusResource;
        FocusItem singleItem2;
        User user;
        UserCommon info;
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding == null || (it = vasSquareLibrarySingleViewBinding.avatarImage) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.animator = new SingleAvatarAnimator(it, MapViewConfigKt.defaultFocusAnimaConfig());
        MapPlayableSource mapPlayableSource = null;
        r1 = null;
        r1 = null;
        r1 = null;
        Integer num = null;
        mapPlayableSource = null;
        mapPlayableSource = null;
        it.setOnClickListener(null);
        it.setConfig(new AvatarAnimConfig(true, SquareMedia.INSTANCE.getCommonPlayerPool(), new PlayConfig(-1, true, null, 4, null), true));
        it.setVisibility(0);
        final SingleAvatarAnimator singleAvatarAnimator = this.animator;
        if (singleAvatarAnimator != null) {
            ViewExtensionsKt.updateLayoutParams(it, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.focus.component.FocusSingleComponent$initAvatar$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = SingleAvatarAnimator.this.getConfig().getAvatarWidth();
                    receiver.height = SingleAvatarAnimator.this.getConfig().getAvatarHeight();
                    receiver.bottomMargin = SingleAvatarAnimator.this.getConfig().getSingleBottomMargin();
                }
            });
        }
        SingleAvatarAnimator singleAvatarAnimator2 = this.animator;
        if (singleAvatarAnimator2 != null) {
            FocusBaseItem data = getData();
            if (data != null && (singleItem = data.getSingleItem()) != null && (focusResource = FocusDataKt.focusResource(singleItem)) != null) {
                FocusBaseItem data2 = getData();
                if (data2 != null && (singleItem2 = data2.getSingleItem()) != null && (user = singleItem2.getUser()) != null && (info = user.getInfo()) != null) {
                    num = Integer.valueOf(info.getDefaultResourceId());
                }
                mapPlayableSource = SquareItemKt.toMapPlayableSource(focusResource, num);
            }
            singleAvatarAnimator2.enterScaleAnim(mapPlayableSource, false, new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusSingleComponent$initAvatar$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FocusItem singleItem3;
                    FocusBaseFragment focusFragment;
                    FocusBaseItem data3 = FocusSingleComponent.this.getData();
                    if (data3 == null || (singleItem3 = data3.getSingleItem()) == null || (focusFragment = FocusSingleComponent.this.getFocusFragment()) == null) {
                        return;
                    }
                    focusFragment.updateLibraryItemVisible(FocusDataKt.getId(singleItem3), FocusDataKt.getType(singleItem3), false);
                }
            });
        }
    }

    private final void initView() {
        FocusBaseItem data;
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding;
        FocusCommonView focusCommonView;
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment == null || (data = getData()) == null || (vasSquareLibrarySingleViewBinding = this.binding) == null || (focusCommonView = vasSquareLibrarySingleViewBinding.commonView) == null) {
            return;
        }
        focusCommonView.initView(data, focusFragment);
    }

    @Override // com.tencent.state.library.focus.IFocusParentView
    public FocusCommonView getCommonView() {
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding != null) {
            return vasSquareLibrarySingleViewBinding.commonView;
        }
        return null;
    }

    @Override // com.tencent.state.library.focus.IFocusParentView
    public View getView() {
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding != null) {
            return vasSquareLibrarySingleViewBinding.getMRv();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fm5, Fragment f16) {
        SquareAvatarView squareAvatarView;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentPaused(fm5, f16);
        this.fromPause.set(true);
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding == null || (squareAvatarView = vasSquareLibrarySingleViewBinding.avatarImage) == null) {
            return;
        }
        squareAvatarView.stop();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        FocusBaseItem data;
        FocusItem singleItem;
        Resource focusResource;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentResumed(fm5, f16);
        if (!this.fromPause.compareAndSet(true, false) || (data = getData()) == null || (singleItem = data.getSingleItem()) == null || (focusResource = FocusDataKt.focusResource(singleItem)) == null) {
            return;
        }
        playAvatar(focusResource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.component.FocusSingleComponent$onFragmentResumed$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareLibrarySingleViewBinding.bind(v3);
        initView();
        initAvatar();
    }

    public final void playAvatar(Resource resource, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SingleAvatarAnimator singleAvatarAnimator = this.animator;
        if (singleAvatarAnimator != null) {
            singleAvatarAnimator.updateAvatar(resource, callback);
        }
    }
}
