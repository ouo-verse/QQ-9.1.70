package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Request implements Comparable<Request> {
    private j C;

    @GuardedBy("mLock")
    private a E;
    private final int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private final String f345420d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, String> f345421e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f345422f;

    /* renamed from: h, reason: collision with root package name */
    private final int f345423h;

    /* renamed from: m, reason: collision with root package name */
    private Integer f345425m;

    /* renamed from: i, reason: collision with root package name */
    private final Object f345424i = new Object();

    @GuardedBy("mLock")
    private boolean D = false;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface Priority {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(Request request, k kVar);

        void b(Request request, IOException iOException);
    }

    public Request(int i3, @Nullable String str, Map<String, String> map, byte[] bArr, int i16, a aVar) {
        this.G = i3;
        this.f345420d = str;
        this.f345422f = bArr;
        this.F = i16 <= 0 ? 8000 : i16;
        this.f345421e = map;
        this.E = aVar;
        this.f345423h = f(str);
    }

    private static int f(String str) {
        Uri parse;
        String host;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            return host.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(Request request) {
        int priority = getPriority();
        int priority2 = request.getPriority();
        if (priority == priority2) {
            return this.f345425m.intValue() - request.f345425m.intValue();
        }
        return priority2 - priority;
    }

    public void d(IOException iOException) {
        a aVar;
        synchronized (this.f345424i) {
            aVar = this.E;
        }
        if (aVar != null) {
            aVar.b(this, iOException);
        }
    }

    public void e(k kVar) {
        a aVar;
        synchronized (this.f345424i) {
            aVar = this.E;
        }
        if (aVar != null) {
            aVar.a(this, kVar);
        }
    }

    @Priority
    public int getPriority() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    public Map<String, String> i() {
        return this.f345421e;
    }

    public int j() {
        return this.G;
    }

    public byte[] k() {
        return this.f345422f;
    }

    public int l() {
        return this.F;
    }

    public int m() {
        return this.f345423h;
    }

    public String n() {
        return this.f345420d;
    }

    public boolean o() {
        boolean z16;
        synchronized (this.f345424i) {
            z16 = this.D;
        }
        return z16;
    }

    public Request p(j jVar) {
        this.C = jVar;
        return this;
    }

    public final Request q(int i3) {
        this.f345425m = Integer.valueOf(i3);
        return this;
    }

    public String toString() {
        String str;
        String str2 = RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(m());
        StringBuilder sb5 = new StringBuilder();
        if (o()) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb5.append(str);
        sb5.append(n());
        sb5.append(" ");
        sb5.append(str2);
        sb5.append(" ");
        sb5.append(getPriority());
        sb5.append(" ");
        sb5.append(this.f345425m);
        return sb5.toString();
    }
}
