package com.tencent.mobileqq.nearby.now.view;

import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.MedalItem;
import com.tencent.mobileqq.nearby.now.utils.ICommentsUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f252870a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f252871b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f252872c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f252873d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f252874e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f252875f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f252876g;

    public void a(String str) {
        this.f252872c.setText(str);
    }

    public void c(MedalInfo medalInfo, int i3, Paint paint, boolean z16) {
        List<MedalItem> list;
        int measureText = (int) ((i3 - ((int) paint.measureText(this.f252873d.getText().toString()))) - ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(this.f252873d.getContext(), 30.0f));
        this.f252874e.setVisibility(8);
        this.f252875f.setVisibility(8);
        if (medalInfo != null && (list = medalInfo.f252682h) != null && list.size() >= 0) {
            this.f252871b.setMaxWidth(measureText);
        } else {
            this.f252871b.setMaxWidth(measureText);
        }
    }

    public void d(long j3) {
        this.f252873d.setText(((ICommentsUtil) QRoute.api(ICommentsUtil.class)).simpleFormatTime(j3 * 1000));
    }

    public void b(String str, String str2) {
        if (str != null && !str.equals("")) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "\u56de\u590d");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(RichStatus.ACTION_COLOR_NORMAL), 0, spannableStringBuilder.length(), 17);
            int length = spannableStringBuilder.length();
            if (str.length() > 6) {
                str = str.substring(0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), length, str.length() + length, 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(RichStatus.ACTION_COLOR_NORMAL), length + str.length(), spannableStringBuilder.length(), 17);
            this.f252872c.setText(spannableStringBuilder);
            return;
        }
        a(str2);
    }
}
