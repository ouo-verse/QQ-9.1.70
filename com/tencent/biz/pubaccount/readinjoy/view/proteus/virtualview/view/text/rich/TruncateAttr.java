package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TruncateAttr {
    private static final String COLOR = "color";
    private static final String FONT_SIZE = "font-size";
    private static final String FONT_WEIGHT = "font-weight";
    private static final String HREF = "href";
    private static final String TAG = "TruncateAttr";
    private static final String TEXT = "text";
    public int color;
    public int fontSize;
    public String fontWeight;
    public String href;
    public String text;
    public double nodeRatio = 1.0d;
    public int maxLines = 100;
    public List<RichTextParser.CustomImageSpan> imageSpans = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TruncateAttr parseTruncate(JSONObject jSONObject) {
        int i3;
        Object size;
        if (jSONObject != null) {
            String optString = jSONObject.optString("text", "");
            String optString2 = jSONObject.optString("href", "");
            TruncateAttr truncateAttr = new TruncateAttr();
            truncateAttr.text = optString;
            truncateAttr.href = optString2;
            try {
                String optString3 = jSONObject.optString("color");
                if (!TextUtils.isEmpty(optString3)) {
                    i3 = Color.parseColor(optString3);
                } else {
                    i3 = -12541697;
                }
                truncateAttr.color = i3;
                int dp2px = Utils.dp2px(16.0d);
                String optString4 = jSONObject.optString("font-size");
                if (!TextUtils.isEmpty(optString4) && (size = CssStyle.getSize(optString4)) != null) {
                    dp2px = Integer.parseInt(String.valueOf(size));
                }
                truncateAttr.fontSize = dp2px;
                String optString5 = jSONObject.optString("font-weight");
                if (!TextUtils.isEmpty(optString5)) {
                    truncateAttr.fontWeight = optString5;
                    return truncateAttr;
                }
                return truncateAttr;
            } catch (Exception e16) {
                LogUtil.QLog.e(TAG, 1, "parseTruncate error! msg=" + e16);
                return truncateAttr;
            }
        }
        return null;
    }
}
