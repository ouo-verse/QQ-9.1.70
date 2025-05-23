package com.qzone.reborn.message.part;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import bl.CommonNoticeBean;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/message/part/i;", "Lcom/qzone/reborn/base/k;", "Ldl/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lbl/a;", "noticeBean", "", com.tencent.luggage.wxa.c8.c.G, "c7", "Lhl/c;", "d", "Lhl/c;", "mMessageViewModel", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "f", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "mComment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", tl.h.F, "Lcom/qzone/proxy/feedcomponent/model/Reply;", "mReply", "Lgf/a;", "i", "Lgf/a;", "mCommentIoc", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends com.qzone.reborn.base.k implements dl.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private hl.c mMessageViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Comment mComment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Reply mReply;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private gf.a mCommentIoc;

    @Override // dl.a
    public void c7(CommonNoticeBean noticeBean, int pos) {
        Intrinsics.checkNotNullParameter(noticeBean, "noticeBean");
        Object obj = noticeBean.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        hl.c cVar = null;
        if (!(obj instanceof QZIntimateSpaceReader$StNotice)) {
            obj = null;
        }
        QZIntimateSpaceReader$StNotice qZIntimateSpaceReader$StNotice = (QZIntimateSpaceReader$StNotice) obj;
        if (qZIntimateSpaceReader$StNotice == null) {
            QLog.e("QZoneIntimateMessageNewCommentPart", 1, "origin intimate space StNotice is null");
            return;
        }
        QZoneBaseCommon$StCommonExt h16 = mj.a.h(noticeBean.getCommonExt());
        oj.a aVar = oj.a.f423008a;
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = qZIntimateSpaceReader$StNotice.feed.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StFeed, "originNotice.feed.get()");
        this.mFeedData = aVar.B(qZoneBaseMeta$StFeed, h16);
        this.mComment = aVar.P(qZIntimateSpaceReader$StNotice.feed_comment.get(), h16);
        QZoneBaseMeta$StReply qZoneBaseMeta$StReply = qZIntimateSpaceReader$StNotice.feed_reply.get();
        if (qZoneBaseMeta$StReply != null) {
            if (TextUtils.isEmpty(qZoneBaseMeta$StReply.user.uid.get())) {
                qZoneBaseMeta$StReply.user.set(qZIntimateSpaceReader$StNotice.op_user.get());
            }
            Unit unit = Unit.INSTANCE;
        } else {
            qZoneBaseMeta$StReply = null;
        }
        this.mReply = aVar.Z(qZoneBaseMeta$StReply, h16);
        if (this.mFeedData == null) {
            QLog.e("QZoneIntimateMessageNewCommentPart", 1, "[doReplyOperate] mFeedData is null");
            return;
        }
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.isComment = this.mReply == null;
        clickedComment.setComment(this.mComment);
        clickedComment.setReply(this.mReply);
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (gf.a) getIocInterface(gf.a.class);
        }
        gf.a aVar2 = this.mCommentIoc;
        if (aVar2 != null) {
            hl.c cVar2 = this.mMessageViewModel;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMessageViewModel");
            } else {
                cVar = cVar2;
            }
            cVar.U1().postValue(this.mFeedData);
            aVar2.f6(new com.qzone.reborn.feedx.bean.b(this.mFeedData));
            aVar2.x1(clickedComment);
            aVar2.c1(this.mFeedData, clickedComment, pos);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.a.class);
        ViewModel viewModel = getViewModel(hl.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026NewViewModel::class.java)");
        this.mMessageViewModel = (hl.c) viewModel;
    }
}
