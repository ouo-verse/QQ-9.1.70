package org.apache.httpcore.message;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import org.apache.httpcore.NameValuePair;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.LangUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        if (this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value)) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.httpcore.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb5 = new StringBuilder(this.name.length() + 1 + this.value.length());
        sb5.append(this.name);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.value);
        return sb5.toString();
    }
}
