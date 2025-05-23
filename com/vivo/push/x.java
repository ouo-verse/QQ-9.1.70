package com.vivo.push;

import android.net.Uri;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f387937a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f387938b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f387939c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f387940d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f387941e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f387942f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    public static String a(int i3) {
        switch (i3) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
