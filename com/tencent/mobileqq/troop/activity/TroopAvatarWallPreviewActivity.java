package com.tencent.mobileqq.troop.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.Cdo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.utils.ap;
import com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qbar.QbarCrashCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.LargeIntentManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc = "\u5927\u56fe\u5c55\u793a TroopAvatarWallPreviewActivity", path = RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY)
/* loaded from: classes19.dex */
public class TroopAvatarWallPreviewActivity extends BaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static final String CURTYPE_KEY = "curType";
    public static final String FACE_ID_KEY = "faceid";
    public static final String FRIEND_UIN_KEY = "friendUin";
    public static final String ID_KEY = "_id";
    public static final String IMAGE_SAVE_PATH;
    public static final String INDEX_KEY = "index";
    public static final String KANDIAN_IMAGE_SID = "4";
    public static final String KEY_ACTICLE_INFO_ROWKEY = "acticle_info_rowkey";
    public static final String KEY_BTN_TEXT = "btntext";
    public static final String KEY_BUNDLE_DATA_EXTRA = "bundle_data_extra";
    public static final String KEY_CALLBACK_SEQ = "callback_seq";
    public static final String KEY_DEFAULT_AVATOR_INDEX = "default_avator_index";
    public static final String KEY_DT_PG_ID = "dt_page_id";
    public static final String KEY_DT_PG_PARAMS = "dt_page_params";
    public static final String KEY_EXTEND_FRIEND_DELETE_PATH_LIST = "extend_friend_delete_path_list";
    public static final String KEY_FROM_EXTEND_FRIEND_EDIT = "from_extend_Friend_edit";
    public static final String KEY_FROM_PERSONALITY_LABEL = "from_personality_label";
    public static final String KEY_FROM_TYPE = "from_type";
    public static final String KEY_IS_FROM_TOOL_PROCESS = "is_from_tool_process";
    public static final String KEY_IS_NOT_SHOW_INDEX = "is_not_show_index";
    public static final String KEY_NEED_TO_AIO = "is_need_to_aio";
    public static final String KEY_ORIGIN_LIST = "origin_list";
    public static final String KEY_ORIGIN_SIZE_LIST = "origin_size_list";
    public static final String KEY_SAVE_INTENT_TO_FILE = "save_intent_to_file";
    public static final String KEY_SEQ_NUM = "seqNum";
    public static final String KEY_SHOW_SOCIAL_BOTTOM_BAR = "show_social_bottom_bar";
    public static final String KEY_SHOW_SOCIAL_BOTTOM_BAR_DATA = "show_social_bottom_bar_data";
    public static final String KEY_SHOW_TITLE_BAR = "show_title_bar";
    public static final String KEY_SRC_ID = "src_id";
    public static final String KEY_STR_DATA_EXTRA = "str_data_extra";
    public static final String KEY_THUMBNAL_BOUND = "KEY_THUMBNAL_BOUND";
    public static final String NEARBY_WEB = "5";
    public static final String PUBLIC_ACCOUNT_IMAGE_SID = "2000";
    public static final String READINJOY_PIC_GALLERY_DETAIL = "6";
    public static final String REQUEST_TYPE_KEY = "requestTypeKey";
    private static final String SOURCE_FROM = "source_from";
    public static final int SOURCE_FROM_MATCH_FRIEND = 1;
    public static final String TAG = "TroopAvatarWallPreviewActivity";
    public static final String TRIBE_IMAGE_SID = "2";
    public static final String URL_KEY = "url";
    static boolean mIsOpen;
    static Object sLock;
    boolean animated;
    private ArrayList<String> extendFriendDeletePathList;
    protected ImageView imageView;
    protected boolean isFromPlugin;
    protected boolean isGridImageReport;
    protected boolean isNeedToAio;
    protected boolean isShowContentUrl;
    protected com.tencent.mobileqq.troop.widget.g mAdapter;
    protected ImageAnimationView mAnimationView;
    protected View mBgView;
    protected View mBottomBar;
    protected View mBottomBarSwitch;
    protected RelativeLayout mBottomBlock;
    private TranslateAnimation mBottomLayoutTranslateDownAnimation;
    private TranslateAnimation mBottomLayoutTranslateUpAnimation;
    protected View.OnClickListener mClickLis;
    protected ImageView mCommentBtn;
    protected View mContentUrlLayout;
    CookieManager mCookieMgr;
    protected List<String> mDelList;
    protected ImageButton mDelbtn;
    protected boolean mDeleteAbility;
    protected ArrayList<String> mDescs;
    protected TextView mDetailBtn;
    protected long mEnterAnimationDuring;
    private Bundle mExtras;
    protected String mExtrasStr;
    protected Gallery mGallery;
    protected int mIndex;
    private boolean mIsBottomBarUp;
    protected boolean mIsEdit;
    protected boolean mIsFromPhotoWall;
    protected boolean mIsFromQSearch;
    protected boolean mIsNotShowIndex;
    protected boolean mIsShowAction;
    protected boolean mIsShowMenu;
    protected boolean mIsTroopMember;
    protected ImageView mLikeBtn;
    protected boolean[] mLikes;
    protected ImageView mMenuBtn;
    protected boolean mNeedBottomBar;
    protected ArrayList<String> mOriginList;
    protected TextView mOriginPicBtn;
    protected ArrayList<String> mOriginSizeList;
    com.tencent.mobileqq.profile.PersonalityLabel.c mPersonalityLabelObserver;
    protected TextView mPhotoDesc;
    protected ArrayList<String> mPhotoIds;
    protected ArrayList<String> mPhotoTimes;
    protected ArrayList<Integer> mPreviewPhotoLocation;
    QQProgressDialog mProgressDialog;
    private PublicAccountShowPictureReport mPublicAccountShowPictureReport;
    private BroadcastReceiver mReceiver;
    protected RelativeLayout mRoot;
    protected FrameLayout mRootParent;
    private ac mRotationObserver;
    protected int mSeqListLength;
    protected List<String> mSeqNumList;
    protected String mSrcId;
    protected TextView mTextView;
    protected ArrayList<Rect> mThumbRect;
    protected String mTroopUin;
    private View.OnClickListener operateBarListener;
    private PictureShowViewModel pictureShowViewModel;
    Runnable setAnimateFlagRunnable;
    private View socialBottomBar;
    private int sourceFrom;
    String tempPath;
    private TextView titleBarTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (view == null) {
                return;
            }
            if (TroopAvatarWallPreviewActivity.this.mPublicAccountShowPictureReport.isReport) {
                TroopAvatarWallPreviewActivity.this.mPublicAccountShowPictureReport.addPicIndex(i3);
                TroopAvatarWallPreviewActivity.this.mPublicAccountShowPictureReport.slide_number++;
            }
            TroopAvatarWallPreviewActivity.this.mIndex = i3;
            String str = (TroopAvatarWallPreviewActivity.this.mIndex + 1) + "/" + TroopAvatarWallPreviewActivity.this.mSeqListLength;
            TroopAvatarWallPreviewActivity.this.mTextView.setText(str);
            if (TroopAvatarWallPreviewActivity.this.titleBarTitle != null) {
                TroopAvatarWallPreviewActivity.this.titleBarTitle.setText(str);
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
            if (troopAvatarWallPreviewActivity.mIsTroopMember) {
                ReportController.o(troopAvatarWallPreviewActivity.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, troopAvatarWallPreviewActivity.mTroopUin, "0", "", "");
            } else {
                ReportController.o(troopAvatarWallPreviewActivity.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, troopAvatarWallPreviewActivity.mTroopUin, "1", "", "");
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this;
            if (troopAvatarWallPreviewActivity2.mNeedBottomBar) {
                troopAvatarWallPreviewActivity2.updateOperateBar(troopAvatarWallPreviewActivity2.mIndex);
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity3 = TroopAvatarWallPreviewActivity.this;
            boolean z17 = troopAvatarWallPreviewActivity3.mIsShowMenu;
            if (troopAvatarWallPreviewActivity3.mExtras != null && TroopAvatarWallPreviewActivity.this.mExtras.getBoolean(TroopAvatarWallPreviewActivity.KEY_FROM_PERSONALITY_LABEL, false)) {
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity4 = TroopAvatarWallPreviewActivity.this;
                if (Long.valueOf(troopAvatarWallPreviewActivity4.mPhotoIds.get(troopAvatarWallPreviewActivity4.mIndex)).longValue() == -1) {
                    z16 = false;
                }
                troopAvatarWallPreviewActivity4.mIsShowMenu = z16;
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity5 = TroopAvatarWallPreviewActivity.this;
            boolean z18 = troopAvatarWallPreviewActivity5.mIsShowMenu;
            if (z17 != z18) {
                ImageView imageView = troopAvatarWallPreviewActivity5.mMenuBtn;
                if (!z18) {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity6 = TroopAvatarWallPreviewActivity.this;
            troopAvatarWallPreviewActivity6.setOriginButton(troopAvatarWallPreviewActivity6.mIndex);
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapterView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class aa implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        aa() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                TroopAvatarWallPreviewActivity.this.back();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public static class ab extends AsyncTask<Void, Void, Bundle> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<TroopAvatarWallPreviewActivity> f293611a;

        /* renamed from: b, reason: collision with root package name */
        protected String f293612b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f293613c;

        /* renamed from: d, reason: collision with root package name */
        protected URLDrawable f293614d;

        /* renamed from: e, reason: collision with root package name */
        protected String f293615e;

        public ab(TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity, String str, boolean z16, URLDrawable uRLDrawable, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopAvatarWallPreviewActivity, str, Boolean.valueOf(z16), uRLDrawable, str2);
                return;
            }
            this.f293611a = new WeakReference<>(troopAvatarWallPreviewActivity);
            this.f293612b = str;
            this.f293613c = z16;
            this.f293614d = uRLDrawable;
            this.f293615e = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            WeakReference<TroopAvatarWallPreviewActivity> weakReference = this.f293611a;
            if (weakReference == null || weakReference.get() == null || this.f293614d == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            String str = TroopAvatarWallPreviewActivity.IMAGE_SAVE_PATH;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + this.f293612b + Utils.Crc64String(this.f293614d.getURL().toString());
            if (!new File(str2).exists()) {
                try {
                    str2 = this.f293614d.saveTo(str2);
                } catch (IOException e16) {
                    QLog.e("foward", 2, "IOException", e16);
                    return null;
                }
            }
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, this.f293615e);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str2);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.f293614d.getURL().toString());
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, str2);
            if (this.f293613c) {
                bundle.putString(AppConstants.Key.FORWARD_THUMB, str2);
                bundle.putBoolean("key_flag_from_plugin", true);
            }
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            WeakReference<TroopAvatarWallPreviewActivity> weakReference = this.f293611a;
            if (weakReference != null && weakReference.get() != null) {
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = this.f293611a.get();
                if (bundle == null) {
                    QQToast.makeText(troopAvatarWallPreviewActivity, HardCodeUtil.qqStr(R.string.ubl), 0).show(troopAvatarWallPreviewActivity.getTitleBarHeight());
                    return;
                }
                Intent intent = new Intent();
                intent.putExtras(bundle);
                ForwardBaseOption.startForwardActivityForResult(troopAvatarWallPreviewActivity, intent, 21);
                troopAvatarWallPreviewActivity.reportPhotoWallAction("0X8006A81", "0X8006A95");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class ac extends ContentObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ContentResolver f293616a;

        public ac(Handler handler) {
            super(handler);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) handler);
            } else {
                this.f293616a = TroopAvatarWallPreviewActivity.this.getContentResolver();
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f293616a.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f293616a.unregisterContentObserver(this);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            super.onChange(z16);
            if (Settings.System.getInt(TroopAvatarWallPreviewActivity.this.getContentResolver(), "accelerometer_rotation", -1) == 1) {
                TroopAvatarWallPreviewActivity.this.setRequestedOrientation(4);
            } else {
                TroopAvatarWallPreviewActivity.this.setRequestedOrientation(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
            }
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
            if (troopAvatarWallPreviewActivity.mIsShowAction || troopAvatarWallPreviewActivity.mIsEdit) {
                troopAvatarWallPreviewActivity.showActionSheet();
            }
            return true;
        }
    }

    /* loaded from: classes19.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.fey) {
                    TroopAvatarWallPreviewActivity.this.onLikeClick();
                } else if (id5 == R.id.fev) {
                    TroopAvatarWallPreviewActivity.this.onCommentClick();
                } else if (id5 == R.id.few) {
                    TroopAvatarWallPreviewActivity.this.onDetailClick();
                } else if (id5 == R.id.ffb) {
                    TroopAvatarWallPreviewActivity.this.onBottomBarSwitchClick();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f293620d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f293621e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293622f;

        d(ActionSheet actionSheet, URLDrawable uRLDrawable) {
            this.f293621e = actionSheet;
            this.f293622f = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallPreviewActivity.this, actionSheet, uRLDrawable);
            } else {
                this.f293620d = TroopAvatarWallPreviewActivity.this.mAdapter.getItem(TroopAvatarWallPreviewActivity.this.mIndex);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String avatarAddress;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
            if (!(!iTroopAvatarUtilApi.isNumeric(this.f293620d))) {
                if (this.f293620d.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                    avatarAddress = iTroopAvatarUtilApi.getAvatarAddress(this.f293620d, TroopAvatarWallPreviewActivity.this.mTroopUin, 0);
                } else {
                    avatarAddress = iTroopAvatarUtilApi.getAvatarAddress(this.f293620d, TroopAvatarWallPreviewActivity.this.mTroopUin, 1);
                }
                iTroopAvatarUtilApi.getThumbPhoto(avatarAddress);
            }
            String content = this.f293621e.getContent(i3);
            if (TroopAvatarWallPreviewActivity.this.getString(R.string.bsj).equals(content)) {
                TroopAvatarWallPreviewActivity.this.forward(this.f293622f, this.f293620d);
                TroopAvatarWallPreviewActivity.this.reportActionSheetPanel(false, R.string.bsj, this.f293621e);
            } else if (TroopAvatarWallPreviewActivity.this.getString(R.string.bst).equals(content)) {
                TroopAvatarWallPreviewActivity.this.savePic(this.f293622f);
                TroopAvatarWallPreviewActivity.this.reportActionSheetPanel(false, R.string.bst, this.f293621e);
            } else if (TroopAvatarWallPreviewActivity.this.getString(R.string.bsr).equals(content)) {
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
                troopAvatarWallPreviewActivity.onQRDecodeSucceed(troopAvatarWallPreviewActivity.tempPath, this.f293620d);
            } else if (TroopAvatarWallPreviewActivity.this.getString(R.string.eve).equals(content)) {
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this;
                troopAvatarWallPreviewActivity2.setDefaultAvatar(troopAvatarWallPreviewActivity2.mIndex);
            } else if (TroopAvatarWallPreviewActivity.this.getString(R.string.bsg).equals(content)) {
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity3 = TroopAvatarWallPreviewActivity.this;
                if (troopAvatarWallPreviewActivity3.mDeleteAbility && troopAvatarWallPreviewActivity3.mExtras != null && TroopAvatarWallPreviewActivity.this.mExtras.getBoolean(TroopAvatarWallPreviewActivity.KEY_FROM_PERSONALITY_LABEL, false)) {
                    TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity4 = TroopAvatarWallPreviewActivity.this;
                    troopAvatarWallPreviewActivity4.deletePernalityLabelPhoto(troopAvatarWallPreviewActivity4.mIndex, troopAvatarWallPreviewActivity4.mExtras);
                } else {
                    TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity5 = TroopAvatarWallPreviewActivity.this;
                    if (troopAvatarWallPreviewActivity5.mDeleteAbility && troopAvatarWallPreviewActivity5.mExtras != null && TroopAvatarWallPreviewActivity.this.mExtras.getBoolean(TroopAvatarWallPreviewActivity.KEY_FROM_EXTEND_FRIEND_EDIT, false)) {
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity6 = TroopAvatarWallPreviewActivity.this;
                        troopAvatarWallPreviewActivity6.deleteExtendFriendPhotoWall(troopAvatarWallPreviewActivity6.mIndex);
                    } else {
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity7 = TroopAvatarWallPreviewActivity.this;
                        if (troopAvatarWallPreviewActivity7.mDeleteAbility && troopAvatarWallPreviewActivity7.canDelete(troopAvatarWallPreviewActivity7.mIndex)) {
                            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity8 = TroopAvatarWallPreviewActivity.this;
                            troopAvatarWallPreviewActivity8.deletePhotoWall(troopAvatarWallPreviewActivity8.mIndex);
                        } else {
                            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity9 = TroopAvatarWallPreviewActivity.this;
                            troopAvatarWallPreviewActivity9.setDefaultAvatar(troopAvatarWallPreviewActivity9.mIndex);
                        }
                    }
                }
            }
            this.f293621e.dismiss();
            TroopAvatarWallPreviewActivity.this.reportActionSheetPanel(false, R.string.cancel, this.f293621e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f293624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f293626f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f293627h;

        e(ActionSheet actionSheet, URLDrawable uRLDrawable, String str, String str2) {
            this.f293624d = actionSheet;
            this.f293625e = uRLDrawable;
            this.f293626f = str;
            this.f293627h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallPreviewActivity.this, actionSheet, uRLDrawable, str, str2);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (TroopAvatarWallPreviewActivity.this.getString(R.string.bst).equals(this.f293624d.getContent(i3))) {
                TroopAvatarWallPreviewActivity.this.savePic(this.f293625e);
            } else {
                if (!TextUtils.isEmpty(this.f293626f)) {
                    ProfileCardUtil.f0(TroopAvatarWallPreviewActivity.this, Long.parseLong(this.f293626f), "0", null, 20006);
                } else if (!TextUtils.isEmpty(this.f293627h) && !"0".equals(this.f293627h)) {
                    ProfileCardUtil.f0(TroopAvatarWallPreviewActivity.this, 0L, this.f293627h, null, 20006);
                } else {
                    QQToast.makeText(TroopAvatarWallPreviewActivity.this, 2, HardCodeUtil.qqStr(R.string.ubk), 0).show();
                }
                ReportController.o(null, "dc00899", "grp_lbs", this.f293626f, "video", "clk_rep", 0, 0, "", "", "", "");
            }
            this.f293624d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class f extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f293629a;

        f(Runnable runnable) {
            this.f293629a = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) runnable);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f293629a.run();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293632d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f293633e;

        h(URLDrawable uRLDrawable, String str) {
            this.f293632d = uRLDrawable;
            this.f293633e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallPreviewActivity.this, uRLDrawable, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAvatarWallPreviewActivity.this.savePhoto(this.f293632d, this.f293633e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class i extends AsyncTask<Void, Void, String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293635a;

        i(URLDrawable uRLDrawable) {
            this.f293635a = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) uRLDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            if (ap.a(TroopAvatarWallPreviewActivity.this, this.f293635a)) {
                if (TroopAvatarWallPreviewActivity.this.getIntent().getBooleanExtra("from_photo_wall", false)) {
                    return HardCodeUtil.qqStr(R.string.ubm);
                }
                return TroopAvatarWallPreviewActivity.this.getString(R.string.cwj);
            }
            return TroopAvatarWallPreviewActivity.this.getString(R.string.cwi);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                QQToast.makeText(TroopAvatarWallPreviewActivity.this, str, 0).show(TroopAvatarWallPreviewActivity.this.getTitleBarHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f293638d;

        k(int i3) {
            this.f293638d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, i3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            String str = TroopAvatarWallPreviewActivity.this.mPhotoIds.get(this.f293638d);
            long parseLong = Long.parseLong(TroopAvatarWallPreviewActivity.this.mPhotoTimes.get(this.f293638d));
            IProfileCardApi iProfileCardApi = (IProfileCardApi) QRoute.api(IProfileCardApi.class);
            QQAppInterface qQAppInterface = TroopAvatarWallPreviewActivity.this.app;
            iProfileCardApi.photoWallDelQzonePhotoWall(qQAppInterface, qQAppInterface.getCurrentAccountUin(), str, parseLong);
            if (!TroopAvatarWallPreviewActivity.this.isFinishing()) {
                TroopAvatarWallPreviewActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ArrayList arrayList = TroopAvatarWallPreviewActivity.this.extendFriendDeletePathList;
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
                arrayList.add(troopAvatarWallPreviewActivity.mSeqNumList.get(troopAvatarWallPreviewActivity.mIndex));
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this;
                troopAvatarWallPreviewActivity2.mSeqNumList.remove(troopAvatarWallPreviewActivity2.mIndex);
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity3 = TroopAvatarWallPreviewActivity.this;
                troopAvatarWallPreviewActivity3.mSeqListLength = troopAvatarWallPreviewActivity3.mSeqNumList.size();
                Intent intent = TroopAvatarWallPreviewActivity.this.getIntent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_EXTEND_FRIEND_DELETE_PATH_LIST, TroopAvatarWallPreviewActivity.this.extendFriendDeletePathList);
                intent.putExtras(bundle);
                TroopAvatarWallPreviewActivity.this.setResult(-1, intent);
                if (TroopAvatarWallPreviewActivity.this.mAdapter.getCount() == 0) {
                    TroopAvatarWallPreviewActivity.this.finish();
                    return;
                }
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity4 = TroopAvatarWallPreviewActivity.this;
                if (troopAvatarWallPreviewActivity4.mIndex >= troopAvatarWallPreviewActivity4.mAdapter.getCount()) {
                    TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity5 = TroopAvatarWallPreviewActivity.this;
                    troopAvatarWallPreviewActivity5.mIndex--;
                }
                TroopAvatarWallPreviewActivity.this.mAdapter.notifyDataSetChanged();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class n implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                TroopAvatarWallPreviewActivity.this.mAnimationView.setVisibility(4);
                TroopAvatarWallPreviewActivity.this.finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                TroopAvatarWallPreviewActivity.this.mGallery.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class o implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            TroopAvatarWallPreviewActivity.this.animated = false;
            animation.setAnimationListener(null);
            TroopAvatarWallPreviewActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* loaded from: classes19.dex */
    class p extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent != null && intent.getAction().equals("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete")) {
                TroopAvatarWallPreviewActivity.this.finish();
            }
        }
    }

    /* loaded from: classes19.dex */
    class q implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* loaded from: classes19.dex */
        class a implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ActionSheet f293646d;

            a(ActionSheet actionSheet) {
                this.f293646d = actionSheet;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this, (Object) actionSheet);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (i3 == 0) {
                    TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
                    troopAvatarWallPreviewActivity.deletePic(troopAvatarWallPreviewActivity.mIndex);
                }
                this.f293646d.dismiss();
            }
        }

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.bf5) {
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(TroopAvatarWallPreviewActivity.this, null);
                    actionSheet.addButton(R.string.bsg, 3);
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new a(actionSheet));
                    actionSheet.show();
                } else if (id5 == R.id.f164122k9) {
                    TroopAvatarWallPreviewActivity.this.showActionSheet();
                } else if (id5 == R.id.ffl) {
                    TroopAvatarWallPreviewActivity.this.downloadOrgImage();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class s implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f293649d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f293650e;

        s(Bundle bundle, int i3) {
            this.f293649d = bundle;
            this.f293650e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallPreviewActivity.this, bundle, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ((PersonalityLabelHandler) TroopAvatarWallPreviewActivity.this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).E2(TroopAvatarWallPreviewActivity.this.app.getCurrentAccountUin(), this.f293649d.getLong("label_id", 0L), Long.valueOf(TroopAvatarWallPreviewActivity.this.mPhotoIds.get(this.f293650e)).longValue());
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
            troopAvatarWallPreviewActivity.showWaitingDialog(troopAvatarWallPreviewActivity.getResources().getString(R.string.akr));
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this;
            troopAvatarWallPreviewActivity2.addObserver(troopAvatarWallPreviewActivity2.mPersonalityLabelObserver);
        }
    }

    /* loaded from: classes19.dex */
    class t extends com.tencent.mobileqq.profile.PersonalityLabel.c {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
        public void onDelPersonalityLabelPhoto(boolean z16, String str, long j3, long j16) {
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity;
            int i3;
            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2;
            ArrayList<String> arrayList;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TroopAvatarWallPreviewActivity.TAG, 2, "onDelPersonalityLabelPhoto,suc:" + z16 + "," + str + "," + j3 + "," + j16);
            }
            if (str.equals(TroopAvatarWallPreviewActivity.this.app.getCurrentAccountUin()) && TroopAvatarWallPreviewActivity.this.mExtras != null && (i3 = (troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this).mIndex) >= 0 && i3 <= troopAvatarWallPreviewActivity.mAdapter.getCount() - 1 && (arrayList = (troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this).mPhotoIds) != null && troopAvatarWallPreviewActivity2.mIndex <= arrayList.size() - 1) {
                long j17 = TroopAvatarWallPreviewActivity.this.mExtras.getLong("label_id", 0L);
                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity3 = TroopAvatarWallPreviewActivity.this;
                long longValue = Long.valueOf(troopAvatarWallPreviewActivity3.mPhotoIds.get(troopAvatarWallPreviewActivity3.mIndex)).longValue();
                if (j17 == j3 && longValue == j16) {
                    TroopAvatarWallPreviewActivity.this.dismissWaittingDialog();
                    TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity4 = TroopAvatarWallPreviewActivity.this;
                    Resources resources = troopAvatarWallPreviewActivity4.getResources();
                    if (z16) {
                        i16 = R.string.bcx;
                    } else {
                        i16 = R.string.ak5;
                    }
                    troopAvatarWallPreviewActivity4.showToast(resources.getString(i16));
                    if (z16) {
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity5 = TroopAvatarWallPreviewActivity.this;
                        troopAvatarWallPreviewActivity5.mPhotoIds.remove(troopAvatarWallPreviewActivity5.mIndex);
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity6 = TroopAvatarWallPreviewActivity.this;
                        troopAvatarWallPreviewActivity6.mSeqNumList.remove(troopAvatarWallPreviewActivity6.mIndex);
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity7 = TroopAvatarWallPreviewActivity.this;
                        troopAvatarWallPreviewActivity7.mSeqListLength = troopAvatarWallPreviewActivity7.mSeqNumList.size();
                        if (TroopAvatarWallPreviewActivity.this.mPhotoIds.size() == 0) {
                            TroopAvatarWallPreviewActivity.this.finish();
                        }
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity8 = TroopAvatarWallPreviewActivity.this;
                        if (troopAvatarWallPreviewActivity8.mIndex >= troopAvatarWallPreviewActivity8.mAdapter.getCount()) {
                            TroopAvatarWallPreviewActivity.this.mIndex--;
                        }
                        TroopAvatarWallPreviewActivity.this.mTextView.setText((TroopAvatarWallPreviewActivity.this.mIndex + 1) + "/" + TroopAvatarWallPreviewActivity.this.mSeqListLength);
                        TroopAvatarWallPreviewActivity.this.mAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class u implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopAvatarWallPreviewActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class v implements Observer<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f293654d;

        v(TextView textView) {
            this.f293654d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) textView);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f293654d.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class w implements Observer<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f293656d;

        w(TextView textView) {
            this.f293656d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) textView);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f293656d.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class x implements Observer<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f293658d;

        x(TextView textView) {
            this.f293658d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) textView);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f293658d.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class y implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class z implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.f86804sn) {
                    TroopAvatarWallPreviewActivity.this.pictureShowViewModel.c2();
                } else if (id5 == R.id.f86824sp) {
                    TroopAvatarWallPreviewActivity.this.pictureShowViewModel.d2();
                } else if (id5 == R.id.f86854ss) {
                    TroopAvatarWallPreviewActivity.this.pictureShowViewModel.e2();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        IMAGE_SAVE_PATH = BaseApplication.getContext().getFilesDir().getPath() + "/Tencent/QQ_Images/";
        mIsOpen = false;
        sLock = new Object();
    }

    public TroopAvatarWallPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsBottomBarUp = true;
        this.mDeleteAbility = false;
        this.mNeedBottomBar = false;
        this.mIsTroopMember = false;
        this.mIsEdit = false;
        this.mEnterAnimationDuring = 300L;
        this.isShowContentUrl = false;
        this.isGridImageReport = false;
        this.mPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
        this.isNeedToAio = true;
        this.isFromPlugin = false;
        this.extendFriendDeletePathList = new ArrayList<>();
        this.operateBarListener = new c();
        this.animated = false;
        this.setAnimateFlagRunnable = null;
        this.mReceiver = new p();
        this.mClickLis = new q();
        this.mPersonalityLabelObserver = new t();
    }

    private boolean applyExitAnimation() {
        View selectedView = this.mGallery.getSelectedView();
        if (selectedView == null) {
            return false;
        }
        Drawable drawable = ((ImageView) selectedView.findViewById(R.id.image)).getDrawable();
        if (drawable != null && (drawable instanceof URLDrawable)) {
            if (((URLDrawable) drawable).getStatus() != 1) {
                return false;
            }
        } else if (drawable == null) {
            return false;
        }
        this.mRootParent.setVisibility(0);
        this.mAnimationView.setVisibility(0);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        Bitmap makeAnimationRect = makeAnimationRect(rect3, rect4, rect, rect2, drawable, drawable instanceof URLDrawable);
        if (makeAnimationRect == null) {
            return false;
        }
        this.animated = true;
        this.mAnimationView.a(makeAnimationRect, rect4, rect3, rect2, rect, this.mEnterAnimationDuring);
        this.mAnimationView.setInterpolator(new DecelerateInterpolator());
        this.mAnimationView.setAnimationListener(new n());
        this.mAnimationView.b();
        this.mRootParent.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.27
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    TroopAvatarWallPreviewActivity.this.animated = false;
                }
            }
        }, this.mEnterAnimationDuring);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        this.mBgView.startAnimation(alphaAnimation);
        return true;
    }

    private void configDtReportParam() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(KEY_DT_PG_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this, stringExtra);
        Serializable serializableExtra = intent.getSerializableExtra(KEY_DT_PG_PARAMS);
        if (serializableExtra instanceof Map) {
            VideoReport.setPageParams(this, new PageParams((HashMap) serializableExtra));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteExtendFriendPhotoWall(int i3) {
        if (i3 < 0 && i3 > this.mAdapter.getCount() - 1) {
            return;
        }
        DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.f198734ni)).setPositiveButton(getString(R.string.f171151ok), new m()).setNegativeButton(getString(R.string.cancel), new l()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePernalityLabelPhoto(int i3, Bundle bundle) {
        ArrayList<String> arrayList;
        if (i3 >= 0 && i3 <= this.mAdapter.getCount() - 1 && (arrayList = this.mPhotoIds) != null && i3 <= arrayList.size() - 1) {
            ReportController.o(this.app, "dc00898", "", "", "0X8007FD5", "0X8007FD5", 0, 0, "0", "0", "", "");
            DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.fpl)).setPositiveButton(getString(R.string.f171151ok), new s(bundle, i3)).setNegativeButton(getString(R.string.cancel), new r()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaittingDialog() {
        QQProgressDialog qQProgressDialog = this.mProgressDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && !isFinishing()) {
            this.mProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadOrgImage() {
        ArrayList<String> arrayList = this.mOriginList;
        if (arrayList != null && this.mIndex < arrayList.size() && !TextUtils.isEmpty(this.mOriginList.get(this.mIndex))) {
            this.mAdapter.h(true);
            this.mAdapter.k(this.mOriginPicBtn);
            this.mAdapter.notifyDataSetChanged();
            LpReportInfo_pf00064.allReport(301, 34, 2);
        }
    }

    private void executeIfGrantPermission(Runnable runnable) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_COMMON_COMPONENT, QQPermissionConstants.Business.SCENE.QQ_TROOP_COMMON));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new f(runnable));
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        List<String> list;
        if (isFinishing()) {
            return;
        }
        this.imageView = (ImageView) findViewById(R.id.image);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.mPublicAccountShowPictureReport.parse(extras.getString("PublicAccountShowPictureReport"));
        PublicAccountShowPictureReport publicAccountShowPictureReport = this.mPublicAccountShowPictureReport;
        if (publicAccountShowPictureReport.isReport) {
            publicAccountShowPictureReport.showStart();
        }
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        this.mGallery = gallery;
        gallery.setVisibility(0);
        this.mTextView = (TextView) findViewById(R.id.jfb);
        this.mRoot = (RelativeLayout) findViewById(R.id.root);
        this.mBottomBlock = (RelativeLayout) findViewById(R.id.ac7);
        this.mBgView = findViewById(R.id.a4f);
        this.mRootParent = (FrameLayout) findViewById(R.id.ier);
        this.mDelbtn = (ImageButton) findViewById(R.id.bf5);
        this.mBgView.setBackgroundColor(-16777216);
        this.mAnimationView = (ImageAnimationView) findViewById(R.id.f164333s8);
        this.mMenuBtn = (ImageView) findViewById(R.id.f164122k9);
        this.mBottomBarSwitch = findViewById(R.id.ffb);
        TextView textView = (TextView) findViewById(R.id.ffl);
        this.mOriginPicBtn = textView;
        textView.setOnClickListener(this.mClickLis);
        this.mPhotoDesc = (TextView) findViewById(R.id.fsb);
        this.mRootParent.setVisibility(0);
        boolean z16 = extras.getBoolean("IS_EDIT");
        this.mIsEdit = z16;
        if (z16) {
            this.mDelbtn.setVisibility(0);
            this.mDelbtn.setOnClickListener(this.mClickLis);
        } else {
            this.mDelbtn.setVisibility(4);
        }
        boolean z17 = extras.getBoolean("SHOW_MENU");
        this.mIsShowMenu = z17;
        if (z17) {
            this.mMenuBtn.setImageResource(R.drawable.aio_gallery_more);
            this.mMenuBtn.setOnClickListener(this.mClickLis);
            this.mMenuBtn.setVisibility(0);
        } else {
            this.mMenuBtn.setVisibility(4);
        }
        this.mBottomBarSwitch.setOnClickListener(this.operateBarListener);
        this.mThumbRect = extras.getParcelableArrayList("KEY_THUMBNAL_BOUND");
        this.mIsShowAction = extras.getBoolean("is_show_action", true);
        this.mIsFromQSearch = TextUtils.equals(extras.getString("is_from_qsearch"), "1");
        this.isNeedToAio = extras.getBoolean(KEY_NEED_TO_AIO, true);
        this.isFromPlugin = extras.getBoolean("is_from_plugin", false);
        boolean z18 = extras.getBoolean("needBottomBar");
        this.mNeedBottomBar = z18;
        if (z18) {
            View inflate = ((ViewStub) findViewById(R.id.j5k)).inflate();
            this.mBottomBar = inflate.findViewById(R.id.fex);
            this.mLikeBtn = (ImageView) inflate.findViewById(R.id.fey);
            this.mCommentBtn = (ImageView) inflate.findViewById(R.id.fev);
            this.mDetailBtn = (TextView) inflate.findViewById(R.id.few);
            this.mBottomBar.setBackgroundResource(R.drawable.f161193rz);
            this.mLikeBtn.setOnClickListener(this.operateBarListener);
            this.mCommentBtn.setOnClickListener(this.operateBarListener);
            this.mDetailBtn.setOnClickListener(this.operateBarListener);
            this.mBottomBar.setVisibility(0);
            this.mBottomBarSwitch.setVisibility(0);
            ((ImageView) this.mBottomBarSwitch).setImageResource(R.drawable.gbt);
            registerReceiver(this.mReceiver, new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete"));
        } else {
            this.mBottomBarSwitch.setVisibility(8);
        }
        this.mLikes = extras.getBooleanArray("likes");
        this.mAdapter = new com.tencent.mobileqq.troop.widget.g(this, this.app);
        this.mTroopUin = extras.getString("troop_uin");
        this.mIsTroopMember = extras.getBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER);
        this.mSeqNumList = extras.getStringArrayList(KEY_SEQ_NUM);
        this.mPreviewPhotoLocation = extras.getIntegerArrayList("mPreviewPhotoLocation");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = obtain.mFailedDrawable;
        ArrayList<Integer> arrayList = this.mPreviewPhotoLocation;
        if (arrayList != null) {
            obtain.mRequestWidth = arrayList.get(2).intValue();
            obtain.mRequestHeight = this.mPreviewPhotoLocation.get(3).intValue();
        }
        if (QLog.isColorLevel() && (list = this.mSeqNumList) != null && !list.isEmpty()) {
            QLog.d(TAG, 2, "Clicl Big Data: first img url:" + this.mSeqNumList.get(0));
        }
        this.mDescs = extras.getStringArrayList("descs");
        this.mPhotoIds = extras.getStringArrayList("photoIds");
        this.mPhotoTimes = extras.getStringArrayList("photoTimes");
        this.mDeleteAbility = extras.getBoolean(IProfileCardConst.KEY_DELETE_ABILITY);
        this.mIsNotShowIndex = extras.getBoolean(KEY_IS_NOT_SHOW_INDEX, true);
        this.mSrcId = extras.getString("src_id");
        this.mExtras = extras.getBundle(KEY_BUNDLE_DATA_EXTRA);
        this.mExtrasStr = extras.getString(KEY_STR_DATA_EXTRA, "");
        this.mOriginList = extras.getStringArrayList(KEY_ORIGIN_LIST);
        this.mOriginSizeList = extras.getStringArrayList(KEY_ORIGIN_SIZE_LIST);
        this.mIsFromPhotoWall = extras.getBoolean("from_photo_wall", false);
        Bundle bundle = this.mExtras;
        if (bundle != null && bundle.getBoolean(KEY_FROM_EXTEND_FRIEND_EDIT, false)) {
            this.mMenuBtn.setImageResource(R.drawable.f160123ml0);
        }
        if (this.mOriginList == null && !this.mIsFromPhotoWall) {
            this.mOriginPicBtn.setVisibility(0);
        }
        String str = this.mSrcId;
        if (str != null) {
            ReportController.o(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, str, "", "", "");
        }
        List<String> list2 = this.mSeqNumList;
        if (list2 != null) {
            this.mSeqListLength = list2.size();
        }
        if (this.mIsNotShowIndex) {
            this.mTextView.setVisibility(4);
        } else {
            this.mTextView.setVisibility(0);
            if (extras.getBoolean("is_index_show_bottom", false) && (this.mTextView.getParent() instanceof RelativeLayout)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTextView.getLayoutParams();
                layoutParams.addRule(10);
                layoutParams.addRule(12, 0);
                layoutParams.setMargins(0, BaseAIOUtils.f(20.0f, getResources()) + ImmersiveUtils.getStatusBarHeight(this), 0, 0);
                this.mTextView.setLayoutParams(layoutParams);
            }
        }
        this.isShowContentUrl = extras.getBoolean("is_show_content_url", false);
        this.isGridImageReport = extras.getBoolean("is_grid_image_report", false);
        if (this.mIsFromPhotoWall) {
            initGallery(extras);
        }
        ThreadManagerV2.post(new Runnable(extras) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f293606d;

            {
                this.f293606d = extras;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this, (Object) extras);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface = TroopAvatarWallPreviewActivity.this.app;
                if (qQAppInterface == null) {
                    return;
                }
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, "troop_" + TroopAvatarWallPreviewActivity.this.mTroopUin);
                createEntityManager.close();
                TroopAvatarWallPreviewActivity.this.runOnUiThread(new Runnable(setting) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Setting f293607d;

                    {
                        this.f293607d = setting;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) setting);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (TroopAvatarWallPreviewActivity.this.isFinishing()) {
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
                        if (!troopAvatarWallPreviewActivity.mIsFromPhotoWall) {
                            troopAvatarWallPreviewActivity.initGallery(anonymousClass2.f293606d);
                            TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity2 = TroopAvatarWallPreviewActivity.this;
                            troopAvatarWallPreviewActivity2.mAdapter.p(troopAvatarWallPreviewActivity2.mTroopUin, this.f293607d);
                        }
                    }
                });
            }
        }, 8, null, true);
        if (isSrcIdSupportRotate()) {
            ac acVar = new ac(new Handler());
            this.mRotationObserver = acVar;
            acVar.a();
            if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", -1) == 1) {
                setRequestedOrientation(4);
            }
        }
        configDtReportParam();
        if (extras.getBoolean(KEY_SHOW_TITLE_BAR)) {
            initTitleBar(this.mIndex, this.mSeqListLength);
        }
        initSocialBottomBar(extras);
    }

    private void initFooterAnimation(boolean z16) {
        if (this.mBottomBar != null) {
            if (z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.mBottomBar.getHeight());
                this.mBottomLayoutTranslateDownAnimation = translateAnimation;
                translateAnimation.setDuration(300L);
                this.mBottomLayoutTranslateDownAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.12
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                            return;
                        }
                        View view = TroopAvatarWallPreviewActivity.this.mBottomBar;
                        if (view == null) {
                            return;
                        }
                        view.post(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.12.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass12.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                View view2 = TroopAvatarWallPreviewActivity.this.mBottomBar;
                                if (view2 == null) {
                                    return;
                                }
                                view2.setVisibility(8);
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                            return;
                        }
                        TextView textView = TroopAvatarWallPreviewActivity.this.mPhotoDesc;
                        if (textView == null) {
                            return;
                        }
                        textView.setVisibility(8);
                    }
                });
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, this.mBottomBar.getHeight(), 0.0f);
            this.mBottomLayoutTranslateUpAnimation = translateAnimation2;
            translateAnimation2.setDuration(300L);
            this.mBottomLayoutTranslateUpAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                        return;
                    }
                    View view = TroopAvatarWallPreviewActivity.this.mBottomBar;
                    if (view == null) {
                        return;
                    }
                    view.post(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.13.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            View view2 = TroopAvatarWallPreviewActivity.this.mBottomBar;
                            if (view2 == null) {
                                return;
                            }
                            view2.setVisibility(0);
                            TextView textView = TroopAvatarWallPreviewActivity.this.mPhotoDesc;
                            if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                                TroopAvatarWallPreviewActivity.this.mPhotoDesc.setVisibility(0);
                            }
                        }
                    });
                }
            });
        }
    }

    private void initSocialBottomBar(Bundle bundle) {
        com.tencent.mobileqq.troop.viewmodel.a bVar;
        if (bundle == null) {
            return;
        }
        boolean z16 = bundle.getBoolean(KEY_SHOW_SOCIAL_BOTTOM_BAR);
        String string = bundle.getString(KEY_SHOW_SOCIAL_BOTTOM_BAR_DATA);
        if (z16 && !TextUtils.isEmpty(string)) {
            try {
                String string2 = bundle.getString(KEY_ACTICLE_INFO_ROWKEY, "");
                String string3 = bundle.getString(KEY_CALLBACK_SEQ, "");
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("commentNum", "0");
                String optString2 = jSONObject.optString("likeNum", "0");
                String optString3 = jSONObject.optString("shareNum", "0");
                boolean optBoolean = jSONObject.optBoolean("liked", false);
                View inflate = ((ViewStub) findViewById(R.id.f86794sm)).inflate();
                this.socialBottomBar = inflate;
                View findViewById = inflate.findViewById(R.id.f86804sn);
                View findViewById2 = this.socialBottomBar.findViewById(R.id.f86824sp);
                View findViewById3 = this.socialBottomBar.findViewById(R.id.f86854ss);
                TextView textView = (TextView) this.socialBottomBar.findViewById(R.id.f86814so);
                TextView textView2 = (TextView) this.socialBottomBar.findViewById(R.id.f86844sr);
                TextView textView3 = (TextView) this.socialBottomBar.findViewById(R.id.f86864st);
                com.tencent.mobileqq.troop.viewmodel.d dVar = new com.tencent.mobileqq.troop.viewmodel.d(string2, string3, optString, optString2, optString3, optBoolean);
                if (bundle.getBoolean(KEY_IS_FROM_TOOL_PROCESS, false)) {
                    bVar = new com.tencent.mobileqq.troop.viewmodel.e(getAppRuntime());
                } else {
                    bVar = new com.tencent.mobileqq.troop.viewmodel.b();
                }
                PictureShowViewModel pictureShowViewModel = (PictureShowViewModel) new ViewModelProvider(this, new com.tencent.mobileqq.troop.viewmodel.c(dVar, bVar)).get(PictureShowViewModel.class);
                this.pictureShowViewModel = pictureShowViewModel;
                pictureShowViewModel.Q1().observe(this, new v(textView));
                this.pictureShowViewModel.R1().observe(this, new w(textView2));
                this.pictureShowViewModel.T1().observe(this, new x(textView3));
                this.pictureShowViewModel.S1().observe(this, new y());
                z zVar = new z();
                findViewById.setOnClickListener(zVar);
                findViewById2.setOnClickListener(zVar);
                findViewById3.setOnClickListener(zVar);
            } catch (JSONException e16) {
                QLog.e(TAG, 2, e16, new Object[0]);
            }
        }
    }

    private void initTitleBar(int i3, int i16) {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this);
        View inflate = ((ViewStub) findViewById(R.id.jo9)).inflate();
        ((RelativeLayout.LayoutParams) inflate.getLayoutParams()).topMargin = statusBarHeight;
        View findViewById = inflate.findViewById(R.id.jo_);
        this.titleBarTitle = (TextView) inflate.findViewById(R.id.f98335mt);
        findViewById.setOnClickListener(new u());
        this.titleBarTitle.setText((i3 + 1) + "/" + i16);
    }

    private boolean isDarkModeAdapter() {
        if (this.sourceFrom == 1 && com.tencent.relation.common.utils.f.b()) {
            return true;
        }
        return false;
    }

    private boolean isSrcIdSupportRotate() {
        if (!"2".equals(this.mSrcId) && !"4".equals(this.mSrcId)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forward$0(URLDrawable uRLDrawable, String str) {
        new ab(this, this.mTroopUin, this.isFromPlugin, uRLDrawable, str).execute(new Void[0]);
    }

    private Bitmap makeAnimationRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, Drawable drawable, boolean z16) {
        Drawable drawable2;
        int intrinsicWidth;
        int intrinsicHeight;
        int i3;
        ArrayList<Rect> arrayList = this.mThumbRect;
        if (arrayList != null) {
            Rect rect5 = arrayList.get(this.mIndex);
            String thumbPath = getThumbPath(z16);
            if (thumbPath != null && rect5 != null) {
                String bigPath = getBigPath(z16);
                if (thumbPath.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                    drawable2 = drawable;
                } else {
                    drawable2 = getDrawable(z16, thumbPath);
                }
                if (drawable2 == null) {
                    return null;
                }
                if (drawable == null && !z16) {
                    return null;
                }
                int i16 = 1;
                if (drawable == null) {
                    if (TextUtils.isEmpty(bigPath) || bigPath.equals(com.tencent.mobileqq.troop.avatar.a.f294527k) || (drawable = getDrawable(z16, bigPath)) == null) {
                        return null;
                    }
                    ((URLDrawable) drawable).setAutoDownload(true);
                }
                int width = this.mGallery.getWidth();
                int height = this.mGallery.getHeight();
                if (drawable2.getIntrinsicWidth() == 0) {
                    intrinsicWidth = 1;
                } else {
                    intrinsicWidth = drawable2.getIntrinsicWidth();
                }
                if (drawable2.getIntrinsicHeight() == 0) {
                    intrinsicHeight = 1;
                } else {
                    intrinsicHeight = drawable2.getIntrinsicHeight();
                }
                Rect d16 = com.tencent.common.galleryactivity.j.d(this.mGallery);
                if (d16 != null) {
                    rect5.offset(d16.left, -d16.top);
                }
                rect3.set(rect5);
                if (z16 && ((URLDrawable) drawable).getStatus() == 1) {
                    if (drawable.getIntrinsicWidth() == 0) {
                        i3 = 1;
                    } else {
                        i3 = drawable.getIntrinsicWidth();
                    }
                    if (drawable.getIntrinsicHeight() != 0) {
                        i16 = drawable.getIntrinsicHeight();
                    }
                } else {
                    i16 = intrinsicHeight;
                    i3 = intrinsicWidth;
                }
                float e16 = Cdo.e(i3, i16);
                rect.set(Cdo.d(intrinsicWidth, intrinsicHeight, i3, i16));
                rect2.set(Cdo.c(i3, i16, width, height));
                rect4.set(Cdo.b(i3, i16, width, height));
                Cdo.f(rect, e16);
                Cdo.f(rect2, e16);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap((int) (i3 * e16), (int) (i16 * e16), Bitmap.Config.ARGB_4444);
                    Canvas canvas = new Canvas(createBitmap);
                    Rect rect6 = new Rect(0, 0, i3, i16);
                    Cdo.f(rect6, e16);
                    drawable.setBounds(rect6);
                    canvas.clipRect(Cdo.a(rect, rect2));
                    drawable.draw(canvas);
                    return createBitmap;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + th5.getMessage());
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBottomBarSwitchClick() {
        if (this.mBottomBar.getVisibility() == 0) {
            ((ImageView) this.mBottomBarSwitch).setImageResource(R.drawable.gbt);
            if (this.mBottomLayoutTranslateDownAnimation == null) {
                initFooterAnimation(true);
            }
            this.mBottomBar.startAnimation(this.mBottomLayoutTranslateDownAnimation);
            this.mIsBottomBarUp = false;
            return;
        }
        ((ImageView) this.mBottomBarSwitch).setImageResource(R.drawable.gbu);
        if (this.mBottomLayoutTranslateUpAnimation == null) {
            initFooterAnimation(false);
        }
        this.mBottomBar.startAnimation(this.mBottomLayoutTranslateUpAnimation);
        this.mIsBottomBarUp = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCommentClick() {
        Intent intent = new Intent("android.intent.action.WEBJSCALL");
        intent.putExtra("callback", "{op:1,index:" + this.mIndex + "}");
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDetailClick() {
        Intent intent = new Intent("android.intent.action.WEBJSCALL");
        intent.putExtra("callback", "{op:3,index:" + this.mIndex + "}");
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLikeClick() {
        boolean[] zArr = this.mLikes;
        if (zArr != null) {
            int length = zArr.length;
            int i3 = this.mIndex;
            if (length > i3) {
                if (!zArr[i3]) {
                    this.mLikeBtn.setImageResource(R.drawable.gbx);
                    this.mLikeBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.f155025h2));
                } else {
                    this.mLikeBtn.setImageResource(R.drawable.f162300gc0);
                }
                this.mLikes[this.mIndex] = !r0[r1];
                Intent intent = new Intent("android.intent.action.WEBJSCALL");
                intent.putExtra("callback", "{op:2,index:" + this.mIndex + "}");
                sendBroadcast(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportActionSheetPanel(boolean z16, int i3, ActionSheet actionSheet) {
        if (!this.mIsFromQSearch) {
            return;
        }
        VideoReport.setElementId(actionSheet, QCircleDaTongConstant.ElementId.EM_XSJ_PIC_VIEW_OPTION_PANEL);
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_name", getString(i3));
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_QQ_PIC_VIEW_PAGE);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PIC_VIEW_OPTION_PANEL);
        if (z16) {
            VideoReport.reportEvent("ev_xsj_abnormal_imp", actionSheet, hashMap);
        } else {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", actionSheet, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPhotoWallAction(String str, String str2) {
        if (getIntent().getBooleanExtra("from_photo_wall", false)) {
            if (getIntent().getBooleanExtra(IProfileCardConst.KEY_DELETE_ABILITY, false)) {
                ReportController.o(this.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public void savePhoto(URLDrawable uRLDrawable, String str) {
        new i(uRLDrawable).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePic(final URLDrawable uRLDrawable) {
        executeIfGrantPermission(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                TroopAvatarWallPreviewActivity.this.lambda$savePic$1(uRLDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setOriginButton(int i3) {
        long j3;
        ArrayList<String> arrayList = this.mOriginList;
        if (arrayList != null && i3 < arrayList.size() && !TextUtils.isEmpty(this.mOriginList.get(i3)) && AbsDownloader.getFile(this.mOriginList.get(i3)) == null) {
            ArrayList<String> arrayList2 = this.mOriginSizeList;
            if (arrayList2 != null && !TextUtils.isEmpty(arrayList2.get(i3))) {
                try {
                    j3 = Integer.parseInt(this.mOriginSizeList.get(i3));
                } catch (Exception e16) {
                    QLog.e(TAG, 2, "setOriginButton exception", e16);
                }
                if (j3 <= 0) {
                    this.mOriginPicBtn.setText(String.format(Locale.CHINA, getResources().getString(R.string.d0d), com.tencent.mobileqq.filemanager.util.q.g(j3)));
                } else {
                    this.mOriginPicBtn.setText(R.string.d0a);
                }
                this.mOriginPicBtn.setVisibility(0);
                LpReportInfo_pf00064.allReport(301, 34, 1);
                return;
            }
            j3 = -1;
            if (j3 <= 0) {
            }
            this.mOriginPicBtn.setVisibility(0);
            LpReportInfo_pf00064.allReport(301, 34, 1);
            return;
        }
        this.mOriginPicBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionSheet() {
        Gallery gallery = this.mGallery;
        if (gallery == null) {
            QQToast.makeText(this, getString(R.string.boo), 0).show();
            return;
        }
        View selectedView = gallery.getSelectedView();
        if (selectedView == null) {
            QQToast.makeText(this, getString(R.string.boo), 0).show();
            return;
        }
        Drawable drawable = ((ImageView) selectedView.findViewById(R.id.image)).getDrawable();
        if (drawable != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() != 1) {
                QQToast.makeText(this, getString(R.string.boo), 0).show();
                return;
            }
            if ("5".equals(this.mSrcId)) {
                showNearbyActionSheet(uRLDrawable);
                return;
            }
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            if (isDarkModeAdapter()) {
                actionSheet.setForceNightMode(true);
            }
            if (this.mIsShowAction) {
                actionSheet.addButton(R.string.bsj, 1);
                reportActionSheetPanel(true, R.string.bsj, actionSheet);
                actionSheet.addButton(R.string.bst, 1);
                reportActionSheetPanel(true, R.string.bst, actionSheet);
                if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
                    ThreadManagerV2.excute(new Runnable(uRLDrawable, actionSheet) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.15
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ URLDrawable f293603d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ ActionSheet f293604e;

                        {
                            this.f293603d = uRLDrawable;
                            this.f293604e = actionSheet;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallPreviewActivity.this, uRLDrawable, actionSheet);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TroopAvatarWallPreviewActivity.TAG, 2, "QR Check Start!");
                                }
                                Bundle bundle = new Bundle();
                                String url = this.f293603d.getURL().toString();
                                TroopAvatarWallPreviewActivity troopAvatarWallPreviewActivity = TroopAvatarWallPreviewActivity.this;
                                if (troopAvatarWallPreviewActivity.mCookieMgr == null) {
                                    CookieSyncManager.createInstance(troopAvatarWallPreviewActivity.getApplicationContext());
                                    TroopAvatarWallPreviewActivity.this.mCookieMgr = CookieManager.getInstance();
                                }
                                String cookie = TroopAvatarWallPreviewActivity.this.mCookieMgr.getCookie(url);
                                if (cookie != null) {
                                    bundle.putString("Cookie", cookie);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TroopAvatarWallPreviewActivity.TAG, 2, "Get cookie: " + com.tencent.biz.common.util.k.e(cookie, new String[0]) + " from " + com.tencent.biz.common.util.k.f(url, new String[0]));
                                    }
                                }
                                String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), url, bundle);
                                if (QLog.isColorLevel()) {
                                    QLog.d(TroopAvatarWallPreviewActivity.TAG, 2, "saveTmpImage path = " + e16);
                                }
                                TroopAvatarWallPreviewActivity.this.tempPath = e16;
                                QbarCrashCollector.sCurrentUrl = com.tencent.biz.common.util.k.f(url, new String[0]);
                                if (!TextUtils.isEmpty(e16)) {
                                    ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(e16).getAbsolutePath()), (Context) TroopAvatarWallPreviewActivity.this, 1, false);
                                    if (decodeQQCodeFromFile != null && decodeQQCodeFromFile.l()) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TroopAvatarWallPreviewActivity.TAG, 2, "has QRCode ");
                                        }
                                        TroopAvatarWallPreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.15.1
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                } else {
                                                    AnonymousClass15.this.f293604e.addButton(R.string.bsr);
                                                    AnonymousClass15.this.f293604e.updateAllButton();
                                                }
                                            }
                                        });
                                    }
                                } else if (QLog.isColorLevel()) {
                                    QLog.d(TroopAvatarWallPreviewActivity.TAG, 2, "no QRCode ");
                                }
                                QbarCrashCollector.sCurrentUrl = null;
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TroopAvatarWallPreviewActivity.TAG, 2, "showActionSheet error : " + e17.getMessage());
                                }
                            } catch (UnsatisfiedLinkError e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TroopAvatarWallPreviewActivity.TAG, 2, "showActionSheet error : " + e18.getMessage());
                                }
                            }
                        }
                    }, 128, null, false);
                }
            }
            if (this.mDeleteAbility && canDelete(this.mIndex)) {
                actionSheet.addButton(R.string.bsg, 1);
            }
            if (this.mIsEdit) {
                actionSheet.addButton(R.string.eve, 5);
                actionSheet.addButton(R.string.bsg, 3);
            }
            actionSheet.addCancelButton(R.string.cancel);
            reportActionSheetPanel(true, R.string.cancel, actionSheet);
            actionSheet.setOnButtonClickListener(new d(actionSheet, uRLDrawable));
            try {
                actionSheet.show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        QQToast.makeText(this, getString(R.string.boo), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        QQToast.makeText(BaseApplication.getContext(), str, 0).show(getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWaitingDialog(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.mProgressDialog.setMessage(str);
        if (isFinishing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    private void startChatAndSendMsg(Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        m3.putExtras(new Bundle(bundle));
        if (!this.mPublicAccountShowPictureReport.isReport && !"2".equals(this.mSrcId) && !"6".equals(this.mSrcId) && !"4".equals(this.mSrcId)) {
            startActivity(m3);
        } else {
            ForwardUtils.w(this.app, this, this, m3, null);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOperateBar(int i3) {
        int i16;
        int i17;
        ArrayList<String> arrayList = this.mDescs;
        if (arrayList != null && i3 < arrayList.size()) {
            String str = this.mDescs.get(i3);
            this.mPhotoDesc.setText(com.tencent.mobileqq.qzonestatus.d.e(str, this.app));
            TextView textView = this.mPhotoDesc;
            if (TextUtils.isEmpty(str)) {
                i17 = 8;
            } else {
                i17 = 0;
            }
            textView.setVisibility(i17);
        } else {
            this.mPhotoDesc.setVisibility(8);
        }
        boolean[] zArr = this.mLikes;
        if (zArr != null && zArr.length > i3) {
            ImageView imageView = this.mLikeBtn;
            if (zArr[i3]) {
                i16 = R.drawable.gbx;
            } else {
                i16 = R.drawable.f162300gc0;
            }
            imageView.setImageResource(i16);
            boolean bool = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
            this.mIsBottomBarUp = bool;
            if (bool) {
                if (!TextUtils.isEmpty(this.mPhotoDesc.getText())) {
                    this.mPhotoDesc.setVisibility(0);
                }
                this.mBottomBar.setVisibility(0);
                ((ImageView) this.mBottomBarSwitch).setImageResource(R.drawable.gbu);
                return;
            }
            this.mPhotoDesc.setVisibility(8);
            this.mBottomBar.setVisibility(8);
            ((ImageView) this.mBottomBarSwitch).setImageResource(R.drawable.gbt);
        }
    }

    void back() {
        Gallery gallery;
        this.mPublicAccountShowPictureReport.leave_mode = 1;
        if (!this.animated && (gallery = this.mGallery) != null && !gallery.resetScale(false)) {
            if (this.mThumbRect != null && this.mGallery.getSelectedItemId() == this.mIndex) {
                if (!applyExitAnimation()) {
                    scaleExit();
                    return;
                }
                return;
            }
            scaleExit();
        }
    }

    boolean canDelete(int i3) {
        Bundle bundle;
        ArrayList<String> arrayList = this.mPhotoIds;
        if (arrayList != null && i3 <= arrayList.size() - 1 && (bundle = this.mExtras) != null && bundle.getBoolean(KEY_FROM_PERSONALITY_LABEL, false)) {
            return true;
        }
        Bundle bundle2 = this.mExtras;
        if (bundle2 != null && bundle2.getBoolean(KEY_FROM_EXTEND_FRIEND_EDIT, false)) {
            return true;
        }
        ArrayList<String> arrayList2 = this.mPhotoIds;
        if (arrayList2 == null || this.mPhotoTimes == null || i3 > arrayList2.size() - 1 || i3 > this.mPhotoTimes.size() - 1 || TextUtils.isEmpty(this.mPhotoIds.get(i3))) {
            return false;
        }
        return true;
    }

    void deletePhotoWall(int i3) {
        ArrayList<String> arrayList;
        if ((i3 >= 0 || i3 <= this.mAdapter.getCount() - 1) && (arrayList = this.mPhotoIds) != null && this.mPhotoTimes != null && i3 <= arrayList.size() - 1 && i3 <= this.mPhotoTimes.size() - 1) {
            DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.d4c)).setPositiveButton(getString(R.string.f171151ok), new k(i3)).setNegativeButton(getString(R.string.cancel), new j()).show();
            reportPhotoWallAction("0X8006A83", "");
        }
    }

    void deletePic(int i3) {
        if (i3 < 0 && i3 > this.mAdapter.getCount() - 1) {
            return;
        }
        if (this.mAdapter.getCount() == 2 && this.mAdapter.getItem(0) != null && this.mAdapter.getItem(0).equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
            back();
            return;
        }
        if (this.mAdapter.getCount() > 1) {
            if (this.mDelList == null) {
                this.mDelList = new ArrayList();
            }
            this.mDelList.add("" + i3);
            if (this.mDelList != null) {
                getIntent().putStringArrayListExtra("del_list", (ArrayList) this.mDelList);
                setResult(-1, getIntent());
            }
            finish();
            return;
        }
        QQToast.makeText(this, getString(R.string.dpo), 1).show(getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        synchronized (sLock) {
            if (mIsOpen) {
                super.finish();
                return false;
            }
            mIsOpen = true;
            QQAppInterface qQAppInterface = this.app;
            if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getAccount())) {
                try {
                    setContentView(getLayoutResID());
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            Intent intent = TroopAvatarWallPreviewActivity.this.getIntent();
                            boolean booleanExtra = intent.getBooleanExtra(TroopAvatarWallPreviewActivity.KEY_SAVE_INTENT_TO_FILE, false);
                            Bundle extras = intent.getExtras();
                            if (extras != null) {
                                TroopAvatarWallPreviewActivity.this.sourceFrom = extras.getInt(TroopAvatarWallPreviewActivity.SOURCE_FROM, 0);
                            }
                            if (booleanExtra) {
                                Intent readSavedIntent = LargeIntentManager.readSavedIntent(TroopAvatarWallPreviewActivity.this);
                                LargeIntentManager.removeSavedIntent(TroopAvatarWallPreviewActivity.this);
                                TroopAvatarWallPreviewActivity.this.setIntent(readSavedIntent);
                            }
                            TroopAvatarWallPreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.1.1
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
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        TroopAvatarWallPreviewActivity.this.init();
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                        }
                    }, 8, null, true);
                    return true;
                } catch (IllegalStateException e16) {
                    QLog.e(TAG, 1, "setContentView IllegalStateException", e16);
                    return false;
                }
            }
            finish();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (this.mNeedBottomBar) {
            LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.mIsBottomBarUp);
            unregisterReceiver(this.mReceiver);
        }
        PublicAccountShowPictureReport publicAccountShowPictureReport = this.mPublicAccountShowPictureReport;
        if (publicAccountShowPictureReport.isReport) {
            publicAccountShowPictureReport.showEnd();
            this.mPublicAccountShowPictureReport.report(this.app);
        }
        Gallery gallery = this.mGallery;
        if (gallery != null && (runnable = this.setAnimateFlagRunnable) != null) {
            gallery.removeCallbacks(runnable);
        }
        ac acVar = this.mRotationObserver;
        if (acVar != null) {
            acVar.b();
        }
        PictureShowViewModel pictureShowViewModel = this.pictureShowViewModel;
        if (pictureShowViewModel != null) {
            pictureShowViewModel.b2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    void forward(final URLDrawable uRLDrawable, final String str) {
        String str2 = this.mSrcId;
        if (str2 != null) {
            ReportController.o(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, str2, "", "", "");
        }
        executeIfGrantPermission(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopAvatarWallPreviewActivity.this.lambda$forward$0(uRLDrawable, str);
            }
        });
    }

    public String getBigPath(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
        if (this.mIndex >= this.mSeqNumList.size()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "picIndex" + this.mIndex + ",mSeqNumList.size()" + this.mSeqNumList.size());
                return null;
            }
            return null;
        }
        String str = this.mSeqNumList.get(this.mIndex);
        if (z16) {
            if (str != null && str.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                return com.tencent.mobileqq.troop.avatar.a.f294527k;
            }
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
            return iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(str, this.mTroopUin, 1));
        }
        return str;
    }

    Drawable getDrawable(boolean z16, String str) {
        if (z16) {
            try {
                return URLDrawable.getDrawable(NearbyImgDownloader.convertURL(str));
            } catch (MalformedURLException unused) {
                return null;
            }
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeFile(str, BaseImageUtil.calculateInSampleSize2(str, 100)));
        } catch (OutOfMemoryError unused2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDrawable out off memory");
            }
            System.gc();
            return null;
        }
    }

    protected View getLayoutResID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return LayoutInflater.from(this).inflate(R.layout.f168205pe, (ViewGroup) null);
    }

    public String getThumbPath(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
        if (this.mIndex >= this.mSeqNumList.size()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "picIndex" + this.mIndex + ",mSeqNumList.size()" + this.mSeqNumList.size());
                return null;
            }
            return null;
        }
        String str = this.mSeqNumList.get(this.mIndex);
        if (z16) {
            if (str != null && str.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                return com.tencent.mobileqq.troop.avatar.a.f294527k;
            }
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
            return iTroopAvatarUtilApi.getThumbPhoto(iTroopAvatarUtilApi.getAvatarAddress(str, this.mTroopUin, 1));
        }
        return str;
    }

    void initGallery(Bundle bundle) {
        this.mAdapter.o(this.mSrcId);
        this.mAdapter.n(this.mSeqNumList);
        this.mAdapter.i(this.mIsFromPhotoWall);
        ArrayList<Integer> arrayList = this.mPreviewPhotoLocation;
        if (arrayList != null) {
            this.mAdapter.m(arrayList);
        }
        this.mAdapter.notifyDataSetChanged();
        ArrayList<String> arrayList2 = this.mOriginList;
        if (arrayList2 != null) {
            this.mAdapter.l(arrayList2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " [updateAdapter] \u4f20\u5165\u94fe\u63a5");
        }
        this.mAdapter.q(!bundle.getBoolean("from_photo_wall", false));
        this.mAdapter.j(bundle.getBoolean("is_use_path", false));
        this.mIndex = bundle.getInt("index", -1);
        this.mGallery.setAdapter((SpinnerAdapter) this.mAdapter);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " [updateAdapter] \u4f20\u5165adapter");
        }
        this.mGallery.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.mGallery.setSelection(this.mIndex);
        this.mGallery.setOnItemClickListener(new aa());
        this.mGallery.setOnItemSelectedListener(new a());
        this.mGallery.setOnItemLongClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 21 && intent != null && this.isNeedToAio) {
            startChatAndSendMsg(intent.getExtras());
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            back();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        synchronized (sLock) {
            mIsOpen = false;
        }
        removeObserver(this.mPersonalityLabelObserver);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (82 == keyEvent.getKeyCode() && this.mIsShowMenu) {
            showActionSheet();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onPause();
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
    }

    void onQRDecodeSucceed(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra("fromPicQRDecode", true);
        intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, str2, null, null, null, 7));
        RouteUtils.startActivity(this, intent, "/qrscan/scanner");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onResume();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: savePicWithOverwrite, reason: merged with bridge method [inline-methods] */
    public void lambda$savePic$1(URLDrawable uRLDrawable) {
        String str;
        String str2;
        String str3 = this.mSrcId;
        if (str3 != null) {
            ReportController.o(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, str3, "", "", "");
        }
        if (uRLDrawable.getStatus() != 1) {
            return;
        }
        String str4 = IMAGE_SAVE_PATH;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str5 = str4 + this.mTroopUin + Utils.Crc64String(uRLDrawable.getURL().toString());
        if (str5.indexOf(".") == -1) {
            str = str5 + QzoneEmotionUtils.SIGN_ICON_URL_END;
        } else {
            str = str5;
        }
        if (str5.indexOf(".") == -1) {
            str2 = str5 + ".jpg";
        } else {
            str2 = str5;
        }
        File file2 = new File(str);
        File file3 = new File(str2);
        if (!file2.exists() && !file3.exists()) {
            savePhoto(uRLDrawable, str5);
        } else {
            DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.h4e)).setMessage(getString(R.string.cwb)).setPositiveButton(getString(R.string.h1a), new h(uRLDrawable, str5)).setNegativeButton(getString(R.string.f171142no), new g()).show();
        }
        reportPhotoWallAction("0X8006A82", "0X8006A96");
    }

    public void scaleExit() {
        int i3;
        int i16;
        int i17;
        ScaleAnimation scaleAnimation;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        ArrayList<Integer> arrayList = this.mPreviewPhotoLocation;
        int i18 = 0;
        if (arrayList != null) {
            i18 = arrayList.get(0).intValue();
            i3 = this.mPreviewPhotoLocation.get(1).intValue();
            i16 = this.mPreviewPhotoLocation.get(2).intValue();
            i17 = this.mPreviewPhotoLocation.get(3).intValue();
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        this.mTextView.setVisibility(4);
        this.mDelbtn.setVisibility(4);
        this.mMenuBtn.setVisibility(4);
        View view2 = this.socialBottomBar;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        this.animated = true;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        if (this.mIsFromPhotoWall) {
            scaleAnimation = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 0, (i16 / 2.0f) + i18, 0, i3 + (i17 / 2.0f));
            scaleAnimation.setDuration(400L);
            alphaAnimation.setDuration(400L);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        if (!"5".equals(this.mSrcId)) {
            animationSet.addAnimation(scaleAnimation);
        }
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new o());
        if (this.setAnimateFlagRunnable == null) {
            this.setAnimateFlagRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.29
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAvatarWallPreviewActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopAvatarWallPreviewActivity.this.animated = false;
                    }
                }
            };
        }
        this.mGallery.postDelayed(this.setAnimateFlagRunnable, 500L);
        if (this.mIsFromPhotoWall) {
            this.mGallery.animate().translationX(i18).translationY(i3);
        }
        this.mGallery.startAnimation(animationSet);
        this.mBgView.startAnimation(alphaAnimation);
        if (this.isShowContentUrl && (view = this.mContentUrlLayout) != null) {
            view.setVisibility(4);
        }
    }

    void setDefaultAvatar(int i3) {
        if (i3 < 0 && i3 > this.mAdapter.getCount() - 1) {
            return;
        }
        getIntent().putExtra(KEY_DEFAULT_AVATOR_INDEX, i3);
        setResult(-1, getIntent());
        finish();
    }

    protected void showNearbyActionSheet(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uRLDrawable);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showNearbyActionSheet: extra=" + this.mExtrasStr);
        }
        if (TextUtils.isEmpty(this.mExtrasStr)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mExtrasStr);
            jSONObject.optString("feedId");
            String optString = jSONObject.optString("tinyId");
            jSONObject.optString("reason");
            String optString2 = jSONObject.optString("uin");
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            actionSheet.addButton(R.string.bst, 1);
            if (!this.app.getCurrentAccountUin().equals(optString2)) {
                actionSheet.addButton(HardCodeUtil.qqStr(R.string.ubj), 0);
            }
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new e(actionSheet, uRLDrawable, optString, optString2));
            actionSheet.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "showNearbyActionSheet err:", e16);
            }
        }
    }
}
