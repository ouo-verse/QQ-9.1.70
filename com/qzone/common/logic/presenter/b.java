package com.qzone.common.logic.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFunnyTreadSpace;
import com.qzone.proxy.feedcomponent.model.CellGiftInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.util.u;
import com.qzone.widget.EmoEditPanel;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.mobileqq.R;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends BaseFeedPresenter {

    /* renamed from: e0, reason: collision with root package name */
    private int f46111e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f46112f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46113d;

        a(BusinessFeedData businessFeedData) {
            this.f46113d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!NetworkState.isNetSupport()) {
                ToastUtil.n(R.string.ghi);
            } else {
                QZoneFeedUtil.Y(this.f46113d, b.this.E(), null, 29);
            }
        }
    }

    public b(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        super(qZoneBaseFeedFragment);
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    public void H0(BusinessFeedData businessFeedData, int i3, int i16) {
        CellFunnyTreadSpace cellFunnyTreadSpace;
        List<String> list;
        BaseFeedClickProcessor baseFeedClickProcessor;
        if (i3 == 0) {
            if (businessFeedData != null && businessFeedData.isSecretFeed()) {
                LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064("303", "7", "9", "secret");
                lpReportInfo_pf00064.info = businessFeedData.getFeedCommInfo().feedskey + "_" + businessFeedData.getFeedCommInfo().getTime();
                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, true);
            }
            if (businessFeedData != null && (cellFunnyTreadSpace = businessFeedData.cellFunnyTreadSpace) != null && (list = cellFunnyTreadSpace.actions) != null && list.size() > 0 && (baseFeedClickProcessor = this.f46088h) != null) {
                baseFeedClickProcessor.m0(businessFeedData.getUser(), businessFeedData.cellFunnyTreadSpace);
            } else {
                e1(businessFeedData);
            }
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && d.j(businessFeedData.getFeedCommInfo().operatemask2, 11)) {
                LpReportInfo_pf00064.allReport(303, 12, 2);
            }
            ap.f59791b.e(77, 1, 0, businessFeedData);
            return;
        }
        if (i3 == 5) {
            View view = this.f46112f0;
            if (view != null) {
                view.setTag(null);
            }
            C().J0(this.f46111e0, this.f46112f0, null, false, false, 78);
            EmoEditPanel.D1 = new EmoEditPanel.al(78, businessFeedData, 0);
            ap.f59791b.e(78, 1, 0, businessFeedData);
            return;
        }
        if (i3 == 8) {
            C().l0(businessFeedData);
            return;
        }
        if (i3 != 10) {
            if (i3 != 25) {
                return;
            }
            int G = u5.b.G("highFiveNotifyStatus", -1);
            w5.b.a(BaseFeedPresenter.f46084d0, 1, "High Five passive button, status = " + G);
            if (G == 0) {
                QZoneWriteOperationService.v0().P(E(), 1L);
                return;
            } else {
                if (G == 1) {
                    QZoneWriteOperationService.v0().P(E(), 0L);
                    return;
                }
                return;
            }
        }
        ap.f59791b.e(79, 1, 0, businessFeedData);
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        if (businessFeedData == null) {
            return;
        }
        r0(businessFeedData);
        if (businessFeedData.isSecretFeed()) {
            LpReportInfo_pf00064 lpReportInfo_pf000642 = new LpReportInfo_pf00064("303", "7", "11", "secret");
            lpReportInfo_pf000642.info = businessFeedData.getFeedCommInfo().feedskey + "_" + businessFeedData.getFeedCommInfo().getTime();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000642, false, false);
        }
    }

    public void c1(BusinessFeedData businessFeedData, int i3) {
        this.I.rb(businessFeedData, i3);
    }

    boolean d1() {
        return false;
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    protected BaseFeedClickProcessor l() {
        return new com.qzone.common.logic.clickprocessor.a(this, this.I);
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    public void r0(BusinessFeedData businessFeedData) {
        this.I.Gc("\u5220\u9664\u63d0\u793a", "\u4ec5\u5220\u9664\u8be5\u6d88\u606f\uff0c\u4e0d\u5220\u9664\u539f\u6587\u548c\u8bc4\u8bba", new a(businessFeedData));
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    public void o0(BusinessFeedData businessFeedData, int i3, boolean z16, Object... objArr) {
        User userV2;
        if (businessFeedData == null) {
            QZLog.e(BaseFeedPresenter.f46084d0, "itemClick BusinessFeedData data=null ,pos=" + i3 + ",bPressedBlankArea=" + z16 + ",args:" + objArr);
            return;
        }
        this.f46111e0 = i3;
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        if (cellSummaryV2 != null && cellSummaryV2.summary != null) {
            CellUserInfo cellUserInfo = businessFeedData.getCellUserInfo();
            TextCellLayout.setClickSummary(cellSummaryV2.summary, (cellUserInfo == null || (userV2 = cellUserInfo.getUserV2()) == null) ? 0L : userV2.uin);
        }
        QZonePullToRefreshListView Q = Q();
        if (Q == null) {
            return;
        }
        this.f46112f0 = Q.getChildAt(i3);
        if (businessFeedData.getLocalInfo().isFake()) {
            return;
        }
        if (z16) {
            j0(businessFeedData, 0, z16);
        } else if (businessFeedData.getFeedCommInfo().actiontype != 6) {
            if (businessFeedData.getFeedCommInfo().actiontype == 20) {
                o(businessFeedData, i3, BaseFeedPresenter.T, new Object[0]);
            } else {
                j0(businessFeedData, 0, z16);
            }
        }
    }

    private void e1(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().actiontype == 20) {
            o(businessFeedData, this.f46111e0, BaseFeedPresenter.T, new Object[0]);
            return;
        }
        CellGiftInfo giftInfo = businessFeedData.getGiftInfo();
        if (giftInfo != null) {
            String str = giftInfo.giftType;
            if (str == null) {
                CellGiftInfo giftInfo2 = businessFeedData.getOriginalInfoSafe().getGiftInfo();
                if (giftInfo2 != null && !TextUtils.isEmpty(giftInfo2.giftType)) {
                    businessFeedData.getFeedCommInfo().actiontype = 1;
                }
            } else if (!TextUtils.isEmpty(str)) {
                businessFeedData.getFeedCommInfo().actiontype = 0;
            }
        }
        this.I.e4(businessFeedData, 1, 0L);
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    public void v(String str, int i3, ClickedComment clickedComment, String str2, String str3, boolean z16, boolean z17, RapidCommentExpressionInfo rapidCommentExpressionInfo, ArrayList<String> arrayList, String str4, Map<String, String> map) {
        BusinessFeedData businessFeedData = (BusinessFeedData) F(i3, true);
        if (businessFeedData != null) {
            f1(str, businessFeedData, i3, true, clickedComment, str3, z16, str4, map);
        }
    }

    @Override // com.qzone.common.logic.presenter.BaseFeedPresenter
    public void j0(BusinessFeedData businessFeedData, int i3, boolean z16) {
        if (businessFeedData == null) {
            QZLog.e(BaseFeedPresenter.f46084d0, String.format("invokeItemClick feedData=null,from=%d,bPressedBlankArea=%b", Integer.valueOf(i3), Boolean.valueOf(z16)));
            return;
        }
        if (businessFeedData.getFeedCommInfo().actiontype == 30) {
            if (businessFeedData.getOperationInfoV2() == null || businessFeedData.getOperationInfoV2().busiParam == null) {
                return;
            }
            String str = businessFeedData.getOperationInfoV2().busiParam.get(75);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ToastUtil.s(str, 4);
            return;
        }
        String str2 = businessFeedData.getGiftInfo() != null ? businessFeedData.getGiftInfo().giftType : null;
        if (str2 == null && businessFeedData.getOriginalInfoSafe().getGiftInfo() != null) {
            if (!TextUtils.isEmpty(businessFeedData.getOriginalInfoSafe().getGiftInfo().giftType)) {
                businessFeedData.getFeedCommInfo().actiontype = 1;
            }
        } else if (!TextUtils.isEmpty(str2)) {
            businessFeedData.getFeedCommInfo().actiontype = 0;
        }
        if (z16) {
            c1(businessFeedData, 1);
        } else {
            this.I.e4(businessFeedData, 1, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b1(String str, int i3, ClickedComment clickedComment, String str2, boolean z16, String str3, Map<String, String> map) {
        QZonePullToRefreshListView Q;
        BusinessFeedData L;
        String str4;
        String str5;
        long j3;
        Comment comment;
        User user;
        String str6;
        long j16;
        String str7;
        long j17;
        String str8;
        String str9;
        User user2;
        if (i3 == -1 || (Q = Q()) == null || (L = L(str3, (BusinessFeedData) Q.j0().getItemAtPosition(i3))) == null) {
            return;
        }
        Map<Integer, String> map2 = L.getOperationInfo().busiParam;
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Map<Integer, String> map3 = map2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("source=1&from_notify=");
        if (d1()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        sb5.append(str4);
        map3.put(41, sb5.toString());
        String str10 = L.getIdInfo().cellId;
        long j18 = L.getUser().uin;
        BusinessFeedData originalInfoSafe = L.getOriginalInfoSafe();
        int i16 = L.getFeedCommInfo().actiontype;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 8) {
                    if (i16 != 9) {
                        str5 = originalInfoSafe.getIdInfo().cellId;
                        j3 = originalInfoSafe.getUser().uin;
                        if (TextUtils.isEmpty(str5)) {
                            str5 = L.getIdInfo().cellId;
                            j3 = L.getUser().uin;
                        }
                        String str11 = str5;
                        long j19 = j3;
                        comment = originalInfoSafe.getCommentInfo().mainComment;
                        if (comment == null && !comment.isFake) {
                            User user3 = L.getUser();
                            long j26 = comment.user.uin;
                            str6 = comment.commentid;
                            j16 = j26;
                            user = user3;
                        } else {
                            user = L.getFeedCommInfo().appid == 333 ? L.getUser() : null;
                            str6 = "";
                            j16 = 0;
                        }
                        if (L.getFeedCommInfo().appid != 4) {
                            str7 = "";
                        } else {
                            str7 = "getPassiveFeeds";
                        }
                        if (j16 != 0) {
                            if (clickedComment != null) {
                                if (clickedComment.getReply() != null) {
                                    user2 = clickedComment.getReply().user;
                                } else {
                                    user2 = clickedComment.getComment().user;
                                }
                                User user4 = user2;
                                QZoneWriteOperationService.v0().c2(E(), L.getFeedCommInfo().ugckey, L.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), L.getFeedCommInfo().appid, j19, j16, user4, str11, "", clickedComment.getComment().commentid, u.a(user4.uin, user4.nickName) + str, str, str2, 0, map3, str7, L.getFeedCommInfo().isTodayInHistoryFeed(), i3, 3, map);
                                return;
                            }
                            QZoneWriteOperationService.v0().c2(E(), L.getFeedCommInfo().ugckey, L.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), L.getFeedCommInfo().appid, j19, j16, user, str11, "", str6, u.a(user.uin, user.nickName) + str, str, str2, 0, map3, str7, false, i3, 3, map);
                            return;
                        }
                        if (!L.getLocalInfo().canComment && !L.getLocalInfo().canReply) {
                            if (L.getLocalInfo().canReferComment) {
                                if (user == null) {
                                    user = L.getUser();
                                }
                                if (user != null) {
                                    str9 = u.a(user.uin, user.nickName) + str;
                                } else {
                                    str9 = str;
                                }
                                QZoneWriteOperationService.v0().R(E(), L.getFeedCommInfo().ugckey, L.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), L.getFeedCommInfo().appid, j19, str11, str9, str2, 0, map3, L.getLocalInfo().canReferComment, str7, L.getUser(), L.getFeedCommInfo().isTodayInHistoryFeed(), z16, map);
                                return;
                            }
                            return;
                        }
                        if (L.getFeedCommInfo().appid != 334) {
                            j17 = L.getUser().uin;
                        } else {
                            if (originalInfoSafe.getUser() != null) {
                                j17 = originalInfoSafe.getUser().uin;
                            }
                            if (TextUtils.isEmpty(str11)) {
                                str8 = str11;
                            } else {
                                String str12 = originalInfoSafe.getIdInfo().cellId;
                                if (originalInfoSafe.getUser() != null) {
                                    str8 = str12;
                                    j19 = originalInfoSafe.getUser().uin;
                                } else {
                                    str8 = str12;
                                }
                            }
                            QZoneWriteOperationService.v0().R(E(), L.getFeedCommInfo().ugckey, L.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), L.getFeedCommInfo().appid, j19, str8, str, str2, 0, map3, L.getLocalInfo().canComment, str7, L.getUser(), L.getFeedCommInfo().isTodayInHistoryFeed(), z16, map);
                            return;
                        }
                        j19 = j17;
                        if (TextUtils.isEmpty(str11)) {
                        }
                        QZoneWriteOperationService.v0().R(E(), L.getFeedCommInfo().ugckey, L.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), L.getFeedCommInfo().appid, j19, str8, str, str2, 0, map3, L.getLocalInfo().canComment, str7, L.getUser(), L.getFeedCommInfo().isTodayInHistoryFeed(), z16, map);
                        return;
                    }
                }
            }
            str5 = originalInfoSafe.getIdInfo().cellId;
            j3 = originalInfoSafe.getUser().uin;
            String str112 = str5;
            long j192 = j3;
            comment = originalInfoSafe.getCommentInfo().mainComment;
            if (comment == null) {
            }
            user = L.getFeedCommInfo().appid == 333 ? L.getUser() : null;
            str6 = "";
            j16 = 0;
            if (L.getFeedCommInfo().appid != 4) {
            }
            if (j16 != 0) {
            }
        }
        str5 = L.getIdInfo().cellId;
        j3 = L.getUser().uin;
        String str1122 = str5;
        long j1922 = j3;
        comment = originalInfoSafe.getCommentInfo().mainComment;
        if (comment == null) {
        }
        user = L.getFeedCommInfo().appid == 333 ? L.getUser() : null;
        str6 = "";
        j16 = 0;
        if (L.getFeedCommInfo().appid != 4) {
        }
        if (j16 != 0) {
        }
    }

    private void f1(String str, BusinessFeedData businessFeedData, int i3, boolean z16, ClickedComment clickedComment, String str2, boolean z17, String str3, Map<String, String> map) {
        b1(str, i3, clickedComment, str2, z17, str3, map);
    }
}
