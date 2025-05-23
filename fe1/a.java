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
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements d {
    private static final String TAG = "DefaultGameStrategyListener";

    @Override // fe1.d
    public void onGetExpertList(long j3, e eVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetExpertList errorCode:", Long.valueOf(j3));
        }
    }

    @Override // fe1.d
    public void onQuestionFollow(long j3, GameQuestionFollow gameQuestionFollow) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onQuestionFollow errorCode:", Long.valueOf(j3));
        }
    }

    @Override // fe1.d
    public void onAddMetaDreamGameFriend(boolean z16, long j3) {
    }

    @Override // fe1.d
    public void onChangeOnlineStatus(long j3, boolean z16) {
    }

    @Override // fe1.d
    public void onCheckAtRobot(long j3, boolean z16) {
    }

    @Override // fe1.d
    public void onExpertOnlineHeartbeat(long j3, int i3) {
    }

    @Override // fe1.d
    public void onGetInviteList(long j3, List<String> list) {
    }

    @Override // fe1.d
    public void onGetInviteListDetail(long j3, List<InviteData> list) {
    }

    @Override // fe1.d
    public void onGetNoAnswer(long j3, g gVar) {
    }

    @Override // fe1.d
    public void onGetOAID(boolean z16, String str) {
    }

    @Override // fe1.d
    public void onGetOnlineStatus(long j3, boolean z16) {
    }

    @Override // fe1.d
    public void onGetQuestionList(long j3, f fVar) {
    }

    @Override // fe1.d
    public void onInviteUser(long j3, List<Long> list) {
    }

    @Override // fe1.d
    public void onQueryTagsFinish(long j3, List<GameStrategyTag> list) {
    }

    @Override // fe1.d
    public void onSearchQuestionsFinish(long j3, List<j> list) {
    }

    @Override // fe1.d
    public void onSetBindInfoRsp(long j3, int i3) {
    }

    @Override // fe1.d
    public void onAnswerQuestionFinish(long j3, long j16, int i3) {
    }

    @Override // fe1.d
    public void onGetAuthJoin(long j3, int i3, boolean z16) {
    }

    @Override // fe1.d
    public void onGetBindInfoRsp(long j3, int i3, String str) {
    }

    @Override // fe1.d
    public void onGetMetaDreamGameTeamingLink(boolean z16, long j3, String str) {
    }

    @Override // fe1.d
    public void onGetMetaDreamIsFriend(boolean z16, long j3, boolean z17) {
    }

    @Override // fe1.d
    public void onGetRecommendMaterials(long j3, int i3, List<GameQALinkCardData> list) {
    }

    @Override // fe1.d
    public void onGetRefMaterialByLink(long j3, GameQALinkCardData gameQALinkCardData, long j16) {
    }

    @Override // fe1.d
    public void onPublishQuestionFinish(long j3, long j16, int i3) {
    }

    @Override // fe1.d
    public void onChannelAnswerQuestionFinish(long j3, long j16, String str, int i3) {
    }

    @Override // fe1.d
    public void onChannelPublishQuestionFinish(long j3, long j16, String str, int i3) {
    }

    @Override // fe1.d
    public void onGetAuthRequire(long j3, String str, int i3, @Nullable GameStrategyAuthRequire gameStrategyAuthRequire) {
    }

    @Override // fe1.d
    public void onGetAuthWhite(long j3, String str, int i3, boolean z16) {
    }

    @Override // fe1.d
    public void onGetGameList(long j3, List<GameListItem> list, long j16, boolean z16) {
    }

    @Override // fe1.d
    public void onLikeAnswerRsp(long j3, long j16, long j17, boolean z16, boolean z17) {
    }

    @Override // fe1.d
    public void onGetMyRefMaterials(long j3, List<GameQALinkCardData> list, int i3, int i16, int i17, boolean z16) {
    }
}
