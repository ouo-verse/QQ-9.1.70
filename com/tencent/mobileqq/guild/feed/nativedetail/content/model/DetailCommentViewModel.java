package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedCommentsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedCommentsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import el1.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0095\u00012\u00020\u0001:\u0002\u0096\u0001B\u0015\u0012\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0091\u0001\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000fJ8\u0010!\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\"\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000203H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00106\u001a\u000203H\u0002J\u0010\u00109\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0012\u0010;\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010?\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010A\u001a\u00020@H\u0002J\u0018\u0010H\u001a\u00020G2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020DH\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010J\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010N\u001a\u00020\u00042\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020=0Kj\b\u0012\u0004\u0012\u00020=`LH\u0002J\u0012\u0010O\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010P\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010Q\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010R\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010S\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010T\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010U\u001a\u00020\u00042\u0006\u00106\u001a\u00020/H\u0002J\u0010\u0010V\u001a\u00020\u00042\u0006\u00106\u001a\u000203H\u0002J\u0012\u0010W\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010X\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010Y\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010Z\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010[\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\\\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010]\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010`\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u000fH\u0002J\u0010\u0010a\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u0018H\u0002J\"\u0010c\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u000f2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010d\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u000fH\u0002J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u000fH\u0002J\u0010\u0010f\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u000fH\u0002J\u001a\u0010g\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u000f2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010h\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010k\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020iH\u0002R\u0016\u0010n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010mR\u0016\u0010y\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010xR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0086\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010mR!\u0010\u008d\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailCommentViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/AbsDetailViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "", "y1", "e1", ReportConstant.COSTREPORT_PREFIX, "t0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "action", "", "args", "a0", "", "c", "E", "getLogTag", "Lwk1/h;", "ioc", "l2", "isFeedAllowComment", ICustomDataEditor.STRING_PARAM_3, "", "result", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedCommentsReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedCommentsRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "from", "F2", "w2", "R2", "l3", "r3", "count", "u3", "v3", "q3", "t3", "o3", "p3", "isFirstLoad", "v2", "Ljl1/h;", "replyItemData", ICustomDataEditor.STRING_PARAM_2, "r2", "Ljl1/b;", "commentItem", "q2", "itemData", "o2", "T2", "p2", "U2", "B2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesRsp;", "Lhl1/g;", "contentData", Constants.MMCCID, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "stComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesReq;", "x2", "", "guildId", "channelId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStChannelSign;", "t2", "E2", "P2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contentDataList", "j2", "H2", "J2", "I2", "O2", "z2", NowProxyConstants.AccountInfoKey.A2, ICustomDataEditor.NUMBER_PARAM_2, "m2", "Q2", "K2", "M2", "L2", "N2", "C2", Constants.BASE_IN_PLUGIN_VERSION, "loadingStatus", "isSuccess", "d3", "k2", "payload", "e3", "k3", "c3", "f3", "b3", "y2", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakPermission", "S2", "J", "Z", "viewModelVisibility", "K", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "curLoadDataArgs", "L", "Ljava/lang/String;", "curAttachInfo", "M", "isFinish", "N", "I", "totalNum", "P", "curRankingType", "Ljl1/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljl1/f;", "commentTitleData", BdhLogUtil.LogTag.Tag_Req, "Lwk1/h;", "inputContextProvide", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver;", "guildInfoUpdateObserver", "T", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/CommentListDataProcessor;", "U", "Lkotlin/Lazy;", "u2", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/CommentListDataProcessor;", "dataProcessor", "getIdentifier", "()I", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailCommentViewModel$a$a;", DownloadInfo.spKey_Config, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailCommentViewModel$a$a;)V", "V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DetailCommentViewModel extends AbsDetailViewModel {

    /* renamed from: J, reason: from kotlin metadata */
    private boolean viewModelVisibility;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LoadDataArgs curLoadDataArgs;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String curAttachInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFinish;

    /* renamed from: N, reason: from kotlin metadata */
    private int totalNum;

    /* renamed from: P, reason: from kotlin metadata */
    private int curRankingType;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private jl1.f commentTitleData;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private wk1.h inputContextProvide;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private GuildInfoIsMemberUpdateObserver guildInfoUpdateObserver;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isFeedAllowComment;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataProcessor;

    public DetailCommentViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void A2(Object args) {
        if (!(args instanceof g.DeleteCommentListItemMessage)) {
            return;
        }
        hl1.g contentData = ((g.DeleteCommentListItemMessage) args).getContentData();
        if (contentData instanceof jl1.h) {
            n2((jl1.h) contentData);
        } else if (contentData instanceof jl1.b) {
            m2((jl1.b) contentData);
        }
    }

    private final void B2(Object args) {
        if (!(args instanceof g.ExpandCommentItemMessage)) {
            return;
        }
        q2(((g.ExpandCommentItemMessage) args).getCommentItemData());
    }

    private final void C2(Object args) {
        if (!(args instanceof g.ExpandReplyListMessage)) {
            return;
        }
        r2(((g.ExpandReplyListMessage) args).getReplyItemData());
    }

    private final void D2(Object args) {
        if (!(args instanceof g.FoldReplyListMessage)) {
            return;
        }
        s2(((g.FoldReplyListMessage) args).getReplyItemData());
    }

    private final GProStComment E2(Object args) {
        Object orNull;
        if (args instanceof g.GetCommentStructArgs) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(u2().A(), ((g.GetCommentStructArgs) args).getItemGroupPosition());
            return (GProStComment) orNull;
        }
        return null;
    }

    private final void F2(int result, String errMsg, GProStGetFeedCommentsReq req, GProStGetFeedCommentsRsp rsp, boolean isLoadMore, int from) {
        boolean z16;
        boolean z17 = false;
        if (rsp.isFinish == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handGetFeedDetailRsp,! result = " + result + " errMsg = " + errMsg + ", from=" + from + ", isLoadMore=" + isLoadMore + ", isFinish=" + z16 + " , listSize = " + rsp.vecCommentList.size() + ", viewModelVisibility=" + this.viewModelVisibility);
        if (this.viewModelVisibility && !R2(req)) {
            if (result != 0) {
                QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handGetFeedDetailRsp error! result = " + result + " errMsg = " + errMsg);
                k2(0);
                e3(from, false, null);
                return;
            }
            l3(rsp, isLoadMore);
            if (u2().A().isEmpty()) {
                k2(0);
                e3(from, true, null);
                return;
            } else {
                e3(from, true, w2(req));
                return;
            }
        }
        if (result == 0) {
            z17 = true;
        }
        k3(from, z17);
    }

    private final void G2(GProGetNextPageRepliesRsp rsp, hl1.g contentData) {
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleGetNextPageRepliesRsp, listSize:" + rsp.replies.size() + ", contentData:" + contentData + ", hasMore" + rsp.hasMore);
        if (contentData == null || !u2().I(rsp, contentData)) {
            return;
        }
        r3();
        O1(5);
    }

    private final void H2(Object args) {
        if (!(args instanceof g.ChangeCommentListVisibilityMessage)) {
            return;
        }
        g.ChangeCommentListVisibilityMessage changeCommentListVisibilityMessage = (g.ChangeCommentListVisibilityMessage) args;
        if (this.viewModelVisibility != changeCommentListVisibilityMessage.getVisible()) {
            boolean visible = changeCommentListVisibilityMessage.getVisible();
            this.viewModelVisibility = visible;
            if (!visible) {
                M1().clear();
            }
            O1(18);
        }
    }

    private final void I2(Object args) {
        if (!(args instanceof g.OnResendCommentItem)) {
            return;
        }
        CommentListDataProcessor u26 = u2();
        String str = ((g.OnResendCommentItem) args).getContentData().getCommentData().idd;
        Intrinsics.checkNotNullExpressionValue(str, "args.contentData.commentData.idd");
        int v3 = u26.v(str);
        jl1.b u16 = u2().u(v3);
        if (u16 == null) {
            return;
        }
        u16.i(1);
        N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, v3, null, 4, null));
    }

    private final void J2(Object args) {
        if (!(args instanceof g.OnResendReplyItem)) {
            return;
        }
        CommentListDataProcessor u26 = u2();
        String str = ((g.OnResendReplyItem) args).getContentData().getReplyData().idd;
        Intrinsics.checkNotNullExpressionValue(str, "args.contentData.replyData.idd");
        int z16 = u26.z(str);
        jl1.h y16 = u2().y(z16);
        if (y16 == null) {
            return;
        }
        y16.h(1);
        N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, z16, null, 4, null));
    }

    private final void K2(Object args) {
        String str;
        String idd;
        GProStComment gProStComment;
        if (!(args instanceof a.OnCommentCompletedMessage)) {
            return;
        }
        a.OnCommentCompletedMessage onCommentCompletedMessage = (a.OnCommentCompletedMessage) args;
        String str2 = onCommentCompletedMessage.getFakeComment().idd;
        GProStDoCommentRsp commentRsp = onCommentCompletedMessage.getCommentRsp();
        GProStComment gProStComment2 = null;
        if (commentRsp != null && (gProStComment = commentRsp.comment) != null) {
            str = gProStComment.idd;
        } else {
            str = null;
        }
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleOnCommentCompletedMessage fakeIdd=" + str2 + " realIdd=" + str);
        CommentListDataProcessor u26 = u2();
        String str3 = onCommentCompletedMessage.getFakeComment().idd;
        Intrinsics.checkNotNullExpressionValue(str3, "args.fakeComment.idd");
        GProStDoCommentRsp commentRsp2 = onCommentCompletedMessage.getCommentRsp();
        if (commentRsp2 != null) {
            gProStComment2 = commentRsp2.comment;
        }
        if (!u26.G(str3, gProStComment2, onCommentCompletedMessage.getIsSuccess())) {
            return;
        }
        if (onCommentCompletedMessage.getIsSuccess()) {
            GProStDoCommentRsp commentRsp3 = onCommentCompletedMessage.getCommentRsp();
            Intrinsics.checkNotNull(commentRsp3);
            GProStComment gProStComment3 = commentRsp3.comment;
            Intrinsics.checkNotNull(gProStComment3);
            idd = gProStComment3.idd;
        } else {
            idd = onCommentCompletedMessage.getFakeComment().idd;
        }
        CommentListDataProcessor u27 = u2();
        Intrinsics.checkNotNullExpressionValue(idd, "idd");
        N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, u27.m(idd), null, 4, null));
    }

    private final void L2(Object args) {
        if (!(args instanceof a.OnCommentSendingMessage)) {
            return;
        }
        a.OnCommentSendingMessage onCommentSendingMessage = (a.OnCommentSendingMessage) args;
        u2().C(onCommentSendingMessage.getFakeComment());
        u3(1);
        r3();
        CommentListDataProcessor u26 = u2();
        String str = onCommentSendingMessage.getFakeComment().idd;
        Intrinsics.checkNotNullExpressionValue(str, "args.fakeComment.idd");
        P1(6, Integer.valueOf(u26.v(str)));
    }

    private final void M2(Object args) {
        String str;
        String idd;
        GProStReply gProStReply;
        if (!(args instanceof a.OnReplyCommentCompletedMessage)) {
            return;
        }
        a.OnReplyCommentCompletedMessage onReplyCommentCompletedMessage = (a.OnReplyCommentCompletedMessage) args;
        String str2 = onReplyCommentCompletedMessage.getReq().comment.idd;
        String str3 = onReplyCommentCompletedMessage.getFakeReply().idd;
        GProStDoReplyRsp replyRsp = onReplyCommentCompletedMessage.getReplyRsp();
        GProStReply gProStReply2 = null;
        if (replyRsp != null && (gProStReply = replyRsp.reply) != null) {
            str = gProStReply.idd;
        } else {
            str = null;
        }
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleOnReplyCommentCompletedMessage hostIdd=" + str2 + " fakeReplyIdd=" + str3 + " realReplyIdd=" + str);
        CommentListDataProcessor u26 = u2();
        String str4 = onReplyCommentCompletedMessage.getFakeReply().idd;
        Intrinsics.checkNotNullExpressionValue(str4, "args.fakeReply.idd");
        GProStDoReplyRsp replyRsp2 = onReplyCommentCompletedMessage.getReplyRsp();
        if (replyRsp2 != null) {
            gProStReply2 = replyRsp2.reply;
        }
        if (!u26.J(str4, gProStReply2, onReplyCommentCompletedMessage.getIsSuccess())) {
            return;
        }
        if (onReplyCommentCompletedMessage.getIsSuccess()) {
            GProStDoReplyRsp replyRsp3 = onReplyCommentCompletedMessage.getReplyRsp();
            Intrinsics.checkNotNull(replyRsp3);
            idd = replyRsp3.reply.idd;
        } else {
            idd = onReplyCommentCompletedMessage.getFakeReply().idd;
        }
        CommentListDataProcessor u27 = u2();
        Intrinsics.checkNotNullExpressionValue(idd, "idd");
        N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, u27.p(idd), null, 4, null));
    }

    private final void N2(Object args) {
        String targetReplyId;
        if (!(args instanceof a.OnReplyCommentSendingMessage)) {
            return;
        }
        a.OnReplyCommentSendingMessage onReplyCommentSendingMessage = (a.OnReplyCommentSendingMessage) args;
        if (onReplyCommentSendingMessage.getReplyType() == 2) {
            targetReplyId = onReplyCommentSendingMessage.getReq().reply.targetReplyID;
        } else {
            targetReplyId = "";
        }
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleOnReplyCommentSendingMessage targetReplyId=" + targetReplyId);
        CommentListDataProcessor u26 = u2();
        String str = onReplyCommentSendingMessage.getReq().comment.idd;
        Intrinsics.checkNotNullExpressionValue(str, "args.req.comment.idd");
        GProStReply fakeReply = onReplyCommentSendingMessage.getFakeReply();
        Intrinsics.checkNotNullExpressionValue(targetReplyId, "targetReplyId");
        if (!u26.D(str, fakeReply, targetReplyId)) {
            return;
        }
        u3(1);
        r3();
        CommentListDataProcessor u27 = u2();
        String str2 = onReplyCommentSendingMessage.getFakeReply().idd;
        Intrinsics.checkNotNullExpressionValue(str2, "args.fakeReply.idd");
        P1(6, Integer.valueOf(u27.z(str2)));
    }

    private final void O2(Object args) {
        GProStReply gProStReply;
        GProStReply gProStReply2;
        if (!(args instanceof a.ReplyRequestOperationResult)) {
            return;
        }
        a.ReplyRequestOperationResult replyRequestOperationResult = (a.ReplyRequestOperationResult) args;
        int operation = replyRequestOperationResult.getOperationMessage().getOperation();
        if (operation != 1) {
            if (operation == 2) {
                if (replyRequestOperationResult.getFakeReply() != null && (!replyRequestOperationResult.getIsSuccess() || replyRequestOperationResult.getResponse() != null)) {
                    CommentListDataProcessor u26 = u2();
                    String str = replyRequestOperationResult.getFakeReply().idd;
                    Intrinsics.checkNotNullExpressionValue(str, "args.fakeReply.idd");
                    GProStDoReplyRsp response = replyRequestOperationResult.getResponse();
                    String idd = null;
                    if (response != null) {
                        gProStReply = response.reply;
                    } else {
                        gProStReply = null;
                    }
                    if (!u26.J(str, gProStReply, replyRequestOperationResult.getIsSuccess())) {
                        return;
                    }
                    if (replyRequestOperationResult.getIsSuccess()) {
                        GProStDoReplyRsp response2 = replyRequestOperationResult.getResponse();
                        if (response2 != null && (gProStReply2 = response2.reply) != null) {
                            idd = gProStReply2.idd;
                        }
                        if (idd == null) {
                            idd = "";
                        }
                    } else {
                        idd = replyRequestOperationResult.getFakeReply().idd;
                    }
                    CommentListDataProcessor u27 = u2();
                    Intrinsics.checkNotNullExpressionValue(idd, "idd");
                    N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, u27.p(idd), null, 4, null));
                    return;
                }
                QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleReplyRequestOperationResult error, fakeReply" + replyRequestOperationResult.getFakeReply() + ", response" + replyRequestOperationResult.getResponse());
                return;
            }
            return;
        }
        if (replyRequestOperationResult.getOperationMessage().getPayload() instanceof jl1.h) {
            n2((jl1.h) replyRequestOperationResult.getOperationMessage().getPayload());
        }
    }

    private final void P2(Object args) {
        boolean F;
        if (!(args instanceof g.TopCommentItemMessage)) {
            return;
        }
        g.TopCommentItemMessage topCommentItemMessage = (g.TopCommentItemMessage) args;
        if (topCommentItemMessage.getTopOrUnTop()) {
            F = u2().b(topCommentItemMessage.getContentData());
        } else {
            F = u2().F();
        }
        if (F) {
            r3();
            P1(13, Boolean.valueOf(topCommentItemMessage.getTopOrUnTop()));
        }
    }

    private final void Q2(Object args) {
        if (args instanceof g.UpdateCommentListPreferStatusMessage) {
            g.UpdateCommentListPreferStatusMessage updateCommentListPreferStatusMessage = (g.UpdateCommentListPreferStatusMessage) args;
            if (!updateCommentListPreferStatusMessage.getIsSuccess()) {
                QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleUpdateCommentListLikeStatus position=" + updateCommentListPreferStatusMessage.getPosition());
                hl1.g contentData = updateCommentListPreferStatusMessage.getContentData();
                if (contentData instanceof jl1.b) {
                    u2().H((jl1.b) contentData, updateCommentListPreferStatusMessage.getLikeInfo());
                } else if (contentData instanceof jl1.h) {
                    u2().K((jl1.h) contentData, updateCommentListPreferStatusMessage.getLikeInfo());
                }
                N1("message_item_data_changed", new g.OnItemDataChangedMessage(7, updateCommentListPreferStatusMessage.getPosition(), null, 4, null));
            }
        }
    }

    private final boolean R2(GProStGetFeedCommentsReq req) {
        if (req.rankingType != this.curRankingType) {
            return true;
        }
        return false;
    }

    private final boolean S2(SpeakPermissionType speakPermission) {
        if (speakPermission != SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT && speakPermission != SpeakPermissionType.PERMISSION_TYPE_NORMAL && speakPermission != SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN && speakPermission != SpeakPermissionType.PERMISSION_TYPE_REAL_NAME && speakPermission != SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME && speakPermission != SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED && speakPermission != SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED) {
            return false;
        }
        return true;
    }

    private final void T2(final jl1.b itemData) {
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "loadMoreReply, data = " + itemData);
        GProGetNextPageRepliesReq x26 = x2(itemData.getCommentData());
        if (x26 == null) {
            return;
        }
        final IPerformanceReportTask m3 = com.tencent.mobileqq.guild.feed.report.c.f223280a.m(x26);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.getNextPageReplies(x26, new IGProgetNextPageRepliesCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback
                public final void onResult(int i3, String str, boolean z16, GProGetNextPageRepliesRsp gProGetNextPageRepliesRsp) {
                    DetailCommentViewModel.V2(IPerformanceReportTask.this, this, itemData, i3, str, z16, gProGetNextPageRepliesRsp);
                }
            });
        }
    }

    private final void U2(final jl1.h replyItemData) {
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "loadMoreReply, data = " + replyItemData);
        GProGetNextPageRepliesReq x26 = x2(u2().A().get(replyItemData.getCommonInfo().getItemGroupPosition()));
        if (x26 == null) {
            return;
        }
        final IPerformanceReportTask m3 = com.tencent.mobileqq.guild.feed.report.c.f223280a.m(x26);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.getNextPageReplies(x26, new IGProgetNextPageRepliesCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback
                public final void onResult(int i3, String str, boolean z16, GProGetNextPageRepliesRsp gProGetNextPageRepliesRsp) {
                    DetailCommentViewModel.Y2(IPerformanceReportTask.this, this, replyItemData, i3, str, z16, gProGetNextPageRepliesRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(IPerformanceReportTask reportTask, final DetailCommentViewModel this$0, final jl1.b itemData, final int i3, final String errMsg, boolean z16, final GProGetNextPageRepliesRsp rsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        cVar.A(reportTask, i3, errMsg, rsp);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.i
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommentViewModel.W2(i3, rsp, errMsg, this$0, itemData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(int i3, GProGetNextPageRepliesRsp rsp, String str, DetailCommentViewModel this$0, jl1.b itemData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "getFeedComments, result=" + i3 + ", listSize=" + rsp.replies.size() + ", hasMore=" + rsp.hasMore + "totalReplyCount=" + rsp.totalReplyCount);
        if (i3 != 0) {
            QQToast.makeText(BaseApplication.context, 1, str, 0).show();
        } else {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            this$0.G2(rsp, itemData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(IPerformanceReportTask reportTask, final DetailCommentViewModel this$0, final jl1.h replyItemData, final int i3, final String errMsg, boolean z16, final GProGetNextPageRepliesRsp rsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyItemData, "$replyItemData");
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        cVar.A(reportTask, i3, errMsg, rsp);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.h
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommentViewModel.a3(i3, rsp, errMsg, this$0, replyItemData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a3(int i3, GProGetNextPageRepliesRsp rsp, String str, DetailCommentViewModel this$0, jl1.h replyItemData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyItemData, "$replyItemData");
        QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "getFeedComments, result=" + i3 + ", listSize=" + rsp.replies.size() + ", hasMore=" + rsp.hasMore + "totalReplyCount=" + rsp.totalReplyCount);
        if (i3 != 0) {
            QQToast.makeText(BaseApplication.context, 1, str, 0).show();
            CommentListDataProcessor u26 = this$0.u2();
            String str2 = replyItemData.getReplyData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "replyItemData.replyData.idd");
            this$0.N1("message_item_data_changed", new g.OnItemDataChangedMessage(5, u26.z(str2), null, 4, null));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.G2(rsp, replyItemData);
    }

    private final void b3(boolean isSuccess, Object payload) {
        P1(2, payload);
        Q1("message_on_load_comment_completed", new g.OnLoadCommentCompletedMessage(isSuccess, this.isFinish));
    }

    private final void c3(boolean isSuccess) {
        O1(3);
        R1("message_on_load_more_complete", new g.OnLoadMoreCompletedMessage(isSuccess, this.isFinish));
    }

    private final void d3(int from, int loadingStatus, boolean isSuccess) {
        k2(loadingStatus);
        O1(from);
    }

    private final void e3(int from, boolean isSuccess, Object payload) {
        if (from != 2) {
            if (from != 3) {
                if (from == 4) {
                    f3(isSuccess);
                    return;
                }
                return;
            }
            c3(isSuccess);
            return;
        }
        b3(isSuccess, payload);
    }

    private final void f3(boolean isSuccess) {
        O1(4);
        T1("message_on_comment_reload_complete", new g.OnReLoadCommentCompletedMessage(isSuccess, this.isFinish));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(IPerformanceReportTask reportTask, final DetailCommentViewModel this$0, final GProStGetFeedCommentsReq req, final int i3, final int i16, final String errMsg, boolean z16, final GProStGetFeedCommentsRsp rsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        cVar.z(reportTask, i16, errMsg, rsp);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.k
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommentViewModel.h3(DetailCommentViewModel.this, i16, errMsg, req, rsp, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(DetailCommentViewModel this$0, int i3, String errMsg, GProStGetFeedCommentsReq req, GProStGetFeedCommentsRsp rsp, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.F2(i3, errMsg, req, rsp, false, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(final DetailCommentViewModel this$0, final GProStGetFeedCommentsReq req, final int i3, final int i16, final String str, boolean z16, final GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.l
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommentViewModel.j3(DetailCommentViewModel.this, i16, str, req, gProStGetFeedCommentsRsp, i3);
            }
        });
    }

    private final void j2(ArrayList<hl1.g> contentDataList) {
        String guildId;
        LoadDataArgs loadDataArgs;
        String channelId;
        IGProGuildInfo L;
        wk1.h hVar;
        wk1.a guildBarDependency;
        LoadDataArgs loadDataArgs2 = this.curLoadDataArgs;
        if (loadDataArgs2 != null && (guildId = loadDataArgs2.getGuildId()) != null && (loadDataArgs = this.curLoadDataArgs) != null && (channelId = loadDataArgs.getChannelId()) != null && (L = ch.L(guildId)) != null && (hVar = this.inputContextProvide) != null && (guildBarDependency = hVar.getGuildBarDependency()) != null) {
            SpeakPermissionType b16 = new el1.a(new a.Companion.Args(guildId, channelId)).b(L);
            Logger.f235387a.d().i("FeedNativeDetail.ContentDetailCommentViewModel", 1, "addInputViewItemIfNeeded " + b16);
            if (!wk1.k.a(guildBarDependency) && guildBarDependency.h() && S2(b16) && !guildBarDependency.j()) {
                guildBarDependency.getIsMemberSync();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(DetailCommentViewModel this$0, int i3, String errMsg, GProStGetFeedCommentsReq req, GProStGetFeedCommentsRsp rsp, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.F2(i3, errMsg, req, rsp, true, i16);
    }

    private final void k2(int loadingStatus) {
        M1().clear();
        M1().add(this.commentTitleData);
        if (loadingStatus == 0) {
            j2(M1());
        }
        if (loadingStatus == 1 || this.isFeedAllowComment) {
            M1().add(new jl1.g(loadingStatus));
        }
    }

    private final void k3(int from, boolean isSuccess) {
        if (from != 2) {
            if (from != 3) {
                if (from == 4) {
                    T1("message_on_comment_reload_complete", new g.OnReLoadCommentCompletedMessage(isSuccess, this.isFinish));
                    return;
                }
                return;
            }
            R1("message_on_load_more_complete", new g.OnLoadMoreCompletedMessage(isSuccess, this.isFinish));
            return;
        }
        Q1("message_on_load_comment_completed", new g.OnLoadCommentCompletedMessage(isSuccess, this.isFinish));
    }

    private final void l3(GProStGetFeedCommentsRsp rsp, boolean isLoadMore) {
        o3(rsp);
        t3(rsp);
        p3(rsp, isLoadMore);
        v3(rsp);
        r3();
    }

    private final void m2(jl1.b itemData) {
        if (!u2().f(itemData)) {
            return;
        }
        u3((-1) - itemData.getCommentData().replyCount);
        if (u2().A().isEmpty()) {
            k2(0);
        } else {
            r3();
        }
        O1(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m3(final DetailCommentViewModel this$0, final GProStGetFeedCommentsReq req, final int i3, final int i16, final String str, boolean z16, final GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.m
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommentViewModel.n3(DetailCommentViewModel.this, i16, str, req, gProStGetFeedCommentsRsp, i3);
            }
        });
    }

    private final void n2(jl1.h itemData) {
        if (!u2().g(itemData)) {
            return;
        }
        u3(-1);
        r3();
        O1(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n3(DetailCommentViewModel this$0, int i3, String errMsg, GProStGetFeedCommentsReq req, GProStGetFeedCommentsRsp rsp, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.F2(i3, errMsg, req, rsp, false, i16);
    }

    private final void o2(jl1.b itemData) {
        if (!u2().i(itemData, 5)) {
            return;
        }
        r3();
        O1(5);
    }

    private final void o3(GProStGetFeedCommentsRsp rsp) {
        String str = rsp.attchInfo;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.attchInfo");
        this.curAttachInfo = str;
    }

    private final void p2(jl1.h replyItemData) {
        if (!u2().j(replyItemData, 5)) {
            return;
        }
        r3();
        O1(5);
    }

    private final void p3(GProStGetFeedCommentsRsp rsp, boolean isLoadMore) {
        Object firstOrNull;
        boolean z16;
        List<GProStComment> listOf;
        List<GProStComment> listOf2;
        boolean z17 = false;
        if (!isLoadMore) {
            u2().d();
            u2().e();
            GProStComment gProStComment = rsp.topComment;
            if (gProStComment.isTop) {
                String str = gProStComment.idd;
                Intrinsics.checkNotNullExpressionValue(str, "rsp.topComment.idd");
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    CommentListDataProcessor u26 = u2();
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(rsp.topComment);
                    u26.M(listOf);
                    CommentListDataProcessor u27 = u2();
                    listOf2 = CollectionsKt__CollectionsJVMKt.listOf(rsp.topComment);
                    u27.a(listOf2);
                }
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) u2().B());
        GProStComment gProStComment2 = (GProStComment) firstOrNull;
        if (gProStComment2 != null) {
            ArrayList<GProStComment> arrayList = rsp.vecCommentList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.vecCommentList");
            Iterator<GProStComment> it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().idd, gProStComment2.idd)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            Integer valueOf = Integer.valueOf(i3);
            if (valueOf.intValue() != -1) {
                z17 = true;
            }
            if (!z17) {
                valueOf = null;
            }
            if (valueOf != null) {
                rsp.vecCommentList.set(valueOf.intValue(), gProStComment2);
            }
        }
        CommentListDataProcessor u28 = u2();
        ArrayList<GProStComment> arrayList2 = rsp.vecCommentList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.vecCommentList");
        u28.a(arrayList2);
        if (isLoadMore) {
            CommentListDataProcessor u29 = u2();
            ArrayList<GProStComment> arrayList3 = rsp.vecCommentList;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "rsp.vecCommentList");
            u29.r(arrayList3, 1);
            return;
        }
        u2().s(1);
    }

    private final void q2(jl1.b commentItem) {
        if (commentItem.getCommentData().vecReplyList.size() > 0) {
            o2(commentItem);
        } else {
            T2(commentItem);
        }
    }

    private final void q3() {
        this.commentTitleData = new jl1.f(this.totalNum);
    }

    private final void r2(jl1.h replyItemData) {
        if (u2().x(replyItemData) > replyItemData.getReplyListPosition() + 1) {
            p2(replyItemData);
        } else {
            U2(replyItemData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3() {
        ArrayList<hl1.g> M1 = M1();
        ArrayList arrayList = new ArrayList();
        for (Object obj : M1) {
            if (obj instanceof jl1.g) {
                arrayList.add(obj);
            }
        }
        M1().clear();
        M1().add(this.commentTitleData);
        j2(M1());
        if (u2().w().isEmpty() && this.isFeedAllowComment) {
            M1().addAll(arrayList);
        } else {
            M1().addAll(u2().w());
        }
    }

    private final void s2(jl1.h replyItemData) {
        if (!u2().t(replyItemData)) {
            return;
        }
        r3();
        O1(5);
    }

    private final GProStChannelSign t2(long guildId, long channelId) {
        GProStChannelSign gProStChannelSign = new GProStChannelSign();
        gProStChannelSign.guildId = guildId;
        gProStChannelSign.channelId = channelId;
        return gProStChannelSign;
    }

    private final void t3(GProStGetFeedCommentsRsp rsp) {
        boolean z16 = true;
        if (rsp.isFinish != 1) {
            z16 = false;
        }
        this.isFinish = z16;
    }

    private final CommentListDataProcessor u2() {
        return (CommentListDataProcessor) this.dataProcessor.getValue();
    }

    private final void u3(int count) {
        this.totalNum = Math.max(0, this.totalNum + count);
        q3();
    }

    private final GProStGetFeedCommentsReq v2(LoadDataArgs loadDataArgs, boolean isFirstLoad, boolean isLoadMore) {
        GProStGetFeedCommentsReq gProStGetFeedCommentsReq = new GProStGetFeedCommentsReq();
        String y26 = y2();
        if (y26 == null) {
            return null;
        }
        gProStGetFeedCommentsReq.userId = y26;
        gProStGetFeedCommentsReq.feedId = loadDataArgs.getFeedId();
        gProStGetFeedCommentsReq.channelSign = t2(Long.parseLong(loadDataArgs.getGuildId()), Long.parseLong(loadDataArgs.getChannelId()));
        gProStGetFeedCommentsReq.replyListNum = 1;
        if (isLoadMore) {
            gProStGetFeedCommentsReq.attchInfo = this.curAttachInfo;
            gProStGetFeedCommentsReq.rankingType = this.curRankingType;
        } else {
            gProStGetFeedCommentsReq.rankingType = loadDataArgs.getRankingType();
            gProStGetFeedCommentsReq.attchInfo = "";
        }
        if (isFirstLoad) {
            gProStGetFeedCommentsReq.needInsertCommentID = loadDataArgs.getNeedInsertCommentID();
            gProStGetFeedCommentsReq.needInsertReplyID = loadDataArgs.getNeedInsertReplyID();
            List<String> h16 = loadDataArgs.h();
            ArrayList<GProStComment> arrayList = gProStGetFeedCommentsReq.needInsertCommentList;
            for (String str : h16) {
                GProStComment gProStComment = new GProStComment();
                gProStComment.idd = str;
                arrayList.add(gProStComment);
            }
            gProStGetFeedCommentsReq.needInsertCommentList = arrayList;
            QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 4, "[getFeedCommentsReq] needInsertCommentList.size=" + arrayList.size());
        } else {
            gProStGetFeedCommentsReq.needInsertReplyID = "";
            gProStGetFeedCommentsReq.needInsertCommentID = "";
        }
        gProStGetFeedCommentsReq.listNum = 15;
        return gProStGetFeedCommentsReq;
    }

    private final void v3(GProStGetFeedCommentsRsp rsp) {
        this.totalNum = rsp.totalNum;
        q3();
    }

    private final Object w2(GProStGetFeedCommentsReq req) {
        int i3;
        if (!TextUtils.isEmpty(req.needInsertReplyID)) {
            CommentListDataProcessor u26 = u2();
            String str = req.needInsertReplyID;
            Intrinsics.checkNotNullExpressionValue(str, "req.needInsertReplyID");
            i3 = u26.p(str);
            QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "needInsertReplyID=" + req.needInsertReplyID + ", position=" + i3);
        } else if (!TextUtils.isEmpty(req.needInsertCommentID)) {
            CommentListDataProcessor u27 = u2();
            String str2 = req.needInsertCommentID;
            Intrinsics.checkNotNullExpressionValue(str2, "req.needInsertCommentID");
            i3 = u27.m(str2);
            QLog.d("FeedNativeDetail.ContentDetailCommentViewModel", 1, "needInsertCommentID=" + req.needInsertCommentID + ", position=" + i3);
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            return Integer.valueOf(i3);
        }
        return null;
    }

    private final GProGetNextPageRepliesReq x2(GProStComment stComment) {
        LoadDataArgs loadDataArgs = this.curLoadDataArgs;
        if (loadDataArgs != null) {
            GProGetNextPageRepliesReq gProGetNextPageRepliesReq = new GProGetNextPageRepliesReq();
            gProGetNextPageRepliesReq.feedId = loadDataArgs.getFeedId();
            gProGetNextPageRepliesReq.commentId = stComment.idd;
            gProGetNextPageRepliesReq.channelSign = t2(Long.parseLong(loadDataArgs.getGuildId()), Long.parseLong(loadDataArgs.getChannelId()));
            gProGetNextPageRepliesReq.attachInfo = stComment.attachInfo;
            gProGetNextPageRepliesReq.pageSize = 5;
            return gProGetNextPageRepliesReq;
        }
        return null;
    }

    private final String y2() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return null;
        }
        return iGPSService.getSelfTinyId();
    }

    private final void z2(Object args) {
        GProStComment gProStComment;
        GProStComment gProStComment2;
        if (!(args instanceof a.CommentRequestOperationResult)) {
            return;
        }
        a.CommentRequestOperationResult commentRequestOperationResult = (a.CommentRequestOperationResult) args;
        int operation = commentRequestOperationResult.getOperationMessage().getOperation();
        if (operation != 1) {
            if (operation == 2) {
                if (commentRequestOperationResult.getFakeComment() != null && (!commentRequestOperationResult.getIsSuccess() || commentRequestOperationResult.getResponse() != null)) {
                    CommentListDataProcessor u26 = u2();
                    String str = commentRequestOperationResult.getFakeComment().idd;
                    Intrinsics.checkNotNullExpressionValue(str, "args.fakeComment.idd");
                    GProStDoCommentRsp response = commentRequestOperationResult.getResponse();
                    String idd = null;
                    if (response != null) {
                        gProStComment = response.comment;
                    } else {
                        gProStComment = null;
                    }
                    if (!u26.G(str, gProStComment, commentRequestOperationResult.getIsSuccess())) {
                        return;
                    }
                    if (commentRequestOperationResult.getIsSuccess()) {
                        GProStDoCommentRsp response2 = commentRequestOperationResult.getResponse();
                        if (response2 != null && (gProStComment2 = response2.comment) != null) {
                            idd = gProStComment2.idd;
                        }
                        if (idd == null) {
                            idd = "";
                        }
                    } else {
                        idd = commentRequestOperationResult.getFakeComment().idd;
                    }
                    CommentListDataProcessor u27 = u2();
                    Intrinsics.checkNotNullExpressionValue(idd, "idd");
                    N1("message_item_data_changed", new g.OnItemDataChangedMessage(6, u27.m(idd), null, 4, null));
                    return;
                }
                QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "handleCommentRequestOperationResult error, fakeComment" + commentRequestOperationResult.getFakeComment() + ", response" + commentRequestOperationResult.getResponse());
                return;
            }
            return;
        }
        if (commentRequestOperationResult.getOperationMessage().getOperation() == 1 && (commentRequestOperationResult.getOperationMessage().getPayload() instanceof jl1.b)) {
            m2((jl1.b) commentRequestOperationResult.getOperationMessage().getPayload());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean E() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    @Nullable
    public Object a0(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            switch (action.hashCode()) {
                case -929924659:
                    if (action.equals("action_get_detail_comment_title_data")) {
                        return this.commentTitleData;
                    }
                    break;
                case -811575074:
                    if (action.equals("action_get_has_top_comment")) {
                        return Boolean.valueOf(!u2().B().isEmpty());
                    }
                    break;
                case 584338023:
                    if (action.equals("action_get_comment_struct")) {
                        return E2(args);
                    }
                    break;
                case 1756453013:
                    if (action.equals("action_get_comment_load_info")) {
                        return new CommentLoadInfo(u2().w().size(), this.isFinish);
                    }
                    break;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean c(@Nullable String action, @Nullable Object args) {
        if (action == null) {
            return false;
        }
        switch (action.hashCode()) {
            case -2012717164:
                if (!action.equals("message_resend_reply_item")) {
                    return false;
                }
                J2(args);
                return true;
            case -1769454190:
                if (!action.equals("message_top_comment_list_item")) {
                    return false;
                }
                P2(args);
                return true;
            case -1741463200:
                if (!action.equals("message_expand_reply_list")) {
                    return false;
                }
                C2(args);
                return true;
            case -1718264873:
                if (!action.equals("message_update_comment_list_like_status")) {
                    return false;
                }
                Q2(args);
                return true;
            case -1171642222:
                if (!action.equals("message_reply_request_operation_result")) {
                    return false;
                }
                O2(args);
                return true;
            case -907902401:
                if (!action.equals("message_resend_comment_item")) {
                    return false;
                }
                I2(args);
                return true;
            case -738605245:
                if (!action.equals("message_on_comment_completed")) {
                    return false;
                }
                K2(args);
                return true;
            case -59975908:
                if (!action.equals("message_change_comment_list_visibility")) {
                    return false;
                }
                H2(args);
                return true;
            case 69131257:
                action.equals("message_on_speak_permission_changed");
                return false;
            case 390249661:
                if (!action.equals("message_comment_request_operation_result")) {
                    return false;
                }
                z2(args);
                return true;
            case 1024191058:
                if (!action.equals("message_on_comment_sending")) {
                    return false;
                }
                L2(args);
                return true;
            case 1047580686:
                if (!action.equals("message_on_reply_completed")) {
                    return false;
                }
                M2(args);
                return true;
            case 1454196696:
                if (!action.equals("message_delete_comment_list_item")) {
                    return false;
                }
                A2(args);
                return true;
            case 1765293309:
                if (!action.equals("message_on_reply_comment_sending")) {
                    return false;
                }
                N2(args);
                return true;
            case 1779593113:
                if (!action.equals("message_fold_reply_list")) {
                    return false;
                }
                D2(args);
                return true;
            case 1992966720:
                if (!action.equals("message_expand_comment_item")) {
                    return false;
                }
                B2(args);
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void e1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        this.curLoadDataArgs = loadDataArgs;
        this.curRankingType = loadDataArgs.getRankingType();
        this.guildInfoUpdateObserver.l(loadDataArgs.getGuildId(), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailCommentViewModel$onLoad$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                z16 = DetailCommentViewModel.this.viewModelVisibility;
                if (z16) {
                    DetailCommentViewModel.this.r3();
                    DetailCommentViewModel.this.O1(17);
                }
            }
        });
        final GProStGetFeedCommentsReq v26 = v2(loadDataArgs, true, false);
        if (v26 == null) {
            return;
        }
        d3(11, 1, true);
        final IPerformanceReportTask f16 = com.tencent.mobileqq.guild.feed.report.c.f223280a.f(loadDataArgs);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            final int i3 = 2;
            c16.getFeedComments(v26, new IGProGetFeedCommentsCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback
                public final void onResult(int i16, String str, boolean z16, GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
                    DetailCommentViewModel.g3(IPerformanceReportTask.this, this, v26, i3, i16, str, z16, gProStGetFeedCommentsRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public int getIdentifier() {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedNativeDetail.ContentDetailCommentViewModel";
    }

    public final void l2(@Nullable wk1.h ioc) {
        this.inputContextProvide = ioc;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void onDestroy() {
        QLog.i("FeedNativeDetail.ContentDetailCommentViewModel", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        this.guildInfoUpdateObserver.i();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void s(@NotNull LoadDataArgs loadDataArgs) {
        com.tencent.qqnt.kernel.api.o c16;
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "onLoadMore, curType = " + this.curRankingType);
        if (this.isFinish) {
            QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "onLoadMore return for isFinish");
            return;
        }
        final GProStGetFeedCommentsReq v26 = v2(loadDataArgs, false, true);
        if (v26 != null && (c16 = com.tencent.mobileqq.guild.feed.util.l.c()) != null) {
            final int i3 = 3;
            c16.getFeedComments(v26, new IGProGetFeedCommentsCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.j
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback
                public final void onResult(int i16, String str, boolean z16, GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
                    DetailCommentViewModel.i3(DetailCommentViewModel.this, v26, i3, i16, str, z16, gProStGetFeedCommentsRsp);
                }
            });
        }
    }

    public final void s3(boolean isFeedAllowComment) {
        this.isFeedAllowComment = isFeedAllowComment;
        r3();
        O1(19);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void t0(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        this.viewModelVisibility = true;
        this.curLoadDataArgs = loadDataArgs;
        this.curRankingType = loadDataArgs.getRankingType();
        QLog.e("FeedNativeDetail.ContentDetailCommentViewModel", 1, "reload, type = " + loadDataArgs.getRankingType());
        final GProStGetFeedCommentsReq v26 = v2(loadDataArgs, false, false);
        if (v26 == null) {
            return;
        }
        d3(11, 1, true);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            final int i3 = 4;
            c16.getFeedComments(v26, new IGProGetFeedCommentsCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.g
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback
                public final void onResult(int i16, String str, boolean z16, GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
                    DetailCommentViewModel.m3(DetailCommentViewModel.this, v26, i3, i16, str, z16, gProStGetFeedCommentsRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void y1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
    }

    public DetailCommentViewModel(@NotNull Companion.Config config) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(config, "config");
        this.viewModelVisibility = true;
        this.curAttachInfo = "";
        this.isFinish = true;
        this.curRankingType = 1;
        this.commentTitleData = new jl1.f(config.getInitCommentCount());
        this.guildInfoUpdateObserver = new GuildInfoIsMemberUpdateObserver();
        this.isFeedAllowComment = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommentListDataProcessor>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailCommentViewModel$dataProcessor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommentListDataProcessor invoke() {
                return new CommentListDataProcessor();
            }
        });
        this.dataProcessor = lazy;
    }

    public /* synthetic */ DetailCommentViewModel(Companion.Config config, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Companion.Config(0, 1, null) : config);
    }
}
