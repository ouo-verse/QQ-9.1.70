package com.tencent.mobileqq.guild.feed.viewmodel.notice;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteInteractReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUPdateFeedInteractSwitchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllFeedNoticesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.sdk.util.UinConfigManager;
import ij1.p;
import ij1.s;
import ij1.t;
import ij1.u;
import ij1.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ui1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ(\u0010\u0007\u001a\u00020\u00062\u001e\u0010\u0005\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003`\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u001a\u001a\u00020\b*\u00020\bH\u0002J\u0014\u0010\u001b\u001a\u00020\b*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J(\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010 \u001a\u00020\u00062\u0016\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001e0\u001dH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0016J \u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\b\b\u0002\u0010%\u001a\u00020\u0016J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000eJ\u0016\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u0006J\b\u0010,\u001a\u00020\u0006H\u0014R*\u00100\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001e0\u001d0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R!\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001e8\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR'\u0010N\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001e0\u001d0-8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/viewmodel/notice/GuildVisitorNoticeViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Ljava/util/ArrayList;", "Lij1/v;", "Lkotlin/collections/ArrayList;", "toAppendList", "", "e2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "notices", "i2", UinConfigManager.KEY_ADS, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDeleteInteractReq;", "P1", "", "result", "", "msg", "blockData", "c2", "R1", "feedId", "", "isReceive", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUPdateFeedInteractSwitchReq;", "Q1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "f2", "d2", "Lcom/tencent/richframework/data/base/UIStateData;", "", "data", "g2", "j2", "getLogTag", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, VideoProxy.PARAM_ENABLE_CACHE, "isRefresh", "U1", "position", "S1", "k2", FeedManager.LOAD_MORE, "refresh", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_uIStateStNotices", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "Z1", "()Ljava/util/List;", "messageBlockData", "Lij1/t;", BdhLogUtil.LogTag.Tag_Conn, "Lij1/t;", "startBlockData", "Lij1/s;", "D", "Lij1/s;", "endBlockData", "Ljava/util/TreeSet;", "E", "Ljava/util/TreeSet;", "guildIdSets", UserInfo.SEX_FEMALE, "I", "unReadCnt", "G", "Ljava/lang/String;", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "attachInfo", "b2", "()Landroidx/lifecycle/MutableLiveData;", "uIStateStNotices", "<init>", "()V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildVisitorNoticeViewModel extends BaseViewModel {

    /* renamed from: F, reason: from kotlin metadata */
    private int unReadCnt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<v<?>>>> _uIStateStNotices = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<v<?>> messageBlockData = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final t startBlockData = new t("\u65b0\u6d88\u606f");

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final s endBlockData = new s("\u65b0\u6d88\u606f\u7ed3\u675f");

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TreeSet<String> guildIdSets = new TreeSet<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String attachInfo = "";

    private final GProDeleteInteractReq P1(GProStNotice notice) {
        GProDeleteInteractReq gProDeleteInteractReq = new GProDeleteInteractReq();
        gProDeleteInteractReq.psvFeedId = notice.psvFeed.idd;
        return gProDeleteInteractReq;
    }

    private final GProUPdateFeedInteractSwitchReq Q1(String feedId, boolean isReceive) {
        int i3;
        GProUPdateFeedInteractSwitchReq gProUPdateFeedInteractSwitchReq = new GProUPdateFeedInteractSwitchReq();
        gProUPdateFeedInteractSwitchReq.feedId = feedId;
        if (isReceive) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        gProUPdateFeedInteractSwitchReq.operateType = i3;
        return gProUPdateFeedInteractSwitchReq;
    }

    private final int R1() {
        int indexOf = this.messageBlockData.indexOf(this.startBlockData);
        int indexOf2 = this.messageBlockData.indexOf(this.endBlockData);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 - indexOf > 1) {
            return -1;
        }
        this.messageBlockData.remove(indexOf2);
        this.messageBlockData.remove(indexOf);
        return indexOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(GuildVisitorNoticeViewModel this$0, int i3, int i16, String msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        this$0.c2(i16, msg2, this$0.messageBlockData.get(i3));
    }

    public static /* synthetic */ void W1(GuildVisitorNoticeViewModel guildVisitorNoticeViewModel, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z18 = false;
        }
        guildVisitorNoticeViewModel.U1(z16, z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(GuildVisitorNoticeViewModel this$0, boolean z16, boolean z17, int i3, String errMsg, boolean z18, int i16, GProGetFeedNoticesRsp rsp) {
        boolean z19;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Logger logger = Logger.f235387a;
        String tag = this$0.getTAG();
        logger.d().d(tag, 1, "getNotices " + i3 + " " + errMsg + " rs " + rsp.notices.size() + ", unreadCnt:" + i16);
        if (!z16 && i3 == 0) {
            ArrayList<GProStNotice> arrayList = rsp.notices;
            if (arrayList != null && !arrayList.isEmpty()) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                UIStateData<List<v<?>>> loadMore = UIStateData.obtainEmpty().setRetCode(i3).setLoadMore(z16);
                Intrinsics.checkNotNullExpressionValue(loadMore, "obtainEmpty<MutableList<\u2026).setLoadMore(isLoadMore)");
                this$0.g2(loadMore);
                return;
            }
        }
        if (i3 == 0) {
            String str = rsp.attachInfo;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.attachInfo");
            this$0.attachInfo = str;
            if (z17) {
                this$0.messageBlockData.clear();
            }
            ArrayList<v<?>> validBlockDataList = ij1.c.e(rsp.notices);
            if (!z16) {
                this$0.unReadCnt = i16;
                this$0.j2();
                if (this$0.unReadCnt > 0) {
                    validBlockDataList.add(0, this$0.startBlockData);
                    if (this$0.unReadCnt + 1 <= validBlockDataList.size()) {
                        validBlockDataList.add(this$0.unReadCnt + 1, this$0.endBlockData);
                    }
                }
                validBlockDataList.add(0, new u("\u4ee5\u4e0b\u662f\u6765\u81ea\u672a\u52a0\u5165\u9891\u9053\u7684\u4e92\u52a8\u6d88\u606f"));
                this$0.messageBlockData.clear();
            } else {
                Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
                this$0.e2(validBlockDataList);
            }
            List<v<?>> list = this$0.messageBlockData;
            Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
            list.addAll(validBlockDataList);
            if ((!validBlockDataList.isEmpty()) && rsp.isFinish) {
                this$0.messageBlockData.add(new p("\u6682\u65e0\u66f4\u591a\u5185\u5bb9"));
            }
            UIStateData<List<v<?>>> finish = UIStateData.obtainSuccess(z18).setData(z16, this$0.messageBlockData).setFinish(rsp.isFinish);
            Intrinsics.checkNotNullExpressionValue(finish, "obtainSuccess<MutableLis\u2026ish(rsp.isFinish ?: true)");
            this$0.g2(finish);
            ArrayList<GProStNotice> arrayList2 = rsp.notices;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.notices");
            this$0.i2(arrayList2);
            return;
        }
        UIStateData<List<v<?>>> loadMore2 = UIStateData.obtainError(errMsg).setRetCode(i3).setLoadMore(z16);
        Intrinsics.checkNotNullExpressionValue(loadMore2, "obtainError<MutableList<\u2026).setLoadMore(isLoadMore)");
        this$0.g2(loadMore2);
    }

    private final GProStNotice a2(GProStNotice gProStNotice) {
        GProStNotice gProStNotice2 = new GProStNotice();
        gProStNotice2.origineFeed = gProStNotice.origineFeed;
        gProStNotice2.psvFeed = gProStNotice.psvFeed;
        gProStNotice2.pattonInfo = gProStNotice.pattonInfo;
        gProStNotice2.datongType = gProStNotice.datongType;
        gProStNotice2.type = gProStNotice.type;
        gProStNotice2.status = gProStNotice.status;
        gProStNotice2.guildNumber = gProStNotice.guildNumber;
        gProStNotice2.isCloseInteract = gProStNotice.isCloseInteract;
        return gProStNotice2;
    }

    private final void c2(int result, String msg2, v<?> blockData) {
        boolean z16 = true;
        if (result == 0) {
            List<v<?>> list = this.messageBlockData;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((v) obj) instanceof ij1.a) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            boolean z17 = false;
            if (size <= 1) {
                this.messageBlockData.clear();
                UIStateData<List<v<?>>> finish = UIStateData.obtainEmpty().setDataList(this.messageBlockData).setLoadMore(false).setFinish(true);
                Intrinsics.checkNotNullExpressionValue(finish, "obtainEmpty<MutableList<\u2026         .setFinish(true)");
                g2(finish);
                return;
            }
            int indexOf = this.messageBlockData.indexOf(blockData);
            this.messageBlockData.remove(blockData);
            int R1 = R1();
            if (R1 != -1) {
                indexOf = Math.min(indexOf, R1);
            }
            UIStateData dataList = UIStateData.obtainDelete().setDataList(this.messageBlockData);
            UIStateData<List<v<?>>> value = this._uIStateStNotices.getValue();
            if (value != null) {
                z17 = value.getIsLoadMore();
            }
            UIStateData loadMore = dataList.setLoadMore(z17);
            UIStateData<List<v<?>>> value2 = this._uIStateStNotices.getValue();
            if (value2 != null) {
                z16 = value2.getIsFinish();
            }
            UIStateData<List<v<?>>> pos = loadMore.setFinish(z16).setPos(indexOf);
            Intrinsics.checkNotNullExpressionValue(pos, "obtainDelete<MutableList\u2026        .setPos(position)");
            g2(pos);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "deleteNotice fail--result:" + result + "," + msg2;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildVisitorNoticeViewModel", 1, (String) it.next(), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d2(final int result, final String msg2, String feedId, boolean isReceive) {
        int collectionSizeOrDefault;
        List filterNotNull;
        GProStNotice gProStNotice;
        GProStNotice gProStNotice2;
        String str;
        Integer num;
        GProStFeed gProStFeed;
        boolean z16 = true;
        if (result == 0) {
            List<v<?>> list = this.messageBlockData;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            boolean z17 = false;
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T b16 = ((v) obj).b();
                if (b16 instanceof GProStNotice) {
                    gProStNotice2 = (GProStNotice) b16;
                } else {
                    gProStNotice2 = null;
                }
                if (gProStNotice2 != null && (gProStFeed = gProStNotice2.origineFeed) != null) {
                    str = gProStFeed.idd;
                } else {
                    str = null;
                }
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildVisitorNoticeViewModel", "feedId:" + feedId + ",curFeedId:" + str);
                }
                if (Intrinsics.areEqual(str, feedId)) {
                    num = Integer.valueOf(i3);
                } else {
                    num = null;
                }
                arrayList.add(num);
                i3 = i16;
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                Object b17 = this.messageBlockData.get(intValue).b();
                if (b17 instanceof GProStNotice) {
                    gProStNotice = (GProStNotice) b17;
                } else {
                    gProStNotice = null;
                }
                if (gProStNotice != null) {
                    this.messageBlockData.set(intValue, new ij1.a(f2(gProStNotice, isReceive)));
                }
            }
            UIStateData dataList = UIStateData.obtainModify().setDataList(this.messageBlockData);
            UIStateData<List<v<?>>> value = this._uIStateStNotices.getValue();
            if (value != null) {
                z17 = value.getIsLoadMore();
            }
            UIStateData loadMore = dataList.setLoadMore(z17);
            UIStateData<List<v<?>>> value2 = this._uIStateStNotices.getValue();
            if (value2 != null) {
                z16 = value2.getIsFinish();
            }
            UIStateData<List<v<?>>> pos = loadMore.setFinish(z16).setPos(-1);
            Intrinsics.checkNotNullExpressionValue(pos, "obtainModify<MutableList\u2026              .setPos(-1)");
            g2(pos);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "[handleSwitchReceiveNotificationRsp fail]--result:" + result + ",msg:" + msg2 + "]";
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it5 = bVar.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("GuildVisitorNoticeViewModel", 1, (String) it5.next(), null);
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.GuildVisitorNoticeViewModel$handleSwitchReceiveNotificationRsp$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final void e2(ArrayList<v<?>> toAppendList) {
        int i3;
        if (!this.messageBlockData.isEmpty() && (i3 = this.unReadCnt) != 0) {
            int i16 = i3 + 2;
            int size = this.messageBlockData.size();
            if (i16 < size && (this.messageBlockData.get(i16) instanceof s)) {
                return;
            }
            int size2 = toAppendList.size() + size;
            if (i16 >= size && i16 <= size2) {
                QLog.i("GuildVisitorNoticeViewModel", 2, "endItemPosition:" + i16 + " totalSize:" + size2);
                toAppendList.add(i16 - size, new s("\u65b0\u6d88\u606f\u7ed3\u675f"));
            }
        }
    }

    private final GProStNotice f2(GProStNotice gProStNotice, boolean z16) {
        GProStNotice a26 = a2(gProStNotice);
        a26.isCloseInteract = !z16;
        return a26;
    }

    private final void g2(final UIStateData<List<v<?>>> data) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildVisitorNoticeViewModel.h2(GuildVisitorNoticeViewModel.this, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(GuildVisitorNoticeViewModel this$0, UIStateData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0._uIStateStNotices.setValue(data);
    }

    private final void i2(ArrayList<GProStNotice> notices) {
        Iterator<GProStNotice> it = notices.iterator();
        while (it.hasNext()) {
            GProStNotice item = it.next();
            TreeSet<String> treeSet = this.guildIdSets;
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (!treeSet.contains(g.b(item))) {
                GuildMainFrameUtils.l(g.b(item), true, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.GuildVisitorNoticeViewModel$refreshGuild$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                        invoke2(iGProGuildInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                        if (iGProGuildInfo == null) {
                            QLog.e(GuildVisitorNoticeViewModel.this.getTAG(), 1, "fetchGuildInfoAnyway guildInfo is null.");
                        }
                    }
                });
            }
            this.guildIdSets.add(g.b(item));
        }
    }

    private final void j2() {
        QLog.i("GuildVisitorNoticeViewModel", 2, "reportRead -- type:10");
        GuildNoticeKtKt.b("", 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(GuildVisitorNoticeViewModel this$0, GProStNotice notice, boolean z16, int i3, String msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(notice, "$notice");
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        String str = notice.origineFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "notice.origineFeed.idd");
        this$0.d2(i3, msg2, str, z16);
    }

    public final void S1(final int position) {
        GProStNotice gProStNotice;
        o c16;
        if (position >= 0 && position < this.messageBlockData.size()) {
            QLog.i("GuildVisitorNoticeViewModel", 2, "deleteNotice position:" + position);
            Object b16 = this.messageBlockData.get(position).b();
            if (b16 instanceof GProStNotice) {
                gProStNotice = (GProStNotice) b16;
            } else {
                gProStNotice = null;
            }
            if (gProStNotice != null && (c16 = l.c()) != null) {
                c16.deleteFeedInteractNotice(P1(gProStNotice), new IGProDeleteFeedInteractNoticeCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.c
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback
                    public final void onResult(int i3, String str) {
                        GuildVisitorNoticeViewModel.T1(GuildVisitorNoticeViewModel.this, position, i3, str);
                    }
                });
            }
        }
    }

    public final void U1(final boolean isLoadMore, boolean enableCache, final boolean isRefresh) {
        GProGetFeedNoticesReq gProGetFeedNoticesReq = new GProGetFeedNoticesReq();
        gProGetFeedNoticesReq.pageNum = 10;
        if (isLoadMore && !TextUtils.isEmpty(this.attachInfo)) {
            gProGetFeedNoticesReq.attachInfo = this.attachInfo;
        }
        o c16 = l.c();
        if (c16 != null) {
            c16.getAllFeedNotices(gProGetFeedNoticesReq, enableCache, new IGProGetAllFeedNoticesCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllFeedNoticesCallback
                public final void onResult(int i3, String str, boolean z16, int i16, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
                    GuildVisitorNoticeViewModel.X1(GuildVisitorNoticeViewModel.this, isLoadMore, isRefresh, i3, str, z16, i16, gProGetFeedNoticesRsp);
                }
            });
        }
    }

    @NotNull
    public final List<v<?>> Z1() {
        return this.messageBlockData;
    }

    @NotNull
    public final MutableLiveData<UIStateData<List<v<?>>>> b2() {
        return this._uIStateStNotices;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildVisitorNoticeViewModel";
    }

    public final void k2(int position, final boolean isReceive) {
        final GProStNotice gProStNotice;
        if (position >= 0 && position < this.messageBlockData.size()) {
            Logger.f235387a.d().d("GuildVisitorNoticeViewModel", 1, "switchReceiveFeedNotification position:" + position + ",isReceive:" + isReceive);
            Object b16 = this.messageBlockData.get(position).b();
            if (b16 instanceof GProStNotice) {
                gProStNotice = (GProStNotice) b16;
            } else {
                gProStNotice = null;
            }
            if (gProStNotice == null) {
                Logger.b bVar = new Logger.b();
                String str = "switchReceiveFeedNotification notice is null--position:" + position + ",data:" + Z1().get(position).b();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildVisitorNoticeViewModel", 1, (String) it.next(), null);
                }
                return;
            }
            o c16 = l.c();
            if (c16 != null) {
                String str2 = gProStNotice.origineFeed.idd;
                Intrinsics.checkNotNullExpressionValue(str2, "notice.origineFeed.idd");
                c16.updateFeedInteractBlockedStatus(Q1(str2, isReceive), new IGProUpdateFeedInteractBlockedStatusCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.notice.d
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback
                    public final void onResult(int i3, String str3) {
                        GuildVisitorNoticeViewModel.l2(GuildVisitorNoticeViewModel.this, gProStNotice, isReceive, i3, str3);
                    }
                });
            }
        }
    }

    public final void loadMore() {
        W1(this, true, false, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        j2();
    }

    public final void refresh() {
        this.guildIdSets.clear();
        this.unReadCnt = 0;
        U1(false, false, true);
    }
}
