package com.tencent.util;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\u001c\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007J\u001c\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/util/m;", "", "T", "Lhx3/b;", "iQueryGeneralDataCallback", "", "b", "Lhx3/c;", "iUpdateGeneralDataCallback", "c", "Lhx3/a;", "a", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f383989a = new m();

    m() {
    }

    public final <T> void a(hx3.a<T> iUpdateGeneralDataCallback) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<T> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.d(-1);
        if (iUpdateGeneralDataCallback != null) {
            iUpdateGeneralDataCallback.a(eVar);
        }
    }

    public final <T> void b(hx3.b<T> iQueryGeneralDataCallback) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<T> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.d(-1);
        if (iQueryGeneralDataCallback != null) {
            iQueryGeneralDataCallback.onQueryResult(eVar);
        }
    }

    public final <T> void c(hx3.c<T> iUpdateGeneralDataCallback) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<T> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.d(-1);
        if (iUpdateGeneralDataCallback != null) {
            iUpdateGeneralDataCallback.onUpdateResult(eVar);
        }
    }
}
