package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropStylePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "pickerVm", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "e", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "styleList", "Lcom/tencent/mobileqq/wink/magicAvatar/ui/m;", tl.h.F, "Lcom/tencent/mobileqq/wink/magicAvatar/ui/m;", "styleAdapter", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;)V", "i", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarCropStylePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarPickerViewModel pickerVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarCropViewModel magicCropVm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView styleList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m styleAdapter;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropStylePart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewExKt.d(8);
        }
    }

    public MagicAvatarCropStylePart(@NotNull MagicAvatarPickerViewModel pickerVm, @NotNull MagicAvatarCropViewModel magicCropVm) {
        Intrinsics.checkNotNullParameter(pickerVm, "pickerVm");
        Intrinsics.checkNotNullParameter(magicCropVm, "magicCropVm");
        this.pickerVm = pickerVm;
        this.magicCropVm = magicCropVm;
    }

    private final void B9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropStylePart$initObserver$1(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropStylePart$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropStylePart$initObserver$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropStylePart$initObserver$4(this, null));
    }

    private final void C9() {
        View findViewById = getPartRootView().findViewById(R.id.f897750o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.styleList)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.styleList = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new b());
        m mVar = new m(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropStylePart$initRecyclerView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                MagicAvatarCropViewModel magicAvatarCropViewModel;
                magicAvatarCropViewModel = MagicAvatarCropStylePart.this.magicCropVm;
                magicAvatarCropViewModel.s2(i3);
            }
        });
        this.styleAdapter = mVar;
        recyclerView.setAdapter(mVar);
        this.magicCropVm.O2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        C9();
        B9();
    }
}
