package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f31692a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final g f31693b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final g f31694c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final g f31695d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final g f31696e = new e();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends g {
        a() {
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean c(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class b extends g {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class c extends g {
        c() {
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean c(DataSource dataSource) {
            if (dataSource != DataSource.DATA_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class d extends g {
        d() {
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class e extends g {
        e() {
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean c(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // com.bumptech.glide.load.engine.g
        public boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (((z16 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED) {
                return true;
            }
            return false;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z16, DataSource dataSource, EncodeStrategy encodeStrategy);
}
