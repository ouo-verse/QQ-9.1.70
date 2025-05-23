package com.tencent.mobileqq.guild.media;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.media.MediaChannelPermissionFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016RM\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/MediaChannelPermissionFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFinish", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "permissionIsNewGet", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()Lkotlin/jvm/functions/Function2;", "callback", "D", "Z", "isFirstShow", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelPermissionFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicInteger F = new AtomicInteger(0);

    @NotNull
    private static final HashMap<Integer, Function2<Boolean, Boolean, Unit>> G = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy callback;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFirstShow;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJR\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000428\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0095\u0001\u0010\u001b\u001a\u0082\u0001\u0012\u0004\u0012\u00020\u0019\u00126\u00124\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00060\u0018j@\u0012\u0004\u0012\u00020\u0019\u00126\u00124\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/MediaChannelPermissionFragment$a;", "", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", DownloadInfo.spKey_Config, "", "bizPermissionId", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "permissionIsNewGet", "", "result", "a", "ARG_BIZ_ID", "Ljava/lang/String;", "ARG_BIZ_SCENE", "ARG_ID", "BIZ_PERMISSION_ID", "TAG", "Ljava/util/concurrent/atomic/AtomicInteger;", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "idCallbackMap", "Ljava/util/HashMap;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.MediaChannelPermissionFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull BusinessConfig config, @NotNull String bizPermissionId, @NotNull Function2<? super Boolean, ? super Boolean, Unit> result) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(bizPermissionId, "bizPermissionId");
            Intrinsics.checkNotNullParameter(result, "result");
            BaseApplication context = BaseApplication.getContext();
            Intent intent = new Intent();
            intent.putExtra("arg_biz_id", config.getBusinessId());
            intent.putExtra("arg_biz_scene", config.getBusinessScene());
            intent.putExtra("biz_permission_id", bizPermissionId);
            intent.addFlags(268435456);
            int addAndGet = MediaChannelPermissionFragment.F.addAndGet(1);
            intent.putExtra("arg_id", addAndGet);
            MediaChannelPermissionFragment.G.put(Integer.valueOf(addAndGet), result);
            QPublicTransFragmentActivity.start(context, intent, MediaChannelPermissionFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\u000b\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J(\u0010\f\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/media/MediaChannelPermissionFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "onDeniedWithoutShowDlg", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MediaChannelPermissionFragment this$0, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
            Function2 sh5 = this$0.sh();
            Boolean bool = Boolean.FALSE;
            sh5.invoke(bool, bool);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.i("MediaChannelPermissionFragment", 1, "onAllGranted.");
            FragmentActivity activity = MediaChannelPermissionFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            Function2 sh5 = MediaChannelPermissionFragment.this.sh();
            Boolean bool = Boolean.TRUE;
            sh5.invoke(bool, bool);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            QLog.i("MediaChannelPermissionFragment", 1, "onDenied.");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            QLog.i("MediaChannelPermissionFragment", 1, "onDeniedWithoutShowDlg.");
            FragmentActivity activity = MediaChannelPermissionFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            Function2 sh5 = MediaChannelPermissionFragment.this.sh();
            Boolean bool = Boolean.FALSE;
            sh5.invoke(bool, bool);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            QLog.i("MediaChannelPermissionFragment", 1, "onDialogShow.");
            if (dialog != null) {
                final MediaChannelPermissionFragment mediaChannelPermissionFragment = MediaChannelPermissionFragment.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.media.ab
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MediaChannelPermissionFragment.b.b(MediaChannelPermissionFragment.this, dialogInterface);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(@Nullable String uncertainPermission) {
            QLog.i("MediaChannelPermissionFragment", 1, "onUncertain.");
            FragmentActivity activity = MediaChannelPermissionFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            MediaChannelPermissionFragment.this.sh().invoke(Boolean.TRUE, Boolean.FALSE);
        }
    }

    public MediaChannelPermissionFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function2<? super Boolean, ? super Boolean, ? extends Unit>>() { // from class: com.tencent.mobileqq.guild.media.MediaChannelPermissionFragment$callback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Function2<? super Boolean, ? super Boolean, ? extends Unit> invoke() {
                Object obj = MediaChannelPermissionFragment.G.get(Integer.valueOf(MediaChannelPermissionFragment.this.requireArguments().getInt("arg_id")));
                Intrinsics.checkNotNull(obj);
                return (Function2) obj;
            }
        });
        this.callback = lazy;
        this.isFirstShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<Boolean, Boolean, Unit> sh() {
        return (Function2) this.callback.getValue();
    }

    private final void th() {
        QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(requireArguments().getString("arg_biz_id"), requireArguments().getString("arg_biz_scene"))).requestPermissions(new String[]{requireArguments().getString("biz_permission_id")}, 2, new b());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.i("MediaChannelPermissionFragment", 1, "onBackEvent.");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentActivity activity;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        boolean z16 = false;
        if (arguments != null && arguments.containsKey("arg_biz_id")) {
            z16 = true;
        }
        if (!z16 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        G.remove(Integer.valueOf(requireArguments().getInt("arg_id")));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isFirstShow) {
            th();
        }
        this.isFirstShow = false;
    }
}
