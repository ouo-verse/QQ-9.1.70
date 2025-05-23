package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class l<E> extends AbstractQueue<E> implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: h, reason: collision with root package name */
    private static final long f250587h = -387911632671998426L;

    /* renamed from: a, reason: collision with root package name */
    transient e<E> f250588a;

    /* renamed from: b, reason: collision with root package name */
    transient e<E> f250589b;

    /* renamed from: c, reason: collision with root package name */
    private transient int f250590c;

    /* renamed from: d, reason: collision with root package name */
    private final int f250591d;

    /* renamed from: e, reason: collision with root package name */
    final ReentrantLock f250592e;

    /* renamed from: f, reason: collision with root package name */
    private final Condition f250593f;

    /* renamed from: g, reason: collision with root package name */
    private final Condition f250594g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private abstract class b implements Iterator<E> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        e<E> f250595a;

        /* renamed from: b, reason: collision with root package name */
        E f250596b;

        /* renamed from: c, reason: collision with root package name */
        private e<E> f250597c;

        b() {
            E e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                return;
            }
            ReentrantLock reentrantLock = l.this.f250592e;
            reentrantLock.lock();
            try {
                e<E> b16 = b();
                this.f250595a = b16;
                if (b16 == null) {
                    e16 = null;
                } else {
                    e16 = b16.f250601a;
                }
                this.f250596b = e16;
            } finally {
                reentrantLock.unlock();
            }
        }

        private e<E> b(e<E> eVar) {
            while (true) {
                e<E> a16 = a(eVar);
                if (a16 == null) {
                    return null;
                }
                if (a16.f250601a != null) {
                    return a16;
                }
                if (a16 == eVar) {
                    return b();
                }
                eVar = a16;
            }
        }

        abstract e<E> a(e<E> eVar);

        void a() {
            E e16;
            ReentrantLock reentrantLock = l.this.f250592e;
            reentrantLock.lock();
            try {
                e<E> b16 = b(this.f250595a);
                this.f250595a = b16;
                if (b16 == null) {
                    e16 = null;
                } else {
                    e16 = b16.f250601a;
                }
                this.f250596b = e16;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract e<E> b();

        @Override // java.util.Iterator
        public boolean hasNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.f250595a != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (E) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            e<E> eVar = this.f250595a;
            if (eVar != null) {
                this.f250597c = eVar;
                E e16 = this.f250596b;
                a();
                return e16;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            e<E> eVar = this.f250597c;
            if (eVar != null) {
                this.f250597c = null;
                ReentrantLock reentrantLock = l.this.f250592e;
                reentrantLock.lock();
                try {
                    if (eVar.f250601a != null) {
                        l.this.c((e) eVar);
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class c extends l<E>.b {
        static IPatchRedirector $redirector_;

        c() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
        }

        @Override // com.tencent.mobileqq.msf.sdk.l.b
        e<E> a(e<E> eVar) {
            return eVar.f250602b;
        }

        @Override // com.tencent.mobileqq.msf.sdk.l.b
        e<E> b() {
            return l.this.f250589b;
        }

        /* synthetic */ c(l lVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar, (Object) aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class d extends l<E>.b {
        static IPatchRedirector $redirector_;

        d() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
        }

        @Override // com.tencent.mobileqq.msf.sdk.l.b
        e<E> a(e<E> eVar) {
            return eVar.f250603c;
        }

        @Override // com.tencent.mobileqq.msf.sdk.l.b
        e<E> b() {
            return l.this.f250588a;
        }

        /* synthetic */ d(l lVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class e<E> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        E f250601a;

        /* renamed from: b, reason: collision with root package name */
        e<E> f250602b;

        /* renamed from: c, reason: collision with root package name */
        e<E> f250603c;

        e(E e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
            } else {
                this.f250601a = e16;
            }
        }
    }

    public l() {
        this(Integer.MAX_VALUE);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private boolean a(e<E> eVar) {
        int i3 = this.f250590c;
        if (i3 >= this.f250591d) {
            return false;
        }
        e<E> eVar2 = this.f250588a;
        eVar.f250603c = eVar2;
        this.f250588a = eVar;
        if (this.f250589b == null) {
            this.f250589b = eVar;
        } else {
            eVar2.f250602b = eVar;
        }
        this.f250590c = i3 + 1;
        this.f250593f.signal();
        return true;
    }

    private boolean b(e<E> eVar) {
        int i3 = this.f250590c;
        if (i3 >= this.f250591d) {
            return false;
        }
        e<E> eVar2 = this.f250589b;
        eVar.f250602b = eVar2;
        this.f250589b = eVar;
        if (this.f250588a == null) {
            this.f250588a = eVar;
        } else {
            eVar2.f250603c = eVar;
        }
        this.f250590c = i3 + 1;
        this.f250593f.signal();
        return true;
    }

    private E o() {
        e<E> eVar = this.f250588a;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f250603c;
        E e16 = eVar.f250601a;
        eVar.f250601a = null;
        eVar.f250603c = eVar;
        this.f250588a = eVar2;
        if (eVar2 == null) {
            this.f250589b = null;
        } else {
            eVar2.f250602b = null;
        }
        this.f250590c--;
        this.f250594g.signal();
        return e16;
    }

    private E p() {
        e<E> eVar = this.f250589b;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f250602b;
        E e16 = eVar.f250601a;
        eVar.f250601a = null;
        eVar.f250602b = eVar;
        this.f250589b = eVar2;
        if (eVar2 == null) {
            this.f250588a = null;
        } else {
            eVar2.f250603c = null;
        }
        this.f250590c--;
        this.f250594g.signal();
        return e16;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) e16)).booleanValue();
        }
        b((l<E>) e16);
        return true;
    }

    void c(e<E> eVar) {
        e<E> eVar2 = eVar.f250602b;
        e<E> eVar3 = eVar.f250603c;
        if (eVar2 == null) {
            o();
            return;
        }
        if (eVar3 == null) {
            p();
            return;
        }
        eVar2.f250603c = eVar3;
        eVar3.f250602b = eVar2;
        eVar.f250601a = null;
        this.f250590c--;
        this.f250594g.signal();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f250588a;
            while (eVar != null) {
                eVar.f250601a = null;
                e<E> eVar2 = eVar.f250603c;
                eVar.f250602b = null;
                eVar.f250603c = null;
                eVar = eVar2;
            }
            this.f250589b = null;
            this.f250588a = null;
            this.f250590c = 0;
            this.f250594g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f250588a; eVar != null; eVar = eVar.f250603c) {
                if (obj.equals(eVar.f250601a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean d(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) e16)).booleanValue();
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return b((e) eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (E) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f250589b;
            return eVar == null ? null : eVar.f250601a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (E) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return b();
    }

    public E f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (E) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return o();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void g(E e16) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) e16);
            return;
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        while (!a((e) eVar)) {
            try {
                this.f250594g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void h(E e16) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) e16);
            return;
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        while (!b((e) eVar)) {
            try {
                this.f250594g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean i(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f250588a; eVar != null; eVar = eVar.f250603c) {
                if (obj.equals(eVar.f250601a)) {
                    c((e) eVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Iterator) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return new d(this, null);
    }

    public E j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (E) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        E f16 = f();
        if (f16 != null) {
            return f16;
        }
        throw new NoSuchElementException();
    }

    public E k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (E) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        E g16 = g();
        if (g16 != null) {
            return g16;
        }
        throw new NoSuchElementException();
    }

    public E l() throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (E) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return m();
    }

    public E m() throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (E) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        while (true) {
            try {
                E o16 = o();
                if (o16 == null) {
                    this.f250593f.await();
                } else {
                    return o16;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E n() throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (E) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        while (true) {
            try {
                E p16 = p();
                if (p16 == null) {
                    this.f250593f.await();
                } else {
                    return p16;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.Queue
    public boolean offer(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) e16)).booleanValue();
        }
        return d(e16);
    }

    @Override // java.util.Queue
    public E peek() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (E) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return d();
    }

    @Override // java.util.Queue
    public E poll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (E) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return f();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? j() : (E) iPatchRedirector.redirect((short) 30, (Object) this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return this.f250590c;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (Object[]) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f250590c];
            e<E> eVar = this.f250588a;
            int i3 = 0;
            while (eVar != null) {
                int i16 = i3 + 1;
                objArr[i3] = eVar.f250601a;
                eVar = eVar.f250603c;
                i3 = i16;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f250588a;
            if (eVar == null) {
                reentrantLock.unlock();
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append('[');
            while (true) {
                Object obj = eVar.f250601a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb5.append(obj);
                eVar = eVar.f250603c;
                if (eVar == null) {
                    sb5.append(']');
                    return sb5.toString();
                }
                sb5.append(',');
                sb5.append(TokenParser.SP);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f250592e = reentrantLock;
        this.f250593f = reentrantLock.newCondition();
        this.f250594g = reentrantLock.newCondition();
        if (i3 > 0) {
            this.f250591d = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) ? i(obj) : ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, obj)).booleanValue();
    }

    public boolean j(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f250589b; eVar != null; eVar = eVar.f250602b) {
                if (obj.equals(eVar.f250601a)) {
                    c((e) eVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void e(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            a((l<E>) e16);
        } else {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) e16);
        }
    }

    public void f(E e16) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            h(e16);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) e16);
        }
    }

    public l(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) collection);
            return;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            for (E e16 : collection) {
                if (e16 != null) {
                    if (!b((e) new e<>(e16))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public E d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (E) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f250588a;
            return eVar == null ? null : eVar.f250601a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (E) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return p();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) ? j() : (E) iPatchRedirector.redirect((short) 40, (Object) this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 45, (Object) this, (Object) tArr));
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f250590c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f250590c));
            }
            e<E> eVar = this.f250588a;
            int i3 = 0;
            while (eVar != null) {
                tArr[i3] = eVar.f250601a;
                eVar = eVar.f250603c;
                i3++;
            }
            if (tArr.length > i3) {
                tArr[i3] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16);
        } else if (!c((l<E>) e16)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void b(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) e16);
        } else if (!d(e16)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean c(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) e16)).booleanValue();
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return a((e) eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            return this.f250591d - this.f250590c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean a(E e16, long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? c(e16, j3, timeUnit) : ((Boolean) iPatchRedirector.redirect((short) 29, this, e16, Long.valueOf(j3), timeUnit)).booleanValue();
    }

    public boolean b(E e16, long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, e16, Long.valueOf(j3), timeUnit)).booleanValue();
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        long nanos = timeUnit.toNanos(j3);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lockInterruptibly();
        while (!a((e) eVar)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.f250594g.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    public E a(long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? b(j3, timeUnit) : (E) iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), timeUnit);
    }

    public int a(Collection<? super E> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) ? a(collection, Integer.MAX_VALUE) : ((Integer) iPatchRedirector.redirect((short) 37, (Object) this, (Object) collection)).intValue();
    }

    public int a(Collection<? super E> collection, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this, (Object) collection, i3)).intValue();
        }
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i3 <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            int min = Math.min(i3, this.f250590c);
            for (int i16 = 0; i16 < min; i16++) {
                collection.add(this.f250588a.f250601a);
                o();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean c(E e16, long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, e16, Long.valueOf(j3), timeUnit)).booleanValue();
        }
        e16.getClass();
        e<E> eVar = new e<>(e16);
        long nanos = timeUnit.toNanos(j3);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lockInterruptibly();
        while (!b((e) eVar)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.f250594g.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    public E b(long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (E) iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), timeUnit);
        }
        long nanos = timeUnit.toNanos(j3);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E o16 = o();
                if (o16 != null) {
                    return o16;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f250593f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Iterator<E> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) ? new c(this, null) : (Iterator) iPatchRedirector.redirect((short) 49, (Object) this);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.f250588a; eVar != null; eVar = eVar.f250603c) {
                objectOutputStream.writeObject(eVar.f250601a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E c(long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (E) iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), timeUnit);
        }
        long nanos = timeUnit.toNanos(j3);
        ReentrantLock reentrantLock = this.f250592e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E p16 = p();
                if (p16 != null) {
                    return p16;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f250593f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (E) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        E d16 = d();
        if (d16 != null) {
            return d16;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f250590c = 0;
        this.f250588a = null;
        this.f250589b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }

    public E c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (E) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        E e16 = e();
        if (e16 != null) {
            return e16;
        }
        throw new NoSuchElementException();
    }
}
