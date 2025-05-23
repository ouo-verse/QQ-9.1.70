package com.qzone.reborn.intimate.part.feed;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.util.w;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nk.ah;
import nk.ar;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J.\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010(\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010/\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\u0013H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0016J\u0012\u00103\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J$\u00104\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\u0013H\u0016J8\u0010:\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u00107\u001a\u0004\u0018\u0001062\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0014\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010=\u001a\u00020\u0016H\u0016R$\u0010D\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010K\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010L8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/h;", "Lcom/qzone/reborn/base/k;", "Lgf/a;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "", "S9", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "clickedComment", "", "Q9", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Z9", "E9", "R9", "Landroid/view/View;", "view", "clickComment", "", "dataPosInList", "X9", "", "itemName", "G9", "F9", "P9", "M9", "businessFeedData", "O9", "N9", "W9", "U9", "V9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onActivityResult", "T9", "Lcom/qzone/reborn/feedx/bean/b;", "dataInfo", "f6", "x1", "position", "z1", "Lcom/qzone/reborn/feedx/bean/c;", "commentBean", ICustomDataEditor.STRING_PARAM_6, ICustomDataEditor.STRING_ARRAY_PARAM_9, "c1", "v", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "H7", "feedId", "H9", "getDtPageId", "d", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "I9", "()Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "setMClickComment", "(Lcom/qzone/proxy/feedcomponent/model/ClickedComment;)V", "mClickComment", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "K9", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "setMFeedData", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", "mFeedData", "Lnk/ah;", "f", "Lnk/ah;", "J9", "()Lnk/ah;", "setMCommentViewModel", "(Lnk/ah;)V", "mCommentViewModel", tl.h.F, "I", "L9", "()I", "setMFeedPosition", "(I)V", "mFeedPosition", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class h extends com.qzone.reborn.base.k implements gf.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ClickedComment mClickComment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ah mCommentViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mFeedPosition = -1;

    private final void F9(String itemName, View view) {
        Map mutableMapOf;
        fo.c.l(view, getPartRootView());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName));
        fo.c.e("em_qz_long_press_comment_to_appear", getDtPageId(), view, mutableMapOf);
    }

    private final void G9(String itemName, View view) {
        Map mutableMapOf;
        fo.c.l(view, getPartRootView());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName));
        fo.c.g("em_qz_long_press_comment_to_appear", getDtPageId(), view, mutableMapOf);
    }

    private final void M9(BusinessFeedData feedData, ClickedComment clickComment) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        String text = clickComment.getText();
        Intrinsics.checkNotNullExpressionValue(text, "clickComment.text");
        qZoneCommentPanelResultBean.C(text);
        String str = feedData.getFeedCommInfo().feedsid;
        Intrinsics.checkNotNullExpressionValue(str, "feedData.feedCommInfo.feedsid");
        qZoneCommentPanelResultBean.A(str);
        S9(qZoneCommentPanelResultBean);
    }

    private final void N9(ClickedComment clickComment, View view) {
        clickComment.onCopy();
        F9("cop", view);
    }

    private final void O9(BusinessFeedData businessFeedData, ClickedComment clickComment, int dataPosInList, View view) {
        z1(businessFeedData, clickComment, dataPosInList);
        F9("del", view);
    }

    private final void P9(View view) {
        com.qzone.reborn.util.o.f59556a.c(R.string.jll, 2);
        F9("rep", view);
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

    private final void S9(QZoneCommentPanelResultBean commentResultBean) {
        BusinessFeedData H9 = H9(commentResultBean.getFeedId());
        if (H9 != null) {
            ff.a aVar = ff.a.f398543a;
            Comment c16 = aVar.c(commentResultBean);
            aVar.g(H9, c16);
            ah ahVar = this.mCommentViewModel;
            if (ahVar != null) {
                ahVar.P1(H9, c16);
            }
        }
    }

    private final boolean U9(ClickedComment clickComment) {
        return clickComment.isComment;
    }

    private final boolean V9(BusinessFeedData feedData, ClickedComment clickedComment) {
        return (ef.b.h(feedData) || R9(clickedComment)) && !feedData.isFakeFeed();
    }

    private final boolean W9(ClickedComment clickedComment) {
        return !R9(clickedComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(h this$0, ClickedComment clickedComment, BusinessFeedData businessFeedData, int i3, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n0y) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.N9(clickedComment, v3);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.n0z) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.O9(businessFeedData, clickedComment, i3, v3);
        } else if (valueOf != null && valueOf.intValue() == R.id.n0w) {
            this$0.M9(businessFeedData, clickedComment);
        } else if (valueOf != null && valueOf.intValue() == R.id.mil) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.P9(v3);
        }
    }

    private final void Z9(final BusinessFeedData feedData, final ClickedComment clickedComment) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u5220\u9664", 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.intimate.part.feed.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                h.aa(h.this, feedData, clickedComment, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        ef.d.f(actionSheet, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(h this$0, BusinessFeedData businessFeedData, ClickedComment clickedComment, ActionSheet actionSheet, View view, int i3) {
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
        this.mClickComment = clickedComment;
        X9(v3, this.mFeedData, clickedComment, dataPosInList);
    }

    public BusinessFeedData H9(String feedId) {
        ar arVar = (ar) getViewModel(ar.class);
        if (arVar != null) {
            return arVar.R1(feedId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I9, reason: from getter */
    public final ClickedComment getMClickComment() {
        return this.mClickComment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J9, reason: from getter */
    public final ah getMCommentViewModel() {
        return this.mCommentViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K9, reason: from getter */
    public final BusinessFeedData getMFeedData() {
        return this.mFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L9, reason: from getter */
    public final int getMFeedPosition() {
        return this.mFeedPosition;
    }

    public void T9(QZoneCommentPanelResultBean commentResultBean) {
        Intrinsics.checkNotNullParameter(commentResultBean, "commentResultBean");
        BusinessFeedData H9 = H9(commentResultBean.getFeedId());
        if (H9 != null) {
            ff.a aVar = ff.a.f398543a;
            Reply e16 = aVar.e(commentResultBean, this.mClickComment);
            aVar.h(H9, this.mClickComment, e16);
            ah ahVar = this.mCommentViewModel;
            if (ahVar != null) {
                ClickedComment clickedComment = this.mClickComment;
                ah.R1(ahVar, H9, clickedComment != null ? clickedComment.getComment() : null, e16, null, 8, null);
            }
        }
    }

    @Override // gf.a
    public void c1(BusinessFeedData feedData, ClickedComment clickedComment, int position) {
        CellFeedCommInfo feedCommInfo;
        this.mFeedData = feedData;
        this.mClickComment = clickedComment;
        this.mFeedPosition = position;
        String str = (feedData == null || (feedCommInfo = feedData.getFeedCommInfo()) == null) ? null : feedCommInfo.feedsid;
        if (str == null || str.length() == 0) {
            return;
        }
        if (R9(clickedComment)) {
            z1(feedData, clickedComment, position);
        } else {
            ho.i.c().k(cd.c.a(this.mFeedData).y(clickedComment == null ? 1207 : 1208).getParams(), getActivity(), this.mFeedData);
        }
    }

    public String getDtPageId() {
        return "pg_qz_intimate_space_home";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null || (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) == null) {
            return;
        }
        if (requestCode == 1207) {
            S9(qZoneCommentPanelResultBean);
        } else {
            if (requestCode != 1208) {
                return;
            }
            T9(qZoneCommentPanelResultBean);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.a.class);
        this.mCommentViewModel = (ah) getViewModel(ah.class);
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
        if (com.qzone.reborn.feedx.util.l.b("QZoneIntimateFeedCommentPartdoDeleteCommentSheet", 500L) || feedData == null || clickedComment == null) {
            return;
        }
        if (Q9(clickedComment)) {
            RFWLog.w("QZoneIntimateFeedCommentPart", RFWLog.USR, "fake comment or reply can not delete");
        } else {
            Z9(feedData, clickedComment);
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
            ah ahVar = this.mCommentViewModel;
            if (ahVar != null) {
                ahVar.S1(feedData, clickedComment.getComment());
                return;
            }
            return;
        }
        ah ahVar2 = this.mCommentViewModel;
        if (ahVar2 != null) {
            ahVar2.T1(feedData, clickedComment.getComment(), clickedComment.getReply());
        }
    }

    private final void X9(View view, final BusinessFeedData feedData, final ClickedComment clickComment, final int dataPosInList) {
        if (view == null || feedData == null || clickComment == null) {
            return;
        }
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        G9("cop", view);
        if (V9(feedData, clickComment)) {
            cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
            G9("del", view);
        }
        if (U9(clickComment)) {
            cVar.a(R.id.n0w, HardCodeUtil.qqStr(R.string.rfg));
        }
        if (W9(clickComment)) {
            cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
            G9("rep", view);
        }
        w.a().b(view, cVar, new w.c() { // from class: com.qzone.reborn.intimate.part.feed.g
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                h.Y9(h.this, clickComment, feedData, dataPosInList, view2);
            }
        });
    }

    @Override // gf.a
    public void a9(Intent intent) {
    }
}
