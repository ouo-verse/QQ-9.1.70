package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedContainerAdapter extends BaseAdapter {
    protected final List<BusinessFeedData> feedDatas = new ArrayList();
    Context mContext;
    protected int mFeedPos;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;

    @Override // android.widget.Adapter
    public int getCount() {
        List<BusinessFeedData> list = this.feedDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getFeedPos() {
        return this.mFeedPos;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        AbsFeedView absFeedView;
        boolean z16;
        View view2;
        BusinessFeedData item = getItem(i3);
        if (item == null) {
            view2 = view;
        } else {
            if (view == null) {
                absFeedView = ViewLoader.getInstance().obtainFeedViewInContainer(this.mContext);
            } else {
                absFeedView = (AbsFeedView) view;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) absFeedView.getLayoutParams();
            boolean z17 = true;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(AreaConst.feedWidth_Rec, -2);
                z16 = true;
            } else {
                layoutParams.width = AreaConst.feedWidth_Rec;
                layoutParams.height = -2;
                z16 = false;
            }
            if (i3 == 0) {
                int i16 = layoutParams.leftMargin;
                int i17 = AreaConst.dp10;
                if (i16 != i17) {
                    layoutParams.setMargins(i17, 0, 0, 0);
                    if (z17) {
                        absFeedView.setLayoutParams(layoutParams);
                    }
                    if (item.getFeedCommInfo().recomtype != 7) {
                        int paddingRight = absFeedView.getPaddingRight();
                        int i18 = AreaConst.f48746dp1;
                        if (paddingRight != i18) {
                            absFeedView.setPadding(absFeedView.getPaddingLeft(), absFeedView.getPaddingTop(), absFeedView.getPaddingRight(), i18);
                        }
                    } else {
                        int paddingRight2 = absFeedView.getPaddingRight();
                        int i19 = AreaConst.dp10;
                        int i26 = AreaConst.f48746dp1;
                        if (paddingRight2 != i19 + i26) {
                            absFeedView.setPadding(absFeedView.getPaddingLeft(), absFeedView.getPaddingTop(), absFeedView.getPaddingRight(), i19 + i26);
                        }
                    }
                    if (!item.hasCalculate) {
                        com.qzone.adapter.feedcomponent.d.w(item);
                    }
                    absFeedView.mFeedData = item;
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                    ((FeedView) absFeedView).mIndex = i3;
                    absFeedView.setFeedPosition(this.mFeedPos);
                    absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                    absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                    view2 = absFeedView;
                    if (i3 == 0) {
                        view2 = absFeedView;
                        if (item.getFeedCommInfo() != null) {
                            view2 = absFeedView;
                            if (item.getFeedCommInfo().isBizRecomFeeds()) {
                                com.qzone.adapter.feedcomponent.i.H().T1(i3, item);
                                view2 = absFeedView;
                            }
                        }
                    }
                }
                z17 = z16;
                if (z17) {
                }
                if (item.getFeedCommInfo().recomtype != 7) {
                }
                if (!item.hasCalculate) {
                }
                absFeedView.mFeedData = item;
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                ((FeedView) absFeedView).mIndex = i3;
                absFeedView.setFeedPosition(this.mFeedPos);
                absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                view2 = absFeedView;
                if (i3 == 0) {
                }
            } else if (i3 == this.feedDatas.size() - 1) {
                int i27 = layoutParams.leftMargin;
                int i28 = AreaConst.dp5;
                if (i27 != i28 || layoutParams.rightMargin != AreaConst.dp10) {
                    layoutParams.setMargins(i28, 0, AreaConst.dp10, 0);
                    if (z17) {
                    }
                    if (item.getFeedCommInfo().recomtype != 7) {
                    }
                    if (!item.hasCalculate) {
                    }
                    absFeedView.mFeedData = item;
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                    ((FeedView) absFeedView).mIndex = i3;
                    absFeedView.setFeedPosition(this.mFeedPos);
                    absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                    absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                    view2 = absFeedView;
                    if (i3 == 0) {
                    }
                }
                z17 = z16;
                if (z17) {
                }
                if (item.getFeedCommInfo().recomtype != 7) {
                }
                if (!item.hasCalculate) {
                }
                absFeedView.mFeedData = item;
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                ((FeedView) absFeedView).mIndex = i3;
                absFeedView.setFeedPosition(this.mFeedPos);
                absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                view2 = absFeedView;
                if (i3 == 0) {
                }
            } else {
                int i29 = layoutParams.leftMargin;
                int i36 = AreaConst.dp5;
                if (i29 != i36) {
                    layoutParams.setMargins(i36, 0, 0, 0);
                    if (z17) {
                    }
                    if (item.getFeedCommInfo().recomtype != 7) {
                    }
                    if (!item.hasCalculate) {
                    }
                    absFeedView.mFeedData = item;
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                    ((FeedView) absFeedView).mIndex = i3;
                    absFeedView.setFeedPosition(this.mFeedPos);
                    absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                    absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                    view2 = absFeedView;
                    if (i3 == 0) {
                    }
                }
                z17 = z16;
                if (z17) {
                }
                if (item.getFeedCommInfo().recomtype != 7) {
                }
                if (!item.hasCalculate) {
                }
                absFeedView.mFeedData = item;
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(this.mContext, absFeedView, item, false);
                ((FeedView) absFeedView).mIndex = i3;
                absFeedView.setFeedPosition(this.mFeedPos);
                absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                view2 = absFeedView;
                if (i3 == 0) {
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<BusinessFeedData> list, Context context) {
        setData(list, context, null);
    }

    void setupSummaryLine() {
        int i3 = 0;
        for (BusinessFeedData businessFeedData : this.feedDatas) {
            int measureContainerFeedSummaryLine = AreaManager.getInstance().measureContainerFeedSummaryLine(businessFeedData.getCellSummaryV2(), businessFeedData.isSubOfMultiAdvContainerFeed());
            if (i3 < measureContainerFeedSummaryLine) {
                i3 = measureContainerFeedSummaryLine;
            }
        }
        if (i3 > 0) {
            for (BusinessFeedData businessFeedData2 : this.feedDatas) {
                if (businessFeedData2.getCellSummaryV2() != null) {
                    businessFeedData2.getCellSummaryV2().minLine = i3;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public BusinessFeedData getItem(int i3) {
        List<BusinessFeedData> list = this.feedDatas;
        if (list != null && list.size() >= i3 + 1) {
            return this.feedDatas.get(i3);
        }
        return null;
    }

    public void setData(List<BusinessFeedData> list, Context context, com.qzone.proxy.feedcomponent.ui.g gVar) {
        if (gVar != null) {
            this.mOnFeedElementClickListener = gVar;
        }
        this.feedDatas.clear();
        this.mContext = context;
        if (list != null) {
            this.feedDatas.addAll(list);
        }
        setupSummaryLine();
        notifyDataSetChanged();
    }
}
