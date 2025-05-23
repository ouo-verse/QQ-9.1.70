package com.tencent.mobileqq.share.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

/* compiled from: P */
@PluginInterface
/* loaded from: classes18.dex */
public class ShareConfig {
    static IPatchRedirector $redirector_;
    public boolean isForceNightTheme;
    public boolean isShowBackgroundMusic;
    public boolean isShowBarrageClose;
    public boolean isShowBarrageOpen;
    public boolean isShowCancelWatchLater;
    public boolean isShowCollect;
    public boolean isShowContentPromotion;
    public boolean isShowCopyContent;
    public boolean isShowCopySchemaLink;
    public boolean isShowCopyShortLink;
    public boolean isShowDataAnalyze;
    public boolean isShowDebug;
    public boolean isShowDelete;
    public boolean isShowDeleteAndEditAlbum;
    public boolean isShowDeletePush;
    public boolean isShowDeletePushDisable;
    public boolean isShowDisLike;
    public boolean isShowFeedBindQQGroup;
    public boolean isShowFeedback;
    public boolean isShowHideThisWork;
    public boolean isShowNotAllowDownload;
    public boolean isShowPushRanComment;
    public boolean isShowQCircleEnterFloatingWindow;
    public boolean isShowQrcode;
    public boolean isShowQrcodeSave;
    public boolean isShowReport;
    public boolean isShowSave;
    public boolean isShowSetQQProfileCover;
    public boolean isShowSetToPrivatePermission;
    public boolean isShowSetToPublicPermission;
    public boolean isShowShareToChannel;
    public boolean isShowShareToChannelAtLast;
    public boolean isShowShareToFriend;
    public boolean isShowShareToQZone;
    public boolean isShowShareToWechat;
    public boolean isShowShareToWechatCircle;
    public boolean isShowStick;
    public boolean isShowUnCollect;
    public boolean isShowUnStick;
    public boolean isShowWatchLater;

    public ShareConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isShowShareToChannelAtLast = false;
            this.isForceNightTheme = false;
        }
    }
}
