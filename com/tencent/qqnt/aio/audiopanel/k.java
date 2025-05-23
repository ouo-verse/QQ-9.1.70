package com.tencent.qqnt.aio.audiopanel;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n\u00a8\u0006\u0012"}, d2 = {"", "", com.tencent.luggage.wxa.c8.c.E, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "b", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p", "", "d", "", "cancel", "params", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "ExtendUtil")
/* loaded from: classes23.dex */
public final class k {
    public static final void a(@NotNull String path, boolean z16, @NotNull RecordParams.RecorderParam params) {
        boolean z17;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.f307260m == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            com.tencent.mobileqq.streamtransfile.b.j(path, z16);
        } else {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(path);
        }
        ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(path);
    }

    public static final int b() {
        QQAppInterface qQAppInterface;
        int c16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 0;
        }
        int c17 = com.tencent.mobileqq.activity.aio.item.n.c(qQAppInterface, "Normal_MaxPtt") * 1000;
        int privilegeFlags = VasUtil.getSignedService(qQAppInterface).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 4) != 0) {
            c16 = com.tencent.mobileqq.activity.aio.item.n.c(qQAppInterface, "SVIP_MaxPtt");
        } else {
            if ((privilegeFlags & 2) != 0) {
                c16 = com.tencent.mobileqq.activity.aio.item.n.c(qQAppInterface, "VIP_MaxPtt");
            }
            return (c17 - 200) + 200;
        }
        c17 = c16 * 1000;
        return (c17 - 200) + 200;
    }

    @NotNull
    public static final ArrayList<Byte> c(@Nullable int[] iArr, int i3) {
        List slice;
        int collectionSizeOrDefault;
        if (iArr != null) {
            slice = ArraysKt___ArraysKt.slice(iArr, new IntRange(0, i3));
            List list = slice;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Byte.valueOf((byte) ((Number) it.next()).intValue()));
            }
            return new ArrayList<>(arrayList);
        }
        return new ArrayList<>();
    }

    public static final void d(@NotNull String path, @NotNull RecordParams.RecorderParam p16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(p16, "p");
        byte[] a16 = RecordParams.a(p16.f307257f, p16.f307255d);
        if (p16.f307260m == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            com.tencent.mobileqq.streamtransfile.b.h(MobileQQ.sMobileQQ.peekAppRuntime(), p16.f307257f, path, 0, (int) (System.currentTimeMillis() / 1000));
            com.tencent.mobileqq.streamtransfile.b.e(path, a16, a16.length, (short) 0);
        } else {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(path);
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(path, a16, a16.length);
        }
    }
}
