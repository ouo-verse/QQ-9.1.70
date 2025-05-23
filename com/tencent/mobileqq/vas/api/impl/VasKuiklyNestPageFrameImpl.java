package com.tencent.mobileqq.vas.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\u000b\fB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl;", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame;", "", "updateSizeTag", "Lkotlin/Function0;", "schemaBuilder", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "newFrame", "<init>", "()V", "Companion", "a", "VasDynamicFrameLogic", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyNestPageFrameImpl implements IVasKuiklyNestPageFrame {

    @NotNull
    public static final String TAG = "VasKuiklyNestPageFrameImpl";

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\f\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0002\u0012;B\u001d\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001d\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\"\u00103R\u0016\u00107\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "Landroid/view/ViewGroup;", AIInput.KEY_FRAME, "", "h0", "pause", "resume", "", AdMetricTag.EVENT_NAME, "", "", "data", "sentEvent", "detachView", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$a;", "handler", "a", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "d", "Ljava/lang/String;", "updateSizeTag", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "schemaBuilder", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "frameViewReference", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", tl.h.F, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "renderLogicView", "i", "Z", "hasAttach", "Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic$MyBroadcastReceiver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic$MyBroadcastReceiver;", "kuiklyReceiver", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Ljava/util/Map;", "eventMap", "g", "()Landroid/view/ViewGroup;", "frameView", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "D", "MyBroadcastReceiver", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class VasDynamicFrameLogic implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, IVasKuiklyNestPageFrame.b {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final Lazy eventMap;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String updateSizeTag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<String> schemaBuilder;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<ViewGroup> frameViewReference;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g renderLogicView;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean hasAttach;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MyBroadcastReceiver kuiklyReceiver;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic$MyBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic;", "a", "Ljava/lang/ref/WeakReference;", "weakLogic", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "(Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class MyBroadcastReceiver extends BroadcastReceiver {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<VasDynamicFrameLogic> weakLogic;

            public MyBroadcastReceiver(@NotNull VasDynamicFrameLogic instance) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                this.weakLogic = new WeakReference<>(instance);
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                l01.a a16;
                int i3;
                l01.a a17;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a18 = com.tencent.kuikly.core.render.android.expand.module.l.a(intent);
                JSONObject b16 = com.tencent.kuikly.core.render.android.expand.module.l.b(intent);
                QLog.i(VasKuiklyNestPageFrameImpl.TAG, 1, a18 + " " + b16);
                VasDynamicFrameLogic vasDynamicFrameLogic = this.weakLogic.get();
                if (vasDynamicFrameLogic == null) {
                    return;
                }
                if (Intrinsics.areEqual(a18, vasDynamicFrameLogic.updateSizeTag)) {
                    double optDouble = b16.optDouble("view_height");
                    if (optDouble > 0.0d) {
                        View view = (View) vasDynamicFrameLogic.renderLogicView;
                        int i16 = 0;
                        if (view != null) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams != null) {
                                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = vasDynamicFrameLogic.renderLogicView;
                                if (gVar != null && (a17 = gVar.a()) != null) {
                                    i3 = (int) a17.b((float) optDouble);
                                } else {
                                    i3 = 0;
                                }
                                layoutParams.height = i3;
                            }
                            view.requestLayout();
                        }
                        ViewGroup g16 = vasDynamicFrameLogic.g();
                        if (g16 != null) {
                            ViewGroup.LayoutParams layoutParams2 = g16.getLayoutParams();
                            if (layoutParams2 != null) {
                                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar2 = vasDynamicFrameLogic.renderLogicView;
                                if (gVar2 != null && (a16 = gVar2.a()) != null) {
                                    i16 = (int) a16.b((float) optDouble);
                                }
                                layoutParams2.height = i16;
                            }
                            g16.requestLayout();
                            return;
                        }
                        return;
                    }
                    return;
                }
                IVasKuiklyNestPageFrame.a aVar = (IVasKuiklyNestPageFrame.a) vasDynamicFrameLogic.f().get(a18);
                if (aVar != null) {
                    aVar.handle(a18, b16);
                }
            }
        }

        public VasDynamicFrameLogic(@NotNull String updateSizeTag, @NotNull Function0<String> schemaBuilder) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(updateSizeTag, "updateSizeTag");
            Intrinsics.checkNotNullParameter(schemaBuilder, "schemaBuilder");
            this.updateSizeTag = updateSizeTag;
            this.schemaBuilder = schemaBuilder;
            this.kuiklyReceiver = new MyBroadcastReceiver(this);
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, IVasKuiklyNestPageFrame.a>>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyNestPageFrameImpl$VasDynamicFrameLogic$eventMap$2
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<String, IVasKuiklyNestPageFrame.a> invoke() {
                    return new LinkedHashMap();
                }
            });
            this.eventMap = lazy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, IVasKuiklyNestPageFrame.a> f() {
            return (Map) this.eventMap.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewGroup g() {
            WeakReference<ViewGroup> weakReference = this.frameViewReference;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void a(@NotNull String eventName, @NotNull IVasKuiklyNestPageFrame.a handler) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(handler, "handler");
            f().put(eventName, handler);
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void detachView() {
            ViewGroup g16;
            if (!this.hasAttach) {
                QLog.e(VasKuiklyNestPageFrameImpl.TAG, 1, "no need detach");
                return;
            }
            this.hasAttach = false;
            if (this.renderLogicView != null && (g16 = g()) != null) {
                Object obj = this.renderLogicView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                g16.removeView((View) obj);
            }
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onDetach();
                try {
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    com.tencent.kuikly.core.render.android.expand.module.l.f(context, this.kuiklyReceiver);
                } catch (Exception e16) {
                    QLog.e(VasKuiklyNestPageFrameImpl.TAG, 1, "unregisterKuiklyBroadcastReceiver: ", e16);
                }
            }
            this.renderLogicView = null;
            this.frameViewReference = null;
            QLog.i(VasKuiklyNestPageFrameImpl.TAG, 1, "detachView " + this.updateSizeTag);
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void h0(@Nullable ViewGroup frame) {
            if (frame == null) {
                QLog.e(VasKuiklyNestPageFrameImpl.TAG, 1, "frame null");
                return;
            }
            if (this.hasAttach) {
                QLog.e(VasKuiklyNestPageFrameImpl.TAG, 1, "repeat Attach");
                return;
            }
            this.hasAttach = true;
            this.frameViewReference = new WeakReference<>(frame);
            IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
            this.renderLogicView = createKuiklyRenderView;
            if (createKuiklyRenderView != null) {
                String invoke = this.schemaBuilder.invoke();
                g.a.a(createKuiklyRenderView, ((Object) invoke) + "&update_size_event_name=" + this.updateSizeTag, null, 2, null);
            }
            Object obj = this.renderLogicView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            frame.addView((View) obj, -1, -1);
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            com.tencent.kuikly.core.render.android.expand.module.l.c(context2, this.kuiklyReceiver);
            QLog.i(VasKuiklyNestPageFrameImpl.TAG, 1, "attachView " + this.updateSizeTag);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideErrorView() {
            h.a.a(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideLoadingView() {
            h.a.b(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
            Intrinsics.checkNotNullParameter(executeMode, "executeMode");
            QLog.i(VasKuiklyNestPageFrameImpl.TAG, 1, "onPageLoadComplete");
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void pause() {
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onPause();
            }
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void resume() {
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onResume();
            }
        }

        @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.b
        public void sentEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.sentEvent(eventName, data);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showErrorView() {
            h.a.c(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showLoadingView() {
            h.a.d(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame
    @NotNull
    public IVasKuiklyNestPageFrame.b newFrame(@NotNull String updateSizeTag, @NotNull Function0<String> schemaBuilder) {
        Intrinsics.checkNotNullParameter(updateSizeTag, "updateSizeTag");
        Intrinsics.checkNotNullParameter(schemaBuilder, "schemaBuilder");
        return new VasDynamicFrameLogic(updateSizeTag, schemaBuilder);
    }
}
