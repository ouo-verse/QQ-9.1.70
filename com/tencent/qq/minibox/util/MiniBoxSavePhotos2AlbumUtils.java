package com.tencent.qq.minibox.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.minibox.proxy.HostNotifySimpleBooleanCallback;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.ui.MiniGameVAPermissionFragment;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qq/minibox/util/MiniBoxSavePhotos2AlbumUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "localFilePath", "", "isLandScape", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "callBack", "", "a", "<init>", "()V", "MiniBoxSavePhotos2AlbumQQPermissionsResult", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxSavePhotos2AlbumUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MiniBoxSavePhotos2AlbumUtils f344752a = new MiniBoxSavePhotos2AlbumUtils();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00140\u00140\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qq/minibox/util/MiniBoxSavePhotos2AlbumUtils$MiniBoxSavePhotos2AlbumQQPermissionsResult;", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "", "d", "Ljava/lang/String;", "targetFileName", "e", "localFilePath", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Lmqq/util/WeakReference;", "contextRef", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", h.F, "callbackRef", "context", "callBack", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class MiniBoxSavePhotos2AlbumQQPermissionsResult extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String targetFileName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String localFilePath;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Context> contextRef;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<HostNotifySimpleBooleanCallback> callbackRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniBoxSavePhotos2AlbumQQPermissionsResult(@NotNull String targetFileName, @NotNull String localFilePath, @NotNull Context context, @NotNull HostNotifySimpleBooleanCallback callBack) {
            super(null);
            Intrinsics.checkNotNullParameter(targetFileName, "targetFileName");
            Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            this.targetFileName = targetFileName;
            this.localFilePath = localFilePath;
            this.contextRef = new WeakReference<>(context);
            this.callbackRef = new WeakReference<>(callBack);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            if (resultCode == 1) {
                boolean saveToSharedStorageCompat = ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).saveToSharedStorageCompat(this.contextRef.get(), new File(this.localFilePath), this.targetFileName);
                QLog.i("MiniBoxSavePhotos2AlbumUtils", 2, "saveImageToPhotosAlbum " + saveToSharedStorageCompat);
                HostNotifySimpleBooleanCallback hostNotifySimpleBooleanCallback = this.callbackRef.get();
                if (hostNotifySimpleBooleanCallback != null) {
                    hostNotifySimpleBooleanCallback.onFinish(saveToSharedStorageCompat);
                    return;
                }
                return;
            }
            QLog.w("MiniBoxSavePhotos2AlbumUtils", 1, "saveImageToPhotosAlbum onDenied");
            HostNotifySimpleBooleanCallback hostNotifySimpleBooleanCallback2 = this.callbackRef.get();
            if (hostNotifySimpleBooleanCallback2 != null) {
                hostNotifySimpleBooleanCallback2.onFinish(false);
            }
        }
    }

    MiniBoxSavePhotos2AlbumUtils() {
    }

    public final void a(@NotNull Activity activity, @NotNull String localFilePath, boolean isLandScape, @NotNull HostNotifySimpleBooleanCallback callBack) {
        Class cls;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE, QQPermissionConstants.Business.SCENE.MINIBOX_APP_WRITE_EXTERNAL));
        String saveImageTargetFileName = ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).getSaveImageTargetFileName(localFilePath);
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            if (isLandScape) {
                cls = QPublicTransFragmentActivityLandscape.class;
            } else {
                cls = QPublicTransFragmentActivity.class;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArray("key_permissions_array", new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
            bundle.putParcelable("key_result_receiver", new MiniBoxSavePhotos2AlbumQQPermissionsResult(saveImageTargetFileName, localFilePath, activity, callBack));
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName("com.tencent.mobileqq", cls.getName()));
            intent.putExtra("public_fragment_class", MiniGameVAPermissionFragment.class.getName());
            activity.startActivity(intent);
            return;
        }
        boolean saveToSharedStorageCompat = ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).saveToSharedStorageCompat(activity, new File(localFilePath), saveImageTargetFileName);
        QLog.i("MiniBoxSavePhotos2AlbumUtils", 2, "saveImageToPhotosAlbum " + saveToSharedStorageCompat);
        callBack.onFinish(saveToSharedStorageCompat);
    }
}
