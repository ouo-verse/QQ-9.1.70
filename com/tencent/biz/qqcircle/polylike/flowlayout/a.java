package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private List<T> f91603a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0921a f91604b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    private HashSet<Integer> f91605c = new HashSet<>();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.polylike.flowlayout.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    interface InterfaceC0921a {
    }

    public a(List<T> list) {
        this.f91603a = list;
    }

    public int a() {
        List<T> list = this.f91603a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T b(int i3) {
        return this.f91603a.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public HashSet<Integer> c() {
        return this.f91605c;
    }

    public abstract View d(QCircleFlowLayout qCircleFlowLayout, int i3, T t16);

    public void e(int i3, View view) {
        QLog.d("zhy", 1, "onSelected " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(InterfaceC0921a interfaceC0921a) {
        this.f91604b = interfaceC0921a;
    }

    public boolean g(int i3, T t16) {
        return false;
    }

    public void h(int i3, View view) {
        QLog.d("zhy", 1, "unSelected " + i3);
    }
}
