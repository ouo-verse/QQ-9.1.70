package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DataChangedState;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailCommentViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailGuildInfoViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.LoadDataArgs;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001QB\u0011\u0012\b\b\u0002\u00102\u001a\u00020/\u00a2\u0006\u0004\bN\u0010OJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00142\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002J\u0012\u0010-\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010.\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010;\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00101R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020<0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00190F8CX\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010H\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/ContentDataFusionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "action", "", "args", "handleBroadcastMessage", "getMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "initData", "U9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/u;", "event", "T9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "da", "ba", "ca", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/c;", "state", "K9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/x;", "J9", "", "source", "S9", "P9", "O9", "N9", "I9", "F9", "msg", "R9", "Q9", "Ltl1/g$aa;", "reloadMessage", "H9", "G9", "M9", "L9", "", "d", "Z", "showGuildInfoDetail", "e", "Ljava/lang/String;", "feedId", "f", "guildId", tl.h.F, "channelId", "i", "isAnimating", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoadingMore", BdhLogUtil.LogTag.Tag_Conn, "isFirstLoadingComment", "Landroid/util/SparseArray;", "D", "Landroid/util/SparseArray;", "isReloadingFlags", "", "E", "Ljava/util/List;", "animationBlockList", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/v;", UserInfo.SEX_FEMALE, "viewModelList", "<init>", "(Z)V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ContentDataFusionPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isFirstLoadingComment;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<AtomicBoolean> isReloadingFlags;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<DataChangedState> animationBlockList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.guild.feed.nativedetail.content.model.v> viewModelList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean showGuildInfoDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isLoadingMore;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f221290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ContentDataFusionPart f221291b;

        public b(ViewModelStoreOwner viewModelStoreOwner, ContentDataFusionPart contentDataFusionPart) {
            this.f221290a = viewModelStoreOwner;
            this.f221291b = contentDataFusionPart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            IPartHost partHost = this.f221291b.getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            TimedValue timedValue = new TimedValue(new DetailMainViewModel(partHost), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f221292a;

        public c(ViewModelStoreOwner viewModelStoreOwner) {
            this.f221292a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new DetailGuildInfoViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f221293a;

        public d(ViewModelStoreOwner viewModelStoreOwner) {
            this.f221293a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new DetailCommentViewModel(null, 1, 0 == true ? 1 : 0), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public ContentDataFusionPart(boolean z16) {
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.content.model.v> emptyList;
        this.showGuildInfoDetail = z16;
        this.isLoadingMore = new AtomicBoolean(false);
        this.isFirstLoadingComment = new AtomicBoolean(false);
        SparseArray<AtomicBoolean> sparseArray = new SparseArray<>();
        sparseArray.append(2, new AtomicBoolean(false));
        sparseArray.append(1, new AtomicBoolean(false));
        sparseArray.append(3, new AtomicBoolean(false));
        this.isReloadingFlags = sparseArray;
        this.animationBlockList = new ArrayList();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.viewModelList = emptyList;
    }

    private final void F9() {
        if (!this.animationBlockList.isEmpty()) {
            LinkedList linkedList = new LinkedList(this.animationBlockList);
            this.animationBlockList.clear();
            K9(new DataChangedState(15, linkedList));
        }
    }

    private final LoadDataArgs G9() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(getPartHost());
        String str6 = this.feedId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            str = null;
        } else {
            str = str6;
        }
        String str7 = this.guildId;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str2 = null;
        } else {
            str2 = str7;
        }
        String str8 = this.channelId;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            str3 = null;
        } else {
            str3 = str8;
        }
        long j3 = h16.getLong("last_Modified_Time");
        Serializable serializable = h16.getSerializable("recommend_feed_detail_data");
        Serializable serializable2 = h16.getSerializable("st_feed_detail_data");
        String string = h16.getString("comment_id");
        if (string == null) {
            str4 = "";
        } else {
            str4 = string;
        }
        String string2 = h16.getString("reply_id");
        if (string2 == null) {
            str5 = "";
        } else {
            str5 = string2;
        }
        List parcelableArrayList = h16.getParcelableArrayList("comment_ids");
        if (parcelableArrayList == null) {
            parcelableArrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new LoadDataArgs("load_data_call_source_init", str, str2, str3, 0, j3, serializable, serializable2, str4, str5, parcelableArrayList, h16.getLong("start_time"), h16.getInt("business_type", 0), false, 8208, null);
    }

    private final LoadDataArgs H9(g.ReloadMessage reloadMessage) {
        int vmIdentifier = reloadMessage.getVmIdentifier();
        if (vmIdentifier != 1) {
            if (vmIdentifier == 2 && (reloadMessage.getPayload() instanceof g.ReloadCommentDataMessage)) {
                LoadDataArgs G9 = G9();
                G9.n("load_data_call_source_init");
                G9.o(((g.ReloadCommentDataMessage) reloadMessage.getPayload()).getType());
                return G9;
            }
            return null;
        }
        LoadDataArgs G92 = G9();
        G92.n("load_data_call_source_init");
        return G92;
    }

    private final void I9(Object args) {
        Boolean bool;
        if (args instanceof Boolean) {
            bool = (Boolean) args;
        } else {
            bool = null;
        }
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            this.isAnimating = booleanValue;
            QLog.d("FeedNativeDetail.ContentContentDataFusionPart", 4, "handleAnimationMessage, isAnimating = " + booleanValue);
            if (!this.isAnimating) {
                F9();
            }
        }
    }

    private final void J9(com.tencent.mobileqq.guild.feed.nativedetail.content.model.x state) {
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    private final void K9(DataChangedState state) {
        for (com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vVar : this.viewModelList) {
            if (vVar.E() || this.isAnimating) {
                QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 1, "isDataPrepared false, vmBlockUpScreen = " + vVar.E() + ", isAnimating = " + this.isAnimating + ", viewModel = " + vVar.getClass().getSimpleName());
                this.animationBlockList.add(state);
                return;
            }
        }
        F9();
        QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 1, "OnDataListChangedMessage source: " + state.getDataChangedSource() + ", payload: " + state.getPayload());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).i());
        }
        broadcastMessage("message_data_list_changed", new g.OnDataListChangedMessage(arrayList, state.getDataChangedSource(), state.getPayload()));
    }

    private final void L9(Object args) {
        Object obj;
        if (!(args instanceof g.UpdateFeedAllowCommentMessage)) {
            return;
        }
        Iterator<T> it = this.viewModelList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) obj) instanceof DetailCommentViewModel) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) obj;
        if (vVar != null) {
            ((DetailCommentViewModel) vVar).s3(((g.UpdateFeedAllowCommentMessage) args).getIsAllowComment());
        }
    }

    private final void M9(Object args) {
        String str;
        String str2;
        String str3;
        if (!(args instanceof g.LoadMoreMessage)) {
            return;
        }
        boolean z16 = this.isFirstLoadingComment.get();
        boolean z17 = this.isReloadingFlags.get(2).get();
        boolean z18 = this.isReloadingFlags.get(1).get();
        QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 1, "handleLoadMoreMessage, isFirstLoading=" + z16 + ", isReloadingFromComment=" + z17 + ", isReloadingFromMain=" + z18);
        if (!z16 && !z17 && !z18) {
            String callSource = ((g.LoadMoreMessage) args).getCallSource();
            String str4 = this.feedId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
                str = null;
            } else {
                str = str4;
            }
            String str5 = this.guildId;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            } else {
                str2 = str5;
            }
            String str6 = this.channelId;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str3 = null;
            } else {
                str3 = str6;
            }
            ca(new LoadDataArgs(callSource, str, str2, str3, 0, 0L, null, null, null, null, null, 0L, 0, false, 16368, null));
        }
    }

    private final void N9(com.tencent.mobileqq.guild.feed.nativedetail.content.model.x state) {
        if (this.isLoadingMore.compareAndSet(true, false)) {
            broadcastMessage(state.getMessage(), state.getMsgObject());
        }
    }

    private final void O9(com.tencent.mobileqq.guild.feed.nativedetail.content.model.x state) {
        if (Intrinsics.areEqual(state.getMessage(), "message_on_load_comment_completed")) {
            this.isFirstLoadingComment.compareAndSet(true, false);
        }
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    private final void P9(com.tencent.mobileqq.guild.feed.nativedetail.content.model.x state) {
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    private final void Q9() {
        LoadDataArgs G9 = G9();
        for (com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vVar : this.viewModelList) {
            if (this.isReloadingFlags.get(vVar.getIdentifier()).compareAndSet(false, true)) {
                vVar.t0(G9);
            }
        }
    }

    private final void R9(Object msg2) {
        if (!(msg2 instanceof g.ReloadMessage)) {
            return;
        }
        g.ReloadMessage reloadMessage = (g.ReloadMessage) msg2;
        QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 4, "handleReloadMessage, callsource=" + reloadMessage.getCallSource() + ", vmIdentifier = " + reloadMessage.getVmIdentifier() + ",  isReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(reloadMessage.getVmIdentifier()));
        if (Intrinsics.areEqual(reloadMessage.getCallSource(), "FeedTipPart") && reloadMessage.getVmIdentifier() == 0) {
            Q9();
            return;
        }
        LoadDataArgs H9 = H9(reloadMessage);
        if (H9 == null) {
            return;
        }
        if (this.isReloadingFlags.get(reloadMessage.getVmIdentifier()).compareAndSet(false, true)) {
            QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 4, "after set, sReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(reloadMessage.getVmIdentifier()));
            broadcastMessage("message_on_reload_begin", new g.OnReloadBeginMessage(reloadMessage.getVmIdentifier()));
            for (com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vVar : this.viewModelList) {
                if (vVar.getIdentifier() == reloadMessage.getVmIdentifier()) {
                    vVar.t0(H9);
                }
            }
        }
        this.isLoadingMore.set(false);
    }

    private final void S9(int source, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x state) {
        QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 4, "handleReloadStateChanged , sReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(source));
        if (this.isReloadingFlags.get(source).compareAndSet(true, false)) {
            QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 4, "handleReloadStateChanged , update false");
        }
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(com.tencent.mobileqq.guild.feed.nativedetail.content.model.u event) {
        Activity activity;
        if (event instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.model.a) {
            Context context = getContext();
            Activity activity2 = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                if (!((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isSplashActivity(activity)) {
                    activity2 = activity;
                }
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    private final void U9() {
        DetailGuildInfoViewModel detailGuildInfoViewModel;
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.content.model.v> listOfNotNull;
        AbsDetailViewModel[] absDetailViewModelArr = new AbsDetailViewModel[3];
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new b(partHost, this)).get(DetailMainViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        absDetailViewModelArr[0] = (AbsDetailViewModel) viewModel;
        if (this.showGuildInfoDetail) {
            IPartHost partHost2 = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost2, "partHost");
            ViewModel viewModel2 = new ViewModelProvider(partHost2, new c(partHost2)).get(DetailGuildInfoViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            detailGuildInfoViewModel = (DetailGuildInfoViewModel) viewModel2;
        } else {
            detailGuildInfoViewModel = null;
        }
        absDetailViewModelArr[1] = detailGuildInfoViewModel;
        IPartHost partHost3 = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost3, "partHost");
        ViewModel viewModel3 = new ViewModelProvider(partHost3, new d(partHost3)).get(DetailCommentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ((DetailCommentViewModel) viewModel3).l2((wk1.h) yl1.n.s(rootView, wk1.h.class));
        Unit unit = Unit.INSTANCE;
        absDetailViewModelArr[2] = (AbsDetailViewModel) viewModel3;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) absDetailViewModelArr);
        this.viewModelList = listOfNotNull;
        for (final com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vVar : listOfNotNull) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            vVar.F1(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.Y9(ContentDataFusionPart.this, (com.tencent.mobileqq.guild.feed.nativedetail.content.model.x) obj);
                }
            });
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
            vVar.N(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.Z9(ContentDataFusionPart.this, (com.tencent.mobileqq.guild.feed.nativedetail.content.model.x) obj);
                }
            });
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
            vVar.b(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.aa(ContentDataFusionPart.this, (com.tencent.mobileqq.guild.feed.nativedetail.content.model.x) obj);
                }
            });
            LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
            vVar.d(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.V9(ContentDataFusionPart.this, (DataChangedState) obj);
                }
            });
            LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "partHost.hostLifecycleOwner");
            vVar.A1(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.W9(ContentDataFusionPart.this, vVar, (com.tencent.mobileqq.guild.feed.nativedetail.content.model.x) obj);
                }
            });
            LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "partHost.hostLifecycleOwner");
            vVar.I(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContentDataFusionPart.X9(ContentDataFusionPart.this, (com.tencent.mobileqq.guild.feed.nativedetail.content.model.x) obj);
                }
            });
            vVar.L(new Function1<com.tencent.mobileqq.guild.feed.nativedetail.content.model.u, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.ContentDataFusionPart$initViewModelList$5$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.feed.nativedetail.content.model.u uVar) {
                    invoke2(uVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.content.model.u it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ContentDataFusionPart.this.T9(it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(ContentDataFusionPart this$0, DataChangedState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.K9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(ContentDataFusionPart this$0, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v vm5, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        int identifier = vm5.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.S9(identifier, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(ContentDataFusionPart this$0, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.J9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ContentDataFusionPart this$0, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.P9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ContentDataFusionPart this$0, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.O9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(ContentDataFusionPart this$0, com.tencent.mobileqq.guild.feed.nativedetail.content.model.x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.N9(it);
    }

    private final void ba(LoadDataArgs loadDataArgs) {
        this.isFirstLoadingComment.compareAndSet(false, true);
        broadcastMessage("message_on_load_data_begin", new g.OnLoadBeginMessage(loadDataArgs.getCallSource()));
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).e1(loadDataArgs);
        }
    }

    private final void ca(LoadDataArgs loadDataArgs) {
        if (this.isLoadingMore.compareAndSet(false, true)) {
            QLog.i("FeedNativeDetail.ContentContentDataFusionPart", 1, "do loadMore");
            broadcastMessage("message_on_load_more_begin", new g.OnLoadMoreBeginMessage(loadDataArgs.getCallSource()));
            Iterator<T> it = this.viewModelList.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).s(loadDataArgs);
            }
        }
    }

    private final void da(LoadDataArgs loadDataArgs) {
        broadcastMessage("message_on_pre_load_begin", new g.OnPreloadBeginMessage(loadDataArgs.getCallSource()));
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).y1(loadDataArgs);
        }
    }

    private final void initData() {
        Bundle h16 = GuildSplitViewUtils.f235370a.h(getPartHost());
        String string = h16.getString("feed_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(NativeDetailConstants.FEED_ID, \"\")");
        this.feedId = string;
        String string2 = h16.getString("guild_id", "");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(NativeDetailConstants.GUILD_ID, \"\")");
        this.guildId = string2;
        String string3 = h16.getString("channel_id", "");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(NativeDetailConstants.CHANNEL_ID, \"\")");
        this.channelId = string3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            Object a06 = ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).a0(action, args);
            if (a06 != null) {
                return a06;
            }
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            switch (action.hashCode()) {
                case -35842170:
                    if (action.equals("message_update_feed_allow_comment")) {
                        L9(args);
                        return;
                    }
                    break;
                case 966244561:
                    if (action.equals("message_reload")) {
                        R9(args);
                        return;
                    }
                    break;
                case 1534930134:
                    if (action.equals("message_load_more")) {
                        M9(args);
                        return;
                    }
                    break;
                case 1583791999:
                    if (action.equals("message_on_animation_ing")) {
                        I9(args);
                        return;
                    }
                    break;
            }
        }
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).c(action, args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
        U9();
        LoadDataArgs G9 = G9();
        G9.n("load_data_call_source_init");
        G9.o(1);
        da(G9);
        ba(G9);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        Iterator<T> it = this.viewModelList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.content.model.v) it.next()).onDestroy();
        }
    }

    public /* synthetic */ ContentDataFusionPart(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
