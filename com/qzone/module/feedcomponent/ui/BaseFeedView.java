package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.PictureUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class BaseFeedView extends FrameLayout implements com.qzone.proxy.feedcomponent.widget.g {
    static int lastOrientation = -1;
    static int screenWidth;
    protected int containerPosition;
    protected float density;
    protected int feedPosition;
    protected boolean hasUsed;
    protected Context mContext;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    protected com.qzone.proxy.feedcomponent.ui.h onFeedEventListener;

    public BaseFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.density = context.getResources().getDisplayMetrics().density;
    }

    public final void attachContext(Context context) {
        this.mContext = context;
    }

    public final Context getAttachedContext() {
        return this.mContext;
    }

    public int getContainerPosition() {
        return this.containerPosition;
    }

    public int getFeedPosition() {
        return this.feedPosition;
    }

    protected int getScreenWidth() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int orientation = defaultDisplay.getOrientation();
        if (orientation != lastOrientation) {
            screenWidth = defaultDisplay.getWidth();
            lastOrientation = orientation;
        }
        return screenWidth;
    }

    public boolean hasUsed() {
        return this.hasUsed;
    }

    protected abstract boolean isEmptyData();

    protected abstract void onUpdate();

    public abstract void reset();

    public void setContainerPosition(int i3) {
        this.containerPosition = i3;
    }

    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
        this.onFeedEventListener = hVar;
    }

    protected void setTouchDelegate(View view, View view2) {
        Rect rect = new Rect();
        view2.getDrawingRect(rect);
        view.setTouchDelegate(new TouchDelegate(rect, view2));
    }

    public void setUsed(boolean z16) {
        this.hasUsed = z16;
    }

    public void update() {
        if (isEmptyData()) {
            return;
        }
        this.hasUsed = true;
        onUpdate();
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.onFeedElementClickListener = null;
        this.onFeedEventListener = null;
    }

    protected void setViewInvisible(View view) {
        setVisibility(4, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setViewVisbile(View view) {
        setVisibility(0, view);
    }

    protected static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    protected static boolean isUrlEmpty(PictureUrl pictureUrl) {
        String str;
        return pictureUrl == null || (str = pictureUrl.url) == null || str.trim().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setViewGone(View view) {
        setVisibility(8, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisibility(int i3, View view) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    protected void setTextColorAndSize(int i3, int i16, TextView textView) {
        if (i3 != -1) {
            textView.setTextColor(i3);
        }
        if (i16 != -1) {
            textView.setTextSize(i16);
        }
    }
}
