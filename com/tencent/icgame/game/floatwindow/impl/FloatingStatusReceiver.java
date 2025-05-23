package com.tencent.icgame.game.floatwindow.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.icgame.game.utils.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import vu0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/FloatingStatusReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "Lvu0/c;", "a", "Ljava/util/List;", "mWindowStatusListener", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FloatingStatusReceiver extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    private static final int f115022c = MobileQQ.sProcessId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> mWindowStatusListener;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("process_name");
        g.a("ICGameFloatingStatusReceiver", "action: " + intent.getAction() + " processName:" + stringExtra);
        if (Intrinsics.areEqual(IECScreenReceiver.ACTION_SCREEN_OFF, intent.getAction())) {
            for (c cVar : this.mWindowStatusListener) {
                Intrinsics.checkNotNull(cVar);
                cVar.c();
            }
            return;
        }
        if (Intrinsics.areEqual(IECScreenReceiver.ACTION_QQ_BACKGROUND, intent.getAction())) {
            if (stringExtra != null && Intrinsics.areEqual(stringExtra, "com.tencent.mobileqq")) {
                for (c cVar2 : this.mWindowStatusListener) {
                    Intrinsics.checkNotNull(cVar2);
                    cVar2.a();
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(IECScreenReceiver.ACTION_QQ_FOREGROUND, intent.getAction())) {
            boolean z16 = false;
            if (stringExtra != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) stringExtra, (CharSequence) ProcessConstant.OPEN_SDK, false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (!z16) {
                for (c cVar3 : this.mWindowStatusListener) {
                    Intrinsics.checkNotNull(cVar3);
                    cVar3.d();
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_CHANGED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_KICKED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_EXPIRED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_FORCE_LOGOUT, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_LOGOUT, intent.getAction())) {
            g.a("ICGameFloatingStatusReceiver", "cnrType=" + intent.getIntExtra("type", -1) + " action=" + intent.getAction());
            for (c cVar4 : this.mWindowStatusListener) {
                Intrinsics.checkNotNull(cVar4);
                cVar4.b();
            }
        }
    }
}
