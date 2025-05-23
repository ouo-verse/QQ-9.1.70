package com.tencent.mobileqq.qwallet.ad;

import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'RENDERED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/AdEvent;", "", "param", "", "(Ljava/lang/String;ILjava/lang/Object;)V", "getParam", "()Ljava/lang/Object;", "setParam", "(Ljava/lang/Object;)V", "DISMISS", "RENDERED", "ORIGINAL_EXPOSURE", "VIEW_LAYOUT", "EXPOSURE_TIMER_TICK", "STRICT_EXPOSURE", MyNearbyProBizScene.CLICK, "TO_LANDING_PAGE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class AdEvent {
    public static final AdEvent CLICK;
    public static final AdEvent EXPOSURE_TIMER_TICK;
    public static final AdEvent ORIGINAL_EXPOSURE;
    public static final AdEvent RENDERED;
    public static final AdEvent STRICT_EXPOSURE;
    public static final AdEvent TO_LANDING_PAGE;
    public static final AdEvent VIEW_LAYOUT;

    @Nullable
    private Object param;
    public static final AdEvent DISMISS = new AdEvent("DISMISS", 0, null, 1, null);
    private static final /* synthetic */ AdEvent[] $VALUES = $values();

    private static final /* synthetic */ AdEvent[] $values() {
        return new AdEvent[]{DISMISS, RENDERED, ORIGINAL_EXPOSURE, VIEW_LAYOUT, EXPOSURE_TIMER_TICK, STRICT_EXPOSURE, CLICK, TO_LANDING_PAGE};
    }

    static {
        Object obj = null;
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        RENDERED = new AdEvent("RENDERED", 1, obj, i3, defaultConstructorMarker);
        Object obj2 = null;
        int i16 = 1;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        ORIGINAL_EXPOSURE = new AdEvent("ORIGINAL_EXPOSURE", 2, obj2, i16, defaultConstructorMarker2);
        VIEW_LAYOUT = new AdEvent("VIEW_LAYOUT", 3, obj, i3, defaultConstructorMarker);
        EXPOSURE_TIMER_TICK = new AdEvent("EXPOSURE_TIMER_TICK", 4, obj2, i16, defaultConstructorMarker2);
        STRICT_EXPOSURE = new AdEvent("STRICT_EXPOSURE", 5, obj, i3, defaultConstructorMarker);
        CLICK = new AdEvent(MyNearbyProBizScene.CLICK, 6, obj2, i16, defaultConstructorMarker2);
        TO_LANDING_PAGE = new AdEvent("TO_LANDING_PAGE", 7, obj, i3, defaultConstructorMarker);
    }

    AdEvent(String str, int i3, Object obj) {
        this.param = obj;
    }

    public static AdEvent valueOf(String str) {
        return (AdEvent) Enum.valueOf(AdEvent.class, str);
    }

    public static AdEvent[] values() {
        return (AdEvent[]) $VALUES.clone();
    }

    @Nullable
    public final Object getParam() {
        return this.param;
    }

    public final void setParam(@Nullable Object obj) {
        this.param = obj;
    }

    /* synthetic */ AdEvent(String str, int i3, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 1) != 0 ? null : obj);
    }
}
