package com.tencent.mobileqq.zootopia.lua;

import android.content.DialogInterface;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ba;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/api/d;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "handleRequestMicPermission", "handleHasFloatWindowPermission", "handleRequestFloatWindowPermission", "Lcom/tencent/mobileqq/zootopia/lua/e;", "e", "Lcom/tencent/mobileqq/zootopia/lua/e;", "getPermissionPluginHelper", "()Lcom/tencent/mobileqq/zootopia/lua/e;", "permissionPluginHelper", "<init>", "(Lcom/tencent/mobileqq/zootopia/lua/e;)V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ba extends com.tencent.mobileqq.z1.lua.b<com.tencent.mobileqq.zootopia.api.d> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e permissionPluginHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ba$b", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f328535d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<JSONObject> f328536e;

        b(AtomicBoolean atomicBoolean, Ref.ObjectRef<JSONObject> objectRef) {
            this.f328535d = atomicBoolean;
            this.f328536e = objectRef;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            if (this.f328535d.get()) {
                return;
            }
            this.f328536e.element.put("result", "dismiss");
            this.f328536e.element.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ba$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328537a;

        c(LuaArgument luaArgument) {
            this.f328537a = luaArgument;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("ZootopiaPermissionLuaPlugin", 1, "handleRequestMicPermission onAllGranted");
            LuaArgument luaArgument = this.f328537a;
            luaArgument.callback(luaArgument.ok("grant"));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.d("ZootopiaPermissionLuaPlugin", 1, "handleRequestMicPermission onDenied");
            LuaArgument luaArgument = this.f328537a;
            luaArgument.callback(luaArgument.fail("deny"));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog dialog, List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            QLog.d("ZootopiaPermissionLuaPlugin", 1, "handleRequestMicPermission onDialogShow");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ba$d", "Lmqq/app/QQPermissionCallback;", "", "i", "", "", "strings", "", "ints", "", "grant", "(I[Ljava/lang/String;[I)V", "deny", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements QQPermissionCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328538d;

        d(LuaArgument luaArgument) {
            this.f328538d = luaArgument;
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strings, int[] ints) {
            Intrinsics.checkNotNullParameter(strings, "strings");
            Intrinsics.checkNotNullParameter(ints, "ints");
            LuaArgument luaArgument = this.f328538d;
            luaArgument.callback(luaArgument.fail("deny"));
            QLog.e("ZootopiaPermissionLuaPlugin", 2, "handleRequestMicPermission, deny");
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strings, int[] ints) {
            Intrinsics.checkNotNullParameter(strings, "strings");
            Intrinsics.checkNotNullParameter(ints, "ints");
            LuaArgument luaArgument = this.f328538d;
            luaArgument.callback(luaArgument.ok("grant"));
            QLog.e("ZootopiaPermissionLuaPlugin", 2, "handleRequestMicPermission, grant");
        }
    }

    public ba(e permissionPluginHelper) {
        Intrinsics.checkNotNullParameter(permissionPluginHelper, "permissionPluginHelper");
        this.permissionPluginHelper = permissionPluginHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "$argument");
        JSONObject put = new JSONObject().put(QCircleDaTongConstant.ElementParamValue.PERMISSION, pk3.a.a(BaseApplication.context));
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(\"permission\", hasPermission)");
        argument.callback(argument.ok(put));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(AtomicBoolean clicked, Ref.ObjectRef resultJson, Ref.BooleanRef hasPermission, LuaArgument argument, ba this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clicked, "$clicked");
        Intrinsics.checkNotNullParameter(resultJson, "$resultJson");
        Intrinsics.checkNotNullParameter(hasPermission, "$hasPermission");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        clicked.set(true);
        ((JSONObject) resultJson.element).put("result", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
        ((JSONObject) resultJson.element).put(QCircleDaTongConstant.ElementParamValue.PERMISSION, hasPermission.element);
        argument.callback(argument.ok((JSONObject) resultJson.element));
        pk3.a.b(this$0.permissionPluginHelper.x1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(AtomicBoolean clicked, Ref.ObjectRef resultJson, Ref.BooleanRef hasPermission, LuaArgument argument, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clicked, "$clicked");
        Intrinsics.checkNotNullParameter(resultJson, "$resultJson");
        Intrinsics.checkNotNullParameter(hasPermission, "$hasPermission");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        clicked.set(true);
        ((JSONObject) resultJson.element).put("result", "cancel");
        ((JSONObject) resultJson.element).put(QCircleDaTongConstant.ElementParamValue.PERMISSION, hasPermission.element);
        argument.callback(argument.ok((JSONObject) resultJson.element));
    }

    private final boolean m(final LuaArgument argument) {
        final QQPermission a16 = this.permissionPluginHelper.getPermissionHelper().a(this.permissionPluginHelper.x1(), new BusinessConfig(QQPermissionConstants.Business.ID.ZPLAN_GAME, QQPermissionConstants.Business.SCENE.ZPLAN_GAME));
        if (a16 == null) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.aw
            @Override // java.lang.Runnable
            public final void run() {
                ba.n(QQPermission.this, argument);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QQPermission qqPermission, LuaArgument argument) {
        Intrinsics.checkNotNullParameter(qqPermission, "$qqPermission");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        if (qqPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            argument.callback(argument.ok("grant"));
        } else {
            qqPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new c(argument));
        }
    }

    private final void o(LuaArgument argument) {
        boolean z16 = MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0;
        QLog.e("ZootopiaPermissionLuaPlugin", 2, "handleRequestMicPermission, params:" + argument.getF440574c());
        if (z16) {
            QLog.e("ZootopiaPermissionLuaPlugin", 2, "handleRequestMicPermission, recorderPermission");
            argument.callback(argument.ok("grant"));
        } else {
            this.permissionPluginHelper.requestPermissions(new d(argument), 1, QQPermissionConstants.Permission.RECORD_AUDIO);
        }
    }

    @LuaEvent("L2N_HasFloatWindowPermission")
    public final String handleHasFloatWindowPermission(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.av
            @Override // java.lang.Runnable
            public final void run() {
                ba.i(LuaArgument.this);
            }
        });
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    @LuaEvent("L2N_RequestFloatWindowPermission")
    public final String handleRequestFloatWindowPermission(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new JSONObject(argument.getF440574c());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.ax
                @Override // java.lang.Runnable
                public final void run() {
                    ba.j(LuaArgument.this, this, objectRef);
                }
            });
            return null;
        } catch (Exception unused) {
            argument.callback(argument.fail("param error"));
            return null;
        }
    }

    @LuaEvent("L2N_RequestMicPermission")
    public final String handleRequestMicPermission(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (m(argument)) {
            return null;
        }
        o(argument);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.json.JSONObject, T] */
    public static final void j(final LuaArgument argument, final ba this$0, Ref.ObjectRef paramJson) {
        Intrinsics.checkNotNullParameter(argument, "$argument");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramJson, "$paramJson");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = pk3.a.a(BaseApplication.context);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? jSONObject = new JSONObject();
        objectRef.element = jSONObject;
        boolean z16 = booleanRef.element;
        if (z16) {
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, z16);
            ((JSONObject) objectRef.element).put("result", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            argument.callback(argument.ok((JSONObject) objectRef.element));
        } else {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            b bVar = new b(atomicBoolean, objectRef);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.permissionPluginHelper.x1(), 230, ((JSONObject) paramJson.element).optString("title"), ((JSONObject) paramJson.element).optString("message"), ((JSONObject) paramJson.element).optString("cancel"), ((JSONObject) paramJson.element).optString(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.lua.ay
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ba.k(atomicBoolean, objectRef, booleanRef, argument, this$0, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.lua.az
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ba.l(atomicBoolean, objectRef, booleanRef, argument, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026      }\n                )");
            createCustomDialog.setOnDismissListener(bVar);
            createCustomDialog.show();
        }
    }
}
