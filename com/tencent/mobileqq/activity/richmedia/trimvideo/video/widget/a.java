package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, c.b> f185972a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC7204a f185973b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7204a {
        void onChanged();
    }

    public a(InterfaceC7204a interfaceC7204a) {
        this.f185973b = interfaceC7204a;
    }

    public void a(c.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FrameAdapter", 2, "addFrame, index=" + bVar.f186002b);
        }
        this.f185972a.putIfAbsent(Integer.valueOf(bVar.f186002b), bVar);
        InterfaceC7204a interfaceC7204a = this.f185973b;
        if (interfaceC7204a != null) {
            interfaceC7204a.onChanged();
        }
    }

    public void b() {
        for (c.b bVar : this.f185972a.values()) {
            bVar.f186001a.recycle();
            bVar.f186001a = null;
        }
    }

    public c.b c(int i3) {
        return this.f185972a.get(Integer.valueOf(i3));
    }

    public boolean d() {
        if (this.f185972a.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        return this.f185972a.containsKey(Integer.valueOf(i3));
    }
}
