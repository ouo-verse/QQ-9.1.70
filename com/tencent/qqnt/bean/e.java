package com.tencent.qqnt.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/bean/e;", "", "", "c", "", "a", "I", "()I", "setTId", "(I)V", "tId", "", "b", "J", "()J", "setTime", "(J)V", "time", "", "strPrompt", "<init>", "(Ljava/lang/String;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int tId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long time;

    public e(@NotNull String strPrompt) {
        Intrinsics.checkNotNullParameter(strPrompt, "strPrompt");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) strPrompt);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strPrompt);
            this.tId = jSONObject.optInt("tid", 0);
            long optLong = jSONObject.optLong("time", 0L);
            this.time = optLong;
            QLog.d("JoinTroopHint", 2, "[SecurityPrompt] tId:" + this.tId + ", time:" + optLong);
        } catch (JSONException unused) {
            QLog.e("JoinTroopHint", 1, "[SecurityPrompt] strPrompt:" + strPrompt);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.tId;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.time;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.tId != 0 && this.time != 0) {
            return true;
        }
        return false;
    }
}
