package com.tencent.mobileqq.statistics.tianjige.metrics;

import android.util.ArrayMap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianjige.metric.d;
import com.tencent.mobileqq.tianjige.metric.f;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/statistics/tianjige/metrics/a;", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", "c", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "msgRecords", "a", "b", "d", "", "", "[Ljava/lang/Integer;", "RECORD_MSG_LIST", "", "", "Ljava/util/Map;", "MSG_TYPE_TRANS", "", "[Ljava/lang/Double;", "BUCKETS_SEND_TEXT_MSG", "e", "BUCKETS_RECV_PUSH_MSG", "Lcom/tencent/mobileqq/tianjige/metric/a;", "f", "Lcom/tencent/mobileqq/tianjige/metric/a;", "msgCounter", "Lcom/tencent/mobileqq/tianjige/metric/d;", "g", "Lcom/tencent/mobileqq/tianjige/metric/d;", "msgHistogram", h.F, "msgPushHistogram", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f290143a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Integer[] RECORD_MSG_LIST;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> MSG_TYPE_TRANS;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Double[] BUCKETS_SEND_TEXT_MSG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Double[] BUCKETS_RECV_PUSH_MSG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.tianjige.metric.a msgCounter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d msgHistogram;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d msgPushHistogram;

    static {
        Map<Integer, String> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f290143a = new a();
        RECORD_MSG_LIST = new Integer[]{-1000};
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-1000, "1"));
        MSG_TYPE_TRANS = mapOf;
        BUCKETS_SEND_TEXT_MSG = new Double[]{Double.valueOf(200.0d), Double.valueOf(300.0d), Double.valueOf(400.0d), Double.valueOf(600.0d), Double.valueOf(800.0d), Double.valueOf(900.0d), Double.valueOf(1000.0d), Double.valueOf(1200.0d), Double.valueOf(1400.0d), Double.valueOf(1600.0d), Double.valueOf(2000.0d), Double.valueOf(3000.0d), Double.valueOf(4000.0d), Double.valueOf(5000.0d), Double.valueOf(6000.0d)};
        BUCKETS_RECV_PUSH_MSG = new Double[]{Double.valueOf(200.0d), Double.valueOf(300.0d), Double.valueOf(400.0d), Double.valueOf(600.0d), Double.valueOf(800.0d), Double.valueOf(900.0d), Double.valueOf(1000.0d), Double.valueOf(1200.0d), Double.valueOf(1400.0d), Double.valueOf(1600.0d), Double.valueOf(2000.0d), Double.valueOf(3000.0d), Double.valueOf(4000.0d), Double.valueOf(5000.0d), Double.valueOf(6000.0d)};
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull List<? extends MessageRecord> msgRecords, @NotNull FromServiceMsg resp) {
        boolean contains;
        Intrinsics.checkNotNullParameter(msgRecords, "msgRecords");
        Intrinsics.checkNotNullParameter(resp, "resp");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        StringBuilder sb5 = new StringBuilder("afterMsgPushNotify");
        for (MessageRecord messageRecord : msgRecords) {
            int i3 = messageRecord.msgtype;
            long j3 = serverTimeMillis - (messageRecord.time * 1000);
            sb5.append(";d=");
            sb5.append(j3);
            sb5.append(",tm=");
            sb5.append(messageRecord.time);
            sb5.append(",ty=");
            sb5.append(i3);
            sb5.append(",uid=");
            sb5.append(messageRecord.msgUid);
            sb5.append(",sh=");
            sb5.append(messageRecord.shmsgseq);
            sb5.append(",u=");
            sb5.append(messageRecord.frienduin);
            sb5.append(",ut=");
            sb5.append(messageRecord.istroop);
            sb5.append(",c=");
            sb5.append(messageRecord.getLogColorContent());
            contains = ArraysKt___ArraysKt.contains(RECORD_MSG_LIST, Integer.valueOf(i3));
            if (contains && j3 <= 600000 && j3 >= 0) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, MSG_TYPE_TRANS.get(Integer.valueOf(i3)));
                f.a(resp, arrayMap);
                d dVar = msgPushHistogram;
                if (dVar != null) {
                    dVar.c(j3, arrayMap);
                }
            }
        }
        QLog.d("QQMsgMetricRecorder", 1, sb5.toString());
    }

    @JvmStatic
    public static final void b() {
        QLog.d("QQMsgMetricRecorder", 1, "init");
        msgCounter = f.c().b("send_msg_total");
        msgHistogram = f.c().f("send_msg_duration", BUCKETS_SEND_TEXT_MSG);
        msgPushHistogram = f.c().f("push_msg_duration", BUCKETS_RECV_PUSH_MSG);
    }

    @JvmStatic
    public static final void c(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        boolean contains;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        int i3 = req.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, Integer.MAX_VALUE);
        contains = ArraysKt___ArraysKt.contains(RECORD_MSG_LIST, Integer.valueOf(i3));
        if (!contains) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQMsgMetricRecorder", 2, "onSendError");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("code", "-1");
        arrayMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, MSG_TYPE_TRANS.get(Integer.valueOf(i3)));
        f.a(resp, arrayMap);
        com.tencent.mobileqq.tianjige.metric.a aVar = msgCounter;
        if (aVar != null) {
            aVar.c(1L, arrayMap);
        }
    }

    public final void d(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) resp);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        int i3 = req.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, Integer.MAX_VALUE);
        contains = ArraysKt___ArraysKt.contains(RECORD_MSG_LIST, Integer.valueOf(i3));
        if (!contains) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQMsgMetricRecorder", 2, "onSendSuccess");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("code", "0");
        Map<Integer, String> map = MSG_TYPE_TRANS;
        arrayMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, map.get(Integer.valueOf(i3)));
        f.a(resp, arrayMap);
        com.tencent.mobileqq.tianjige.metric.a aVar = msgCounter;
        if (aVar != null) {
            aVar.c(1L, arrayMap);
        }
        long currentTimeMillis = System.currentTimeMillis() - req.extraData.getLong("msg_send_time", System.currentTimeMillis());
        if (currentTimeMillis > 480000) {
            return;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(QQHealthReportApiImpl.MSG_TYPE_KEY, map.get(Integer.valueOf(i3)));
        f.a(resp, arrayMap2);
        d dVar = msgHistogram;
        if (dVar != null) {
            dVar.c(currentTimeMillis, arrayMap2);
        }
    }
}
