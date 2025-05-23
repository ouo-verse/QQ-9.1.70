package com.tencent.mobileqq.troop.troopcard.api;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopGameCardUtilsApi extends QRouteApi {
    public static final int GAME_CARD_CLOSE = 0;
    public static final int GAME_CARD_OPEN = 1;
    public static final String GAME_GRADE_ICON_FILE_NAME_PREFIX = "game_grade_";
    public static final String GAME_GRADE_NUMBER_ICON_FILE_NAME_PREFIX = "game_grade_number_";
    public static final String GAME_GRADE_START_IMAGE_FILE_NAME_PREFIX = "game_grade_star";
    public static final String GAME_MEMBER_GAME_CARD_BG_IMAGE_FILE_NAME = "member_game_card_bg.png";
    public static final String GAME_MEMBER_GAME_CARD_BG_NIGHT_IMAGE_FILE_NAME = "member_game_card_bg_night.png";
    public static final String GAME_SKILLED_LEVEL_ICON_FILE_NAME_PREFIX = "game_hero_skill_level_";
    public static final int GRAY_TIPS_SWITCH_CLOSE_BIZ_ID = 10036;
    public static final int GRAY_TIPS_SWITCH_OPEN_BIZ_ID = 10035;
    public static final String PNG_ENDPIX = ".png";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16, boolean z17);
    }

    void ansyCheckShowMsgGameGradeLevel(String str, String str2, a aVar);

    @Nullable
    boolean[] checkShowMsgGameGradeLevel(String str, String str2, a aVar);

    String getGameGradeIconPathById(int i3);

    String getGameGradeNumberIconPathById(int i3);

    String getGameGradeStarImagePathById(int i3);

    String getGameSkilledLevelIconPath(int i3);

    String getGradeDescById(int i3);

    Bitmap getImageBitmap(String str);

    String getMajorGradeTagById(int i3);

    String getMemberGameCardBgImagePath(boolean z16);

    String getOccupationTypeText(int i3);

    String getSecondaryGradeById(int i3);

    String getSelectedEndColorById(int i3);

    String getSelectedStartColorById(int i3);

    String getSelectedTextColorById(int i3);

    String getUnselectedEndColorById(int i3);

    String getUnselectedStartColorById(int i3);
}
