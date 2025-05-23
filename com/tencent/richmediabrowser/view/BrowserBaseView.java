package com.tencent.richmediabrowser.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import e04.b;
import e04.d;
import e04.e;
import e04.f;
import f04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserBaseView implements c, View.OnLongClickListener, d, f, b {
    public BrowserBasePresenter basePresenter;
    private e decoratorViewEvent;
    public boolean isInEnterAnim;
    public boolean isInExitAnim;
    public b itemAnimationListener;
    public e04.c itemClickEventListener;
    public RelativeLayout mBrowserItemView;
    public Context mContext;
    public int mScreenHeightPx;
    public int mScreenWidthPx;
    public int midScreenWidth;
    public f pictureScaleEventListener;
    public d scrollEventListener;

    public BrowserBaseView(Context context, BrowserBasePresenter browserBasePresenter) {
        this.mContext = context;
        if (browserBasePresenter.getRecyclerView() != null) {
            this.mScreenWidthPx = browserBasePresenter.getRecyclerView().getWidth();
            this.mScreenHeightPx = browserBasePresenter.getRecyclerView().getHeight();
        }
        this.basePresenter = browserBasePresenter;
    }

    public void bindView(int i3) {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            eVar.b(i3);
        }
    }

    @Override // f04.c
    public void buildParams(Intent intent) {
        this.midScreenWidth = ScreenUtils.getScreenWidth(this.mContext) / 2;
        initParams(intent);
    }

    @Override // e04.b
    public Rect getAnimationEndDstRect() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            return bVar.getAnimationEndDstRect();
        }
        return null;
    }

    public View getView(View view, ViewGroup viewGroup) {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            return eVar.a(view, viewGroup);
        }
        return null;
    }

    public void initParams(Intent intent) {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            eVar.h(intent);
        }
    }

    public boolean isNeedDisallowInterceptEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // e04.b
    public boolean needEnterRectAnimation() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            return bVar.needEnterRectAnimation();
        }
        return false;
    }

    @Override // e04.b
    public boolean needExitRectAnimation() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            return bVar.needExitRectAnimation();
        }
        return false;
    }

    public void onClickEvent() {
        e04.c cVar = this.itemClickEventListener;
        if (cVar != null) {
            cVar.onClickEvent();
        } else {
            this.basePresenter.back();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.basePresenter.getRecyclerView() != null) {
            int width = this.basePresenter.getRecyclerView().getWidth();
            int height = this.basePresenter.getRecyclerView().getHeight();
            if (width != this.mScreenWidthPx || height != this.mScreenHeightPx) {
                this.mScreenWidthPx = width;
                this.mScreenHeightPx = height;
                URLDrawable.clearMemoryCache();
            }
        }
    }

    public void onDestroy() {
        setDecoratorViewEvent(null);
        setBrowserItemClickListener(null);
        setBrowserItemScrollEventListener(null);
        setPictureScaleEventListener(null);
        setBrowserItemAnimationListener(null);
    }

    public void onDestroyView(int i3, View view) {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            eVar.c(i3, view);
        }
    }

    @Override // e04.f
    public void onDoubleTap(int i3) {
        f fVar = this.pictureScaleEventListener;
        if (fVar != null) {
            fVar.onDoubleTap(i3);
        }
    }

    @Override // e04.b
    public void onEnterAnimationEnd() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            bVar.onEnterAnimationEnd();
        }
    }

    @Override // e04.b
    public void onEnterAnimationStart() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            bVar.onEnterAnimationStart();
        }
    }

    @Override // e04.b
    public void onExitAnimationEnd() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            bVar.onExitAnimationEnd();
        }
    }

    @Override // e04.b
    public void onExitAnimationStart() {
        b bVar = this.itemAnimationListener;
        if (bVar != null) {
            bVar.onExitAnimationStart();
        }
    }

    public void onItemSelected(int i3) {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            eVar.onItemSelected(i3);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        e04.c cVar = this.itemClickEventListener;
        if (cVar != null) {
            cVar.onLongClickEvent();
            z16 = true;
        } else {
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // e04.f
    public void onScale(int i3) {
        f fVar = this.pictureScaleEventListener;
        if (fVar != null) {
            fVar.onScale(i3);
        }
    }

    public void onScaleBegin(int i3) {
        f fVar = this.pictureScaleEventListener;
        if (fVar != null) {
            fVar.onScaleBegin(i3);
        }
    }

    @Override // e04.f
    public void onScaleEnd(int i3) {
        f fVar = this.pictureScaleEventListener;
        if (fVar != null) {
            fVar.onScaleEnd(i3);
        }
    }

    @Override // e04.d
    public void onScrollEnd() {
        d dVar = this.scrollEventListener;
        if (dVar != null) {
            dVar.onScrollEnd();
        }
    }

    public void onScrollHalfScreenWidth() {
        d dVar = this.scrollEventListener;
        if (dVar != null) {
            dVar.onScrollHalfScreenWidth();
        }
    }

    @Override // e04.d
    public void onScrollStart() {
        d dVar = this.scrollEventListener;
        if (dVar != null) {
            dVar.onScrollStart();
        }
    }

    public void setBrowserItemAnimationListener(b bVar) {
        this.itemAnimationListener = bVar;
    }

    public void setBrowserItemClickListener(e04.c cVar) {
        this.itemClickEventListener = cVar;
    }

    public void setBrowserItemScrollEventListener(d dVar) {
        this.scrollEventListener = dVar;
    }

    public void setDecoratorViewEvent(e eVar) {
        this.decoratorViewEvent = eVar;
    }

    public void setPictureScaleEventListener(f fVar) {
        this.pictureScaleEventListener = fVar;
    }

    public void updateUI() {
        e eVar = this.decoratorViewEvent;
        if (eVar != null) {
            eVar.updateUI();
        }
    }

    @Override // f04.c
    public void buildComplete() {
    }

    @Override // f04.c
    public void buildView() {
    }

    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
    }
}
