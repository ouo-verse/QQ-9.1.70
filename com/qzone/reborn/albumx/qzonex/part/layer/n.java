package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditMediaEvent;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.util.w;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EditPhoto;
import com.tencent.qqnt.kernel.nativeinterface.EditPhotoOperaType;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditBatchMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAEditBatchMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditBatchMediaRsp;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001a\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\"\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\nH\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020\rH\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020$2\u0006\u00100\u001a\u00020\nH\u0016J\u0018\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u00020$2\u0006\u00100\u001a\u00020\rH\u0016R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u000b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=\u00a8\u0006D"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/n;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Ll9/g;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "", "J9", "K9", "L9", "X9", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "clickedComment", "H9", "Lcom/qzone/reborn/albumx/common/bean/g;", "reply", "I9", "Lcom/qzone/reborn/albumx/common/bean/d;", "N9", "clickedInfo", "P9", "Q9", "aa", "clickComment", "O9", "R9", "", "U9", "T9", "Z9", "Y9", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onActivityResult", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "X7", "data", "v8", "q0", "S1", "d6", "view", "W3", "r1", "Loc/p;", tl.h.F, "Loc/p;", "mCommentViewModel", "i", "Lcom/qzone/reborn/albumx/common/bean/g;", "clickedReply", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends b implements l9.g {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private oc.p mCommentViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.bean.g clickedReply;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.bean.g clickedComment = new com.qzone.reborn.albumx.common.bean.g();

    private final void H9(Comment clickedComment) {
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        oc.p pVar = this.mCommentViewModel;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            pVar = null;
        }
        pVar.Z1(N9, clickedComment);
    }

    private final void I9(com.qzone.reborn.albumx.common.bean.g reply) {
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        oc.p pVar = this.mCommentViewModel;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            pVar = null;
        }
        pVar.X1(0, N9, reply.getHostComment(), reply.getStReply());
    }

    private final void J9(QZoneCommentPanelResultBean commentResultBean) {
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(this.clickedComment.getHostComment());
        clickedComment.setReply(this.clickedComment.getStReply());
        clickedComment.setComment(this.clickedComment.getHostComment());
        ff.a aVar = ff.a.f398543a;
        Reply e16 = aVar.e(commentResultBean, clickedComment);
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String uin = x95.getUin();
        Intrinsics.checkNotNull(uin);
        Reply b16 = aVar.b(e16, uin);
        oc.p pVar = this.mCommentViewModel;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            pVar = null;
        }
        pVar.Q1(N9, clickedComment.getComment(), b16, clickedComment.getReply());
    }

    private final void K9(QZoneCommentPanelResultBean commentResultBean) {
        if (this.clickedReply == null) {
            return;
        }
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        ClickedComment clickedComment = new ClickedComment();
        com.qzone.reborn.albumx.common.bean.g gVar = this.clickedReply;
        oc.p pVar = null;
        clickedComment.setComment(gVar != null ? gVar.getHostComment() : null);
        com.qzone.reborn.albumx.common.bean.g gVar2 = this.clickedReply;
        clickedComment.setReply(gVar2 != null ? gVar2.getStReply() : null);
        ff.a aVar = ff.a.f398543a;
        Reply e16 = aVar.e(commentResultBean, clickedComment);
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String uin = x95.getUin();
        Intrinsics.checkNotNull(uin);
        Reply b16 = aVar.b(e16, uin);
        oc.p pVar2 = this.mCommentViewModel;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
        } else {
            pVar = pVar2;
        }
        pVar.Q1(N9, clickedComment.getComment(), b16, clickedComment.getReply());
    }

    private final void L9(QZoneCommentPanelResultBean commentResultBean) {
        String albumId;
        String lLoc;
        QZAlbumxLayerExtraInfoBean x95 = x9();
        String str = "";
        final String str2 = (x95 == null || (lLoc = x95.getLLoc()) == null) ? "" : lLoc;
        QZAlbumxLayerExtraInfoBean x96 = x9();
        final String valueOf = String.valueOf(x96 != null ? Long.valueOf(x96.getLinkId()) : null);
        final String inputContent = commentResultBean.getInputContent();
        PAEditBatchMediaReq pAEditBatchMediaReq = new PAEditBatchMediaReq();
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 != null && (albumId = x97.getAlbumId()) != null) {
            str = albumId;
        }
        pAEditBatchMediaReq.albumId = str;
        ArrayList<EditPhoto> arrayList = pAEditBatchMediaReq.editPhotoList;
        EditPhoto editPhoto = new EditPhoto();
        editPhoto.desc = inputContent;
        editPhoto.picId = str2;
        arrayList.add(editPhoto);
        pAEditBatchMediaReq.operations.add(Integer.valueOf(EditPhotoOperaType.KEDITPHOTOOPERATYPEDESC.ordinal()));
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.editBatchMedia(pAEditBatchMediaReq, new IPersonalAlbumServiceEditBatchMediaCallback() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditBatchMediaCallback
                public final void onEditBatchMedia(PAEditBatchMediaRsp pAEditBatchMediaRsp) {
                    n.M9(currentTimeMillis, this, valueOf, str2, inputContent, pAEditBatchMediaRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(long j3, n this$0, String linkId, String lloc, String desc, PAEditBatchMediaRsp pAEditBatchMediaRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(linkId, "$linkId");
        Intrinsics.checkNotNullParameter(lloc, "$lloc");
        Intrinsics.checkNotNullParameter(desc, "$desc");
        mc.c.f416541a.e("editBatchMedia", System.currentTimeMillis() - j3, pAEditBatchMediaRsp.result);
        if (pAEditBatchMediaRsp.result != 0) {
            QLog.d(this$0.getTAG(), 1, "editBatchMediaTime fail, traceId: " + pAEditBatchMediaRsp.traceId + ", msg:" + pAEditBatchMediaRsp.errMs);
            String str = pAEditBatchMediaRsp.errMs;
            if (str == null || str.length() == 0) {
                str = "\u4fee\u6539\u63cf\u8ff0\u5931\u8d25";
            }
            com.qzone.reborn.util.o.f59556a.d(str, 1);
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxEditMediaEvent(linkId, lloc, true, desc));
        com.qzone.reborn.util.o.f59556a.d("\u4fee\u6539\u63cf\u8ff0\u6210\u529f", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        if (r1 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.qzone.reborn.albumx.common.bean.d N9() {
        String str;
        String str2;
        String str3;
        String str4;
        String uin;
        com.qzone.reborn.albumx.common.bean.d dVar = new com.qzone.reborn.albumx.common.bean.d();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        dVar.n(x95 != null ? x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String() : false);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        String str5 = "";
        if (x96 == null || (str = x96.getUin()) == null) {
            str = "";
        }
        dVar.k(str);
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str2 = x97.getAlbumId()) == null) {
            str2 = "";
        }
        dVar.h(str2);
        QZAlbumxLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str3 = x98.getBatchId()) == null) {
            str3 = "";
        }
        dVar.i(str3);
        QZAlbumxLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str4 = x99.getLLoc()) == null) {
            str4 = "";
        }
        dVar.l(str4);
        QZAlbumxLayerExtraInfoBean x910 = x9();
        if (x910 == null || (uin = x910.getAlbumCreatorUin()) == null) {
            QZAlbumxLayerExtraInfoBean x911 = x9();
            uin = x911 != null ? x911.getUin() : null;
        }
        str5 = uin;
        dVar.m(str5);
        QZAlbumxLayerExtraInfoBean x912 = x9();
        dVar.j(x912 != null ? x912.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() : 0L);
        return dVar;
    }

    private final void O9(Comment clickComment) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        String str = clickComment.comment;
        Intrinsics.checkNotNullExpressionValue(str, "clickComment.comment");
        qZoneCommentPanelResultBean.C(str);
        String str2 = clickComment.commentid;
        Intrinsics.checkNotNullExpressionValue(str2, "clickComment.commentid");
        qZoneCommentPanelResultBean.A(str2);
        X9(qZoneCommentPanelResultBean);
    }

    private final void P9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        String str;
        if (S9(clickedInfo)) {
            Comment hostComment = clickedInfo.getHostComment();
            str = hostComment != null ? hostComment.comment : null;
            Intrinsics.checkNotNull(str);
        } else {
            Reply stReply = clickedInfo.getStReply();
            str = stReply != null ? stReply.content : null;
            Intrinsics.checkNotNull(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(str));
    }

    private final void Q9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        aa(clickedInfo);
    }

    private final void R9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        com.qzone.reborn.util.o.f59556a.c(R.string.jll, 2);
    }

    private final boolean S9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        return clickedInfo.getStReply() == null && clickedInfo.getHostComment() != null;
    }

    private final boolean T9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (!Intrinsics.areEqual(x95 != null ? x95.getUploadUid() : null, LoginData.getInstance().getUinString())) {
            QZAlbumxLayerExtraInfoBean x96 = x9();
            if (!Intrinsics.areEqual(x96 != null ? x96.getUploadUid() : null, LoginData.getInstance().getUid())) {
                return false;
            }
        }
        return true;
    }

    private final boolean U9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        Reply stReply;
        User user;
        Reply stReply2;
        User user2;
        Comment hostComment;
        User user3;
        Comment hostComment2;
        User user4;
        String str = null;
        if (S9(clickedInfo)) {
            if ((clickedInfo == null || (hostComment2 = clickedInfo.getHostComment()) == null || (user4 = hostComment2.user) == null || user4.uin != LoginData.getInstance().getUin()) ? false : true) {
                return true;
            }
            if (clickedInfo != null && (hostComment = clickedInfo.getHostComment()) != null && (user3 = hostComment.user) != null) {
                str = user3.uid;
            }
            return Intrinsics.areEqual(str, LoginData.getInstance().getUid());
        }
        if ((clickedInfo == null || (stReply2 = clickedInfo.getStReply()) == null || (user2 = stReply2.user) == null || user2.uin != LoginData.getInstance().getUin()) ? false : true) {
            return true;
        }
        if (clickedInfo != null && (stReply = clickedInfo.getStReply()) != null && (user = stReply.user) != null) {
            str = user.uid;
        }
        return Intrinsics.areEqual(str, LoginData.getInstance().getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(n this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            this$0.P9(this$0.clickedComment);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            this$0.Q9(this$0.clickedComment);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0w) {
            Comment hostComment = this$0.clickedComment.getHostComment();
            Intrinsics.checkNotNull(hostComment);
            this$0.O9(hostComment);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            this$0.R9(this$0.clickedComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(n this$0, com.qzone.reborn.albumx.common.bean.g data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            this$0.P9(data);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            this$0.Q9(data);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            this$0.R9(data);
        }
    }

    private final void X9(QZoneCommentPanelResultBean commentResultBean) {
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        ff.a aVar = ff.a.f398543a;
        Comment c16 = aVar.c(commentResultBean);
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String uin = x95.getUin();
        Intrinsics.checkNotNull(uin);
        Comment a16 = aVar.a(c16, uin);
        oc.p pVar = this.mCommentViewModel;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            pVar = null;
        }
        pVar.T1(N9, a16, commentResultBean.g());
    }

    private final boolean Y9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        boolean z16;
        Comment hostComment = clickedInfo.getHostComment();
        if (!(hostComment != null && hostComment.isFake)) {
            Reply stReply = clickedInfo.getStReply();
            if (!(stReply != null && stReply.isFake)) {
                z16 = false;
                return (!U9(clickedInfo) || T9()) && !z16;
            }
        }
        z16 = true;
        if (U9(clickedInfo)) {
        }
    }

    private final boolean Z9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        return !U9(clickedInfo);
    }

    private final void aa(final com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u5220\u9664", 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.l
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                n.ba(n.this, clickedInfo, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        ef.d.f(actionSheet, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(n this$0, com.qzone.reborn.albumx.common.bean.g clickedInfo, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickedInfo, "$clickedInfo");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            if (this$0.S9(clickedInfo)) {
                this$0.H9(clickedInfo.getHostComment());
            } else {
                this$0.I9(clickedInfo);
            }
            actionSheet.dismiss();
        }
    }

    @Override // l9.g
    public void S1(com.qzone.reborn.albumx.common.bean.g data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedReply = data;
        if (U9(data)) {
            aa(data);
            return;
        }
        Reply stReply = data.getStReply();
        Intrinsics.checkNotNull(stReply);
        String nickname = stReply.user.nickName;
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(514);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().p(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), N9);
    }

    @Override // l9.g
    public void W3(View view, Comment data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedComment.d(data);
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        if (Y9(this.clickedComment)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
        }
        cVar.a(R.id.n0w, HardCodeUtil.qqStr(R.string.rfg));
        if (Z9(this.clickedComment)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
        }
        com.qzone.reborn.feedx.util.w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.k
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                n.V9(n.this, view2);
            }
        });
    }

    @Override // l9.g
    public void X7(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        QLog.e("huanxxiao", RFWLog.USR, "onClickAvatarOrName");
        ho.h.b(getActivity(), user.uin);
    }

    @Override // l9.g
    public void d6() {
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        ho.i.c().p(new QZoneCommentPanelParams.a().q(cd.c.j(false, null, 3, null)).y(512).getParams(), getActivity(), N9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null || (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) == null) {
            return;
        }
        switch (requestCode) {
            case 512:
                X9(qZoneCommentPanelResultBean);
                return;
            case 513:
                J9(qZoneCommentPanelResultBean);
                return;
            case 514:
                K9(qZoneCommentPanelResultBean);
                return;
            case 515:
                L9(qZoneCommentPanelResultBean);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(oc.p.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxLay\u2026entViewModel::class.java)");
        this.mCommentViewModel = (oc.p) viewModel;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        oc.p pVar = null;
        if (extras != null && extras.containsKey("key_feed_id")) {
            oc.p pVar2 = this.mCommentViewModel;
            if (pVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
                pVar2 = null;
            }
            String stringExtra = intent.getStringExtra("key_feed_id");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "it.getStringExtra(QZAlbu\u2026Launcher.KEY_FEED_ID)?:\"\"");
            }
            pVar2.o3(stringExtra);
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 != null && extras2.containsKey("key_is_detail_layer")) {
            oc.p pVar3 = this.mCommentViewModel;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            } else {
                pVar = pVar3;
            }
            pVar.m3(intent.getBooleanExtra("key_is_detail_layer", false));
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, l9.g.class);
    }

    @Override // l9.g
    public void q0(Comment data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedComment.d(data);
        String nickname = data.user.nickName;
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(513);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().p(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), N9);
    }

    @Override // l9.g
    public void r1(View view, final com.qzone.reborn.albumx.common.bean.g data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        if (Y9(data)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
        }
        if (Z9(data)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
        }
        com.qzone.reborn.feedx.util.w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.m
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                n.W9(n.this, data, view2);
            }
        });
    }

    @Override // l9.g
    public void v8(Comment data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedComment.d(data);
        if (U9(this.clickedComment)) {
            aa(this.clickedComment);
            return;
        }
        String nickname = data.user.nickName;
        com.qzone.reborn.albumx.common.bean.d N9 = N9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(513);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().p(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), N9);
    }
}
