package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MultiThreadManager {
    public static final int DEFAULT_ENHANCE_THREAD_NUMS = 3;
    public static final int MAX_ENHANCE_THREAD_NUMS = 20;

    /* renamed from: e, reason: collision with root package name */
    private static volatile MultiThreadManager f107401e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f107402a = false;

    /* renamed from: b, reason: collision with root package name */
    private long f107403b = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;

    /* renamed from: c, reason: collision with root package name */
    private long f107404c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f107405d = 0;

    public static MultiThreadManager getInstance() {
        if (f107401e == null) {
            synchronized (MultiThreadManager.class) {
                if (f107401e == null) {
                    f107401e = new MultiThreadManager();
                }
            }
        }
        return f107401e;
    }

    public int getEnhanceThreadNums() {
        int i3 = this.f107405d;
        if (i3 > 0 && i3 <= 20) {
            return i3;
        }
        return 3;
    }

    public long getMultiThreadDownFileSize() {
        long j3 = this.f107404c;
        if (j3 > 0) {
            return j3;
        }
        return this.f107403b;
    }

    public boolean isMultiTheadDownOpen() {
        return this.f107402a;
    }

    public void setEnhanceThreadNums(int i3) {
        int i16;
        if (getMultiThreadDownFileSize() > 0) {
            i16 = g.a(i3, 0, 20);
        } else {
            i16 = 3;
        }
        this.f107405d = i16;
    }

    public void setMultiTheadDownOpen(boolean z16) {
        this.f107402a = z16;
    }

    public void setMultiThreadDownFileSize(long j3) {
        this.f107404c = j3;
    }
}
