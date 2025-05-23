package com.samskivert.mustache;

import com.huawei.hms.framework.common.ContainerUtils;
import com.samskivert.mustache.Mustache;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Escapers {
    public static final Mustache.Escaper HTML = simple(new String[]{ContainerUtils.FIELD_DELIMITER, "&amp;"}, new String[]{"'", "&#39;"}, new String[]{"\"", "&quot;"}, new String[]{"<", "&lt;"}, new String[]{">", "&gt;"}, new String[]{"`", "&#x60;"}, new String[]{ContainerUtils.KEY_VALUE_DELIMITER, "&#x3D;"});
    public static final Mustache.Escaper NONE = new Mustache.Escaper() { // from class: com.samskivert.mustache.Escapers.1
        @Override // com.samskivert.mustache.Mustache.Escaper
        public String escape(String str) {
            return str;
        }
    };

    public static Mustache.Escaper simple(final String[]... strArr) {
        return new Mustache.Escaper() { // from class: com.samskivert.mustache.Escapers.2
            @Override // com.samskivert.mustache.Mustache.Escaper
            public String escape(String str) {
                for (String[] strArr2 : strArr) {
                    str = str.replace(strArr2[0], strArr2[1]);
                }
                return str;
            }
        };
    }
}
