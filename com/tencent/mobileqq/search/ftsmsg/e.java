package com.tencent.mobileqq.search.ftsmsg;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import vy2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends ep2.d {
    private String T;
    private String U;
    private int V;
    protected String W;
    private String X;

    public e(AppInterface appInterface, String str, String str2, ArrayList<String> arrayList, List<FTSMessage> list, String str3, CharSequence charSequence) {
        super(str, str2, arrayList, list);
        FTSMessage fTSMessage = list.get(0);
        this.T = String.valueOf(fTSMessage.uin);
        this.U = fTSMessage.senderuin;
        int i3 = fTSMessage.istroop;
        this.V = i3;
        this.W = str3;
        this.J = charSequence;
        if (i3 == 3000) {
            int discussionMemberNum = ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(this.T);
            if (discussionMemberNum <= 0) {
                this.X = "";
            } else {
                this.X = String.valueOf(discussionMemberNum);
            }
        }
        C(13);
        D(this.T + "_" + this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        M(view, this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(final View view, String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.ftsmsg.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.K(view);
            }
        });
    }

    private void M(View view, CharSequence charSequence) {
        if (this.S.size() == 1) {
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            iSearchPieceFetcher.setRecentUtilIsEnterFromSearch(Boolean.TRUE);
            FTSMessage fTSMessage = (FTSMessage) this.S.get(0);
            MsgExts msgExts = fTSMessage.msgExts;
            if (msgExts != null) {
                int i3 = fTSMessage.istroop;
                if (i3 != 1 && i3 != 3000) {
                    iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).time);
                } else {
                    iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).shmsgseq);
                }
            }
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(appInterface, this.G);
            iSearchPieceFetcher.enterChatWin(view.getContext(), appInterface, this.T, this.V, (String) charSequence, false);
            SearchUtils.Z0(this.G, 40, view, false);
        } else {
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).fTSEntitySearchDetailActivityLaunch(view.getContext(), getKeyword(), this.H, charSequence, this.S, 1, this.T, this.V, -1, 0);
        }
        SearchUtils.c1(this.G, 40, 0, view);
    }

    @Override // ep2.d
    public CharSequence G() {
        CharSequence charSequence;
        List<? extends FTSEntity> list = this.S;
        if (list != null && list.size() == 1 && this.L == null && (this.S.get(0) instanceof FTSMessage) && (charSequence = ((FTSMessage) this.S.get(0)).matchSecondTitle) != null) {
            this.L = charSequence;
        }
        return this.L;
    }

    @Override // ep2.d
    public CharSequence H() {
        CharSequence charSequence;
        List<? extends FTSEntity> list = this.S;
        if (list != null && list.size() == 1 && this.K == null && (this.S.get(0) instanceof FTSMessage) && (charSequence = ((FTSMessage) this.S.get(0)).matchTitle) != null) {
            this.K = charSequence;
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        int i3 = this.V;
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                if (!QLog.isColorLevel()) {
                    return 1;
                }
                QLog.d("FTSMessageSearchResultModel", 2, "Face type is illegal. type = " + this.V);
                return 1;
            }
            return 101;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.T;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        ArrayList<String> arrayList;
        if (this.M == null) {
            int size = this.S.size();
            if (size == 1) {
                this.M = SearchUtils.Y(this.S.get(0).mContent, this.S.get(0).mProximityStart, this.I);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.muc) + "\"");
                if (this.W != null && ((arrayList = this.I) == null || arrayList.isEmpty())) {
                    String str = this.W;
                    spannableStringBuilder.append(SearchUtils.C(str, str));
                } else {
                    String str2 = this.G;
                    spannableStringBuilder.append(SearchUtils.C(str2, str2));
                }
                spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) "\u76f8\u5173\u8bb0\u5f55");
                this.M = spannableStringBuilder;
            }
        }
        return this.M;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        if (this.V == 3000 && !TextUtils.isEmpty(this.X)) {
            return SearchUtils.W(this.X);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.J == null) {
            this.J = ac.Q((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), this.T, this.V);
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(final View view) {
        boolean isUniteSearchActivity = ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).isUniteSearchActivity(view.getContext());
        if (isUniteSearchActivity) {
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this)) {
                SearchUtils.d dVar = hashMap.get(this);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "native");
                } catch (JSONException e16) {
                    QLog.e("FTSMessageSearchResultModel", 2, "e = " + e16);
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            com.tencent.mobileqq.search.report.b.e(null, this.C, 0, "0X8009D4D", 0, 0, null, null);
        }
        Integer num = (Integer) view.getTag(R.id.kxc);
        Integer num2 = (Integer) view.getTag(R.id.kxa);
        if (isUniteSearchActivity && num.intValue() >= 0 && num2.intValue() >= 0) {
            SearchUtils.W0("all_result", "clk_talk", "" + this.G, "" + num2, "" + (num.intValue() + 1));
        } else if (isUniteSearchActivity) {
            SearchUtils.W0("talk", "clk_talk", "" + this.G, "" + num2, "" + (num.intValue() + 1));
        }
        if (this.S.size() == 1) {
            b.a.f443717f = 1;
        } else {
            b.a.f443717f = 2;
        }
        b.a.f443715d = this.N;
        b.a.f443718g = this.V;
        b.a.f443721j = this.P;
        b.a.f443722k = this.Q;
        b.a.f443723l = this.R;
        vy2.b.k(view);
        CharSequence charSequence = this.J;
        if (charSequence != null) {
            AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            vy2.b.i((QQAppInterface) appInterface2, appInterface2.getApp(), this.T, this.V, this.U, new com.tencent.mobileqq.troop.e() { // from class: com.tencent.mobileqq.search.ftsmsg.c
                @Override // com.tencent.mobileqq.troop.e
                public final void a(String str) {
                    e.this.L(view, str);
                }
            });
        } else {
            M(view, charSequence);
        }
    }
}
