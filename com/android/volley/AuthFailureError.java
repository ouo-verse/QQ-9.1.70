package com.android.volley;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes.dex */
public class AuthFailureError extends VolleyError {
    private Intent mResolutionIntent;

    public AuthFailureError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mResolutionIntent != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }

    public AuthFailureError(Intent intent) {
        this.mResolutionIntent = intent;
    }

    public AuthFailureError(g gVar) {
        super(gVar);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    public AuthFailureError(String str, Exception exc) {
        super(str, exc);
    }
}
