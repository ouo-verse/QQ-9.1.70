package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AlbumRecDirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedAlbumRec extends BaseFeedView implements FeedChildView, View.OnClickListener {
    static final FeedViewSection.SectionController SECTION_CONTROLLER = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedAlbumRec.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || !businessFeedData.isAlbumRecFeed();
        }
    };
    public static WeakReference<FeedAlbumRec> sLastRef;
    private AlbumRecReporter.c mAlbumRecInfo;
    private final AlbumRecDirector mDirector;
    private BusinessFeedData mLastFeedData;

    public FeedAlbumRec(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1716), this);
        this.mDirector = new AlbumRecDirector(this);
    }

    public BusinessFeedData getLastFeedData() {
        return this.mLastFeedData;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return this.mAlbumRecInfo == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.onFeedElementClickListener != null) {
            this.mDirector.e();
            this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, new com.qzone.proxy.feedcomponent.model.e(this.mDirector.h(), "", this.feedPosition));
            postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAlbumRec.2
                @Override // java.lang.Runnable
                public void run() {
                    FeedAlbumRec feedAlbumRec = FeedAlbumRec.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedAlbumRec.onFeedElementClickListener;
                    FeedElement feedElement = FeedElement.FEEDBACK;
                    int i3 = feedAlbumRec.feedPosition;
                    gVar.onClick(feedAlbumRec, feedElement, i3, Integer.valueOf(i3));
                }
            }, 50L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        if (this.mAlbumRecInfo == null) {
            return;
        }
        setVisibility(0);
        this.mDirector.i(this.mAlbumRecInfo);
        this.mDirector.setOnClickListener(this);
        AlbumRecReporter.D.f(this.mAlbumRecInfo.type);
        this.mDirector.f();
        sLastRef = new WeakReference<>(this);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mDirector.i(AlbumRecReporter.c.f47420a);
        this.mDirector.setOnClickListener(null);
        setVisibility(8);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        this.mLastFeedData = businessFeedData;
        if (businessFeedData.isAlbumRecFeed()) {
            AlbumRecReporter.c cVar = businessFeedData.albumRecInfo;
            this.mAlbumRecInfo = cVar;
            if (cVar == null) {
                this.mAlbumRecInfo = AlbumRecReporter.c.f47420a;
            }
            update();
        } else {
            this.mAlbumRecInfo = null;
        }
        if (this.mAlbumRecInfo == null) {
            setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
