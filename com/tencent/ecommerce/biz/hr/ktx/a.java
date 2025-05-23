package com.tencent.ecommerce.biz.hr.ktx;

import android.util.ArrayMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007R4\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00060\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/ktx/a;", "", "", "filePath", "", "b", "Lkotlin/Function1;", "Ljava/io/File;", "", "resultBlock", "c", "file", "a", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "downloadingMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f102564b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayMap<String, List<Function1<File, Unit>>> downloadingMap = new ArrayMap<>();

    a() {
    }

    public final void a(String filePath, File file) {
        synchronized (this) {
            List<Function1<File, Unit>> remove = downloadingMap.remove(filePath);
            if (remove != null) {
                Iterator<T> it = remove.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(file);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean b(String filePath) {
        boolean z16;
        synchronized (this) {
            List<Function1<File, Unit>> list = downloadingMap.get(filePath);
            z16 = false;
            if (list != null) {
                if (!list.isEmpty()) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public final void c(String filePath, Function1<? super File, Unit> resultBlock) {
        synchronized (this) {
            ArrayMap<String, List<Function1<File, Unit>>> arrayMap = downloadingMap;
            List<Function1<File, Unit>> list = arrayMap.get(filePath);
            if (list == null) {
                list = new ArrayList<>();
                arrayMap.put(filePath, list);
            }
            list.add(resultBlock);
        }
    }
}
