package com.tencent.mobileqq.qqvideoedit.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.util.PermissionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/utils/m;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "listener", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "b", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f276257a = new m();

    m() {
    }

    public final boolean a(@Nullable Context context) {
        return PermissionUtil.isHasStoragePermission(context);
    }

    @NotNull
    public final QQPermission b(@NotNull Fragment fragment, @NotNull QQPermission.BasePermissionsListener listener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QQPermission qqPermission = QQPermissionFactory.getQQPermission(fragment, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO));
        qqPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, listener);
        Intrinsics.checkNotNullExpressionValue(qqPermission, "qqPermission");
        return qqPermission;
    }
}
