package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntryLayout extends FrameLayout implements View.OnClickListener {
    private static final int SCROLL_MODE_HORIZONTAL = 1;
    private static final int SCROLL_MODE_UNDEFINED = 0;
    private static final int SCROLL_MODE_VERTICAL = 2;
    public static final String TAG = "MicroAppEntryLayout";
    private DownloadParams.DecodeHandler decodeHandler;
    private MiniAppEntryAdapter mAdapter;
    private TextView mAppStoreEntryText;
    private BaseActivity mContext;
    private ViewGroup mDefaultStateView;
    private MiniAppDotAnimationView mDotView;
    private LinearLayoutManager mLinearLayoutManager;
    private ViewGroup mNormalStateView;
    private ViewGroup mParent;
    private int[] mParentLocation;
    private float mPressX;
    private float mPressY;
    private RecyclerView mRecyclerView;
    private int mRefer;
    private int mScrollMode;
    private int[] mStoryBarLocation;
    private ImageView mThemeBackgroudView;
    private int mTouchSlop;
    private boolean result;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class MiniAppLinearLayoutManager extends LinearLayoutManager {
        public MiniAppLinearLayoutManager(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (Throwable th5) {
                QLog.e(MiniAppEntryLayout.TAG, 1, "onLayoutChildren, exception: " + Log.getStackTraceString(th5));
            }
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                return super.scrollHorizontallyBy(i3, recycler, state);
            } catch (Throwable th5) {
                QLog.e(MiniAppEntryLayout.TAG, 1, "scrollHorizontallyBy, exception: " + Log.getStackTraceString(th5));
                return 0;
            }
        }

        public MiniAppLinearLayoutManager(Context context, int i3, boolean z16) {
            super(context, i3, z16);
        }

        public MiniAppLinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
            super(context, attributeSet, i3, i16);
        }
    }

    public MiniAppEntryLayout(Context context, int i3) {
        super(context);
        this.mParentLocation = new int[2];
        this.mStoryBarLocation = new int[2];
        this.result = false;
        this.decodeHandler = new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.2
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap bitmap2 = null;
                if (bitmap != null) {
                    try {
                        Rect rect = new Rect();
                        rect.right = bitmap.getWidth();
                        int dip2px = ViewUtils.dip2px(240.0f);
                        rect.bottom = Math.min(bitmap.getHeight(), dip2px);
                        bitmap2 = BaseImageUtil.getClipRectBitmapScale(bitmap, rect, 2);
                        if (QLog.isColorLevel()) {
                            QLog.d(MiniAppEntryLayout.TAG, 2, "updateHongBaoRes\uff0csetDecodeHandler\uff1a,originalHeight:" + bitmap.getHeight() + ",maxHeight:" + dip2px + "\uff0coutWidth\uff1a" + rect.right + ",outHeight\uff1a" + rect.bottom + ",outBitmap:" + bitmap2);
                        }
                    } catch (Throwable th5) {
                        QLog.e(MiniAppEntryLayout.TAG, 1, th5, new Object[0]);
                    }
                }
                return bitmap2;
            }
        };
        this.mContext = (BaseActivity) context;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mRefer = i3;
        View.inflate(context, R.layout.f169018bn0, this);
        this.mParent = (ViewGroup) findViewById(R.id.exd);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.zba);
        this.mRecyclerView = recyclerView;
        recyclerView.setItemAnimator(null);
        this.mAdapter = new MiniAppEntryAdapter((Activity) context, i3);
        if (MiniAppConfProcessor.l()) {
            this.mAdapter.setRedDotSwitchState(com.tencent.mobileqq.applets.b.a() ? 1 : 0);
        }
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i16) {
                if (i16 == 0) {
                    MiniAppEntryLayout.exposureReport();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i16, int i17) {
            }
        });
        this.mThemeBackgroudView = (ImageView) findViewById(R.id.ewe);
        this.mNormalStateView = (ViewGroup) findViewById(R.id.ewi);
        this.mDefaultStateView = (ViewGroup) findViewById(R.id.ewd);
        TextView textView = (TextView) findViewById(R.id.ewm);
        this.mAppStoreEntryText = textView;
        textView.setOnClickListener(this);
        this.mDotView = (MiniAppDotAnimationView) findViewById(R.id.exb);
        MiniAppLinearLayoutManager miniAppLinearLayoutManager = new MiniAppLinearLayoutManager(context, 0, false);
        this.mLinearLayoutManager = miniAppLinearLayoutManager;
        miniAppLinearLayoutManager.setAutoMeasureEnabled(false);
        this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
    }

    public static void exposureReport() {
        ArrayList arrayList = new ArrayList();
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        MiniAppExposureManager miniAppExposureManager = appInterface != null ? (MiniAppExposureManager) appInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER) : null;
        if (miniAppExposureManager != null) {
            List<MiniAppExposureManager.BaseExposureReport> reportItemList = miniAppExposureManager.getReportItemList();
            for (int i3 = 0; i3 < reportItemList.size(); i3++) {
                MiniAppExposureManager.BaseExposureReport baseExposureReport = reportItemList.get(i3);
                if (baseExposureReport instanceof MiniAppExposureManager.MiniAppExposureData) {
                    arrayList.add((MiniAppExposureManager.MiniAppExposureData) baseExposureReport);
                }
            }
            MiniProgramLpReportDC04239.reportPageView(arrayList, "expo");
            MiniProgramLpReportDC04239.reportPageView(arrayList, "expo_scene", true);
            miniAppExposureManager.clear();
        }
    }

    private void setMiniAppData(List<MiniAppInfo> list, Map<String, Integer> map) {
        MiniAppEntryAdapter miniAppEntryAdapter = this.mAdapter;
        if (miniAppEntryAdapter != null) {
            miniAppEntryAdapter.setData(list, map);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void dotViewOnScroll(float f16) {
        this.mDotView.doOnScroll(f16);
    }

    public ViewGroup getContainerView() {
        return this.mParent;
    }

    public int getDotViewHeight() {
        return this.mDotView.getHeight();
    }

    public float getDotViewTranslationY() {
        return this.mDotView.getTranslationY();
    }

    public boolean interceptDrawer(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action == 0) {
            getLocationInWindow(this.mStoryBarLocation);
            view.getLocationInWindow(this.mParentLocation);
            int i3 = this.mStoryBarLocation[1];
            this.result = y16 >= ((float) i3) && y16 < ((float) (i3 + getHeight()));
            this.mPressX = x16;
            this.mPressY = y16;
            this.mScrollMode = 0;
        } else if (action == 2) {
            float abs = Math.abs(this.mPressX - x16);
            float abs2 = Math.abs(this.mPressY - y16);
            if (this.mScrollMode == 0 && abs > this.mTouchSlop) {
                this.mScrollMode = 1;
            }
            if (this.mScrollMode == 0 && abs2 > this.mTouchSlop) {
                this.mScrollMode = 2;
            }
            if (this.mScrollMode == 2 && this.result) {
                this.result = false;
                motionEvent.setAction(3);
                dispatchTouchEvent(motionEvent);
            }
        }
        if (this.result) {
            motionEvent.offsetLocation(0.0f, this.mParentLocation[1] - this.mStoryBarLocation[1]);
            dispatchTouchEvent(motionEvent);
        }
        return this.result;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateHongBaoRes();
        if (this.mRecyclerView.getLayoutManager().getChildCount() != this.mRecyclerView.getChildCount()) {
            QLog.e(TAG, 2, "onAttachedToWindow recyclerView count not match, need reset!");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
            this.mLinearLayoutManager = linearLayoutManager;
            linearLayoutManager.setAutoMeasureEnabled(true);
            this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
            this.mRecyclerView.getAdapter().notifyDataSetChanged();
        }
        MiniAppUtils.updateMiniAppList(3);
    }

    public void onChangeRedDotSwitch(int i3, boolean z16) {
        MiniAppEntryAdapter miniAppEntryAdapter = this.mAdapter;
        if (miniAppEntryAdapter != null) {
            miniAppEntryAdapter.setRedDotSwitchState(i3);
            if (z16) {
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MiniAppUtils.handleMiniAppMoreClick(this.mContext);
    }

    public void onPostThemeChanged() {
        try {
            this.mRecyclerView.setBackgroundDrawable(null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onPostThemeChanged:", e16);
        }
        updateHongBaoRes();
    }

    public void recordExposureItem() {
        int i3;
        Integer num;
        if (this.mRecyclerView != null) {
            AppInterface appInterface = MiniAppUtils.getAppInterface();
            MiniAppExposureManager miniAppExposureManager = appInterface != null ? (MiniAppExposureManager) appInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER) : null;
            Map<String, Integer> redDotDataMap = this.mAdapter.getRedDotDataMap();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                MiniAppInfo itemForPosition = this.mAdapter.getItemForPosition(findFirstVisibleItemPosition);
                if (itemForPosition != null && miniAppExposureManager != null) {
                    int i16 = this.mRefer;
                    if (i16 == 0 && itemForPosition.reportData != null) {
                        if (itemForPosition.recommend == 1) {
                            itemForPosition.via = "1001_1";
                        } else if (itemForPosition.topType == 1) {
                            itemForPosition.via = "1001_3";
                        }
                    } else {
                        if (i16 == 1 && itemForPosition.reportData != null) {
                            if (itemForPosition.recommend == 1) {
                                itemForPosition.via = "2006_1";
                            } else if (itemForPosition.topType == 1) {
                                itemForPosition.via = "2006_2";
                            } else {
                                itemForPosition.via = "2006_3";
                            }
                            i3 = 2006;
                        } else if (i16 == 2 && itemForPosition.reportData != null) {
                            if (itemForPosition.recommend == 1) {
                                itemForPosition.via = "2007_1";
                            } else if (itemForPosition.topType == 1) {
                                itemForPosition.via = "2007_2";
                            } else {
                                itemForPosition.via = "2007_3";
                            }
                            i3 = 2007;
                        }
                        MiniAppConfig miniAppConfig = new MiniAppConfig(itemForPosition);
                        miniAppConfig.launchParam.scene = i3;
                        miniAppExposureManager.addReportItem(new MiniAppExposureManager.MiniAppExposureData(miniAppConfig, findFirstVisibleItemPosition, String.valueOf((redDotDataMap != null || (num = redDotDataMap.get(itemForPosition.appId)) == null) ? 0 : num.intValue())));
                    }
                    i3 = 1001;
                    MiniAppConfig miniAppConfig2 = new MiniAppConfig(itemForPosition);
                    miniAppConfig2.launchParam.scene = i3;
                    miniAppExposureManager.addReportItem(new MiniAppExposureManager.MiniAppExposureData(miniAppConfig2, findFirstVisibleItemPosition, String.valueOf((redDotDataMap != null || (num = redDotDataMap.get(itemForPosition.appId)) == null) ? 0 : num.intValue())));
                }
            }
        }
    }

    public void resetDotViewStatus() {
        this.mDotView.resetDots();
    }

    public void setDotViewTranslationY(float f16) {
        this.mDotView.setTranslationY(f16);
    }

    public void setThemeBackgroundDrawable() {
        try {
            if (this.mThemeBackgroudView != null) {
                if (!ThemeUtil.isDefaultTheme() && !MiniAppUtils.isNightMode()) {
                    this.mThemeBackgroudView.setVisibility(0);
                    this.mThemeBackgroudView.setImageResource(R.drawable.bg_texture_theme_version2);
                }
                this.mThemeBackgroudView.setVisibility(8);
            }
            this.mAdapter.notifyDataSetChanged();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setThemeBackgroundDrawable error.", th5);
        }
    }

    public void startSwitchIconAnimation() {
        MiniAppEntryAdapter miniAppEntryAdapter = this.mAdapter;
        if (miniAppEntryAdapter != null) {
            miniAppEntryAdapter.startAnimation();
        }
    }

    public void stopSwitchIconAnimation() {
        MiniAppEntryAdapter miniAppEntryAdapter = this.mAdapter;
        if (miniAppEntryAdapter != null) {
            miniAppEntryAdapter.stopAnimation();
        }
    }

    public void updateHongBaoRes() {
        try {
            QLog.d(TAG, 1, "---updateHongBaoRes---");
            if (getParent() instanceof PullRefreshHeader) {
                ((PullRefreshHeader) getParent()).setBackgroundColor(0);
            }
            setThemeBackgroundDrawable();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "updateHongBaoRes error.", th5);
        }
    }

    public void updateMicroAppItemData() {
        MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) this.mContext.app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        List<MiniAppInfo> miniAppInfoData = miniAppUserAppInfoListManager.getMiniAppInfoData();
        if (miniAppInfoData != null && miniAppInfoData.size() != 0) {
            this.mDefaultStateView.setVisibility(8);
            this.mNormalStateView.setVisibility(0);
            setMiniAppData(miniAppInfoData, miniAppUserAppInfoListManager.getRedDotData());
            return;
        }
        this.mDefaultStateView.setVisibility(0);
        this.mNormalStateView.setVisibility(8);
        if (miniAppUserAppInfoListManager.getPullDownEntryExtInfo() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "[MiniAppUserAppInfoListManager]. updateMicroAppItemData");
            }
            MiniAppUtils.checkSendUserAppListRequest();
        }
    }
}
