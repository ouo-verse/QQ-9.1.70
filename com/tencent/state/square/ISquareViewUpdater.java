package com.tencent.state.square;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareRecommendUserItem;
import com.tencent.state.square.data.SquareStyleInfo;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H&J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u000eH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H'J\"\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u001fH&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000eH&J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000eH&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0012\u0010.\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u000203H&J\u0010\u00104\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u00106\u001a\u00020\u0003H&J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u001fH&J\u0016\u00109\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\"0\u0005H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0018H&J\u0018\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u001fH&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020DH&J\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u00020GH&J\"\u0010H\u001a\u00020\u00032\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\n0JH&J\u0018\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH&J\u001c\u0010Q\u001a\u00020\u00032\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020K0JH&J\u0018\u0010R\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010S\u001a\u00020TH&J\"\u0010U\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010XH&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0018H&J\u0012\u0010[\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\\H&J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020_H&J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u0018H&J\u0018\u0010b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010c\u001a\u00020dH&J\u0010\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020gH&J\u0018\u0010h\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010i\u001a\u00020jH&J\u001a\u0010k\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010l\u001a\u0004\u0018\u00010mH&\u00a8\u0006n"}, d2 = {"Lcom/tencent/state/square/ISquareViewUpdater;", "Lcom/tencent/state/map/IMapViewUpdater;", "appendOrUpdateChatLandUserItem", "", "list", "", "Lcom/tencent/state/map/MapItem;", "onDone", "Lkotlin/Function0;", "appendOrUpdateRecommendUserItem", "", "Lcom/tencent/state/square/data/SquareRecommendUserItem;", "clearNewInfo", "index", "", "targetTypes", "doAirborneLanding", "", "Lcom/tencent/state/square/MoveItem;", "Lcom/tencent/state/square/MoveResult;", VideoTemplateParser.ITEM_LIST, "doAvatarCloseToMe", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "uin", "", "doAvatarSetTop", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "unReadMsgCount", "foldTroopMessage", "getCloseToMePlace", "getCurAvatarGender", "", "()Ljava/lang/Boolean;", "getCurMeActions", "Lcom/tencent/state/square/data/AvatarAction;", "hide", "itemType", "skipAnim", "hideRingAnim", "hideSpeakBubble", "isNotInSquare", SquareJSConst.Params.PARAMS_UNIT_TYPE, "isNotInSquareUinItemType", "onFootLabelChangeNotify", "label", "Lcom/tencent/state/template/data/CommonFootLabel;", "onNewMessage", "onTroopUnreadMessageNotify", "message", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "onUnreadMessageNotify", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "pauseAndEnsurePlay", "playRingAnim", "saveBuildingChange", "setAvatarFixed", "isFixed", "setMeActions", "showTroopMessage", "updateAvatarCover", "id", "updateAvatarImageVisible", "show", "updateAvatarLocationView", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "updateBlindBoxEntrance", "blindBoxEntranceInfo", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateBuildingBubble", "result", "", "Lcom/tencent/state/square/data/BuildingBubble;", "updateBuildingStyle", "data", "Lcom/tencent/state/square/data/SquareEntranceItem;", "styleInfo", "Lcom/tencent/state/square/data/SquareStyleInfo;", "updateExtraBuildingBubble", "updateFeedsBubble", "feedsInfo", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "updateFlowerInfo", "flowerCount", "flowerMedal", "Lcom/tencent/state/square/flower/data/MedalData;", "updateMeCustomText", "md5", "updateMeLikeUnReadNum", "Lcom/tencent/state/square/like/LikeListInfo;", "updateMeStatus", "newItem", "Lcom/tencent/state/square/detail/StatusUpdateData;", "updateMusicPlayState", "songMid", "updatePttPlayState", "state", "Lcom/tencent/state/square/data/PlayState;", "updateSpeakBubble", "bubble", "Lcom/tencent/state/template/push/BubbleMessage;", "updateStickers", c.B, "Lcom/tencent/state/square/data/Stickers;", "updateUserSongInfo", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareViewUpdater extends IMapViewUpdater {
    void appendOrUpdateChatLandUserItem(List<? extends MapItem> list, Function0<Unit> onDone);

    void appendOrUpdateRecommendUserItem(List<SquareRecommendUserItem> list);

    void clearNewInfo(int index, List<Integer> targetTypes);

    Map<MoveItem, MoveResult> doAirborneLanding(List<MoveItem> itemList);

    PlaceInfo doAvatarCloseToMe(String uin);

    PlaceInfo doAvatarSetTop(MoveItem item, int unReadMsgCount);

    void foldTroopMessage(String uin);

    PlaceInfo getCloseToMePlace(String uin);

    Boolean getCurAvatarGender();

    List<AvatarAction> getCurMeActions();

    @Deprecated(message = "use hide(uin, itemType) instead")
    void hide(String uin);

    void hide(String uin, int itemType, boolean skipAnim);

    void hideRingAnim(String uin);

    void hideSpeakBubble(String uin);

    boolean isNotInSquare(String uin, int unitType);

    boolean isNotInSquareUinItemType(String uin, int itemType);

    void onFootLabelChangeNotify(CommonFootLabel label);

    void onNewMessage(int index);

    void onTroopUnreadMessageNotify(SquareTroopMessageRecord message);

    void onUnreadMessageNotify(SquareBaseMessageRecord message);

    void pauseAndEnsurePlay(String uin);

    void playRingAnim(String uin);

    void saveBuildingChange();

    void setAvatarFixed(String uin, boolean isFixed);

    void setMeActions(List<AvatarAction> list);

    void showTroopMessage(String uin);

    void updateAvatarCover(String id5);

    void updateAvatarImageVisible(String id5, boolean show);

    void updateAvatarLocationView(AvatarLocationInfo locationInfo);

    void updateBlindBoxEntrance(SquareBlindBoxEntranceInfo blindBoxEntranceInfo);

    void updateBubbleSkin(String uin, SquareBubbleInfo bubbleInfo);

    void updateBuildingBubble(Map<Integer, List<BuildingBubble>> result);

    void updateBuildingStyle(SquareEntranceItem data, SquareStyleInfo styleInfo);

    void updateExtraBuildingBubble(Map<Integer, BuildingBubble> result);

    void updateFeedsBubble(String uin, QZoneFeedsInfo feedsInfo);

    void updateFlowerInfo(String uin, int flowerCount, MedalData flowerMedal);

    void updateMeCustomText(String md5);

    void updateMeLikeUnReadNum(LikeListInfo data);

    void updateMeStatus(StatusUpdateData newItem);

    void updateMusicPlayState(String songMid);

    void updatePttPlayState(String uin, PlayState state);

    void updateSpeakBubble(BubbleMessage bubble);

    void updateStickers(String uin, Stickers stickers);

    void updateUserSongInfo(String uin, SongInfo songInfo);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void appendOrUpdateChatLandUserItem$default(ISquareViewUpdater iSquareViewUpdater, List list, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function0 = new Function0<Unit>() { // from class: com.tencent.state.square.ISquareViewUpdater$appendOrUpdateChatLandUserItem$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    };
                }
                iSquareViewUpdater.appendOrUpdateChatLandUserItem(list, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendOrUpdateChatLandUserItem");
        }

        public static /* synthetic */ PlaceInfo doAvatarSetTop$default(ISquareViewUpdater iSquareViewUpdater, MoveItem moveItem, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iSquareViewUpdater.doAvatarSetTop(moveItem, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doAvatarSetTop");
        }

        public static /* synthetic */ void hide$default(ISquareViewUpdater iSquareViewUpdater, String str, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    z16 = false;
                }
                iSquareViewUpdater.hide(str, i3, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }

        public static /* synthetic */ void onNewMessage$default(ISquareViewUpdater iSquareViewUpdater, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i3 = -1;
                }
                iSquareViewUpdater.onNewMessage(i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNewMessage");
        }
    }
}
