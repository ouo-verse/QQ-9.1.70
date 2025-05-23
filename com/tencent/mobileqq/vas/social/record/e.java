package com.tencent.mobileqq.vas.social.record;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/RecordState;", "a", "", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310819a;

        static {
            int[] iArr = new int[RecordState.values().length];
            try {
                iArr[RecordState.UN_RECORDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordState.RECORDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordState.UPLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RecordState.NOTIFIED_UPLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f310819a = iArr;
        }
    }

    public static final RecordState a(RecordState recordState) {
        Intrinsics.checkNotNullParameter(recordState, "<this>");
        int i3 = a.f310819a[recordState.ordinal()];
        if (i3 == 1) {
            return RecordState.RECORDED;
        }
        if (i3 == 2) {
            return RecordState.UPLOADED;
        }
        if (i3 == 3) {
            return RecordState.NOTIFIED_UPLOAD;
        }
        if (i3 == 4) {
            return RecordState.NOTIFIED_UPLOAD;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    public static final RecordState b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        switch (str.hashCode()) {
            case -1948348832:
                if (str.equals("UPLOADED")) {
                    return RecordState.UPLOADED;
                }
                return RecordState.UN_RECORDED;
            case -1380656504:
                if (str.equals("NOTIFIED_UPLOAD")) {
                    return RecordState.NOTIFIED_UPLOAD;
                }
                return RecordState.UN_RECORDED;
            case -491283562:
                if (str.equals("UN_RECORDED")) {
                    return RecordState.UN_RECORDED;
                }
                return RecordState.UN_RECORDED;
            case -16607056:
                if (str.equals("RECORDED")) {
                    return RecordState.RECORDED;
                }
                return RecordState.UN_RECORDED;
            default:
                return RecordState.UN_RECORDED;
        }
    }
}
