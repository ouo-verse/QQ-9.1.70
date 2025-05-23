package com.tencent.sqshow.zootopia.nativeui.ue;

import android.os.Handler;
import b94.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskExtInfo;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.util.AppSetting;
import com.tencent.util.QQToastUtil;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import m94.DressControllerInitData;
import m94.DressErrorMsg;
import m94.DressHistoryChangeInfo;
import uv4.ak;
import uv4.al;
import uv4.az;

@Metadata(d1 = {"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0094\u0001B\u0011\u0012\u0006\u0010h\u001a\u00020e\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J,\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0003J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010#\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010%H\u0016J(\u0010)\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000fH\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020\u000b2\u0006\u0010\f\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010<\u001a\u00020\u000b2\u0006\u00109\u001a\u0002082\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010;\u001a\u00020:H\u0016J.\u0010A\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002080=2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010;\u001a\u00020:2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010G\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010J\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020H2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010K\u001a\u00020HH\u0016J\u0010\u0010L\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010O\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010P\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010R\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u000fH\u0016J \u0010S\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000fH\u0016J.\u0010W\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00042\f\u0010T\u001a\b\u0012\u0004\u0012\u0002080=2\u0006\u0010V\u001a\u00020U2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J,\u0010X\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010Y\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010Z\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\\\u001a\u00020\u000f2\u0006\u00109\u001a\u000208H\u0016J\u0016\u0010]\u001a\u00020\u000f2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002080=H\u0016J\b\u0010^\u001a\u00020\u000bH\u0016J\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0014H\u0016J\u0018\u0010a\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010F\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000bH\u0016J\u001e\u0010d\u001a\u00020U2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0=2\u0006\u0010\"\u001a\u00020!H\u0016R\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR$\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u00160pj\b\u0012\u0004\u0012\u00020\u0016`q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\u001c0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0084\u0001\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010kR\u0016\u0010\u0086\u0001\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010kR\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u00a8\u0006\u0095\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/PortalStoreAvatarDressController;", "Lcom/tencent/zplan/luabridge/a$b;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Lb94/d;", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "targetGender", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "requestCb", "Ljava/lang/Runnable;", "taskAfterRequest", "", "l", "Luv4/ak;", "avatarData", "", "clearDressHistory", "skipUpdateDataCenter", "refreshCurrentDress", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "targetIndex", "Lm94/h;", "cb", ReportConstant.COSTREPORT_PREFIX, "Lm94/i;", "k", "y", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "p", "j", DomainData.DOMAIN_NAME, "Lm94/a;", IZplanHandleApi.BUSINESS_DRESS_INFO, "t", "o", "Lm94/d;", "initData", "c8", "getInitData", UinConfigManager.KEY_HB, "Luv4/al;", "avatarInfo", "gender", "Mc", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "success", "engineInitFinish", "Lm94/k;", "v9", "ce", "Luv4/az;", "storeItem", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lf", "", "storeItemList", "", "extInfo", "J9", "Y6", "E9", "Lqu4/j;", "faceInfo", "addToHistory", "F6", "Lqu4/c;", "colorInfo", "Q8", "pb", "v8", "Ob", "targetSlot", "q9", "ke", "waitingUeCallback", "O6", "Gg", VideoTemplateParser.ITEM_LIST, "Lqu4/a;", "avatarCharacter", "Bg", "L4", "J8", "B8", "ve", "Kf", "r", "j1", "targetHistoryIndex", ICustomDataEditor.NUMBER_PARAM_5, "Nc", "destroy", "itemUniqueIds", "E4", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "panelRepo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mDressingLock", "f", "Lm94/k;", "mSelfDressChangeListener", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Ljava/util/HashSet;", "mDressClothesListenerPool", "Ljava/util/LinkedList;", "i", "Ljava/util/LinkedList;", "mWaitDressTask", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "mCurrentTask", BdhLogUtil.LogTag.Tag_Conn, "Luv4/ak;", "mAvatarData", "Lm94/g;", "D", "Lm94/g;", "mHistoryData", "E", "mAvatarDataInitState", UserInfo.SEX_FEMALE, "mServiceConnected", "G", "Lm94/d;", "mInitData", "H", "Z", "mChangeGenderTaskRunning", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "I", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "mDressTaskChannel", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;)V", "J", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class PortalStoreAvatarDressController implements a.b, ZPlanEngineStatusUpdateListener, b94.d {

    /* renamed from: C, reason: from kotlin metadata */
    private ak mAvatarData;

    /* renamed from: D, reason: from kotlin metadata */
    private final m94.g mHistoryData;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicBoolean mAvatarDataInitState;

    /* renamed from: F, reason: from kotlin metadata */
    private final AtomicBoolean mServiceConnected;

    /* renamed from: G, reason: from kotlin metadata */
    private DressControllerInitData mInitData;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mChangeGenderTaskRunning;

    /* renamed from: I, reason: from kotlin metadata */
    private DressTaskChannel mDressTaskChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.repo.p panelRepo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mDressingLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private m94.k mSelfDressChangeListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final HashSet<m94.h> mDressClothesListenerPool;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<com.tencent.sqshow.zootopia.nativeui.data.dress.task.b> mWaitDressTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.dress.task.b mCurrentTask;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371318a;

        static {
            int[] iArr = new int[UEAvatarGender.values().length];
            try {
                iArr[UEAvatarGender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UEAvatarGender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371318a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/PortalStoreAvatarDressController$c", "Lm94/i;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends m94.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m94.h f371319b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PortalStoreAvatarDressController f371320c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(m94.h hVar, PortalStoreAvatarDressController portalStoreAvatarDressController) {
            super(hVar);
            this.f371319b = hVar;
            this.f371320c = portalStoreAvatarDressController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(PortalStoreAvatarDressController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(PortalStoreAvatarDressController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y();
        }

        @Override // m94.i, m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.e("PortalStoreAvatarDressController_", 1, "DressClothesCallback#onError id:" + task.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() + ", errorMsg:" + errorMsg);
            this.f371320c.mCurrentTask = null;
            this.f371320c.mDressingLock.set(false);
            this.f371319b.a(task, errorMsg);
            Iterator it = this.f371320c.mDressClothesListenerPool.iterator();
            while (it.hasNext()) {
                ((m94.h) it.next()).a(task, errorMsg);
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PortalStoreAvatarDressController portalStoreAvatarDressController = this.f371320c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.y
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreAvatarDressController.c.f(PortalStoreAvatarDressController.this);
                }
            });
        }

        @Override // m94.i, m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("PortalStoreAvatarDressController_", 1, "DressClothesCallback#onSuccess id:" + task.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
            this.f371320c.mCurrentTask = null;
            this.f371320c.mDressingLock.set(false);
            this.f371319b.b(task);
            Iterator it = this.f371320c.mDressClothesListenerPool.iterator();
            while (it.hasNext()) {
                ((m94.h) it.next()).b(task);
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PortalStoreAvatarDressController portalStoreAvatarDressController = this.f371320c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.z
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreAvatarDressController.c.g(PortalStoreAvatarDressController.this);
                }
            });
            this.f371320c.o(task);
        }
    }

    public PortalStoreAvatarDressController(com.tencent.sqshow.zootopia.nativeui.data.repo.p panelRepo) {
        Intrinsics.checkNotNullParameter(panelRepo, "panelRepo");
        this.panelRepo = panelRepo;
        this.mDressingLock = new AtomicBoolean(false);
        this.mDressClothesListenerPool = new HashSet<>();
        this.mWaitDressTask = new LinkedList<>();
        this.mHistoryData = new m94.g(null, 0, 3, null);
        this.mAvatarDataInitState = new AtomicBoolean(false);
        this.mServiceConnected = new AtomicBoolean(false);
        this.mDressTaskChannel = new DressTaskChannel(null, null, 3, null);
        if (FilamentApiImpl.f369933a.d()) {
            return;
        }
        ZPlanServiceHelper.I.E0(this);
    }

    private final void j() {
        int size = this.mWaitDressTask.size();
        QLog.i("PortalStoreAvatarDressController_", 1, "checkWaitingTaskLength currentLength:" + size);
        if (size <= 5) {
            return;
        }
        while (this.mWaitDressTask.size() > 5) {
            com.tencent.sqshow.zootopia.nativeui.data.dress.task.b pollLast = this.mWaitDressTask.pollLast();
            if (pollLast != null) {
                pollLast.getCallback().getOriginCb().a(pollLast, DressErrorMsg.INSTANCE.f());
            }
        }
    }

    private final m94.i k(m94.h cb5) {
        return new c(cb5, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PortalStoreAvatarDressController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d.a.h(this$0, m94.b.f416465a, false, false, 6, null);
    }

    private final void n(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        boolean z16;
        boolean z17 = this.mDressingLock.get();
        boolean z18 = this.mAvatarDataInitState.get();
        if (!this.mServiceConnected.get()) {
            b94.a engineApi = this.mDressTaskChannel.getEngineApi();
            if ((engineApi != null ? engineApi.getType() : null) != AvatarEngineType.FILAMENT) {
                z16 = false;
                if (z17 && z16 && z18) {
                    this.mDressingLock.set(true);
                    this.mCurrentTask = task;
                    task.i(this);
                    return;
                }
                QLog.w("PortalStoreAvatarDressController_", 1, "handleDressTask dressingLock:" + z17 + ", avatarDataInitState:" + z18 + ", serviceConnected:" + z16);
                p(task);
            }
        }
        z16 = true;
        if (z17) {
        }
        QLog.w("PortalStoreAvatarDressController_", 1, "handleDressTask dressingLock:" + z17 + ", avatarDataInitState:" + z18 + ", serviceConnected:" + z16);
        p(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        String str;
        String h16;
        String str2;
        ZootopiaSource source;
        Object orNull;
        String K;
        String str3 = "";
        if (task instanceof com.tencent.sqshow.zootopia.nativeui.data.dress.task.h) {
            com.tencent.sqshow.zootopia.nativeui.data.dress.task.h hVar = (com.tencent.sqshow.zootopia.nativeui.data.dress.task.h) task;
            if (!hVar.getMIsUnderDressTask()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(hVar.l(), 0);
                az azVar = (az) orNull;
                if (azVar != null && (K = r94.b.K(azVar)) != null) {
                    str3 = K;
                }
                str = String.valueOf(azVar != null ? r94.b.J(azVar) : null);
                if (str3.length() == 0) {
                    UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
                    HashMap hashMap = new HashMap();
                    hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                    DressControllerInitData dressControllerInitData = this.mInitData;
                    if (dressControllerInitData == null || (source = dressControllerInitData.getSource()) == null || (h16 = ah.b(source)) == null) {
                        h16 = ZPlanAvatarPreDownloadManager.f371947a.h();
                    }
                    hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, h16);
                    hashMap.put("zplan_item_id", str3);
                    hashMap.put("zplan_gender", Integer.valueOf(n3.getIndex()));
                    if (Intrinsics.areEqual(task.getDressTaskChannel().getExtInfo(), DressTaskExtInfo.AI_MAKE_FACE)) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    hashMap.put("zplan_is_ai_sculpt", str2);
                    hashMap.put("zplan_ext_info", str);
                    VideoReport.reportEvent("ev_zplan_try_clothes_click", null, hashMap);
                    QLog.i("PortalStoreAvatarDressController_", 1, "handleTaskSucceedReport params:" + hashMap);
                    return;
                }
                return;
            }
        }
        str = "";
        if (str3.length() == 0) {
        }
    }

    private final void p(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        Object obj;
        Iterator<T> it = this.mWaitDressTask.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.sqshow.zootopia.nativeui.data.dress.task.b) obj).getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), task.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String())) {
                    break;
                }
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b bVar = (com.tencent.sqshow.zootopia.nativeui.data.dress.task.b) obj;
        if (bVar != null && (bVar instanceof com.tencent.sqshow.zootopia.nativeui.data.dress.task.h)) {
            task.getCallback().b(task);
            ((com.tencent.sqshow.zootopia.nativeui.data.dress.task.h) bVar).getCallback().b(task);
        } else {
            this.mWaitDressTask.addFirst(task);
            j();
        }
    }

    private final void s(int targetIndex, m94.h cb5) {
        List list;
        QLog.i("PortalStoreAvatarDressController_", 1, "moveToHistory targetIndex:" + targetIndex + ", mHistoryCursor:" + this.mHistoryData.getHistoryCursor() + ", historySize:" + this.mHistoryData.h());
        if (this.mHistoryData.h() == 0) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.b());
            return;
        }
        if (targetIndex < 0) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.c());
            return;
        }
        if (targetIndex >= this.mHistoryData.h()) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.d());
            return;
        }
        m94.a g16 = this.mHistoryData.g(targetIndex);
        DressTaskChannel dressTaskChannel = this.mDressTaskChannel;
        list = CollectionsKt___CollectionsKt.toList(g16.b().values());
        n(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.g(dressTaskChannel, r94.b.j(list), k(cb5), targetIndex, g16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PortalStoreAvatarDressController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(PortalStoreAvatarDressController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b pollLast = this.mWaitDressTask.pollLast();
        if (pollLast == null) {
            return;
        }
        QLog.i("PortalStoreAvatarDressController_", 1, "triggerNexTask last:" + pollLast);
        n(pollLast);
    }

    @Override // b94.d
    public void B8(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new q94.c(this.mDressTaskChannel, k(cb5)));
    }

    @Override // b94.d
    public void Bg(UEAvatarGender gender, List<az> itemList, qu4.a avatarCharacter, m94.h cb5) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.f(this.mDressTaskChannel, r94.b.j(itemList), k(cb5), gender, itemList, avatarCharacter));
    }

    @Override // b94.d
    public qu4.a E4(List<String> itemUniqueIds, m94.a dressInfo) {
        Intrinsics.checkNotNullParameter(itemUniqueIds, "itemUniqueIds");
        Intrinsics.checkNotNullParameter(dressInfo, "dressInfo");
        return p.f371394a.b(itemUniqueIds, dressInfo);
    }

    @Override // b94.d
    public void E9(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        s(this.mHistoryData.getHistoryCursor() + 1, cb5);
    }

    @Override // b94.d
    public void F6(qu4.j faceInfo, boolean addToHistory, m94.h cb5) {
        Intrinsics.checkNotNullParameter(faceInfo, "faceInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new p94.a(this.mDressTaskChannel, faceInfo, k(cb5), addToHistory));
    }

    @Override // b94.d
    public void Gg(m94.h cb5, boolean waitingUeCallback, boolean addToHistory) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.i(this.mDressTaskChannel, k(cb5), waitingUeCallback, addToHistory));
    }

    @Override // b94.d
    public void J8(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new q94.b(this.mDressTaskChannel, k(cb5)));
    }

    @Override // b94.d
    public void J9(List<az> storeItemList, m94.h cb5, NormalDressStrategy strategy, String extInfo) {
        Object orNull;
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.h hVar = new com.tencent.sqshow.zootopia.nativeui.data.dress.task.h(DressTaskChannel.b(this.mDressTaskChannel, null, extInfo, 1, null), r94.b.j(storeItemList), k(cb5), storeItemList, strategy);
        orNull = CollectionsKt___CollectionsKt.getOrNull(storeItemList, 0);
        az azVar = (az) orNull;
        if (azVar == null) {
            return;
        }
        UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
        if (r94.b.B(n3, Integer.valueOf(azVar.f440296w))) {
            QLog.e("PortalStoreAvatarDressController_", 1, "gender invalid, curGender = " + n3 + ", dstRole = " + azVar.f440296w);
            QQToastUtil.showQQToast(1, R.string.xru);
            cb5.a(hVar, DressErrorMsg.INSTANCE.a());
            return;
        }
        n(hVar);
    }

    @Override // b94.d
    public boolean Kf(az storeItem) {
        List<az> listOf;
        Intrinsics.checkNotNullParameter(storeItem, "storeItem");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(storeItem);
        return r(listOf);
    }

    @Override // b94.d
    public void L4(UEAvatarGender targetGender, com.tencent.mobileqq.zootopia.api.e<uv4.w> requestCb, Runnable taskAfterRequest) {
        if (this.mChangeGenderTaskRunning) {
            QLog.i("PortalStoreAvatarDressController_", 1, "changeGender mChangeGenderTaskRunning running!");
        } else {
            l(targetGender, requestCb, taskAfterRequest);
        }
    }

    @Override // b94.d
    public void Lf(az storeItem, m94.h cb5, NormalDressStrategy strategy) {
        List listOf;
        Intrinsics.checkNotNullParameter(storeItem, "storeItem");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(storeItem);
        d.a.d(this, listOf, cb5, strategy, null, 8, null);
    }

    @Override // b94.d
    public void Mc(al avatarInfo, UEAvatarGender gender) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(gender, "gender");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        m94.a O = r94.b.O(avatarInfo, gender, cVar.x());
        QLog.i("PortalStoreAvatarDressController_", 1, "updateCurrentSavedAvatar itemMap => " + O);
        QLog.i("PortalStoreAvatarDressController_", 1, "updateCurrentSavedAvatar " + r94.c.A(O.getAvatarCharacter()));
        cVar.e().e(gender);
        cVar.d().e(O);
        if (cVar.w().b().getGender() == gender) {
            cVar.w().e(O);
        }
        boolean c16 = r94.a.c(cVar.m().b().getAvatarCharacter(), O.getAvatarCharacter());
        if (!c16) {
            O6(m94.b.f416465a, false);
            if (!AppSetting.isPublicVersion()) {
                QQToastUtil.showQQToast(1, "\u8bf7\u6c42\u7684\u4fdd\u5b58\u7684\u6570\u636e\u548c\u5b9e\u9645\u4fdd\u5b58\u7684\u6570\u636e\u4e0d\u4e00\u81f4!");
            }
        }
        QLog.i("PortalStoreAvatarDressController_", 1, "current => saved is the same = " + c16);
    }

    @Override // b94.d
    public void Nc(m94.a dressInfo, boolean addToHistory) {
        int checkRadix;
        int checkRadix2;
        List list;
        Intrinsics.checkNotNullParameter(dressInfo, "dressInfo");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.m().e(dressInfo);
        if (addToHistory) {
            if (this.mHistoryData.c(dressInfo)) {
                t(this.mHistoryData.getHistoryCursor() + 1, dressInfo);
            } else {
                QLog.w("PortalStoreAvatarDressController_", 1, "updateDressInfo canAddToHistory is false. dressInfo is same with current history!");
            }
        }
        HashSet<Integer> x16 = cVar.x();
        HashSet<String> hashSet = new HashSet<>();
        for (az azVar : dressInfo.b().values()) {
            hashSet.addAll(r94.b.f(azVar));
            int[] iArr = azVar.f440290q.f440325b;
            if (iArr != null) {
                Intrinsics.checkNotNullExpressionValue(iArr, "item.slot.occupancySlots");
                list = ArraysKt___ArraysKt.toList(iArr);
                x16.addAll(list);
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.l().e(hashSet);
        String aVar = dressInfo.toString();
        int hashCode = aVar.hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        QLog.i("PortalStoreAvatarDressController_", 1, "updateDressInfo dressInfo:" + num + "," + aVar);
        int hashCode2 = hashSet.hashCode();
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
        String num2 = Integer.toString(hashCode2, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
        QLog.i("PortalStoreAvatarDressController_", 1, "updateDressInfo dressInfo ids:" + num2 + "," + hashSet);
        m94.k kVar = this.mSelfDressChangeListener;
        if (kVar != null) {
            kVar.m0(new ArrayList(hashSet));
        }
    }

    @Override // b94.d
    public void O6(m94.h cb5, boolean waitingUeCallback) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.j(this.mDressTaskChannel, k(cb5), waitingUeCallback));
    }

    @Override // b94.d
    public void Ob(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new o94.c(this.mDressTaskChannel, k(cb5)));
    }

    public void Q8(qu4.c colorInfo, boolean addToHistory, m94.h cb5) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new n94.a(this.mDressTaskChannel, colorInfo, k(cb5), addToHistory));
    }

    @Override // b94.d
    public void Y6(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        s(this.mHistoryData.getHistoryCursor() - 1, cb5);
    }

    @Override // b94.d
    public void c8(DressControllerInitData initData) {
        Intrinsics.checkNotNullParameter(initData, "initData");
        this.mInitData = initData;
        this.mDressTaskChannel.e(initData.getEngineApi());
    }

    @Override // b94.d
    public void ce(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.mDressClothesListenerPool.add(cb5);
    }

    @Override // b94.d
    public void destroy() {
        this.mDressClothesListenerPool.clear();
        this.mSelfDressChangeListener = null;
        this.mWaitDressTask.clear();
        ZPlanServiceHelper.I.a1(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        QLog.i("PortalStoreAvatarDressController_", 1, "engineInitFinish success:" + success);
        if (success) {
            return;
        }
        this.mServiceConnected.set(false);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    @Override // b94.d
    /* renamed from: getInitData, reason: from getter */
    public DressControllerInitData getMInitData() {
        return this.mInitData;
    }

    @Override // b94.d
    public void hb(ak avatarData, boolean clearDressHistory, boolean skipUpdateDataCenter, boolean refreshCurrentDress) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        this.mAvatarDataInitState.set(false);
        this.mAvatarData = avatarData;
        q(avatarData, clearDressHistory, skipUpdateDataCenter, refreshCurrentDress);
        this.mAvatarDataInitState.set(true);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.w
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreAvatarDressController.w(PortalStoreAvatarDressController.this);
            }
        });
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // b94.d
    public void j1() {
        this.mHistoryData.i();
        m94.k kVar = this.mSelfDressChangeListener;
        if (kVar != null) {
            kVar.U(new DressHistoryChangeInfo(0, this.mHistoryData, 1, null));
        }
    }

    @Override // b94.d
    public void ke(int targetSlot, m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new n94.c(this.mDressTaskChannel, targetSlot, k(cb5)));
    }

    @Override // com.tencent.zplan.luabridge.a.b
    public void onExecuteLua() {
        a.b.C10064a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("PortalStoreAvatarDressController_", 1, "onFirstFrame");
    }

    @Override // com.tencent.zplan.luabridge.a.b
    public void onLuaResult(boolean z16, String str) {
        a.b.C10064a.b(this, z16, str);
    }

    @Override // b94.d
    public qu4.c pb() {
        qu4.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter().f429575d;
        if (cVar == null) {
            cVar = new qu4.c();
        }
        return bj3.a.i(cVar);
    }

    @Override // b94.d
    public void q9(int targetSlot, m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new n94.d(this.mDressTaskChannel, targetSlot, k(cb5)));
    }

    public boolean r(List<az> storeItemList) {
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        String j3 = r94.b.j(storeItemList);
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b bVar = this.mCurrentTask;
        if (Intrinsics.areEqual(bVar != null ? bVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() : null, j3)) {
            return true;
        }
        Iterator<T> it = this.mWaitDressTask.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((com.tencent.sqshow.zootopia.nativeui.data.dress.task.b) it.next()).getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), j3)) {
                return true;
            }
        }
        return false;
    }

    @Override // b94.d
    public void s0(UEAvatarGender uEAvatarGender, com.tencent.mobileqq.zootopia.api.e<uv4.u> eVar, Runnable runnable) {
        d.a.a(this, uEAvatarGender, eVar, runnable);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        QLog.i("PortalStoreAvatarDressController_", 1, "connect:" + connect);
        this.mServiceConnected.set(connect);
        if (connect) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.v
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreAvatarDressController.x(PortalStoreAvatarDressController.this);
                }
            });
        }
    }

    @Override // b94.d
    public void v8(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new o94.b(this.mDressTaskChannel, k(cb5)));
    }

    @Override // b94.d
    public void v9(m94.k l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mSelfDressChangeListener = l3;
    }

    @Override // b94.d
    public void ve(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(new q94.d(this.mDressTaskChannel, k(cb5)));
    }

    @Override // b94.d
    public void n5(int targetHistoryIndex) {
        u(this, targetHistoryIndex, null, 2, null);
    }

    private final void t(int targetIndex, m94.a dressInfo) {
        int i3;
        int checkRadix;
        if (dressInfo != null) {
            this.mHistoryData.k(targetIndex, dressInfo);
            i3 = 2;
        } else {
            this.mHistoryData.j(targetIndex);
            i3 = 1;
        }
        m94.k kVar = this.mSelfDressChangeListener;
        if (kVar != null) {
            kVar.U(new DressHistoryChangeInfo(i3, this.mHistoryData));
        }
        String valueOf = String.valueOf(dressInfo);
        m94.g gVar = this.mHistoryData;
        int hashCode = valueOf.hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        QLog.i("PortalStoreAvatarDressController_", 1, "recordHistory(). newHistoryData:" + gVar + ", targetIndex:" + targetIndex + ", dressInfo:" + num + "," + valueOf);
    }

    private final void q(ak avatarData, boolean clearDressHistory, boolean skipUpdateDataCenter, boolean refreshCurrentDress) {
        if (refreshCurrentDress && !skipUpdateDataCenter) {
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.z(avatarData);
        } else {
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.C(avatarData);
        }
        if (clearDressHistory) {
            this.mHistoryData.e();
            m94.k kVar = this.mSelfDressChangeListener;
            if (kVar != null) {
                kVar.U(new DressHistoryChangeInfo(0, this.mHistoryData, 1, null));
            }
        }
        if (refreshCurrentDress) {
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            m94.a b16 = cVar.d().b();
            m94.a b17 = cVar.m().b();
            Nc(b17, this.mHistoryData.getHistoryCursor() == -1);
            long currentTimeMillis = System.currentTimeMillis();
            boolean c16 = r94.a.c(b17.getAvatarCharacter(), b16.getAvatarCharacter());
            QLog.i("PortalStoreAvatarDressController_", 1, "default:" + cVar.p().b());
            QLog.i("PortalStoreAvatarDressController_", 1, "init:" + cVar.q().b());
            QLog.i("PortalStoreAvatarDressController_", 1, "currentSaved:" + cVar.d().b());
            QLog.i("PortalStoreAvatarDressController_", 1, "current:" + cVar.m().b());
            QLog.i("PortalStoreAvatarDressController_", 1, "initDressMap end. isSame:" + c16 + ", duration:" + (System.currentTimeMillis() - currentTimeMillis) + ", clearDressHistory:" + clearDressHistory);
        }
    }

    private final void l(UEAvatarGender targetGender, final com.tencent.mobileqq.zootopia.api.e<uv4.w> requestCb, Runnable taskAfterRequest) {
        UEAvatarGender uEAvatarGender;
        AvatarEngineType avatarEngineType;
        b94.a engineApi;
        String schemeParams;
        String brandId;
        UEAvatarGender uEAvatarGender2;
        this.mChangeGenderTaskRunning = true;
        UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
        if (targetGender == null) {
            int i3 = b.f371318a[n3.ordinal()];
            if (i3 == 1) {
                uEAvatarGender2 = UEAvatarGender.FEMALE;
            } else if (i3 == 2) {
                uEAvatarGender2 = UEAvatarGender.MALE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            uEAvatarGender = uEAvatarGender2;
        } else {
            uEAvatarGender = targetGender;
        }
        QLog.i("PortalStoreAvatarDressController_", 1, "changeGender currentGender:" + n3 + ", finalTargetGender:" + uEAvatarGender);
        if (uEAvatarGender == n3) {
            if (requestCb != null) {
                requestCb.onResultSuccess(new uv4.w());
            }
            if (taskAfterRequest != null) {
                taskAfterRequest.run();
            }
            this.mChangeGenderTaskRunning = false;
            return;
        }
        final Runnable runnable = taskAfterRequest == null ? new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.x
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreAvatarDressController.m(PortalStoreAvatarDressController.this);
            }
        } : taskAfterRequest;
        com.tencent.mobileqq.zootopia.api.e<uv4.w> eVar = new com.tencent.mobileqq.zootopia.api.e<uv4.w>() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController$handleChangeGender$netCb$1
            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(uv4.w result) {
                Intrinsics.checkNotNullParameter(result, "result");
                t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController$handleChangeGender$netCb$1$onResultSuccess$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        QQToast.makeText(BaseApplication.context, 2, "\u6027\u522b\u5207\u6362\u6210\u529f", 0).show();
                    }
                });
                runnable.run();
                com.tencent.mobileqq.zootopia.api.e<uv4.w> eVar2 = requestCb;
                if (eVar2 != null) {
                    eVar2.onResultSuccess(result);
                }
                this.mChangeGenderTaskRunning = false;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.PortalStoreAvatarDressController$handleChangeGender$netCb$1$onResultFailure$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        QQToast.makeText(BaseApplication.context, 1, "\u6027\u522b\u5207\u6362\u5931\u8d25", 0).show();
                    }
                });
                this.mChangeGenderTaskRunning = false;
                com.tencent.mobileqq.zootopia.api.e<uv4.w> eVar2 = requestCb;
                if (eVar2 != null) {
                    eVar2.onResultFailure(error, message);
                }
            }
        };
        com.tencent.sqshow.zootopia.nativeui.data.repo.p pVar = this.panelRepo;
        DressControllerInitData dressControllerInitData = this.mInitData;
        String str = (dressControllerInitData == null || (brandId = dressControllerInitData.getBrandId()) == null) ? "" : brandId;
        DressControllerInitData dressControllerInitData2 = this.mInitData;
        String str2 = (dressControllerInitData2 == null || (schemeParams = dressControllerInitData2.getSchemeParams()) == null) ? "" : schemeParams;
        DressControllerInitData dressControllerInitData3 = this.mInitData;
        int reqSource = dressControllerInitData3 != null ? dressControllerInitData3.getReqSource() : 0;
        DressControllerInitData dressControllerInitData4 = this.mInitData;
        if (dressControllerInitData4 == null || (engineApi = dressControllerInitData4.getEngineApi()) == null || (avatarEngineType = engineApi.getType()) == null) {
            avatarEngineType = AvatarEngineType.UE;
        }
        com.tencent.sqshow.zootopia.nativeui.data.repo.p.i(pVar, str, uEAvatarGender, eVar, true, str2, reqSource, avatarEngineType, false, null, false, 896, null);
    }

    static /* synthetic */ void u(PortalStoreAvatarDressController portalStoreAvatarDressController, int i3, m94.a aVar, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                aVar = null;
            }
            portalStoreAvatarDressController.t(i3, aVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordHistory");
    }
}
