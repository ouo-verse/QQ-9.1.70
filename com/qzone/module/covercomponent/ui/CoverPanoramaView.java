package com.qzone.module.covercomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.module.covercomponent.manage.QZoneCoverContainerManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CoverPanoramaView extends CoverBaseView implements View.OnClickListener {
    private PanoramaLayout J;
    private String K;
    private String L;
    private Context M;
    private FrameLayout N;
    private CoverCacheData P;
    private long Q;

    private void i() {
        int i3 = this.E != 1 ? 2 : 1;
        String config = CoverEnv.getConfig("H5Url", "CoverStore", CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(this.Q);
        if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
            config = coverJumpUrlFromJce;
        }
        CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithQua(config), "{hostUin}", String.valueOf(this.Q)), CoverEnv.getLoginUin()), "{page}", String.valueOf(i3)), "{from}", CoverHelper.getFromPageName(this.E)), CoverEnv.getContext(), null);
    }

    private void j() {
        int i3 = this.E != 1 ? 2 : 1;
        String config = CoverEnv.getConfig("H5Url", "CoverPreview", CoverHelper.JUMP_COVER_PREVIEW_URL);
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(this.Q);
        if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
            config = coverJumpUrlFromJce;
        }
        CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithQua(config), "{hostUin}", String.valueOf(this.Q)), CoverEnv.getLoginUin()), "{coverid}", this.P.coverId), "{page}", String.valueOf(i3)), "{from}", CoverHelper.getFromPageName(this.E)), CoverEnv.getContext(), null);
    }

    private void k() {
        this.J = new PanoramaLayout(this.M);
        this.N.addView(this.J, new FrameLayout.LayoutParams(-1, -1));
        this.J.O(new PanoramaConfig.Builder(0).setShowType(1).setRenderMode(1).setOpenGyroscopeSensor(true).setOpenTouchMove(false).setShowLoadingProgress(false).setShowGuideAnimate(true).setShowPanoramaBall(false).setThumbUrl(this.K).setSmallUrl(this.L).setPanoramaType(1).setPanoramaExtra(PanoramaConfig.KEY_CURRENT_UIN, String.valueOf(this.Q)));
        this.J.setOnCoverClickListener(this);
        this.J.setOnLongClickListener(this);
    }

    private boolean l() {
        return this.Q == CoverEnv.getLoginUin();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (l()) {
            i();
        } else {
            j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        super.onDestroy();
        PanoramaLayout panoramaLayout = this.J;
        if (panoramaLayout != null) {
            panoramaLayout.J();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        super.onPause();
        PanoramaLayout panoramaLayout = this.J;
        if (panoramaLayout != null) {
            panoramaLayout.I();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        super.onResume();
        PanoramaLayout panoramaLayout = this.J;
        if (panoramaLayout != null) {
            panoramaLayout.K();
        }
    }

    public CoverPanoramaView(long j3, Context context, FrameLayout frameLayout, CoverCacheData coverCacheData) {
        super(18);
        this.Q = j3;
        this.M = context;
        this.N = frameLayout;
        this.P = coverCacheData;
        HashMap<String, String> hashMap = coverCacheData.mapExtInfo;
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("panorama_url"))) {
            this.K = coverCacheData.mapExtInfo.get("panorama_url");
        }
        HashMap<String, String> hashMap2 = coverCacheData.urls;
        if (hashMap2 != null && hashMap2.get("HigeResolutionCover") != null) {
            this.L = coverCacheData.urls.get("HigeResolutionCover");
        }
        if (TextUtils.isEmpty(this.K)) {
            return;
        }
        k();
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
    }
}
