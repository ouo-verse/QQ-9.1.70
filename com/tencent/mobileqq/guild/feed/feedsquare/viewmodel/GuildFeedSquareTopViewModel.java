package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.event.GuildHomeFragmentOnRefreshEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareTopViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001&\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u0012J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0017J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R&\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "guildId", "channelId", "", "R1", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Q1", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/h;", "data", "U1", "T1", "Landroidx/lifecycle/LiveData;", "P1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onCleared", "", "S1", "i", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "topFeedsLiveData", "com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel$b", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel$b;", "topFeedSurface", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareTopViewModel extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFacadeType guildFacadeType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<ij1.h>>> topFeedsLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b topFeedSurface = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String channelId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J;\u0010\u0013\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011\u0018\u00010\u00102\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\t2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/j;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Lij1/h;", "", "guildId", "channelId", "", "updateTime", "", "Y", "", "getDisplaySurfaceType", "", "", "args", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "getDisplaySurfaceData", "([Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "loadMoreForDisplaySurface", "([Ljava/lang/Object;)V", "d", "J", "G0", "()J", "a", "(J)V", "lastUpdatedTime", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", IECDtReport.ACTION_IDENTIFIER, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements j, IDataDisplaySurface<ij1.h> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long lastUpdatedTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String identifier;

        b() {
            String str;
            if (GuildFeedSquareTopViewModel.this.S1(GuildFeedSquareTopViewModel.this.channelId)) {
                str = GuildFeedSquareTopViewModel.this.guildId + "_" + hashCode();
            } else {
                str = GuildFeedSquareTopViewModel.this.guildId + "_" + GuildFeedSquareTopViewModel.this.channelId + "_" + hashCode();
            }
            this.identifier = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j
        /* renamed from: G0, reason: from getter */
        public long getLastUpdatedTime() {
            return this.lastUpdatedTime;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j
        public void Y(@NotNull String guildId, @NotNull String channelId, long updateTime) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            if (Intrinsics.areEqual(GuildFeedSquareTopViewModel.this.guildId, guildId) && Intrinsics.areEqual(GuildFeedSquareTopViewModel.this.channelId, channelId)) {
                a(updateTime);
            }
        }

        public void a(long j3) {
            this.lastUpdatedTime = j3;
        }

        @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
        @Nullable
        public MutableLiveData<UIStateData<List<ij1.h>>> getDisplaySurfaceData(@NotNull Object... args) {
            boolean z16;
            Intrinsics.checkNotNullParameter(args, "args");
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16) && !Intrinsics.areEqual(args[0], GuildFeedSquareTopViewModel.this.guildId)) {
                return null;
            }
            if (args.length > 1 && !Intrinsics.areEqual(args[1], GuildFeedSquareTopViewModel.this.channelId)) {
                return null;
            }
            if (GuildFeedSquareTopViewModel.this.topFeedsLiveData.getValue() == 0) {
                GuildFeedSquareTopViewModel.this.topFeedsLiveData.setValue(UIStateData.obtainEmpty());
            }
            return GuildFeedSquareTopViewModel.this.topFeedsLiveData;
        }

        @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
        public int getDisplaySurfaceType() {
            return 0;
        }

        @Override // co1.h
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
        public void loadMoreForDisplaySurface(@NotNull Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
        }
    }

    public GuildFeedSquareTopViewModel() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void R1(String guildId, String channelId) {
        String d16;
        if (S1(channelId)) {
            d16 = jj1.b.d(guildId, "");
        } else {
            d16 = jj1.b.d(guildId, channelId);
        }
        jj1.b.c().registerDisplaySurface(d16, this.topFeedSurface);
    }

    @NotNull
    public final LiveData<UIStateData<List<ij1.h>>> P1() {
        return this.topFeedsLiveData;
    }

    public final void Q1(@NotNull String guildId, @NotNull String channelId, @NotNull GuildFacadeType guildFacadeType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        this.guildId = guildId;
        this.channelId = channelId;
        this.guildFacadeType = guildFacadeType;
        R1(guildId, channelId);
    }

    public final boolean S1(@Nullable String channelId) {
        if (!Intrinsics.areEqual(channelId, "0") && !Intrinsics.areEqual(channelId, "")) {
            return false;
        }
        return true;
    }

    public final void T1() {
        int i3;
        QLog.i("GuildFeedSquareTopViewModel", 1, "[sendUpdateTopFeedEvent] begin");
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
        guildFeedDetailTopUpdateEvent.setChannelId(guildFeedDetailTopUpdateEvent.getChannelId());
        if (GuildFacadeType.GameCenter == this.guildFacadeType) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        guildFeedDetailTopUpdateEvent.setServiceType(i3);
        SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailTopUpdateEvent);
        QLog.i("GuildFeedSquareTopViewModel", 1, "[sendUpdateTopFeedEvent] end");
    }

    public final void U1(@NotNull final UIStateData<List<ij1.h>> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareTopViewModel$updateFeedTopData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedSquareTopViewModel.b bVar;
                GuildFeedSquareTopViewModel.this.topFeedsLiveData.setValue(data);
                bVar = GuildFeedSquareTopViewModel.this.topFeedSurface;
                bVar.a(System.currentTimeMillis());
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildHomeFragmentOnRefreshEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Deprecated(message = "\u65b0\u7248\u4e3b\u6846\u67b6\u901a\u8fc7 guildHomeViewModel.liveStartRefresh \u5206\u53d1\u5237\u65b0\u4e8b\u4ef6")
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        if ((event instanceof GuildHomeFragmentOnRefreshEvent) && (str = this.guildId) != null) {
            if (!Intrinsics.areEqual(str, ((GuildHomeFragmentOnRefreshEvent) event).getGuildId())) {
                str = null;
            }
            if (str != null) {
                T1();
            }
        }
    }
}
