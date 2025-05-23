package bb;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernel.nativeinterface.MediaOpMask;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007J\u001e\u0010\u000b\u001a\u00020\t2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010!\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lbb/i;", "Lbb/h;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "photoInfo", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "m0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "", "l0", "n0", "", "N", "Z", "q0", "()Z", "w0", "(Z)V", "isRefresh", "P", "isFetchLeft", "s0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isFetchRight", "t0", BdhLogUtil.LogTag.Tag_Req, "p0", "u0", "isLeftFinish", ExifInterface.LATITUDE_SOUTH, "r0", "x0", "isRightFinish", "", "T", "I", "o0", "()I", "v0", "(I)V", "mediumSum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i extends h {

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isLeftFinish;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isRightFinish;

    /* renamed from: T, reason: from kotlin metadata */
    private int mediumSum;

    private final QZAlbumxLayerExtraInfoBean m0(CommonPhotoInfo photoInfo) {
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = new QZAlbumxLayerExtraInfoBean();
        qZAlbumxLayerExtraInfoBean.E(M(photoInfo.getMedia()));
        qZAlbumxLayerExtraInfoBean.Z(N(photoInfo.getMedia()));
        qZAlbumxLayerExtraInfoBean.z(photoInfo.getAlbumId());
        qZAlbumxLayerExtraInfoBean.A(photoInfo.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        qZAlbumxLayerExtraInfoBean.y(photoInfo.getOwner().getUin());
        qZAlbumxLayerExtraInfoBean.B(String.valueOf(photoInfo.getMedia().getBatchId()));
        qZAlbumxLayerExtraInfoBean.G(photoInfo.getMedia().getLinkId());
        qZAlbumxLayerExtraInfoBean.h0(photoInfo.getMedia().getType() == 1);
        qZAlbumxLayerExtraInfoBean.c0(photoInfo.getMedia().n().contains(Integer.valueOf(MediaOpMask.KMEDIAOPMASKSHOWREPAIR.ordinal())));
        if (qZAlbumxLayerExtraInfoBean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            qZAlbumxLayerExtraInfoBean.i0(photoInfo.getMedia().getVideo().getId());
        } else {
            qZAlbumxLayerExtraInfoBean.i0("");
        }
        qZAlbumxLayerExtraInfoBean.f0(photoInfo.getMedia().getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String());
        qZAlbumxLayerExtraInfoBean.e0(photoInfo.getMedia().getUploadTime());
        qZAlbumxLayerExtraInfoBean.b0(photoInfo.getMedia().getShootTime());
        qZAlbumxLayerExtraInfoBean.F(photoInfo.getMedia().getLbs().getLocation());
        qZAlbumxLayerExtraInfoBean.D(photoInfo.getMedia().getDesc());
        qZAlbumxLayerExtraInfoBean.d0(getUin());
        qZAlbumxLayerExtraInfoBean.C(photoInfo.getMedia().getComment().getCommentNum());
        qZAlbumxLayerExtraInfoBean.M(photoInfo.getMedia().getLike().getLiked() == 1);
        qZAlbumxLayerExtraInfoBean.V(photoInfo.getMedia().getLike().getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.NUM java.lang.String());
        qZAlbumxLayerExtraInfoBean.N(photoInfo.getMedia().getLike().getKey());
        qZAlbumxLayerExtraInfoBean.g0(photoInfo.getMedia().getUploadUserName());
        return qZAlbumxLayerExtraInfoBean;
    }

    public final void l0(ArrayList<CommonPhotoInfo> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<QZAlbumxLayerExtraInfoBean> arrayList = new ArrayList<>();
        Iterator<CommonPhotoInfo> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonPhotoInfo media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(m0(media));
        }
        g0(arrayList);
    }

    public final void n0(ArrayList<CommonPhotoInfo> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        Iterator<CommonPhotoInfo> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonPhotoInfo photoInfo = it.next();
            RFWLayerItemMediaInfo z16 = z(photoInfo.getMedia());
            Intrinsics.checkNotNullExpressionValue(photoInfo, "photoInfo");
            z16.setExtraData(m0(photoInfo));
            arrayList.add(z16);
        }
        o(arrayList);
    }

    /* renamed from: o0, reason: from getter */
    public final int getMediumSum() {
        return this.mediumSum;
    }

    /* renamed from: p0, reason: from getter */
    public final boolean getIsLeftFinish() {
        return this.isLeftFinish;
    }

    /* renamed from: q0, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* renamed from: r0, reason: from getter */
    public final boolean getIsRightFinish() {
        return this.isRightFinish;
    }

    public final void s0(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void t0(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void u0(boolean z16) {
        this.isLeftFinish = z16;
    }

    public final void v0(int i3) {
        this.mediumSum = i3;
    }

    public final void w0(boolean z16) {
        this.isRefresh = z16;
    }

    public final void x0(boolean z16) {
        this.isRightFinish = z16;
    }
}
