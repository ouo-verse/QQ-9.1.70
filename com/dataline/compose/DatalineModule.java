package com.dataline.compose;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import com.dataline.nt.DataLineRecentContactUtil;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import cooperation.qzone.QzoneIPCModule;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002JI\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022+\u0010\"\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\t\u0018\u00010\u001cj\u0004\u0018\u0001`!H\u0016J\b\u0010$\u001a\u00020\tH\u0016\u00a8\u0006)"}, d2 = {"Lcom/dataline/compose/DatalineModule;", "Li01/e;", "", "methodType", "", "deviceType", "uin", "", "isChecked", "", "j", "bAutoDownload", "t", "bPcOnlineNotify", "u", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "w", "p", NodeProps.ENABLED, "v", "l", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "onCreate", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class DatalineModule extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/dataline/compose/DatalineModule$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.c {
        b() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (resultCode == -1 && data != null && data.getExtras() != null) {
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(DatalineModule.this.getActivity()), new int[]{2});
                m3.putExtras(new Bundle(data.getExtras()));
                Activity activity = DatalineModule.this.getActivity();
                if (activity != null) {
                    activity.startActivity(m3);
                }
                Activity activity2 = DatalineModule.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
            c.a.a(this, requestCode, resultCode, data);
        }
    }

    private final void j(String methodType, int deviceType, String uin, boolean isChecked) {
        int hashCode = methodType.hashCode();
        if (hashCode != -1815615808) {
            if (hashCode != 424899220) {
                if (hashCode == 1957096995 && methodType.equals("pcOnlineMentionChecked")) {
                    u(deviceType, isChecked);
                    return;
                }
                return;
            }
            if (methodType.equals("setTopChecked")) {
                DataLineRecentContactUtil.f32313a.y(uin, isChecked);
                return;
            }
            return;
        }
        if (methodType.equals("noWifiAutoRecvFileChecked")) {
            t(deviceType, isChecked);
            ((IDataLineConfigApi) QRoute.api(IDataLineConfigApi.class)).setAutoDownload(isChecked);
        }
    }

    private final void l(String uin) {
        QQAppInterface qQAppInterface;
        String str;
        int i3;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        if (Intrinsics.areEqual(AppConstants.DATALINE_PC_UIN, uin)) {
            str = PeerUid.DATALINE_PC_UID;
            i3 = 6000;
        } else if (Intrinsics.areEqual(AppConstants.DATALINE_PHONE_UIN, uin)) {
            str = PeerUid.DATALINE_PHONE_UID;
            i3 = 6005;
        } else if (Intrinsics.areEqual(AppConstants.DATALINE_IPAD_UIN, uin)) {
            str = PeerUid.DATALINE_PAD_UID;
            i3 = 6003;
        } else {
            str = "";
            i3 = 0;
        }
        NTFriendSettingHelper.w(NTFriendSettingHelper.f352067a, new NTFriendSettingHelper.a(qQAppInterface, uin, str, true, i3), null, 2, null);
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("clear_flag", true);
        Intent intent = new Intent();
        intent.putExtra("launchKuiklyParams", extras);
        activity.setResult(-1, intent);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(int deviceType) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return false;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "app.preferences");
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType != 2) {
                    return false;
                }
                return preferences.getBoolean("auto_receive_files_phone", false);
            }
            return preferences.getBoolean("auto_receive_files_ipad", false);
        }
        return preferences.getBoolean("auto_receive_files", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(int deviceType) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return true;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "app.preferences");
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType != 2) {
                    return true;
                }
                return preferences.getBoolean("dl_phone_online_notify", true);
            }
            return preferences.getBoolean("dl_ipad_online_notify", true);
        }
        return preferences.getBoolean("dl_pc_online_notify", true);
    }

    private final boolean p() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return true;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "app.preferences");
        return preferences.getBoolean("dl_is_add_shortcut_hint_enabled", true);
    }

    private final void q(int deviceType) {
        QQAppInterface qQAppInterface;
        int i3;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        QQAppInterface qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 == null) {
            return;
        }
        String string = activity.getString(R.string.c5f);
        Intrinsics.checkNotNullExpressionValue(string, "localActivity.getString(R.string.lite_title)");
        String str = AppConstants.DATALINE_PC_UIN;
        if (deviceType == 3) {
            string = activity.getString(R.string.f16272217);
            Intrinsics.checkNotNullExpressionValue(string, "localActivity.getString(R.string.lite_title_pad)");
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = R.drawable.qfile_dataline_ipad_recent;
        } else {
            i3 = R.drawable.qfile_dataline_pc_recent;
        }
        if (deviceType == 2) {
            string = activity.getString(R.string.f16273218);
            Intrinsics.checkNotNullExpressionValue(string, "localActivity.getString(R.string.lite_title_phone)");
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = R.drawable.qfile_dataline_user_aio;
        }
        int i16 = i3;
        String str2 = string;
        if (!ah.O0(activity, str2) && (deviceType == 0 || deviceType == 1 || deviceType == 2 || deviceType == 3)) {
            Bundle bundle = new Bundle();
            bundle.putString(IProfileProtocolConst.PARAM_TARGET_UIN, str);
            Unit unit = Unit.INSTANCE;
            ah.d(qQAppInterface2, activity, "jump_shortcut_dataline", str2, i16, bundle);
            ReportController.o(qQAppInterface2, "CliOper", "", "", "data_wire", "Dw_shortcut_clk", 0, 0, "", "", "", "");
        }
        w(activity);
    }

    private final void r() {
        if (!Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
            com.tencent.mobileqq.filemanager.util.d.f("\u5185\u5b58\u5361\u88ab\u62d4\u9664\u6216\u5df2\u635f\u574f");
            return;
        }
        try {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByLiteAdvance(getActivity());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void t(int deviceType, boolean bAutoDownload) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "app.preferences");
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType == 2) {
                    preferences.edit().putBoolean("auto_receive_files_phone", bAutoDownload).apply();
                    return;
                }
                return;
            }
            preferences.edit().putBoolean("auto_receive_files_ipad", bAutoDownload).apply();
            return;
        }
        preferences.edit().putBoolean("auto_receive_files", bAutoDownload).apply();
    }

    private final void u(int deviceType, boolean bPcOnlineNotify) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "app.preferences");
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType == 2) {
                    preferences.edit().putBoolean("dl_phone_online_notify", bPcOnlineNotify).apply();
                    return;
                }
                return;
            }
            preferences.edit().putBoolean("dl_ipad_online_notify", bPcOnlineNotify).apply();
            return;
        }
        preferences.edit().putBoolean("dl_pc_online_notify", bPcOnlineNotify).apply();
    }

    private final void v(boolean enabled) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences.Editor edit = qQAppInterface.getPreferences().edit();
        edit.putBoolean("dl_is_add_shortcut_hint_enabled", enabled);
        edit.apply();
    }

    private final void w(final Activity activity) {
        if (!p()) {
            com.tencent.mobileqq.filemanager.util.d.g(R.string.b76);
        } else {
            DialogUtil.createDialogWithCheckBox(activity, 230, activity.getString(R.string.zqc), activity.getString(R.string.zq9), activity.getString(R.string.zqa), false, activity.getString(R.string.zqb), activity.getString(R.string.zq_), new DialogInterface.OnClickListener() { // from class: com.dataline.compose.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    DatalineModule.x(DatalineModule.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.dataline.compose.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    DatalineModule.y(activity, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.dataline.compose.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    DatalineModule.z(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(DatalineModule this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        if (i3 == 1) {
            z16 = false;
        }
        this$0.v(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Activity activity, DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        new PermissionPageUtil(activity, activity.getPackageName()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0039. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("DatalineModule", 1, "call method: " + method + ", params: " + params);
        switch (method.hashCode()) {
            case -1571111519:
                if (method.equals("addDesktopShortcut")) {
                    if (params == null) {
                        return super.call(method, params, callback);
                    }
                    q(new JSONObject(params).optInt("device_type", 0));
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 367611966:
                if (method.equals("getDatalineCheckedValue")) {
                    if (params != null && !Intrinsics.areEqual("", params)) {
                        JSONObject jSONObject = new JSONObject(params);
                        String targetUin = jSONObject.optString(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
                        final int optInt = jSONObject.optInt("device_type", 0);
                        DataLineRecentContactUtil dataLineRecentContactUtil = DataLineRecentContactUtil.f32313a;
                        Intrinsics.checkNotNullExpressionValue(targetUin, "targetUin");
                        dataLineRecentContactUtil.q(targetUin, new Function1<Boolean, Unit>() { // from class: com.dataline.compose.DatalineModule$call$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                boolean m3;
                                boolean o16;
                                JSONObject jSONObject2 = new JSONObject();
                                DatalineModule datalineModule = this;
                                int i3 = optInt;
                                jSONObject2.put("setTopChecked", z16);
                                m3 = datalineModule.m(i3);
                                jSONObject2.put("noWifiAutoRecvFileChecked", m3);
                                o16 = datalineModule.o(i3);
                                jSONObject2.put("pcOnlineMentionChecked", o16);
                                QLog.d("DatalineModule", 2, "getDatalineCheckedValue resultJson: " + jSONObject2);
                                Function1<Object, Unit> function1 = callback;
                                if (function1 != null) {
                                    function1.invoke(jSONObject2);
                                }
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                }
                return super.call(method, params, callback);
            case 771138140:
                if (method.equals("checkSwitch")) {
                    if (params == null) {
                        return super.call(method, params, callback);
                    }
                    JSONObject jSONObject2 = new JSONObject(params);
                    String methodType = jSONObject2.optString("type", "");
                    boolean optBoolean = jSONObject2.optBoolean("isChecked", false);
                    String uin = jSONObject2.optString(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
                    int optInt2 = jSONObject2.optInt("device_type", 0);
                    QLog.d("DatalineModule", 1, "checkSwitch params: " + params);
                    Intrinsics.checkNotNullExpressionValue(methodType, "methodType");
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    j(methodType, optInt2, uin, optBoolean);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 876329533:
                if (method.equals("getRecvFilePath")) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("recvFilePath", lc1.b.a().getDefaultRecvPath());
                    QLog.d("DatalineModule", 2, "get recv file path resultJson: " + jSONObject3);
                    if (callback != null) {
                        callback.invoke(jSONObject3);
                        return Unit.INSTANCE;
                    }
                    return null;
                }
                return super.call(method, params, callback);
            case 1367853925:
                if (method.equals("clearMsgRecord")) {
                    if (params == null) {
                        return super.call(method, params, callback);
                    }
                    String uin2 = new JSONObject(params).optString(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
                    Intrinsics.checkNotNullExpressionValue(uin2, "uin");
                    l(uin2);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1711749163:
                if (method.equals("queryDownloadedFile")) {
                    r();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // i01.e, i01.a
    public void onCreate() {
        super.onCreate();
        addKuiklyRenderLifecycleCallback(new b());
    }
}
