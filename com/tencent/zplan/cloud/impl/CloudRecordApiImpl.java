package com.tencent.zplan.cloud.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.cloud.impl.CloudRecordApiImpl;
import com.tencent.zplan.cloud.record.api.Priority;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import dx4.CloudActionResult;
import dx4.CloudFailedResult;
import dx4.CloudForecastResult;
import ix4.e;
import ix4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0002@,B\u0007\u00a2\u0006\u0004\b=\u0010>J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J.\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0002J(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J2\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0002JD\u0010+\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J<\u0010,\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J:\u0010.\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u00100R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00100R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl;", "Lcom/tencent/zplan/cloud/record/api/a;", "", "jsonAction", "", "error", "message", "", "Ldx4/b;", "l", "Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl$ACTION;", "action", "", "Lix4/k;", "result", "Lcom/tencent/zplan/cloud/record/api/b;", "cloudRecordListener", "reqFrom", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl$ACTION;[Lix4/k;Lcom/tencent/zplan/cloud/record/api/b;I)V", "failedUserTaskList", DomainData.DOMAIN_NAME, "", "isCloudCache", "doneUserTaskList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startUserTaskList", "p", "actionId", "o", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "uin", "k", "Lcom/tencent/zplan/cloud/record/api/Priority;", "priority", ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "Lgx4/a;", "avatarCharacter", "maxWaitDuration", "recordScene", "r", "a", "appearanceKey", "j", "", "Ljava/util/Map;", "cloudRecordListenerForPushMap", "Ljava/lang/Runnable;", "b", "delayRunnableMap", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "Lay4/a;", "d", "Lay4/a;", "pushObserver", "<init>", "()V", "e", "ACTION", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class CloudRecordApiImpl implements com.tencent.zplan.cloud.record.api.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, com.tencent.zplan.cloud.record.api.b> cloudRecordListenerForPushMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Runnable> delayRunnableMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ay4.a pushObserver;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl$ACTION;", "", "(Ljava/lang/String;I)V", "CREATE", "BATCH", "PUSH", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public enum ACTION {
        CREATE,
        BATCH,
        PUSH
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/zplan/cloud/impl/CloudRecordApiImpl$b", "Lkx4/a;", "", "Lix4/k;", "result", "", "a", "([Lix4/k;)V", "", "error", "", "message", "onResultFailure", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements kx4.a<k[]> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.cloud.record.api.b f385247b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f385248c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f385249d;

        b(com.tencent.zplan.cloud.record.api.b bVar, int i3, String str) {
            this.f385247b = bVar;
            this.f385248c = i3;
            this.f385249d = str;
        }

        @Override // kx4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(@NotNull k[] result) {
            Intrinsics.checkNotNullParameter(result, "result");
            CloudRecordApiImpl.this.q(ACTION.BATCH, result, this.f385247b, this.f385248c);
        }

        @Override // kx4.a
        public void onResultFailure(int error, @Nullable String message) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "CloudRecordApiImpl", 1, "batchRecordMedia failed :: error == " + error + " , message == " + message, null, 8, null);
            }
            List<CloudFailedResult> l3 = CloudRecordApiImpl.this.l(this.f385249d, error, message);
            com.tencent.zplan.cloud.record.api.b bVar = this.f385247b;
            if (message == null) {
                message = "";
            }
            bVar.a(l3, error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/zplan/cloud/impl/CloudRecordApiImpl$c", "Lkx4/a;", "", "Lix4/k;", "result", "", "a", "([Lix4/k;)V", "", "error", "", "message", "onResultFailure", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements kx4.a<k[]> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.cloud.record.api.b f385251b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f385252c;

        c(com.tencent.zplan.cloud.record.api.b bVar, int i3) {
            this.f385251b = bVar;
            this.f385252c = i3;
        }

        @Override // kx4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(@NotNull k[] result) {
            Intrinsics.checkNotNullParameter(result, "result");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "CloudRecordApiImpl", 1, "batchRecordMedia success :: result size == " + result.length, null, 8, null);
            }
            CloudRecordApiImpl.this.q(ACTION.BATCH, result, this.f385251b, this.f385252c);
        }

        @Override // kx4.a
        public void onResultFailure(int error, @Nullable String message) {
            List<CloudFailedResult> emptyList;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "CloudRecordApiImpl", 1, "batchRecordMedia failed :: error == " + error + " , message == " + message, null, 8, null);
            }
            com.tencent.zplan.cloud.record.api.b bVar = this.f385251b;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (message == null) {
                message = "";
            }
            bVar.a(emptyList, error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/zplan/cloud/impl/CloudRecordApiImpl$d", "Lkx4/a;", "", "Lix4/k;", "result", "", "a", "([Lix4/k;)V", "", "error", "", "message", "onResultFailure", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements kx4.a<k[]> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.cloud.record.api.b f385254b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f385255c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f385256d;

        d(com.tencent.zplan.cloud.record.api.b bVar, int i3, String str) {
            this.f385254b = bVar;
            this.f385255c = i3;
            this.f385256d = str;
        }

        @Override // kx4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(@NotNull k[] result) {
            Intrinsics.checkNotNullParameter(result, "result");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "CloudRecordApiImpl", 1, "recordActionByCloud success :: result size == " + result.length, null, 8, null);
            }
            com.tencent.zplan.cloud.record.api.b bVar = this.f385254b;
            if (bVar != null) {
                CloudRecordApiImpl.this.q(ACTION.CREATE, result, bVar, this.f385255c);
            }
        }

        @Override // kx4.a
        public void onResultFailure(int error, @Nullable String message) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "CloudRecordApiImpl", 1, "recordActionByCloud failed :: error == " + error + " , message == " + message, null, 8, null);
            }
            List<CloudFailedResult> l3 = CloudRecordApiImpl.this.l(this.f385256d, error, message);
            com.tencent.zplan.cloud.record.api.b bVar = this.f385254b;
            if (bVar != null) {
                if (message == null) {
                    message = "";
                }
                bVar.a(l3, error, message);
            }
        }
    }

    public CloudRecordApiImpl() {
        ay4.a aVar = new ay4.a() { // from class: com.tencent.zplan.cloud.impl.CloudRecordApiImpl$pushObserver$1
            @Override // ay4.a
            public final void onReceive(final int i3, final byte[] bArr) {
                Handler handler;
                handler = CloudRecordApiImpl.this.handler;
                handler.post(new Runnable() { // from class: com.tencent.zplan.cloud.impl.CloudRecordApiImpl$pushObserver$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map map;
                        List mutableListOf;
                        Map map2;
                        Map map3;
                        Handler handler2;
                        Integer num;
                        LogUtil logUtil = LogUtil.f385285b;
                        d a16 = logUtil.a();
                        Unit unit = null;
                        if (a16 != null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("CloudPush :: cmdId:");
                            sb5.append(i3);
                            sb5.append(", data size:");
                            byte[] bArr2 = bArr;
                            if (bArr2 != null) {
                                num = Integer.valueOf(bArr2.length);
                            } else {
                                num = null;
                            }
                            sb5.append(num);
                            d.a.b(a16, "CloudRecordApiImpl", 1, sb5.toString(), null, 8, null);
                        }
                        hx4.a c16 = hx4.a.c(bArr);
                        Intrinsics.checkNotNullExpressionValue(c16, "MsgBody.parseFrom(buf)");
                        if (c16.f406572a == 4) {
                            k userTask = c16.f406573b.f406580d.f406581a;
                            d a17 = logUtil.a();
                            if (a17 != null) {
                                d.a.c(a17, "CloudRecordApiImpl", 1, "CloudPush :: taskId == " + userTask.f408950a, null, 8, null);
                            }
                            if (userTask.f408955f != 2) {
                                d a18 = logUtil.a();
                                if (a18 != null) {
                                    d.a.c(a18, "CloudRecordApiImpl", 1, "CloudPush :: task priority is " + userTask.f408955f + " , just return", null, 8, null);
                                    return;
                                }
                                return;
                            }
                            ex4.a aVar2 = ex4.a.f397351b;
                            String str = userTask.f408953d.f408938a;
                            Intrinsics.checkNotNullExpressionValue(str, "userTask.jsonParams.json");
                            int n3 = aVar2.n(str);
                            map = CloudRecordApiImpl.this.cloudRecordListenerForPushMap;
                            com.tencent.zplan.cloud.record.api.b bVar = (com.tencent.zplan.cloud.record.api.b) map.get(userTask.f408950a);
                            if (bVar != null) {
                                int i16 = userTask.f408970u;
                                if (i16 != 1) {
                                    if (i16 != 2) {
                                        d a19 = logUtil.a();
                                        if (a19 != null) {
                                            d.a.b(a19, "CloudRecordApiImpl", 1, "CloudPush :: unknown status", null, 8, null);
                                        }
                                    } else {
                                        CloudRecordApiImpl cloudRecordApiImpl = CloudRecordApiImpl.this;
                                        CloudRecordApiImpl.ACTION action = CloudRecordApiImpl.ACTION.PUSH;
                                        Intrinsics.checkNotNullExpressionValue(userTask, "userTask");
                                        cloudRecordApiImpl.o(n3, action, userTask, bVar);
                                    }
                                } else {
                                    CloudRecordApiImpl cloudRecordApiImpl2 = CloudRecordApiImpl.this;
                                    CloudRecordApiImpl.ACTION action2 = CloudRecordApiImpl.ACTION.PUSH;
                                    Intrinsics.checkNotNullExpressionValue(userTask, "userTask");
                                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(userTask);
                                    cloudRecordApiImpl2.m(false, action2, mutableListOf, bVar);
                                }
                                map2 = CloudRecordApiImpl.this.cloudRecordListenerForPushMap;
                                map2.remove(userTask.f408950a);
                                map3 = CloudRecordApiImpl.this.delayRunnableMap;
                                Runnable runnable = (Runnable) map3.remove(userTask.f408950a);
                                if (runnable != null) {
                                    handler2 = CloudRecordApiImpl.this.handler;
                                    handler2.removeCallbacks(runnable);
                                    unit = Unit.INSTANCE;
                                }
                                if (unit != null) {
                                    return;
                                }
                            }
                            d a26 = logUtil.a();
                            if (a26 != null) {
                                d.a.c(a26, "CloudRecordApiImpl", 1, "CloudPush :: maybe canceled by batch", null, 8, null);
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                    }
                });
            }
        };
        this.pushObserver = aVar;
        ay4.b.f27352d.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String taskId, int actionId, com.tencent.zplan.cloud.record.api.b cloudRecordListener, int reqFrom, String uin) {
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "CloudRecordApiImpl", 1, "batchRecordMedia start (\u8d85\u65f6):: actionId == " + actionId, null, 8, null);
        }
        kx4.b.f(new kx4.b(), taskId, 0, uin, new c(cloudRecordListener, reqFrom), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CloudFailedResult> l(String jsonAction, int error, String message) {
        String str;
        List<Integer> m3 = ex4.a.f397351b.m(jsonAction);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = m3.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (message == null) {
                str = "";
            } else {
                str = message;
            }
            arrayList.add(new CloudFailedResult(intValue, "", error, str));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean isCloudCache, ACTION action, List<k> doneUserTaskList, com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = doneUserTaskList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            ex4.a aVar = ex4.a.f397351b;
            String str2 = kVar.f408953d.f408938a;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.jsonParams.json");
            int n3 = aVar.n(str2);
            String str3 = kVar.D;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                str = kVar.f408967r;
            } else {
                str = kVar.D;
            }
            String result = str;
            String str4 = kVar.f408950a;
            Intrinsics.checkNotNullExpressionValue(str4, "userRecordTask.taskId");
            String str5 = kVar.f408961l;
            Intrinsics.checkNotNullExpressionValue(str5, "userRecordTask.taskHash");
            Priority t16 = t(kVar.f408955f);
            Intrinsics.checkNotNullExpressionValue(result, "result");
            int i3 = kVar.f408964o;
            String str6 = kVar.B;
            Intrinsics.checkNotNullExpressionValue(str6, "userRecordTask.appearanceKeySaved");
            String str7 = kVar.C;
            Intrinsics.checkNotNullExpressionValue(str7, "userRecordTask.appearanceKeyNewSaved");
            arrayList.add(new CloudActionResult(n3, str4, str5, t16, result, i3, str6, str7));
        }
        if (!arrayList.isEmpty()) {
            cloudRecordListener.c(isCloudCache, arrayList);
        }
    }

    private final void n(ACTION action, List<k> failedUserTaskList, com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        ArrayList arrayList = new ArrayList();
        for (k kVar : failedUserTaskList) {
            ex4.a aVar = ex4.a.f397351b;
            String str = kVar.f408953d.f408938a;
            Intrinsics.checkNotNullExpressionValue(str, "userRecordTask.jsonParams.json");
            int n3 = aVar.n(str);
            String str2 = kVar.f408950a;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.taskId");
            int i3 = kVar.f408965p;
            String str3 = kVar.f408966q;
            Intrinsics.checkNotNullExpressionValue(str3, "userRecordTask.errorMsg");
            CloudFailedResult cloudFailedResult = new CloudFailedResult(n3, str2, i3, str3);
            arrayList.add(cloudFailedResult);
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "CloudRecordApiImpl", 2, "cloudRecordListener(\u5931\u8d25\u5b50\u9879) :: action == " + action.name() + " , actionId == " + n3 + " ,taskHash == " + kVar.f408961l + TokenParser.SP + ",taskId == " + cloudFailedResult.getTaskId() + " , errorCode == " + cloudFailedResult.getErrorCode(), null, 8, null);
            }
        }
        if (!arrayList.isEmpty()) {
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.c(a17, "CloudRecordApiImpl", 1, "cloudRecordListener(\u5931\u8d25\u56de\u8c03\u603b\u6570) :: action == " + action.name() + " , onActionFailed size == " + arrayList.size(), null, 8, null);
            }
            cloudRecordListener.a(arrayList, -10, "some error exist in list");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int actionId, ACTION action, k result, com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.b(a16, "CloudRecordApiImpl", 1, "handleRecordFailed :: action == " + action.name() + " , actionId == " + actionId + " , errorCode == " + result.f408965p + " , errorMsg == " + result.f408966q, null, 8, null);
        }
        ArrayList arrayList = new ArrayList();
        String str = result.f408950a;
        Intrinsics.checkNotNullExpressionValue(str, "result.taskId");
        int i3 = result.f408965p;
        String str2 = result.f408966q;
        Intrinsics.checkNotNullExpressionValue(str2, "result.errorMsg");
        arrayList.add(new CloudFailedResult(actionId, str, i3, str2));
        int i16 = result.f408965p;
        String str3 = result.f408966q;
        Intrinsics.checkNotNullExpressionValue(str3, "result.errorMsg");
        cloudRecordListener.a(arrayList, i16, str3);
    }

    private final void p(final ACTION action, List<k> startUserTaskList, final com.tencent.zplan.cloud.record.api.b cloudRecordListener, final int reqFrom) {
        ArrayList arrayList;
        Iterator it;
        com.tencent.zplan.cloud.record.api.b bVar = cloudRecordListener;
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = startUserTaskList.iterator();
        while (it5.hasNext()) {
            final k kVar = (k) it5.next();
            ex4.a aVar = ex4.a.f397351b;
            String str = kVar.f408953d.f408938a;
            Intrinsics.checkNotNullExpressionValue(str, "userRecordTask.jsonParams.json");
            final int n3 = aVar.n(str);
            String str2 = kVar.f408953d.f408938a;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.jsonParams.json");
            String o16 = aVar.o(str2);
            arrayList2.add(new CloudForecastResult(n3, kVar.f408963n));
            LogUtil logUtil = LogUtil.f385285b;
            lx4.d a16 = logUtil.a();
            if (a16 != null) {
                d.a.c(a16, "CloudRecordApiImpl", 2, "handleStartTaskList(\u53d1\u8d77\u5f55\u5236\u5b50\u9879) :: action == " + action.name() + " , actionId == " + n3 + TokenParser.SP + ", priority == " + kVar.f408955f + ", mode == " + o16 + TokenParser.SP + ", taskId == " + kVar.f408950a, null, 8, null);
            }
            if (action != ACTION.BATCH) {
                long j3 = kVar.f408963n;
                if (j3 > 0 && kVar.f408955f == 2) {
                    Map<String, com.tencent.zplan.cloud.record.api.b> map = this.cloudRecordListenerForPushMap;
                    String str3 = kVar.f408950a;
                    Intrinsics.checkNotNullExpressionValue(str3, "userRecordTask.taskId");
                    map.put(str3, bVar);
                    it = it5;
                    final ArrayList arrayList3 = arrayList2;
                    arrayList = arrayList2;
                    Runnable runnable = new Runnable() { // from class: com.tencent.zplan.cloud.impl.CloudRecordApiImpl$handleStartTaskList$$inlined$forEach$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Map map2;
                            d a17 = LogUtil.f385285b.a();
                            if (a17 != null) {
                                d.a.c(a17, "CloudRecordApiImpl", 1, "start over time delay batch , actionId == " + n3, null, 8, null);
                            }
                            CloudRecordApiImpl cloudRecordApiImpl = this;
                            String str4 = kVar.f408950a;
                            Intrinsics.checkNotNullExpressionValue(str4, "userRecordTask.taskId");
                            cloudRecordApiImpl.k(str4, n3, cloudRecordListener, reqFrom, String.valueOf(kVar.f408971v));
                            map2 = this.cloudRecordListenerForPushMap;
                            map2.remove(kVar.f408950a);
                        }
                    };
                    Map<String, Runnable> map2 = this.delayRunnableMap;
                    String str4 = kVar.f408950a;
                    Intrinsics.checkNotNullExpressionValue(str4, "userRecordTask.taskId");
                    map2.put(str4, runnable);
                    this.handler.postDelayed(runnable, j3);
                    lx4.d a17 = logUtil.a();
                    if (a17 != null) {
                        d.a.c(a17, "CloudRecordApiImpl", 1, "start record action , actionId == " + n3 + TokenParser.SP + ", forecastDuration == " + kVar.f408963n, null, 8, null);
                    }
                } else {
                    arrayList = arrayList2;
                    it = it5;
                    lx4.d a18 = logUtil.a();
                    if (a18 != null) {
                        d.a.c(a18, "CloudRecordApiImpl", 1, "forecastDurationLong == " + j3, null, 8, null);
                    }
                }
                bVar = cloudRecordListener;
                it5 = it;
                arrayList2 = arrayList;
            }
        }
        ArrayList arrayList4 = arrayList2;
        if (!arrayList4.isEmpty()) {
            lx4.d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                d.a.c(a19, "CloudRecordApiImpl", 1, "cloudRecordListener(\u53d1\u8d77\u5f55\u5236\u56de\u8c03\u4e2a\u6570) :: action == " + action.name() + " , onActionStart size == " + arrayList4.size(), null, 8, null);
            }
            cloudRecordListener.b(arrayList4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(ACTION action, k[] result, com.tencent.zplan.cloud.record.api.b cloudRecordListener, int reqFrom) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (k kVar : result) {
            int i3 = kVar.f408970u;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        arrayList3.add(kVar);
                    }
                } else {
                    arrayList2.add(kVar);
                }
            } else {
                arrayList.add(kVar);
            }
        }
        m(true, action, arrayList2, cloudRecordListener);
        p(action, arrayList, cloudRecordListener, reqFrom);
        n(action, arrayList3, cloudRecordListener);
    }

    private final int s(Priority priority) {
        int i3 = a.f385260a[priority.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        return 0;
    }

    private final Priority t(int priority) {
        if (priority != 1) {
            if (priority != 2) {
                return Priority.OFFLINE_LOW;
            }
            return Priority.IMMEDIATE;
        }
        return Priority.OFFLINE_HIGH;
    }

    @Override // com.tencent.zplan.cloud.record.api.a
    public void a(@NotNull MemeZPlanBaseAction action, @Nullable gx4.a avatarCharacter, int maxWaitDuration, int recordScene, @NotNull Priority priority, @Nullable com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        r(action, avatarCharacter, maxWaitDuration, recordScene, 0, priority, cloudRecordListener);
    }

    public void j(@NotNull MemeZPlanBaseAction action, int recordScene, int reqFrom, @NotNull String appearanceKey, @Nullable gx4.a avatarCharacter, @NotNull com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        int i3;
        String str;
        String str2;
        String zPlanVersion;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(cloudRecordListener, "cloudRecordListener");
        kx4.b bVar = new kx4.b();
        String d16 = ex4.a.f397351b.d(action);
        if (avatarCharacter != null) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        e eVar = new e();
        eVar.f408938a = d16;
        Unit unit = Unit.INSTANCE;
        yx4.c cVar = (yx4.c) mx4.a.f417748a.a(yx4.c.class);
        if (cVar == null || (zPlanVersion = cVar.getZPlanVersion()) == null) {
            str = "";
        } else {
            str = zPlanVersion;
        }
        b bVar2 = new b(cloudRecordListener, reqFrom, d16);
        String senderUin = action.getSenderUin();
        if (senderUin == null) {
            str2 = "";
        } else {
            str2 = senderUin;
        }
        bVar.d(i3, eVar, reqFrom, str, recordScene, appearanceKey, avatarCharacter, bVar2, str2);
    }

    public void r(@NotNull MemeZPlanBaseAction action, @Nullable gx4.a avatarCharacter, int maxWaitDuration, int recordScene, int reqFrom, @NotNull Priority priority, @Nullable com.tencent.zplan.cloud.record.api.b cloudRecordListener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "CloudRecordApiImpl", 1, "recordActionByCloud start action == " + action.getIdDesc() + " , mode == " + action.getMode().name() + " ,  priority == " + priority, null, 8, null);
        }
        kx4.b bVar = new kx4.b();
        String d16 = ex4.a.f397351b.d(action);
        k kVar = new k();
        if (avatarCharacter != null) {
            kVar.f408952c = 3;
            kVar.f408960k = avatarCharacter;
        } else {
            kVar.f408952c = 1;
        }
        e eVar = new e();
        eVar.f408938a = d16;
        Unit unit = Unit.INSTANCE;
        kVar.f408953d = eVar;
        kVar.f408955f = s(priority);
        kVar.f408951b = recordScene;
        kVar.f408956g = maxWaitDuration;
        bVar.b(kVar, new d(cloudRecordListener, reqFrom, d16));
    }
}
