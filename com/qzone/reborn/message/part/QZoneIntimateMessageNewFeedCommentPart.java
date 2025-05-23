package com.qzone.reborn.message.part;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.message.event.QZoneNoticeReplySuccessEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nk.ah;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/message/part/QZoneIntimateMessageNewFeedCommentPart;", "Lcom/qzone/reborn/intimate/part/feed/h;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "H9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "", "T9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateMessageNewFeedCommentPart extends com.qzone.reborn.intimate.part.feed.h {
    @Override // com.qzone.reborn.intimate.part.feed.h
    public BusinessFeedData H9(String feedId) {
        hl.c cVar = (hl.c) getViewModel(hl.c.class);
        BusinessFeedData T1 = cVar != null ? cVar.T1() : null;
        String a16 = ef.b.a(T1);
        if (a16 == null || a16.length() == 0) {
            return null;
        }
        if ((feedId == null || feedId.length() == 0) || T1 == null || !Intrinsics.areEqual(ef.b.a(T1), feedId)) {
            return null;
        }
        return T1;
    }

    @Override // com.qzone.reborn.intimate.part.feed.h
    public void T9(QZoneCommentPanelResultBean commentResultBean) {
        Intrinsics.checkNotNullParameter(commentResultBean, "commentResultBean");
        BusinessFeedData H9 = H9(commentResultBean.getFeedId());
        if (H9 != null) {
            ff.a aVar = ff.a.f398543a;
            Reply e16 = aVar.e(commentResultBean, getMClickComment());
            aVar.h(H9, getMClickComment(), e16);
            ah mCommentViewModel = getMCommentViewModel();
            if (mCommentViewModel != null) {
                ClickedComment mClickComment = getMClickComment();
                mCommentViewModel.Q1(H9, mClickComment != null ? mClickComment.getComment() : null, e16, new Function0<Unit>() { // from class: com.qzone.reborn.message.part.QZoneIntimateMessageNewFeedCommentPart$sendReply$1$1
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
                        BusinessFeedData mFeedData;
                        int mFeedPosition;
                        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                        mFeedData = QZoneIntimateMessageNewFeedCommentPart.this.getMFeedData();
                        String a16 = ef.b.a(mFeedData);
                        if (a16 == null) {
                            a16 = "";
                        }
                        mFeedPosition = QZoneIntimateMessageNewFeedCommentPart.this.getMFeedPosition();
                        simpleEventBus.dispatchEvent(new QZoneNoticeReplySuccessEvent(a16, mFeedPosition));
                    }
                });
            }
        }
    }
}
