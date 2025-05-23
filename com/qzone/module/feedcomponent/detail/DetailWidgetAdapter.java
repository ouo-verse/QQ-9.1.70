package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.detail.AbsDetailWidgetView;
import com.qzone.proxy.feedcomponent.ui.detail.a;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DetailWidgetAdapter extends a {
    boolean mNeedBackground;
    private static final String FEED_COMMENT_VERIFY_TIPS = j.K(1110);
    private static final String FEED_COMMENT_PRIVATE_SPACE_TIPS = j.K(1111);

    public DetailWidgetAdapter(Context context, int i3) {
        super(context, i3);
        this.mNeedBackground = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i3 = this.mWidgetType;
        if (i3 == 3) {
            Object obj = this.mWidgetData;
            if (obj == null || !(obj instanceof BusinessFeedData)) {
                return 0;
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            return (businessFeedData.getCellUserInfo().getUser() == null || businessFeedData.getCellUserInfo().getUser().isCmtVerifyOpen != 1) ? 0 : 1;
        }
        if (i3 != 4) {
            return i3 == -1 ? 0 : 1;
        }
        Object obj2 = this.mWidgetData;
        if (obj2 == null || !(obj2 instanceof BusinessFeedData)) {
            return 0;
        }
        BusinessFeedData businessFeedData2 = (BusinessFeedData) obj2;
        return (businessFeedData2.getCellUserInfo().getUser() == null || businessFeedData2.getCellUserInfo().getUser().isPrivateMode != 1) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000f, code lost:
    
        if (r0 != 4) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
    
        if (r0 == 2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
    
        if (r0 == 1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
    
        if (r0 == 0) goto L62;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        View view4;
        View view5;
        int i16 = this.mWidgetType;
        if (i16 == 0) {
            if (view instanceof AbsDetailWidgetView) {
                int widgetType = ((AbsDetailWidgetView) view).getWidgetType();
                view2 = view;
            }
            FeedDetailEnterHostSpaceWidgetView feedDetailEnterHostSpaceWidgetView = new FeedDetailEnterHostSpaceWidgetView(this.mContext);
            feedDetailEnterHostSpaceWidgetView.setOnDetailFeedElementClickListener(this.onFeedElementClickListener);
            view2 = feedDetailEnterHostSpaceWidgetView;
            ((AbsDetailWidgetView) view2).setWidgetData(this.mWidgetData);
            g gVar = this.onFeedElementClickListener;
            view3 = view2;
            if (gVar != null) {
                gVar.onClick(view2, FeedElement.DETAIL_WIDGET_ENTER_HOST_SPACE_EXPOSE, 0, null);
                view3 = view2;
            }
        } else if (i16 == 1) {
            if (view instanceof AbsDetailWidgetView) {
                int widgetType2 = ((AbsDetailWidgetView) view).getWidgetType();
                view4 = view;
            }
            FeedDetailBlankAreaWidgetView feedDetailBlankAreaWidgetView = new FeedDetailBlankAreaWidgetView(this.mContext);
            feedDetailBlankAreaWidgetView.setOnDetailFeedElementClickListener(this.onFeedElementClickListener);
            feedDetailBlankAreaWidgetView.setWidgetData(this.mWidgetData);
            feedDetailBlankAreaWidgetView.initUI(this.mContext);
            view4 = feedDetailBlankAreaWidgetView;
            boolean z16 = view4 instanceof FeedDetailBlankAreaWidgetView;
            view3 = view4;
            if (z16) {
                ((FeedDetailBlankAreaWidgetView) view4).setNeedBackground(this.mNeedBackground);
                view3 = view4;
            }
        } else if (i16 != 2) {
            if (i16 != 3) {
                view3 = view;
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(j.j(1677), (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(j.O(2664));
            view3 = inflate;
            if (textView != null) {
                if (this.mWidgetType == 3) {
                    showVerifyTips(textView);
                } else {
                    textView.setText(FEED_COMMENT_PRIVATE_SPACE_TIPS);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                Object obj = this.mWidgetData;
                if (obj != null && (obj instanceof BusinessFeedData)) {
                    BusinessFeedData businessFeedData = (BusinessFeedData) obj;
                    if ((businessFeedData.getLikeInfoV2() == null || TextUtils.isEmpty(businessFeedData.getLikeInfoV2().displayStr)) && businessFeedData.getCellRedBonus() == null && businessFeedData.getCellLuckyMoney() == null && businessFeedData.getCellForwardInfo() == null) {
                        layoutParams.topMargin = com.qzone.proxy.feedcomponent.util.g.a(9.0f);
                        layoutParams.bottomMargin = com.qzone.proxy.feedcomponent.util.g.a(4.0f);
                    } else {
                        layoutParams.topMargin = com.qzone.proxy.feedcomponent.util.g.a(17.0f);
                        layoutParams.bottomMargin = com.qzone.proxy.feedcomponent.util.g.a(4.0f);
                    }
                }
                textView.setLayoutParams(layoutParams);
                view3 = inflate;
            }
        } else {
            if (view instanceof AbsDetailWidgetView) {
                int widgetType3 = ((AbsDetailWidgetView) view).getWidgetType();
                view5 = view;
            }
            FeedDetailCommentTipsWidgetView feedDetailCommentTipsWidgetView = new FeedDetailCommentTipsWidgetView(this.mContext);
            feedDetailCommentTipsWidgetView.setOnDetailFeedElementClickListener(this.onFeedElementClickListener);
            feedDetailCommentTipsWidgetView.initUI(this.mContext);
            view5 = feedDetailCommentTipsWidgetView;
            ((AbsDetailWidgetView) view5).setWidgetData(this.mWidgetData);
            view3 = view5;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.a
    public void setNeedBackground(boolean z16) {
        this.mNeedBackground = z16;
    }

    private void showVerifyTips(TextView textView) {
        if (textView != null && i.H().U("QZoneSetting", "isShowVerifyTips", false)) {
            textView.setText(FEED_COMMENT_VERIFY_TIPS);
        }
    }
}
