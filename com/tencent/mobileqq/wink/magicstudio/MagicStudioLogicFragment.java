package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\u0004J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioLogicFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "data", "", "sh", "bundle", "wh", "", "returnAction", "vh", "secondAction", "xh", Constants.FILE_INSTANCE_STATE, "onCreate", "th", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "Lcom/tencent/mobileqq/wink/magicstudio/p;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/wink/magicstudio/p;", "viewModel", "<init>", "()V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioLogicFragment extends ReportAndroidXFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioLogicFragment$a;", "", "Landroid/content/Context;", "context", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/os/Bundle;", "extraBundle", "", "fromStr", "", "b", "c", "d", "", "MAGIC_STUDIO_FRAGMENT_BACK_STACK_LIST", "Ljava/util/List;", "a", "()Ljava/util/List;", "AIGC_LOGIC", "Ljava/lang/String;", "IMGCREATE_TAG", "IMGSELECT_TAG", "MAGIC_STUDIO_CAPTURE", "MAGIC_STUDIO_SETTING", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(Context context, Fragment fragment, Bundle extraBundle, String fromStr) {
            com.tencent.mobileqq.wink.picker.f fVar = com.tencent.mobileqq.wink.picker.f.f324854a;
            String traceId = WinkContext.INSTANCE.d().getTraceId();
            Config.Companion companion = Config.INSTANCE;
            Config.a aVar = new Config.a();
            aVar.i(TabType.ONLY_IMAGE);
            aVar.f(true);
            aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
            aVar.e(101);
            aVar.g(fromStr);
            Unit unit = Unit.INSTANCE;
            fVar.f(context, fragment, 101, traceId, aVar.a(), extraBundle);
        }

        @NotNull
        public final List<String> a() {
            return MagicStudioLogicFragment.E;
        }

        public final void c(@NotNull Context context, @NotNull Fragment fragment, @NotNull Bundle extraBundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(extraBundle, "extraBundle");
            w53.b.f("MagicStudioLogicFragment", "jumpToMediaPickerFromMainPage");
            extraBundle.putString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_MAIN);
            b(context, fragment, extraBundle, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_MAIN);
        }

        public final void d(@NotNull Context context, @NotNull Fragment fragment, @NotNull Bundle extraBundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(extraBundle, "extraBundle");
            w53.b.f("MagicStudioLogicFragment", "jumpToMediaPickerFromSecondPage");
            extraBundle.putString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_SECOND);
            b(context, fragment, extraBundle, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_SECOND);
        }

        Companion() {
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"MAGIC_STUDIO_CAPTURE", "MAGIC_STUDIO_SETTING"});
        E = listOf;
    }

    public MagicStudioLogicFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicStudioLogicFragment.this.requireActivity()).get(p.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026umpViewModel::class.java)");
                return (p) viewModel;
            }
        });
        this.viewModel = lazy;
    }

    private final p rh() {
        return (p) this.viewModel.getValue();
    }

    private final void sh(Bundle data) {
        String str;
        String str2;
        Bundle bundle;
        boolean z16;
        if (data != null) {
            str = data.getString(AECameraConstants.FRAGMENT_RETURN_ACTION);
        } else {
            str = null;
        }
        if (data != null) {
            str2 = data.getString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION);
        } else {
            str2 = null;
        }
        if (data != null) {
            bundle = data.getBundle(AECameraConstants.FRAGMENT_CAMERA_GOTO_MULTI_SELECT_INFO);
        } else {
            bundle = null;
        }
        w53.b.f("MagicStudioLogicFragment", "handleResult action = " + str + ", secAction = " + str2 + " gotoMultiSelectBundle = " + bundle);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER)) {
                if (bundle != null) {
                    wh(bundle);
                    return;
                }
                if (Intrinsics.areEqual(str2, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_MAIN)) {
                    rh().M1(null);
                    vh(data, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER);
                    return;
                } else {
                    if (Intrinsics.areEqual(str2, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_SECOND)) {
                        rh().M1(data);
                        return;
                    }
                    return;
                }
            }
            if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA)) {
                rh().M1(null);
                if (str2 == null) {
                    str2 = AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_MAIN;
                }
                xh(data, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(MagicStudioLogicFragment this$0, String str, Bundle result) {
        Fragment fragment;
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentManager supportFragmentManager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION);
        Bundle bundle = result.getBundle(AECameraConstants.FRAGMENT_CAMERA_GOTO_MULTI_SELECT_INFO);
        w53.b.f("MagicStudioLogicFragment", "FragmentResultListener secAction = " + string + " gotoMultiSelectBundle = " + bundle);
        if (bundle != null) {
            this$0.wh(bundle);
            return;
        }
        if (Intrinsics.areEqual(string, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_MAIN)) {
            this$0.vh(result, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA);
            return;
        }
        if (Intrinsics.areEqual(string, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AIGC_SECOND)) {
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null && (supportFragmentManager2 = activity2.getSupportFragmentManager()) != null) {
                fragment = supportFragmentManager2.findFragmentByTag("MAGIC_STUDIO_CAPTURE");
            } else {
                fragment = null;
            }
            if (fragment != null && (activity = this$0.getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(fragment)) != null) {
                remove.commitAllowingStateLoss();
            }
            this$0.rh().M1(result);
        }
    }

    private final void vh(Bundle data, String returnAction) {
        data.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, returnAction);
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCImgCreateFragment(getActivity(), data);
    }

    private final void wh(Bundle bundle) {
        if (com.tencent.mobileqq.wink.editor.util.h.f322638a.c()) {
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchMagicStudioResultFragment(requireActivity(), bundle);
        } else {
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCMultiSelectFragment(requireActivity(), bundle);
        }
    }

    private final void xh(Bundle data, String secondAction) {
        FragmentActivity fragmentActivity;
        data.putInt("ability_flag", 2);
        data.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        data.putString("app_key", "00000QG6YX3X0LZH");
        data.putBoolean("camera_direct_return_result", true);
        data.putString("camera_fragment_tag", "MAGIC_STUDIO_CAPTURE");
        data.putString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION, secondAction);
        data.putBoolean(QQWinkConstants.WINK_CAPTURE_FRAGMENT_IGNORE_BOTTOM_HEIGHT, true);
        data.putInt("fragment_request_business_code", 101);
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAECameraFragmentForMagicStudio(fragmentActivity, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle bundle;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (data != null) {
                bundle = data.getExtras();
            } else {
                bundle = null;
            }
            sh(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        th();
    }

    public final void th() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.setFragmentResultListener("101", this, new FragmentResultListener() { // from class: com.tencent.mobileqq.wink.magicstudio.q
                @Override // androidx.fragment.app.FragmentResultListener
                public final void onFragmentResult(String str, Bundle bundle) {
                    MagicStudioLogicFragment.uh(MagicStudioLogicFragment.this, str, bundle);
                }
            });
        }
    }
}
