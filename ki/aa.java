package ki;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.event.GroupAlbumBannerEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumUnReadEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteQunFeedCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedsCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTDeleteQunFeedReq;
import com.tencent.qqnt.kernel.nativeinterface.NTDeleteQunFeedRsp;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedsReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.qqnt.kernel.nativeinterface.StBanner;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\"\u0010#J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J,\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J8\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lki/aa;", "", "", "refreash", "", "groupId", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "reqAttachInfo", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataCallback", "", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunFeedsRsp;", "response", "l", "", "contextHashCode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "businessFeedData", "isDelMediaFileInAlbum", "e", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "mCommonExt", "b", "Ljava/lang/String;", "mAttachInfo", "c", "Z", "mFirstTime", "<init>", "()V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private StCommonExt mCommonExt = new StCommonExt();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mFirstTime = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final n.a dataCallback, final BusinessFeedData businessFeedData, final NTDeleteQunFeedRsp nTDeleteQunFeedRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(businessFeedData, "$businessFeedData");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.z
            @Override // java.lang.Runnable
            public final void run() {
                aa.g(NTDeleteQunFeedRsp.this, dataCallback, businessFeedData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NTDeleteQunFeedRsp nTDeleteQunFeedRsp, n.a dataCallback, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(businessFeedData, "$businessFeedData");
        RFWLog.e("GroupAlbumFeedServerRepo", RFWLog.USR, "IAlbumServiceDeleteQunFeedCallback trace:" + nTDeleteQunFeedRsp.traceId + " ret:" + nTDeleteQunFeedRsp.result + "  err\uff1a" + nTDeleteQunFeedRsp.errMs);
        int i3 = nTDeleteQunFeedRsp.result;
        if (i3 == 0) {
            String str = nTDeleteQunFeedRsp.errMs;
            Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
            dataCallback.onSuccess(businessFeedData, i3, str, true);
            return;
        }
        dataCallback.onFailure(i3, nTDeleteQunFeedRsp.errMs);
    }

    private final void h(boolean refreash, final String groupId, StCommonExt commonExt, String reqAttachInfo, final n.a<List<BusinessFeedData>> dataCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        IAlbumServiceGetQunFeedsCallback iAlbumServiceGetQunFeedsCallback = new IAlbumServiceGetQunFeedsCallback() { // from class: ki.w
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedsCallback
            public final void onGetQunFeeds(NTGetQunFeedsRsp nTGetQunFeedsRsp) {
                aa.i(groupId, currentTimeMillis, this, dataCallback, nTGetQunFeedsRsp);
            }
        };
        NTGetQunFeedsReq nTGetQunFeedsReq = new NTGetQunFeedsReq();
        nTGetQunFeedsReq.extInfo = commonExt;
        nTGetQunFeedsReq.qunId = groupId;
        if (refreash && this.mFirstTime) {
            nTGetQunFeedsReq.canReadCache = true;
            nTGetQunFeedsReq.enableCache = true;
            this.mFirstTime = false;
        }
        nTGetQunFeedsReq.attachInfo = reqAttachInfo;
        nTGetQunFeedsReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.getQunFeeds(nTGetQunFeedsReq, iAlbumServiceGetQunFeedsCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String groupId, long j3, final aa this$0, final n.a dataCallback, final NTGetQunFeedsRsp nTGetQunFeedsRsp) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWLog.e("GroupAlbumFeedServerRepo", RFWLog.USR, "NTGetQunFeedsRsp groupId:" + groupId + "  isFromCache\uff1a" + nTGetQunFeedsRsp.isFromCache + " traceId:" + nTGetQunFeedsRsp.traceId);
        int i3 = nTGetQunFeedsRsp.result;
        fj.v.a(i3 == 0, 0, i3, System.currentTimeMillis() - j3, nTGetQunFeedsRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.x
            @Override // java.lang.Runnable
            public final void run() {
                aa.j(aa.this, nTGetQunFeedsRsp, dataCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(aa this$0, NTGetQunFeedsRsp response, n.a dataCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        StCommonExt stCommonExt = response.extInfo;
        if (stCommonExt == null) {
            stCommonExt = new StCommonExt();
        }
        this$0.mCommonExt = stCommonExt;
        String str = response.attachInfo;
        if (str == null) {
            str = "";
        }
        this$0.mAttachInfo = str;
        int i3 = response.result;
        if (i3 == 0) {
            List<BusinessFeedData> h16 = yh.a.f450323a.h(response.feeds, response.extInfo);
            long j3 = response.result;
            String str2 = response.errMs;
            dataCallback.onSuccess(h16, j3, str2 == null ? "" : str2, !response.hasMore);
            Intrinsics.checkNotNullExpressionValue(response, "response");
            this$0.l(response);
            return;
        }
        dataCallback.onFailure(i3, response.errMs);
    }

    private final void l(NTGetQunFeedsRsp response) {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        StBanner stBanner = response.banner;
        String id5 = stBanner.f359222id;
        String img = stBanner.img;
        String color = stBanner.color;
        String text = stBanner.text;
        int i3 = stBanner.actionType;
        String actionUrl = stBanner.actionUrl;
        long j3 = stBanner.intervalTime;
        Intrinsics.checkNotNullExpressionValue(id5, "response.banner.id");
        boolean z16 = id5.length() == 0;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        Intrinsics.checkNotNullExpressionValue(img, "img");
        Intrinsics.checkNotNullExpressionValue(color, "color");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Intrinsics.checkNotNullExpressionValue(actionUrl, "actionUrl");
        simpleEventBus.dispatchEvent(new GroupAlbumBannerEvent(id5, img, color, text, actionUrl, j3, i3, z16));
        if (response.isFromCache) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumUnReadEvent(response.unreadFeedsNum));
    }

    public void e(int contextHashCode, final BusinessFeedData businessFeedData, String groupId, boolean isDelMediaFileInAlbum, final n.a<BusinessFeedData> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (groupId == null) {
            RFWLog.e("GroupAlbumFeedServerRepo", RFWLog.USR, "deleteFeed groupId is null");
            return;
        }
        String a16 = ef.b.a(businessFeedData);
        if (a16 == null || a16.length() == 0) {
            RFWLog.e("GroupAlbumFeedServerRepo", RFWLog.USR, "deleteFeed feedId is null");
            return;
        }
        StFeed b16 = xh.c.f448000a.b(businessFeedData, groupId);
        IAlbumServiceDeleteQunFeedCallback iAlbumServiceDeleteQunFeedCallback = new IAlbumServiceDeleteQunFeedCallback() { // from class: ki.y
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteQunFeedCallback
            public final void onDeleteQunFeed(NTDeleteQunFeedRsp nTDeleteQunFeedRsp) {
                aa.f(n.a.this, businessFeedData, nTDeleteQunFeedRsp);
            }
        };
        NTDeleteQunFeedReq nTDeleteQunFeedReq = new NTDeleteQunFeedReq(0, new RequestTimelineInfo(), new StCommonExt(), b16, isDelMediaFileInAlbum);
        nTDeleteQunFeedReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.g b17 = fj.r.b();
        if (b17 != null) {
            b17.deleteQunFeed(nTDeleteQunFeedReq, iAlbumServiceDeleteQunFeedCallback);
        }
    }

    public void k(int contextHashCode, String groupId, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        h(false, groupId, this.mCommonExt, this.mAttachInfo, dataCallback);
    }

    public void m(int contextHashCode, String groupId, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        h(true, groupId, new StCommonExt(), "", dataCallback);
    }
}
