package com.tencent.mobileqq.qwallet.hb.aigc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerViewModel;
import com.tencent.mobileqq.qwallet.hb.aigc.data.OutputImageInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.qphone.base.util.QLog;
import e93.i;
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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "Fi", "Hi", "Lcom/tencent/mobileqq/qwallet/hb/aigc/data/OutputImageInfo;", "selectImageInfo", "Ki", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Ze", "", "requestCode", "", "P5", "Landroid/content/Context;", "context", "onAttach", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel;", "a0", "Lkotlin/Lazy;", "Gi", "()Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel;", "viewModel", "<init>", "()V", "b0", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public QWalletMediaPickerFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletMediaPickerViewModel>() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletMediaPickerViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(QWalletMediaPickerFragment.this).get(QWalletMediaPickerViewModel.class);
                QWalletMediaPickerViewModel qWalletMediaPickerViewModel = (QWalletMediaPickerViewModel) viewModel;
                QWalletMediaPickerFragment.this.getLifecycle().addObserver(qWalletMediaPickerViewModel);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026addObserver(vm)\n        }");
                return qWalletMediaPickerViewModel;
            }
        });
        this.viewModel = lazy;
    }

    private final void Fi(final LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        if (!l.d()) {
            l.f();
            c.f277218a.d(0L, getString(R.string.f2176461k));
        } else {
            final Context context = getContext();
            if (context != null) {
                d93.c.INSTANCE.b(context, i.x(mediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerFragment$checkAndUpload$1$1
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
                        String str;
                        QWalletMediaPickerViewModel Gi;
                        Intent intent;
                        FragmentActivity activity = QWalletMediaPickerFragment.this.getActivity();
                        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("request_biz_id")) == null) {
                            str = "";
                        }
                        Gi = QWalletMediaPickerFragment.this.Gi();
                        Context it = context;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        String str2 = mediaInfo.path;
                        Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
                        Gi.Z1(it, str2, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QWalletMediaPickerViewModel Gi() {
        return (QWalletMediaPickerViewModel) this.viewModel.getValue();
    }

    private final void Hi() {
        LiveData<QWalletMediaPickerViewModel.b> T1 = Gi().T1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<QWalletMediaPickerViewModel.b, Unit> function1 = new Function1<QWalletMediaPickerViewModel.b, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerFragment$observerImageProcessResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QWalletMediaPickerViewModel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QWalletMediaPickerViewModel.b bVar) {
                if (bVar instanceof QWalletMediaPickerViewModel.b.DetectSuccess) {
                    QWalletMediaPickerFragment.this.Ki(((QWalletMediaPickerViewModel.b.DetectSuccess) bVar).getImageInfo());
                } else if (bVar instanceof QWalletMediaPickerViewModel.b.DetectFail) {
                    c.f277218a.f(((QWalletMediaPickerViewModel.b.DetectFail) bVar).getThrowable());
                } else {
                    c.f277218a.d(0L, "");
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletMediaPickerFragment.Ii(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(QWalletMediaPickerFragment this$0, String requestKey, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.d("QWalletMediaPickerFragment", 1, "onActivityResult: " + requestKey + " " + bundle);
        this$0.Fi((LocalMediaInfo) bundle.getParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ki(OutputImageInfo selectImageInfo) {
        Intent intent = new Intent();
        intent.putExtra("result_selected_image_info", selectImageInfo);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public boolean P5(int requestCode) {
        FragmentActivity fragmentActivity;
        Bundle bundle = new Bundle();
        bundle.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA);
        bundle.putInt("ability_flag", 2);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE_REDPACKET");
        bundle.putBoolean("camera_direct_return_result", true);
        bundle.putInt("fragment_request_business_code", 1);
        try {
            getParentFragmentManager().setFragmentResultListener("1", this, new FragmentResultListener() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.d
                @Override // androidx.fragment.app.FragmentResultListener
                public final void onFragmentResult(String str, Bundle bundle2) {
                    QWalletMediaPickerFragment.Ji(QWalletMediaPickerFragment.this, str, bundle2);
                }
            });
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAECameraFragmentForAIGCHB(fragmentActivity, bundle);
            }
        } catch (Exception e16) {
            QLog.w("QWalletMediaPickerFragment", 1, "onCaptureSelect error", e16);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        Fi(mediaInfo);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        l.f();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Hi();
    }
}
