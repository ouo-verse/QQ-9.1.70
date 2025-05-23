package com.tencent.mobileqq.qroute.route;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ActivityURIRequest extends URIRequest {
    static IPatchRedirector $redirector_;
    final URIRequest request;

    public ActivityURIRequest(Context context, String str) {
        super(context, Uri.parse(normalizePath(str)), null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.request = this;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    protected static String normalizePath(String str) {
        if (str != null && str.length() != 0) {
            if (!str.startsWith("/")) {
                str = "/" + str;
            }
            return "qroute://page" + str;
        }
        return "";
    }

    public Uri data() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Uri) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (Uri) this.request.getField(Uri.class, "com.tencent.mobileqq.qroute.route.data");
    }

    public Bundle extra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bundle) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Bundle bundle = (Bundle) this.request.getField(Bundle.class, "com.tencent.mobileqq.qroute.route.intentExtra");
        if (bundle == null) {
            Bundle bundle2 = new Bundle();
            this.request.putField("com.tencent.mobileqq.qroute.route.intentExtra", bundle2);
            return bundle2;
        }
        return bundle;
    }

    public int flags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((Integer) this.request.getField(Integer.class, "com.tencent.mobileqq.qroute.route.flags", 0)).intValue();
    }

    public URIRequest getRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (URIRequest) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.request;
    }

    public String intentAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (String) this.request.getField(String.class, "com.tencent.mobileqq.qroute.route.intentAction");
    }

    public Bundle options() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? options(true) : (Bundle) iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public int[] overridePendingTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (int[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (int[]) this.request.getField(int[].class, "com.tencent.mobileqq.qroute.route.overridePendingTransition", null);
    }

    public Integer requestCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (Integer) this.request.getField(Integer.class, "com.tencent.mobileqq.qroute.route.requestCode", null);
    }

    public ActivityURIRequest setData(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uri);
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.data", uri);
        return this;
    }

    public ActivityURIRequest setFlags(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.flags", Integer.valueOf(i3));
        return this;
    }

    public ActivityURIRequest setIntentAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.intentAction", str);
        return this;
    }

    public ActivityURIRequest setOptions(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
        }
        options().putAll(bundle);
        return this;
    }

    public ActivityURIRequest setOverridePendingTransition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.overridePendingTransition", new int[]{i3, i16});
        return this;
    }

    public ActivityURIRequest setRequestCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.requestCode", Integer.valueOf(i3));
        return this;
    }

    public ActivityURIRequest setType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        this.request.putField("com.tencent.mobileqq.qroute.route.type", str);
        return this;
    }

    public String type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (String) this.request.getField(String.class, "com.tencent.mobileqq.qroute.route.type");
    }

    Bundle options(boolean z16) {
        Bundle bundle = (Bundle) this.request.getField(Bundle.class, "com.tencent.mobileqq.qroute.route.options");
        if (bundle != null || !z16) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        this.request.putField("com.tencent.mobileqq.qroute.route.options", bundle2);
        return bundle2;
    }

    ActivityURIRequest(URIRequest uRIRequest) {
        super(null, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.request = uRIRequest;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRIRequest);
        }
    }
}
