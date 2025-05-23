package androidx.recyclerview.widget;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Argus;
import androidx.recyclerview.widget.ArgusRecycleViewPreloader;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RFWPreloadExecutor;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.db.HistoryInflateRecord;
import com.tencent.richframework.argus.page.db.ListHistoryInflateRecord;
import com.tencent.richframework.argus.page.db.ListLayoutInflateRecord;
import com.tencent.richframework.argus.page.db.ListLayoutInflateRepository;
import com.tencent.richframework.argus.page.db.PageInflateRecord;
import com.tencent.richframework.argus.page.db.PageInflateRepository;
import com.tencent.richframework.handler.HandlerExtensionKt;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import com.tencent.richframework.preload.activity.ArgusPreloadManagerKt;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0003J\u0016\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010*\u001a\u00020\u001e2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\u0084\u0001\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020=0<2\u001e\u0010>\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\r0<0<H\u0002J\u000e\u0010?\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Landroidx/recyclerview/widget/ArgusRecycleViewPreloader;", "Landroidx/recyclerview/widget/IRecyclerViewMonitor;", "Lcom/tencent/biz/richframework/layoutinflater/ArgusInflateCollector$InflateCollectCallback;", "Lcom/tencent/richframework/lifecycle/IProcessStateChangeCallback;", "()V", "DEBUG", "", "getDEBUG", "()Z", "TAG", "", "inflateInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "onScrollListener", "androidx/recyclerview/widget/ArgusRecycleViewPreloader$onScrollListener$1", "Landroidx/recyclerview/widget/ArgusRecycleViewPreloader$onScrollListener$1;", "preloadTask", "Landroidx/recyclerview/widget/ArgusRecycleViewPreloader$PreloadCheckTask;", "processors", "", "Landroidx/recyclerview/widget/AbsPreloadProcessor;", "getProcessors", "()Ljava/util/List;", "setProcessors", "(Ljava/util/List;)V", "updateQuickInflateRecordTask", "Ljava/lang/Runnable;", "addPreloadAbility", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addRecyclerView", "findResId", "resName", "generateFromInflateRecord", "it", "Lcom/tencent/richframework/argus/node/NodePO;", "generateFromQuickListInflateRecord", "handlePreloadAfterScrolled", "processor", "onInflateCollect", "node", "Lcom/tencent/richframework/argus/node/ArgusNode;", "pageInflateRecord", "Lcom/tencent/richframework/argus/page/db/PageInflateRecord;", "onProcessBackground", "processInflateRecord", "firstPatchId", "inflatePatchId", "inflateResName", "itemViewResName", "itemViewType", "rootClassName", "itemLayoutManager", "inflateCount", "recordType", "Landroidx/recyclerview/widget/InflateRecordType;", "viewTypeToPreloadRequest", "", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "viewTypeSubLayoutResNameInfo", "removePreloadAbility", "removeRecyclerView", "PreloadCheckTask", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ArgusRecycleViewPreloader implements IRecyclerViewMonitor, ArgusInflateCollector.InflateCollectCallback, IProcessStateChangeCallback {

    @NotNull
    public static final String TAG = "ArgusRecycleViewPreloader";
    private static ConcurrentHashMap<Integer, RecyclerViewInflateHistoryInfo> inflateInfo;
    private static final ArgusRecycleViewPreloader$onScrollListener$1 onScrollListener;
    private static PreloadCheckTask preloadTask;

    @NotNull
    private static List<? extends AbsPreloadProcessor> processors;
    private static Runnable updateQuickInflateRecordTask;

    @NotNull
    public static final ArgusRecycleViewPreloader INSTANCE = new ArgusRecycleViewPreloader();
    private static final boolean DEBUG = RFWApplication.isDebug();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00050\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Landroidx/recyclerview/widget/ArgusRecycleViewPreloader$PreloadCheckTask;", "Ljava/lang/Runnable;", "processor", "Landroidx/recyclerview/widget/AbsPreloadProcessor;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/AbsPreloadProcessor;Landroidx/recyclerview/widget/RecyclerView;)V", "getProcessor", "()Landroidx/recyclerview/widget/AbsPreloadProcessor;", "wrfRecyclerView", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWrfRecyclerView", "()Ljava/lang/ref/WeakReference;", TencentLocation.RUN_MODE, "", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class PreloadCheckTask implements Runnable {

        @NotNull
        private final AbsPreloadProcessor processor;

        @NotNull
        private final WeakReference<RecyclerView> wrfRecyclerView;

        public PreloadCheckTask(@NotNull AbsPreloadProcessor processor, @NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.processor = processor;
            this.wrfRecyclerView = new WeakReference<>(recyclerView);
        }

        @NotNull
        public final AbsPreloadProcessor getProcessor() {
            return this.processor;
        }

        @NotNull
        public final WeakReference<RecyclerView> getWrfRecyclerView() {
            return this.wrfRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = this.wrfRecyclerView.get();
            if (recyclerView != null) {
                Intrinsics.checkNotNullExpressionValue(recyclerView, "wrfRecyclerView.get() ?: return");
                ArgusRecycleViewPreloader.INSTANCE.handlePreloadAfterScrolled(this.processor, recyclerView);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.recyclerview.widget.ArgusRecycleViewPreloader$onScrollListener$1] */
    static {
        List<? extends AbsPreloadProcessor> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AbsPreloadProcessor[]{new LinearLayoutPreloadProcessor(), new GridLayoutPreloadProcessor(), new StaggerGridLayoutPreloadProcessor()});
        processors = listOf;
        inflateInfo = new ConcurrentHashMap<>();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader.1
            @Override // java.lang.Runnable
            public final void run() {
                ArgusInflateCollector argusInflateCollector = ArgusInflateCollector.INSTANCE;
                ArgusRecycleViewPreloader argusRecycleViewPreloader = ArgusRecycleViewPreloader.INSTANCE;
                argusInflateCollector.registerComponentCallback(argusRecycleViewPreloader);
                RFWLifecycleHelper.getInstance().registerProcessChangeListener(argusRecycleViewPreloader);
            }
        });
        onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull final RecyclerView recyclerView, int newState) {
                RecyclerView.Adapter adapter;
                Object obj;
                ArgusRecycleViewPreloader.PreloadCheckTask preloadCheckTask;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0 && (adapter = recyclerView.getAdapter()) != null && adapter.hasStableIds()) {
                    Iterator<T> it = ArgusRecycleViewPreloader.INSTANCE.getProcessors().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((AbsPreloadProcessor) obj).isTargetProcess(recyclerView)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    final AbsPreloadProcessor absPreloadProcessor = (AbsPreloadProcessor) obj;
                    if (absPreloadProcessor != null) {
                        int postTaskMode = ItemPreloadConfigManager.INSTANCE.getPreloadConfig().getPostTaskMode();
                        if (postTaskMode != 1) {
                            if (postTaskMode != 2) {
                                ArgusRecycleViewPreloader.INSTANCE.handlePreloadAfterScrolled(absPreloadProcessor, recyclerView);
                                return;
                            }
                            ArgusRecycleViewPreloader argusRecycleViewPreloader = ArgusRecycleViewPreloader.INSTANCE;
                            preloadCheckTask = ArgusRecycleViewPreloader.preloadTask;
                            if (preloadCheckTask != null) {
                                RFWPreloadExecutor.INSTANCE.remove(preloadCheckTask);
                            }
                            ArgusRecycleViewPreloader.PreloadCheckTask preloadCheckTask2 = new ArgusRecycleViewPreloader.PreloadCheckTask(absPreloadProcessor, recyclerView);
                            RFWPreloadExecutor.INSTANCE.execute(preloadCheckTask2);
                            Unit unit = Unit.INSTANCE;
                            ArgusRecycleViewPreloader.preloadTask = preloadCheckTask2;
                            return;
                        }
                        recyclerView.post(new Runnable() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader$onScrollListener$1$onScrollStateChanged$$inlined$let$lambda$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ArgusRecycleViewPreloader.INSTANCE.handlePreloadAfterScrolled(AbsPreloadProcessor.this, recyclerView);
                            }
                        });
                    }
                }
            }
        };
    }

    ArgusRecycleViewPreloader() {
    }

    private final int findResId(String resName) {
        try {
            Application application = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
            Resources resources = application.getResources();
            Application application2 = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
            return resources.getIdentifier(resName, "id", application2.getPackageName());
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final RecyclerViewInflateHistoryInfo generateFromInflateRecord(NodePO it) {
        String str;
        String str2;
        String str3;
        String str4;
        long nanoTime = System.nanoTime();
        List<HistoryInflateRecord> pageCountPastSevenDaysWithListPage = PageInflateRepository.INSTANCE.getPageCountPastSevenDaysWithListPage(it);
        if (pageCountPastSevenDaysWithListPage.isEmpty()) {
            RFWLog.w(TAG, RFWLog.USR, "can't find inflateRecords for this recyclerview");
            return null;
        }
        RFWLog.w(TAG, RFWLog.USR, "find inflateRecords size " + pageCountPastSevenDaysWithListPage.size() + " for " + it);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        int i3 = pageCountPastSevenDaysWithListPage.get(0).patchId;
        for (HistoryInflateRecord historyInflateRecord : pageCountPastSevenDaysWithListPage) {
            int i16 = historyInflateRecord.patchId;
            String str5 = historyInflateRecord.resName;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            String str6 = historyInflateRecord.itemViewResName;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            int i17 = historyInflateRecord.itemViewType;
            String str7 = historyInflateRecord.rootClassName;
            if (str7 == null) {
                str3 = "";
            } else {
                str3 = str7;
            }
            String str8 = historyInflateRecord.itemLayoutManager;
            if (str8 == null) {
                str4 = "";
            } else {
                str4 = str8;
            }
            processInflateRecord(i3, i16, str, str2, i17, str3, str4, historyInflateRecord.count, InflateRecordType.DATABASE, concurrentHashMap, concurrentHashMap2);
            i3 = i3;
        }
        RFWLog.i(TAG, RFWLog.USR, "analyze cost:" + (System.nanoTime() - nanoTime));
        if (!concurrentHashMap.isEmpty()) {
            for (Map.Entry<Integer, PreloadRequest> entry : concurrentHashMap.entrySet()) {
                RFWLog.i(TAG, RFWLog.DEV, "findViewType:" + entry.getKey().intValue() + " layoutInfo:" + entry.getValue());
            }
            for (Map.Entry<Integer, Map<PreloadRequest, Integer>> entry2 : concurrentHashMap2.entrySet()) {
                for (Map.Entry<PreloadRequest, Integer> entry3 : entry2.getValue().entrySet()) {
                    RFWLog.i(TAG, RFWLog.DEV, "findViewType:" + entry2.getKey().intValue() + " subLayoutInfo:" + entry3.getKey() + TokenParser.SP + "count:" + entry3.getValue().intValue());
                }
            }
            return new RecyclerViewInflateHistoryInfo(it, concurrentHashMap, concurrentHashMap2);
        }
        RFWLog.w(TAG, RFWLog.DEV, "can't find viewType for this recyclerview");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final RecyclerViewInflateHistoryInfo generateFromQuickListInflateRecord(NodePO it) {
        Object putIfAbsent;
        if (!ItemPreloadConfigManager.INSTANCE.getPreloadConfig().getUseQuickRecord()) {
            return null;
        }
        long nanoTime = System.nanoTime();
        List<ListHistoryInflateRecord> listPageHistoryInflateRecord = ListLayoutInflateRepository.INSTANCE.getListPageHistoryInflateRecord(it);
        if (listPageHistoryInflateRecord.isEmpty()) {
            RFWLog.w(TAG, RFWLog.USR, "can't find inflateRecords for this recyclerview");
            return null;
        }
        RFWLog.w(TAG, RFWLog.USR, "find inflateRecords size " + listPageHistoryInflateRecord.size() + " for " + it);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (ListHistoryInflateRecord listHistoryInflateRecord : listPageHistoryInflateRecord) {
            int i3 = listHistoryInflateRecord.layout_type;
            if (i3 == 0) {
                Integer valueOf = Integer.valueOf(listHistoryInflateRecord.item_view_type);
                int i16 = listHistoryInflateRecord.res_id;
                String str = listHistoryInflateRecord.root_class_name;
                Intrinsics.checkNotNullExpressionValue(str, "it.root_class_name");
                String str2 = listHistoryInflateRecord.item_layout_manager;
                Intrinsics.checkNotNullExpressionValue(str2, "it.item_layout_manager");
                PreloadRequest preloadRequest = new PreloadRequest(i16, str, str2);
                String str3 = listHistoryInflateRecord.res_name;
                Intrinsics.checkNotNullExpressionValue(str3, "it.res_name");
                preloadRequest.setResName(str3);
                Unit unit = Unit.INSTANCE;
                concurrentHashMap.put(valueOf, preloadRequest);
            } else if (i3 == 1) {
                Integer valueOf2 = Integer.valueOf(listHistoryInflateRecord.item_view_type);
                Object obj = concurrentHashMap2.get(valueOf2);
                if (obj == null && (putIfAbsent = concurrentHashMap2.putIfAbsent(valueOf2, (obj = new ConcurrentHashMap()))) != null) {
                    obj = putIfAbsent;
                }
                Map subLayoutInfo = (Map) obj;
                int i17 = listHistoryInflateRecord.res_id;
                String str4 = listHistoryInflateRecord.root_class_name;
                if (str4 == null) {
                    str4 = "";
                }
                PreloadRequest preloadRequest2 = new PreloadRequest(i17, str4, null, 4, null);
                String str5 = listHistoryInflateRecord.res_name;
                Intrinsics.checkNotNullExpressionValue(str5, "it.res_name");
                preloadRequest2.setResName(str5);
                Intrinsics.checkNotNullExpressionValue(subLayoutInfo, "subLayoutInfo");
                subLayoutInfo.put(preloadRequest2, Integer.valueOf(listHistoryInflateRecord.count));
            }
        }
        RFWLog.i(TAG, RFWLog.USR, "analyze cost:" + (System.nanoTime() - nanoTime));
        return new RecyclerViewInflateHistoryInfo(it, concurrentHashMap, concurrentHashMap2);
    }

    private final void processInflateRecord(int firstPatchId, int inflatePatchId, String inflateResName, String itemViewResName, int itemViewType, String rootClassName, String itemLayoutManager, int inflateCount, InflateRecordType recordType, Map<Integer, PreloadRequest> viewTypeToPreloadRequest, Map<Integer, Map<PreloadRequest, Integer>> viewTypeSubLayoutResNameInfo) {
        String str = rootClassName;
        if (TextUtils.isEmpty(inflateResName) || TextUtils.isEmpty(itemViewResName)) {
            return;
        }
        int i3 = 0;
        if (TextUtils.equals(inflateResName, itemViewResName)) {
            PreloadRequest preloadRequest = viewTypeToPreloadRequest.get(Integer.valueOf(itemViewType));
            if (preloadRequest == null) {
                Integer valueOf = Integer.valueOf(itemViewType);
                PreloadRequest preloadRequest2 = new PreloadRequest(findResId(inflateResName), str, itemLayoutManager);
                preloadRequest2.setResName(inflateResName);
                Unit unit = Unit.INSTANCE;
                viewTypeToPreloadRequest.put(valueOf, preloadRequest2);
                return;
            }
            if (!TextUtils.isEmpty(inflateResName) && (!Intrinsics.areEqual(preloadRequest.getResName(), inflateResName)) && inflatePatchId == firstPatchId) {
                RFWLog.e(TAG, RFWLog.USR, "find same viewType " + itemViewType + TokenParser.SP + " but different resName1: " + itemViewResName + " resName2:" + preloadRequest.getResName());
                return;
            }
            return;
        }
        Integer valueOf2 = Integer.valueOf(itemViewType);
        Map<PreloadRequest, Integer> map = viewTypeSubLayoutResNameInfo.get(valueOf2);
        if (map == null) {
            map = new ConcurrentHashMap<>();
            viewTypeSubLayoutResNameInfo.put(valueOf2, map);
        }
        Map<PreloadRequest, Integer> map2 = map;
        int findResId = findResId(inflateResName);
        if (str == null) {
            str = "";
        }
        PreloadRequest preloadRequest3 = new PreloadRequest(findResId, str, null, 4, null);
        preloadRequest3.setResName(inflateResName);
        Integer num = map2.get(preloadRequest3);
        if (num == null) {
            num = Integer.valueOf(inflateCount);
            map2.put(preloadRequest3, num);
        }
        int intValue = num.intValue();
        if (recordType == InflateRecordType.DATABASE) {
            i3 = RangesKt___RangesKt.coerceAtLeast(intValue, inflateCount);
        } else if (recordType == InflateRecordType.MEMORY) {
            i3 = Math.min(intValue + 1, 10);
        }
        if (i3 >= intValue) {
            map2.put(preloadRequest3, Integer.valueOf(i3));
        }
    }

    public final void addPreloadAbility(@NotNull final RecyclerView recyclerView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.getHeight() == 0 && ItemPreloadConfigManager.INSTANCE.getPreloadConfig().getMinHeightPercent() > 0.01f) {
            z16 = true;
        } else {
            z16 = false;
        }
        HandlerExtensionKt.postIf(recyclerView, z16, new Runnable() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader$addPreloadAbility$1
            @Override // java.lang.Runnable
            public final void run() {
                ArgusRecycleViewPreloader$onScrollListener$1 argusRecycleViewPreloader$onScrollListener$1;
                ArgusRecycleViewPreloader$onScrollListener$1 argusRecycleViewPreloader$onScrollListener$12;
                float height = RecyclerView.this.getHeight();
                float screenHeight = DisplayUtil.getScreenHeight();
                ItemPreloadConfigManager itemPreloadConfigManager = ItemPreloadConfigManager.INSTANCE;
                if (height < screenHeight * itemPreloadConfigManager.getPreloadConfig().getMinHeightPercent()) {
                    if (RFWLog.isColorLevel()) {
                        RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.CLR, "not reach minHeight " + (DisplayUtil.getScreenHeight() * itemPreloadConfigManager.getPreloadConfig().getMinHeightPercent()) + ", height is " + RecyclerView.this.getHeight());
                        return;
                    }
                    return;
                }
                if (!(LayoutInflater.from(RecyclerView.this.getContext()) instanceof RFWDelegateLayoutInflater)) {
                    if (RFWLog.isColorLevel()) {
                        RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.CLR, "is not delegate layoutInflater\uff0cnot use recyclerview preload");
                        return;
                    }
                    return;
                }
                final int hashCode = RecyclerView.this.hashCode();
                ArgusNode<?> node = Argus.INSTANCE.getNode(RecyclerView.this, null, itemPreloadConfigManager.getPreloadConfig().getCreateNodeIfEmpty());
                if (node != null) {
                    if (ArgusPreloadManagerKt.findAutoPreloadNode(ArgusPreloadManager.INSTANCE.getPreloadMode(), node) == null) {
                        if (RFWLog.isColorLevel()) {
                            RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.CLR, "not support node auto preload");
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView2 = RecyclerView.this;
                    ArgusRecycleViewPreloader argusRecycleViewPreloader = ArgusRecycleViewPreloader.INSTANCE;
                    argusRecycleViewPreloader$onScrollListener$1 = ArgusRecycleViewPreloader.onScrollListener;
                    recyclerView2.removeOnScrollListener(argusRecycleViewPreloader$onScrollListener$1);
                    RecyclerView recyclerView3 = RecyclerView.this;
                    argusRecycleViewPreloader$onScrollListener$12 = ArgusRecycleViewPreloader.onScrollListener;
                    recyclerView3.addOnScrollListener(argusRecycleViewPreloader$onScrollListener$12);
                    final NodePO nodeTreeTag = node.getNodeTreeTag();
                    if (nodeTreeTag != null) {
                        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader$addPreloadAbility$1$$special$$inlined$let$lambda$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewInflateHistoryInfo generateFromQuickListInflateRecord;
                                ConcurrentHashMap concurrentHashMap;
                                ArgusRecycleViewPreloader argusRecycleViewPreloader2 = ArgusRecycleViewPreloader.INSTANCE;
                                generateFromQuickListInflateRecord = argusRecycleViewPreloader2.generateFromQuickListInflateRecord(NodePO.this);
                                if (generateFromQuickListInflateRecord == null) {
                                    generateFromQuickListInflateRecord = argusRecycleViewPreloader2.generateFromInflateRecord(NodePO.this);
                                }
                                if (generateFromQuickListInflateRecord != null) {
                                    concurrentHashMap = ArgusRecycleViewPreloader.inflateInfo;
                                    concurrentHashMap.put(Integer.valueOf(hashCode), generateFromQuickListInflateRecord);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void addRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        addPreloadAbility(recyclerView);
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    @NotNull
    public final List<AbsPreloadProcessor> getProcessors() {
        return processors;
    }

    public final void handlePreloadAfterScrolled(@NotNull AbsPreloadProcessor processor, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        long nanoTime = System.nanoTime();
        try {
            processor.preloadAfterScrolled(recyclerView, ItemPreloadConfigManager.INSTANCE.getPreloadConfig(), inflateInfo.get(Integer.valueOf(recyclerView.hashCode())));
            RFWLog.i(TAG, RFWLog.USR, "handlePreloadAfterScrolled:" + (System.nanoTime() - nanoTime));
        } catch (Exception e16) {
            RFWLog.fatal(TAG, RFWLog.USR, e16);
        }
    }

    @Override // com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector.InflateCollectCallback
    public void onInflateCollect(@NotNull ArgusNode<?> node, @NotNull PageInflateRecord pageInflateRecord) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(pageInflateRecord, "pageInflateRecord");
        if (!(node.getContainer() instanceof RecyclerView) && ArgusPreloadManagerKt.findAutoPreloadNode(ArgusPreloadManager.INSTANCE.getPreloadMode(), node) == null) {
            return;
        }
        ConcurrentHashMap<Integer, RecyclerViewInflateHistoryInfo> concurrentHashMap = inflateInfo;
        Object container = node.getContainer();
        int i16 = 0;
        if (container != null) {
            i3 = container.hashCode();
        } else {
            i3 = 0;
        }
        RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo = concurrentHashMap.get(Integer.valueOf(i3));
        if (recyclerViewInflateHistoryInfo == null) {
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
            NodePO nodeTreeTag = node.getNodeTreeTag();
            Intrinsics.checkNotNull(nodeTreeTag);
            RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo2 = new RecyclerViewInflateHistoryInfo(nodeTreeTag, concurrentHashMap2, concurrentHashMap3);
            ConcurrentHashMap<Integer, RecyclerViewInflateHistoryInfo> concurrentHashMap4 = inflateInfo;
            Object container2 = node.getContainer();
            if (container2 != null) {
                i16 = container2.hashCode();
            }
            concurrentHashMap4.put(Integer.valueOf(i16), recyclerViewInflateHistoryInfo2);
            recyclerViewInflateHistoryInfo = recyclerViewInflateHistoryInfo2;
        }
        if (pageInflateRecord.isFromCache == 0) {
            int i17 = pageInflateRecord.patchId;
            String str5 = pageInflateRecord.resName;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            String str6 = pageInflateRecord.itemViewResName;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            int i18 = pageInflateRecord.itemViewType;
            String str7 = pageInflateRecord.rootClassName;
            if (str7 == null) {
                str3 = "";
            } else {
                str3 = str7;
            }
            String str8 = pageInflateRecord.recyclerViewLayoutManager;
            if (str8 == null) {
                str4 = "";
            } else {
                str4 = str8;
            }
            processInflateRecord(i17, i17, str, str2, i18, str3, str4, 1, InflateRecordType.MEMORY, recyclerViewInflateHistoryInfo.getViewTypeToResLayoutId(), recyclerViewInflateHistoryInfo.getViewTypeSubLayoutInfo());
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        if (!ItemPreloadConfigManager.INSTANCE.getPreloadConfig().getUseQuickRecord()) {
            RFWLog.i(TAG, RFWLog.USR, "not use quick record");
            return;
        }
        if (updateQuickInflateRecordTask != null) {
            RFWThreadManager.getInstance().remove(updateQuickInflateRecordTask);
        }
        ArgusRecycleViewPreloader$onProcessBackground$1 argusRecycleViewPreloader$onProcessBackground$1 = new Runnable() { // from class: androidx.recyclerview.widget.ArgusRecycleViewPreloader$onProcessBackground$1
            @Override // java.lang.Runnable
            public final void run() {
                ConcurrentHashMap concurrentHashMap;
                LinkedList linkedList = new LinkedList();
                long nanoTime = System.nanoTime();
                ArgusRecycleViewPreloader argusRecycleViewPreloader = ArgusRecycleViewPreloader.INSTANCE;
                concurrentHashMap = ArgusRecycleViewPreloader.inflateInfo;
                Collection<RecyclerViewInflateHistoryInfo> values = concurrentHashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "inflateInfo.values");
                for (RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo : values) {
                    Iterator<T> it = recyclerViewInflateHistoryInfo.getViewTypeToResLayoutId().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        ListLayoutInflateRecord listLayoutInflateRecord = new ListLayoutInflateRecord();
                        listLayoutInflateRecord.itemViewType = ((Number) entry.getKey()).intValue();
                        listLayoutInflateRecord.fromListNode = recyclerViewInflateHistoryInfo.getNodeTreeTag();
                        listLayoutInflateRecord.resId = ((PreloadRequest) entry.getValue()).getResId();
                        listLayoutInflateRecord.resName = ((PreloadRequest) entry.getValue()).getResName();
                        listLayoutInflateRecord.isMerge = ((PreloadRequest) entry.getValue()).getIsMergeRes() ? 1 : 0;
                        listLayoutInflateRecord.rootClassName = ((PreloadRequest) entry.getValue()).getParentViewClassName();
                        listLayoutInflateRecord.itemLayoutManager = ((PreloadRequest) entry.getValue()).getItemLayoutManager();
                        listLayoutInflateRecord.layoutType = 0;
                        listLayoutInflateRecord.count = 1;
                        Unit unit = Unit.INSTANCE;
                        linkedList.add(listLayoutInflateRecord);
                    }
                    Iterator<T> it5 = recyclerViewInflateHistoryInfo.getViewTypeSubLayoutInfo().entrySet().iterator();
                    while (it5.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it5.next();
                        int intValue = ((Number) entry2.getKey()).intValue();
                        for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                            ListLayoutInflateRecord listLayoutInflateRecord2 = new ListLayoutInflateRecord();
                            listLayoutInflateRecord2.itemViewType = intValue;
                            listLayoutInflateRecord2.fromListNode = recyclerViewInflateHistoryInfo.getNodeTreeTag();
                            listLayoutInflateRecord2.resId = ((PreloadRequest) entry3.getKey()).getResId();
                            listLayoutInflateRecord2.resName = ((PreloadRequest) entry3.getKey()).getResName();
                            listLayoutInflateRecord2.isMerge = ((PreloadRequest) entry3.getKey()).getIsMergeRes() ? 1 : 0;
                            listLayoutInflateRecord2.rootClassName = ((PreloadRequest) entry3.getKey()).getParentViewClassName();
                            listLayoutInflateRecord2.itemLayoutManager = ((PreloadRequest) entry3.getKey()).getItemLayoutManager();
                            listLayoutInflateRecord2.layoutType = 1;
                            listLayoutInflateRecord2.count = ((Number) entry3.getValue()).intValue();
                            Unit unit2 = Unit.INSTANCE;
                            linkedList.add(listLayoutInflateRecord2);
                        }
                    }
                }
                long nanoTime2 = System.nanoTime() - nanoTime;
                ListLayoutInflateRepository.INSTANCE.insertAll(linkedList);
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "insert cost time:" + nanoTime2);
            }
        };
        RFWThreadManager.getInstance().execOnFileThread(argusRecycleViewPreloader$onProcessBackground$1);
        updateQuickInflateRecordTask = argusRecycleViewPreloader$onProcessBackground$1;
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public /* bridge */ /* synthetic */ void onProcessForeground() {
        com.tencent.richframework.lifecycle.a.b(this);
    }

    public final void removePreloadAbility(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.removeOnScrollListener(onScrollListener);
        inflateInfo.remove(Integer.valueOf(recyclerView.hashCode()));
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void removeRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        removePreloadAbility(recyclerView);
    }

    public final void setProcessors(@NotNull List<? extends AbsPreloadProcessor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        processors = list;
    }
}
