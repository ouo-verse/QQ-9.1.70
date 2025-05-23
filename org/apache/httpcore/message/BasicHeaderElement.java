package org.apache.httpcore.message;

import com.huawei.hms.framework.common.ContainerUtils;
import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.NameValuePair;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.LangUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicHeaderElement implements HeaderElement, Cloneable {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
        if (nameValuePairArr != null) {
            this.parameters = nameValuePairArr;
        } else {
            this.parameters = new NameValuePair[0];
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderElement)) {
            return false;
        }
        BasicHeaderElement basicHeaderElement = (BasicHeaderElement) obj;
        if (this.name.equals(basicHeaderElement.name) && LangUtils.equals(this.value, basicHeaderElement.value) && LangUtils.equals((Object[]) this.parameters, (Object[]) basicHeaderElement.parameters)) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // org.apache.httpcore.HeaderElement
    public NameValuePair getParameter(int i3) {
        return this.parameters[i3];
    }

    @Override // org.apache.httpcore.HeaderElement
    public NameValuePair getParameterByName(String str) {
        Args.notNull(str, "Name");
        for (NameValuePair nameValuePair : this.parameters) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair;
            }
        }
        return null;
    }

    @Override // org.apache.httpcore.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // org.apache.httpcore.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // org.apache.httpcore.HeaderElement
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        for (NameValuePair nameValuePair : this.parameters) {
            hashCode = LangUtils.hashCode(hashCode, nameValuePair);
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.name);
        if (this.value != null) {
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.value);
        }
        for (NameValuePair nameValuePair : this.parameters) {
            sb5.append("; ");
            sb5.append(nameValuePair);
        }
        return sb5.toString();
    }

    public BasicHeaderElement(String str, String str2) {
        this(str, str2, null);
    }
}
