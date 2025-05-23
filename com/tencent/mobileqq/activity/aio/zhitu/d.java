package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg$ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f180396a;

    /* renamed from: b, reason: collision with root package name */
    public String f180397b;

    /* renamed from: c, reason: collision with root package name */
    public String f180398c;

    /* renamed from: d, reason: collision with root package name */
    public int f180399d;

    /* renamed from: e, reason: collision with root package name */
    public String f180400e;

    /* renamed from: f, reason: collision with root package name */
    public String f180401f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f180402g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f180403h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f180404i = false;

    public ZhituReportMsg$ReqBody a() {
        if (this.f180396a == null) {
            this.f180396a = "";
        }
        if (this.f180398c == null) {
            this.f180398c = "";
        }
        if (this.f180397b == null) {
            this.f180397b = "";
        }
        if (this.f180400e == null) {
            this.f180400e = "";
        }
        if (this.f180401f == null) {
            this.f180401f = "";
        }
        if (this.f180402g == null) {
            this.f180402g = "";
        }
        if (this.f180403h == null) {
            this.f180403h = "";
        }
        ZhituReportMsg$ReqBody zhituReportMsg$ReqBody = new ZhituReportMsg$ReqBody();
        zhituReportMsg$ReqBody.bytes_pass.set(ByteStringMicro.copyFromUtf8(this.f180396a));
        zhituReportMsg$ReqBody.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.f180397b));
        zhituReportMsg$ReqBody.bytes_style.set(ByteStringMicro.copyFromUtf8(this.f180398c));
        zhituReportMsg$ReqBody.uint32_action.set(this.f180399d);
        zhituReportMsg$ReqBody.bytes_aio_type.set(ByteStringMicro.copyFromUtf8(this.f180400e));
        zhituReportMsg$ReqBody.bytes_mobile_type.set(ByteStringMicro.copyFromUtf8("android"));
        zhituReportMsg$ReqBody.bytes_current_text.set(ByteStringMicro.copyFromUtf8(this.f180401f));
        return zhituReportMsg$ReqBody;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ZhituReportData{pass='");
        sb5.append(this.f180396a);
        sb5.append('\'');
        sb5.append(", imgId='");
        sb5.append(this.f180397b);
        sb5.append('\'');
        sb5.append(", styles='");
        sb5.append(this.f180398c);
        sb5.append('\'');
        sb5.append(", action=");
        sb5.append(this.f180399d);
        sb5.append(", aioType='");
        sb5.append(this.f180400e);
        sb5.append('\'');
        sb5.append(", queryText='");
        String str3 = this.f180401f;
        String str4 = "null";
        if (str3 == null) {
            str = "null";
        } else {
            str = com.tencent.securitysdk.utils.c.b(str3);
        }
        sb5.append(str);
        sb5.append('\'');
        sb5.append(", lastMessage='");
        String str5 = this.f180402g;
        if (str5 == null) {
            str2 = "null";
        } else {
            str2 = com.tencent.securitysdk.utils.c.b(str5);
        }
        sb5.append(str2);
        sb5.append('\'');
        sb5.append(", lastTwoMessage='");
        String str6 = this.f180403h;
        if (str6 != null) {
            str4 = com.tencent.securitysdk.utils.c.b(str6);
        }
        sb5.append(str4);
        sb5.append('\'');
        sb5.append(", isReported=");
        sb5.append(this.f180404i);
        sb5.append('}');
        return sb5.toString();
    }
}
