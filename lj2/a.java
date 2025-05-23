package lj2;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.File;
import lj2.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f414861a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f414862b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f414863c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f414864d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f414865e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f414866f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f414867g;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c.a.f414882b);
        String str = File.separator;
        sb5.append(str);
        sb5.append("editor");
        String sb6 = sb5.toString();
        f414861a = sb6;
        f414862b = sb6 + str + DKConfiguration.Directory.RESOURCES;
        f414863c = sb6 + str + QQWinkConstants.TAB_EFFECT;
        f414864d = sb6 + str + "generated_images";
        f414865e = sb6 + str + "generated_videos";
        String str2 = c.a.f414881a + str + "editor";
        f414866f = str2;
        f414867g = str2 + str + "generated_videos" + str + "cover";
    }
}
