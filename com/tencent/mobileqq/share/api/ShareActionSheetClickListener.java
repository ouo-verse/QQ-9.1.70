package com.tencent.mobileqq.share.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

/* compiled from: P */
@PluginInterface
/* loaded from: classes18.dex */
public interface ShareActionSheetClickListener {
    void cancelPushDisable();

    void cancelWatchLater();

    void changeFeedPermission(boolean z16);

    void collect();

    void copyContent();

    void copyLink();

    void copyShortLink();

    void createQrcode();

    void dataAnalyze();

    void delete();

    void deleteAlbum();

    void deleteHasPush();

    void editAlbum();

    void enterQCircleFloatingWindow();

    void feedback();

    void hideHim();

    void hideThisWork();

    void jumpQcirclePrivateMessage();

    void miniAppDebugOn();

    void openFeedBindQQGroupPage();

    void openMusicAggregationPage();

    void promotion();

    void pushRanComment();

    void report();

    void save();

    void saveQrcode();

    void setQQProfileCover();

    void shareToChannel(int i3);

    void shareToQQ();

    void shareToQZone();

    void shareToSpecifiedFriend(String str, String str2, int i3);

    void shareToWeChat(int i3);

    void shareToWeChatCircle(int i3);

    void showReportDisLike();

    void stick();

    void switchBarrageClose();

    void switchBarrageOpen();

    void unCollect();

    void unStick();

    void watchLater();
}
