package com.tencent.biz.pubaccount.weishi.richtext;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.subscribe.comment.g;
import com.tencent.biz.subscribe.comment.o;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d implements com.tencent.biz.pubaccount.weishi.richtext.a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Drawable> f81552a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f81553b = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f81554c = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f81555d = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedRichTextView.a f81556d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f81557e;

        a(FeedRichTextView.a aVar, String str) {
            this.f81556d = aVar;
            this.f81557e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            FeedRichTextView.a aVar = this.f81556d;
            if (aVar != null) {
                aVar.b(this.f81557e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedRichTextView.a f81559d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f81560e;

        b(FeedRichTextView.a aVar, String str) {
            this.f81559d = aVar;
            this.f81560e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            FeedRichTextView.a aVar = this.f81559d;
            if (aVar != null) {
                aVar.a(this.f81560e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends SpannableStringBuilder {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<e> f81562d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<C0830d> f81563e;

        c(CharSequence charSequence) {
            super(charSequence);
        }

        public ArrayList<C0830d> a() {
            return this.f81563e;
        }

        public ArrayList<e> b() {
            return this.f81562d;
        }

        public void c(ArrayList<C0830d> arrayList) {
            this.f81563e = arrayList;
        }

        public void d(ArrayList<e> arrayList) {
            this.f81562d = arrayList;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.richtext.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0830d {

        /* renamed from: a, reason: collision with root package name */
        public String f81564a;

        /* renamed from: b, reason: collision with root package name */
        public String f81565b;

        public C0830d() {
        }

        public C0830d(String str, String str2) {
            this.f81564a = str;
            this.f81565b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f81566a;

        /* renamed from: b, reason: collision with root package name */
        public String f81567b;

        /* renamed from: c, reason: collision with root package name */
        public String f81568c;

        public e() {
        }

        public e(String str, String str2) {
            this.f81566a = str;
            this.f81567b = str2;
        }

        public e(String str, String str2, String str3) {
            this.f81566a = str;
            this.f81567b = str2;
            this.f81568c = str3;
        }
    }

    private C0830d b(String str, String str2) {
        int indexOf = str.indexOf("tid:") + 4;
        int indexOf2 = str.indexOf(str2);
        if (indexOf2 == -1) {
            return new C0830d("", "");
        }
        String substring = str.substring(indexOf, indexOf2);
        String substring2 = str.substring(indexOf2 + str2.length(), str.length() - 1);
        try {
            substring2 = URLDecoder.decode(substring2, "UTF-8");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new C0830d(substring, substring2);
    }

    private ArrayList<C0830d> e(c cVar, FeedRichTextView.a aVar) {
        if (TextUtils.isEmpty(cVar)) {
            return null;
        }
        Matcher matcher = f81554c.matcher(cVar);
        ArrayList<C0830d> arrayList = new ArrayList<>();
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                C0830d b16 = b(group, ",name:");
                String str = b16.f81564a;
                String str2 = " #" + b16.f81565b + " ";
                cVar.replace(start, end, (CharSequence) str2);
                i3 += group.length() - str2.length();
                int length = str2.length() + start;
                cVar.setSpan(new b(aVar, str), start, length, 33);
                cVar.setSpan(new StyleSpan(1), start, length, 33);
                arrayList.add(b16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        cVar.c(arrayList);
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.richtext.a
    public c a(CharSequence charSequence, int i3, FeedRichTextView.a aVar, Drawable.Callback callback) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        c cVar = new c(charSequence);
        d(cVar, aVar);
        e(cVar, aVar);
        f(cVar, i3, callback);
        return cVar;
    }

    public e c(String str, String str2) {
        int indexOf = str.indexOf("uid:") + 4;
        int indexOf2 = str.indexOf(str2);
        if (indexOf2 == -1) {
            return new e("", "");
        }
        String substring = str.substring(indexOf, indexOf2);
        String substring2 = str.substring(indexOf2 + str2.length(), str.length() - 1);
        try {
            substring2 = URLDecoder.decode(substring2, "UTF-8");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new e(substring, substring2);
    }

    protected ArrayList<e> d(c cVar, FeedRichTextView.a aVar) {
        if (TextUtils.isEmpty(cVar)) {
            return null;
        }
        Matcher matcher = f81553b.matcher(cVar);
        ArrayList<e> arrayList = new ArrayList<>();
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                e c16 = c(group, ",nick:");
                String str = c16.f81566a;
                String str2 = " @" + c16.f81567b + " ";
                cVar.replace(start, end, (CharSequence) str2);
                i3 += group.length() - str2.length();
                int length = str2.length() + start;
                cVar.setSpan(new a(aVar, str), start, length, 33);
                cVar.setSpan(new StyleSpan(1), start, length, 33);
                arrayList.add(c16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        cVar.d(arrayList);
        return arrayList;
    }

    private void f(c cVar, int i3, Drawable.Callback callback) {
        int a16;
        if (cVar == null) {
            return;
        }
        Matcher matcher = f81555d.matcher(cVar);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String charSequence = cVar.subSequence(start, end).toString();
            Drawable drawable = f81552a.containsKey(charSequence) ? f81552a.get(charSequence) : null;
            if (drawable == null) {
                drawable = QzoneEmotionUtils.getDrawable(charSequence);
            }
            if (drawable == null && (a16 = o.a(charSequence)) > -1 && a16 < o.f96034e.length) {
                drawable = g.a(a16, BaseApplication.getContext().getResources().getDisplayMetrics().density, BaseApplication.getContext(), null);
            }
            if (drawable == null) {
                int b16 = o.b(charSequence);
                x.b("emotion", "emotion code:" + charSequence + ",index:" + b16);
                if (b16 > -1 && b16 < o.f96035f.length) {
                    drawable = g.b(b16, BaseApplication.getContext().getResources().getDisplayMetrics().density, BaseApplication.getContext(), null);
                }
            }
            if (drawable != null) {
                f81552a.put(charSequence, drawable);
                drawable.setBounds(new Rect(0, 0, i3, i3));
                cVar.setSpan(new VerticalCenterImageSpan(drawable, 0), start, end, 33);
            }
        }
    }
}
