package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends ep2.c {
    private String N;
    private gd1.a P;
    private GameBoxRecentUser Q;

    public f(AppInterface appInterface, String str, ArrayList<String> arrayList, FTSEntity fTSEntity) {
        super(appInterface, str, arrayList, fTSEntity);
        this.N = String.valueOf(((FTSMessage) fTSEntity).uin);
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appInterface.getRuntimeService(IGameMsgBoxManager.class, "");
        this.Q = iGameMsgBoxManager.findGameBoxRecentUserInfo(this.N);
        this.P = iGameMsgBoxManager.findGameDetailInfoByConvertUin(this.N);
    }

    @Override // ep2.c
    public CharSequence H() {
        CharSequence charSequence;
        if (this.L == null && (charSequence = ((FTSMessage) this.G).matchSecondTitle) != null) {
            this.L = charSequence;
        }
        return this.L;
    }

    @Override // ep2.c, com.tencent.mobileqq.search.model.t
    public int k() {
        return 119;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (TextUtils.isEmpty(this.J)) {
            this.J = "";
            FTSMessage fTSMessage = (FTSMessage) this.G;
            if (fTSMessage.msgExts != null) {
                this.J = en.d(BaseApplication.getContext(), 3, ((TextMsgExts) fTSMessage.msgExts).time * 1000);
            }
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        return this.P.f401941e;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.N);
        bundle.putString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, this.Q.mToRoleId);
        bundle.putString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, this.Q.mFromRoleId);
        bundle.putInt("uintype", 10007);
        bundle.putInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, 6);
        ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
        iSearchPieceFetcher.setRecentUtilIsEnterFromSearch(Boolean.TRUE);
        MsgExts msgExts = ((FTSMessage) this.G).msgExts;
        if (msgExts != null) {
            iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).time);
        }
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(G(), this.H);
        iSearchPieceFetcher.enterChatWin(view.getContext(), G(), this.N, 10007, this.P.f401941e, false, bundle, null);
    }
}
