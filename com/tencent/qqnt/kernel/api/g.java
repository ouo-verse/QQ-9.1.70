package com.tencent.qqnt.kernel.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumModifyMask;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceAddAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteMediasCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteQunFeedCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAllAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetFeedByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMainPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListTailTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunRightCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceModifyAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQueryQuoteToQunAlbumStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQunAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQzoneCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceReportViewQunFeedCallback;
import com.tencent.qqnt.kernel.nativeinterface.IReddotReaderServiceGetRedPointsCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTDeleteQunFeedReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAllAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetFeedByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListTailTabReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedsReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunRightReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQueryQuoteToQunAlbumStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQunAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQzoneReq;
import com.tencent.qqnt.kernel.nativeinterface.NTReportViewQunFeedReq;
import com.tencent.qqnt.kernel.nativeinterface.SceneType;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StLike;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u0016\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0015H&J&\u0010\u0019\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0018H&J\u001c\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u001cH&J\u001c\u0010 \u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u001fH&J\u001c\u0010#\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010!2\b\u0010\n\u001a\u0004\u0018\u00010\"H&J\u001c\u0010&\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010$2\b\u0010\n\u001a\u0004\u0018\u00010%H&Jf\u0010,\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u001e\u0010)\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010'j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`(2\u001e\u0010*\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010'j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`(2\b\u0010\n\u001a\u0004\u0018\u00010+H&J<\u00100\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u001e\u0010.\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010'j\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u0001`(2\b\u0010\n\u001a\u0004\u0018\u00010/H&J\u001c\u00103\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u0001012\b\u0010\n\u001a\u0004\u0018\u000102H&J\u001c\u00106\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u0001042\b\u0010\n\u001a\u0004\u0018\u000105H&J\u001c\u00109\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u0001072\b\u0010\n\u001a\u0004\u0018\u000108H&J\u001c\u0010<\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010:2\b\u0010\n\u001a\u0004\u0018\u00010;H&J0\u0010B\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010\u00022\b\u0010@\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010AH&J\u001c\u0010E\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010C2\b\u0010\n\u001a\u0004\u0018\u00010DH&JB\u0010L\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\n\u001a\u0004\u0018\u00010KH&JL\u0010Q\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u0010M\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010I2\b\u0010O\u001a\u0004\u0018\u00010N2\b\u0010\n\u001a\u0004\u0018\u00010PH&J\u001c\u0010T\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010R2\b\u0010\n\u001a\u0004\u0018\u00010SH&J8\u0010Y\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010U\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010V2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\n\u001a\u0004\u0018\u00010XH&J&\u0010]\u001a\u00020\u000b2\b\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010?\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\\H&J\u001c\u0010`\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010^2\b\u0010\n\u001a\u0004\u0018\u00010_H&J\u001c\u0010c\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010a2\b\u0010\n\u001a\u0004\u0018\u00010bH&J\u001c\u0010f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010d2\b\u0010\n\u001a\u0004\u0018\u00010eH&\u00a8\u0006g"}, d2 = {"Lcom/tencent/qqnt/kernel/api/g;", "Lcom/tencent/qqnt/kernel/api/j;", "", "uin", "qua", "deviceInfo", "", "setAlbumServiceInfo", "groupId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMainPageCallback;", "callback", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAlbumListReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAlbumListCallback;", "getAlbumList", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAlbumInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAlbumInfoCallback;", "getAlbumInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAllAlbumListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAllAlbumListCallback;", "p0", "albumId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteAlbumCallback;", "A0", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceAddAlbumCallback;", "v0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQuoteToQzoneReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQuoteToQzoneCallback;", "quoteToQzone", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQuoteToQunAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQuoteToQunAlbumCallback;", "quoteToQunAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQueryQuoteToQunAlbumStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQueryQuoteToQunAlbumStatusCallback;", "queryQuoteToQunAlbumStatus", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "llocId", "batchId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteMediasCallback;", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumModifyMask;", "qunModifyAlbumMask", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceModifyAlbumCallback;", "d0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetMediaListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMediaListCallback;", "getMediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetMediaListTailTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMediaListTailTabCallback;", "getMediaListTailTab", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunFeedsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunFeedsCallback;", "getQunFeeds", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunFeedDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunFeedDetailCallback;", "getQunFeedDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "ext", "qunId", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunNoticeListCallback;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunCommentCallback;", "getQunComment", "commentType", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "feed", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "comment", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunCommentCallback;", "W", "replyType", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "reply", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunReplyCallback;", "f0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTDeleteQunFeedReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteQunFeedCallback;", "deleteQunFeed", "likeType", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", "like", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunLikeCallback;", "X", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneType;", "scene", "Lcom/tencent/qqnt/kernel/nativeinterface/IReddotReaderServiceGetRedPointsCallback;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/NTReportViewQunFeedReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceReportViewQunFeedCallback;", "reportViewQunFeed", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunRightReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunRightCallback;", "getQunRight", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetFeedByIdReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetFeedByIdCallback;", "getFeedById", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface g extends j {
    int A0(@Nullable String groupId, @Nullable String albumId, @Nullable IAlbumServiceDeleteAlbumCallback callback);

    int J(@Nullable SceneType scene, @Nullable String qunId, @Nullable IReddotReaderServiceGetRedPointsCallback callback);

    int V(@Nullable String groupId, @Nullable String albumId, @Nullable ArrayList<String> llocId, @Nullable ArrayList<String> batchId, @Nullable IAlbumServiceDeleteMediasCallback callback);

    int W(@Nullable StCommonExt ext, @Nullable String qunId, int commentType, @Nullable StFeed feed, @Nullable StComment comment, @Nullable IAlbumServiceDoQunCommentCallback callback);

    int X(@Nullable StCommonExt ext, int likeType, @Nullable StLike like, @Nullable StFeed feed, @Nullable IAlbumServiceDoQunLikeCallback callback);

    int d0(@Nullable AlbumInfo albumInfo, @Nullable ArrayList<AlbumModifyMask> qunModifyAlbumMask, @Nullable IAlbumServiceModifyAlbumCallback callback);

    int deleteQunFeed(@Nullable NTDeleteQunFeedReq request, @Nullable IAlbumServiceDeleteQunFeedCallback callback);

    int f0(@Nullable StCommonExt ext, @Nullable String qunId, int replyType, @Nullable StFeed feed, @Nullable StComment comment, @Nullable StReply reply, @Nullable IAlbumServiceDoQunReplyCallback callback);

    int getAlbumInfo(@Nullable NTGetAlbumInfoReq request, @Nullable IAlbumServiceGetAlbumInfoCallback callback);

    int getAlbumList(@Nullable NTGetAlbumListReq request, @Nullable IAlbumServiceGetAlbumListCallback callback);

    int getFeedById(@Nullable NTGetFeedByIdReq request, @Nullable IAlbumServiceGetFeedByIdCallback callback);

    int getMediaList(@Nullable NTGetMediaListReq request, @Nullable IAlbumServiceGetMediaListCallback callback);

    int getMediaListTailTab(@Nullable NTGetMediaListTailTabReq request, @Nullable IAlbumServiceGetMediaListTailTabCallback callback);

    int getQunComment(@Nullable NTGetQunCommentReq request, @Nullable IAlbumServiceGetQunCommentCallback callback);

    int getQunFeedDetail(@Nullable NTGetQunFeedDetailReq request, @Nullable IAlbumServiceGetQunFeedDetailCallback callback);

    int getQunFeeds(@Nullable NTGetQunFeedsReq request, @Nullable IAlbumServiceGetQunFeedsCallback callback);

    int getQunRight(@Nullable NTGetQunRightReq request, @Nullable IAlbumServiceGetQunRightCallback callback);

    int h(@Nullable StCommonExt ext, @Nullable String qunId, @Nullable String attachInfo, @Nullable IAlbumServiceGetQunNoticeListCallback callback);

    int n(@Nullable String groupId, @Nullable IAlbumServiceGetMainPageCallback callback);

    int p0(@Nullable NTGetAllAlbumListReq request, @Nullable IAlbumServiceGetAllAlbumListCallback callback);

    int queryQuoteToQunAlbumStatus(@Nullable NTQueryQuoteToQunAlbumStatusReq request, @Nullable IAlbumServiceQueryQuoteToQunAlbumStatusCallback callback);

    int quoteToQunAlbum(@Nullable NTQuoteToQunAlbumReq request, @Nullable IAlbumServiceQuoteToQunAlbumCallback callback);

    int quoteToQzone(@Nullable NTQuoteToQzoneReq request, @Nullable IAlbumServiceQuoteToQzoneCallback callback);

    int reportViewQunFeed(@Nullable NTReportViewQunFeedReq request, @Nullable IAlbumServiceReportViewQunFeedCallback callback);

    void setAlbumServiceInfo(@Nullable String uin, @Nullable String qua, @Nullable String deviceInfo);

    int v0(@Nullable AlbumInfo albumInfo, @Nullable IAlbumServiceAddAlbumCallback callback);
}
