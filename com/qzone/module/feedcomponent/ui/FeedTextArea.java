package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.module.feedcomponent.ui.common.AccessibleArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedTextArea extends SubArea implements TextLayoutBase, AccessibleArea, DittoTextAreaCompat {
    public static final int lineSpace = (int) (FeedGlobalEnv.g().getDensity() * 2.0f);
    ViewArea.OnAreaClickedListener clickListener;
    protected int fontSizeType;
    boolean isTruncated;
    int lineHeight;
    int linePos;
    protected ArrayList<TextCell> mCells;
    float mDensity;
    int mFontHeight;
    protected Paint paint;
    protected int textColor;
    TextCellLayout textLayout;
    int verPos;
    final ArrayList<Integer> lineHeights = new ArrayList<>();
    RectF highLightFrame = new RectF();
    int virtualId = -1;
    private float letterSpacing = 0.0f;
    int linebreakSeq = 1048576;
    protected int textColorLink = com.qzone.adapter.feedcomponent.j.I();
    int textColorLinkPress = -1;
    int textColorLinkBackground = 855638016;
    protected boolean cellClickable = true;
    boolean isLineBreakNeeded = true;
    private int mMaxLines = -1;

    public FeedTextArea(int i3) {
        this.textColor = -16777216;
        this.mType = i3;
        this.paint = AreaManager.getInstance().getPaintForTextArea(i3);
        this.textLayout = new TextCellLayout(this, this.paint);
        this.textColor = com.qzone.adapter.feedcomponent.j.o();
        this.mDensity = FeedGlobalEnv.getContext().getResources().getDisplayMetrics().density;
    }

    public static int measureText(String str, float f16) {
        FeedTextArea feedTextArea = new FeedTextArea(257);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(FeedGlobalEnv.g().getScreenWidth(), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(FeedGlobalEnv.g().getScreenHeight(), Integer.MIN_VALUE);
        feedTextArea.setRichText(str);
        feedTextArea.setTextSize(f16);
        feedTextArea.measure(makeMeasureSpec, makeMeasureSpec2);
        return feedTextArea.mWidth;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        return this.textLayout.draw(this, canvas);
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public int getAreaId() {
        return this.virtualId;
    }

    public float getCellWidth(TextCell textCell) {
        Paint paint = this.paint;
        if (paint != null) {
            return textCell.getWidth(paint);
        }
        return 0.0f;
    }

    public ArrayList<TextCell> getCells() {
        return this.mCells;
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public String getContentDescription() {
        return getDisplayedText();
    }

    public String getDisplayedText() {
        return this.textLayout.getDisplayedText();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public int getLineCount() {
        return this.textLayout.getLineCount();
    }

    public int getLineHeight() {
        return this.textLayout.getLineHeight();
    }

    public int getMeasuredHeight() {
        return this.textLayout.getMeausredHeight();
    }

    public int getMeasuredWidth() {
        return this.textLayout.getMeausredWidth();
    }

    public Paint getPaint() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            return textCellLayout.getPaint();
        }
        return null;
    }

    @Override // com.tencent.ditto.widget.DittoTextAreaCompat
    public String getText() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            return textCellLayout.getText();
        }
        return null;
    }

    public TextCellLayout getTextLayout() {
        return this.textLayout;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    public int getmFontHeight() {
        return this.mFontHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void invalidate() {
        super.invalidate();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public void onLongClick(ViewArea.OnAreaLongClickedListener onAreaLongClickedListener) {
        super.onLongClick(onAreaLongClickedListener);
        this.textLayout.clearTouchTarget();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        this.clickListener = subAreaShell;
        return this.textLayout.onTouchEvent(motionEvent, SubArea.longClickHandler);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellClick(TextCell textCell) {
        ViewArea.OnAreaClickedListener onAreaClickedListener = this.clickListener;
        if (onAreaClickedListener != null) {
            onAreaClickedListener.onAreaClicked(this, textCell);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellLongClick() {
        if (this.clickListener != null) {
            Handler handler = SubArea.longClickHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0, this), 600L);
        }
    }

    public int preMeasuewLine(int i3) {
        return this.textLayout.preMeasuewLine(i3);
    }

    public void recycleTextRes() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.recycleTextRes();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void requestLayout() {
        super.requestLayout();
    }

    public void resetTextAnimation() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.resetXuanDongAnimation();
        }
    }

    public void setAdditionEllipsizeWidth(int i3) {
        this.textLayout.setAdditionEllipsizeWidth(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public void setAreaId(int i3) {
        this.virtualId = i3;
    }

    public void setCellClickable(boolean z16) {
        this.textLayout.setCellClickable(z16);
    }

    public void setClickable(boolean z16) {
        this.textLayout.setClickable(z16);
    }

    public void setColorBackground(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setColorBackground(i3);
            this.textLayout.setDrawBackground(true);
        }
    }

    public void setContentChanged(boolean z16) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.requestLayout();
        }
    }

    public void setData(String str, int i3) {
        setRichText(str);
    }

    public void setEllipsisStr(String str) {
        this.textLayout.setEllipsisStr(str);
    }

    public void setFont(int i3, String str, int i16, String str2) {
        this.textLayout.setFont(i3, str, i16, str2);
    }

    void setFontHeight(float f16) {
        this.paint.setTextSize(f16);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        this.mFontHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.textLayout.setGradientColor(iArr, fArr, orientation);
    }

    public void setHasMore(boolean z16) {
        this.textLayout.setHasMore(z16);
    }

    public void setHasPressState(boolean z16) {
        this.textLayout.setDrawBackground(z16);
    }

    public void setIsNeedLineSpace(Boolean bool) {
        this.textLayout.setIsNeedLineSpace(bool);
    }

    public void setIsSpan(boolean z16) {
        this.textLayout.setIsSpan(z16);
    }

    public void setLetterSpacing(float f16) {
        this.letterSpacing = f16;
        this.textLayout.setLetterSpacing(f16);
    }

    public void setLineBreakNeeded(boolean z16) {
        this.isLineBreakNeeded = z16;
        this.textLayout.setLineBreakNeeded(z16);
    }

    public void setLineSpace(float f16) {
        this.textLayout.setLineSpace((int) f16);
    }

    public void setLinkColor(int i3) {
        this.textColorLink = i3;
        this.textLayout.setTextColorLink(i3);
    }

    public void setLinkColorBackground(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setTextColorLinkBackground(i3);
        }
    }

    public void setLongclickable(boolean z16) {
        this.textLayout.setLongclickable(z16);
    }

    public void setMaxLine(int i3) {
        this.textLayout.setMaxLine(i3);
        if (this.mMaxLines != i3) {
            this.textLayout.requestLayout();
        }
        this.mMaxLines = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void setMaxWidth(int i3) {
        this.textLayout.setMaxWidth(i3);
    }

    public void setMinLine(int i3) {
        this.textLayout.setMinLine(i3);
    }

    public void setPlainText(String str) {
        this.textLayout.setText(str);
    }

    public void setRichText(String str, boolean z16) {
        this.mCells = TextCellParser.parseContent(this, str, this.mFontHeight, this.cellClickable, z16);
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setText(this.mCells);
        this.textLayout.setDrawBackground(false);
    }

    public void setRichTextAndDrawbackground(String str, boolean z16) {
        setRichText(str);
        this.textLayout.setDrawBackground(z16);
    }

    public void setShadowLayer(int i3, int i16, int i17, int i18) {
        this.textLayout.setShadowLayer(i3, i16, i17, i18);
    }

    public void setShowMore(boolean z16) {
        this.textLayout.setShowMore(z16);
    }

    public void setShowPackOrUnpack(boolean z16) {
        this.textLayout.setShowPackOrUnpack(z16);
    }

    public void setSummaryMaxPack(int i3) {
        this.textLayout.setSummaryMaxPack(i3);
    }

    public void setSummaryMinPack(int i3) {
        this.textLayout.setSummaryMinPack(i3);
    }

    public void setSummaryPackOrUnpackDirect(int i3) {
        this.textLayout.setSummaryPackOrUnpackDirect(i3);
    }

    public void setSummaryPackShowLine(int i3) {
        this.textLayout.setSummaryPackShowLine(i3);
    }

    public void setTextBold(boolean z16) {
        this.textLayout.setTextBold(z16);
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
        this.textLayout.setTextColor(i3);
    }

    public void setTextColorAnimation(int i3, int i16, int i17) {
        this.textLayout.setTextColorAnimation(i3, i16, i17);
    }

    public void setTextGravity(int i3) {
        this.textLayout.setTextGravity(i3);
    }

    public void setTextInType(int i3) {
        this.fontSizeType = i3;
        this.textLayout.setTextSizeType(i3);
    }

    public void setTextSize(float f16) {
        float spValue = FeedGlobalEnv.g().getSpValue(f16);
        setFontHeight(spValue);
        this.textLayout.setTextSize(spValue);
    }

    public void setTextSizeInSp(float f16) {
        setFontHeight(f16);
        this.textLayout.setTextSize(f16);
    }

    public void setUseSoftLineBreak(boolean z16) {
        this.textLayout.setUseSoftLineBreak(z16);
    }

    public void clearClickListener() {
        this.clickListener = null;
        this.longClickedListener = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        setPressed(false);
        SubArea.longClickHandler.removeMessages(0);
        this.longClickTrig = false;
        this.textLayout.clearTouchTarget();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        this.isTruncated = false;
        this.textLayout.measure(i3, i16);
        this.mHeight = this.textLayout.getMeausredHeight();
        this.mWidth = this.textLayout.getMeausredWidth();
    }

    public void setData(String str, TextCell textCell) {
        setRichText(str, textCell, true);
    }

    public void setEllipsisStr(String str, int i3, float f16) {
        this.textLayout.setEllipsisStr(str, i3, f16);
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        this.textLayout.setTextColorAnimation(arrayList, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, ViewArea.OnAreaClickedListener onAreaClickedListener, boolean z16) {
        this.clickListener = onAreaClickedListener;
        return this.textLayout.onTouchEvent(motionEvent, SubArea.longClickHandler);
    }

    public void setData(String str, TextCell textCell, boolean z16) {
        setRichText(str, textCell, z16);
    }

    public void setData(String str, int i3, boolean z16) {
        setRichTextAndDrawbackground(str, z16);
    }

    public void setData(String str, int i3, int i16) {
        setRichText(str, i16);
    }

    public void setRichText(String str) {
        int i3 = AreaConst.dp17;
        int i16 = this.mFontHeight;
        if (i16 > 0) {
            i3 = i16;
        }
        if (this.fontSizeType == 1) {
            i3 = this.textLayout.getLargeFontSize() - com.qzone.proxy.feedcomponent.util.g.a(1.5f);
        }
        this.mCells = TextCellParser.parseContent(this, str, this.mFontHeight, this.cellClickable, true, i3);
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setText(this.mCells);
        this.textLayout.setDrawBackground(false);
    }

    public void setRichText(String str, TextCell textCell, boolean z16) {
        ArrayList<TextCell> arrayList;
        this.mCells = TextCellParser.parseContent(this, str, this.mFontHeight, this.cellClickable, z16);
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setText(this.mCells);
        this.textLayout.setDrawBackground(false);
        if (textCell == null || (arrayList = this.mCells) == null || arrayList.contains(textCell)) {
            return;
        }
        this.mCells.add(0, textCell);
    }

    public void setRichText(String str, int i3) {
        this.mCells = TextCellParser.parseContent(this, str, this.mFontHeight, this.cellClickable, true, i3);
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setText(this.mCells);
        this.textLayout.setDrawBackground(false);
    }

    public void updateNetEmoji() {
    }
}
