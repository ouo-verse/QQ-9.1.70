package com.tencent.mobileqq.wink.editor.crop;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMenuPart;
import com.tencent.mobileqq.wink.editor.crop.model.WinkCropUIData;
import com.tencent.mobileqq.wink.editor.crop.viewmodel.WinkEditorCropViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "xa", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "onInitView", "oa", "K9", "", "B9", "Landroid/os/Bundle;", "args", "L9", "", "onBackEvent", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "Lcom/tencent/mobileqq/wink/editor/template/x;", "M", "Lcom/tencent/mobileqq/wink/editor/template/x;", "mWinkEditorTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "N", "Lkotlin/Lazy;", "getMusicVolumeViewModel", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "P", "wa", "()Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "cropViewModel", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    private x mWinkEditorTemplateViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    public WinkEditorCropMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMenuPart$musicVolumeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ComponentCallbacks2 activity = WinkEditorCropMenuPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
                return (MusicVolumeControlViewModel) new ViewModelProvider((ViewModelStoreOwner) activity).get(MusicVolumeControlViewModel.class);
            }
        });
        this.musicVolumeViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorCropViewModel>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMenuPart$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorCropViewModel invoke() {
                ComponentCallbacks2 activity = WinkEditorCropMenuPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
                return (WinkEditorCropViewModel) new ViewModelProvider((ViewModelStoreOwner) activity).get(WinkEditorCropViewModel.class);
            }
        });
        this.cropViewModel = lazy2;
    }

    private final WinkEditorCropViewModel wa() {
        return (WinkEditorCropViewModel) this.cropViewModel.getValue();
    }

    private final void xa() {
        List<MediaClip> a06;
        long j3;
        FragmentManager childFragmentManager;
        com.tencent.mobileqq.wink.editor.a aVar;
        dr H9 = H9();
        if (H9 != null && (a06 = H9.a0()) != null) {
            boolean z16 = H9 instanceof WinkImageTavCut;
            if (z16) {
                j3 = ((WinkImageTavCut) H9).getCurrentPosition();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            Fragment hostFragment = getHostFragment();
            if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
                childFragmentManager.beginTransaction().add(R.id.f123867ht, WinkEditorCropFragment.INSTANCE.a(new ArrayList<>(a06), 0L, z16, H9.getDurationUs(), j16, false), "TAG_CROP").addToBackStack("TAG_CROP").commit();
                ActivityResultCaller hostFragment2 = getHostFragment();
                if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                    aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.g1(true);
                }
                wa().n2(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(WinkEditorCropMenuPart this$0, Pair pair) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.c((List) pair.getFirst());
            if (H9 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H9;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut == null) {
                return;
            }
            winkVideoTavCut.m0(new b(winkVideoTavCut, this$0));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.ubm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        xa();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
        if (uiData instanceof WinkCropUIData) {
            O9(uiData);
            wa().f2((WinkCropUIData) uiData);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.CROP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ViewModel viewModel = getViewModel(x.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorT\u2026ateViewModel::class.java)");
        this.mWinkEditorTemplateViewModel = (x) viewModel;
        WinkEditorCropViewModel wa5 = wa();
        WinkEditUIData uiData = getUiData();
        Intrinsics.checkNotNull(uiData, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.crop.model.WinkCropUIData");
        wa5.X1((WinkCropUIData) uiData);
        wa().O1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.crop.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorCropMenuPart.za(WinkEditorCropMenuPart.this, (Pair) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Fragment fragment;
        FragmentManager childFragmentManager;
        Fragment hostFragment = getHostFragment();
        WinkEditorCropFragment winkEditorCropFragment = null;
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            fragment = childFragmentManager.findFragmentByTag("TAG_CROP");
        } else {
            fragment = null;
        }
        if (fragment instanceof WinkEditorCropFragment) {
            winkEditorCropFragment = (WinkEditorCropFragment) fragment;
        }
        if (winkEditorCropFragment != null && winkEditorCropFragment.isAdded() && !winkEditorCropFragment.isHidden()) {
            return winkEditorCropFragment.handleBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        FragmentManager fragmentManager;
        int i3;
        String str;
        FragmentManager.BackStackEntry backStackEntryAt;
        Fragment hostFragment = getHostFragment();
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (hostFragment != null) {
            fragmentManager = hostFragment.getChildFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            i3 = fragmentManager.getBackStackEntryCount();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (fragmentManager != null && (backStackEntryAt = fragmentManager.getBackStackEntryAt(i3 - 1)) != null) {
                str = backStackEntryAt.getName();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "TAG_CROP")) {
                fragmentManager.popBackStack();
                ActivityResultCaller hostFragment2 = getHostFragment();
                if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                    aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
                }
                if (aVar != null) {
                    aVar.g1(false);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(new WinkCropUIData(this));
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart$b", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkVideoTavCut f319763a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorCropMenuPart f319764b;

        b(WinkVideoTavCut winkVideoTavCut, WinkEditorCropMenuPart winkEditorCropMenuPart) {
            this.f319763a = winkVideoTavCut;
            this.f319764b = winkEditorCropMenuPart;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorCropMenuPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ((m63.d) this$0.getViewModel(m63.d.class)).n2();
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            this.f319763a.d(this);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorCropMenuPart winkEditorCropMenuPart = this.f319764b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.q
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorCropMenuPart.b.b(WinkEditorCropMenuPart.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
