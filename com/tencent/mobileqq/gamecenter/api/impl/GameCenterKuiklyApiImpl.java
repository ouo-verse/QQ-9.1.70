package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Looper;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.kuikly.module.GameCenterWebView;
import com.tencent.mobileqq.gamecenter.kuikly.module.QQGameCenterKuiklyModule;
import com.tencent.mobileqq.gamecenter.kuikly.module.ZoomDragImageView;
import com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J:\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0002J(\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b*\u00020\tH\u0002J(\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b*\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameCenterKuiklyApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameCenterKuiklyApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/gamecenter/ui/aa;", "openInfo", "", "openKuiklyFloatDialog", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "paramsMap", "doOpenFloatDialog", "schemeParams", "Lorg/json/JSONObject;", "toParamsMap", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalModule", QZoneDTLoginReporter.SCHEMA, "dataObj", "", "checkIfOpenFloatInCurProcess", QQPermissionConstants.Permission.AUIDO_GROUP, "removeRecordKey", "pushMsg", "onMsgForwardToFrontReceived", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterKuiklyApiImpl implements IGameCenterKuiklyApi {

    @NotNull
    public static final String EVENT_GAME_CENTER_NOTIFY_PUSH_MSG = "EVENT_GAME_CENTER_NOTIFY_PUSH_MSG";

    @NotNull
    public static final String EVENT_MSG_DATA_KEY = "data";

    @NotNull
    private static final String TAG = "GameCenterKuiklyApiImp";

    @NotNull
    private static final HashSet<String> floatRecordSet = new HashSet<>();

    private final void doOpenFloatDialog(final Activity activity, final LinkedHashMap<String, Object> paramsMap) {
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16 && paramsMap != null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.j
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterKuiklyApiImpl.doOpenFloatDialog$lambda$4(GameCenterKuiklyApiImpl.this, activity, paramsMap);
                }
            };
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                runnable.run();
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(runnable);
                return;
            }
        }
        QLog.e(TAG, 1, "[doOpenFloatDialog] params is error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOpenFloatDialog$lambda$4(GameCenterKuiklyApiImpl this$0, Activity activity, LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openKuiklyFloatDialog(activity, com.tencent.mobileqq.gamecenter.ui.ab.c(linkedHashMap));
    }

    private final void openKuiklyFloatDialog(Activity activity, com.tencent.mobileqq.gamecenter.ui.aa openInfo) {
        if (openInfo != null) {
            if (openInfo.getPackageName().length() == 0) {
                QLog.e(TAG, 1, "[openKuiklyFloatDialog] pageName is empty");
                return;
            }
            int hashCode = activity.hashCode();
            openInfo.s(openInfo.getPackageName() + "_" + hashCode);
            if (openInfo.h() && floatRecordSet.contains(openInfo.getRecordKey())) {
                QLog.e(TAG, 1, "[openKuiklyFloatDialog] activity already open this dialog");
                return;
            }
            if (activity.isFinishing()) {
                QLog.e(TAG, 1, "[openKuiklyFloatDialog] activity is finish");
                return;
            }
            floatRecordSet.add(openInfo.getRecordKey());
            final GameCenterKuiklyFloatDialog gameCenterKuiklyFloatDialog = new GameCenterKuiklyFloatDialog(activity, R.style.a0z, openInfo);
            gameCenterKuiklyFloatDialog.setContentView(R.layout.eb9);
            gameCenterKuiklyFloatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.gamecenter.api.impl.k
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GameCenterKuiklyApiImpl.openKuiklyFloatDialog$lambda$3$lambda$2$lambda$1(GameCenterKuiklyFloatDialog.this, dialogInterface);
                }
            });
            gameCenterKuiklyFloatDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openKuiklyFloatDialog$lambda$3$lambda$2$lambda$1(GameCenterKuiklyFloatDialog this_apply, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.Q("onDismiss");
    }

    private final LinkedHashMap<String, Object> schemeParams(String str) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        try {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null) {
                for (String it : queryParameterNames) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String queryParameter = parse.getQueryParameter(it);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                    linkedHashMap.put(it, queryParameter);
                }
            }
        } catch (Throwable th5) {
            QLog.e("schemeParams", 1, "schemeParams error: " + th5);
        }
        return linkedHashMap;
    }

    private final LinkedHashMap<String, Object> toParamsMap(JSONObject jSONObject) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        try {
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Object obj = jSONObject.get(key);
                Intrinsics.checkNotNullExpressionValue(obj, "this[key]");
                linkedHashMap.put(key, obj);
            }
        } catch (Throwable th5) {
            QLog.e("toParamsMap", 1, "toParamsMap error: " + th5);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkIfOpenFloatInCurProcess(@Nullable String schema) {
        boolean z16;
        boolean startsWith$default;
        if (schema != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schema, "mqqapi://gamecenter/kuikly_float", false, 2, null);
            if (startsWith$default) {
                z16 = true;
                if (z16) {
                    return false;
                }
                QLog.i(TAG, 1, "[checkIfOpenFloatInCurProcess] true");
                ax c16 = bi.c(null, MobileQQ.sMobileQQ, schema);
                if (c16 != null) {
                    c16.b();
                }
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    public void onMsgForwardToFrontReceived(@Nullable String pushMsg) {
        boolean z16;
        QLog.i(TAG, 2, "[onMsgForwardToFrontReceived] pushMsg:" + pushMsg);
        if (pushMsg != null && pushMsg.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", pushMsg);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, EVENT_GAME_CENTER_NOTIFY_PUSH_MSG, jSONObject);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("GameCenterKuiklyFloatModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.gamecenter.kuikly.module.b();
            }
        });
        renderExport.a("QQGameCenterKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QQGameCenterKuiklyModule();
            }
        });
        renderExport.a("QQGameDistributeModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.gamecenter.kuikly.module.l();
            }
        });
        renderExport.a("QQGameMsgKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.gamecenter.kuikly.module.r();
            }
        });
        renderExport.a("QQGameProfileCardModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.gamecenter.kuikly.module.t();
            }
        });
        b.a.a(renderExport, "QQRemoteWebView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$6
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GameCenterWebView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "QQKuiklyPictureView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterKuiklyApiImpl$registerExternalModule$1$7
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new ZoomDragImageView(it);
            }
        }, null, 4, null);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    public void removeRecordKey(@NotNull String record) {
        Intrinsics.checkNotNullParameter(record, "record");
        floatRecordSet.remove(record);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    public void openKuiklyFloatDialog(@Nullable Activity activity, @Nullable String schema) {
        doOpenFloatDialog(activity, schema != null ? schemeParams(schema) : null);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi
    public void openKuiklyFloatDialog(@Nullable Activity activity, @Nullable JSONObject dataObj) {
        doOpenFloatDialog(activity, dataObj != null ? toParamsMap(dataObj) : null);
    }
}
