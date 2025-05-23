package ar;

import com.tencent.aelight.camera.ae.j;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26775a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f26776b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f26777c;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j.a.f65591b);
        String str = File.separator;
        sb5.append(str);
        sb5.append("ae_editor");
        sb5.append(str);
        sb5.append("pag");
        String sb6 = sb5.toString();
        f26775a = sb6;
        String str2 = sb6 + str + ToastView.ICON_LOADING;
        f26776b = str2;
        f26777c = str2 + str + "loading.zip";
    }
}
