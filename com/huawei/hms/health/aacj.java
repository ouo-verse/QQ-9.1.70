package com.huawei.hms.health;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.hihealth.data.AppLangItem;
import com.huawei.hms.hihealth.data.ScopeLangItem;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacj implements com.huawei.hms.hihealth.aabk {
    private static volatile aacj aab;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Callable<Void> {
        boolean aab;

        aab(boolean z16) {
            this.aab = z16;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabc().aab(this.aab);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aaba implements Callable<ScopeLangItem> {
        String aab;
        String aaba;

        aaba(String str, String str2) {
            this.aab = str;
            this.aaba = str2;
        }

        @Override // java.util.concurrent.Callable
        public ScopeLangItem call() throws Exception {
            return aack.aabf().aabc().aab(this.aaba, this.aab);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabb implements Callable<List<AppLangItem>> {
        int aab;
        String aaba;

        aabb(int i3, String str) {
            this.aab = i3;
            this.aaba = str;
        }

        @Override // java.util.concurrent.Callable
        public List<AppLangItem> call() throws Exception {
            return aack.aabf().aabc().aab(this.aaba, this.aab);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabc implements Callable<Map<String, String>> {
        List<String> aab;

        aabc(List<String> list) {
            this.aab = list;
        }

        @Override // java.util.concurrent.Callable
        public Map<String, String> call() throws Exception {
            return aack.aabf().aabc().aaba(this.aab);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabd implements Callable<Map<String, String>> {
        List<String> aab;

        aabd(List<String> list) {
            this.aab = list;
        }

        @Override // java.util.concurrent.Callable
        public Map<String, String> call() throws Exception {
            return aack.aabf().aabc().aab(this.aab);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabe implements Callable<Void> {
        String aab;
        List<String> aaba;

        aabe(String str, List<String> list) {
            this.aab = str;
            this.aaba = list;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabc().aab(this.aab, this.aaba);
            return null;
        }
    }

    aacj() {
    }

    public Task<Void> aab(String str) {
        Preconditions.checkNotNull(str, "Must set the appId");
        return aacs.aab(8, new aabe(str, null));
    }

    public Task<Map<String, String>> aaba(List<String> list) {
        Preconditions.checkArgument(aabz.aaba(list).booleanValue(), "Must set the pkgNames");
        return aacs.aaba(8, new aabd(list));
    }

    public Task<List<AppLangItem>> aab(String str, int i3) {
        Preconditions.checkNotNull(str, "Must set the lang");
        return aacs.aaba(8, new aabb(i3, str));
    }

    public Task<ScopeLangItem> aab(String str, String str2) {
        Preconditions.checkNotNull(str, "Must set the lang");
        Preconditions.checkNotNull(str2, "Must set the appId");
        return aacs.aab(8, new aaba(str2, str));
    }

    public Task<Void> aab(String str, List<String> list) {
        Preconditions.checkNotNull(str, "Must set the appId");
        Preconditions.checkNotNull(list, "Must set the scopes");
        Preconditions.checkArgument(!list.isEmpty(), "Must set the scopes");
        return aacs.aab(8, new aabe(str, list));
    }

    public Task<Map<String, String>> aab(List<String> list) {
        Preconditions.checkArgument(aabz.aaba(list).booleanValue(), "Must set the appIds");
        return aacs.aaba(8, new aabc(list));
    }

    public Task<Void> aab(boolean z16) {
        return aacs.aab(8, new aab(z16));
    }

    public static com.huawei.hms.hihealth.aabk aab() {
        if (aab == null) {
            synchronized (aacj.class) {
                if (aab == null) {
                    aab = new aacj();
                }
            }
        }
        return aab;
    }
}
