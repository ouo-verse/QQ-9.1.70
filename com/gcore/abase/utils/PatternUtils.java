package com.gcore.abase.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class PatternUtils {
    public static final String NO_MATCH = "EMPTY";

    public static List<String> getMatchGroup(String str, String str2, int i3) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(str2);
        while (matcher.find()) {
            arrayList.add(matcher.group(i3));
        }
        if (arrayList.size() <= 0) {
            arrayList.add(NO_MATCH);
        }
        return arrayList;
    }
}
