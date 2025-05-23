package com.qzone.reborn.intimate.part.message;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nk.ay;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StReply;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/intimate/part/message/e;", "Lcom/qzone/reborn/base/k;", "Lqj/h;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/qzone/reborn/message/data/a;", "messageBean", "", "position", "J5", "Lgf/a;", "C9", "Lnk/ay;", "d", "Lnk/ay;", "mMessageViewModel", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "f", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "mComment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", h.F, "Lcom/qzone/proxy/feedcomponent/model/Reply;", "mReply", "i", "Lgf/a;", "mCommentIoc", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends k implements qj.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ay mMessageViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Comment mComment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Reply mReply;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private gf.a mCommentIoc;

    public final gf.a C9() {
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (gf.a) getIocInterface(gf.a.class);
        }
        return this.mCommentIoc;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, qj.h.class);
        ViewModel viewModel = getViewModel(ay.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ageViewModel::class.java)");
        this.mMessageViewModel = (ay) viewModel;
    }

    @Override // qj.h
    public void J5(com.qzone.reborn.message.data.a messageBean, int position) {
        if (messageBean == null) {
            return;
        }
        oj.a aVar = oj.a.f423008a;
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = messageBean.getStNotice().feed.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StFeed, "messageBean.stNotice.feed.get()");
        this.mFeedData = aVar.B(qZoneBaseMeta$StFeed, messageBean.getStCommonExt());
        this.mComment = aVar.P(messageBean.getStNotice().feed_comment.get(), messageBean.getStCommonExt());
        QZoneBaseMeta$StReply qZoneBaseMeta$StReply = messageBean.getStNotice().feed_reply.get();
        ay ayVar = null;
        if (qZoneBaseMeta$StReply != null) {
            if (TextUtils.isEmpty(qZoneBaseMeta$StReply.user.uid.get())) {
                qZoneBaseMeta$StReply.user.set(messageBean.getStNotice().op_user.get());
            }
            Unit unit = Unit.INSTANCE;
        } else {
            qZoneBaseMeta$StReply = null;
        }
        this.mReply = aVar.Z(qZoneBaseMeta$StReply, messageBean.getStCommonExt());
        if (this.mFeedData == null) {
            QLog.e(getTAG(), 1, "doReplyOperate mFeedData is null");
            return;
        }
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.isComment = this.mReply == null;
        clickedComment.setComment(this.mComment);
        clickedComment.setReply(this.mReply);
        if (C9() != null) {
            ay ayVar2 = this.mMessageViewModel;
            if (ayVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMessageViewModel");
            } else {
                ayVar = ayVar2;
            }
            ayVar.U1().postValue(this.mFeedData);
            gf.a C9 = C9();
            Intrinsics.checkNotNull(C9);
            C9.f6(new com.qzone.reborn.feedx.bean.b(this.mFeedData));
            gf.a C92 = C9();
            Intrinsics.checkNotNull(C92);
            C92.x1(clickedComment);
            gf.a C93 = C9();
            Intrinsics.checkNotNull(C93);
            C93.c1(this.mFeedData, clickedComment, position);
        }
    }
}
