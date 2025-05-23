package com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.component.ECommerceBubbleBroadcastReceiver;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/component/ECommerceBubbleBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/component/ECommerceBubbleBroadcastReceiver$a;", "listener", "", "b", "d", "c", "e", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "", "Z", "isRegistered", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "listenerSet", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceBubbleBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isRegistered;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ECommerceBubbleBroadcastReceiver f377573a = new ECommerceBubbleBroadcastReceiver();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<a> listenerSet = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/component/ECommerceBubbleBroadcastReceiver$a;", "", "", "isVisible", "", "D7", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void D7(boolean isVisible);
    }

    ECommerceBubbleBroadcastReceiver() {
    }

    public final void b(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerSet.add(listener);
    }

    public final void c() {
        if (isRegistered) {
            return;
        }
        isRegistered = true;
        MobileQQ.sMobileQQ.registerReceiver(this, new IntentFilter("com.tencent.ecommerce.biz.live_window"));
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceBubbleBroadcastReceiver", 2, "registerReceiver");
        }
    }

    public final void d(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerSet.remove(listener);
    }

    public final void e() {
        if (isRegistered) {
            MobileQQ.sMobileQQ.unregisterReceiver(this);
            isRegistered = false;
            if (QLog.isColorLevel()) {
                QLog.i("ECommerceBubbleBroadcastReceiver", 2, "unRegister");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable final Intent intent) {
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.component.ECommerceBubbleBroadcastReceiver$onReceive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashSet hashSet;
                Intent intent2 = intent;
                boolean booleanExtra = intent2 != null ? intent2.getBooleanExtra("isWindowShow", false) : false;
                hashSet = ECommerceBubbleBroadcastReceiver.listenerSet;
                Iterator it = hashSet.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "listenerSet.iterator()");
                while (it.hasNext()) {
                    ((ECommerceBubbleBroadcastReceiver.a) it.next()).D7(booleanExtra);
                }
            }
        });
    }
}
