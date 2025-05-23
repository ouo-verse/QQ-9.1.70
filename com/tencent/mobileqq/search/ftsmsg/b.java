package com.tencent.mobileqq.search.ftsmsg;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.en;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import vy2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends ep2.c {
    private String N;
    private String P;
    private int Q;

    public b(AppInterface appInterface, String str, ArrayList<String> arrayList, FTSEntity fTSEntity) {
        super(appInterface, str, arrayList, fTSEntity);
        FTSMessage fTSMessage = (FTSMessage) this.G;
        this.N = String.valueOf(fTSMessage.uin);
        this.P = fTSMessage.senderuin;
        this.Q = fTSMessage.istroop;
        getTitleSpans();
    }

    @Override // ep2.c
    public CharSequence H() {
        CharSequence charSequence;
        if (this.L == null && (charSequence = ((FTSMessage) this.G).matchSecondTitle) != null) {
            this.L = charSequence;
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return String.valueOf(((FTSMessage) this.G).senderuin);
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (TextUtils.isEmpty(this.J)) {
            this.J = "";
            MsgExts msgExts = ((FTSMessage) this.G).msgExts;
            if (msgExts != null) {
                this.J = en.d(MobileQQ.sMobileQQ, 3, ((TextMsgExts) msgExts).time * 1000);
            }
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.K == null) {
            FTSMessage fTSMessage = (FTSMessage) this.G;
            CharSequence charSequence = fTSMessage.matchTitle;
            if (charSequence != null) {
                this.K = charSequence;
            } else {
                boolean equals = G().getCurrentAccountUin().equals(fTSMessage.senderuin);
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = this.Q;
                sessionInfo.f179557e = this.N;
                if ("80000000".equals(this.P)) {
                    this.K = HardCodeUtil.qqStr(R.string.mub);
                } else {
                    this.K = ac.T((QQAppInterface) G(), sessionInfo, equals, fTSMessage.senderuin);
                }
            }
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
        iSearchPieceFetcher.setRecentUtilIsEnterFromSearch(Boolean.TRUE);
        FTSMessage fTSMessage = (FTSMessage) this.G;
        MsgExts msgExts = fTSMessage.msgExts;
        if (msgExts != null) {
            int i3 = fTSMessage.istroop;
            if (i3 != 1 && i3 != 3000) {
                iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).time);
            } else {
                iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).shmsgseq);
            }
        }
        b.a.f443715d = fTSMessage.searchStrategy;
        b.a.f443717f = 1;
        b.a.f443718g = this.Q;
        FTSEntity fTSEntity = this.G;
        b.a.f443721j = ((FTSMessage) fTSEntity).senderNum;
        b.a.f443722k = ((FTSMessage) fTSEntity).friendNum;
        b.a.f443723l = ((FTSMessage) fTSEntity).friendIndex;
        vy2.b.k(view);
        RecentUtil.s(view.getContext(), (QQAppInterface) G(), this.N, this.Q, ac.Q(G(), this.N, this.Q), false);
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(G(), this.H);
        SearchUtils.Z0(this.H, 40, view, true);
    }
}
