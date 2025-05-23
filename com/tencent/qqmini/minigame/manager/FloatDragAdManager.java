package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.vip.pb.TianShuAccess;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FloatDragAdManager {
    public static final String OPERATE_TYPE_ADD = "add";
    public static final String OPERATE_TYPE_REMOVE = "remove";
    private static final String TAG = "FloatDragAdManager";
    private Activity mContext;
    private DragImageView mDragImageView;
    private ViewGroup mGameContainer;
    private IMiniAppContext mMiniAppContext;

    public FloatDragAdManager(Activity activity, IMiniAppContext iMiniAppContext, ViewGroup viewGroup) {
        this.mContext = activity;
        this.mMiniAppContext = iMiniAppContext;
        this.mGameContainer = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdView(final FloatDragAdInfo floatDragAdInfo) {
        if (this.mDragImageView != null) {
            QMLog.e(TAG, "addAdView fail, already exist");
            return;
        }
        this.mDragImageView = new DragImageView(this.mContext);
        final MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        this.mDragImageView.setImageDrawable(miniAppProxy.getDrawable(this.mContext, floatDragAdInfo.getPictureUrl(), 0, 0, null));
        this.mDragImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mDragImageView.setScaleSize(DisplayUtil.dip2px(this.mContext, 65.0f), DisplayUtil.dip2px(this.mContext, 65.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 55.0f), DisplayUtil.dip2px(this.mContext, 55.0f));
        layoutParams.leftMargin = DisplayUtil.dip2px(this.mContext, 14.5f);
        layoutParams.rightMargin = DisplayUtil.dip2px(this.mContext, 14.5f);
        layoutParams.topMargin = DisplayUtil.dip2px(this.mContext, 92.5f);
        layoutParams.bottomMargin = DisplayUtil.dip2px(this.mContext, 92.5f);
        layoutParams.gravity = 8388693;
        this.mGameContainer.addView(this.mDragImageView, layoutParams);
        this.mDragImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FloatDragAdManager.this.performReport(floatDragAdInfo.getAdItem(), floatDragAdInfo.getType(), 102);
                FloatDragAdManager.this.onAdClick(floatDragAdInfo, miniAppProxy);
                FloatDragAdDataManager.requestAd(FloatDragAdManager.this.mContext, FloatDragAdManager.this.mMiniAppContext, floatDragAdInfo.getAppId(), floatDragAdInfo.getScene());
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        performReport(floatDragAdInfo.getAdItem(), floatDragAdInfo.getType(), 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClick(FloatDragAdInfo floatDragAdInfo, MiniAppProxy miniAppProxy) {
        if (floatDragAdInfo.isSchema()) {
            miniAppProxy.openSchema(this.mContext, floatDragAdInfo.getJumpUrl(), 2115, null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", floatDragAdInfo.getJumpUrl());
        miniAppProxy.startBrowserActivity(this.mContext, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performReport(final TianShuAccess.AdItem adItem, final String str, final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdManager.3
            @Override // java.lang.Runnable
            public void run() {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).tianshuReport(adItem, str, i3);
            }
        });
    }

    public boolean removeDragAd() {
        ViewGroup viewGroup = this.mGameContainer;
        if (viewGroup == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (FloatDragAdManager.this.mDragImageView != null) {
                    FloatDragAdManager.this.mGameContainer.removeView(FloatDragAdManager.this.mDragImageView);
                }
                FloatDragAdManager.this.mDragImageView = null;
            }
        });
        return true;
    }

    public boolean showDragAd(final FloatDragAdInfo floatDragAdInfo) {
        ViewGroup viewGroup;
        if (this.mContext != null && (viewGroup = this.mGameContainer) != null) {
            if (this.mDragImageView != null) {
                performReport(floatDragAdInfo.getAdItem(), floatDragAdInfo.getType(), 101);
                QMLog.e(TAG, "showDragAd fail, already exist");
                return false;
            }
            viewGroup.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdManager.1
                @Override // java.lang.Runnable
                public void run() {
                    FloatDragAdManager.this.addAdView(floatDragAdInfo);
                }
            });
            return true;
        }
        QMLog.e(TAG, "showDragAd fail");
        return false;
    }
}
