package je;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellBigTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StGPS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.ArrayUtils;
import ef.d;
import fj.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0001\u001a\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0006\u001a\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0001\u001a\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0001\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u0001\u001a\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0006\u001a\u001c\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u0007*\u0004\u0018\u00010\u001a\u001a.\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u0007\u001a2\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0007*\u00020\u001f2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u0007\u001a\u0016\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001f\u001a\u0014\u0010&\u001a\u00020\u0010*\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$\u001a\f\u0010'\u001a\u00020\u0010*\u00020%H\u0002\u001a\f\u0010(\u001a\u00020\u0010*\u00020%H\u0002\u001a\f\u0010)\u001a\u00020\u0010*\u00020%H\u0002\u001a\f\u0010*\u001a\u00020\u0010*\u00020%H\u0002\u001a\u000e\u0010+\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001b\u001a\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u0006\u001a\u000e\u0010/\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010-\u001a\u000e\u00102\u001a\u0004\u0018\u000101*\u0004\u0018\u000100\u001a\u000e\u00103\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001b\u001a\u000e\u00104\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001b\u001a\f\u00105\u001a\u0004\u0018\u00010\u0014*\u00020\u001b\u001a\u0016\u00106\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0016\u00107\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0016\u00108\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0016\u00109\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0016\u0010=\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u00142\u0006\u0010<\u001a\u00020;\u001a\u0016\u0010>\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u0006\u001a\u000e\u0010A\u001a\u00020?2\u0006\u0010@\u001a\u00020?\u001a\u000e\u0010C\u001a\u00020?2\u0006\u0010B\u001a\u00020?\u001a\u000e\u0010E\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010D\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020G0$*\n\u0012\u0004\u0012\u00020F\u0018\u00010$\u001a\u000e\u0010I\u001a\u0004\u0018\u00010G*\u0004\u0018\u00010F\u001a\u000e\u0010L\u001a\u0004\u0018\u00010K*\u0004\u0018\u00010J\u001a\f\u0010N\u001a\u00020M*\u0004\u0018\u00010\u0001\u001a\f\u0010O\u001a\u00020M*\u0004\u0018\u00010\u0001\u001a\u001a\u0010Q\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010P\u001a\u0004\u0018\u00010\u001a\u001a\n\u0010S\u001a\u00020R*\u00020\u0003\u001a\u000e\u0010U\u001a\u0004\u0018\u00010T*\u0004\u0018\u00010D\u001a\f\u0010V\u001a\u0004\u0018\u00010J*\u00020D\u001a\u001e\u0010Y\u001a\u0004\u0018\u00010J*\b\u0012\u0004\u0012\u00020F0$2\n\u0010X\u001a\u00060?j\u0002`W\u001a\f\u0010Z\u001a\u00020T*\u0004\u0018\u00010J\u001a\n\u0010\\\u001a\u00020?*\u00020[\u001a\f\u0010^\u001a\u00020M*\u0004\u0018\u00010]\u001a\f\u0010_\u001a\u00020M*\u0004\u0018\u00010]\u001a\u0012\u0010`\u001a\u0004\u0018\u00010]*\b\u0012\u0004\u0012\u00020]0$\u001a\u0012\u0010a\u001a\u0004\u0018\u00010]*\b\u0012\u0004\u0012\u00020]0$\u00a8\u0006b"}, d2 = {"", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "stMediaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "albumInfo", "Ljava/util/ArrayList;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "stMedia", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "l", "o", "mediaInfo", "", "f", "", "D", "B", "E", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", h.F, "j", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "H", "mediaList", "p", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", DomainData.DOMAIN_NAME, "commonMedia", "routeBean", "k", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "P", "t", "v", "u", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLBS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "Y", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonGPS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StGPS;", "X", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "y", "g", "a", "c", "d", "commonImage", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "currentPicInfo", "b", "i", "", "width", "G", "height", UserInfo.SEX_FEMALE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicSpecUrlEntry;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "T", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicUrl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "U", "", "O", "L", "commonFeed", HippyTKDListViewAdapter.X, "Lcom/qzone/album/data/model/AlbumCacheData;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "V", "J", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PhotoSpec;", "spec", "I", "W", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBigTail;", "M", "N", "r", ReportConstant.COSTREPORT_PREFIX, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final String A(CommonMedia commonMedia) {
        String name;
        CommonImage cover;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        if (xd.c.z(commonMedia)) {
            CommonVideo video = commonMedia.getVideo();
            if (video == null || (cover = video.getCover()) == null || (name = cover.getName()) == null) {
                return "";
            }
        } else {
            CommonImage image = commonMedia.getImage();
            if (image == null || (name = image.getName()) == null) {
                return "";
            }
        }
        return name;
    }

    public static final String B(StMedia stMedia) {
        String str;
        StImage stImage;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (O(stMedia)) {
            StVideo stVideo = stMedia.video;
            if (stVideo == null || (stImage = stVideo.cover) == null || (str = stImage.name) == null) {
                return "";
            }
        } else {
            StImage stImage2 = stMedia.image;
            if (stImage2 == null || (str = stImage2.name) == null) {
                return "";
            }
        }
        return str;
    }

    public static final String C(CommonMedia commonMedia) {
        String lloc;
        CommonImage cover;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        if (xd.c.z(commonMedia)) {
            CommonVideo video = commonMedia.getVideo();
            if (video == null || (cover = video.getCover()) == null || (lloc = cover.getLloc()) == null) {
                return "";
            }
        } else {
            CommonImage image = commonMedia.getImage();
            if (image == null || (lloc = image.getLloc()) == null) {
                return "";
            }
        }
        return lloc;
    }

    public static final String D(StMedia stMedia) {
        String str;
        StImage stImage;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (O(stMedia)) {
            StVideo stVideo = stMedia.video;
            if (stVideo == null || (stImage = stVideo.cover) == null || (str = stImage.lloc) == null) {
                return "";
            }
        } else {
            StImage stImage2 = stMedia.image;
            if (stImage2 == null || (str = stImage2.lloc) == null) {
                return "";
            }
        }
        return str;
    }

    public static final String E(StMedia stMedia) {
        String str;
        StImage stImage;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (O(stMedia)) {
            StVideo stVideo = stMedia.video;
            if (stVideo == null || (stImage = stVideo.cover) == null || (str = stImage.sloc) == null) {
                return "";
            }
        } else {
            StImage stImage2 = stMedia.image;
            if (stImage2 == null || (str = stImage2.sloc) == null) {
                return "";
            }
        }
        return str;
    }

    public static final ArrayList<CommonMedia> H(CommonFeed commonFeed) {
        ArrayList<CommonMedia> arrayList = new ArrayList<>();
        if (commonFeed != null) {
            CommonCellMedia cellMedia = commonFeed.getCellMedia();
            if (!ArrayUtils.isOutOfArrayIndex(0, cellMedia != null ? cellMedia.getMediaItems() : null)) {
                CommonCellMedia cellMedia2 = commonFeed.getCellMedia();
                Intrinsics.checkNotNull(cellMedia2);
                arrayList.addAll(cellMedia2.getMediaItems());
            }
        }
        return arrayList;
    }

    public static final StPicUrl I(List<StPicSpecUrlEntry> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            StPicSpecUrlEntry stPicSpecUrlEntry = (StPicSpecUrlEntry) it.next();
            Integer num = stPicSpecUrlEntry.spec;
            if (num != null && num.intValue() == i3) {
                StPicUrl stPicUrl = stPicSpecUrlEntry.url;
                if (!TextUtils.isEmpty(stPicUrl != null ? stPicUrl.url : null)) {
                    return stPicSpecUrlEntry.url;
                }
            }
        }
    }

    public static final StPicUrl J(StImage stImage) {
        List listOf;
        Object obj;
        Intrinsics.checkNotNullParameter(stImage, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{5, 1, 6, 0, 3});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            StPicUrl I = I(stImage.photoUrl, ((Number) it.next()).intValue());
            if (I != null) {
                return I;
            }
        }
        Iterator<T> it5 = stImage.photoUrl.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj = null;
                break;
            }
            obj = it5.next();
            if (!TextUtils.isEmpty(((StPicSpecUrlEntry) obj).url != null ? r4.url : null)) {
                break;
            }
        }
        StPicSpecUrlEntry stPicSpecUrlEntry = (StPicSpecUrlEntry) obj;
        StPicUrl stPicUrl = stPicSpecUrlEntry != null ? stPicSpecUrlEntry.url : null;
        return stPicUrl == null ? stImage.defaultUrl : stPicUrl;
    }

    public static final int K(RFWLayerState rFWLayerState) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(rFWLayerState, "<this>");
        int mediaSum = rFWLayerState.getMediaSum();
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerState.getRichMediaDataList();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mediaSum, richMediaDataList != null ? richMediaDataList.size() : 0);
        return coerceAtLeast;
    }

    public static final String P(List<StRichMsg> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (StRichMsg stRichMsg : list) {
                Integer valueOf = stRichMsg != null ? Integer.valueOf(stRichMsg.type) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    sb5.append(stRichMsg.content);
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    sb5.append(t(stRichMsg));
                } else if (valueOf != null && valueOf.intValue() == 2) {
                    sb5.append(v(stRichMsg));
                } else if (valueOf != null && valueOf.intValue() == 4) {
                    sb5.append(u(stRichMsg));
                } else if (valueOf != null && valueOf.intValue() == 5) {
                    sb5.append(w(stRichMsg));
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    public static final AlbumCacheData Q(AlbumInfo albumInfo) {
        String str;
        PictureUrl V;
        StVideo stVideo;
        Intrinsics.checkNotNullParameter(albumInfo, "<this>");
        AlbumCacheData albumCacheData = new AlbumCacheData();
        StUser stUser = albumInfo.creator;
        if (stUser == null || (str = stUser.nick) == null) {
            str = "";
        }
        albumCacheData.albumOwner = str;
        albumCacheData.ownerUin = d.k(stUser != null ? stUser.uin : null);
        if (L(albumInfo.cover)) {
            StMedia stMedia = albumInfo.cover;
            V = V(stMedia != null ? stMedia.image : null);
        } else {
            StMedia stMedia2 = albumInfo.cover;
            if (stMedia2 != null && (stVideo = stMedia2.video) != null) {
                r2 = stVideo.cover;
            }
            V = V(r2);
        }
        albumCacheData.coverUrl = V;
        albumCacheData.bitmap = albumInfo.bitmap;
        Long l3 = albumInfo.uploadNumber;
        albumCacheData.albumnum = l3 != null ? (int) l3.longValue() : 0;
        albumCacheData.albumname = albumInfo.name;
        albumCacheData.albumdesc = albumInfo.desc;
        albumCacheData.albumid = albumInfo.albumId;
        Boolean bool = albumInfo.isShareAlbum;
        albumCacheData.allow_share = bool != null ? wx4.d.INSTANCE.b(bool.booleanValue()) : 0;
        return albumCacheData;
    }

    public static final List<CommonPicSpecUrlEntry> T(List<StPicSpecUrlEntry> list) {
        ArrayList arrayList = new ArrayList();
        if (ArrayUtils.isOutOfArrayIndex(0, list)) {
            return arrayList;
        }
        Intrinsics.checkNotNull(list);
        Iterator<StPicSpecUrlEntry> it = list.iterator();
        while (it.hasNext()) {
            CommonPicSpecUrlEntry S = S(it.next());
            if (S != null) {
                arrayList.add(S);
            }
        }
        return arrayList;
    }

    public static final PictureUrl W(StPicUrl stPicUrl) {
        PictureUrl pictureUrl = new PictureUrl();
        if (stPicUrl == null) {
            return pictureUrl;
        }
        pictureUrl.url = stPicUrl.url;
        Integer num = stPicUrl.width;
        pictureUrl.width = num != null ? num.intValue() : 0;
        Integer num2 = stPicUrl.height;
        pictureUrl.height = num2 != null ? num2.intValue() : 0;
        return pictureUrl;
    }

    public static final void a(CommonMedia commonMedia, RFWLayerPicInfo layerPicInfo) {
        List<CommonPicSpecUrlEntry> photoUrl;
        List<CommonPicSpecUrlEntry> photoUrl2;
        List<CommonPicSpecUrlEntry> photoUrl3;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(layerPicInfo, "layerPicInfo");
        CommonImage image = commonMedia.getImage();
        String c16 = (image == null || (photoUrl3 = image.getPhotoUrl()) == null) ? null : xd.d.c(photoUrl3, 1);
        int i3 = 0;
        if (c16 == null || c16.length() == 0) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(c16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c16)));
        CommonImage image2 = commonMedia.getImage();
        rFWPicInfo.setWidth(G((image2 == null || (photoUrl2 = image2.getPhotoUrl()) == null) ? 0 : xd.d.h(photoUrl2, 1)));
        CommonImage image3 = commonMedia.getImage();
        if (image3 != null && (photoUrl = image3.getPhotoUrl()) != null) {
            i3 = xd.d.d(photoUrl, 1);
        }
        rFWPicInfo.setHeight(F(i3));
        layerPicInfo.setBigPicInfo(rFWPicInfo);
    }

    public static final void b(CommonImage commonImage, RFWLayerPicInfo.RFWPicInfo currentPicInfo) {
        Intrinsics.checkNotNullParameter(commonImage, "commonImage");
        Intrinsics.checkNotNullParameter(currentPicInfo, "currentPicInfo");
        String c16 = xd.d.c(commonImage.getPhotoUrl(), 5);
        String c17 = xd.d.c(commonImage.getPhotoUrl(), 1);
        if (c16.length() > 0) {
            currentPicInfo.setUrl(c16);
            currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c16)));
        } else {
            if (c17.length() > 0) {
                currentPicInfo.setUrl(c17);
                currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c17)));
            }
        }
    }

    public static final void c(CommonMedia commonMedia, RFWLayerPicInfo layerPicInfo) {
        List<CommonPicSpecUrlEntry> photoUrl;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(layerPicInfo, "layerPicInfo");
        CommonImage image = commonMedia.getImage();
        String c16 = (image == null || (photoUrl = image.getPhotoUrl()) == null) ? null : xd.d.c(photoUrl, 6);
        if (c16 == null || c16.length() == 0) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(c16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c16)));
        layerPicInfo.setDownloadPicInfo(rFWPicInfo);
    }

    public static final void d(CommonMedia commonMedia, RFWLayerPicInfo layerPicInfo) {
        List<CommonPicSpecUrlEntry> photoUrl;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(layerPicInfo, "layerPicInfo");
        CommonImage image = commonMedia.getImage();
        String c16 = (image == null || (photoUrl = image.getPhotoUrl()) == null) ? null : xd.d.c(photoUrl, 0);
        if (c16 == null || c16.length() == 0) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(c16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(c16)));
        layerPicInfo.setOriginPicInfo(rFWPicInfo);
    }

    public static final void e(CommonMedia commonMedia, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(C(commonMedia));
        g(commonMedia, rFWLayerPicInfo);
        mediaInfo.setMediaId(rFWLayerPicInfo.getPicId());
        mediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    public static final void f(StMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(D(stMedia));
        h(stMedia, rFWLayerPicInfo);
        mediaInfo.setMediaId(rFWLayerPicInfo.getPicId());
        mediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    public static final void g(CommonMedia commonMedia, RFWLayerPicInfo layerPicInfo) {
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(layerPicInfo, "layerPicInfo");
        CommonImage y16 = y(commonMedia);
        if (y16 == null) {
            return;
        }
        a(commonMedia, layerPicInfo);
        c(commonMedia, layerPicInfo);
        d(commonMedia, layerPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo);
            if (bigPicInfo.getWidth() != 0) {
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                double height = r5.getHeight() * 1.0d;
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                if (height / r5.getWidth() > 2.5d) {
                    RFWLayerPicInfo.RFWPicInfo bigPicInfo2 = layerPicInfo.getBigPicInfo();
                    Intrinsics.checkNotNull(bigPicInfo2);
                    layerPicInfo.setCurrentPicInfo(bigPicInfo2);
                    return;
                }
            }
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        b(y16, rFWPicInfo);
        rFWPicInfo.setWidth(xd.d.h(y16.getPhotoUrl(), 5));
        rFWPicInfo.setHeight(xd.d.d(y16.getPhotoUrl(), 5));
        if (rFWPicInfo.getWidth() == 0 || rFWPicInfo.getHeight() == 0) {
            rFWPicInfo.setWidth(xd.d.b());
            rFWPicInfo.setHeight(xd.d.a());
        }
        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            layerPicInfo.setSmallPicInfo(layerPicInfo.getCurrentPicInfo());
            RFWLayerPicInfo.RFWPicInfo bigPicInfo3 = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo3);
            layerPicInfo.setCurrentPicInfo(bigPicInfo3);
        }
    }

    public static final void h(StMedia stMedia, RFWLayerPicInfo layerPicInfo) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        Intrinsics.checkNotNullParameter(layerPicInfo, "layerPicInfo");
        CommonImage z16 = z(stMedia);
        if (z16 == null) {
            return;
        }
        a(CommonMediaKt.toCommon(stMedia), layerPicInfo);
        c(CommonMediaKt.toCommon(stMedia), layerPicInfo);
        d(CommonMediaKt.toCommon(stMedia), layerPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo);
            if (bigPicInfo.getWidth() != 0) {
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                double height = r5.getHeight() * 1.0d;
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                if (height / r5.getWidth() > 2.5d) {
                    RFWLayerPicInfo.RFWPicInfo bigPicInfo2 = layerPicInfo.getBigPicInfo();
                    Intrinsics.checkNotNull(bigPicInfo2);
                    layerPicInfo.setCurrentPicInfo(bigPicInfo2);
                    return;
                }
            }
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        b(z16, rFWPicInfo);
        rFWPicInfo.setWidth(xd.d.h(z16.getPhotoUrl(), 5));
        rFWPicInfo.setHeight(xd.d.d(z16.getPhotoUrl(), 5));
        if (rFWPicInfo.getWidth() == 0 || rFWPicInfo.getHeight() == 0) {
            rFWPicInfo.setWidth(xd.d.b());
            rFWPicInfo.setHeight(xd.d.a());
        }
        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            layerPicInfo.setSmallPicInfo(layerPicInfo.getCurrentPicInfo());
            RFWLayerPicInfo.RFWPicInfo bigPicInfo3 = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo3);
            layerPicInfo.setCurrentPicInfo(bigPicInfo3);
        }
    }

    public static final void i(CommonMedia commonMedia, RFWLayerItemMediaInfo mediaInfo) {
        CommonVideo video;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (xd.c.z(commonMedia) && (video = commonMedia.getVideo()) != null) {
            RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
            String id5 = video.getId();
            String str = "";
            if (id5 == null) {
                id5 = "";
            }
            rFWLayerVideoInfo.setFileId(id5);
            if (xd.d.c(video.getVideoUrl(), 5).length() == 0) {
                String url = video.getUrl();
                if (url != null) {
                    str = url;
                }
            } else {
                str = xd.d.c(video.getVideoUrl(), 5);
            }
            String c16 = xd.d.c(video.getVideoUrl(), 0);
            rFWLayerVideoInfo.setNormalVideoUrl(str);
            rFWLayerVideoInfo.setCurrentVideoUrl(str);
            rFWLayerVideoInfo.setVideoOriginUrl(c16);
            rFWLayerVideoInfo.setVideoWidth(G(video.getWidth()));
            rFWLayerVideoInfo.setVideoHeight(F(video.getHeight()));
            rFWLayerVideoInfo.setVideoDurationSec(((int) video.getVideoTime()) / 1000);
            mediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        }
    }

    public static final void j(StMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        StVideo stVideo;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (O(stMedia) && (stVideo = stMedia.video) != null) {
            RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
            String str = stVideo.id;
            if (str == null) {
                str = "";
            }
            rFWLayerVideoInfo.setFileId(str);
            String c16 = xd.d.c(T(stVideo.videoUrl), 5);
            if (c16.length() == 0) {
                String str2 = stVideo.url;
                c16 = str2 != null ? str2 : "";
            }
            String c17 = xd.d.c(T(stVideo.videoUrl), 0);
            rFWLayerVideoInfo.setNormalVideoUrl(c16);
            rFWLayerVideoInfo.setCurrentVideoUrl(c16);
            rFWLayerVideoInfo.setVideoOriginUrl(c17);
            Integer num = stVideo.width;
            rFWLayerVideoInfo.setVideoWidth(G(num != null ? num.intValue() : 0));
            Integer num2 = stVideo.height;
            rFWLayerVideoInfo.setVideoHeight(F(num2 != null ? num2.intValue() : 0));
            Long l3 = stVideo.videoTime;
            rFWLayerVideoInfo.setVideoDurationSec((l3 != null ? (int) l3.longValue() : 0) / 1000);
            mediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        }
    }

    public static final QzoneFeedProLayerExtraInfoBean k(CommonMedia commonMedia, QzoneFeedProLayerRouteBean routeBean) {
        String str;
        long k3;
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        Intrinsics.checkNotNullParameter(routeBean, "routeBean");
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = new QzoneFeedProLayerExtraInfoBean(null, null, null, null, false, null, null, 0L, null, 0L, false, 0, 0, 0L, 16383, null);
        qzoneFeedProLayerExtraInfoBean.x(A(commonMedia));
        qzoneFeedProLayerExtraInfoBean.v(C(commonMedia));
        qzoneFeedProLayerExtraInfoBean.u(commonMedia.getDesc());
        qzoneFeedProLayerExtraInfoBean.q(routeBean.getAlbumId());
        qzoneFeedProLayerExtraInfoBean.r(routeBean.getAlbumName());
        qzoneFeedProLayerExtraInfoBean.s(commonMedia.getBatchId());
        qzoneFeedProLayerExtraInfoBean.D(xd.c.z(commonMedia));
        if (qzoneFeedProLayerExtraInfoBean.getIsVideo()) {
            CommonVideo video = commonMedia.getVideo();
            str = video != null ? video.getId() : null;
        } else {
            str = "";
        }
        qzoneFeedProLayerExtraInfoBean.E(str);
        CommonUser uploadUser = commonMedia.getUploadUser();
        String uin = uploadUser != null ? uploadUser.getUin() : null;
        if (uin == null || uin.length() == 0) {
            k3 = d.k(routeBean.getUploadUser());
        } else {
            CommonUser uploadUser2 = commonMedia.getUploadUser();
            k3 = d.k(uploadUser2 != null ? uploadUser2.getUin() : null);
        }
        qzoneFeedProLayerExtraInfoBean.y(k3);
        CommonMediaLike like = commonMedia.getLike();
        if (like != null) {
            qzoneFeedProLayerExtraInfoBean.A(like.getNum());
            qzoneFeedProLayerExtraInfoBean.z(like.getLiked());
        }
        CommonMediaComment comment = commonMedia.getComment();
        if (comment != null) {
            qzoneFeedProLayerExtraInfoBean.t(comment.getNum());
        }
        Iterator<T> it = commonMedia.getOpMask().iterator();
        while (it.hasNext()) {
            qzoneFeedProLayerExtraInfoBean.j().add(Integer.valueOf(((Number) it.next()).intValue()));
        }
        qzoneFeedProLayerExtraInfoBean.C(commonMedia.getShootTime());
        qzoneFeedProLayerExtraInfoBean.w(Y(commonMedia.getLbs()));
        return qzoneFeedProLayerExtraInfoBean;
    }

    public static final RFWLayerItemMediaInfo m(CommonMedia commonMedia) {
        Intrinsics.checkNotNullParameter(commonMedia, "commonMedia");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        e(commonMedia, rFWLayerItemMediaInfo);
        i(commonMedia, rFWLayerItemMediaInfo);
        return rFWLayerItemMediaInfo;
    }

    public static final ArrayList<QzoneFeedProLayerExtraInfoBean> n(QzoneFeedProLayerRouteBean qzoneFeedProLayerRouteBean, ArrayList<CommonMedia> mediaList) {
        Intrinsics.checkNotNullParameter(qzoneFeedProLayerRouteBean, "<this>");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        ArrayList<QzoneFeedProLayerExtraInfoBean> arrayList = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return arrayList;
        }
        Iterator<CommonMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(k(media, qzoneFeedProLayerRouteBean));
        }
        return arrayList;
    }

    public static final RFWLayerItemMediaInfo o(StMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        f(stMedia, rFWLayerItemMediaInfo);
        j(stMedia, rFWLayerItemMediaInfo);
        return rFWLayerItemMediaInfo;
    }

    public static final ArrayList<RFWLayerItemMediaInfo> p(ArrayList<CommonMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return arrayList;
        }
        Iterator<CommonMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(m(media));
        }
        return arrayList;
    }

    public static final ArrayList<RFWLayerItemMediaInfo> q(List<StMedia> stMediaList, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(stMediaList, "stMediaList");
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, stMediaList)) {
            return arrayList;
        }
        for (StMedia stMedia : stMediaList) {
            RFWLayerItemMediaInfo o16 = o(stMedia);
            o16.setExtraData(l(stMedia, albumInfo));
            arrayList.add(o16);
        }
        return arrayList;
    }

    public static final CommonCellBigTail r(List<CommonCellBigTail> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (M((CommonCellBigTail) obj)) {
                break;
            }
        }
        return (CommonCellBigTail) obj;
    }

    public static final CommonCellBigTail s(List<CommonCellBigTail> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (N((CommonCellBigTail) obj)) {
                break;
            }
        }
        return (CommonCellBigTail) obj;
    }

    private static final String t(StRichMsg stRichMsg) {
        String a16 = s.f399470a.a(String.valueOf(stRichMsg.uin), stRichMsg.name);
        return "@{uin:" + stRichMsg.uin + ",nick:" + a16 + ",who:" + stRichMsg.who + "}";
    }

    private static final String u(StRichMsg stRichMsg) {
        return "{topic:#" + stRichMsg.content + ",url:" + stRichMsg.url + "}";
    }

    private static final String v(StRichMsg stRichMsg) {
        return "{url:" + mk.h.f416877a.a(stRichMsg.url, null) + ",text:" + stRichMsg.content + "}";
    }

    private static final String w(StRichMsg stRichMsg) {
        return "<uin:" + stRichMsg.uin + ",nickname:" + stRichMsg.name + ">";
    }

    public static final RFWLayerPicInfo x(CommonMedia commonMedia, CommonFeed commonFeed) {
        CommonImage image;
        String g16;
        CommonVideo video;
        CommonImage cover;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        if (commonMedia == null) {
            return rFWLayerPicInfo;
        }
        String str = "";
        if (!xd.c.z(commonMedia) ? !((image = commonMedia.getImage()) == null || (g16 = xd.d.g(image)) == null) : !((video = commonMedia.getVideo()) == null || (cover = video.getCover()) == null || (g16 = xd.d.g(cover)) == null)) {
            str = g16;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("generateLayerPicInfo", 1, "url is empty, feed ufKey is " + CommonFeedExtKt.getFeedUniqueKey(commonFeed));
        }
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(str);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(str)));
        return rFWLayerPicInfo;
    }

    public static final CommonImage y(CommonMedia commonMedia) {
        Intrinsics.checkNotNullParameter(commonMedia, "<this>");
        if (xd.c.z(commonMedia)) {
            CommonVideo video = commonMedia.getVideo();
            if (video != null) {
                return video.getCover();
            }
            return null;
        }
        return commonMedia.getImage();
    }

    public static final CommonImage z(StMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "<this>");
        if (O(stMedia)) {
            StVideo stVideo = stMedia.video;
            return R(stVideo != null ? stVideo.cover : null);
        }
        StImage stImage = stMedia.image;
        if (stImage != null) {
            return R(stImage);
        }
        return null;
    }

    public static final int F(int i3) {
        return i3 == 0 ? xd.d.a() : i3;
    }

    public static final int G(int i3) {
        return i3 == 0 ? xd.d.b() : i3;
    }

    public static final boolean L(StMedia stMedia) {
        Integer num;
        return (stMedia == null || (num = stMedia.type) == null || num.intValue() != 0) ? false : true;
    }

    public static final boolean M(CommonCellBigTail commonCellBigTail) {
        Integer type;
        return (commonCellBigTail == null || (type = commonCellBigTail.getType()) == null || type.intValue() != 2) ? false : true;
    }

    public static final boolean N(CommonCellBigTail commonCellBigTail) {
        Integer type;
        return (commonCellBigTail == null || (type = commonCellBigTail.getType()) == null || type.intValue() != 3) ? false : true;
    }

    public static final boolean O(StMedia stMedia) {
        Integer num;
        return (stMedia == null || (num = stMedia.type) == null || num.intValue() != 1) ? false : true;
    }

    public static final CommonImage R(StImage stImage) {
        if (stImage == null) {
            return null;
        }
        CommonImage commonImage = new CommonImage();
        commonImage.setName(stImage.name);
        commonImage.setLloc(stImage.lloc);
        commonImage.setSloc(stImage.sloc);
        commonImage.setPhotoUrl(T(stImage.photoUrl));
        commonImage.setDefaultUrl(U(stImage.defaultUrl));
        Boolean bool = stImage.isGif;
        commonImage.setGif(bool != null ? bool.booleanValue() : false);
        commonImage.setType(stImage.type);
        Boolean bool2 = stImage.hasRaw;
        commonImage.setHasRaw(bool2 != null ? bool2.booleanValue() : false);
        return commonImage;
    }

    public static final CommonPicSpecUrlEntry S(StPicSpecUrlEntry stPicSpecUrlEntry) {
        if (stPicSpecUrlEntry == null) {
            return null;
        }
        CommonPicSpecUrlEntry commonPicSpecUrlEntry = new CommonPicSpecUrlEntry();
        commonPicSpecUrlEntry.setSpec(stPicSpecUrlEntry.spec);
        commonPicSpecUrlEntry.setUrl(U(stPicSpecUrlEntry.url));
        return commonPicSpecUrlEntry;
    }

    public static final CommonPicUrl U(StPicUrl stPicUrl) {
        if (stPicUrl == null) {
            return null;
        }
        CommonPicUrl commonPicUrl = new CommonPicUrl();
        commonPicUrl.setUrl(stPicUrl.url);
        Integer num = stPicUrl.width;
        commonPicUrl.setWidth(num != null ? num.intValue() : 0);
        Integer num2 = stPicUrl.height;
        commonPicUrl.setHeight(num2 != null ? num2.intValue() : 0);
        return commonPicUrl;
    }

    public static final PictureUrl V(StImage stImage) {
        StPicUrl J;
        if (stImage == null || (J = J(stImage)) == null) {
            return null;
        }
        return W(J);
    }

    public static final StGPS X(CommonGPS commonGPS) {
        if (commonGPS == null) {
            return null;
        }
        StGPS stGPS = new StGPS(null, null, null, null, 15, null);
        stGPS.alt = Long.valueOf(commonGPS.getAlt());
        stGPS.lat = Long.valueOf(commonGPS.getLat());
        stGPS.lon = Long.valueOf(commonGPS.getLon());
        stGPS.eType = Long.valueOf(commonGPS.getEType());
        return stGPS;
    }

    public static final StLBS Y(CommonLBS commonLBS) {
        if (commonLBS == null) {
            return null;
        }
        StLBS stLBS = new StLBS(null, null, null, null, 15, null);
        stLBS.id = commonLBS.getId();
        stLBS.location = commonLBS.getLocation();
        stLBS.gps = X(commonLBS.getGps());
        stLBS.address = commonLBS.getAddress();
        return stLBS;
    }

    public static final QzoneFeedProLayerExtraInfoBean l(StMedia stMedia, AlbumInfo albumInfo) {
        String str;
        String str2;
        long k3;
        StUser stUser;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = new QzoneFeedProLayerExtraInfoBean(null, null, null, null, false, null, null, 0L, null, 0L, false, 0, 0, 0L, 16383, null);
        qzoneFeedProLayerExtraInfoBean.x(B(stMedia));
        qzoneFeedProLayerExtraInfoBean.B(E(stMedia));
        qzoneFeedProLayerExtraInfoBean.v(D(stMedia));
        Long l3 = stMedia.batchId;
        qzoneFeedProLayerExtraInfoBean.s(l3 != null ? l3.longValue() : 0L);
        qzoneFeedProLayerExtraInfoBean.u(stMedia.desc);
        String str3 = "";
        if (albumInfo == null || (str = albumInfo.albumId) == null) {
            str = "";
        }
        qzoneFeedProLayerExtraInfoBean.q(str);
        if (albumInfo == null || (str2 = albumInfo.name) == null) {
            str2 = "";
        }
        qzoneFeedProLayerExtraInfoBean.r(str2);
        qzoneFeedProLayerExtraInfoBean.D(O(stMedia));
        if (qzoneFeedProLayerExtraInfoBean.getIsVideo()) {
            StVideo stVideo = stMedia.video;
            str3 = stVideo != null ? stVideo.id : null;
        }
        qzoneFeedProLayerExtraInfoBean.E(str3);
        StUser stUser2 = stMedia.uploadUser;
        String str4 = stUser2 != null ? stUser2.uin : null;
        if (str4 == null || str4.length() == 0) {
            if (albumInfo != null && (stUser = albumInfo.creator) != null) {
                r7 = stUser.uin;
            }
            k3 = d.k(r7);
        } else {
            StUser stUser3 = stMedia.uploadUser;
            k3 = d.k(stUser3 != null ? stUser3.uin : null);
        }
        qzoneFeedProLayerExtraInfoBean.y(k3);
        StMediaLike stMediaLike = stMedia.like;
        if (stMediaLike != null) {
            Integer num = stMediaLike.num;
            qzoneFeedProLayerExtraInfoBean.A(num != null ? num.intValue() : 0);
            Boolean bool = stMediaLike.liked;
            qzoneFeedProLayerExtraInfoBean.z(bool != null ? bool.booleanValue() : false);
        }
        StMediaComment stMediaComment = stMedia.comment;
        if (stMediaComment != null) {
            Integer num2 = stMediaComment.num;
            qzoneFeedProLayerExtraInfoBean.t(num2 != null ? num2.intValue() : 0);
        }
        qzoneFeedProLayerExtraInfoBean.j().addAll(stMedia.opMask);
        Long l16 = stMedia.shootTime;
        qzoneFeedProLayerExtraInfoBean.C(l16 != null ? l16.longValue() : 0L);
        qzoneFeedProLayerExtraInfoBean.w(stMedia.lbs);
        return qzoneFeedProLayerExtraInfoBean;
    }
}
