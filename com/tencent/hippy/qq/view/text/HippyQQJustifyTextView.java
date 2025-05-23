package com.tencent.hippy.qq.view.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.hippy.qq.view.text.HippyQQJustifyTextViewController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQJustifyTextView extends AppCompatTextView implements HippyViewBase {
    private static final String TAG = "HippyQQJustifyTextView";
    private final ArrayList<ChangeColorItem> changeColors;
    private int defaultTextColor;
    private String fontFamily;
    private String fontStyle;
    private int lineY;
    private int viewWidth;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ChangeColorItem {
        int color;
        int end;
        int start;

        public ChangeColorItem(int i3, int i16, int i17) {
            this.start = i3;
            this.end = i16;
            this.color = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface FunctionName {
        public static final String CHANGE_TEXT_COLOR = "changeTextColor";
    }

    public HippyQQJustifyTextView(Context context) {
        super(context);
        this.changeColors = new ArrayList<>();
    }

    private void changeTextColor(int i3, int i16, String str) {
        if (i3 >= 0 && i16 >= i3 && !TextUtils.isEmpty(str)) {
            try {
                this.changeColors.add(new ChangeColorItem(i3, i16, Color.parseColor(str)));
            } catch (IllegalArgumentException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    private void drawNormalText(Canvas canvas, int i3, String str) {
        float f16 = 0.0f;
        for (int i16 = 0; i16 < str.length(); i16++) {
            String valueOf = String.valueOf(str.charAt(i16));
            float desiredWidth = Layout.getDesiredWidth(valueOf, getPaint());
            getPaint().setColor(getCharColor(i3 + i16));
            canvas.drawText(valueOf, f16, this.lineY, getPaint());
            f16 += desiredWidth;
        }
    }

    private void drawScaledText(Canvas canvas, int i3, String str, float f16) {
        float length = (this.viewWidth - f16) / (str.length() - 1);
        float f17 = 0.0f;
        for (int i16 = 0; i16 < str.length(); i16++) {
            String valueOf = String.valueOf(str.charAt(i16));
            float desiredWidth = Layout.getDesiredWidth(valueOf, getPaint());
            getPaint().setColor(getCharColor(i3 + i16));
            canvas.drawText(valueOf, f17, this.lineY, getPaint());
            f17 += desiredWidth + length;
        }
    }

    private int getCharColor(int i3) {
        Iterator<ChangeColorItem> it = this.changeColors.iterator();
        while (it.hasNext()) {
            ChangeColorItem next = it.next();
            if (i3 >= next.start && i3 <= next.end) {
                return next.color;
            }
        }
        return this.defaultTextColor;
    }

    private boolean needScale(String str) {
        if (str == null || str.length() == 0 || str.charAt(str.length() - 1) == '\n') {
            return false;
        }
        return true;
    }

    private void resetFont() {
        if (TextUtils.isEmpty(this.fontFamily)) {
            return;
        }
        Typeface create = Typeface.create(this.fontFamily, new HippyQQJustifyTextViewController.FontStyleName(this.fontStyle).getStyle());
        if (create != null) {
            setTypeface(create);
        }
    }

    public void dispatchFunction(String str, HippyArray hippyArray, Promise promise) {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "dispatchFunction functionName:", str);
        }
        if (!TextUtils.isEmpty(str) && FunctionName.CHANGE_TEXT_COLOR.equals(str)) {
            changeTextColor(hippyArray.getInt(0), hippyArray.getInt(1), hippyArray.getString(2));
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getText() != null && getLayout() != null) {
            Layout layout = getLayout();
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.drawableState = getDrawableState();
            this.viewWidth = getMeasuredWidth();
            this.lineY = 0;
            this.lineY = (int) (0 + getTextSize());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil = (int) ((((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) * layout.getSpacingMultiplier()) + layout.getSpacingAdd());
            for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
                int lineStart = layout.getLineStart(i3);
                int lineEnd = layout.getLineEnd(i3);
                float desiredWidth = Layout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
                String substring = charSequence.substring(lineStart, lineEnd);
                if (i3 < layout.getLineCount() - 1) {
                    if (needScale(substring)) {
                        drawScaledText(canvas, lineStart, substring, desiredWidth);
                    } else {
                        drawNormalText(canvas, lineStart, substring);
                    }
                } else {
                    drawNormalText(canvas, lineStart, substring);
                }
                this.lineY += ceil;
            }
        }
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
        resetFont();
    }

    public void setFontStyle(String str) {
        this.fontStyle = str;
        resetFont();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        this.defaultTextColor = i3;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
