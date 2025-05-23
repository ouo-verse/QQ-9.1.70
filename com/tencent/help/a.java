package com.tencent.help;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.b;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/help/a;", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/data/Friends;", "Lkotlin/Comparator;", "f", "", "a", "o1", "o2", "b", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes31.dex */
public final class a implements Comparator<Friends> {
    private final int a(Friends f16) {
        long lastLoginType;
        int i3;
        int a16 = b.a(f16.detalStatusFlag, f16.iTermType);
        int i16 = (a16 == 6 || a16 == 0) ? 131072 : 65536;
        int i17 = 16384;
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            if (f16.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
                i17 = 0;
            } else if (f16.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                i17 = 4096;
            } else if (f16.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                i17 = 8192;
            } else if (f16.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                i17 = 12288;
            }
        }
        if (a16 != 0) {
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 == 3 || a16 == 4) {
                        i3 = i17 | 1;
                    } else if (a16 != 6) {
                        if (a16 != 7) {
                            lastLoginType = f16.getLastLoginType();
                            i3 = ((int) lastLoginType) | i17;
                        }
                    }
                }
                i3 = i17 | 3;
            } else {
                i3 = i17 | 2;
            }
            return i3 | i16;
        }
        lastLoginType = f16.getLastLoginType();
        i3 = ((int) lastLoginType) | i17;
        return i3 | i16;
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(Friends o16, Friends o26) {
        Intrinsics.checkNotNullParameter(o16, "o1");
        Intrinsics.checkNotNullParameter(o26, "o2");
        int a16 = a(o16);
        int a17 = a(o26);
        return a16 == a17 ? j.a(o16.mComparePartInt, o16.mCompareSpell, o26.mComparePartInt, o26.mCompareSpell) : a16 - a17;
    }
}
