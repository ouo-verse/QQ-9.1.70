package fe1;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.gamecenter.qa.data.GameQuestionFollow;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.gamecenter.qa.model.e;
import com.tencent.mobileqq.gamecenter.qa.model.f;
import com.tencent.mobileqq.gamecenter.qa.model.g;
import com.tencent.mobileqq.gamecenter.qa.model.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface d {
    void onAddMetaDreamGameFriend(boolean z16, long j3);

    void onAnswerQuestionFinish(long j3, long j16, int i3);

    void onChangeOnlineStatus(long j3, boolean z16);

    void onChannelAnswerQuestionFinish(long j3, long j16, String str, int i3);

    void onChannelPublishQuestionFinish(long j3, long j16, String str, int i3);

    void onCheckAtRobot(long j3, boolean z16);

    void onExpertOnlineHeartbeat(long j3, int i3);

    void onGetAuthJoin(long j3, int i3, boolean z16);

    void onGetAuthRequire(long j3, String str, int i3, @Nullable GameStrategyAuthRequire gameStrategyAuthRequire);

    void onGetAuthWhite(long j3, String str, int i3, boolean z16);

    void onGetBindInfoRsp(long j3, int i3, String str);

    void onGetExpertList(long j3, e eVar);

    void onGetGameList(long j3, List<GameListItem> list, long j16, boolean z16);

    void onGetInviteList(long j3, List<String> list);

    void onGetInviteListDetail(long j3, List<InviteData> list);

    void onGetMetaDreamGameTeamingLink(boolean z16, long j3, String str);

    void onGetMetaDreamIsFriend(boolean z16, long j3, boolean z17);

    void onGetMyRefMaterials(long j3, List<GameQALinkCardData> list, int i3, int i16, int i17, boolean z16);

    void onGetNoAnswer(long j3, g gVar);

    void onGetOAID(boolean z16, String str);

    void onGetOnlineStatus(long j3, boolean z16);

    void onGetQuestionList(long j3, f fVar);

    void onGetRecommendMaterials(long j3, int i3, List<GameQALinkCardData> list);

    void onGetRefMaterialByLink(long j3, GameQALinkCardData gameQALinkCardData, long j16);

    void onInviteUser(long j3, List<Long> list);

    void onLikeAnswerRsp(long j3, long j16, long j17, boolean z16, boolean z17);

    void onPublishQuestionFinish(long j3, long j16, int i3);

    void onQueryTagsFinish(long j3, List<GameStrategyTag> list);

    void onQuestionFollow(long j3, GameQuestionFollow gameQuestionFollow);

    void onSearchQuestionsFinish(long j3, List<j> list);

    void onSetBindInfoRsp(long j3, int i3);
}
