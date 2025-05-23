package com.tencent.mobileqq.vas.config.business.qvip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.util.Arrays;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class KingCardConfig {
    private static final String defaultJson = "{\n\"AIO\": {\n\"content\": \"\u63a8\u8350\u4f7f\u7528 \u514d\u6d41\u91cf\u7279\u6743\",\n\"keyWords\": [\"\u514d\u6d41\u91cf\u7279\u6743\"],\n\"actionUrls\": [\"https://club.vip.qq.com/wk/home?showtab=0&_wvx=10&_wv=16777221&_proxy=1&from=person_file\"]\n},\n\"group\": {\n\"content\": \"\u63a8\u8350\u4f7f\u7528 \u514d\u6d41\u91cf\u7279\u6743\",\n\"keyWords\": [\"\u514d\u6d41\u91cf\u7279\u6743\"],\n\"actionUrls\": [\"https://club.vip.qq.com/wk/home?showtab=0&_wvx=10&_wv=16777221&_proxy=1&from=group_file\"]\n},\n\"download\": {\n\"content\": \"\u514d\u6d41\u91cf\u4e0b\u8f7d\",\n\"keyWords\": [\"\u514d\u6d41\u91cf\u4e0b\u8f7d\"],\n\"actionUrls\": [\"https://club.vip.qq.com/wk/home?showtab=0&_wvx=10&_wv=16777221&_proxy=1&from=group_dw\"]\n}\n}";

    @NonNull
    public final Item aio = get(defaultJson, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);

    @NonNull
    public final Item group = get(defaultJson, VipFunCallConstants.KEY_GROUP);

    @NonNull
    public final Item download = get(defaultJson, "download");

    private static Item get(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new Item();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                String optString = optJSONObject.optString("content", null);
                JSONArray optJSONArray = optJSONObject.optJSONArray("keyWords");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("actionUrls");
                String[] strArr = new String[optJSONArray.length()];
                String[] strArr2 = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = optJSONArray.optString(i3, null);
                    strArr2[i3] = optJSONArray2.optString(i3, null);
                }
                return new Item(str2, true, optString, strArr, strArr2);
            }
        } catch (Exception e16) {
            QLog.e("KC.ConfigProcessor", 1, "json parse error:" + e16);
        }
        return new Item();
    }

    public String toString() {
        return "KingCardConfig{aio=" + this.aio + ", group=" + this.group + ", download=" + this.download + '}';
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Item {
        private final String[] actionUrls;
        private final String content;
        public final boolean enable;
        private final String[] keyWords;
        private final String sopNameClick;
        private final String sopNameExposure;
        private final String type;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a extends ClickableSpan {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f308947d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f308948e;

            a(String str, Context context) {
                this.f308947d = str;
                this.f308948e = context;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ((IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class)).openH5Page(this.f308947d, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), (Activity) this.f308948e);
                ReportController.o(null, "dc00898", "", "", Item.this.sopNameClick, Item.this.sopNameClick, 2, 0, "", "", "", "");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#4D94FF"));
                textPaint.setUnderlineText(false);
            }
        }

        public Item() {
            this.type = "";
            this.enable = false;
            this.content = null;
            this.keyWords = null;
            this.actionUrls = null;
            this.sopNameExposure = null;
            this.sopNameClick = null;
        }

        public SpannableString appendKingcardString(Context context, CharSequence charSequence) {
            String str = ((Object) charSequence) + this.content;
            SpannableString spannableString = new SpannableString(str);
            int i3 = 0;
            while (true) {
                String[] strArr = this.keyWords;
                if (i3 < strArr.length) {
                    String str2 = strArr[i3];
                    String str3 = this.actionUrls[i3];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        int indexOf = str.indexOf(this.keyWords[i3]);
                        spannableString.setSpan(new a(str3, context), indexOf, str2.length() + indexOf, 33);
                    }
                    i3++;
                } else {
                    String str4 = this.sopNameExposure;
                    ReportController.o(null, "dc00898", "", "", str4, str4, 2, 0, "", "", "", "");
                    return spannableString;
                }
            }
        }

        public String getFirstActionUrl() {
            String[] strArr = this.actionUrls;
            if (strArr != null && strArr.length > 0) {
                String str = this.sopNameExposure;
                ReportController.o(null, "dc00898", "", "", str, str, 2, 0, "", "", "", "");
                return this.actionUrls[0];
            }
            return "";
        }

        public void reportClickEvent() {
            String str = this.sopNameClick;
            ReportController.o(null, "dc00898", "", "", str, str, 2, 0, "", "", "", "");
        }

        public String toString() {
            return "Item{enable=" + this.enable + ", content='" + this.content + "', keyWords=" + Arrays.toString(this.keyWords) + ", actionUrls=" + Arrays.toString(this.actionUrls) + '}';
        }

        public Item(String str, boolean z16, String str2, String[] strArr, String[] strArr2) {
            this.type = str;
            this.enable = z16;
            this.content = str2;
            this.keyWords = strArr;
            this.actionUrls = strArr2;
            if (QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO.equals(str)) {
                this.sopNameExposure = "0X800A647";
                this.sopNameClick = "0X800A648";
            } else if (VipFunCallConstants.KEY_GROUP.equals(str)) {
                this.sopNameExposure = "0X800A649";
                this.sopNameClick = "0X800A64A";
            } else if ("download".equals(str)) {
                this.sopNameExposure = "0X800A64B";
                this.sopNameClick = "0X800A64C";
            } else {
                this.sopNameExposure = null;
                this.sopNameClick = null;
            }
        }
    }
}
