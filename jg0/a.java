package jg0;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.permission.api.IPermission;
import com.tencent.ecommerce.base.permission.api.PermissionListener;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ljg0/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "b", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "fragment", "", "permissions", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "permissionListener", "", "d", "(Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;[Ljava/lang/String;Lcom/tencent/ecommerce/base/permission/api/PermissionListener;)V", "c", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/tencent/ecommerce/base/permission/api/PermissionListener;)V", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", "a", "()Lcom/tencent/ecommerce/base/permission/api/IPermission;", "permissionProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f409882a = new a();

    a() {
    }

    private final IPermission a() {
        return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPermission();
    }

    public final boolean b(Activity activity, String permission) {
        Object valueOf;
        IPermission a16 = a();
        if (a16 != null) {
            valueOf = Boolean.valueOf(a16.hasPermission(activity, permission));
        } else {
            valueOf = Integer.valueOf(ContextCompat.checkSelfPermission(activity, permission));
        }
        return Intrinsics.areEqual(valueOf, (Object) 0);
    }

    public final void c(Activity activity, String[] permissions, PermissionListener permissionListener) {
        IPermission a16 = a();
        if (a16 != null) {
            a16.requestPermissions(activity, permissions, permissionListener);
        }
    }

    public final void d(ECBaseFragment fragment, String[] permissions, PermissionListener permissionListener) {
        IPermission a16 = a();
        if (a16 != null) {
            a16.requestPermissions(fragment.requireActivity(), permissions, permissionListener);
        } else {
            fragment.Gh(permissions, permissionListener);
        }
    }
}
