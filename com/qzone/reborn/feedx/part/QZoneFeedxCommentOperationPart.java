package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.presenter.springfestival.QZoneDragonAnimEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.IActivityLauncherProxy;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes37.dex */
public class QZoneFeedxCommentOperationPart extends g implements gf.a {
    private BusinessFeedData C;
    private com.qzone.reborn.feedx.util.i D;
    private xg.b E;
    private xg.c F;

    /* renamed from: d, reason: collision with root package name */
    private tc.b f54880d;

    /* renamed from: e, reason: collision with root package name */
    private int f54881e;

    /* renamed from: f, reason: collision with root package name */
    private ClickedComment f54882f;

    /* renamed from: h, reason: collision with root package name */
    private ActionSheet f54883h;

    /* renamed from: i, reason: collision with root package name */
    private int f54884i;

    /* renamed from: m, reason: collision with root package name */
    private int f54885m;

    /* loaded from: classes37.dex */
    class b implements IActivityLauncherProxy {
        b() {
        }

        @Override // cooperation.qzone.api.IActivityLauncherProxy
        public void startActivityForResult(Intent intent, int i3) {
            QZoneFeedxCommentOperationPart.this.B9(intent, i3);
        }
    }

    private Map<String, String> I9(QZoneCommentPanelResultBean qZoneCommentPanelResultBean, boolean z16) {
        Map<String, String> a16 = qZoneCommentPanelResultBean.a();
        if (z16) {
            String g16 = com.qzone.reborn.feedx.util.aa.g(this.C);
            if (!TextUtils.isEmpty(g16)) {
                a16.put("hittext", g16);
            }
            BusinessFeedData businessFeedData = this.C;
            if (businessFeedData != null && businessFeedData.getFeedCommInfoV2() != null) {
                a16.put("tid_create_time", (this.C.getFeedCommInfoV2().time / 1000) + "");
            }
            BusinessFeedData businessFeedData2 = this.C;
            if (businessFeedData2 != null && businessFeedData2.getCommentInfo() != null && !this.C.getCommentInfo().hasComments()) {
                a16.put("no_cmt_list", "1");
            }
        }
        QLog.i("QZoneFeedxCommentOperationPart", 1, "doneComment  feedData = " + this.C);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9() {
        com.qzone.util.ap.f59791b.e(this.f54884i, 27, this.f54881e, this.C);
    }

    public void G9(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
        String str = businessFeedData.getFeedCommInfo().ugckey;
        int i16 = businessFeedData.getFeedCommInfo().appid;
        String str2 = businessFeedData.getIdInfo().cellId;
        long j3 = businessFeedData.getUser().uin;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<Integer, String> map2 = map;
        if (clickedComment.getReply() != null) {
            QZoneWriteOperationService.v0().c0(0, getMainHandler(), str, i16, j3, str2, clickedComment.getComment().user.uin, clickedComment.getComment().commentid, 0, clickedComment.getReply().user.uin, clickedComment.getReply().replyId, map2, clickedComment.getReply().isFake, i3);
        } else {
            QZoneWriteOperationService.v0().S(0, getMainHandler(), str, i16, j3, str2, clickedComment.getComment().user.uin, clickedComment.getComment().commentid, 0, map2, clickedComment.getComment().isFake, 0, i3);
        }
    }

    @Override // gf.a
    public void H7(View view, BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3) {
        if (this.F == null) {
            xg.c cVar = new xg.c(getActivity());
            this.F = cVar;
            cVar.o(this);
        }
        this.F.m(view, businessFeedData, comment, reply, i3);
    }

    protected String J9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar == null) {
            return "";
        }
        return fo.c.h(kVar.getPageType());
    }

    public BusinessFeedData K9(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f54880d == null) {
            this.f54880d = C9();
        }
        List<BusinessFeedData> data = this.f54880d.T1().getValue() != null ? this.f54880d.T1().getValue().getData() : null;
        if (data == null) {
            return null;
        }
        for (BusinessFeedData businessFeedData : data) {
            if (businessFeedData.getFeedCommInfo() != null && TextUtils.equals(str, businessFeedData.getFeedCommInfo().feedskey)) {
                return businessFeedData;
            }
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
        return null;
    }

    @Override // gf.a
    public void a9(Intent intent) {
        if (intent == null) {
            QLog.e("QZoneFeedxCommentOperationPart", 1, "[getDoneCommentBeanNew] data is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QZoneFeedxCommentOperationPart", 1, "[getDoneCommentBeanNew] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent()) && com.tencent.mobileqq.utils.bl.b(qZoneCommentPanelResultBean.g())) {
            QLog.e("QZoneFeedxCommentOperationPart", 1, "doneComment  commentText and pic is null");
            return;
        }
        s6(new com.qzone.reborn.feedx.bean.c().o(qZoneCommentPanelResultBean.getInputContent()).r(this.f54881e).v("").m(qZoneCommentPanelResultBean.getCacheUniKey()).s(qZoneCommentPanelResultBean.getIsCheckedPrivateIcon()).q(qZoneCommentPanelResultBean.g()).l(qZoneCommentPanelResultBean.getCacheFeedsKey()).t(qZoneCommentPanelResultBean.getIsEmoRapidComment()).u(qZoneCommentPanelResultBean.getRapidCommentInfo()).p(I9(qZoneCommentPanelResultBean, true)));
        if (this.f54884i != 0) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.q
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxCommentOperationPart.this.N9();
                }
            }, 200L);
        }
    }

    @Override // gf.a
    public void c1(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
        if (this.E == null) {
            xg.b bVar = new xg.b(getHostFragment(), new b());
            this.E = bVar;
            bVar.d(this);
            this.E.e(J9());
        }
        this.E.f(this.f54885m);
        this.E.a(businessFeedData, clickedComment, i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxCommentOperationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 != -1) {
            return;
        }
        if (i3 == 1207) {
            a9(intent);
        } else if (i3 == 1208) {
            H9(intent);
        }
        O9();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        int i3 = message.what;
        if (i3 == 999905 || i3 == 999907) {
            L9(unpack);
        } else {
            if (i3 != 999978) {
                return;
            }
            M9(unpack);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = new com.qzone.reborn.feedx.util.i(view);
        registerIoc(this, gf.a.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        QZLog.d(getTAG(), 1, "[onPartCreate] hashCode=" + hashCode());
        xm.a.f448133d.m();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.qzone.reborn.feedx.util.i iVar = this.D;
        if (iVar != null) {
            iVar.h();
        }
    }

    @Override // gf.a
    public void x1(ClickedComment clickedComment) {
        this.f54882f = clickedComment;
    }

    @Override // gf.a
    public void z1(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxCommentOperationPartdoDeleteCommentSheet", 500L)) {
            return;
        }
        a aVar = new a(businessFeedData, clickedComment, i3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(getActivity(), R.string.gda), 0, 0, 2));
        com.qzone.widget.o a16 = com.qzone.widget.p.a(getActivity(), arrayList, aVar);
        this.f54883h = a16;
        a16.addCancelButton(R.string.cancel);
        ActionSheetHelper.showActionSheet(getActivity(), this.f54883h);
    }

    private void O9() {
        this.f54881e = 0;
        this.f54882f = null;
    }

    /* loaded from: classes37.dex */
    class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f54887d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ClickedComment f54888e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f54889f;

        a(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
            this.f54887d = businessFeedData;
            this.f54888e = clickedComment;
            this.f54889f = i3;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                QZoneFeedxCommentOperationPart.this.G9(this.f54887d, this.f54888e, this.f54889f);
                if (QZoneFeedxCommentOperationPart.this.f54883h != null) {
                    QZoneFeedxCommentOperationPart.this.f54883h.dismiss();
                }
            }
            ActionSheetHelper.dismissActionSheet(QZoneFeedxCommentOperationPart.this.getActivity(), QZoneFeedxCommentOperationPart.this.f54883h);
        }
    }

    private void L9(final QZoneResult qZoneResult) {
        if (qZoneResult != null && !qZoneResult.getSucceed()) {
            c6.a.i(qZoneResult.getMessage());
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneFeedxCommentOperationPart.this.D != null) {
                        QZoneFeedxCommentOperationPart.this.D.e(qZoneResult);
                    }
                }
            });
        }
    }

    private void M9(QZoneResult qZoneResult) {
        if (qZoneResult == null || qZoneResult.getSucceed()) {
            return;
        }
        c6.a.i(qZoneResult.getMessage());
    }

    private void H9(Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QZoneFeedxCommentOperationPart", 1, "[getDoneReplyBeanNew] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent())) {
            QLog.e("QZoneFeedxCommentOperationPart", 1, "doneReply  commentText == null");
        } else {
            s6(new com.qzone.reborn.feedx.bean.c().o(qZoneCommentPanelResultBean.getInputContent()).r(this.f54881e).n(this.f54882f).v("").m(qZoneCommentPanelResultBean.getCacheUniKey()).s(qZoneCommentPanelResultBean.getIsCheckedPrivateIcon()).l(qZoneCommentPanelResultBean.getCacheFeedsKey()).t(false).p(I9(qZoneCommentPanelResultBean, false)));
        }
    }

    @Override // gf.a
    public void f6(com.qzone.reborn.feedx.bean.b bVar) {
        if (bVar == null) {
            return;
        }
        this.C = bVar.f54743d;
        this.f54881e = bVar.f54740a;
        this.f54884i = bVar.f54741b;
        this.f54885m = bVar.f54742c;
    }

    @Override // gf.a
    public void s6(com.qzone.reborn.feedx.bean.c cVar) {
        BusinessFeedData K9;
        User user;
        if (cVar == null || (K9 = K9(cVar.a())) == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZoneDragonAnimEvent(ef.b.a(this.C), false, getActivity()));
        MiscReportUtils.l(K9, false);
        Map<Integer, String> map = K9.getOperationInfo().busiParam;
        if (cVar.c() != null) {
            if (TextUtils.isEmpty(cVar.c().getComment().commentid)) {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastServerBusy", "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5"));
                return;
            }
            if (cVar.c().getReply() != null) {
                user = cVar.c().getReply().user;
            } else {
                user = cVar.c().getComment().user;
            }
            if (K9.getFeedCommInfo().appid == 334 && K9.getUser().uin != LoginData.getInstance().getUin() && user.uin != LoginData.getInstance().getUin()) {
                QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
                lVar.f45712e = K9.getFeedCommInfo().appid;
                lVar.f45718k = map;
                lVar.f45715h = com.qzone.util.u.a(user.uin, user.nickName) + cVar.d();
                lVar.f45716i = cVar.b();
                lVar.f45709b = K9.getFeedCommInfo().feedskey;
                lVar.f45710c = UUID.randomUUID().toString();
                lVar.f45711d = K9.getFeedCommInfo().clientkey;
                lVar.f45725r = cVar.j();
                lVar.f45724q = K9.getFeedCommInfo().isTodayInHistoryFeed();
                lVar.f45713f = K9.getUser().uin;
                lVar.f45719l = cVar.i();
                lVar.f45714g = K9.getIdInfo().cellId;
                lVar.f45708a = K9.getFeedCommInfo().ugckey;
                lVar.f45727t = 0;
                QZoneWriteOperationService.v0().Q(getMainHandler(), lVar);
                return;
            }
            QZoneWriteOperationService.v0().b2(0, getMainHandler(), K9.getFeedCommInfo().ugckey, K9.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), K9.getFeedCommInfo().appid, K9.getUser().uin, cVar.c().getComment().user.uin, user, K9.getIdInfo().cellId, "", cVar.c().getComment().commentid, com.qzone.util.u.a(user.uin, user.nickName) + cVar.d(), cVar.d(), cVar.b(), 0, map, cVar.i(), K9.getFeedCommInfo().isTodayInHistoryFeed(), cVar.g(), 0, cVar.e());
            return;
        }
        QZoneWriteOperationService.l lVar2 = new QZoneWriteOperationService.l();
        lVar2.f45712e = K9.getFeedCommInfo().appid;
        lVar2.f45718k = map;
        lVar2.f45715h = cVar.d();
        lVar2.f45716i = cVar.b();
        lVar2.f45710c = UUID.randomUUID().toString();
        lVar2.f45709b = K9.getFeedCommInfo().feedskey;
        lVar2.f45711d = K9.getFeedCommInfo().clientkey;
        lVar2.f45725r = cVar.j();
        lVar2.f45724q = K9.getFeedCommInfo().isTodayInHistoryFeed();
        lVar2.f45717j = 0;
        lVar2.f45713f = K9.getUser().uin;
        lVar2.f45723p = 0;
        lVar2.f45719l = cVar.i();
        lVar2.f45722o = null;
        lVar2.f45714g = K9.getIdInfo().cellId;
        lVar2.f45721n = 1;
        lVar2.f45708a = K9.getFeedCommInfo().ugckey;
        lVar2.f45726s = cVar.f();
        lVar2.f45730w = cVar.e();
        lVar2.f45731x = K9.isSubFeed;
        lVar2.f45732y = K9;
        lVar2.f45733z = K9.feedType;
        if (!cVar.k()) {
            QZoneWriteOperationService.v0().Q(getMainHandler(), lVar2);
        } else {
            QZoneWriteOperationService.v0().X1(getMainHandler(), lVar2, cVar.h());
        }
    }
}
