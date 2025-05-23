package com.tencent.mobileqq.zplan.lua.plugins;

import android.app.Activity;
import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J@\u0010\u000b\u001a\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002JH\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanStorageLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "msg", "", "callback", "a", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "handleSaveToAlbum", "Landroid/content/Context;", "context", "path", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanStorageLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final ZPlanStorageLuaPlugin f333825d = new ZPlanStorageLuaPlugin();

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J(\u0010\n\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/lua/plugins/ZPlanStorageLuaPlugin$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "onDeniedWithoutShowDlg", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f333826a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f333826a = function2;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f333826a.invoke(Boolean.TRUE, "onAllGranted");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            this.f333826a.invoke(Boolean.FALSE, "onDenied");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> permissions, List<Integer> results) {
            super.onDeniedWithoutShowDlg(permissions, results);
            this.f333826a.invoke(Boolean.FALSE, "onDeniedWithoutShowDlg");
        }
    }

    static {
        QLog.w("ZPlanStorageLuaPlugin", 1, "ZPlanStorageLuaPlugin init.");
    }

    ZPlanStorageLuaPlugin() {
    }

    private final void a(Function2<? super Boolean, ? super String, Unit> callback) {
        QQPermission qQPermission;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            callback.invoke(Boolean.FALSE, "activity is null");
            return;
        }
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.ZPLAN_SHARE, QQPermissionConstants.Business.SCENE.ZPLAN_SHARE);
        if (topActivity instanceof ZootopiaUEActivity) {
            qQPermission = ((ZootopiaUEActivity) topActivity).getPermissionHelper().a(topActivity, businessConfig);
        } else {
            QLog.e("ZPlanStorageLuaPlugin", 1, "activity not is ZootopiaUEActivity");
            qQPermission = QQPermissionFactory.getQQPermission(topActivity, businessConfig);
        }
        if (qQPermission == null) {
            callback.invoke(Boolean.FALSE, "qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            callback.invoke(Boolean.TRUE, "has permission");
        } else {
            b(qQPermission, callback);
        }
    }

    private final void b(QQPermission qqPermission, Function2<? super Boolean, ? super String, Unit> callback) {
        qqPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(callback));
    }

    public final void c(final Context context, final String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        a(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZPlanStorageLuaPlugin$saveToAlbum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (z16) {
                    ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(context, path);
                    return;
                }
                QLog.w("ZPlanStorageLuaPlugin", 1, "handleSaveToAlbum not permission. " + msg2);
                v.f373305a.c(R.string.xhk, QCircleDaTongConstant.ElementParamValue.PERMISSION);
            }
        });
    }

    @LuaEvent("L2N_Save_To_Album")
    public final String handleSaveToAlbum(LuaArgument arg) {
        int optInt;
        String contentPath;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.d("ZPlanStorageLuaPlugin", 1, "handleSaveToAlbum called. " + arg.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(arg.getF440574c());
            optInt = jSONObject.optInt("ContentType", -1);
            contentPath = jSONObject.optString("Url");
        } catch (JSONException e16) {
            QLog.d("ZPlanStorageLuaPlugin", 1, "handleSaveToAlbum err.", e16);
            v.f373305a.c(R.string.xhk, ark.ARKMETADATA_JSON);
        }
        if (optInt == -1) {
            QLog.d("ZPlanStorageLuaPlugin", 1, "handleSaveToAlbum contentType error.");
            v.f373305a.c(R.string.xhk, "contentType");
            return arg.ok();
        }
        if (!(contentPath == null || contentPath.length() == 0)) {
            Intrinsics.checkNotNullExpressionValue(contentPath, "contentPath");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(contentPath, "/", false, 2, null);
            if (startsWith$default) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                c(context, contentPath);
                return arg.ok();
            }
        }
        QLog.d("ZPlanStorageLuaPlugin", 1, "handleSaveToAlbum contentPath error.");
        v.f373305a.c(R.string.xhk, "contentPath");
        return arg.ok();
    }
}
