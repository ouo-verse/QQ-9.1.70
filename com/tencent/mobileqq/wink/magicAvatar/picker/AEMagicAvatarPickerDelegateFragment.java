package com.tencent.mobileqq.wink.magicAvatar.picker;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.g;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropFragment;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0001H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/AEMagicAvatarPickerDelegateFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/a;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "img", "", "rh", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Ze", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onReceiveActivityResult", "", "P5", "fragment", "hg", "onBackEvent", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/Fragment;", "hostFragment", "", "D", "Ljava/lang/String;", "style", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "E", "Lkotlin/Lazy;", "qh", "()Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AEMagicAvatarPickerDelegateFragment extends ReportAndroidXFragment implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private Fragment hostFragment;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String style = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicCropVm;

    public AEMagicAvatarPickerDelegateFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicAvatarCropViewModel>() { // from class: com.tencent.mobileqq.wink.magicAvatar.picker.AEMagicAvatarPickerDelegateFragment$magicCropVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicAvatarCropViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(AEMagicAvatarPickerDelegateFragment.this).get(MagicAvatarCropViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ropViewModel::class.java)");
                return (MagicAvatarCropViewModel) viewModel;
            }
        });
        this.magicCropVm = lazy;
    }

    private final ModifyAvatarConfig ph() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (ModifyAvatarConfig) arguments.getParcelable("avatar_config");
        }
        return null;
    }

    private final MagicAvatarCropViewModel qh() {
        return (MagicAvatarCropViewModel) this.magicCropVm.getValue();
    }

    private final void rh(MagicAvatarGenerateInfo img) {
        FragmentTransaction fragmentTransaction;
        FragmentManager supportFragmentManager;
        img.setOriginStyleName(this.style);
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            fragmentTransaction = supportFragmentManager.beginTransaction();
        } else {
            fragmentTransaction = null;
        }
        if (fragmentTransaction == null) {
            return;
        }
        fragmentTransaction.setCustomAnimations(R.anim.f155080vw, R.anim.f154634p6);
        Fragment fragment = this.hostFragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostFragment");
            fragment = null;
        }
        fragmentTransaction.add(fragment.getId(), MagicAvatarCropFragment.INSTANCE.a(getArguments(), img), "MagicAvatarCropFragment");
        fragmentTransaction.setTransition(4097);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.mobileqq.wink.magicAvatar.picker.a
    public boolean P5(int requestCode) {
        HashMap hashMapOf;
        String g16;
        w53.b.f("MagicAvatarPickerDelegateFragment", "onCaptureSelect");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
            return true;
        }
        f z26 = qh().z2();
        if (!(z26 instanceof f.b) && !(z26 instanceof f.e)) {
            Bundle bundle = new Bundle();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("target", "0"));
            bundle.putSerializable("key_attrs", hashMapOf);
            bundle.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_MAGIC_AVATAR);
            bundle.putInt("ability_flag", 2);
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            WinkContext.Companion companion = WinkContext.INSTANCE;
            WinkContext e16 = companion.e();
            if (e16 == null || (g16 = e16.getTraceId()) == null) {
                g16 = companion.g();
            }
            bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, g16);
            bundle.putString("app_key", "00000QG6YX3X0LZH");
            bundle.putBoolean("camera_direct_return_result", true);
            bundle.putString("camera_fragment_tag", "MAGIC_AVATAR");
            bundle.putInt("fragment_request_business_code", 102);
            bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 102);
            bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
            bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
            bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
            bundle.putString(AECameraConstants.MAGIC_AVATAR_STYLE, this.style);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                g.f322861a.d(activity, bundle);
            }
            return true;
        }
        w53.b.c("MagicAvatarPickerDelegateFragment", "count out");
        QQToast.makeText(BaseApplication.getContext(), "\u4eca\u65e5\u6b21\u6570\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u660e\u65e5\u518d\u8bd5", 0).show();
        return true;
    }

    @Override // com.tencent.mobileqq.wink.magicAvatar.picker.a
    public void Ze(@NotNull LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        w53.b.f("MagicAvatarPickerDelegateFragment", "onMediaSelect");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
            return;
        }
        f z26 = qh().z2();
        if (!(z26 instanceof f.b) && !(z26 instanceof f.e)) {
            MagicAvatarGenerateInfo magicAvatarGenerateInfo = new MagicAvatarGenerateInfo();
            String str = mediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
            magicAvatarGenerateInfo.setOriginFilePath(str);
            rh(magicAvatarGenerateInfo);
            return;
        }
        w53.b.c("MagicAvatarPickerDelegateFragment", "count out");
        QQToast.makeText(BaseApplication.getContext(), "\u4eca\u65e5\u6b21\u6570\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u660e\u65e5\u518d\u8bd5", 0).show();
    }

    @Override // com.tencent.mobileqq.wink.magicAvatar.picker.a
    public void hg(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.hostFragment = fragment;
    }

    @Override // com.tencent.mobileqq.wink.magicAvatar.picker.a
    public boolean onBackEvent() {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager2 = activity.getSupportFragmentManager()) != null) {
            fragment = supportFragmentManager2.findFragmentByTag("MagicAvatarCropFragment");
        } else {
            fragment = null;
        }
        if (fragment != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
                supportFragmentManager.popBackStack();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        String str;
        Bundle bundle;
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        MagicAvatarCropViewModel qh5 = qh();
        ModifyAvatarConfig ph5 = ph();
        if (ph5 != null) {
            i3 = ph5.getAvatarSource();
        } else {
            i3 = 0;
        }
        qh5.K2(i3);
        Bundle arguments = getArguments();
        if (arguments != null && (bundle = arguments.getBundle(AECameraConstants.AVATAR_EXTRA_DATA)) != null) {
            str = bundle.getString(AECameraConstants.MAGIC_AVATAR_STYLE);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.style = str;
        w53.b.f("MagicAvatarPickerDelegateFragment", "onMediaSelect style = " + str);
    }

    @Override // com.tencent.mobileqq.wink.magicAvatar.picker.a
    public void onReceiveActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        MagicAvatarGenerateInfo magicAvatarGenerateInfo;
        Bundle extras;
        if (requestCode == 102) {
            w53.b.f("MagicAvatarPickerDelegateFragment", "onReceiveActivityResult");
            if (data != null && (extras = data.getExtras()) != null) {
                magicAvatarGenerateInfo = (MagicAvatarGenerateInfo) extras.getParcelable(AECameraConstants.MAGIC_AVATAR_CAPTURE_INFO);
            } else {
                magicAvatarGenerateInfo = null;
            }
            w53.b.f("MagicAvatarPickerDelegateFragment", "onReceiveActivityResult info= " + magicAvatarGenerateInfo);
            if (magicAvatarGenerateInfo != null) {
                rh(magicAvatarGenerateInfo);
            }
        }
    }
}
