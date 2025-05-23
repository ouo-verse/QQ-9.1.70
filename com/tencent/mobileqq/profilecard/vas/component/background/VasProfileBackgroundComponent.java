package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

/* loaded from: classes16.dex */
public class VasProfileBackgroundComponent extends AbsVasProfileBackgroundComponent {
    private RelativeLayout mBackgroundVideoView;
    private ImageView mBackgroundView;
    private VasCardData mCardData;
    private Drawable mCurBgDrawable;
    private String mCurBgFile;
    private Vector<Drawable> mNeedToRecycleBgList;
    private ImageView mNumberView;
    private RelativeLayout mRootView;
    private String mUin;
    private IThemeVideoController mVideoPlayer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class UserGldrawable {
        private Drawable bgDrawable;
        private long bgId;
        private String dynamicFileDirectory;
        private boolean myResult;

        public UserGldrawable(long j3, String str, Drawable drawable) {
            this.bgId = j3;
            this.dynamicFileDirectory = str;
            this.bgDrawable = drawable;
        }

        public Drawable getBgDrawable() {
            return this.bgDrawable;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0074  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UserGldrawable invoke() {
            boolean z16;
            if (VasToggle.isEnable(VasToggle.GLDRAWABLE, true)) {
                String str = ProfileCardManager.t(((AbsComponent) VasProfileBackgroundComponent.this).mActivity, this.bgId) + "dynamicVideo.mp4";
                if (!new File(str).exists()) {
                    str = this.dynamicFileDirectory + "/video.mp4";
                    if (!new File(str).exists()) {
                        z16 = false;
                        QLog.d(VasProfileBackgroundComponent.this.getTAG(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", str, Boolean.valueOf(z16)));
                        if (z16) {
                            if (VasProfileBackgroundComponent.this.mCurBgDrawable != null && TextUtils.equals(VasProfileBackgroundComponent.this.mCurBgFile, str) && (VasProfileBackgroundComponent.this.mCurBgDrawable instanceof IGLDrawable)) {
                                QLog.i(VasProfileBackgroundComponent.this.getTAG(), 2, "initProfileCardBackground use old video-drawable");
                                this.myResult = true;
                                return this;
                            }
                            IGLDrawable fromFile = GLDrawableApi.factory().fromFile(new File(str));
                            this.bgDrawable = fromFile;
                            if (fromFile != null) {
                                if (fromFile instanceof IGLDrawable) {
                                    fromFile.setLockWH(true);
                                }
                                VasProfileBackgroundComponent.this.mCurBgFile = str;
                                QLog.i(VasProfileBackgroundComponent.this.getTAG(), 2, "initProfileCardBackground use new video-drawable");
                            }
                        }
                    }
                }
                z16 = true;
                QLog.d(VasProfileBackgroundComponent.this.getTAG(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", str, Boolean.valueOf(z16)));
                if (z16) {
                }
            }
            this.myResult = false;
            return this;
        }

        boolean is() {
            return this.myResult;
        }
    }

    public VasProfileBackgroundComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super("VasProfileBackgroundComponent", iComponentCenter, profileCardInfo);
        this.mNeedToRecycleBgList = new Vector<>();
        this.mCurBgDrawable = null;
        this.mCurBgFile = null;
        this.mCardData = null;
        this.mUin = "";
        Card card = profileCardInfo.card;
        if (card != null) {
            this.mUin = card.uin;
        }
    }

    private void clearBackgroundCache() {
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, String.format("clearBGCache size=%s", Integer.valueOf(this.mNeedToRecycleBgList.size())));
        }
        Iterator<Drawable> it = this.mNeedToRecycleBgList.iterator();
        while (it.hasNext()) {
            Drawable next = it.next();
            if (next instanceof FriendProfileCardBgDrawable) {
                ((FriendProfileCardBgDrawable) next).l();
            } else if (next instanceof IGLDrawable) {
                ((IGLDrawable) next).recycle();
            }
        }
        this.mNeedToRecycleBgList.clear();
    }

    private String getVideoPath(String str, long j3) {
        boolean z16;
        boolean z17 = true;
        if (VasNormalToggle.BUG_PROFILE_DIY.isEnable(true)) {
            if (j3 != 160 && j3 != 1600) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
        }
        String str2 = ProfileCardManager.t(this.mActivity, j3) + "dynamicVideo.mp4";
        if (!new File(str2).exists()) {
            str2 = str + "/video.mp4";
            if (!new File(str2).exists()) {
                z17 = false;
            }
        }
        if (!z17) {
            return null;
        }
        return str2;
    }

    private boolean iniProfileCaardBackground(FriendProfileCardBgDrawable friendProfileCardBgDrawable) {
        Drawable drawable = this.mCurBgDrawable;
        if (drawable != null && (drawable instanceof FriendProfileCardBgDrawable)) {
            Bitmap i3 = friendProfileCardBgDrawable.i();
            Bitmap i16 = ((FriendProfileCardBgDrawable) this.mCurBgDrawable).i();
            if (i16 != null && i16 == i3) {
                if (QLog.isColorLevel()) {
                    QLog.i(getTAG(), 2, "initProfileCardBackground newBitmap == currentBitmap");
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[Catch: all -> 0x014b, TryCatch #0 {all -> 0x014b, blocks: (B:9:0x004c, B:11:0x0056, B:16:0x0066, B:17:0x007d, B:21:0x00dc, B:23:0x00e2, B:24:0x00f6, B:26:0x0109, B:29:0x0129, B:33:0x013a, B:35:0x0136, B:36:0x0141, B:39:0x008f, B:41:0x0097, B:44:0x00bf, B:45:0x006f), top: B:8:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2 A[Catch: all -> 0x014b, TryCatch #0 {all -> 0x014b, blocks: (B:9:0x004c, B:11:0x0056, B:16:0x0066, B:17:0x007d, B:21:0x00dc, B:23:0x00e2, B:24:0x00f6, B:26:0x0109, B:29:0x0129, B:33:0x013a, B:35:0x0136, B:36:0x0141, B:39:0x008f, B:41:0x0097, B:44:0x00bf, B:45:0x006f), top: B:8:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0109 A[Catch: all -> 0x014b, TryCatch #0 {all -> 0x014b, blocks: (B:9:0x004c, B:11:0x0056, B:16:0x0066, B:17:0x007d, B:21:0x00dc, B:23:0x00e2, B:24:0x00f6, B:26:0x0109, B:29:0x0129, B:33:0x013a, B:35:0x0136, B:36:0x0141, B:39:0x008f, B:41:0x0097, B:44:0x00bf, B:45:0x006f), top: B:8:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0141 A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #0 {all -> 0x014b, blocks: (B:9:0x004c, B:11:0x0056, B:16:0x0066, B:17:0x007d, B:21:0x00dc, B:23:0x00e2, B:24:0x00f6, B:26:0x0109, B:29:0x0129, B:33:0x013a, B:35:0x0136, B:36:0x0141, B:39:0x008f, B:41:0x0097, B:44:0x00bf, B:45:0x006f), top: B:8:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f A[Catch: all -> 0x014b, TryCatch #0 {all -> 0x014b, blocks: (B:9:0x004c, B:11:0x0056, B:16:0x0066, B:17:0x007d, B:21:0x00dc, B:23:0x00e2, B:24:0x00f6, B:26:0x0109, B:29:0x0129, B:33:0x013a, B:35:0x0136, B:36:0x0141, B:39:0x008f, B:41:0x0097, B:44:0x00bf, B:45:0x006f), top: B:8:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean initProfileCardBackground(VasCardData vasCardData) {
        boolean z16;
        String n3;
        String str;
        String str2;
        boolean isFile;
        long lCurrentBgId;
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, String.format("initProfileCardBackground styleId=%s bgId=%s url=%s strZipUrl=%s heroUrl=%s", Long.valueOf(vasCardData.getLCurrentStyleId()), Long.valueOf(vasCardData.getLCurrentBgId()), vasCardData.getBackgroundUrl(), vasCardData.getStrZipUrl(), vasCardData.getStrWzryHeroUrl()));
        }
        if (!TextUtils.isEmpty(vasCardData.getBackgroundUrl())) {
            try {
                if (vasCardData.getLCurrentBgId() != 160 && vasCardData.getLCurrentBgId() != 1600) {
                    z16 = false;
                    if (!z16) {
                        n3 = ProfileCardUtil.u(vasCardData.getBackgroundUrl());
                    } else {
                        n3 = ProfileCardManager.n(this.mActivity, vasCardData.getLCurrentStyleId(), vasCardData.getLCurrentBgId());
                    }
                    str = "";
                    if (!TextUtils.isEmpty(vasCardData.getStrZipUrl()) && (!z16 || !VasNormalToggle.BUG_PROFILE_DIY.isEnable(true))) {
                        str2 = ProfileCardManager.t(this.mActivity, vasCardData.getLCurrentBgId()) + "dynamicBottom.jpg";
                        if (new File(str2).exists()) {
                            n3 = str2;
                        }
                        str = ProfileCardManager.t(this.mActivity, vasCardData.getLCurrentBgId()) + ".dynamic";
                    }
                    String str3 = n3;
                    String str4 = str;
                    if (QLog.isColorLevel()) {
                        QLog.d(getTAG(), 2, String.format("initProfileCardBackground fileName=%s dynamicFileDirectory=%s", str3, str4));
                    }
                    File file = new File(str3);
                    isFile = file.isFile();
                    boolean exists = file.exists();
                    if (QLog.isColorLevel()) {
                        QLog.d(getTAG(), 2, String.format("initProfileCardBackground isFile=%s exists=%s", Boolean.valueOf(isFile), Boolean.valueOf(exists)));
                    }
                    if (isFile && exists) {
                        if (!VasNormalToggle.BUG_PROFILE_DIY_2.isEnable(true)) {
                            if (z16) {
                                lCurrentBgId = 0;
                            } else {
                                lCurrentBgId = vasCardData.getLCurrentBgId();
                            }
                            return loadBackground(lCurrentBgId, str3, str4, file);
                        }
                        return loadBackground(vasCardData.getLCurrentBgId(), str3, str4, file);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                str = "";
                if (!TextUtils.isEmpty(vasCardData.getStrZipUrl())) {
                    str2 = ProfileCardManager.t(this.mActivity, vasCardData.getLCurrentBgId()) + "dynamicBottom.jpg";
                    if (new File(str2).exists()) {
                    }
                    str = ProfileCardManager.t(this.mActivity, vasCardData.getLCurrentBgId()) + ".dynamic";
                }
                String str32 = n3;
                String str42 = str;
                if (QLog.isColorLevel()) {
                }
                File file2 = new File(str32);
                isFile = file2.isFile();
                boolean exists2 = file2.exists();
                if (QLog.isColorLevel()) {
                }
                if (isFile) {
                    if (!VasNormalToggle.BUG_PROFILE_DIY_2.isEnable(true)) {
                    }
                }
            } catch (Throwable th5) {
                QLog.e(getTAG(), 1, "initProfileCardBackground fail.", th5);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.graphics.drawable.ColorDrawable] */
    private boolean loadBackground(long j3, String str, String str2, File file) {
        Boolean bool = ProfileCardManager.f259994i.get(Long.valueOf(j3));
        if (bool != null && bool.booleanValue()) {
            ImageCacheHelper.f98636a.m("profilecard:" + str);
            ProfileCardManager.f259994i.remove(Long.valueOf(j3));
        }
        FriendProfileCardBgDrawable friendProfileCardBgDrawable = null;
        if (VasNormalToggle.VAS_CHANGE_GLD_2_NATIVE.isEnable(true)) {
            String videoPath = getVideoPath(str2, j3);
            if (!TextUtils.isEmpty(videoPath)) {
                if (TextUtils.equals(this.mCurBgFile, videoPath)) {
                    QLog.i(getTAG(), 2, "loadBackground use old video-drawable");
                    return true;
                }
                this.mCurBgFile = videoPath;
                ?? colorDrawable = new ColorDrawable();
                QLog.i(getTAG(), 2, "loadBackground use new video player");
                friendProfileCardBgDrawable = colorDrawable;
            }
        } else {
            UserGldrawable invoke = new UserGldrawable(j3, str2, null).invoke();
            if (invoke.is()) {
                return true;
            }
            friendProfileCardBgDrawable = invoke.getBgDrawable();
        }
        if (friendProfileCardBgDrawable == null) {
            this.mCurBgFile = null;
            friendProfileCardBgDrawable = ProfileCardUtil.v(this.mActivity.getResources(), str2, str);
            if (iniProfileCaardBackground(friendProfileCardBgDrawable)) {
                return true;
            }
        }
        Drawable drawable = this.mCurBgDrawable;
        if (drawable != null) {
            this.mNeedToRecycleBgList.add(drawable);
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, String.format("initProfileCardBackground bgDrawable=%s", friendProfileCardBgDrawable));
        }
        this.mCurBgDrawable = friendProfileCardBgDrawable;
        return true;
    }

    private void releaseBackground() {
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "releaseBackground");
        }
        Drawable drawable = this.mCurBgDrawable;
        if (drawable != null) {
            if (drawable instanceof FriendProfileCardBgDrawable) {
                ((FriendProfileCardBgDrawable) drawable).l();
            }
            Drawable drawable2 = this.mCurBgDrawable;
            if (drawable2 instanceof IGLDrawable) {
                ((IGLDrawable) drawable2).recycle();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mRootView = new RelativeLayout(qBaseActivity);
        this.mBackgroundView = new ImageView(qBaseActivity);
        this.mBackgroundVideoView = new RelativeLayout(qBaseActivity);
        this.mNumberView = new ImageView(qBaseActivity);
        this.mRootView.addView(this.mBackgroundView, -1, -1);
        this.mRootView.addView(this.mBackgroundVideoView, -1, -1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0f);
        layoutParams.topMargin = ImmersiveUtils.dpToPx(100.0f);
        this.mRootView.addView(this.mNumberView, layoutParams);
        ((FrameLayout) this.mViewContainer).addView(this.mRootView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        IThemeVideoController iThemeVideoController = this.mVideoPlayer;
        if (iThemeVideoController != null) {
            iThemeVideoController.release();
        }
        clearBackgroundCache();
        releaseBackground();
        ((FrameLayout) this.mViewContainer).removeView(this.mRootView);
        this.mBackgroundView = null;
        this.mBackgroundVideoView = null;
        this.mNumberView = null;
        this.mRootView = null;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
    public boolean onVasDataUpdate(VasProfileData vasProfileData) {
        Drawable drawable = null;
        if (VasNormalToggle.VAS_BUG_117441308.isEnable(true) && this.mActivity == null) {
            onCreate((QBaseActivity) Foreground.getTopActivity(), null);
        }
        if (vasProfileData.getCurrentTemplate() == null) {
            this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
            return true;
        }
        VipData vipDataForFriends = b.a().getVipDataForFriends(this.mUin);
        int lCurrentBgId = (int) vasProfileData.getCardData().getLCurrentBgId();
        VipData.VipNumberInfo vipNumberInfo = vipDataForFriends.getVipNumberInfo(VipData.VipNumberInfo.APPID.ProfileCard, lCurrentBgId);
        if (vipNumberInfo != null) {
            this.mNumberView.setImageDrawable(((IVipNumberDrawable) QRoute.api(IVipNumberDrawable.class)).newBigDrawable(vipNumberInfo.getNumberItemId(), vipNumberInfo.getNumberIdx(), vipNumberInfo.isLongNumber()));
            VasLogNtReporter.getVipNumber().reportLow(String.format("profilecard[%d] number_id[%d] number[%d]", Integer.valueOf(lCurrentBgId), Integer.valueOf(vipNumberInfo.getNumberItemId()), Integer.valueOf(vipNumberInfo.getNumberIdx())));
        } else {
            this.mNumberView.setImageDrawable(null);
        }
        if (vasProfileData.getCardData().equals(this.mCardData) && getIsBackgroundShow()) {
            return true;
        }
        VasCardData cardData = vasProfileData.getCardData();
        this.mCardData = cardData;
        boolean initProfileCardBackground = initProfileCardBackground(cardData);
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "onCardUpdate initConfigResult=" + initProfileCardBackground);
        }
        if (VasNormalToggle.VAS_CHANGE_GLD_2_NATIVE.isEnable(true) && !TextUtils.isEmpty(this.mCurBgFile) && new File(this.mCurBgFile).exists()) {
            IThemeVideoController iThemeVideoController = this.mVideoPlayer;
            if (iThemeVideoController == null || !iThemeVideoController.isSameFile(this.mCurBgFile)) {
                IThemeVideoController iThemeVideoController2 = this.mVideoPlayer;
                if (iThemeVideoController2 != null) {
                    iThemeVideoController2.release();
                }
                QBaseActivity qBaseActivity = this.mActivity;
                if (qBaseActivity != null) {
                    drawable = qBaseActivity.getDrawable(getDefaultResourceID());
                }
                this.mVideoPlayer = ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).newLoopVideoController(this.mCurBgFile, drawable, this.mBackgroundVideoView);
            }
            setBackgroundShow(true);
            QLog.i(getTAG(), 1, "set native video player:" + this.mCurBgFile);
            return true;
        }
        Drawable drawable2 = this.mCurBgDrawable;
        if (drawable2 != null) {
            this.mBackgroundView.setBackgroundDrawable(drawable2);
            setBackgroundShow(true);
        } else {
            this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
            setBackgroundShow(false);
        }
        return true;
    }
}
