package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import com.tencent.mobileqq.guild.discoveryv2.content.model.k;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends;
import com.tencent.mobileqq.guild.discoveryv2.fragment.d;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabClickData;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsUIState;

/* compiled from: P */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\t*\u0001;\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\f\u0010\u0010\u001a\u00020\u0004*\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "M9", "Lqh1/e;", "state", "K9", "", "stageCode", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "E9", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel;", "J9", "G9", "list", "L9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onPartPause", "onPartStop", "onPartDestroy", "action", "", "args", "handleBroadcastMessage", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "F9", "()Landroidx/recyclerview/widget/RecyclerView;", "_rv", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel;", "_tabVM", "Lzh1/b;", tl.h.F, "Lzh1/b;", "_feedsCardListIoc", "i", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "originReportTask", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "firstScreenReportFinished", BdhLogUtil.LogTag.Tag_Conn, "hasPaused", "com/tencent/mobileqq/guild/discoveryv2/parts/TabMisc$b", "D", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc$b;", "_depends", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabMisc extends MVPFeedsPart {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b _depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _rv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TabViewModel _tabVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zh1.b _feedsCardListIoc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask originReportTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean firstScreenReportFinished;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/TabMisc$b", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MVPFeedsDepends;", "", "d", "getContentWidth", "", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "joinSourceDepends", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends MVPFeedsDepends {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.content.recommend.d clickProcessor = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.d(1);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.fragment.d joinSourceDepends = a.f217635a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "dataType", "", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "Lkotlin/Pair;", "", "a", "(ILjava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        static final class a implements com.tencent.mobileqq.guild.discoveryv2.fragment.d {

            /* renamed from: a, reason: collision with root package name */
            public static final a f217635a = new a();

            a() {
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public final Pair<String, String> a(int i3, @Nullable Object obj) {
                h.Companion companion = com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE;
                if (i3 == companion.q()) {
                    return TuplesKt.to("discover", "discover_single_recommend");
                }
                if (i3 == companion.h()) {
                    return TuplesKt.to("discover", "discover_single_recommend");
                }
                if (i3 == companion.u()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.s()) {
                    return TuplesKt.to("discover", "discover_livestream");
                }
                if (i3 == companion.v()) {
                    return TuplesKt.to("discover", "discover_voice");
                }
                if (i3 == companion.r()) {
                    return TuplesKt.to("discover", "discover_single_recommend_new");
                }
                if (i3 == companion.y()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.l()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.B()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.A()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.p()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                if (i3 == companion.z()) {
                    return TuplesKt.to("discover", "discover_hot");
                }
                com.tencent.mobileqq.guild.util.s.e("discoveryv2", "getJoinSource: " + i3 + " " + obj, new IllegalStateException());
                return TuplesKt.to("discover", "discover_hot");
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public Pair<String, String> b(int i3) {
                return d.a.a(this, i3);
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: c, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.fragment.d getJoinSourceDepends() {
            return this.joinSourceDepends;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends, com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int d() {
            Object m476constructorimpl;
            int coerceAtLeast;
            TabMisc tabMisc = TabMisc.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object broadcastGetMessage = tabMisc.broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
                Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
                Iterator<com.tencent.mobileqq.guild.discoveryv2.content.base.h> it = ((MVPFeedsUIState) ((StateFlow) broadcastGetMessage).getValue()).getListState().d().iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() instanceof com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
                m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(coerceAtLeast));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = 0;
            }
            return ((Number) m476constructorimpl).intValue();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: e, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.content.recommend.d getClickProcessor() {
            return this.clickProcessor;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends, com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public boolean f() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends, com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int getContentWidth() {
            Number valueOf;
            TabMisc tabMisc = TabMisc.this;
            int screenWidth = DisplayUtil.getScreenWidth();
            if (QQGuildUIUtil.A(tabMisc.getContext())) {
                valueOf = Float.valueOf(com.tencent.mobileqq.pad.e.h() * screenWidth);
            } else {
                valueOf = Integer.valueOf(screenWidth);
            }
            return valueOf.intValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f217636d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f217637e;

        public c(Object obj, Observer observer) {
            this.f217636d = obj;
            this.f217637e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f217636d)) != null) {
                this.f217637e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f217638d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f217639e;

        public d(Object obj, Observer observer) {
            this.f217638d = obj;
            this.f217639e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f217638d)) != null) {
                this.f217639e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f217640a;

        public e(ViewModelStoreOwner viewModelStoreOwner) {
            this.f217640a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new TabsViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public TabMisc() {
        Lazy lazy;
        uh1.a.f438959a.d("tabFragment init");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc$_rv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) TabMisc.this.getPartRootView().findViewById(R.id.uiw);
            }
        });
        this._rv = lazy;
        this._feedsCardListIoc = zh1.b.INSTANCE.a();
        this._depends = new b();
    }

    private final IPerformanceReportTask E9(String stageCode) {
        String str;
        Map<String, ? extends Object> mapOf;
        IPerformanceReportTask iPerformanceReportTask = this.originReportTask;
        if (iPerformanceReportTask != null) {
            int i3 = 0;
            IPerformanceReportTask duplicate = iPerformanceReportTask.duplicate(new String[0]);
            if (duplicate != null) {
                duplicate.setRealTime(false);
                Pair[] pairArr = new Pair[2];
                TabViewModel tabViewModel = this._tabVM;
                if (tabViewModel == null || (str = tabViewModel.getTabName()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("tab_name", str);
                TabViewModel tabViewModel2 = this._tabVM;
                if (tabViewModel2 != null) {
                    i3 = tabViewModel2.getTabId();
                }
                pairArr[1] = TuplesKt.to(com.qzone.widget.u.COLUMN_TAB_ID, Integer.valueOf(i3));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                duplicate.setExtras(mapOf);
                return duplicate.setStageCode(stageCode);
            }
        }
        return null;
    }

    private final RecyclerView F9() {
        return (RecyclerView) this._rv.getValue();
    }

    private final void G9(final TabViewModel tabViewModel) {
        LiveData<ef1.a<TabClickData>> S1 = tabViewModel.S1();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<TabClickData, Unit> function1 = new Function1<TabClickData, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc$observeRefreshEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TabClickData tabClickData) {
                invoke2(tabClickData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TabClickData tabClickData) {
                Logger logger = Logger.f235387a;
                TabViewModel tabViewModel2 = tabViewModel;
                logger.d().i("TabMisc", 1, "liveEventClickData: " + tabViewModel2.getTabId() + "(" + tabViewModel2.getTabType() + ") " + tabClickData);
                boolean isGuildTabSelected = tabClickData.getIsGuildTabSelected();
                boolean needRefreshTab = tabClickData.getNeedRefreshTab();
                Integer tabId = tabClickData.getTabId();
                if (!isGuildTabSelected && !needRefreshTab) {
                    TabMisc.this.broadcastMessage("message_guild_tab_selected", new ContentMessage());
                    return;
                }
                TabMisc.this.broadcastMessage("message_trigger_jump_and_pull_to_refresh", new ContentMessage.TriggerJumpTopAndPullToRefresh(isGuildTabSelected + " _ " + needRefreshTab + " _ " + tabId));
            }
        };
        S1.observe(a16, new c(null, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabMisc.I9(Function1.this, obj);
            }
        }));
        LiveData<ef1.a<Integer>> T1 = tabViewModel.T1();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc$observeRefreshEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Logger logger = Logger.f235387a;
                TabViewModel tabViewModel2 = tabViewModel;
                logger.d().i("TabMisc", 1, "liveEventNavTabClickData: " + tabViewModel2.getTabId() + "(" + tabViewModel2.getTabType() + ") event:" + num);
                TabMisc tabMisc = TabMisc.this;
                int tabId = tabViewModel.getTabId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("NavTabClick ");
                sb5.append(tabId);
                tabMisc.broadcastMessage("message_trigger_jump_and_pull_to_refresh", new ContentMessage.TriggerJumpTopAndPullToRefresh(sb5.toString()));
            }
        };
        T1.observe(a17, new d(null, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabMisc.H9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final TabViewModel J9() {
        c.Companion companion = ef1.c.INSTANCE;
        Fragment parentFragment = getHostFragment().getParentFragment();
        if (parentFragment == null) {
            parentFragment = getHostFragment();
        }
        Intrinsics.checkNotNullExpressionValue(parentFragment, "hostFragment.parentFragment ?: hostFragment");
        ViewModel viewModel = new ViewModelProvider(parentFragment, new e(parentFragment)).get(TabsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        TabViewModel P1 = ((TabsViewModel) viewModel).P1((GuildSubTabFragmentAdapter.SubTabData) com.tencent.mobileqq.guild.base.extension.n.a(this, "subTabData"));
        P1.e2();
        G9(P1);
        return P1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(MVPFeedsUIState state) {
        String stackTraceToString;
        boolean z16;
        boolean z17;
        IPerformanceReportTask extra;
        try {
            if (!this.hasPaused && !this.firstScreenReportFinished) {
                boolean z18 = state.getRefreshState().getRefreshType() instanceof k.RefreshFinish;
                int i3 = 0;
                if (state.getListState().getSource() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!state.getListState().d().isEmpty()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                boolean d16 = state.getSuccess().d();
                if (z16) {
                    if (z18) {
                        IPerformanceReportTask E9 = E9("stage_request_net_end");
                        if (E9 != null) {
                            E9.setResultCode(state.getSuccess().f431477a);
                            String str = state.getSuccess().f431478b;
                            Intrinsics.checkNotNullExpressionValue(str, "state.success.message");
                            E9.setResultMsg(str);
                            E9.report();
                        }
                        if (!d16) {
                            IPerformanceReportTask E92 = E9("stage_finish");
                            if (E92 != null && (extra = E92.setExtra("has_data", 0)) != null) {
                                extra.report();
                            }
                            this.firstScreenReportFinished = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                IPerformanceReportTask E93 = E9("stage_load_cache_end");
                if (E93 != null) {
                    if (z17) {
                        i3 = 1;
                    }
                    E93.setExtra("has_data", Integer.valueOf(i3));
                    E93.report();
                }
                IPerformanceReportTask E94 = E9("stage_request_net_start");
                if (E94 != null) {
                    E94.report();
                }
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("TabMisc", 1, "[reportRecommendTabInit] exception: " + stackTraceToString);
        }
    }

    private final void L9(MVPFeedsUIState list) {
        boolean z16;
        IPerformanceReportTask extra;
        try {
            if (!this.hasPaused && !this.firstScreenReportFinished) {
                if (list.getListState().getSource() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    IPerformanceReportTask E9 = E9("stage_finish");
                    if (E9 != null && (extra = E9.setExtra("has_data", 1)) != null) {
                        qw1.b.k(extra, F9(), null, 2, null);
                    }
                    this.firstScreenReportFinished = true;
                    return;
                }
                IPerformanceReportTask E92 = E9("stage_cache_first_frame_finish");
                if (E92 != null) {
                    qw1.b.k(E92, F9(), null, 2, null);
                }
            }
        } catch (Exception e16) {
            Logger.f235387a.d().i("TabMisc", 1, "reportRenderOnScreen: exception:" + e16.getMessage());
        }
    }

    private final void M9() {
        String stackTraceToString;
        try {
            IPerformanceReportTask E9 = E9("stage_load_cache");
            if (E9 != null) {
                E9.report();
            }
            Object broadcastGetMessage = broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
            Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
            StateFlow stateFlow = (StateFlow) broadcastGetMessage;
            LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
            Lifecycle.State state = Lifecycle.State.STARTED;
            Lifecycle lifecycle = a16.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
            LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new TabMisc$reportTabStart$$inlined$collectIn$default$1(lifecycle, state, stateFlow, null, this));
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("TabMisc", 1, "[reportRecommendTabStart] exception: " + stackTraceToString);
        }
    }

    private final void N9(View rootView) {
        Activity activity;
        Map mutableMapOf;
        GuildSubTabFragmentAdapter.SubTabData subTabData = (GuildSubTabFragmentAdapter.SubTabData) com.tencent.mobileqq.guild.base.extension.n.a(this, "subTabData");
        Context context = rootView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        VideoReport.setPageId(rootView, "pg_sgrp_discover_scene");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_tab_name", subTabData.getName()), TuplesKt.to("sgrp_tab_type", Integer.valueOf(subTabData.getType())));
        mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mutableMapOf));
        VideoReport.setPageLinkEnable(rootView, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        final MVPFeedsUIState mVPFeedsUIState;
        if (Intrinsics.areEqual(action, "message_data_changed_render_on_screen")) {
            if (args instanceof MVPFeedsUIState) {
                mVPFeedsUIState = (MVPFeedsUIState) args;
            } else {
                mVPFeedsUIState = null;
            }
            if (mVPFeedsUIState == null) {
                return;
            }
            L9(mVPFeedsUIState);
            final RecyclerView _rv = F9();
            Intrinsics.checkNotNullExpressionValue(_rv, "_rv");
            Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(_rv, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc$handleBroadcastMessage$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    TabViewModel tabViewModel;
                    String str;
                    uh1.a aVar = uh1.a.f438959a;
                    aVar.d("tabFragment feed onPreDraw " + mVPFeedsUIState.getListState());
                    Logger.a d16 = Logger.f235387a.d();
                    long a16 = aVar.a();
                    tabViewModel = this._tabVM;
                    if (tabViewModel != null) {
                        str = tabViewModel.getTabName();
                    } else {
                        str = null;
                    }
                    d16.i("MVPFeedsTrace", 1, "Guild Performance discovery feeds data notify " + a16 + " " + str);
                    VideoReport.traverseExposure();
                }
            }), "OneShotPreDrawListener.add(this) { action(this) }");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        DisplayUtil.reset();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final IPerformanceReportTask d16 = qw1.b.d(getHostFragment().getArguments(), null, 1, null);
        final IPerformanceReportTask c16 = qw1.b.c(getHostFragment().getArguments(), "_extra_param_report_task_view_pager_tab");
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(rootView, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc$onInitView$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                TabViewModel tabViewModel;
                String str;
                TabViewModel tabViewModel2;
                uh1.a aVar = uh1.a.f438959a;
                tabViewModel = this._tabVM;
                String str2 = null;
                if (tabViewModel != null) {
                    str = tabViewModel.getTabName();
                } else {
                    str = null;
                }
                aVar.d("tabFragment onPreDraw " + str);
                Logger.a d17 = Logger.f235387a.d();
                long a16 = aVar.a();
                tabViewModel2 = this._tabVM;
                if (tabViewModel2 != null) {
                    str2 = tabViewModel2.getTabName();
                }
                d17.i("MVPFeedsTrace", 1, "Guild Performance discovery main pre draw, " + a16 + " " + str2);
                cp1.d.f391542a.b(d16);
                d16.report();
                qw1.b.n(c16);
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        this.originReportTask = c16;
        M9();
        N9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        DisplayUtil.reset();
        this._tabVM = J9();
        PartIOCKt.registerIoc(this, this._depends, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
        PartIOCKt.registerIoc(this, this._feedsCardListIoc, zh1.b.class);
        TabViewModel tabViewModel = this._tabVM;
        Intrinsics.checkNotNull(tabViewModel);
        PartIOCKt.registerIoc(this, tabViewModel, TabViewModel.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
        PartIOCKt.unregisterIoc(this, zh1.b.class);
        PartIOCKt.unregisterIoc(this, TabViewModel.class);
        PartIOCKt.unregisterIoc(this, zp1.a.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPaused = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        DisplayUtil.reset();
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_discover_scene", "TabMisc");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        this.hasPaused = true;
    }
}
