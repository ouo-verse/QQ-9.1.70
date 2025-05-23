package com.qzone.app;

import com.qzone.luan.LuanIndexInjectInfoService;
import com.tencent.luan.core.LuanLog;
import com.tencent.luan.ioc.LuanInjectService;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements LuanLog.LuanLogInterface {

    /* renamed from: a, reason: collision with root package name */
    private final LuanInjectService f44487a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f44488a = new f();
    }

    f() {
        LuanLog.init(this);
        this.f44487a = new LuanIndexInjectInfoService().getModuleQZoneMainInjectServiceBuilder().setDebugMode(true).setClassLoader(f.class.getClassLoader()).create();
    }

    public static <T> T a(Class<T> cls) {
        return (T) a.f44488a.f44487a.get(cls, null, new Object[0]);
    }

    public static void b(Object obj) {
        a.f44488a.f44487a.inject(obj);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void e(String str, String str2) {
        QZLog.e(str, str2);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void i(String str, String str2) {
        QZLog.i(str, str2);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void w(String str, String str2) {
        QZLog.w(str, str2);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void d(String str, String str2) {
        QZLog.d(str, 2, str2);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void e(String str, String str2, Throwable th5) {
        QZLog.e(str, str2, th5);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void v(String str, String str2) {
        QZLog.d(str, 4, str2);
    }

    @Override // com.tencent.luan.core.LuanLog.LuanLogInterface
    public void w(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
    }
}
