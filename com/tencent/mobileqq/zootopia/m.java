package com.tencent.mobileqq.zootopia;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/zootopia/Source;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "", "a", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328585a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.UnSet.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.None.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f328585a = iArr;
        }
    }

    public static final boolean a(@NotNull ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<this>");
        int i3 = a.f328585a[zootopiaSource.getMainSource().ordinal()];
        if (i3 != 1 && i3 != 2) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Source b(int i3) {
        Source source;
        boolean z16;
        Source[] values = Source.values();
        int length = values.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                source = values[i16];
                if (source.getValue() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i16++;
            } else {
                source = null;
                break;
            }
        }
        if (source == null) {
            return Source.UnSet;
        }
        return source;
    }
}
