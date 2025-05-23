package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AvatarArea;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.model.CellRecommendList;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedRecommendListArea extends DittoArea {
    private static final int AVATAR_LIST_MAX_SHOW_COUNT = 5;
    private List<SubAreaShell> mAllSubAreaShellLists;
    private List<SubAreaShell> mAvatarAreaShellList;
    private final String mHeaderTitleKeywordName;
    Paint mPaint;
    CellRecommendList mRecommendList;
    private SubAreaShell mTextDescShell;

    public CanvasFeedRecommendListArea(DittoHost dittoHost) {
        super(dittoHost);
        this.mPaint = new Paint();
        this.mHeaderTitleKeywordName = i.H().T("QZoneSetting", "feed_recommend_list_header_keyword", "UP");
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<SubAreaShell> list = this.mAllSubAreaShellLists;
        if (list != null) {
            for (SubAreaShell subAreaShell : list) {
                if (subAreaShell != null) {
                    canvas.save();
                    canvas.translate(subAreaShell.getLeft(), subAreaShell.getTop());
                    subAreaShell.draw(canvas, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        int i17;
        super.onMeasure(i3, i16);
        int i18 = AreaConst.dp11;
        List<SubAreaShell> list = this.mAvatarAreaShellList;
        if (list != null) {
            int i19 = AreaConst.dp10;
            int size = list.size();
            for (int i26 = 0; i26 < size; i26++) {
                SubAreaShell subAreaShell = this.mAvatarAreaShellList.get(i26);
                subAreaShell.setLeft(i18);
                subAreaShell.setTop(i19);
                if (i26 == size - 1) {
                    i17 = subAreaShell.getWidth();
                } else {
                    i17 = AreaConst.dp22_5;
                }
                i18 += i17;
            }
        }
        SubAreaShell subAreaShell2 = this.mTextDescShell;
        if (subAreaShell2 != null) {
            subAreaShell2.setLeft(i18 + AreaConst.dp9);
            this.mTextDescShell.setTop(AreaConst.dp18);
            this.mTextDescShell.measure(-2, -2);
        }
    }

    public void reset() {
        List<SubAreaShell> list = this.mAvatarAreaShellList;
        if (list != null) {
            list.clear();
        }
        List<SubAreaShell> list2 = this.mAllSubAreaShellLists;
        if (list2 != null) {
            list2.clear();
        }
        this.mTextDescShell = null;
        this.mRecommendList = null;
    }

    public void setData(CellRecommendList cellRecommendList, View view) {
        reset();
        this.mRecommendList = cellRecommendList;
        ArrayList<CellRecommendList.RecommendMan> arrayList = cellRecommendList == null ? null : cellRecommendList.recommendMans;
        if (arrayList != null && arrayList.size() >= 1) {
            if (this.mAllSubAreaShellLists == null) {
                this.mAllSubAreaShellLists = new ArrayList();
            }
            if (this.mAvatarAreaShellList == null) {
                this.mAvatarAreaShellList = new ArrayList();
            }
            int min = Math.min(arrayList.size(), 5);
            for (int i3 = 0; i3 < min; i3++) {
                User user = arrayList.get(i3).user;
                if (user != null) {
                    AvatarArea avatarArea = new AvatarArea();
                    avatarArea.setAvatarSize(AreaConst.dp26);
                    avatarArea.setUser(user, true);
                    SubAreaShell obtain = SubAreaShell.obtain(avatarArea);
                    obtain.setParent(view);
                    this.mAvatarAreaShellList.add(obtain);
                }
            }
            this.mAllSubAreaShellLists.addAll(this.mAvatarAreaShellList);
            FeedTextArea feedTextArea = new FeedTextArea(0);
            feedTextArea.setLineSpace(0.0f);
            feedTextArea.setMaxLine(1);
            feedTextArea.setTextSize(12.0f);
            feedTextArea.setTextColor(-16777216);
            feedTextArea.setData(getDisplayStr(cellRecommendList), 0);
            SubAreaShell obtain2 = SubAreaShell.obtain(feedTextArea);
            this.mTextDescShell = obtain2;
            obtain2.setParent(view);
            this.mAllSubAreaShellLists.add(this.mTextDescShell);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public CanvasFeedRecommendListArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mPaint = new Paint();
        this.mHeaderTitleKeywordName = i.H().T("QZoneSetting", "feed_recommend_list_header_keyword", "UP");
    }

    private String getDisplayStr(CellRecommendList cellRecommendList) {
        if (cellRecommendList == null) {
            return null;
        }
        if (cellRecommendList.isRecommended) {
            int i3 = cellRecommendList.num - 1;
            if (i3 > 0) {
                return "\u4f60\u548c" + i3 + "\u4f4d\u597d\u53cb" + this.mHeaderTitleKeywordName;
            }
            return "\u4f60" + this.mHeaderTitleKeywordName + "\u4e86";
        }
        return cellRecommendList.num + "\u4f4d\u597d\u53cb" + this.mHeaderTitleKeywordName;
    }
}
