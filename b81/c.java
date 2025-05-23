package b81;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lb81/c;", "Lb81/a;", "", "text", "", "textSize", "", NodeProps.MAX_WIDTH, "b", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements a {
    private final int b(String text, float textSize, int maxWidth) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(textSize);
        StaticLayout build = StaticLayout.Builder.obtain(text, 0, text.length(), textPaint, maxWidth).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(text, 0, text.len\u2026lse)\n            .build()");
        if (build.getLineCount() > 2) {
            return 2;
        }
        return build.getLineCount();
    }

    @Override // b81.a
    public int a(@NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        if (!Intrinsics.areEqual(arkMsgModel.d() + arkMsgModel.e(), "com.tencent.multimsgcontact")) {
            return 0;
        }
        try {
            String m3 = arkMsgModel.m();
            JSONArray jSONArray = null;
            if (m3 != null) {
                jSONObject = new JSONObject(m3);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null && (jSONObject3 = jSONObject.getJSONObject("detail")) != null) {
                str = jSONObject3.getString("source");
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            float f16 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
            a.C7329a c7329a = a.C7329a.f192417a;
            float f17 = 15;
            float f18 = 9;
            int b16 = (int) (((((c7329a.b() / f16) - f17) - f17) - f18) - f18);
            if (b16 < 0) {
                QLog.e("ArkApp.MultiHeightHandler", 1, "heightWidth = " + b16 + " bubbleMaxWidth = " + c7329a.b() + " scale = " + f16);
                return 0;
            }
            int b17 = b(valueOf, 17.0f, b16);
            int i3 = b17 * 24;
            if (jSONObject != null && (jSONObject2 = jSONObject.getJSONObject("detail")) != null) {
                jSONArray = jSONObject2.getJSONArray("news");
            }
            if (jSONArray == null) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                String text = jSONArray.getJSONObject(i16).getString("text");
                Intrinsics.checkNotNullExpressionValue(text, "text");
                arrayList.add(text);
            }
            a.C7329a c7329a2 = a.C7329a.f192417a;
            int b18 = (int) (((((c7329a2.b() / f16) - 10) - f17) - f18) - f18);
            if (b18 < 0) {
                QLog.e("ArkApp.MultiHeightHandler", 1, "textWidth = " + b16 + " bubbleMaxWidth = " + c7329a2.b() + " scale = " + f16);
                return 0;
            }
            Iterator it = arrayList.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                i17 += b((String) it.next(), 13.0f, b18);
            }
            if (i17 > 4) {
                i17 = 4;
            }
            int i18 = i17 * 20;
            float f19 = (i18 + 57 + i3) * f16;
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.MultiHeightHandler", 1, "getAdjustedHeight height = " + f19 + " ,textLineCount = " + i17 + " , textHeight = " + i18 + " , headLineCount = " + b17 + ", headHeight = " + i3 + " ");
            }
            return (int) f19;
        } catch (JSONException e16) {
            QLog.e("ArkApp.MultiHeightHandler", 1, "parse json error = " + e16);
            return 0;
        }
    }
}
