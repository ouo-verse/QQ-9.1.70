package com.tencent.ecommerce.base.runtime.api;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/runtime/api/IECScreenReceiver;", "", "Landroid/content/Intent;", "intent", "", "receive", "Companion", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECScreenReceiver {

    @NotNull
    public static final String ACTION_QQ_BACKGROUND = "mqq.intent.action.QQ_BACKGROUND";

    @NotNull
    public static final String ACTION_QQ_FOREGROUND = "mqq.intent.action.QQ_FOREGROUND";

    @NotNull
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    @NotNull
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f100955a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/runtime/api/IECScreenReceiver$a;", "", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.runtime.api.IECScreenReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f100955a = new Companion();

        Companion() {
        }
    }

    void receive(@NotNull Intent intent);
}
