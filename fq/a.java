package fq;

import fq.c;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f400292a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f400293b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f400294c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f400295d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f400296e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f400297f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f400298g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f400299h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f400300i;

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = c.a.f400306a;
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("camera");
        String sb6 = sb5.toString();
        f400292a = sb6;
        f400293b = str + str2 + "sv_config_resources" + str2;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append(str2);
        sb7.append("capture");
        f400294c = sb7.toString();
        f400295d = sb6 + str2 + "material_zip_download";
        f400296e = sb6 + str2 + "material_usable";
        f400297f = sb6 + str2 + "material_config";
        f400298g = sb6 + str2 + "material_zip_download_v2";
        f400299h = sb6 + str2 + "material_usable_v2";
        f400300i = sb6 + str2 + "material_config_v2";
    }
}
