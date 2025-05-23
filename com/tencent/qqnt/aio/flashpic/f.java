package com.tencent.qqnt.aio.flashpic;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002RJ\u0010\u000f\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n0\fj\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/flashpic/f;", "", "", "elementId", "", "encryptPath", "key", "", "c", "b", "Lkotlin/Pair;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "encryptPathCache", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f349947a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Long, Pair<String, String>> encryptPathCache = new HashMap<>();

    f() {
    }

    public final Pair<String, String> a(long elementId) {
        if (QLog.isColorLevel()) {
            QLog.i("NTFlashPic FlashPicEncryptPathCache", 2, "getEncryptPathFromCache elementId: " + elementId);
        }
        return encryptPathCache.get(Long.valueOf(elementId));
    }

    public final synchronized void b(long elementId) {
        if (QLog.isColorLevel()) {
            QLog.i("NTFlashPic FlashPicEncryptPathCache", 2, "removeEncryptPathCache elementId: " + elementId);
        }
        if (encryptPathCache.containsKey(Long.valueOf(elementId))) {
            encryptPathCache.remove(Long.valueOf(elementId));
        }
    }

    public final synchronized void c(long elementId, String encryptPath, String key) {
        Intrinsics.checkNotNullParameter(encryptPath, "encryptPath");
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isColorLevel()) {
            QLog.i("NTFlashPic FlashPicEncryptPathCache", 2, "EncryptPath elementId: " + elementId + " ,encryptPath: " + encryptPath);
        }
        encryptPathCache.put(Long.valueOf(elementId), new Pair<>(encryptPath, key));
    }
}
