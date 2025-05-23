package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes2.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z16, boolean z17) {
        this(imageLoader, z16, z17, null);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && this.pauseOnFling) {
                    this.imageLoader.pause();
                }
            } else if (this.pauseOnScroll) {
                this.imageLoader.pause();
            }
        } else {
            this.imageLoader.resume();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z16, boolean z17, AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z16;
        this.pauseOnFling = z17;
        this.externalListener = onScrollListener;
    }
}
