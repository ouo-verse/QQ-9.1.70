package di;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.albumx.common.bean.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/d;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final BusinessFeedData a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.cellFeedCommInfo = new CellFeedCommInfo();
        CellGroupAlbumInfo cellGroupAlbumInfo = new CellGroupAlbumInfo();
        businessFeedData.cellGroupAlbumInfo = cellGroupAlbumInfo;
        cellGroupAlbumInfo.groupId = dVar.getGroupId();
        CellUserInfo cellUserInfo = new CellUserInfo();
        businessFeedData.cellUserInfo = cellUserInfo;
        cellUserInfo.user = new User();
        businessFeedData.cellUserInfo.user.uin = ef.d.k(dVar.getUin());
        User user = businessFeedData.cellUserInfo.user;
        user.uid = "";
        user.nickName = "";
        if (dVar.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            businessFeedData.setVideoInfo(new VideoInfo());
            businessFeedData.getVideoInfo().albumid = dVar.getAlbumId();
            businessFeedData.getVideoInfo().batchId = Long.parseLong(dVar.getBatchId());
            businessFeedData.getVideoInfo().lloc = dVar.getLlocId();
        } else {
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            businessFeedData.cellPictureInfo = cellPictureInfo;
            cellPictureInfo.albumid = dVar.getAlbumId();
            businessFeedData.cellPictureInfo.batchId = Long.parseLong(dVar.getBatchId());
            businessFeedData.cellPictureInfo.pics = new ArrayList<>();
            PictureItem pictureItem = new PictureItem();
            pictureItem.albumId = dVar.getAlbumId();
            pictureItem.lloc = dVar.getLlocId();
            businessFeedData.cellPictureInfo.pics.add(pictureItem);
        }
        return businessFeedData;
    }
}
