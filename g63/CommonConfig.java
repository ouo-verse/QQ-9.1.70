package g63;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J1\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lg63/a;", "", "Lg63/c;", "scrollConfig", "Lg63/b;", "layoutConfig", "Lg63/e;", "videoTrackConfig", "Lg63/d;", "timeBarConfig", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lg63/c;", "d", "()Lg63/c;", "b", "Lg63/b;", "c", "()Lg63/b;", "Lg63/e;", "f", "()Lg63/e;", "Lg63/d;", "e", "()Lg63/d;", "<init>", "(Lg63/c;Lg63/b;Lg63/e;Lg63/d;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g63.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class CommonConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ScrollConfig scrollConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LayoutConfig layoutConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VideoTrackConfig videoTrackConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TimeBarConfig timeBarConfig;

    public CommonConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CommonConfig b(CommonConfig commonConfig, ScrollConfig scrollConfig, LayoutConfig layoutConfig, VideoTrackConfig videoTrackConfig, TimeBarConfig timeBarConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            scrollConfig = commonConfig.scrollConfig;
        }
        if ((i3 & 2) != 0) {
            layoutConfig = commonConfig.layoutConfig;
        }
        if ((i3 & 4) != 0) {
            videoTrackConfig = commonConfig.videoTrackConfig;
        }
        if ((i3 & 8) != 0) {
            timeBarConfig = commonConfig.timeBarConfig;
        }
        return commonConfig.a(scrollConfig, layoutConfig, videoTrackConfig, timeBarConfig);
    }

    @NotNull
    public final CommonConfig a(@NotNull ScrollConfig scrollConfig, @NotNull LayoutConfig layoutConfig, @NotNull VideoTrackConfig videoTrackConfig, @NotNull TimeBarConfig timeBarConfig) {
        Intrinsics.checkNotNullParameter(scrollConfig, "scrollConfig");
        Intrinsics.checkNotNullParameter(layoutConfig, "layoutConfig");
        Intrinsics.checkNotNullParameter(videoTrackConfig, "videoTrackConfig");
        Intrinsics.checkNotNullParameter(timeBarConfig, "timeBarConfig");
        return new CommonConfig(scrollConfig, layoutConfig, videoTrackConfig, timeBarConfig);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final LayoutConfig getLayoutConfig() {
        return this.layoutConfig;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ScrollConfig getScrollConfig() {
        return this.scrollConfig;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TimeBarConfig getTimeBarConfig() {
        return this.timeBarConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonConfig)) {
            return false;
        }
        CommonConfig commonConfig = (CommonConfig) other;
        if (Intrinsics.areEqual(this.scrollConfig, commonConfig.scrollConfig) && Intrinsics.areEqual(this.layoutConfig, commonConfig.layoutConfig) && Intrinsics.areEqual(this.videoTrackConfig, commonConfig.videoTrackConfig) && Intrinsics.areEqual(this.timeBarConfig, commonConfig.timeBarConfig)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final VideoTrackConfig getVideoTrackConfig() {
        return this.videoTrackConfig;
    }

    public int hashCode() {
        return (((((this.scrollConfig.hashCode() * 31) + this.layoutConfig.hashCode()) * 31) + this.videoTrackConfig.hashCode()) * 31) + this.timeBarConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommonConfig(scrollConfig=" + this.scrollConfig + ", layoutConfig=" + this.layoutConfig + ", videoTrackConfig=" + this.videoTrackConfig + ", timeBarConfig=" + this.timeBarConfig + ")";
    }

    public CommonConfig(@NotNull ScrollConfig scrollConfig, @NotNull LayoutConfig layoutConfig, @NotNull VideoTrackConfig videoTrackConfig, @NotNull TimeBarConfig timeBarConfig) {
        Intrinsics.checkNotNullParameter(scrollConfig, "scrollConfig");
        Intrinsics.checkNotNullParameter(layoutConfig, "layoutConfig");
        Intrinsics.checkNotNullParameter(videoTrackConfig, "videoTrackConfig");
        Intrinsics.checkNotNullParameter(timeBarConfig, "timeBarConfig");
        this.scrollConfig = scrollConfig;
        this.layoutConfig = layoutConfig;
        this.videoTrackConfig = videoTrackConfig;
        this.timeBarConfig = timeBarConfig;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ CommonConfig(g63.ScrollConfig r18, g63.LayoutConfig r19, g63.VideoTrackConfig r20, g63.TimeBarConfig r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r17 = this;
            r0 = r22 & 1
            r1 = 0
            r2 = 0
            if (r0 == 0) goto Ld
            g63.c r0 = new g63.c
            r3 = 1
            r0.<init>(r2, r3, r1)
            goto Lf
        Ld:
            r0 = r18
        Lf:
            r3 = r22 & 2
            if (r3 == 0) goto L23
            g63.b r3 = new g63.b
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 63
            r12 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            goto L25
        L23:
            r3 = r19
        L25:
            r4 = r22 & 4
            if (r4 == 0) goto L3d
            g63.e r4 = new g63.e
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 511(0x1ff, float:7.16E-43)
            r16 = 0
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L3f
        L3d:
            r4 = r20
        L3f:
            r5 = r22 & 8
            if (r5 == 0) goto L4c
            g63.d r5 = new g63.d
            r6 = 3
            r5.<init>(r2, r2, r6, r1)
            r1 = r17
            goto L50
        L4c:
            r1 = r17
            r5 = r21
        L50:
            r1.<init>(r0, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g63.CommonConfig.<init>(g63.c, g63.b, g63.e, g63.d, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
