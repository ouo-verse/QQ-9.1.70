package com.tencent.mobileqq.zplan.view;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/a;", "", "", "c", "", "a", "I", "getTapGap", "()I", "tapGap", "", "b", "J", "lastTapTime", "curTapTime", "", "()Z", "isDoubleTap", "<init>", "(I)V", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final int f335932e = R.id.ukp;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int tapGap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastTapTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long curTapTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/a$a;", "", "Landroid/view/View;", "anchor", "", "tapGap", "", "a", "Lcom/tencent/mobileqq/zplan/view/a;", "b", "DOUBLE_TAP_KEY", "I", "", "TAG", "Ljava/lang/String;", "TAP_GAP", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final synchronized void a(View anchor, int tapGap) {
            a aVar = new a(tapGap);
            Object tag = anchor.getTag(a.f335932e);
            if (tag != null && !(tag instanceof a)) {
                QLog.w("DoubleTapChecker", 1, "DoubleTapChecker id tag is already exits!");
            }
            anchor.setTag(a.f335932e, aVar);
        }

        @NotNull
        public final a b(@NotNull View anchor, int tapGap) {
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            Object tag = anchor.getTag(a.f335932e);
            if (tag == null) {
                a(anchor, tapGap);
            }
            if (tag != null && !(tag instanceof a)) {
                a(anchor, tapGap);
            }
            Object tag2 = anchor.getTag(a.f335932e);
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.view.DoubleTapChecker");
            return (a) tag2;
        }

        Companion() {
        }
    }

    public a() {
        this(0, 1, null);
    }

    public final boolean b() {
        long j3 = this.lastTapTime;
        if (j3 == 0 || this.curTapTime - j3 > this.tapGap) {
            return false;
        }
        return true;
    }

    public final void c() {
        this.lastTapTime = this.curTapTime;
        this.curTapTime = SystemClock.elapsedRealtime();
    }

    public a(int i3) {
        this.tapGap = i3;
    }

    public /* synthetic */ a(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 500 : i3);
    }
}
