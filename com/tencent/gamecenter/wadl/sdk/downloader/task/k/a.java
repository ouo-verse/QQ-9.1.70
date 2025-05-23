package com.tencent.gamecenter.wadl.sdk.downloader.task.k;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.e.g;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static EnumC1136a[] f107606g;

    /* renamed from: h, reason: collision with root package name */
    public static EnumC1136a[] f107607h;

    /* renamed from: a, reason: collision with root package name */
    public String f107608a;

    /* renamed from: b, reason: collision with root package name */
    public EnumC1136a f107609b;

    /* renamed from: c, reason: collision with root package name */
    public int f107610c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f107611d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f107612e = "";

    /* renamed from: f, reason: collision with root package name */
    public boolean f107613f = false;

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC1136a {
        Type_Outer,
        Type_CDN_Domain,
        Type_CDN_Ip_App_Input,
        Type_CDN_Ip_Jumped,
        Type_CDN_Ip_Http_Header,
        Type_CDN_Ip_Socket_Schedule,
        Type_Src_Domain,
        Type_Src_Ip_App_Input,
        Type_Src_Ip_Jumped,
        Type_CDN_Ip_Socket_Schedule_Https,
        Type_CDN_Ip_Local_Dns,
        Type_CDN_Ip_User_Https
    }

    static {
        EnumC1136a enumC1136a = EnumC1136a.Type_CDN_Ip_Local_Dns;
        EnumC1136a enumC1136a2 = EnumC1136a.Type_CDN_Ip_App_Input;
        EnumC1136a enumC1136a3 = EnumC1136a.Type_CDN_Domain;
        EnumC1136a enumC1136a4 = EnumC1136a.Type_CDN_Ip_Socket_Schedule;
        EnumC1136a enumC1136a5 = EnumC1136a.Type_CDN_Ip_Http_Header;
        EnumC1136a enumC1136a6 = EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https;
        EnumC1136a enumC1136a7 = EnumC1136a.Type_CDN_Ip_Jumped;
        EnumC1136a enumC1136a8 = EnumC1136a.Type_Src_Ip_App_Input;
        EnumC1136a enumC1136a9 = EnumC1136a.Type_Src_Ip_Jumped;
        EnumC1136a enumC1136a10 = EnumC1136a.Type_Src_Domain;
        f107606g = new EnumC1136a[]{enumC1136a, enumC1136a2, enumC1136a3, enumC1136a4, enumC1136a5, enumC1136a6, enumC1136a7, enumC1136a8, enumC1136a9, enumC1136a10};
        f107607h = new EnumC1136a[]{enumC1136a, enumC1136a4, enumC1136a2, enumC1136a5, enumC1136a7, enumC1136a6, enumC1136a3, enumC1136a8, enumC1136a9, enumC1136a10};
    }

    public a(String str, EnumC1136a enumC1136a) {
        this.f107608a = str;
        this.f107609b = enumC1136a;
    }

    public static EnumC1136a a(EnumC1136a enumC1136a, boolean z16) {
        EnumC1136a[] enumC1136aArr = z16 ? f107606g : f107607h;
        EnumC1136a enumC1136a2 = enumC1136aArr[0];
        if (enumC1136a == null) {
            return enumC1136a2;
        }
        for (int i3 = 0; i3 < enumC1136aArr.length; i3++) {
            if (enumC1136a == enumC1136aArr[i3] && i3 != enumC1136aArr.length - 1) {
                return enumC1136aArr[i3 + 1];
            }
        }
        return enumC1136a2;
    }

    public static boolean b(EnumC1136a enumC1136a) {
        if (enumC1136a != EnumC1136a.Type_CDN_Ip_App_Input && enumC1136a != EnumC1136a.Type_CDN_Ip_Http_Header && enumC1136a != EnumC1136a.Type_CDN_Ip_Socket_Schedule && enumC1136a != EnumC1136a.Type_Src_Ip_App_Input && enumC1136a != EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https && enumC1136a != EnumC1136a.Type_CDN_Ip_Local_Dns) {
            return false;
        }
        return true;
    }

    public String toString() {
        boolean z16;
        EnumC1136a enumC1136a = this.f107609b;
        if (enumC1136a != EnumC1136a.Type_CDN_Ip_Http_Header && enumC1136a != EnumC1136a.Type_CDN_Ip_Socket_Schedule && enumC1136a != EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https && enumC1136a != EnumC1136a.Type_CDN_Ip_App_Input && enumC1136a != EnumC1136a.Type_Src_Ip_App_Input) {
            z16 = false;
        } else {
            z16 = true;
        }
        return "" + this.f107610c + ":" + this.f107609b.ordinal() + ":" + g.a(this.f107608a, z16);
    }

    public String a() {
        return !TextUtils.isEmpty(this.f107612e) ? this.f107612e : this.f107608a;
    }

    public void a(int i3) {
        this.f107610c = i3;
    }

    public static boolean a(EnumC1136a enumC1136a) {
        return enumC1136a == EnumC1136a.Type_CDN_Ip_App_Input || enumC1136a == EnumC1136a.Type_CDN_Ip_Jumped || enumC1136a == EnumC1136a.Type_CDN_Ip_Http_Header || enumC1136a == EnumC1136a.Type_CDN_Ip_Socket_Schedule || enumC1136a == EnumC1136a.Type_Src_Ip_App_Input || enumC1136a == EnumC1136a.Type_Src_Ip_Jumped || enumC1136a == EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https || enumC1136a == EnumC1136a.Type_CDN_Ip_Local_Dns;
    }
}
