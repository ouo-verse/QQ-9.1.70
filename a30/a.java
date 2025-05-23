package a30;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* compiled from: P */
    /* renamed from: a30.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0008a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f25427a;

        C0008a(b bVar) {
            this.f25427a = bVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            a.b(this.f25427a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b bVar) {
        if (bVar == null) {
            QLog.e("QCircleDebugPermissionUtils", 1, "[notifyHandlerAllowDump] listener should not be null.");
        } else {
            bVar.a();
        }
    }

    public static void c(Context context, b bVar) {
        if (!(context instanceof Activity)) {
            QLog.e("QCircleDebugPermissionUtils", 1, "[requestSystemDumpPermissions] context not is activity.");
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.QCIRCLE_MIX_FEED));
        if (qQPermission == null) {
            QLog.e("QCircleDebugPermissionUtils", 1, "[requestSystemDumpPermissions] qq permission should not be null.");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            b(bVar);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}, 2, new C0008a(bVar));
        }
    }
}
