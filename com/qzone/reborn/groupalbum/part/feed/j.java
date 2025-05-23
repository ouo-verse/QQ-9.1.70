package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.util.w;
import com.qzone.reborn.groupalbum.event.GroupAlbumFeedExposureEvent;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumCommentViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\nJ\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010#\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016J$\u0010'\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020\fH\u0016J8\u0010.\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\fH\u0016J\u0014\u00101\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020/H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0002J\u0010\u00107\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001c\u00108\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u00109\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010:\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J.\u0010=\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010<\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020\fH\u0002J\"\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u0019H\u0002J\"\u0010@\u001a\u00020\u00052\u0006\u0010>\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0019H\u0002J \u0010B\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u001eH\u0002J(\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0003H\u0002J \u0010E\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010G\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u001eH\u0002J\u0018\u0010H\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010I\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H\u0002R\u0018\u0010L\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/j;", "Lcom/qzone/reborn/base/k;", "Lgf/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/content/Intent;", "intent", ICustomDataEditor.STRING_ARRAY_PARAM_9, "", "S9", "", "K9", "P9", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "outState", "onPartSaveInstanceState", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "J9", "Lcom/qzone/reborn/feedx/bean/b;", "dataInfo", "f6", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "clickedComment", "x1", "feedData", "position", "z1", "Lcom/qzone/reborn/feedx/bean/c;", "commentBean", ICustomDataEditor.STRING_PARAM_6, "c1", "v", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "dataPosInList", "H7", "", "feedId", "I9", "getDtPageId", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "T9", "U9", "Q9", "aa", "E9", "R9", "view", "clickComment", "Y9", "itemName", "G9", "F9", "O9", "L9", "businessFeedData", "N9", "M9", "X9", "V9", "W9", "H9", "d", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "mClickComment", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel;", "f", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumCommentViewModel;", "mCommentViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class j extends com.qzone.reborn.base.k implements gf.a {

    /* renamed from: i, reason: collision with root package name */
    private static BusinessFeedData f56768i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ClickedComment mClickComment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumCommentViewModel mCommentViewModel;

    private final void F9(String itemName, View view, BusinessFeedData feedData) {
        Map mutableMapOf;
        CellUserInfo cellUserInfo;
        User user;
        fo.c.l(view, getPartRootView());
        String a16 = ef.b.a(feedData);
        if (a16 == null) {
            a16 = "";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName), TuplesKt.to("feedid", a16), TuplesKt.to("framer_uin", Long.valueOf((feedData == null || (cellUserInfo = feedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? 0L : user.uin)));
        fo.c.e("em_qz_long_press_comment_to_appear", getDtPageId(), view, mutableMapOf);
    }

    private final void G9(String itemName, View view, BusinessFeedData feedData) {
        Map mutableMapOf;
        CellUserInfo cellUserInfo;
        User user;
        fo.c.l(view, getPartRootView());
        String a16 = ef.b.a(feedData);
        if (a16 == null) {
            a16 = "";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName), TuplesKt.to("feedid", a16), TuplesKt.to("framer_uin", Long.valueOf((feedData == null || (cellUserInfo = feedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? 0L : user.uin)));
        fo.c.g("em_qz_long_press_comment_to_appear", getDtPageId(), view, mutableMapOf);
    }

    private final void H9(String feedId) {
        BusinessFeedData I9 = I9(feedId);
        if (I9 == null || !Intrinsics.areEqual(getDtPageId(), "pg_qz_group_dynamic_tab")) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(I9);
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumFeedExposureEvent(2, arrayList));
    }

    private final void L9(View view, BusinessFeedData feedData, ClickedComment clickComment) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        String text = clickComment.getText();
        Intrinsics.checkNotNullExpressionValue(text, "clickComment.text");
        qZoneCommentPanelResultBean.C(text);
        String str = feedData.getFeedCommInfo().feedsid;
        Intrinsics.checkNotNullExpressionValue(str, "feedData.feedCommInfo.feedsid");
        qZoneCommentPanelResultBean.A(str);
        T9(qZoneCommentPanelResultBean);
        F9("plo", view, feedData);
    }

    private final void M9(ClickedComment clickComment, View view, BusinessFeedData feedData) {
        clickComment.onCopy();
        F9("cop", view, feedData);
    }

    private final void N9(BusinessFeedData businessFeedData, ClickedComment clickComment, int dataPosInList, View view) {
        z1(businessFeedData, clickComment, dataPosInList);
        F9("del", view, businessFeedData);
    }

    private final void O9(View view, BusinessFeedData feedData) {
        com.qzone.reborn.util.o.f59556a.c(R.string.jll, 2);
        F9("rep", view, feedData);
    }

    private final boolean Q9(ClickedComment clickedComment) {
        if (clickedComment.getReply() != null) {
            return clickedComment.getReply().isFake;
        }
        if (clickedComment.getComment() != null) {
            return clickedComment.getComment().isFake;
        }
        return false;
    }

    private final void T9(QZoneCommentPanelResultBean commentResultBean) {
        BusinessFeedData I9 = I9(commentResultBean.getFeedId());
        if (I9 != null) {
            ff.a aVar = ff.a.f398543a;
            Comment c16 = aVar.c(commentResultBean);
            CellGroupAlbumInfo cellGroupAlbumInfo = I9.cellGroupAlbumInfo;
            Intrinsics.checkNotNull(cellGroupAlbumInfo);
            String str = cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNullExpressionValue(str, "businessFeedData.cellGroupAlbumInfo!!.groupId");
            Comment a16 = aVar.a(c16, str);
            aVar.g(I9, a16);
            GroupAlbumCommentViewModel groupAlbumCommentViewModel = this.mCommentViewModel;
            if (groupAlbumCommentViewModel != null) {
                groupAlbumCommentViewModel.R1(I9, a16, commentResultBean.g(), K9() == ki.j.INSTANCE.a());
            }
        }
    }

    private final void U9(QZoneCommentPanelResultBean commentResultBean) {
        BusinessFeedData I9 = I9(commentResultBean.getFeedId());
        if (I9 != null) {
            ClickedComment clickedComment = this.mClickComment;
            ff.a aVar = ff.a.f398543a;
            Reply e16 = aVar.e(commentResultBean, clickedComment);
            String str = I9.cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNullExpressionValue(str, "businessFeedData.cellGroupAlbumInfo.groupId");
            Reply b16 = aVar.b(e16, str);
            aVar.h(I9, clickedComment, b16);
            GroupAlbumCommentViewModel groupAlbumCommentViewModel = this.mCommentViewModel;
            if (groupAlbumCommentViewModel != null) {
                groupAlbumCommentViewModel.S1(I9, clickedComment != null ? clickedComment.getComment() : null, b16, P9());
            }
        }
    }

    private final boolean V9(ClickedComment clickComment) {
        return clickComment.isComment;
    }

    private final boolean W9(BusinessFeedData feedData, ClickedComment clickedComment) {
        return (ef.b.h(feedData) || R9(clickedComment)) && !feedData.isFakeFeed();
    }

    private final boolean X9(ClickedComment clickedComment) {
        return !R9(clickedComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(j this$0, ClickedComment clickedComment, BusinessFeedData businessFeedData, int i3, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.M9(clickedComment, v3, businessFeedData);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.N9(businessFeedData, clickedComment, i3, v3);
        } else if (valueOf != null && valueOf.intValue() == R.id.n0w) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.L9(v3, businessFeedData, clickedComment);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.O9(v3, businessFeedData);
        }
    }

    private final void aa(final BusinessFeedData feedData, final ClickedComment clickedComment) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u5220\u9664", 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                j.ba(j.this, feedData, clickedComment, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        ef.d.f(actionSheet, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(j this$0, BusinessFeedData businessFeedData, ClickedComment clickedComment, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            this$0.E9(businessFeedData, clickedComment);
            actionSheet.dismiss();
        }
    }

    @Override // gf.a
    public void H7(View v3, BusinessFeedData feedData, Comment comment, Reply reply, int dataPosInList) {
        this.mFeedData = feedData;
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(comment);
        clickedComment.setReply(reply);
        clickedComment.isComment = reply == null;
        x1(clickedComment);
        Y9(v3, this.mFeedData, this.mClickComment, dataPosInList);
    }

    public BusinessFeedData I9(String feedId) {
        com.qzone.reborn.groupalbum.viewmodel.z zVar = (com.qzone.reborn.groupalbum.viewmodel.z) getViewModel(com.qzone.reborn.groupalbum.viewmodel.z.class);
        if (zVar != null) {
            return zVar.b2(feedId);
        }
        return null;
    }

    public final BusinessFeedData J9() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return businessFeedData == null ? f56768i : businessFeedData;
    }

    public int K9() {
        return ki.j.INSTANCE.a();
    }

    public final boolean P9() {
        return K9() == ki.j.INSTANCE.a();
    }

    public boolean S9() {
        return false;
    }

    @Override // gf.a
    public void c1(BusinessFeedData feedData, ClickedComment clickedComment, int position) {
        String str;
        CellFeedCommInfo feedCommInfo;
        this.mFeedData = feedData;
        x1(clickedComment);
        BusinessFeedData businessFeedData = this.mFeedData;
        String str2 = (businessFeedData == null || (feedCommInfo = businessFeedData.getFeedCommInfo()) == null) ? null : feedCommInfo.feedsid;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if (R9(clickedComment)) {
            z1(feedData, clickedComment, position);
            return;
        }
        int i3 = clickedComment == null ? 1207 : 1208;
        if (clickedComment == null) {
            ho.i.c().i(cd.c.a(this.mFeedData).q(cd.c.j(false, null, 3, null)).y(i3).getParams(), getActivity(), this.mFeedData);
            return;
        }
        if (clickedComment.getReply() != null) {
            str = clickedComment.getReply().user.nickName;
            Intrinsics.checkNotNullExpressionValue(str, "clickedComment.reply.user.nickName");
        } else {
            str = clickedComment.getComment().user.nickName;
            Intrinsics.checkNotNullExpressionValue(str, "clickedComment.comment.user.nickName");
        }
        ho.i.c().i(cd.c.a(this.mFeedData).q(cd.c.i(false, str)).y(i3).getParams(), getActivity(), this.mFeedData);
    }

    public String getDtPageId() {
        return "pg_qz_group_dynamic_tab";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null) {
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean");
        if (qZoneCommentPanelResultBean == null) {
            RFWLog.fatal("GroupAlbumFeedCommentPart", RFWLog.USR, new RuntimeException("commentResultBean is null"));
            return;
        }
        if (requestCode == 1207) {
            T9(qZoneCommentPanelResultBean);
        } else if (requestCode == 1208) {
            U9(qZoneCommentPanelResultBean);
        }
        f56768i = null;
        H9(qZoneCommentPanelResultBean.getFeedId());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.a.class);
        GroupAlbumCommentViewModel groupAlbumCommentViewModel = (GroupAlbumCommentViewModel) getViewModel(GroupAlbumCommentViewModel.class);
        this.mCommentViewModel = groupAlbumCommentViewModel;
        if (groupAlbumCommentViewModel != null) {
            groupAlbumCommentViewModel.a2(S9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        ClickedComment clickedComment;
        super.onPartCreate(activity, savedInstanceState);
        if (savedInstanceState == null || (clickedComment = (ClickedComment) ParcelableWrapper.getDataFromBudle(savedInstanceState, "save_click_comment")) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(clickedComment, "getDataFromBudle<Clicked\u2026tate, SAVE_CLICK_COMMENT)");
        this.mClickComment = clickedComment;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle outState) {
        super.onPartSaveInstanceState(activity, outState);
        ClickedComment clickedComment = this.mClickComment;
        if (clickedComment != null) {
            ParcelableWrapper.putDataToBundle(outState, "save_click_comment", clickedComment);
        }
        f56768i = this.mFeedData;
    }

    @Override // gf.a
    public void s6(com.qzone.reborn.feedx.bean.c commentBean) {
        Intrinsics.checkNotNullParameter(commentBean, "commentBean");
    }

    @Override // gf.a
    public void x1(ClickedComment clickedComment) {
        this.mClickComment = clickedComment;
    }

    @Override // gf.a
    public void z1(BusinessFeedData feedData, ClickedComment clickedComment, int position) {
        if (com.qzone.reborn.feedx.util.l.b("GroupAlbumFeedCommentPartdoDeleteCommentSheet", 500L) || feedData == null || clickedComment == null) {
            return;
        }
        if (Q9(clickedComment)) {
            RFWLog.w("GroupAlbumFeedCommentPart", RFWLog.USR, "fake comment or reply can not delete");
        } else {
            aa(feedData, clickedComment);
        }
    }

    @Override // gf.a
    public void f6(com.qzone.reborn.feedx.bean.b dataInfo) {
        if (dataInfo == null) {
            return;
        }
        this.mFeedData = dataInfo.f54743d;
    }

    private final boolean R9(ClickedComment clickedComment) {
        User user;
        User user2;
        if (clickedComment == null) {
            return false;
        }
        Long l3 = null;
        if (clickedComment.getReply() != null) {
            Reply reply = clickedComment.getReply();
            if (reply != null && (user2 = reply.user) != null) {
                l3 = Long.valueOf(user2.uin);
            }
        } else {
            Comment comment = clickedComment.getComment();
            if (comment != null && (user = comment.user) != null) {
                l3 = Long.valueOf(user.uin);
            }
        }
        return l3 != null && l3.longValue() == LoginData.getInstance().getUin();
    }

    private final void E9(BusinessFeedData feedData, ClickedComment clickedComment) {
        if (feedData == null || clickedComment == null) {
            return;
        }
        if (clickedComment.isComment) {
            GroupAlbumCommentViewModel groupAlbumCommentViewModel = this.mCommentViewModel;
            if (groupAlbumCommentViewModel != null) {
                groupAlbumCommentViewModel.T1(feedData, clickedComment.getComment(), P9());
            }
        } else {
            GroupAlbumCommentViewModel groupAlbumCommentViewModel2 = this.mCommentViewModel;
            if (groupAlbumCommentViewModel2 != null) {
                groupAlbumCommentViewModel2.U1(feedData, clickedComment.getComment(), clickedComment.getReply(), P9());
            }
        }
        String a16 = ef.b.a(feedData);
        Intrinsics.checkNotNull(a16);
        H9(a16);
    }

    private final void Y9(View view, final BusinessFeedData feedData, final ClickedComment clickComment, final int dataPosInList) {
        if (view == null || feedData == null || clickComment == null) {
            return;
        }
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        G9("cop", view, feedData);
        if (W9(feedData, clickComment)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
            G9("del", view, feedData);
        }
        if (V9(clickComment)) {
            cVar.a(R.id.n0w, HardCodeUtil.qqStr(R.string.rfg));
            G9("plo", view, feedData);
        }
        if (X9(clickComment)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
            G9("rep", view, feedData);
        }
        com.qzone.reborn.feedx.util.w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.groupalbum.part.feed.i
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                j.Z9(j.this, clickComment, feedData, dataPosInList, view2);
            }
        });
    }

    @Override // gf.a
    public void a9(Intent intent) {
    }
}
