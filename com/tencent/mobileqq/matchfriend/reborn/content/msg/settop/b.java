package com.tencent.mobileqq.matchfriend.reborn.content.msg.settop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;", "", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244805a;

        static {
            int[] iArr = new int[SetTopBizType.values().length];
            try {
                iArr[SetTopBizType.JIE_BAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SetTopBizType.NEAR_BY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f244805a = iArr;
        }
    }

    public static final int a(SetTopBizType setTopBizType) {
        Intrinsics.checkNotNullParameter(setTopBizType, "<this>");
        int i3 = a.f244805a[setTopBizType.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? 0 : 2;
        }
        return 1;
    }
}
