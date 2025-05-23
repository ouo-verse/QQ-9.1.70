package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.network.pb.qqstory_struct$ErrorInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f94009a;

    /* renamed from: b, reason: collision with root package name */
    public String f94010b;

    public a() {
    }

    public a(qqstory_struct$ErrorInfo qqstory_struct_errorinfo) {
        this.f94009a = qqstory_struct_errorinfo.error_code.get();
        this.f94010b = qqstory_struct_errorinfo.error_desc.get().toStringUtf8();
    }
}
