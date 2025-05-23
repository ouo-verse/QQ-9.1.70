package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VisitView extends FeedCountView {
    private BusinessFeedData mFeedData;

    public VisitView(Context context) {
        super(context);
    }

    private void reportExposure() {
        String str;
        if (this.mFeedData == null) {
            return;
        }
        com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
        String str2 = this.mFeedData.getFeedCommInfoV2() == null ? null : this.mFeedData.getFeedCommInfoV2().feedskey;
        if (com.qzone.adapter.feedcomponent.i.H().j0() == this.mFeedData.getUser().uin) {
            str = "1";
        } else {
            str = "0";
        }
        H.g(201, 5, 1, "", str2, str);
    }

    public void setRemarkStr(String str) {
        SubAreaShell subAreaShell = this.countShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.countShell = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hasRemark = true;
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getVisitListArea(str, null, true));
        this.countShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.countShell.setParent(this);
    }

    public boolean setVisitInfo(CellVisitorInfo cellVisitorInfo, boolean z16) {
        boolean z17;
        SubAreaShell subAreaShell = this.countShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.countShell = null;
        }
        if (cellVisitorInfo != null && !TextUtils.isEmpty(cellVisitorInfo.displayStr)) {
            this.visitInfo = cellVisitorInfo;
            SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getVisitListArea(cellVisitorInfo.displayStr, z16 ? null : cellVisitorInfo.unikey));
            this.countShell = obtain;
            obtain.setOnClickListener(this.onClickListener);
            this.countShell.setParent(this);
            setContentDescription(cellVisitorInfo.displayStr);
            z17 = true;
        } else {
            setContentDescription("");
            z17 = false;
        }
        setFocusable(true);
        if (z17) {
            reportExposure();
        }
        return z17;
    }

    public VisitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisitView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public boolean setVisitInfo(CellVisitorInfo cellVisitorInfo, boolean z16, BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        return setVisitInfo(cellVisitorInfo, z16);
    }
}
