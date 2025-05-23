package com.tencent.mobileqq.wink.magicstudio.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.util.h;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.c;
import com.tencent.mobileqq.wink.picker.report.AlbumSelectionData;
import e93.i;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/picker/MagicStudioSingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "", "Hi", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "requestCode", "Ii", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "imgInfo", "Landroid/os/Bundle;", "gotoMultiSelectInfo", "Ji", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Landroid/view/View;", "view", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Ze", "gi", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "a0", "Lkotlin/Lazy;", "Gi", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "magicStudioCreationViewModel", "b0", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "magicMediaInfo", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "c0", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "<init>", "()V", "d0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioSingleMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy magicStudioCreationViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo magicMediaInfo;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioPicStyle magicStudioPicStyle;

    public MagicStudioSingleMediaPickerFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.picker.MagicStudioSingleMediaPickerFragment$magicStudioCreationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioCreationViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicStudioSingleMediaPickerFragment.this).get(MagicStudioCreationViewModel.class);
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) viewModel;
                magicStudioCreationViewModel.u3(true);
                magicStudioCreationViewModel.s3(true);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026enerated = true\n        }");
                return magicStudioCreationViewModel;
            }
        });
        this.magicStudioCreationViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioCreationViewModel Gi() {
        return (MagicStudioCreationViewModel) this.magicStudioCreationViewModel.getValue();
    }

    private final void Hi() {
        MagicStudioCreationViewModel Gi = Gi();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        MagicStudioCreationViewModel.v2(Gi, this, requireContext, requireView(), new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.picker.MagicStudioSingleMediaPickerFragment$observerMagicStudio$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
                invoke2(gotoMultiSelect);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect selectInfo) {
                LocalMediaInfo localMediaInfo;
                MagicStudioCreationViewModel Gi2;
                MagicStudioPicStyle magicStudioPicStyle;
                Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
                localMediaInfo = MagicStudioSingleMediaPickerFragment.this.magicMediaInfo;
                if (localMediaInfo != null) {
                    MagicStudioSingleMediaPickerFragment magicStudioSingleMediaPickerFragment = MagicStudioSingleMediaPickerFragment.this;
                    Gi2 = magicStudioSingleMediaPickerFragment.Gi();
                    FragmentActivity requireActivity = magicStudioSingleMediaPickerFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    magicStudioPicStyle = magicStudioSingleMediaPickerFragment.magicStudioPicStyle;
                    magicStudioSingleMediaPickerFragment.Ji(localMediaInfo, c.f324480a.b().getBusinessRequestCode(), null, Gi2.k3(requireActivity, selectInfo, magicStudioPicStyle));
                }
            }
        }, null, null, null, false, false, w.CTRL_INDEX, null);
    }

    private final void Ii(final LocalMediaInfo mediaInfo, final int requestCode) {
        int x16 = i.x(mediaInfo);
        Context context = getContext();
        if (context != null) {
            d93.c.INSTANCE.b(context, x16, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.picker.MagicStudioSingleMediaPickerFragment$returnPicPath$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MagicStudioCreationViewModel Gi;
                    MagicStudioPicStyle magicStudioPicStyle;
                    MagicStudioPicStyle magicStudioPicStyle2;
                    int i3 = requestCode;
                    if (i3 == 101) {
                        this.magicMediaInfo = mediaInfo;
                        if (!h.f322638a.c()) {
                            Gi = this.Gi();
                            String str = mediaInfo.path;
                            magicStudioPicStyle = this.magicStudioPicStyle;
                            Intrinsics.checkNotNull(magicStudioPicStyle);
                            MagicStudioCreationViewModel.q3(Gi, str, magicStudioPicStyle, false, null, 0, 28, null);
                            return;
                        }
                        MagicStudioCreationViewModel.Companion companion = MagicStudioCreationViewModel.INSTANCE;
                        magicStudioPicStyle2 = this.magicStudioPicStyle;
                        this.Ji(mediaInfo, requestCode, null, companion.a(magicStudioPicStyle2, mediaInfo, false));
                        return;
                    }
                    MagicStudioSingleMediaPickerFragment.Ki(this, mediaInfo, i3, null, null, 12, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji(LocalMediaInfo mediaInfo, int requestCode, MagicStudioUploadImgAndStyle imgInfo, Bundle gotoMultiSelectInfo) {
        Bundle bundle;
        Intent intent;
        Intent intent2;
        Intent intent3 = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER);
        bundle2.putSerializable(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH, mediaInfo);
        if (imgInfo != null) {
            bundle2.putParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_MAGIC_INFO, imgInfo);
            FragmentActivity activity = getActivity();
            Bundle bundle3 = null;
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                bundle = intent2.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
            } else {
                bundle = null;
            }
            if (bundle != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null) {
                    bundle3 = intent.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
                }
                bundle2.putAll(bundle3);
            }
        }
        if (gotoMultiSelectInfo != null) {
            bundle2.putBundle(AECameraConstants.FRAGMENT_CAMERA_GOTO_MULTI_SELECT_INFO, gotoMultiSelectInfo);
        }
        intent3.putExtras(bundle2);
        String str = mediaInfo.path;
        if (str != null) {
            b.f("MagicStudioSingleMediaPickerFragment", "return pic path: " + str);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.setResult(requestCode, intent3);
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            activity4.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Ki(MagicStudioSingleMediaPickerFragment magicStudioSingleMediaPickerFragment, LocalMediaInfo localMediaInfo, int i3, MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle, Bundle bundle, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            magicStudioUploadImgAndStyle = null;
        }
        if ((i16 & 8) != 0) {
            bundle = null;
        }
        magicStudioSingleMediaPickerFragment.Ji(localMediaInfo, i3, magicStudioUploadImgAndStyle, bundle);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.MagicStudio;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        Ii(mediaInfo, c.f324480a.b().getBusinessRequestCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void gi() {
        b.f(getTAG(), "onPickerExit invoke");
        AlbumSelectionData.a();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Serializable serializable;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Hi();
        Bundle arguments = getArguments();
        if (arguments != null && (bundle = arguments.getBundle(AECameraConstants.FRAGMENT_EXTRA_DATA)) != null) {
            serializable = bundle.getSerializable("magic_studio_pic_style");
        } else {
            serializable = null;
        }
        this.magicStudioPicStyle = (MagicStudioPicStyle) serializable;
    }
}
