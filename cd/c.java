package cd;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.util.t;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001c\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J&\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000b\u00a8\u0006$"}, d2 = {"Lcd/c;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams$a;", "a", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "c", "", "requestCode", "d", "", "selfAction", "nickName", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "commentReplyParam", "e", "Lcom/qzone/reborn/albumx/common/bean/d;", "layerFeedInfo", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "g", "themeMode", "", DomainData.DOMAIN_NAME, tl.h.F, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a */
    public static final c f30656a = new c();

    c() {
    }

    @JvmStatic
    public static final QZoneCommentPanelParams.a a(BusinessFeedData feedData) {
        QZoneCommentPanelParams.a aVar = new QZoneCommentPanelParams.a();
        if (feedData == null) {
            RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "buildCommonParamsByFeed error, " + feedData);
            return aVar;
        }
        CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
        String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "feedData.feedCommInfo?.feedsid ?: \"\"");
        }
        aVar.o(str);
        CellFeedCommInfo feedCommInfo2 = feedData.getFeedCommInfo();
        String str3 = feedCommInfo2 != null ? feedCommInfo2.ugckey : null;
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "feedData.feedCommInfo?.ugckey ?: \"\"");
        }
        aVar.e(str3);
        CellFeedCommInfo feedCommInfo3 = feedData.getFeedCommInfo();
        String str4 = feedCommInfo3 != null ? feedCommInfo3.feedskey : null;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "feedData.feedCommInfo?.feedskey ?: \"\"");
        }
        aVar.g(str4);
        CellFeedCommInfo feedCommInfo4 = feedData.getFeedCommInfo();
        String str5 = feedCommInfo4 != null ? feedCommInfo4.feedskey : null;
        if (str5 != null) {
            Intrinsics.checkNotNullExpressionValue(str5, "feedData.feedCommInfo?.feedskey ?: \"\"");
            str2 = str5;
        }
        aVar.f(str2);
        aVar.n(feedData.isFeedCommentInsertImage());
        return aVar;
    }

    @JvmStatic
    public static final QZoneCommentPanelParams.a b(BusinessFeedData feedData, String r95) {
        QZoneCommentPanelParams.a aVar = new QZoneCommentPanelParams.a();
        boolean z16 = false;
        if (feedData == null) {
            RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "buildParamsByFeed error, " + r95 + ", " + feedData);
            return aVar;
        }
        boolean l3 = QZoneFeedUtil.l(feedData, 17);
        CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
        String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "feedData.feedCommInfo?.feedsid ?: \"\"");
        }
        aVar.o(str);
        CellFeedCommInfo feedCommInfo2 = feedData.getFeedCommInfo();
        String str3 = feedCommInfo2 != null ? feedCommInfo2.ugckey : null;
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "feedData.feedCommInfo?.ugckey ?: \"\"");
        }
        aVar.e(str3);
        CellFeedCommInfo feedCommInfo3 = feedData.getFeedCommInfo();
        String str4 = feedCommInfo3 != null ? feedCommInfo3.feedskey : null;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "feedData.feedCommInfo?.feedskey ?: \"\"");
        }
        aVar.g(str4);
        CellFeedCommInfo feedCommInfo4 = feedData.getFeedCommInfo();
        String str5 = feedCommInfo4 != null ? feedCommInfo4.feedskey : null;
        if (str5 != null) {
            Intrinsics.checkNotNullExpressionValue(str5, "feedData.feedCommInfo?.feedskey ?: \"\"");
            str2 = str5;
        }
        aVar.f(str2);
        aVar.b(feedData);
        aVar.n(feedData.isFeedCommentInsertImage());
        aVar.m(l(feedData));
        aVar.j(TextUtils.isEmpty(r95) && k(feedData));
        if (TextUtils.isEmpty(r95) && l3) {
            z16 = true;
        }
        aVar.u(z16);
        return aVar;
    }

    @JvmStatic
    public static final QZoneCommentPanelParams.a c(CommonFeed feedData, String r65) {
        QZoneCommentPanelParams.a aVar = new QZoneCommentPanelParams.a();
        if (feedData == null) {
            RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "buildParamsByFeed error, " + r65 + ", " + feedData);
            return aVar;
        }
        aVar.o(CommonFeedExtKt.getFeedUniqueKey(feedData));
        aVar.e(CommonFeedExtKt.getFeedUniqueKey(feedData));
        aVar.g(CommonFeedExtKt.getFeedUniqueKey(feedData));
        aVar.f(CommonFeedExtKt.getFeedUniqueKey(feedData));
        aVar.n(true);
        return aVar;
    }

    @JvmStatic
    public static final QZoneCommentPanelParams.a d(BusinessFeedData feedData, int requestCode) {
        QZoneCommentPanelParams.a aVar = new QZoneCommentPanelParams.a();
        if (feedData == null) {
            RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "buildShareParamsByFeed error, " + requestCode + ", " + feedData);
            return aVar;
        }
        CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
        String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "feedData.feedCommInfo?.feedsid ?: \"\"");
        }
        aVar.o(str);
        CellFeedCommInfo feedCommInfo2 = feedData.getFeedCommInfo();
        String str3 = feedCommInfo2 != null ? feedCommInfo2.ugckey : null;
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "feedData.feedCommInfo?.ugckey ?: \"\"");
        }
        aVar.e(str3);
        CellFeedCommInfo feedCommInfo3 = feedData.getFeedCommInfo();
        String str4 = feedCommInfo3 != null ? feedCommInfo3.feedskey : null;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "feedData.feedCommInfo?.feedskey ?: \"\"");
        }
        aVar.g(str4);
        CellFeedCommInfo feedCommInfo4 = feedData.getFeedCommInfo();
        String str5 = feedCommInfo4 != null ? feedCommInfo4.feedskey : null;
        if (str5 != null) {
            Intrinsics.checkNotNullExpressionValue(str5, "feedData.feedCommInfo?.feedskey ?: \"\"");
            str2 = str5;
        }
        aVar.f(str2);
        aVar.C(m(feedData, requestCode));
        return aVar;
    }

    @JvmStatic
    public static final String i(boolean selfAction, String nickName) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        if (selfAction) {
            String a16 = com.qzone.util.l.a(R.string.glb);
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            HardCodeUt\u2026blis_mood_hint)\n        }");
            return a16;
        }
        String format = com.qzone.util.l.a(R.string.f2197567_);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(format, "format");
        String format2 = String.format(format, Arrays.copyOf(new Object[]{nickName}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    public final int h() {
        int g16 = com.qzone.reborn.util.i.b().g(KuiklyLaunchParams.PARAM_QUI_TOKEN_THEME_MODE, 1000);
        n(1000);
        return g16;
    }

    public final void n(int i3) {
        com.qzone.reborn.util.i.b().o(KuiklyLaunchParams.PARAM_QUI_TOKEN_THEME_MODE, i3);
    }

    @JvmStatic
    public static final boolean k(BusinessFeedData feedData) {
        if (feedData == null || feedData.getFeedCommInfoV2() == null || (feedData.getOriginalInfo() != null && feedData.getOriginalInfo().getOriginalInfo() != null && feedData.getOriginalInfo().getUser().uin > 0)) {
            return false;
        }
        int i3 = feedData.getFeedCommInfoV2().appid;
        return i3 == 4 || i3 == 202 || i3 == 311;
    }

    @JvmStatic
    public static final boolean l(BusinessFeedData feedData) {
        if (feedData == null || feedData.getFeedCommInfoV2() == null || (feedData.getOriginalInfo() != null && feedData.getOriginalInfo().getOriginalInfo() != null && feedData.getOriginalInfo().getUser().uin > 0)) {
            return false;
        }
        int i3 = feedData.getFeedCommInfoV2().appid;
        return i3 == 4 || i3 == 311;
    }

    @JvmStatic
    public static final String f(com.qzone.reborn.albumx.common.bean.d layerFeedInfo, int requestCode) {
        if (requestCode != -1 && layerFeedInfo != null) {
            return requestCode + "_" + LoginData.getInstance().getUin() + "_" + layerFeedInfo.getAlbumId() + "_" + layerFeedInfo.getBatchId();
        }
        RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "generateCacheKey error, " + requestCode + ", " + layerFeedInfo);
        return "";
    }

    public final String g(CommonAlbumInfo albumInfo, int requestCode) {
        if (requestCode != -1 && albumInfo != null) {
            return requestCode + "_" + LoginData.getInstance().getUin() + "_" + albumInfo.getAlbumId() + "_" + albumInfo.getCreator().getUin();
        }
        RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "generateCacheKey error, " + requestCode + ", " + albumInfo);
        return "";
    }

    public static /* synthetic */ String j(boolean z16, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            str = "";
        }
        return i(z16, str);
    }

    @JvmStatic
    public static final String e(BusinessFeedData feedData, CommentReplyParam commentReplyParam, int requestCode) {
        ArrayList<PictureItem> arrayList;
        if (requestCode != -1 && commentReplyParam != null && feedData != null) {
            if (requestCode == 1207 && TextUtils.isEmpty(commentReplyParam.getCommentID()) && TextUtils.isEmpty(commentReplyParam.getReplyID()) && feedData.getFeedCommInfo().appid == 4) {
                CellPictureInfo pictureInfo = feedData.getPictureInfo();
                if ((pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() != 1) ? false : true) {
                    String str = feedData.getPictureInfo().pics.get(0).lloc;
                    Intrinsics.checkNotNullExpressionValue(str, "feedData.pictureInfo.pics[0].lloc");
                    if (feedData.getUser().uin >= 10001 && !TextUtils.isEmpty(feedData.getPictureInfo().albumid) && !TextUtils.isEmpty(str)) {
                        return feedData.getUser().uin + "_" + feedData.getPictureInfo().albumid + "_" + str;
                    }
                }
            }
            String str2 = feedData.getFeedCommInfo().ugckey;
            switch (requestCode) {
                case 1205:
                    return str2 + "_SHARE";
                case 1206:
                    return str2 + "_FORWARD";
                case 1207:
                    if (!TextUtils.isEmpty(commentReplyParam.getCommentID())) {
                        str2 = str2 + "_" + commentReplyParam.getCommentID();
                    }
                    if (TextUtils.isEmpty(commentReplyParam.getReplyID())) {
                        return str2;
                    }
                    return str2 + "_" + commentReplyParam.getReplyID();
                case 1208:
                    if (!TextUtils.isEmpty(commentReplyParam.getCommentID())) {
                        str2 = str2 + "_" + commentReplyParam.getCommentID();
                    }
                    if (TextUtils.isEmpty(commentReplyParam.getReplyID())) {
                        return str2;
                    }
                    return str2 + "_" + commentReplyParam.getReplyID();
                default:
                    return str2;
            }
        }
        RFWLog.e("QZoneCommentParamsUtil", RFWLog.USR, "generateCacheKey error, " + requestCode + ", " + commentReplyParam + ", " + feedData);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean m(BusinessFeedData businessFeedData, int i3) {
        boolean z16;
        ArrayList<s_droplist_option> arrayList;
        s_droplist_option s_droplist_optionVar;
        if (businessFeedData == null) {
            return false;
        }
        if (i3 != 1206 && i3 != 1205) {
            return false;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (!(videoInfo != null && videoInfo.videoStatus == 4)) {
            if (!(videoInfo != null && videoInfo.videoStatus == 7)) {
                z16 = false;
                if (z16 && !businessFeedData.isFriendAnniversaryFeed() && !businessFeedData.isCardFollowMoreRecommendContainerFeed() && !QZoneAdFeedUtils.f55717a.M(businessFeedData) && !QZoneAdFeedDataExtKt.isNativeAd(businessFeedData) && (arrayList = businessFeedData.getFeedCommInfo().customDroplist) != null && arrayList.size() > 0 && (s_droplist_optionVar = arrayList.get(0)) != null && s_droplist_optionVar.actiontype != 38) {
                    return false;
                }
                if (t.f55783a == -1) {
                    t.f55783a = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin());
                }
                return (t.f55783a & 8) == 0;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (t.f55783a == -1) {
        }
        if ((t.f55783a & 8) == 0) {
        }
    }
}
