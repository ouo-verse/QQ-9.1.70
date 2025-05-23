package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RichNativeText extends NativeText {
    private static final String TAG = "RichNativeText";
    private Object richData;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new RichNativeText(vafContext);
        }
    }

    public RichNativeText(VafContext vafContext) {
        super(vafContext);
        this.mTextSize = Utils.dp2px(16.0d);
    }

    private void setRichText() {
        if (this.richData instanceof JSONArray) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            RichTextParser.parse(this.mNative, spannableStringBuilder, this.richData);
            setRealText(spannableStringBuilder);
            this.mNative.setTruncateAttr(RichTextParser.getTruncate());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean onClick() {
        if (this.mNative.isHyperLinkClick()) {
            this.mNative.setHyperLinkClick(false);
            return true;
        }
        return super.onClick();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        setRichText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, Object obj) {
        if (i3 == 66) {
            if (obj instanceof JSONArray) {
                this.richData = obj;
                return true;
            }
            return true;
        }
        return super.setAttribute(i3, obj);
    }
}
