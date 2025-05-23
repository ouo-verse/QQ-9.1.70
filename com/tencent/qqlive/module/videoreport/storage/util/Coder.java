package com.tencent.qqlive.module.videoreport.storage.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Coder {
    <T> T decode(String str, Class<T> cls);

    String encode(Object obj);
}
