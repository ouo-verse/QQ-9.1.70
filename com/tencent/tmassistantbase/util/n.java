package com.tencent.tmassistantbase.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public String f380483a;

    /* renamed from: b, reason: collision with root package name */
    public String f380484b;

    /* renamed from: c, reason: collision with root package name */
    public String f380485c;

    /* renamed from: d, reason: collision with root package name */
    public String f380486d;

    /* renamed from: e, reason: collision with root package name */
    public String f380487e;

    /* renamed from: f, reason: collision with root package name */
    public String f380488f;

    /* renamed from: g, reason: collision with root package name */
    public int f380489g;

    /* renamed from: h, reason: collision with root package name */
    public int f380490h;

    /* renamed from: i, reason: collision with root package name */
    public int f380491i;

    private String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(this.f380484b.subSequence(0, 1));
        stringBuffer.append(this.f380485c);
        return stringBuffer.toString();
    }

    public String a() {
        String b16 = b();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TMASDK_");
        stringBuffer.append(this.f380484b);
        if (!TextUtils.isEmpty(this.f380486d)) {
            stringBuffer.append("_");
            stringBuffer.append(this.f380486d);
        }
        stringBuffer.append("/");
        stringBuffer.append(b16);
        stringBuffer.append("&NA/");
        stringBuffer.append(b16);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append(this.f380488f);
        stringBuffer.append("_");
        stringBuffer.append(this.f380491i);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append(this.f380489g / 16);
        stringBuffer.append("_");
        stringBuffer.append(this.f380490h / 16);
        stringBuffer.append("_");
        stringBuffer.append("14&");
        stringBuffer.append(this.f380483a);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append(this.f380487e);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append("NA");
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append("V3");
        return stringBuffer.toString();
    }
}
