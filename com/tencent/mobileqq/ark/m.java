package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m {

    /* renamed from: e, reason: collision with root package name */
    private static volatile m f199510e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f199511a = false;

    /* renamed from: b, reason: collision with root package name */
    private bs f199512b = new a();

    /* renamed from: c, reason: collision with root package name */
    private long f199513c = -1;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.activity.aio.item.b> f199514d = null;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends bs {
        a() {
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onMsgRevokeNotice(boolean z16, List<MessageRecord> list, boolean z17) {
            m.a(m.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class b {
    }

    m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ b a(m mVar) {
        mVar.getClass();
        return null;
    }

    public static m d() {
        if (f199510e == null) {
            synchronized (m.class) {
                if (f199510e == null) {
                    f199510e = new m();
                }
            }
        }
        return f199510e;
    }

    public MessageForArkApp b() {
        return null;
    }

    public com.tencent.mobileqq.activity.aio.item.b c() {
        return null;
    }
}
