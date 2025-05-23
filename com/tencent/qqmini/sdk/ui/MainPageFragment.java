package com.tencent.qqmini.sdk.ui;

import NS_COMM.COMM;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class MainPageFragment extends MiniBaseFragment implements View.OnClickListener {
    private static final String LIKE_NUM_POSTFIX = "\u4e2a\u8d5e";
    private static final String MINI_FILE_SUB_PATH = "/tencent/mini/files/";
    private static final String MINI_LOG_PATH = Environment.getExternalStorageDirectory().getPath() + MINI_FILE_SUB_PATH;
    public static final String TAG = "MainPageFragment";
    private boolean isLike;
    private ImageView mAppIcon;
    private TextView mAppName;
    private TextView mBackTextView;
    private ImageView mBackView;
    private View mComplainCallbackContainer;
    private Button mEnterMiniAppBtn;
    private TextView mIntroduction;
    private ImageView mLikeBtn;
    private View mLikeContainer;
    private COMM.StCommonExt mLikeExtInfo;
    private TextView mLikeNum;
    private MiniAppDialog mMiniAppDialog;
    private MiniAppInfo mMiniAppInfo;
    private ImageView mMoreView;
    private Button mRecommendMiniAppBtn;
    private View mRelativePublicAccountContainer;
    private View mSeparator;
    private View mSetTopContainer;
    private Switch mSetTopSwitch;
    private TextView mSetTopText;
    private COMM.StCommonExt mTopExtInfo;
    private int mLikeNumber = 0;
    private boolean isMiniGame = false;
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
    private View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.1
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view.getId() == R.id.miniapp_logo && GameWnsUtils.enablePersistentDebugVersion() && MainPageFragment.this.mMiniAppInfo != null) {
                SharedPreferences sharedPreferences = AppLoaderFactory.g().getContext().getApplicationContext().getSharedPreferences("persistent_debug_version_" + MainPageFragment.this.getUin(), 4);
                if (sharedPreferences.getBoolean("persistent", false)) {
                    sharedPreferences.edit().remove("persistent").apply();
                    QMLog.e("MainPageFragment", "close persistent debug version");
                    MiniToast.makeText(MainPageFragment.this.getActivity(), MainPageFragment.this.getResources().getString(R.string.mini_sdk_game_close_persistent_debug_version), 1).show();
                } else {
                    sharedPreferences.edit().putBoolean("persistent", true).apply();
                    QMLog.e("MainPageFragment", "open persistent debug version");
                    MiniToast.makeText(MainPageFragment.this.getActivity(), MainPageFragment.this.getResources().getString(R.string.mini_sdk_game_open_persistent_debug_version), 1).show();
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    };

    private Drawable getIconDrawable(String str) {
        Drawable drawable;
        int dip2px = DisplayUtil.dip2px(getActivity(), 70.0f);
        try {
            drawable = getActivity().getDrawable(R.drawable.mini_sdk_icon_loading_default);
        } catch (Exception e16) {
            QMLog.e("MainPageFragment", "getIconDrawable, exception!");
            e16.printStackTrace();
            drawable = null;
        }
        return this.mMiniAppProxy.getDrawable(getActivity(), str, dip2px, dip2px, drawable);
    }

    private void handleMiniappMoreInfo() {
        if (QUAUtil.isQQApp()) {
            startMoreInformation(null);
        } else {
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            if (channelProxy != null) {
                channelProxy.getSDKOpenKeyToken(null, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.3
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        if (z16 && jSONObject != null) {
                            MainPageFragment.this.startMoreInformation(jSONObject.optString("token"));
                        }
                    }
                });
            }
        }
        this.mMiniAppDialog.dismiss();
        reportClick("profile");
    }

    private void handleMiniappSetting() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            FragmentActivity activity = getActivity();
            MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
            channelProxy.openPermissionSettingsActivity(activity, miniAppInfo2.appId, miniAppInfo2.name);
            this.mMiniAppDialog.dismiss();
            reportClick("set");
        }
    }

    private void handleMoreButtonEvent() {
        MiniAppDialog miniAppDialog = new MiniAppDialog(getActivity());
        this.mMiniAppDialog = miniAppDialog;
        miniAppDialog.setContentView(LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_dialog_layout, (ViewGroup) null));
        TextView textView = (TextView) this.mMiniAppDialog.findViewById(R.id.miniapp_seting);
        textView.setText("\u8bbe\u7f6e");
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.mMiniAppDialog.findViewById(R.id.miniapp_more_information);
        textView2.setText("\u66f4\u591a\u8d44\u6599");
        textView2.setOnClickListener(this);
        ((TextView) this.mMiniAppDialog.findViewById(R.id.miniapp_dialog_cancel)).setOnClickListener(this);
        this.mMiniAppDialog.show();
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            MiniAppInfo miniAppInfo = (MiniAppInfo) arguments.getParcelable("mini_app_info");
            this.mMiniAppInfo = miniAppInfo;
            this.isMiniGame = miniAppInfo.isEngineTypeMiniGame();
        }
    }

    private void initUI() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            if (!TextUtils.isEmpty(miniAppInfo.iconUrl)) {
                this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
            }
            this.mAppName.setText(this.mMiniAppInfo.name);
            this.mIntroduction.setText(this.mMiniAppInfo.desc);
            MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
            boolean z16 = miniAppInfo2.appMode.disableAddToMyApp;
            if (z16 || miniAppInfo2.isInternalApp()) {
                this.mSetTopContainer.setVisibility(8);
                if (z16) {
                    this.mRecommendMiniAppBtn.setVisibility(8);
                    View view = this.mSeparator;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            }
        }
        updateUIText();
        if (!QUAUtil.isQQApp() && !QUAUtil.isDemoApp()) {
            this.mSetTopContainer.setVisibility(8);
            this.mLikeContainer.setVisibility(8);
        }
        if (QUAUtil.isQQBrowseApp()) {
            this.mEnterMiniAppBtn.setVisibility(8);
        }
    }

    private void reportClick(String str) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        SDKMiniProgramLpReportDC04239.reportUserClick(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "user_click", "more_about", str);
    }

    private void sendGetUserAppInfoRequest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.mMiniAppInfo.appId);
        update(this.mMiniAppInfo);
        this.mChannelProxy.getUserAppInfo(null, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    final int optInt = jSONObject.optInt("likeNum");
                    int optInt2 = jSONObject.optInt("doLike");
                    final Object opt = jSONObject.opt("mini_app_info_data");
                    MainPageFragment.this.mLikeNumber = optInt;
                    MainPageFragment mainPageFragment = MainPageFragment.this;
                    boolean z17 = true;
                    if (optInt2 != 1) {
                        z17 = false;
                    }
                    mainPageFragment.isLike = z17;
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageFragment.this.updateLikeNum(optInt);
                            MainPageFragment mainPageFragment2 = MainPageFragment.this;
                            mainPageFragment2.updateLikeState(mainPageFragment2.isLike);
                            Object obj = opt;
                            if (obj instanceof MiniAppInfo) {
                                MainPageFragment.this.mMiniAppInfo = (MiniAppInfo) obj;
                                MainPageFragment mainPageFragment3 = MainPageFragment.this;
                                mainPageFragment3.updateTopTypeState(mainPageFragment3.mMiniAppInfo);
                            }
                        }
                    });
                }
            }
        });
    }

    private void sendSetUserAppLikeRequest(boolean z16) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).setUserAppLike(z16, this.mLikeExtInfo, this.mMiniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.6
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                COMM.StCommonExt stCommonExt;
                if (z17 && (stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext")) != null) {
                    MainPageFragment.this.mLikeExtInfo = stCommonExt;
                }
            }
        });
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

    private void setMiniAppTop(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            QMLog.e("MainPageFragment", "setMiniAppTop, miniAppInfo = null");
        } else {
            this.mChannelProxy.setUserAppTop(miniAppInfo, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.5
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    COMM.StCommonExt stCommonExt;
                    if (z16 && (stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext")) != null) {
                        MainPageFragment.this.mTopExtInfo = stCommonExt;
                    }
                }
            });
        }
    }

    private void setTopType(MiniAppInfo miniAppInfo) {
        int i3;
        String str;
        if (miniAppInfo.topType == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        miniAppInfo.topType = i3;
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
            QMLog.e("MainPageFragment", "startComplainAndCallback, mApkgConfig = " + this.mMiniAppInfo);
            return;
        }
        try {
            str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QMLog.e("MainPageFragment", "startComplainAndCallback, url = ");
            e16.printStackTrace();
            str = "";
        }
        String str2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.mMiniAppInfo.appId + "&openid=" + getUin() + "&avatar=" + str + "&nickname=\u6e38\u5ba2";
        if (!QUAUtil.isQQApp()) {
            str2 = str2 + "&customInfo=-" + this.mMiniAppProxy.getPlatformId();
        }
        Intent intent = new Intent();
        intent.putExtra("url", str2);
        intent.putExtra("title", "\u6295\u8bc9\u4e0e\u53cd\u9988");
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        this.mMiniAppProxy.startBrowserActivity(getActivity(), intent);
        reportClick("feedback");
        QMLog.d("MainPageFragment", "feedback, prepare to upload log ");
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
    }

    private void startMiniApp() {
        this.mMiniAppInfo.launchParam.scene = 1024;
        MiniAppLauncher.launchMiniApp(getActivity(), this.mMiniAppInfo, (Bundle) null, (ResultReceiver) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMoreInformation(String str) {
        if (this.mMiniAppInfo == null) {
            QMLog.e("MainPageFragment", "startMoreInformation, miniAppInfo = " + this.mMiniAppInfo);
            return;
        }
        String str2 = "https://q.qq.com/os/store/details-more?appid=" + this.mMiniAppInfo.appId;
        if (!TextUtils.isEmpty(str)) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            str2 = str2 + "&token=" + str + "&uin=" + miniAppProxy.getAccount() + "&pid=" + miniAppProxy.getPlatformId();
        }
        Intent intent = new Intent();
        intent.putExtra("url", str2);
        intent.putExtra("title", "\u66f4\u591a\u8d44\u6599");
        new Bundle().putBoolean("hide_more_button", true);
        this.mMiniAppProxy.startBrowserActivity(getActivity(), intent);
    }

    private void update(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.name)) {
            this.mAppName.setText(this.mMiniAppInfo.name);
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.desc)) {
            this.mIntroduction.setText(this.mMiniAppInfo.desc);
        }
        updateTopTypeState(miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeNum(int i3) {
        if (!this.isLike) {
            if (this.isMiniGame) {
                this.mLikeNum.setText("\u4e3a\u5c0f\u6e38\u620f\u70b9\u8d5e");
                return;
            } else {
                this.mLikeNum.setText("\u4e3a\u5c0f\u7a0b\u5e8f\u70b9\u8d5e");
                return;
            }
        }
        if (i3 > 0) {
            if (i3 > 9999) {
                this.mLikeNum.setText(String.format("%.2f", Float.valueOf(i3 / 10000.0f)) + "\u4e07" + LIKE_NUM_POSTFIX);
                return;
            }
            this.mLikeNum.setText(i3 + LIKE_NUM_POSTFIX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeState(boolean z16) {
        if (z16) {
            this.mLikeBtn.setImageResource(R.drawable.mini_sdk_like_button);
        } else {
            this.mLikeBtn.setImageResource(R.drawable.mini_sdk_not_like_button);
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

    private void updateUIText() {
        if (this.isMiniGame) {
            this.mSetTopText.setText("\u7f6e\u9876");
            this.mRecommendMiniAppBtn.setText("\u63a8\u8350\u5c0f\u6e38\u620f");
            this.mEnterMiniAppBtn.setText("\u8fdb\u5165\u5c0f\u6e38\u620f");
            this.mLikeNum.setText("\u4e3a\u5c0f\u6e38\u620f\u70b9\u8d5e");
            return;
        }
        if (WnsUtil.needShowMiniAppFullScreen()) {
            this.mSetTopText.setText("\u7f6e\u9876");
        }
        this.mLikeNum.setText("\u4e3a\u5c0f\u7a0b\u5e8f\u70b9\u8d5e");
    }

    public String getUin() {
        return LoginManager.getInstance().getAccount();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.miniapp_enter_miniapp_btn) {
            startMiniApp();
            reportClick("launch");
        } else if (id5 == R.id.miniapp_like_container) {
            setLikeNum();
        } else if (id5 == R.id.miniapp_set_top_switch) {
            setTopType(this.mMiniAppInfo);
        } else if (id5 == R.id.miniapp_recommend_miniapp_btn) {
            startRecommendMiniApp();
            reportClick("share");
        } else if (id5 != R.id.miniapp_relative_public_account_container) {
            if (id5 == R.id.miniapp_complain_callback_container) {
                startComplainAndCallback();
            } else if (id5 == R.id.miniapp_title_back) {
                getActivity().finish();
            } else if (id5 == R.id.miniapp_title_more) {
                handleMoreButtonEvent();
            } else if (id5 == R.id.miniapp_seting) {
                handleMiniappSetting();
            } else if (id5 == R.id.miniapp_more_information) {
                handleMiniappMoreInfo();
            } else if (id5 == R.id.miniapp_dialog_cancel) {
                this.mMiniAppDialog.dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_layout, (ViewGroup) null);
        getActivity().getWindow().clearFlags(67108864);
        getActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getActivity().getWindow().setStatusBarColor(-1);
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        if (DisplayUtil.isImmersiveSupported()) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, DisplayUtil.getStatusBarHeight(getActivity()), 0, 0);
        }
        initData();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.miniapp_logo);
        this.mAppIcon = imageView;
        imageView.setOnLongClickListener(this.mLongClickListener);
        this.mAppName = (TextView) view.findViewById(R.id.miniapp_name);
        this.mIntroduction = (TextView) view.findViewById(R.id.miniapp_desc);
        this.mLikeNum = (TextView) view.findViewById(R.id.miniapp_like_num_text);
        this.mLikeBtn = (ImageView) view.findViewById(R.id.miniapp_like_image);
        this.mSetTopContainer = view.findViewById(R.id.set_top_layout);
        this.mSetTopSwitch = (Switch) view.findViewById(R.id.miniapp_set_top_switch);
        this.mRecommendMiniAppBtn = (Button) view.findViewById(R.id.miniapp_recommend_miniapp_btn);
        this.mEnterMiniAppBtn = (Button) view.findViewById(R.id.miniapp_enter_miniapp_btn);
        this.mRelativePublicAccountContainer = view.findViewById(R.id.miniapp_relative_public_account_container);
        this.mComplainCallbackContainer = view.findViewById(R.id.miniapp_complain_callback_container);
        this.mLikeContainer = view.findViewById(R.id.miniapp_like_container);
        this.mBackView = (ImageView) view.findViewById(R.id.miniapp_title_back);
        this.mMoreView = (ImageView) view.findViewById(R.id.miniapp_title_more);
        this.mSetTopText = (TextView) view.findViewById(R.id.set_top_text);
        this.mSeparator = view.findViewById(R.id.item_separator);
        this.mSetTopSwitch.setOnClickListener(this);
        this.mRecommendMiniAppBtn.setOnClickListener(this);
        this.mEnterMiniAppBtn.setOnClickListener(this);
        this.mRelativePublicAccountContainer.setOnClickListener(this);
        this.mComplainCallbackContainer.setOnClickListener(this);
        this.mComplainCallbackContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qqmini.sdk.ui.MainPageFragment.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                EventCollector.getInstance().onViewLongClickedBefore(view2);
                String str = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/" + MainPageFragment.this.mMiniAppInfo.appId + "_debug";
                if (new File(str).exists()) {
                    FileUtils.delete(str, false);
                }
                String str2 = MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(MainPageFragment.this.mMiniAppInfo.appId);
                if (new File(str2).exists()) {
                    FileUtils.delete(str2, false);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(view2.getContext().getCacheDir());
                String str3 = File.separator;
                sb5.append(str3);
                sb5.append("mini");
                sb5.append(str3);
                sb5.append(MainPageFragment.this.getUin());
                sb5.append(str3);
                sb5.append(MainPageFragment.this.mMiniAppInfo.appId);
                String sb6 = sb5.toString();
                if (new File(sb6).exists()) {
                    FileUtils.delete(sb6, false);
                }
                MainPageFragment.this.getActivity().finish();
                ProcessUtil.killProcess(Process.myPid());
                QMLog.e("MainPageFragment", "clear miniapp");
                MiniToast.makeText(view2.getContext(), "\u6e05\u9664\u6e38\u620f\u7f13\u5b58\u6570\u636e\u6210\u529f!", 1).show();
                EventCollector.getInstance().onViewLongClicked(view2);
                return false;
            }
        });
        this.mBackView.setOnClickListener(this);
        this.mMoreView.setOnClickListener(this);
        this.mLikeContainer.setOnClickListener(this);
        initUI();
        sendGetUserAppInfoRequest();
    }

    public void sendSetUserAppTopRequest(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null && QMLog.isColorLevel()) {
            QMLog.e("MainPageFragment", "sendSetUserAppTopRequest, miniAppInfo = " + this.mMiniAppInfo);
        }
    }

    private void startRecommendMiniApp() {
    }
}
