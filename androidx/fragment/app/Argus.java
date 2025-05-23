package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Argus;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.delegate.util.RFWConfigExtKt;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.richframework.argus.ActionInfo;
import com.tencent.richframework.argus.node.ActivityNodeCreator;
import com.tencent.richframework.argus.node.ArgusMergeNode;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.ArgusNodeCreator;
import com.tencent.richframework.argus.node.FragmentNodeForViewCreator;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.node.RecyclerViewNodeCreator;
import com.tencent.richframework.argus.node.TabHostNodeCreator;
import com.tencent.richframework.argus.node.ViewPager2BlockCreator;
import com.tencent.richframework.argus.node.ViewPagerNodeCreator;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.richframework.argus.page.db.PageChangeRecord;
import com.tencent.richframework.argus.page.db.PageChangeRepository;
import com.tencent.richframework.argus.page.db.PageInflateRepository;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import defpackage.RFWLogExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\n\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010;\u001a\u00020<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0015J\u001c\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\n\u0010A\u001a\u0006\u0012\u0002\b\u000301H\u0002J\u0006\u0010B\u001a\u00020<J\u0015\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010DH\u0002\u00a2\u0006\u0002\u0010EJ.\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\f\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010?\u001a\u00020@2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J>\u0010J\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u00102\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010\u00102\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020\rH\u0002J \u0010T\u001a\u00020<2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VH\u0002J\u001e\u0010X\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010Y\u001a\u00020@2\b\b\u0002\u0010Z\u001a\u00020\u001dJ&\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010?\u001a\u00020@2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010\\\u001a\u00020\u001dJ.\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010]\u001a\u00020@2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u0016\u0010_\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010Y\u001a\u00020@H\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010\u000e2\u0006\u0010a\u001a\u00020@H\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\rH\u0002J\u0016\u0010b\u001a\u00020<2\u0006\u0010Y\u001a\u00020@2\u0006\u0010c\u001a\u00020dJ\u0016\u0010e\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\u0006\u0010f\u001a\u00020@H\u0002J \u0010g\u001a\u00020<2\n\u0010h\u001a\u0006\u0012\u0002\b\u0003012\n\u0010i\u001a\u0006\u0012\u0002\b\u000301H\u0002J\b\u0010j\u001a\u00020<H\u0002J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ-\u0010n\u001a\u00020<2\b\b\u0002\u0010o\u001a\u00020\u001d2\u0016\u0010p\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010I0D\"\u0004\u0018\u00010I\u00a2\u0006\u0002\u0010qJ\u0010\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020\u000eH\u0002J\b\u0010t\u001a\u00020<H\u0016J\u0010\u0010u\u001a\u00020<2\u0006\u0010]\u001a\u00020@H\u0016J\u0010\u0010v\u001a\u00020<2\u0006\u0010]\u001a\u00020@H\u0016J\u0018\u0010w\u001a\u00020<2\u0006\u0010x\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u0010H\u0002J\u000e\u0010y\u001a\u00020<2\u0006\u0010z\u001a\u00020\u0017J\u0010\u0010{\u001a\u00020<2\u0006\u0010Y\u001a\u00020@H\u0002J\u0012\u0010|\u001a\u00020<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0015J\u000e\u0010}\u001a\u00020<2\u0006\u0010~\u001a\u00020-J\u0010\u0010\u007f\u001a\u00020<2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J[\u0010\u0082\u0001\u001a\u00020<2\u000b\u0010\u0083\u0001\u001a\u0006\u0012\u0002\b\u0003012\u0007\u0010\u0084\u0001\u001a\u00020\u001d2\u0012\u0010\u0085\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003010\u0086\u00012\u0012\u0010\u0087\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003010\u0086\u00012\u0012\u0010\u0088\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003010\u0086\u0001H\u0002J\u000f\u0010\u0089\u0001\u001a\u00020<2\u0006\u0010z\u001a\u00020\u0017J\t\u0010\u008a\u0001\u001a\u00020<H\u0002J\u0014\u0010\u008b\u0001\u001a\u00020<2\t\u0010S\u001a\u0005\u0018\u00010\u008c\u0001H\u0003J\u000f\u0010\u008b\u0001\u001a\u00020<2\u0006\u0010?\u001a\u00020@J\u0019\u0010\u008b\u0001\u001a\u00020<2\u0006\u0010a\u001a\u00020@2\u0006\u0010x\u001a\u00020\u000eH\u0002J\u0019\u0010\u008b\u0001\u001a\u00020<2\u0006\u0010S\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u000eH\u0002Jo\u0010\u008d\u0001\u001a\u00020<2\u0006\u0010x\u001a\u00020\u000e2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u00102\u0006\u0010P\u001a\u00020Q2\u001b\u0010\u008f\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u0001j\n\u0012\u0005\u0012\u00030\u0091\u0001`\u0092\u00012\u001b\u0010\u0093\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u0001j\n\u0012\u0005\u0012\u00030\u0091\u0001`\u0092\u00012\u0007\u0010\u0094\u0001\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001c\u0010\u001eR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b!\u0010\u001eR\u0010\u0010#\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010/\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030100j\f\u0012\b\u0012\u0006\u0012\u0002\b\u000301`2X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009a\u0001"}, d2 = {"Landroidx/fragment/app/Argus;", "Lcom/tencent/richframework/lifecycle/IProcessStateChangeCallback;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "ARGUS_DB_ENABLE", "", "ARGUS_ENABLE", "ARGUS_PREDICT_ENABLE", "TAG", "UNIQUE_TAG_GSON", "Lcom/google/gson/Gson;", "allPages", "", "", "Lcom/tencent/richframework/argus/page/PageInfo;", "allPagesPO", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "argusGlobalConfig", "Landroidx/fragment/app/ArgusGlobalConfig;", "argusNodeCreators", "", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "componentCallbacks", "Landroidx/fragment/app/Argus$ComponentCallback;", "currentPageInfo", "currentPageInfoPO", "groupHandler", "Landroid/os/Handler;", "isDebug", "", "()Z", "isDebug$delegate", "Lkotlin/Lazy;", "isLoggingInSubThread", "isLoggingInSubThread$delegate", "lastGroupInfo", "lastGroupPagePO", "getLastGroupPagePO", "()Lcom/tencent/richframework/argus/page/PageInfoPO;", "setLastGroupPagePO", "(Lcom/tencent/richframework/argus/page/PageInfoPO;)V", "mainHandler", "operationChangeListener", "Landroidx/fragment/app/OperationChangeListener;", "pendingActionInfo", "Lcom/tencent/richframework/argus/ActionInfo;", "pendingHandler", "pendingNodes", "Ljava/util/HashSet;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Lkotlin/collections/HashSet;", "getPendingNodes", "()Ljava/util/HashSet;", "setPendingNodes", "(Ljava/util/HashSet;)V", "updateGroupTask", "Landroidx/fragment/app/Argus$UpdateGroupTask;", "updatePendingTask", "Ljava/lang/Runnable;", "addBlockCreator", "", "argusNodeCreator", "bindNodeWithParent", "currentView", "Landroid/view/View;", "childNode", "clearHistory", "collectComponentCallbacks", "", "()[Landroidx/fragment/app/Argus$ComponentCallback;", "createNode", "preArgusNode", ParseCommon.CONTAINER, "", "dispatchPageChange", "fromPage", "fromPagePO", "newPage", "newPagePO", "groupPO", "mergeResult", "Landroidx/fragment/app/Argus$MergeResult;", "dispatchPendingNode", "windowToken", "dispatchPredictResult", "historyPageChanges", "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "findViewBlockNode", "view", "createIfNotExist", "getNode", "createIfEmpty", "targetView", "updateNode", "getNodeFromView", "getPageFromView", "pointView", "getPageUniteTag", "uniqueTagCallback", "Landroidx/fragment/app/Argus$UniqueTagCallback;", "getParentNode", "childView", "handleParentAndChildNode", "parentBlock", "childBlock", "initBlockCreator", "isEnablePredict", "isEnableWriteDb", "isMonitorEnable", "log", "highLight", "message", "(Z[Ljava/lang/Object;)V", "mergePageDiff", "pageInfo", "onProcessBackground", "onViewAttachedToWindow", "onViewDetachedFromWindow", "predictNewPage", "newPageInfo", "registerComponentCallback", "callback", "registerPageSelectedIfNeed", "removeBlockCreator", "sendActionInfo", "actionInfo", "startMonitor", "application", "Landroid/app/Application;", "travelAllNode", "visitNode", "isParentVisible", "showNodes", "", "hideNodes", "addNodes", "unRegisterComponentCallback", "updateConfig", "updatePage", "Landroid/os/IBinder;", "writePageChangeRecordToDb", "pageInfoPO", "firstShowNodes", "Ljava/util/ArrayList;", "Lcom/tencent/richframework/argus/node/NodePO;", "Lkotlin/collections/ArrayList;", "notFirstShowNodes", "recordActionInfo", "ComponentCallback", "MergeResult", "RouteFragmentLifecycleCallback", "UniqueTagCallback", "UpdateGroupTask", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class Argus implements IProcessStateChangeCallback, View.OnAttachStateChangeListener {
    private static final String ARGUS_DB_ENABLE = "argus_db_enable";
    private static final String ARGUS_ENABLE = "argus_enable_new";
    private static final String ARGUS_PREDICT_ENABLE = "argus_predict_enable";

    @NotNull
    public static final Argus INSTANCE;

    @NotNull
    public static final String TAG = "Argus";
    private static final Gson UNIQUE_TAG_GSON;
    private static final Map<Integer, PageInfo> allPages;
    private static final Map<Integer, PageInfoPO> allPagesPO;
    private static ArgusGlobalConfig argusGlobalConfig;
    private static final List<ArgusNodeCreator<?>> argusNodeCreators;
    private static final List<ComponentCallback> componentCallbacks;
    private static PageInfo currentPageInfo;
    private static PageInfoPO currentPageInfoPO;
    private static final Handler groupHandler;

    /* renamed from: isDebug$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isDebug;

    /* renamed from: isLoggingInSubThread$delegate, reason: from kotlin metadata */
    private static final Lazy isLoggingInSubThread;
    private static PageInfo lastGroupInfo;

    @Nullable
    private static PageInfoPO lastGroupPagePO;
    private static final Handler mainHandler;
    private static final OperationChangeListener operationChangeListener;
    private static ActionInfo pendingActionInfo;
    private static final Handler pendingHandler;

    @NotNull
    private static HashSet<ArgusNode<?>> pendingNodes;
    private static UpdateGroupTask updateGroupTask;
    private static final Runnable updatePendingTask;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH'J \u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'\u00a8\u0006\u0012"}, d2 = {"Landroidx/fragment/app/Argus$ComponentCallback;", "", "onPageChange", "", "fromPage", "Lcom/tencent/richframework/argus/page/PageInfo;", "fromPagePO", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "newPage", "newPagePO", "groupPO", "mergeResult", "Landroidx/fragment/app/Argus$MergeResult;", "onPredictResult", "currentPageInfo", "historyPageChanges", "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public interface ComponentCallback {
        @UiThread
        void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull MergeResult mergeResult);

        @WorkerThread
        void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Landroidx/fragment/app/Argus$MergeResult;", "", "isChange", "", "showNodes", "", "Lcom/tencent/richframework/argus/node/ArgusNode;", "hideNodes", "addNodes", "(ZLjava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "getAddNodes", "()Ljava/util/Set;", "getHideNodes", "()Z", "getShowNodes", "toString", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class MergeResult {

        @NotNull
        private final Set<ArgusNode<?>> addNodes;

        @NotNull
        private final Set<ArgusNode<?>> hideNodes;
        private final boolean isChange;

        @NotNull
        private final Set<ArgusNode<?>> showNodes;

        /* JADX WARN: Multi-variable type inference failed */
        public MergeResult(boolean z16, @NotNull Set<? extends ArgusNode<?>> showNodes, @NotNull Set<? extends ArgusNode<?>> hideNodes, @NotNull Set<? extends ArgusNode<?>> addNodes) {
            Intrinsics.checkNotNullParameter(showNodes, "showNodes");
            Intrinsics.checkNotNullParameter(hideNodes, "hideNodes");
            Intrinsics.checkNotNullParameter(addNodes, "addNodes");
            this.isChange = z16;
            this.showNodes = showNodes;
            this.hideNodes = hideNodes;
            this.addNodes = addNodes;
        }

        @NotNull
        public final Set<ArgusNode<?>> getAddNodes() {
            return this.addNodes;
        }

        @NotNull
        public final Set<ArgusNode<?>> getHideNodes() {
            return this.hideNodes;
        }

        @NotNull
        public final Set<ArgusNode<?>> getShowNodes() {
            return this.showNodes;
        }

        /* renamed from: isChange, reason: from getter */
        public final boolean getIsChange() {
            return this.isChange;
        }

        @NotNull
        public String toString() {
            String trimIndent;
            trimIndent = StringsKt__IndentKt.trimIndent("\n                   MergeResult{isChange=" + this.isChange + ", \n                   showNodes=" + this.showNodes + ", \n                   hideNodes=" + this.hideNodes + ",\n                   addNodes=" + this.addNodes + "}\n                   ");
            return trimIndent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Landroidx/fragment/app/Argus$RouteFragmentLifecycleCallback;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "()V", "onFragmentAttached", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "onFragmentDetached", "fm", "f", "onFragmentPaused", "onFragmentResumed", "onFragmentViewCreated", "fragmentView", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class RouteFragmentLifecycleCallback extends FragmentManager.FragmentLifecycleCallbacks {
        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentAttached(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDetached(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            if (f16.getView() != null) {
                Log.i(Argus.TAG, "onFragmentDetached:" + f16);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            super.onFragmentPaused(fm5, f16);
            View it = f16.getView();
            if (it != null) {
                Argus argus = Argus.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                argus.updatePage(it);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull final Fragment fragment) {
            boolean z16;
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            super.onFragmentResumed(fm5, fragment);
            final View view = fragment.getView();
            if (view != null) {
                Intrinsics.checkNotNullExpressionValue(view, "fragment.view ?: return");
                if (view.isAttachedToWindow()) {
                    if (fragment.isVisible() && view.isShown()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Log.i(Argus.TAG, "onFragmentResumed fragment:" + fragment + "isFragmentVisible:" + z16);
                    Log.i(Argus.TAG, "onFragmentResumed fragment:" + fragment + "onPreDraw isVisible:" + fragment.isVisible() + " isShown:" + view.isShown());
                    if (fragment.isVisible() && view.isShown()) {
                        Argus.INSTANCE.updatePage(view);
                        return;
                    }
                    return;
                }
                view.post(new Runnable() { // from class: androidx.fragment.app.Argus$RouteFragmentLifecycleCallback$onFragmentResumed$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z17;
                        if (Fragment.this.isVisible() && view.isShown()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        Log.i(Argus.TAG, "onFragmentResumed fragment:" + Fragment.this + "isFragmentVisible:" + z17);
                        Log.i(Argus.TAG, "onFragmentResumed fragment:" + Fragment.this + "onPreDraw isVisible:" + Fragment.this.isVisible() + " isShown:" + view.isShown());
                        if (Fragment.this.isVisible() && view.isShown()) {
                            Argus.INSTANCE.updatePage(view);
                        }
                    }
                });
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NotNull FragmentManager fm5, @NotNull Fragment fragment, @NotNull View fragmentView, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(fragmentView, "fragmentView");
            RFWLog.i(Argus.TAG, RFWLog.USR, "onFragmentViewCreated fragment:" + fragment + " view:" + fragmentView + " parentView:" + fragmentView.getParent());
            Argus.INSTANCE.getNode(fragmentView, fragment, true);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Landroidx/fragment/app/Argus$UniqueTagCallback;", "", "onUniqueTagResult", "", "uniqueTag", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public interface UniqueTagCallback {
        void onUniqueTagResult(@Nullable String uniqueTag);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Landroidx/fragment/app/Argus$UpdateGroupTask;", "Ljava/lang/Runnable;", "groupPageInfo", "Lcom/tencent/richframework/argus/page/PageInfo;", "groupPageInfoPO", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "(Lcom/tencent/richframework/argus/page/PageInfo;Lcom/tencent/richframework/argus/page/PageInfoPO;)V", TencentLocation.RUN_MODE, "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class UpdateGroupTask implements Runnable {
        private final PageInfo groupPageInfo;
        private final PageInfoPO groupPageInfoPO;

        public UpdateGroupTask(@NotNull PageInfo groupPageInfo, @NotNull PageInfoPO groupPageInfoPO) {
            Intrinsics.checkNotNullParameter(groupPageInfo, "groupPageInfo");
            Intrinsics.checkNotNullParameter(groupPageInfoPO, "groupPageInfoPO");
            this.groupPageInfo = groupPageInfo;
            this.groupPageInfoPO = groupPageInfoPO;
        }

        @Override // java.lang.Runnable
        public void run() {
            Argus argus = Argus.INSTANCE;
            PageInfo pageInfo = this.groupPageInfo;
            argus.setLastGroupPagePO(this.groupPageInfoPO);
            PageInfoPO lastGroupPagePO = argus.getLastGroupPagePO();
            if (lastGroupPagePO != null) {
                argus.predictNewPage(pageInfo, lastGroupPagePO);
                lastGroupPagePO.printAll("ArgusChangeGroup");
            }
            Unit unit = Unit.INSTANCE;
            Argus.lastGroupInfo = pageInfo;
            Argus.pendingActionInfo = null;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Argus argus = new Argus();
        INSTANCE = argus;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: androidx.fragment.app.Argus$isDebug$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("ARGUS_DEBUG");
            }
        });
        isDebug = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: androidx.fragment.app.Argus$isLoggingInSubThread$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("ARGUS_LOG_IN_SUB_THREAD");
            }
        });
        isLoggingInSubThread = lazy2;
        allPages = new HashMap();
        allPagesPO = new HashMap();
        argusNodeCreators = new ArrayList();
        argusGlobalConfig = new ArgusGlobalConfig(true, true, true);
        UNIQUE_TAG_GSON = new Gson();
        mainHandler = new Handler(Looper.getMainLooper());
        groupHandler = new Handler(Looper.getMainLooper());
        pendingHandler = new Handler(Looper.getMainLooper());
        pendingNodes = new HashSet<>();
        argus.initBlockCreator();
        componentCallbacks = new ArrayList();
        operationChangeListener = new OperationChangeListener() { // from class: androidx.fragment.app.Argus.1
            @Override // androidx.fragment.app.OperationChangeListener
            public void enqueueOption(@NotNull SpecialEffectsController.Operation operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
            }

            @Override // androidx.fragment.app.OperationChangeListener
            public void onCompleteListener(@NotNull SpecialEffectsController.Operation operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                RFWLog.i(Argus.TAG, RFWLog.USR, "onCompleteListener:" + operation);
                if (operation.getLifecycleImpact() == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
                    Fragment fragment = operation.getFragment();
                    Intrinsics.checkNotNullExpressionValue(fragment, "operation.fragment");
                    View it = fragment.getView();
                    if (it != null) {
                        Argus argus2 = Argus.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        argus2.getNode(it, operation.getFragment(), true);
                    }
                }
                Fragment fragment2 = operation.getFragment();
                Intrinsics.checkNotNullExpressionValue(fragment2, "operation.fragment");
                View it5 = fragment2.getView();
                if (it5 != null) {
                    Argus argus3 = Argus.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    argus3.updatePage(it5);
                }
            }
        };
        updatePendingTask = new Runnable() { // from class: androidx.fragment.app.Argus$updatePendingTask$1
            @Override // java.lang.Runnable
            public final void run() {
                PageInfo pageInfo;
                Argus argus2 = Argus.INSTANCE;
                pageInfo = Argus.currentPageInfo;
                if (pageInfo != null) {
                    argus2.dispatchPendingNode(pageInfo.getWindowToken());
                }
            }
        };
    }

    Argus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindNodeWithParent(final View currentView, final ArgusNode<?> childNode) {
        ArgusNode<?> parentNode = getParentNode(currentView);
        boolean isAttachedToWindow = currentView.isAttachedToWindow();
        if (!isAttachedToWindow) {
            pendingNodes.add(childNode);
            Handler handler = pendingHandler;
            Runnable runnable = updatePendingTask;
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 1000L);
        } else {
            pendingNodes.remove(childNode);
            if (pendingNodes.isEmpty()) {
                pendingHandler.removeCallbacks(updatePendingTask);
            }
        }
        if (parentNode != null) {
            handleParentAndChildNode(parentNode, childNode);
            if (currentView.isAttachedToWindow()) {
                log(false, "create node trigger update page when is already attached to window");
                updatePage(currentView);
                return;
            } else {
                log(false, "bind parentNode success but is not attachToWindow, not updatePage, and still trigger PendingTask");
                return;
            }
        }
        if (!isAttachedToWindow) {
            log(false, "bind node with parent and update page after post");
            currentView.post(new Runnable() { // from class: androidx.fragment.app.Argus$bindNodeWithParent$1
                @Override // java.lang.Runnable
                public final void run() {
                    Argus argus = Argus.INSTANCE;
                    ArgusNode findViewBlockNode$default = Argus.findViewBlockNode$default(argus, currentView, false, 2, null);
                    ArgusNode argusNode = ArgusNode.this;
                    if (findViewBlockNode$default == argusNode) {
                        argus.bindNodeWithParent(currentView, argusNode);
                    } else {
                        argus.log(false, "bind node with parent,but find node is changed");
                    }
                }
            });
        } else {
            log(false, "block ", childNode.getContainer(), " not found parentNode");
        }
    }

    private final ComponentCallback[] collectComponentCallbacks() {
        ComponentCallback[] componentCallbackArr;
        List<ComponentCallback> list = componentCallbacks;
        synchronized (list) {
            if (list.size() > 0) {
                Object[] array = list.toArray(new ComponentCallback[0]);
                if (array != null) {
                    componentCallbackArr = (ComponentCallback[]) array;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                componentCallbackArr = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        return componentCallbackArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.richframework.argus.node.ArgusNode<?>] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, com.tencent.richframework.argus.node.ArgusNode] */
    private final ArgusNode<?> createNode(ArgusNode<?> preArgusNode, View currentView, Object container) {
        Class<?> cls;
        ArrayList arrayList = new ArrayList();
        if (preArgusNode != null) {
            if (preArgusNode instanceof ArgusMergeNode) {
                arrayList.addAll(((ArgusMergeNode) preArgusNode).getInnerNodes());
            } else {
                arrayList.add(preArgusNode);
            }
        }
        ?? finalCreatedNode = 0;
        for (ArgusNodeCreator<?> argusNodeCreator : argusNodeCreators) {
            if (argusNodeCreator.canHandle(currentView, container)) {
                finalCreatedNode = argusNodeCreator.createNode(currentView, container);
                Intrinsics.checkNotNullExpressionValue(finalCreatedNode, "finalCreatedNode");
                Class<?> cls2 = finalCreatedNode.getClass();
                if (preArgusNode != null) {
                    cls = preArgusNode.getClass();
                } else {
                    cls = null;
                }
                if (!Intrinsics.areEqual(cls2, cls)) {
                    arrayList.add(finalCreatedNode);
                }
            }
        }
        if (arrayList.size() > 1) {
            return new ArgusMergeNode(arrayList);
        }
        return finalCreatedNode;
    }

    private final void dispatchPageChange(PageInfo fromPage, PageInfoPO fromPagePO, PageInfo newPage, PageInfoPO newPagePO, PageInfoPO groupPO, MergeResult mergeResult) {
        ComponentCallback[] collectComponentCallbacks = collectComponentCallbacks();
        if (collectComponentCallbacks != null) {
            for (ComponentCallback componentCallback : collectComponentCallbacks) {
                componentCallback.onPageChange(fromPage, fromPagePO, newPage, newPagePO, groupPO, mergeResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPendingNode(int windowToken) {
        PageInfoPO pageInfoPO = allPagesPO.get(Integer.valueOf(windowToken));
        if (pageInfoPO != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<ArgusNode<?>> it = pendingNodes.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "pendingNodes.iterator()");
            while (it.hasNext()) {
                ArgusNode<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                ArgusNode<?> argusNode = next;
                View nodeView = argusNode.getNodeView();
                Object container = argusNode.getContainer();
                if (nodeView != null && container != null) {
                    if (!argusNode.getHasDispatchPending()) {
                        NodePO nodeTreeTag = argusNode.getNodeTreeTag();
                        if (nodeTreeTag != null) {
                            arrayList.add(nodeTreeTag);
                            INSTANCE.log(false, "pendingNode:", nodeTreeTag);
                        }
                        argusNode.setHasDispatchPending(true);
                    }
                } else {
                    it.remove();
                }
            }
            if ((!arrayList.isEmpty()) && isEnableWriteDb()) {
                PageChangeRecord pageChangeRecord = new PageChangeRecord();
                pageChangeRecord.isSameRoot = 1;
                pageChangeRecord.isSameRootWithGroup = 1;
                pageChangeRecord.fromPage = pageInfoPO;
                pageChangeRecord.fromGroupPage = lastGroupPagePO;
                pageChangeRecord.toPage = pageInfoPO;
                pageChangeRecord.pendingBlocks = arrayList;
                pageChangeRecord.time = System.currentTimeMillis();
                PageChangeRepository.INSTANCE.insert(pageChangeRecord);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPredictResult(PageInfo currentPageInfo2, List<? extends HistoryPageChange> historyPageChanges) {
        ComponentCallback[] collectComponentCallbacks = collectComponentCallbacks();
        if (collectComponentCallbacks != null) {
            for (ComponentCallback componentCallback : collectComponentCallbacks) {
                componentCallback.onPredictResult(currentPageInfo2, historyPageChanges);
            }
        }
    }

    public static /* synthetic */ ArgusNode findViewBlockNode$default(Argus argus, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return argus.findViewBlockNode(view, z16);
    }

    private final ArgusNode<?> getNodeFromView(View view) {
        Object tag = view.getTag(R.id.t8x);
        if (tag instanceof ArgusNode) {
            return (ArgusNode) tag;
        }
        return null;
    }

    private final PageInfo getPageFromView(View pointView) {
        return allPages.get(Integer.valueOf(pointView.getWindowToken().hashCode()));
    }

    private final ArgusNode<?> getParentNode(View childView) {
        if (!(childView.getParent() instanceof View)) {
            return null;
        }
        Object parent = childView.getParent();
        if (parent != null) {
            View view = (View) parent;
            ArgusNode<?> node = getNode(view, null, true);
            if (node == null) {
                return getParentNode(view);
            }
            return node;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    private final void handleParentAndChildNode(ArgusNode<?> parentBlock, ArgusNode<?> childBlock) {
        String str;
        Iterator<ArgusNode<?>> it = parentBlock.getAllChildNode().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "parentBlock.allChildNode.iterator()");
        while (it.hasNext()) {
            ArgusNode<?> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "childNodeIterator.next()");
            ArgusNode<?> argusNode = next;
            if (childBlock.getNodeView() == argusNode.getNodeView()) {
                log(true, "handleParentAndChildBlock find same view:", childBlock, " ", argusNode);
            } else if (childBlock.isAncestorOfNode(argusNode)) {
                log(true, "fix child:", argusNode, " new parent:", childBlock);
                childBlock.addChildNode(argusNode);
                argusNode.setParentNode(childBlock);
                it.remove();
            }
        }
        childBlock.setParentNode(parentBlock);
        parentBlock.addChildNode(childBlock);
        Object[] objArr = new Object[4];
        objArr[0] = "bindBlock parent:";
        Object container = parentBlock.getContainer();
        String str2 = null;
        if (container != null) {
            str = container.getClass().getName();
        } else {
            str = null;
        }
        objArr[1] = str;
        objArr[2] = " child:";
        Object container2 = childBlock.getContainer();
        if (container2 != null) {
            str2 = container2.getClass().getName();
        }
        objArr[3] = str2;
        log(false, objArr);
    }

    private final void initBlockCreator() {
        addBlockCreator(new ActivityNodeCreator());
        addBlockCreator(new FragmentNodeForViewCreator());
        addBlockCreator(new TabHostNodeCreator());
        addBlockCreator(new ViewPager2BlockCreator());
        addBlockCreator(new ViewPagerNodeCreator());
        addBlockCreator(new RecyclerViewNodeCreator());
    }

    private final boolean isLoggingInSubThread() {
        return ((Boolean) isLoggingInSubThread.getValue()).booleanValue();
    }

    public static /* synthetic */ void log$default(Argus argus, boolean z16, Object[] objArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        argus.log(z16, objArr);
    }

    private final MergeResult mergePageDiff(PageInfo pageInfo) {
        long nanoTime = System.nanoTime();
        Set<ArgusNode<?>> allVisibleNode = pageInfo.getAllVisibleNode();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        travelAllNode(pageInfo.getRootNode(), true, linkedHashSet, linkedHashSet2, linkedHashSet3);
        linkedHashSet.removeAll(allVisibleNode);
        Iterator<ArgusNode<?>> it = linkedHashSet2.iterator();
        while (it.hasNext()) {
            if (!allVisibleNode.contains(it.next())) {
                it.remove();
            }
        }
        boolean z16 = false;
        log(false, "merge cost:", Long.valueOf(System.nanoTime() - nanoTime));
        if ((!linkedHashSet.isEmpty()) || (!linkedHashSet2.isEmpty()) || (!linkedHashSet3.isEmpty())) {
            z16 = true;
        }
        return new MergeResult(z16, linkedHashSet, linkedHashSet2, linkedHashSet3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void predictNewPage(final PageInfo newPageInfo, final PageInfoPO newPagePO) {
        if (newPagePO.getRootNode() != null && isEnablePredict()) {
            final long nanoTime = System.nanoTime();
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: androidx.fragment.app.Argus$predictNewPage$1
                @Override // java.lang.Runnable
                public final void run() {
                    PageInfoPO pageInfoPO;
                    PageInfoPO pageInfoPO2;
                    try {
                        RFWLog.i(Argus.TAG, RFWLog.USR, "newPagePO:" + PageInfoPO.this);
                        List<HistoryPageChange> historyPageChange = PageChangeRepository.INSTANCE.getHistoryPageChange(PageInfoPO.this, ArgusConfigManager.INSTANCE.getStrategyConfig().getPredictPastMinutes());
                        Argus argus = Argus.INSTANCE;
                        pageInfoPO = Argus.currentPageInfoPO;
                        if (Intrinsics.areEqual(pageInfoPO, PageInfoPO.this)) {
                            long nanoTime2 = System.nanoTime();
                            int i3 = RFWLog.USR;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("predict success current: ");
                            pageInfoPO2 = Argus.currentPageInfoPO;
                            sb5.append(pageInfoPO2);
                            sb5.append(TokenParser.SP);
                            sb5.append("cost:");
                            sb5.append(nanoTime2 - nanoTime);
                            RFWLog.e(Argus.TAG, i3, sb5.toString());
                            argus.dispatchPredictResult(newPageInfo, historyPageChange);
                        } else {
                            RFWLog.w(Argus.TAG, RFWLog.USR, "predict unSuccess because page change, search from pagePO:" + PageInfoPO.this);
                        }
                    } catch (Exception e16) {
                        RFWLog.e(Argus.TAG, RFWLog.USR, "predict catch exception", e16);
                        RFWReporter.reportThrowableCache(new IllegalStateException("GsonConvertFailed"));
                    }
                }
            });
        } else {
            log(true, "empty rootBlock do nothing");
        }
    }

    private final void registerPageSelectedIfNeed(View view) {
        boolean z16 = view instanceof ViewPager;
        if (view.getParent() instanceof ViewGroup) {
            Object parent = view.getParent();
            if (parent != null) {
                registerPageSelectedIfNeed((View) parent);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }

    private final void travelAllNode(ArgusNode<?> visitNode, boolean isParentVisible, Set<ArgusNode<?>> showNodes, Set<ArgusNode<?>> hideNodes, Set<ArgusNode<?>> addNodes) {
        boolean z16;
        if (isParentVisible) {
            z16 = visitNode.isSelfVisible();
            visitNode.setVisibleFlag(z16);
            if (z16) {
                showNodes.add(visitNode);
            } else {
                hideNodes.add(visitNode);
            }
        } else {
            z16 = false;
            visitNode.setVisibleFlag(false);
            hideNodes.add(visitNode);
        }
        if (!visitNode.getHasDispatchAdd()) {
            addNodes.add(visitNode);
            visitNode.setHasDispatchAdd(true);
        }
        Iterator<ArgusNode<?>> it = visitNode.getAllChildNode().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "visitNode.allChildNode.iterator()");
        while (it.hasNext()) {
            ArgusNode<?> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            ArgusNode<?> argusNode = next;
            if (argusNode.isRelease()) {
                RFWLog.i(TAG, RFWLog.USR, "remove node:" + argusNode);
                it.remove();
            } else {
                travelAllNode(argusNode, z16, showNodes, hideNodes, addNodes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConfig() {
        argusGlobalConfig.setEnableMonitor(RFWConfig.getConfigValue(ARGUS_ENABLE, true));
        argusGlobalConfig.setEnableWriteDb(RFWConfig.getConfigValue(ARGUS_DB_ENABLE, true));
        argusGlobalConfig.setEnablePredict(RFWConfig.getConfigValue(ARGUS_PREDICT_ENABLE, true));
    }

    private final void updatePage(View pointView, PageInfo newPageInfo) {
        allPages.put(Integer.valueOf(pointView.getWindowToken().hashCode()), newPageInfo);
    }

    private final void writePageChangeRecordToDb(PageInfo newPageInfo, PageInfoPO pageInfoPO, PageInfoPO newPagePO, MergeResult mergeResult, ArrayList<NodePO> firstShowNodes, ArrayList<NodePO> notFirstShowNodes, ActionInfo recordActionInfo) {
        int i3;
        if (isEnableWriteDb()) {
            PageChangeRecord pageChangeRecord = new PageChangeRecord();
            PageInfo pageInfo = currentPageInfo;
            int i16 = 0;
            if (pageInfo != null && pageInfo.getWindowToken() == newPageInfo.getWindowToken()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            pageChangeRecord.isSameRoot = i3;
            PageInfo pageInfo2 = lastGroupInfo;
            if (pageInfo2 != null && pageInfo2.getWindowToken() == newPageInfo.getWindowToken()) {
                i16 = 1;
            }
            pageChangeRecord.isSameRootWithGroup = i16;
            pageChangeRecord.fromPage = pageInfoPO;
            pageChangeRecord.fromGroupPage = lastGroupPagePO;
            pageChangeRecord.toPage = newPagePO;
            ArrayList arrayList = new ArrayList();
            Iterator<ArgusNode<?>> it = mergeResult.getAddNodes().iterator();
            while (it.hasNext()) {
                NodePO nodeTreeTag = it.next().getNodeTreeTag();
                if (nodeTreeTag != null) {
                    arrayList.add(nodeTreeTag);
                }
            }
            pageChangeRecord.addBlocks = arrayList;
            pageChangeRecord.firstShowBlocks = firstShowNodes;
            pageChangeRecord.notFirstShowBlocks = notFirstShowNodes;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it5 = pendingNodes.iterator();
            while (it5.hasNext()) {
                ArgusNode argusNode = (ArgusNode) it5.next();
                if (!argusNode.getHasDispatchPending()) {
                    NodePO nodeTreeTag2 = argusNode.getNodeTreeTag();
                    if (nodeTreeTag2 != null) {
                        arrayList2.add(nodeTreeTag2);
                    }
                    argusNode.setHasDispatchPending(true);
                }
            }
            pageChangeRecord.pendingBlocks = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            Iterator<ArgusNode<?>> it6 = mergeResult.getHideNodes().iterator();
            while (it6.hasNext()) {
                NodePO nodeTreeTag3 = it6.next().getNodeTreeTag();
                if (nodeTreeTag3 != null) {
                    arrayList3.add(nodeTreeTag3);
                }
            }
            pageChangeRecord.hideBlocks = arrayList3;
            pageChangeRecord.actionInfo = recordActionInfo.getType().toString();
            pageChangeRecord.time = System.currentTimeMillis();
            PageChangeRepository.INSTANCE.insert(pageChangeRecord);
        }
    }

    public final void addBlockCreator(@NotNull final ArgusNodeCreator<?> argusNodeCreator) {
        Intrinsics.checkNotNullParameter(argusNodeCreator, "argusNodeCreator");
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            mainHandler.post(new Runnable() { // from class: androidx.fragment.app.Argus$addBlockCreator$1
                @Override // java.lang.Runnable
                public final void run() {
                    List list;
                    Argus argus = Argus.INSTANCE;
                    list = Argus.argusNodeCreators;
                    list.add(ArgusNodeCreator.this);
                }
            });
        } else {
            argusNodeCreators.add(argusNodeCreator);
        }
    }

    public final void clearHistory() {
        try {
            RFWFileUtils.deleteDb("page_change_db");
            RFWFileUtils.deleteDb("argus_db");
            RFWFileUtils.deleteDb("argus_release_db");
            RFWFileUtils.deleteDb("argus_db_release_v2");
            RFWFileUtils.deleteDb("argus_db_release_v3");
            RFWFileUtils.deleteDb("argus_db_release_v4");
            RFWFileUtils.deleteDb("argus_db_release_v5");
            PageChangeRepository pageChangeRepository = PageChangeRepository.INSTANCE;
            ArgusConfigManager argusConfigManager = ArgusConfigManager.INSTANCE;
            pageChangeRepository.deletePageRecordBefore(argusConfigManager.getStrategyConfig().getRecordClearPastMinutes());
            PageInflateRepository.INSTANCE.deleteRecordsBefore(argusConfigManager.getStrategyConfig().getRecordClearPastMinutes());
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
        }
    }

    @Nullable
    public final ArgusNode<?> findViewBlockNode(@NotNull View view, boolean createIfNotExist) {
        Intrinsics.checkNotNullParameter(view, "view");
        while (true) {
            View view2 = null;
            if (view == null) {
                return null;
            }
            ArgusNode<?> node = getNode(view, null, createIfNotExist);
            if (node != null) {
                return node;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view2 = parent;
            }
            view = view2;
        }
    }

    @Nullable
    public final PageInfoPO getLastGroupPagePO() {
        return lastGroupPagePO;
    }

    @Nullable
    public final ArgusNode<?> getNode(@NotNull View currentView, @Nullable Object container, boolean createIfEmpty) {
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        return getNode(currentView, container, createIfEmpty, false);
    }

    public final void getPageUniteTag(@NotNull final View view, @NotNull final UniqueTagCallback uniqueTagCallback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uniqueTagCallback, "uniqueTagCallback");
        if (view.isAttachedToWindow()) {
            ArgusNode findViewBlockNode$default = findViewBlockNode$default(this, view, false, 2, null);
            if (findViewBlockNode$default != null) {
                uniqueTagCallback.onUniqueTagResult(UNIQUE_TAG_GSON.toJson(findViewBlockNode$default.getNodeTreeTag()));
                return;
            }
            return;
        }
        view.post(new Runnable() { // from class: androidx.fragment.app.Argus$getPageUniteTag$2
            @Override // java.lang.Runnable
            public final void run() {
                Gson gson;
                ArgusNode findViewBlockNode$default2 = Argus.findViewBlockNode$default(Argus.INSTANCE, view, false, 2, null);
                if (findViewBlockNode$default2 != null) {
                    Argus.UniqueTagCallback uniqueTagCallback2 = uniqueTagCallback;
                    gson = Argus.UNIQUE_TAG_GSON;
                    uniqueTagCallback2.onUniqueTagResult(gson.toJson(findViewBlockNode$default2.getNodeTreeTag()));
                }
            }
        });
    }

    @NotNull
    public final HashSet<ArgusNode<?>> getPendingNodes() {
        return pendingNodes;
    }

    public final boolean isDebug() {
        return ((Boolean) isDebug.getValue()).booleanValue();
    }

    public final boolean isEnablePredict() {
        if (RFWApplication.isPublicVersion() && !argusGlobalConfig.getEnablePredict()) {
            return false;
        }
        return true;
    }

    public final boolean isEnableWriteDb() {
        if (RFWApplication.isPublicVersion() && !argusGlobalConfig.getEnableWriteDb()) {
            return false;
        }
        return true;
    }

    public final boolean isMonitorEnable() {
        if (RFWApplication.isPublicVersion() && !argusGlobalConfig.getEnableMonitor()) {
            return false;
        }
        return true;
    }

    public final void log(final boolean highLight, @NotNull final Object... message) {
        Intrinsics.checkNotNullParameter(message, "message");
        RFWLogExecutor.f25095b.a(isLoggingInSubThread(), new Runnable() { // from class: androidx.fragment.app.Argus$log$1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder obtain = RFWStringBuilderUtils.obtain();
                for (Object obj : message) {
                    obtain.append(obj);
                }
                String sb5 = obtain.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "stringBuilder\n          \u2026              .toString()");
                if (highLight) {
                    RFWLog.e(Argus.TAG, RFWLog.USR, sb5);
                } else {
                    RFWLog.i(Argus.TAG, RFWLog.USR, sb5);
                }
            }
        });
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: androidx.fragment.app.Argus$onProcessBackground$1
            @Override // java.lang.Runnable
            public final void run() {
                if (ArgusConfigManager.INSTANCE.getStrategyConfig().getRecordClearPastMinutes() > 0) {
                    Argus.INSTANCE.clearHistory();
                }
            }
        });
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public /* bridge */ /* synthetic */ void onProcessForeground() {
        com.tencent.richframework.lifecycle.a.b(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ArgusNode<?> nodeFromView = getNodeFromView(targetView);
        if (nodeFromView != null && nodeFromView.getParentNode() == null) {
            bindNodeWithParent(targetView, nodeFromView);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View targetView) {
        ArgusNode<?> parentNode;
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ArgusNode<?> nodeFromView = getNodeFromView(targetView);
        if (nodeFromView != null && (parentNode = getParentNode(targetView)) != null) {
            parentNode.removeChildNode(nodeFromView);
            nodeFromView.setParentNode(null);
        }
    }

    public final void registerComponentCallback(@NotNull ComponentCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<ComponentCallback> list = componentCallbacks;
        synchronized (list) {
            list.add(callback);
        }
    }

    public final void removeBlockCreator(@NotNull ArgusNodeCreator<?> argusNodeCreator) {
        Intrinsics.checkNotNullParameter(argusNodeCreator, "argusNodeCreator");
        argusNodeCreators.remove(argusNodeCreator);
    }

    public final void sendActionInfo(@NotNull ActionInfo actionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (Intrinsics.areEqual(actionInfo, pendingActionInfo)) {
            return;
        }
        if (pendingActionInfo != null) {
            lastGroupInfo = null;
            lastGroupPagePO = null;
        }
        if (isDebug()) {
            RFWLog.d(TAG, RFWLog.DEV, "sendActionInfo: pendInfo:" + pendingActionInfo + " newActionInfo:" + actionInfo);
        }
        pendingActionInfo = actionInfo;
    }

    public final void setLastGroupPagePO(@Nullable PageInfoPO pageInfoPO) {
        lastGroupPagePO = pageInfoPO;
    }

    public final void setPendingNodes(@NotNull HashSet<ArgusNode<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        pendingNodes = hashSet;
    }

    public final void startMonitor(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (!isMonitorEnable()) {
            return;
        }
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this);
        application.registerActivityLifecycleCallbacks(new Argus$startMonitor$1());
    }

    public final void unRegisterComponentCallback(@NotNull ComponentCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<ComponentCallback> list = componentCallbacks;
        synchronized (list) {
            list.remove(callback);
        }
    }

    private final PageInfo getPageFromView(int windowToken) {
        return allPages.get(Integer.valueOf(windowToken));
    }

    private final void updatePage(int windowToken, PageInfo newPageInfo) {
        allPages.put(Integer.valueOf(windowToken), newPageInfo);
    }

    @Nullable
    public final ArgusNode<?> getNode(@NotNull View targetView, @Nullable Object container, boolean createIfEmpty, boolean updateNode) {
        ArgusNode<?> createNode;
        boolean areEqual;
        ArgusNode<?> parentNode;
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (!isMonitorEnable()) {
            return null;
        }
        ArgusNode<?> nodeFromView = getNodeFromView(targetView);
        if (nodeFromView != null && !updateNode) {
            return nodeFromView;
        }
        if ((nodeFromView == null && !createIfEmpty) || (createNode = createNode(nodeFromView, targetView, container)) == null) {
            return null;
        }
        if ((createNode instanceof ArgusMergeNode) && (nodeFromView instanceof ArgusMergeNode)) {
            areEqual = ((ArgusMergeNode) createNode).getInnerNodes().size() == ((ArgusMergeNode) nodeFromView).getInnerNodes().size();
        } else {
            areEqual = Intrinsics.areEqual(createNode.getClass(), nodeFromView != null ? nodeFromView.getClass() : null);
        }
        targetView.setTag(R.id.t8x, createNode);
        targetView.addOnAttachStateChangeListener(this);
        if (nodeFromView == null) {
            bindNodeWithParent(targetView, createNode);
        } else if (!areEqual && (parentNode = getParentNode(targetView)) != null) {
            parentNode.removeChildNode(nodeFromView);
            parentNode.addChildNode(createNode);
            createNode.setParentNode(parentNode);
        }
        return createNode;
    }

    public final void updatePage(@NotNull final View currentView) {
        IBinder windowToken;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        if (isDebug()) {
            int i3 = RFWLog.USR;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updatePage: view:");
            sb5.append(currentView);
            sb5.append("   context:");
            sb5.append(currentView.getContext());
            sb5.append("   Lifecycle:");
            Object context = currentView.getContext();
            if (!(context instanceof LifecycleOwner)) {
                context = null;
            }
            LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
            sb5.append((lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState());
            sb5.append("   windowToken:");
            IBinder windowToken2 = currentView.getWindowToken();
            int i16 = 0;
            sb5.append(windowToken2 != null ? windowToken2.hashCode() : 0);
            sb5.append("   rootViewContext:");
            View rootView = currentView.getRootView();
            sb5.append(rootView != null ? rootView.getContext() : null);
            sb5.append("   rootViewWindowToken:");
            IBinder windowToken3 = currentView.getWindowToken();
            sb5.append(windowToken3 != null ? windowToken3.hashCode() : 0);
            sb5.append("   contentView:");
            sb5.append(currentView.getRootView().findViewById(android.R.id.content));
            sb5.append("   contentViewWindowToken:");
            View findViewById = currentView.getRootView().findViewById(android.R.id.content);
            if (findViewById != null && (windowToken = findViewById.getWindowToken()) != null) {
                i16 = windowToken.hashCode();
            }
            sb5.append(i16);
            RFWLog.i(TAG, i3, sb5.toString());
        }
        if (isMonitorEnable()) {
            if (!currentView.isAttachedToWindow()) {
                currentView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.Argus$updatePage$2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NotNull View v3) {
                        Intrinsics.checkNotNullParameter(v3, "v");
                        Argus.INSTANCE.updatePage(currentView);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NotNull View v3) {
                        Intrinsics.checkNotNullParameter(v3, "v");
                    }
                });
            } else if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                currentView.post(new Runnable() { // from class: androidx.fragment.app.Argus$updatePage$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Argus.INSTANCE.updatePage(currentView.getWindowToken());
                    }
                });
            } else {
                updatePage(currentView.getWindowToken());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void updatePage(IBinder windowToken) {
        int hashCode;
        PageInfo pageFromView;
        if (windowToken == null || (pageFromView = getPageFromView((hashCode = windowToken.hashCode()))) == null) {
            return;
        }
        PageInfoPO pageInfoPO = allPagesPO.get(Integer.valueOf(hashCode));
        MergeResult mergePageDiff = mergePageDiff(pageFromView);
        log(true, "mergeResult:", mergePageDiff);
        if (mergePageDiff.getIsChange()) {
            Iterator<ArgusNode<?>> it = mergePageDiff.getShowNodes().iterator();
            while (it.hasNext()) {
                it.next().setNodeLifecycleState(Lifecycle.State.RESUMED);
            }
            Iterator<ArgusNode<?>> it5 = mergePageDiff.getHideNodes().iterator();
            while (it5.hasNext()) {
                it5.next().setNodeLifecycleState(Lifecycle.State.CREATED);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(pageFromView.getAllVisibleNode());
            linkedHashSet.addAll(mergePageDiff.getShowNodes());
            linkedHashSet.removeAll(mergePageDiff.getHideNodes());
            log(false, "allVisibleBlockInfo:", linkedHashSet);
            PageInfo pageInfo = new PageInfo(hashCode, pageFromView.getRootNode(), linkedHashSet);
            ActionInfo actionInfo = pendingActionInfo;
            ActionInfo actionInfo2 = actionInfo != null ? actionInfo : new ActionInfo(hashCode, ActionInfo.Type.UNKNOWN, 0.0f, 0.0f, 12, null);
            pageFromView.printAll(TAG);
            updatePage(hashCode, pageInfo);
            PageInfoPO visiblePageInfoPO = pageInfo.getVisiblePageInfoPO();
            boolean isVisible = pageInfo.getRootNode().isVisible(false);
            log(false, "isNewPageInfoVisible:", Boolean.valueOf(isVisible));
            if (isVisible) {
                UpdateGroupTask updateGroupTask2 = updateGroupTask;
                if (updateGroupTask2 != null) {
                    groupHandler.removeCallbacks(updateGroupTask2);
                }
                if (lastGroupPagePO == null && pageInfoPO == null) {
                    new UpdateGroupTask(pageInfo, visiblePageInfoPO).run();
                } else {
                    UpdateGroupTask updateGroupTask3 = new UpdateGroupTask(pageInfo, visiblePageInfoPO);
                    groupHandler.postDelayed(updateGroupTask3, ArgusConfigManager.INSTANCE.getStrategyConfig().getMinChangeGroupMill());
                    updateGroupTask = updateGroupTask3;
                }
            }
            dispatchPageChange(pageFromView, pageInfoPO, pageInfo, visiblePageInfoPO, lastGroupPagePO, mergePageDiff);
            ArrayList<NodePO> arrayList = new ArrayList<>();
            ArrayList<NodePO> arrayList2 = new ArrayList<>();
            for (ArgusNode<?> argusNode : mergePageDiff.getShowNodes()) {
                if (!argusNode.getHasDispatchShown()) {
                    NodePO nodeTreeTag = argusNode.getNodeTreeTag();
                    if (nodeTreeTag != null) {
                        arrayList.add(nodeTreeTag);
                    }
                    argusNode.setHasDispatchShown(true);
                } else {
                    NodePO nodeTreeTag2 = argusNode.getNodeTreeTag();
                    if (nodeTreeTag2 != null) {
                        arrayList2.add(nodeTreeTag2);
                    }
                }
            }
            writePageChangeRecordToDb(pageInfo, pageInfoPO, visiblePageInfoPO, mergePageDiff, arrayList, arrayList2, actionInfo2);
            allPagesPO.put(Integer.valueOf(hashCode), visiblePageInfoPO);
            if (isVisible) {
                currentPageInfo = pageInfo;
                currentPageInfoPO = visiblePageInfoPO;
            }
        }
    }
}
