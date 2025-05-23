package com.tencent.mobileqq.zplan.emoticon.panel.util;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import by4.ZPlanRecordResourceStatistic;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mobileqq.zplan.servlet.m;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonTabCloudCacheRequestConfig;
import com.tencent.state.data.SquareJSConst;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.CloudSwitches;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import com.tencent.zplan.record.model.RenderSwitches;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import nh3.ZPlanEmoticonReportData;
import org.json.JSONObject;
import t74.r;
import tl.h;

@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002^}B\t\b\u0002\u00a2\u0006\u0004\b{\u0010|JM\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0002Ji\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J9\u0010\u001f\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\"\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0002J\"\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0002J\"\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0002J2\u0010)\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010(H\u0002J0\u0010+\u001a\u00020**\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J;\u0010,\u001a\u00020**\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u001d\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100J[\u00104\u001a\u000203*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u00105J\u000e\u00108\u001a\u000207*\u0004\u0018\u000106H\u0002J\u000e\u0010:\u001a\u000207*\u0004\u0018\u000109H\u0002J\"\u0010>\u001a\u00020\u000e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0<J\u000e\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u000201J\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010C\u001a\u00020\u0005J\u0010\u0010E\u001a\u00020\u000e2\b\b\u0002\u0010D\u001a\u00020\u0007J:\u0010G\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u000201Jg\u0010I\u001a\u00020\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tJ\u000e\u0010J\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010K\u001a\u0002012\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010L\u001a\u0002012\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010N\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010O\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"J,\u0010P\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010(J,\u0010Q\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010(J2\u0010R\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010(J\u0016\u0010U\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007J\u0006\u0010V\u001a\u00020\u000eJ\f\u0010Y\u001a\u0004\u0018\u00010X*\u00020WJ\n\u0010\\\u001a\u00020[*\u00020ZJ\u001e\u0010^\u001a\u00020\u000e2\u0006\u0010]\u001a\u0002012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016R\"\u0010d\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010E\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001b\u0010k\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010aR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010i\u001a\u0004\bn\u0010oR\u0016\u0010r\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010ER\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010JR\u0016\u0010u\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010ER \u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020w0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010xR\u001b\u0010z\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010i\u001a\u0004\bq\u0010a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006~"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil;", "Lcom/tencent/mobileqq/zplan/servlet/m;", "", "Lcom/tencent/mobileqq/zplan/model/e;", "actionList2D", "", "selfUin", "", "reqFrom", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$a;", "Lkotlin/ParameterName;", "name", "reportData", "", "callback", "K", "actionInfoList", "Lcom/tencent/zplan/meme/Priority;", "coverPriority", "picPriority", "Ljh3/a;", "listener", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "scope", "D", "actions", "uin", "width", "height", "I", "(Ljava/util/List;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "actionInfo", "Lcom/tencent/zplan/meme/action/MODE;", "mode", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "priority", "Ljh3/b;", "M", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "i0", "m0", "(Lcom/tencent/mobileqq/zplan/model/e;Ljava/lang/String;Lcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/meme/Priority;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/meme/model/a;", "u", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "downloadFromNetIfLocalAbsent", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "j0", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/zplan/meme/action/MODE;IILcom/tencent/zplan/meme/Priority;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lby4/a;", "Lnh3/b;", "e0", "Lwx4/d;", "f0", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function0;", "onDone", "X", "show", "d0", "from", "c0", "E", "limit", "Z", "report", "P", "actionListMeme", "V", "J", UserInfo.SEX_FEMALE, "G", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "N", "T", "L", "firstLine", "lastLine", "a0", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/zplan/record/model/d;", "Lcom/tencent/zplan/meme/EngineType;", "h0", "Lcom/tencent/zplan/record/model/b;", "Lcom/tencent/zplan/common/model/UploadConfig;", "g0", "success", "a", "f", "H", "()Z", "setZPlanEmoticonPanelShown", "(Z)V", "isZPlanEmoticonPanelShown", h.F, "Ljava/lang/String;", "emoticonPanelLastJumpFrom", "i", "Lkotlin/Lazy;", "B", "enableCloudRecord", "Lcom/tencent/sqshow/utils/featureswitch/model/v;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "()Lcom/tencent/sqshow/utils/featureswitch/model/v;", "batchPreRequestConfig", BdhLogUtil.LogTag.Tag_Conn, "isDoingBatchPreRequest", "", "lastBatchPreRequestTimestamp", "appearanceKeyChanged", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$b;", "Ljava/util/concurrent/ConcurrentHashMap;", "idActionMap", "enableResetPriority", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil extends m {

    /* renamed from: C */
    private static volatile boolean isDoingBatchPreRequest;

    /* renamed from: D, reason: from kotlin metadata */
    private static volatile long lastBatchPreRequestTimestamp;

    /* renamed from: E, reason: from kotlin metadata */
    private static volatile boolean appearanceKeyChanged;

    /* renamed from: F */
    private static final ConcurrentHashMap<Integer, PairEntry> idActionMap;

    /* renamed from: G, reason: from kotlin metadata */
    private static final Lazy enableResetPriority;

    /* renamed from: e */
    public static final ZPlanEmoticonUtil f333176e;

    /* renamed from: f, reason: from kotlin metadata */
    private static boolean isZPlanEmoticonPanelShown;

    /* renamed from: h */
    private static String emoticonPanelLastJumpFrom;

    /* renamed from: i, reason: from kotlin metadata */
    private static final Lazy enableCloudRecord;

    /* renamed from: m */
    private static final Lazy batchPreRequestConfig;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$d", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a */
        final /* synthetic */ Function0<Unit> f333208a;

        d(Function0<Unit> function0) {
            this.f333208a = function0;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            this.f333208a.invoke();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        ZPlanEmoticonUtil zPlanEmoticonUtil = new ZPlanEmoticonUtil();
        f333176e = zPlanEmoticonUtil;
        emoticonPanelLastJumpFrom = "aio";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$enableCloudRecord$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanFeatureSwitch.f369852a.n());
            }
        });
        enableCloudRecord = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanEmoticonTabCloudCacheRequestConfig>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$batchPreRequestConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanEmoticonTabCloudCacheRequestConfig invoke() {
                return ZPlanQQMC.INSTANCE.getZPlanEmoticonTabCloudCacheRequestConfig();
            }
        });
        batchPreRequestConfig = lazy2;
        idActionMap = new ConcurrentHashMap<>();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$enableResetPriority$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMemeResetPriority());
            }
        });
        enableResetPriority = lazy3;
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.addObserver(zPlanEmoticonUtil, true);
        }
    }

    ZPlanEmoticonUtil() {
    }

    public final boolean B() {
        return ((Boolean) enableCloudRecord.getValue()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) enableResetPriority.getValue()).booleanValue();
    }

    private final void D(CoroutineScope scope) {
        if (isDoingBatchPreRequest) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "getZPlanActionsAndDoPreRequest, isDoingBatchPreRequest return!");
            return;
        }
        isDoingBatchPreRequest = true;
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return;
        }
        CorountineFunKt.e(scope, "zplan_getZPlanActionsAndDoPreRequest", null, null, null, new ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1(scope, baseApplication, null), 14, null);
    }

    public final Object I(List<ZPlanActionInfo> list, String str, int i3, int i16, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2(list, str, i3, i16, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    public final void K(List<ZPlanActionInfo> actionList2D, String selfUin, int reqFrom, Function1<? super EmotionTabRecordReportData, Unit> callback) {
        long currentTimeMillis = System.currentTimeMillis();
        int size = actionList2D.size();
        ReentrantLock reentrantLock = new ReentrantLock();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = size * 2;
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        Ref.IntRef intRef3 = new Ref.IntRef();
        a.f333231a.k(actionList2D, selfUin, reqFrom, new c(reentrantLock, intRef, intRef2, new Ref.IntRef(), intRef3, new Ref.IntRef(), new Ref.IntRef(), new Ref.IntRef(), longRef, currentTimeMillis, size, callback));
    }

    private final void M(ZPlanActionInfo actionInfo, MODE mode, String uin, Priority priority, jh3.b listener) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEmoticonUtil$recordActionByResourceCenter$1(actionInfo, uin, mode, priority, listener, null), 3, null);
    }

    private final void R(List<ZPlanActionInfo> list, String str, Priority priority, Priority priority2, int i3, jh3.a aVar, Function1<? super EmotionTabRecordReportData, Unit> function1) {
        Object first;
        Object first2;
        if (list.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Ref.LongRef longRef = new Ref.LongRef();
        int size = list.size();
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        Ref.IntRef intRef5 = new Ref.IntRef();
        Ref.IntRef intRef6 = new Ref.IntRef();
        ReentrantLock reentrantLock = new ReentrantLock();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        int width = ((ZPlanActionInfo) first).getWidth();
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        int height = ((ZPlanActionInfo) first2).getHeight();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1(list, str, width, height, priority, i3, aVar, reentrantLock, intRef3, intRef, intRef2, size, longRef, currentTimeMillis, intRef4, intRef5, intRef6, function1, null), 3, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ZPlanActionInfo) obj).getOriginType() != 100) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2(arrayList, str, width, height, priority2, i3, reentrantLock, intRef6, intRef4, intRef5, intRef, intRef2, intRef3, size, longRef, currentTimeMillis, function1, null), 3, null);
    }

    public static final void Y(List uinList, Function0 onDone) {
        Intrinsics.checkNotNullParameter(uinList, "$uinList");
        Intrinsics.checkNotNullParameter(onDone, "$onDone");
        ZplanDataRepository.f334898a.w(uinList, new d(onDone));
    }

    public static final void b0(int i3, int i16) {
        Priority priority;
        Iterator<Map.Entry<Integer, PairEntry>> it = idActionMap.entrySet().iterator();
        while (it.hasNext()) {
            PairEntry value = it.next().getValue();
            int lineNumber = value.getActionInfo().getLineNumber();
            boolean z16 = false;
            if (i3 <= lineNumber && lineNumber <= i16) {
                z16 = true;
            }
            if (z16) {
                priority = Priority.HIGH;
            } else {
                priority = Priority.LOW;
            }
            value.getRecordParams().v(priority);
            Meme.f385754h.F(value.getRecordParams().a(), priority);
        }
    }

    private final ZPlanEmoticonReportData f0(wx4.d dVar) {
        MODE mode;
        int errCode = dVar != null ? dVar.getErrCode() : 0;
        String name = Source.LOCAL_RECORD.name();
        long l3 = dVar != null ? dVar.l() : 0L;
        long p16 = dVar != null ? dVar.p() : 0L;
        long e16 = dVar != null ? dVar.e() : 0L;
        boolean hitCache = dVar != null ? dVar.getHitCache() : false;
        if (dVar == null || (mode = dVar.getMode()) == null) {
            mode = MODE.FRAME;
        }
        return new ZPlanEmoticonReportData(errCode, name, l3, p16, e16, hitCache, mode, 0L, 0L, 0L, null, false, 0, 8064, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m0(ZPlanActionInfo zPlanActionInfo, String str, MODE mode, Priority priority, int i3, Continuation<? super SingleRecordRequestParams> continuation) {
        ZPlanEmoticonUtil$toResourceParam2$1 zPlanEmoticonUtil$toResourceParam2$1;
        Object coroutine_suspended;
        int i16;
        SingleRecordRequestParams i06;
        if (continuation instanceof ZPlanEmoticonUtil$toResourceParam2$1) {
            zPlanEmoticonUtil$toResourceParam2$1 = (ZPlanEmoticonUtil$toResourceParam2$1) continuation;
            int i17 = zPlanEmoticonUtil$toResourceParam2$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanEmoticonUtil$toResourceParam2$1.label = i17 - Integer.MIN_VALUE;
                Object obj = zPlanEmoticonUtil$toResourceParam2$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = zPlanEmoticonUtil$toResourceParam2$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i06 = i0(zPlanActionInfo, str, mode, priority, i3);
                    zPlanEmoticonUtil$toResourceParam2$1.L$0 = i06;
                    zPlanEmoticonUtil$toResourceParam2$1.label = 1;
                    obj = u(str, zPlanEmoticonUtil$toResourceParam2$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    i06 = (SingleRecordRequestParams) zPlanEmoticonUtil$toResourceParam2$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i06.x((AvatarCharacterInfo) obj);
                return i06;
            }
        }
        zPlanEmoticonUtil$toResourceParam2$1 = new ZPlanEmoticonUtil$toResourceParam2$1(this, continuation);
        Object obj2 = zPlanEmoticonUtil$toResourceParam2$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = zPlanEmoticonUtil$toResourceParam2$1.label;
        if (i16 != 0) {
        }
        i06.x((AvatarCharacterInfo) obj2);
        return i06;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x002a, B:12:0x0067, B:14:0x006b, B:16:0x0073, B:28:0x0043), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x002a, B:12:0x0067, B:14:0x006b, B:16:0x0073, B:28:0x0043), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(String str, Continuation<? super AvatarCharacterInfo> continuation) {
        ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1 zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        gx4.a a16;
        try {
            if (continuation instanceof ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1) {
                zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1 = (ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1) continuation;
                int i16 = zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!ZPlanQQMC.INSTANCE.enableEmoticonStickerIdConfigFromAllConfig()) {
                            return null;
                        }
                        String str3 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(str).appearanceKey;
                        IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                        zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.L$0 = str3;
                        zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.label = 1;
                        Object fetchOtherAvatarInfoWithUin = iZPlanAvatarInfoHelper.fetchOtherAvatarInfoWithUin(str, zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1);
                        if (fetchOtherAvatarInfoWithUin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = fetchOtherAvatarInfoWithUin;
                        str2 = str3;
                    } else if (i3 == 1) {
                        str2 = (String) zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    a16 = jSONObject == null ? fx4.a.a(jSONObject) : null;
                    if (a16 == null) {
                        return new AvatarCharacterInfo(a16, str2);
                    }
                    return null;
                }
            }
            if (i3 != 0) {
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2 == null) {
            }
            if (a16 == null) {
            }
        } catch (Throwable unused) {
            QLog.e("[zplan][ZPlanEmoticonUtil]", 1, "toResourceParam, get avatarCharacterInfo failed.");
            return null;
        }
        zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1 = new ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1(this, continuation);
        Object obj2 = zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1.label;
    }

    public final ZPlanEmoticonTabCloudCacheRequestConfig v() {
        return (ZPlanEmoticonTabCloudCacheRequestConfig) batchPreRequestConfig.getValue();
    }

    private final String x(ZPlanActionInfo zPlanActionInfo, String str, MODE mode) {
        if (zPlanActionInfo.getOriginType() == 100) {
            return a.f333231a.e(zPlanActionInfo, str);
        }
        if (B()) {
            return z(zPlanActionInfo, str, mode);
        }
        return y(zPlanActionInfo, str, mode);
    }

    private final String y(ZPlanActionInfo actionInfo, String uin, MODE mode) {
        int width = actionInfo.getWidth();
        int height = actionInfo.getHeight();
        String name = actionInfo.getName();
        if (name == null) {
            name = String.valueOf(actionInfo.getId());
        }
        File o16 = Meme.f385754h.o(new MemeZPlanAction(actionInfo.getId(), mode.toFrameCount(), width, height, mode, uin, name).getKey());
        if (o16 == null || !o16.exists()) {
            return null;
        }
        return o16.getAbsolutePath();
    }

    private final String z(ZPlanActionInfo zPlanActionInfo, String str, MODE mode) {
        ZPlanRecordResource c16 = ZPlanRecordResourceCenter.f386003a.c(k0(this, zPlanActionInfo, str, mode, null, 0, 12, null));
        if (c16 != null) {
            return c16.getLocalPath();
        }
        return null;
    }

    public final String A(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return x(actionInfo, selfUin, MODE.SHARPP);
    }

    public final String E() {
        return emoticonPanelLastJumpFrom;
    }

    public final boolean F(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return w(actionInfo, selfUin) != null;
    }

    public final boolean G(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return A(actionInfo, selfUin) != null;
    }

    public final boolean H() {
        return isZPlanEmoticonPanelShown;
    }

    public final void J(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (!v().getEnableBatchPreRequest()) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "preRequestZPlanActionsCloudCache, enableBatchPreRequest false, return!");
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = lastBatchPreRequestTimestamp;
        long j16 = serverTime - j3;
        long validTimeSeconds = v().getValidTimeSeconds();
        if (j3 != 0 && j16 <= validTimeSeconds && !appearanceKeyChanged) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "preRequestZPlanActionsCloudCache, lastDuration:" + j16 + " not match validTimeSeconds:" + validTimeSeconds + ", and appearanceKey not changed, return!");
            return;
        }
        D(scope);
    }

    public final void L(ZPlanActionInfo actionInfo, MODE mode, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        M(actionInfo, mode, selfUin, priority, listener);
    }

    public final void N(ZPlanActionInfo actionInfo, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (actionInfo.getOriginType() == 100) {
            a.f333231a.l(actionInfo, selfUin, priority, listener);
        } else {
            L(actionInfo, MODE.FRAME, selfUin, priority, listener);
        }
    }

    public final void P(List<ZPlanActionInfo> actionInfoList, Priority coverPriority, Priority picPriority, int reqFrom, boolean report) {
        Intrinsics.checkNotNullParameter(actionInfoList, "actionInfoList");
        Intrinsics.checkNotNullParameter(coverPriority, "coverPriority");
        Intrinsics.checkNotNullParameter(picPriority, "picPriority");
        ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1 zPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1 = new ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1(actionInfoList.size(), actionInfoList, reqFrom, coverPriority, picPriority, report);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(zPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1, 16, null, true);
        } else {
            zPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1.run();
        }
    }

    public final void T(ZPlanActionInfo actionInfo, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (actionInfo.getOriginType() == 100) {
            a.f333231a.n(actionInfo, selfUin, priority, listener);
        } else {
            L(actionInfo, MODE.SHARPP, selfUin, priority, listener);
        }
    }

    public final void V(List<ZPlanActionInfo> actionListMeme, String selfUin, Priority coverPriority, Priority picPriority, int reqFrom, jh3.a listener, Function1<? super EmotionTabRecordReportData, Unit> callback) {
        Intrinsics.checkNotNullParameter(actionListMeme, "actionListMeme");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(coverPriority, "coverPriority");
        Intrinsics.checkNotNullParameter(picPriority, "picPriority");
        R(actionListMeme, selfUin, coverPriority, picPriority, reqFrom, listener, callback);
    }

    public final void X(final List<String> r36, final Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(r36, "uinList");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonUtil.Y(r36, onDone);
            }
        }, 128, null, true);
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [com.tencent.mobileqq.qcoroutine.api.coroutine.b, T] */
    public final void Z(int limit) {
        CoroutineScope f16;
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e)) == null) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CorountineFunKt.e(f16, "zplan_requireZPlanActionsAndRecord", null, null, null, new ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1(f16, baseApplication, limit, objectRef, null), 14, null);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.m
    public void a(boolean success, List<String> r36) {
        Intrinsics.checkNotNullParameter(r36, "uinList");
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null && r36.contains(c16.getCurrentUin())) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "onUserAppearanceKeyChange change!");
            appearanceKeyChanged = true;
        }
    }

    public final void a0(final int firstLine, final int lastLine) {
        if (C()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEmoticonUtil.b0(firstLine, lastLine);
                }
            }, 16, null, false);
        }
    }

    public final void c0(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        emoticonPanelLastJumpFrom = from;
    }

    public final void d0(boolean show) {
        isZPlanEmoticonPanelShown = show;
    }

    public final UploadConfig g0(CloudSwitches cloudSwitches) {
        UploadConfig.UploadTarget uploadTarget;
        Intrinsics.checkNotNullParameter(cloudSwitches, "<this>");
        boolean enableUploadToCloud = cloudSwitches.getEnableUploadToCloud();
        if (cloudSwitches.getUploadToIDC()) {
            uploadTarget = UploadConfig.UploadTarget.IDC;
        } else {
            uploadTarget = UploadConfig.UploadTarget.CDN;
        }
        return new UploadConfig(enableUploadToCloud, uploadTarget, false, true, 4, null);
    }

    public final EngineType h0(RenderSwitches renderSwitches) {
        Intrinsics.checkNotNullParameter(renderSwitches, "<this>");
        if (renderSwitches.getEnableFilament()) {
            return new EngineType.Filament(FilamentNativeAppRecorder.class);
        }
        return null;
    }

    public final void s() {
        if (C()) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "clearIdActionMap");
            idActionMap.clear();
        }
    }

    public final String t(ZPlanActionInfo actionInfo, String uin, MODE mode) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        int id5 = actionInfo.getId();
        int frameCount = mode.toFrameCount();
        int width = actionInfo.getWidth();
        int height = actionInfo.getHeight();
        String name = actionInfo.getName();
        return new MemeZPlanAction(id5, frameCount, width, height, mode, uin, name == null ? String.valueOf(actionInfo.getId()) : name).getKey();
    }

    public final String w(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return x(actionInfo, selfUin, MODE.FRAME);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005J\t\u0010\n\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010!\u001a\u0004\b\u0019\u0010\"R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b$\u0010\"R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b&\u0010\u0011R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$a;", "", "", "numerator", "denominator", "", "a", "recorderType", "", "j", "toString", "hashCode", "other", "", "equals", "I", "getTotal", "()I", "total", "b", "coverCacheNum", "c", "coverCloudRecordNum", "d", "coverLocalRecordNum", "e", "f", "picCacheNum", "g", "picCloudRecordNum", h.F, "picLocalRecordNum", "", "J", "()J", "coverTimeCost", "i", "timeCost", "getTotal_3D", "total_3D", "k", "getTotal_3D_plus_2D", "total_3D_plus_2D", "<init>", "(IIIIIIIJJII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class EmotionTabRecordReportData {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int total;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int coverCacheNum;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final int coverCloudRecordNum;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final int coverLocalRecordNum;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final int picCacheNum;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final int picCloudRecordNum;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final int picLocalRecordNum;

        /* renamed from: h, reason: from toString */
        private final long coverTimeCost;

        /* renamed from: i, reason: from kotlin metadata and from toString */
        private final long timeCost;

        /* renamed from: j, reason: from kotlin metadata and from toString */
        private final int total_3D;

        /* renamed from: k, reason: from kotlin metadata and from toString */
        private final int total_3D_plus_2D;

        public EmotionTabRecordReportData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, long j3, long j16, int i28, int i29) {
            this.total = i3;
            this.coverCacheNum = i16;
            this.coverCloudRecordNum = i17;
            this.coverLocalRecordNum = i18;
            this.picCacheNum = i19;
            this.picCloudRecordNum = i26;
            this.picLocalRecordNum = i27;
            this.coverTimeCost = j3;
            this.timeCost = j16;
            this.total_3D = i28;
            this.total_3D_plus_2D = i29;
        }

        /* renamed from: b, reason: from getter */
        public final int getCoverCacheNum() {
            return this.coverCacheNum;
        }

        /* renamed from: c, reason: from getter */
        public final int getCoverCloudRecordNum() {
            return this.coverCloudRecordNum;
        }

        /* renamed from: d, reason: from getter */
        public final int getCoverLocalRecordNum() {
            return this.coverLocalRecordNum;
        }

        /* renamed from: e, reason: from getter */
        public final long getCoverTimeCost() {
            return this.coverTimeCost;
        }

        /* renamed from: f, reason: from getter */
        public final int getPicCacheNum() {
            return this.picCacheNum;
        }

        /* renamed from: g, reason: from getter */
        public final int getPicCloudRecordNum() {
            return this.picCloudRecordNum;
        }

        /* renamed from: h, reason: from getter */
        public final int getPicLocalRecordNum() {
            return this.picLocalRecordNum;
        }

        public int hashCode() {
            return (((((((((((((((((((this.total * 31) + this.coverCacheNum) * 31) + this.coverCloudRecordNum) * 31) + this.coverLocalRecordNum) * 31) + this.picCacheNum) * 31) + this.picCloudRecordNum) * 31) + this.picLocalRecordNum) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.coverTimeCost)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.timeCost)) * 31) + this.total_3D) * 31) + this.total_3D_plus_2D;
        }

        /* renamed from: i, reason: from getter */
        public final long getTimeCost() {
            return this.timeCost;
        }

        public final void j(String recorderType) {
            String str;
            Map mapOf;
            Intrinsics.checkNotNullParameter(recorderType, "recorderType");
            String a16 = a(this.coverCacheNum, this.total_3D);
            String a17 = a(this.picCacheNum, this.total_3D);
            String a18 = a(this.coverCacheNum + this.picCacheNum, this.total_3D * 2);
            String a19 = a(this.coverCloudRecordNum, this.total_3D);
            String a26 = a(this.picCloudRecordNum, this.total_3D);
            String a27 = a(this.coverCloudRecordNum + this.picCloudRecordNum, this.total_3D * 2);
            EngineType h06 = ZPlanEmoticonUtil.f333176e.h0(ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.EMOTICON).getRenderSwitches());
            if (h06 != null && (h06 instanceof EngineType.Filament)) {
                str = "Filament";
            } else {
                str = "Unreal";
            }
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("recorderType", recorderType), TuplesKt.to("totalNum", String.valueOf(this.total)), TuplesKt.to("coverCacheNum", String.valueOf(this.coverCacheNum)), TuplesKt.to("coverCloudRecordNum", String.valueOf(this.coverCloudRecordNum)), TuplesKt.to("coverLocalRecordNum", String.valueOf(this.coverLocalRecordNum)), TuplesKt.to("picCacheNum", String.valueOf(this.picCacheNum)), TuplesKt.to("picCloudRecordNum", String.valueOf(this.picCloudRecordNum)), TuplesKt.to("picLocalRecordNum", String.valueOf(this.picLocalRecordNum)), TuplesKt.to("coverCacheRatio", a16), TuplesKt.to("picCacheRatio", a17), TuplesKt.to("totalCacheRatio", a18), TuplesKt.to("coverCloudRatio", a19), TuplesKt.to("picCloudRatio", a26), TuplesKt.to("totalCloudRatio", a27), TuplesKt.to("coverTimeCost", String.valueOf(this.coverTimeCost)), TuplesKt.to("timeCost", String.valueOf(this.timeCost)), TuplesKt.to("timestampMs", String.valueOf(System.currentTimeMillis())), TuplesKt.to("total3DNum", String.valueOf(this.total_3D)), TuplesKt.to("total3DPlus2DNum", String.valueOf(this.total_3D_plus_2D)), TuplesKt.to("localRecordEngineType", str));
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "report zplan_emotion_tab_record_timecost, " + mapOf);
            r.e(null, "zplan_emotion_tab_record_timecost", mapOf, 1, null);
        }

        public String toString() {
            return "EmotionTabRecordReportData(total=" + this.total + ", coverCacheNum=" + this.coverCacheNum + ", coverCloudRecordNum=" + this.coverCloudRecordNum + ", coverLocalRecordNum=" + this.coverLocalRecordNum + ", picCacheNum=" + this.picCacheNum + ", picCloudRecordNum=" + this.picCloudRecordNum + ", picLocalRecordNum=" + this.picLocalRecordNum + ", coverTimeCost=" + this.coverTimeCost + ", timeCost=" + this.timeCost + ", total_3D=" + this.total_3D + ", total_3D_plus_2D=" + this.total_3D_plus_2D + ")";
        }

        private final String a(int numerator, int denominator) {
            if (denominator == 0) {
                return "-1";
            }
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf((numerator * 1.0d) / denominator)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmotionTabRecordReportData)) {
                return false;
            }
            EmotionTabRecordReportData emotionTabRecordReportData = (EmotionTabRecordReportData) other;
            return this.total == emotionTabRecordReportData.total && this.coverCacheNum == emotionTabRecordReportData.coverCacheNum && this.coverCloudRecordNum == emotionTabRecordReportData.coverCloudRecordNum && this.coverLocalRecordNum == emotionTabRecordReportData.coverLocalRecordNum && this.picCacheNum == emotionTabRecordReportData.picCacheNum && this.picCloudRecordNum == emotionTabRecordReportData.picCloudRecordNum && this.picLocalRecordNum == emotionTabRecordReportData.picLocalRecordNum && this.coverTimeCost == emotionTabRecordReportData.coverTimeCost && this.timeCost == emotionTabRecordReportData.timeCost && this.total_3D == emotionTabRecordReportData.total_3D && this.total_3D_plus_2D == emotionTabRecordReportData.total_3D_plus_2D;
        }

        public /* synthetic */ EmotionTabRecordReportData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, long j3, long j16, int i28, int i29, int i36, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i36 & 2) != 0 ? 0 : i16, (i36 & 4) != 0 ? 0 : i17, (i36 & 8) != 0 ? 0 : i18, (i36 & 16) != 0 ? 0 : i19, (i36 & 32) != 0 ? 0 : i26, (i36 & 64) != 0 ? 0 : i27, (i36 & 128) != 0 ? 0L : j3, (i36 & 256) == 0 ? j16 : 0L, (i36 & 512) != 0 ? 0 : i28, (i36 & 1024) == 0 ? i29 : 0);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$c", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements jh3.b {

        /* renamed from: a */
        final /* synthetic */ ReentrantLock f333195a;

        /* renamed from: b */
        final /* synthetic */ Ref.IntRef f333196b;

        /* renamed from: c */
        final /* synthetic */ Ref.IntRef f333197c;

        /* renamed from: d */
        final /* synthetic */ Ref.IntRef f333198d;

        /* renamed from: e */
        final /* synthetic */ Ref.IntRef f333199e;

        /* renamed from: f */
        final /* synthetic */ Ref.IntRef f333200f;

        /* renamed from: g */
        final /* synthetic */ Ref.IntRef f333201g;

        /* renamed from: h */
        final /* synthetic */ Ref.IntRef f333202h;

        /* renamed from: i */
        final /* synthetic */ Ref.LongRef f333203i;

        /* renamed from: j */
        final /* synthetic */ long f333204j;

        /* renamed from: k */
        final /* synthetic */ int f333205k;

        /* renamed from: l */
        final /* synthetic */ Function1<EmotionTabRecordReportData, Unit> f333206l;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f333207a;

            static {
                int[] iArr = new int[MODE.values().length];
                try {
                    iArr[MODE.FRAME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MODE.GIF.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f333207a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(ReentrantLock reentrantLock, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, Ref.IntRef intRef7, Ref.LongRef longRef, long j3, int i3, Function1<? super EmotionTabRecordReportData, Unit> function1) {
            this.f333195a = reentrantLock;
            this.f333196b = intRef;
            this.f333197c = intRef2;
            this.f333198d = intRef3;
            this.f333199e = intRef4;
            this.f333200f = intRef5;
            this.f333201g = intRef6;
            this.f333202h = intRef7;
            this.f333203i = longRef;
            this.f333204j = j3;
            this.f333205k = i3;
            this.f333206l = function1;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mode, "mode");
            ReentrantLock reentrantLock = this.f333195a;
            Ref.IntRef intRef = this.f333196b;
            Ref.IntRef intRef2 = this.f333197c;
            Ref.IntRef intRef3 = this.f333198d;
            Ref.IntRef intRef4 = this.f333199e;
            Ref.IntRef intRef5 = this.f333200f;
            Ref.IntRef intRef6 = this.f333201g;
            Ref.IntRef intRef7 = this.f333202h;
            Ref.LongRef longRef = this.f333203i;
            long j3 = this.f333204j;
            int i3 = this.f333205k;
            Function1<EmotionTabRecordReportData, Unit> function1 = this.f333206l;
            reentrantLock.lock();
            try {
                intRef.element--;
                int i16 = a.f333207a[data.getEncode2DMode().ordinal()];
                if (i16 == 1) {
                    String recorderType = data.getRecorderType();
                    if (Intrinsics.areEqual(recorderType, Source.LOCAL_CACHE.name())) {
                        intRef2.element++;
                    } else if (Intrinsics.areEqual(recorderType, Source.CLOUD_CACHE.name())) {
                        intRef3.element++;
                    } else if (Intrinsics.areEqual(recorderType, Source.LOCAL_RECORD.name())) {
                        intRef4.element++;
                    }
                } else if (i16 == 2) {
                    String recorderType2 = data.getRecorderType();
                    if (Intrinsics.areEqual(recorderType2, Source.LOCAL_CACHE.name())) {
                        intRef5.element++;
                    } else if (Intrinsics.areEqual(recorderType2, Source.CLOUD_CACHE.name())) {
                        intRef6.element++;
                    } else if (Intrinsics.areEqual(recorderType2, Source.LOCAL_RECORD.name())) {
                        intRef7.element++;
                    }
                }
                if (data.getEncode2DMode() == MODE.FRAME) {
                    longRef.element = System.currentTimeMillis() - j3;
                }
                if (intRef.element == 0) {
                    EmotionTabRecordReportData emotionTabRecordReportData = new EmotionTabRecordReportData(i3, intRef2.element, intRef3.element, intRef4.element, intRef5.element, intRef6.element, intRef7.element, longRef.element, System.currentTimeMillis() - j3, 0, 0, 1536, null);
                    if (function1 != null) {
                        function1.invoke(emotionTabRecordReportData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final ZPlanEmoticonReportData e0(ZPlanRecordResourceStatistic zPlanRecordResourceStatistic) {
        wx4.d dVar;
        if (zPlanRecordResourceStatistic != null && zPlanRecordResourceStatistic.getSource() != Source.LOCAL_CACHE) {
            if (zPlanRecordResourceStatistic.getSource() == Source.CLOUD_CACHE) {
                Integer cacheErrorCode = zPlanRecordResourceStatistic.getCacheErrorCode();
                return new ZPlanEmoticonReportData(cacheErrorCode != null ? cacheErrorCode.intValue() : 0, zPlanRecordResourceStatistic.getSource().name(), 0L, 0L, zPlanRecordResourceStatistic.getCacheTimeCost(), false, zPlanRecordResourceStatistic.getMode(), 0L, 0L, 0L, null, false, zPlanRecordResourceStatistic.getResId(), 3980, null);
            }
            if (zPlanRecordResourceStatistic.getRaw() instanceof wx4.d) {
                Object raw = zPlanRecordResourceStatistic.getRaw();
                Intrinsics.checkNotNull(raw, "null cannot be cast to non-null type com.tencent.zplan.meme.statistic.MemeRecordStatistic");
                dVar = (wx4.d) raw;
            } else {
                dVar = null;
            }
            return f0(dVar);
        }
        return new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
    }

    private final SingleRecordRequestParams i0(ZPlanActionInfo zPlanActionInfo, String str, MODE mode, Priority priority, int i3) {
        GeneralRecordSwitches generalRecordSwitchesByScene = ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.EMOTICON);
        EngineType h06 = h0(generalRecordSwitchesByScene.getRenderSwitches());
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
        businessConfig.C(BusinessConfig.FrameType.PNG);
        String str2 = null;
        if (h06 != null) {
            businessConfig.G(h06);
            businessConfig.A(businessConfig.getTargetEngine() instanceof EngineType.Filament ? Boolean.TRUE : null);
        }
        businessConfig.x(1);
        businessConfig.z(Boolean.valueOf(generalRecordSwitchesByScene.getRenderSwitches().getDisableGlassesMetallic()));
        String stickerIdConf = zPlanActionInfo.getStickerIdConf();
        if (stickerIdConf != null) {
            if (!Boolean.valueOf(stickerIdConf.length() > 0).booleanValue()) {
                stickerIdConf = null;
            }
            if (stickerIdConf != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(zPlanActionInfo.getId()), stickerIdConf);
                str2 = jSONObject.toString();
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        businessConfig.F(str2);
        return new SingleRecordRequestParams(zPlanActionInfo.getId(), str, null, zPlanActionInfo.getWidth(), zPlanActionInfo.getHeight(), mode, businessConfig, 2, null, priority, g0(generalRecordSwitchesByScene.getCloudSwitches()), null, i3, false, zPlanActionInfo.getMetadataExtraJson(), null, 43264, null);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "a", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "b", "()Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "recordParams", "Lcom/tencent/mobileqq/zplan/model/e;", "Lcom/tencent/mobileqq/zplan/model/e;", "()Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "<init>", "(Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lcom/tencent/mobileqq/zplan/model/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class PairEntry {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final SingleRecordRequestParams recordParams;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final ZPlanActionInfo actionInfo;

        public PairEntry(SingleRecordRequestParams recordParams, ZPlanActionInfo actionInfo) {
            Intrinsics.checkNotNullParameter(recordParams, "recordParams");
            Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
            this.recordParams = recordParams;
            this.actionInfo = actionInfo;
        }

        /* renamed from: a, reason: from getter */
        public final ZPlanActionInfo getActionInfo() {
            return this.actionInfo;
        }

        /* renamed from: b, reason: from getter */
        public final SingleRecordRequestParams getRecordParams() {
            return this.recordParams;
        }

        public int hashCode() {
            return (this.recordParams.hashCode() * 31) + this.actionInfo.hashCode();
        }

        public String toString() {
            return "PairEntry(recordParams=" + this.recordParams + ", actionInfo=" + this.actionInfo + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PairEntry)) {
                return false;
            }
            PairEntry pairEntry = (PairEntry) other;
            return Intrinsics.areEqual(this.recordParams, pairEntry.recordParams) && Intrinsics.areEqual(this.actionInfo, pairEntry.actionInfo);
        }
    }

    public static /* synthetic */ void O(ZPlanEmoticonUtil zPlanEmoticonUtil, ZPlanActionInfo zPlanActionInfo, String str, Priority priority, jh3.b bVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            priority = Priority.LOW;
        }
        if ((i3 & 8) != 0) {
            bVar = null;
        }
        zPlanEmoticonUtil.N(zPlanActionInfo, str, priority, bVar);
    }

    public static /* synthetic */ void Q(ZPlanEmoticonUtil zPlanEmoticonUtil, List list, Priority priority, Priority priority2, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            priority = Priority.LOW;
        }
        Priority priority3 = priority;
        if ((i16 & 4) != 0) {
            priority2 = Priority.LOW;
        }
        Priority priority4 = priority2;
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        zPlanEmoticonUtil.P(list, priority3, priority4, i3, z16);
    }

    public static final void S(ReentrantLock reentrantLock, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, int i3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, Ref.LongRef longRef, long j3, Function1<? super EmotionTabRecordReportData, Unit> function1) {
        reentrantLock.lock();
        try {
            int i16 = intRef.element;
            int i17 = intRef2.element;
            int i18 = intRef3.element;
            if (i16 + i17 + i18 == i3) {
                int i19 = intRef4.element;
                int i26 = intRef5.element;
                int i27 = intRef6.element;
                if (i19 + i26 + i27 == i3) {
                    EmotionTabRecordReportData emotionTabRecordReportData = new EmotionTabRecordReportData(i3, i16, i17, i18, i19, i26, i27, longRef.element, System.currentTimeMillis() - j3, 0, 0, 1536, null);
                    if (function1 != null) {
                        function1.invoke(emotionTabRecordReportData);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void U(ZPlanEmoticonUtil zPlanEmoticonUtil, ZPlanActionInfo zPlanActionInfo, String str, Priority priority, jh3.b bVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            priority = Priority.LOW;
        }
        if ((i3 & 8) != 0) {
            bVar = null;
        }
        zPlanEmoticonUtil.T(zPlanActionInfo, str, priority, bVar);
    }

    static /* synthetic */ SingleRecordRequestParams k0(ZPlanEmoticonUtil zPlanEmoticonUtil, ZPlanActionInfo zPlanActionInfo, String str, MODE mode, Priority priority, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            priority = Priority.LOW;
        }
        Priority priority2 = priority;
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        return zPlanEmoticonUtil.i0(zPlanActionInfo, str, mode, priority2, i3);
    }

    public static /* synthetic */ Object n0(ZPlanEmoticonUtil zPlanEmoticonUtil, ZPlanActionInfo zPlanActionInfo, String str, MODE mode, Priority priority, int i3, Continuation continuation, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            priority = Priority.LOW;
        }
        Priority priority2 = priority;
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        return zPlanEmoticonUtil.m0(zPlanActionInfo, str, mode, priority2, i3, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0138 A[LOOP:0: B:11:0x0132->B:13:0x0138, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0207 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j0(List<ZPlanActionInfo> list, String str, MODE mode, int i3, int i16, Priority priority, int i17, boolean z16, Continuation<? super BatchRecordRequestParams> continuation) {
        ZPlanEmoticonUtil$toResourceParam$1 zPlanEmoticonUtil$toResourceParam$1;
        Object coroutine_suspended;
        int i18;
        GeneralRecordSwitches generalRecordSwitchesByScene;
        EngineType h06;
        String str2;
        MODE mode2;
        Priority priority2;
        BusinessConfig businessConfig;
        int i19;
        int i26;
        int i27;
        boolean z17;
        List<ZPlanActionInfo> list2;
        ZPlanEmoticonUtil zPlanEmoticonUtil;
        int collectionSizeOrDefault;
        Iterator<T> it;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        Object firstOrNull;
        String str3;
        if (continuation instanceof ZPlanEmoticonUtil$toResourceParam$1) {
            zPlanEmoticonUtil$toResourceParam$1 = (ZPlanEmoticonUtil$toResourceParam$1) continuation;
            int i28 = zPlanEmoticonUtil$toResourceParam$1.label;
            if ((i28 & Integer.MIN_VALUE) != 0) {
                zPlanEmoticonUtil$toResourceParam$1.label = i28 - Integer.MIN_VALUE;
                Object obj = zPlanEmoticonUtil$toResourceParam$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i18 = zPlanEmoticonUtil$toResourceParam$1.label;
                if (i18 != 0) {
                    ResultKt.throwOnFailure(obj);
                    generalRecordSwitchesByScene = ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.EMOTICON);
                    h06 = h0(generalRecordSwitchesByScene.getRenderSwitches());
                    BusinessConfig businessConfig2 = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
                    businessConfig2.C(BusinessConfig.FrameType.PNG);
                    if (h06 != null) {
                        businessConfig2.G(h06);
                        businessConfig2.A(businessConfig2.getTargetEngine() instanceof EngineType.Filament ? Boxing.boxBoolean(true) : null);
                    }
                    businessConfig2.x(1);
                    businessConfig2.z(Boxing.boxBoolean(generalRecordSwitchesByScene.getRenderSwitches().getDisableGlassesMetallic()));
                    zPlanEmoticonUtil$toResourceParam$1.L$0 = this;
                    zPlanEmoticonUtil$toResourceParam$1.L$1 = list;
                    zPlanEmoticonUtil$toResourceParam$1.L$2 = str;
                    zPlanEmoticonUtil$toResourceParam$1.L$3 = mode;
                    zPlanEmoticonUtil$toResourceParam$1.L$4 = priority;
                    zPlanEmoticonUtil$toResourceParam$1.L$5 = generalRecordSwitchesByScene;
                    zPlanEmoticonUtil$toResourceParam$1.L$6 = h06;
                    zPlanEmoticonUtil$toResourceParam$1.L$7 = businessConfig2;
                    zPlanEmoticonUtil$toResourceParam$1.I$0 = i3;
                    zPlanEmoticonUtil$toResourceParam$1.I$1 = i16;
                    zPlanEmoticonUtil$toResourceParam$1.I$2 = i17;
                    zPlanEmoticonUtil$toResourceParam$1.Z$0 = z16;
                    zPlanEmoticonUtil$toResourceParam$1.label = 1;
                    Object u16 = u(str, zPlanEmoticonUtil$toResourceParam$1);
                    if (u16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                    mode2 = mode;
                    priority2 = priority;
                    businessConfig = businessConfig2;
                    i19 = i3;
                    i26 = i16;
                    i27 = i17;
                    z17 = z16;
                    list2 = list;
                    obj = u16;
                    zPlanEmoticonUtil = this;
                } else if (i18 == 1) {
                    boolean z18 = zPlanEmoticonUtil$toResourceParam$1.Z$0;
                    int i29 = zPlanEmoticonUtil$toResourceParam$1.I$2;
                    int i36 = zPlanEmoticonUtil$toResourceParam$1.I$1;
                    int i37 = zPlanEmoticonUtil$toResourceParam$1.I$0;
                    BusinessConfig businessConfig3 = (BusinessConfig) zPlanEmoticonUtil$toResourceParam$1.L$7;
                    h06 = (EngineType) zPlanEmoticonUtil$toResourceParam$1.L$6;
                    generalRecordSwitchesByScene = (GeneralRecordSwitches) zPlanEmoticonUtil$toResourceParam$1.L$5;
                    Priority priority3 = (Priority) zPlanEmoticonUtil$toResourceParam$1.L$4;
                    MODE mode3 = (MODE) zPlanEmoticonUtil$toResourceParam$1.L$3;
                    String str4 = (String) zPlanEmoticonUtil$toResourceParam$1.L$2;
                    list2 = (List) zPlanEmoticonUtil$toResourceParam$1.L$1;
                    zPlanEmoticonUtil = (ZPlanEmoticonUtil) zPlanEmoticonUtil$toResourceParam$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z17 = z18;
                    i27 = i29;
                    i26 = i36;
                    i19 = i37;
                    businessConfig = businessConfig3;
                    priority2 = priority3;
                    mode2 = mode3;
                    str2 = str4;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AvatarCharacterInfo avatarCharacterInfo = (AvatarCharacterInfo) obj;
                List<ZPlanActionInfo> list3 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(Boxing.boxInt(((ZPlanActionInfo) it.next()).getId()));
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (ZPlanActionInfo zPlanActionInfo : list3) {
                    Integer boxInt = Boxing.boxInt(zPlanActionInfo.getId());
                    BusinessConfig businessConfig4 = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
                    businessConfig4.C(businessConfig.getFrameType());
                    if (h06 != null) {
                        businessConfig4.G(h06);
                        businessConfig4.A(businessConfig4.getTargetEngine() instanceof EngineType.Filament ? Boxing.boxBoolean(true) : null);
                    }
                    businessConfig4.z(Boxing.boxBoolean(generalRecordSwitchesByScene.getRenderSwitches().getDisableGlassesMetallic()));
                    String stickerIdConf = zPlanActionInfo.getStickerIdConf();
                    if (stickerIdConf != null) {
                        if (!Boxing.boxBoolean(stickerIdConf.length() > 0).booleanValue()) {
                            stickerIdConf = null;
                        }
                        if (stickerIdConf != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(String.valueOf(zPlanActionInfo.getId()), stickerIdConf);
                            str3 = jSONObject.toString();
                            if (str3 != null) {
                                str3 = "";
                            }
                            businessConfig4.F(str3);
                            Pair pair = new Pair(boxInt, businessConfig4);
                            linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        }
                    }
                    str3 = null;
                    if (str3 != null) {
                    }
                    businessConfig4.F(str3);
                    Pair pair2 = new Pair(boxInt, businessConfig4);
                    linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
                }
                AppTheme appTheme = AppTheme.DAY;
                UploadConfig g06 = zPlanEmoticonUtil.g0(generalRecordSwitchesByScene.getCloudSwitches());
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                ZPlanActionInfo zPlanActionInfo2 = (ZPlanActionInfo) firstOrNull;
                BatchRecordRequestParams batchRecordRequestParams = new BatchRecordRequestParams(arrayList, linkedHashMap, appTheme, str2, null, i19, i26, mode2, businessConfig, 2, priority2, g06, null, i27, z17, zPlanActionInfo2 != null ? zPlanActionInfo2.getMetadataExtraJson() : null, null, 69632, null);
                batchRecordRequestParams.z(avatarCharacterInfo);
                return batchRecordRequestParams;
            }
        }
        zPlanEmoticonUtil$toResourceParam$1 = new ZPlanEmoticonUtil$toResourceParam$1(this, continuation);
        Object obj2 = zPlanEmoticonUtil$toResourceParam$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i18 = zPlanEmoticonUtil$toResourceParam$1.label;
        if (i18 != 0) {
        }
        AvatarCharacterInfo avatarCharacterInfo2 = (AvatarCharacterInfo) obj2;
        List<ZPlanActionInfo> list32 = list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list32, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        it = list32.iterator();
        while (it.hasNext()) {
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list32, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast);
        while (r1.hasNext()) {
        }
        AppTheme appTheme2 = AppTheme.DAY;
        UploadConfig g062 = zPlanEmoticonUtil.g0(generalRecordSwitchesByScene.getCloudSwitches());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
        ZPlanActionInfo zPlanActionInfo22 = (ZPlanActionInfo) firstOrNull;
        BatchRecordRequestParams batchRecordRequestParams2 = new BatchRecordRequestParams(arrayList2, linkedHashMap2, appTheme2, str2, null, i19, i26, mode2, businessConfig, 2, priority2, g062, null, i27, z17, zPlanActionInfo22 != null ? zPlanActionInfo22.getMetadataExtraJson() : null, null, 69632, null);
        batchRecordRequestParams2.z(avatarCharacterInfo2);
        return batchRecordRequestParams2;
    }
}
