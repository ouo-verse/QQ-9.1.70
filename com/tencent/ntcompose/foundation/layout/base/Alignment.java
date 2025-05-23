package com.tencent.ntcompose.foundation.layout.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "Horizontal", "Vertical", "TopStart", "TopCenter", "TopEnd", "CenterStart", "Center", "CenterEnd", "BottomStart", "BottomCenter", "BottomEnd", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public enum Alignment {
    TopStart,
    TopCenter,
    TopEnd,
    CenterStart,
    Center,
    CenterEnd,
    BottomStart,
    BottomCenter,
    BottomEnd;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Horizontal Start = Horizontal.Start;
    private static final Horizontal End = Horizontal.End;
    private static final Horizontal CenterHorizontally = Horizontal.CenterHorizontally;
    private static final Vertical Top = Vertical.Top;
    private static final Vertical Bottom = Vertical.Bottom;
    private static final Vertical CenterVertically = Vertical.CenterVertically;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "", "(Ljava/lang/String;I)V", "Start", "End", "CenterHorizontally", "ntcompose_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum Horizontal {
        Start,
        End,
        CenterHorizontally
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "", "(Ljava/lang/String;I)V", "Top", "Bottom", "CenterVertically", "ntcompose_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum Vertical {
        Top,
        Bottom,
        CenterVertically
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/Alignment$a;", "", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "Start", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "e", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "End", "d", "CenterHorizontally", "b", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "Top", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "f", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "Bottom", "a", "CenterVertically", "c", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.foundation.layout.base.Alignment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Vertical a() {
            return Alignment.Bottom;
        }

        public final Horizontal b() {
            return Alignment.CenterHorizontally;
        }

        public final Vertical c() {
            return Alignment.CenterVertically;
        }

        public final Horizontal d() {
            return Alignment.End;
        }

        public final Horizontal e() {
            return Alignment.Start;
        }

        public final Vertical f() {
            return Alignment.Top;
        }

        Companion() {
        }
    }
}
