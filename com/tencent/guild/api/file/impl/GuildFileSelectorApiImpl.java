package com.tencent.guild.api.file.impl;

import android.app.Activity;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.file.IGuildFileSelectorApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0002J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/api/file/impl/GuildFileSelectorApiImpl;", "Lcom/tencent/guild/api/file/IGuildFileSelectorApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "openFileSelectorInner", "Lkotlin/Function1;", "", "callback", "applySdcardPermission", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "applySdcardPermissionInner", "openFileSelector", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildFileSelectorApiImpl implements IGuildFileSelectorApi {
    public static final int PERMISSION_DENIED = 1;
    public static final int PERMISSION_GRANTED = 0;

    @NotNull
    public static final String TAG = "GuildFileSelectorApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/api/file/impl/GuildFileSelectorApiImpl$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f112512a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Integer, Unit> function1) {
            this.f112512a = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.i(GuildFileSelectorApiImpl.TAG, 4, "onAllGranted");
            this.f112512a.invoke(0);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            QLog.i(GuildFileSelectorApiImpl.TAG, 4, "onAllGranted");
            this.f112512a.invoke(1);
        }
    }

    private final void applySdcardPermission(Activity activity, Function1<? super Integer, Unit> callback) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_AIO_FILE_PANEL));
        if (qQPermission != null) {
            if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                applySdcardPermissionInner(qQPermission, callback);
            } else {
                callback.invoke(0);
            }
        }
    }

    private final void applySdcardPermissionInner(QQPermission permission, Function1<? super Integer, Unit> callback) {
        permission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openFileSelectorInner(Activity activity, AIOParam aioParam) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByAIO(activity, 10014, aioParam.r().c().j(), aioParam.r().c().j(), aioParam.r().c().f(), -1);
    }

    @Override // com.tencent.guild.api.file.IGuildFileSelectorApi
    public void openFileSelector(@NotNull final Activity activity, @NotNull final AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        QLog.i(TAG, 4, "openFileSelector param=" + aioParam.r().c());
        applySdcardPermission(activity, new Function1<Integer, Unit>() { // from class: com.tencent.guild.api.file.impl.GuildFileSelectorApiImpl$openFileSelector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i(GuildFileSelectorApiImpl.TAG, 4, "permission result=" + i3);
                if (i3 == 0) {
                    GuildFileSelectorApiImpl.this.openFileSelectorInner(activity, aioParam);
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 1, "\u672a\u6388\u6743", 0).show();
                }
            }
        });
    }
}
