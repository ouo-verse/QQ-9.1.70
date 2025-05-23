package com.tencent.mobileqq.qqshop.publicaccount;

import com.tencent.mobileqq.ecshop.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003R$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/c;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "d", "", "b", "adId", "", "c", "a", "Ljava/util/ArrayList;", "feedbackList", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f274574a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Long> feedbackList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        c cVar = new c();
        f274574a = cVar;
        feedbackList = cVar.d();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = feedbackList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Number) it.next()).longValue());
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        g.q("shop_feedback_ad_id_list", jSONArray2);
    }

    private final ArrayList<Long> d() {
        String c16;
        boolean z16;
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            c16 = e.c("shop_feedback_ad_id_list");
            if (c16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } catch (Throwable th5) {
            QLog.e("MsgAdFeedbackInfo", 4, th5, new Object[0]);
        }
        if (z16) {
            return arrayList;
        }
        JSONArray jSONArray = new JSONArray(c16);
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Long.valueOf(jSONArray.optLong(i3)));
        }
        return arrayList;
    }

    public final void a(long adId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, adId);
        } else {
            feedbackList.add(Long.valueOf(adId));
            b();
        }
    }

    public final boolean c(long adId) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, adId)).booleanValue();
        }
        ArrayList<Long> arrayList = feedbackList;
        boolean z17 = false;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Number) it.next()).longValue() == adId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        QLog.d("MsgAdFeedbackInfo", 1, "isFeedback result = " + z17);
        return z17;
    }
}
