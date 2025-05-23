package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    private final String f265664a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f265665b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f265666c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f265667d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265668a = "";

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<String> f265669b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<String> f265670c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        private byte[] f265671d = new byte[0];

        public ag e() {
            return new ag(this);
        }

        public a f(ArrayList<String> arrayList) {
            this.f265669b = arrayList;
            return this;
        }

        public a g(String str) {
            this.f265668a = str;
            return this;
        }

        public a h(ArrayList<String> arrayList) {
            this.f265670c = arrayList;
            return this;
        }

        public a i(byte[] bArr) {
            this.f265671d = bArr;
            return this;
        }
    }

    ag(a aVar) {
        this.f265664a = aVar.f265668a;
        this.f265665b = aVar.f265669b;
        this.f265666c = aVar.f265670c;
        this.f265667d = aVar.f265671d;
    }

    public ArrayList<String> a() {
        return this.f265665b;
    }

    public String b() {
        return this.f265664a;
    }

    public ArrayList<String> c() {
        return this.f265666c;
    }

    public byte[] d() {
        return this.f265667d;
    }

    public boolean e() {
        if ((this.f265664a.isEmpty() || this.f265664a.equals("0") || this.f265665b.isEmpty()) && this.f265666c.isEmpty() && this.f265667d.length <= 0) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "GProFetchLiveRoomInfoParam{guildId='" + this.f265664a + "', channelIdList=" + this.f265665b + ", liveRoomIdList=" + this.f265666c + ", needDecodeDataSize=" + this.f265667d.length + '}';
    }
}
