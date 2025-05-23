package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.channel.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c<Respond extends com.tencent.biz.qqstory.channel.a> {

    /* renamed from: a, reason: collision with root package name */
    public a<Respond> f94015a;

    /* renamed from: b, reason: collision with root package name */
    public long f94016b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f94017c = 2;

    /* renamed from: d, reason: collision with root package name */
    public int f94018d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f94019e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a<T extends com.tencent.biz.qqstory.channel.a> {
        void a(int i3, String str, T t16);
    }

    public abstract String a();

    public int b() {
        int i3 = this.f94019e;
        String a16 = a();
        if (i3 == 0 && a16.length() > 0) {
            for (int i16 = 0; i16 < a16.length(); i16++) {
                i3 = (i3 * 31) + a16.charAt(i16);
            }
            this.f94019e = i3;
        }
        return i3;
    }

    public abstract com.tencent.biz.qqstory.channel.a c(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] d() throws QQStoryCmdHandler.IllegalUinException;

    public a<Respond> e() {
        return this.f94015a;
    }

    public void f(a<Respond> aVar) {
        this.f94015a = aVar;
    }
}
