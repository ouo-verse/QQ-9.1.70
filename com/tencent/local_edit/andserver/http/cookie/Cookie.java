package com.tencent.local_edit.andserver.http.cookie;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Cookie implements Cloneable, Serializable {
    private String comment;
    private String domain;
    private String name;
    private String path;
    private boolean secure;
    private String value;
    private int maxAge = -1;
    private int version = 0;
    private boolean isHttpOnly = false;

    public Cookie(@NonNull String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (a(str) && !str.equalsIgnoreCase("Comment") && !str.equalsIgnoreCase("Discard") && !str.equalsIgnoreCase("Domain") && !str.equalsIgnoreCase("Expires") && !str.equalsIgnoreCase("Max-Age") && !str.equalsIgnoreCase("Path") && !str.equalsIgnoreCase("Secure") && !str.equalsIgnoreCase("Version") && !str.startsWith("$")) {
                this.name = str;
                this.value = str2;
                return;
            }
            throw new IllegalArgumentException(String.format("This name [%1$s] is a reserved character.", str));
        }
        throw new IllegalArgumentException("The name of the cookie cannot be empty or null.");
    }

    private boolean a(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < ' ' || charAt >= '\u007f' || "/()<>@,;:\\\"[]?={} \t".indexOf(charAt) != -1) {
                return false;
            }
        }
        return true;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16.getMessage());
        }
    }

    @Nullable
    public String getComment() {
        return this.comment;
    }

    @Nullable
    public String getDomain() {
        return this.domain;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getPath() {
        return this.path;
    }

    public boolean getSecure() {
        return this.secure;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isHttpOnly() {
        return this.isHttpOnly;
    }

    public void setComment(@Nullable String str) {
        this.comment = str;
    }

    public void setDomain(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.domain = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.domain = null;
        }
    }

    public void setHttpOnly(boolean z16) {
        this.isHttpOnly = z16;
    }

    public void setMaxAge(int i3) {
        this.maxAge = i3;
    }

    public void setPath(@Nullable String str) {
        this.path = str;
    }

    public void setSecure(boolean z16) {
        this.secure = z16;
    }

    public void setValue(@Nullable String str) {
        this.value = str;
    }

    public void setVersion(int i3) {
        this.version = i3;
    }
}
