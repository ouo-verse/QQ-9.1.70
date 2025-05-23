package com.tencent.mobileqq.zplan.emoticon.api.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonPanelHelperBuilder;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelBuilder;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelTabCreateListener;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.zplan.emoticon.panel.util.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b(\u0010)J@\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/impl/ZPlanEmotionPanelBuilderImpl;", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmotionPanelBuilder;", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "app", "Landroid/content/Context;", "context", "", "panelType", VasReportUtils.BUSINESS_TYPE_EMOTION, "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "callback", "Landroid/view/ViewGroup;", "aioRoot", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "Lcom/tencent/mobileqq/emoticon/EmotionInjectionInfo;", "init", "", "buildParams", "buildView", "buildData", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter;", "buildComplete", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "Landroid/content/Context;", "columnNum", "I", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "<set-?>", "adapter", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/c;", "observer", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/c;", "<init>", "()V", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmotionPanelBuilderImpl implements IZPlanEmotionPanelBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ZPlanEmoticonAdapter adapter;
    private ViewGroup aioRoot;
    private IEmoticonMainPanelApp app;
    private EmoticonCallback callback;
    private int columnNum;
    private Context context;
    private int emotionType;
    private c observer;
    private int panelType;
    private SessionInfo sessionInfo;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/impl/ZPlanEmotionPanelBuilderImpl$Companion;", "", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "adapterRef", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroid/content/Context;", "context", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(WeakReference<ZPlanEmoticonAdapter> adapterRef, CoroutineScope scope, Context context) {
            if (scope != null) {
                CorountineFunKt.e(scope, "ZPlanEmotionPanelBuilderImpl_\u76d1\u542c\u8868\u60c5\u66f4\u65b0", null, null, null, new ZPlanEmotionPanelBuilderImpl$Companion$refreshEmotionAdapterData$1(scope, context, adapterRef, null), 14, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelBuilder
    public synchronized BaseEmotionAdapter buildComplete() {
        Context context = this.context;
        if (context == null) {
            return null;
        }
        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
        if (iEmoticonMainPanelApp == null) {
            return null;
        }
        c cVar = this.observer;
        if (cVar == null) {
            return null;
        }
        EmoticonCallback emoticonCallback = this.callback;
        if (emoticonCallback == null) {
            return null;
        }
        ViewGroup viewGroup = this.aioRoot;
        if (viewGroup == null) {
            return null;
        }
        SessionInfo sessionInfo = this.sessionInfo;
        if (sessionInfo == null) {
            return null;
        }
        if (cVar instanceof ZPlanEmoticonPanelLifecycleObserver) {
            return new ZPlanEmoticonAdapter2(iEmoticonMainPanelApp, context, this.columnNum, this.panelType, this.emotionType, emoticonCallback, viewGroup, sessionInfo, (ZPlanEmoticonPanelLifecycleObserver) cVar);
        }
        ZPlanEmoticonAdapter zPlanEmoticonAdapter = new ZPlanEmoticonAdapter(iEmoticonMainPanelApp, context, this.columnNum, this.panelType, this.emotionType, emoticonCallback, viewGroup, sessionInfo, LifecycleOwnerKt.getLifecycleScope(cVar));
        INSTANCE.b(new WeakReference(zPlanEmoticonAdapter), LifecycleOwnerKt.getLifecycleScope(cVar), context);
        this.adapter = zPlanEmoticonAdapter;
        return zPlanEmoticonAdapter;
    }

    public final ZPlanEmoticonAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelBuilder
    public EmotionInjectionInfo init(IEmoticonMainPanelApp app, Context context, int panelType, int emotionType, EmoticonCallback callback, ViewGroup aioRoot, p sessionInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.app = app;
        this.context = context;
        this.columnNum = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isBigScreen() ? 5 : 4;
        this.panelType = panelType;
        this.emotionType = emotionType;
        this.callback = callback;
        this.aioRoot = aioRoot;
        this.sessionInfo = (SessionInfo) sessionInfo;
        AbsEmoticonPanelLifecycleObserver build = ((IZPlanEmoticonPanelHelperBuilder) QRoute.api(IZPlanEmoticonPanelHelperBuilder.class)).build(11, sessionInfo.f179555d, sessionInfo.f179557e);
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonPanelHelper");
        c cVar = (c) build;
        this.observer = cVar;
        EmotionInjectionInfo emotionInjectionInfo = new EmotionInjectionInfo(emotionType, this.columnNum, 0, this);
        emotionInjectionInfo.setEmotionPanelLifecycleObserver(this.observer);
        emotionInjectionInfo.setEmotionTabCreateListener(((IZPlanEmotionPanelTabCreateListener) QRoute.api(IZPlanEmotionPanelTabCreateListener.class)).build(app, LifecycleOwnerKt.getLifecycleScope(cVar)));
        this.adapter = null;
        return emotionInjectionInfo;
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelBuilder
    public void buildData() {
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelBuilder
    public void buildParams() {
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelBuilder
    public void buildView() {
    }
}
