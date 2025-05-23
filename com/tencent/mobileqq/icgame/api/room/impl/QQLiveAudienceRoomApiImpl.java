package com.tencent.mobileqq.icgame.api.room.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.IQQLiveAudienceRoomApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/impl/QQLiveAudienceRoomApiImpl;", "Lcom/tencent/mobileqq/icgame/api/room/IQQLiveAudienceRoomApi;", "Landroid/content/Context;", "context", "Lxt0/a;", "params", "Landroid/app/Activity;", "currentActivity", "", "enterExistSameRoom", "", "skipOnNewIntent", "enterRoom", "<init>", "()V", "Companion", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveAudienceRoomApiImpl implements IQQLiveAudienceRoomApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String EXTRA_KEY_FROM_WINDOW = "open_from_float_window";

    @NotNull
    private static final Lazy<String> TAG$delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/impl/QQLiveAudienceRoomApiImpl$Companion;", "", "()V", "EXTRA_KEY_FROM_WINDOW", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTAG() {
            return (String) QQLiveAudienceRoomApiImpl.TAG$delegate.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.icgame.api.room.impl.QQLiveAudienceRoomApiImpl$Companion$TAG$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "QQLiveAudienceRoomImpl";
            }
        });
        TAG$delegate = lazy;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IQQLiveAudienceRoomApi
    public void enterExistSameRoom(@NotNull Context context, @NotNull xt0.a params, @NotNull Activity currentActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        QLog.i(INSTANCE.getTAG(), 1, "enterExistSameRoom");
        Intent intent = currentActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "currentActivity.intent");
        intent.putExtras(p42.a.a(params));
        intent.putExtra(EXTRA_KEY_FROM_WINDOW, true);
        intent.setFlags(67108864);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        currentActivity.setIntent(intent);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IQQLiveAudienceRoomApi
    public void enterRoom(@NotNull Context context, @NotNull xt0.a params, boolean skipOnNewIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intent paramIntent = p42.a.a(params);
        if (!(context instanceof Activity)) {
            paramIntent.addFlags(268435456);
        }
        QLog.i(INSTANCE.getTAG(), 1, "current is single Room");
        Intrinsics.checkNotNullExpressionValue(paramIntent, "paramIntent");
        com.tencent.mobileqq.icgame.room.frame.activity.a.b(paramIntent, context);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.room.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.icgame.game.liveroom.impl.room.util.a.a();
            }
        }, 16, null, false);
    }
}
