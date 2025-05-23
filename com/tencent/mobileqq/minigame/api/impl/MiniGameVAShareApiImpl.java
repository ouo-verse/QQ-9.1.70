package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.activity.MiniSharePanelFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.api.CreateColorNoteCallback;
import com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi;
import com.tencent.mobileqq.minigame.va.util.InitColorNoteCallback;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAColorNote;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2%\u0010\t\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\nj\u0002`\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAShareApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAShareApi;", "()V", MiniChatConstants.MINI_APP_ADD_SHORTCUT, "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "appId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/api/AddShortcutCallback;", "createMiniGameVAColorNote", "Lcom/tencent/mobileqq/minigame/api/CreateColorNoteCallback;", "isMiniGameShortcutExist", "appName", "openShareFragment", "params", "Landroid/os/Bundle;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAShareApiImpl implements IMiniGameVAShareApi {
    private static final String TAG = "MiniGameVAShareApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$6(final Function1 callback, final Activity activity, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            QLog.d(TAG, 1, "addShortcut getAppInfo isSuc=" + z16 + ",ret=" + jSONObject);
            if (!z16) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            long optLong = jSONObject.optLong("retCode");
            String optString = jSONObject.optString("errMsg");
            MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
            QLog.i(TAG, 1, "getAppInfo, retCode = " + optLong + ",errMsg = " + optString + " appInfo:" + (miniAppInfo != null));
            if (miniAppInfo == null) {
                callback.invoke(Boolean.FALSE);
            } else if (ShortcutUtils.i(activity) == 1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniGameVAShareApiImpl.addShortcut$lambda$6$lambda$4(activity, callback);
                    }
                });
            } else {
                ShortcutUtils.n(activity, MiniSdkLauncher.convert(miniAppInfo), new ShortcutUtils.c() { // from class: com.tencent.mobileqq.minigame.api.impl.p
                    @Override // com.tencent.qqmini.proxyimpl.ShortcutUtils.c
                    public final void a(int i3, String str) {
                        MiniGameVAShareApiImpl.addShortcut$lambda$6$lambda$5(Function1.this, i3, str);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAppInfo", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$6$lambda$4(final Activity activity, final Function1 callback) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ShortcutUtils.d Q = ShortcutUtils.d.Q(activity, "\u65e0\u6cd5\u6dfb\u52a0\u5feb\u6377\u65b9\u5f0f", "\u53d6\u6d88", "\u53bb\u8bbe\u7f6e", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.api.impl.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniGameVAShareApiImpl.addShortcut$lambda$6$lambda$4$lambda$2(activity, callback, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.api.impl.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniGameVAShareApiImpl.addShortcut$lambda$6$lambda$4$lambda$3(Function1.this, dialogInterface, i3);
            }
        });
        Q.S(false);
        Q.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$6$lambda$4$lambda$2(Activity activity, Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ba.openPermissionActivity(activity);
        callback.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$6$lambda$4$lambda$3(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        dialogInterface.dismiss();
        callback.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$6$lambda$5(Function1 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0) {
            callback.invoke(Boolean.TRUE);
        } else {
            callback.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMiniGameVAColorNote$lambda$1(final CreateColorNoteCallback callback, final Activity activity, boolean z16, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            QLog.d(TAG, 1, "createMiniGameVAColorNote getAppInfo isSuc=" + z16 + ",ret=" + jSONObject);
            if (!z16) {
                callback.onCreate(null);
                return;
            }
            long optLong = jSONObject.optLong("retCode");
            String optString = jSONObject.optString("errMsg");
            final MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
            QLog.i(TAG, 1, "getAppInfo, retCode = " + optLong + ",errMsg = " + optString + " appInfo:" + (miniAppInfo == null));
            if (miniAppInfo == null) {
                callback.onCreate(null);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniGameVAShareApiImpl.createMiniGameVAColorNote$lambda$1$lambda$0(activity, miniAppInfo, callback);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e(MiniSharePanelFragment.TAG, 1, "getAppInfo", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMiniGameVAColorNote$lambda$1$lambda$0(Activity activity, MiniAppInfo miniAppInfo, final CreateColorNoteCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert = MiniSdkLauncher.convert(miniAppInfo);
        Intrinsics.checkNotNullExpressionValue(convert, "convert(appInfo)");
        final MiniGameVAColorNote miniGameVAColorNote = new MiniGameVAColorNote(activity, convert, null);
        miniGameVAColorNote.setInitCallback(new InitColorNoteCallback() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAShareApiImpl$createMiniGameVAColorNote$1$1$1
            @Override // com.tencent.mobileqq.minigame.va.util.InitColorNoteCallback
            public void init() {
                CreateColorNoteCallback.this.onCreate(miniGameVAColorNote);
            }
        });
        miniGameVAColorNote.onResume();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi
    public void addShortcut(final Activity activity, String appId, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniAppCmdUtil.getInstance().getAppInfoById(null, appId, null, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.api.impl.r
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniGameVAShareApiImpl.addShortcut$lambda$6(Function1.this, activity, z16, jSONObject);
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi
    public void createMiniGameVAColorNote(final Activity activity, String appId, final CreateColorNoteCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniAppCmdUtil.getInstance().getAppInfoById(null, appId, null, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.api.impl.q
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniGameVAShareApiImpl.createMiniGameVAColorNote$lambda$1(CreateColorNoteCallback.this, activity, z16, jSONObject);
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi
    public boolean isMiniGameShortcutExist(Activity activity, String appId, String appName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appName, "appName");
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
        miniAppInfo.appId = appId;
        miniAppInfo.name = appName;
        return ShortcutUtils.s(activity, miniAppInfo);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi
    public void openShareFragment(Activity activity, Bundle params) {
        Class cls;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.getBoolean("orientation", true)) {
            cls = QPublicTransFragmentActivityLandscape.class;
        } else {
            cls = QPublicTransFragmentActivity.class;
        }
        Intent intent = new Intent();
        intent.putExtras(params);
        intent.setComponent(new ComponentName("com.tencent.mobileqq", cls.getName()));
        intent.putExtra("public_fragment_class", MiniGameVAShareFragment.class.getName());
        activity.startActivity(intent);
    }
}
