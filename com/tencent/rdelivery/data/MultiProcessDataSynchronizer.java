package com.tencent.rdelivery.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.util.c;
import com.tencent.rdelivery.util.d;
import iz3.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0007\u0019B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer;", "", "Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer$NetMsgReceiver;", "a", "Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer$NetMsgReceiver;", "netMsgReceiver", "Liz3/i;", "b", "Liz3/i;", "localStorageUpdateListener", "Lcom/tencent/rdelivery/RDeliverySetting;", "c", "Lcom/tencent/rdelivery/RDeliverySetting;", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Landroid/content/Context;", "d", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Lcom/tencent/rdelivery/net/g;", "requestManager", "<init>", "(Lcom/tencent/rdelivery/net/g;Lcom/tencent/rdelivery/RDeliverySetting;Landroid/content/Context;)V", "e", "NetMsgReceiver", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class MultiProcessDataSynchronizer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private NetMsgReceiver netMsgReceiver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private i localStorageUpdateListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer$NetMsgReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/rdelivery/net/g;", "a", "Lcom/tencent/rdelivery/net/g;", "getRequestManager", "()Lcom/tencent/rdelivery/net/g;", "requestManager", "Lcom/tencent/rdelivery/RDeliverySetting;", "b", "Lcom/tencent/rdelivery/RDeliverySetting;", "getSetting", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "<init>", "(Lcom/tencent/rdelivery/net/g;Lcom/tencent/rdelivery/RDeliverySetting;)V", "c", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class NetMsgReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final g requestManager;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RDeliverySetting setting;

        public NetMsgReceiver(@NotNull g requestManager, @NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            this.requestManager = requestManager;
            this.setting = setting;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            c logger = this.setting.getLogger();
            if (logger != null) {
                c.b(logger, d.a("NetMsgReceiver", this.setting.getRdInstanceIdentifier()), "NetMsgReceiver onReceive " + intent, false, 4, null);
            }
            g.e(this.requestManager, RDeliveryRequest.RequestSource.MULTI_PROCESS_DATA_SYNC, null, null, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/data/MultiProcessDataSynchronizer$a", "Liz3/i;", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f364206b;

        a(String str) {
            this.f364206b = str;
        }

        @Override // iz3.i
        public void a() {
            try {
                MultiProcessDataSynchronizer.this.getContext().sendBroadcast(new Intent(this.f364206b));
            } catch (Exception e16) {
                c logger = MultiProcessDataSynchronizer.this.getSetting().getLogger();
                if (logger != null) {
                    logger.d(d.a("MultiProcessDataSynchronizer", MultiProcessDataSynchronizer.this.getSetting().getRdInstanceIdentifier()), "sendBroadcast exception ", e16);
                }
            }
        }
    }

    public MultiProcessDataSynchronizer(@NotNull g requestManager, @NotNull RDeliverySetting setting, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.setting = setting;
        this.context = context;
        String str = "RECEIVE_NEW_RD_NET_DATA_" + setting.getRdInstanceIdentifier();
        if (setting.W()) {
            a aVar = new a(str);
            this.localStorageUpdateListener = aVar;
            setting.d0(aVar);
            return;
        }
        NetMsgReceiver netMsgReceiver = new NetMsgReceiver(requestManager, setting);
        this.netMsgReceiver = netMsgReceiver;
        try {
            context.registerReceiver(netMsgReceiver, new IntentFilter(str));
        } catch (Exception e16) {
            c logger = this.setting.getLogger();
            if (logger != null) {
                logger.d(d.a("MultiProcessDataSynchronizer", this.setting.getRdInstanceIdentifier()), "init exception ", e16);
            }
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }
}
