package com.tencent.mobileqq.wink.magicAvatar.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import d93.c;
import e93.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarSingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Landroid/view/View;", "view", "", "Ei", "Landroidx/fragment/app/Fragment;", "Di", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/a;", "Ci", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Ze", "Landroid/content/Context;", "context", "onAttach", "", "requestCode", "", "P5", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "a0", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/a;", "delegate", "<init>", "()V", "b0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarSingleMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a delegate;

    /* JADX WARN: Multi-variable type inference failed */
    private final a Ci() {
        a aVar;
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        Fragment Di = Di();
        if (Di == 0) {
            return null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add(Di, getTag())) != null) {
            add.commitAllowingStateLoss();
        }
        if (Di instanceof a) {
            aVar = (a) Di;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        aVar.hg(this);
        return aVar;
    }

    private final Fragment Di() {
        String str;
        Parcelable parcelable;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra(QQWinkConstants.KEY_PICKER_FRAGMENT_CLASS);
        } else {
            str = null;
        }
        try {
            Object newInstance = Class.forName(str).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) newInstance;
            fragment.setArguments(getArguments());
            Bundle arguments = fragment.getArguments();
            if (arguments != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    parcelable = arguments2.getParcelable(AECameraConstants.FRAGMENT_EXTRA_DATA);
                } else {
                    parcelable = null;
                }
                arguments.putParcelable(AECameraConstants.AVATAR_EXTRA_DATA, parcelable);
            }
            return fragment;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private final void Ei(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_xsj_choose_media_new_page");
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(WinkDTParamBuilder.buildElementParams(), c16));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public boolean P5(int requestCode) {
        w53.b.a("MagicAvatarSingleMediaPickerFragment", "onCaptureSelect");
        a aVar = this.delegate;
        if (aVar != null) {
            return aVar.P5(requestCode);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.MagicAvatar;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable final LocalMediaInfo mediaInfo) {
        w53.b.a("MagicAvatarSingleMediaPickerFragment", "onMediaSelect");
        if (mediaInfo == null) {
            return;
        }
        int x16 = i.x(mediaInfo);
        Context context = getContext();
        if (context != null) {
            c.INSTANCE.b(context, x16, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarSingleMediaPickerFragment$onMediaSelect$1$1
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
                    a aVar;
                    aVar = MagicAvatarSingleMediaPickerFragment.this.delegate;
                    if (aVar != null) {
                        aVar.Ze(mediaInfo);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new QCircleMediaPickerTopDetectFacePart(QQTheme.isNowThemeIsNight(), true));
        return assembleParts;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        w53.b.a("MagicAvatarSingleMediaPickerFragment", "onActivityResult requestCode = " + requestCode);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.onReceiveActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
            Wh().h2(true);
            ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_xsj_fbq_aiface_cluster_v2");
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Boolean bool;
        a aVar = this.delegate;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.onBackEvent());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        l.f();
        w53.b.f("MagicAvatarSingleMediaPickerFragment", "activity = " + getActivity());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.delegate = Ci();
        Ei(view);
    }
}
