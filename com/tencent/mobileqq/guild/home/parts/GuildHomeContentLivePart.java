package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bp1.HeaderCollapsedState;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.event.GuildBehaviorUpdateListenerEvent;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo1.a;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 N2\u00020\u0001:\u0002OPB'\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\f\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\u0002J\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\nJ\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010#\u001a\u00020\nR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "width", "N9", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Lkotlin/ParameterName;", "name", "holder", "", "callback", "K9", "", "Lso1/h;", "list", "Lqo1/a;", "adapter", "O9", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onPostThemeChanged", "", "d", "J", "categoryId", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "e", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/home/subhome/e;", "f", "Lcom/tencent/mobileqq/guild/home/subhome/e;", "activeChannelViewModel", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", tl.h.F, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "i", "I", "currentOrientation", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "needForceNotify", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "liveAudioSubChannelView", "D", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onOutBehaviorStateUpdate", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$GuildLiveListViewRunnable;", "E", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$GuildLiveListViewRunnable;", "guildLiveListViewRunnable", "Lap1/a;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "M9", "()Lap1/a;", "guildChannelListJumpHandler", "<init>", "(JLcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;Lcom/tencent/mobileqq/guild/home/subhome/e;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "G", "a", "GuildLiveListViewRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeContentLivePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private OverScrollRecyclerViewWithHeaderFooter liveAudioSubChannelView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onOutBehaviorStateUpdate;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildLiveListViewRunnable guildLiveListViewRunnable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildChannelListJumpHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long categoryId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FacadeArgsData facadeArgsData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.e activeChannelViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask reportTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentOrientation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean needForceNotify;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n0\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r0\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$GuildLiveListViewRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "guildHomeContentLivePartRef", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "e", "liveViewRef", "Lcom/tencent/mobileqq/guild/home/subhome/e;", "f", "channelViewModelRef", "guildHomeContentLivePart", "guildListView", "channelViewModel", "<init>", "(Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart;Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;Lcom/tencent/mobileqq/guild/home/subhome/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GuildLiveListViewRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<GuildHomeContentLivePart> guildHomeContentLivePartRef;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<OverScrollRecyclerViewWithHeaderFooter> liveViewRef;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<com.tencent.mobileqq.guild.home.subhome.e> channelViewModelRef;

        public GuildLiveListViewRunnable(@NotNull GuildHomeContentLivePart guildHomeContentLivePart, @NotNull OverScrollRecyclerViewWithHeaderFooter guildListView, @NotNull com.tencent.mobileqq.guild.home.subhome.e channelViewModel) {
            Intrinsics.checkNotNullParameter(guildHomeContentLivePart, "guildHomeContentLivePart");
            Intrinsics.checkNotNullParameter(guildListView, "guildListView");
            Intrinsics.checkNotNullParameter(channelViewModel, "channelViewModel");
            this.guildHomeContentLivePartRef = new WeakReference<>(guildHomeContentLivePart);
            this.liveViewRef = new WeakReference<>(guildListView);
            this.channelViewModelRef = new WeakReference<>(channelViewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.mobileqq.guild.home.subhome.e eVar;
            GuildHomeContentLivePart guildHomeContentLivePart;
            qo1.a aVar;
            List<so1.h> value;
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveViewRef.get();
            if (overScrollRecyclerViewWithHeaderFooter == null || (eVar = this.channelViewModelRef.get()) == null || (guildHomeContentLivePart = this.guildHomeContentLivePartRef.get()) == null) {
                return;
            }
            RecyclerView.Adapter adapter = overScrollRecyclerViewWithHeaderFooter.getAdapter();
            if (adapter instanceof qo1.a) {
                aVar = (qo1.a) adapter;
            } else {
                aVar = null;
            }
            if (aVar != null && (value = eVar.X1().getValue()) != null) {
                QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "GuildLiveListViewRunnable data.size=" + value.size() + ", itemSize:" + aVar.getItems().size() + ", needForceNotify:" + guildHomeContentLivePart.needForceNotify);
                if (guildHomeContentLivePart.needForceNotify) {
                    guildHomeContentLivePart.needForceNotify = false;
                    aVar.notifyDataSetChanged();
                } else {
                    aVar.setItems(value);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$b", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224910b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeContentLivePart f224911c;

        public b(String str, GuildHomeContentLivePart guildHomeContentLivePart) {
            this.f224910b = str;
            this.f224911c = guildHomeContentLivePart;
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeContentLivePart", "onStateUpdate state:" + state);
            }
            if (state instanceof HeaderCollapsedState) {
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.f224911c.liveAudioSubChannelView;
                if (overScrollRecyclerViewWithHeaderFooter != null) {
                    overScrollRecyclerViewWithHeaderFooter.K(false);
                    return;
                }
                return;
            }
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.f224911c.liveAudioSubChannelView;
            if (overScrollRecyclerViewWithHeaderFooter2 != null) {
                overScrollRecyclerViewWithHeaderFooter2.K(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qo1.a f224912a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f224913b;

        c(qo1.a aVar, GridLayoutManager gridLayoutManager) {
            this.f224912a = aVar;
            this.f224913b = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (this.f224912a.getItems().get(position) instanceof so1.j) {
                return this.f224913b.getSpanCount();
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    public GuildHomeContentLivePart(long j3, @NotNull FacadeArgsData facadeArgsData, @NotNull com.tencent.mobileqq.guild.home.subhome.e activeChannelViewModel, @NotNull IPerformanceReportTask reportTask) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        Intrinsics.checkNotNullParameter(activeChannelViewModel, "activeChannelViewModel");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        this.categoryId = j3;
        this.facadeArgsData = facadeArgsData;
        this.activeChannelViewModel = activeChannelViewModel;
        this.reportTask = reportTask;
        this.onOutBehaviorStateUpdate = L9();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap1.a>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart$guildChannelListJumpHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ap1.a invoke() {
                ap1.a aVar = new ap1.a();
                aVar.a(GuildHomeContentLivePart.this.facadeArgsData);
                return aVar;
            }
        });
        this.guildChannelListJumpHandler = lazy;
    }

    private final void K9(Function1<? super GuildHomeChannelBaseAdapterDelegate.a, Unit> callback) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.ViewHolder viewHolder;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveAudioSubChannelView;
        if (overScrollRecyclerViewWithHeaderFooter == null || (layoutManager = overScrollRecyclerViewWithHeaderFooter.getLayoutManager()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(layoutManager, "this.layoutManager ?: return");
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != null) {
                Intrinsics.checkNotNullExpressionValue(childAt, "layoutManager.getChildAt(i) ?: continue");
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.liveAudioSubChannelView;
                if (overScrollRecyclerViewWithHeaderFooter2 != null) {
                    viewHolder = overScrollRecyclerViewWithHeaderFooter2.getChildViewHolder(childAt);
                } else {
                    viewHolder = null;
                }
                if (viewHolder instanceof GuildHomeChannelBaseAdapterDelegate.a) {
                    callback.invoke(viewHolder);
                }
            }
        }
    }

    private final com.tencent.mobileqq.guild.home.subhome.g L9() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new b("Guild.NewHome.subFrag.GuildHomeContentLivePart", this);
    }

    private final ap1.a M9() {
        return (ap1.a) this.guildChannelListJumpHandler.getValue();
    }

    private final int N9(int width) {
        if (width < ViewUtils.dip2px(549.0f)) {
            return 2;
        }
        if (width < ViewUtils.dip2px(768.0f)) {
            return 3;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(List<? extends so1.h> list, qo1.a adapter) {
        RecyclerView.LayoutManager layoutManager;
        int i3;
        QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "handleActiveChannelListUpdate, list size:" + list.size());
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveAudioSubChannelView;
        GridLayoutManager gridLayoutManager = null;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            layoutManager = overScrollRecyclerViewWithHeaderFooter.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        }
        if (gridLayoutManager != null) {
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            intRef.element = findFirstVisibleItemPosition;
            View findViewByPosition = gridLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                i3 = findViewByPosition.getTop();
            } else {
                i3 = 0;
            }
            intRef2.element = i3;
        }
        QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "calculate and save position before data update\uff1a" + intRef.element + ", recyclerView offset:" + intRef2.element);
        adapter.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeContentLivePart.P9(Ref.IntRef.this, intRef2, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Ref.IntRef firstVisibleItemPos, Ref.IntRef offset, GuildHomeContentLivePart this$0) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(firstVisibleItemPos, "$firstVisibleItemPos");
        Intrinsics.checkNotNullParameter(offset, "$offset");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "recover position after data update\uff1a" + firstVisibleItemPos.element + ", recyclerView offset:" + offset.element);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this$0.liveAudioSubChannelView;
        GridLayoutManager gridLayoutManager = null;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            layoutManager = overScrollRecyclerViewWithHeaderFooter.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        }
        if (gridLayoutManager != null) {
            gridLayoutManager.scrollToPositionWithOffset(firstVisibleItemPos.element, offset.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(OverScrollRecyclerViewWithHeaderFooter this_apply, GuildHomeContentLivePart this$0, so1.h itemData) {
        boolean z16;
        IGProChannelInfo it;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            if (itemData.getChannelId().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (it = com.tencent.mobileqq.guild.util.ch.B(itemData.getChannelId())) != null) {
                ap1.a M9 = this$0.M9();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                M9.b(it, true, activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(OverScrollRecyclerViewWithHeaderFooter this_apply, GuildHomeContentLivePart this$0, final qo1.a adapter, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        GridLayoutManager gridLayoutManager;
        int N9;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        RecyclerView.LayoutManager layoutManager = this_apply.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            gridLayoutManager = null;
        }
        if (gridLayoutManager != null) {
            int i29 = i17 - i3;
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            if (guildSplitViewUtils.n(this_apply.getContext())) {
                i29 = RangesKt___RangesKt.coerceAtMost(i29, GuildSplitViewUtils.j(guildSplitViewUtils, false, null, 3, null));
            }
            if (i29 != i27 - i19 && (N9 = this$0.N9(i29)) != gridLayoutManager.getSpanCount()) {
                gridLayoutManager.setSpanCount(N9);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this$0.liveAudioSubChannelView;
                if (overScrollRecyclerViewWithHeaderFooter != null) {
                    overScrollRecyclerViewWithHeaderFooter.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildHomeContentLivePart.S9(qo1.a.this);
                        }
                    });
                }
            }
            List<so1.h> value = this$0.activeChannelViewModel.X1().getValue();
            if (value != null) {
                QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "LayoutChangeListener data.size=" + value.size() + ", itemSize:" + adapter.getItems().size() + ", needForceNotify:" + this$0.needForceNotify);
                if (this$0.needForceNotify) {
                    this$0.needForceNotify = false;
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.setItems(value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(qo1.a adapter) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void T9() {
        final OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveAudioSubChannelView;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            LiveData<List<so1.h>> X1 = this.activeChannelViewModel.X1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<List<? extends so1.h>, Unit> function1 = new Function1<List<? extends so1.h>, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart$onViewCreatedAfterPartInit$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends so1.h> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends so1.h> list) {
                    GuildHomeContentLivePart guildHomeContentLivePart = GuildHomeContentLivePart.this;
                    Intrinsics.checkNotNullExpressionValue(list, "list");
                    RecyclerView.Adapter adapter = overScrollRecyclerViewWithHeaderFooter.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.activechannel.GuildHomeActiveChannelAdapter");
                    guildHomeContentLivePart.O9(list, (qo1.a) adapter);
                    VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter);
                }
            };
            X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildHomeContentLivePart.U9(Function1.this, obj);
                }
            });
            this.guildLiveListViewRunnable = new GuildLiveListViewRunnable(this, overScrollRecyclerViewWithHeaderFooter, this.activeChannelViewModel);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        qo1.a aVar;
        List emptyList;
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int i3 = this.currentOrientation;
            int i16 = configuration.orientation;
            if (i3 != i16) {
                this.currentOrientation = i16;
                this.needForceNotify = true;
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveAudioSubChannelView;
                if (overScrollRecyclerViewWithHeaderFooter != null) {
                    RecyclerView.Adapter adapter = overScrollRecyclerViewWithHeaderFooter.getAdapter();
                    if (adapter instanceof qo1.a) {
                        aVar = (qo1.a) adapter;
                    } else {
                        aVar = null;
                    }
                    if (aVar != null) {
                        QLog.i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "onConfigurationChanged orientation:" + this.currentOrientation);
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        aVar.setItems(emptyList);
                    }
                    GuildLiveListViewRunnable guildLiveListViewRunnable = this.guildLiveListViewRunnable;
                    if (guildLiveListViewRunnable != null) {
                        overScrollRecyclerViewWithHeaderFooter.postDelayed(guildLiveListViewRunnable, 1000L);
                    }
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        final OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
        Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeContentLivePart", 1, "onInitView, guildId: " + this.facadeArgsData.f227656e + ", categoryId:" + this.categoryId);
        if (rootView != null && (overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) rootView.findViewById(R.id.wmo)) != null) {
            qw1.b.j(this.reportTask, overScrollRecyclerViewWithHeaderFooter, new Function1<IPerformanceReportTask, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart$onInitView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IPerformanceReportTask iPerformanceReportTask) {
                    invoke2(iPerformanceReportTask);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IPerformanceReportTask reportOnFirstFrame) {
                    IPerformanceReportTask iPerformanceReportTask;
                    Intrinsics.checkNotNullParameter(reportOnFirstFrame, "$this$reportOnFirstFrame");
                    cp1.d dVar = cp1.d.f391542a;
                    iPerformanceReportTask = GuildHomeContentLivePart.this.reportTask;
                    dVar.b(iPerformanceReportTask);
                }
            });
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            final qo1.a aVar = new qo1.a(lifecycleOwner, new a.b() { // from class: com.tencent.mobileqq.guild.home.parts.k
                @Override // qo1.a.b
                public final void a(so1.h hVar) {
                    GuildHomeContentLivePart.Q9(OverScrollRecyclerViewWithHeaderFooter.this, this, hVar);
                }
            });
            overScrollRecyclerViewWithHeaderFooter.setAdapter(aVar);
            overScrollRecyclerViewWithHeaderFooter.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(overScrollRecyclerViewWithHeaderFooter.getContext(), 2);
            gridLayoutManager.setSpanSizeLookup(new c(aVar, gridLayoutManager));
            overScrollRecyclerViewWithHeaderFooter.setLayoutManager(gridLayoutManager);
            overScrollRecyclerViewWithHeaderFooter.setItemAnimator(null);
            overScrollRecyclerViewWithHeaderFooter.I(true);
            overScrollRecyclerViewWithHeaderFooter.K(true);
            overScrollRecyclerViewWithHeaderFooter.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.home.parts.l
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    GuildHomeContentLivePart.R9(OverScrollRecyclerViewWithHeaderFooter.this, this, aVar, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            overScrollRecyclerViewWithHeaderFooter.addOnScrollListener(new d());
            this.liveAudioSubChannelView = overScrollRecyclerViewWithHeaderFooter;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        this.currentOrientation = getContext().getResources().getConfiguration().orientation;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeContentLivePart", "onPartPause");
        }
        K9(new Function1<GuildHomeChannelBaseAdapterDelegate.a, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart$onPartPause$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeChannelBaseAdapterDelegate.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildHomeChannelBaseAdapterDelegate.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.p(false);
            }
        });
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        simpleEventBus.dispatchEvent(new GuildBehaviorUpdateListenerEvent(str, System.identityHashCode(activity), this.onOutBehaviorStateUpdate, false));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeContentLivePart", "onPartResume");
        }
        K9(new Function1<GuildHomeChannelBaseAdapterDelegate.a, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart$onPartResume$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeChannelBaseAdapterDelegate.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildHomeChannelBaseAdapterDelegate.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.p(true);
            }
        });
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        simpleEventBus.dispatchEvent(new GuildBehaviorUpdateListenerEvent(str, System.identityHashCode(activity), this.onOutBehaviorStateUpdate, true));
    }

    public final void onPostThemeChanged() {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.liveAudioSubChannelView;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            overScrollRecyclerViewWithHeaderFooter.setItemViewCacheSize(0);
            overScrollRecyclerViewWithHeaderFooter.setItemViewCacheSize(2);
            RecyclerView.Adapter adapter = overScrollRecyclerViewWithHeaderFooter.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
