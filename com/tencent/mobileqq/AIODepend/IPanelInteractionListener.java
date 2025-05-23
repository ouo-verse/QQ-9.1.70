package com.tencent.mobileqq.AIODepend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.qqnt.aio.shortcutbar.g;

/* loaded from: classes9.dex */
public interface IPanelInteractionListener extends IPanelListener {
    boolean canShowGif();

    Object gestureDetectorDestroy(Object obj);

    IAIOEmoticonUIHelper getAIOEmoticonUIHelper();

    int getAIOHeight();

    EditText getAIOInput();

    int[] getAIOLocation();

    ViewGroup getAIORootView();

    float getAIOScale();

    int getAIOWidth();

    String getCurFriendUin();

    int getCurType();

    <T> T getHelper(int i3);

    String getInputBarText();

    void getLocationInAIO(View view, int[] iArr);

    int getPanelChatPieType();

    int getPanelIconsBarHeight();

    int getPanelTargetHeight();

    PopOutAnimConfig getPopOutAnimConfig();

    int getStatusBarHeight(Context context);

    int getTitleBarHeight();

    Object initGestureDetector(Object obj);

    boolean isCurGuildLiveChannel();

    boolean isExperiment();

    boolean isHostSafe();

    boolean isInAio();

    boolean isRobotAIO();

    boolean isScaleChat();

    boolean isShowEmoTitleInPreview(EmoticonInfo emoticonInfo, boolean z16);

    void launchAECameraUnit();

    boolean needShowFavAndFunnyPicIcon();

    void removeEmoticonGuideBubble();

    void setPaneliconsInterceptListener(g gVar);

    void setPaneliconsShowRed(int i3, boolean z16);

    void stickerEditMode(boolean z16);

    void stopAnimationConatiner();

    boolean supportExtendPanel();
}
