package com.tencent.biz.pubaccount.weishi.richtext;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.richtext.d;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qcircle.weseevideo.model.template.light.LightPatterHelper;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends d {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f81547e = Pattern.compile("@?\\{uid:.*?,uidtype:.*?,nick:.*?\\}", 2);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedRichTextView.a f81548d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.e f81549e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f81550f;

        a(FeedRichTextView.a aVar, d.e eVar, String str) {
            this.f81548d = aVar;
            this.f81549e = eVar;
            this.f81550f = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.f81548d == null || !TextUtils.equals(this.f81549e.f81568c, "1")) {
                return;
            }
            this.f81548d.b(this.f81550f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private String g(String str, String str2, String str3, boolean z16) {
        int indexOf = str.indexOf(str2) + str2.length();
        if (z16) {
            return str.substring(indexOf, str.length() - 1);
        }
        int indexOf2 = str.indexOf(str3);
        if (indexOf2 == -1) {
            return "";
        }
        return str.substring(indexOf, indexOf2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.richtext.d
    protected ArrayList<d.e> d(d.c cVar, FeedRichTextView.a aVar) {
        if (TextUtils.isEmpty(cVar)) {
            return null;
        }
        Matcher matcher = f81547e.matcher(cVar);
        ArrayList<d.e> arrayList = new ArrayList<>();
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                d.e h16 = h(group);
                String str = h16.f81566a;
                if (TextUtils.isEmpty(h16.f81567b.trim())) {
                    h16.f81567b = LightPatterHelper.DEFAULT_NICKNAME;
                }
                if (h16.f81567b.length() > 9) {
                    h16.f81567b = h16.f81567b.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                String str2 = " @" + h16.f81567b + " ";
                cVar.replace(start, end, (CharSequence) str2);
                i3 += group.length() - str2.length();
                int length = str2.length() + start;
                cVar.setSpan(new a(aVar, h16, str), start, length, 33);
                if (TextUtils.equals(h16.f81568c, "1")) {
                    cVar.setSpan(new ForegroundColorSpan(Color.parseColor("#fe9526")), start, length, 33);
                }
                arrayList.add(h16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        cVar.d(arrayList);
        return arrayList;
    }

    public d.e h(String str) {
        String g16 = g(str, "uid:", ",uidtype:", false);
        String g17 = g(str, ",uidtype:", ",nick:", false);
        String g18 = g(str, ",nick:", "", true);
        try {
            g18 = URLDecoder.decode(g18);
        } catch (Exception e16) {
            x.f("WSCommentRichParserImpl", e16.getLocalizedMessage());
        }
        return new d.e(g16, g18, g17);
    }
}
