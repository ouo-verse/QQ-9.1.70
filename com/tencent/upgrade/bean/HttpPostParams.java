package com.tencent.upgrade.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upgrade.util.d;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes27.dex */
public class HttpPostParams {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HttpPostParams";
    protected String content;
    protected ContentType contentType;
    protected Map<String, String> formParams;
    protected Map<String, String> headParams;
    protected Map<String, String> queryParams;
    protected int timeout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class ContentType {
        private static final /* synthetic */ ContentType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ContentType JSON;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7239);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ContentType contentType = new ContentType("JSON", 0);
            JSON = contentType;
            $VALUES = new ContentType[]{contentType};
        }

        ContentType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ContentType valueOf(String str) {
            return (ContentType) Enum.valueOf(ContentType.class, str);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }
    }

    public HttpPostParams(ContentType contentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) contentType);
            return;
        }
        this.queryParams = new HashMap();
        this.formParams = new HashMap();
        this.headParams = new HashMap();
        this.timeout = 5000;
        this.contentType = contentType;
    }

    public HttpPostParams addFormPart(@NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HttpPostParams) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
        this.formParams.put(str, str2);
        return this;
    }

    public void addHeadParams(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) map);
        } else {
            this.headParams.putAll(map);
        }
    }

    public HttpPostParams addQueryParams(@NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HttpPostParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        this.queryParams.put(str, str2);
        return this;
    }

    public String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.content;
    }

    public Map<String, String> getFormParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.formParams;
    }

    public Map<String, String> getHeadParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.headParams;
    }

    public Map<String, String> getQueryParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.queryParams;
    }

    public int getTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.timeout;
    }

    public HttpPostParams jsonContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HttpPostParams) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.content = str;
        return this;
    }

    public void print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        d.a(TAG, "Post headParams = " + this.headParams);
        d.a(TAG, "Post content = " + this.content);
    }

    public HttpPostParams timeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HttpPostParams) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.timeout = i3;
        return this;
    }
}
