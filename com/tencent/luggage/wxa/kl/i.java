package com.tencent.luggage.wxa.kl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.so.c;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface i {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kl.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public enum EnumC6399a {
            PageConfig,
            JsApi,
            HalfScreenConfig,
            LiteGame,
            EnforceFlag;


            /* renamed from: f, reason: collision with root package name */
            public static final com.tencent.luggage.wxa.so.c f132661f = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: c31.k
                @Override // com.tencent.luggage.wxa.so.c.a
                public final Object a() {
                    List asList;
                    asList = Arrays.asList(i.a.EnumC6399a.values());
                    return asList;
                }
            });

            public static List b() {
                return (List) f132661f.b();
            }
        }

        boolean b(boolean z16, EnumC6399a enumC6399a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        BLACK(-16777216),
        WHITE(-1);


        /* renamed from: a, reason: collision with root package name */
        public final int f132666a;

        b(int i3) {
            this.f132666a = i3;
        }

        public static b a(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (b bVar : values()) {
                    if (bVar.name().equalsIgnoreCase(str)) {
                        return bVar;
                    }
                }
            }
            return WHITE;
        }

        public static b a(int i3) {
            return i3 == -1 ? WHITE : BLACK;
        }
    }

    void a(boolean z16, a.EnumC6399a enumC6399a);

    void destroy();

    View getActionView();

    int getBackgroundColor();

    void setBackButtonClickListener(View.OnClickListener onClickListener);

    void setBackgroundColor(int i3);

    void setCloseButtonClickListener(View.OnClickListener onClickListener);

    void setForegroundColor(int i3);

    void setForegroundStyle(String str);

    void setLoadingIconVisibility(boolean z16);

    void setMainTitle(CharSequence charSequence);
}
