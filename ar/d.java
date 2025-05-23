package ar;

import com.tencent.aelight.camera.ae.j;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26768a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f26769b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f26770c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f26771d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f26772e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f26773f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f26774g;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j.a.f65591b);
        String str = File.separator;
        sb5.append(str);
        sb5.append("ae_editor");
        String sb6 = sb5.toString();
        f26768a = sb6;
        f26769b = sb6 + str + DKConfiguration.Directory.RESOURCES;
        f26770c = sb6 + str + QQWinkConstants.TAB_EFFECT;
        f26771d = sb6 + str + "generated_images";
        f26772e = sb6 + str + "generated_videos";
        String str2 = j.a.f65590a + str + "ae_editor";
        f26773f = str2;
        f26774g = str2 + str + "generated_videos" + str + "cover";
    }
}
