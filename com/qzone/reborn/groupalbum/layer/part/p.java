package com.qzone.reborn.groupalbum.layer.part;

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
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.util.w;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u001a\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\"\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\fH\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u0018\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020#2\u0006\u0010/\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020#2\u0006\u0010/\u001a\u00020\fH\u0016R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\n\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/p;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Ll9/g;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "", "I9", "J9", "U9", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "clickedComment", "G9", "Lcom/qzone/reborn/albumx/common/bean/g;", "reply", "H9", "Lcom/qzone/reborn/albumx/common/bean/d;", "K9", "clickedInfo", "M9", "N9", "X9", "clickComment", "L9", "O9", "", "R9", "Q9", "W9", "V9", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onActivityResult", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "X7", "data", "v8", "q0", "S1", "d6", "view", "W3", "r1", "Lcom/qzone/reborn/groupalbum/viewmodel/ad;", tl.h.F, "Lcom/qzone/reborn/groupalbum/viewmodel/ad;", "mCommentViewModel", "i", "Lcom/qzone/reborn/albumx/common/bean/g;", "clickedReply", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends b implements l9.g {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.ad mCommentViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.bean.g clickedReply;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.bean.g clickedComment = new com.qzone.reborn.albumx.common.bean.g();

    private final void G9(Comment clickedComment) {
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = this.mCommentViewModel;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            adVar = null;
        }
        adVar.Z1(K9, clickedComment);
    }

    private final void H9(com.qzone.reborn.albumx.common.bean.g reply) {
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = this.mCommentViewModel;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            adVar = null;
        }
        adVar.X1(0, K9, reply.getHostComment(), reply.getStReply());
    }

    private final void I9(QZoneCommentPanelResultBean commentResultBean) {
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(this.clickedComment.getHostComment());
        clickedComment.setReply(this.clickedComment.getStReply());
        clickedComment.setComment(this.clickedComment.getHostComment());
        ff.a aVar = ff.a.f398543a;
        Reply e16 = aVar.e(commentResultBean, clickedComment);
        GroupAlbumLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String groupId = x95.getGroupId();
        Intrinsics.checkNotNull(groupId);
        Reply b16 = aVar.b(e16, groupId);
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = this.mCommentViewModel;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            adVar = null;
        }
        adVar.Q1(K9, clickedComment.getComment(), b16, clickedComment.getReply());
    }

    private final void J9(QZoneCommentPanelResultBean commentResultBean) {
        if (this.clickedReply == null) {
            return;
        }
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        ClickedComment clickedComment = new ClickedComment();
        com.qzone.reborn.albumx.common.bean.g gVar = this.clickedReply;
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = null;
        clickedComment.setComment(gVar != null ? gVar.getHostComment() : null);
        com.qzone.reborn.albumx.common.bean.g gVar2 = this.clickedReply;
        clickedComment.setReply(gVar2 != null ? gVar2.getStReply() : null);
        ff.a aVar = ff.a.f398543a;
        Reply e16 = aVar.e(commentResultBean, clickedComment);
        GroupAlbumLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String groupId = x95.getGroupId();
        Intrinsics.checkNotNull(groupId);
        Reply b16 = aVar.b(e16, groupId);
        com.qzone.reborn.groupalbum.viewmodel.ad adVar2 = this.mCommentViewModel;
        if (adVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
        } else {
            adVar = adVar2;
        }
        adVar.Q1(K9, clickedComment.getComment(), b16, clickedComment.getReply());
    }

    private final com.qzone.reborn.albumx.common.bean.d K9() {
        String str;
        String str2;
        String str3;
        String str4;
        String uploadUid;
        com.qzone.reborn.albumx.common.bean.d dVar = new com.qzone.reborn.albumx.common.bean.d();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        dVar.n(x95 != null ? x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String() : false);
        GroupAlbumLayerExtraInfoBean x96 = x9();
        String str5 = "";
        if (x96 == null || (str = x96.getGroupId()) == null) {
            str = "";
        }
        dVar.k(str);
        GroupAlbumLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str2 = x97.getAlbumId()) == null) {
            str2 = "";
        }
        dVar.h(str2);
        GroupAlbumLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str3 = x98.getBatchId()) == null) {
            str3 = "";
        }
        dVar.i(str3);
        GroupAlbumLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str4 = x99.getLLoc()) == null) {
            str4 = "";
        }
        dVar.l(str4);
        GroupAlbumLayerExtraInfoBean x910 = x9();
        if (x910 != null && (uploadUid = x910.getUploadUid()) != null) {
            str5 = uploadUid;
        }
        dVar.m(str5);
        GroupAlbumLayerExtraInfoBean x911 = x9();
        dVar.j(x911 != null ? x911.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() : 0L);
        return dVar;
    }

    private final void L9(Comment clickComment) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        String str = clickComment.comment;
        Intrinsics.checkNotNullExpressionValue(str, "clickComment.comment");
        qZoneCommentPanelResultBean.C(str);
        String str2 = clickComment.commentid;
        Intrinsics.checkNotNullExpressionValue(str2, "clickComment.commentid");
        qZoneCommentPanelResultBean.A(str2);
        U9(qZoneCommentPanelResultBean);
    }

    private final void M9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        String str;
        if (P9(clickedInfo)) {
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

    private final void N9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        X9(clickedInfo);
    }

    private final void O9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        com.qzone.reborn.util.o.f59556a.c(R.string.jll, 2);
    }

    private final boolean P9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        return clickedInfo.getStReply() == null && clickedInfo.getHostComment() != null;
    }

    private final boolean Q9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        if (!Intrinsics.areEqual(x95 != null ? x95.getUploadUid() : null, LoginData.getInstance().getUinString())) {
            GroupAlbumLayerExtraInfoBean x96 = x9();
            if (!Intrinsics.areEqual(x96 != null ? x96.getUploadUid() : null, LoginData.getInstance().getUid())) {
                return false;
            }
        }
        return true;
    }

    private final boolean R9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        Reply stReply;
        User user;
        Reply stReply2;
        User user2;
        Comment hostComment;
        User user3;
        Comment hostComment2;
        User user4;
        String str = null;
        if (P9(clickedInfo)) {
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
    public static final void S9(p this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            this$0.M9(this$0.clickedComment);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            this$0.N9(this$0.clickedComment);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0w) {
            Comment hostComment = this$0.clickedComment.getHostComment();
            Intrinsics.checkNotNull(hostComment);
            this$0.L9(hostComment);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            this$0.O9(this$0.clickedComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(p this$0, com.qzone.reborn.albumx.common.bean.g data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            this$0.M9(data);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            this$0.N9(data);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            this$0.O9(data);
        }
    }

    private final void U9(QZoneCommentPanelResultBean commentResultBean) {
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        ff.a aVar = ff.a.f398543a;
        Comment c16 = aVar.c(commentResultBean);
        GroupAlbumLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String groupId = x95.getGroupId();
        Intrinsics.checkNotNull(groupId);
        Comment a16 = aVar.a(c16, groupId);
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = this.mCommentViewModel;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            adVar = null;
        }
        adVar.T1(K9, a16, commentResultBean.g());
    }

    private final boolean V9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        boolean z16;
        Comment hostComment = clickedInfo.getHostComment();
        if (!(hostComment != null && hostComment.isFake)) {
            Reply stReply = clickedInfo.getStReply();
            if (!(stReply != null && stReply.isFake)) {
                z16 = false;
                return (!R9(clickedInfo) || Q9()) && !z16;
            }
        }
        z16 = true;
        if (R9(clickedInfo)) {
        }
    }

    private final boolean W9(com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        return !R9(clickedInfo);
    }

    private final void X9(final com.qzone.reborn.albumx.common.bean.g clickedInfo) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u5220\u9664", 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.groupalbum.layer.part.o
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                p.Y9(p.this, clickedInfo, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        ef.d.f(actionSheet, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(p this$0, com.qzone.reborn.albumx.common.bean.g clickedInfo, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickedInfo, "$clickedInfo");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            if (this$0.P9(clickedInfo)) {
                this$0.G9(clickedInfo.getHostComment());
            } else {
                this$0.H9(clickedInfo);
            }
            actionSheet.dismiss();
        }
    }

    @Override // l9.g
    public void S1(com.qzone.reborn.albumx.common.bean.g data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedReply = data;
        if (R9(data)) {
            X9(data);
            return;
        }
        Reply stReply = data.getStReply();
        Intrinsics.checkNotNull(stReply);
        String nickname = stReply.user.nickName;
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(514);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().j(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), K9);
    }

    @Override // l9.g
    public void W3(View view, Comment data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedComment.d(data);
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        if (V9(this.clickedComment)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
        }
        cVar.a(R.id.n0w, HardCodeUtil.qqStr(R.string.rfg));
        if (W9(this.clickedComment)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
        }
        com.qzone.reborn.feedx.util.w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.groupalbum.layer.part.n
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                p.S9(p.this, view2);
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
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        ho.i.c().j(new QZoneCommentPanelParams.a().q(cd.c.j(false, null, 3, null)).y(512).getParams(), getActivity(), K9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null) {
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean");
        if (qZoneCommentPanelResultBean == null) {
            RFWLog.fatal("GroupAlbumLayerCommentPanelOperatePart", RFWLog.USR, new RuntimeException("commentResultBean is null"));
            return;
        }
        switch (requestCode) {
            case 512:
                U9(qZoneCommentPanelResultBean);
                return;
            case 513:
                I9(qZoneCommentPanelResultBean);
                return;
            case 514:
                J9(qZoneCommentPanelResultBean);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.ad.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumL\u2026entViewModel::class.java)");
        this.mCommentViewModel = (com.qzone.reborn.groupalbum.viewmodel.ad) viewModel;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = null;
        if (extras != null && extras.containsKey("key_feed_id")) {
            com.qzone.reborn.groupalbum.viewmodel.ad adVar2 = this.mCommentViewModel;
            if (adVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
                adVar2 = null;
            }
            String stringExtra = intent.getStringExtra("key_feed_id");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "it.getStringExtra(GroupA\u2026Launcher.KEY_FEED_ID)?:\"\"");
            }
            adVar2.j3(stringExtra);
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 != null && extras2.containsKey("key_is_detail_layer")) {
            com.qzone.reborn.groupalbum.viewmodel.ad adVar3 = this.mCommentViewModel;
            if (adVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentViewModel");
            } else {
                adVar = adVar3;
            }
            adVar.h3(intent.getBooleanExtra("key_is_detail_layer", false));
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
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(513);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().j(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), K9);
    }

    @Override // l9.g
    public void r1(View view, final com.qzone.reborn.albumx.common.bean.g data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        if (V9(data)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
        }
        if (W9(data)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
        }
        com.qzone.reborn.feedx.util.w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.groupalbum.layer.part.m
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                p.T9(p.this, data, view2);
            }
        });
    }

    @Override // l9.g
    public void v8(Comment data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.clickedComment.d(data);
        if (R9(this.clickedComment)) {
            X9(this.clickedComment);
            return;
        }
        String nickname = data.user.nickName;
        com.qzone.reborn.albumx.common.bean.d K9 = K9();
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(513);
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        ho.i.c().j(y16.q(cd.c.i(false, nickname)).getParams(), getActivity(), K9);
    }
}
