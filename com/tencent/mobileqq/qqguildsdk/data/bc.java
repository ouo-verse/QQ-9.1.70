package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Long> f265725a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<Long> f265726b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<bf> f265727c;

    /* renamed from: d, reason: collision with root package name */
    private final bz f265728d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<Long> f265729a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Long> f265730b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<bf> f265731c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        private bz f265732d = new bz.a().e();

        public bc e() {
            return new bc(this);
        }

        public a f(@Nullable List<String> list) {
            if (list != null) {
                this.f265729a = new ArrayList<>();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.f265729a.add(Long.valueOf(Long.parseLong(it.next())));
                }
            }
            return this;
        }

        public a g(@Nullable List<String> list) {
            if (list != null) {
                this.f265730b = new ArrayList<>();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.f265730b.add(Long.valueOf(Long.parseLong(it.next())));
                }
            }
            return this;
        }

        public a h(@Nullable bz bzVar) {
            if (bzVar != null) {
                this.f265732d = bzVar;
            }
            return this;
        }
    }

    bc(a aVar) {
        this.f265725a = aVar.f265729a;
        this.f265726b = aVar.f265730b;
        this.f265727c = aVar.f265731c;
        this.f265728d = aVar.f265732d;
    }

    public ArrayList<Long> a() {
        return this.f265725a;
    }

    public ArrayList<Long> b() {
        return this.f265726b;
    }

    public bz c() {
        return this.f265728d;
    }

    public ArrayList<bf> d() {
        return this.f265727c;
    }

    public String toString() {
        return "GProMsgSearchCondParams{mChannelIds=" + this.f265725a + ", mFromTinyIds=" + this.f265726b + ", mTimeRanges=" + this.f265727c + ", mSeqCond=" + this.f265728d + '}';
    }
}
