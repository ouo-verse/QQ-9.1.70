package bb;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.MediaOpMask;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001ZB\u0007\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J \u0010\u001e\u001a\u00020\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cH\u0016J \u0010\u001f\u001a\u00020\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u000e\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010$\u001a\u00020\b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cJ\u000e\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020!0\u001bj\b\u0012\u0004\u0012\u00020!`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b(\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u00100\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\"\u0010B\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00100\u001a\u0004\b@\u00102\"\u0004\bA\u00104R\"\u0010F\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00100\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\"\u0010M\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u001a\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010P\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u00100\u001a\u0004\b7\u00102\"\u0004\bO\u00104R$\u0010T\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u00100\u001a\u0004\bR\u00102\"\u0004\bS\u00104R2\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010)\u001a\u0004\bV\u0010+\"\u0004\bW\u0010-\u00a8\u0006["}, d2 = {"Lbb/h;", "Lo9/a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "stMedia", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "B", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "", "u", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "t", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "stImage", "p", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "currentPicInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "", "width", "a0", "height", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "w", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", HippyTKDListViewAdapter.X, "selectedList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "M", "N", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", UserInfo.SEX_FEMALE, "()Ljava/util/ArrayList;", "g0", "(Ljava/util/ArrayList;)V", "extraInfoBeanList", "D", "Ljava/lang/String;", "getRightAttachInfo", "()Ljava/lang/String;", "j0", "(Ljava/lang/String;)V", "rightAttachInfo", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "E", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "e0", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "albumDetailInitBean", "G", "setFeedId", "feedId", "c0", "k0", "uin", "H", "V", "i0", "linkId", "", "I", "getFromFeedDetail", "()Z", "h0", "(Z)V", "fromFeedDetail", "J", "f0", "dataRepoKey", "K", "getAlbumCreatorUin", "d0", "albumCreatorUin", "L", "b0", "setSelectedList", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class h extends o9.a {

    /* renamed from: E, reason: from kotlin metadata */
    private QZAlbumxAlbumDetailInitBean albumDetailInitBean;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean fromFeedDetail;

    /* renamed from: K, reason: from kotlin metadata */
    private String albumCreatorUin;

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<QZAlbumxLayerExtraInfoBean> extraInfoBeanList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String uin = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String linkId = "";

    /* renamed from: J, reason: from kotlin metadata */
    private String dataRepoKey = "";

    /* renamed from: L, reason: from kotlin metadata */
    private ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> selectedList = new ArrayList<>();

    private final QZAlbumxBatchLayerSelectedMediaInfoBean B(CommonStMedia stMedia) {
        String str;
        QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = new QZAlbumxBatchLayerSelectedMediaInfoBean();
        qZAlbumxBatchLayerSelectedMediaInfoBean.g(M(stMedia));
        qZAlbumxBatchLayerSelectedMediaInfoBean.l(stMedia.u());
        qZAlbumxBatchLayerSelectedMediaInfoBean.m(stMedia.u() ? stMedia.getVideo().getVideoTime() : 0L);
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        u(stMedia, rFWLayerPicInfo);
        RFWLayerPicInfo.RFWPicInfo currentPicInfo = rFWLayerPicInfo.getCurrentPicInfo();
        if (currentPicInfo == null || (str = currentPicInfo.getUrl()) == null) {
            str = "";
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean.k(str);
        return qZAlbumxBatchLayerSelectedMediaInfoBean;
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
        rFWPicInfo.setWidth(a0(tVar.d(stImage.e(), photoSpec)));
        rFWPicInfo.setHeight(Z(tVar.a(stImage.e(), photoSpec)));
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
        StPicUrl e16 = t.f399471a.e(stImage.e(), PhotoSpec.KPHOTOSPECDOWNLOAD);
        if (e16 == null || TextUtils.isEmpty(e16.url)) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(e16.url);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(e16.url)));
        rFWPicInfo.setWidth(e16.width);
        rFWPicInfo.setHeight(e16.height);
        layerPicInfo.setDownloadPicInfo(rFWPicInfo);
    }

    private final void s(CommonStImage stImage, RFWLayerPicInfo layerPicInfo) {
        StPicUrl f16 = t.f399471a.f(stImage.e(), PhotoSpec.KPHOTOSPECORIGIN, false);
        if (f16 == null || TextUtils.isEmpty(f16.url)) {
            return;
        }
        layerPicInfo.setOriginPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo);
        originPicInfo.setUrl(f16.url);
        RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo2);
        originPicInfo2.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(f16.url)));
        RFWLayerPicInfo.RFWPicInfo originPicInfo3 = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo3);
        originPicInfo3.setWidth(f16.width);
        RFWLayerPicInfo.RFWPicInfo originPicInfo4 = layerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo4);
        originPicInfo4.setHeight(f16.height);
    }

    private final void t(CommonStMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(M(stMedia));
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
        t tVar = t.f399471a;
        String c16 = tVar.c(stMedia.getVideo().e(), PhotoSpec.KPHOTOSPECORIGIN, false);
        if (TextUtils.isEmpty(c16)) {
            c16 = tVar.c(stMedia.getVideo().e(), PhotoSpec.KPHOTOSPECBIG, false);
        }
        rFWLayerVideoInfo.setVideoOriginUrl(c16);
        if (!TextUtils.isEmpty(rFWLayerVideoInfo.getVideoOriginUrl()) && n9.a.f419499a.a().contains(rFWLayerVideoInfo.getFileId())) {
            url = rFWLayerVideoInfo.getVideoOriginUrl();
            Intrinsics.checkNotNull(url);
        } else {
            url = stMedia.getVideo().getUrl();
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(url);
        rFWLayerVideoInfo.setVideoWidth(a0(stMedia.getVideo().getWidth()));
        rFWLayerVideoInfo.setVideoHeight(Z(stMedia.getVideo().getHeight()));
        rFWLayerVideoInfo.setVideoDurationSec(((int) stMedia.getVideo().getVideoTime()) / 1000);
        mediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    public final void A(ArrayList<CommonStMedia> selectedList) {
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        if (ArrayUtils.isOutOfArrayIndex(0, selectedList)) {
            return;
        }
        ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> arrayList = new ArrayList<>();
        Iterator<T> it = selectedList.iterator();
        while (it.hasNext()) {
            arrayList.add(B((CommonStMedia) it.next()));
        }
        this.selectedList = arrayList;
    }

    /* renamed from: C, reason: from getter */
    public final QZAlbumxAlbumDetailInitBean getAlbumDetailInitBean() {
        return this.albumDetailInitBean;
    }

    /* renamed from: E, reason: from getter */
    public final String getDataRepoKey() {
        return this.dataRepoKey;
    }

    public final ArrayList<QZAlbumxLayerExtraInfoBean> F() {
        return this.extraInfoBeanList;
    }

    /* renamed from: G, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    public final String M(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (stMedia.getType() == 1) {
            return stMedia.getVideo().getCover().getLloc();
        }
        return stMedia.getImage().getLloc();
    }

    public final String N(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (stMedia.getType() == 1) {
            return stMedia.getVideo().getCover().getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
        }
        return stMedia.getImage().getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
    }

    /* renamed from: V, reason: from getter */
    public final String getLinkId() {
        return this.linkId;
    }

    public final ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> b0() {
        return this.selectedList;
    }

    /* renamed from: c0, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void d0(String str) {
        this.albumCreatorUin = str;
    }

    public final void e0(QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean) {
        this.albumDetailInitBean = qZAlbumxAlbumDetailInitBean;
    }

    public final void f0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }

    public final void g0(ArrayList<QZAlbumxLayerExtraInfoBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.extraInfoBeanList = arrayList;
    }

    public final void h0(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void i0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.linkId = str;
    }

    public final void j0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }

    public final void k0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public void w(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<QZAlbumxLayerExtraInfoBean> arrayList = new ArrayList<>();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(x(media));
        }
        this.extraInfoBeanList = arrayList;
    }

    public final QZAlbumxLayerExtraInfoBean x(CommonStMedia stMedia) {
        long linkId;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = new QZAlbumxLayerExtraInfoBean();
        qZAlbumxLayerExtraInfoBean.E(M(stMedia));
        qZAlbumxLayerExtraInfoBean.Z(N(stMedia));
        qZAlbumxLayerExtraInfoBean.z(getAlbumId());
        qZAlbumxLayerExtraInfoBean.A(getAlbumName());
        qZAlbumxLayerExtraInfoBean.B(String.valueOf(stMedia.getBatchId()));
        qZAlbumxLayerExtraInfoBean.h0(stMedia.getType() == 1);
        if (stMedia.getLinkId() == 0) {
            linkId = stMedia.getBatchId();
        } else {
            linkId = stMedia.getLinkId();
        }
        qZAlbumxLayerExtraInfoBean.G(linkId);
        qZAlbumxLayerExtraInfoBean.c0(stMedia.n().contains(Integer.valueOf(MediaOpMask.KMEDIAOPMASKSHOWREPAIR.ordinal())));
        if (qZAlbumxLayerExtraInfoBean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            qZAlbumxLayerExtraInfoBean.i0(stMedia.getVideo().getId());
        } else {
            qZAlbumxLayerExtraInfoBean.i0("");
        }
        qZAlbumxLayerExtraInfoBean.f0(stMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String());
        qZAlbumxLayerExtraInfoBean.e0(stMedia.getUploadTime());
        qZAlbumxLayerExtraInfoBean.b0(stMedia.getShootTime());
        qZAlbumxLayerExtraInfoBean.D(stMedia.getDesc());
        qZAlbumxLayerExtraInfoBean.d0(this.uin);
        qZAlbumxLayerExtraInfoBean.C(stMedia.getComment().getCommentNum());
        qZAlbumxLayerExtraInfoBean.M(stMedia.getLike().getLiked() == 1);
        qZAlbumxLayerExtraInfoBean.V(stMedia.getLike().getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.NUM java.lang.String());
        qZAlbumxLayerExtraInfoBean.N(stMedia.getLike().getKey());
        qZAlbumxLayerExtraInfoBean.g0(stMedia.getUploadUserName());
        qZAlbumxLayerExtraInfoBean.F(stMedia.getLbs().getLocation());
        qZAlbumxLayerExtraInfoBean.y(this.albumCreatorUin);
        return qZAlbumxLayerExtraInfoBean;
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

    private final int Z(int height) {
        return height == 0 ? vj.d.f441734a.f() : height;
    }

    private final int a0(int width) {
        return width == 0 ? vj.d.f441734a.g() : width;
    }
}
