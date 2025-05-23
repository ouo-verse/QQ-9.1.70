package jc;

import NS_MOBILE_OPERATION.PhotoInformation;
import NS_MOBILE_OPERATION.operation_addfavour_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.favorite.protocol.QzoneAddFavorRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.albumx.qzonex.utils.QZAlbumxFavorUtil;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ljc/m;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "Lcom/qzone/common/business/IQZoneServiceListener;", "shareContext", "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", "Lcom/qzone/common/business/task/QZoneTask;", "task", "onTaskResponse", "", "e", "Ljava/lang/String;", "ugc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m extends com.qzone.reborn.albumx.common.share.a<ic.c> implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String ugc;

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean f(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (!shareContext.getLayerItemInfo().isVideo() && !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) {
            QZAlbumxFavorUtil qZAlbumxFavorUtil = QZAlbumxFavorUtil.f53383a;
            if (!qZAlbumxFavorUtil.e(qZAlbumxFavorUtil.d(shareContext))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(6);
        return listOf;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask task) {
        if (task == null) {
            return;
        }
        if (task.succeeded()) {
            if (task.mRequest.rsp instanceof operation_addfavour_rsp) {
                QfavHelper.B(BaseApplication.context, LoginData.getInstance().getUinString(), true, null, false);
                String str = this.ugc;
                if (str != null) {
                    QZAlbumxFavorUtil qZAlbumxFavorUtil = QZAlbumxFavorUtil.f53383a;
                    JceStruct jceStruct = task.mRequest.rsp;
                    Intrinsics.checkNotNull(jceStruct, "null cannot be cast to non-null type NS_MOBILE_OPERATION.operation_addfavour_rsp");
                    String str2 = ((operation_addfavour_rsp) jceStruct).strFavID;
                    Intrinsics.checkNotNullExpressionValue(str2, "task.mRequest.rsp as ope\u2026n_addfavour_rsp).strFavID");
                    qZAlbumxFavorUtil.a(str, str2);
                    return;
                }
                return;
            }
            return;
        }
        ToastUtil.s(task.f45835msg, 4);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        String str;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        PhotoInformation photoInformation = new PhotoInformation();
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        if (layerPicInfo == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str = currentPicInfo.getUrl()) == null) {
            str = "";
        }
        photoInformation.sUrl = str;
        String d16 = QZAlbumxFavorUtil.f53383a.d(shareContext);
        this.ugc = d16;
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        long k3 = ef.d.k(extraInfoBean != null ? extraInfoBean.getUin() : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(photoInformation);
        Unit unit = Unit.INSTANCE;
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneAddFavorRequest(k3, 4L, 0L, "", "", d16, arrayList, "", null), null, this, 3585));
    }
}
