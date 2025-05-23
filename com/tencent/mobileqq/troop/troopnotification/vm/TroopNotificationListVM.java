package com.tencent.mobileqq.troop.troopnotification.vm;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationDetailFragment;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationListRepo;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationOperateRepo;
import com.tencent.mobileqq.troop.troopnotification.utils.g;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$notificationChangeObserver$2;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$notificationObserver$2;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.c;
import com.tencent.qqnt.notification.f;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\n*\u0004\u0092\u0001\u0097\u0001\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009f\u0001B\t\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0002J(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\"\u0010\u0013\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J$\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bJ\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007J\u001e\u00104\u001a\u00020\u00022\u0006\u00101\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u00103\u001a\u000202J\u0018\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u0005J\u0006\u00108\u001a\u00020\u0002J\u000e\u00109\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010J\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u0010NR\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR%\u0010Z\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020Q\u0018\u00010P0U8\u0006\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001f\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0U8\u0006\u00a2\u0006\f\n\u0004\b_\u0010W\u001a\u0004\b`\u0010YR\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010cR\u001f\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0U8\u0006\u00a2\u0006\f\n\u0004\be\u0010W\u001a\u0004\bf\u0010YR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020h0U8\u0006\u00a2\u0006\f\n\u0004\bl\u0010W\u001a\u0004\bm\u0010YR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020\r0U8\u0006\u00a2\u0006\f\n\u0004\bo\u0010W\u001a\u0004\bp\u0010YR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR/\u0010x\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040U8\u0006\u00a2\u0006\f\n\u0004\bv\u0010W\u001a\u0004\bw\u0010YR&\u0010|\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R/\u0010\u007f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y0U8\u0006\u00a2\u0006\f\n\u0004\b}\u0010W\u001a\u0004\b~\u0010YR(\u0010\u0081\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010{R2\u0010\u0084\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y0U8\u0006\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010W\u001a\u0005\b\u0083\u0001\u0010YR\u001f\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001d\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00068\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R&\u0010\u008d\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008a\u0001\u0010G\u001a\u0005\b\u008b\u0001\u0010I\"\u0005\b\u008c\u0001\u0010NR\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0096\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010?\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R \u0010\u009b\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0098\u0001\u0010?\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "Landroidx/lifecycle/ViewModel;", "", "K2", "", "", "", "Lcom/tencent/qqnt/notification/f;", "dataMap", "O2", "category", "", "dataList", "", "needPost", "u2", "needPostRecent", "needPostHistory", Constants.MMCCID, "L2", "R2", "P2", "msg", "E2", "newMsg", Constants.BASE_IN_PLUGIN_VERSION, "B2", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/os/Bundle;", "args", "Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/d;", "processors", "z2", "destroy", "H2", "N2", "S2", ICustomDataEditor.STRING_PARAM_2, com.tencent.luggage.wxa.c8.c.G, ICustomDataEditor.NUMBER_PARAM_2, "categoryIndex", "t2", "r2", "Landroid/content/Context;", "context", "C2", "c2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "clickData", "F2", "reportCategory", "dataCategory", "I2", "b2", "x2", "i2", "w2", "y2", "Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo;", "i", "Lkotlin/Lazy;", "m2", "()Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo;", "repo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "I", "e2", "()I", IProfileCardConst.KEY_FROM_TYPE, "D", "getSource", "setSource", "(I)V", "source", "", "", "E", "[Ljava/lang/String;", "_tabTitle", "Lcom/tencent/mobileqq/troop/troopnotification/utils/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopnotification/utils/a;", "p2", "()Lcom/tencent/mobileqq/troop/troopnotification/utils/a;", "tabTitle", "", "G", "[Z", "_tabRedState", "H", "o2", "tabRedState", "", "[I", "_tabVisibility", "J", "q2", "tabVisibility", "Landroid/util/SparseBooleanArray;", "K", "Landroid/util/SparseBooleanArray;", "_hasMore", "L", "f2", "hasMore", "M", NowProxyConstants.AccountInfoKey.A2, "isAllEmpty", "Lcom/tencent/qqnt/notification/c;", "N", "Lcom/tencent/qqnt/notification/c;", "cacheInfo", "P", "j2", "notificationMap", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", "_historyNotificationMap", BdhLogUtil.LogTag.Tag_Req, "g2", "historyNotificationMap", ExifInterface.LATITUDE_SOUTH, "_recentNotificationMap", "T", "l2", "recentNotificationMap", "U", "Ljava/util/List;", "categoryProcessor", "V", "visibleTabProcessor", "W", "d2", "Q2", "currentCategory", "Landroid/util/SparseLongArray;", "X", "Landroid/util/SparseLongArray;", "lastReadSeqMap", "com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationObserver$2$a", "Y", "k2", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationObserver$2$a;", "notificationObserver", "com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationChangeObserver$2$a", "Z", SemanticAttributes.DbSystemValues.H2, "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationChangeObserver$2$a;", "notificationChangeObserver", "<init>", "()V", "a0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationListVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int fromType;

    /* renamed from: D, reason: from kotlin metadata */
    private int source;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String[] _tabTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<String[]> tabTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private boolean[] _tabRedState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<boolean[]> tabRedState;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private int[] _tabVisibility;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<int[]> tabVisibility;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private SparseBooleanArray _hasMore;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<SparseBooleanArray> hasMore;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<Boolean> isAllEmpty;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.c cacheInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> notificationMap;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, List<f>> _historyNotificationMap;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> historyNotificationMap;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, List<f>> _recentNotificationMap;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> recentNotificationMap;

    /* renamed from: U, reason: from kotlin metadata */
    private List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> categoryProcessor;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopnotification.vm.processor.d> visibleTabProcessor;

    /* renamed from: W, reason: from kotlin metadata */
    private int currentCategory;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private SparseLongArray lastReadSeqMap;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy notificationObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy notificationChangeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "a", "", "KEY_SOURCE_FOR_VM", "Ljava/lang/String;", "", "NOTIFICATION_TIME_LIMIT", "J", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TroopNotificationListVM a(@NotNull ViewModelStoreOwner owner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopNotificationListVM) iPatchRedirector.redirect((short) 2, (Object) this, (Object) owner);
            }
            Intrinsics.checkNotNullParameter(owner, "owner");
            ViewModel viewModel = new ViewModelProvider(owner).get(TroopNotificationListVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026cationListVM::class.java)");
            return (TroopNotificationListVM) viewModel;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationListVM() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationListVM$repo$2.INSTANCE);
            this.repo = lazy;
            this.source = 1;
            this.tabTitle = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(this._tabTitle);
            this.tabRedState = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(this._tabRedState);
            this.tabVisibility = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(this._tabVisibility);
            this._hasMore = new SparseBooleanArray();
            this.hasMore = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(this._hasMore);
            this.isAllEmpty = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(Boolean.FALSE);
            com.tencent.qqnt.notification.c cVar = new com.tencent.qqnt.notification.c();
            this.cacheInfo = cVar;
            this.notificationMap = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(cVar.e());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this._historyNotificationMap = linkedHashMap;
            this.historyNotificationMap = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(linkedHashMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            this._recentNotificationMap = linkedHashMap2;
            this.recentNotificationMap = new com.tencent.mobileqq.troop.troopnotification.utils.a<>(linkedHashMap2);
            this.visibleTabProcessor = new ArrayList();
            this.lastReadSeqMap = new SparseLongArray();
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationListVM$notificationObserver$2.a>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$notificationObserver$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationObserver$2$a", "Lcom/tencent/mobileqq/troop/api/observer/d;", "", "isSuccess", "", "data", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a extends com.tencent.mobileqq.troop.api.observer.d {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TroopNotificationListVM f300942d;

                    a(TroopNotificationListVM troopNotificationListVM) {
                        this.f300942d = troopNotificationListVM;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationListVM);
                        }
                    }

                    @Override // com.tencent.mobileqq.troop.api.observer.d
                    protected void a(boolean isSuccess, @Nullable Object data) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopNotificationListVM", 2, "onGetTroopNotificationInfoSuccess: isSuccess=" + isSuccess);
                        }
                        if (isSuccess) {
                            this.f300942d.G2(true, true);
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopNotificationListVM.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.notificationObserver = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationListVM$notificationChangeObserver$2.a>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$notificationChangeObserver$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM$notificationChangeObserver$2$a", "Lcom/tencent/qqnt/inner/observer/a;", "Lcom/tencent/qqnt/notification/f;", "newMsg", "", "a", "c", "msg", "d", "e", "", "unreadCount", "unhandledCount", "unHandleAndUnreadCount", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a implements com.tencent.qqnt.inner.observer.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ TroopNotificationListVM f300941a;

                    a(TroopNotificationListVM troopNotificationListVM) {
                        this.f300941a = troopNotificationListVM;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationListVM);
                        }
                    }

                    @Override // com.tencent.qqnt.inner.observer.a
                    public void a(@NotNull f newMsg) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newMsg);
                        } else {
                            Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                            this.f300941a.D2(newMsg);
                        }
                    }

                    @Override // com.tencent.qqnt.troop.g
                    public void b(int unreadCount, int unhandledCount, int unHandleAndUnreadCount) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                            this.f300941a.P2();
                        } else {
                            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(unreadCount), Integer.valueOf(unhandledCount), Integer.valueOf(unHandleAndUnreadCount));
                        }
                    }

                    @Override // com.tencent.qqnt.inner.observer.a
                    public void c() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                            this.f300941a.O2(new LinkedHashMap());
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopNotificationListVM", 2, "onNotificationClear: ");
                                return;
                            }
                            return;
                        }
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    }

                    @Override // com.tencent.qqnt.inner.observer.a
                    public void d(@NotNull f msg2) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
                        } else {
                            Intrinsics.checkNotNullParameter(msg2, "msg");
                            this.f300941a.E2(msg2);
                        }
                    }

                    @Override // com.tencent.qqnt.inner.observer.a
                    public void e() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            iPatchRedirector.redirect((short) 5, (Object) this);
                        } else {
                            this.f300941a.H2();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopNotificationListVM.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.notificationChangeObserver = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean B2() {
        if (this.currentCategory == 1) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2(final f newMsg) {
        List<f> listOf;
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(newMsg);
            iTroopNotificationInnerService.saveNotificationMsg(lifecycleOwner, listOf);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        this.cacheInfo.i(newMsg, !B2(), new Function2<Integer, f, Unit>(newMsg, booleanRef, booleanRef2) { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$onNotificationChanged$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.BooleanRef $needPostHistory;
            final /* synthetic */ Ref.BooleanRef $needPostRecent;
            final /* synthetic */ f $newMsg;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$newMsg = newMsg;
                this.$needPostHistory = booleanRef;
                this.$needPostRecent = booleanRef2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopNotificationListVM.this, newMsg, booleanRef, booleanRef2);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, f fVar) {
                invoke(num.intValue(), fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull f old) {
                Map map;
                Map map2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) old);
                    return;
                }
                Intrinsics.checkNotNullParameter(old, "old");
                c.Companion companion = com.tencent.qqnt.notification.c.INSTANCE;
                map = TroopNotificationListVM.this._historyNotificationMap;
                if (companion.c((List) map.get(Integer.valueOf(i3)), old, this.$newMsg) != null) {
                    this.$needPostHistory.element = true;
                }
                map2 = TroopNotificationListVM.this._recentNotificationMap;
                if (companion.c((List) map2.get(Integer.valueOf(i3)), old, this.$newMsg) != null) {
                    this.$needPostRecent.element = true;
                }
            }
        });
        G2(booleanRef2.element, booleanRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2(f msg2) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        this.cacheInfo.g(msg2, new Function2<Integer, f, Unit>(booleanRef, booleanRef2) { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$onNotificationRemove$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.BooleanRef $needPostHistory;
            final /* synthetic */ Ref.BooleanRef $needPostRecent;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$needPostHistory = booleanRef;
                this.$needPostRecent = booleanRef2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopNotificationListVM.this, booleanRef, booleanRef2);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, f fVar) {
                invoke(num.intValue(), fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull f old) {
                Map map;
                Map map2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) old);
                    return;
                }
                Intrinsics.checkNotNullParameter(old, "old");
                map = TroopNotificationListVM.this._historyNotificationMap;
                List list = (List) map.get(Integer.valueOf(i3));
                if (list != null) {
                    Boolean valueOf = Boolean.valueOf(list.remove(old));
                    Ref.BooleanRef booleanRef3 = this.$needPostHistory;
                    valueOf.booleanValue();
                    booleanRef3.element = true;
                }
                map2 = TroopNotificationListVM.this._recentNotificationMap;
                List list2 = (List) map2.get(Integer.valueOf(i3));
                if (list2 != null) {
                    Boolean valueOf2 = Boolean.valueOf(list2.remove(old));
                    Ref.BooleanRef booleanRef4 = this.$needPostRecent;
                    valueOf2.booleanValue();
                    booleanRef4.element = true;
                }
            }
        });
        if (this.cacheInfo.f()) {
            this.isAllEmpty.postValue(Boolean.TRUE);
        } else {
            this.isAllEmpty.postValue(Boolean.FALSE);
        }
        G2(booleanRef2.element, booleanRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(boolean needPostRecent, boolean needPostHistory) {
        this.notificationMap.postValue(this.cacheInfo.e());
        if (needPostRecent) {
            this.recentNotificationMap.postValue(this._recentNotificationMap);
        }
        if (needPostHistory) {
            this.historyNotificationMap.postValue(this._historyNotificationMap);
        }
    }

    public static /* synthetic */ void J2(TroopNotificationListVM troopNotificationListVM, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = i3;
        }
        troopNotificationListVM.I2(i3, i16);
    }

    private final void K2() {
        TroopNotificationListRepo m26 = m2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleOwner = null;
        }
        m26.o(lifecycleOwner, new Function1<Map<Integer, ? extends List<f>>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$requestFirstScreenNotification$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<f>> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<Integer, ? extends List<f>> dataMap) {
                com.tencent.qqnt.notification.c cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(dataMap, "dataMap");
                TroopNotificationListVM.this.O2(dataMap);
                if (!dataMap.isEmpty()) {
                    TroopNotificationListVM.this.L2(dataMap);
                }
                if (QLog.isColorLevel()) {
                    int size = dataMap.size();
                    cVar = TroopNotificationListVM.this.cacheInfo;
                    QLog.d("TroopNotificationListVM", 2, "getFirstScreenNotificationList: dataMap.size=" + size + ", _notificationMap.size=" + cVar.e().size());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2(Map<Integer, ? extends List<f>> dataMap) {
        final ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, ? extends List<f>>> it = dataMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationListVM.M2(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(List notificationList) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(notificationList, "$notificationList");
        List<String> c16 = com.tencent.mobileqq.troop.troopnotification.utils.e.f300928a.c(notificationList);
        ITroopNotificationService iTroopNotificationService = (ITroopNotificationService) bg.l(ITroopNotificationService.class);
        if (iTroopNotificationService == null) {
            return;
        }
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                if (longValue != 0) {
                    com.tencent.mobileqq.data.troop.d applicantInfo = iTroopNotificationService.getApplicantInfo(Long.valueOf(longValue));
                    if (applicantInfo == null) {
                        iTroopNotificationService.addLackApplicantInfoUinToCacheBy0x5eb(Long.valueOf(longValue));
                        iTroopNotificationService.addLackApplicantInfoUinToCacheBy0x668(Long.valueOf(longValue));
                    } else {
                        if (!applicantInfo.j()) {
                            iTroopNotificationService.addLackApplicantInfoUinToCacheBy0x668(Long.valueOf(longValue));
                        }
                        if (!applicantInfo.i()) {
                            iTroopNotificationService.addLackApplicantInfoUinToCacheBy0x5eb(Long.valueOf(longValue));
                        }
                    }
                }
            }
        }
        List<Long> waitingLevelApplicantInfoUinFromCache = iTroopNotificationService.getWaitingLevelApplicantInfoUinFromCache();
        Intrinsics.checkNotNullExpressionValue(waitingLevelApplicantInfoUinFromCache, "service.waitingLevelApplicantInfoUinFromCache");
        List<Long> waitingTagApplicantInfoUinFromCache = iTroopNotificationService.getWaitingTagApplicantInfoUinFromCache();
        Intrinsics.checkNotNullExpressionValue(waitingTagApplicantInfoUinFromCache, "service.waitingTagApplicantInfoUinFromCache");
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListVM", 2, "requestLevelTagInfo: needRequestLevelUins=" + waitingLevelApplicantInfoUinFromCache + ", needRequestTagUins=" + waitingTagApplicantInfoUinFromCache);
        }
        if (!waitingTagApplicantInfoUinFromCache.isEmpty()) {
            iTroopNotificationService.getNotifyCationApplicantInfoBy0x5eb(waitingTagApplicantInfoUinFromCache);
        }
        if (!waitingLevelApplicantInfoUinFromCache.isEmpty()) {
            iTroopNotificationService.getNotifyCationApplicantQQLevelBy0x668(waitingLevelApplicantInfoUinFromCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(Map<Integer, ? extends List<f>> dataMap) {
        this.cacheInfo.b();
        this._historyNotificationMap.clear();
        this._recentNotificationMap.clear();
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list = this.categoryProcessor;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
            list = null;
        }
        for (com.tencent.mobileqq.troop.troopnotification.vm.processor.d dVar : list) {
            int category = dVar.getCategory();
            List<f> list2 = dataMap.get(Integer.valueOf(category));
            if (list2 != null) {
                List<f> a16 = dVar.a(list2);
                v2(this, category, a16, false, 4, null);
                if (a16.isEmpty()) {
                    this._hasMore.put(category, false);
                }
            } else {
                QLog.e("TroopNotificationListVM", 1, "resetAllNotification: not find dataList, category=" + dVar.getCategory());
            }
        }
        P2();
        this.hasMore.postValue(this._hasMore);
        if (this.cacheInfo.f()) {
            this.isAllEmpty.postValue(Boolean.TRUE);
        } else {
            this.isAllEmpty.postValue(Boolean.FALSE);
        }
        G2(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2() {
        boolean z16;
        int i3;
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list = this.categoryProcessor;
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
            list = null;
        }
        int size = list.size();
        boolean[] zArr = new boolean[size];
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = "";
        }
        this.visibleTabProcessor.clear();
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list3 = this.categoryProcessor;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
        } else {
            list2 = list3;
        }
        int i17 = 0;
        for (com.tencent.mobileqq.troop.troopnotification.vm.processor.d dVar : list2) {
            int i18 = i17 + 1;
            int category = dVar.getCategory();
            List<f> list4 = this.cacheInfo.e().get(Integer.valueOf(category));
            if (list4 == null) {
                list4 = CollectionsKt__CollectionsKt.emptyList();
            }
            strArr[i17] = dVar.getTitle();
            if (this.currentCategory != category && dVar.b(list4)) {
                z16 = true;
            } else {
                z16 = false;
            }
            zArr[i17] = z16;
            boolean c16 = dVar.c(list4);
            if (c16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            iArr[i17] = i3;
            if (c16) {
                this.visibleTabProcessor.add(dVar);
            }
            i17 = i18;
        }
        this._tabTitle = strArr;
        this._tabVisibility = iArr;
        this.tabTitle.postValue(strArr);
        this.tabVisibility.postValue(this._tabVisibility);
        this._tabRedState = zArr;
        this.tabRedState.postValue(zArr);
        if (QLog.isColorLevel()) {
            String arrays = Arrays.toString(iArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.d("TroopNotificationListVM", 2, "resetTabData: tabVisibility=" + arrays);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2() {
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list = this.categoryProcessor;
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
            list = null;
        }
        int size = list.size();
        String[] strArr = this._tabTitle;
        int i3 = 0;
        if (strArr == null) {
            strArr = new String[size];
            for (int i16 = 0; i16 < size; i16++) {
                strArr[i16] = "";
            }
        }
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list3 = this.categoryProcessor;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
        } else {
            list2 = list3;
        }
        Iterator<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> it = list2.iterator();
        while (it.hasNext()) {
            strArr[i3] = it.next().getTitle();
            i3++;
        }
        this._tabTitle = strArr;
        this.tabTitle.postValue(strArr);
    }

    private final TroopNotificationListVM$notificationChangeObserver$2.a h2() {
        return (TroopNotificationListVM$notificationChangeObserver$2.a) this.notificationChangeObserver.getValue();
    }

    private final TroopNotificationListVM$notificationObserver$2.a k2() {
        return (TroopNotificationListVM$notificationObserver$2.a) this.notificationObserver.getValue();
    }

    private final TroopNotificationListRepo m2() {
        return (TroopNotificationListRepo) this.repo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(int category, List<f> dataList, boolean needPost) {
        List<f> list = this._historyNotificationMap.get(Integer.valueOf(category));
        if (list == null) {
            list = new ArrayList<>();
        }
        List<f> list2 = this._recentNotificationMap.get(Integer.valueOf(category));
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.cacheInfo.a(category, dataList);
        boolean z16 = false;
        boolean z17 = false;
        for (f fVar : dataList) {
            if (fVar.g()) {
                list.add(fVar);
                z17 = true;
            } else {
                list2.add(fVar);
                z16 = true;
            }
        }
        this._historyNotificationMap.put(Integer.valueOf(category), list);
        this._recentNotificationMap.put(Integer.valueOf(category), list2);
        if (needPost) {
            G2(z16, z17);
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            iTroopNotificationInnerService.saveNotificationMsg(lifecycleOwner, dataList);
        }
    }

    static /* synthetic */ void v2(TroopNotificationListVM troopNotificationListVM, int i3, List list, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        troopNotificationListVM.u2(i3, list, z16);
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<Boolean> A2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.isAllEmpty;
    }

    public final void C2(@NotNull Context context, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) context, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TroopNotificationDetailFragment.INSTANCE.a(context, msg2);
    }

    public final void F2(@NotNull GroupNotifyOperateType operateType, @NotNull f msg2, @NotNull final TroopNotificationBaseButtonParser.a clickData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, operateType, msg2, clickData);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        TroopNotificationOperateRepo.r(TroopNotificationOperateRepo.f300860a, msg2, this.source, clickData.b(), null, false, new Function4<Boolean, Integer, String, f, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$operateNotification$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationBaseButtonParser.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, f fVar) {
                invoke(bool.booleanValue(), num.intValue(), str, fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull f newMsg) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, newMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                g.f300931a.f(z16, TroopNotificationBaseButtonParser.a.this.a(), i3);
            }
        }, 24, null);
    }

    public final void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListVM", 2, "reRenderNotification: ");
        }
        K2();
    }

    public final void I2(int reportCategory, int dataCategory) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(reportCategory), Integer.valueOf(dataCategory));
            return;
        }
        List<f> list = this.cacheInfo.e().get(Integer.valueOf(dataCategory));
        if (list != null && (!list.isEmpty())) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            f fVar = (f) first;
            if (fVar.j().seq > this.lastReadSeqMap.get(reportCategory, 0L)) {
                TroopNotificationOperateRepo.f300860a.w(reportCategory);
                this.lastReadSeqMap.put(reportCategory, fVar.j().seq);
            }
        }
    }

    public final void N2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, category);
            return;
        }
        TroopNotificationListRepo m26 = m2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleOwner = null;
        }
        m26.q(lifecycleOwner, category, new Function3<Integer, Boolean, List<f>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM$requestNextPageNotification$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool, List<f> list) {
                invoke(num.intValue(), bool.booleanValue(), list);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, boolean z16, @NotNull List<f> notificationList) {
                List list;
                List<f> list2;
                SparseBooleanArray sparseBooleanArray;
                SparseBooleanArray sparseBooleanArray2;
                Map mapOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), notificationList);
                    return;
                }
                Intrinsics.checkNotNullParameter(notificationList, "notificationList");
                list = TroopNotificationListVM.this.categoryProcessor;
                Object obj = null;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
                    list = null;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((com.tencent.mobileqq.troop.troopnotification.vm.processor.d) next).getCategory() == i3) {
                        obj = next;
                        break;
                    }
                }
                com.tencent.mobileqq.troop.troopnotification.vm.processor.d dVar = (com.tencent.mobileqq.troop.troopnotification.vm.processor.d) obj;
                if (dVar == null || (list2 = dVar.a(notificationList)) == null) {
                    list2 = notificationList;
                }
                TroopNotificationListVM.this.u2(i3, notificationList, true);
                TroopNotificationListVM.this.R2();
                sparseBooleanArray = TroopNotificationListVM.this._hasMore;
                sparseBooleanArray.put(i3, z16);
                com.tencent.mobileqq.troop.troopnotification.utils.a<SparseBooleanArray> f26 = TroopNotificationListVM.this.f2();
                sparseBooleanArray2 = TroopNotificationListVM.this._hasMore;
                f26.postValue(sparseBooleanArray2);
                TroopNotificationListVM troopNotificationListVM = TroopNotificationListVM.this;
                mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(Integer.valueOf(i3), list2));
                troopNotificationListVM.L2(mapOf);
            }
        });
    }

    public final void Q2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.currentCategory = i3;
        }
    }

    public final void S2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list = this.categoryProcessor;
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
            list = null;
        }
        int size = list.size();
        int[] iArr = this._tabVisibility;
        if (iArr == null) {
            iArr = new int[size];
        }
        this.visibleTabProcessor.clear();
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list3 = this.categoryProcessor;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
        } else {
            list2 = list3;
        }
        int i16 = 0;
        for (com.tencent.mobileqq.troop.troopnotification.vm.processor.d dVar : list2) {
            int i17 = i16 + 1;
            List<f> list4 = this.cacheInfo.e().get(Integer.valueOf(dVar.getCategory()));
            if (list4 == null) {
                list4 = CollectionsKt__CollectionsKt.emptyList();
            }
            boolean c16 = dVar.c(list4);
            if (c16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            iArr[i16] = i3;
            if (c16) {
                this.visibleTabProcessor.add(dVar);
            }
            i16 = i17;
        }
        this.tabVisibility.postValue(this._tabVisibility);
    }

    public final void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            TroopNotificationOperateRepo.f300860a.k(TroopNotificationListVM$clearAllNotification$1.INSTANCE);
        }
    }

    public final void c2(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TroopNotificationOperateRepo.f300860a.o(msg2, this.source, "", TroopNotificationListVM$deleteNotification$1.INSTANCE);
        }
    }

    public final int d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.currentCategory;
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListVM", 2, "destroy: this=" + this);
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(k2());
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            iTroopNotificationInnerService.destroyNotificationMsg(lifecycleOwner);
        }
    }

    public final int e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.fromType;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<SparseBooleanArray> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.hasMore;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.historyNotificationMap;
    }

    public final int i2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, category)).intValue();
        }
        List<f> list = this.cacheInfo.e().get(Integer.valueOf(category));
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.notificationMap;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<f>>> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.recentNotificationMap;
    }

    public final int n2(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, pos)).intValue();
        }
        boolean z16 = false;
        if (pos >= 0 && pos < this.visibleTabProcessor.size()) {
            z16 = true;
        }
        if (z16) {
            return this.visibleTabProcessor.get(pos).getCategory();
        }
        return -1;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<boolean[]> o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.tabRedState;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<String[]> p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.tabTitle;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.utils.a<int[]> q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.troopnotification.utils.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.tabVisibility;
    }

    public final boolean r2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, category)).booleanValue();
        }
        Iterator<com.tencent.mobileqq.troop.troopnotification.vm.processor.d> it = this.visibleTabProcessor.iterator();
        while (it.hasNext()) {
            if (it.next().getCategory() == category) {
                return true;
            }
        }
        return false;
    }

    public final int s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int[] iArr = this._tabVisibility;
        if (iArr == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 == 0) {
                i3++;
            }
        }
        return i3;
    }

    public final int t2(int categoryIndex) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, categoryIndex)).intValue();
        }
        int[] iArr = this._tabVisibility;
        if (iArr == null) {
            return -1;
        }
        int i3 = 0;
        if (iArr[categoryIndex] == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return -1;
        }
        List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> list = this.categoryProcessor;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryProcessor");
            list = null;
        }
        int category = list.get(categoryIndex).getCategory();
        Iterator<com.tencent.mobileqq.troop.troopnotification.vm.processor.d> it = this.visibleTabProcessor.iterator();
        while (it.hasNext()) {
            int i16 = i3 + 1;
            if (it.next().getCategory() == category) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    public final boolean w2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, category)).booleanValue();
        }
        if (this._historyNotificationMap.get(Integer.valueOf(category)) == null || !(!r4.isEmpty())) {
            return false;
        }
        return true;
    }

    public final boolean x2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, category)).booleanValue();
        }
        return this._hasMore.get(category, true);
    }

    public final boolean y2(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, category)).booleanValue();
        }
        if (this._recentNotificationMap.get(Integer.valueOf(category)) == null || !(!r4.isEmpty())) {
            return false;
        }
        return true;
    }

    public final void z2(@NotNull LifecycleOwner lifecycleOwner, @NotNull Bundle args, @NotNull List<? extends com.tencent.mobileqq.troop.troopnotification.vm.processor.d> processors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, lifecycleOwner, args, processors);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(processors, "processors");
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListVM", 2, "init: this=" + this + ", lifecycleOwner=" + lifecycleOwner);
        }
        this.lifecycleOwner = lifecycleOwner;
        this.categoryProcessor = processors;
        this.fromType = args.getInt("key_from", 0);
        this.source = args.getInt("KEY_SOURCE_FOR_VM", this.source);
        K2();
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(k2());
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            iTroopNotificationInnerService.registerNotificationChangedObserver(lifecycleOwner, h2());
        }
    }
}
