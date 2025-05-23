package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes2.dex */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String modifyString(char c16, String str, int i3) {
        if (i3 < str.length()) {
            return c16 + str.substring(i3);
        }
        return String.valueOf(c16);
    }

    static String separateCamelCase(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (Character.isUpperCase(charAt) && sb5.length() != 0) {
                sb5.append(str2);
            }
            sb5.append(charAt);
        }
        return sb5.toString();
    }

    static String upperCaseFirstLetter(String str) {
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i3 < length - 1 && !Character.isLetter(charAt)) {
            sb5.append(charAt);
            i3++;
            charAt = str.charAt(i3);
        }
        if (!Character.isUpperCase(charAt)) {
            sb5.append(modifyString(Character.toUpperCase(charAt), str, i3 + 1));
            return sb5.toString();
        }
        return str;
    }
}
