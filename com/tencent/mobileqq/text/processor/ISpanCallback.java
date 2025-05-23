package com.tencent.mobileqq.text.processor;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface ISpanCallback {
    <T> T[] acquireSpans(int i3, int i16, Class<T> cls);

    void addSpan(Object obj, int i3, int i16, int i17);
}
