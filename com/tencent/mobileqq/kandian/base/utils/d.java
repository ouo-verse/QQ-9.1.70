package com.tencent.mobileqq.kandian.base.utils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final BigInteger f239077a = BigInteger.ONE.shiftLeft(64);

    public static Properties a(String str) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(str));
            return properties;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
