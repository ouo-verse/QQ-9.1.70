package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;

/* loaded from: classes39.dex */
public class FeedPicTextCardSmallTailView extends FeedPicTextCardView {
    private static final String SMALL_TAIL_EVENT_TAG_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/bottomrecom_topic.png";
    private static final String SMALL_TAIL_PHOTO_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/bottomrecom_photo.png";
    protected DrawUrlPicArea mLeftPic;
    private int mViewHeight;
    private int mViewMaxHeight;
    private int mViewMinHeight;
    private static int ICON_PIC_SIZE = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
    public static int sSmallTailTextColor = Color.parseColor("#989EB4");

    public FeedPicTextCardSmallTailView(Context context) {
        super(context);
        this.mViewHeight = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
        this.mViewMaxHeight = com.qzone.proxy.feedcomponent.util.g.a(36.0f);
        this.mViewMinHeight = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
        this.mLeftPic = new DrawUrlPicArea();
    }

    private void measureElements() {
        SubAreaShell subAreaShell = this.mLeftPicShell;
        if (subAreaShell != null) {
            subAreaShell.measure(0, 0);
            this.mLeftPicShell.setLeft(AreaConst.dp0_5);
            this.mLeftPicShell.setTop(AreaConst.dp4_5);
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

    @Override // com.qzone.module.feedcomponent.ui.FeedPicTextCardView
    protected void bindBottomViewData(BusinessFeedData businessFeedData, CellBottomRecomm cellBottomRecomm, int i3) {
        int i16;
        PictureItem pictureItem;
        if (this.mSubAreaShellLists == null || cellBottomRecomm == null) {
            return;
        }
        if (this.mLeftPic != null && (pictureItem = cellBottomRecomm.picinfo) != null && pictureItem.currentUrl != null) {
            int i17 = ICON_PIC_SIZE;
            PictureUrl pictureUrl = cellBottomRecomm.picinfo.currentUrl;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i17, i17, pictureUrl.pivotXRate, pictureUrl.pivotYRate);
            String str = cellBottomRecomm.picinfo.currentUrl.url;
            int i18 = cellBottomRecomm.anonymity;
            if (i18 == CellBottomRecomm.TYPE_PHOTO) {
                str = SMALL_TAIL_PHOTO_URL;
            } else if (i18 == CellBottomRecomm.TYPE_EVENT_TAG) {
                str = SMALL_TAIL_EVENT_TAG_URL;
            }
            String str2 = str;
            DrawUrlPicArea drawUrlPicArea = this.mLeftPic;
            int i19 = ICON_PIC_SIZE;
            drawUrlPicArea.setData(str2, i19, i19, normalFeedImageProcessor, PictureUrl.calculateImageUrl(str2));
            SubAreaShell obtain = SubAreaShell.obtain(this.mLeftPic);
            this.mLeftPicShell = obtain;
            obtain.setParent(this);
            this.mSubAreaShellLists.add(this.mLeftPicShell);
        }
        FeedTextArea feedTextArea = this.mTitle;
        if (feedTextArea != null && cellBottomRecomm.title != null) {
            feedTextArea.setTextSize(12.0f);
            int i26 = businessFeedData.feedType != 2 ? 1 : 2;
            this.mTitle.setMaxLine(i26);
            this.mTitle.setTextColor(sSmallTailTextColor);
            this.mTitle.setData(cellBottomRecomm.title, 0);
            if (i26 != 1) {
                i26 = this.mTitle.preMeasuewLine(FeedPicTextCardView.VIEW_WIDTH);
            }
            if (i26 > 1) {
                i16 = this.mViewMaxHeight;
            } else {
                i16 = this.mViewMinHeight;
            }
            this.mViewHeight = i16;
            SubAreaShell obtain2 = SubAreaShell.obtain(this.mTitle);
            this.mTitleShell = obtain2;
            obtain2.setParent(this);
            this.mTitleShell.setMaxWidth(FeedPicTextCardView.VIEW_WIDTH - this.mLeftPicShell.getRight());
            this.mSubAreaShellLists.add(this.mTitleShell);
        }
        measureElements();
    }

    public int getViewHeight() {
        return this.mViewHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedPicTextCardView, android.view.View
    protected void onDraw(Canvas canvas) {
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
        if (this.isExposure) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().f(803, 0, 1);
        SmallTailReportUtil.reportBigSmallTailExpose();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedPicTextCardView, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(FeedPicTextCardView.VIEW_WIDTH, this.mViewHeight);
    }

    public FeedPicTextCardSmallTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewHeight = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
        this.mViewMaxHeight = com.qzone.proxy.feedcomponent.util.g.a(36.0f);
        this.mViewMinHeight = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
        this.mLeftPic = new DrawUrlPicArea();
    }

    public FeedPicTextCardSmallTailView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mViewHeight = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
        this.mViewMaxHeight = com.qzone.proxy.feedcomponent.util.g.a(36.0f);
        this.mViewMinHeight = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
        this.mLeftPic = new DrawUrlPicArea();
    }
}
