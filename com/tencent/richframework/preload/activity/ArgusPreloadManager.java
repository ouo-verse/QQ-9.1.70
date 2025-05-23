package com.tencent.richframework.preload.activity;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.WorkerThread;
import androidx.collection.LruCache;
import androidx.fragment.app.Argus;
import androidx.fragment.app.ArgusUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.delegate.util.RFWConfigExtKt;
import com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector;
import com.tencent.biz.richframework.layoutinflater.LayoutPreloadConfigManager;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.layoutinflater.ViewInflateRecordExtKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryInflateRecord;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.richframework.argus.page.db.PageInflateRecord;
import com.tencent.richframework.argus.page.db.PageInflateRepository;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.preload.activity.BaseActivityPreloadTask;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t\b\u0002\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J,\u0010\u0017\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J$\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\u001e\u0010%\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J>\u0010.\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010'2\u0006\u0010-\u001a\u00020,H\u0016J \u00101\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0 H\u0016J\u001c\u00104\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u00103\u001a\u000202H\u0017J\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a062\u0006\u00105\u001a\u00020\u0018J\b\u00108\u001a\u00020\u0005H\u0016J\u001a\u0010;\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010@\u001a\u000209H\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R \u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020Q0P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020]8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\u00a8\u0006e"}, d2 = {"Lcom/tencent/richframework/preload/activity/ArgusPreloadManager;", "Landroidx/fragment/app/Argus$ComponentCallback;", "Lcom/tencent/biz/richframework/layoutinflater/ArgusInflateCollector$InflateCollectCallback;", "Lcom/tencent/richframework/lifecycle/IProcessStateChangeCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "", "initCallback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "preloadForLaunch", "Lcom/tencent/richframework/argus/node/ArgusNode;", "rootNode", "Lcom/tencent/richframework/argus/node/NodePO;", "showNode", "findTargetNode", "node", "Lcom/tencent/richframework/argus/page/PageInfo;", "currentPageInfo", "getPreloadContextActivity", "allNodePO", "showBlock", "", "isSameFromGroup", "handleShowBlock", "", "fullResName", "", "getResIdFromString", "", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "resMap", "preloadWithCurrentActivity", "", "Lcom/tencent/richframework/argus/page/db/HistoryInflateRecord;", "historyInflateRecords", "getPreloadResConfigFromLaunch", "getPreloadResConfigFromSameNode", "preloadWithCreateActivity", "fromPage", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromPagePO", "newPage", "newPagePO", "groupPO", "Landroidx/fragment/app/Argus$MergeResult;", "mergeResult", "onPageChange", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "historyPageChanges", "onPredictResult", "Lcom/tencent/richframework/argus/page/db/PageInflateRecord;", "pageInflateRecord", "onInflateCollect", "containerClassName", "Lkotlin/Pair;", "getPreloadCount", "onProcessBackground", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Landroidx/collection/LruCache;", "resNameToId", "Landroidx/collection/LruCache;", "Lcom/tencent/richframework/preload/activity/PreloadMode;", "preloadMode", "Lcom/tencent/richframework/preload/activity/PreloadMode;", "getPreloadMode", "()Lcom/tencent/richframework/preload/activity/PreloadMode;", "setPreloadMode", "(Lcom/tencent/richframework/preload/activity/PreloadMode;)V", "Lcom/tencent/richframework/preload/activity/CheckMode;", "checkMode", "Lcom/tencent/richframework/preload/activity/CheckMode;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/richframework/preload/activity/InflateCollectData;", "nodePreloadStatistics", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/richframework/preload/activity/PreloadNodeType;", "preloadNodeType", "Lcom/tencent/richframework/preload/activity/PreloadNodeType;", "preloadForLaunchEnabled", "Z", "getPreloadForLaunchEnabled", "()Z", "setPreloadForLaunchEnabled", "(Z)V", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "layoutPreLoader$delegate", "Lkotlin/Lazy;", "getLayoutPreLoader", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "layoutPreLoader", "<init>", "()V", "argus-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusPreloadManager implements Argus.ComponentCallback, ArgusInflateCollector.InflateCollectCallback, IProcessStateChangeCallback, Application.ActivityLifecycleCallbacks {

    @NotNull
    public static final ArgusPreloadManager INSTANCE;
    private static CheckMode checkMode;

    /* renamed from: layoutPreLoader$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy layoutPreLoader;
    private static ConcurrentHashMap<String, InflateCollectData> nodePreloadStatistics;
    private static boolean preloadForLaunchEnabled;

    @NotNull
    private static PreloadMode preloadMode;
    private static PreloadNodeType preloadNodeType;
    private static final LruCache<String, Integer> resNameToId;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreloadNodeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PreloadNodeType.FIRST_ADD.ordinal()] = 1;
            iArr[PreloadNodeType.FIRST_SHOW.ordinal()] = 2;
        }
    }

    static {
        PreloadNodeType preloadNodeType2;
        Lazy lazy;
        ArgusPreloadManager argusPreloadManager = new ArgusPreloadManager();
        INSTANCE = argusPreloadManager;
        resNameToId = new LruCache<>(100);
        preloadMode = PreloadMode.PRELOAD_WITH_TAG;
        checkMode = CheckMode.CHECK_NODE;
        nodePreloadStatistics = new ConcurrentHashMap<>();
        if (RFWApplication.isPublicVersion() && !RFWConfig.getConfigValue("ARGUS_PRELOAD_USE_ADD_NODE", true)) {
            preloadNodeType2 = PreloadNodeType.FIRST_SHOW;
        } else {
            preloadNodeType2 = PreloadNodeType.FIRST_ADD;
        }
        preloadNodeType = preloadNodeType2;
        preloadForLaunchEnabled = RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("ARGUS_PRELOAD_FOR_LAUNCH");
        argusPreloadManager.initCallback();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.richframework.preload.activity.ArgusPreloadManager$layoutPreLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                return RFWLayoutPreLoaderFactory.getLayoutLoader(new PredictLayoutLoadStrategy());
            }
        });
        layoutPreLoader = lazy;
    }

    ArgusPreloadManager() {
    }

    private final ArgusNode<?> findTargetNode(ArgusNode<?> rootNode, NodePO showNode) {
        ArgusNode<?> findNodeFromRootNode = ArgusUtil.INSTANCE.findNodeFromRootNode(rootNode, showNode);
        if (findNodeFromRootNode != null) {
            RFWLog.i("ArgusPreloadManager", RFWLog.USR, "find node fromPageRootNode " + rootNode);
            return findNodeFromRootNode;
        }
        NodePO findSelfPO = ArgusPreloadManagerKt.findSelfPO(showNode);
        Iterator<ArgusNode<?>> it = Argus.INSTANCE.getPendingNodes().iterator();
        while (it.hasNext()) {
            ArgusNode<?> pendingNode = it.next();
            ArgusUtil argusUtil = ArgusUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(pendingNode, "pendingNode");
            ArgusNode<?> findNodeFromRootNode2 = argusUtil.findNodeFromRootNode(pendingNode, findSelfPO);
            if (findNodeFromRootNode2 != null) {
                RFWLog.i("ArgusPreloadManager", RFWLog.USR, "find node from pending node " + findNodeFromRootNode2);
                return findNodeFromRootNode2;
            }
        }
        return null;
    }

    private final Activity getPreloadContextActivity(ArgusNode<?> node, PageInfo currentPageInfo) {
        Object obj;
        Object obj2;
        ArgusNode<?> rootNode;
        Object obj3;
        View nodeView;
        Object obj4 = null;
        if (node != null) {
            obj = node.getContainer();
        } else {
            obj = null;
        }
        if (!(obj instanceof Activity)) {
            obj = null;
        }
        Activity activity = (Activity) obj;
        if (activity == null) {
            if (node != null && (nodeView = node.getNodeView()) != null) {
                obj3 = nodeView.getContext();
            } else {
                obj3 = null;
            }
            if (!(obj3 instanceof Activity)) {
                obj3 = null;
            }
            activity = (Activity) obj3;
        }
        if (activity == null) {
            if (currentPageInfo != null && (rootNode = currentPageInfo.getRootNode()) != null) {
                obj2 = rootNode.getContainer();
            } else {
                obj2 = null;
            }
            if (obj2 instanceof Activity) {
                obj4 = obj2;
            }
            return (Activity) obj4;
        }
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<PreloadRequest, Integer> getPreloadResConfigFromLaunch(List<? extends HistoryInflateRecord> historyInflateRecords) {
        int coerceAtLeast;
        boolean z16;
        HashMap hashMap = new HashMap();
        for (HistoryInflateRecord historyInflateRecord : historyInflateRecords) {
            int i3 = historyInflateRecord.resId;
            boolean z17 = true;
            if (i3 == 0) {
                String str = historyInflateRecord.resName;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String str2 = historyInflateRecord.resName;
                    Intrinsics.checkNotNullExpressionValue(str2, "inflateRecord.resName");
                    getResIdFromString(str2);
                }
            }
            if (i3 != Integer.MIN_VALUE) {
                String str3 = historyInflateRecord.rootClassName;
                Intrinsics.checkNotNullExpressionValue(str3, "inflateRecord.rootClassName");
                String str4 = historyInflateRecord.itemLayoutManager;
                String str5 = "";
                if (str4 == null) {
                    str4 = "";
                }
                PreloadRequest preloadRequest = new PreloadRequest(i3, str3, str4);
                Object obj = hashMap.get(preloadRequest);
                if (obj == null) {
                    obj = 0;
                    hashMap.put(preloadRequest, obj);
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(historyInflateRecord.count, ((Number) obj).intValue());
                String str6 = historyInflateRecord.rootClassName;
                Intrinsics.checkNotNullExpressionValue(str6, "inflateRecord.rootClassName");
                String str7 = historyInflateRecord.itemLayoutManager;
                if (str7 != null) {
                    str5 = str7;
                }
                PreloadRequest preloadRequest2 = new PreloadRequest(i3, str6, str5);
                String str8 = historyInflateRecord.customContextName;
                if (str8 != null && str8.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    preloadRequest2.setCustomContextClass(Class.forName(historyInflateRecord.customContextName));
                }
                Unit unit = Unit.INSTANCE;
                hashMap.put(preloadRequest2, Integer.valueOf(coerceAtLeast));
            }
        }
        if (Argus.INSTANCE.isDebug()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                RFWLog.i("ArgusPreloadManager", RFWLog.USR, ((PreloadRequest) entry.getKey()).toString() + " count:" + ((Number) entry.getValue()).intValue());
            }
        }
        return hashMap;
    }

    private final Map<PreloadRequest, Integer> getPreloadResConfigFromSameNode(List<? extends HistoryInflateRecord> historyInflateRecords) {
        boolean z16;
        boolean z17;
        boolean z18;
        HashMap hashMap = new HashMap();
        List<? extends HistoryInflateRecord> list = historyInflateRecords;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return hashMap;
        }
        int i3 = historyInflateRecords.get(0).patchId;
        for (HistoryInflateRecord historyInflateRecord : historyInflateRecords) {
            if (i3 == historyInflateRecord.patchId) {
                int i16 = historyInflateRecord.resId;
                if (i16 == 0) {
                    String str = historyInflateRecord.resName;
                    if (str != null && str.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        String str2 = historyInflateRecord.resName;
                        Intrinsics.checkNotNullExpressionValue(str2, "inflateRecord.resName");
                        getResIdFromString(str2);
                    }
                }
                if (i16 != Integer.MIN_VALUE) {
                    String str3 = historyInflateRecord.rootClassName;
                    Intrinsics.checkNotNullExpressionValue(str3, "inflateRecord.rootClassName");
                    String str4 = historyInflateRecord.itemLayoutManager;
                    if (str4 == null) {
                        str4 = "";
                    }
                    PreloadRequest preloadRequest = new PreloadRequest(i16, str3, str4);
                    String str5 = historyInflateRecord.customContextName;
                    if (str5 != null && str5.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        preloadRequest.setCustomContextClass(Class.forName(historyInflateRecord.customContextName));
                    }
                    Unit unit = Unit.INSTANCE;
                    hashMap.put(preloadRequest, Integer.valueOf(historyInflateRecord.count));
                }
            }
        }
        if (Argus.INSTANCE.isDebug()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                RFWLog.i("ArgusPreloadManager", RFWLog.USR, ((PreloadRequest) entry.getKey()).toString() + " count:" + ((Number) entry.getValue()).intValue());
            }
        }
        return hashMap;
    }

    private final int getResIdFromString(String fullResName) {
        List split$default;
        List split$default2;
        LruCache<String, Integer> lruCache = resNameToId;
        Integer num = lruCache.get(fullResName);
        if (num == null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) fullResName, new String[]{":"}, false, 2, 2, (Object) null);
            String str = (String) split$default.get(0);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{"/"}, false, 2, 2, (Object) null);
            String str2 = (String) split$default2.get(0);
            String str3 = (String) split$default2.get(1);
            Resources resources = RFWApplication.getApplication().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "RFWApplication.getApplication().getResources()");
            try {
                num = Integer.valueOf(resources.getIdentifier(str3, str2, str));
                lruCache.put(fullResName, num);
            } catch (Exception unused) {
            }
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        return num.intValue();
    }

    private final void handleShowBlock(PageInfo currentPageInfo, NodePO allNodePO, NodePO showBlock, boolean isSameFromGroup) {
        Object obj;
        ArgusNode<?> rootNode;
        ArgusNode<?> rootNode2;
        int i3;
        View nodeView;
        if (!ArgusPreloadManagerKt.isNodeAutoPreloadEnabled(preloadMode, showBlock)) {
            if (Argus.INSTANCE.isDebug()) {
                RFWLog.w("ArgusPreloadManager", RFWLog.USR, "can't preload this block: " + showBlock);
                return;
            }
            return;
        }
        List<HistoryInflateRecord> pageCountPastSevenDays = PageInflateRepository.INSTANCE.getPageCountPastSevenDays(showBlock);
        boolean z16 = true;
        int i16 = 0;
        RFWLog.e("ArgusPreloadManager", RFWLog.USR, "find inflate record:" + pageCountPastSevenDays.size());
        if (!pageCountPastSevenDays.isEmpty()) {
            if (isSameFromGroup) {
                Map<PreloadRequest, Integer> preloadResConfigFromSameNode = getPreloadResConfigFromSameNode(pageCountPastSevenDays);
                Object obj2 = null;
                r9 = null;
                ArrayList<HistoryInflateRecord> arrayList = null;
                if (checkMode == CheckMode.CHECK_NODE) {
                    if (currentPageInfo != null && (rootNode2 = currentPageInfo.getRootNode()) != null) {
                        ArgusPreloadManager argusPreloadManager = INSTANCE;
                        ArgusNode<?> findTargetNode = argusPreloadManager.findTargetNode(rootNode2, showBlock);
                        if (findTargetNode != null && (nodeView = findTargetNode.getNodeView()) != null) {
                            arrayList = ViewInflateRecordExtKt.getInflateRecord(nodeView);
                        }
                        Map<PreloadRequest, Integer> preloadResConfigFromSameNode2 = argusPreloadManager.getPreloadResConfigFromSameNode(arrayList);
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<PreloadRequest, Integer> entry : preloadResConfigFromSameNode.entrySet()) {
                            Integer num = preloadResConfigFromSameNode2.get(entry.getKey());
                            if (num != null) {
                                i3 = num.intValue();
                            } else {
                                i3 = i16;
                            }
                            int intValue = entry.getValue().intValue() - i3;
                            if (intValue > 0) {
                                hashMap.put(entry.getKey(), Integer.valueOf(intValue));
                            }
                            RFWLog.w("ArgusPreloadManager", RFWLog.USR, "node " + entry.getKey().getResId() + " exist:" + i3 + " need:" + intValue);
                            i16 = 0;
                        }
                        if (!hashMap.isEmpty()) {
                            if (findTargetNode == null) {
                                ArgusPreloadManager argusPreloadManager2 = INSTANCE;
                                NodePO findActivityNodePO = ArgusPreloadManagerKt.findActivityNodePO(showBlock);
                                if (findActivityNodePO != null) {
                                    findTargetNode = argusPreloadManager2.findTargetNode(rootNode2, findActivityNodePO);
                                } else {
                                    RFWLog.e("ArgusPreloadManager", RFWLog.USR, "can't find activity node");
                                    return;
                                }
                            }
                            ArgusPreloadManager argusPreloadManager3 = INSTANCE;
                            Activity preloadContextActivity = argusPreloadManager3.getPreloadContextActivity(findTargetNode, currentPageInfo);
                            if (preloadContextActivity != null) {
                                argusPreloadManager3.preloadWithCurrentActivity(preloadContextActivity, hashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (checkMode == CheckMode.CHECK_PO) {
                    if (allNodePO == null || ArgusUtil.INSTANCE.checkIsAlreadyExist(allNodePO, showBlock)) {
                        z16 = false;
                    }
                    RFWLog.w("ArgusPreloadManager", RFWLog.USR, "is exist:" + z16);
                    if (!z16) {
                        if (currentPageInfo != null && (rootNode = currentPageInfo.getRootNode()) != null) {
                            obj = rootNode.getContainer();
                        } else {
                            obj = null;
                        }
                        if (obj instanceof Activity) {
                            obj2 = obj;
                        }
                        Activity activity = (Activity) obj2;
                        if (activity != null) {
                            preloadWithCurrentActivity(activity, preloadResConfigFromSameNode);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            RFWLog.i("ArgusPreloadManager", RFWLog.USR, "is new root start preload activity: showBlock:" + showBlock.getContainerClass());
            preloadWithCreateActivity(showBlock, pageCountPastSevenDays);
        }
    }

    private final void initCallback() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.richframework.preload.activity.ArgusPreloadManager$initCallback$1
            @Override // java.lang.Runnable
            public final void run() {
                ArgusInflateCollector argusInflateCollector = ArgusInflateCollector.INSTANCE;
                ArgusPreloadManager argusPreloadManager = ArgusPreloadManager.INSTANCE;
                argusInflateCollector.registerComponentCallback(argusPreloadManager);
                RFWLifecycleHelper.getInstance().registerProcessChangeListener(argusPreloadManager);
                RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(argusPreloadManager);
            }
        });
    }

    private final void preloadForLaunch(Activity activity) {
        final WeakReference weakReference = new WeakReference(activity);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.richframework.preload.activity.ArgusPreloadManager$preloadForLaunch$1
            @Override // java.lang.Runnable
            public final void run() {
                Map preloadResConfigFromLaunch;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    Intrinsics.checkNotNullExpressionValue(activity2, "launchActivityWrf.get() ?: return@execOnFileThread");
                    List<HistoryInflateRecord> launchInflateRecordPastTreeDays = PageInflateRepository.INSTANCE.getLaunchInflateRecordPastTreeDays();
                    for (HistoryInflateRecord historyInflateRecord : launchInflateRecordPastTreeDays) {
                        RFWLog.i("ArgusPreloadManager", RFWLog.USR, "launchRecord:" + historyInflateRecord.resName + " patchId:" + historyInflateRecord.launchStageId + " launchStageId:" + historyInflateRecord.launchStageId + " count:" + historyInflateRecord.count);
                    }
                    preloadResConfigFromLaunch = ArgusPreloadManager.INSTANCE.getPreloadResConfigFromLaunch(launchInflateRecordPastTreeDays);
                    for (Map.Entry entry : preloadResConfigFromLaunch.entrySet()) {
                        ArgusPreloadManager.INSTANCE.getLayoutPreLoader().fillPreloadView(activity2, (PreloadRequest) entry.getKey(), ((Number) entry.getValue()).intValue());
                    }
                }
            }
        });
    }

    private final void preloadWithCreateActivity(final NodePO showBlock, List<? extends HistoryInflateRecord> historyInflateRecords) {
        try {
            if (TextUtils.isEmpty(showBlock.getContainerClass())) {
                return;
            }
            final Class<?> cls = Class.forName(showBlock.getContainerClass());
            if (!Activity.class.isAssignableFrom(cls)) {
                RFWLog.e("ArgusPreloadManager", RFWLog.USR, "is not activity class:" + cls);
                return;
            }
            final Map<PreloadRequest, Integer> preloadResConfigFromSameNode = getPreloadResConfigFromSameNode(historyInflateRecords);
            RFWLog.i("ArgusPreloadManager", RFWLog.USR, "addPreloadTask:" + cls + " taskKey:" + showBlock);
            ActivityPreloadManager.INSTANCE.addPreloadTask(new BaseActivityResPreloadTask() { // from class: com.tencent.richframework.preload.activity.ArgusPreloadManager$preloadWithCreateActivity$1
                @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
                @NotNull
                public Class<Activity> getActivityClass() {
                    Class<Activity> cls2 = cls;
                    if (cls2 != null) {
                        return cls2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.app.Activity>");
                }

                @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
                @NotNull
                public BaseActivityPreloadTask.ExecuteMode getExecuteMode() {
                    return BaseActivityPreloadTask.ExecuteMode.IDLE;
                }

                @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
                @NotNull
                public BaseActivityPreloadTask.PreloadMode getPreloadMode() {
                    if (LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getPreloadActivityTaskRecycle()) {
                        return BaseActivityPreloadTask.PreloadMode.RECYCLE;
                    }
                    return BaseActivityPreloadTask.PreloadMode.ONCE;
                }

                @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
                @NotNull
                public Map<PreloadRequest, Integer> getPreloadRes() {
                    return preloadResConfigFromSameNode;
                }

                @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
                @NotNull
                public RFWLayoutPreLoader getTargetPreLoader() {
                    return ArgusPreloadManager.INSTANCE.getLayoutPreLoader();
                }

                @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
                @NotNull
                public String getTaskKey() {
                    return NodePO.this.toString();
                }
            });
        } catch (ClassNotFoundException e16) {
            RFWLog.e("ArgusPreloadManager", RFWLog.USR, e16);
        }
    }

    private final void preloadWithCurrentActivity(Activity activity, Map<PreloadRequest, Integer> resMap) {
        RFWLog.i("ArgusPreloadManager", RFWLog.USR, "is activity container, start preload");
        Iterator<T> it = resMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int intValue = ((Number) entry.getValue()).intValue();
            ArgusPreloadManager argusPreloadManager = INSTANCE;
            int viewCountInCache = argusPreloadManager.getLayoutPreLoader().getViewCountInCache(activity, (PreloadRequest) entry.getKey());
            int i3 = intValue - viewCountInCache;
            Application application = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
            String resourceName = application.getResources().getResourceName(((PreloadRequest) entry.getKey()).getResId());
            RFWLog.i("ArgusPreloadManager", RFWLog.USR, "predict inflate id: " + ((PreloadRequest) entry.getKey()) + ", name: " + resourceName + " predictCount: " + intValue + " cacheCount:" + viewCountInCache + TokenParser.SP + " needInflateCount:" + i3 + " context:" + activity);
            if (i3 >= 1) {
                argusPreloadManager.getLayoutPreLoader().preloadView(activity, (PreloadRequest) entry.getKey(), i3);
            } else {
                RFWLog.w("ArgusPreloadManager", RFWLog.USR, "preload enough resId: " + ((PreloadRequest) entry.getKey()) + " name: " + resourceName + " cacheCount: " + viewCountInCache);
            }
        }
    }

    @NotNull
    public final RFWLayoutPreLoader getLayoutPreLoader() {
        return (RFWLayoutPreLoader) layoutPreLoader.getValue();
    }

    @NotNull
    public final Pair<Integer, Integer> getPreloadCount(@NotNull String containerClassName) {
        int i3;
        Intrinsics.checkNotNullParameter(containerClassName, "containerClassName");
        InflateCollectData remove = nodePreloadStatistics.remove(containerClassName);
        int i16 = 0;
        if (remove != null) {
            i3 = remove.getCacheCount();
        } else {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i3);
        if (remove != null) {
            i16 = remove.getTotalCount();
        }
        return new Pair<>(valueOf, Integer.valueOf(i16));
    }

    public final boolean getPreloadForLaunchEnabled() {
        return preloadForLaunchEnabled;
    }

    @NotNull
    public final PreloadMode getPreloadMode() {
        return preloadMode;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (preloadForLaunchEnabled && ArgusUtil.INSTANCE.isLaunchMainActivity(activity)) {
            preloadForLaunch(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector.InflateCollectCallback
    @WorkerThread
    public void onInflateCollect(@NotNull ArgusNode<?> node, @NotNull PageInflateRecord pageInflateRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(pageInflateRecord, "pageInflateRecord");
        ArgusNode<?> findAutoPreloadNode = ArgusPreloadManagerKt.findAutoPreloadNode(preloadMode, node);
        if (findAutoPreloadNode != null) {
            if (findAutoPreloadNode.getContainerClassName().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                InflateCollectData inflateCollectData = nodePreloadStatistics.get(findAutoPreloadNode.getContainerClassName());
                if (inflateCollectData == null) {
                    inflateCollectData = new InflateCollectData();
                    nodePreloadStatistics.put(findAutoPreloadNode.getContainerClassName(), inflateCollectData);
                }
                inflateCollectData.setTotalCount(inflateCollectData.getTotalCount() + 1);
                if (pageInflateRecord.isFromCache == 1) {
                    inflateCollectData.setCacheCount(inflateCollectData.getCacheCount() + 1);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull Argus.MergeResult mergeResult) {
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        Intrinsics.checkNotNullParameter(newPagePO, "newPagePO");
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges) {
        NodePO nodePO;
        List<NodePO> list;
        boolean z16;
        ArgusNode<?> rootNode;
        Intrinsics.checkNotNullParameter(historyPageChanges, "historyPageChanges");
        int i3 = 0;
        RFWLog.e("ArgusPreloadManager", RFWLog.USR, "onPredictResult historyPageChanges size:" + historyPageChanges.size());
        if (currentPageInfo != null) {
            currentPageInfo.printAll("ArgusPreloadManager");
        }
        if (historyPageChanges.isEmpty()) {
            return;
        }
        if (currentPageInfo != null && (rootNode = currentPageInfo.getRootNode()) != null) {
            nodePO = rootNode.getNodeStoreObject(false, true);
        } else {
            nodePO = null;
        }
        int i16 = 0;
        for (Object obj : historyPageChanges) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            HistoryPageChange historyPageChange = (HistoryPageChange) obj;
            historyPageChange.toPage.printAll("ArgusPreloadManager_toPage_" + i17 + '/' + historyPageChanges.size());
            int i18 = WhenMappings.$EnumSwitchMapping$0[preloadNodeType.ordinal()];
            if (i18 != 1) {
                if (i18 == 2) {
                    list = historyPageChange.firstShowBlocks;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                list = historyPageChange.addBlocks;
            }
            if (list != null) {
                int i19 = i3;
                for (Object obj2 : list) {
                    int i26 = i19 + 1;
                    if (i19 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    NodePO preloadNode = (NodePO) obj2;
                    if (Argus.INSTANCE.isDebug()) {
                        PageInfoPO.INSTANCE.printTree("ArgusPreloadManager_showBlock_" + i26 + '/' + list.size(), preloadNode, "");
                    }
                    ArgusPreloadManager argusPreloadManager = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(preloadNode, "preloadNode");
                    if (historyPageChange.isSameRootWithGroup == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    argusPreloadManager.handleShowBlock(currentPageInfo, nodePO, preloadNode, z16);
                    i19 = i26;
                }
            }
            i16 = i17;
            i3 = 0;
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        Map map;
        map = MapsKt__MapsKt.toMap(nodePreloadStatistics);
        RFWReporter.report("argus_preload_report_event", map);
        nodePreloadStatistics.clear();
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public /* synthetic */ void onProcessForeground() {
        com.tencent.richframework.lifecycle.a.b(this);
    }
}
