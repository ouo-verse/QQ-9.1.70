package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class m implements f {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f283762a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f283763b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<g> f283764c;

    /* renamed from: d, reason: collision with root package name */
    private h f283765d;

    /* renamed from: e, reason: collision with root package name */
    private l f283766e = new l();

    /* renamed from: f, reason: collision with root package name */
    private String f283767f;

    /* renamed from: g, reason: collision with root package name */
    private int f283768g;

    @Override // com.tencent.mobileqq.search.rich.f
    public h b() {
        return this.f283765d;
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public void c(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3) {
        this.f283762a = qQAppInterface;
        this.f283763b = context;
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "create, serverdata:" + str + "  extredata:" + str2 + " config:" + str3 + " templateid:" + i3);
        }
        this.f283766e.a(true);
        this.f283766e.d(str);
        this.f283766e.c(str2);
        this.f283767f = str3;
        this.f283768g = i3;
        this.f283765d = i(context);
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public void d(g gVar) {
        this.f283764c = new WeakReference<>(gVar);
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "destroy");
        }
        j();
        this.f283762a = null;
        this.f283763b = null;
        this.f283764c = null;
        h hVar = this.f283765d;
        if (hVar != null) {
            hVar.destroy();
            this.f283765d = null;
        }
        this.f283767f = null;
        this.f283766e = null;
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public int e() {
        return this.f283768g;
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public void f(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "updateData, serverdata:" + str + "  extredata:" + str2 + " config:" + str3);
        }
        this.f283766e.d(str);
        this.f283766e.c(str2);
        this.f283767f = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str, String str2) {
        g gVar;
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "fireEvent, key:" + str + " value:" + str2);
        }
        WeakReference<g> weakReference = this.f283764c;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            gVar.d(this, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public String getData() {
        return this.f283766e.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        g gVar;
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
        }
        WeakReference<g> weakReference = this.f283764c;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            gVar.e(this);
        }
    }

    protected abstract h i(Context context);

    @Override // com.tencent.mobileqq.search.rich.f
    public void pause() {
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "pause");
        }
    }

    @Override // com.tencent.mobileqq.search.rich.f
    public void resume() {
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeBase", 2, "resume");
        }
    }

    protected void j() {
    }
}
