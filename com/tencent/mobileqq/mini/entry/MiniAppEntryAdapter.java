package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.desktop.widget.ExtendViewFlipper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntryAdapter extends RecyclerView.Adapter<MicroAppViewHolder> {
    private static final String DEVELOP = HardCodeUtil.qqStr(R.string.o7e);
    private static final String EXPERIENCE = HardCodeUtil.qqStr(R.string.o7_);
    public static final int REFER_CONTACTS = 1;
    public static final int REFER_CONVERSATION = 0;
    public static final int REFER_LEBA = 2;
    private static final String TAG = "MiniAppEntryAdapter";
    private static final int TYPE_MIMI_APP_SPECIAL = 3;
    private static final int TYPE_MINI_APP_NORMAL = 1;
    private static final int TYPE_MINI_APP_TOP = 2;
    private Activity mActivity;
    private OnAnimationListener mAnimListener;
    private boolean mCanShowRedDot;
    protected BubblePopupWindow mMenuPop;
    private int mRedDotSwitchState;
    private int mRefer;
    private List<MiniAppInfo> mData = new ArrayList();
    private List<MiniAppInfo> mTopData = new ArrayList();
    private List<MiniAppInfo> mSpecialData = new ArrayList();
    private Map<String, Integer> mRedDotData = new HashMap();
    private int topAppNum = 0;
    View.OnClickListener onMenuItemSelected = new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CharSequence text;
            String charSequence = (!(view instanceof TextView) || (text = ((TextView) view).getText()) == null) ? null : text.toString();
            int id5 = view.getId();
            if (id5 >= 0 && id5 < MiniAppEntryAdapter.this.mData.size()) {
                MiniAppEntryAdapter.this.onMenuItemClick(charSequence, (MiniAppInfo) MiniAppEntryAdapter.this.mData.get(id5));
            }
            if (QLog.isColorLevel()) {
                QLog.i(MiniAppEntryAdapter.TAG, 2, "onClick. onMenuItemSelected, position = " + id5);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnAnimationListener {
        void startAnimation();

        void stopAnimation();
    }

    public MiniAppEntryAdapter(Activity activity, int i3) {
        this.mRefer = 0;
        this.mActivity = activity;
        this.mRefer = i3;
    }

    private void deleteMiniApp(MiniAppInfo miniAppInfo) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "deleteMiniApp, delete miniAppInfo: " + miniAppInfo.toString());
        }
        BaseActivity baseActivity = (BaseActivity) this.mActivity;
        MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) baseActivity.app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if (miniAppUserAppInfoListManager != null) {
            miniAppUserAppInfoListManager.sendDelUserAppRequest(miniAppInfo);
        }
        MiniCacheFreeManager.freeCache(baseActivity.app.getCurrentUin(), miniAppInfo);
    }

    private List<String> getMenuItems(MiniAppInfo miniAppInfo) {
        Resources resources = this.mActivity.getResources();
        ArrayList arrayList = new ArrayList();
        if (miniAppInfo != null) {
            int i3 = miniAppInfo.topType;
            if (i3 == 0) {
                arrayList.add(resources.getString(R.string.c_x));
                arrayList.add(resources.getString(R.string.c_w));
            } else if (i3 == 1) {
                arrayList.add(resources.getString(R.string.c_v));
                arrayList.add(resources.getString(R.string.c_w));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRedDotCount(String str) {
        Integer num = this.mRedDotData.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMenuItemClick(String str, MiniAppInfo miniAppInfo) {
        String str2;
        int i3;
        Resources resources = this.mActivity.getResources();
        int i16 = this.mRefer;
        if (i16 == 1) {
            str2 = "contact";
            i3 = 2006;
        } else if (i16 == 2) {
            str2 = "more";
            i3 = 2007;
        } else {
            str2 = "message";
            i3 = 1001;
        }
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = i3;
        if (Utils.p(str, resources.getString(R.string.c_w))) {
            deleteMiniApp(miniAppInfo);
            MiniProgramLpReportDC04239.reportDropDown(miniAppConfig, str2, "delete");
            return;
        }
        if (Utils.p(str, resources.getString(R.string.c_x))) {
            if ((this.mSpecialData != null || this.mTopData != null) && this.topAppNum >= 11) {
                QQToast.makeText(this.mActivity, "\u6700\u591a\u4ec5\u652f\u6301\u7f6e\u987610\u4e2a\u5c0f\u7a0b\u5e8f", 0).show();
                return;
            } else {
                setTopMiniApp(miniAppInfo);
                MiniProgramLpReportDC04239.reportDropDown(miniAppConfig, str2, "settop_on");
                return;
            }
        }
        if (Utils.p(str, resources.getString(R.string.c_v))) {
            setTopMiniApp(miniAppInfo);
            MiniProgramLpReportDC04239.reportDropDown(miniAppConfig, str2, "settop_off");
        }
    }

    private void setAnimationListener(OnAnimationListener onAnimationListener) {
        this.mAnimListener = onAnimationListener;
    }

    private void setTopMiniApp(MiniAppInfo miniAppInfo) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setTopMiniApp, miniAppInfo: " + miniAppInfo.toString());
        }
        MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) ((BaseActivity) this.mActivity).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if (miniAppUserAppInfoListManager != null) {
            if (miniAppInfo.topType == 0) {
                miniAppInfo.topType = 1;
                miniAppInfo.updateTimeStamp();
            } else {
                miniAppInfo.topType = 0;
            }
            miniAppUserAppInfoListManager.sendSetUserAppTopRequest(miniAppInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateMiniAppStorePlayAnimationTime() {
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            appInterface.getPreferences().edit().putLong(AppConstants.Preferences.KEY_MINI_APP_STORE_SHOW_ANIMATION_TIME, System.currentTimeMillis()).apply();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MiniAppInfo> list = this.mData;
        if (list == null || list.size() == 0) {
            return 1;
        }
        return this.mData.size();
    }

    public MiniAppInfo getItemForPosition(int i3) {
        if (i3 >= this.mData.size() || i3 < 0) {
            return null;
        }
        return this.mData.get(i3);
    }

    public Map<String, Integer> getRedDotDataMap() {
        return this.mRedDotData;
    }

    public void handleLongClick(View view, MiniAppInfo miniAppInfo, int i3) {
        List<String> menuItems = getMenuItems(miniAppInfo);
        if (menuItems.size() > 0) {
            com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
            for (int i16 = 0; i16 < menuItems.size(); i16++) {
                aVar.a(i3, menuItems.get(i16));
            }
            this.mMenuPop = s.d(view, aVar, this.onMenuItemSelected, null);
        }
    }

    public void setData(List<MiniAppInfo> list, Map<String, Integer> map) {
        this.mData.clear();
        this.mTopData.clear();
        this.mSpecialData.clear();
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (MiniAppInfo miniAppInfo : list) {
                if (miniAppInfo.isSpecialMiniApp()) {
                    if (miniAppInfo.topType != 1) {
                        miniAppInfo.topType = 1;
                    }
                    this.mSpecialData.add(miniAppInfo);
                } else if (miniAppInfo.topType == 1) {
                    this.mTopData.add(miniAppInfo);
                } else {
                    arrayList.add(miniAppInfo);
                }
            }
            this.mData.addAll(this.mSpecialData);
            this.mData.addAll(this.mTopData);
            this.mData.addAll(arrayList);
            this.topAppNum = this.mSpecialData.size() + this.mTopData.size();
            this.mRedDotData.clear();
            this.mRedDotData.putAll(map);
            this.mCanShowRedDot = MiniAppConfProcessor.i();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setData. data = " + list);
        }
    }

    public void setRedDotSwitchState(int i3) {
        this.mRedDotSwitchState = i3;
    }

    public void startAnimation() {
        OnAnimationListener onAnimationListener = this.mAnimListener;
        if (onAnimationListener != null) {
            onAnimationListener.startAnimation();
        }
    }

    public void stopAnimation() {
        OnAnimationListener onAnimationListener = this.mAnimListener;
        if (onAnimationListener != null) {
            onAnimationListener.stopAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MicroAppViewHolder extends RecyclerView.ViewHolder implements OnAnimationListener {
        ViewGroup dividerLine;
        ImageView imageView;
        boolean isPlayAnim;
        MiniAppInfo miniAppInfo;
        int picCount;
        ImageView recommendBadge;
        TextView redDot;
        TextView textView;
        TextView versionTypeMark;
        ExtendViewFlipper viewFlipper;

        public MicroAppViewHolder(View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.exe);
            this.imageView = imageView;
            if (imageView instanceof ThemeImageView) {
                ((ThemeImageView) imageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
            }
            this.textView = (TextView) view.findViewById(R.id.exf);
            this.versionTypeMark = (TextView) view.findViewById(R.id.exg);
            this.dividerLine = (ViewGroup) view.findViewById(R.id.exa);
            this.recommendBadge = (ImageView) view.findViewById(R.id.ewj);
            this.redDot = (TextView) view.findViewById(R.id.lul);
        }

        public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
            this.miniAppInfo = miniAppInfo;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.OnAnimationListener
        public void startAnimation() {
            QLog.i(MiniAppEntryAdapter.TAG, 1, "[mini_app_anim].startAnimation, picCount = " + this.picCount + ", pic Url = " + this.miniAppInfo.appStoreAnimPicUrl);
            this.isPlayAnim = true;
            this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, R.drawable.hog, 48));
            this.imageView.invalidate();
            startSwitchAnimation();
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.OnAnimationListener
        public void stopAnimation() {
            QLog.d(MiniAppEntryAdapter.TAG, 1, "[mini_app_anim].stopAnimation, isPlayAnim: " + this.isPlayAnim);
            this.isPlayAnim = false;
            this.viewFlipper.stopFlipping();
            ImageView imageView = this.imageView;
            imageView.setImageDrawable(MiniAppUtils.getIcon(imageView.getContext(), this.miniAppInfo.iconUrl, true));
            this.viewFlipper.setVisibility(8);
        }

        private void startSwitchAnimation() {
            long j3 = this.picCount * 2200;
            QLog.d(MiniAppEntryAdapter.TAG, 1, "[mini_app_anim].startSwitchAnimation, picCount = " + this.picCount + ", isPlayAnim: " + this.isPlayAnim + ", duration: " + j3);
            this.viewFlipper.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(700L);
            translateAnimation.setInterpolator(new SpringTranslationInterpolator(0.4f));
            translateAnimation.setFillAfter(true);
            this.viewFlipper.setInAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(700L);
            translateAnimation2.setInterpolator(new LinearInterpolator());
            translateAnimation2.setFillAfter(false);
            this.viewFlipper.setOutAnimation(translateAnimation2);
            this.viewFlipper.setFlipInterval(Constants.Action.ACTION_APP_GUARD);
            this.viewFlipper.setAnimateFirstView(true);
            this.viewFlipper.startFlipping();
            AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.MicroAppViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    MicroAppViewHolder microAppViewHolder = MicroAppViewHolder.this;
                    if (microAppViewHolder.isPlayAnim) {
                        microAppViewHolder.stopAnimation();
                        MiniAppEntryAdapter.updateMiniAppStorePlayAnimationTime();
                        QLog.d(MiniAppEntryAdapter.TAG, 1, "[mini_app_anim].startSwitchAnimation, animation end.");
                    }
                }
            }, j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fd A[LOOP:0: B:58:0x01f7->B:60:0x01fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c6  */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(MicroAppViewHolder microAppViewHolder, int i3) {
        int i16;
        MiniAppExposureManager miniAppExposureManager;
        ArrayList<String> arrayList;
        Iterator<String> it;
        if (this.mData.isEmpty()) {
            QLog.e(TAG, 1, "[MiniAppUserAppInfoListManager].onBindViewHolder, size = " + this.mData.size());
            return;
        }
        MiniAppInfo miniAppInfo = this.mData.get(i3);
        microAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, miniAppInfo.iconUrl, true));
        microAppViewHolder.textView.setText(miniAppInfo.name);
        microAppViewHolder.setMiniAppInfo(miniAppInfo);
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            microAppViewHolder.textView.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.skin_black_theme_version2));
            ImageView imageView = microAppViewHolder.imageView;
            if (imageView instanceof ThemeImageView) {
                ((ThemeImageView) imageView).setSupportMaskView(true);
            }
        }
        if (miniAppInfo.isSpecialMiniApp()) {
            microAppViewHolder.itemView.setTag(3);
        } else if (miniAppInfo.topType == 1) {
            microAppViewHolder.itemView.setTag(2);
        } else {
            microAppViewHolder.itemView.setTag(1);
        }
        int i17 = miniAppInfo.verType;
        if (i17 == 0 || i17 == 4) {
            microAppViewHolder.versionTypeMark.setVisibility(0);
            microAppViewHolder.versionTypeMark.setText(DEVELOP);
        } else if (i17 == 1) {
            microAppViewHolder.versionTypeMark.setVisibility(0);
            microAppViewHolder.versionTypeMark.setText(EXPERIENCE);
        } else {
            microAppViewHolder.versionTypeMark.setVisibility(8);
        }
        if (miniAppInfo.recommend == 1) {
            microAppViewHolder.recommendBadge.setVisibility(0);
            if (!TextUtils.isEmpty(miniAppInfo.recommendAppIconUrl)) {
                microAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getRecommendIconDrawable(this.mActivity, miniAppInfo.recommendAppIconUrl));
            } else {
                microAppViewHolder.recommendBadge.setImageResource(R.drawable.d09);
            }
        } else {
            microAppViewHolder.recommendBadge.setVisibility(8);
        }
        int i18 = this.topAppNum;
        if (i18 > 0 && i3 == i18 - 1 && this.mData.size() > this.topAppNum) {
            microAppViewHolder.dividerLine.setVisibility(0);
            setDividerLineColor(microAppViewHolder.dividerLine);
        } else {
            microAppViewHolder.dividerLine.setVisibility(8);
        }
        Integer num = this.mRedDotData.get(miniAppInfo.appId);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + num + ", name : " + miniAppInfo.name);
        }
        if (this.mCanShowRedDot && this.mRedDotSwitchState == 1 && num != null && num.intValue() > 0) {
            microAppViewHolder.redDot.setVisibility(0);
            d.b(microAppViewHolder.redDot, 7, num.intValue(), 0);
        } else {
            microAppViewHolder.redDot.setVisibility(8);
        }
        int i19 = this.mRefer;
        if (i19 == 0) {
            if (miniAppInfo.recommend == 1) {
                miniAppInfo.via = "1001_1";
            }
        } else {
            if (i19 == 1) {
                if (miniAppInfo.recommend == 1) {
                    miniAppInfo.via = "2006_1";
                } else if (miniAppInfo.topType == 1) {
                    miniAppInfo.via = "2006_2";
                } else {
                    miniAppInfo.via = "2006_3";
                }
                i16 = 2006;
            } else if (i19 == 2) {
                if (miniAppInfo.recommend == 1) {
                    miniAppInfo.via = "2007_1";
                } else if (miniAppInfo.topType == 1) {
                    miniAppInfo.via = "2007_2";
                } else {
                    miniAppInfo.via = "2007_3";
                }
                i16 = 2007;
            }
            miniAppExposureManager = appInterface == null ? (MiniAppExposureManager) appInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER) : null;
            if (miniAppExposureManager != null) {
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                miniAppConfig.launchParam.scene = i16;
                miniAppExposureManager.addReportItem(new MiniAppExposureManager.MiniAppExposureData(miniAppConfig, i3, String.valueOf(getRedDotCount(miniAppInfo.appId))));
            }
            arrayList = miniAppInfo.motionPics;
            if (arrayList != null && arrayList.size() > 0) {
                setAnimationListener(microAppViewHolder);
                it = miniAppInfo.motionPics.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    ImageView imageView2 = new ImageView(this.mActivity);
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    imageView2.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, next, true));
                    imageView2.setScaleType(ImageView.ScaleType.CENTER);
                    microAppViewHolder.viewFlipper.addView(imageView2);
                }
                microAppViewHolder.picCount = miniAppInfo.motionPics.size();
            }
            microAppViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Object tag = view.getTag();
                    if (!(tag instanceof Integer)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(MiniAppEntryAdapter.TAG, 2, "onClick. obj = " + tag);
                            return;
                        }
                        return;
                    }
                    MiniAppInfo miniAppInfo2 = ((MicroAppViewHolder) ((RecyclerView) view.getParent()).getChildViewHolder(view)).miniAppInfo;
                    int i26 = 1001;
                    if (MiniAppEntryAdapter.this.mRefer != 0) {
                        if (MiniAppEntryAdapter.this.mRefer == 1) {
                            i26 = 2006;
                        } else if (MiniAppEntryAdapter.this.mRefer == 2) {
                            i26 = 2007;
                        }
                    }
                    try {
                        QLog.i(MiniAppEntryAdapter.TAG, 1, "--- click appid:" + miniAppInfo2.appId);
                        MiniAppLauncher.launchAppByAppInfo(MiniAppEntryAdapter.this.mActivity, miniAppInfo2, i26);
                        int redDotCount = MiniAppEntryAdapter.this.getRedDotCount(miniAppInfo2.appId);
                        MiniAppConfig miniAppConfig2 = new MiniAppConfig(miniAppInfo2);
                        LaunchParam launchParam = new LaunchParam();
                        launchParam.scene = i26;
                        miniAppConfig2.launchParam = launchParam;
                        MiniProgramLpReportDC04239.reportAsync(miniAppConfig2, "page_view", "click_scene", null, String.valueOf(redDotCount));
                    } catch (MiniAppException e16) {
                        e16.printStackTrace();
                    }
                }
            });
            microAppViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    Object tag = view.getTag();
                    if (!(tag instanceof Integer)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(MiniAppEntryAdapter.TAG, 2, "onLongClick. obj = " + tag);
                        }
                        return true;
                    }
                    int intValue = ((Integer) tag).intValue();
                    if (intValue == 1 || intValue == 2) {
                        MicroAppViewHolder microAppViewHolder2 = (MicroAppViewHolder) ((RecyclerView) view.getParent()).getChildViewHolder(view);
                        MiniAppEntryAdapter.this.handleLongClick(view, microAppViewHolder2.miniAppInfo, microAppViewHolder2.getLayoutPosition());
                    }
                    return true;
                }
            });
        }
        i16 = 1001;
        if (appInterface == null) {
        }
        if (miniAppExposureManager != null) {
        }
        arrayList = miniAppInfo.motionPics;
        if (arrayList != null) {
            setAnimationListener(microAppViewHolder);
            it = miniAppInfo.motionPics.iterator();
            while (it.hasNext()) {
            }
            microAppViewHolder.picCount = miniAppInfo.motionPics.size();
        }
        microAppViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof Integer)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppEntryAdapter.TAG, 2, "onClick. obj = " + tag);
                        return;
                    }
                    return;
                }
                MiniAppInfo miniAppInfo2 = ((MicroAppViewHolder) ((RecyclerView) view.getParent()).getChildViewHolder(view)).miniAppInfo;
                int i26 = 1001;
                if (MiniAppEntryAdapter.this.mRefer != 0) {
                    if (MiniAppEntryAdapter.this.mRefer == 1) {
                        i26 = 2006;
                    } else if (MiniAppEntryAdapter.this.mRefer == 2) {
                        i26 = 2007;
                    }
                }
                try {
                    QLog.i(MiniAppEntryAdapter.TAG, 1, "--- click appid:" + miniAppInfo2.appId);
                    MiniAppLauncher.launchAppByAppInfo(MiniAppEntryAdapter.this.mActivity, miniAppInfo2, i26);
                    int redDotCount = MiniAppEntryAdapter.this.getRedDotCount(miniAppInfo2.appId);
                    MiniAppConfig miniAppConfig2 = new MiniAppConfig(miniAppInfo2);
                    LaunchParam launchParam = new LaunchParam();
                    launchParam.scene = i26;
                    miniAppConfig2.launchParam = launchParam;
                    MiniProgramLpReportDC04239.reportAsync(miniAppConfig2, "page_view", "click_scene", null, String.valueOf(redDotCount));
                } catch (MiniAppException e16) {
                    e16.printStackTrace();
                }
            }
        });
        microAppViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof Integer)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppEntryAdapter.TAG, 2, "onLongClick. obj = " + tag);
                    }
                    return true;
                }
                int intValue = ((Integer) tag).intValue();
                if (intValue == 1 || intValue == 2) {
                    MicroAppViewHolder microAppViewHolder2 = (MicroAppViewHolder) ((RecyclerView) view.getParent()).getChildViewHolder(view);
                    MiniAppEntryAdapter.this.handleLongClick(view, microAppViewHolder2.miniAppInfo, microAppViewHolder2.getLayoutPosition());
                }
                return true;
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public MicroAppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new MicroAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bmz, viewGroup, false));
    }

    private void setDividerLineColor(ViewGroup viewGroup) {
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ImageView) {
                ImageView imageView = (ImageView) childAt;
                if (MiniAppUtils.isNightMode()) {
                    imageView.setImageResource(R.drawable.f161033qn);
                } else {
                    imageView.setImageResource(R.drawable.auy);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class SpringTranslationInterpolator implements Interpolator {
        private float factor;

        public SpringTranslationInterpolator(float f16) {
            this.factor = f16;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return (float) ((Math.pow(2.0d, (-10.0f) * f16) * Math.sin(((f16 - (r2 / 4.0f)) * 6.283185307179586d) / this.factor)) + 1.0d);
        }
    }
}
