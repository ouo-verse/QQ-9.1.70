package lx3;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kx3.b;
import kx3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u0016\u0010\u000e\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nR,\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Llx3/a;", "", "", "uid", "trace", "Lhx3/b;", "Lkx3/a;", "iQueryGeneralDataCallback", "", "a", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "b", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "c", "ntVasSimpleInfo", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkx3/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "vasDetailInfoCallbackHashMap", "Lkx3/c;", "vasSimpleInfoCallbackHashMap", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f415742a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> vasDetailInfoCallbackHashMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, c>> vasSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();

    a() {
    }

    public final void a(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> concurrentHashMap = vasDetailInfoCallbackHashMap;
        ConcurrentHashMap<Integer, b> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new b(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }

    public final void b(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<NTVasSimpleInfo> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, c>> concurrentHashMap = vasSimpleInfoCallbackHashMap;
        ConcurrentHashMap<Integer, c> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new c(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }

    public final void c(@Nullable e<kx3.a> responseData) {
        ArrayList<kx3.a> arrayList;
        boolean z16;
        if (responseData != null) {
            arrayList = responseData.b();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<kx3.a> it = arrayList.iterator();
            while (it.hasNext()) {
                kx3.a next = it.next();
                ConcurrentHashMap<Integer, b> concurrentHashMap = vasDetailInfoCallbackHashMap.get(next.getUid());
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ArrayList<kx3.a> arrayList2 = new ArrayList<>();
                    arrayList2.add(next);
                    e<kx3.a> eVar = new e<>();
                    eVar.e(arrayList2);
                    Iterator<Map.Entry<Integer, b>> it5 = concurrentHashMap.entrySet().iterator();
                    while (it5.hasNext()) {
                        b value = it5.next().getValue();
                        if (value.a().get() == null) {
                            it5.remove();
                        } else {
                            value.b(eVar);
                        }
                    }
                }
            }
        }
    }

    public final void d(@NotNull NTVasSimpleInfo ntVasSimpleInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntVasSimpleInfo, "ntVasSimpleInfo");
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
        arrayList.add(ntVasSimpleInfo);
        ConcurrentHashMap<Integer, c> concurrentHashMap = vasSimpleInfoCallbackHashMap.get(ntVasSimpleInfo.getUid());
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        e<NTVasSimpleInfo> eVar = new e<>();
        eVar.e(arrayList);
        Iterator<Map.Entry<Integer, c>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            c value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.b(eVar);
            }
        }
    }
}
