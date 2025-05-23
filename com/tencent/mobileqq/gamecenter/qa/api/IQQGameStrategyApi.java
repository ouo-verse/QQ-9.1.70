package com.tencent.mobileqq.gamecenter.qa.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Set;
import ud1.GameRankConfig;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGameStrategyApi extends QRouteApi {
    void answerQuestion(QBaseActivity qBaseActivity, int i3, long j3, String str);

    void clearDraftCache();

    GameRankConfig getGameRankConfig();

    Class getHippyUIParserClass();

    Class getJumpParserClass();

    Fragment getStrategyDialogFragment(QBaseActivity qBaseActivity);

    Set<Integer> getSupportSceneSet();

    boolean isGameQAUrl(Activity activity);

    boolean isGameRobot(String str);

    void openGameQAQuoteArticle(Activity activity, int i3, int i16, long j3);

    void openGameStrategyAnswer(Context context, int i3, long j3, String str, String str2, String str3, int i16, int i17);

    void openGameStrategyAnswerDialog(QBaseActivity qBaseActivity, int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry);

    void openGameStrategyAtDialog(QBaseActivity qBaseActivity, int i3, long j3, ArrayList<InviteData> arrayList, ArrayList<String> arrayList2);

    void openGameStrategyAuthDialog(QBaseActivity qBaseActivity, int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry, GameStrategyAuthRequire gameStrategyAuthRequire);

    void openGameStrategyAuthDialog(QBaseActivity qBaseActivity, int i3, GameStrategyAuthRequire gameStrategyAuthRequire);

    void openGameStrategyQuestion(Context context, int i3, String str, String str2, int i16, int i17);

    void openGameStrategyQuestionDialog(QBaseActivity qBaseActivity, int i3, GameStrategyChannelEntry gameStrategyChannelEntry);

    void openTransparentPage(Context context, String str, int i3);

    void preloadJsBundle();

    void reportAskBtnClick(QBaseActivity qBaseActivity, int i3, GameStrategyChannelEntry gameStrategyChannelEntry);
}
