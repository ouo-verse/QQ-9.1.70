package com.tencent.qqnt.notification.logic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"h\u0010\t\u001aV\u0012\u0004\u0012\u00020\u0000\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00060\u0003j*\u0012\u0004\u0012\u00020\u0000\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\"(\u0010\u0013\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"P\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u0015*\u00020\u00002\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "c", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "extData", "Ljava/lang/Object;", "b", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "value", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)I", "f", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;I)V", "count", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)Ljava/util/ArrayList;", "g", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;Ljava/util/ArrayList;)V", "msgInfoList", "notification_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<RecentContactInfo, HashMap<Integer, Object>> f359846a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f359847b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f359846a = new HashMap<>();
            f359847b = new Object();
        }
    }

    public static final void c(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        synchronized (f359847b) {
            f359846a.remove(recentContactInfo);
        }
    }

    public static final int d(@NotNull RecentContactInfo recentContactInfo) {
        Object obj;
        int i3;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        synchronized (f359847b) {
            HashMap<Integer, Object> hashMap = f359846a.get(recentContactInfo);
            Integer num = null;
            if (hashMap != null) {
                obj = hashMap.get(1);
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    @Nullable
    public static final ArrayList<RecentContactInfo> e(@NotNull RecentContactInfo recentContactInfo) {
        ArrayList<RecentContactInfo> arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        synchronized (f359847b) {
            HashMap<Integer, Object> hashMap = f359846a.get(recentContactInfo);
            arrayList = null;
            if (hashMap != null) {
                obj = hashMap.get(2);
            } else {
                obj = null;
            }
            if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            }
        }
        return arrayList;
    }

    public static final void f(@NotNull RecentContactInfo recentContactInfo, int i3) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        synchronized (f359847b) {
            if (i3 == 0) {
                HashMap<Integer, Object> hashMap = f359846a.get(recentContactInfo);
                if (hashMap != null) {
                    hashMap.remove(1);
                }
                return;
            }
            HashMap<RecentContactInfo, HashMap<Integer, Object>> hashMap2 = f359846a;
            HashMap<Integer, Object> hashMap3 = hashMap2.get(recentContactInfo);
            if (hashMap3 == null) {
                hashMap3 = new HashMap<>();
                hashMap2.put(recentContactInfo, hashMap3);
            }
            hashMap3.put(1, Integer.valueOf(i3));
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void g(@NotNull RecentContactInfo recentContactInfo, @Nullable ArrayList<RecentContactInfo> arrayList) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        synchronized (f359847b) {
            if (arrayList == null) {
                HashMap<Integer, Object> hashMap = f359846a.get(recentContactInfo);
                if (hashMap != null) {
                    hashMap.remove(2);
                }
                return;
            }
            HashMap<RecentContactInfo, HashMap<Integer, Object>> hashMap2 = f359846a;
            HashMap<Integer, Object> hashMap3 = hashMap2.get(recentContactInfo);
            if (hashMap3 == null) {
                hashMap3 = new HashMap<>();
                hashMap2.put(recentContactInfo, hashMap3);
            }
            hashMap3.put(2, arrayList);
            Unit unit = Unit.INSTANCE;
        }
    }
}
