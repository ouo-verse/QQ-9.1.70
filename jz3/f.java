package jz3;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz3.DiffInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Ljz3/e;", "", "e", "d", "c", "a", "", "version", "Lnz3/a;", "b", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class f {
    public static final boolean a(@NotNull e checkEncryptFileValid) {
        Intrinsics.checkParameterIsNotNull(checkEncryptFileValid, "$this$checkEncryptFileValid");
        return c.b(checkEncryptFileValid.I, checkEncryptFileValid.f411276q, checkEncryptFileValid.f411275p);
    }

    @Nullable
    public static final DiffInfo b(@NotNull e findBigResDiffInfo, long j3) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(findBigResDiffInfo, "$this$findBigResDiffInfo");
        List<DiffInfo> list = findBigResDiffInfo.f411283x;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            DiffInfo diffInfo = (DiffInfo) next;
            if (diffInfo.i() && diffInfo.getVersion() == j3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (DiffInfo) obj;
    }

    public static final boolean c(@NotNull e isEncryptFileExist) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(isEncryptFileExist, "$this$isEncryptFileExist");
        String str = isEncryptFileExist.I;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(isEncryptFileExist.I).exists()) {
            return false;
        }
        return true;
    }

    public static final boolean d(@NotNull e isLocalOriginFileAvailable) {
        Intrinsics.checkParameterIsNotNull(isLocalOriginFileAvailable, "$this$isLocalOriginFileAvailable");
        if (e(isLocalOriginFileAvailable) && isLocalOriginFileAvailable.g()) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull e isOriginFileExist) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(isOriginFileExist, "$this$isOriginFileExist");
        String str = isOriginFileExist.H;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(isOriginFileExist.H).exists()) {
            return false;
        }
        return true;
    }
}
