package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSearchNoResultTip extends BaseFeedView implements FeedChildView {
    public static FeedViewSection.SectionController SearchTipController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedSearchNoResultTip.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || !businessFeedData.isNeedShowSearchNoResultTip();
        }
    };
    private static String noTraceText = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NotTrace", "\u6ca1\u6709\u7559\u4e0b\u75d5\u8ff9");
    TextView mDesc;
    TextView mMonth;

    public FeedSearchNoResultTip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    void initUI(Context context) {
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1696), this);
        inflate.setBackgroundColor(0);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSearchNoResultTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        findViewById(com.qzone.adapter.feedcomponent.j.O(2582)).setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        TextView textView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2580));
        this.mMonth = textView;
        textView.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        TextView textView2 = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2581));
        this.mDesc = textView2;
        textView2.setTextColor(com.qzone.adapter.feedcomponent.j.F());
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            setData(businessFeedData.searchClickCalendar, businessFeedData.searchRealCalendar, businessFeedData.isBlankSearchNoResultTip);
        }
    }

    public void setData(Calendar calendar, Calendar calendar2, boolean z16) {
        if (calendar == null || calendar2 == null) {
            return;
        }
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar2.get(1);
        int i18 = calendar2.get(2) + 1;
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append(i3);
            sb5.append("\u5e74");
            sb5.append(i16);
            sb5.append("\u6708");
        } else if (i3 == i17) {
            if (i16 - i18 == 1) {
                sb5.append(i3);
                sb5.append("\u5e74");
                sb5.append(i16);
                sb5.append("\u6708");
            } else if (i18 < 12) {
                sb5.append(i3);
                sb5.append("\u5e74");
                sb5.append(i18 + 1);
                sb5.append("\u6708~");
                sb5.append(i16);
                sb5.append("\u6708");
            } else {
                sb5.append(i3 + 1);
                sb5.append("\u5e74");
                sb5.append(1);
                sb5.append("\u6708~");
                sb5.append(i16);
                sb5.append("\u6708");
            }
        } else if (i18 < 12) {
            sb5.append(i17);
            sb5.append("\u5e74");
            sb5.append(i18 + 1);
            sb5.append("\u6708~");
            sb5.append(i3);
            sb5.append("\u5e74");
            sb5.append(i16);
            sb5.append("\u6708");
        } else {
            sb5.append(i17 + 1);
            sb5.append("\u5e74");
            sb5.append(1);
            sb5.append("\u6708~");
            sb5.append(i3);
            sb5.append("\u5e74");
            sb5.append(i16);
            sb5.append("\u6708");
        }
        TextView textView = this.mMonth;
        if (textView != null) {
            textView.setText(sb5.toString());
        }
        TextView textView2 = this.mDesc;
        if (textView2 != null) {
            textView2.setText(noTraceText);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
