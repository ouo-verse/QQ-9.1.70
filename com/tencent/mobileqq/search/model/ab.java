package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.activity.MessageSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ab extends z {
    private String G;
    private FullMessageSearchResult.SearchResultItem H;
    private QQAppInterface I;
    private CharSequence J;
    private CharSequence K;
    private String L;

    public ab(QQAppInterface qQAppInterface, String str, FullMessageSearchResult.SearchResultItem searchResultItem) {
        this.I = qQAppInterface;
        this.G = str;
        this.H = searchResultItem;
        if (searchResultItem.user.getType() == 3000) {
            int q16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(searchResultItem.user.uin);
            if (q16 <= 0) {
                this.L = "";
            } else {
                this.L = String.valueOf(q16);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        int type = this.H.user.getType();
        if (type == 0) {
            return 1;
        }
        if (type != 1) {
            if (type != 3000) {
                if (!QLog.isColorLevel()) {
                    return 1;
                }
                QLog.d("MessageSearchResultModel", 2, "Face type is illegal. type = " + this.H.user.getType());
                return 1;
            }
            return 101;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.H.user.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (this.K == null) {
            int size = this.H.secondPageMessageUniseq.size();
            if (size == 1) {
                this.K = SearchUtils.C(this.H.secondPageList.get(0).f203106msg, this.G);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.o3k) + "\"");
                String str = this.G;
                spannableStringBuilder.append(SearchUtils.C(str, str));
                spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) "\u76f8\u5173\u8bb0\u5f55");
                this.K = spannableStringBuilder;
            }
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        if (this.H.user.getType() == 3000 && !TextUtils.isEmpty(this.L)) {
            return SearchUtils.W(this.L);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.J == null) {
            QQAppInterface qQAppInterface = this.I;
            RecentUser recentUser = this.H.user;
            this.J = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, recentUser.uin, recentUser.getType());
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        if (view.getContext() instanceof UniteSearchActivity) {
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this)) {
                SearchUtils.d dVar = hashMap.get(this);
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "native");
                } catch (JSONException e16) {
                    QLog.e("MessageSearchResultModel", 2, "e = " + e16);
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
        }
        if (this.H.secondPageMessageUniseq.size() == 1) {
            RecentUtil.f185176a = true;
            RecentUtil.f185177b = this.H.secondPageList.get(0);
            Context context = view.getContext();
            QQAppInterface qQAppInterface2 = this.I;
            RecentUser recentUser = this.H.user;
            String str = recentUser.uin;
            int type = recentUser.getType();
            QQAppInterface qQAppInterface3 = this.I;
            RecentUser recentUser2 = this.H.user;
            RecentUtil.s(context, qQAppInterface2, str, type, com.tencent.mobileqq.utils.ac.Q(qQAppInterface3, recentUser2.uin, recentUser2.getType()), false);
            com.tencent.mobileqq.search.ac.o(this.I, this.G);
            SearchUtils.Z0(this.G, 40, view, false);
        } else {
            MessageSearchDetailActivity.H2(view.getContext(), getKeyword(), this.H);
        }
        SearchUtils.c1(this.G, 40, 0, view);
    }
}
