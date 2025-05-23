package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/x;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "actionType", "", "O1", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo;", "likeInfo", "Q1", "", "getLogTag", "Landroid/content/Intent;", "intent", "P1", "M1", "", "batch", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "opType", "N1", "i", "Z", "isSinglePhoto", "Lki/v;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lki/v;", "mLikeRepo", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSinglePhoto;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ki.v mLikeRepo = new ki.v();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/x$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<CommonStLike> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonStLike t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            x.this.N1(true, true, retCode, 1);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            x.this.N1(true, false, errorCode, 1);
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    private final void O1(BusinessFeedData feedData, int actionType) {
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
            oj.a aVar = oj.a.f423008a;
            String str = feedData.cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.cellGroupAlbumInfo.groupId");
            cellLikeInfo.likeMans.add(0, new CellLikeInfo.LikeMan(aVar.b(str), 0, null));
            Q1(feedData, cellLikeInfo);
        } else {
            int size = cellLikeInfo.likeMans.size();
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (cellLikeInfo.likeMans.get(i3).user.uin == LoginData.getInstance().getUin()) {
                    cellLikeInfo.likeMans.remove(i3);
                    Q1(feedData, cellLikeInfo);
                    break;
                }
                i3++;
            }
        }
        QLog.d("GroupAlbumFeedLikeViewModel", 1, "operateLikeFakeInfo  | businessfeedData.getLikeInfo().likeNum = " + feedData.getLikeInfo().likeNum);
    }

    private final void Q1(BusinessFeedData feedData, CellLikeInfo likeInfo) {
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
        O1(feedData, i3);
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(feedData), feedData.cellLikeInfo), true);
        ki.v vVar = this.mLikeRepo;
        boolean z16 = this.isSinglePhoto;
        CellGroupAlbumInfo cellGroupAlbumInfo = feedData.cellGroupAlbumInfo;
        vVar.d(z16, feedData, cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null, i3, new b());
    }

    public final void N1(boolean batch, boolean isSuccess, long resultCode, int opType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("interact_op_success", Integer.valueOf(isSuccess ? 1 : 0));
        linkedHashMap.put("business_type", Integer.valueOf(!batch ? 1 : 0));
        linkedHashMap.put("fail_error_code", Long.valueOf(resultCode));
        linkedHashMap.put("op_type", Integer.valueOf(opType));
        fo.c.c("ev_qun_album_on_interact_op", linkedHashMap);
    }

    public final void P1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getBooleanExtra("fromark", false)) {
            String stringExtra = intent.getStringExtra("llocid");
            Intrinsics.checkNotNull(stringExtra);
            this.isSinglePhoto = !(stringExtra == null || stringExtra.length() == 0);
            return;
        }
        this.isSinglePhoto = false;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedLikeViewModel";
    }
}
