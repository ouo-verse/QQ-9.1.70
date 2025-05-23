package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.DrawUrlPicArea;
import com.qzone.module.feedcomponent.ui.FeedPicTextCardSmallTailView;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedEventTagSmallTailArea extends CanvasFeedEventTagArea {
    private static int ICON_PIC_SIZE = g.a(10.0f);
    private int mViewHeight;
    private int mViewMaxHeight;
    private int mViewMinHeight;

    public CanvasFeedEventTagSmallTailArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mViewHeight = g.a(20.0f);
        this.mViewMaxHeight = g.a(34.0f);
        this.mViewMinHeight = g.a(18.0f);
    }

    private void measureElements() {
        SubAreaShell subAreaShell = this.mLeftPicShell;
        if (subAreaShell != null) {
            subAreaShell.measure(0, 0);
            this.mLeftPicShell.setLeft(AreaConst.f48748dp3);
            this.mLeftPicShell.setTop(AreaConst.dp6_5);
        }
        SubAreaShell subAreaShell2 = this.mTitleShell;
        if (subAreaShell2 == null || this.mLeftPicShell == null) {
            return;
        }
        subAreaShell2.measure(0, this.mViewHeight);
        SubAreaShell subAreaShell3 = this.mTitleShell;
        int right = this.mLeftPicShell.getRight();
        int i3 = AreaConst.f48748dp3;
        subAreaShell3.setLeft(right + i3);
        this.mTitleShell.setTop(i3);
    }

    @Override // com.qzone.canvasui.widget.CanvasFeedEventTagArea
    protected void bindEventTagView(CellBottomRecomm cellBottomRecomm, View view) {
        int i3;
        PictureItem pictureItem;
        if (this.mLeftPic != null && (pictureItem = cellBottomRecomm.picinfo) != null && pictureItem.currentUrl != null) {
            int i16 = ICON_PIC_SIZE;
            PictureUrl pictureUrl = cellBottomRecomm.picinfo.currentUrl;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i16, i16, pictureUrl.pivotXRate, pictureUrl.pivotYRate);
            DrawUrlPicArea drawUrlPicArea = this.mLeftPic;
            PictureUrl pictureUrl2 = cellBottomRecomm.picinfo.currentUrl;
            String str = pictureUrl2.url;
            int i17 = ICON_PIC_SIZE;
            drawUrlPicArea.setData(str, i17, i17, normalFeedImageProcessor, pictureUrl2.imageUrl);
            SubAreaShell obtain = SubAreaShell.obtain(this.mLeftPic);
            this.mLeftPicShell = obtain;
            obtain.setParent(view);
            this.mSubAreaShellLists.add(this.mLeftPicShell);
        }
        FeedTextArea feedTextArea = this.mTitle;
        if (feedTextArea != null && cellBottomRecomm.title != null) {
            feedTextArea.setTextSize(12.0f);
            this.mTitle.setMaxLine(2);
            this.mTitle.setTextColor(FeedPicTextCardSmallTailView.sSmallTailTextColor);
            this.mTitle.setData(cellBottomRecomm.title, 0);
            if (this.mTitle.preMeasuewLine(CanvasFeedEventTagArea.VIEW_WIDTH) > 1) {
                i3 = this.mViewMaxHeight;
            } else {
                i3 = this.mViewMinHeight;
            }
            this.mViewHeight = i3;
            SubAreaShell obtain2 = SubAreaShell.obtain(this.mTitle);
            this.mTitleShell = obtain2;
            obtain2.setParent(view);
            this.mTitleShell.setMaxWidth(CanvasFeedEventTagArea.VIEW_WIDTH - this.mLeftPicShell.getRight());
            this.mSubAreaShellLists.add(this.mTitleShell);
        }
        measureElements();
    }

    @Override // com.qzone.canvasui.widget.CanvasFeedEventTagArea, com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getHeight() {
        return this.mViewHeight;
    }

    @Override // com.qzone.canvasui.widget.CanvasFeedEventTagArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        if (this.mSubAreaShellLists == null) {
            return;
        }
        Paint paint = new Paint();
        for (SubAreaShell subAreaShell : this.mSubAreaShellLists) {
            if (subAreaShell != null) {
                canvas.save();
                canvas.translate(subAreaShell.getLeft(), subAreaShell.getTop());
                subAreaShell.draw(canvas, paint);
                canvas.restore();
            }
        }
    }

    @Override // com.qzone.canvasui.widget.CanvasFeedEventTagArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(CanvasFeedEventTagArea.VIEW_WIDTH, this.mViewHeight);
    }
}
