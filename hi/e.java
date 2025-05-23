package hi;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.qzone.reborn.groupalbum.reship.util.GroupAlbumReshipUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import fj.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lhi/e;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lgi/a;", "shareContext", "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends com.qzone.reborn.albumx.common.share.a<gi.a> {
    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(gi.a shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (shareContext.getLayerItemInfo().getExtraData() == null || !(shareContext.getLayerItemInfo().getExtraData() instanceof GroupAlbumLayerExtraInfoBean)) {
            groupAlbumLayerExtraInfoBean = null;
        } else {
            Object extraData = shareContext.getLayerItemInfo().getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean");
            groupAlbumLayerExtraInfoBean = (GroupAlbumLayerExtraInfoBean) extraData;
        }
        if (groupAlbumLayerExtraInfoBean == null) {
            QLog.e("GroupAlbumReprintPhotoAction", 1, "currentSelectedMedia is null");
            return;
        }
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        arrayList.add(p.f399467a.a(shareContext.getLayerItemInfo(), groupAlbumLayerExtraInfoBean));
        GroupAlbumReshipUtil groupAlbumReshipUtil = GroupAlbumReshipUtil.f56889a;
        String groupId = groupAlbumLayerExtraInfoBean.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        String albumId = groupAlbumLayerExtraInfoBean.getAlbumId();
        groupAlbumReshipUtil.a(arrayList, groupId, albumId != null ? albumId : "", shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String());
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean f(gi.a shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !shareContext.getLayerItemInfo().isVideo();
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(100);
        return arrayListOf;
    }
}
