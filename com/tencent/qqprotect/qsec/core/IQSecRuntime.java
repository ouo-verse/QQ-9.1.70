package com.tencent.qqprotect.qsec.core;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IQSecRuntime {
    Object getApplicationContext();

    Object getQQAppInterface();

    int getRuntimeVersion();

    IRuntimeInterface queryRuntimeInterface(String str);
}
