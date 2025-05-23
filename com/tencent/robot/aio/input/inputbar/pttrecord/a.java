package com.tencent.robot.aio.input.inputbar.pttrecord;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/a;", "Lat/a;", "<init>", "()V", "a", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/a$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/a$a;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "pttRecordView", "e", "Z", "b", "()Z", "isPttRecordMode", "<init>", "(Landroid/view/View;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.input.inputbar.pttrecord.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class PttRecordModeChangedMviIntent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View pttRecordView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPttRecordMode;

        public PttRecordModeChangedMviIntent(@Nullable View view, boolean z16) {
            super(null);
            this.pttRecordView = view;
            this.isPttRecordMode = z16;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getPttRecordView() {
            return this.pttRecordView;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsPttRecordMode() {
            return this.isPttRecordMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PttRecordModeChangedMviIntent)) {
                return false;
            }
            PttRecordModeChangedMviIntent pttRecordModeChangedMviIntent = (PttRecordModeChangedMviIntent) other;
            if (Intrinsics.areEqual(this.pttRecordView, pttRecordModeChangedMviIntent.pttRecordView) && this.isPttRecordMode == pttRecordModeChangedMviIntent.isPttRecordMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            View view = this.pttRecordView;
            if (view == null) {
                hashCode = 0;
            } else {
                hashCode = view.hashCode();
            }
            int i3 = hashCode * 31;
            boolean z16 = this.isPttRecordMode;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "PttRecordModeChangedMviIntent(pttRecordView=" + this.pttRecordView + ", isPttRecordMode=" + this.isPttRecordMode + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
