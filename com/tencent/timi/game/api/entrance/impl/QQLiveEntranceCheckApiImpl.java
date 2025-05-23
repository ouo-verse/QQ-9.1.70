package com.tencent.timi.game.api.entrance.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.auth.AuthState;
import com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi;
import com.tencent.timi.game.api.entrance.IQQLiveEntranceCheckApi;
import com.tencent.timi.game.api.entrance.impl.QQLiveEntranceCheckApiImpl;
import com.tencent.timi.game.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/api/entrance/impl/QQLiveEntranceCheckApiImpl;", "Lcom/tencent/timi/game/api/entrance/IQQLiveEntranceCheckApi;", "", "isStudyMode", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "entranceParams", "Lhf4/a;", "callback", "", "checkIdentify", "", "dlgType", "showDlg", "checkEntrance", "newStrategy", "Z", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveEntranceCheckApiImpl implements IQQLiveEntranceCheckApi {

    @Deprecated
    private static final int ADULT_AGE = 18;

    @NotNull
    private static final a Companion = new a(null);
    private final boolean newStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/api/entrance/impl/QQLiveEntranceCheckApiImpl$a;", "", "", "ADULT_AGE", "I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f376285a;

        static {
            int[] iArr = new int[AuthState.values().length];
            try {
                iArr[AuthState.NOT_AUTHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthState.AUTHED_TEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AuthState.AUTHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f376285a = iArr;
        }
    }

    public QQLiveEntranceCheckApiImpl() {
        this.newStrategy = ht3.a.b("qqlive_enable_new_minor_strategy", 1) == 1;
    }

    private final void checkIdentify(final Context context, final Bundle entranceParams, final hf4.a callback) {
        if (this.newStrategy) {
            QLog.i("QQLiveEntranceCheckApiImpl", 1, "use new strategy");
            callback.onResult(true, "");
        } else if (isStudyMode()) {
            QLog.i("QQLiveEntranceCheckApiImpl", 1, "study mode");
            callback.onResult(true, "");
        } else {
            ((IQQLiveAuthCheckApi) QRoute.api(IQQLiveAuthCheckApi.class)).checkAuth(new com.tencent.timi.game.api.auth.a() { // from class: if4.e
                @Override // com.tencent.timi.game.api.auth.a
                public final void a(AuthState authState, String str) {
                    QQLiveEntranceCheckApiImpl.checkIdentify$lambda$0(QQLiveEntranceCheckApiImpl.this, callback, entranceParams, context, authState, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIdentify$lambda$0(QQLiveEntranceCheckApiImpl this$0, hf4.a callback, Bundle entranceParams, Context context, AuthState authState, String str) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(entranceParams, "$entranceParams");
        QLog.i("QQLiveEntranceCheckApiImpl", 1, "checkAuth state:" + authState + ", message:" + str);
        if (authState == null) {
            i3 = -1;
        } else {
            i3 = b.f376285a[authState.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    callback.onResult(true, str);
                    return;
                } else {
                    callback.onResult(true, str);
                    return;
                }
            }
            if (this$0.newStrategy) {
                callback.onResult(true, str);
                return;
            } else {
                this$0.showDlg(context, 2);
                callback.onResult(false, str);
                return;
            }
        }
        if (this$0.newStrategy) {
            callback.onResult(true, str);
        } else {
            if (entranceParams.getInt("user_age") >= 18) {
                callback.onResult(true, str);
                return;
            }
            QLog.i("QQLiveEntranceCheckApiImpl", 1, "user is teen");
            this$0.showDlg(context, 1);
            callback.onResult(false, str);
        }
    }

    private final boolean isStudyMode() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    private final void showDlg(Context context, int dlgType) {
        Intent putExtra = new Intent().putExtra("key_dlg_type", dlgType).putExtra("public_fragment_window_feature", 1);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n               \u2026 Window.FEATURE_NO_TITLE)");
        putExtra.setFlags(335544320);
        QPublicFragmentActivity.b.b(context, putExtra, QPublicTransFragmentActivity.class, CheckDialogFragment.class);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).overridePendingTransition(0, 0);
    }

    @Override // com.tencent.timi.game.api.entrance.IQQLiveEntranceCheckApi
    public void checkEntrance(@Nullable Context context, @NotNull Bundle entranceParams, @NotNull hf4.a callback) {
        Intrinsics.checkNotNullParameter(entranceParams, "entranceParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (o.a()) {
            return;
        }
        checkIdentify(context, entranceParams, callback);
    }
}
