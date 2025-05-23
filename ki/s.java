package ki;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JV\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u00a8\u0006\u0014"}, d2 = {"Lki/s;", "", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "postUin", "groupId", "albumId", "batchId", "llocId", "likeKey", "", "actionType", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "dataCallback", "", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f412506a = new s();

    s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final n.a dataCallback, int i3, final int i16, final String str, final StCommonExt stCommonExt, final StLike stLike) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.r
            @Override // java.lang.Runnable
            public final void run() {
                s.e(i16, dataCallback, stLike, stCommonExt, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, n.a dataCallback, StLike stLike, StCommonExt stCommonExt, String errMs) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        if (i3 == 0) {
            CommonStLike N = stLike != null ? yh.b.N(stLike, stCommonExt) : null;
            Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
            dataCallback.onSuccess(N, i3, errMs, true);
            return;
        }
        dataCallback.onFailure(i3, errMs);
    }

    public final void c(boolean isVideo, String postUin, String groupId, String albumId, String batchId, String llocId, String likeKey, int actionType, final n.a<CommonStLike> dataCallback) {
        Intrinsics.checkNotNullParameter(postUin, "postUin");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(llocId, "llocId");
        Intrinsics.checkNotNullParameter(likeKey, "likeKey");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        StFeed stFeed = new StFeed();
        stFeed.cellUserInfo.user.uin = postUin;
        StFeedCellMedia stFeedCellMedia = stFeed.cellMedia;
        stFeedCellMedia.albumId = albumId;
        stFeedCellMedia.batchId = Long.parseLong(batchId);
        StMedia stMedia = new StMedia();
        if (!isVideo) {
            stMedia.image.lloc = llocId;
        } else {
            stMedia.video.cover.lloc = llocId;
        }
        stFeed.cellMedia.mediaItems.add(stMedia);
        stFeed.cellQunInfo = new StFeedCellQunInfo(groupId);
        int i3 = actionType == 0 ? 3 : 4;
        StUser stUser = new StUser();
        stUser.uin = LoginData.getInstance().getUinString();
        stUser.uid = LoginData.getInstance().getUid();
        StLike stLike = new StLike(likeKey, actionType, actionType, stUser, 0);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        IAlbumServiceDoQunLikeCallback iAlbumServiceDoQunLikeCallback = new IAlbumServiceDoQunLikeCallback() { // from class: ki.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunLikeCallback
            public final void onDoQunLike(int i16, int i17, String str, StCommonExt stCommonExt, StLike stLike2) {
                s.d(n.a.this, i16, i17, str, stCommonExt, stLike2);
            }
        };
        if (b16 != null) {
            b16.X(new StCommonExt(), i3, stLike, stFeed, iAlbumServiceDoQunLikeCallback);
        }
    }
}
