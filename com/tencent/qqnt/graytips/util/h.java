package com.tencent.qqnt.graytips.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.util.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes24.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static a b(@NotNull a.C9628a c9628a) {
        return c(c9628a.a(), c9628a.b(), true);
    }

    public static a c(CharSequence charSequence, List<com.tencent.qqnt.graytips.c> list, boolean z16) {
        Collections.sort(list, new Comparator() { // from class: com.tencent.qqnt.graytips.util.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e16;
                e16 = h.e((com.tencent.qqnt.graytips.c) obj, (com.tencent.qqnt.graytips.c) obj2);
                return e16;
            }
        });
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append("revoke msg GrayTips -> msg=");
        sb5.append(e.a(charSequence));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String charSequence2 = charSequence.toString();
        String str = "";
        int i3 = 0;
        for (com.tencent.qqnt.graytips.c cVar : list) {
            int i16 = cVar.start - i3;
            int i17 = cVar.end - i3;
            if (i16 > charSequence2.length()) {
                i16 = charSequence2.length();
            } else if (i16 < 0) {
                i16 = 0;
            }
            if (i17 > charSequence2.length()) {
                i17 = charSequence2.length();
            } else if (i17 < 0) {
                i17 = 0;
            }
            sb5.append(" ;item.start=");
            sb5.append(cVar.start);
            sb5.append(",end=");
            sb5.append(cVar.end);
            sb5.append("|index1=");
            sb5.append(i16);
            sb5.append(",index2=");
            sb5.append(i17);
            sb5.append("|lastEnd=");
            sb5.append(i3);
            String str2 = str + charSequence2.substring(0, i16);
            String substring = charSequence2.substring(i16, i17);
            charSequence2 = charSequence2.substring(i17);
            int i18 = cVar.end;
            cVar.start = str2.length();
            str = str2 + substring;
            cVar.end = str.length();
            i3 = i18;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GrayTips", 2, sb5.toString());
        }
        spannableStringBuilder.append((CharSequence) str).append((CharSequence) charSequence2);
        return d(list, z16, spannableStringBuilder);
    }

    private static a d(List<com.tencent.qqnt.graytips.c> list, boolean z16, SpannableStringBuilder spannableStringBuilder) {
        a aVar = new a();
        BaseApplication baseApplication = BaseApplication.context;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        boolean enableTalkBack = com.tencent.qqnt.util.b.f362976b.enableTalkBack();
        for (com.tencent.qqnt.graytips.c cVar : list) {
            if (cVar != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (TextUtils.isEmpty(cVar.iconUrl)) {
                    com.tencent.qqnt.graytips.span.a aVar2 = new com.tencent.qqnt.graytips.span.a(peekAppRuntime, cVar.b(), baseApplication, cVar);
                    aVar.b(aVar2);
                    spannableStringBuilder2.setSpan(aVar2, cVar.start, cVar.end, 33);
                } else {
                    com.tencent.qqnt.graytips.imagespan.b.a(baseApplication, spannableStringBuilder2, cVar, z16, aVar);
                    if (cVar.actionInfo != null && !enableTalkBack) {
                        com.tencent.qqnt.graytips.span.a aVar3 = new com.tencent.qqnt.graytips.span.a(peekAppRuntime, cVar.b(), baseApplication, cVar);
                        aVar.b(aVar3);
                        spannableStringBuilder2.setSpan(aVar3, cVar.start, cVar.end, 33);
                    }
                }
            }
        }
        aVar.f356916a = spannableStringBuilder2;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(com.tencent.qqnt.graytips.c cVar, com.tencent.qqnt.graytips.c cVar2) {
        return cVar.start - cVar2.start;
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public SpannableStringBuilder f356916a;

        /* renamed from: b, reason: collision with root package name */
        public List<ClickableSpan> f356917b;

        /* renamed from: c, reason: collision with root package name */
        public List<com.tencent.qqnt.graytips.span.b> f356918c;

        public a(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence);
                return;
            }
            this.f356917b = new ArrayList();
            this.f356918c = new ArrayList();
            this.f356916a = new SpannableStringBuilder(charSequence);
        }

        public void a(com.tencent.qqnt.graytips.span.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            } else {
                this.f356918c.add(bVar);
            }
        }

        public void b(ClickableSpan clickableSpan) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) clickableSpan);
            } else {
                this.f356917b.add(clickableSpan);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f356917b = new ArrayList();
                this.f356918c = new ArrayList();
            }
        }
    }
}
