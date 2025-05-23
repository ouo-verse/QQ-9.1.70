package com.tencent.biz.richframework.layoutinflater;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Argus;
import androidx.fragment.app.ArgusUtil;
import androidx.recyclerview.widget.InflateHelper;
import androidx.recyclerview.widget.ItemViewData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.db.HistoryInflateRecord;
import com.tencent.richframework.argus.page.db.PageInflateRecord;
import com.tencent.richframework.argus.page.db.PageInflateRepository;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J,\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J@\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/ArgusInflateCollector;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "node", "", "resId", "", "rootName", "", "isFromCache", "", "addInflateRecordToView", "getPatchId", "Landroid/view/View;", "inflateView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "isAttachRoot", "isMerge", "", "costTime", "handleInflateEvent", "Lcom/tencent/biz/richframework/layoutinflater/ArgusInflateCollector$InflateCollectCallback;", "callback", "registerComponentCallback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "pid", "I", "launchActivityCreatedTime", "J", "inflateCount", "", "inflateCallbacks", "Ljava/util/List;", "enableRecordInNode", "Z", "<init>", "()V", "InflateCollectCallback", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ArgusInflateCollector implements Application.ActivityLifecycleCallbacks {

    @NotNull
    public static final ArgusInflateCollector INSTANCE;
    private static final boolean enableRecordInNode;
    private static final List<InflateCollectCallback> inflateCallbacks;
    private static int inflateCount;
    private static long launchActivityCreatedTime;
    private static final int pid;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/ArgusInflateCollector$InflateCollectCallback;", "", "onInflateCollect", "", "node", "Lcom/tencent/richframework/argus/node/ArgusNode;", "pageInflateRecord", "Lcom/tencent/richframework/argus/page/db/PageInflateRecord;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface InflateCollectCallback {
        @WorkerThread
        void onInflateCollect(@NotNull ArgusNode<?> node, @NotNull PageInflateRecord pageInflateRecord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
    
        if (com.tencent.biz.richframework.delegate.impl.RFWConfig.getConfigValue("ARGUS_RECORD_IN_NODE", false) != false) goto L6;
     */
    static {
        boolean z16;
        ArgusInflateCollector argusInflateCollector = new ArgusInflateCollector();
        INSTANCE = argusInflateCollector;
        pid = Process.myPid();
        inflateCallbacks = new ArrayList();
        if (RFWApplication.isPublicVersion()) {
            z16 = false;
        }
        z16 = true;
        enableRecordInNode = z16;
        RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(argusInflateCollector);
    }

    ArgusInflateCollector() {
    }

    public static final /* synthetic */ int access$getInflateCount$p(ArgusInflateCollector argusInflateCollector) {
        return inflateCount;
    }

    private final void addInflateRecordToView(ArgusNode<?> node, int resId, String rootName, boolean isFromCache) {
        View nodeView = node.getNodeView();
        if (nodeView != null) {
            HistoryInflateRecord historyInflateRecord = new HistoryInflateRecord();
            historyInflateRecord.patchId = INSTANCE.getPatchId(node);
            historyInflateRecord.resId = resId;
            historyInflateRecord.rootClassName = rootName;
            historyInflateRecord.isFromCache = isFromCache ? 1 : 0;
            Unit unit = Unit.INSTANCE;
            ViewInflateRecordExtKt.addInflateRecord(nodeView, historyInflateRecord);
        }
    }

    private final int getPatchId(ArgusNode<?> node) {
        return node.hashCode() + pid;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:6:0x0021, B:11:0x0034, B:12:0x003e, B:14:0x0042, B:15:0x0045, B:18:0x0057, B:20:0x005f, B:22:0x0067, B:23:0x006f, B:26:0x0076, B:29:0x009a, B:31:0x00a6, B:33:0x00b5, B:34:0x00c5, B:36:0x00cb, B:37:0x0107, B:40:0x0114, B:42:0x011e, B:44:0x0136, B:45:0x013a, B:47:0x0142, B:48:0x0146, B:49:0x014b, B:58:0x00c3, B:62:0x0167), top: B:5:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:6:0x0021, B:11:0x0034, B:12:0x003e, B:14:0x0042, B:15:0x0045, B:18:0x0057, B:20:0x005f, B:22:0x0067, B:23:0x006f, B:26:0x0076, B:29:0x009a, B:31:0x00a6, B:33:0x00b5, B:34:0x00c5, B:36:0x00cb, B:37:0x0107, B:40:0x0114, B:42:0x011e, B:44:0x0136, B:45:0x013a, B:47:0x0142, B:48:0x0146, B:49:0x014b, B:58:0x00c3, B:62:0x0167), top: B:5:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleInflateEvent(int resId, @NotNull View inflateView, @Nullable View rootView, boolean isAttachRoot, boolean isMerge, long costTime, boolean isFromCache) {
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        NodePO nodePO;
        int i3;
        final ArgusNode<?> findViewBlockNode$default;
        String str;
        int i16;
        int i17;
        int i18;
        ItemViewData adjustItemTypeAndLayoutId;
        Intrinsics.checkNotNullParameter(inflateView, "inflateView");
        inflateCount++;
        Argus argus = Argus.INSTANCE;
        if (!argus.isEnableWriteDb()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            nodePO = null;
            i3 = 0;
            findViewBlockNode$default = Argus.findViewBlockNode$default(argus, inflateView, false, 2, null);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (findViewBlockNode$default != null) {
            String str2 = "";
            if (rootView == null) {
                str = "";
            } else {
                str = rootView.getClass().getName();
            }
            if (enableRecordInNode) {
                addInflateRecordToView(findViewBlockNode$default, resId, str, isFromCache);
            }
            NodePO nodeTreeTag = findViewBlockNode$default.getNodeTreeTag();
            PageInflateRecord pageInflateRecord = new PageInflateRecord();
            pageInflateRecord.fromPage = nodeTreeTag;
            pageInflateRecord.resId = resId;
            if (isMerge) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            pageInflateRecord.isMerge = i16;
            pageInflateRecord.rootClassName = str;
            if (rootView instanceof RecyclerView) {
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) rootView).getLayoutManager();
                if (layoutManager != null) {
                    str2 = layoutManager.getClass().getName();
                }
                pageInflateRecord.recyclerViewLayoutManager = str2;
            }
            if (isAttachRoot) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            pageInflateRecord.attachRoot = i17;
            pageInflateRecord.time = System.currentTimeMillis();
            long currentTimeMillis = System.currentTimeMillis() - launchActivityCreatedTime;
            LayoutPreloadConfigManager layoutPreloadConfigManager = LayoutPreloadConfigManager.INSTANCE;
            if (currentTimeMillis < layoutPreloadConfigManager.getPreloadConfig().getLaunchGapMillTime() && inflateCount < layoutPreloadConfigManager.getPreloadConfig().getLaunchPreloadCount()) {
                ArgusUtil argusUtil = ArgusUtil.INSTANCE;
                Context context = inflateView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "inflateView.context");
                if (argusUtil.isLaunchMainActivity(context)) {
                    pageInflateRecord.launchStageId = inflateView.getContext().hashCode() + pid;
                    if (RFWApplication.isDebug()) {
                        int i19 = RFWLog.USR;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("gapTime:");
                        sb5.append(currentTimeMillis);
                        sb5.append(" fromMain:");
                        ArgusUtil argusUtil2 = ArgusUtil.INSTANCE;
                        Context context2 = inflateView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "inflateView.context");
                        sb5.append(argusUtil2.isLaunchMainActivity(context2));
                        sb5.append(" inflateCount:");
                        sb5.append(access$getInflateCount$p(this));
                        RFWLog.i("Argus_Collect", i19, sb5.toString());
                    }
                    pageInflateRecord.patchId = getPatchId(findViewBlockNode$default);
                    pageInflateRecord.costTime = costTime;
                    if (!isFromCache) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                    pageInflateRecord.isFromCache = i18;
                    adjustItemTypeAndLayoutId = InflateHelper.INSTANCE.getAdjustItemTypeAndLayoutId(inflateView, resId);
                    if (adjustItemTypeAndLayoutId != null) {
                        pageInflateRecord.itemViewType = adjustItemTypeAndLayoutId.getItemType();
                        pageInflateRecord.itemViewLayoutId = adjustItemTypeAndLayoutId.getItemLayoutId();
                        pageInflateRecord.itemViewHashcode = adjustItemTypeAndLayoutId.getItemHashCode();
                        ArgusNode<?> listViewPage = adjustItemTypeAndLayoutId.getListViewPage();
                        if (listViewPage != null) {
                            nodePO = listViewPage.getNodeTreeTag();
                        }
                        pageInflateRecord.fromPage = nodePO;
                        ArgusNode<?> listViewPage2 = adjustItemTypeAndLayoutId.getListViewPage();
                        if (listViewPage2 != null) {
                            i3 = listViewPage2.hashCode();
                        }
                        pageInflateRecord.patchId = i3 + pid;
                    }
                    PageInflateRepository pageInflateRepository = PageInflateRepository.INSTANCE;
                    Context context3 = inflateView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "inflateView.context");
                    pageInflateRepository.insert(pageInflateRecord, context3.getClass(), new Function1<PageInflateRecord, Unit>() { // from class: com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector$handleInflateEvent$1$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PageInflateRecord pageInflateRecord2) {
                            invoke2(pageInflateRecord2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull PageInflateRecord record) {
                            List list;
                            Intrinsics.checkNotNullParameter(record, "record");
                            ArgusInflateCollector argusInflateCollector = ArgusInflateCollector.this;
                            list = ArgusInflateCollector.inflateCallbacks;
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((ArgusInflateCollector.InflateCollectCallback) it.next()).onInflateCollect(findViewBlockNode$default, record);
                            }
                        }
                    });
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl == null && RFWApplication.isDebug()) {
                        throw m479exceptionOrNullimpl;
                    }
                    return;
                }
            }
            pageInflateRecord.launchStageId = 0;
            if (RFWApplication.isDebug()) {
            }
            pageInflateRecord.patchId = getPatchId(findViewBlockNode$default);
            pageInflateRecord.costTime = costTime;
            if (!isFromCache) {
            }
            pageInflateRecord.isFromCache = i18;
            adjustItemTypeAndLayoutId = InflateHelper.INSTANCE.getAdjustItemTypeAndLayoutId(inflateView, resId);
            if (adjustItemTypeAndLayoutId != null) {
            }
            PageInflateRepository pageInflateRepository2 = PageInflateRepository.INSTANCE;
            Context context32 = inflateView.getContext();
            Intrinsics.checkNotNullExpressionValue(context32, "inflateView.context");
            pageInflateRepository2.insert(pageInflateRecord, context32.getClass(), new Function1<PageInflateRecord, Unit>() { // from class: com.tencent.biz.richframework.layoutinflater.ArgusInflateCollector$handleInflateEvent$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PageInflateRecord pageInflateRecord2) {
                    invoke2(pageInflateRecord2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PageInflateRecord record) {
                    List list;
                    Intrinsics.checkNotNullParameter(record, "record");
                    ArgusInflateCollector argusInflateCollector = ArgusInflateCollector.this;
                    list = ArgusInflateCollector.inflateCallbacks;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((ArgusInflateCollector.InflateCollectCallback) it.next()).onInflateCollect(findViewBlockNode$default, record);
                    }
                }
            });
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl == null) {
                return;
            } else {
                return;
            }
        }
        RFWLog.w("Argus_Collect", RFWLog.USR, "can't find node resId:" + resId + " costTime:" + costTime);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (ArgusUtil.INSTANCE.isLaunchMainActivity(activity)) {
            launchActivityCreatedTime = System.currentTimeMillis();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (ArgusUtil.INSTANCE.isLaunchMainActivity(activity)) {
            inflateCount = 0;
        }
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

    @UiThread
    public final void registerComponentCallback(@NotNull InflateCollectCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        inflateCallbacks.add(callback);
    }
}
