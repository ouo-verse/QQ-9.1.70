package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.ka;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class kh<D extends ka> implements jz<D>, kg<D> {

    /* renamed from: a, reason: collision with root package name */
    private ReentrantReadWriteLock f148971a = new ReentrantReadWriteLock();

    @Override // com.tencent.mapsdk.internal.kg
    public final void b(String str, D d16) {
        try {
            this.f148971a.writeLock().lock();
            a(str, (String) d16);
        } finally {
            this.f148971a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final void j() {
        try {
            this.f148971a.writeLock().lock();
            b();
        } finally {
            this.f148971a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final long k() {
        try {
            this.f148971a.readLock().lock();
            return c();
        } finally {
            this.f148971a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final long l() {
        try {
            this.f148971a.readLock().lock();
            return d();
        } finally {
            this.f148971a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final D b(String str, Class<D> cls) {
        try {
            this.f148971a.readLock().lock();
            return a(str, cls);
        } finally {
            this.f148971a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final boolean b(String str) {
        try {
            this.f148971a.writeLock().lock();
            return a(str);
        } finally {
            this.f148971a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.kg
    public final kg<D> m() {
        return this;
    }
}
