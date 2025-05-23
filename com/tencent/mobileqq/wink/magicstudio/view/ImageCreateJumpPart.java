package com.tencent.mobileqq.wink.magicstudio.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/ImageCreateJumpPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "A9", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "it", "z9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "getVm", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "vm", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "e", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ImageCreateJumpPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioCreationViewModel vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioPicStyle magicStudioPicStyle;

    public ImageCreateJumpPart(@NotNull MagicStudioCreationViewModel vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
    }

    private final void A9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            MagicStudioCreationViewModel magicStudioCreationViewModel = this.vm;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            MagicStudioCreationViewModel.v2(magicStudioCreationViewModel, hostFragment, context, hostFragment.requireView(), new ImageCreateJumpPart$initFlow$1$1(this), null, null, null, false, false, w.CTRL_INDEX, null);
        }
    }

    private final void B9() {
        A9();
    }

    private final void C9() {
        Serializable serializable;
        Map map;
        Serializable serializable2;
        boolean z16;
        Intent intent;
        Activity activity = getActivity();
        String str = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof Map) {
            map = (Map) serializable;
        } else {
            map = null;
        }
        if (map != null) {
            if (map.containsKey("magic_studio_prompt")) {
                this.vm.w3((String) map.get("magic_studio_prompt"));
                w53.b.a("ImageCreationFragment", "scheme prompt is: " + map.get("magic_studio_prompt"));
            }
            if (map.containsKey("magic_studio_style")) {
                this.vm.x3((String) map.get("magic_studio_style"));
                w53.b.a("ImageCreationFragment", "scheme style is: " + map.get("magic_studio_style"));
            }
        }
        Bundle arguments = getHostFragment().getArguments();
        if (arguments != null) {
            serializable2 = arguments.getSerializable("magic_studio_pic_style");
        } else {
            serializable2 = null;
        }
        this.magicStudioPicStyle = (MagicStudioPicStyle) serializable2;
        String schemaStyle = this.vm.getSchemaStyle();
        if (schemaStyle != null && schemaStyle.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            MagicStudioCreationViewModel magicStudioCreationViewModel = this.vm;
            MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
            if (magicStudioPicStyle != null) {
                str = magicStudioPicStyle.getStyleId();
            }
            magicStudioCreationViewModel.x3(str);
        }
        w53.b.a("ImageCreationFragment", "scheme style final is: " + this.vm.getSchemaStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z9(MagicStudioCreationViewModel.b.GotoMultiSelect it) {
        FragmentActivity fragmentActivity;
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            MagicStudioCreationViewModel magicStudioCreationViewModel = this.vm;
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCMultiSelectFragment(fragmentActivity, magicStudioCreationViewModel.k3(activity2, it, this.magicStudioPicStyle));
            ((MagicStudioViewModel) new ViewModelProvider(fragmentActivity).get(MagicStudioViewModel.class)).T1(1);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        C9();
        B9();
    }
}
