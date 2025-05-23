package ci;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.ArrayUtils;
import fj.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J \u0010\u001f\u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001dH\u0016J \u0010 \u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001dH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001cj\b\u0012\u0004\u0012\u00020\"`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b1\u0010-\"\u0004\b@\u0010/R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010+\u001a\u0004\bC\u0010-\"\u0004\bD\u0010/R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/R\"\u0010N\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0019\u001a\u0004\b9\u0010K\"\u0004\bL\u0010MR\"\u0010R\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010+\u001a\u0004\bP\u0010-\"\u0004\bQ\u0010/\u00a8\u0006W"}, d2 = {"Lci/i;", "Lo9/a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "stMedia", "", "G", "M", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "", "u", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "t", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "stImage", "p", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "currentPicInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "", "width", "Z", "height", "V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "w", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setExtraInfoBeanList", "(Ljava/util/ArrayList;)V", "extraInfoBeanList", "D", "Ljava/lang/String;", "getRightAttachInfo", "()Ljava/lang/String;", "f0", "(Ljava/lang/String;)V", "rightAttachInfo", "E", "I", "getRightBoundIndex", "()I", "g0", "(I)V", "rightBoundIndex", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "a0", "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;)V", "albumDetailInitBean", "c0", "feedId", "H", "N", "e0", "groupId", "B", "b0", "batchId", "", "J", "()Z", "d0", "(Z)V", "fromFeedDetail", "K", "getDataRepoKey", "setDataRepoKey", "dataRepoKey", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class i extends o9.a {

    /* renamed from: E, reason: from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean albumDetailInitBean;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean fromFeedDetail;

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<GroupAlbumLayerExtraInfoBean> extraInfoBeanList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String groupId = "";

    /* renamed from: I, reason: from kotlin metadata */
    private String batchId = "";

    /* renamed from: K, reason: from kotlin metadata */
    private String dataRepoKey = "";

    private final String G(CommonStMedia stMedia) {
        if (stMedia.getType() == 1) {
            return stMedia.getVideo().getCover().getLloc();
        }
        return stMedia.getImage().getLloc();
    }

    private final String M(CommonStMedia stMedia) {
        if (stMedia.getType() == 1) {
            return stMedia.getVideo().getCover().getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
        }
        return stMedia.getImage().getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
    }

    private final void p(CommonStImage stImage, RFWLayerPicInfo layerPicInfo) {
        t tVar = t.f399471a;
        List<CommonStPicSpecUrlEntry> e16 = stImage.e();
        PhotoSpec photoSpec = PhotoSpec.KPHOTOSPECBIG;
        String b16 = tVar.b(e16, photoSpec);
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(b16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(b16)));
        rFWPicInfo.setWidth(Z(tVar.d(stImage.e(), photoSpec)));
        rFWPicInfo.setHeight(V(tVar.a(stImage.e(), photoSpec)));
        layerPicInfo.setBigPicInfo(rFWPicInfo);
    }

    private final void q(CommonStImage stImage, RFWLayerPicInfo.RFWPicInfo currentPicInfo) {
        t tVar = t.f399471a;
        String b16 = tVar.b(stImage.e(), PhotoSpec.KPHOTOSPECCURRENT);
        String b17 = tVar.b(stImage.e(), PhotoSpec.KPHOTOSPECBIG);
        if (!TextUtils.isEmpty(b16)) {
            currentPicInfo.setUrl(b16);
            currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(b16)));
        } else {
            if (TextUtils.isEmpty(b17)) {
                return;
            }
            currentPicInfo.setUrl(b17);
            currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(b17)));
        }
    }

    private final void r(CommonStImage stImage, RFWLayerPicInfo layerPicInfo) {
        String b16 = t.f399471a.b(stImage.e(), PhotoSpec.KPHOTOSPECDOWNLOAD);
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(b16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(b16)));
        layerPicInfo.setDownloadPicInfo(rFWPicInfo);
    }

    private final void s(CommonStImage stImage, RFWLayerPicInfo layerPicInfo) {
        String c16 = t.f399471a.c(stImage.e(), PhotoSpec.KPHOTOSPECORIGIN, false);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        layerPicInfo.setOriginPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo);
        originPicInfo.setUrl(c16);
        RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo2);
        originPicInfo2.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c16)));
    }

    private final void t(CommonStMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(G(stMedia));
        u(stMedia, rFWLayerPicInfo);
        mediaInfo.setMediaId(rFWLayerPicInfo.getPicId());
        mediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    private final void u(CommonStMedia stMedia, RFWLayerPicInfo layerPicInfo) {
        CommonStImage image;
        new CommonStImage();
        if (stMedia.getType() == 1) {
            image = stMedia.getVideo().getCover();
        } else {
            image = stMedia.getImage();
        }
        p(image, layerPicInfo);
        r(image, layerPicInfo);
        s(image, layerPicInfo);
        if (!com.qzone.reborn.configx.g.f53821a.b().O() && layerPicInfo.getOriginPicInfo() != null) {
            RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo.getOriginPicInfo();
            Intrinsics.checkNotNull(originPicInfo);
            if (RFWFileUtils.fileExists(originPicInfo.getLocalPath())) {
                RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo.getOriginPicInfo();
                Intrinsics.checkNotNull(originPicInfo2);
                layerPicInfo.setCurrentPicInfo(originPicInfo2);
                return;
            }
        }
        if (layerPicInfo.getBigPicInfo() != null) {
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo);
            if (bigPicInfo.getWidth() != 0) {
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                double height = r0.getHeight() * 1.0d;
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                if (height / r2.getWidth() > 2.5d) {
                    RFWLayerPicInfo.RFWPicInfo bigPicInfo2 = layerPicInfo.getBigPicInfo();
                    Intrinsics.checkNotNull(bigPicInfo2);
                    layerPicInfo.setCurrentPicInfo(bigPicInfo2);
                    return;
                }
            }
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        q(image, rFWPicInfo);
        t tVar = t.f399471a;
        List<CommonStPicSpecUrlEntry> e16 = image.e();
        PhotoSpec photoSpec = PhotoSpec.KPHOTOSPECCURRENT;
        rFWPicInfo.setWidth(tVar.d(e16, photoSpec));
        rFWPicInfo.setHeight(tVar.a(image.e(), photoSpec));
        if (rFWPicInfo.getWidth() == 0 || rFWPicInfo.getHeight() == 0) {
            vj.d dVar = vj.d.f441734a;
            rFWPicInfo.setWidth(dVar.g());
            rFWPicInfo.setHeight(dVar.f());
        }
        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            layerPicInfo.setSmallPicInfo(layerPicInfo.getCurrentPicInfo());
            RFWLayerPicInfo.RFWPicInfo bigPicInfo3 = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo3);
            layerPicInfo.setCurrentPicInfo(bigPicInfo3);
        }
    }

    private final void v(CommonStMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        String url;
        if (stMedia.getType() != 1) {
            return;
        }
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(stMedia.getVideo().getId());
        rFWLayerVideoInfo.setNormalVideoUrl(stMedia.getVideo().getUrl());
        rFWLayerVideoInfo.setVideoOriginUrl(t.f399471a.c(stMedia.getVideo().e(), PhotoSpec.KPHOTOSPECORIGIN, false));
        if (!TextUtils.isEmpty(rFWLayerVideoInfo.getVideoOriginUrl()) && n9.a.f419499a.a().contains(rFWLayerVideoInfo.getFileId())) {
            url = rFWLayerVideoInfo.getVideoOriginUrl();
            Intrinsics.checkNotNull(url);
        } else {
            url = stMedia.getVideo().getUrl();
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(url);
        rFWLayerVideoInfo.setVideoWidth(Z(stMedia.getVideo().getWidth()));
        rFWLayerVideoInfo.setVideoHeight(V(stMedia.getVideo().getHeight()));
        mediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    /* renamed from: A, reason: from getter */
    public final GroupAlbumAlbumDetailInitBean getAlbumDetailInitBean() {
        return this.albumDetailInitBean;
    }

    /* renamed from: B, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    public final ArrayList<GroupAlbumLayerExtraInfoBean> C() {
        return this.extraInfoBeanList;
    }

    /* renamed from: E, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: F, reason: from getter */
    public final boolean getFromFeedDetail() {
        return this.fromFeedDetail;
    }

    /* renamed from: N, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final void a0(GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean) {
        this.albumDetailInitBean = groupAlbumAlbumDetailInitBean;
    }

    public final void b0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void c0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void d0(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void e0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void f0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }

    public final void g0(int i3) {
        this.rightBoundIndex = i3;
    }

    public void w(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<GroupAlbumLayerExtraInfoBean> arrayList = new ArrayList<>();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(x(media));
        }
        this.extraInfoBeanList = arrayList;
    }

    public final GroupAlbumLayerExtraInfoBean x(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean = new GroupAlbumLayerExtraInfoBean();
        groupAlbumLayerExtraInfoBean.z(G(stMedia));
        groupAlbumLayerExtraInfoBean.D(M(stMedia));
        groupAlbumLayerExtraInfoBean.t(getAlbumId());
        groupAlbumLayerExtraInfoBean.u(getAlbumName());
        groupAlbumLayerExtraInfoBean.v(String.valueOf(stMedia.getBatchId()));
        groupAlbumLayerExtraInfoBean.M(stMedia.getType() == 1);
        if (groupAlbumLayerExtraInfoBean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            groupAlbumLayerExtraInfoBean.N(stMedia.getVideo().getId());
        } else {
            groupAlbumLayerExtraInfoBean.N("");
        }
        groupAlbumLayerExtraInfoBean.F(stMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String());
        groupAlbumLayerExtraInfoBean.E(stMedia.getUploadTime());
        groupAlbumLayerExtraInfoBean.x(stMedia.getDesc());
        groupAlbumLayerExtraInfoBean.y(this.groupId);
        groupAlbumLayerExtraInfoBean.w(stMedia.getComment().getCommentNum());
        groupAlbumLayerExtraInfoBean.A(stMedia.getLike().getLiked() == 1);
        groupAlbumLayerExtraInfoBean.C(stMedia.getLike().getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.NUM java.lang.String());
        groupAlbumLayerExtraInfoBean.B(stMedia.getLike().getKey());
        groupAlbumLayerExtraInfoBean.G(stMedia.getUploadUserName());
        return groupAlbumLayerExtraInfoBean;
    }

    public void y(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(z(media));
        }
        o(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RFWLayerItemMediaInfo z(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        t(stMedia, rFWLayerItemMediaInfo);
        v(stMedia, rFWLayerItemMediaInfo);
        return rFWLayerItemMediaInfo;
    }

    private final int V(int height) {
        return height == 0 ? vj.d.f441734a.f() : height;
    }

    private final int Z(int width) {
        return width == 0 ? vj.d.f441734a.g() : width;
    }
}
