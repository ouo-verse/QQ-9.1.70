package nk;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StLike;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lnk/as;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "actionType", "", "N1", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo;", "likeInfo", "O1", "", "getLogTag", "M1", "Lbk/i;", "i", "Lbk/i;", "mLikeRepo", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class as extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bk.i mLikeRepo = new bk.i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/as$b", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZoneBaseMeta$StLike;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<QZoneBaseMeta$StLike> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZoneBaseMeta$StLike t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    private final void N1(BusinessFeedData feedData, int actionType) {
        if (feedData.cellLikeInfo == null) {
            feedData.cellLikeInfo = new CellLikeInfo();
        }
        CellLikeInfo cellLikeInfo = feedData.cellLikeInfo;
        Intrinsics.checkNotNullExpressionValue(cellLikeInfo, "feedData.cellLikeInfo");
        int i3 = 0;
        cellLikeInfo.isLiked = actionType == 1;
        cellLikeInfo.isFakeOperation = true;
        if (cellLikeInfo.likeMans == null) {
            cellLikeInfo.likeMans = new ArrayList<>();
        }
        if (actionType == 1) {
            ArrayList<CellLikeInfo.LikeMan> arrayList = cellLikeInfo.likeMans;
            Intrinsics.checkNotNullExpressionValue(arrayList, "likeInfo.likeMans");
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((CellLikeInfo.LikeMan) it.next()).user.uin == LoginData.getInstance().getUin()) {
                    return;
                }
            }
            cellLikeInfo.likeMans.add(0, new CellLikeInfo.LikeMan(oj.a.f423008a.e(), 0, null));
            O1(feedData, cellLikeInfo);
        } else {
            int size = cellLikeInfo.likeMans.size();
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (cellLikeInfo.likeMans.get(i3).user.uin == LoginData.getInstance().getUin()) {
                    cellLikeInfo.likeMans.remove(i3);
                    O1(feedData, cellLikeInfo);
                    break;
                }
                i3++;
            }
        }
        QLog.d("QZoneIntimateLikeViewModel", 1, "operateLikeFakeInfo  | businessfeedData.getLikeInfo().likeNum = " + feedData.getLikeInfo().likeNum);
    }

    private final void O1(BusinessFeedData feedData, CellLikeInfo likeInfo) {
        if (likeInfo.isLiked) {
            likeInfo.likeNum++;
        } else {
            likeInfo.likeNum--;
        }
    }

    public final void M1(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.cellLikeInfo == null) {
            feedData.cellLikeInfo = new CellLikeInfo();
        }
        int i3 = !feedData.cellLikeInfo.isLiked ? 1 : 0;
        N1(feedData, i3);
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(feedData), feedData.cellLikeInfo), true);
        bk.i iVar = this.mLikeRepo;
        int i16 = this.contextHashCode;
        CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
        iVar.a(i16, feedData, cellIntimateSpaceInfo != null ? cellIntimateSpaceInfo.spaceId : null, i3, new b());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateLikeViewModel";
    }
}
