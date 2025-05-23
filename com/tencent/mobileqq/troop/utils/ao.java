package com.tencent.mobileqq.troop.utils;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildABTestApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ao {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static String f302037d;

    /* renamed from: e, reason: collision with root package name */
    public static String f302038e;

    /* renamed from: f, reason: collision with root package name */
    public static String f302039f;

    /* renamed from: g, reason: collision with root package name */
    public static int f302040g;

    /* renamed from: h, reason: collision with root package name */
    public static int f302041h;

    /* renamed from: i, reason: collision with root package name */
    public static int f302042i;

    /* renamed from: j, reason: collision with root package name */
    public static int f302043j;

    /* renamed from: k, reason: collision with root package name */
    public static int f302044k;

    /* renamed from: l, reason: collision with root package name */
    public static int f302045l;

    /* renamed from: m, reason: collision with root package name */
    public static int f302046m;

    /* renamed from: n, reason: collision with root package name */
    private static ao f302047n;

    /* renamed from: a, reason: collision with root package name */
    private boolean f302048a;

    /* renamed from: b, reason: collision with root package name */
    public String f302049b;

    /* renamed from: c, reason: collision with root package name */
    public String f302050c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f302037d = "exp_grp_recommend_channel_enterance";
        f302038e = "exp_grp_recommend_channel_enterance_A";
        f302039f = "exp_grp_recommend_channel_enterance_B";
        f302040g = 27;
        f302041h = 28;
        f302042i = 29;
        f302043j = 30;
        f302044k = ViewUtils.dip2px(5.0f);
        f302045l = ViewUtils.dpToPx(5.0f);
        f302046m = ViewUtils.dpToPx(16.0f);
    }

    public ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f302048a = false;
        this.f302049b = "";
        this.f302050c = "";
    }

    public static ao b() {
        if (f302047n == null) {
            f302047n = new ao();
        }
        return f302047n;
    }

    public String a(TextView textView, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, textView, str, Integer.valueOf(i3));
        }
        int measuredWidth = textView.getMeasuredWidth();
        if (textView.getMaxLines() > 1) {
            measuredWidth = (measuredWidth - ViewUtils.dpToPx(10.0f)) * textView.getMaxLines();
        }
        TextPaint paint = textView.getPaint();
        float f16 = measuredWidth - i3;
        if (f16 < paint.measureText(str)) {
            return (String) TextUtils.ellipsize(str, paint, f16, TextUtils.TruncateAt.END);
        }
        return str;
    }

    public SpannableStringBuilder c(String str, List<String> list, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 5, this, str, list, textView);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int dpToPx = ViewUtils.dpToPx(5.0f);
        int dpToPx2 = ViewUtils.dpToPx(13.0f);
        for (String str2 : list) {
            spannableStringBuilder.append((CharSequence) ":");
            c cVar = new c(textView.getContext(), str2, dpToPx2, dpToPx, 0);
            cVar.c(textView);
            spannableStringBuilder.setSpan(cVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append(TokenParser.SP);
        return spannableStringBuilder;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.f302049b)) {
            return this.f302050c;
        }
        return this.f302050c + "-" + this.f302049b;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f302048a = ((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).isExpHit(f302037d, f302039f);
        if (((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).isExpHit(f302037d, f302038e) || ((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).isExpHit(f302037d, f302039f)) {
            ((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).reportExposure(f302037d);
        }
    }

    public Boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Boolean.valueOf(this.f302048a);
    }

    public void g(TextView textView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) textView, (Object) str);
            return;
        }
        int i3 = f302044k;
        textView.setPadding(i3, 0, i3, 0);
        textView.setText(str);
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_common_text_secondary));
        textView.setBackgroundResource(R.drawable.guild_label_grey_chain_bg);
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f302050c = str;
        }
    }

    public void i(TextView textView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView, (Object) str);
            return;
        }
        int i3 = f302044k;
        textView.setPadding(i3, 0, i3, 0);
        textView.setText(str);
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_button_bg_primary_default));
        textView.setBackgroundResource(R.drawable.guild_theme_collection_label_relationship_chain_bg);
    }
}
