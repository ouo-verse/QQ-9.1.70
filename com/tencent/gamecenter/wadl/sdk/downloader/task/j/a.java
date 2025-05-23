package com.tencent.gamecenter.wadl.sdk.downloader.task.j;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<C1135a> f107605a = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1135a {
        public C1135a(long j3, int i3, String str) {
            if (!TextUtils.isEmpty(str)) {
                g.a(str);
            }
        }
    }

    public void a(C1135a c1135a) {
        synchronized (this.f107605a) {
            if (this.f107605a.size() < 20) {
                this.f107605a.add(c1135a);
            }
        }
    }
}
