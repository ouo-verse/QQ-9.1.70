package com.tencent.oskplayer.util.apache;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class InetAddressValidator implements Serializable {
    private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    private static final InetAddressValidator VALIDATOR = new InetAddressValidator();
    private static final long serialVersionUID = -919201640201914789L;
    private final RegexValidator ipv4Validator = new RegexValidator(IPV4_REGEX);

    public static InetAddressValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isValid(String str) {
        return isValidInet4Address(str);
    }

    public boolean isValidInet4Address(String str) {
        String[] match = this.ipv4Validator.match(str);
        if (match == null) {
            return false;
        }
        for (int i3 = 0; i3 <= 3; i3++) {
            String str2 = match[i3];
            if (str2 != null && str2.length() > 0) {
                try {
                    if (Integer.parseInt(str2) > 255) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }
}
