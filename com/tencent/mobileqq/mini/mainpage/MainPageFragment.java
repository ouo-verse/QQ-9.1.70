package com.tencent.mobileqq.mini.mainpage;

import NS_COMM.COMM;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MainPageFragment extends PublicBaseFragment implements View.OnClickListener {
    private static final String CMD_GETUSERAPPINFO = "getUserAppInfo";
    private static final String CMD_SETUSERAPPLIKE = "setUserAppLike";
    private static final String CMD_SETUSERAPPTOP = "setUserAppTop";
    private static final String LIKE_NUM_POSTFIX = HardCodeUtil.qqStr(R.string.nxd);
    public static final String TAG = "MainPageFragment";
    private View divider;
    private boolean isLike;
    private ImageView mAppIcon;
    private TextView mAppName;
    private TextView mBackTextView;
    private ImageView mBackView;
    private TextView mComplainCallback;
    private View mComplainCallbackContainer;
    private Button mEnterMiniAppBtn;
    private TextView mIntroduction;
    private ImageView mLikeBtn;
    private View mLikeContainer;
    private COMM.StCommonExt mLikeExtInfo;
    private TextView mLikeNum;
    private RelativeLayout mMiniAbout;
    private MiniAppConfig mMiniAppConfig;
    private MiniAppDialog mMiniAppDialog;
    private MiniAppInfo mMiniAppInfo;
    private RelativeLayout mMiniBottom;
    private LinearLayout mMiniTitleHead;
    private TextView mMoreInfoTv;
    private View mMoreInformationContainer;
    private ImageView mMoreView;
    private TextView mPrivacyAgreement;
    private View mPrivacyAgreementContainer;
    private PrivacyDetailInfo mPrivacyInfo;
    private Button mRecommendMiniAppBtn;
    private View mRelativePublicAccountContainer;
    private View mSeparator1;
    private View mSeparator2;
    private View mSeparator3;
    private View mServiceTermsContainer;
    private View mServiceTermsSplitLineView;
    private TextView mServiceTermsTv;
    private Switch mSetTopSwitch;
    private TextView mSetTopText;
    private COMM.StCommonExt mTopExtInfo;
    private int mLikeNumber = 0;
    private boolean isMiniGame = false;
    private View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.MainPageFragment.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getId() == R.id.exk && GameWnsUtils.enablePersistentDebugVersion() && MainPageFragment.this.mMiniAppInfo != null) {
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("persistent_debug_version_" + MainPageFragment.getUin(), 4);
                if (sharedPreferences.getBoolean("persistent", false)) {
                    sharedPreferences.edit().remove("persistent").apply();
                    QLog.e("MainPageFragment", 1, "close persistent debug version");
                    QQToast.makeText(MainPageFragment.this.getBaseActivity(), MainPageFragment.this.getResources().getString(R.string.hi_), 1).show();
                } else {
                    sharedPreferences.edit().putBoolean("persistent", true).apply();
                    QLog.e("MainPageFragment", 1, "open persistent debug version");
                    QQToast.makeText(MainPageFragment.this.getBaseActivity(), MainPageFragment.this.getResources().getString(R.string.hm6), 1).show();
                }
            }
            return false;
        }
    };

    private void changeSkin() {
        if (QQTheme.isNowThemeIsNight()) {
            this.mMiniAbout.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci_));
            this.mMiniTitleHead.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci9));
            this.mMiniBottom.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci9));
            this.mBackView.setImageResource(R.drawable.top_back_left_selector);
            this.mMoreView.setImageResource(R.drawable.n0y);
            this.mAppName.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
            this.mIntroduction.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cio));
            this.mLikeNum.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciu));
            this.mSetTopSwitch.setTrackResource(R.drawable.f161079k01);
            this.mSetTopSwitch.setThumbResource(R.drawable.f161078k00);
            this.divider.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161084k02));
            this.mSeparator1.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cil));
            this.mSeparator2.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cil));
            this.mSeparator3.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cil));
            this.mServiceTermsSplitLineView.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cil));
            this.mComplainCallback.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cib));
            this.mPrivacyAgreement.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cib));
            this.mServiceTermsTv.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cib));
            this.mMoreInfoTv.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cib));
            this.mSetTopText.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cit));
            this.mRecommendMiniAppBtn.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.jyb));
            this.mRecommendMiniAppBtn.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.c58));
            this.mEnterMiniAppBtn.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.jya));
            this.mComplainCallbackContainer.setBackgroundResource(R.drawable.jy_);
            this.mPrivacyAgreementContainer.setBackgroundResource(R.drawable.jy_);
            this.mMoreInformationContainer.setBackgroundResource(R.drawable.jy_);
            this.mServiceTermsContainer.setBackgroundResource(R.drawable.jy_);
            return;
        }
        this.mMiniAbout.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci8));
        this.mMiniTitleHead.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci8));
        this.mMiniBottom.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci8));
        this.mBackView.setImageResource(R.drawable.ch6);
        this.mMoreView.setImageResource(R.drawable.ch8);
        this.mAppName.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cic));
        this.mIntroduction.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cif));
        this.mLikeNum.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci7));
        this.mSetTopSwitch.setTrackResource(R.drawable.b58);
        this.mSetTopSwitch.setThumbResource(R.drawable.b57);
        this.divider.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f162280av3));
        this.mSeparator1.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cvh));
        this.mSeparator2.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cvh));
        this.mSeparator3.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cvh));
        this.mServiceTermsSplitLineView.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cvh));
        this.mComplainCallback.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cia));
        this.mPrivacyAgreement.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cia));
        this.mServiceTermsTv.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cia));
        this.mMoreInfoTv.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cia));
        this.mSetTopText.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cis));
        this.mRecommendMiniAppBtn.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161032qm));
        this.mRecommendMiniAppBtn.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.c57));
        this.mEnterMiniAppBtn.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161031ql));
        this.mComplainCallbackContainer.setBackgroundResource(R.drawable.f161027qk);
        this.mPrivacyAgreementContainer.setBackgroundResource(R.drawable.f161027qk);
        this.mMoreInformationContainer.setBackgroundResource(R.drawable.f161027qk);
        this.mServiceTermsContainer.setBackgroundResource(R.drawable.f161027qk);
    }

    private Drawable getIconDrawable(String str) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(70.0f);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        try {
            obtain.mFailedDrawable = getBaseActivity().getDrawable(R.drawable.f161062ch3);
            obtain.mLoadingDrawable = getBaseActivity().getDrawable(R.drawable.f161062ch3);
        } catch (Exception e16) {
            QLog.e("MainPageFragment", 1, "getIconDrawable, exception!");
            e16.printStackTrace();
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            try {
                uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(12.0f)));
                uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("MainPageFragment", 2, "getIcon url: " + str);
                }
                return uRLDrawable;
            }
        } catch (Exception e18) {
            e = e18;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static String getUin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            return null;
        }
        String account = runtime.getAccount();
        QLog.i("CommonDataAdapter", 2, "get uin from app runtim succ:" + account);
        return account;
    }

    private void handleMoreButtonEvent() {
        MiniAppDialog miniAppDialog = new MiniAppDialog(getBaseActivity());
        this.mMiniAppDialog = miniAppDialog;
        miniAppDialog.setContentView(LayoutInflater.from(getBaseActivity()).inflate(R.layout.bmw, (ViewGroup) null));
        LinearLayout linearLayout = (LinearLayout) this.mMiniAppDialog.findViewById(R.id.ex6);
        TextView textView = (TextView) this.mMiniAppDialog.findViewById(R.id.exx);
        textView.setText(HardCodeUtil.qqStr(R.string.nx6));
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.mMiniAppDialog.findViewById(R.id.ex_);
        textView2.setOnClickListener(this);
        this.mMiniAppDialog.show();
        this.mMiniAppDialog.findViewById(R.id.kmm);
        View findViewById = this.mMiniAppDialog.findViewById(R.id.f116176y1);
        if (QQTheme.isNowThemeIsNight()) {
            linearLayout.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161021jy0));
            textView.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.jy_));
            textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
            textView2.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
            findViewById.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cij));
            return;
        }
        linearLayout.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
        textView.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161027qk));
        textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.civ));
        textView2.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.civ));
        findViewById.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.cii));
    }

    private void initData() {
        MiniAppInfo miniAppInfo;
        Bundle arguments = getArguments();
        if (arguments != null) {
            MiniAppConfig miniAppConfig = (MiniAppConfig) arguments.getParcelable("app_config");
            this.mMiniAppConfig = miniAppConfig;
            if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null) {
                this.mMiniAppInfo = miniAppInfo;
                if (QLog.isColorLevel()) {
                    QLog.d("MainPageFragment", 2, "initData : miniAppConfig = " + this.mMiniAppConfig.toString());
                }
            }
            this.isMiniGame = arguments.getBoolean("isMiniGame");
        }
    }

    private void initUI() {
        View findViewById;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            if (!TextUtils.isEmpty(miniAppInfo.iconUrl)) {
                this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
            }
            this.mAppName.setText(this.mMiniAppInfo.name);
            this.mIntroduction.setText(this.mMiniAppInfo.desc);
            MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
            boolean z16 = miniAppInfo2.appMode.disableAddToMyApp;
            if (z16 || miniAppInfo2.isLimitedAccessApp()) {
                if (getView() != null && (findViewById = getView().findViewById(R.id.ipn)) != null) {
                    findViewById.setVisibility(8);
                }
                if (z16) {
                    this.mRecommendMiniAppBtn.setVisibility(8);
                    View view = this.mSeparator2;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            }
        }
        if (this.isMiniGame) {
            this.mSetTopText.setText(HardCodeUtil.qqStr(R.string.nx5));
            this.mRecommendMiniAppBtn.setText(HardCodeUtil.qqStr(R.string.nx8));
            this.mEnterMiniAppBtn.setText(HardCodeUtil.qqStr(R.string.f172161nx4));
            this.mLikeNum.setText(HardCodeUtil.qqStr(R.string.nx_));
            return;
        }
        if (MiniAppConfProcessor.m()) {
            this.mSetTopText.setText(HardCodeUtil.qqStr(R.string.nx5));
        }
        this.mLikeNum.setText(HardCodeUtil.qqStr(R.string.nxc));
    }

    public static void launch(Context context, MiniAppConfig miniAppConfig, int i3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("app_config", miniAppConfig);
        intent.putExtra("versionType", i3);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForMini.class, MainPageFragment.class);
    }

    public static void launchForMiniGame(Context context, MiniAppConfig miniAppConfig, int i3, boolean z16) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("app_config", miniAppConfig);
        intent.putExtra("versionType", i3);
        intent.putExtra("isMiniGame", z16);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForMini.class, MainPageFragment.class);
    }

    private void openServiceTermsPage() {
        if (this.mPrivacyInfo != null) {
            Intent intent = new Intent();
            intent.putExtra("url", this.mPrivacyInfo.getServiceTermsUrl());
            RouteUtils.startActivity(getBaseActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
            reportClick(MiniProgramLpReportDC04239.MORE_ABOUT_RESERVERS_SERVICE_TERMS);
            MiniProgramReporter.getInstance().flush();
        }
    }

    private void reportClick(String str) {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        MiniProgramLpReportDC04239.reportUserClick(miniAppConfig, MiniProgramLpReportDC04239.getAppType(miniAppConfig), null, "user_click", "more_about", str);
    }

    private void sendGetPrivacyAgreement() {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getMiniAppPrivacyInfo(this.mMiniAppInfo.appId, "getPrivacyAgreement", new MiniAppProxy.GetPrivacyInfoListener() { // from class: com.tencent.mobileqq.mini.mainpage.MainPageFragment.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetPrivacyInfoListener
            public void onResult(boolean z16, boolean z17, PrivacyDetailInfo privacyDetailInfo) {
                MainPageFragment.this.mPrivacyInfo = privacyDetailInfo;
                QMLog.i("MainPageFragment", "loadPrivacyInfo result\uff1a" + z16 + "," + z17 + "," + privacyDetailInfo);
                if (MainPageFragment.this.mPrivacyInfo != null && !TextUtils.isEmpty(MainPageFragment.this.mPrivacyInfo.getWebUrl())) {
                    MainPageFragment.this.mPrivacyAgreementContainer.setVisibility(0);
                }
                if (MainPageFragment.this.mPrivacyInfo == null || TextUtils.isEmpty(MainPageFragment.this.mPrivacyInfo.getServiceTermsName()) || TextUtils.isEmpty(MainPageFragment.this.mPrivacyInfo.getServiceTermsUrl())) {
                    return;
                }
                MainPageFragment.this.mServiceTermsContainer.setVisibility(0);
                MainPageFragment.this.mServiceTermsSplitLineView.setVisibility(0);
                MainPageFragment.this.mServiceTermsTv.setText(MainPageFragment.this.mPrivacyInfo.getServiceTermsName());
            }
        });
    }

    private void sendGetUserAppInfoRequest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.mMiniAppInfo.appId);
        update(this.mMiniAppInfo);
        MiniAppCmdUtil.getInstance().getUserAppInfo(arrayList, new ResponseListener(this, CMD_GETUSERAPPINFO));
    }

    private void sendSetUserAppLikeRequest(boolean z16) {
        MiniAppCmdUtil.getInstance().setUserAppLike(z16, this.mLikeExtInfo, this.mMiniAppInfo.appId, new ResponseListener(this, CMD_SETUSERAPPLIKE));
    }

    private void setLikeNum() {
        String str;
        if (this.isLike) {
            this.isLike = false;
            this.mLikeNumber--;
        } else {
            this.isLike = true;
            this.mLikeNumber++;
        }
        updateLikeNum(this.mLikeNumber);
        updateLikeState(this.isLike);
        sendSetUserAppLikeRequest(this.isLike);
        if (this.isLike) {
            str = "like_on";
        } else {
            str = "like_off";
        }
        reportClick(str);
    }

    private void setTopType(MiniAppInfo miniAppInfo) {
        String str;
        miniAppInfo.topType = miniAppInfo.topType == 0 ? 1 : 0;
        updateTopTypeState(miniAppInfo);
        sendSetUserAppTopRequest(miniAppInfo);
        if (miniAppInfo.topType == 0) {
            str = "settop_off";
        } else {
            str = "settop_on";
        }
        reportClick(str);
    }

    private void startComplainAndCallback() {
        String str;
        if (this.mMiniAppInfo == null) {
            QLog.e("MainPageFragment", 1, "startComplainAndCallback, mApkgConfig = " + this.mMiniAppInfo);
            return;
        }
        try {
            str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("MainPageFragment", 1, "startComplainAndCallback, url = ");
            e16.printStackTrace();
            str = "";
        }
        String str2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.mMiniAppInfo.appId + "&openid=" + getUin() + "&avatar=" + str + HardCodeUtil.qqStr(R.string.nxf);
        Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        startActivity(intent);
        reportClick("feedback");
        QLog.d("MainPageFragment", 2, "feedback, prepare to upload log ");
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", this.mMiniAppInfo.appId);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_UPLOAD_USER_LOG, bundle2, null);
    }

    private void startMiniApp() {
        try {
            MiniAppLauncher.launchAppByAppInfo(getBaseActivity(), this.mMiniAppInfo, 1024);
        } catch (MiniAppException unused) {
            QLog.e("MainPageFragment", 1, "startMiniApp is failed !!!");
        }
    }

    private void startMoreInformation() {
        if (this.mMiniAppInfo == null) {
            QLog.e("MainPageFragment", 1, "startMoreInformation, miniAppInfo = " + this.mMiniAppInfo);
            return;
        }
        String str = "https://q.qq.com/os/store/details-more?appid=" + this.mMiniAppInfo.appId;
        Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void startPrivacyAgreement() {
        PrivacyDetailInfo privacyDetailInfo = this.mPrivacyInfo;
        if (privacyDetailInfo != null) {
            String webUrl = privacyDetailInfo.getWebUrl();
            Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", webUrl);
            intent.putExtras(new Bundle());
            startActivity(intent);
            reportClick("privacy");
        }
    }

    private void startRecommendMiniApp() {
        if (this.mMiniAppInfo != null) {
            ShareQQArkHelper.s(getBaseActivity(), new MiniArkShareModelBuilder().setAppId(this.mMiniAppInfo.appId).setTitle(this.mMiniAppInfo.name).setDescription(this.mMiniAppInfo.desc).setShareScene(0).setShareTemplateType(0).setShareBusinessType(this.mMiniAppInfo.getReportType()).setPicUrl(this.mMiniAppInfo.iconUrl).setVidUrl(null).setIconUrl(this.mMiniAppInfo.iconUrl).setVersionType(this.mMiniAppInfo.verType).setVersionId(this.mMiniAppInfo.versionId).setWithShareTicket(false).setMiniAppShareFrom(10).setExtInfo(null).createMiniArkShareModel(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeNum(int i3) {
        if (!this.isLike) {
            if (this.isMiniGame) {
                this.mLikeNum.setText(HardCodeUtil.qqStr(R.string.f172159nx2));
                return;
            } else {
                this.mLikeNum.setText(HardCodeUtil.qqStr(R.string.nxe));
                return;
            }
        }
        if (i3 > 0) {
            if (i3 > 9999) {
                this.mLikeNum.setText(String.format("%.2f", Float.valueOf(i3 / 10000.0f)) + HardCodeUtil.qqStr(R.string.nxb) + LIKE_NUM_POSTFIX);
                return;
            }
            this.mLikeNum.setText(i3 + LIKE_NUM_POSTFIX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTopTypeState(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.topType == 0) {
            this.mSetTopSwitch.setChecked(false);
        } else {
            this.mSetTopSwitch.setChecked(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        MiniProgramReporter.getInstance().flush();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ex5 /* 2131376692 */:
                startComplainAndCallback();
                return;
            case R.id.ex_ /* 2131376696 */:
                this.mMiniAppDialog.dismiss();
                return;
            case R.id.exc /* 2131376699 */:
                startMiniApp();
                reportClick("launch");
                return;
            case R.id.exh /* 2131376707 */:
                setLikeNum();
                return;
            case R.id.zbg /* 2131376717 */:
                startMoreInformation();
                reportClick("profile");
                return;
            case R.id.zbh /* 2131376720 */:
                startPrivacyAgreement();
                return;
            case R.id.ext /* 2131376721 */:
                startRecommendMiniApp();
                reportClick("share");
                return;
            case R.id.zbk /* 2131376725 */:
                openServiceTermsPage();
                return;
            case R.id.exw /* 2131376726 */:
                setTopType(this.mMiniAppInfo);
                return;
            case R.id.exx /* 2131376727 */:
                MiniAppInfo miniAppInfo = this.mMiniAppInfo;
                if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.appId)) {
                    return;
                }
                BaseActivity baseActivity = getBaseActivity();
                MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
                PermissionSettingFragment.launchForResult(baseActivity, miniAppInfo2.appId, miniAppInfo2.name, 5);
                this.mMiniAppDialog.dismiss();
                reportClick("set");
                return;
            case R.id.exy /* 2131376730 */:
                MiniProgramReporter.getInstance().flush();
                getBaseActivity().finish();
                return;
            case R.id.exz /* 2131376732 */:
                handleMoreButtonEvent();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.bmx, (ViewGroup) null);
        getBaseActivity().getWindow().clearFlags(67108864);
        getBaseActivity().getWindow().addFlags(Integer.MIN_VALUE);
        if (QQTheme.isNowThemeIsNight()) {
            getBaseActivity().getWindow().setStatusBarColor(-16777216);
        } else {
            getBaseActivity().getWindow().setStatusBarColor(-1);
        }
        ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        initData();
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mMiniAbout = (RelativeLayout) view.findViewById(R.id.f75773zv);
        this.mMiniTitleHead = (LinearLayout) view.findViewById(R.id.zbl);
        this.mMiniBottom = (RelativeLayout) view.findViewById(R.id.f75313ym);
        ImageView imageView = (ImageView) view.findViewById(R.id.exk);
        this.mAppIcon = imageView;
        imageView.setOnLongClickListener(this.mLongClickListener);
        this.mAppName = (TextView) view.findViewById(R.id.exr);
        this.mIntroduction = (TextView) view.findViewById(R.id.ex8);
        this.mLikeNum = (TextView) view.findViewById(R.id.exj);
        this.mLikeBtn = (ImageView) view.findViewById(R.id.exi);
        this.mSetTopSwitch = (Switch) view.findViewById(R.id.exw);
        this.mRecommendMiniAppBtn = (Button) view.findViewById(R.id.ext);
        this.mEnterMiniAppBtn = (Button) view.findViewById(R.id.exc);
        this.mRelativePublicAccountContainer = view.findViewById(R.id.exu);
        this.mComplainCallbackContainer = view.findViewById(R.id.ex5);
        this.mPrivacyAgreementContainer = view.findViewById(R.id.zbh);
        this.mServiceTermsContainer = view.findViewById(R.id.zbk);
        this.mServiceTermsSplitLineView = view.findViewById(R.id.xxn);
        this.mMoreInformationContainer = view.findViewById(R.id.zbg);
        this.mLikeContainer = view.findViewById(R.id.exh);
        this.mBackView = (ImageView) view.findViewById(R.id.exy);
        this.mMoreView = (ImageView) view.findViewById(R.id.exz);
        this.mSetTopText = (TextView) view.findViewById(R.id.ipo);
        this.mSeparator1 = view.findViewById(R.id.xxk);
        this.mSeparator2 = view.findViewById(R.id.xxl);
        this.mSeparator3 = view.findViewById(R.id.xxm);
        this.mComplainCallback = (TextView) view.findViewById(R.id.b6s);
        this.mPrivacyAgreement = (TextView) view.findViewById(R.id.f27560gk);
        this.mServiceTermsTv = (TextView) view.findViewById(R.id.f83444jk);
        this.mMoreInfoTv = (TextView) view.findViewById(R.id.zes);
        this.divider = view.findViewById(R.id.kmm);
        changeSkin();
        this.mSetTopSwitch.setOnClickListener(this);
        this.mRecommendMiniAppBtn.setOnClickListener(this);
        this.mEnterMiniAppBtn.setOnClickListener(this);
        this.mRelativePublicAccountContainer.setOnClickListener(this);
        this.mComplainCallbackContainer.setOnClickListener(this);
        this.mPrivacyAgreementContainer.setOnClickListener(this);
        this.mServiceTermsContainer.setOnClickListener(this);
        this.mMoreInformationContainer.setOnClickListener(this);
        this.mComplainCallbackContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.MainPageFragment.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MiniCacheFreeManager.freeCache(MainPageFragment.getUin(), MainPageFragment.this.mMiniAppInfo);
                MainPageFragment.this.getBaseActivity().finish();
                QQToast.makeText(view2.getContext(), HardCodeUtil.qqStr(R.string.f172160nx3), 1).show();
                return false;
            }
        });
        this.mBackView.setOnClickListener(this);
        this.mMoreView.setOnClickListener(this);
        this.mLikeContainer.setOnClickListener(this);
        initUI();
        sendGetUserAppInfoRequest();
        sendGetPrivacyAgreement();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class ResponseListener implements MiniAppCmdInterface {
        private final String cmd;
        private final WeakReference<MainPageFragment> fragmentWeakReference;

        ResponseListener(MainPageFragment mainPageFragment, String str) {
            this.fragmentWeakReference = new WeakReference<>(mainPageFragment);
            this.cmd = str;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            MainPageFragment mainPageFragment = this.fragmentWeakReference.get();
            if (mainPageFragment == null) {
                return;
            }
            String str = this.cmd;
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1736408338:
                    if (str.equals(MainPageFragment.CMD_GETUSERAPPINFO)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 786907467:
                    if (str.equals(MainPageFragment.CMD_SETUSERAPPLIKE)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1549412641:
                    if (str.equals(MainPageFragment.CMD_SETUSERAPPTOP)) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    getUserAppInfo(mainPageFragment, z16, jSONObject);
                    return;
                case 1:
                    setUserAppLike(mainPageFragment, z16, jSONObject);
                    return;
                case 2:
                    setUserAppTop(mainPageFragment, z16, jSONObject);
                    return;
                default:
                    return;
            }
        }

        private void getUserAppInfo(MainPageFragment mainPageFragment, boolean z16, JSONObject jSONObject) {
            if (z16) {
                final int optInt = jSONObject.optInt("likeNum");
                int optInt2 = jSONObject.optInt("doLike");
                final Object opt = jSONObject.opt("mini_app_info_data");
                mainPageFragment.mLikeNumber = optInt;
                final boolean z17 = optInt2 == 1;
                mainPageFragment.isLike = z17;
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.MainPageFragment.ResponseListener.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        MainPageFragment mainPageFragment2 = (MainPageFragment) ResponseListener.this.fragmentWeakReference.get();
                        if (mainPageFragment2 == null) {
                            return;
                        }
                        mainPageFragment2.updateLikeNum(optInt);
                        mainPageFragment2.updateLikeState(z17);
                        Object obj = opt;
                        if (obj instanceof MiniAppInfo) {
                            MiniAppInfo miniAppInfo = (MiniAppInfo) obj;
                            mainPageFragment2.mMiniAppInfo = miniAppInfo;
                            mainPageFragment2.updateTopTypeState(miniAppInfo);
                        }
                    }
                });
            }
        }

        private void setUserAppLike(MainPageFragment mainPageFragment, boolean z16, JSONObject jSONObject) {
            COMM.StCommonExt stCommonExt;
            if (!z16 || (stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext")) == null) {
                return;
            }
            mainPageFragment.mLikeExtInfo = stCommonExt;
        }

        private void setUserAppTop(MainPageFragment mainPageFragment, boolean z16, JSONObject jSONObject) {
            COMM.StCommonExt stCommonExt;
            if (!z16 || (stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext")) == null) {
                return;
            }
            mainPageFragment.mTopExtInfo = stCommonExt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class SyncDataIPCCallback implements EIPCResultCallback {
        private final WeakReference<MainPageFragment> ref;

        SyncDataIPCCallback(MainPageFragment mainPageFragment) {
            this.ref = new WeakReference<>(mainPageFragment);
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null && eIPCResult.code == -100) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.MainPageFragment.SyncDataIPCCallback.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        MainPageFragment mainPageFragment = (MainPageFragment) SyncDataIPCCallback.this.ref.get();
                        if (mainPageFragment == null) {
                            return;
                        }
                        if (mainPageFragment.mMiniAppInfo != null) {
                            mainPageFragment.mMiniAppInfo.topType = 0;
                            mainPageFragment.updateTopTypeState(mainPageFragment.mMiniAppInfo);
                        }
                        if (MiniAppConfProcessor.m()) {
                            QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.nxa) + MiniAppConfProcessor.d() + HardCodeUtil.qqStr(R.string.nx7), 0).show();
                            return;
                        }
                        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.iup), 0).show();
                    }
                });
                return;
            }
            MainPageFragment mainPageFragment = this.ref.get();
            if (mainPageFragment == null) {
                return;
            }
            mainPageFragment.setMiniAppTop(mainPageFragment.mMiniAppInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeState(boolean z16) {
        if (z16) {
            this.mLikeBtn.setImageResource(R.drawable.ch5);
        } else {
            this.mLikeBtn.setImageResource(R.drawable.ch_);
        }
    }

    public void sendSetUserAppTopRequest(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MainPageFragment", 1, "sendSetUserAppTopRequest, miniAppInfo = " + this.mMiniAppInfo);
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("appid", miniAppInfo.appId);
        bundle.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, miniAppInfo.topType);
        bundle.putInt("verType", miniAppInfo.verType);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_SYNC_MINI_APP_DATA, bundle, new SyncDataIPCCallback(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMiniAppTop(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            QLog.e("MainPageFragment", 1, "setMiniAppTop, miniAppInfo = null");
        } else {
            MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, miniAppInfo.topType, miniAppInfo.verType, this.mTopExtInfo, new ResponseListener(this, CMD_SETUSERAPPTOP));
        }
    }

    private void update(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
            this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.name)) {
            this.mAppName.setText(this.mMiniAppInfo.name);
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.desc)) {
            this.mIntroduction.setText(this.mMiniAppInfo.desc);
        }
        updateTopTypeState(miniAppInfo);
    }
}
