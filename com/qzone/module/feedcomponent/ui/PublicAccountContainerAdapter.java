package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class PublicAccountContainerAdapter extends BaseAdapter implements com.qzone.proxy.feedcomponent.widget.g {
    public static WeakReference<PublicAccountContainerAdapter> CIRCLE_RECOMM_ADAPTER_REF = new WeakReference<>(null);
    private float mAlpha;
    private Context mContext;
    private BusinessFeedData mFeedData;
    private Integer mFeedPos;
    private com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    private List<BusinessFeedData> mRecFeedDatas;
    private List<com.qzone.proxy.feedcomponent.widget.g> views = new ArrayList();

    public PublicAccountContainerAdapter(Context context, float f16, BusinessFeedData businessFeedData, Integer num, com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mContext = context;
        this.mAlpha = f16;
        this.mFeedData = businessFeedData;
        this.mOnFeedElementClickListener = gVar;
        this.mFeedPos = num;
        if (businessFeedData.isRecommendQQCircleFeed()) {
            CIRCLE_RECOMM_ADAPTER_REF = new WeakReference<>(this);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BusinessFeedData> list = this.mRecFeedDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<BusinessFeedData> list = this.mRecFeedDatas;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        if (getItem(i3) == null) {
            return 0L;
        }
        return ((BusinessFeedData) r3).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        CanvasPublicAccountContainerView canvasPublicAccountContainerView;
        if (view instanceof CanvasPublicAccountContainerView) {
            canvasPublicAccountContainerView = (CanvasPublicAccountContainerView) view;
        } else {
            canvasPublicAccountContainerView = new CanvasPublicAccountContainerView(this.mContext);
            this.views.add(canvasPublicAccountContainerView);
        }
        canvasPublicAccountContainerView.setAlpha(this.mAlpha);
        canvasPublicAccountContainerView.setFeedPosition(this.mFeedPos.intValue());
        canvasPublicAccountContainerView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        BusinessFeedData businessFeedData = this.mRecFeedDatas.get(i3);
        BusinessFeedData businessFeedData2 = this.mFeedData;
        canvasPublicAccountContainerView.setRecFeedData(businessFeedData, i3, businessFeedData2 != null && businessFeedData2.isRecommendQQCircleFeed());
        canvasPublicAccountContainerView.setPadding(i3 == 0 ? AreaConst.dp6 : 0, canvasPublicAccountContainerView.getPaddingTop(), canvasPublicAccountContainerView.getPaddingRight(), canvasPublicAccountContainerView.getPaddingBottom());
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return canvasPublicAccountContainerView;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        Iterator<com.qzone.proxy.feedcomponent.widget.g> it = this.views.iterator();
        while (it.hasNext()) {
            it.next().onRecycled();
        }
    }

    public void remove(int i3) {
        this.mRecFeedDatas.remove(i3);
        notifyDataSetChanged();
    }

    public void setRecFeedDatas(List<BusinessFeedData> list) {
        this.mRecFeedDatas = list;
    }
}
