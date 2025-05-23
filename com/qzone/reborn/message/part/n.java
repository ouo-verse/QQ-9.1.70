package com.qzone.reborn.message.part;

import android.view.View;
import bl.CommonNoticeBean;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/message/part/n;", "Lcom/qzone/reborn/base/k;", "Ldl/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lbl/a;", "noticeBean", "", com.tencent.luggage.wxa.c8.c.G, "c7", "Lgf/a;", "d", "Lgf/a;", "commentIoc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends com.qzone.reborn.base.k implements dl.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private gf.a commentIoc;

    @Override // dl.a
    public void c7(CommonNoticeBean noticeBean, int pos) {
        Intrinsics.checkNotNullParameter(noticeBean, "noticeBean");
        Object obj = noticeBean.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData == null) {
            return;
        }
        if (this.commentIoc == null) {
            this.commentIoc = (gf.a) getIocInterface(gf.a.class);
        }
        com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(businessFeedData);
        bVar.f54740a = pos;
        bVar.f54741b = 4;
        bVar.f54742c = 1;
        Comment mainComment = businessFeedData.getMainComment();
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.isComment = true;
        clickedComment.setComment(mainComment);
        clickedComment.setReply(null);
        gf.a aVar = this.commentIoc;
        if (aVar != null) {
            aVar.f6(bVar);
        }
        gf.a aVar2 = this.commentIoc;
        if (aVar2 != null) {
            aVar2.x1(clickedComment);
        }
        gf.a aVar3 = this.commentIoc;
        if (aVar3 != null) {
            aVar3.c1(businessFeedData, clickedComment, pos);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.a.class);
    }
}
