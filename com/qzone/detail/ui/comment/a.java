package com.qzone.detail.ui.comment;

import android.app.Activity;
import android.os.Handler;
import com.qzone.business.lbsv2.business.c;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.service.PictureManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.widget.RapidCommentExpressionInfo;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends CommentListBaseController {
    /* JADX INFO: Access modifiers changed from: protected */
    public a(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void A() {
        if (T0().C > 0 && !T0().f46826d) {
            PictureManager.getInstance().getSender().getMoreComment(this.K, this.f46896d, this.f46898e, this.f46903h, this.f46900f, T0().f46831m, 29, this.D, 1048578, false, true);
        } else {
            if (T0().E <= 0 || T0().f46826d) {
                return;
            }
            PictureManager.getInstance().getSender().getMoreCommentEssence(this.K, this.f46896d, this.f46898e, this.f46903h, this.f46900f, T0().D, 29, this.D, 1048579, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void B(Handler handler, QZoneWriteOperationService.k kVar) {
        super.B(handler, kVar);
        PictureManager.getInstance().getSender().likeComment(handler, kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void C(QZoneWriteOperationService.l lVar, RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        QZoneWriteOperationService.l lVar2 = new QZoneWriteOperationService.l();
        lVar2.f45712e = lVar.f45712e;
        lVar2.f45718k = lVar.f45718k;
        lVar2.f45715h = lVar.f45715h;
        lVar2.f45716i = lVar.f45716i;
        lVar2.f45710c = lVar.f45710c;
        lVar2.f45709b = lVar.f45709b;
        lVar2.f45711d = lVar.f45711d;
        lVar2.f45725r = lVar.f45725r;
        lVar2.f45724q = lVar.f45724q;
        lVar2.f45720m = lVar.f45720m;
        lVar2.f45713f = lVar.f45713f;
        lVar2.f45722o = lVar.f45722o;
        lVar2.f45714g = lVar.f45714g;
        lVar2.f45708a = lVar.f45708a;
        lVar2.f45726s = lVar.f45726s;
        lVar2.f45727t = lVar.f45727t;
        lVar2.f45723p = lVar.f45723p;
        lVar2.f45730w = lVar.f45730w;
        lVar2.f45729v = lVar.f45729v;
        super.C(lVar2, rapidCommentExpressionInfo);
        PictureManager.getInstance().getSender().rapidCommentFeed(this.K, lVar, rapidCommentExpressionInfo);
    }

    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void D() {
        PictureManager.getInstance().getSender().getFeedComment(this.K, this.f46896d, this.f46898e, this.f46903h, this.f46900f, this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void u0(QZoneResult qZoneResult) {
        super.u0(qZoneResult);
        if (qZoneResult == null) {
            return;
        }
        switch (qZoneResult.what) {
            case 999905:
            case 999907:
            case 999909:
            case 999978:
            case 1000087:
                if (qZoneResult.getSucceed()) {
                    T0().A0(T0().R(), this.f46905i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    protected void x(QZoneWriteOperationService.l lVar) {
        QZoneWriteOperationService.v0().F1(lVar);
        PictureManager.getInstance().getSender().commentFeed(this.K, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void y(Handler handler, BusinessFeedData businessFeedData, Comment comment) {
        super.y(handler, businessFeedData, comment);
        PictureManager.getInstance().getSender().deleteComment(handler, businessFeedData, comment);
    }

    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    protected void y0(int i3, int i16) {
        LpReportInfo_dc00321.report(i3, i16, 2, c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void z(Handler handler, BusinessFeedData businessFeedData, Reply reply, Comment comment, int i3) {
        super.z(handler, businessFeedData, reply, comment, i3);
        PictureManager.getInstance().getSender().deleteReply(handler, businessFeedData, reply, comment, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.comment.CommentListBaseController
    public void E(Handler handler, String str, String str2, String str3, int i3, long j3, long j16, User user, String str4, String str5, String str6, String str7, String str8, String str9, int i16, Map<Integer, String> map, String str10, boolean z16, int i17, int i18, Map<String, String> map2) {
        super.E(handler, str, str2, str3, i3, j3, j16, user, str4, str5, str6, str7, str8, str9, i16, map, str10, z16, i17, i18, map2);
        PictureManager.getInstance().getSender().replyFeed(handler, str, str2, str3, i3, j3, j16, user, str4, str5, str6, str7, str8, str9, i16, map, str10, z16, i17, i18, map2);
    }
}
