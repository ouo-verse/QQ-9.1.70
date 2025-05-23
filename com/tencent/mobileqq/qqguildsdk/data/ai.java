package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    protected String f265673a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Integer> f265674b = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265675a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Integer> f265676b;

        public ai c() {
            return new ai(this);
        }

        public a d(ArrayList<Integer> arrayList) {
            this.f265676b = arrayList;
            return this;
        }

        public a e(String str) {
            this.f265675a = str;
            return this;
        }
    }

    ai(a aVar) {
        d(aVar.f265675a);
        c(aVar.f265676b);
    }

    public ArrayList<Integer> a() {
        return this.f265674b;
    }

    public String b() {
        return this.f265673a;
    }

    public void c(ArrayList<Integer> arrayList) {
        this.f265674b = arrayList;
    }

    public void d(String str) {
        this.f265673a = str;
    }

    public String toString() {
        return "GProGetLiveAudioPollingInfoReqInfo{guildId=" + this.f265673a + "categoryTypeList=" + this.f265674b + "}";
    }
}
