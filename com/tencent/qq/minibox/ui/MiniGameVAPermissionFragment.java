package com.tencent.qq.minibox.ui;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J/\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qq/minibox/ui/MiniGameVAPermissionFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "<init>", "()V", "D", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniGameVAPermissionFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQPermission permission;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qq/minibox/ui/MiniGameVAPermissionFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f344643a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniGameVAPermissionFragment f344644b;

        b(ResultReceiver resultReceiver, MiniGameVAPermissionFragment miniGameVAPermissionFragment) {
            this.f344643a = resultReceiver;
            this.f344644b = miniGameVAPermissionFragment;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.i("MiniGameVAPermissionFragment", 1, "requestPermissions onAllGranted");
            ResultReceiver resultReceiver = this.f344643a;
            if (resultReceiver != null) {
                resultReceiver.send(1, null);
            }
            FragmentActivity activity = this.f344644b.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            QLog.i("MiniGameVAPermissionFragment", 1, "requestPermissions onDenied");
            ResultReceiver resultReceiver = this.f344643a;
            if (resultReceiver != null) {
                resultReceiver.send(-1, null);
            }
            FragmentActivity activity = this.f344644b.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r3 != false) goto L15;
     */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        boolean z17;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.i("MiniGameVAPermissionFragment", 1, "requestPermissions args invalid");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.permission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE, QQPermissionConstants.Business.SCENE.MINIBOX_APP_WRITE_EXTERNAL));
        ResultReceiver resultReceiver = (ResultReceiver) arguments.getParcelable("key_result_receiver");
        String[] stringArray = arguments.getStringArray("key_permissions_array");
        if (stringArray != null) {
            z16 = false;
            if (stringArray.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = true;
        Unit unit = null;
        if (z16) {
            QLog.i("MiniGameVAPermissionFragment", 1, "requestPermissions permissions invalid");
            if (resultReceiver != null) {
                resultReceiver.send(-1, null);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        QQPermission qQPermission = this.permission;
        if (qQPermission != null) {
            qQPermission.requestPermissions(stringArray, 2, new b(resultReceiver, this));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.i("MiniGameVAPermissionFragment", 1, "requestPermissions permission invalid");
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        QQPermission qQPermission = this.permission;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
        }
    }
}
