package ki;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellMedia;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellQunInfo;
import com.tencent.qqnt.kernel.nativeinterface.StLike;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J:\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u00a8\u0006\u0017"}, d2 = {"Lki/v;", "", "", "actionType", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lkotlin/Pair;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", "c", "", "singlePhoto", "businessFeedData", "", "spaceId", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "dataCallback", "", "d", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class v {
    private final Pair<StFeed, StLike> c(int actionType, BusinessFeedData feedData) {
        String str;
        String str2;
        String str3;
        long j3;
        StFeed stFeed = new StFeed();
        stFeed.cellUserInfo.user.uin = String.valueOf(feedData.cellUserInfo.user.uin);
        StMedia stMedia = new StMedia();
        if (feedData.getVideoInfo() != null && !TextUtils.isEmpty(feedData.getVideoInfo().albumid)) {
            str = feedData.getVideoInfo().albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.videoInfo.albumid");
            j3 = feedData.getVideoInfo().batchId;
            String str4 = feedData.getVideoInfo().lloc;
            Intrinsics.checkNotNullExpressionValue(str4, "feedData.videoInfo.lloc");
            stMedia.type = 1;
            stMedia.video.cover.lloc = str4;
            String str5 = feedData.getVideoInfo().likekey;
            Intrinsics.checkNotNullExpressionValue(str5, "feedData.videoInfo.likekey");
            str3 = str5;
        } else {
            str = feedData.cellPictureInfo.albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.cellPictureInfo.albumid");
            CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
            long j16 = cellPictureInfo.batchId;
            if (cellPictureInfo.pics.isEmpty()) {
                str2 = "";
            } else {
                str2 = feedData.cellPictureInfo.pics.get(0).lloc;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                    fe\u20260].lloc\n                }");
            }
            stMedia.type = 0;
            stMedia.image.lloc = str2;
            String str6 = feedData.cellPictureInfo.pics.get(0).likeKey;
            Intrinsics.checkNotNullExpressionValue(str6, "feedData.cellPictureInfo.pics[0].likeKey");
            str3 = str6;
            j3 = j16;
        }
        StFeedCellMedia stFeedCellMedia = stFeed.cellMedia;
        stFeedCellMedia.albumId = str;
        stFeedCellMedia.batchId = j3;
        stFeedCellMedia.mediaItems.add(stMedia);
        stFeed.cellQunInfo = new StFeedCellQunInfo(feedData.cellGroupAlbumInfo.groupId);
        StUser stUser = new StUser();
        stUser.uin = LoginData.getInstance().getUinString();
        stUser.uid = LoginData.getInstance().getUid();
        return new Pair<>(stFeed, new StLike(str3, actionType, actionType, stUser, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final n.a dataCallback, int i3, final int i16, final String str, final StCommonExt stCommonExt, final StLike stLike) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.u
            @Override // java.lang.Runnable
            public final void run() {
                v.f(i16, dataCallback, stLike, stCommonExt, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, n.a dataCallback, StLike stLike, StCommonExt stCommonExt, String errMs) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (i3 == 0) {
            CommonStLike N = stLike != null ? yh.b.N(stLike, stCommonExt) : null;
            Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
            dataCallback.onSuccess(N, i3, errMs, true);
            return;
        }
        dataCallback.onFailure(i3, errMs);
    }

    public final void d(boolean singlePhoto, BusinessFeedData businessFeedData, String spaceId, int actionType, final n.a<CommonStLike> dataCallback) {
        Pair<StFeed, StLike> c16;
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        int i3 = 1;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            if (!(spaceId == null || spaceId.length() == 0)) {
                if (actionType != 0) {
                    i3 = !singlePhoto ? 2 : 4;
                } else if (singlePhoto) {
                    i3 = 3;
                }
                int i16 = i3;
                if (singlePhoto) {
                    c16 = c(actionType, businessFeedData);
                } else {
                    c16 = xh.c.f448000a.c(businessFeedData, spaceId, actionType);
                }
                StFeed first = c16.getFirst();
                StLike second = c16.getSecond();
                com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
                IAlbumServiceDoQunLikeCallback iAlbumServiceDoQunLikeCallback = new IAlbumServiceDoQunLikeCallback() { // from class: ki.t
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunLikeCallback
                    public final void onDoQunLike(int i17, int i18, String str, StCommonExt stCommonExt, StLike stLike) {
                        v.e(n.a.this, i17, i18, str, stCommonExt, stLike);
                    }
                };
                if (b16 != null) {
                    b16.X(new StCommonExt(), i16, second, first, iAlbumServiceDoQunLikeCallback);
                    return;
                }
                return;
            }
        }
        RFWLog.e("GroupAlbumFeedLikeRepo", RFWLog.USR, "doLike error, businessFeedData: " + businessFeedData + ", spaceId: " + spaceId);
    }
}
