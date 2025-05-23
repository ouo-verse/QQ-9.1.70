package com.tencent.mobileqq.profilecard.base.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.av.utils.ba;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.h;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor;
import com.tencent.mobileqq.config.business.sigtopic.a;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dating.j;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profile.k;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.c;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantFileUtil;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.mobileqq.widget.bo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$TopicItem;

/* loaded from: classes16.dex */
public abstract class AbsProfileHeaderView extends RelativeLayout implements ITopic.OnTopicClickListener, XListView.MotionEventInterceptor {
    static IPatchRedirector $redirector_ = null;
    protected static final String DESCRIPTION_INCREASE_VOTE = "\uff0c\u65b0\u589e%d\u8d5e";
    private static final int MSG_CHECK_TIPS = 1000;
    private static final int MSG_UPDATE_PENDANT = 1003;
    private static final int PROFILE_FLAG_SET_CARD = 2;
    public static String TAG;
    private long curHeadTimestamp;
    private boolean hasAsyncUpdateHdAvatar;
    private WeakReference<URLDrawable> hdDrawableRef;
    protected QBaseActivity mActivity;
    protected QQAppInterface mApp;
    protected ProfileCardInfo mCardInfo;
    public int mCoverTimeStamp;
    public String mCoverUrl;
    protected float mDensity;
    protected BusinessObserver mDiyPendantObserver;
    private boolean mHasSendUpdateTips;
    private float mHeaderAvailableWidth;
    protected HashMap<String, View> mHeaderChildMap;
    private IVasLiangNum.b mLiangIdChangedListener;
    protected j mNewVoteAnimHelper;
    protected View.OnClickListener mOnClickListener;
    protected long mPendantId;
    protected float mScreenHeight;
    protected float mScreenWidth;
    private AtomicBoolean mSetCardChecked;
    private int mTipsFlags;
    private Handler.Callback mUICallback;
    protected MqqWeakReferenceHandler mUIHandler;
    protected IProfileViewLoader mViewLoader;
    protected ITemplateUtils templateUtils;

    /* loaded from: classes16.dex */
    private static class AvatarUpdateObserver implements BusinessObserver {
        static IPatchRedirector $redirector_;
        private WeakReference<AbsProfileHeaderView> mViewRef;

        public AvatarUpdateObserver(AbsProfileHeaderView absProfileHeaderView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) absProfileHeaderView);
            } else {
                this.mViewRef = new WeakReference<>(absProfileHeaderView);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (z16 && i3 == 62 && (obj instanceof Set)) {
                Set set = (Set) obj;
                AbsProfileHeaderView absProfileHeaderView = this.mViewRef.get();
                if (absProfileHeaderView != null && set.contains(absProfileHeaderView.mCardInfo.allInOne.uin)) {
                    absProfileHeaderView.updateAvatarPendantImage(absProfileHeaderView.mCardInfo, false);
                    absProfileHeaderView.mApp.removeObserver(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class UpdateProfileSetCardTask implements Runnable {
        static IPatchRedirector $redirector_;
        private WeakReference<AbsProfileHeaderView> mHeaderViewRef;

        UpdateProfileSetCardTask(AbsProfileHeaderView absProfileHeaderView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) absProfileHeaderView);
            } else {
                this.mHeaderViewRef = new WeakReference<>(absProfileHeaderView);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0139 A[Catch: Exception -> 0x013d, TRY_LEAVE, TryCatch #0 {Exception -> 0x013d, blocks: (B:9:0x000f, B:11:0x0019, B:13:0x0053, B:22:0x006d, B:26:0x0098, B:27:0x009a, B:29:0x00ab, B:30:0x00dd, B:32:0x00e3, B:36:0x00ed, B:38:0x00f3, B:39:0x00fe, B:40:0x012f, B:42:0x0139, B:46:0x010f, B:47:0x008e, B:48:0x0117, B:49:0x011f), top: B:8:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Card r16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                AbsProfileHeaderView absProfileHeaderView = this.mHeaderViewRef.get();
                if (absProfileHeaderView != null) {
                    QQAppInterface qQAppInterface = absProfileHeaderView.mApp;
                    ProfileCardInfo profileCardInfo = absProfileHeaderView.mCardInfo;
                    Card card = profileCardInfo.card;
                    long j3 = card.lCurrentStyleId;
                    long j16 = card.lCurrentBgId;
                    int i3 = card.templateRet;
                    String str = profileCardInfo.allInOne.uin;
                    ArrayList<Integer> bgTypeArray = card.getBgTypeArray();
                    SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("ProfileCardTips" + qQAppInterface.getCurrentAccountUin(), 0);
                    if (!ProfileCardUtil.R(bgTypeArray) && profileCardInfo.card.lCurrentBgId != 160) {
                        if (str != null) {
                            long j17 = 0;
                            if (j16 > 0 && j3 > 0 && i3 == 0) {
                                String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(System.currentTimeMillis()));
                                FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                if (friendsManager == null) {
                                    r16 = null;
                                } else {
                                    r16 = friendsManager.r(qQAppInterface.getCurrentAccountUin());
                                }
                                if (r16 != null) {
                                    j17 = r16.lCurrentBgId;
                                }
                                String string = sharedPreferences.getString(String.valueOf(j16), "");
                                if (QLog.isColorLevel()) {
                                    QLog.d(AbsProfileHeaderView.TAG, 2, "updateSetCardBar today=" + format + ",userLastAccessDay=" + string + ",friendBackgroundId=" + j16 + ",myBackgroundId=" + j17);
                                }
                                if (!TextUtils.isEmpty(format) && !format.equals(string) && j17 != j16) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    if (edit != null) {
                                        edit.putString(String.valueOf(j16), format).commit();
                                    }
                                    absProfileHeaderView.mTipsFlags = 2 | absProfileHeaderView.mTipsFlags;
                                    qQAppInterface.runOnUiThread(new Runnable(absProfileHeaderView) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask.1
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ AbsProfileHeaderView val$headerView;

                                        {
                                            this.val$headerView = absProfileHeaderView;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UpdateProfileSetCardTask.this, (Object) absProfileHeaderView);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            try {
                                                if (this.val$headerView.mHeaderChildMap != null) {
                                                    ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
                                                    View view = this.val$headerView.mHeaderChildMap.get("map_key_tips_set_card");
                                                    TextView textView = (TextView) view.findViewById(R.id.czx);
                                                    ImageView imageView = (ImageView) view.findViewById(R.id.czj);
                                                    Resources resources = view.getResources();
                                                    textView.setText(resources.getString(R.string.f173213i33));
                                                    imageView.setContentDescription(resources.getString(R.string.f173213i33));
                                                    view.setTag(new com.tencent.mobileqq.profile.b(29, "CLICK_BANNER"));
                                                    view.setOnClickListener(this.val$headerView.mOnClickListener);
                                                    this.val$headerView.mSetCardChecked.set(true);
                                                    this.val$headerView.checkTips();
                                                }
                                            } catch (Exception e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                    });
                                } else {
                                    absProfileHeaderView.mSetCardChecked.set(true);
                                }
                                if (absProfileHeaderView.mSetCardChecked.get()) {
                                    absProfileHeaderView.checkTips();
                                    return;
                                }
                                return;
                            }
                        }
                        absProfileHeaderView.mSetCardChecked.set(true);
                        if (absProfileHeaderView.mSetCardChecked.get()) {
                        }
                    }
                    absProfileHeaderView.mTipsFlags &= -3;
                    absProfileHeaderView.mSetCardChecked.set(true);
                    if (absProfileHeaderView.mSetCardChecked.get()) {
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            TAG = "AbsProfileHeaderView";
        }
    }

    public AbsProfileHeaderView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) profileCardInfo);
            return;
        }
        this.mHeaderChildMap = new HashMap<>();
        this.mTipsFlags = 0;
        this.mHasSendUpdateTips = false;
        this.mSetCardChecked = new AtomicBoolean(false);
        this.mCoverTimeStamp = 0;
        this.curHeadTimestamp = 0L;
        this.hasAsyncUpdateHdAvatar = false;
        this.mViewLoader = null;
        this.mLiangIdChangedListener = new IVasLiangNum.b() { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this);
                }
            }

            @Override // com.tencent.mobileqq.vas.api.IVasLiangNum.b
            public void onChanged() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            AbsProfileHeaderView absProfileHeaderView = AbsProfileHeaderView.this;
                            ProfileCardInfo profileCardInfo2 = absProfileHeaderView.mCardInfo;
                            if (profileCardInfo2 != null) {
                                absProfileHeaderView.updateUinInfo(profileCardInfo2, profileCardInfo2.card.uin);
                            }
                        }
                    });
                }
            }
        };
        this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AbsProfileHeaderView.TAG, 2, String.format("handleMessage msg.what=%s", Integer.valueOf(message.what)));
                }
                int i3 = message.what;
                if (1000 == i3) {
                    if (AbsProfileHeaderView.this.mSetCardChecked.get()) {
                        AbsProfileHeaderView absProfileHeaderView = AbsProfileHeaderView.this;
                        absProfileHeaderView.updateTips(absProfileHeaderView.mCardInfo);
                    }
                } else {
                    if (1003 != i3 || ProAvatarComponentUtils.m()) {
                        return true;
                    }
                    View view = AbsProfileHeaderView.this.mHeaderChildMap.get("map_key_avatar_pendant");
                    if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        kx3.a aVar = (kx3.a) message.obj;
                        if (aVar != null && aVar.getPendantId() != 0) {
                            AbsProfileHeaderView.this.mPendantId = aVar.getPendantId();
                            imageView.setVisibility(0);
                            com.tencent.mobileqq.vas.b bVar = (com.tencent.mobileqq.vas.b) AbsProfileHeaderView.this.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
                            if (bVar != null) {
                                bVar.getPendantInfo(AbsProfileHeaderView.this.mPendantId).setDrawable(imageView, 2, PendantConstant.PENDANT_TARGET_ID_PROFILE, aVar.getUin(), aVar.getPendantDiyId());
                            }
                        } else {
                            imageView.setVisibility(4);
                            AbsProfileHeaderView.this.mPendantId = 0L;
                        }
                    }
                }
                return true;
            }
        };
        this.mDiyPendantObserver = new AvatarUpdateObserver(this);
        this.mActivity = qBaseActivity;
        this.mApp = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.mCardInfo = profileCardInfo;
        this.mUIHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mScreenWidth = Math.min(r4.widthPixels, r4.heightPixels);
        this.mScreenHeight = Math.max(r4.widthPixels, r4.heightPixels);
        this.mPendantId = 0L;
        this.mHeaderAvailableWidth = this.mScreenWidth - ScreenUtil.dip2px(127.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTips() {
        MqqWeakReferenceHandler mqqWeakReferenceHandler;
        if (this.mSetCardChecked.get() && (mqqWeakReferenceHandler = this.mUIHandler) != null && !this.mHasSendUpdateTips) {
            this.mHasSendUpdateTips = true;
            Message obtainMessage = mqqWeakReferenceHandler.obtainMessage(1000);
            if (obtainMessage != null) {
                this.mUIHandler.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAvatarMask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof FaceDrawable) {
                ((FaceDrawable) drawable).setSupportMaskView(false);
            }
        }
    }

    private SpannableStringBuilder constructSignSpan(ProfileCardInfo profileCardInfo, SpannableString spannableString, TextView textView) {
        Bitmap bitmap;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            spannableStringBuilder.insert(0, (CharSequence) "[S] ");
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.qq_profilecard_signature_edit);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                bitmap = null;
                bo boVar = new bo(getResources(), bitmap, false, false);
                int textSize = (int) (textView.getTextSize() + 0.5f);
                boVar.setBounds(0, 0, textSize, textSize);
                OffsetableImageSpan offsetableImageSpan = new OffsetableImageSpan(boVar, 0);
                offsetableImageSpan.setOffset(-0.1f);
                spannableStringBuilder.setSpan(offsetableImageSpan, 0, 3, 17);
                return spannableStringBuilder;
            } catch (Throwable th5) {
                th5.printStackTrace();
                bitmap = null;
                bo boVar2 = new bo(getResources(), bitmap, false, false);
                int textSize2 = (int) (textView.getTextSize() + 0.5f);
                boVar2.setBounds(0, 0, textSize2, textSize2);
                OffsetableImageSpan offsetableImageSpan2 = new OffsetableImageSpan(boVar2, 0);
                offsetableImageSpan2.setOffset(-0.1f);
                spannableStringBuilder.setSpan(offsetableImageSpan2, 0, 3, 17);
                return spannableStringBuilder;
            }
            bo boVar22 = new bo(getResources(), bitmap, false, false);
            int textSize22 = (int) (textView.getTextSize() + 0.5f);
            boVar22.setBounds(0, 0, textSize22, textSize22);
            OffsetableImageSpan offsetableImageSpan22 = new OffsetableImageSpan(boVar22, 0);
            offsetableImageSpan22.setOffset(-0.1f);
            spannableStringBuilder.setSpan(offsetableImageSpan22, 0, 3, 17);
        }
        return spannableStringBuilder;
    }

    private void dealTextViewForCopyAction(TextView textView, ProfileCardInfo profileCardInfo, Card card, String str, String str2) {
        textView.setVisibility(0);
        textView.setSingleLine(true);
        PrettyAccountUtil.setAccountText(textView, PrettyAccountUtil.isPrettyOpenForCard(card), card.lhLevel, str2, card.uin, card.liangNameplateId, PrettyAccountUtil.calLiangNumTopMargin(textView.getContext(), profileCardInfo, card));
        textView.setOnTouchListener(ba.f77070d);
        textView.setOnClickListener(new View.OnClickListener(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ ProfileCardInfo val$cardInfo;

            {
                this.val$cardInfo = profileCardInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this, (Object) profileCardInfo);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AbsProfileHeaderView.this.openMoreDetailActivity(this.val$cardInfo);
                    PrettyAccountUtil.reportLhEventForCard(AbsProfileHeaderView.this.mApp, this.val$cardInfo, true);
                    ProfileCardDtReportUtil.dtReportClick(view);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ProfileCardUtil.e(textView, card.uin, str);
    }

    private String handleNickNameAndNumber(TextView textView, String str, String str2, boolean z16) {
        updateNickInfo(str);
        if (textView != null && !TextUtils.isEmpty(str2)) {
            return String.format("QQ\u53f7\uff1a%s", str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeAccountSimpleInfoForTroopMember$0(ProfileCardInfo profileCardInfo, String str, TextView textView, Card card) {
        String handleNickNameAndNumber;
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && troopManager.V(profileCardInfo.troopUin)) {
            handleNickNameAndNumber = str;
        } else {
            handleNickNameAndNumber = handleNickNameAndNumber(textView, str, card.uin, !card.isNoCover());
        }
        dealTextViewForCopyAction(textView, profileCardInfo, card, str, handleNickNameAndNumber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeAccountSimpleInfoForTroopMember$1(final Card card, final ProfileCardInfo profileCardInfo, final TextView textView, TroopMemberInfo troopMemberInfo) {
        String str;
        if (troopMemberInfo != null && TextUtils.isEmpty(troopMemberInfo.troopnick) && !TextUtils.isEmpty(card.strReMark)) {
            str = card.strNick;
        } else if (TextUtils.isEmpty(card.strReMark)) {
            str = card.strNick;
        } else {
            str = card.strReMark;
        }
        if (TextUtils.isEmpty(str)) {
            str = ac.g(this.mApp, card.uin, false);
        }
        final String str2 = str;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.view.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsProfileHeaderView.this.lambda$makeAccountSimpleInfoForTroopMember$0(profileCardInfo, str2, textView, card);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
    
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
    
        if (r12 >= r13) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
    
        if (r13 != r8) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
    
        r3 = com.tencent.mobileqq.util.ProfileCardUtil.T(r3, r12, r13, "  ", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cb, code lost:
    
        if (r10.length() <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
    
        r10.append((java.lang.CharSequence) "\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d0, code lost:
    
        r10.append((java.lang.CharSequence) r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeAccountDetailInfo(TextView textView, ProfileCardInfo profileCardInfo) {
        boolean z16;
        if (profileCardInfo != null && textView != null) {
            List<SpannableString> W = ProfileCardUtil.W(this.mApp, this.mActivity, profileCardInfo);
            boolean isEmpty = W.isEmpty();
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne != null && allInOne.f260789pa == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (isEmpty && z16) {
                W.add(new SpannableString(this.mActivity.getString(R.string.fpz)));
            }
            if (!W.isEmpty()) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int size = W.size();
                SpannableStringBuilder T = ProfileCardUtil.T(W, 0, size, "  ", spannableStringBuilder);
                TextPaint paint = textView.getPaint();
                if (paint == null) {
                    paint = new TextPaint(1);
                    paint.density = this.mDensity;
                }
                if (paint.measureText(T, 0, T.length() - 1) > this.mHeaderAvailableWidth) {
                    T = new SpannableStringBuilder();
                    int i3 = 0;
                    int i16 = 1;
                    while (true) {
                        SpannableStringBuilder T2 = ProfileCardUtil.T(W, i3, i16, "  ", spannableStringBuilder);
                        if (paint.measureText(T2, 0, T2.length() - 1) < this.mHeaderAvailableWidth) {
                            i16++;
                        } else if (i16 - i3 == 1) {
                            SpannableStringBuilder T3 = ProfileCardUtil.T(W, i3, size, "  ", spannableStringBuilder);
                            if (T.length() > 0) {
                                T.append((CharSequence) "\n");
                            }
                            T.append((CharSequence) T3);
                        } else {
                            int i17 = i16 - 1;
                            SpannableStringBuilder T4 = ProfileCardUtil.T(W, i3, i17, "  ", spannableStringBuilder);
                            if (T.length() > 0) {
                                T.append((CharSequence) "\n");
                            }
                            T.append((CharSequence) T4);
                            i3 = i17;
                        }
                        if (i3 < 0 || i16 > size || i3 >= i16) {
                            break;
                        }
                    }
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((View) textView.getParent()).getLayoutParams();
                marginLayoutParams.rightMargin = 0;
                ((View) textView.getParent()).setLayoutParams(marginLayoutParams);
                textView.setVisibility(0);
                textView.setSingleLine(true);
                textView.setText(T);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setOnTouchListener(ba.f77070d);
                textView.setOnClickListener(new View.OnClickListener(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.12
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProfileCardInfo val$cardInfo;

                    {
                        this.val$cardInfo = profileCardInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this, (Object) profileCardInfo);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            AbsProfileHeaderView.this.openMoreDetailActivity(this.val$cardInfo);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                if (!isEmpty) {
                    ProfileCardUtil.e(textView, null, null);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
        }
    }

    private void makeAccountDetailInfoForQQCircle(LinearLayout linearLayout, ProfileCardInfo profileCardInfo) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle");
        }
        if (profileCardInfo != null && linearLayout != null) {
            linearLayout.removeAllViews();
            List<Pair<String, String>> V = ProfileCardUtil.V(this.mActivity, profileCardInfo);
            boolean isEmpty = V.isEmpty();
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne != null && allInOne.f260789pa == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (isEmpty && z16) {
                V.add(Pair.create(this.mActivity.getString(R.string.fpz), ""));
            }
            if (!V.isEmpty()) {
                int size = V.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    Pair<String, String> pair = V.get(i3);
                    String str = (String) pair.first;
                    TextView textView = new TextView(this.mActivity);
                    textView.setText(str);
                    textView.setTextColor(getResources().getColor(R.color.skin_black));
                    if (!TextUtils.isEmpty((CharSequence) pair.second)) {
                        textView.setBackgroundResource(R.drawable.f161587kf4);
                        textView.setPadding(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.5f), ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.5f));
                    }
                    textView.setTextSize(14.0f);
                    linearLayout.addView(textView);
                    try {
                        ((LinearLayout.LayoutParams) textView.getLayoutParams()).rightMargin = ViewUtils.dpToPx(6.0f);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    linearLayout.measure(0, 0);
                    QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.mHeaderAvailableWidth + ", " + linearLayout.getMeasuredWidth());
                    if (linearLayout.getMeasuredWidth() > this.mHeaderAvailableWidth) {
                        linearLayout.removeView(textView);
                        break;
                    } else {
                        if (!isEmpty) {
                            ProfileCardUtil.e(textView, null, null);
                        }
                        i3++;
                    }
                }
                linearLayout.setOnTouchListener(ba.f77070d);
                linearLayout.setOnClickListener(new View.OnClickListener(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.13
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProfileCardInfo val$cardInfo;

                    {
                        this.val$cardInfo = profileCardInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this, (Object) profileCardInfo);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            AbsProfileHeaderView.this.openMoreDetailActivity(this.val$cardInfo);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    private void makeAccountSimpleInfo(TextView textView, ProfileCardInfo profileCardInfo) {
        Card card;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "makeAccountDetailInfo");
        }
        if (textView == null) {
            return;
        }
        if (profileCardInfo == null) {
            card = null;
        } else {
            card = profileCardInfo.card;
        }
        if (profileCardInfo != null && card != null && !ProfilePAUtils.isFromWholePeopleVote(profileCardInfo.allInOne) && !ProfilePAUtils.isFromExtendFriend(profileCardInfo.allInOne)) {
            textView.setVisibility(0);
            if (profileCardInfo.isTroopMemberCard) {
                makeAccountSimpleInfoForTroopMember(textView, profileCardInfo, card);
                return;
            } else {
                makeAccountSimpleInfoForFriend(textView, profileCardInfo, card);
                return;
            }
        }
        this.mHeaderChildMap.remove("map_key_uin_info");
        textView.setVisibility(8);
    }

    private void makeAccountSimpleInfoForFriend(TextView textView, ProfileCardInfo profileCardInfo, Card card) {
        boolean z16;
        String str;
        String str2;
        String[] strArr = profileCardInfo.nameArray;
        if (strArr != null && !TextUtils.isEmpty(strArr[5]) && !TextUtils.equals(profileCardInfo.nameArray[5], card.strNick)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (TextUtils.isEmpty(card.strReMark) && !z16) {
            str = String.format("QQ\u53f7\uff1a%s", card.uin);
            str2 = "";
        } else {
            String handleNickNameAndNumber = handleNickNameAndNumber(textView, card.strNick, card.uin, !card.isNoCover());
            String str3 = card.strNick;
            if (TextUtils.isEmpty(handleNickNameAndNumber)) {
                handleNickNameAndNumber = String.format("QQ\u53f7\uff1a%s", card.uin);
            }
            str = handleNickNameAndNumber;
            str2 = str3;
        }
        dealTextViewForCopyAction(textView, profileCardInfo, card, str2, str);
    }

    private void makeAccountSimpleInfoForTroopMember(final TextView textView, final ProfileCardInfo profileCardInfo, final Card card) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, card.uin, false, this.mActivity, TAG, new g() { // from class: com.tencent.mobileqq.profilecard.base.view.b
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                AbsProfileHeaderView.this.lambda$makeAccountSimpleInfoForTroopMember$1(card, profileCardInfo, textView, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMoreDetailActivity(ProfileCardInfo profileCardInfo) {
        int i3;
        if (profileCardInfo != null) {
            Card card = profileCardInfo.card;
            if (card != null && card.isForbidAccount) {
                QLog.i(TAG, 1, "openMoreDetailActivity but forbidAccount");
                return;
            }
            ProfileCardUtil.p0(profileCardInfo, this.mApp, this.mActivity);
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne != null && allInOne.f260789pa == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(this.mApp, "dc00898", "", "", "0X8009999", "0X8009999", i3, 0, "", "", "", "");
        }
    }

    private void recommendTopicViewControl(View view, boolean z16) {
        int i3;
        String str;
        if (view == null) {
            return;
        }
        if (!z16) {
            view.setVisibility(8);
            return;
        }
        if (!k.d().o(this.mApp)) {
            view.setVisibility(8);
            return;
        }
        com.tencent.mobileqq.config.business.sigtopic.a a16 = SigTopicConfProcessor.a();
        if (a16 != null && !a16.b()) {
            int i16 = 0;
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.id.md5);
            ImageView imageView = (ImageView) view.findViewById(R.id.dum);
            ArrayList<a.b> arrayList = a16.a().f202831f;
            textView.setText(k.d().g(a16));
            while (true) {
                if (i16 < a16.a().f202831f.size()) {
                    if (TextUtils.isEmpty(arrayList.get(i16).f202833b)) {
                        i16++;
                    } else {
                        i3 = arrayList.get(i16).f202832a;
                        str = arrayList.get(i16).f202833b;
                        break;
                    }
                } else {
                    i3 = -1;
                    str = "";
                    break;
                }
            }
            if (z16) {
                view.setOnClickListener(new View.OnClickListener(str, i3, view) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.14
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$recommendTagId;
                    final /* synthetic */ String val$recommendTagName;
                    final /* synthetic */ View val$topicView;

                    {
                        this.val$recommendTagName = str;
                        this.val$recommendTagId = i3;
                        this.val$topicView = view;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, AbsProfileHeaderView.this, str, Integer.valueOf(i3), view);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                        } else if (c.a(this.val$recommendTagName) && this.val$recommendTagId >= 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("key_sign_topic_name", this.val$recommendTagName);
                            bundle.putInt("key_sign_topic_id", this.val$recommendTagId);
                            bundle.putInt("from_type", 2);
                            AbsProfileHeaderView absProfileHeaderView = AbsProfileHeaderView.this;
                            if (absProfileHeaderView.mActivity != null && absProfileHeaderView.mApp != null) {
                                Intent intent = new Intent();
                                intent.putExtras(bundle);
                                intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
                                intent.setClass(AbsProfileHeaderView.this.mActivity, QPublicFragmentActivity.class);
                                AbsProfileHeaderView.this.mActivity.startActivityForResult(intent, -1);
                            }
                            this.val$topicView.setVisibility(8);
                            k.d().p(AbsProfileHeaderView.this.mApp);
                            ReportController.o(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
                        }
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(view) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.15
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View val$topicView;

                    {
                        this.val$topicView = view;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this, (Object) view);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                        } else {
                            k.d().p(AbsProfileHeaderView.this.mApp);
                            this.val$topicView.setVisibility(8);
                        }
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
            }
            ReportController.o(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
            return;
        }
        view.setVisibility(8);
    }

    private void setAvatar(QQProAvatarView qQProAvatarView, String str) {
        String str2;
        Card card;
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null && card.isForbidAccount) {
            str2 = "0";
        } else {
            str2 = str;
        }
        boolean z16 = !((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str);
        qQProAvatarView.x(1, str2, new e.a().e(z16).b(true).j(true).p(3).c(true).m(1).d(!SimpleUIUtil.isNowSimpleMode()).n(0).o(3).g(200).a());
        setFaceStoke(str2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFaceStoke(String str, boolean z16) {
        boolean z17;
        Card card;
        View view = this.mHeaderChildMap.get("map_key_face_stoke");
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            z17 = card.isNoCover();
        } else {
            z17 = false;
        }
        if (view != null) {
            if (z17 && !ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
                view.setVisibility(4);
            } else {
                view.setVisibility(VasFaceManager.h(str, this.mApp));
            }
            if (SimpleUIUtil.getSimpleUISwitch()) {
                view.setVisibility(4);
            }
            if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && z16) {
                view.setVisibility(4);
            }
            if (((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)) {
                view.setVisibility(4);
            }
        }
    }

    private void showVoteInner(ProfileCardInfo profileCardInfo, View view, boolean z16, int i3) {
        boolean z17;
        String format;
        int i16;
        boolean z18;
        Object obj;
        int i17 = 0;
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        if (profileCardInfo.card == null) {
            format = this.mActivity.getString(R.string.acw);
            obj = null;
            z18 = false;
            i16 = 0;
        } else {
            if (this.mNewVoteAnimHelper == null) {
                this.mNewVoteAnimHelper = new j(this.mActivity, this.mApp, 1, 1);
            }
            Card card = profileCardInfo.card;
            int i18 = (int) card.lVoteCount;
            int i19 = card.iVoteIncrement;
            this.mNewVoteAnimHelper.M = card.getLastPraiseInfoList();
            if (i19 <= this.mNewVoteAnimHelper.M.size()) {
                j jVar = this.mNewVoteAnimHelper;
                jVar.M = jVar.M.subList(0, i19);
            }
            j jVar2 = this.mNewVoteAnimHelper;
            jVar2.M = com.tencent.mobileqq.profile.like.c.b(jVar2.M);
            Card card2 = profileCardInfo.card;
            if (1 == card2.bVoted) {
                z17 = true;
            } else {
                z17 = false;
            }
            Object bVar = new com.tencent.mobileqq.profile.b(10, card2);
            if (z16) {
                format = String.format(this.mActivity.getString(R.string.acu), String.valueOf(i18));
            } else {
                format = String.format(this.mActivity.getString(R.string.aap), String.valueOf(i18));
                if (profileCardInfo.card.bAvailVoteCnt == 0) {
                    if (view instanceof VoteView) {
                        ((VoteView) view).f();
                    } else if (view instanceof VoteViewV2) {
                        ((VoteViewV2) view).m();
                    }
                }
            }
            if (i19 > 0) {
                format = format.concat(String.format(DESCRIPTION_INCREASE_VOTE, Integer.valueOf(i19)));
            }
            i16 = i18;
            i17 = i19;
            z18 = z17;
            obj = bVar;
        }
        if (view instanceof VoteView) {
            int i26 = i17 - i3;
            j jVar3 = this.mNewVoteAnimHelper;
            Card card3 = profileCardInfo.card;
            ((VoteView) view).j(z16, z18, i16, i26, jVar3, false, card3.likeAreaId, card3.isLuckyVip(), profileCardInfo.card.uin);
        } else if (view instanceof VoteViewV2) {
            int i27 = i17 - i3;
            j jVar4 = this.mNewVoteAnimHelper;
            Card card4 = profileCardInfo.card;
            ((VoteViewV2) view).r(z16, z18, i16, i27, jVar4, false, card4.likeAreaId, Boolean.valueOf(card4.isLuckyVip()), profileCardInfo.card.uin);
        }
        view.setTag(obj);
        view.setOnClickListener(this.mOnClickListener);
        view.setContentDescription(format);
        AccessibilityUtil.d(view, Button.class.getName());
    }

    private void updateSetCardBar(ProfileCardInfo profileCardInfo) {
        this.mTipsFlags &= -3;
        this.mSetCardChecked.set(false);
        View view = this.mHeaderChildMap.get("map_key_tips_set_card");
        if (view == null) {
            view = View.inflate(this.mActivity, R.layout.bek, null);
        }
        View view2 = view;
        if (view2 != null && profileCardInfo != null && profileCardInfo.card != null) {
            this.mHeaderChildMap.put("map_key_tips_set_card", view2);
            String currentAccountUin = this.mApp.getCurrentAccountUin();
            if (currentAccountUin == null) {
                QLog.e(TAG, 1, "updateSetCardBar fail, mApp.getCurrentAccountUin is null");
                return;
            }
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne.f260789pa != 0 && !currentAccountUin.equals(allInOne.uin)) {
                ThreadManagerV2.post(new UpdateProfileSetCardTask(this), 5, null, true);
                return;
            }
            Card card = profileCardInfo.card;
            long j3 = card.lCurrentStyleId;
            long j16 = card.lCurrentBgId;
            int i3 = card.templateRet;
            ArrayList<Integer> bgTypeArray = card.getBgTypeArray();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateSetCardBar bgtype = " + bgTypeArray);
            }
            ThreadManagerV2.excute(new Runnable(i3, j3, getResources(), (TextView) view2.findViewById(R.id.czx), (ImageView) view2.findViewById(R.id.czj), view2) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$currentTemplateId;
                final /* synthetic */ View val$finalMSetCardTipLayout;
                final /* synthetic */ ImageView val$guideImage;
                final /* synthetic */ Resources val$res;
                final /* synthetic */ int val$templateRet;
                final /* synthetic */ TextView val$tipsView;

                {
                    this.val$templateRet = i3;
                    this.val$currentTemplateId = j3;
                    this.val$res = r9;
                    this.val$tipsView = r10;
                    this.val$guideImage = r11;
                    this.val$finalMSetCardTipLayout = view2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AbsProfileHeaderView.this, Integer.valueOf(i3), Long.valueOf(j3), r9, r10, r11, view2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences preferences = AbsProfileHeaderView.this.mApp.getPreferences();
                    boolean z16 = false;
                    if (preferences != null) {
                        z16 = preferences.getBoolean(AppConstants.Preferences.SVIP_PROFILE_USE_GUIDE_SHOWN_FLAG, false);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AbsProfileHeaderView.TAG, 2, "isShowTips" + z16 + ",templateRet=" + this.val$templateRet + ",myTemplateId=" + this.val$currentTemplateId);
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16, preferences) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.9.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ boolean val$finalIsShowTips;
                        final /* synthetic */ SharedPreferences val$userCurrentSP;

                        {
                            this.val$finalIsShowTips = z16;
                            this.val$userCurrentSP = preferences;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass9.this, Boolean.valueOf(z16), preferences);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String string;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            int i16 = AnonymousClass9.this.val$templateRet;
                            if ((101107 == i16 || 101108 == i16) && !this.val$finalIsShowTips && this.val$userCurrentSP != null) {
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.9.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        SharedPreferences.Editor edit = AnonymousClass1.this.val$userCurrentSP.edit();
                                        if (edit != null) {
                                            edit.putBoolean(AppConstants.Preferences.SVIP_PROFILE_USE_GUIDE_SHOWN_FLAG, true).commit();
                                        }
                                    }
                                }, 16, null, true);
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                QBaseActivity qBaseActivity = AbsProfileHeaderView.this.mActivity;
                                Object[] objArr = new Object[1];
                                if (101107 == anonymousClass9.val$templateRet) {
                                    string = anonymousClass9.val$res.getString(R.string.f171204d45);
                                } else {
                                    string = anonymousClass9.val$res.getString(R.string.f173184hu3);
                                }
                                objArr[0] = string;
                                String string2 = qBaseActivity.getString(R.string.gz7, objArr);
                                AnonymousClass9.this.val$tipsView.setText(string2);
                                ImageView imageView = AnonymousClass9.this.val$guideImage;
                                if (imageView != null) {
                                    imageView.setContentDescription(string2);
                                }
                                AnonymousClass9.this.val$finalMSetCardTipLayout.setTag(new com.tencent.mobileqq.profile.b(24, Integer.valueOf(AnonymousClass9.this.val$templateRet)));
                                AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                                anonymousClass92.val$finalMSetCardTipLayout.setOnClickListener(AbsProfileHeaderView.this.mOnClickListener);
                                AbsProfileHeaderView absProfileHeaderView = AbsProfileHeaderView.this;
                                absProfileHeaderView.mTipsFlags = 2 | absProfileHeaderView.mTipsFlags;
                            }
                            AbsProfileHeaderView.this.mSetCardChecked.set(true);
                            AbsProfileHeaderView.this.checkTips();
                        }
                    });
                }
            }, 16, null, true);
            return;
        }
        this.mSetCardChecked.set(true);
        checkTips();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
    
        if (r0.size() <= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00af, code lost:
    
        if (com.tencent.mobileqq.profile.k.d().c(r0) <= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r22.setTag(new com.tencent.mobileqq.profile.b(97, com.tencent.mobileqq.profile.k.d().f(r0)));
        r22.setOnClickListener(r20.mOnClickListener);
        r6.setText(com.tencent.mobileqq.app.HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.pez) + com.tencent.mobileqq.profile.k.d().c(r0) + com.tencent.mobileqq.app.HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.pex));
        r7.setOnClickListener(new com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.AnonymousClass8(r20, r22));
        r22.setVisibility(0);
        com.tencent.mobileqq.statistics.ReportController.o(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateSignTopic(ProfileCardInfo profileCardInfo, View view, TextView textView, RichStatus richStatus, int i3, SpannableString spannableString) {
        boolean z16;
        byte[] bArr;
        List<oidb_0xd9f$TopicItem> list;
        List<com.tencent.util.Pair<Integer, String>> list2;
        if (spannableString.length() > 0) {
            if (!k.d().i(this.mApp) && (list2 = richStatus.topics) != null && list2.size() > 0) {
                textView.post(new Runnable(richStatus, textView, i3) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$drawableSize;
                    final /* synthetic */ TextView val$signView;
                    final /* synthetic */ RichStatus val$status;

                    {
                        this.val$status = richStatus;
                        this.val$signView = textView;
                        this.val$drawableSize = i3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, AbsProfileHeaderView.this, richStatus, textView, Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        int i16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        QBaseActivity qBaseActivity = AbsProfileHeaderView.this.mActivity;
                        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                            ArrayList<String> arrayList = this.val$status.plainText;
                            if (arrayList != null && arrayList.size() > 0) {
                                str = this.val$status.plainText.get(0);
                            } else {
                                str = null;
                            }
                            String str2 = str;
                            this.val$status.sortTopicPos();
                            List<com.tencent.util.Pair<Integer, Integer>> list3 = this.val$status.topicsPos;
                            if (list3 != null && list3.size() > 0) {
                                i16 = this.val$status.topicsPos.get(0).second.intValue();
                            } else {
                                i16 = 0;
                            }
                            int k3 = k.d().k(this.val$signView, this.val$status.topics.get(0).second, this.val$status.actionText, this.val$drawableSize, str2, i16);
                            if (k3 == Integer.MIN_VALUE) {
                                return;
                            }
                            UiUtils.INSTANCE.showProfileSignGuideAsDropDown(this.val$signView, -k3, 0);
                            k.d().m(AbsProfileHeaderView.this.mApp);
                            ReportController.o(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
                        }
                    }
                });
            }
            k.d().r(this.mApp, richStatus);
            boolean n3 = k.d().n(this.mApp);
            if (view != null) {
                if (profileCardInfo.allInOne.f260789pa == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                TextView textView2 = (TextView) view.findViewById(R.id.md5);
                ImageView imageView = (ImageView) view.findViewById(R.id.dum);
                oidb_0xd9f$RspBody oidb_0xd9f_rspbody = new oidb_0xd9f$RspBody();
                Card card = profileCardInfo.card;
                if (card != null && (bArr = card.vLongNickTopicInfo) != null) {
                    try {
                        oidb_0xd9f_rspbody.mergeFrom(bArr);
                        oidb_0xd9f$LongNickItem oidb_0xd9f_longnickitem = oidb_0xd9f_rspbody.longnick_item.get();
                        if (oidb_0xd9f_longnickitem != null) {
                            list = oidb_0xd9f_longnickitem.rpt_topic_item.get();
                        } else {
                            list = null;
                        }
                        if (!n3 && !k.d().h(this.mApp, k.d().e(list))) {
                            recommendTopicViewControl(view, z16);
                            return;
                        }
                        recommendTopicViewControl(view, z16);
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
                        }
                        recommendTopicViewControl(view, z16);
                        return;
                    }
                }
                recommendTopicViewControl(view, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStaticAvatarInner(int i3, AllInOne allInOne, String str) {
        View c16;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159025u8);
        AvatarLayout avatarLayout = (AvatarLayout) this.mHeaderChildMap.get("map_key_face");
        Bitmap bitmap = null;
        if (avatarLayout == null) {
            c16 = null;
        } else {
            c16 = avatarLayout.c(0);
        }
        ImageView imageView = (ImageView) c16;
        if (3 != i3 && (imageView instanceof DynamicAvatarView)) {
            ((DynamicAvatarView) imageView).f316488d = "";
        }
        if (i3 == 0) {
            if (allInOne.f260789pa == 0 && FaceUtil.isUploadingAvatar()) {
                try {
                    String tempAvatarFilePath = FaceUtil.getTempAvatarFilePath();
                    File file = new File(tempAvatarFilePath);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    FileInputStream fileInputStream = new FileInputStream(file);
                    options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream, dimensionPixelSize, dimensionPixelSize);
                    fileInputStream.close();
                    bitmap = com.tencent.mobileqq.util.j.d(tempAvatarFilePath, options);
                    if (bitmap != null) {
                        bitmap = QQAppInterface.getCircleFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, e16.toString());
                    }
                }
            }
            if (bitmap == null) {
                bitmap = this.mApp.getFaceBitmap(str, true);
            }
        } else if (1 == i3) {
            bitmap = this.mApp.getFaceBitmap(11, str, (byte) 3, true, 0);
        } else if (3 == i3) {
            if (imageView instanceof DynamicAvatarView) {
                DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) imageView;
                String L = ac.L(this.mCardInfo.allInOne.contactName);
                dynamicAvatarView.f316488d = L;
                if (ac.o0(L)) {
                    dynamicAvatarView.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.f159585az2));
                } else {
                    dynamicAvatarView.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.f159586az3));
                }
            }
            try {
                BitmapFactory.decodeResource(getContext().getResources(), R.drawable.day);
            } catch (OutOfMemoryError unused) {
            }
        } else if (2 == i3) {
            bitmap = BaseImageUtil.getDefaultPhoneContactBitmap();
        } else {
            bitmap = BaseImageUtil.getDefaultFaceBitmap();
        }
        if (bitmap != null) {
            this.mActivity.runOnUiThread(new Runnable(bitmap) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap val$faceBitMap;

                {
                    this.val$faceBitMap = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderView.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    View c17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AvatarLayout avatarLayout2 = (AvatarLayout) AbsProfileHeaderView.this.mHeaderChildMap.get("map_key_face");
                    if (avatarLayout2 == null) {
                        c17 = null;
                    } else {
                        c17 = avatarLayout2.c(0);
                    }
                    ImageView imageView2 = (ImageView) c17;
                    if (imageView2 != null) {
                        if (this.val$faceBitMap != null) {
                            QLog.d(LogTag.GET_HEAD, 1, "ProfileHeaderView updateAvatar, bitmap: " + this.val$faceBitMap);
                            avatarLayout2.setStaticAvatar(this.val$faceBitMap);
                        }
                        AbsProfileHeaderView.this.clearAvatarMask(imageView2);
                    }
                }
            });
        }
    }

    public void addChildView(String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) view);
        } else {
            this.mHeaderChildMap.put(str, view);
        }
    }

    public boolean containChildView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return this.mHeaderChildMap.containsKey(str);
    }

    public View getChildView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.mHeaderChildMap.get(str);
    }

    public int getHorizontalMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return 0;
    }

    public long getPendantId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mPendantId;
    }

    @Override // com.tencent.widget.XListView.MotionEventInterceptor
    public boolean intercept(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isShowZan(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        Card card = profileCardInfo.card;
        boolean z17 = true;
        if (card != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (card != null && card.isForbidAccount) {
            QLog.e(TAG, 1, "isShowZan isForbid");
            return false;
        }
        boolean equals = TextUtils.equals(profileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
        boolean isPaTypeFriend = ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne);
        if (!equals && !isPaTypeFriend) {
            if (!z16 || !profileCardInfo.card.strangerVoteOpen) {
                z17 = false;
            }
            return z16 & z17;
        }
        return z16;
    }

    public void onApolloExpand(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.ITopic.OnTopicClickListener
    public void onClick(ITopic iTopic, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) iTopic, (Object) view);
            return;
        }
        Object data = iTopic.getData();
        if (data instanceof com.tencent.util.Pair) {
            com.tencent.util.Pair pair = (com.tencent.util.Pair) data;
            c.d(this.mActivity, c.b(((Integer) pair.first).intValue(), (String) pair.second), -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mScreenWidth = Math.min(r4.widthPixels, r4.heightPixels);
        this.mScreenHeight = Math.max(r4.widthPixels, r4.heightPixels);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.mDiyPendantObserver);
        }
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.mUIHandler;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeCallbacksAndMessages(null);
        }
        View view = this.mHeaderChildMap.get("map_key_qzonecover");
        if (view instanceof QzonePhotoView) {
            ((QzonePhotoView) view).l();
        }
        ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).unregisterLiangIdChangedListener(this.mLiangIdChangedListener);
    }

    public void onGetQZoneCover(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_qzonecover");
        if (view instanceof QzonePhotoView) {
            QzonePhotoView qzonePhotoView = (QzonePhotoView) view;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(z16) + ",uin=" + str);
            }
            qzonePhotoView.m(z16, str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        if (view instanceof VipPhotoViewForSimple) {
            VipPhotoViewForSimple vipPhotoViewForSimple = (VipPhotoViewForSimple) view;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(z16) + ",uin=" + str);
            }
            vipPhotoViewForSimple.k(z16, str, mobile_sub_get_photo_wall_rspVar);
        }
    }

    public void onInit(ITemplateUtils iTemplateUtils) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iTemplateUtils);
        } else {
            this.templateUtils = iTemplateUtils;
            onInit(this.mCardInfo);
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.hasAsyncUpdateHdAvatar = false;
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public abstract void onUpdate(ProfileCardInfo profileCardInfo, boolean z16);

    public void setClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onClickListener);
        } else {
            this.mOnClickListener = onClickListener;
        }
    }

    public void setViewLoader(IProfileViewLoader iProfileViewLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iProfileViewLoader);
        } else {
            this.mViewLoader = iProfileViewLoader;
        }
    }

    public void updateAvatar(AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) allInOne);
            return;
        }
        AvatarLayout avatarLayout = (AvatarLayout) this.mHeaderChildMap.get("map_key_face");
        View c16 = avatarLayout != null ? avatarLayout.c(0) : null;
        if (c16 instanceof QQProAvatarView) {
            setAvatar((QQProAvatarView) c16, allInOne.uin);
            return;
        }
        if (allInOne.f260789pa == 33) {
            updateAvatar(allInOne, 2, allInOne.uin, false);
            return;
        }
        if (ProfilePAUtils.isPaTypeHasUin(allInOne)) {
            int i3 = allInOne.f260789pa;
            if ((i3 == 41 || i3 == 86) && !TextUtils.isEmpty(allInOne.uin) && allInOne.uin.equals("0") && !TextUtils.isEmpty(allInOne.uid)) {
                updateAvatar(allInOne, 0, allInOne.uid, false);
                return;
            } else {
                updateAvatar(allInOne, 0, allInOne.uin, true);
                return;
            }
        }
        String w3 = ProfileCardUtil.w(allInOne);
        if (w3 != null && w3.length() > 0) {
            if (allInOne.f260789pa == 53) {
                updateAvatar(allInOne, allInOne.bindQQ ? 1 : 3, w3, false);
                return;
            } else {
                updateAvatar(allInOne, 1, w3, false);
                return;
            }
        }
        updateAvatar(allInOne, 2, allInOne.uin, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateAvatarPendantImage(ProfileCardInfo profileCardInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, profileCardInfo, Boolean.valueOf(z16));
            return;
        }
        if (ProAvatarComponentUtils.m()) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_avatar_pendant");
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (!ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
                imageView.setVisibility(4);
                this.mPendantId = 0L;
            } else {
                ThreadManagerV2.post(new Runnable(profileCardInfo, z16) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.10
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProfileCardInfo val$cardInfo;
                    final /* synthetic */ boolean val$isInit;

                    {
                        this.val$cardInfo = profileCardInfo;
                        this.val$isInit = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AbsProfileHeaderView.this, profileCardInfo, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ((IQQVasInfoApi) QRoute.api(IQQVasInfoApi.class)).getVasInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.val$cardInfo.allInOne.uin), AbsProfileHeaderView.TAG, new hx3.b<kx3.a>() { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.10.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this);
                                    }
                                }

                                @Override // hx3.b
                                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<kx3.a> eVar) {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, (Object) eVar);
                                        return;
                                    }
                                    if (eVar != null && eVar.a() == 0) {
                                        if (eVar.b().isEmpty()) {
                                            AbsProfileHeaderView.this.mUIHandler.sendMessage(AbsProfileHeaderView.this.mUIHandler.obtainMessage(1003, (Runnable) null));
                                            return;
                                        }
                                        Iterator<kx3.a> it = eVar.b().iterator();
                                        while (it.hasNext()) {
                                            kx3.a next = it.next();
                                            AbsProfileHeaderView.this.mUIHandler.sendMessage(AbsProfileHeaderView.this.mUIHandler.obtainMessage(1003, next));
                                            if (AnonymousClass10.this.val$isInit && next != null && AvatarPendantFileUtil.isDiyPendant(next.getPendantId())) {
                                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                                AvatarPendantUtil.e(AbsProfileHeaderView.this.mApp, anonymousClass10.val$cardInfo.allInOne.uin);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    }
                }, 8, null, true);
            }
        }
    }

    public void updateDetail(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_details");
        if (view instanceof TextView) {
            makeAccountDetailInfo((TextView) view, profileCardInfo);
        } else if (view instanceof LinearLayout) {
            makeAccountDetailInfoForQQCircle((LinearLayout) view, profileCardInfo);
        }
    }

    public void updateHead(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_profile_nick_name");
        if (view != null) {
            view.setBackgroundResource(R.drawable.agj);
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            AllInOne allInOne = profileCardInfo.allInOne;
            String str = profileCardInfo.profileName.f305805a.f305804b;
            if (QLog.isColorLevel()) {
                QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "updateHead titleName = " + Utils.U(str));
            }
            if (str == null || str.length() == 0) {
                if (ProfilePAUtils.isPaTypeShowAccount(allInOne) && allInOne != null) {
                    str = String.valueOf(allInOne.uin);
                } else {
                    str = " ";
                }
            }
            textView.setText(str);
            textView.setContentDescription((this.mActivity.getString(R.string.ab7) + ":") + str);
            textView.setTag(new com.tencent.mobileqq.profile.b(88, textView.getText().toString()));
            textView.setOnClickListener(this.mOnClickListener);
            LongClickCopyAction.attachCopyAction(textView);
            if (allInOne != null) {
                ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(textView, profileCardInfo.card);
                return;
            }
            return;
        }
        if (view instanceof ProfileNameView) {
            ((ProfileNameView) view).k(this.mApp, profileCardInfo);
        }
    }

    public void updateJueban(ProfileCardInfo profileCardInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_tag_jueban");
        View view2 = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof ImageView) && view2 != null && profileCardInfo.card != null && isShowZan(profileCardInfo) && ProfileCardUtil.N(profileCardInfo.card.getBgTypeArray())) {
            view.setTag(new com.tencent.mobileqq.profile.b(34, null));
            view.setOnClickListener(this.mOnClickListener);
            view.setVisibility(0);
            if (profileCardInfo.allInOne.f260789pa == 0) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, str, "", "", "");
        }
    }

    public void updateLike(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) profileCardInfo);
            return;
        }
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (profileCardInfo.isTroopMemberCard && troopManager.V(profileCardInfo.troopUin)) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof VoteView) || (view instanceof VoteViewV2)) {
            boolean isShowZan = isShowZan(profileCardInfo);
            boolean equals = TextUtils.equals(profileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
            if (isShowZan) {
                showVoteInner(profileCardInfo, view, equals, 0);
            } else {
                view.setVisibility(4);
            }
            if (view instanceof VoteViewV2) {
                VoteViewV2 voteViewV2 = (VoteViewV2) view;
                voteViewV2.setVoteImageId(R.drawable.qui_like, R.drawable.qui_like_filled);
                voteViewV2.setVoteColor(R.color.qui_common_brand_standard);
            }
        }
    }

    public void updateLiked(ProfileCardInfo profileCardInfo, long j3, boolean z16) {
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, profileCardInfo, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteView) {
            VoteView voteView = (VoteView) view;
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateLiked");
            }
            if (j3 == -1) {
                j17 = voteView.G;
            } else {
                j17 = j3;
            }
            Card card = profileCardInfo.card;
            if (card != null && card.bAvailVoteCnt == 0) {
                voteView.f();
            }
            Card card2 = profileCardInfo.card;
            voteView.j(false, true, (int) j17, 0, null, z16, card2.likeAreaId, card2.isLuckyVip(), profileCardInfo.card.uin);
            voteView.setOnClickListener(this.mOnClickListener);
            voteView.setContentDescription(String.format(this.mActivity.getString(R.string.f170791ab1), String.valueOf(j17)));
            return;
        }
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateLiked");
            }
            if (j3 == -1) {
                j16 = voteViewV2.f316533e;
            } else {
                j16 = j3;
            }
            Card card3 = profileCardInfo.card;
            if (card3 != null && card3.bAvailVoteCnt == 0) {
                voteViewV2.m();
            }
            Card card4 = profileCardInfo.card;
            voteViewV2.r(false, true, (int) j16, 0, null, z16, card4.likeAreaId, Boolean.valueOf(card4.isLuckyVip()), profileCardInfo.card.uin);
            voteViewV2.setOnClickListener(this.mOnClickListener);
            voteViewV2.setContentDescription(String.format(this.mActivity.getString(R.string.f170791ab1), String.valueOf(j16)));
        }
    }

    public void updateNickInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_profile_remark_name");
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setText(this.mActivity.getString(R.string.f160431v0) + str);
            View view2 = this.mHeaderChildMap.get("map_key_profile_nick_name");
            if (view2 instanceof ProfileNameView) {
                textView.setTextColor(((ProfileNameView) view2).f());
            }
        }
    }

    public void updateOnlineStatusLayout(ProfileCardInfo profileCardInfo) {
        Context context;
        String uidFromUin;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) profileCardInfo);
            return;
        }
        if (!OnlineStatusToggleUtils.t()) {
            return;
        }
        try {
            View view = this.mHeaderChildMap.get("map_key_online_status");
            if (!(view instanceof LinearLayout) || (context = view.getContext()) == null) {
                return;
            }
            String str = profileCardInfo.card.uin;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(str) && (uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str)) != null && !uidFromUin.isEmpty()) {
                String str2 = TAG + "_updateOnlineStatusLayout";
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, str2) || (onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, str2)) == null) {
                    return;
                }
                AppRuntime.Status translateNT = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).translateNT(onlineStatusSimpleInfoWithUid);
                LinearLayout linearLayout = (LinearLayout) view;
                linearLayout.removeAllViews();
                linearLayout.setOnClickListener(null);
                Map<String, Object> onlineStatusViewAndClickListener = ProfileCardUtils.getOnlineStatusViewAndClickListener(onlineStatusSimpleInfoWithUid, str, translateNT, peekAppRuntime, context);
                if (onlineStatusViewAndClickListener == null) {
                    return;
                }
                Object obj = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_VIEW);
                Object obj2 = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_CLICK_LISTENER);
                Object obj3 = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_WIDTH);
                if ((obj instanceof View) && (obj2 instanceof View.OnClickListener) && (obj3 instanceof Integer)) {
                    linearLayout.addView((View) obj);
                    linearLayout.setVisibility(0);
                    linearLayout.setOnClickListener((View.OnClickListener) obj2);
                    if (onlineStatusSimpleInfoWithUid.e0() > 0 && translateNT.equals(AppRuntime.Status.online)) {
                        valueOf = String.valueOf(onlineStatusSimpleInfoWithUid.e0());
                    } else {
                        valueOf = String.valueOf(translateNT.getValue());
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ProfileCardDtReportUtil.STATUS_ID, valueOf);
                    ProfileCardDtReportUtil.initElementWithExposureClickAndParams(linearLayout, ProfileCardDtReportUtil.DT_REPORT_STATUS_ICON, hashMap);
                    linearLayout.requestLayout();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateOnlineStatusLayout " + e16);
        }
    }

    public void updateOnlineStatusView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
    }

    public void updateQidInfo(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_qid_info");
        if (view instanceof QidCoolTextView) {
            QidCoolTextView qidCoolTextView = (QidCoolTextView) view;
            if (QidCardManager.needHideSearchQid(this.mApp, profileCardInfo)) {
                qidCoolTextView.setVisibility(8);
                return;
            }
            qidCoolTextView.updateQidView(this.mApp, profileCardInfo);
            qidCoolTextView.setTag(new com.tencent.mobileqq.profile.b(105, null));
            ProfileCardDtReportUtil.initElementWithExposureClick(view, ProfileCardDtReportUtil.DT_REPORT_ACCOUNT);
        }
    }

    public void updateSexAgeArea(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_sex_age_area");
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            String a06 = ProfileCardUtil.a0(this.mActivity, profileCardInfo);
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateSexAgeArea strInfo=" + Utils.U(a06));
            }
            if (profileCardInfo.allInOne.f260789pa == 33) {
                String string = this.mActivity.getString(R.string.fpy);
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setPadding(0, 10, 0, 0);
                textView.setText(string);
                textView.setContentDescription(string);
                return;
            }
            if (a06 != null && a06.length() > 0) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setPadding(0, 0, 0, 0);
                textView.setText(a06);
                textView.setContentDescription(this.mActivity.getString(R.string.aam) + ":" + a06);
                textView.setClickable(true);
                return;
            }
            if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateSign(ProfileCardInfo profileCardInfo) {
        int i3;
        AllInOne allInOne;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) profileCardInfo);
            return;
        }
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (profileCardInfo != null && profileCardInfo.isTroopMemberCard && troopManager != null && troopManager.V(profileCardInfo.troopUin)) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_sign");
        View view2 = this.mHeaderChildMap.get("map_key_sign_common_topic");
        if ((view instanceof TextView) && profileCardInfo != null && profileCardInfo.allInOne != null) {
            TextView textView = (TextView) view;
            Card card = profileCardInfo.card;
            if (card == null) {
                textView.setVisibility(8);
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            RichStatus richStatus = RichStatusUtils.INSTANCE.getRichStatus(card);
            String str = "";
            if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne) && richStatus != null) {
                if (profileCardInfo.allInOne.f260789pa == 0) {
                    textView.setTag(new com.tencent.mobileqq.profile.b(3, ""));
                    textView.setOnClickListener(this.mOnClickListener);
                }
                SpannableString spannableString = new SpannableString(richStatus.toSpannableStringWithTopic("", RichStatus.ACTION_COLOR_NORMAL, RichStatus.ACTION_COLOR_PRESSED, this));
                if (!TextUtils.isEmpty(richStatus.actionText)) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                    spannableStringBuilder.insert(0, (CharSequence) "[S] ");
                    StatusManager statusManager = (StatusManager) this.mApp.getManager(QQManagerFactory.STATUS_MANAGER);
                    if (statusManager != null) {
                        bitmap = statusManager.K(richStatus.actionId, 200);
                    } else {
                        try {
                            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bwk);
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                            bitmap = null;
                            bo boVar = new bo(getResources(), bitmap, false, false);
                            int textSize = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
                            boVar.setBounds(0, 0, textSize, textSize);
                            OffsetableImageSpan offsetableImageSpan = new OffsetableImageSpan(boVar, 0);
                            offsetableImageSpan.setOffset(-0.1f);
                            spannableStringBuilder.setSpan(offsetableImageSpan, 0, 3, 17);
                            if (profileCardInfo.allInOne.f260789pa == 0) {
                            }
                            textView.setText(new QQText(spannableStringBuilder, 1, 14));
                            i3 = textSize;
                            textView.setMovementMethod(com.tencent.mobileqq.richstatus.topic.b.getInstance());
                            textView.setVisibility(0);
                            updateSignTopic(profileCardInfo, view2, textView, richStatus, i3, spannableString);
                            allInOne = profileCardInfo.allInOne;
                            if (allInOne.f260789pa != 0) {
                            }
                            textView.setOnClickListener(this.mOnClickListener);
                            if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.qq_profilecard_signature_more, 0);
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(this.mActivity.getString(R.string.acl));
                            sb5.append(":");
                            if (!TextUtils.isEmpty(spannableString)) {
                            }
                            sb5.append(str);
                            textView.setContentDescription(sb5.toString());
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            bitmap = null;
                            bo boVar2 = new bo(getResources(), bitmap, false, false);
                            int textSize2 = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
                            boVar2.setBounds(0, 0, textSize2, textSize2);
                            OffsetableImageSpan offsetableImageSpan2 = new OffsetableImageSpan(boVar2, 0);
                            offsetableImageSpan2.setOffset(-0.1f);
                            spannableStringBuilder.setSpan(offsetableImageSpan2, 0, 3, 17);
                            if (profileCardInfo.allInOne.f260789pa == 0) {
                            }
                            textView.setText(new QQText(spannableStringBuilder, 1, 14));
                            i3 = textSize2;
                            textView.setMovementMethod(com.tencent.mobileqq.richstatus.topic.b.getInstance());
                            textView.setVisibility(0);
                            updateSignTopic(profileCardInfo, view2, textView, richStatus, i3, spannableString);
                            allInOne = profileCardInfo.allInOne;
                            if (allInOne.f260789pa != 0) {
                            }
                            textView.setOnClickListener(this.mOnClickListener);
                            if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
                            }
                            StringBuilder sb52 = new StringBuilder();
                            sb52.append(this.mActivity.getString(R.string.acl));
                            sb52.append(":");
                            if (!TextUtils.isEmpty(spannableString)) {
                            }
                            sb52.append(str);
                            textView.setContentDescription(sb52.toString());
                            return;
                        }
                    }
                    bo boVar22 = new bo(getResources(), bitmap, false, false);
                    int textSize22 = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
                    boVar22.setBounds(0, 0, textSize22, textSize22);
                    OffsetableImageSpan offsetableImageSpan22 = new OffsetableImageSpan(boVar22, 0);
                    offsetableImageSpan22.setOffset(-0.1f);
                    spannableStringBuilder.setSpan(offsetableImageSpan22, 0, 3, 17);
                    if (profileCardInfo.allInOne.f260789pa == 0) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qq_profilecard_signature_edit, 0, 0, 0);
                    }
                    textView.setText(new QQText(spannableStringBuilder, 1, 14));
                    i3 = textSize22;
                } else {
                    textView.setText(new QQText(constructSignSpan(profileCardInfo, spannableString, textView), 1, 14));
                    i3 = 0;
                }
                textView.setMovementMethod(com.tencent.mobileqq.richstatus.topic.b.getInstance());
                textView.setVisibility(0);
                updateSignTopic(profileCardInfo, view2, textView, richStatus, i3, spannableString);
                allInOne = profileCardInfo.allInOne;
                if (allInOne.f260789pa != 0 || ProfilePAUtils.isPaTypeFriend(allInOne)) {
                    textView.setOnClickListener(this.mOnClickListener);
                }
                if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne) && profileCardInfo.allInOne.f260789pa != 0) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.qq_profilecard_signature_more, 0);
                }
                StringBuilder sb522 = new StringBuilder();
                sb522.append(this.mActivity.getString(R.string.acl));
                sb522.append(":");
                if (!TextUtils.isEmpty(spannableString)) {
                    str = spannableString.toString();
                }
                sb522.append(str);
                textView.setContentDescription(sb522.toString());
                return;
            }
            if (profileCardInfo.allInOne.f260789pa == 0) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qq_profilecard_signature_edit, 0, 0, 0);
                textView.setText(HardCodeUtil.qqStr(R.string.f172322pf0));
                textView.setVisibility(0);
                textView.setTag(new com.tencent.mobileqq.profile.b(3, ""));
                textView.setOnClickListener(this.mOnClickListener);
                textView.setContentDescription(this.mActivity.getString(R.string.acl));
                recommendTopicViewControl(view2, true);
                return;
            }
            textView.setVisibility(8);
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void updateTagCloud(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) profileCardInfo);
        }
    }

    public void updateTips(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) profileCardInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ProfileHeaderView updateTips");
        }
        View view = this.mHeaderChildMap.get("map_key_tips");
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if ((this.mTipsFlags & 2) != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "ProfileHeaderView updateTips setcard");
                }
                View view2 = this.mHeaderChildMap.get("map_key_tips_set_card");
                if (view2 != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(view2);
                    linearLayout.setVisibility(0);
                    if (profileCardInfo.isTroopMemberCard) {
                        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    }
                }
            }
        }
    }

    public void updateUinInfo(ProfileCardInfo profileCardInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) profileCardInfo, (Object) str);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_uin_info");
        if (view instanceof TextView) {
            makeAccountSimpleInfo((TextView) view, profileCardInfo);
        }
    }

    public void updateVipMedal(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) profileCardInfo);
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_vip_medal");
        if (view instanceof ImageView) {
            int i3 = profileCardInfo.card.vipMedalId;
            if (i3 <= 0) {
                view.setVisibility(8);
                return;
            }
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
            ImageView imageView = (ImageView) view;
            imageView.setTag(new com.tencent.mobileqq.profile.b(115, null));
            imageView.setImageDrawable(((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getMedalIcon(view.getResources(), i3));
            MobileReportManager.getInstance().reportAction(SearchConstants.PLATFORM, "data_card", "vip_medal", "", String.valueOf(i3), "62", 101, 0);
            imageView.setOnClickListener(new View.OnClickListener(i3, profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ ProfileCardInfo val$cardInfo;
                final /* synthetic */ int val$vipMedalId;

                {
                    this.val$vipMedalId = i3;
                    this.val$cardInfo = profileCardInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AbsProfileHeaderView.this, Integer.valueOf(i3), profileCardInfo);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                    } else {
                        MobileReportManager.getInstance().reportAction(SearchConstants.PLATFORM, "data_card", "vip_medal", "", String.valueOf(this.val$vipMedalId), "62", 102, 0);
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(view2.getContext(), this.val$cardInfo.card.vipMedalJumpUrl);
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInit(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) profileCardInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ProfileHeaderView onInit");
        }
        if (profileCardInfo.currentTemplate != null) {
            updateSetCardBar(profileCardInfo);
        }
        this.mApp.addObserver(this.mDiyPendantObserver);
        ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).registerLiangIdChangedListener(this.mLiangIdChangedListener);
    }

    public void updateAvatar(AllInOne allInOne, int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, allInOne, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateAvatar type=%s kye=%s isDynamicMode=%s", Integer.valueOf(i3), str, Boolean.valueOf(z16)));
        }
        AvatarLayout avatarLayout = (AvatarLayout) this.mHeaderChildMap.get("map_key_face");
        View c16 = avatarLayout != null ? avatarLayout.c(0) : null;
        if (c16 instanceof QQProAvatarView) {
            setAvatar((QQProAvatarView) c16, allInOne.uin);
        } else if (z16 && i3 == 0) {
            this.mActivity.runOnUiThread(new Runnable(allInOne, i3, str) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ AllInOne val$allinone;
                final /* synthetic */ String val$key;
                final /* synthetic */ int val$type;

                {
                    this.val$allinone = allInOne;
                    this.val$type = i3;
                    this.val$key = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AbsProfileHeaderView.this, allInOne, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    View c17;
                    h hVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AvatarLayout avatarLayout2 = (AvatarLayout) AbsProfileHeaderView.this.mHeaderChildMap.get("map_key_face");
                    boolean z17 = false;
                    if (avatarLayout2 == null) {
                        c17 = null;
                    } else {
                        c17 = avatarLayout2.c(0);
                    }
                    ImageView imageView = (ImageView) c17;
                    if (imageView instanceof DynamicAvatarView) {
                        int i16 = 1;
                        if (!QQTheme.isNowSimpleUI() && !SimpleUIUtil.isNowElderMode()) {
                            ((IQQVasInfoApi) QRoute.api(IQQVasInfoApi.class)).getVasInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.val$allinone.uin), AbsProfileHeaderView.TAG, new hx3.b<kx3.a>(avatarLayout2, i16) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.4.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ AvatarLayout val$avatarLayout;
                                final /* synthetic */ int val$headType;

                                {
                                    this.val$avatarLayout = avatarLayout2;
                                    this.val$headType = i16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, avatarLayout2, Integer.valueOf(i16));
                                    }
                                }

                                @Override // hx3.b
                                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<kx3.a> eVar) {
                                    boolean z18;
                                    Object valueOf;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, (Object) eVar);
                                        return;
                                    }
                                    if (eVar != null && eVar.a() == 0 && eVar.b() != null) {
                                        Iterator<kx3.a> it = eVar.b().iterator();
                                        while (it.hasNext()) {
                                            kx3.a next = it.next();
                                            boolean z19 = false;
                                            if (next != null && next.getPendantId() != 0) {
                                                z18 = false;
                                            } else {
                                                z18 = true;
                                            }
                                            String str2 = AbsProfileHeaderView.TAG;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("setFace has pendant? ");
                                            if (next == null) {
                                                valueOf = "null";
                                            } else {
                                                if (next.getPendantId() != 0) {
                                                    z19 = true;
                                                }
                                                valueOf = Boolean.valueOf(z19);
                                            }
                                            sb5.append(valueOf);
                                            QLog.d(str2, 2, sb5.toString());
                                            AvatarLayout avatarLayout3 = this.val$avatarLayout;
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            avatarLayout3.setFaceDrawable(AbsProfileHeaderView.this.mApp, this.val$headType, anonymousClass4.val$allinone.uin, 640, true, true, true, false, 3, z18, 102);
                                        }
                                        return;
                                    }
                                    AvatarLayout avatarLayout4 = this.val$avatarLayout;
                                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                    avatarLayout4.setFaceDrawable(AbsProfileHeaderView.this.mApp, this.val$headType, anonymousClass42.val$allinone.uin, 640, true, true, true, false, 3, false, 102);
                                }
                            });
                        } else {
                            avatarLayout2.setFaceDrawable(AbsProfileHeaderView.this.mApp, 1, this.val$allinone.uin, 640, true, true, true, false, 3, true, 102);
                        }
                        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (hVar = ((DynamicAvatarView) imageView).E) != null) {
                            Drawable a16 = hVar.a();
                            if ((a16 instanceof FaceDrawable) && ((FaceDrawable) a16).isShowZplanOutboundAvatar()) {
                                z17 = true;
                            }
                        }
                        AbsProfileHeaderView.this.setFaceStoke(this.val$allinone.uin, z17);
                        AbsProfileHeaderView.this.clearAvatarMask(imageView);
                        return;
                    }
                    AbsProfileHeaderView.this.updateAvatar(this.val$allinone, this.val$type, this.val$key, false);
                }
            });
        } else {
            ThreadManagerV2.post(new Runnable(i3, allInOne, str) { // from class: com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ AllInOne val$allinone;
                final /* synthetic */ String val$key;
                final /* synthetic */ int val$type;

                {
                    this.val$type = i3;
                    this.val$allinone = allInOne;
                    this.val$key = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AbsProfileHeaderView.this, Integer.valueOf(i3), allInOne, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        AbsProfileHeaderView.this.updateStaticAvatarInner(this.val$type, this.val$allinone, this.val$key);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, true);
        }
    }
}
