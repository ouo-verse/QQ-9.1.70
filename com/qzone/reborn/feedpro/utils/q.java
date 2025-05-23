package com.qzone.reborn.feedpro.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedForwardManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ForwardFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/q;", "", "Lcom/qzone/reborn/share/e;", "context", "", "c", "Landroid/content/Intent;", "intent", "b", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "bean", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedForwardManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedForwardManager;", "forwardManager", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager;", "commentManager", "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "<init>", "()V", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedForwardManager forwardManager = new QzoneFeedForwardManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedCommentManager commentManager = new QzoneFeedCommentManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.share.e shareContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonFeed commonFeed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/utils/q$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<AddCommentRsp> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AddCommentRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("QzoneFeedProCommentClickProcess", 2, "doCommentIfNeed success");
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneFeedProCommentClickProcess", 1, "doCommentIfNeed fail errorCode:" + errorCode + ", errorMsg:" + errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/utils/q$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ForwardFeedRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements DataCallback<ForwardFeedRsp> {
        c() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ForwardFeedRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            c6.a.j(com.qzone.util.l.a(R.string.akw), 5);
            QLog.i("QzoneFeedProCommentClickProcess", 2, "doForward success");
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.feedpro.utils.c.f54317a.a(errorCode, errorMsg, "\u8f6c\u53d1\u5931\u8d25");
            QLog.e("QzoneFeedProCommentClickProcess", 1, "doForward fail errorCode:" + errorCode + ", errorMsg:" + errorMsg);
        }
    }

    public final void a(QZoneCommentPanelResultBean bean) {
        CommonCellCommon cellCommon;
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (!bean.getIsCheckedForwardAndComment()) {
            QLog.i("QzoneFeedProCommentClickProcess", 2, "doCommentIfNeed false");
            return;
        }
        if (TextUtils.isEmpty(bean.getInputContent())) {
            QLog.e("QzoneFeedProCommentClickProcess", 1, "doneComment  commentText is null");
            return;
        }
        List<CommonRichMsg> stringToRichMsg = CommonFeedDataUtil.INSTANCE.stringToRichMsg(bean.getInputContent());
        QzoneFeedCommentManager qzoneFeedCommentManager = this.commentManager;
        CommonFeed commonFeed = this.commonFeed;
        qzoneFeedCommentManager.addTextComment((commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? null : cellCommon.getUnionId(), stringToRichMsg, false, new b());
    }

    public final void c(com.qzone.reborn.share.e context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.shareContext = context;
        Object data = context != null ? context.getData() : null;
        CommonFeed commonFeed = data instanceof CommonFeed ? (CommonFeed) data : null;
        this.commonFeed = commonFeed;
        if (commonFeed == null) {
            QLog.e("QzoneFeedProCommentClickProcess", 1, "onForwardClick error feedData is null");
            return;
        }
        QZoneCommentPanelParams params = cd.c.c(this.commonFeed, "").y(1206).g(CommonFeedExtKt.getFeedUniqueKey(this.commonFeed)).q(com.qzone.util.l.a(R.string.f132864k)).l(true).x(11).r(true).getParams();
        ad.b k3 = ho.i.k();
        com.qzone.reborn.share.e eVar = this.shareContext;
        k3.d(params, eVar != null ? eVar.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() : null, this.commonFeed);
    }

    public final void b(Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        if (intent != null && (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) != null) {
            this.forwardManager.forwardFeed(this.commonFeed, new LinkedHashMap(), qZoneCommentPanelResultBean.getInputContent(), false, 0, new c());
            a(qZoneCommentPanelResultBean);
        } else {
            QLog.e("QzoneFeedProCommentClickProcess", 1, "doForward data is null");
        }
    }
}
