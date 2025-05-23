package com.tencent.timi.game.floatwindow.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/FloatingStatusReceiver;", "Landroid/content/BroadcastReceiver;", "Luh4/g;", "listener", "", "a", "b", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "Landroid/content/Context;", "mContext", "", "Ljava/util/List;", "mWindowStatusListener", "<init>", "(Landroid/content/Context;)V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FloatingStatusReceiver extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static final int f377052d = MobileQQ.sProcessId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mWindowStatusListener;

    public FloatingStatusReceiver(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mWindowStatusListener = new ArrayList();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        mContext.getApplicationContext().registerReceiver(this, intentFilter);
    }

    public final void a(@Nullable g listener) {
        if (!this.mWindowStatusListener.contains(listener)) {
            this.mWindowStatusListener.add(listener);
        }
    }

    public final void b() {
        this.mContext.getApplicationContext().unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("process_name");
        l.b("FloatingStatusReceiver", "action: " + intent.getAction() + " processName:" + stringExtra);
        if (Intrinsics.areEqual(IECScreenReceiver.ACTION_SCREEN_OFF, intent.getAction())) {
            for (g gVar : this.mWindowStatusListener) {
                Intrinsics.checkNotNull(gVar);
                gVar.c();
            }
            return;
        }
        if (Intrinsics.areEqual(IECScreenReceiver.ACTION_QQ_BACKGROUND, intent.getAction())) {
            if (stringExtra != null && Intrinsics.areEqual(stringExtra, "com.tencent.mobileqq")) {
                for (g gVar2 : this.mWindowStatusListener) {
                    Intrinsics.checkNotNull(gVar2);
                    gVar2.a();
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
                for (g gVar3 : this.mWindowStatusListener) {
                    Intrinsics.checkNotNull(gVar3);
                    gVar3.d();
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_CHANGED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_KICKED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_ACCOUNT_EXPIRED, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_FORCE_LOGOUT, intent.getAction()) || Intrinsics.areEqual(NewIntent.ACTION_LOGOUT, intent.getAction())) {
            l.b("FloatingStatusReceiver", "cnrType=" + intent.getIntExtra("type", -1) + " action=" + intent.getAction());
            for (g gVar4 : this.mWindowStatusListener) {
                Intrinsics.checkNotNull(gVar4);
                gVar4.b();
            }
        }
    }
}
