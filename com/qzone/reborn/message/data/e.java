package com.qzone.reborn.message.data;

import androidx.exifinterface.media.ExifInterface;
import bl.CommonNoticeMessageIcon;
import bl.CommonNoticePattonInfo;
import bl.CommonPattonAction;
import bl.CommonStComment;
import bl.CommonStReply;
import bl.CommonStRichMsg;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonBytesEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUserAccountEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqnt.kernel.nativeinterface.BytesEntry;
import com.tencent.qqnt.kernel.nativeinterface.Entry;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import com.tencent.qqnt.kernel.nativeinterface.StUserAccountEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xh.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H\u0002\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0000H\u0002\u001a\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002\u001a\u000e\u0010\u0017\u001a\u00020\u0016*\u0004\u0018\u00010\u0015H\u0002\u001a\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0000H\u0002\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0000H\u0002\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0018H\u0002\u001a\f\u0010\u001f\u001a\u00020\u001e*\u00020\u001aH\u0002\u001a\u000e\u0010 \u001a\u00020\n*\u0004\u0018\u00010\u0001H\u0002\u001a\n\u0010!\u001a\u00020\r*\u00020\u000e\u001a\n\u0010$\u001a\u00020#*\u00020\"\u001a\u0012\u0010(\u001a\u00020'*\u00020\r2\u0006\u0010&\u001a\u00020%\u001a\n\u0010+\u001a\u00020**\u00020)\u001a\n\u0010-\u001a\u00020,*\u00020\n\u001a\n\u00100\u001a\u00020/*\u00020.\u00a8\u00061"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "t", "", "p", "Lbl/d;", "w", "", "Lbl/h;", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lbl/b;", "r", "Lcom/qzone/proxy/feedcomponent/model/CellLeftThumb;", "Lbl/c;", HippyTKDListViewAdapter.X, "Lcom/qzone/proxy/feedcomponent/model/User;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "o", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "u", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "v", "Lbl/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbl/g;", DomainData.DOMAIN_NAME, "y", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "E", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "image", "", "l", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/StRichMsg;", "B", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {
    public static final StCommonExt A(CommonStCommonExt commonStCommonExt) {
        Intrinsics.checkNotNullParameter(commonStCommonExt, "<this>");
        StCommonExt stCommonExt = new StCommonExt();
        for (CommonEntry commonEntry : commonStCommonExt.c()) {
            Entry entry = new Entry();
            entry.key = commonEntry.getKey();
            entry.value = commonEntry.getValue();
            stCommonExt.mapInfo.add(entry);
        }
        stCommonExt.attachInfo = commonStCommonExt.getAttachInfo();
        for (CommonBytesEntry commonBytesEntry : commonStCommonExt.b()) {
            BytesEntry bytesEntry = new BytesEntry();
            bytesEntry.key = commonBytesEntry.getKey();
            bytesEntry.value = commonBytesEntry.getValue();
            stCommonExt.mapBytesInfo.add(bytesEntry);
        }
        for (CommonStUserAccountEntry commonStUserAccountEntry : commonStCommonExt.e()) {
            StUserAccountEntry stUserAccountEntry = new StUserAccountEntry();
            stUserAccountEntry.uid = commonStUserAccountEntry.getUid();
            stUserAccountEntry.account.uid = commonStUserAccountEntry.getAccount().getUid();
            stUserAccountEntry.account.uin = commonStUserAccountEntry.getAccount().getUin();
            stCommonExt.mapUserAccount.add(stUserAccountEntry);
        }
        return stCommonExt;
    }

    public static final StRichMsg B(CommonStRichMsg commonStRichMsg) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(commonStRichMsg, "<this>");
        List<CommonStMedia> b16 = commonStRichMsg.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            arrayList.add(h.i((CommonStMedia) it.next()));
        }
        ArrayList<StMedia> arrayList2 = new ArrayList<>(arrayList);
        StRichMsg stRichMsg = new StRichMsg();
        stRichMsg.type = commonStRichMsg.getType();
        stRichMsg.content = commonStRichMsg.getContent();
        stRichMsg.uid = commonStRichMsg.getUid();
        stRichMsg.name = commonStRichMsg.getName();
        stRichMsg.who = commonStRichMsg.getWho();
        stRichMsg.url = commonStRichMsg.getUrl();
        stRichMsg.uin = commonStRichMsg.getUin();
        stRichMsg.mediaItems = arrayList2;
        return stRichMsg;
    }

    public static final PictureItem C(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        PictureItem pictureItem = new PictureItem();
        if (commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal()) {
            pictureItem.videoflag = 1;
            pictureItem.videodata = E(commonStMedia.getVideo());
        } else {
            pictureItem.videoflag = 0;
            l(pictureItem, commonStMedia.getImage());
        }
        pictureItem.desc = commonStMedia.getDesc();
        pictureItem.uploadUid = commonStMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
        pictureItem.uploadTime = commonStMedia.getUploadTime();
        return pictureItem;
    }

    public static final PictureUrl D(CommonStPicUrl commonStPicUrl) {
        Intrinsics.checkNotNullParameter(commonStPicUrl, "<this>");
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = commonStPicUrl.getUrl();
        pictureUrl.width = commonStPicUrl.getWidth();
        pictureUrl.height = commonStPicUrl.getHeight();
        return pictureUrl;
    }

    public static final VideoInfo E(CommonStVideo commonStVideo) {
        Intrinsics.checkNotNullParameter(commonStVideo, "<this>");
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = commonStVideo.getUrl();
        PictureUrl D = D(commonStVideo.getCover().getDefaultUrl());
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.videoId = commonStVideo.getId();
        videoInfo.width = commonStVideo.getWidth();
        videoInfo.height = commonStVideo.getHeight();
        videoInfo.videoTime = commonStVideo.getVideoTime();
        videoInfo.videoUrl = videoUrl;
        videoInfo.lloc = commonStVideo.getCover().getLloc();
        videoInfo.sloc = commonStVideo.getCover().getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
        videoInfo.coverUrl = D;
        videoInfo.width = commonStVideo.getCover().getDefaultUrl().getWidth();
        videoInfo.height = commonStVideo.getCover().getDefaultUrl().getHeight();
        return videoInfo;
    }

    public static final /* synthetic */ CommonStComment a(Comment comment) {
        return m(comment);
    }

    public static final /* synthetic */ CommonStReply b(Reply reply) {
        return n(reply);
    }

    public static final /* synthetic */ CommonStUser c(User user) {
        return o(user);
    }

    public static final /* synthetic */ long d(BusinessFeedData businessFeedData) {
        return p(businessFeedData);
    }

    public static final /* synthetic */ CommonNoticeMessageIcon e(BusinessFeedData businessFeedData) {
        return r(businessFeedData);
    }

    public static final /* synthetic */ List f(BusinessFeedData businessFeedData) {
        return s(businessFeedData);
    }

    public static final /* synthetic */ int g(BusinessFeedData businessFeedData) {
        return t(businessFeedData);
    }

    public static final /* synthetic */ Comment h(BusinessFeedData businessFeedData) {
        return u(businessFeedData);
    }

    public static final /* synthetic */ Reply i(BusinessFeedData businessFeedData) {
        return v(businessFeedData);
    }

    public static final /* synthetic */ CommonPattonAction j(BusinessFeedData businessFeedData) {
        return w(businessFeedData);
    }

    public static final /* synthetic */ CommonNoticePattonInfo k(CellLeftThumb cellLeftThumb) {
        return x(cellLeftThumb);
    }

    public static final void l(PictureItem pictureItem, CommonStImage image) {
        Intrinsics.checkNotNullParameter(pictureItem, "<this>");
        Intrinsics.checkNotNullParameter(image, "image");
        pictureItem.picname = image.getName();
        pictureItem.lloc = image.getLloc();
        pictureItem.sloc = image.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.SLOC java.lang.String();
        for (CommonStPicSpecUrlEntry commonStPicSpecUrlEntry : image.e()) {
            int spec = commonStPicSpecUrlEntry.getSpec();
            if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal()) {
                pictureItem.originUrl = D(commonStPicSpecUrlEntry.getUrl());
            } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
                pictureItem.bigUrl = D(commonStPicSpecUrlEntry.getUrl());
            } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal()) {
                pictureItem.currentUrl = D(commonStPicSpecUrlEntry.getUrl());
            } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal()) {
                pictureItem.downloadUrl = D(commonStPicSpecUrlEntry.getUrl());
            }
        }
        String str = pictureItem.currentUrl.url;
        if (str == null || str.length() == 0) {
            pictureItem.currentUrl = D(image.getDefaultUrl());
        }
    }

    public static final CommonStComment m(Comment comment) {
        List mutableListOf;
        String commentid = comment.commentid;
        CommonStUser o16 = o(comment.user);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(y(comment.comment));
        long j3 = comment.time * 1000;
        List<CommonStMedia> z16 = z(ol.a.f423082a.a(comment));
        String str = comment.clientKey;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        int i3 = comment.replyNum;
        List<Reply> replies = comment.replies;
        Intrinsics.checkNotNullExpressionValue(replies, "replies");
        ArrayList arrayList = new ArrayList();
        for (Reply it : replies) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(n(it));
        }
        Intrinsics.checkNotNullExpressionValue(commentid, "commentid");
        return new CommonStComment(commentid, o16, mutableListOf, j3, str2, i3, arrayList, z16);
    }

    public static final CommonStReply n(Reply reply) {
        List mutableListOf;
        String replyId = reply.replyId;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(y(reply.content));
        CommonStUser o16 = o(reply.user);
        CommonStUser o17 = o(reply.targetUser);
        long j3 = reply.date * 1000;
        String str = reply.clientKey;
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(replyId, "replyId");
        return new CommonStReply(replyId, o16, mutableListOf, j3, str, o17);
    }

    public static final CommonStUser o(User user) {
        CommonStUser commonStUser = new CommonStUser();
        if (user == null) {
            return commonStUser;
        }
        String str = user.uid;
        if (str == null) {
            str = "";
        }
        commonStUser.f(str);
        commonStUser.g(String.valueOf(user.uin));
        String nickName = user.nickName;
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        commonStUser.e(nickName);
        return commonStUser;
    }

    public static final long p(BusinessFeedData businessFeedData) {
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 == null) {
            return 0L;
        }
        long j3 = feedCommInfoV2.lastModifyTime;
        long j16 = feedCommInfoV2.time;
        return j3 > j16 ? j3 : j16;
    }

    public static final String q(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        String a16 = ef.b.a(businessFeedData);
        if (a16 == null) {
            a16 = "";
        }
        return a16 + "_" + p(businessFeedData);
    }

    public static final CommonNoticeMessageIcon r(BusinessFeedData businessFeedData) {
        CommonNoticeMessageIcon commonNoticeMessageIcon = new CommonNoticeMessageIcon(0, null, 3, null);
        Integer e16 = QZonePassiveMessageFeedPreprocessor.f58250a.e(businessFeedData);
        if (e16 != null) {
            commonNoticeMessageIcon.c(e16.intValue());
        }
        return commonNoticeMessageIcon;
    }

    public static final List<CommonStRichMsg> s(BusinessFeedData businessFeedData) {
        List<CommonStRichMsg> mutableListOf;
        QZonePassiveMessageFeedPreprocessor qZonePassiveMessageFeedPreprocessor = QZonePassiveMessageFeedPreprocessor.f58250a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(y(qZonePassiveMessageFeedPreprocessor.g(businessFeedData)), new CommonStRichMsg(0, null, null, null, 0, null, null, z(qZonePassiveMessageFeedPreprocessor.f(businessFeedData)), 127, null));
        return mutableListOf;
    }

    public static final int t(BusinessFeedData businessFeedData) {
        Map<String, String> map;
        CellFeedCommInfo cellFeedCommInfo = businessFeedData.cellFeedCommInfo;
        return ef.d.j((cellFeedCommInfo == null || (map = cellFeedCommInfo.extendInfo) == null) ? null : map.get(QQHealthReportApiImpl.MSG_TYPE_KEY), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r0 != null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Comment u(BusinessFeedData businessFeedData) {
        Comment mainComment;
        CellCommentInfo commentInfoV2;
        ArrayList<Comment> arrayList;
        Object firstOrNull;
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if (originalInfo != null && (commentInfoV2 = originalInfo.getCommentInfoV2()) != null && (arrayList = commentInfoV2.commments) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            mainComment = (Comment) firstOrNull;
            if (mainComment != null) {
                List<Reply> list = mainComment.replies;
                if (!(!(list == null || list.isEmpty()))) {
                    mainComment = null;
                }
            }
        }
        mainComment = businessFeedData.getMainComment();
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        ArrayList<PictureItem> arrayList2 = cellSummaryV2 != null ? cellSummaryV2.summarypic : null;
        if (!(arrayList2 == null || arrayList2.isEmpty())) {
            if (mainComment != null) {
                CellSummary cellSummaryV22 = businessFeedData.getCellSummaryV2();
                mainComment.pictureItems = cellSummaryV22 != null ? cellSummaryV22.summarypic : null;
            }
            if (mainComment != null) {
                CellSummary cellSummaryV23 = businessFeedData.getCellSummaryV2();
                mainComment.commentPictureItems = cellSummaryV23 != null ? cellSummaryV23.summarypic : null;
            }
        }
        return mainComment;
    }

    public static final Reply v(BusinessFeedData businessFeedData) {
        if (!f.f58260a.t(businessFeedData)) {
            return null;
        }
        Reply reply = new Reply();
        reply.replyId = "";
        reply.user = businessFeedData.getUser();
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        reply.content = cellSummaryV2 != null ? cellSummaryV2.summary : null;
        reply.date = (int) (p(businessFeedData) / 1000);
        reply.targetUser = new User(LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""));
        return reply;
    }

    public static final CommonPattonAction w(BusinessFeedData businessFeedData) {
        int i3 = 0;
        CommonPattonAction commonPattonAction = new CommonPattonAction(0, null, 3, null);
        if (businessFeedData.getFeedCommInfoV2() == null) {
            return commonPattonAction;
        }
        int i16 = businessFeedData.getFeedCommInfoV2().actiontype;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = 3;
                } else if (i16 != 50) {
                    if (i16 != 51) {
                        switch (i16) {
                        }
                    }
                }
                commonPattonAction.c(i3);
                String str = businessFeedData.getFeedCommInfoV2().actionurl;
                Intrinsics.checkNotNullExpressionValue(str, "feedCommInfoV2.actionurl");
                commonPattonAction.d(str);
                return commonPattonAction;
            }
            i3 = 2;
            commonPattonAction.c(i3);
            String str2 = businessFeedData.getFeedCommInfoV2().actionurl;
            Intrinsics.checkNotNullExpressionValue(str2, "feedCommInfoV2.actionurl");
            commonPattonAction.d(str2);
            return commonPattonAction;
        }
        i3 = 1;
        commonPattonAction.c(i3);
        String str22 = businessFeedData.getFeedCommInfoV2().actionurl;
        Intrinsics.checkNotNullExpressionValue(str22, "feedCommInfoV2.actionurl");
        commonPattonAction.d(str22);
        return commonPattonAction;
    }

    public static final CommonNoticePattonInfo x(CellLeftThumb cellLeftThumb) {
        CommonStImage commonStImage;
        List mutableListOf;
        List mutableListOf2;
        PictureUrl pictureUrl;
        CommonNoticePattonInfo commonNoticePattonInfo = new CommonNoticePattonInfo(0, null, null, false, 15, null);
        QZonePassiveMessageFeedPreprocessor qZonePassiveMessageFeedPreprocessor = QZonePassiveMessageFeedPreprocessor.f58250a;
        CommonStRichMsg y16 = y(qZonePassiveMessageFeedPreprocessor.k(qZonePassiveMessageFeedPreprocessor.d(cellLeftThumb), true));
        PictureItem pictureItem = cellLeftThumb.getPictureItem();
        if (((pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null) ? null : pictureUrl.url) != null) {
            PictureItem pictureItem2 = cellLeftThumb.getPictureItem();
            Intrinsics.checkNotNullExpressionValue(pictureItem2, "pictureItem");
            commonStImage = fj.e.b(pictureItem2);
        } else {
            commonStImage = new CommonStImage();
        }
        commonNoticePattonInfo.f(k9.a.i(k9.a.k(commonStImage)) ? 2 : 1);
        commonNoticePattonInfo.h(cellLeftThumb.getMediaType() == 3);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(y16);
        commonNoticePattonInfo.g(new CommonNoticePattonInfo.CommonPlainTxtInfo(mutableListOf));
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(y16);
        commonNoticePattonInfo.e(new CommonNoticePattonInfo.CommonLeftTxtRightPicInfo(mutableListOf2, commonStImage));
        return commonNoticePattonInfo;
    }

    private static final CommonStRichMsg y(String str) {
        QZonePassiveMessageFeedPreprocessor qZonePassiveMessageFeedPreprocessor = QZonePassiveMessageFeedPreprocessor.f58250a;
        if (str == null) {
            str = "";
        }
        return new CommonStRichMsg(0, QZonePassiveMessageFeedPreprocessor.l(qZonePassiveMessageFeedPreprocessor, str, false, 2, null), null, null, 0, null, null, null, 252, null);
    }

    public static final List<CommonStMedia> z(List<? extends PictureItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends PictureItem> it = list.iterator();
        while (it.hasNext()) {
            CommonStMedia g16 = fj.e.g(it.next());
            if (g16 != null) {
                arrayList.add(g16);
            }
        }
        return arrayList;
    }
}
