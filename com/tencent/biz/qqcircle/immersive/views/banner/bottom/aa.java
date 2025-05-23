package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.views.banner.g;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.IReplyMsgWithSourceMsgInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ReplyMsgWithSourceMsgInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SourceMsgInfoForReplyMsg;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.DstUinType;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$MessageInfo;
import feedcloud.FeedCloudMeta$ShareMessageReplyBox;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u00014B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0014J\b\u0010 \u001a\u00020\u0002H\u0014J\b\u0010!\u001a\u00020\u0002H\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/aa;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "", "O", "", "H", "N", "I", "M", "", "content", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/SourceMsgInfoForReplyMsg;", "E", UserInfo.SEX_FEMALE, "J", "D", "", "emojiId", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Le30/b;", "data", "position", tl.h.F, "isElementCanActivate", "onElementActivated", "onElementInactivated", "getPriority", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/view/View;", "Landroid/view/View;", "mBanner", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTextView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mEmojiRecycler", "Lcom/tencent/biz/qqcircle/immersive/views/banner/g;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/g;", "mEmojiAdapter", "Ljava/lang/String;", "mEmojiString", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aa extends c {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mBanner;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mEmojiRecycler;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.views.banner.g mEmojiAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String mEmojiString;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/aa$b", "Lcom/tencent/biz/qqcircle/comment/QFSBaseInputPopupWindow$b;", "", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QFSBaseInputPopupWindow.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public void a() {
            String str;
            com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
            if (K != null) {
                str = K.f0();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            QLog.d(aa.this.m(), 1, "[onSendEvent] text:" + str);
            aa.this.B(str);
            com.tencent.biz.qqcircle.comment.u K2 = QFSCommentHelper.L().K();
            if (K2 != null) {
                K2.dismiss();
            }
            aa.this.z();
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public void b() {
            String str;
            com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
            if (K != null) {
                str = K.g0();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            QLog.d(aa.this.m(), 1, "[onDismissEvent] text:" + str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    private final void A() {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (this.mBanner == null) {
            return;
        }
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        String str2 = null;
        if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        map.put("xsj_feed_id", str);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.ARK_CMT);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        VideoReport.setElementId(this.mBanner, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR);
        VideoReport.setElementParams(this.mBanner, map);
        View view = this.mBanner;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f90602e;
        if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
            str2 = pBStringField.get();
        }
        VideoReport.setElementReuseIdentifier(view, "QFSFeedShareMessageReplyView" + str2);
        VideoReport.setElementExposePolicy(this.mBanner, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.mBanner, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.mBanner, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String content) {
        Unit unit;
        if (content != null) {
            SourceMsgInfoForReplyMsg E = E();
            if (E != null) {
                QLog.d(m(), 1, "[fastReplyMessage] start, " + E);
                au.d(content, E, new IReplyMsgWithSourceMsgInfoCallback() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.z
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IReplyMsgWithSourceMsgInfoCallback
                    public final void onResult(ReplyMsgWithSourceMsgInfoResult replyMsgWithSourceMsgInfoResult) {
                        aa.C(aa.this, replyMsgWithSourceMsgInfoResult);
                    }
                });
            } else {
                QLog.e(m(), 1, "[fastReplyMessage] replyMsg is null");
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(m(), 1, "[fastReplyMessage] content is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(aa this$0, ReplyMsgWithSourceMsgInfoResult replyMsgWithSourceMsgInfoResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (replyMsgWithSourceMsgInfoResult.result == 0) {
            QCircleToast.j(QCircleToast.f91645e, "\u56de\u590d\u6210\u529f", 0);
            this$0.N();
        } else {
            QCircleToast.j(QCircleToast.f91645e, "\u56de\u590d\u5931\u8d25", 0);
        }
        QLog.d(this$0.m(), 1, "[fastReplyMessage] result, " + replyMsgWithSourceMsgInfoResult.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D() {
        String dtPageId;
        List split$default;
        boolean z16 = true;
        QLog.d(m(), 1, "[generateEmoji] mEmojiString: " + this.mEmojiString);
        String str = this.mEmojiString;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = this.mEmojiString;
        if (str2 != null && split$default != null) {
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                int c16 = cu.c((String) it.next(), -1);
                if (c16 != -1) {
                    arrayList.add(Integer.valueOf(QQSysFaceUtil.convertToLocal(c16)));
                }
            }
        }
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar = this.mEmojiAdapter;
        if (gVar != null) {
            gVar.o0(this.f90601d);
        }
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar2 = this.mEmojiAdapter;
        if (gVar2 != null) {
            if (p() == null) {
                dtPageId = "0";
            } else {
                dtPageId = p().getDtPageId();
            }
            gVar2.p0(dtPageId);
        }
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar3 = this.mEmojiAdapter;
        if (gVar3 != null) {
            gVar3.setData(arrayList);
        }
        this.mEmojiString = null;
    }

    private final SourceMsgInfoForReplyMsg E() {
        FeedCloudMeta$ShareMessageReplyBox feedCloudMeta$ShareMessageReplyBox;
        FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo;
        FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo2 = null;
        if (H()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed != null && (feedCloudMeta$ShareMessageReplyBox = feedCloudMeta$StFeed.shareMessageReplyBox) != null && (feedCloudMeta$MessageInfo = feedCloudMeta$ShareMessageReplyBox.messageInfo) != null) {
                feedCloudMeta$MessageInfo2 = feedCloudMeta$MessageInfo.get();
            }
            return au.b(feedCloudMeta$MessageInfo2);
        }
        QLog.e(m(), 1, "[getSourceMsgInfoForReplyMsg] not has reply box");
        return null;
    }

    private final String F() {
        FeedCloudMeta$ShareMessageReplyBox feedCloudMeta$ShareMessageReplyBox;
        FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$ShareMessageReplyBox = feedCloudMeta$StFeed.shareMessageReplyBox) == null || (feedCloudMeta$MessageInfo = feedCloudMeta$ShareMessageReplyBox.messageInfo) == null) {
            return "\u56de\u590d";
        }
        int i3 = feedCloudMeta$MessageInfo.chatType.get();
        if (i3 == DstUinType.UIN_TYPE_UIN.getValue()) {
            return "\u56de\u590d\u7ed9\u597d\u53cb";
        }
        if (i3 != DstUinType.UIN_TYPE_GROUP.getValue()) {
            return "\u56de\u590d";
        }
        return "\u56de\u590d\u5230\u7fa4\u804a";
    }

    private final void G(int emojiId) {
        String emoString = HostEmotionUtil.getEmoString(1, emojiId);
        QLog.d(m(), 1, "[handleEmojiClick] emojiId: " + emojiId + ", text: " + emoString);
        B(emoString);
    }

    private final boolean H() {
        FeedCloudMeta$ShareMessageReplyBox feedCloudMeta$ShareMessageReplyBox;
        FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$ShareMessageReplyBox = feedCloudMeta$StFeed.shareMessageReplyBox) != null && (feedCloudMeta$MessageInfo = feedCloudMeta$ShareMessageReplyBox.messageInfo) != null && feedCloudMeta$MessageInfo.has()) {
            return true;
        }
        return false;
    }

    private final boolean I() {
        View view = this.mBanner;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void J() {
        View view;
        ViewStub viewStub;
        TextView textView;
        if (this.mBanner != null || (view = this.f90604h) == null || (viewStub = (ViewStub) view.findViewById(R.id.f41391gy)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.mBanner = inflate;
        RecyclerView recyclerView = null;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.f41381gx);
        } else {
            textView = null;
        }
        this.mTextView = textView;
        View view2 = this.mBanner;
        if (view2 != null) {
            recyclerView = (RecyclerView) view2.findViewById(R.id.f41371gw);
        }
        this.mEmojiRecycler = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(j(), 0, false));
        }
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar = new com.tencent.biz.qqcircle.immersive.views.banner.g();
        this.mEmojiAdapter = gVar;
        gVar.r0(1);
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar2 = this.mEmojiAdapter;
        if (gVar2 != null) {
            gVar2.q0(new g.a() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.y
                @Override // com.tencent.biz.qqcircle.immersive.views.banner.g.a
                public final void a(int i3) {
                    aa.K(aa.this, i3);
                }
            });
        }
        RecyclerView recyclerView2 = this.mEmojiRecycler;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mEmojiAdapter);
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(aa this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(aa this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
        this$0.y();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M() {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d(m(), 1, "[openCommentInputWindow]");
            return;
        }
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.activity = (Activity) j();
        CharSequence charSequence = null;
        QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(this.f90602e, null, null);
        TextView textView = this.mTextView;
        if (textView != null) {
            charSequence = textView.getText();
        }
        qFSFeedCommentInfo.mHintText = String.valueOf(charSequence);
        qFSCommentInputWindowConfig.commentInfo = qFSFeedCommentInfo;
        qFSCommentInputWindowConfig.needShowAtIcon = false;
        qFSCommentInputWindowConfig.needShowRecommendBar = false;
        qFSCommentInputWindowConfig.needShowFavoriteTab = false;
        qFSCommentInputWindowConfig.isShowEmoji = false;
        qFSCommentInputWindowConfig.isShowPostBtn = false;
        qFSCommentInputWindowConfig.isAllowAiComment = false;
        qFSCommentInputWindowConfig.reportBean = p();
        boolean A0 = QFSCommentHelper.L().A0(qFSCommentInputWindowConfig, new b());
        QLog.d(m(), 1, "[openCommentInputWindow] show:" + A0);
    }

    private final void N() {
        FeedCloudMeta$ShareMessageReplyBox feedCloudMeta$ShareMessageReplyBox;
        FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$ShareMessageReplyBox = feedCloudMeta$StFeed.shareMessageReplyBox) != null && (feedCloudMeta$MessageInfo = feedCloudMeta$ShareMessageReplyBox.messageInfo) != null) {
            feedCloudMeta$MessageInfo.setHasFlag(false);
        }
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) this, false);
    }

    private final void O() {
        boolean z16;
        if (au.k(this.f90602e) && H()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !I()) {
            QLog.d(m(), 1, "[tryNotifyGroup] need but not show, notifyGroupActivate");
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        } else if (!z16 && I()) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) this, false);
            QLog.d(m(), 1, "[tryNotifyGroup] not need but show, inactivateElement");
        }
    }

    private final void y() {
        String str;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(this.mTextView, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR_INPUT_AREA);
        VideoReport.setElementExposePolicy(this.mTextView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.mTextView, ClickPolicy.REPORT_NONE);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        QCircleReportBean p16 = p();
        if (p16 != null) {
            str = p16.getDtPageId();
        } else {
            str = null;
        }
        map.put("xsj_custom_pgid", str);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.ARK_CMT);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.mTextView, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        String str;
        PBStringField pBStringField;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_ARK_SEND_BUTTON);
        QCircleReportBean p16 = p();
        String str2 = null;
        if (p16 != null) {
            str = p16.getDtPageId();
        } else {
            str = null;
        }
        map.put("xsj_custom_pgid", str);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str2 = pBStringField.get();
        }
        map.put("xsj_feed_id", str2);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 109;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(@Nullable e30.b data, int position) {
        FeedCloudMeta$StFeed g16;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        List<FeedCloudCommon$Entry> list;
        super.h(data, position);
        if (data != null && (g16 = data.g()) != null && (pBRepeatMessageField = g16.feedTextInfo) != null && (list = pBRepeatMessageField.get()) != null) {
            this.mEmojiString = bh.d(list, "share_message_reply_emoji");
        }
        O();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean k3 = au.k(this.f90602e);
        boolean H = H();
        QLog.d(m(), 1, "[isElementCanActivate] need show liteBanner:" + k3 + ", has reply box:" + H);
        if (k3 && H) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    @NotNull
    public String m() {
        return "QFSFeedShareMessageReplyView";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        J();
        View view = this.mBanner;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(F());
        }
        View view2 = this.mBanner;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    aa.L(aa.this, view3);
                }
            });
        }
        au.g();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        View view = this.mBanner;
        if (view != null) {
            view.setVisibility(8);
        }
        A();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
