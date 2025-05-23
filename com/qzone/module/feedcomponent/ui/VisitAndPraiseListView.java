package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellInterest;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;

/* loaded from: classes39.dex */
public class VisitAndPraiseListView extends View {
    protected int feedPosition;
    boolean isIntrest;
    TitleAttachArea mAttachArea;
    SubAreaShell mAttachShell;
    int mGoodsType;
    protected int mIndex;
    boolean mIsGoods;
    protected SubAreaShell.OnAreaClickListener onClickListener;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    int paddingTop;
    SubAreaShell praiseShell;
    SubAreaShell touchingArea;
    CellVisitorInfo visitInfo;
    SubAreaShell visitShell;

    public VisitAndPraiseListView(Context context) {
        super(context);
        this.paddingTop = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseListView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 30) {
                    VisitAndPraiseListView visitAndPraiseListView = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView.isIntrest) {
                        visitAndPraiseListView.onFeedElementClickListener.onClick(visitAndPraiseListView, FeedElement.VISIT, visitAndPraiseListView.feedPosition, visitAndPraiseListView.visitInfo);
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 25) {
                    VisitAndPraiseListView visitAndPraiseListView2 = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView2.isIntrest) {
                        if (textCell instanceof UserNameCell) {
                            long longValue = ((UserNameCell) textCell).getUin().longValue();
                            VisitAndPraiseListView visitAndPraiseListView3 = VisitAndPraiseListView.this;
                            visitAndPraiseListView3.onFeedElementClickListener.onClick(visitAndPraiseListView3, FeedElement.FRIEND_NICKNAME, visitAndPraiseListView3.feedPosition, Long.valueOf(longValue));
                            if (VisitAndPraiseListView.this.mIsGoods) {
                                com.qzone.adapter.feedcomponent.i.H().a2(VisitAndPraiseListView.this.mGoodsType);
                                return;
                            }
                            return;
                        }
                        visitAndPraiseListView2.onFeedElementClickListener.onClick(visitAndPraiseListView2, FeedElement.PRAISE_LIST, visitAndPraiseListView2.feedPosition, null);
                        return;
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener == null || subAreaShell.getType() != 59) {
                    return;
                }
                ClickedPoint clickedPoint = new ClickedPoint(subAreaShell.getLeft(), subAreaShell.getTop(), 0, 0, subAreaShell.getWidth(), subAreaShell.getHeight());
                VisitAndPraiseListView visitAndPraiseListView4 = VisitAndPraiseListView.this;
                visitAndPraiseListView4.onFeedElementClickListener.onClick(visitAndPraiseListView4, FeedElement.DROPDOWN_BUTTON, visitAndPraiseListView4.feedPosition, clickedPoint);
            }
        };
    }

    SubAreaShell findArea(float f16, float f17) {
        if (this.visitShell != null && f17 > r0.getTop() && f17 < this.visitShell.getBottom() && f16 > this.visitShell.getLeft() && f16 < this.visitShell.getRight()) {
            return this.visitShell;
        }
        if (this.praiseShell != null && f17 > r0.getTop() && f17 < this.praiseShell.getBottom() && f16 > this.praiseShell.getLeft() && f16 < this.praiseShell.getRight()) {
            return this.praiseShell;
        }
        if (this.mAttachShell == null || f17 <= r0.getTop() || f17 >= this.mAttachShell.getBottom() || f16 <= this.mAttachShell.getLeft() || f16 >= this.mAttachShell.getRight()) {
            return null;
        }
        return this.mAttachShell;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        SubAreaShell subAreaShell;
        canvas.save();
        if (this.praiseShell != null || this.visitShell != null) {
            canvas.translate(0.0f, this.paddingTop);
        }
        SubAreaShell subAreaShell2 = this.visitShell;
        if (subAreaShell2 != null) {
            subAreaShell2.draw(canvas, null);
            canvas.translate(0.0f, this.visitShell.getHeight());
        }
        if (this.praiseShell != null) {
            canvas.translate(0.0f, AreaConst.dp5);
            this.praiseShell.draw(canvas, null);
        }
        if (this.isIntrest && (subAreaShell = this.praiseShell) != null) {
            canvas.translate(0.0f, subAreaShell.getHeight() - AreaConst.f48746dp1);
            Paint paint = new Paint();
            paint.setColor(com.qzone.adapter.feedcomponent.j.H());
            canvas.drawLine(AreaConst.dp8, 0.0f, AreaConst.SCREEN_WIDTH - r0, 0.0f, paint);
        }
        if (this.mAttachShell != null) {
            canvas.restore();
            canvas.save();
            canvas.translate(this.mAttachShell.getLeft(), this.mAttachShell.getTop() + AreaConst.f48749dp4);
            this.mAttachShell.draw(canvas, null);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = 0;
        int i18 = (this.praiseShell == null && this.visitShell == null) ? 0 : this.paddingTop + 0;
        SubAreaShell subAreaShell = this.visitShell;
        if (subAreaShell != null) {
            subAreaShell.setTop(i18);
            i17 = AreaConst.SCREEN_WIDTH;
            i18 += this.visitShell.getHeight();
        }
        SubAreaShell subAreaShell2 = this.praiseShell;
        if (subAreaShell2 != null) {
            subAreaShell2.setTop(i18);
            i17 = AreaConst.SCREEN_WIDTH;
            i18 += this.praiseShell.getHeight();
        }
        SubAreaShell subAreaShell3 = this.mAttachShell;
        if (subAreaShell3 != null) {
            subAreaShell3.measure(i3, i16);
        }
        setMeasuredDimension(i17, i18);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SubAreaShell findArea = findArea(motionEvent.getX(), motionEvent.getY());
        SubAreaShell subAreaShell = this.touchingArea;
        if (findArea != subAreaShell) {
            if (subAreaShell != null) {
                subAreaShell.clearTouchingEvent();
            }
            this.touchingArea = findArea;
        }
        if (findArea != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(0.0f, findArea.getTop() * (-1));
            boolean onTouchEvent = findArea.onTouchEvent(obtain);
            obtain.recycle();
            if (onTouchEvent) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    void recycleShell() {
        SubAreaShell subAreaShell = this.praiseShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.praiseShell = null;
        }
        SubAreaShell subAreaShell2 = this.visitShell;
        if (subAreaShell2 != null) {
            SubAreaShell.recycle(subAreaShell2);
            this.visitShell = null;
        }
    }

    void setAttachArea(BusinessFeedData businessFeedData) {
        if (this.mAttachArea == null) {
            this.mAttachArea = new TitleAttachArea();
        }
        SubAreaShell subAreaShell = this.mAttachShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
        }
        this.mAttachArea.setFeedData(businessFeedData, false);
        SubAreaShell obtain = SubAreaShell.obtain(this.mAttachArea);
        this.mAttachShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.mAttachShell.setParent(this);
        this.mAttachShell.setLeft(AreaConst.SCREEN_WIDTH - AreaConst.dp35);
        this.mAttachShell.setPaddingTop(AreaConst.dp12);
    }

    public void setFeedPosition(int i3, int i16) {
        this.feedPosition = i3;
        this.mIndex = i16;
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
    }

    public boolean setLikeInfo(CellLikeInfo cellLikeInfo, boolean z16, int i3) {
        this.mIsGoods = z16;
        this.mGoodsType = i3;
        SubAreaShell subAreaShell = this.praiseShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.praiseShell = null;
        }
        if (cellLikeInfo == null || TextUtils.isEmpty(cellLikeInfo.displayStr)) {
            return false;
        }
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getPraiseListArea(cellLikeInfo.displayStr, cellLikeInfo.isLiked, cellLikeInfo.unikey, false, z16));
        this.praiseShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.praiseShell.setPaddingLeft(AreaConst.FEED_INTERVAL);
        this.praiseShell.setParent(this);
        SubAreaShell subAreaShell2 = this.praiseShell;
        int i16 = AreaConst.dp10;
        subAreaShell2.setPaddingTop(i16);
        this.praiseShell.setPaddingBottom(i16);
        return true;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setPaddingTop(int i3) {
        this.paddingTop = i3;
    }

    public boolean setVisitInfo(CellVisitorInfo cellVisitorInfo) {
        SubAreaShell subAreaShell = this.visitShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.visitShell = null;
        }
        if (cellVisitorInfo == null || TextUtils.isEmpty(cellVisitorInfo.displayStr)) {
            return false;
        }
        this.visitInfo = cellVisitorInfo;
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getVisitListArea(cellVisitorInfo.displayStr, cellVisitorInfo.unikey));
        this.visitShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.visitShell.setParent(this);
        this.visitShell.setPaddingLeft(AreaConst.FEED_INTERVAL);
        this.visitShell.setPaddingTop(com.qzone.proxy.feedcomponent.util.g.a(4.0f));
        return true;
    }

    public void reset() {
        this.isIntrest = false;
        recycleShell();
        this.touchingArea = null;
    }

    public boolean setInterestInfo(BusinessFeedData businessFeedData, CellInterest cellInterest) {
        boolean z16 = true;
        this.isIntrest = true;
        SubAreaShell subAreaShell = this.praiseShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.praiseShell = null;
        }
        if (cellInterest == null || TextUtils.isEmpty(cellInterest.displayUserStr)) {
            z16 = false;
        } else {
            SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getInterestArea(cellInterest.displayUserStr, cellInterest.displayEllipsisStr, cellInterest.unikey, false));
            this.praiseShell = obtain;
            obtain.setOnClickListener(this.onClickListener);
            this.praiseShell.setPaddingLeft(AreaConst.FEED_INTERVAL);
            this.praiseShell.setParent(this);
            SubAreaShell subAreaShell2 = this.praiseShell;
            int i3 = AreaConst.dp7;
            subAreaShell2.setPaddingTop(i3);
            this.praiseShell.setPaddingBottom(i3);
        }
        setAttachArea(businessFeedData);
        return z16;
    }

    public VisitAndPraiseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paddingTop = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseListView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 30) {
                    VisitAndPraiseListView visitAndPraiseListView = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView.isIntrest) {
                        visitAndPraiseListView.onFeedElementClickListener.onClick(visitAndPraiseListView, FeedElement.VISIT, visitAndPraiseListView.feedPosition, visitAndPraiseListView.visitInfo);
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 25) {
                    VisitAndPraiseListView visitAndPraiseListView2 = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView2.isIntrest) {
                        if (textCell instanceof UserNameCell) {
                            long longValue = ((UserNameCell) textCell).getUin().longValue();
                            VisitAndPraiseListView visitAndPraiseListView3 = VisitAndPraiseListView.this;
                            visitAndPraiseListView3.onFeedElementClickListener.onClick(visitAndPraiseListView3, FeedElement.FRIEND_NICKNAME, visitAndPraiseListView3.feedPosition, Long.valueOf(longValue));
                            if (VisitAndPraiseListView.this.mIsGoods) {
                                com.qzone.adapter.feedcomponent.i.H().a2(VisitAndPraiseListView.this.mGoodsType);
                                return;
                            }
                            return;
                        }
                        visitAndPraiseListView2.onFeedElementClickListener.onClick(visitAndPraiseListView2, FeedElement.PRAISE_LIST, visitAndPraiseListView2.feedPosition, null);
                        return;
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener == null || subAreaShell.getType() != 59) {
                    return;
                }
                ClickedPoint clickedPoint = new ClickedPoint(subAreaShell.getLeft(), subAreaShell.getTop(), 0, 0, subAreaShell.getWidth(), subAreaShell.getHeight());
                VisitAndPraiseListView visitAndPraiseListView4 = VisitAndPraiseListView.this;
                visitAndPraiseListView4.onFeedElementClickListener.onClick(visitAndPraiseListView4, FeedElement.DROPDOWN_BUTTON, visitAndPraiseListView4.feedPosition, clickedPoint);
            }
        };
    }

    public VisitAndPraiseListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.paddingTop = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        this.onClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.VisitAndPraiseListView.1
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 30) {
                    VisitAndPraiseListView visitAndPraiseListView = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView.isIntrest) {
                        visitAndPraiseListView.onFeedElementClickListener.onClick(visitAndPraiseListView, FeedElement.VISIT, visitAndPraiseListView.feedPosition, visitAndPraiseListView.visitInfo);
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener != null && subAreaShell.getType() == 25) {
                    VisitAndPraiseListView visitAndPraiseListView2 = VisitAndPraiseListView.this;
                    if (!visitAndPraiseListView2.isIntrest) {
                        if (textCell instanceof UserNameCell) {
                            long longValue = ((UserNameCell) textCell).getUin().longValue();
                            VisitAndPraiseListView visitAndPraiseListView3 = VisitAndPraiseListView.this;
                            visitAndPraiseListView3.onFeedElementClickListener.onClick(visitAndPraiseListView3, FeedElement.FRIEND_NICKNAME, visitAndPraiseListView3.feedPosition, Long.valueOf(longValue));
                            if (VisitAndPraiseListView.this.mIsGoods) {
                                com.qzone.adapter.feedcomponent.i.H().a2(VisitAndPraiseListView.this.mGoodsType);
                                return;
                            }
                            return;
                        }
                        visitAndPraiseListView2.onFeedElementClickListener.onClick(visitAndPraiseListView2, FeedElement.PRAISE_LIST, visitAndPraiseListView2.feedPosition, null);
                        return;
                    }
                }
                if (VisitAndPraiseListView.this.onFeedElementClickListener == null || subAreaShell.getType() != 59) {
                    return;
                }
                ClickedPoint clickedPoint = new ClickedPoint(subAreaShell.getLeft(), subAreaShell.getTop(), 0, 0, subAreaShell.getWidth(), subAreaShell.getHeight());
                VisitAndPraiseListView visitAndPraiseListView4 = VisitAndPraiseListView.this;
                visitAndPraiseListView4.onFeedElementClickListener.onClick(visitAndPraiseListView4, FeedElement.DROPDOWN_BUTTON, visitAndPraiseListView4.feedPosition, clickedPoint);
            }
        };
    }
}
