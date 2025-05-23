package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.p;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.Collections;
import java.util.List;

/* loaded from: classes39.dex */
public class VisitAndPraiseAvatarsView extends View implements r {
    private int mAvatarSize;
    protected com.qzone.proxy.feedcomponent.ui.g mFeedElementClickListener;
    protected int mFeedPosition;
    protected int mIndex;
    protected SubAreaShell.OnAreaClickListener mOnAvatarClickListener;
    protected SubAreaShell.OnAreaClickListener mOnVisitClickListener;
    PraiseAvatarsArea mPraiseAvatarsArea;
    SubAreaShell mPraiseShell;
    SubAreaShell mTouchingShell;
    CellVisitorInfo mVisitInfo;
    SubAreaShell mVisitShell;

    public VisitAndPraiseAvatarsView(Context context) {
        super(context);
        this.mAvatarSize = -1;
        this.mOnAvatarClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                p pVar = (p) subAreaShell.getData();
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 36) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.PRAISE_AVATAR, visitAndPraiseAvatarsView.mFeedPosition, pVar);
            }
        };
        this.mOnVisitClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.VISIT, visitAndPraiseAvatarsView.mFeedPosition, visitAndPraiseAvatarsView.mVisitInfo);
            }
        };
    }

    SubAreaShell findShell(float f16, float f17) {
        if (this.mVisitShell != null && f17 > r2.getTop() && f17 < this.mVisitShell.getBottom()) {
            return this.mVisitShell;
        }
        SubAreaShell subAreaShell = this.mVisitShell;
        int bottom = subAreaShell != null ? subAreaShell.getBottom() : 0;
        if (this.mPraiseShell == null || f17 <= r0.getTop() + bottom || f17 >= this.mPraiseShell.getBottom() + bottom) {
            return null;
        }
        return this.mPraiseShell;
    }

    public String getReadStr() {
        PraiseAvatarsArea praiseAvatarsArea = this.mPraiseAvatarsArea;
        if (praiseAvatarsArea == null) {
            return "";
        }
        return praiseAvatarsArea.getReadStr();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        SubAreaShell subAreaShell = this.mVisitShell;
        if (subAreaShell != null) {
            subAreaShell.draw(canvas, null);
            canvas.translate(0.0f, this.mVisitShell.getHeight());
        }
        SubAreaShell subAreaShell2 = this.mPraiseShell;
        if (subAreaShell2 != null) {
            subAreaShell2.draw(canvas, null);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        SubAreaShell subAreaShell = this.mPraiseShell;
        int i18 = 0;
        if (subAreaShell != null) {
            i17 = subAreaShell.getWidth();
            i18 = 0 + this.mPraiseShell.getHeight();
        } else {
            i17 = 0;
        }
        SubAreaShell subAreaShell2 = this.mVisitShell;
        if (subAreaShell2 != null) {
            i17 = AreaConst.SCREEN_WIDTH;
            i18 += subAreaShell2.getHeight();
        }
        setMeasuredDimension(i17, i18);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        PraiseAvatarsArea praiseAvatarsArea = this.mPraiseAvatarsArea;
        if (praiseAvatarsArea != null) {
            praiseAvatarsArea.onRecycled();
            this.mPraiseAvatarsArea = null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SubAreaShell subAreaShell;
        SubAreaShell findShell = findShell(motionEvent.getX(), motionEvent.getY());
        SubAreaShell subAreaShell2 = this.mTouchingShell;
        if (findShell != subAreaShell2) {
            if (subAreaShell2 != null) {
                subAreaShell2.clearTouchingEvent();
            }
            this.mTouchingShell = findShell;
        }
        if (findShell != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(0.0f, findShell.getTop() * (-1));
            if (findShell == this.mPraiseShell && (subAreaShell = this.mVisitShell) != null) {
                obtain.offsetLocation(0.0f, subAreaShell.getHeight() * (-1));
            }
            boolean onTouchEvent = findShell.onTouchEvent(obtain);
            obtain.recycle();
            return onTouchEvent;
        }
        return super.onTouchEvent(motionEvent);
    }

    void recycleShell() {
        SubAreaShell subAreaShell = this.mPraiseShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.mPraiseShell = null;
        }
        SubAreaShell subAreaShell2 = this.mVisitShell;
        if (subAreaShell2 != null) {
            SubAreaShell.recycle(subAreaShell2);
            this.mVisitShell = null;
        }
    }

    public void reset() {
        recycleShell();
        this.mTouchingShell = null;
    }

    public void setAvatarPressEnable(boolean z16) {
        PraiseAvatarsArea praiseAvatarsArea = this.mPraiseAvatarsArea;
        if (praiseAvatarsArea != null) {
            praiseAvatarsArea.setAvatarPressEnable(z16);
        }
    }

    public void setAvatarSize(int i3) {
        this.mAvatarSize = i3;
    }

    public void setFeedPosition(int i3, int i16) {
        this.mFeedPosition = i3;
        this.mIndex = i16;
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mFeedElementClickListener = gVar;
    }

    public void setPraiseData(List<CellLikeInfo.LikeMan> list, int i3) {
        setPraiseData(list, i3, true, null, -1, -1);
    }

    public boolean setVisitInfo(CellVisitorInfo cellVisitorInfo) {
        SubAreaShell subAreaShell = this.mVisitShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.mVisitShell = null;
        }
        if (cellVisitorInfo == null || TextUtils.isEmpty(cellVisitorInfo.displayStr)) {
            return false;
        }
        this.mVisitInfo = cellVisitorInfo;
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getVisitListArea(cellVisitorInfo.displayStr, cellVisitorInfo.unikey));
        this.mVisitShell = obtain;
        obtain.setOnClickListener(this.mOnVisitClickListener);
        this.mVisitShell.setParent(this);
        SubAreaShell subAreaShell2 = this.mVisitShell;
        int i3 = AreaConst.dp8;
        subAreaShell2.setPaddingLeft(i3);
        this.mVisitShell.setPaddingRight(i3);
        this.mVisitShell.setPaddingTop(i3);
        this.mVisitShell.setPaddingBottom(i3);
        return true;
    }

    public void setPraiseData(List<CellLikeInfo.LikeMan> list, int i3, boolean z16, String str, int i16, int i17) {
        SubAreaShell subAreaShell = this.mPraiseShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.mPraiseShell = null;
        }
        if (this.mPraiseAvatarsArea == null) {
            PraiseAvatarsArea praiseAvatarsArea = new PraiseAvatarsArea();
            this.mPraiseAvatarsArea = praiseAvatarsArea;
            int i18 = this.mAvatarSize;
            if (i18 > 0) {
                praiseAvatarsArea.setAvatarSize(i18);
            }
        }
        if (list != null) {
            this.mPraiseAvatarsArea.setShowPraiseIcon(z16);
            if (str != null) {
                this.mPraiseAvatarsArea.setCustomString(str, i16, i17);
            }
            this.mPraiseAvatarsArea.setUsers(list, i3);
            this.mPraiseAvatarsArea.measure(AreaConst.SCREEN_WIDTH, 0);
            SubAreaShell obtain = SubAreaShell.obtain(this.mPraiseAvatarsArea);
            this.mPraiseShell = obtain;
            obtain.setParent(this);
            this.mPraiseShell.setOnClickListener(this.mOnAvatarClickListener);
            return;
        }
        this.mPraiseAvatarsArea.setUsers(Collections.emptyList(), 0);
    }

    public VisitAndPraiseAvatarsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAvatarSize = -1;
        this.mOnAvatarClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                p pVar = (p) subAreaShell.getData();
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 36) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.PRAISE_AVATAR, visitAndPraiseAvatarsView.mFeedPosition, pVar);
            }
        };
        this.mOnVisitClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.VISIT, visitAndPraiseAvatarsView.mFeedPosition, visitAndPraiseAvatarsView.mVisitInfo);
            }
        };
    }

    public VisitAndPraiseAvatarsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAvatarSize = -1;
        this.mOnAvatarClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                p pVar = (p) subAreaShell.getData();
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 36) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.PRAISE_AVATAR, visitAndPraiseAvatarsView.mFeedPosition, pVar);
            }
        };
        this.mOnVisitClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseAvatarsView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseAvatarsView.this.mFeedElementClickListener == null || subAreaShell.getType() != 30) {
                    return;
                }
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = VisitAndPraiseAvatarsView.this;
                visitAndPraiseAvatarsView.mFeedElementClickListener.onClick(visitAndPraiseAvatarsView, FeedElement.VISIT, visitAndPraiseAvatarsView.mFeedPosition, visitAndPraiseAvatarsView.mVisitInfo);
            }
        };
    }
}
