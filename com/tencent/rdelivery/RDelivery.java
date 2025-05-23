package com.tencent.rdelivery;

import android.content.Context;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.data.DataManager;
import com.tencent.rdelivery.data.MultiProcessDataSynchronizer;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.a;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.report.TargetType;
import com.tencent.rdelivery.update.AbsUpdater;
import com.tencent.rdelivery.update.UpdateManager;
import com.tencent.rdelivery.util.RightlyHelper;
import com.tencent.rdelivery.util.d;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import iz3.e;
import iz3.f;
import iz3.l;
import iz3.n;
import iz3.p;
import iz3.r;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0003?pqB-\b\u0002\u0012\u0006\u0010f\u001a\u00020d\u0012\u0006\u0010i\u001a\u00020g\u0012\u0006\u0010l\u001a\u00020j\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bn\u0010oJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J(\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J(\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u001e\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 0\"2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\u0013J\u0012\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010&J!\u0010)\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010,\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020+J\u001c\u00100\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0-2\u0006\u0010\u0003\u001a\u00020/J\u0016\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u000202J\u001c\u00106\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130-2\u0006\u0010\u0003\u001a\u000205J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000207J\u000e\u00109\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010\nJ\u001c\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010>\u001a\u00020\u0004R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010VR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u0002070X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010YR\u0014\u0010]\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R \u0010a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010`R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010YR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010k\u00a8\u0006r"}, d2 = {"Lcom/tencent/rdelivery/RDelivery;", "", "Liz3/h;", "listener", "", "j", "B", "D", "Lcom/tencent/rdelivery/data/DataManager;", "o", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "readDiskWhenDataNotInited", BdhLogUtil.LogTag.Tag_Conn, "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "w", "", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", DomainData.DOMAIN_NAME, "Lorg/json/JSONObject;", "t", "Lorg/json/JSONArray;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/rdelivery/data/RDeliveryData;", "y", "", "l", "v", "u", "Liz3/e;", "G", "mergeReqId", "H", "(Liz3/e;J)V", "Liz3/p;", "J", "", "keys", "Liz3/l;", "I", WadlProxyConsts.SCENE_ID, "Liz3/b;", UserInfo.SEX_FEMALE, "taskIds", "Liz3/f;", "k", "Liz3/c;", "g", "E", "value", "K", "userId", "M", h.F, "a", "Lcom/tencent/rdelivery/data/DataManager;", "dataManager", "Lcom/tencent/rdelivery/net/g;", "b", "Lcom/tencent/rdelivery/net/g;", "requestManager", "Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer;", "c", "Lcom/tencent/rdelivery/data/MultiProcessDataSynchronizer;", "multiProcessDataSynchronizer", "Lcom/tencent/rdelivery/update/UpdateManager;", "d", "Lcom/tencent/rdelivery/update/UpdateManager;", "updateManager", "Lcom/tencent/rdelivery/util/c;", "e", "Lcom/tencent/rdelivery/util/c;", "logger", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "f", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "readwriteLock", "Liz3/h;", "dataInitListener", "", "Ljava/util/List;", "dataChangeListeners", "i", "Liz3/c;", "customDataChangeListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Liz3/n;", "Ljava/util/concurrent/ConcurrentHashMap;", "singleDataChangeListenerMap", "Liz3/r;", "userEventListeners", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/rdelivery/a;", "Lcom/tencent/rdelivery/a;", "dependencyInjector", "dataInitListenerFromHost", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/rdelivery/a;Liz3/h;)V", "InitBuglyAndUuidTask", "ReportStartUpTask", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDelivery {

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private static final Void f364090o = null;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private DataManager dataManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private g requestManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MultiProcessDataSynchronizer multiProcessDataSynchronizer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private UpdateManager updateManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.rdelivery.util.c logger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReentrantReadWriteLock readwriteLock;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final iz3.h dataInitListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<iz3.c> dataChangeListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final iz3.c customDataChangeListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, n> singleDataChangeListenerMap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final List<r> userEventListeners;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RDeliverySetting setting;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final a dependencyInjector;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rdelivery/RDelivery$InitBuglyAndUuidTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Landroid/content/Context;", "", TencentLocation.RUN_MODE, "Lcom/tencent/rdelivery/RDeliverySetting;", "d", "Lcom/tencent/rdelivery/RDeliverySetting;", "getSetting", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/RDeliverySetting;)V", "e", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class InitBuglyAndUuidTask extends IRTask.WeakReferenceTask<Context> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RDeliverySetting setting;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitBuglyAndUuidTask(@NotNull Context context, @NotNull RDeliverySetting setting) {
            super(context, "RDelivery_InitBuglyAndUuidTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            this.setting = setting;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object m476constructorimpl;
            com.tencent.rdelivery.util.c logger;
            Context it = getRef();
            if (it != null) {
                com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
                if (logger2 != null) {
                    com.tencent.rdelivery.util.c.b(logger2, "RDelivery_InitBuglyAndUuidTask", "InitBugly And Uuid in sub thread", false, 4, null);
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    com.tencent.rdelivery.util.a aVar = com.tencent.rdelivery.util.a.f364654d;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    aVar.g(it, this.setting);
                    RightlyHelper.f364646c.d(this.setting);
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null && (logger = this.setting.getLogger()) != null) {
                    logger.d(d.a("RDelivery_InitBuglyAndUuidTask", this.setting.getRdInstanceIdentifier()), "InitBuglyAndUuidTask err", m479exceptionOrNullimpl);
                }
                RDeliverySetting rDeliverySetting = this.setting;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                rDeliverySetting.O(it);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/RDelivery$ReportStartUpTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Landroid/content/Context;", "", TencentLocation.RUN_MODE, "Lcom/tencent/rdelivery/RDeliverySetting;", "d", "Lcom/tencent/rdelivery/RDeliverySetting;", "getSetting", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "e", "Z", "initSuccess", "", "f", "J", QCircleWeakNetReporter.KEY_COST, "context", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/RDeliverySetting;ZJ)V", h.F, "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class ReportStartUpTask extends IRTask.WeakReferenceTask<Context> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RDeliverySetting setting;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean initSuccess;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long cost;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReportStartUpTask(@NotNull Context context, @NotNull RDeliverySetting setting, boolean z16, long j3) {
            super(context, "RDelivery_ReportStartUpTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            this.setting = setting;
            this.initSuccess = z16;
            this.cost = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context it = getRef();
            if (it != null) {
                com.tencent.rdelivery.report.c cVar = com.tencent.rdelivery.report.c.f364376c;
                cVar.m(this.initSuccess, this.cost, this.setting);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                cVar.n(it, this.initSuccess, this.cost);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/RDelivery$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/rdelivery/a;", "injector", "Liz3/h;", "listener", "Lcom/tencent/rdelivery/RDelivery;", "a", "", "ENV_ID_PRODUCTION", "Ljava/lang/Void;", "b", "()Ljava/lang/Void;", "", "NAME_SEPARATOR", "Ljava/lang/String;", "REQUEST_TIME_STAMP", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.RDelivery$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final RDelivery a(@NotNull Context context, @NotNull RDeliverySetting setting, @NotNull a injector, @Nullable iz3.h listener) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            Intrinsics.checkParameterIsNotNull(injector, "injector");
            return new RDelivery(context, setting, injector, listener, null);
        }

        @Nullable
        public final Void b() {
            return RDelivery.f364090o;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/rdelivery/RDelivery$b", "Liz3/c;", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "oldData", "newData", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements iz3.c {
        b() {
        }

        @Override // iz3.c
        public void a(@NotNull String key, @Nullable RDeliveryData oldData, @Nullable RDeliveryData newData) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            n nVar = (n) RDelivery.this.singleDataChangeListenerMap.get(key);
            if (nVar != null) {
                nVar.a(oldData, newData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/RDelivery$c", "Liz3/h;", "", "onInitFinish", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c implements iz3.h {
        c() {
        }

        @Override // iz3.h
        public void onInitFinish() {
            com.tencent.rdelivery.util.c cVar = RDelivery.this.logger;
            if (cVar != null) {
                com.tencent.rdelivery.util.c.b(cVar, d.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, RDelivery.this.setting.getRdInstanceIdentifier()), "onInitFinish", false, 4, null);
            }
            UpdateManager updateManager = RDelivery.this.updateManager;
            if (updateManager != null) {
                updateManager.e(AbsUpdater.Event.SDK_INIT);
            }
        }
    }

    RDelivery(Context context, RDeliverySetting rDeliverySetting, a aVar, iz3.h hVar) {
        boolean z16;
        this.context = context;
        this.setting = rDeliverySetting;
        this.dependencyInjector = aVar;
        this.readwriteLock = new ReentrantReadWriteLock();
        this.dataInitListener = new c();
        this.dataChangeListeners = new CopyOnWriteArrayList();
        this.customDataChangeListener = new b();
        this.singleDataChangeListenerMap = new ConcurrentHashMap<>();
        this.userEventListeners = new CopyOnWriteArrayList();
        com.tencent.rdelivery.util.c cVar = new com.tencent.rdelivery.util.c(aVar.getLogInterface());
        this.logger = cVar;
        com.tencent.rdelivery.util.c.b(cVar, d.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, rDeliverySetting.getRdInstanceIdentifier()), "init start", false, 4, null);
        rDeliverySetting.e0(this.logger);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            j(hVar);
            z16 = true;
        } catch (Exception e16) {
            com.tencent.rdelivery.util.c cVar2 = this.logger;
            if (cVar2 != null) {
                cVar2.d(d.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, this.setting.getRdInstanceIdentifier()), "init failed", e16);
            }
            z16 = false;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        this.dependencyInjector.getTaskInterface().startTask(IRTask.TaskType.SIMPLE_TASK, new ReportStartUpTask(this.context, this.setting, z16, uptimeMillis2));
        com.tencent.rdelivery.util.c cVar3 = this.logger;
        if (cVar3 != null) {
            com.tencent.rdelivery.util.c.b(cVar3, d.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, this.setting.getRdInstanceIdentifier()), "init end cost = " + uptimeMillis2 + ",initSuccess = " + z16, false, 4, null);
        }
    }

    private final void B() {
        IRStorage iRStorage;
        DataManager dataManager;
        String b16 = this.setting.b();
        IRStorage dataStorage = this.dependencyInjector.getStorageFactory().createIRStorage(b16);
        if (this.setting.getEnableRecordLastRequestTime()) {
            iRStorage = this.dependencyInjector.getStorageFactory().createIRStorage(b16 + "_request_ts");
        } else {
            iRStorage = null;
        }
        if (this.setting.V()) {
            Intrinsics.checkExpressionValueIsNotNull(dataStorage, "dataStorage");
            dataManager = new com.tencent.rdelivery.data.b(dataStorage, this.dependencyInjector.getTaskInterface(), this.setting, iRStorage);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(dataStorage, "dataStorage");
            dataManager = new DataManager(dataStorage, this.dependencyInjector.getTaskInterface(), this.setting, iRStorage);
        }
        this.dataManager = dataManager;
        dataManager.e(this.dataInitListener);
    }

    private final void D(iz3.h listener) {
        DataManager dataManager = this.dataManager;
        if (dataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        dataManager.o();
        B();
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        DataManager dataManager2 = this.dataManager;
        if (dataManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        gVar.b(dataManager2);
        for (iz3.c cVar : this.dataChangeListeners) {
            DataManager dataManager3 = this.dataManager;
            if (dataManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataManager");
            }
            dataManager3.d(cVar);
        }
        for (r rVar : this.userEventListeners) {
            DataManager dataManager4 = this.dataManager;
            if (dataManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataManager");
            }
            dataManager4.f(rVar);
        }
        DataManager dataManager5 = this.dataManager;
        if (dataManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        dataManager5.E(listener);
    }

    public static /* synthetic */ void N(RDelivery rDelivery, String str, iz3.h hVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hVar = null;
        }
        rDelivery.M(str, hVar);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final RDelivery i(@NotNull Context context, @NotNull RDeliverySetting rDeliverySetting, @NotNull a aVar, @Nullable iz3.h hVar) {
        return INSTANCE.a(context, rDeliverySetting, aVar, hVar);
    }

    private final void j(iz3.h listener) {
        com.tencent.rdelivery.report.c.f364376c.f(this.context, this.dependencyInjector.getNetInterface());
        this.setting.N(this.dependencyInjector.getStorageFactory().createIRStorage("rdelivery_common_storage"));
        this.dependencyInjector.getTaskInterface().startTask(IRTask.TaskType.IO_TASK, new InitBuglyAndUuidTask(this.context, this.setting));
        B();
        g(this.customDataChangeListener);
        RDeliverySetting rDeliverySetting = this.setting;
        DataManager dataManager = this.dataManager;
        if (dataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        this.requestManager = new g(rDeliverySetting, dataManager, this.dependencyInjector.getNetInterface(), this.dependencyInjector.getTaskInterface(), this.context);
        Context context = this.context;
        RDeliverySetting rDeliverySetting2 = this.setting;
        IRTask taskInterface = this.dependencyInjector.getTaskInterface();
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        this.updateManager = new UpdateManager(context, rDeliverySetting2, taskInterface, gVar);
        DataManager dataManager2 = this.dataManager;
        if (dataManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        dataManager2.E(listener);
        if (this.setting.getEnableMultiProcessDataSync()) {
            g gVar2 = this.requestManager;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestManager");
            }
            this.multiProcessDataSynchronizer = new MultiProcessDataSynchronizer(gVar2, this.setting, this.context);
        }
    }

    private final DataManager o() {
        this.readwriteLock.readLock().lock();
        try {
            DataManager dataManager = this.dataManager;
            if (dataManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataManager");
            }
            return dataManager;
        } finally {
            this.readwriteLock.readLock().unlock();
        }
    }

    public static /* synthetic */ RDeliveryData z(RDelivery rDelivery, String str, RDeliveryData rDeliveryData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            rDeliveryData = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return rDelivery.y(str, rDeliveryData, z16);
    }

    @JvmOverloads
    @Nullable
    public final String A(@NotNull String key, @Nullable String defaultValue, boolean readDiskWhenDataNotInited) {
        String p16;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (p16 = u16.p()) != null) {
            return p16;
        }
        return defaultValue;
    }

    @JvmOverloads
    public final boolean C(@NotNull String key, boolean defaultValue, boolean readDiskWhenDataNotInited) {
        Boolean switchValue;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData t16 = o().t(key, TargetType.SWITCH, readDiskWhenDataNotInited);
        if (t16 != null && (switchValue = t16.getSwitchValue()) != null) {
            return switchValue.booleanValue();
        }
        return defaultValue;
    }

    public final void E(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.singleDataChangeListenerMap.remove(key);
    }

    public final void F(long sceneId, @NotNull iz3.b listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        gVar.c(sceneId, listener);
    }

    public final void G(@Nullable e listener) {
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        g.e(gVar, RDeliveryRequest.RequestSource.HOST_APP, listener, null, 4, null);
    }

    public final void H(@Nullable e listener, long mergeReqId) {
        if (this.setting.W()) {
            g gVar = this.requestManager;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestManager");
            }
            gVar.d(RDeliveryRequest.RequestSource.HOST_APP, listener, Long.valueOf(mergeReqId));
            return;
        }
        com.tencent.rdelivery.net.h.f364359c.c(mergeReqId, this.setting);
        g gVar2 = this.requestManager;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        g.e(gVar2, RDeliveryRequest.RequestSource.HOST_APP, listener, null, 4, null);
    }

    public final void I(@NotNull List<String> keys, @NotNull l listener) {
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        gVar.f(keys, listener);
    }

    public final void J(@NotNull String key, @NotNull p listener) {
        List<String> listOf;
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        g gVar = this.requestManager;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestManager");
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(key);
        gVar.f(listOf, listener);
    }

    public final void K(@NotNull String key, @Nullable String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.setting.f0(key, value);
    }

    @JvmOverloads
    public final void L(@NotNull String str) {
        N(this, str, null, 2, null);
    }

    @JvmOverloads
    public final void M(@NotNull String userId, @Nullable iz3.h listener) {
        Intrinsics.checkParameterIsNotNull(userId, "userId");
        this.readwriteLock.writeLock().lock();
        try {
            this.setting.g0(userId);
            D(listener);
        } finally {
            this.readwriteLock.writeLock().unlock();
        }
    }

    public final void g(@NotNull iz3.c listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataChangeListeners.add(listener);
        o().d(listener);
    }

    public final void h() {
        com.tencent.rdelivery.util.c cVar = this.logger;
        if (cVar != null) {
            com.tencent.rdelivery.util.c.b(cVar, d.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, this.setting.getRdInstanceIdentifier()), "clearAllCache", false, 4, null);
        }
        this.readwriteLock.writeLock().lock();
        try {
            DataManager dataManager = this.dataManager;
            if (dataManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataManager");
            }
            dataManager.l();
        } finally {
            this.readwriteLock.writeLock().unlock();
        }
    }

    public final void k(@NotNull List<Long> taskIds, @NotNull f listener) {
        Intrinsics.checkParameterIsNotNull(taskIds, "taskIds");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        a.Companion companion = com.tencent.rdelivery.net.a.INSTANCE;
        companion.e(companion.c(taskIds, this.setting, listener), this.dependencyInjector.getNetInterface(), this.setting);
    }

    @JvmOverloads
    @NotNull
    public final Map<String, RDeliveryData> l(boolean readDiskWhenDataNotInited) {
        return o().r(readDiskWhenDataNotInited);
    }

    @JvmOverloads
    public final boolean m(@NotNull String key, boolean defaultValue, boolean readDiskWhenDataNotInited) {
        Boolean b16;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (b16 = u16.b()) != null) {
            return b16.booleanValue();
        }
        return defaultValue;
    }

    @JvmOverloads
    @Nullable
    public final byte[] n(@NotNull String key, @Nullable byte[] defaultValue, boolean readDiskWhenDataNotInited) {
        byte[] c16;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (c16 = u16.c()) != null) {
            return c16;
        }
        return defaultValue;
    }

    @JvmOverloads
    public final double p(@NotNull String key, double defaultValue, boolean readDiskWhenDataNotInited) {
        Double g16;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (g16 = u16.g()) != null) {
            return g16.doubleValue();
        }
        return defaultValue;
    }

    @JvmOverloads
    public final float q(@NotNull String key, float defaultValue, boolean readDiskWhenDataNotInited) {
        Float h16;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (h16 = u16.h()) != null) {
            return h16.floatValue();
        }
        return defaultValue;
    }

    @JvmOverloads
    public final int r(@NotNull String key, int defaultValue, boolean readDiskWhenDataNotInited) {
        Integer j3;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (j3 = u16.j()) != null) {
            return j3.intValue();
        }
        return defaultValue;
    }

    @JvmOverloads
    @Nullable
    public final JSONArray s(@NotNull String key, @Nullable JSONArray defaultValue, boolean readDiskWhenDataNotInited) {
        JSONArray k3;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (k3 = u16.k()) != null) {
            return k3;
        }
        return defaultValue;
    }

    @JvmOverloads
    @Nullable
    public final JSONObject t(@NotNull String key, @Nullable JSONObject defaultValue, boolean readDiskWhenDataNotInited) {
        JSONObject l3;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (l3 = u16.l()) != null) {
            return l3;
        }
        return defaultValue;
    }

    public final long u() {
        DataManager dataManager = this.dataManager;
        if (dataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        return dataManager.y();
    }

    public final long v(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        DataManager dataManager = this.dataManager;
        if (dataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataManager");
        }
        return dataManager.z(key);
    }

    @JvmOverloads
    public final long w(@NotNull String key, long defaultValue, boolean readDiskWhenDataNotInited) {
        Long n3;
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData u16 = DataManager.u(o(), key, null, readDiskWhenDataNotInited, 2, null);
        if (u16 != null && (n3 = u16.n()) != null) {
            return n3.longValue();
        }
        return defaultValue;
    }

    @JvmOverloads
    @Nullable
    public final RDeliveryData x(@NotNull String str) {
        return z(this, str, null, false, 6, null);
    }

    @JvmOverloads
    @Nullable
    public final RDeliveryData y(@NotNull String key, @Nullable RDeliveryData defaultValue, boolean readDiskWhenDataNotInited) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData t16 = o().t(key, TargetType.CONFIG_SWITCH, readDiskWhenDataNotInited);
        if (t16 != null) {
            return t16;
        }
        return defaultValue;
    }

    public /* synthetic */ RDelivery(Context context, RDeliverySetting rDeliverySetting, a aVar, iz3.h hVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, rDeliverySetting, aVar, hVar);
    }
}
