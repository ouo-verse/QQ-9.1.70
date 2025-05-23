package com.tencent.mobileqq.guild.feed.event.bus;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H$J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\n\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/bus/GuildIPCCompatEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "saveInFile", "T", "restoreFromFile", "()Lcom/tencent/mobileqq/guild/feed/event/bus/GuildIPCCompatEvent;", "afterSaveInFile", "", "toString", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "", "<set-?>", "isCompleted", "Z", "()Z", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildIPCCompatEvent extends SimpleBaseEvent {
    public static final int IPC_DATA_THRESHOLD_LENGTH = 188184;

    /* renamed from: isCompleted, reason: from kotlin metadata and from toString */
    private boolean isRestore;

    @NotNull
    private final String requestId;

    public GuildIPCCompatEvent(@NotNull String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        this.requestId = requestId;
        this.isRestore = true;
    }

    protected abstract void afterSaveInFile();

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: isCompleted, reason: from getter */
    public final boolean getIsRestore() {
        return this.isRestore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T extends com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent, java.lang.Object, com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent] */
    @Nullable
    public final <T extends GuildIPCCompatEvent> T restoreFromFile() {
        if (this.isRestore) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent.restoreFromFile");
            return this;
        }
        T t16 = null;
        try {
            MMKVOptionEntity L = bw.L();
            String str = this.requestId;
            Bundle bundle = Bundle.EMPTY;
            Bundle bundle2 = (Bundle) L.decodeParcelable(str, Bundle.class, bundle);
            if (bundle2 != null) {
                bundle = bundle2;
            }
            Serializable serializable = bundle.getSerializable("event_data");
            if (serializable instanceof GuildIPCCompatEvent) {
                t16 = (GuildIPCCompatEvent) serializable;
            }
            bw.L().removeKey(this.requestId);
            if (t16 != null) {
                t16.isRestore = true;
            }
        } catch (Exception e16) {
            QLog.e("GuildIPCCompatEvent", 1, "[restoreFromFile] encounter exception: " + ExceptionsKt.stackTraceToString(e16));
        }
        return t16;
    }

    public final void saveInFile() {
        try {
            if (!bw.L().encodeParcelableR(this.requestId, BundleKt.bundleOf(TuplesKt.to("event_data", this)))) {
                QLog.e("GuildIPCCompatEvent", 1, "[saveInFile]: save with return false");
            }
        } catch (Exception e16) {
            QLog.e("GuildIPCCompatEvent", 1, "[saveInFile] exception: " + ExceptionsKt.stackTraceToString(e16));
        }
        afterSaveInFile();
        this.isRestore = false;
    }

    @NotNull
    public String toString() {
        return "{reqId=" + this.requestId + ", isRestore=" + this.isRestore + "}";
    }
}
