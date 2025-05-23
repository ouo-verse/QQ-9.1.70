package com.tencent.mapsdk.internal;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kq {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Toast f149059a;

        /* renamed from: b, reason: collision with root package name */
        private int f149060b;

        /* renamed from: c, reason: collision with root package name */
        private int f149061c;

        /* renamed from: d, reason: collision with root package name */
        private int f149062d;

        /* renamed from: e, reason: collision with root package name */
        private String f149063e;

        /* renamed from: f, reason: collision with root package name */
        private String f149064f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f149065g;

        /* renamed from: h, reason: collision with root package name */
        private TextView f149066h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f149067i;

        /* renamed from: j, reason: collision with root package name */
        private Context f149068j;

        a(Context context) {
            this.f149068j = context;
        }

        private a b(String str) {
            return a(str, 8388611);
        }

        private void c() {
            Toast toast = this.f149059a;
            if (toast != null) {
                toast.cancel();
            }
        }

        public final boolean b() {
            Toast toast = this.f149059a;
            if (toast == null) {
                return false;
            }
            toast.show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final a a(Context context, View view, int i3) {
            Toast toast = new Toast(context);
            this.f149059a = toast;
            toast.setView(view);
            this.f149059a.setDuration(i3);
            this.f149060b = this.f149059a.getGravity();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ViewGroup a(Context context, String str, String str2) {
            this.f149063e = str;
            this.f149064f = str2;
            LinearLayout linearLayout = new LinearLayout(context);
            int a16 = km.a(context, 5);
            int a17 = km.a(context, 10);
            linearLayout.setPadding(a17, a16, a17, a16);
            linearLayout.setBackgroundColor(-12303292);
            linearLayout.setOrientation(1);
            if (!TextUtils.isEmpty(str)) {
                this.f149066h = new TextView(context);
                int a18 = km.a(context, 5);
                this.f149066h.setPadding(a18, a18, a18, a18);
                this.f149066h.setText(str);
                this.f149066h.setTextColor(-1);
                this.f149066h.setTextSize(2, 18.0f);
                linearLayout.addView(this.f149066h, new ViewGroup.MarginLayoutParams(-1, -2));
            }
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = new TextView(context);
                this.f149067i = textView;
                textView.setId(R.id.message);
                this.f149067i.setText(str2);
                this.f149067i.setTextColor(-1);
                this.f149067i.setTextSize(2, 16.0f);
                int a19 = km.a(context, 5);
                this.f149067i.setPadding(a19, a19, a19, a19);
                linearLayout.addView(this.f149067i, new ViewGroup.MarginLayoutParams(-1, -2));
            }
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(21);
            TextView textView2 = new TextView(context);
            int a26 = km.a(context, 5);
            int a27 = km.a(context, 10);
            textView2.setTextColor(-1);
            textView2.setBackgroundColor(-16776961);
            textView2.setPadding(a27, a26, a27, a26);
            textView2.setVisibility(8);
            this.f149065g = textView2;
            linearLayout2.addView(textView2, new ViewGroup.MarginLayoutParams(-2, -2));
            linearLayout.addView(linearLayout2, new ViewGroup.MarginLayoutParams(-1, -2));
            return linearLayout;
        }

        public final a a() {
            try {
                Object a16 = hq.a(this.f149059a, "mTN");
                if (a16 != null) {
                    Object a17 = hq.a(a16, "mParams");
                    if (a17 instanceof WindowManager.LayoutParams) {
                        ((WindowManager.LayoutParams) a17).flags = 136;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return this;
        }

        public final a a(String str, View.OnClickListener onClickListener) {
            if (this.f149065g != null && !TextUtils.isEmpty(str) && onClickListener != null) {
                this.f149065g.setText(str);
                this.f149065g.setOnClickListener(onClickListener);
                this.f149065g.setVisibility(0);
            }
            return this;
        }

        private a a(String str) {
            TextView textView;
            this.f149063e = str;
            if (str != null && (textView = this.f149066h) != null) {
                textView.setText(str);
            }
            return this;
        }

        public final a a(String str, int i3) {
            TextView textView;
            this.f149064f = str;
            if (str != null && (textView = this.f149067i) != null) {
                textView.setText(str);
                this.f149067i.setGravity(i3);
            }
            return this;
        }

        private a a(int i3) {
            this.f149060b = i3;
            Toast toast = this.f149059a;
            if (toast != null) {
                toast.setGravity(i3, this.f149061c, this.f149062d);
            }
            return this;
        }

        private a a(int i3, int i16) {
            this.f149061c = i3;
            this.f149062d = i16;
            Toast toast = this.f149059a;
            if (toast != null) {
                toast.setGravity(this.f149060b, i3, i16);
            }
            return this;
        }
    }

    public static a a(Context context, String str, String str2, int i3) {
        if (context == null) {
            return null;
        }
        a aVar = new a(context);
        return aVar.a(context, aVar.a(context, str, str2), i3);
    }

    private static a b(Context context, String str) {
        return a(context, null, str, 0);
    }

    private static a a(Context context) {
        return a(context, null, " ", 0);
    }

    private static a a(Context context, String str) {
        return a(context, null, str, 0);
    }
}
