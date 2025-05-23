package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarInitPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "C9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "pickerVm", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "e", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarInitPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarPickerViewModel pickerVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarCropViewModel magicCropVm;

    public MagicAvatarInitPart(@NotNull MagicAvatarPickerViewModel pickerVm, @NotNull MagicAvatarCropViewModel magicCropVm) {
        Intrinsics.checkNotNullParameter(pickerVm, "pickerVm");
        Intrinsics.checkNotNullParameter(magicCropVm, "magicCropVm");
        this.pickerVm = pickerVm;
        this.magicCropVm = magicCropVm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9() {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
    }

    private final void D9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        LiveData<MagicAvatarPickerViewModel.b> T1 = this.pickerVm.T1();
        final Function1<MagicAvatarPickerViewModel.b, Unit> function1 = new Function1<MagicAvatarPickerViewModel.b, Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarInitPart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicAvatarPickerViewModel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MagicAvatarPickerViewModel.b bVar) {
                MagicAvatarCropViewModel magicAvatarCropViewModel;
                if (bVar instanceof MagicAvatarPickerViewModel.b.a) {
                    MagicAvatarDataSource.f323499a.x(((MagicAvatarPickerViewModel.b.a) bVar).getE());
                    MagicAvatarInitPart.this.C9();
                    return;
                }
                if (bVar instanceof MagicAvatarPickerViewModel.b.C9056b) {
                    w53.b.f("MagicAvatarCropFragment", "first init success");
                    Bundle arguments = MagicAvatarInitPart.this.getHostFragment().getArguments();
                    if (arguments != null) {
                        arguments.putParcelable("style_img", ((MagicAvatarPickerViewModel.b.C9056b) bVar).getInfo());
                    }
                    magicAvatarCropViewModel = MagicAvatarInitPart.this.magicCropVm;
                    magicAvatarCropViewModel.c3(((MagicAvatarPickerViewModel.b.C9056b) bVar).getInfo());
                    MagicAvatarInitPart.this.F9();
                    return;
                }
                if (bVar instanceof MagicAvatarPickerViewModel.b.d) {
                    QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
                    MagicAvatarInitPart.this.C9();
                }
            }
        };
        T1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicAvatarInitPart.E9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        broadcastMessage("broadcast_init", "");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        MagicAvatarGenerateInfo magicAvatarGenerateInfo;
        super.onInitView(rootView);
        Bundle arguments = getHostFragment().getArguments();
        if (arguments != null) {
            magicAvatarGenerateInfo = (MagicAvatarGenerateInfo) arguments.getParcelable("style_img");
        } else {
            magicAvatarGenerateInfo = null;
        }
        if (magicAvatarGenerateInfo != null) {
            this.pickerVm.R1(magicAvatarGenerateInfo.getOriginFilePath(), magicAvatarGenerateInfo.getOriginStyleName());
        }
        D9();
    }
}
