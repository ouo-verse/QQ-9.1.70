package m83;

import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.request.WinkMagicStudioRequestUtils;
import com.tencent.mobileqq.wink.utils.ar;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r93.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0015\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0013R\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006 "}, d2 = {"Lm83/a;", "", "", "mmkvKey", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "c", "", "historyList", "", "g", "", "b", "historyImageModels", h.F, "publicMediaPath", "j", "d", "historyData", "", "leftCount", "a", "Z", "e", "()Z", "k", "(Z)V", "isEnableSaveHistory", "f", "isInExperiment", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f416440a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableSaveHistory;

    static {
        boolean z16;
        a aVar = new a();
        f416440a = aVar;
        if (aVar.f() && aVar.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        isEnableSaveHistory = z16;
    }

    a() {
    }

    private final List<MagicStudioHistoryImageModel> c(String mmkvKey) {
        boolean z16;
        byte[] d16;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ar arVar = ar.f326685a;
            z16 = false;
            d16 = arVar.d(arVar.k(mmkvKey), new byte[0]);
            if (d16.length == 0) {
                z16 = true;
            }
        } catch (Exception e16) {
            w53.b.d("WinkQZoneMagicStudioHistoryUtils", "getMMKVHistoryList error", e16);
        }
        if (z16) {
            w53.b.f("WinkQZoneMagicStudioHistoryUtils", "getMMKVHistoryList " + mmkvKey + " empty");
            return arrayList;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(d16);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object readObject = objectInputStream.readObject();
        Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel>");
        arrayList.addAll((List) readObject);
        objectInputStream.close();
        byteArrayInputStream.close();
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "getMMKVHistoryList cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return arrayList;
    }

    private final void g(String mmkvKey, List<MagicStudioHistoryImageModel> historyList) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ar arVar = ar.f326685a;
            String k3 = arVar.k(mmkvKey);
            if (historyList.isEmpty()) {
                arVar.l(k3);
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(historyList);
                    objectOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(objectOutputStream, null);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
                    arVar.n(k3, byteArray);
                } finally {
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkQZoneMagicStudioHistoryUtils", "saveMMKVHistoryList error", e16);
        }
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "saveMMKVHistoryList cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static /* synthetic */ void i(a aVar, List list, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "qzone_magic_studio_history";
        }
        aVar.h(list, str);
    }

    public final void a(@Nullable MagicStudioHistoryImageModel historyData, int leftCount) {
        List<MagicStudioHistoryImageModel> emptyList;
        List<MagicStudioHistoryImageModel> take;
        List<MagicStudioHistoryImageModel> emptyList2;
        List<MagicStudioHistoryImageModel> emptyList3;
        long currentTimeMillis = System.currentTimeMillis();
        if (leftCount <= 0) {
            a aVar = f416440a;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            aVar.g("qzone_magic_studio_history", emptyList2);
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            aVar.g("qzone_magic_studio_publish_history", emptyList3);
            WinkMagicStudioRequestUtils.f323879a.a();
        } else if (historyData != null) {
            WinkMagicStudioRequestUtils.f323879a.b(historyData);
            List<MagicStudioHistoryImageModel> c16 = f416440a.c("qzone_magic_studio_publish_history");
            ArrayList arrayList = new ArrayList();
            for (Object obj : c16) {
                if (!Intrinsics.areEqual(((MagicStudioHistoryImageModel) obj).getImagePath(), historyData.getImagePath())) {
                    arrayList.add(obj);
                }
            }
            a aVar2 = f416440a;
            aVar2.g("qzone_magic_studio_publish_history", arrayList);
            int size = leftCount - arrayList.size();
            if (size <= 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                aVar2.g("qzone_magic_studio_history", emptyList);
            } else {
                List<MagicStudioHistoryImageModel> c17 = aVar2.c("qzone_magic_studio_history");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : c17) {
                    if (!Intrinsics.areEqual(((MagicStudioHistoryImageModel) obj2).getImagePath(), historyData.getImagePath())) {
                        arrayList2.add(obj2);
                    }
                }
                take = CollectionsKt___CollectionsKt.take(arrayList2, size);
                f416440a.g("qzone_magic_studio_history", take);
            }
        }
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "deleteMagicStudioHistory cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final boolean b() {
        return ar.f326685a.j("qzone_magic_studio_enable_save_history", true);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List, T] */
    @NotNull
    public final List<MagicStudioHistoryImageModel> d() {
        int collectionSizeOrDefault;
        List take;
        ?? mutableList;
        boolean z16;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        long currentTimeMillis = System.currentTimeMillis();
        List<MagicStudioHistoryImageModel> c16 = f416440a.c("qzone_magic_studio_publish_history");
        if (c16.size() >= 3) {
            return c16;
        }
        List<MagicStudioHistoryImageModel> list = c16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MagicStudioHistoryImageModel) it.next()).getImagePath());
        }
        List<MagicStudioHistoryImageModel> c17 = f416440a.c("qzone_magic_studio_history");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : c17) {
            if (!arrayList.contains(((MagicStudioHistoryImageModel) obj).getImagePath())) {
                arrayList2.add(obj);
            }
        }
        c16.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            MagicStudioHistoryImageModel magicStudioHistoryImageModel = (MagicStudioHistoryImageModel) obj2;
            try {
                z16 = new File(magicStudioHistoryImageModel.getImagePath()).exists();
                if (!z16) {
                    f416440a.a(magicStudioHistoryImageModel, 3);
                }
            } catch (Exception e16) {
                w53.b.d("WinkQZoneMagicStudioHistoryUtils", "filter history list error", e16);
                f416440a.a(magicStudioHistoryImageModel, 3);
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj2);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList3, 3);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) take);
        objectRef.element = mutableList;
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "getMagicStudioHistoryList cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return (List) objectRef.element;
    }

    public final boolean e() {
        return isEnableSaveHistory;
    }

    public final boolean f() {
        return i.f430994a.a("exp_qzone_publisher_inspiration_magicstudio_historicphotos_1", "qzone_magic_studio_save_history_is_in_exp");
    }

    public final void h(@NotNull List<MagicStudioHistoryImageModel> historyImageModels, @NotNull String mmkvKey) {
        int collectionSizeOrDefault;
        List<MagicStudioHistoryImageModel> take;
        boolean z16;
        List<MagicStudioHistoryImageModel> take2;
        Intrinsics.checkNotNullParameter(historyImageModels, "historyImageModels");
        Intrinsics.checkNotNullParameter(mmkvKey, "mmkvKey");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        List<MagicStudioHistoryImageModel> c16 = f416440a.c(mmkvKey);
        List<MagicStudioHistoryImageModel> list = historyImageModels;
        arrayList.addAll(0, list);
        List<MagicStudioHistoryImageModel> list2 = historyImageModels;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((MagicStudioHistoryImageModel) it.next()).getImageMd5());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : c16) {
            if (true ^ arrayList2.contains(((MagicStudioHistoryImageModel) obj).getImageMd5())) {
                arrayList3.add(obj);
            }
        }
        arrayList.addAll(arrayList3);
        a aVar = f416440a;
        take = CollectionsKt___CollectionsKt.take(arrayList, 3);
        aVar.g(mmkvKey, take);
        if (Intrinsics.areEqual(mmkvKey, "qzone_magic_studio_history")) {
            WinkMagicStudioRequestUtils.f323879a.c(historyImageModels);
            List<MagicStudioHistoryImageModel> c17 = aVar.c("qzone_magic_studio_publish_history");
            if (!(c17 instanceof Collection) || !c17.isEmpty()) {
                Iterator<T> it5 = c17.iterator();
                while (it5.hasNext()) {
                    if (arrayList2.contains(((MagicStudioHistoryImageModel) it5.next()).getImageMd5())) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.addAll(0, list);
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : c17) {
                    if (!arrayList2.contains(((MagicStudioHistoryImageModel) obj2).getImageMd5())) {
                        arrayList5.add(obj2);
                    }
                }
                arrayList4.addAll(arrayList5);
                a aVar2 = f416440a;
                take2 = CollectionsKt___CollectionsKt.take(arrayList4, 3);
                aVar2.g("qzone_magic_studio_publish_history", take2);
            }
        }
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "saveMagicStudioHistory cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void j(@Nullable List<String> publicMediaPath) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        List<String> list = publicMediaPath;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<MagicStudioHistoryImageModel> c16 = f416440a.c("qzone_magic_studio_history");
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            Iterator<T> it = ((MagicStudioHistoryImageModel) obj).getAigcOutputMediaPath().iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                if (publicMediaPath.contains((String) it.next())) {
                    z17 = true;
                }
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        f416440a.h(arrayList, "qzone_magic_studio_publish_history");
        WinkMagicStudioRequestUtils.f323879a.d(arrayList);
        w53.b.a("WinkQZoneMagicStudioHistoryUtils", "saveMagicStudioPublishHistory cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void k(boolean z16) {
        isEnableSaveHistory = z16;
    }
}
