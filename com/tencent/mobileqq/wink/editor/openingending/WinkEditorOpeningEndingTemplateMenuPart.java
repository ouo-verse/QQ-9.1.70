package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "", "oa", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Bundle;", "args", "L9", "", "onBackEvent", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "M", "Lkotlin/Lazy;", "wa", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "viewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingTemplateMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkEditorOpeningEndingTemplateMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateMenuPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                Activity activity = WinkEditorOpeningEndingTemplateMenuPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                ViewModel viewModel = new ViewModelProvider((FragmentActivity) activity).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider((activ\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
    }

    private final WinkEditorOpeningEndingViewModel wa() {
        return (WinkEditorOpeningEndingViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        List<MediaClip> arrayList;
        BackgroundModel backgroundModel;
        FragmentManager childFragmentManager;
        MediaModel V;
        super.L9(args);
        dr H9 = H9();
        if (H9 == null || (arrayList = H9.a0()) == null) {
            arrayList = new ArrayList<>();
        }
        List<MediaClip> list = arrayList;
        dr H92 = H9();
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (H92 != null && (V = H92.V()) != null) {
            backgroundModel = V.backgroundModel;
        } else {
            backgroundModel = null;
        }
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            childFragmentManager.beginTransaction().add(R.id.f123867ht, new WinkEditorOpeningEndingTemplateFragment(list, null, false, backgroundModel, 6, null), "WinkEditorOpeningEndingTemplateFragment").addToBackStack("WinkEditorOpeningEndingTemplateFragment").commitAllowingStateLoss();
            ActivityResultCaller hostFragment2 = getHostFragment();
            if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
            }
            if (aVar != null) {
                aVar.g1(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.OPENING_ENDING;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        FragmentManager fragmentManager;
        Fragment findFragmentByTag;
        Fragment findFragmentByTag2;
        Fragment hostFragment = getHostFragment();
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (hostFragment != null) {
            fragmentManager = hostFragment.getChildFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null && (findFragmentByTag2 = fragmentManager.findFragmentByTag("WinkEditorOpeningEndingAigcImageSelectFragment")) != null && (findFragmentByTag2 instanceof WinkEditorOpeningEndingAigcImageSelectFragment)) {
            ((WinkEditorOpeningEndingAigcImageSelectFragment) findFragmentByTag2).dismiss();
            return true;
        }
        if (fragmentManager != null && (findFragmentByTag = fragmentManager.findFragmentByTag("WinkEditorOpeningEndingTemplateFragment")) != null && (findFragmentByTag instanceof WinkEditorOpeningEndingTemplateFragment)) {
            ((WinkEditorOpeningEndingTemplateFragment) findFragmentByTag).dismiss();
            x9();
            ActivityResultCaller hostFragment2 = getHostFragment();
            if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
            }
            if (aVar != null) {
                aVar.g1(false);
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        LiveData<Boolean> s26 = wa().s2();
        Fragment hostFragment = getHostFragment();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateMenuPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (bool.booleanValue()) {
                    return;
                }
                WinkEditorOpeningEndingTemplateMenuPart.this.x9();
                ActivityResultCaller hostFragment2 = WinkEditorOpeningEndingTemplateMenuPart.this.getHostFragment();
                com.tencent.mobileqq.wink.editor.a aVar = hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a ? (com.tencent.mobileqq.wink.editor.a) hostFragment2 : null;
                if (aVar != null) {
                    aVar.g1(false);
                }
            }
        };
        s26.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingTemplateMenuPart.xa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
