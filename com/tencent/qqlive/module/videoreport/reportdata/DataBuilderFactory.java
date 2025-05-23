package com.tencent.qqlive.module.videoreport.reportdata;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataBuilderFactory {
    public static IDataBuilder obtain() {
        return DataBuilderWithFormatter.getInstance();
    }
}
