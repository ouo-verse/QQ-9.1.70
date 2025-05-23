package com.qzone.proxy.feedcomponent.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.uihierarchy.TextViewCompat;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellTextView extends View implements TouchBehaviorListener, TextLayoutBase, TextViewCompat {
    protected static final long LONG_CLICK_TRIG_TIME = 600;
    protected boolean cellClickable;
    protected boolean drawBackground;
    protected String fontFamily;
    private boolean hasAttached;
    protected boolean isLongClicked;
    private Handler longClickHandler;
    protected boolean longClickTrig;
    protected Context mContext;
    protected d mPreDecorateListener;
    protected TextCellLayout.OnCellClickListener onCellClickListener;
    protected View.OnClickListener onClickListener;
    protected Paint paint;
    protected int styleIndex;
    protected ArrayList<TextCell> text;
    protected int textColor;
    protected int textColorLink;
    protected ColorStateList textColorLinkList;
    protected ColorStateList textColorList;
    protected TextCellLayout textLayout;
    protected OnTextOperater textOperator;
    protected TextCell touchTarget;
    protected int typefaceIndex;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnTextOperater {
        void onCancle();

        void onCopy();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements OnTextOperater {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView cellTextView = CellTextView.this;
            cellTextView.isLongClicked = false;
            cellTextView.postInvalidate();
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView cellTextView = CellTextView.this;
            cellTextView.copyText(cellTextView.getCopiedText());
            CellTextView cellTextView2 = CellTextView.this;
            cellTextView2.isLongClicked = false;
            cellTextView2.postInvalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            CellTextView cellTextView = CellTextView.this;
            cellTextView.isLongClicked = true;
            cellTextView.postInvalidate();
            CellTextView cellTextView2 = CellTextView.this;
            TextCellLayout.OnCellClickListener onCellClickListener = cellTextView2.onCellClickListener;
            if (!(onCellClickListener != null ? onCellClickListener.onLongClick(cellTextView2, cellTextView2.textOperator) : false)) {
                CellTextView cellTextView3 = CellTextView.this;
                com.qzone.widget.util.b.h(cellTextView3.mContext, cellTextView3.textOperator);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CellTextView cellTextView = CellTextView.this;
            cellTextView.longClickTrig = true;
            cellTextView.onInvoke(6, message.arg1, message.arg2, 0);
            CellTextView cellTextView2 = CellTextView.this;
            TextCell textCell = cellTextView2.touchTarget;
            cellTextView2.initTextCellLayout();
            CellTextView.this.textLayout.clearTouchTarget();
            CellTextView.this.touchTarget = textCell;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface d {
        List<TextCell> a(List<TextCell> list);
    }

    public CellTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.paint = new Paint(1);
        this.isLongClicked = false;
        this.textColor = -16777216;
        this.textColorLink = -16711936;
        this.textColorList = null;
        this.textColorLinkList = null;
        this.longClickTrig = false;
        this.cellClickable = true;
        this.drawBackground = false;
        this.fontFamily = null;
        this.typefaceIndex = -1;
        this.styleIndex = -1;
        this.textOperator = new a();
        this.longClickHandler = new c(Looper.getMainLooper());
        this.mContext = null;
        this.hasAttached = false;
        init(context, attributeSet, i3);
    }

    private void attachStateChangeToParent() {
        if (this.hasAttached) {
            return;
        }
        this.hasAttached = true;
        ViewParent parent = getParent();
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setAddStatesFromChildren(true);
            parent = viewGroup.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCopiedText() {
        initTextCellLayout();
        return this.textLayout.getCopiedText();
    }

    private void handleWindowGone() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onPause();
        }
    }

    private void handleWindowVisible() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onResume();
        }
    }

    public void addLeftDrawable(Drawable drawable, int i3) {
        initTextCellLayout();
        this.textLayout.addLeftDrawable(drawable, i3);
    }

    public void addRightDrawable(Drawable drawable, int i3) {
        initTextCellLayout();
        this.textLayout.addRightDrawable(drawable, i3);
    }

    public void copyText(String str) {
        try {
            ((ClipboardManager) getContext().getSystemService("clipboard")).setText(str);
            QQToast.makeText(getContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f"), 0).show();
        } catch (Exception unused) {
        }
    }

    protected List<TextCell> decorateTextCell(ArrayList<TextCell> arrayList) {
        d dVar = this.mPreDecorateListener;
        return dVar != null ? dVar.a(arrayList) : arrayList;
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.textColorLinkList;
        if (colorStateList != null) {
            this.textColorLink = colorStateList.getColorForState(getDrawableState(), this.textColorLink);
            invalidate();
        }
        ColorStateList colorStateList2 = this.textColorList;
        if (colorStateList2 != null) {
            this.textColor = colorStateList2.getColorForState(getDrawableState(), this.textColor);
            invalidate();
        }
    }

    public void forceRequestLayout() {
        initTextCellLayout();
        this.textLayout.forceRequestLayout();
        requestLayout();
    }

    protected int getCellHeight(TextCell textCell) {
        initTextCellLayout();
        return textCell.getHeight(this.textLayout.getPaint());
    }

    public float getCellWidth(TextCell textCell) {
        initTextCellLayout();
        return textCell.getWidth(this.textLayout.getPaint());
    }

    public String getDisplayedText() {
        initTextCellLayout();
        return this.textLayout.getDisplayedText();
    }

    public int getLineCount() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            return textCellLayout.getLineCount();
        }
        return 0;
    }

    public int getLineHeight() {
        initTextCellLayout();
        return this.textLayout.getLineHeight();
    }

    public OnTextOperater getOnTextOperator() {
        return this.textOperator;
    }

    public Paint getPaint() {
        initTextCellLayout();
        return this.textLayout.getPaint();
    }

    public float getTextSize() {
        initTextCellLayout();
        return this.textLayout.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet, int i3) {
        initTextCellLayout();
        setDrawBackground(this.drawBackground);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CellTextView, i3, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < indexCount; i26++) {
            int index = obtainStyledAttributes.getIndex(i26);
            if (index == 0) {
                setTextSize(obtainStyledAttributes.getDimensionPixelSize(index, (int) ViewUtils.getSpValue(13.0f)));
            } else if (index == 3) {
                int resourceId = obtainStyledAttributes.getResourceId(3, -1);
                if (resourceId == -1) {
                    setTextColor(obtainStyledAttributes.getColor(index, this.textColor));
                } else {
                    setTextColor(getResources().getColor(resourceId));
                }
            } else if (index == 16) {
                if (obtainStyledAttributes.getBoolean(index, false)) {
                    setMaxLine(1);
                }
            } else if (index == 10) {
                setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == 15) {
                setMaxLine(obtainStyledAttributes.getInt(index, -1));
            } else if (index == 14) {
                setText(obtainStyledAttributes.getString(index));
            } else if (index == 2) {
                this.styleIndex = obtainStyledAttributes.getInt(index, -1);
            } else if (index == 1) {
                this.typefaceIndex = obtainStyledAttributes.getInt(index, -1);
            } else if (index == 18) {
                this.fontFamily = obtainStyledAttributes.getString(index);
            } else if (index == 6) {
                i16 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 8) {
                i18 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 7) {
                i17 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 9) {
                i19 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            }
        }
        setPadding(i16, i17, i18, i19);
        obtainStyledAttributes.recycle();
        setTextStyle(this.fontFamily, this.typefaceIndex, this.styleIndex);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTextCellLayout() {
        if (this.textLayout == null) {
            this.textLayout = new TextCellLayout(this);
        }
        this.textLayout.attachView(this);
    }

    public boolean isFinished() {
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public boolean isLongClickTrig() {
        return this.longClickTrig;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initTextCellLayout();
        this.textLayout.draw(this, canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        jo.h hVar = jo.h.f410717a;
        hVar.g("cell_text_measure").f(this);
        initTextCellLayout();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0 && size == 0) {
            i3 = Integer.MIN_VALUE;
        }
        this.textLayout.measure(i3, i16);
        setMeasuredDimension(this.textLayout.getMeausredWidth(), this.textLayout.getMeausredHeight());
        setContentDescription(getDisplayedText());
        hVar.g("cell_text_measure").a(this);
    }

    public void onStateIdle() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onStateIdle();
        }
    }

    public void onStateScrolling() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onStateScrolling();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        initTextCellLayout();
        return this.textLayout.onTouchEvent(motionEvent, this.longClickHandler);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 == 0) {
            handleWindowVisible();
        } else if (i3 == 8) {
            handleWindowGone();
        }
    }

    public ArrayList<TextCell> parseContent(CharSequence charSequence) {
        return parseContent(charSequence, true);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellLongClick() {
        Handler handler = this.longClickHandler;
        handler.sendMessageDelayed(handler.obtainMessage(0), 600L);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void postRequestLayout() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.a
            @Override // java.lang.Runnable
            public final void run() {
                CellTextView.this.requestLayout();
            }
        });
    }

    @Override // android.view.View, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void requestLayout() {
        initTextCellLayout();
        this.textLayout.requestLayout();
        super.requestLayout();
    }

    public void resetSideDrawables() {
        initTextCellLayout();
        this.textLayout.resetSideDrawables();
    }

    public void setBarrageEffect(boolean z16, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        initTextCellLayout();
        this.textLayout.setBarrageEffect(z16, barrageEffectInfo);
    }

    public void setCellClickable(boolean z16) {
        this.cellClickable = z16;
        initTextCellLayout();
        this.textLayout.setCellClickable(z16);
    }

    @Override // android.view.View
    public void setClickable(boolean z16) {
        super.setClickable(z16);
        initTextCellLayout();
        this.textLayout.setClickable(z16);
    }

    public void setColorBackground(int i3) {
        initTextCellLayout();
        this.textLayout.setColorBackground(i3);
    }

    public void setDrawBackground(boolean z16) {
        initTextCellLayout();
        this.textLayout.setDrawBackground(z16);
    }

    public void setDrawablePadding(int i3) {
        initTextCellLayout();
        this.textLayout.setDrawablePadding(i3);
    }

    public void setEllipsisStr(String str) {
        initTextCellLayout();
        this.textLayout.setEllipsisStr(str);
    }

    public void setFakeFeed(boolean z16) {
        initTextCellLayout();
        this.textLayout.setFakeFeed(z16);
    }

    public void setFont(int i3, String str, int i16) {
        setFont(i3, str, i16, null);
    }

    public void setFontBgVisible(boolean z16) {
        initTextCellLayout();
        this.textLayout.setFontBgVisible(z16);
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        initTextCellLayout();
        this.textLayout.setGradientColor(iArr, fArr, orientation);
    }

    public void setHasMore(boolean z16) {
        initTextCellLayout();
        this.textLayout.setHasMore(z16);
    }

    public void setLineBreakInContent(boolean z16) {
        initTextCellLayout();
        this.textLayout.setLineBreakInContent(z16);
    }

    public void setLineBreakNeeded(boolean z16) {
        initTextCellLayout();
        this.textLayout.setLineBreakNeeded(z16);
    }

    public void setLineSpace(int i3) {
        initTextCellLayout();
        this.textLayout.setLineSpace(i3);
        invalidate();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void setLongClickTrig(boolean z16) {
        this.longClickTrig = z16;
    }

    public void setLongclickable(boolean z16) {
        this.textLayout.setLongclickable(z16);
        if (z16) {
            setOnLongClickListener(new b());
        }
    }

    public void setMaxCommentLine(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setMaxCommentLine(i3, true);
        }
    }

    public void setMaxLine(int i3) {
        initTextCellLayout();
        this.textLayout.setMaxLine(i3);
    }

    public void setMaxWidth(int i3) {
        initTextCellLayout();
        this.textLayout.setMaxWidth(i3);
    }

    public void setMeasuredTextCacheEnabled(boolean z16) {
        initTextCellLayout();
        this.textLayout.setMeasuredTextCacheEnabled(z16);
    }

    public void setMoreCellColor(int i3) {
        initTextCellLayout();
        this.textLayout.setMoreCellColor(i3);
        invalidate();
    }

    public void setNinePatchBackground(int i3) {
        this.textLayout.setNinePatchBackground(i3);
    }

    public void setOnCellClickListener(TextCellLayout.OnCellClickListener onCellClickListener) {
        this.onCellClickListener = onCellClickListener;
        initTextCellLayout();
        this.textLayout.setOnCellClickListener(onCellClickListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.onClickListener = onClickListener;
    }

    public void setOnSideDrawableClickListener(TextCellLayout.i iVar) {
        initTextCellLayout();
        this.textLayout.setOnSideDrawableClickListener(iVar);
    }

    public void setOnTextOperateListener(OnTextOperater onTextOperater) {
        this.textOperator = onTextOperater;
    }

    public void setOuterListener(com.qzone.proxy.feedcomponent.text.font.a aVar) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setOuterListener(aVar);
        }
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        initTextCellLayout();
        this.textLayout.setPadding(i3, i16, i17, i18);
    }

    public void setPreDecorateListener(d dVar) {
        this.mPreDecorateListener = dVar;
    }

    public ArrayList<TextCell> setRichText(CharSequence charSequence, boolean z16) {
        ArrayList<TextCell> parseContent = parseContent(charSequence, z16);
        if (this.text == null) {
            this.text = new ArrayList<>();
        }
        this.text.clear();
        this.text.addAll(decorateTextCell(parseContent));
        initTextCellLayout();
        this.textLayout.setText(this.text);
        requestLayout();
        invalidate();
        return parseContent;
    }

    public void setShadowLayer(int i3, int i16, int i17, int i18) {
        initTextCellLayout();
        this.textLayout.setShadowLayer(i3, i16, i17, i18);
    }

    public void setShowMore(boolean z16) {
        initTextCellLayout();
        this.textLayout.setShowMore(z16);
    }

    public void setShowMoreTextColor(int i3) {
        initTextCellLayout();
        this.textLayout.setShowMoreTextColor(i3);
    }

    public void setShowMoreTextSize(float f16) {
        initTextCellLayout();
        this.textLayout.setShowMoreTextSize(f16);
    }

    public void setShowMoreTextUnClickable(boolean z16) {
        initTextCellLayout();
        this.textLayout.setShowMoreTextUnClickable(z16);
    }

    public void setText(int i3) {
        setText(getResources().getString(i3));
    }

    public void setTextBold(boolean z16) {
        initTextCellLayout();
        this.textLayout.setTextBold(z16);
    }

    public void setTextCells(ArrayList<TextCell> arrayList) {
        if (this.text == null) {
            this.text = new ArrayList<>();
        }
        this.text.clear();
        this.text.addAll(decorateTextCell(arrayList));
        initTextCellLayout();
        this.textLayout.setText(this.text);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i3) {
        initTextCellLayout();
        this.textLayout.setTextColor(i3);
        invalidate();
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        initTextCellLayout();
        this.textLayout.setTextColorAnimation(arrayList, i3);
    }

    public void setTextColorLink(int i3) {
        initTextCellLayout();
        this.textColorLink = i3;
        this.textLayout.setTextColorLink(i3);
        invalidate();
    }

    public void setTextColorLinkBackground(int i3) {
        initTextCellLayout();
        this.textLayout.setTextColorLinkBackground(i3);
    }

    public void setTextGravity(int i3) {
        initTextCellLayout();
        this.textLayout.setTextGravity(i3);
    }

    public void setTextInType(int i3) {
        initTextCellLayout();
        this.textLayout.setTextSizeType(i3);
    }

    public void setTextSize(float f16) {
        initTextCellLayout();
        this.textLayout.setTextSize(f16);
        requestLayout();
        invalidate();
    }

    public void setTextStyle(String str, int i3, int i16) {
        this.textLayout.setTypefaceFromAttrs(str, i3, i16);
    }

    public void setUseSoftLineBreak(boolean z16) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setUseSoftLineBreak(z16);
        }
    }

    public void setUserNameRichText(TextCell textCell, CharSequence charSequence) {
        setRichText(charSequence);
        ArrayList<TextCell> arrayList = this.text;
        if (arrayList != null) {
            arrayList.add(0, textCell);
            requestLayout();
            invalidate();
        }
    }

    public void setmutiRichText(ArrayList<TextCell> arrayList, CharSequence charSequence) {
        setRichText(charSequence);
        ArrayList<TextCell> arrayList2 = this.text;
        if (arrayList2 != null) {
            arrayList2.addAll(0, arrayList);
            requestLayout();
            invalidate();
        }
    }

    @Override // com.tencent.mobileqq.utils.uihierarchy.TextViewCompat
    public String getText() {
        initTextCellLayout();
        return this.textLayout.getText();
    }

    public ArrayList<TextCell> parseContent(CharSequence charSequence, boolean z16) {
        return TextCellParser.parseContent(this, charSequence, this.textLayout.getFontHeight(getTextSize()), this.cellClickable, z16);
    }

    public void setFont(int i3, String str, int i16, String str2) {
        initTextCellLayout();
        this.textLayout.setFont(i3, str, i16, str2);
    }

    public void setText(String str) {
        ArrayList<TextCell> arrayList = new ArrayList<>();
        this.text = arrayList;
        arrayList.add(new TextCell(0, str));
        initTextCellLayout();
        this.textLayout.setText(this.text);
        requestLayout();
        invalidate();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TouchBehaviorListener
    public boolean onInvoke(int i3, float f16, float f17, int i16) {
        try {
            if (i3 == 0) {
                return performClick();
            }
            if (6 == i3) {
                return performLongClick();
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellClick(TextCell textCell) {
        if (textCell == null) {
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this);
                return;
            }
            return;
        }
        TextCellLayout.OnCellClickListener onCellClickListener = this.onCellClickListener;
        if (onCellClickListener != null) {
            onCellClickListener.onClick(textCell, this);
        }
    }

    public static void setCanCopy(ArrayList<TextCell> arrayList, boolean z16) {
        if (arrayList == null) {
            return;
        }
        Iterator<TextCell> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setCanCopy(z16);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        initTextCellLayout();
        this.textLayout.setTextColor(colorStateList);
        drawableStateChanged();
        invalidate();
    }

    public void setTextColorLink(ColorStateList colorStateList) {
        initTextCellLayout();
        this.textLayout.setTextColorLink(colorStateList);
        drawableStateChanged();
        invalidate();
    }

    public void setTextSize(int i3, float f16) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
        if (applyDimension != getTextSize()) {
            setTextSize(applyDimension);
        }
    }

    public void setText(ArrayList<TextCell> arrayList) {
        this.text = arrayList;
        initTextCellLayout();
        this.textLayout.setText(arrayList);
        requestLayout();
        invalidate();
    }

    public ArrayList<TextCell> setRichText(CharSequence charSequence) {
        return setRichText(charSequence, true);
    }

    private String getModeStr(int i3) {
        if (i3 == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i3 == 0) {
            return "UNSPECIFIED";
        }
        if (i3 != 1073741824) {
            return "";
        }
        return "EXACTLY";
    }

    public void setRichText(CharSequence charSequence, int i3, int i16, int i17) {
        setRichText(charSequence);
    }

    public void setText(TextCell textCell) {
        ArrayList<TextCell> arrayList = new ArrayList<>();
        this.text = arrayList;
        arrayList.add(textCell);
        initTextCellLayout();
        this.textLayout.setText(textCell);
        requestLayout();
        invalidate();
    }

    public CellTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint(1);
        this.isLongClicked = false;
        this.textColor = -16777216;
        this.textColorLink = -16711936;
        this.textColorList = null;
        this.textColorLinkList = null;
        this.longClickTrig = false;
        this.cellClickable = true;
        this.drawBackground = false;
        this.fontFamily = null;
        this.typefaceIndex = -1;
        this.styleIndex = -1;
        this.textOperator = new a();
        this.longClickHandler = new c(Looper.getMainLooper());
        this.mContext = null;
        this.hasAttached = false;
        init(context, attributeSet, 0);
    }

    public void clearText() {
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public View getAttachedView() {
        return this;
    }

    public void reset() {
    }

    public void setParseUrl(boolean z16) {
    }

    public void setUrlColorRes(int i3) {
    }

    public CellTextView(Context context) {
        super(context);
        this.paint = new Paint(1);
        this.isLongClicked = false;
        this.textColor = -16777216;
        this.textColorLink = -16711936;
        this.textColorList = null;
        this.textColorLinkList = null;
        this.longClickTrig = false;
        this.cellClickable = true;
        this.drawBackground = false;
        this.fontFamily = null;
        this.typefaceIndex = -1;
        this.styleIndex = -1;
        this.textOperator = new a();
        this.longClickHandler = new c(Looper.getMainLooper());
        this.mContext = null;
        this.hasAttached = false;
        init(context, null, 0);
    }
}
