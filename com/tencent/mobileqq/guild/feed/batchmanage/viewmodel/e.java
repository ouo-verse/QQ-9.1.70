package com.tencent.mobileqq.guild.feed.batchmanage.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.feed.batchmanage.b;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedsFilter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ij1.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 e2\u00020\u0001:\u0001fB\u0007\u00a2\u0006\u0004\bc\u0010dJ<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002JD\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J@\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J4\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0002J0\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J8\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001c\u0010\u001d\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010 \u001a\u00020\fJ,\u0010'\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020%\u0018\u00010$J\u0016\u0010*\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010)\u001a\u00020(J\u0016\u0010+\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010,\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010\b\u001a\u00020\u0004R\u0016\u0010/\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020%0\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010.R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020%0\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010CR&\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR*\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010V\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010.\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR#\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0W0E8\u0006\u00a2\u0006\f\n\u0004\bY\u0010G\u001a\u0004\bZ\u0010[R%\u0010`\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0018\u00010]8F\u00a2\u0006\u0006\u001a\u0004\b^\u0010_R%\u0010b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0018\u00010]8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010_\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e;", "Landroidx/lifecycle/ViewModel;", "", "sortMode", "", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "forceScrollTop", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "notificationItem", "", "e2", "isFinish", "k2", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "data", "usePreData", "newFeedList", "Ljava/lang/Runnable;", "extraTask", "m2", "i2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;", "c2", "j2", "l2", "isCacheRsp", SemanticAttributes.DbSystemValues.H2, FeedManager.LOAD_MORE, "", "guildId", "channelId", "", "", "hashMap", "g2", "Lwh2/br;", "callback", "W1", "X1", "U1", "i", "Ljava/lang/String;", "mGuildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mChannelID", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "feedListDataRepo", "D", "mChannelAttachInfo", "E", "I", "mSortMode", UserInfo.SEX_FEMALE, "Ljava/util/List;", "mChannelFeedList", "G", "mFeedAttachInfo", "H", "mFeedRespFeedList", "", "[B", "mFeedToken", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "feedsListData", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "K", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Z1", "()Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "q2", "(Lcom/tencent/richframework/data/idata/IDataDisplaySurface;)V", "feedListDataDisplaySurface", "L", "getFeedListSourceDataType", "()Ljava/lang/String;", "r2", "(Ljava/lang/String;)V", "feedListSourceDataType", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "M", "getFeedSectionData", "()Landroidx/lifecycle/MutableLiveData;", "feedSectionData", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "mFeedListData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "feedListUIState", "<init>", "()V", "N", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends ViewModel {

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private IDataDisplaySurface<g> feedListDataDisplaySurface;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String feedListSourceDataType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mChannelID = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedListDataRepo feedListDataRepo = new GuildFeedListDataRepo("GuildFeedBatchManageViewModel", -1);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mChannelAttachInfo = "";

    /* renamed from: E, reason: from kotlin metadata */
    private int mSortMode = 3;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<Object> mChannelFeedList = new CopyOnWriteArrayList();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mFeedAttachInfo = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<Object> mFeedRespFeedList = new CopyOnWriteArrayList();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private byte[] mFeedToken = new byte[0];

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<g>>> feedsListData = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<IGProCategoryChannelInfoList>> feedSectionData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e$b", "Lqx1/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/a;", "rsp", "", "f", "", "result", "", "errMsg", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.a> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> f218319b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f218320c;

        b(GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar, boolean z16) {
            this.f218319b = bVar;
            this.f218320c = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int result, @Nullable String errMsg, @Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.a rsp) {
            List arrayList;
            e eVar = e.this;
            UIStateData loadMore = UIStateData.obtainError(errMsg).setRetCode(result).setType(e.this.mSortMode).setLoadMore(this.f218320c);
            UIStateData uIStateData = (UIStateData) e.this.feedsListData.getValue();
            if (uIStateData == null || (arrayList = (List) uIStateData.getData()) == null) {
                arrayList = new ArrayList();
            }
            UIStateData dataList = loadMore.setDataList(arrayList);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainError<MutableList<\u2026.data ?: mutableListOf())");
            eVar.l2(dataList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.a rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            e.this.c2(this.f218319b.getSortMode(), rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), rsp.getGProGetChannelFeedsRsp(), this.f218319b.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), !this.f218320c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e$c", "Lqx1/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/b;", "rsp", "", "f", "", "result", "", "errMsg", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedListDataRepo.b<GProGetGuildFeedsReq> f218322b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f218323c;

        c(GuildFeedListDataRepo.b<GProGetGuildFeedsReq> bVar, boolean z16) {
            this.f218322b = bVar;
            this.f218323c = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int result, @Nullable String errMsg, @Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.b rsp) {
            List arrayList;
            e eVar = e.this;
            UIStateData loadMore = UIStateData.obtainError(errMsg).setRetCode(result).setType(e.this.mSortMode).setLoadMore(this.f218323c);
            UIStateData uIStateData = (UIStateData) e.this.feedsListData.getValue();
            if (uIStateData == null || (arrayList = (List) uIStateData.getData()) == null) {
                arrayList = new ArrayList();
            }
            UIStateData dataList = loadMore.setDataList(arrayList);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainError<MutableList<\u2026.data ?: mutableListOf())");
            eVar.l2(dataList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.b rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            e eVar = e.this;
            eVar.e2(eVar.mSortMode, rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), rsp.getGProGetGuildFeedsRsp(), this.f218322b.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), !this.f218323c, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e$d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", Const.BUNDLE_KEY_REQUEST, "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements GuildFeedListDataRepo.b.a<GProGetGuildFeedsReq> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull GProGetGuildFeedsReq request) {
            Intrinsics.checkNotNullParameter(request, "request");
            GProGuildFeedsFilter gProGuildFeedsFilter = request.filter;
            gProGuildFeedsFilter.needHasFeedFlag = false;
            gProGuildFeedsFilter.needAdv = false;
            gProGuildFeedsFilter.needSum = false;
            gProGuildFeedsFilter.needLive = false;
            gProGuildFeedsFilter.needVoice = false;
            gProGuildFeedsFilter.needHeadAdv = false;
            gProGuildFeedsFilter.needScheduler = false;
            gProGuildFeedsFilter.needSysMsg = false;
            gProGuildFeedsFilter.needTopInfo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(final int sortMode, final boolean isCache, final GProStGetChannelFeedsRsp rsp, final boolean isLoadMore, final boolean forceScrollTop) {
        Integer num;
        if (h2(isCache, sortMode)) {
            return;
        }
        if (rsp != null) {
            num = Integer.valueOf(rsp.isFinish);
        } else {
            num = null;
        }
        QLog.d("GuildFeedBatchManageViewModel", 1, "[handleGetFeedListRsp] sortMode=" + sortMode + ", isCache=" + isCache + ", isFinish=" + num);
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                e.d2(isLoadMore, this, rsp, isCache, sortMode, forceScrollTop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(boolean z16, e this$0, GProStGetChannelFeedsRsp rsp, boolean z17, int i3, boolean z18) {
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        if (!z16) {
            this$0.mChannelFeedList.clear();
        }
        String str = rsp.feedAttchInfo;
        if (str != null && str.length() != 0) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (!z19) {
            String str2 = rsp.feedAttchInfo;
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.feedAttchInfo");
            this$0.mChannelAttachInfo = str2;
        }
        if (rsp.isFinish > 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        this$0.j2(rsp, z16, z17, z26, i3, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(final int sortMode, final boolean isCache, final GProGetGuildFeedsRsp rsp, final boolean isLoadMore, final boolean forceScrollTop, final GuildInteractiveNotificationItem notificationItem) {
        Integer num;
        if (h2(isCache, sortMode)) {
            return;
        }
        if (rsp != null) {
            num = Integer.valueOf(rsp.isFinish);
        } else {
            num = null;
        }
        QLog.d("GuildFeedBatchManageViewModel", 1, "[FeedsLoad] [handleGetFeedListRsp] sortMode=" + sortMode + ", isCache=" + isCache + ", isFinish=" + num);
        this.mSortMode = sortMode;
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.a
            @Override // java.lang.Runnable
            public final void run() {
                e.f2(isLoadMore, this, rsp, isCache, sortMode, forceScrollTop, notificationItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(boolean z16, e this$0, GProGetGuildFeedsRsp gProGetGuildFeedsRsp, boolean z17, int i3, boolean z18, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.mFeedRespFeedList.clear();
        }
        if (gProGetGuildFeedsRsp != null) {
            String str = gProGetGuildFeedsRsp.feedAttchInfo;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.feedAttchInfo");
            this$0.mFeedAttachInfo = str;
        }
        if (gProGetGuildFeedsRsp != null) {
            byte[] bArr = gProGetGuildFeedsRsp.token;
            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.token");
            this$0.mFeedToken = bArr;
        }
        boolean z19 = true;
        if (gProGetGuildFeedsRsp != null && gProGetGuildFeedsRsp.isFinish <= 0) {
            z19 = false;
        }
        this$0.k2(gProGetGuildFeedsRsp, z16, z17, z19, i3, z18, guildInteractiveNotificationItem);
    }

    private final boolean h2(boolean isCacheRsp, int sortMode) {
        boolean z16;
        List<g> data;
        if (isCacheRsp) {
            UIStateData<List<g>> value = this.feedsListData.getValue();
            if (value != null && (data = value.getData()) != null && (!data.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final void i2(boolean usePreData, List<g> newFeedList, UIStateData<List<g>> data) {
        List<g> list;
        UIStateData<List<g>> value = this.feedsListData.getValue();
        if (value != null) {
            list = value.getData();
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (usePreData && list != null) {
            List<g> list2 = list;
            if (!list2.isEmpty()) {
                arrayList.addAll(list2);
            }
        }
        if (newFeedList != null) {
            List<g> list3 = newFeedList;
            if (!list3.isEmpty()) {
                arrayList.addAll(list3);
            }
        }
        data.setDataList(arrayList);
        if (newFeedList != null && arrayList.size() == 0) {
            data.setState(0);
        }
        this.feedListDataDisplaySurface = null;
        this.feedsListData.setValue(data);
    }

    private final void j2(GProStGetChannelFeedsRsp rsp, boolean isLoadMore, boolean isCache, boolean isFinish, int sortMode, boolean forceScrollTop) {
        ArrayList<g> c16 = ij1.c.c(rsp.vecFeedList, rsp.traceId);
        if (c16 == null) {
            c16 = new ArrayList<>();
        }
        ArrayList<g> arrayList = c16;
        int i3 = 0;
        QLog.d("GuildFeedBatchManageViewModel", 1, "[postFeedData] transForm size:" + arrayList.size() + ", isLoadMore: " + isLoadMore, ", trace_id=" + rsp.traceId);
        jj1.b.c().initOrUpdateGlobalState((List) rsp.vecFeedList, true);
        List<Object> list = this.mChannelFeedList;
        ArrayList<GProStFeed> arrayList2 = rsp.vecFeedList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.vecFeedList");
        list.addAll(arrayList2);
        if (arrayList.isEmpty() && !isLoadMore) {
            UIStateData<List<g>> finish = UIStateData.obtainEmpty().setType(sortMode).setFinish(isFinish);
            Intrinsics.checkNotNullExpressionValue(finish, "obtainEmpty<MutableList<\u2026     .setFinish(isFinish)");
            l2(finish);
        } else {
            UIStateData type = UIStateData.obtainSuccess(isCache).setData(isLoadMore, arrayList).setType(sortMode);
            if (!forceScrollTop) {
                i3 = -1;
            }
            UIStateData finish2 = type.setPos(i3).setFinish(isFinish);
            Intrinsics.checkNotNullExpressionValue(finish2, "obtainSuccess<MutableLis\u2026     .setFinish(isFinish)");
            n2(this, finish2, isLoadMore, arrayList, null, 8, null);
        }
    }

    private final void k2(GProGetGuildFeedsRsp rsp, boolean isLoadMore, boolean isCache, boolean isFinish, int sortMode, boolean forceScrollTop, GuildInteractiveNotificationItem notificationItem) {
        if (rsp == null) {
            return;
        }
        ArrayList<g> c16 = ij1.c.c(rsp.vecFeedList, rsp.traceId);
        if (c16 == null) {
            c16 = new ArrayList<>();
        }
        ArrayList<g> arrayList = c16;
        int i3 = 0;
        QLog.d("GuildFeedBatchManageViewModel", 1, "[postFeedData] transForm size:" + arrayList.size() + ", isLoadMore: " + isLoadMore, ", trace_id=" + rsp.traceId);
        jj1.b.c().initOrUpdateGlobalState((List) rsp.vecFeedList, true);
        List<Object> list = this.mFeedRespFeedList;
        ArrayList<GProStFeed> arrayList2 = rsp.vecFeedList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.vecFeedList");
        list.addAll(arrayList2);
        if (arrayList.isEmpty() && !isLoadMore) {
            UIStateData<List<g>> finish = UIStateData.obtainEmpty().setType(sortMode).setFinish(isFinish);
            Intrinsics.checkNotNullExpressionValue(finish, "obtainEmpty<MutableList<\u2026     .setFinish(isFinish)");
            l2(finish);
        } else {
            UIStateData data = UIStateData.obtainSuccess(isCache).setData(isLoadMore, arrayList);
            if (!forceScrollTop) {
                i3 = -1;
            }
            UIStateData finish2 = data.setPos(i3).setType(sortMode).setFinish(isFinish);
            Intrinsics.checkNotNullExpressionValue(finish2, "obtainSuccess<MutableLis\u2026     .setFinish(isFinish)");
            n2(this, finish2, isLoadMore, arrayList, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(final UIStateData<List<g>> data) {
        QLog.d("GuildFeedBatchManageViewModel", 1, "postFeedInMain " + data);
        this.feedListDataDisplaySurface = null;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                e.p2(e.this, data);
            }
        });
    }

    private final void m2(final UIStateData<List<g>> data, final boolean usePreData, final List<g> newFeedList, final Runnable extraTask) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                e.o2(e.this, usePreData, newFeedList, data, extraTask);
            }
        });
    }

    static /* synthetic */ void n2(e eVar, UIStateData uIStateData, boolean z16, List list, Runnable runnable, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            runnable = null;
        }
        eVar.m2(uIStateData, z16, list, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(e this$0, boolean z16, List list, UIStateData data, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.i2(z16, list, data);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(e this$0, UIStateData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.feedsListData.setValue(data);
    }

    public final void U1(@NotNull String guildId, @NotNull String channelId, boolean isLoadMore) {
        String str;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.mChannelID = channelId;
        int i3 = this.mSortMode;
        if (isLoadMore) {
            str = this.mChannelAttachInfo;
        } else {
            str = "";
        }
        GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar = new GuildFeedListDataRepo.b<>(guildId, channelId, "", i3, isLoadMore, false, str, "", null, 0, null, 0L, null, 7936, null);
        QLog.d("GuildFeedBatchManageViewModel", 1, " getChannelData " + bVar);
        this.feedListDataRepo.k(bVar, new b(bVar, isLoadMore));
    }

    public final void W1(@NotNull String guildId, @NotNull br callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(guildId));
        bdVar.h(false);
        bdVar.j(false);
        bdVar.i(true);
        ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, callback);
    }

    public final void X1(@NotNull String guildId, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        String str = "";
        this.mChannelID = "";
        int i3 = this.mSortMode;
        if (isLoadMore) {
            str = this.mFeedAttachInfo;
        }
        GuildFeedListDataRepo.b<GProGetGuildFeedsReq> bVar = new GuildFeedListDataRepo.b<>(guildId, "", "", i3, isLoadMore, false, str, "", null, 0, "", 0L, new d(), 2048, null);
        QLog.d("GuildFeedBatchManageViewModel", 1, " getFeedData " + bVar);
        this.feedListDataRepo.l(bVar, new c(bVar, isLoadMore));
    }

    @Nullable
    public final IDataDisplaySurface<g> Z1() {
        return this.feedListDataDisplaySurface;
    }

    @Nullable
    public final LiveData<UIStateData<List<g>>> a2() {
        MutableLiveData<UIStateData<List<g>>> mutableLiveData;
        UIStateData<List<g>> value;
        UIStateData<List<g>> value2;
        List<g> data;
        IDataDisplaySurface<g> iDataDisplaySurface = this.feedListDataDisplaySurface;
        ArrayList arrayList = null;
        if (iDataDisplaySurface != null) {
            mutableLiveData = iDataDisplaySurface.getDisplaySurfaceData(this.feedListSourceDataType);
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null && (value2 = mutableLiveData.getValue()) != null && (data = value2.getData()) != null) {
            arrayList = new ArrayList();
            for (Object obj : data) {
                g it = (g) obj;
                b.Companion companion = com.tencent.mobileqq.guild.feed.batchmanage.b.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (companion.a(it)) {
                    arrayList.add(obj);
                }
            }
        }
        if (mutableLiveData != null && (value = mutableLiveData.getValue()) != null) {
            value.setDataList(arrayList);
        }
        return mutableLiveData;
    }

    @Nullable
    public final LiveData<UIStateData<List<g>>> b2() {
        return this.feedsListData;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g2(@NotNull String guildId, @NotNull String channelId, @Nullable Map<String, ? extends Object> hashMap) {
        String str;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.mGuildId = guildId;
        this.mChannelID = channelId;
        LiveData<UIStateData<List<g>>> a26 = a2();
        if (a26 != null) {
            this.feedsListData.setValue(a26.getValue());
        }
        if (hashMap == null) {
            return;
        }
        Object obj = hashMap.get("attachInfo");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        boolean z18 = false;
        if (str != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    if (this.mChannelID.length() > 0) {
                        z18 = true;
                    }
                    if (z18 && !Intrinsics.areEqual(this.mChannelID, "0")) {
                        this.mChannelAttachInfo = str;
                    } else {
                        this.mFeedAttachInfo = str;
                    }
                }
                QLog.d("GuildFeedBatchManageViewModel", 1, "init mGuildId=" + this.mGuildId + " ,mChannelId=" + this.mChannelID);
            }
        }
        z16 = false;
        if (z16) {
        }
        QLog.d("GuildFeedBatchManageViewModel", 1, "init mGuildId=" + this.mGuildId + " ,mChannelId=" + this.mChannelID);
    }

    public final void loadMore() {
        boolean z16;
        QLog.d("GuildFeedBatchManageViewModel", 1, FeedManager.LOAD_MORE);
        UIStateData<List<g>> value = this.feedsListData.getValue();
        boolean z17 = false;
        if (value != null && value.isLoading()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("GuildFeedBatchManageViewModel", 1, "isLoading Ignore");
            return;
        }
        if (this.mChannelID.length() == 0) {
            z17 = true;
        }
        if (!z17 && !Intrinsics.areEqual(this.mChannelID, "0")) {
            U1(this.mGuildId, this.mChannelID, true);
        } else {
            X1(this.mGuildId, true);
        }
    }

    public final void q2(@Nullable IDataDisplaySurface<g> iDataDisplaySurface) {
        this.feedListDataDisplaySurface = iDataDisplaySurface;
    }

    public final void r2(@Nullable String str) {
        this.feedListSourceDataType = str;
    }
}
