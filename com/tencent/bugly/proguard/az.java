package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.common.utils.ContextUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class az {

    /* renamed from: g, reason: collision with root package name */
    private static WeakReference<az> f98149g;

    /* renamed from: a, reason: collision with root package name */
    public MappedByteBuffer f98150a;

    /* renamed from: b, reason: collision with root package name */
    public FileChannel f98151b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f98152c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f98153d = false;

    /* renamed from: e, reason: collision with root package name */
    public final ai f98154e;

    /* renamed from: f, reason: collision with root package name */
    public final String f98155f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f98158a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f98159b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f98160c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f98161d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f98162e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f98163f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f98164g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final int f98165h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final int f98166i = 9;

        /* renamed from: j, reason: collision with root package name */
        public static final int f98167j = 10;

        /* renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ int[] f98168k = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final int f98169a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f98170b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f98171c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f98172d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f98173e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f98174f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f98175g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final int f98176h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final int f98177i = 9;

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ int[] f98178j = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    az(Context context) {
        ai a16 = ai.a(context);
        this.f98154e = a16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("bugly_crash_processing");
        sb5.append(str);
        sb5.append(a16.f98016d);
        sb5.append("_process_record.txt");
        this.f98155f = sb5.toString();
    }

    public static synchronized az a() {
        az azVar;
        synchronized (az.class) {
            WeakReference<az> weakReference = f98149g;
            azVar = weakReference != null ? weakReference.get() : null;
            if (azVar == null) {
                azVar = new az(ContextUtil.getGlobalContext());
                f98149g = new WeakReference<>(azVar);
            }
        }
        return azVar;
    }

    public final void a(int i3, boolean z16, boolean z17) {
        if (z17 && this.f98152c && !this.f98153d) {
            try {
                MappedByteBuffer mappedByteBuffer = this.f98150a;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.put(0, Integer.toString(i3).getBytes()[0]);
                    if (z16) {
                        this.f98150a.put(2, (byte) 49);
                    }
                    this.f98150a.force();
                }
            } catch (Exception e16) {
                av.e("update processing file failed!\n".concat(String.valueOf(e16)), new Object[0]);
            }
        }
    }

    public final void a(int i3, boolean z16) {
        if (!z16 || !this.f98152c || this.f98153d || i3 < 0 || i3 >= 16) {
            return;
        }
        try {
            MappedByteBuffer mappedByteBuffer = this.f98150a;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(i3 + 6, (byte) 49);
                this.f98150a.force();
            }
        } catch (Throwable th5) {
            av.e("update attachment info in processing record failed, ".concat(String.valueOf(th5)), new Object[0]);
        }
    }
}
