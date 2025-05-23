package com.tencent.timi.game.api.auth.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.api.auth.AuthState;
import com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi;
import com.tencent.timi.game.api.auth.impl.QQLiveAuthCheckApiImpl;
import com.tencent.timi.game.initer.impl.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import nh2.c;
import oh2.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/api/auth/impl/QQLiveAuthCheckApiImpl;", "Lcom/tencent/timi/game/api/auth/IQQLiveAuthCheckApi;", "Lnh2/c;", "giftSDK", "", "initGiftSdkIfNeed", "registerAccountBroadcast", "fetchAndCacheAuthState", "Lcom/tencent/timi/game/api/auth/a;", "callback", "checkAuth", "forceCheckAuth", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "log", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "", "localStateValid", "Z", "Lcom/tencent/timi/game/api/auth/AuthState;", "authState", "Lcom/tencent/timi/game/api/auth/AuthState;", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveAuthCheckApiImpl implements IQQLiveAuthCheckApi {

    @Deprecated
    private static final int CODE_NOT_REAL_NAME_AUTH = -11153;

    @Deprecated
    private static final int CODE_REAL_NAME_AUTH_OK = 0;

    @Deprecated
    private static final int CODE_REAL_NAME_AUTH_UNDER_AGE = -11154;

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String QQ_ACTION_LOGOUT = "com.tencent.mobileqq.intent.logout";

    @NotNull
    private AuthState authState;
    private boolean localStateValid;

    @NotNull
    private final IAegisLogApi log;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/api/auth/impl/QQLiveAuthCheckApiImpl$a;", "", "", "CODE_NOT_REAL_NAME_AUTH", "I", "CODE_REAL_NAME_AUTH_OK", "CODE_REAL_NAME_AUTH_UNDER_AGE", "", "QQ_ACTION_LOGOUT", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public QQLiveAuthCheckApiImpl() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.authState = AuthState.UNKNOWN;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: df4.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveAuthCheckApiImpl._init_$lambda$0(QQLiveAuthCheckApiImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(QQLiveAuthCheckApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerAccountBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forceCheckAuth$lambda$2(QQLiveAuthCheckApiImpl this$0, com.tencent.timi.game.api.auth.a callback, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.log.i("QQLiveAuthCheckApiImpl", "checkIdentityStatus success:" + z16 + ",errorCode=" + i3 + ",errorMsg=" + str);
        if (i3 != CODE_REAL_NAME_AUTH_UNDER_AGE) {
            if (i3 != CODE_NOT_REAL_NAME_AUTH) {
                if (i3 != 0) {
                    callback.a(AuthState.UNKNOWN, "checkIdentityStatus errorCode=" + i3 + ",errorMsg=" + str);
                } else {
                    this$0.localStateValid = true;
                    AuthState authState = AuthState.AUTHED;
                    this$0.authState = authState;
                    callback.a(authState, str);
                }
            } else {
                this$0.localStateValid = true;
                AuthState authState2 = AuthState.NOT_AUTHED;
                this$0.authState = authState2;
                callback.a(authState2, str);
            }
        } else {
            this$0.localStateValid = true;
            AuthState authState3 = AuthState.AUTHED_TEEN;
            this$0.authState = authState3;
            callback.a(authState3, str);
        }
        this$0.log.i("QQLiveAuthCheckApiImpl", "checkIdentityStatus authState " + this$0.authState);
    }

    private final void initGiftSdkIfNeed(c giftSDK) {
        if (!giftSDK.isInited() || giftSDK.isDestroyed()) {
            QLog.i("QQLiveAuthCheckApiImpl", 1, "initGiftSdk isDestroyed:" + giftSDK.isDestroyed());
            b.f377190a.f(QQLiveSDKConfigHelper.getSceneId());
        }
    }

    private final void registerAccountBroadcast() {
        BaseApplication baseApplication = BaseApplication.context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.intent.logout");
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + baseApplication.getPackageName());
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        baseApplication.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.timi.game.api.auth.impl.QQLiveAuthCheckApiImpl$registerAccountBroadcast$accountBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                IAegisLogApi iAegisLogApi;
                AuthState authState;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                QQLiveAuthCheckApiImpl.this.localStateValid = false;
                QQLiveAuthCheckApiImpl.this.authState = AuthState.UNKNOWN;
                iAegisLogApi = QQLiveAuthCheckApiImpl.this.log;
                String action = intent.getAction();
                authState = QQLiveAuthCheckApiImpl.this.authState;
                iAegisLogApi.i("QQLiveAuthCheckApiImpl", "receive, action " + action + ", authState " + authState);
            }
        }, intentFilter);
    }

    @Override // com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi
    public void checkAuth(@NotNull com.tencent.timi.game.api.auth.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.log.i("QQLiveAuthCheckApiImpl", "checkAuth, localStateValid " + this.localStateValid + ", authState " + this.authState);
        if (this.localStateValid) {
            callback.a(this.authState, "");
        } else {
            forceCheckAuth(callback);
        }
    }

    @Override // com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi
    public void fetchAndCacheAuthState() {
        if (this.localStateValid) {
            return;
        }
        forceCheckAuth(new com.tencent.timi.game.api.auth.a() { // from class: df4.a
            @Override // com.tencent.timi.game.api.auth.a
            public final void a(AuthState authState, String str) {
                QQLiveAuthCheckApiImpl.fetchAndCacheAuthState$lambda$1(authState, str);
            }
        });
    }

    @Override // com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi
    public void forceCheckAuth(@NotNull final com.tencent.timi.game.api.auth.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.log.i("QQLiveAuthCheckApiImpl", "forceCheckAuth");
        c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl == null) {
            this.log.e("QQLiveAuthCheckApiImpl", "giftSDK is null");
            callback.a(AuthState.UNKNOWN, "giftSDK is null");
        } else {
            initGiftSdkIfNeed(sDKImpl);
            sDKImpl.e().C(new c.a() { // from class: df4.b
                @Override // oh2.c.a
                public final void a(boolean z16, int i3, String str) {
                    QQLiveAuthCheckApiImpl.forceCheckAuth$lambda$2(QQLiveAuthCheckApiImpl.this, callback, z16, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchAndCacheAuthState$lambda$1(AuthState authState, String str) {
    }
}
