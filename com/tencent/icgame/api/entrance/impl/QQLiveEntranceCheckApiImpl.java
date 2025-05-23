package com.tencent.icgame.api.entrance.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.icgame.api.entrance.IQQLiveEntranceCheckApi;
import com.tencent.icgame.api.entrance.QQLiveEntrance;
import com.tencent.icgame.api.entrance.impl.QQLiveEntranceCheckApiImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.auth.AuthState;
import com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi;
import com.tencent.timi.game.utils.o;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J*\u0010\u0011\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/api/entrance/impl/QQLiveEntranceCheckApiImpl;", "Lcom/tencent/icgame/api/entrance/IQQLiveEntranceCheckApi;", "", "isStudyMode", "Landroid/content/Context;", "context", "Lcom/tencent/icgame/api/entrance/QQLiveEntrance;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "Landroid/os/Bundle;", "entranceParams", "Lcom/tencent/icgame/api/entrance/a;", "callback", "", "checkIdentify", "", "dlgType", "showDlg", "checkEntrance", "newStrategy", "Z", "<init>", "()V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveEntranceCheckApiImpl implements IQQLiveEntranceCheckApi {

    @Deprecated
    private static final int ADULT_AGE = 18;

    @NotNull
    private static final a Companion = new a(null);
    private final boolean newStrategy = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/icgame/api/entrance/impl/QQLiveEntranceCheckApiImpl$a;", "", "", "ADULT_AGE", "I", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114812a;

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
            f114812a = iArr;
        }
    }

    private final void checkIdentify(final Context context, final QQLiveEntrance entrance, final Bundle entranceParams, final com.tencent.icgame.api.entrance.a callback) {
        if (isStudyMode()) {
            QLog.i("ICGameEntranceCheckApiImpl", 1, "study mode");
            callback.a(entrance, true, "");
        } else {
            ((IQQLiveAuthCheckApi) QRoute.api(IQQLiveAuthCheckApi.class)).checkAuth(new com.tencent.timi.game.api.auth.a() { // from class: nt0.e
                @Override // com.tencent.timi.game.api.auth.a
                public final void a(AuthState authState, String str) {
                    QQLiveEntranceCheckApiImpl.checkIdentify$lambda$0(QQLiveEntranceCheckApiImpl.this, callback, entrance, entranceParams, context, authState, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIdentify$lambda$0(QQLiveEntranceCheckApiImpl this$0, com.tencent.icgame.api.entrance.a callback, QQLiveEntrance entrance, Bundle entranceParams, Context context, AuthState authState, String str) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(entrance, "$entrance");
        Intrinsics.checkNotNullParameter(entranceParams, "$entranceParams");
        QLog.i("ICGameEntranceCheckApiImpl", 1, "checkAuth state:" + authState + ", message:" + str);
        if (authState == null) {
            i3 = -1;
        } else {
            i3 = b.f114812a[authState.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    callback.a(entrance, true, str);
                    return;
                } else {
                    callback.a(entrance, true, str);
                    return;
                }
            }
            if (this$0.newStrategy) {
                callback.a(entrance, true, str);
                return;
            } else {
                this$0.showDlg(context, 2);
                callback.a(entrance, false, str);
                return;
            }
        }
        if (this$0.newStrategy) {
            callback.a(entrance, true, str);
        } else {
            if (entranceParams.getInt("user_age") >= 18) {
                callback.a(entrance, true, str);
                return;
            }
            QLog.i("ICGameEntranceCheckApiImpl", 1, "user is teen");
            this$0.showDlg(context, 1);
            callback.a(entrance, false, str);
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

    @Override // com.tencent.icgame.api.entrance.IQQLiveEntranceCheckApi
    public void checkEntrance(@Nullable Context context, @NotNull QQLiveEntrance entrance, @NotNull Bundle entranceParams, @NotNull com.tencent.icgame.api.entrance.a callback) {
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(entranceParams, "entranceParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (o.a()) {
            return;
        }
        QLog.i("ICGameEntranceCheckApiImpl", 1, "checkEntrance entrance:" + entrance.name());
        checkIdentify(context, entrance, entranceParams, callback);
    }
}
