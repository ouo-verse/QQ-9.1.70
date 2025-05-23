package com.tencent.qqnt.kernel.api.impl;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
import com.tencent.qqnt.kernel.nativeinterface.IKernelAlbumService;
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
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 s2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001tB\u0019\u0012\b\u0010n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010p\u001a\u00020o\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u001c\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010!2\b\u0010\u000e\u001a\u0004\u0018\u00010\"H\u0016Jf\u0010)\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u001e\u0010&\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`%2\u001e\u0010'\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`%2\b\u0010\u000e\u001a\u0004\u0018\u00010(H\u0016J<\u0010-\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u001e\u0010+\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u0001`%2\b\u0010\u000e\u001a\u0004\u0018\u00010,H\u0016J\u001c\u00100\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010.2\b\u0010\u000e\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00103\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u0001012\b\u0010\u000e\u001a\u0004\u0018\u000102H\u0016J\u001c\u00106\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u0001042\b\u0010\u000e\u001a\u0004\u0018\u000105H\u0016J\u001c\u00109\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u0001072\b\u0010\u000e\u001a\u0004\u0018\u000108H\u0016J\u001c\u0010<\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010:2\b\u0010\u000e\u001a\u0004\u0018\u00010;H\u0016J\u001c\u0010?\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010=2\b\u0010\u000e\u001a\u0004\u0018\u00010>H\u0016J0\u0010E\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010DH\u0016J\u001c\u0010H\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010F2\b\u0010\u000e\u001a\u0004\u0018\u00010GH\u0016JB\u0010O\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010I\u001a\u00020\u00042\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\u000e\u001a\u0004\u0018\u00010NH\u0016JL\u0010T\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010P\u001a\u00020\u00042\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010M\u001a\u0004\u0018\u00010L2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010\u000e\u001a\u0004\u0018\u00010SH\u0016J\u001c\u0010W\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010U2\b\u0010\u000e\u001a\u0004\u0018\u00010VH\u0016J8\u0010\\\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010X\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010Y2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\u000e\u001a\u0004\u0018\u00010[H\u0016J&\u0010`\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010_H\u0016J\u001c\u0010c\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010a2\b\u0010\u000e\u001a\u0004\u0018\u00010bH\u0016J\u001c\u0010f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010d2\b\u0010\u000e\u001a\u0004\u0018\u00010eH\u0016J\u001c\u0010i\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010g2\b\u0010\u000e\u001a\u0004\u0018\u00010hH\u0016R\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006u"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/b;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAlbumService;", "Lcom/tencent/qqnt/kernel/api/g;", "", "p4", "", "uin", "qua", "deviceInfo", "", "setAlbumServiceInfo", "groupId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMainPageCallback;", "callback", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAlbumListReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAlbumListCallback;", "getAlbumList", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAlbumInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAlbumInfoCallback;", "getAlbumInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetAllAlbumListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAllAlbumListCallback;", "p0", "albumId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteAlbumCallback;", "A0", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceAddAlbumCallback;", "v0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQuoteToQzoneReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQuoteToQzoneCallback;", "quoteToQzone", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "llocId", "batchId", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteMediasCallback;", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumModifyMask;", "qunModifyAlbumMask", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceModifyAlbumCallback;", "d0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQuoteToQunAlbumReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQuoteToQunAlbumCallback;", "quoteToQunAlbum", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQueryQuoteToQunAlbumStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQueryQuoteToQunAlbumStatusCallback;", "queryQuoteToQunAlbumStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetMediaListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMediaListCallback;", "getMediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetMediaListTailTabReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMediaListTailTabCallback;", "getMediaListTailTab", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunFeedsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunFeedsCallback;", "getQunFeeds", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunFeedDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunFeedDetailCallback;", "getQunFeedDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "ext", "qunId", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunNoticeListCallback;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunCommentReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunCommentCallback;", "getQunComment", "commentType", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "feed", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "comment", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunCommentCallback;", "W", "replyType", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "reply", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunReplyCallback;", "f0", "Lcom/tencent/qqnt/kernel/nativeinterface/NTDeleteQunFeedReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDeleteQunFeedCallback;", "deleteQunFeed", "likeType", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", "like", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunLikeCallback;", "X", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneType;", "scene", "Lcom/tencent/qqnt/kernel/nativeinterface/IReddotReaderServiceGetRedPointsCallback;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/NTReportViewQunFeedReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceReportViewQunFeedCallback;", "reportViewQunFeed", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetQunRightReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetQunRightCallback;", "getQunRight", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetFeedByIdReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetFeedByIdCallback;", "getFeedById", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "seqCount", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAlbumService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "e", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends BaseService<IKernelAlbumService, IKernelAlbumService> implements com.tencent.qqnt.kernel.api.g {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger seqCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/b$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable IKernelAlbumService iKernelAlbumService, @NotNull py content) {
        super("AlbumService", content, iKernelAlbumService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelAlbumService, (Object) content);
        } else {
            this.seqCount = new AtomicInteger(0);
        }
    }

    private final int p4() {
        return this.seqCount.incrementAndGet();
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int A0(@Nullable String groupId, @Nullable String albumId, @Nullable IAlbumServiceDeleteAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, groupId, albumId, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.deleteAlbum(p46, groupId, albumId, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int J(@Nullable SceneType scene, @Nullable String qunId, @Nullable IReddotReaderServiceGetRedPointsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, scene, qunId, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getRedPoints(p46, scene, qunId, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int V(@Nullable String groupId, @Nullable String albumId, @Nullable ArrayList<String> llocId, @Nullable ArrayList<String> batchId, @Nullable IAlbumServiceDeleteMediasCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, groupId, albumId, llocId, batchId, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.deleteMedias(p46, groupId, albumId, llocId, batchId, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int W(@Nullable StCommonExt ext, @Nullable String qunId, int commentType, @Nullable StFeed feed, @Nullable StComment comment, @Nullable IAlbumServiceDoQunCommentCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, ext, qunId, Integer.valueOf(commentType), feed, comment, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.doQunComment(p46, ext, qunId, commentType, feed, comment, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int X(@Nullable StCommonExt ext, int likeType, @Nullable StLike like, @Nullable StFeed feed, @Nullable IAlbumServiceDoQunLikeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, ext, Integer.valueOf(likeType), like, feed, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.doQunLike(p46, ext, likeType, like, feed, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int d0(@Nullable AlbumInfo albumInfo, @Nullable ArrayList<AlbumModifyMask> qunModifyAlbumMask, @Nullable IAlbumServiceModifyAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, albumInfo, qunModifyAlbumMask, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.modifyAlbum(p46, albumInfo, qunModifyAlbumMask, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int deleteQunFeed(@Nullable NTDeleteQunFeedReq request, @Nullable IAlbumServiceDeleteQunFeedCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.deleteQunFeed(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int f0(@Nullable StCommonExt ext, @Nullable String qunId, int replyType, @Nullable StFeed feed, @Nullable StComment comment, @Nullable StReply reply, @Nullable IAlbumServiceDoQunReplyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, ext, qunId, Integer.valueOf(replyType), feed, comment, reply, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.doQunReply(p46, ext, qunId, replyType, feed, comment, reply, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getAlbumInfo(@Nullable NTGetAlbumInfoReq request, @Nullable IAlbumServiceGetAlbumInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getAlbumInfo(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getAlbumList(@Nullable NTGetAlbumListReq request, @Nullable IAlbumServiceGetAlbumListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getAlbumList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getFeedById(@Nullable NTGetFeedByIdReq request, @Nullable IAlbumServiceGetFeedByIdCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getFeedById(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getMediaList(@Nullable NTGetMediaListReq request, @Nullable IAlbumServiceGetMediaListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getMediaList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getMediaListTailTab(@Nullable NTGetMediaListTailTabReq request, @Nullable IAlbumServiceGetMediaListTailTabCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getMediaListTailTab(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getQunComment(@Nullable NTGetQunCommentReq request, @Nullable IAlbumServiceGetQunCommentCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getQunComment(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getQunFeedDetail(@Nullable NTGetQunFeedDetailReq request, @Nullable IAlbumServiceGetQunFeedDetailCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getQunFeedDetail(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getQunFeeds(@Nullable NTGetQunFeedsReq request, @Nullable IAlbumServiceGetQunFeedsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getQunFeeds(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int getQunRight(@Nullable NTGetQunRightReq request, @Nullable IAlbumServiceGetQunRightCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getQunRight(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int h(@Nullable StCommonExt ext, @Nullable String qunId, @Nullable String attachInfo, @Nullable IAlbumServiceGetQunNoticeListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, ext, qunId, attachInfo, callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getQunNoticeList(p46, ext, qunId, attachInfo, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int n(@Nullable String groupId, @Nullable IAlbumServiceGetMainPageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) groupId, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getMainPage(p46, groupId, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int p0(@Nullable NTGetAllAlbumListReq request, @Nullable IAlbumServiceGetAllAlbumListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.getAllAlbumList(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int queryQuoteToQunAlbumStatus(@Nullable NTQueryQuoteToQunAlbumStatusReq request, @Nullable IAlbumServiceQueryQuoteToQunAlbumStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.queryQuoteToQunAlbumStatus(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int quoteToQunAlbum(@Nullable NTQuoteToQunAlbumReq request, @Nullable IAlbumServiceQuoteToQunAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        if (request != null) {
            request.seq = p46;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.quoteToQunAlbum(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int quoteToQzone(@Nullable NTQuoteToQzoneReq request, @Nullable IAlbumServiceQuoteToQzoneCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.quoteToQzone(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int reportViewQunFeed(@Nullable NTReportViewQunFeedReq request, @Nullable IAlbumServiceReportViewQunFeedCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) request, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.reportViewQunFeed(request, callback);
        }
        return p46;
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public void setAlbumServiceInfo(@Nullable String uin, @Nullable String qua, @Nullable String deviceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, qua, deviceInfo);
            return;
        }
        IKernelAlbumService service = getService();
        if (service != null) {
            service.setAlbumServiceInfo(uin, qua, deviceInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.g
    public int v0(@Nullable AlbumInfo albumInfo, @Nullable IAlbumServiceAddAlbumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) albumInfo, (Object) callback)).intValue();
        }
        int p46 = p4();
        IKernelAlbumService service = getService();
        if (service != null) {
            service.addAlbum(p46, albumInfo, callback);
        }
        return p46;
    }
}
