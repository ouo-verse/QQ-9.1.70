package com.tencent.rdelivery.data;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.report.TargetType;
import com.tencent.rdelivery.util.RightlyHelper;
import com.tencent.rdelivery.util.d;
import iz3.c;
import iz3.i;
import iz3.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 D2\u00020\u0001:\t\u0082\u0001Y\u0083\u0001\u0084\u0001\u0085\u0001B-\u0012\u0006\u0010u\u001a\u00020q\u0012\u0006\u0010x\u001a\u00020v\u0012\u0006\u0010}\u001a\u00020y\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010q\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u0014\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0002J,\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ&\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001c\u0010'\u001a\u00020\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030%H\u0016J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0003J\b\u0010.\u001a\u00020\u0013H\u0016J\u0016\u00100\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016JT\u00107\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003022\u0006\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00106\u001a\u00020\u001fJK\u0010;\u001a\u00020\f2\u0006\u00109\u001a\u0002082\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0003022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u0003022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b;\u0010<J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020\u0019J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J2\u0010@\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000302H\u0016J\u0016\u0010C\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J$\u0010H\u001a\u00020\f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010G\u001a\u00020FJ\u0018\u0010J\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u0007J\u001a\u0010K\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010I\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020LJ\u000e\u0010O\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020NJ\u000e\u0010P\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010Q\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010R\u001a\u00020\fJ\u001a\u0010T\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\b\u0010S\u001a\u0004\u0018\u00010\u0003H\u0004J\u0006\u0010U\u001a\u00020\fJ\u001c\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030V2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0011\u0010X\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\bX\u0010\u001bR\u0016\u0010[\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR$\u0010a\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R.\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030%8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR4\u0010l\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030ij\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003`j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010kR\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010^R\u0018\u00105\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010^R\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020L028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010mR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020N028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010mR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u000e028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010mR\u001a\u0010u\u001a\u00020q8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bK\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010wR\u001a\u0010}\u001a\u00020y8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bU\u0010z\u001a\u0004\b{\u0010|R\u001c\u0010\u007f\u001a\u0004\u0018\u00010q8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010r\u001a\u0004\b~\u0010t\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager;", "", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "list", "Lcom/tencent/rdelivery/data/DataManager$CfgChangeType;", "changeType", "", ReportConstant.COSTREPORT_PREFIX, "key", "oldData", "newData", "", "H", "Liz3/h;", "listener", "G", "Lkotlin/Pair;", "", "", "p", "context", "updatedDatas", "deletedDataKeys", "U", "", h.F, "()Ljava/lang/Long;", "E", "Lcom/tencent/rdelivery/report/TargetType;", "targetType", "", "readDiskWhenDataNotInited", "t", "B", "v", "K", "Ljava/util/concurrent/ConcurrentHashMap;", "newDataMap", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "left", "right", "i", UserInfo.SEX_FEMALE, "datas", "P", "remainedDatas", "", "deletedDatas", "userId", "logicEnvironment", "isOverwrite", "O", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "serverTime", "T", "(Lcom/tencent/rdelivery/net/RDeliveryRequest;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ExifInterface.LATITUDE_SOUTH, "g", "oldRespJsonStr", "newHitSubTaskID", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "dataList", "", "batchCount", "M", "logMsg", "k", "j", "Liz3/c;", "d", "Liz3/r;", "f", "e", "L", "o", "data", "I", "l", "", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "Z", "initialized", "<set-?>", "b", "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/lang/String;", "serverContext", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "w", "()Ljava/util/concurrent/ConcurrentHashMap;", "N", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "dataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "fixedAfterHitDataMap", "Ljava/util/List;", "dataChangeListeners", "userEventListeners", "dataInitListeners", "Lcom/tencent/raft/standard/storage/IRStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", HippyTKDListViewAdapter.X, "()Lcom/tencent/raft/standard/storage/IRStorage;", "dataStorage", "Lcom/tencent/raft/standard/task/IRTask;", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "D", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "getRequestTimeStorage", "requestTimeStorage", "<init>", "(Lcom/tencent/raft/standard/storage/IRStorage;Lcom/tencent/raft/standard/task/IRTask;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/raft/standard/storage/IRStorage;)V", "CfgChangeType", "InitLocalDataTask", "NotifyUserEventTask", "UpdateLocalStorageTask", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class DataManager {

    /* renamed from: n */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private volatile boolean initialized;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private String serverContext;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private volatile ConcurrentHashMap<String, RDeliveryData> dataMap;

    /* renamed from: d, reason: from kotlin metadata */
    private final HashMap<String, RDeliveryData> fixedAfterHitDataMap;

    /* renamed from: e, reason: from kotlin metadata */
    private String userId;

    /* renamed from: f, reason: from kotlin metadata */
    private String logicEnvironment;

    /* renamed from: g, reason: from kotlin metadata */
    private final List<c> dataChangeListeners;

    /* renamed from: h */
    private final List<r> userEventListeners;

    /* renamed from: i, reason: from kotlin metadata */
    private final List<iz3.h> dataInitListeners;

    /* renamed from: j, reason: from kotlin metadata */
    @NotNull
    private final IRStorage dataStorage;

    /* renamed from: k, reason: from kotlin metadata */
    private final IRTask taskInterface;

    /* renamed from: l, reason: from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* renamed from: m */
    @Nullable
    private final IRStorage requestTimeStorage;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$CfgChangeType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", QzoneDataUpdateAction.UPDATE, "DELETE", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum CfgChangeType {
        UPDATE(0),
        DELETE(1);

        private final int value;

        CfgChangeType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$InitLocalDataTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/data/DataManager;", "", TencentLocation.RUN_MODE, "Liz3/h;", "d", "Liz3/h;", "getListener", "()Liz3/h;", "listener", "dataManager", "<init>", "(Lcom/tencent/rdelivery/data/DataManager;Liz3/h;)V", "e", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class InitLocalDataTask extends IRTask.WeakReferenceTask<DataManager> {

        /* renamed from: d, reason: from kotlin metadata */
        @Nullable
        private final iz3.h listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitLocalDataTask(@NotNull DataManager dataManager, @Nullable iz3.h hVar) {
            super(dataManager, "RDelivery_InitLocalDataTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
            this.listener = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataManager ref = getRef();
            if (ref != null) {
                ref.G(this.listener);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B!\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$NotifyUserEventTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/data/DataManager;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "e", "Lcom/tencent/rdelivery/data/RDeliveryData;", "getData", "()Lcom/tencent/rdelivery/data/RDeliveryData;", "data", "dataManager", "<init>", "(Lcom/tencent/rdelivery/data/DataManager;Ljava/lang/String;Lcom/tencent/rdelivery/data/RDeliveryData;)V", "f", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class NotifyUserEventTask extends IRTask.WeakReferenceTask<DataManager> {

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final String key;

        /* renamed from: e, reason: from kotlin metadata */
        @Nullable
        private final RDeliveryData data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyUserEventTask(@NotNull DataManager dataManager, @NotNull String key, @Nullable RDeliveryData rDeliveryData) {
            super(dataManager, "RDelivery_InitLocalDataTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.key = key;
            this.data = rDeliveryData;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            DataManager ref = getRef();
            if (ref != null && (list = ref.userEventListeners) != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).a(this.key, this.data);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B3\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$UpdateLocalStorageTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/data/DataManager;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "serverContext", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "e", "Ljava/util/List;", "updatedDatas", "f", "deletedDataKeys", "dataManager", "<init>", "(Lcom/tencent/rdelivery/data/DataManager;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", h.F, "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class UpdateLocalStorageTask extends IRTask.WeakReferenceTask<DataManager> {

        /* renamed from: h */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: from kotlin metadata */
        private final String serverContext;

        /* renamed from: e, reason: from kotlin metadata */
        private final List<RDeliveryData> updatedDatas;

        /* renamed from: f, reason: from kotlin metadata */
        private final List<String> deletedDataKeys;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$UpdateLocalStorageTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.data.DataManager$UpdateLocalStorageTask$a */
        /* loaded from: classes25.dex */
        public static final class Companion {
            Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateLocalStorageTask(@NotNull DataManager dataManager, @NotNull String serverContext, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<String> deletedDataKeys) {
            super(dataManager, "RDelivery_UpdateLocalStorageTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
            Intrinsics.checkParameterIsNotNull(serverContext, "serverContext");
            Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
            Intrinsics.checkParameterIsNotNull(deletedDataKeys, "deletedDataKeys");
            this.serverContext = serverContext;
            this.updatedDatas = updatedDatas;
            this.deletedDataKeys = deletedDataKeys;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataManager ref = getRef();
            if (ref != null) {
                ref.U(this.serverContext, this.updatedDatas, this.deletedDataKeys);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rdelivery/data/DataManager$a;", "", "", "CONTROL_INFO_KEY_SERVER_CONTEXT", "Ljava/lang/String;", "KEY_FULL_REQUEST_TS", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.data.DataManager$a */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DataManager(@NotNull IRStorage dataStorage, @NotNull IRTask taskInterface, @NotNull RDeliverySetting setting, @Nullable IRStorage iRStorage) {
        Intrinsics.checkParameterIsNotNull(dataStorage, "dataStorage");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        this.dataStorage = dataStorage;
        this.taskInterface = taskInterface;
        this.setting = setting;
        this.requestTimeStorage = iRStorage;
        this.serverContext = "";
        this.dataMap = new ConcurrentHashMap<>();
        this.fixedAfterHitDataMap = new HashMap<>();
        this.userId = "";
        this.dataChangeListeners = new CopyOnWriteArrayList();
        this.userEventListeners = new CopyOnWriteArrayList();
        this.dataInitListeners = new CopyOnWriteArrayList();
        this.userId = setting.getUserId();
        this.logicEnvironment = setting.getLogicEnvironment();
    }

    public final void G(iz3.h listener) {
        boolean z16;
        long uptimeMillis = SystemClock.uptimeMillis();
        double d16 = 0.0d;
        try {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (this.setting.W()) {
                this.dataStorage.lock();
            }
            d16 = F();
            String string = this.dataStorage.getString("mmkv_special_key_for_rdelivery_server_context", "");
            Intrinsics.checkExpressionValueIsNotNull(string, "dataStorage.getString(CO\u2026O_KEY_SERVER_CONTEXT, \"\")");
            this.serverContext = string;
            if (this.setting.W()) {
                this.dataStorage.unlock();
            }
            long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                String a16 = d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadDataFromDisk cost = ");
                sb5.append(uptimeMillis3);
                sb5.append(", threadId = ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getId());
                logger.a(a16, sb5.toString(), this.setting.getEnableDetailLog());
            }
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "loadDataFromDisk serverContext = " + this.serverContext, this.setting.getEnableDetailLog());
            }
            z16 = true;
        } catch (Exception e16) {
            com.tencent.rdelivery.util.c logger3 = this.setting.getLogger();
            if (logger3 != null) {
                logger3.d(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "loadDataFromDisk exception", e16);
            }
            z16 = false;
        }
        this.initialized = z16;
        Iterator<T> it = this.dataInitListeners.iterator();
        while (it.hasNext()) {
            ((iz3.h) it.next()).onInitFinish();
        }
        if (listener != null) {
            listener.onInitFinish();
        }
        long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis;
        com.tencent.rdelivery.util.c logger4 = this.setting.getLogger();
        if (logger4 != null) {
            com.tencent.rdelivery.util.c.f(logger4, d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "loadDataFromDisk loadResult = " + z16 + ", cost = " + uptimeMillis4 + ", dataMap.size = " + this.dataMap.size() + ", memSize = " + d16, false, 4, null);
        }
    }

    private final void H(String key, RDeliveryData oldData, RDeliveryData newData) {
        Iterator<T> it = this.dataChangeListeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(key, oldData, newData);
        }
    }

    public final void U(String context, List<RDeliveryData> updatedDatas, List<String> deletedDataKeys) {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "updateLocalStorage start", this.setting.getEnableDetailLog());
        }
        this.dataStorage.lock();
        Iterator<String> it = deletedDataKeys.iterator();
        while (it.hasNext()) {
            this.dataStorage.remove(it.next());
        }
        for (RDeliveryData rDeliveryData : updatedDatas) {
            this.dataStorage.putString(rDeliveryData.getKey(), rDeliveryData.getResponseJsonString());
        }
        if (!TextUtils.isEmpty(context)) {
            this.dataStorage.putString("mmkv_special_key_for_rdelivery_server_context", context);
        } else {
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "updateLocalStorage ignore empty context", this.setting.getEnableDetailLog());
            }
        }
        this.dataStorage.unlock();
        i localStorageUpdateListener = this.setting.getLocalStorageUpdateListener();
        if (localStorageUpdateListener != null) {
            localStorageUpdateListener.a();
        }
        com.tencent.rdelivery.util.c logger3 = this.setting.getLogger();
        if (logger3 != null) {
            logger3.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "updateLocalStorage end", this.setting.getEnableDetailLog());
        }
    }

    private final Long h() {
        RDeliveryData rDeliveryData;
        String str;
        RDeliveryData value;
        try {
            Iterator<Map.Entry<String, RDeliveryData>> it = this.dataMap.entrySet().iterator();
            long j3 = 0;
            rDeliveryData = null;
            while (it.hasNext()) {
                try {
                    value = it.next().getValue();
                } catch (NumberFormatException e16) {
                    e = e16;
                }
                try {
                    if (!TextUtils.isEmpty(value.getHitSubTaskID())) {
                        j3 += Long.parseLong(value.getHitSubTaskID());
                    }
                    rDeliveryData = value;
                } catch (NumberFormatException e17) {
                    e = e17;
                    rDeliveryData = value;
                    com.tencent.rdelivery.util.c logger = this.setting.getLogger();
                    if (logger == null) {
                        return null;
                    }
                    String a16 = d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("calcuTaskCheckSum err, key = ");
                    if (rDeliveryData != null) {
                        str = rDeliveryData.getKey();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    logger.d(a16, sb5.toString(), e);
                    return null;
                }
            }
            return Long.valueOf(j3);
        } catch (NumberFormatException e18) {
            e = e18;
            rDeliveryData = null;
        }
    }

    private final Pair<Map<String, RDeliveryData>, Double> p() {
        int i3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] allKeys = this.dataStorage.allKeys();
        double d16 = 0.0d;
        if (allKeys != null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : allKeys) {
                if (!Intrinsics.areEqual(str, "mmkv_special_key_for_rdelivery_server_context")) {
                    arrayList.add(str);
                }
            }
            for (String str2 : arrayList) {
                com.tencent.rdelivery.util.c logger = this.setting.getLogger();
                if (logger != null) {
                    logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "doLoadAllRDeliveryDatasFromDisc it key = " + str2, this.setting.getEnableDetailLog());
                }
                String string = this.dataStorage.getString(str2, null);
                if (string != null) {
                    try {
                        RDeliveryData a16 = g.INSTANCE.a(new JSONObject(string), this.setting.getRdInstanceIdentifier(), this.setting.getLogger(), this.setting.getEnableDetailLog());
                        linkedHashMap.put(a16.getKey(), a16);
                        String responseJsonString = a16.getResponseJsonString();
                        if (responseJsonString != null) {
                            i3 = responseJsonString.length();
                        } else {
                            i3 = 0;
                        }
                        d16 += (i3 * 2.0d) / 1024;
                        Unit unit = Unit.INSTANCE;
                    } catch (Exception e16) {
                        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
                        if (logger2 != null) {
                            logger2.d(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "doLoadAllRDeliveryDatasFromDisc Exception", e16);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        return new Pair<>(linkedHashMap, Double.valueOf(d16));
    }

    private final String s(List<RDeliveryData> list, CfgChangeType cfgChangeType) {
        String hitSubTaskID;
        String hitSubTaskID2;
        StringBuilder sb5 = new StringBuilder();
        for (RDeliveryData rDeliveryData : list) {
            int i3 = a.f364217b[cfgChangeType.ordinal()];
            String str = "0";
            if (i3 != 1) {
                if (i3 != 2) {
                    str = "";
                    hitSubTaskID = "";
                } else {
                    str = rDeliveryData.getHitSubTaskID();
                    hitSubTaskID = "0";
                }
            } else {
                RDeliveryData rDeliveryData2 = this.dataMap.get(rDeliveryData.getKey());
                if (rDeliveryData2 != null && (hitSubTaskID2 = rDeliveryData2.getHitSubTaskID()) != null) {
                    str = hitSubTaskID2;
                }
                hitSubTaskID = rDeliveryData.getHitSubTaskID();
            }
            sb5.append(rDeliveryData.getKey());
            sb5.append("|");
            sb5.append(str);
            sb5.append("|");
            sb5.append(hitSubTaskID);
            sb5.append(",");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "cfgInfo.toString()");
        return sb6;
    }

    public static /* synthetic */ RDeliveryData u(DataManager dataManager, String str, TargetType targetType, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                targetType = TargetType.CONFIG;
            }
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return dataManager.t(str, targetType, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDataByKey");
    }

    @Nullable
    public Long A() {
        return h();
    }

    @Nullable
    public final RDeliveryData B(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (this.dataMap.containsKey(key)) {
            return this.dataMap.get(key);
        }
        return null;
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final String getServerContext() {
        return this.serverContext;
    }

    @NotNull
    /* renamed from: D, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }

    public final void E(@Nullable iz3.h listener) {
        this.taskInterface.startTask(IRTask.TaskType.IO_TASK, new InitLocalDataTask(this, listener));
    }

    public double F() {
        Pair<Map<String, RDeliveryData>, Double> p16 = p();
        this.dataMap.putAll(p16.getFirst());
        double doubleValue = p16.getSecond().doubleValue();
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "loadAllRDeliveryDatasFromDisc configCount = " + this.dataMap.size() + ",memSize = " + doubleValue, this.setting.getEnableDetailLog());
        }
        return doubleValue;
    }

    public final void I(@NotNull String key, @Nullable RDeliveryData data) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RightlyHelper.f364646c.f(key, data, SystemClock.elapsedRealtime(), this.setting, this.taskInterface);
        if (this.userEventListeners.isEmpty()) {
            return;
        }
        this.taskInterface.startTask(IRTask.TaskType.SIMPLE_TASK, new NotifyUserEventTask(this, key, data));
    }

    public void J() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.dataMap);
        ConcurrentHashMap<String, RDeliveryData> concurrentHashMap2 = new ConcurrentHashMap<>();
        concurrentHashMap2.putAll(p().getFirst());
        R(concurrentHashMap2);
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.e(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "reloadAllRDeliveryDatasFromDisc configCount = " + this.dataMap.size(), this.setting.getEnableDetailLog());
        }
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            RDeliveryData rDeliveryData = (RDeliveryData) entry.getValue();
            if (!this.dataMap.containsKey(str)) {
                H(str, rDeliveryData, null);
            }
        }
        for (Map.Entry<String, RDeliveryData> entry2 : this.dataMap.entrySet()) {
            String key = entry2.getKey();
            RDeliveryData value = entry2.getValue();
            if (!concurrentHashMap.containsKey(key)) {
                H(key, null, value);
            } else {
                RDeliveryData rDeliveryData2 = (RDeliveryData) concurrentHashMap.get(key);
                RDeliveryData rDeliveryData3 = this.dataMap.get(key);
                if (!i(rDeliveryData2, rDeliveryData3)) {
                    H(key, rDeliveryData2, rDeliveryData3);
                }
            }
        }
    }

    @Nullable
    public RDeliveryData K(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData rDeliveryData = this.dataMap.get(key);
        RDeliveryData v3 = v(key);
        if (v3 == null) {
            this.dataMap.remove(key);
        } else {
            Q(key, v3);
        }
        if (!i(rDeliveryData, v3)) {
            H(key, rDeliveryData, v3);
        }
        return v3;
    }

    public final void L(@NotNull iz3.h listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataInitListeners.remove(listener);
    }

    public final void M(@NotNull List<RDeliveryData> dataList, @NotNull CfgChangeType changeType, int batchCount) {
        IntRange until;
        IntProgression step;
        Intrinsics.checkParameterIsNotNull(dataList, "dataList");
        Intrinsics.checkParameterIsNotNull(changeType, "changeType");
        if (!this.setting.getIsCfgChangeReport()) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "reportChangedCfg return for isCfgChangeReport is false", this.setting.getEnableDetailLog());
                return;
            }
            return;
        }
        int size = dataList.size();
        until = RangesKt___RangesKt.until(0, size);
        step = RangesKt___RangesKt.step(until, batchCount);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 >= 0) {
            if (first > last) {
                return;
            }
        } else if (first < last) {
            return;
        }
        while (true) {
            int i3 = first + batchCount;
            if (i3 > size) {
                i3 = size;
            }
            String s16 = s(dataList.subList(first, i3), changeType);
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "reportChangedCfg for " + first + ',' + changeType + " cfgInfo = " + s16, this.setting.getEnableDetailLog());
            }
            com.tencent.rdelivery.report.c.f364376c.j(s16, this.setting);
            if (first != last) {
                first += step2;
            } else {
                return;
            }
        }
    }

    public final void N(@NotNull ConcurrentHashMap<String, RDeliveryData> concurrentHashMap) {
        Intrinsics.checkParameterIsNotNull(concurrentHashMap, "<set-?>");
        this.dataMap = concurrentHashMap;
    }

    public final void O(@NotNull String context, @NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas, @NotNull String userId, @Nullable String logicEnvironment, boolean isOverwrite) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
        Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
        Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
        Intrinsics.checkParameterIsNotNull(userId, "userId");
        if (k(userId, "updateContextAndData") || j(logicEnvironment, "updateContextAndData")) {
            return;
        }
        if (isOverwrite) {
            l();
        }
        g(remainedDatas, updatedDatas, deletedDatas);
        if (!TextUtils.isEmpty(context)) {
            this.serverContext = context;
        } else {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "updateContextAndData ignore empty context", this.setting.getEnableDetailLog());
            }
        }
        List<RDeliveryData> S = S(remainedDatas);
        P(updatedDatas);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(S);
        arrayList.addAll(updatedDatas);
        this.taskInterface.startTask(IRTask.TaskType.IO_TASK, new UpdateLocalStorageTask(this, context, arrayList, n(deletedDatas)));
    }

    public void P(@NotNull List<RDeliveryData> datas) {
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        M(datas, CfgChangeType.UPDATE, 50);
        for (RDeliveryData rDeliveryData : datas) {
            RDeliveryData rDeliveryData2 = this.dataMap.get(rDeliveryData.getKey());
            Q(rDeliveryData.getKey(), rDeliveryData);
            H(rDeliveryData.getKey(), rDeliveryData2, rDeliveryData);
        }
    }

    public void Q(@NotNull String key, @NotNull RDeliveryData newData) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(newData, "newData");
        this.dataMap.put(key, newData);
    }

    public void R(@NotNull ConcurrentHashMap<String, RDeliveryData> newDataMap) {
        Intrinsics.checkParameterIsNotNull(newDataMap, "newDataMap");
        this.dataMap = newDataMap;
    }

    @NotNull
    public List<RDeliveryData> S(@NotNull List<RDeliveryData> datas) {
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        ArrayList<RDeliveryData> arrayList = new ArrayList();
        for (RDeliveryData rDeliveryData : datas) {
            RDeliveryData rDeliveryData2 = this.dataMap.get(rDeliveryData.getKey());
            String hitSubTaskID = rDeliveryData.getHitSubTaskID();
            if (rDeliveryData2 != null && !TextUtils.isEmpty(hitSubTaskID) && (!Intrinsics.areEqual(rDeliveryData2.getHitSubTaskID(), hitSubTaskID))) {
                arrayList.add(rDeliveryData);
            }
        }
        M(arrayList, CfgChangeType.UPDATE, 50);
        ArrayList arrayList2 = new ArrayList();
        for (RDeliveryData rDeliveryData3 : arrayList) {
            RDeliveryData rDeliveryData4 = this.dataMap.get(rDeliveryData3.getKey());
            String hitSubTaskID2 = rDeliveryData3.getHitSubTaskID();
            if (rDeliveryData4 != null) {
                rDeliveryData4.v(hitSubTaskID2);
                String responseJsonString = rDeliveryData4.getResponseJsonString();
                if (responseJsonString == null) {
                    responseJsonString = "";
                }
                rDeliveryData4.w(q(responseJsonString, hitSubTaskID2));
                arrayList2.add(rDeliveryData4);
            }
        }
        return arrayList2;
    }

    public final void T(@NotNull RDeliveryRequest r46, @NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas, @Nullable Long serverTime) {
        Intrinsics.checkParameterIsNotNull(r46, "request");
        Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
        Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
        Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
        if (this.setting.getEnableRecordLastRequestTime() && serverTime != null) {
            int i3 = a.f364216a[r46.getPullType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        for (RDeliveryData rDeliveryData : remainedDatas) {
                            IRStorage iRStorage = this.requestTimeStorage;
                            if (iRStorage != null) {
                                iRStorage.putLong(rDeliveryData.getKey(), serverTime.longValue());
                            }
                        }
                        for (RDeliveryData rDeliveryData2 : updatedDatas) {
                            IRStorage iRStorage2 = this.requestTimeStorage;
                            if (iRStorage2 != null) {
                                iRStorage2.putLong(rDeliveryData2.getKey(), serverTime.longValue());
                            }
                        }
                        for (RDeliveryData rDeliveryData3 : deletedDatas) {
                            IRStorage iRStorage3 = this.requestTimeStorage;
                            if (iRStorage3 != null) {
                                iRStorage3.putLong(rDeliveryData3.getKey(), serverTime.longValue());
                            }
                        }
                        return;
                    }
                    return;
                }
                List<String> l3 = r46.l();
                if (l3 != null) {
                    for (String str : l3) {
                        IRStorage iRStorage4 = this.requestTimeStorage;
                        if (iRStorage4 != null) {
                            iRStorage4.putLong(str, serverTime.longValue());
                        }
                    }
                    return;
                }
                return;
            }
            IRStorage iRStorage5 = this.requestTimeStorage;
            if (iRStorage5 != null) {
                iRStorage5.putLong("mmkv_special_key_for_full_request_time_stamp", serverTime.longValue());
            }
        }
    }

    public final void d(@NotNull c listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataChangeListeners.add(listener);
    }

    public final void e(@NotNull iz3.h listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataInitListeners.add(listener);
    }

    public final void f(@NotNull r listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.userEventListeners.add(listener);
    }

    public void g(@NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas) {
        Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
        Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
        Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
        if (this.setting.X()) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "adjustDeletedDatas start deletedDatas = " + deletedDatas, this.setting.getEnableDetailLog());
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = remainedDatas.iterator();
            while (it.hasNext()) {
                arrayList.add(((RDeliveryData) it.next()).getKey());
            }
            Iterator<T> it5 = updatedDatas.iterator();
            while (it5.hasNext()) {
                arrayList.add(((RDeliveryData) it5.next()).getKey());
            }
            for (Map.Entry<String, RDeliveryData> entry : this.dataMap.entrySet()) {
                String key = entry.getKey();
                RDeliveryData value = entry.getValue();
                if (!arrayList.contains(key)) {
                    deletedDatas.add(value);
                }
            }
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "adjustDeletedDatas end deletedDatas = " + deletedDatas, this.setting.getEnableDetailLog());
            }
        }
    }

    public final boolean i(@Nullable RDeliveryData left, @Nullable RDeliveryData right) {
        if ((left != null && right != null && Intrinsics.areEqual(left.getResponseJsonString(), right.getResponseJsonString())) || (left == null && right == null)) {
            return true;
        }
        return false;
    }

    public final boolean j(@Nullable String logicEnvironment, @NotNull String logMsg) {
        Intrinsics.checkParameterIsNotNull(logMsg, "logMsg");
        if (!Intrinsics.areEqual(this.logicEnvironment, logicEnvironment)) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.c(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "checkIllegalEnvType " + logMsg + " illegal envType");
            }
            return true;
        }
        return false;
    }

    public final boolean k(@NotNull String userId, @NotNull String logMsg) {
        Intrinsics.checkParameterIsNotNull(userId, "userId");
        Intrinsics.checkParameterIsNotNull(logMsg, "logMsg");
        if (!Intrinsics.areEqual(this.userId, userId)) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.c(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "checkIllegalUserId " + logMsg + " illegal userId");
            }
            return true;
        }
        return false;
    }

    public final void l() {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "clearAllCache called, enableClearAllOptimize = " + this.setting.getEnableClearAllOptimize(), this.setting.getEnableDetailLog());
        }
        this.dataStorage.lock();
        if (this.setting.getEnableClearAllOptimize()) {
            this.dataStorage.clear();
        } else {
            String[] allKeys = this.dataStorage.allKeys();
            if (allKeys != null) {
                for (String str : allKeys) {
                    this.dataStorage.remove(str);
                }
            }
        }
        this.dataStorage.unlock();
        m();
        this.serverContext = "";
        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
        if (logger2 != null) {
            logger2.a(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "clearAllCache finish", this.setting.getEnableDetailLog());
        }
    }

    public void m() {
        this.dataMap.clear();
    }

    @NotNull
    public List<String> n(@NotNull List<RDeliveryData> datas) {
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RDeliveryData rDeliveryData : datas) {
            RDeliveryData rDeliveryData2 = this.dataMap.get(rDeliveryData.getKey());
            if (rDeliveryData2 != null) {
                arrayList2.add(rDeliveryData2);
            }
            this.dataMap.remove(rDeliveryData.getKey());
            H(rDeliveryData.getKey(), rDeliveryData2, null);
            arrayList.add(rDeliveryData.getKey());
        }
        M(arrayList2, CfgChangeType.DELETE, 50);
        return arrayList;
    }

    public final void o() {
        m();
        this.dataInitListeners.clear();
        this.dataChangeListeners.clear();
        this.userEventListeners.clear();
    }

    @NotNull
    public final String q(@NotNull String oldRespJsonStr, @NotNull String newHitSubTaskID) {
        Intrinsics.checkParameterIsNotNull(oldRespJsonStr, "oldRespJsonStr");
        Intrinsics.checkParameterIsNotNull(newHitSubTaskID, "newHitSubTaskID");
        JSONObject jSONObject = new JSONObject(oldRespJsonStr);
        jSONObject.optJSONObject("report").putOpt("hitSubTaskID", newHitSubTaskID);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "rDeliveryDataitem.toString()");
        return jSONObject2;
    }

    @NotNull
    public Map<String, RDeliveryData> r(boolean readDiskWhenDataNotInited) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (readDiskWhenDataNotInited && !this.initialized) {
            linkedHashMap.putAll(p().getFirst());
        } else {
            linkedHashMap.putAll(this.dataMap);
        }
        return linkedHashMap;
    }

    @Nullable
    public RDeliveryData t(@NotNull String key, @NotNull TargetType targetType, boolean readDiskWhenDataNotInited) {
        RDeliveryData B;
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(targetType, "targetType");
        if (readDiskWhenDataNotInited && !this.initialized) {
            B = v(key);
        } else {
            B = B(key);
        }
        RDeliveryData B2 = this.setting.B(key, B);
        I(key, B2);
        return B2;
    }

    @Nullable
    public final RDeliveryData v(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDeliveryData rDeliveryData = null;
        String string = this.dataStorage.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            rDeliveryData = g.INSTANCE.a(new JSONObject(string), this.setting.getRdInstanceIdentifier(), this.setting.getLogger(), this.setting.getEnableDetailLog());
            Unit unit = Unit.INSTANCE;
            return rDeliveryData;
        } catch (Exception e16) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.d(d.a("RDelivery_DataManager", this.setting.getRdInstanceIdentifier()), "getDataByKeyFromDisc Exception", e16);
                Unit unit2 = Unit.INSTANCE;
                return rDeliveryData;
            }
            return rDeliveryData;
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, RDeliveryData> w() {
        return this.dataMap;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final IRStorage getDataStorage() {
        return this.dataStorage;
    }

    public final long y() {
        IRStorage iRStorage = this.requestTimeStorage;
        if (iRStorage == null) {
            return -1L;
        }
        return iRStorage.getLong("mmkv_special_key_for_full_request_time_stamp", -1L);
    }

    public final long z(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        IRStorage iRStorage = this.requestTimeStorage;
        if (iRStorage == null) {
            return -1L;
        }
        return iRStorage.getLong(key, -1L);
    }
}
