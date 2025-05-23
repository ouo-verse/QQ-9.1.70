package com.qq.e.comm.plugin.base.media.a;

import android.widget.ImageView;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.base.media.a.e;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f39185a;

    protected c() {
    }

    public static c a() {
        if (f39185a == null) {
            synchronized (c.class) {
                if (f39185a == null) {
                    f39185a = new c();
                }
            }
        }
        return f39185a;
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, null);
    }

    public void a(String str, ImageView imageView, d dVar) {
        if (StringUtil.isEmpty(str)) {
            if (dVar != null) {
                dVar.a(str, imageView, 406);
            }
        } else {
            e.a aVar = new e.a();
            aVar.f39200a = str;
            aVar.f39201b = imageView;
            aVar.f39202c = dVar;
            GdtSDKThreadManager.getSubThreadHandler().post(new e(aVar));
        }
    }
}
