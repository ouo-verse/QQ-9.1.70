package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.view.a;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes33.dex */
public class PTSNodeRichText extends PTSNodeTextBase implements a {
    private static final String TAG = "PTSNodeRichText";
    private Object richData;

    /* loaded from: classes33.dex */
    public static class Builder implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSRichTextNativeView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new PTSNodeRichText(pTSAppInstance);
        }
    }

    protected PTSNodeRichText(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, PTSConstant.VNT_RICH_TEXT, null);
        resetStyleParser();
    }

    private JSONArray getRichData(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return new JSONArray((String) obj);
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "[setAttribute], value = $value parse failed");
            return null;
        }
    }

    private void setRichText() {
        if (this.richData instanceof JSONArray) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            RichTextParser.parse((PTSRichTextNativeView) getView(), spannableStringBuilder, this.richData);
            ((PTSRichTextNativeView) getView()).setText(spannableStringBuilder);
            ((PTSRichTextNativeView) getView()).setTruncateAttr(RichTextParser.getTruncate());
        }
    }

    @Override // com.tencent.pts.ui.view.a
    public float[] getRichTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            PTSLog.d(TAG, "[getRichTextMeasuredSize] constrainedSize = " + Arrays.toString(fArr) + ", content = " + str + ", fontSize = " + str2 + ", lineHeight = " + str3 + ", lineClamp = " + str4 + ", fontWeight = " + str5 + ", fontFamily = " + str6 + ", richTextNode = " + str7);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            try {
                com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.h(PTSConfig.getApplicationContext(), getRichData(str7), spannableStringBuilder);
                float parseFloat = Float.parseFloat(str2);
                float parseFloat2 = Float.parseFloat(str3);
                float px2dp = PTSDeviceUtil.px2dp(com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.e());
                float max = Math.max(parseFloat2, PTSDeviceUtil.px2dp(com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.g()));
                float f16 = com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f();
                float f17 = (parseFloat2 * f16) + (parseFloat2 - parseFloat);
                float[] textMeasuredSize = PTSNodeFactory.getTextMeasuredSize(fArr, spannableStringBuilder, String.valueOf(px2dp), String.valueOf(max), String.valueOf(f16), str5);
                if (textMeasuredSize != null && textMeasuredSize.length >= 2) {
                    textMeasuredSize[1] = Math.min(textMeasuredSize[1], f17);
                }
                return textMeasuredSize;
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "[getRichTextMeasuredSize], e = " + e);
                return new float[0];
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        setRichText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        if ("nodes".equals(str)) {
            this.richData = getRichData(obj);
        }
        return super.setAttribute(str, obj);
    }

    private void resetStyleParser() {
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79867a = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79868b = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79869c = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79870d = 0;
    }
}
