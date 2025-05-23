package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes11.dex */
public class StepGroup<T extends b> extends AsyncStep<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected AsyncStep[] f195313d;

    /* renamed from: e, reason: collision with root package name */
    public String f195314e;

    /* renamed from: f, reason: collision with root package name */
    public int f195315f;

    /* renamed from: h, reason: collision with root package name */
    protected String[] f195316h;

    public StepGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String b(String str) {
        char c16;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c17 = charArray[0];
        if (c17 == '{') {
            c16 = '}';
        } else if (c17 == '[') {
            c16 = ']';
        } else {
            if (str.indexOf(",") == -1) {
                return str;
            }
            return str.substring(0, str.indexOf(","));
        }
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char c18 = charArray[i16];
            if (c18 == c17) {
                i3++;
            } else if (c18 == c16) {
                i3--;
            }
            if (i3 == 0) {
                return str.substring(0, i16 + 1);
            }
        }
        return "";
    }

    private String[] c(String str) {
        int i3 = 0;
        if (str.length() <= 2) {
            return new String[0];
        }
        String substring = str.substring(1, str.length() - 1);
        int length = substring.length();
        StringBuilder sb5 = new StringBuilder(50);
        String str2 = substring;
        while (i3 < length) {
            if (str2.startsWith(",")) {
                i3++;
                str2 = substring.substring(i3, length);
            }
            String b16 = b(str2);
            sb5.append(b16);
            sb5.append("-");
            i3 += b16.length();
            str2 = substring.substring(i3, length);
        }
        return sb5.toString().split("-");
    }

    public AsyncStep g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = this.f195315f;
        String[] strArr = this.f195316h;
        if (i3 < strArr.length) {
            AsyncStep[] asyncStepArr = this.f195313d;
            b bVar = this.mAutomator;
            asyncStepArr[i3] = bVar.S1(bVar, strArr[i3]);
            AsyncStep[] asyncStepArr2 = this.f195313d;
            int i16 = this.f195315f;
            AsyncStep asyncStep = asyncStepArr2[i16];
            asyncStep.mParams = this.mParams;
            this.f195315f = i16 + 1;
            return asyncStep;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mTimeout = TTL.MAX_VALUE;
        String[] c16 = c(this.f195314e);
        this.f195316h = c16;
        this.f195315f = 0;
        this.f195313d = new AsyncStep[c16.length];
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void setResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 != 4) {
            super.setResult(i3);
        }
        AsyncStep[] asyncStepArr = this.f195313d;
        if ((i3 == 8 || i3 == 4) && asyncStepArr != null) {
            for (AsyncStep asyncStep : asyncStepArr) {
                if (asyncStep != null) {
                    asyncStep.setResult(i3);
                } else {
                    return;
                }
            }
        }
    }
}
