package com.tencent.mobileqq.kandian.biz.detail;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/detail/d;", "", "", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "ERROR_MSG_LIST_DEFAULT", "c", "Z", "MONITOR_SWITCH_DEFAULT", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f239367a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> ERROR_MSG_LIST_DEFAULT;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean MONITOR_SWITCH_DEFAULT = false;

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("\u5546\u54c1\u5df2\u552e\u7f44", "\u65e0\u6cd5\u6253\u5f00\u9875\u9762", "\u767b\u5f55\u5931\u8d25");
        ERROR_MSG_LIST_DEFAULT = arrayListOf;
    }

    d() {
    }

    public final boolean a() {
        boolean z16 = MONITOR_SWITCH_DEFAULT;
        QLog.i("RIJWebMonitorUtils", 1, "[getSwitchStates] switchStates = " + z16);
        return z16;
    }
}
