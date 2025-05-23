package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends ep2.d {
    private String T;
    private gd1.a U;
    private GameBoxRecentUser V;

    public g(AppInterface appInterface, String str, String str2, ArrayList<String> arrayList, List<? extends FTSEntity> list, String str3) {
        super(str, str2, arrayList, list);
        this.T = str3;
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) appInterface.getRuntimeService(IGameMsgBoxManager.class, "");
        this.V = iGameMsgBoxManager.findGameBoxRecentUserInfo(str3);
        this.U = iGameMsgBoxManager.findGameDetailInfoByConvertUin(str3);
    }

    @Override // ep2.d
    public CharSequence G() {
        return null;
    }

    @Override // ep2.d
    public CharSequence H() {
        return null;
    }

    public boolean I() {
        if (this.V != null && this.U != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 119;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.T;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (this.M == null) {
            int size = this.S.size();
            if (size == 1) {
                this.M = SearchUtils.Y(this.S.get(0).mContent, this.S.get(0).mProximityStart, this.I);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.muc) + "\"");
                String str = this.G;
                spannableStringBuilder.append(SearchUtils.C(str, str));
                spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) "\u76f8\u5173\u8bb0\u5f55");
                this.M = spannableStringBuilder;
            }
        }
        return this.M;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.U.f401941e;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        this.J = this.U.f401941e;
        if (this.S.size() == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("uin", this.T);
            bundle.putString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, this.V.mToRoleId);
            bundle.putString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, this.V.mFromRoleId);
            bundle.putInt("uintype", 10007);
            bundle.putInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, 6);
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            iSearchPieceFetcher.setRecentUtilIsEnterFromSearch(Boolean.TRUE);
            MsgExts msgExts = ((FTSMessage) this.S.get(0)).msgExts;
            if (msgExts != null) {
                iSearchPieceFetcher.setRecentUtilEnterFromExts(((TextMsgExts) msgExts).time);
            }
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(appInterface, this.G);
            iSearchPieceFetcher.enterChatWin(view.getContext(), appInterface, this.T, 10007, this.U.f401941e, false, bundle, null);
            return;
        }
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).lanuchFTSEntitySearchDetailActivity(view.getContext(), getKeyword(), this.H, getTitleSpans(), this.S, 1, this.T, 10007, -1);
    }
}
