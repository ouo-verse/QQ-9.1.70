package com.tencent.tmassistantsdk.internal.openSDK;

import com.tencent.tmassistant.common.ProtocolPackage;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static String a(String str) {
        return com.tencent.tmassistantbase.util.a.b(ProtocolPackage.encrypt(str.getBytes(), ProtocolPackage.CRYPT_KEY.getBytes()), 0);
    }
}
