package com.tencent.robot.action.api.impl;

import androidx.fragment.app.FragmentActivity;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002JP\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/action/api/impl/RobotCommandActionUtils;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "", "errorMsg", "", "callback", "b", "source", "a", "", "[Ljava/lang/String;", "photoPanelPermissionList", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotCommandActionUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RobotCommandActionUtils f365910a = new RobotCommandActionUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] photoPanelPermissionList = {QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/action/api/impl/RobotCommandActionUtils$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f365912a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f365912a = function2;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f365912a.invoke(Boolean.TRUE, "");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            String str;
            Object firstOrNull;
            super.onDenied(permissions, results);
            Function2<Boolean, String, Unit> function2 = this.f365912a;
            Boolean bool = Boolean.FALSE;
            if (permissions != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) permissions);
                str = (String) firstOrNull;
            } else {
                str = null;
            }
            function2.invoke(bool, "permissionDenied: " + str);
        }
    }

    RobotCommandActionUtils() {
    }

    private final void b(com.tencent.aio.api.runtime.a aioContext, Function2<? super Boolean, ? super String, Unit> callback) {
        FragmentActivity activity = aioContext.c().getActivity();
        if (activity == null) {
            callback.invoke(Boolean.FALSE, "fragment is detached");
            return;
        }
        String[] strArr = photoPanelPermissionList;
        int length = strArr.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            boolean z17 = true;
            if (i3 < length) {
                if (activity.checkSelfPermission(strArr[i3]) == 0) {
                    z17 = false;
                }
                if (z17) {
                    break;
                } else {
                    i3++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            callback.invoke(Boolean.TRUE, "");
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM));
        if (qQPermission != null) {
            qQPermission.requestPermissions(photoPanelPermissionList, 2, new a(callback));
        }
    }

    public final void a(@NotNull final String source, @NotNull final com.tencent.aio.api.runtime.a aioContext, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        b(aioContext, new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.action.api.impl.RobotCommandActionUtils$checkPermissionAndInvokePhotoPanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String errorMsg) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                if (z16) {
                    com.tencent.aio.api.runtime.a.this.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent(source, 1003, false, 0, 12, null));
                    Function2<Boolean, String, Unit> function2 = callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, "");
                        return;
                    }
                    return;
                }
                Function2<Boolean, String, Unit> function22 = callback;
                if (function22 != null) {
                    function22.invoke(Boolean.FALSE, errorMsg);
                }
            }
        });
    }
}
