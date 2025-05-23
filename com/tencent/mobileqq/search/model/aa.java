package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.en;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa extends z {
    private static SimpleDateFormat N = new SimpleDateFormat("yy/MM/dd");
    private RecentUser G;
    private MessageRecord H;
    private String I;
    private CharSequence J;
    private QQAppInterface K;
    private CharSequence L;
    private CharSequence M;

    public aa(QQAppInterface qQAppInterface, String str, RecentUser recentUser, MessageRecord messageRecord) {
        this.K = qQAppInterface;
        this.I = str;
        this.G = recentUser;
        this.H = messageRecord;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.H.senderuin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (TextUtils.isEmpty(this.J)) {
            this.J = en.d(BaseApplicationImpl.sApplication, 3, this.H.time * 1000);
        }
        return this.J;
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
        return this.I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        if (this.M == null) {
            this.M = SearchUtils.C(this.H.f203106msg, this.I);
        }
        return this.M;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.L == null) {
            if (com.tencent.biz.anonymous.a.m(this.H)) {
                this.L = BaseApplicationImpl.sApplication.getString(R.string.eid) + com.tencent.biz.anonymous.a.e(this.H).f78367c;
            } else {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = this.G.getType();
                sessionInfo.f179557e = this.G.uin;
                this.L = com.tencent.mobileqq.utils.ac.T(this.K, sessionInfo, this.H.isSend(), this.H.senderuin);
            }
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        RecentUtil.f185176a = true;
        RecentUtil.f185177b = this.H;
        Context context = view.getContext();
        QQAppInterface qQAppInterface = this.K;
        RecentUser recentUser = this.G;
        String str = recentUser.uin;
        int type = recentUser.getType();
        QQAppInterface qQAppInterface2 = this.K;
        RecentUser recentUser2 = this.G;
        RecentUtil.s(context, qQAppInterface, str, type, com.tencent.mobileqq.utils.ac.Q(qQAppInterface2, recentUser2.uin, recentUser2.getType()), false);
        com.tencent.mobileqq.search.ac.o(this.K, this.I);
        SearchUtils.Z0(this.I, 40, view, true);
    }
}
