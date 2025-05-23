package com.tencent.mobileqq.tvideo.temporaryauth;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.tvideo.temporaryauth.d;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tvideo.TVideoTemporaryAuth$AuthorizePlayData;
import tvideo.TVideoTemporaryAuth$AuthorizeTabData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f304770a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Integer> f304771b = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Observer<TVideoTemporaryAuth$AuthorizeTabData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(TVideoTemporaryAuth$AuthorizeTabData tVideoTemporaryAuth$AuthorizeTabData) {
            if (tVideoTemporaryAuth$AuthorizeTabData == null) {
                return;
            }
            QLog.d("TVideoTemporaryAuthUtil", 4, "requestAuthData needTemporaryAuth = " + tVideoTemporaryAuth$AuthorizeTabData.allow_authorize.get() + " tabid = " + tVideoTemporaryAuth$AuthorizeTabData.tab_id.get());
            d.f304770a = tVideoTemporaryAuth$AuthorizeTabData.allow_authorize.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(tVideoTemporaryAuth$AuthorizeTabData.tab_id.get());
            sb5.append("");
            iy2.a.f(sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(TVideoTemporaryAuth$AuthorizePlayData tVideoTemporaryAuth$AuthorizePlayData);
    }

    public static void c() {
        f304771b.clear();
        f304770a = false;
    }

    public static boolean d() {
        return f304770a;
    }

    public static boolean e(TVideoTemporaryAuth$AuthorizePlayData tVideoTemporaryAuth$AuthorizePlayData, String str) {
        if (tVideoTemporaryAuth$AuthorizePlayData == null || tVideoTemporaryAuth$AuthorizePlayData.authorize_ret.get() != 2 || !TextUtils.equals(str, tVideoTemporaryAuth$AuthorizePlayData.vid.get())) {
            return false;
        }
        return true;
    }

    public static boolean f(int i3, String str) {
        QLog.d("TVideoTemporaryAuthUtil", 1, " isNeedTemporaryAuth allowAuthorize = " + f304770a + " videoState = " + i3);
        if (f304770a && i3 != 2 && !g(str)) {
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        Integer num = f304771b.get(str);
        QLog.d("TVideoTemporaryAuthUtil", 1, " isOutRequestRange " + str + " requestCount = " + num);
        if (num != null && num.intValue() >= 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(b bVar, TVideoTemporaryAuth$AuthorizePlayData tVideoTemporaryAuth$AuthorizePlayData) {
        if (bVar != null) {
            bVar.a(tVideoTemporaryAuth$AuthorizePlayData);
        }
    }

    public static void i(String str, final b bVar) {
        int i3;
        com.tencent.mobileqq.tvideo.temporaryauth.b bVar2 = new com.tencent.mobileqq.tvideo.temporaryauth.b();
        bVar2.f304767m.observeForever(new Observer() { // from class: com.tencent.mobileqq.tvideo.temporaryauth.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.h(d.b.this, (TVideoTemporaryAuth$AuthorizePlayData) obj);
            }
        });
        k(str);
        Integer num = f304771b.get(str);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        bVar2.L1(str, i3);
    }

    public static void j() {
        com.tencent.mobileqq.tvideo.temporaryauth.a aVar = new com.tencent.mobileqq.tvideo.temporaryauth.a();
        aVar.f304765m.observeForever(new a());
        aVar.L1();
    }

    private static void k(String str) {
        Integer num = f304771b.get(str);
        if (num == null) {
            num = 0;
        }
        f304771b.put(str, Integer.valueOf(num.intValue() + 1));
    }
}
