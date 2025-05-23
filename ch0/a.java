package ch0;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.ecommerce.base.ui.customview.PTSRichTextNativeView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends PTSNodeTextBase implements com.tencent.pts.ui.view.a {

    /* renamed from: a, reason: collision with root package name */
    private Object f30838a;

    /* compiled from: P */
    /* renamed from: ch0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0192a implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSRichTextNativeView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new a(pTSAppInstance);
        }
    }

    public a(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, PTSConstant.VNT_RICH_TEXT, "");
        resetStyleParser();
    }

    private JSONArray getRichData(Object obj) {
        if (obj instanceof String) {
            try {
                return new JSONArray((String) obj);
            } catch (JSONException unused) {
                Log.i("PTSNodeRichText", "[setAttribute], value = $value parse failed");
                return null;
            }
        }
        return null;
    }

    private void resetStyleParser() {
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79867a = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79868b = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79869c = 0;
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f79870d = 0;
    }

    private void setRichText() {
        if (this.f30838a instanceof JSONArray) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            RichTextParser.parse((TextView) getView(), spannableStringBuilder, this.f30838a);
            ((TextView) getView()).setText(spannableStringBuilder);
            ((TextView) getView()).setGravity(48);
        }
    }

    @Override // com.tencent.pts.ui.view.a
    public float[] getRichTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        float f16;
        PTSLog.d("PTSNodeRichText", "[getRichTextMeasuredSize] constrainedSize = " + Arrays.toString(fArr) + ", content = " + str + ", fontSize = " + str2 + ", lineHeight = " + str3 + ", lineClamp = " + str4 + ", fontWeight = " + str5 + ", fontFamily = " + str6 + ", richTextNode = " + str7);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.h(PTSConfig.getApplicationContext(), getRichData(str7), spannableStringBuilder);
        float parseFloat = Float.parseFloat(str2);
        float parseFloat2 = Float.parseFloat(str3);
        float px2dp = PTSDeviceUtil.px2dp((float) com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.e());
        float max = Math.max(parseFloat2, PTSDeviceUtil.px2dp((float) com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.g()));
        float f17 = (float) com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a.f();
        float f18 = parseFloat2 - parseFloat;
        float f19 = parseFloat2 * f17;
        float[] textMeasuredSize = PTSNodeFactory.getTextMeasuredSize(fArr, spannableStringBuilder, String.valueOf(px2dp), String.valueOf(max), String.valueOf(f17), str5);
        if (textMeasuredSize != null && textMeasuredSize.length >= 2) {
            if (fArr != null && fArr.length >= 2) {
                textMeasuredSize[0] = Math.max(textMeasuredSize[0], fArr[0]);
            }
            float f26 = textMeasuredSize[1];
            if (f26 < f19) {
                f16 = f26 + f18;
            } else {
                f16 = f19 + f18;
            }
            textMeasuredSize[1] = f16;
        }
        return textMeasuredSize;
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        Log.i("PTSNodeRichText", "[onParseValueFinished]");
        setRichText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        if ("nodes".equals(str)) {
            this.f30838a = getRichData(obj);
        }
        return super.setAttribute(str, obj);
    }
}
