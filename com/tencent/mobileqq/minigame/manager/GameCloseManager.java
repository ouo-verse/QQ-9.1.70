package com.tencent.mobileqq.minigame.manager;

import NS_COMM.COMM;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.RetainDialogModuleUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.minigame.adapter.RecommendItemAdapter;
import com.tencent.mobileqq.minigame.config.MiniGameRetainConfigParser;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.report.MiniGameNewRetainDialogReport;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.MiniGameJumperFragment;
import com.tencent.mobileqq.minigame.ui.retain.QQCustomDialogForRetainEntrance;
import com.tencent.mobileqq.minigame.ui.retain.UsageGuideStyle;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.MiniGameStorageUtil;
import com.tencent.mobileqq.minigame.utils.QQMiniAppUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogForMiniGame;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import com.tencent.qqmini.proxyimpl.at;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.widget.RoundRectURLImageView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameCloseManager {
    private static final String DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_IMAGE_URL = "https://static.mie.qq.com/act/img/public/202408/m1723797764_guide.png";
    private static final int DIALOG_BTN_COLOR = -15066082;
    private static final int DIALOG_BTN_HEIGHT = 54;
    private static final int DIALOG_GUIDE_CONTENT_HEIGHT = 210;
    private static final int DIALOG_GUIDE_CONTENT_WIDTH = 296;
    private static final int DIALOG_GUIDE_RADIUS_5 = 5;
    private static final int LAUNCH_SCENE_MINI_GAME_CENTER = 1037;
    private static final String PREF_KEY_HAS_REMOVE_MMKV_DATA = "key_has_remove_mmkv_data";
    private static final String PREF_KEY_MINI_GAME_GUIDE_DIALOG_EXPOSURE_TIMES = "key_guide_dialog_exposure_times";
    private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES = "key_retain_confirm_exposure_times";
    private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_LAST_EXPOSE_TIMESTAMP = "key_retain_confirm_last_expose_timestamp";
    private static final String PREF_KEY_MMKV_DATA_KEY_PREFIX = "retain_confirm_";
    private static final long RECOMMEND_ITEM_EXPOSURE_DURATION = 200;
    public static final String RETAIN_CONFIRM_KEY = "retain_confirm_%s_%s_%s_%s";
    private static final String RETAIN_DIALOG_TOGGLE = "minigame_retain_dialog";
    private static final int RETAIN_MAX_FRIEND_NUM = 3;
    public static final int RETAIN_MODULE_TYPE_COLOR_SIGN = 3;
    public static final int RETAIN_MODULE_TYPE_DEFAULT = 0;
    public static final int RETAIN_MODULE_TYPE_DESKTOP_SHORTCUT = 2;
    public static final int RETAIN_MODULE_TYPE_OPERATION = 1;
    public static final int RETAIN_MODULE_TYPE_USAGE_GUIDE = 4;
    private static final int RETAIN_RECOMMEND_APP_NUM = 6;
    private static final int RETAIN_RECOMMEND_OPERATION_APP_NUM = 4;
    public static final int SCENE_JUMPING_GAME = 2120;
    private static final String TAG = "GameCloseManager";
    private static final String TOGGLE_RETAIN_DIALOG_KEY_MAX_COUNT = "maxCount";
    private static final String URL_COLOR_SIGN_BG = "https://miniapp.gtimg.cn/game/audit/reason/1663151616645/1663151616647-game_color_sign_bg.png";
    private static final String URL_COLOR_SIGN_GUIDE = "https://miniapp.gtimg.cn/game/audit/reason/1663309444646/1663309444640-game_color_sign_guide.png";
    private static final String URL_SHORTCUT_BG = "https://miniapp.gtimg.cn/game/audit/reason/1663151633793/1663151633800-game_shortcut_bg.png";
    private static final String URL_SHORTCUT_GUIDE = "https://miniapp.gtimg.cn/game/audit/reason/1663309458342/1663309458343-game_shortcut_guide.png";
    private static boolean hasShowUsageGuideDialog;
    private static final int MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD = GameWnsUtils.getDropGuideShowTimes();
    private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = GameWnsUtils.getBattleGameShowAlertViewScenes();
    private static final Map<String, Long> exposureAppIdMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ChangeAllOnClickListener implements View.OnClickListener {
        private String appId;
        public DialogInterface.OnClickListener closeListener;
        public Dialog dialog;
        public CommExtInfo ext;
        private Activity gameActivity;
        private MiniAppConfig gameConfig;
        private RecommendItemAdapter itemAdapter;
        private String refer;
        private int versionType;
        private String via;

        public ChangeAllOnClickListener(Activity activity, String str, int i3, String str2, String str3, MiniAppConfig miniAppConfig) {
            this.gameActivity = activity;
            this.appId = str;
            this.versionType = i3;
            this.refer = str2;
            this.via = str3;
            this.gameConfig = miniAppConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(ArrayList arrayList) {
            RecommendItemAdapter recommendItemAdapter = this.itemAdapter;
            if (recommendItemAdapter != null) {
                recommendItemAdapter.setData(arrayList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$1(long j3, boolean z16, JSONObject jSONObject) {
            QLog.i(GameCloseManager.TAG, 2, "[useUserApp] isSuc:" + z16 + ",cost:" + (System.currentTimeMillis() - j3));
            if (z16 && jSONObject != null && this.gameActivity != null) {
                try {
                    final ArrayList parseRecommendList = GameCloseManager.parseRecommendList(RetainDialogModuleUtil.getRecommendModule(jSONObject));
                    if (parseRecommendList != null && parseRecommendList.size() >= 6) {
                        this.ext = GameCloseManager.parseCommExtInfo(RetainDialogModuleUtil.getProperRetainModule(jSONObject, this.appId));
                        this.gameActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameCloseManager.ChangeAllOnClickListener.this.lambda$onClick$0(parseRecommendList);
                            }
                        });
                        return;
                    }
                    QLog.w(GameCloseManager.TAG, 1, "useUserApp, recommendApps == null || recommendApps.size() < RETAIN_RECOMMEND_APP_NUM");
                    return;
                } catch (JSONException e16) {
                    QLog.e(GameCloseManager.TAG, 1, "useUserApp, useUserApp request JSONException ", e16);
                    return;
                }
            }
            QLog.w(GameCloseManager.TAG, 1, "useUserApp, !isSuc || ret == null || gameActivity == null");
        }

        private COMM.StCommonExt processCommExtInfo() {
            if (this.ext == null) {
                return null;
            }
            COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
            String str = this.ext.attachInfo;
            if (str != null) {
                stCommonExt.attachInfo.set(str);
            }
            if (this.ext.mapInfo == null) {
                return stCommonExt;
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.ext.mapInfo.keySet()) {
                String str3 = this.ext.mapInfo.get(str2);
                COMM.Entry entry = new COMM.Entry();
                entry.key.set(str2);
                entry.value.set(str3);
                arrayList.add(entry);
            }
            stCommonExt.mapInfo.set(arrayList);
            return stCommonExt;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COMM.StCommonExt processCommExtInfo = processCommExtInfo();
            MiniGameNewRetainDialogReport.reportRecommendGameChange(this.gameConfig, false);
            final long currentTimeMillis = System.currentTimeMillis();
            MiniAppCmdUtil.getInstance().useUserApp(this.appId, this.versionType, 0, this.refer, this.via, processCommExtInfo, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.manager.n
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    GameCloseManager.ChangeAllOnClickListener.this.lambda$onClick$1(currentTimeMillis, z16, jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ChangeOperationAllOnClickListener implements View.OnClickListener {
        public List<MiniAppViewOperationItem> appViewItems;
        private int batchStartIndex = 4;
        public DialogInterface.OnClickListener closeListener;
        public Dialog dialog;
        private Activity gameActivity;
        private MiniAppConfig gameConfig;
        private boolean isLandscape;
        private List<MiniAppInfo> recommendOperationApps;

        public ChangeOperationAllOnClickListener(Activity activity, MiniAppConfig miniAppConfig, List<MiniAppInfo> list, boolean z16) {
            this.gameActivity = activity;
            this.gameConfig = miniAppConfig;
            this.recommendOperationApps = list;
            this.isLandscape = z16;
        }

        private void updateChangeAllItems(final DialogInterface dialogInterface, final MiniAppConfig miniAppConfig, DialogInterface.OnClickListener onClickListener, final Activity activity) {
            if (this.batchStartIndex >= this.recommendOperationApps.size()) {
                this.batchStartIndex = 0;
            }
            int size = this.batchStartIndex + 4 > this.recommendOperationApps.size() ? this.recommendOperationApps.size() - this.batchStartIndex : 4;
            for (int i3 = 0; i3 < size && i3 < this.appViewItems.size(); i3++) {
                final MiniAppInfo miniAppInfo = this.recommendOperationApps.get(this.batchStartIndex);
                this.batchStartIndex++;
                MiniAppViewOperationItem miniAppViewOperationItem = this.appViewItems.get(i3);
                if (miniAppViewOperationItem != null && miniAppInfo != null) {
                    miniAppViewOperationItem.setData(miniAppInfo, new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.ChangeOperationAllOnClickListener.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            GameCloseManager.handleClick(miniAppInfo, null, dialogInterface, 0, null, activity, true, ChangeOperationAllOnClickListener.this.isLandscape, true);
                            MiniAppConfig miniAppConfig2 = miniAppConfig;
                            MiniAppInfo miniAppInfo2 = miniAppInfo;
                            MiniGameNewRetainDialogReport.reportRecommendGameClick(miniAppConfig2, miniAppInfo2.appId, miniAppInfo2.tianshuAdId, true, miniAppInfo2.reportData);
                        }
                    });
                    MiniGameNewRetainDialogReport.reportRecommendGameShow(miniAppConfig, miniAppInfo.appId, miniAppInfo.tianshuAdId, true, miniAppInfo.reportData);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MiniGameNewRetainDialogReport.reportRecommendGameChange(this.gameConfig, true);
            updateChangeAllItems(this.dialog, this.gameConfig, this.closeListener, this.gameActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class CloseBtnClickListener implements View.OnClickListener {
        MiniAppInfo appInfo;
        MiniAppConfig closeAppConfig;
        DialogInterface.OnClickListener closeListener;
        Activity gameActivity;
        boolean isLandscape;
        DialogInterface qqCustomDialog;

        CloseBtnClickListener(MiniAppInfo miniAppInfo, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, DialogInterface.OnClickListener onClickListener, Activity activity, boolean z16) {
            this.appInfo = miniAppInfo;
            this.closeAppConfig = miniAppConfig;
            this.qqCustomDialog = dialogInterface;
            this.closeListener = onClickListener;
            this.gameActivity = activity;
            this.isLandscape = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GameCloseManager.handleClick(this.appInfo, null, this.qqCustomDialog, 0, this.closeListener, this.gameActivity, false, this.isLandscape, true);
            MiniGameNewRetainDialogReport.reportDialogDismiss(this.closeAppConfig, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class LinkJumpTask implements Runnable {
        private WeakReference<Activity> actRef;
        private boolean isLandscape;
        private String link;

        public LinkJumpTask(Activity activity, boolean z16, String str) {
            this.actRef = new WeakReference<>(activity);
            this.isLandscape = z16;
            this.link = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Class cls;
            Activity activity = this.actRef.get();
            if (activity == null) {
                QLog.e(GameCloseManager.TAG, 1, "handle LinkJumpTask but gameActivity invalid");
                return;
            }
            if (this.isLandscape) {
                cls = QPublicTransFragmentActivityLandscape.class;
            } else {
                cls = QPublicTransFragmentActivity.class;
            }
            String name = cls.getName();
            Intent intent = new Intent();
            intent.putExtra(ZPlanPublishSource.FROM_SCHEME, this.link);
            intent.setComponent(new ComponentName("com.tencent.mobileqq", name));
            intent.putExtra("public_fragment_class", MiniGameJumperFragment.class.getName());
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppViewOperationItem {
        private Context context;
        private ArrayList<ImageView> friendIconList = new ArrayList<>();
        private ImageView imageView;
        private View root;
        private TextView textView;

        public MiniAppViewOperationItem(Context context) {
            this.context = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.fif, (ViewGroup) null, false);
            this.root = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.exe);
            this.imageView = imageView;
            if (imageView instanceof ThemeImageView) {
                ((ThemeImageView) imageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
            }
            this.textView = (TextView) this.root.findViewById(R.id.exf);
        }

        public void setData(MiniAppInfo miniAppInfo, final View.OnClickListener onClickListener) {
            this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.context, miniAppInfo.iconUrl, true));
            this.textView.setVisibility(0);
            this.textView.setText(miniAppInfo.name);
            this.root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.MiniAppViewOperationItem.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canReportExposure(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, Long> map = exposureAppIdMap;
        Long l3 = map.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (l3 != null && Math.abs(currentTimeMillis - l3.longValue()) < RECOMMEND_ITEM_EXPOSURE_DURATION) {
            return false;
        }
        map.put(str, Long.valueOf(currentTimeMillis));
        return true;
    }

    private static boolean checkInterval(Activity activity) {
        int retainConfirmInterval = GameWnsUtils.getRetainConfirmInterval();
        long currentTimeMillis = (System.currentTimeMillis() - (activity instanceof GameActivity1 ? ((GameActivity1) activity).getStartTime() : 0L)) / 1000;
        if (currentTimeMillis <= retainConfirmInterval) {
            return false;
        }
        QLog.i(TAG, 1, "showRetainGuideDialog: not show, duration=" + currentTimeMillis + " timeInterval=" + retainConfirmInterval);
        return true;
    }

    private static void doShowColorSignDialog(final Activity activity, final MiniAppConfig miniAppConfig, final DialogInterface.OnClickListener onClickListener, final com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo, final boolean z16) {
        doShowGuideDialogBase(activity, URL_COLOR_SIGN_BG, URL_COLOR_SIGN_GUIDE, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowColorSignDialog$8(onClickListener, activity, z16, miniAppConfig, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowColorSignDialog$9(MiniAppConfig.this, miniAppInfo, activity, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowColorSignDialog$10(MiniAppConfig.this, dialogInterface, i3);
            }
        }, R.string.f167752ds, R.string.f167762dt, R.string.f167782dv);
        RetainDialogModuleUtil.saveShowTime(3, miniAppInfo.appId);
        MiniGameNewRetainDialogReport.reportColorSignDialogShow(miniAppConfig);
    }

    private static void doShowDropGuideDialog(Activity activity, final MiniAppConfig miniAppConfig, final String str, final String str2, final DialogInterface.OnClickListener onClickListener) {
        final Dialog dialog = new Dialog(activity, R.style.ayi);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.fi9);
        ((ImageView) dialog.findViewById(R.id.z9n)).setImageDrawable(MiniAppUtils.getDrawable(DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_IMAGE_URL, null));
        TextView textView = (TextView) dialog.findViewById(R.id.z9o);
        SpannableString spannableString = new SpannableString("\u73a9\u8fc7\u7684\u5c0f\u6e38\u620f\u53ef\u4ee5\u5728\u9996\u9875\"\u4e0b\u62c9\"\u627e\u5230\u54e6");
        spannableString.setSpan(new ForegroundColorSpan(-16725505), 12, 14, 33);
        textView.setText(spannableString);
        ((Button) dialog.findViewById(R.id.z9m)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiniProgramLpReportDC04239.reportByDropGuideDialog(MiniAppConfig.this, MiniProgramLpReportDC04239.DROP_GUIDE_DIALOG_ACTION_TYPE, "popup", "expo", str, str2);
                dialog.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialog, 0);
                }
            }
        });
        dialog.show();
        MiniProgramLpReportDC04239.reportByDropGuideDialog(miniAppConfig, MiniProgramLpReportDC04239.DROP_GUIDE_DIALOG_ACTION_TYPE, "popup", "click", str, str2);
    }

    private static void doShowGuideDialogBase(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, final DialogInterface.OnClickListener onClickListener3, int i3, int i16, int i17) {
        final QQCustomDialogForMiniGame qQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(activity, R.style.ayi);
        qQCustomDialogForMiniGame.setContentView(R.layout.fi8);
        qQCustomDialogForMiniGame.setBodyLayoutNoMargin();
        qQCustomDialogForMiniGame.setBackground(R.drawable.f161086k04);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.fi_, (ViewGroup) null, false);
        inflate.findViewById(R.id.dum).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClickListener3.onClick(qQCustomDialogForMiniGame, 0);
            }
        });
        ((TextView) inflate.findViewById(R.id.f112056mw)).setText(i3);
        RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) inflate.findViewById(R.id.y3y);
        roundRectURLImageView.setRadius(ViewUtils.dpToPx(5.0f));
        roundRectURLImageView.setImageURL(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0f), ViewUtils.dpToPx(210.0f));
        layoutParams.gravity = 17;
        qQCustomDialogForMiniGame.setCancelable(false);
        qQCustomDialogForMiniGame.setTitle((String) null);
        qQCustomDialogForMiniGame.setMessage((CharSequence) null);
        qQCustomDialogForMiniGame.addView(inflate, layoutParams);
        qQCustomDialogForMiniGame.setNegativeButton(i16, onClickListener);
        qQCustomDialogForMiniGame.setPositiveButton(i17, onClickListener2, false);
        initBtnLayout(qQCustomDialogForMiniGame);
        qQCustomDialogForMiniGame.show();
    }

    private static void doShowRetainForEntranceDialog(final Activity activity, final MiniAppConfig miniAppConfig, final MiniAppInfo miniAppInfo, String str, final boolean z16, final DialogInterface.OnClickListener onClickListener, UsageGuideStyle usageGuideStyle) {
        final QQCustomDialogForRetainEntrance qQCustomDialogForRetainEntrance = new QQCustomDialogForRetainEntrance(activity, R.style.ayi, miniAppConfig);
        qQCustomDialogForRetainEntrance.setLandscape(z16);
        qQCustomDialogForRetainEntrance.setContentView(z16 ? R.layout.dkc : R.layout.dkb);
        qQCustomDialogForRetainEntrance.setUsageGuideStyle(usageGuideStyle);
        qQCustomDialogForRetainEntrance.setCanceledOnTouchOutside(false);
        qQCustomDialogForRetainEntrance.setDialogGravity();
        qQCustomDialogForRetainEntrance.setCancelable(true);
        qQCustomDialogForRetainEntrance.setClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QQCustomDialogForRetainEntrance.this.reportExitBtnClick();
                QQCustomDialogForRetainEntrance.this.subScribePubAccount();
                GameCloseManager.handleClick(miniAppInfo, null, QQCustomDialogForRetainEntrance.this, -2, onClickListener, activity, false, z16, true);
            }
        }, new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiniGameNewRetainDialogReport.reportFunctionRetainMoreBtnClick(MiniAppConfig.this);
                GameCloseManager.handleClick(miniAppInfo, null, qQCustomDialogForRetainEntrance, -2, null, activity, true, z16, false);
            }
        }, new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QQCustomDialogForRetainEntrance.this.reportCloseBtnClick();
                QQCustomDialogForRetainEntrance.this.subScribePubAccount();
                QQCustomDialogForRetainEntrance.this.dismiss();
            }
        });
        qQCustomDialogForRetainEntrance.checkSubscribeAndShow();
        hasShowUsageGuideDialog = true;
        RetainDialogModuleUtil.removeFunctionRetainJson();
    }

    private static void doShowShortCutDialog(final Activity activity, final MiniAppConfig miniAppConfig, final DialogInterface.OnClickListener onClickListener, final com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo, final boolean z16) {
        doShowGuideDialogBase(activity, URL_SHORTCUT_BG, URL_SHORTCUT_GUIDE, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowShortCutDialog$4(onClickListener, activity, z16, miniAppConfig, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowShortCutDialog$6(activity, miniAppInfo, miniAppConfig, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowShortCutDialog$7(MiniAppConfig.this, dialogInterface, i3);
            }
        }, R.string.f167802dx, R.string.f167762dt, R.string.f167792dw);
        RetainDialogModuleUtil.saveShowTime(2, miniAppInfo.appId);
        MiniGameNewRetainDialogReport.reportShotCutDialogShow(miniAppConfig);
    }

    public static String getAndRemoveRetainInfoCache(String str, int i3, String str2) {
        String format = String.format(RETAIN_CONFIRM_KEY, str, BaseApplicationImpl.getApplication().getRuntime().getAccount(), String.valueOf(i3), str2);
        String string = MiniGameStorageUtil.getString(format, null);
        MiniGameStorageUtil.removeKey(format);
        if (StorageUtil.getPreference().contains(format)) {
            StorageUtil.getPreference().edit().remove(format).commit();
        }
        return string;
    }

    private static int getDropGuideDialogShowTimes() {
        return MiniAppMMKVUtils.getInt("key_guide_dialog_exposure_times_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x006d, code lost:
    
        if (r4.get(1) == r2.get(1)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getRetainDialogShowTimes() {
        boolean z16;
        int i3 = MiniAppMMKVUtils.getInt("key_retain_confirm_exposure_times_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
        long j3 = MiniAppMMKVUtils.getLong("key_retain_confirm_last_expose_timestamp_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0L);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        if (calendar.get(6) == calendar2.get(6)) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            return i3;
        }
        return 0;
    }

    private static int getRetainMaxExposureCount() {
        JSONObject jSONObject;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (jSONObject = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject(RETAIN_DIALOG_TOGGLE, "")) == null) {
            return 0;
        }
        return jSONObject.optInt(TOGGLE_RETAIN_DIALOG_KEY_MAX_COUNT);
    }

    public static boolean handleDropGuideDialog(Activity activity, MiniAppConfig miniAppConfig, DialogInterface.OnClickListener onClickListener) {
        String str;
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_DROP_GUIDE_SCENE_BLACK_LIST, QzoneConfig.DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_BLACK_LIST);
        String config2 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_DROP_GUIDE_SCENE_AND_VIA_BLACK_LIST, QzoneConfig.DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_AND_VIA_BLACK_LIST);
        String config3 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_DROP_GUIDE_SCENE_AND_MODE_BLACK_LIST, QzoneConfig.DEFAULT_VALUE_MINI_GAME_DROP_GUIDE_SCENE_AND_MODE_BLACK_LIST);
        LaunchParam launchParam = miniAppConfig.launchParam;
        int i3 = launchParam == null ? 0 : launchParam.scene;
        String str2 = miniAppConfig.config.via;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        if (launchParam == null || TextUtils.isEmpty(launchParam.reportData)) {
            str = "";
        } else {
            String[] parseModeAndLocation = parseModeAndLocation(miniAppConfig.launchParam.reportData);
            str3 = parseModeAndLocation[0];
            str = parseModeAndLocation[1];
        }
        int dropGuideDialogShowTimes = getDropGuideDialogShowTimes();
        if (dropGuideDialogShowTimes >= MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD) {
            QLog.i(TAG, 1, "handleDropGuideDialog: not show, show too many times");
            return false;
        }
        if (!isInSceneBlackList(i3, config) && !isInSceneAndViaBlackList(i3, str2, config2) && !isInSceneAndModeBlackList(i3, str3, config3)) {
            try {
                doShowDropGuideDialog(activity, miniAppConfig, str3, str, onClickListener);
                updateDropGuideDialogShowTimes(dropGuideDialogShowTimes);
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleDropGuideDialog: doShowDropGuideDialog exception.", e16);
                return false;
            }
        }
        QLog.i(TAG, 1, "handleDropGuideDialog: not show, is in blacklist");
        return false;
    }

    private static void initBtnLayout(QQCustomDialog qQCustomDialog) {
        qQCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT, 1);
        qQCustomDialog.getBtnight().setTextColor(DIALOG_BTN_COLOR);
        qQCustomDialog.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
        qQCustomDialog.getBtnLeft().setTextColor(DIALOG_BTN_COLOR);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qQCustomDialog.getBtnight().getLayoutParams();
        layoutParams.height = ViewUtils.dpToPx(54.0f);
        qQCustomDialog.getBtnight().setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qQCustomDialog.getBtnLeft().getLayoutParams();
        layoutParams2.height = ViewUtils.dpToPx(54.0f);
        qQCustomDialog.getBtnLeft().setLayoutParams(layoutParams2);
    }

    private static boolean isInSceneBlackList(int i3, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList.contains(String.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowColorSignDialog$10(MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        MiniGameNewRetainDialogReport.reportColorSignDialogCloseClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowColorSignDialog$9(MiniAppConfig miniAppConfig, com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo, Activity activity, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        MiniGameNewRetainDialogReport.reportColorSignDialogAddClick(miniAppConfig);
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniApp()) {
            PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
            if (pageGestureProxy instanceof at) {
                handleColorNoteClickEvent(((at) pageGestureProxy).g());
                return;
            }
            return;
        }
        if (activity instanceof GameActivity1) {
            handleColorNoteClickEvent(((GameActivity1) activity).getColorNoteController());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowRetainDialog$1(QQCustomDialog qQCustomDialog, MiniAppConfig miniAppConfig, View view) {
        qQCustomDialog.dismiss();
        MiniGameNewRetainDialogReport.reportNewRetainCloseClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowRetainDialog$3(String str, MiniAppInfo miniAppInfo, Activity activity, boolean z16, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        String jumpLink = MiniGameRetainConfigParser.loadConfig().getJumpLink();
        QLog.i(TAG, 2, "configJumpLink:" + jumpLink);
        handleClick(miniAppInfo, TextUtils.isEmpty(jumpLink) ? str : jumpLink, dialogInterface, i3, null, activity, true, z16, true);
        MiniGameNewRetainDialogReport.reportNewRetainMoreGameClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowShortCutDialog$5(Activity activity, DialogInterface dialogInterface, int i3, String str) {
        QLog.e(TAG, 1, "[doShowShortCutDialog] retCode:" + i3);
        if (i3 == 0 || (i3 == 1 && !ShortcutUtils.h())) {
            if (i3 == 1) {
                QQToast.makeText(activity, 1, R.string.tfv, 0).show();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowShortCutDialog$6(final Activity activity, com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo, MiniAppConfig miniAppConfig, final DialogInterface dialogInterface, int i3) {
        ShortcutUtils.g(activity, miniAppInfo, new ShortcutUtils.c() { // from class: com.tencent.mobileqq.minigame.manager.b
            @Override // com.tencent.qqmini.proxyimpl.ShortcutUtils.c
            public final void a(int i16, String str) {
                GameCloseManager.lambda$doShowShortCutDialog$5(activity, dialogInterface, i16, str);
            }
        });
        MiniGameNewRetainDialogReport.reportShotCutDialogAddClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowShortCutDialog$7(MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        MiniGameNewRetainDialogReport.reportShotCutDialogCloseClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveRetainInfoCache$0() {
        MiniAppMMKVUtils.removeKeyPrefix(PREF_KEY_MMKV_DATA_KEY_PREFIX);
        QLog.i(TAG, 1, "saveRetainInfoCache: removeKeyPrefix mmkv old data");
    }

    private static String parseBackgroundPic(JSONObject jSONObject) {
        return jSONObject.optString("backgroundPic");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CommExtInfo parseCommExtInfo(JSONObject jSONObject) {
        String optString = jSONObject.optString("ext");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return (CommExtInfo) GsonUtils.json2Obj(optString, CommExtInfo.class);
    }

    private static String[] parseModeAndLocation(String str) {
        String str2 = "";
        String str3 = "";
        for (String str4 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            if (str4.contains("mode")) {
                String[] split = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length > 1) {
                    str2 = split[1];
                }
            }
            if (str4.contains("location")) {
                String[] split2 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length > 1) {
                    str3 = split2[1];
                }
            }
        }
        return new String[]{str2, str3};
    }

    private static int parseModuleType(JSONObject jSONObject) {
        return jSONObject.optInt("moduleType");
    }

    private static MiniAppInfo parseMoreAppInfo(JSONObject jSONObject) {
        String optString = jSONObject.optString("moreAppInfo");
        if (TextUtils.isEmpty(optString)) {
            QLog.i(TAG, 1, "showRetainGuideDialog: not show, moreAppStr == null");
            return null;
        }
        return (MiniAppInfo) GsonUtils.json2Obj(optString, MiniAppInfo.class);
    }

    private static String parseMoreAppLink(JSONObject jSONObject) {
        return jSONObject.optString("jumpLink");
    }

    private static ArrayList<MiniAppInfo> parseOperationRecommendList(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("operationAppList");
        if (optJSONArray != null && optJSONArray.length() >= 4) {
            ArrayList<MiniAppInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                MiniAppInfo miniAppInfo = (MiniAppInfo) GsonUtils.json2Obj(optJSONArray.getString(i3), MiniAppInfo.class);
                if (miniAppInfo != null) {
                    arrayList.add(miniAppInfo);
                }
            }
            return arrayList;
        }
        QLog.i(TAG, 1, "showRetainGuideDialog: not show, appList is empty or too small");
        return null;
    }

    private static int parsePopupType(JSONObject jSONObject) {
        return jSONObject.optInt("popupType");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<MiniAppInfo> parseRecommendList(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("appList");
        if (optJSONArray != null && optJSONArray.length() >= 6) {
            ArrayList<MiniAppInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < 6; i3++) {
                MiniAppInfo miniAppInfo = (MiniAppInfo) GsonUtils.json2Obj(optJSONArray.getString(i3), MiniAppInfo.class);
                if (miniAppInfo != null) {
                    arrayList.add(miniAppInfo);
                }
            }
            return arrayList;
        }
        QLog.i(TAG, 1, "showRetainGuideDialog: not show, appList is empty or too small");
        return null;
    }

    private static void updateDropGuideDialogShowTimes(int i3) {
        MiniAppMMKVUtils.putInt("key_guide_dialog_exposure_times_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), i3 + 1);
    }

    private static void updateRetainDialogShowTimes(int i3) {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        MiniAppMMKVUtils.putInt("key_retain_confirm_exposure_times_" + account, i3 + 1);
        MiniAppMMKVUtils.putLong("key_retain_confirm_last_expose_timestamp_" + account, System.currentTimeMillis());
    }

    private static boolean isInSceneAndViaBlackList(int i3, String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                int i17 = jSONObject.getInt("scene");
                String string = jSONObject.getString("via");
                if (i3 == i17 && !TextUtils.isEmpty(str) && str.equals(string)) {
                    return true;
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public static void saveRetainInfoCache(String str, String str2, String str3, String str4, String str5) {
        MiniGameStorageUtil.putString(String.format(RETAIN_CONFIRM_KEY, str2, str3, str4, str5), str);
        if (StorageUtil.getPreference().getBoolean(PREF_KEY_HAS_REMOVE_MMKV_DATA, false)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.f
                @Override // java.lang.Runnable
                public final void run() {
                    GameCloseManager.lambda$saveRetainInfoCache$0();
                }
            }, 64, null, false);
            StorageUtil.getPreference().edit().putBoolean(PREF_KEY_HAS_REMOVE_MMKV_DATA, true).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleClick(MiniAppInfo miniAppInfo, String str, DialogInterface dialogInterface, int i3, DialogInterface.OnClickListener onClickListener, Activity activity, boolean z16, boolean z17, boolean z18) {
        if (z16) {
            if (!TextUtils.isEmpty(str)) {
                ThreadManagerV2.getUIHandlerV2().post(new LinkJumpTask(activity, z17, str));
            } else {
                try {
                    MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, 2120);
                } catch (MiniAppException e16) {
                    QLog.e(TAG, 1, "launch more game error", e16);
                }
            }
        }
        if (z18) {
            dialogInterface.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
    }

    private static void handleColorNoteClickEvent(IColorNoteController iColorNoteController) {
        if (iColorNoteController != null) {
            if (iColorNoteController.canAddColorNote()) {
                iColorNoteController.insertColorNote();
            } else {
                iColorNoteController.onCannotAdd();
            }
        }
    }

    private static boolean shouldShowAlertViewForBattleGame(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null && miniAppInfo.whiteList != null && miniAppConfig.launchParam != null) {
            QLog.d(TAG, 2, "shouldShowAlertViewForBattleGame ", " api " + Arrays.toString(miniAppConfig.config.whiteList.toArray()) + " scenes " + MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES);
            for (String str : miniAppConfig.config.whiteList) {
                if ("showRetainAlterViewType1".equals(str)) {
                    return true;
                }
                if (str.startsWith("showRetainAlterViewType")) {
                    String str2 = MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        try {
                            JSONArray optJSONArray = new JSONObject(str2).optJSONArray(str.replace("showRetainAlterViewType", ""));
                            if (optJSONArray != null) {
                                int length = optJSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    if (optJSONArray.optInt(i3, 0) == miniAppConfig.launchParam.scene) {
                                        return true;
                                    }
                                }
                            } else {
                                continue;
                            }
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "shouldShowAlertViewForBattleGame ", e16);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void doShowRetainOperationDialog(final Activity activity, final MiniAppInfo miniAppInfo, final String str, final MiniAppConfig miniAppConfig, final ArrayList<MiniAppInfo> arrayList, String str2, DialogInterface.OnClickListener onClickListener, ChangeOperationAllOnClickListener changeOperationAllOnClickListener, final boolean z16) {
        Activity activity2 = activity;
        String config = TextUtils.isEmpty(str2) ? QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_BACKGROUND_URL) : str2;
        final QQCustomDialogForMiniGame qQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(activity2, R.style.ayi);
        qQCustomDialogForMiniGame.setContentView(R.layout.fi8);
        qQCustomDialogForMiniGame.setBodyLayoutNoMargin();
        qQCustomDialogForMiniGame.setBackground(R.drawable.f161087k05);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.fie, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.zbc);
        changeOperationAllOnClickListener.gameActivity = activity2;
        changeOperationAllOnClickListener.dialog = qQCustomDialogForMiniGame;
        changeOperationAllOnClickListener.closeListener = onClickListener;
        linearLayout.setOnClickListener(changeOperationAllOnClickListener);
        ((URLImageView) inflate.findViewById(R.id.f2111005)).setBackground(MiniAppUtils.getDrawable(config, null));
        inflate.findViewById(R.id.f2112006).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                if (miniAppInfo2 != null && !TextUtils.isEmpty(miniAppInfo2.appId)) {
                    try {
                        MiniAppLauncher.launchAppByAppInfo(activity, MiniAppInfo.this, 2120);
                    } catch (MiniAppException e16) {
                        QLog.e(GameCloseManager.TAG, 1, "launch operation game error", e16);
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    try {
                        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
                        activity.startActivity(intent);
                    } catch (UnsupportedEncodingException e17) {
                        QLog.e(GameCloseManager.TAG, 1, "launch operation url error", e17);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int i3 = 0;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    i3 = ((MiniAppInfo) arrayList.get(0)).tianshuAdId;
                }
                MiniGameNewRetainDialogReport.reportPicClick(miniAppConfig, i3, true);
                qQCustomDialogForMiniGame.dismiss();
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.i2z);
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < 4) {
            MiniAppViewOperationItem miniAppViewOperationItem = new MiniAppViewOperationItem(activity2);
            final MiniAppInfo miniAppInfo2 = arrayList.get(i3);
            final QQCustomDialogForMiniGame qQCustomDialogForMiniGame2 = qQCustomDialogForMiniGame;
            miniAppViewOperationItem.setData(miniAppInfo2, new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GameCloseManager.handleClick(MiniAppInfo.this, null, qQCustomDialogForMiniGame2, 0, null, activity, true, z16, true);
                    MiniAppConfig miniAppConfig2 = miniAppConfig;
                    MiniAppInfo miniAppInfo3 = MiniAppInfo.this;
                    MiniGameNewRetainDialogReport.reportRecommendGameClick(miniAppConfig2, miniAppInfo3.appId, miniAppInfo3.tianshuAdId, true, miniAppInfo3.reportData);
                }
            });
            arrayList2.add(miniAppViewOperationItem);
            linearLayout2.addView(miniAppViewOperationItem.root);
            MiniGameNewRetainDialogReport.reportRecommendGameShow(miniAppConfig, miniAppInfo2.appId, miniAppInfo2.tianshuAdId, true, miniAppInfo2.reportData);
            i3++;
            activity2 = activity;
            qQCustomDialogForMiniGame = qQCustomDialogForMiniGame;
        }
        QQCustomDialogForMiniGame qQCustomDialogForMiniGame3 = qQCustomDialogForMiniGame;
        changeOperationAllOnClickListener.appViewItems = arrayList2;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.zbi);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.zbj);
        if (!z16) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new CloseBtnClickListener(miniAppInfo, miniAppConfig, qQCustomDialogForMiniGame3, onClickListener, activity, z16));
        } else {
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new CloseBtnClickListener(miniAppInfo, miniAppConfig, qQCustomDialogForMiniGame3, onClickListener, activity, z16));
        }
        qQCustomDialogForMiniGame3.setCancelable(true);
        qQCustomDialogForMiniGame3.setTitle((String) null).setMessage((CharSequence) null).addView(inflate).show();
        MiniGameNewRetainDialogReport.reportDialogShow(miniAppConfig, true);
    }

    public static boolean showAlertViewForBattleGame(GameActivity gameActivity, MiniAppConfig miniAppConfig, final DialogInterface.OnClickListener onClickListener) {
        if (gameActivity == null || miniAppConfig == null || !shouldShowAlertViewForBattleGame(miniAppConfig)) {
            return false;
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(gameActivity, 230).setTitle(gameActivity.getString(R.string.f173206i10)).setMessage(gameActivity.getString(R.string.w1s)).setNegativeButton(gameActivity.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(gameActivity.getString(R.string.w1r), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i3);
                }
            }
        });
        positiveButton.setCancelable(false);
        positiveButton.show();
        return true;
    }

    private static void doShowRetainDialog(final Activity activity, final MiniAppConfig miniAppConfig, final MiniAppInfo miniAppInfo, final String str, ArrayList<MiniAppInfo> arrayList, final boolean z16, final DialogInterface.OnClickListener onClickListener, ChangeAllOnClickListener changeAllOnClickListener) {
        boolean z17;
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_CHANGE_ALL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_CHANGE_ALL);
        String config2 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_BACKGROUND_URL);
        String config3 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL);
        String config4 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL);
        final QQCustomDialogForMiniGame qQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(activity, R.style.ayi);
        qQCustomDialogForMiniGame.setContentView(R.layout.fi8);
        qQCustomDialogForMiniGame.setBodyLayoutNoMargin();
        qQCustomDialogForMiniGame.setBackground(R.drawable.f161087k05);
        qQCustomDialogForMiniGame.setCanceledOnTouchOutside(false);
        final View inflate = LayoutInflater.from(activity).inflate(R.layout.fic, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.f112056mw)).setTextSize(1, z16 ? 15.0f : 17.0f);
        GridView gridView = (GridView) inflate.findViewById(R.id.i2z);
        RecommendItemAdapter recommendItemAdapter = new RecommendItemAdapter(arrayList, new RecommendItemAdapter.OnRecommendItemClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.6
            @Override // com.tencent.mobileqq.minigame.adapter.RecommendItemAdapter.OnRecommendItemClickListener
            public void onExposure(MiniAppInfo miniAppInfo2) {
                if (GameCloseManager.canReportExposure(miniAppInfo2.appId)) {
                    MiniGameNewRetainDialogReport.reportRecommendGameShow(MiniAppConfig.this, miniAppInfo2.appId, miniAppInfo2.tianshuAdId, true, miniAppInfo2.reportData);
                    QLog.i(GameCloseManager.TAG, 2, "[onExposure] appId:" + miniAppInfo2.appId);
                }
            }

            @Override // com.tencent.mobileqq.minigame.adapter.RecommendItemAdapter.OnRecommendItemClickListener
            public void onClick(MiniAppInfo miniAppInfo2) {
                GameCloseManager.handleClick(miniAppInfo2, null, qQCustomDialogForMiniGame, 0, null, activity, true, z16, true);
                MiniGameNewRetainDialogReport.reportRecommendGameClick(MiniAppConfig.this, miniAppInfo2.appId, miniAppInfo2.tianshuAdId, true, miniAppInfo2.reportData);
            }
        });
        recommendItemAdapter.setIsLandscape(z16);
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(z16 ? 13.0f : 15.0f);
        }
        gridView.setPadding(0, ViewUtils.dpToPx(z16 ? 13.0f : 15.0f), 0, 0);
        gridView.setNumColumns(3);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setHorizontalScrollBarEnabled(false);
        gridView.setClipToPadding(false);
        gridView.setVerticalSpacing(ViewUtils.dpToPx(11.0f));
        gridView.setSelector(new ColorDrawable(0));
        gridView.setAdapter((ListAdapter) recommendItemAdapter);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.zbc);
        ((ImageView) inflate.findViewById(R.id.zbb)).setImageDrawable(MiniAppUtils.getDrawable(config, null));
        changeAllOnClickListener.gameActivity = activity;
        changeAllOnClickListener.dialog = qQCustomDialogForMiniGame;
        changeAllOnClickListener.closeListener = onClickListener;
        changeAllOnClickListener.itemAdapter = recommendItemAdapter;
        linearLayout.setOnClickListener(changeAllOnClickListener);
        inflate.setBackground(MiniAppUtils.getDrawable(config2, null));
        inflate.findViewById(R.id.dum).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameCloseManager.lambda$doShowRetainDialog$1(QQCustomDialog.this, miniAppConfig, view);
            }
        });
        final LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0f), ViewUtils.dpToPx(z16 ? 271.0f : 296.0f));
        layoutParams2.gravity = 17;
        qQCustomDialogForMiniGame.setCancelable(true);
        qQCustomDialogForMiniGame.setTitle((String) null).setMessage((CharSequence) null).addView(inflate, layoutParams2).setNegativeButton(R.string.f167762dt, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowRetainDialog$2(MiniAppInfo.this, onClickListener, activity, z16, miniAppConfig, dialogInterface, i3);
            }
        }).setPositiveButton(R.string.f167772du, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCloseManager.lambda$doShowRetainDialog$3(str, miniAppInfo, activity, z16, miniAppConfig, dialogInterface, i3);
            }
        });
        qQCustomDialogForMiniGame.getBtnight().setTypeface(Typeface.DEFAULT, 1);
        qQCustomDialogForMiniGame.getBtnight().setTextColor(-1);
        qQCustomDialogForMiniGame.getBtnight().setBackground(MiniAppUtils.getDrawable(config4, null));
        qQCustomDialogForMiniGame.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
        qQCustomDialogForMiniGame.getBtnLeft().setTextColor(-1);
        qQCustomDialogForMiniGame.getBtnLeft().setBackground(MiniAppUtils.getDrawable(config3, null));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qQCustomDialogForMiniGame.getBtnight().getLayoutParams();
        layoutParams3.height = ViewUtils.dpToPx(z16 ? 45.0f : 52.0f);
        qQCustomDialogForMiniGame.getBtnight().setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) qQCustomDialogForMiniGame.getBtnLeft().getLayoutParams();
        layoutParams4.height = ViewUtils.dpToPx(z16 ? 45.0f : 52.0f);
        qQCustomDialogForMiniGame.getBtnLeft().setLayoutParams(layoutParams4);
        try {
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                qQCustomDialogForMiniGame.show();
                com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GameCloseManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            return;
                        }
                        int rootViewHeight = qQCustomDialogForMiniGame.getRootViewHeight();
                        int screenHeight = DisplayUtil.getScreenHeight(activity);
                        QLog.i(GameCloseManager.TAG, 1, "update retain dialog height: dialog_height=" + rootViewHeight + ", screen_height=" + screenHeight);
                        if (rootViewHeight > screenHeight - 110) {
                            layoutParams2.height = ViewUtils.dpToPx(200.0f);
                            inflate.setLayoutParams(layoutParams2);
                        }
                    }
                });
            }
            z17 = true;
        } catch (Exception e16) {
            z17 = true;
            QLog.e(TAG, 1, "doShowRetainDialog error:", e16);
        }
        MiniGameNewRetainDialogReport.reportDialogShow(miniAppConfig, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowColorSignDialog$8(DialogInterface.OnClickListener onClickListener, Activity activity, boolean z16, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        handleClick(null, null, dialogInterface, i3, onClickListener, activity, false, z16, true);
        MiniGameNewRetainDialogReport.reportColorSignDialogQuitClick(miniAppConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowRetainDialog$2(MiniAppInfo miniAppInfo, DialogInterface.OnClickListener onClickListener, Activity activity, boolean z16, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        handleClick(miniAppInfo, null, dialogInterface, i3, onClickListener, activity, false, z16, true);
        MiniGameNewRetainDialogReport.reportDialogDismiss(miniAppConfig, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShowShortCutDialog$4(DialogInterface.OnClickListener onClickListener, Activity activity, boolean z16, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        handleClick(null, null, dialogInterface, i3, onClickListener, activity, false, z16, true);
        MiniGameNewRetainDialogReport.reportShotCutDialogQuitClick(miniAppConfig);
    }

    private static boolean isInSceneAndModeBlackList(int i3, String str, String str2) {
        if (i3 != 2001 && i3 != 1037) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : str2.split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(str3);
            }
        }
        return arrayList.contains(str);
    }

    public static boolean handleRetainGuideDialog(Activity activity, String str, MiniAppConfig miniAppConfig, com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo, DialogInterface.OnClickListener onClickListener) {
        MiniAppInfo miniAppInfo2;
        ArrayList<MiniAppInfo> arrayList;
        if (miniAppConfig == null || (miniAppInfo2 = miniAppConfig.config) == null) {
            return false;
        }
        String str2 = miniAppInfo2.appId;
        LaunchParam launchParam = miniAppConfig.launchParam;
        int i3 = launchParam == null ? 0 : launchParam.scene;
        String str3 = miniAppInfo2.via;
        if (str3 == null) {
            str3 = "";
        }
        int i16 = miniAppInfo2.verType;
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || TextUtils.isEmpty(str2)) {
            return false;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        boolean z16 = requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6 || requestedOrientation == 11;
        if (i3 == 2120) {
            QLog.i(TAG, 1, "showRetainGuideDialog: not show, scene == 2113");
            return false;
        }
        int retainDialogShowTimes = getRetainDialogShowTimes();
        int retainMaxExposureCount = getRetainMaxExposureCount();
        if (retainMaxExposureCount > 0 && retainDialogShowTimes >= retainMaxExposureCount) {
            QLog.i(TAG, 1, "showRetainGuideDialog: not show, show too many times\uff0cshowTimes:" + retainDialogShowTimes + ",maxShowTimes:" + retainMaxExposureCount);
            return false;
        }
        try {
            JSONObject usageGuideRetainJson = MiniAppDetainManager.INSTANCE.getUsageGuideRetainJson();
            if (usageGuideRetainJson == null) {
                if (TextUtils.isEmpty(str)) {
                    QLog.i(TAG, 1, "showRetainGuideDialog: not show, no result cache");
                    return false;
                }
                usageGuideRetainJson = RetainDialogModuleUtil.getProperRetainModule(str, str2);
            }
            MiniAppInfo parseMoreAppInfo = parseMoreAppInfo(usageGuideRetainJson);
            int parsePopupType = parsePopupType(usageGuideRetainJson);
            if (parsePopupType == 2) {
                try {
                    QLog.i(TAG, 1, "showRetainGuideDialog: not show, popupType=INTERFACE.NotPopup");
                    return false;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "showRetainGuideDialog: not show, parse json error", e);
                    return false;
                }
            }
            if (parsePopupType == 0 && checkInterval(activity)) {
                return false;
            }
            int parseModuleType = parseModuleType(usageGuideRetainJson);
            StringBuilder sb5 = new StringBuilder();
            String str4 = str3;
            sb5.append("[handleRetainGuideDialog] popupType:");
            sb5.append(parsePopupType);
            sb5.append(",moduleType:");
            sb5.append(parseModuleType);
            QLog.i(TAG, 2, sb5.toString());
            ArrayList<MiniAppInfo> parseRecommendList = parseRecommendList(usageGuideRetainJson);
            if (parseModuleType == 0 && (parseMoreAppInfo == null || parseRecommendList == null || parseRecommendList.size() < 6)) {
                return false;
            }
            ArrayList<MiniAppInfo> parseOperationRecommendList = parseOperationRecommendList(usageGuideRetainJson);
            if (parseModuleType != 1) {
                arrayList = parseRecommendList;
            } else {
                if (parseMoreAppInfo == null || parseOperationRecommendList == null) {
                    return false;
                }
                arrayList = parseRecommendList;
                if (parseOperationRecommendList.size() < 4) {
                    return false;
                }
            }
            String parseBackgroundPic = !z16 ? parseBackgroundPic(usageGuideRetainJson) : null;
            String parseMoreAppLink = parseMoreAppLink(usageGuideRetainJson);
            String parseBackgroundPic2 = parseBackgroundPic(usageGuideRetainJson);
            CommExtInfo parseCommExtInfo = parseCommExtInfo(usageGuideRetainJson);
            UsageGuideStyle usageGuide = RetainDialogModuleUtil.getUsageGuide(usageGuideRetainJson);
            QLog.i(TAG, 1, "orientation:" + requestedOrientation + " isLandscape:" + z16 + " searchLeadImgUrl:" + parseBackgroundPic + " moreAppLink:" + parseMoreAppLink);
            if (parseModuleType == 4) {
                if (usageGuide != null && !hasShowUsageGuideDialog) {
                    doShowRetainForEntranceDialog(activity, miniAppConfig, parseMoreAppInfo, parseMoreAppLink, z16, onClickListener, usageGuide);
                } else {
                    QLog.i(TAG, 1, "can't show entrance dialog, usageGuide:" + usageGuide + ",hasShowUsageGuideDialog:" + hasShowUsageGuideDialog);
                    return false;
                }
            } else if (parseModuleType == 1) {
                doShowRetainOperationDialog(activity, parseMoreAppInfo, parseMoreAppLink, miniAppConfig, parseOperationRecommendList, parseBackgroundPic2, onClickListener, new ChangeOperationAllOnClickListener(activity, miniAppConfig, parseOperationRecommendList, z16), z16);
            } else if (parseModuleType == 2) {
                doShowShortCutDialog(activity, miniAppConfig, onClickListener, miniAppInfo, z16);
            } else if (parseModuleType == 3) {
                int colorNoteType = QQMiniAppUtils.getColorNoteType(activity);
                if (colorNoteType != 0 && !miniAppInfo.isLimitedAccessApp()) {
                    doShowColorSignDialog(activity, miniAppConfig, onClickListener, miniAppInfo, z16);
                } else {
                    QLog.i(TAG, 1, "can't show color sign dialog,colorNoteType:" + colorNoteType + ",isLimitedAccessApp:" + miniAppInfo.isLimitedAccessApp());
                    return false;
                }
            } else {
                ChangeAllOnClickListener changeAllOnClickListener = new ChangeAllOnClickListener(activity, str2, i16, i3 + "", str4, miniAppConfig);
                changeAllOnClickListener.ext = parseCommExtInfo;
                doShowRetainDialog(activity, miniAppConfig, parseMoreAppInfo, parseMoreAppLink, arrayList, z16, onClickListener, changeAllOnClickListener);
            }
            updateRetainDialogShowTimes(retainDialogShowTimes);
            return true;
        } catch (Exception e17) {
            e = e17;
        }
    }
}
