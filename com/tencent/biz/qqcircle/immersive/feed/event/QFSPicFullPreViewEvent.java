package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.View;
import com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPicFullPreViewEvent extends SimpleBaseEvent {
    public static final int VIEW_DISMISS = 1;
    public static final int VIEW_SHOW = 0;
    private final int mAction;
    private View mClearDetectorView;
    private QFSGalleryPreListView mPicPreView;

    public QFSPicFullPreViewEvent(int i3, int i16) {
        this.mAction = i3;
        this.mHashCode = i16;
    }

    public int getAction() {
        return this.mAction;
    }

    public View getClearDetectorView() {
        return this.mClearDetectorView;
    }

    public QFSGalleryPreListView getPicPreView() {
        return this.mPicPreView;
    }

    public void setClearDetectorView(View view) {
        this.mClearDetectorView = view;
    }

    public void setPreView(QFSGalleryPreListView qFSGalleryPreListView) {
        this.mPicPreView = qFSGalleryPreListView;
    }
}
