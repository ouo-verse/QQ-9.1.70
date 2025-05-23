package com.tencent.mobileqq.zplan.minihome;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "GLOBAL", "FOCUS", "ACTION", "STRANGER", "FAILURE", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum MapMode {
    UNKNOWN(-1),
    GLOBAL(0),
    FOCUS(1),
    ACTION(2),
    STRANGER(3),
    FAILURE(1000);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MapMode$a;", "", "", "value", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "defaultMode", "a", "mapNode", "", IProfileProtocolConst.PARAM_IS_FRIEND, "b", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.MapMode$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zplan.minihome.MapMode$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public /* synthetic */ class C9186a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334267a;

            static {
                int[] iArr = new int[MapMode.values().length];
                try {
                    iArr[MapMode.GLOBAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MapMode.FOCUS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MapMode.ACTION.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MapMode.STRANGER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MapMode.FAILURE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f334267a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MapMode a(int value, @NotNull MapMode defaultMode) {
            MapMode mapMode;
            boolean z16;
            Intrinsics.checkNotNullParameter(defaultMode, "defaultMode");
            MapMode[] values = MapMode.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    mapMode = values[i3];
                    if (mapMode.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    mapMode = null;
                    break;
                }
            }
            if (mapMode != null) {
                return mapMode;
            }
            return defaultMode;
        }

        public final int b(@Nullable MapMode mapNode, boolean isFriend) {
            int i3;
            MapStateReportValue mapStateReportValue;
            if (mapNode == null) {
                i3 = -1;
            } else {
                i3 = C9186a.f334267a[mapNode.ordinal()];
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return 0;
                            }
                            return MapStateReportValue.FAILURE.getValue();
                        }
                        return MapStateReportValue.STRANGER.getValue();
                    }
                    return MapStateReportValue.ACTION.getValue();
                }
                if (isFriend) {
                    mapStateReportValue = MapStateReportValue.FRIEND_FOCUS;
                } else {
                    mapStateReportValue = MapStateReportValue.SELF_FOCUS;
                }
                return mapStateReportValue.getValue();
            }
            return MapStateReportValue.GLOBAL.getValue();
        }

        Companion() {
        }
    }

    MapMode(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
