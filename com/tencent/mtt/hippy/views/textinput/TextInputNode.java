package com.tencent.mtt.hippy.views.textinput;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.flex.FlexMeasureMode;
import com.tencent.mtt.hippy.dom.flex.f;
import com.tencent.mtt.hippy.dom.flex.g;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.PixelUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TextInputNode extends TextNode implements f.a {
    private float[] mComputedPadding;
    private EditText mEditText;

    public TextInputNode(boolean z16) {
        super(z16);
        setMeasureFunction(this);
    }

    private int getMeasureSpec(float f16, FlexMeasureMode flexMeasureMode) {
        if (flexMeasureMode == FlexMeasureMode.EXACTLY) {
            return View.MeasureSpec.makeMeasureSpec((int) f16, 1073741824);
        }
        if (flexMeasureMode == FlexMeasureMode.AT_MOST) {
            return View.MeasureSpec.makeMeasureSpec((int) f16, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // com.tencent.mtt.hippy.dom.node.TextNode, com.tencent.mtt.hippy.dom.node.b
    public void layoutBefore(HippyEngineContext hippyEngineContext) {
        if (this.mEditText == null) {
            EditText editText = new EditText(ContextHolder.getAppContext());
            this.mEditText = editText;
            editText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            setDefaultPadding(4, this.mEditText.getPaddingLeft());
            setDefaultPadding(1, this.mEditText.getPaddingTop());
            setDefaultPadding(5, this.mEditText.getPaddingRight());
            setDefaultPadding(3, this.mEditText.getPaddingBottom());
            this.mComputedPadding = new float[]{getPadding(4), getPadding(1), getPadding(5), getPadding(3)};
        }
    }

    @Override // com.tencent.mtt.hippy.dom.flex.f.a
    public long measure(f fVar, float f16, FlexMeasureMode flexMeasureMode, float f17, FlexMeasureMode flexMeasureMode2) {
        EditText editText = this.mEditText;
        int i3 = this.mFontSize;
        if (i3 == -1) {
            i3 = (int) Math.ceil(PixelUtil.dp2px(14.0f));
        }
        editText.setTextSize(0, i3);
        this.mComputedPadding = new float[]{getPadding(4), getPadding(1), getPadding(5), getPadding(3)};
        this.mEditText.setPadding((int) Math.floor(getPadding(4)), (int) Math.floor(getPadding(1)), (int) Math.floor(getPadding(5)), (int) Math.floor(getPadding(3)));
        int i16 = this.mNumberOfLines;
        if (i16 != -1) {
            this.mEditText.setLines(i16);
        }
        this.mEditText.measure(getMeasureSpec(f16, flexMeasureMode), getMeasureSpec(f17, flexMeasureMode2));
        return g.a(this.mEditText.getMeasuredWidth(), this.mEditText.getMeasuredHeight());
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public void setPadding(int i3, float f16) {
        super.setPadding(i3, f16);
        this.mComputedPadding = new float[]{getPadding(4), getPadding(1), getPadding(5), getPadding(3)};
        markUpdated();
    }

    @Override // com.tencent.mtt.hippy.dom.node.TextNode, com.tencent.mtt.hippy.dom.node.b
    public void layoutAfter(HippyEngineContext hippyEngineContext) {
    }

    @Override // com.tencent.mtt.hippy.dom.node.TextNode, com.tencent.mtt.hippy.dom.node.b
    public void updateProps(HippyMap hippyMap) {
    }
}
