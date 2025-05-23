package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H&J@\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "currentMode", "", "reportArkExpo", "", "position", "", "aioChatType", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "(ILjava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "reportBeacon", "event", "params", "", "reportBigT", "bigT", "entry", "result", "r1", "r2", "r3", "r4", "reportRobot", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOReport extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull IAIOReport iAIOReport) {
            return "0";
        }

        public static void b(@NotNull IAIOReport iAIOReport, int i3, @Nullable Integer num, @NotNull MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }
    }

    @NotNull
    String currentMode();

    void reportArkExpo(int position, @Nullable Integer aioChatType, @NotNull MsgRecord msgRecord);

    void reportBeacon(@NotNull String event, @NotNull Map<String, String> params);

    void reportBigT(@NotNull String bigT);

    void reportBigT(@NotNull String bigT, int entry, int result, @NotNull String r16, @NotNull String r26, @NotNull String r36, @NotNull String r46);

    void reportRobot(@NotNull MsgRecord msgRecord);
}
