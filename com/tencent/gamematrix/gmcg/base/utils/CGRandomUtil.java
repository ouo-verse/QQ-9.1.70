package com.tencent.gamematrix.gmcg.base.utils;

import java.security.SecureRandom;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGRandomUtil {
    public static String getRandomString(int i3) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < i3; i16++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static long random(int i3) {
        StringBuilder sb5 = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(secureRandom.nextInt(10));
        }
        return Long.parseLong(sb5.toString());
    }
}
