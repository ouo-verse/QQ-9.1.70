package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardView2;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class FriendPlayingAdapter extends BaseAdapter implements com.qzone.proxy.feedcomponent.widget.g {
    private float mAlpha;
    private Context mContext;
    private BusinessFeedData mFeedData;
    private Integer mFeedPos;
    private boolean mIsV2;
    private com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    private List<PicText> mPicTexts;
    private List<com.qzone.proxy.feedcomponent.widget.g> views = new ArrayList();

    public FriendPlayingAdapter(Context context, float f16, boolean z16, BusinessFeedData businessFeedData, Integer num, com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mContext = context;
        this.mAlpha = f16;
        this.mIsV2 = z16;
        this.mFeedData = businessFeedData;
        this.mOnFeedElementClickListener = gVar;
        this.mFeedPos = num;
    }

    private View getCanvasFriendPlayingCardView2(int i3, View view) {
        CanvasFriendPlayingCardView2 canvasFriendPlayingCardView2;
        if (view instanceof CanvasFriendPlayingCardView2) {
            canvasFriendPlayingCardView2 = (CanvasFriendPlayingCardView2) view;
        } else {
            canvasFriendPlayingCardView2 = new CanvasFriendPlayingCardView2(this.mContext);
            this.views.add(canvasFriendPlayingCardView2);
        }
        canvasFriendPlayingCardView2.setFeedPosition(this.mFeedPos.intValue());
        canvasFriendPlayingCardView2.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        canvasFriendPlayingCardView2.setData(this.mFeedData, this.mPicTexts.get(i3), i3);
        return canvasFriendPlayingCardView2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PicText> list = this.mPicTexts;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<PicText> list = this.mPicTexts;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View canvasFriendPlayingCardView;
        if (this.mIsV2) {
            canvasFriendPlayingCardView = getCanvasFriendPlayingCardView2(i3, view);
        } else {
            canvasFriendPlayingCardView = getCanvasFriendPlayingCardView(i3, view);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return canvasFriendPlayingCardView;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        Iterator<com.qzone.proxy.feedcomponent.widget.g> it = this.views.iterator();
        while (it.hasNext()) {
            it.next().onRecycled();
        }
    }

    public void setPicText(List<PicText> list) {
        this.mPicTexts = list;
    }

    private View getCanvasFriendPlayingCardView(int i3, View view) {
        CanvasFriendPlayingCardView canvasFriendPlayingCardView;
        if (view != null && (view instanceof CanvasFriendPlayingCardView)) {
            canvasFriendPlayingCardView = (CanvasFriendPlayingCardView) view;
        } else {
            canvasFriendPlayingCardView = new CanvasFriendPlayingCardView(this.mContext);
            this.views.add(canvasFriendPlayingCardView);
        }
        canvasFriendPlayingCardView.setAlpha(this.mAlpha);
        canvasFriendPlayingCardView.setFeedPosition(this.mFeedPos.intValue());
        canvasFriendPlayingCardView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        canvasFriendPlayingCardView.setPlayPicText(this.mFeedData, this.mPicTexts.get(i3), i3);
        canvasFriendPlayingCardView.setPadding(i3 == 0 ? AreaConst.dp6 : 0, canvasFriendPlayingCardView.getPaddingTop(), canvasFriendPlayingCardView.getPaddingRight(), canvasFriendPlayingCardView.getPaddingBottom());
        return canvasFriendPlayingCardView;
    }
}
