package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u000323BQ\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J[\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b$\u0010 R\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b(\u0010#R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b)\u0010#R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0017\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "c", "d", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "e", "f", "g", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$a;", tl.h.F, "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "i", "id", "name", "frameCount", "triggerAction", "resPath", "resPathMd5", com.tencent.luggage.wxa.c8.c.G, "type", "toString", "hashCode", "", "other", "", "equals", "I", "k", "()I", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "j", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "p", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "<init>", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$a;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final /* data */ class StickerItemInfo implements com.tencent.luggage.wxa.f8.i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TriggerAction triggerAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String resPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String resPathMd5;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Position pos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final StickerBackType type;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "", "jsonVal", "I", "getJsonVal", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "BACKGROUND", "HUMAN_REGION", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public enum StickerBackType {
        BACKGROUND(0),
        HUMAN_REGION(1);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int jsonVal;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$a;", "", "", "typeInt", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$StickerBackType$a, reason: from kotlin metadata */
        /* loaded from: classes9.dex */
        public static final class Companion {
            Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final StickerBackType a(int typeInt) {
                boolean z16;
                for (StickerBackType stickerBackType : StickerBackType.values()) {
                    if (typeInt == stickerBackType.getJsonVal()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return stickerBackType;
                    }
                }
                return null;
            }
        }

        StickerBackType(int i3) {
            this.jsonVal = i3;
        }

        @JvmStatic
        @Nullable
        public static final StickerBackType from(int i3) {
            return INSTANCE.a(i3);
        }

        public final int getJsonVal() {
            return this.jsonVal;
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b \u00a8\u0006!"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "", "", "jsonVal", "I", "getJsonVal", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "DEFAULT_ACTION_LOOP", "FACE_ACTION_MOUTH_OPEN", "FACE_ACTION_MOUTH_KISS", "FACE_ACTION_LEFT_EYE_BLINK", "FACE_ACTION_RIGHT_EYE_BLINK", "FACE_ACTION_EYE_BLINK", "FACE_ACTION_EYEBROW_UP", "FACE_ACTION_HEAD_SHAKE", "FACE_ACTION_HEAD_NOD", "HAND_ACTION_HEART", "HAND_ACTION_PAPER", "HAND_ACTION_SCISSOR", "HAND_ACTION_FIST", "HAND_ACTION_ONE", "HAND_ACTION_LOVE", "HAND_ACTION_LIKE", "HAND_ACTION_OK", "HAND_ACTION_ROCK", "HAND_ACTION_SIX", "HAND_ACTION_EIGHT", "HAND_ACTION_LIFT", "HAND_ACTION_GOOD_FORTUNE", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public enum TriggerAction {
        DEFAULT_ACTION_LOOP(-1),
        FACE_ACTION_MOUTH_OPEN(10),
        FACE_ACTION_MOUTH_KISS(11),
        FACE_ACTION_LEFT_EYE_BLINK(12),
        FACE_ACTION_RIGHT_EYE_BLINK(13),
        FACE_ACTION_EYE_BLINK(14),
        FACE_ACTION_EYEBROW_UP(15),
        FACE_ACTION_HEAD_SHAKE(16),
        FACE_ACTION_HEAD_NOD(17),
        HAND_ACTION_HEART(100),
        HAND_ACTION_PAPER(101),
        HAND_ACTION_SCISSOR(102),
        HAND_ACTION_FIST(103),
        HAND_ACTION_ONE(104),
        HAND_ACTION_LOVE(105),
        HAND_ACTION_LIKE(106),
        HAND_ACTION_OK(107),
        HAND_ACTION_ROCK(108),
        HAND_ACTION_SIX(109),
        HAND_ACTION_EIGHT(110),
        HAND_ACTION_LIFT(111),
        HAND_ACTION_GOOD_FORTUNE(112);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int jsonVal;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction$a;", "", "", "actionInt", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$TriggerAction$a, reason: from kotlin metadata */
        /* loaded from: classes9.dex */
        public static final class Companion {
            Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final TriggerAction a(int actionInt) {
                boolean z16;
                for (TriggerAction triggerAction : TriggerAction.values()) {
                    if (actionInt == triggerAction.getJsonVal()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return triggerAction;
                    }
                }
                return null;
            }
        }

        TriggerAction(int i3) {
            this.jsonVal = i3;
        }

        @JvmStatic
        @Nullable
        public static final TriggerAction from(int i3) {
            return INSTANCE.a(i3);
        }

        public final int getJsonVal() {
            return this.jsonVal;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J1\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$a;", "", "", "a", "b", "c", "d", "x1", "y1", "x2", "y2", "", "toString", "", "hashCode", "other", "", "equals", "D", "e", "()D", "g", "f", tl.h.F, "<init>", "(DDDD)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$a, reason: from toString */
    /* loaded from: classes9.dex */
    public static final /* data */ class Position {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final double x1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final double y1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final double x2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final double y2;

        public Position(double d16, double d17, double d18, double d19) {
            this.x1 = d16;
            this.y1 = d17;
            this.x2 = d18;
            this.y2 = d19;
        }

        /* renamed from: a, reason: from getter */
        public final double getX1() {
            return this.x1;
        }

        /* renamed from: b, reason: from getter */
        public final double getY1() {
            return this.y1;
        }

        /* renamed from: c, reason: from getter */
        public final double getX2() {
            return this.x2;
        }

        /* renamed from: d, reason: from getter */
        public final double getY2() {
            return this.y2;
        }

        public final double e() {
            return this.x1;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Position)) {
                return false;
            }
            Position position = (Position) other;
            if (Intrinsics.areEqual((Object) Double.valueOf(this.x1), (Object) Double.valueOf(position.x1)) && Intrinsics.areEqual((Object) Double.valueOf(this.y1), (Object) Double.valueOf(position.y1)) && Intrinsics.areEqual((Object) Double.valueOf(this.x2), (Object) Double.valueOf(position.x2)) && Intrinsics.areEqual((Object) Double.valueOf(this.y2), (Object) Double.valueOf(position.y2))) {
                return true;
            }
            return false;
        }

        public final double f() {
            return this.x2;
        }

        public final double g() {
            return this.y1;
        }

        public final double h() {
            return this.y2;
        }

        public int hashCode() {
            return (((((com.tencent.biz.qqcircle.comment.recpic.a.a(this.x1) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.y1)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.x2)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.y2);
        }

        @NotNull
        public String toString() {
            return "Position(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
        }

        @NotNull
        public final Position a(double x16, double y16, double x26, double y26) {
            return new Position(x16, y16, x26, y26);
        }
    }

    public StickerItemInfo(int i3, @NotNull String name, int i16, @NotNull TriggerAction triggerAction, @NotNull String resPath, @NotNull String resPathMd5, @Nullable Position position, @NotNull StickerBackType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(triggerAction, "triggerAction");
        Intrinsics.checkNotNullParameter(resPath, "resPath");
        Intrinsics.checkNotNullParameter(resPathMd5, "resPathMd5");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = i3;
        this.name = name;
        this.frameCount = i16;
        this.triggerAction = triggerAction;
        this.resPath = resPath;
        this.resPathMd5 = resPathMd5;
        this.pos = position;
        this.type = type;
    }

    @NotNull
    public final StickerItemInfo a(int id5, @NotNull String name, int frameCount, @NotNull TriggerAction triggerAction, @NotNull String resPath, @NotNull String resPathMd5, @Nullable Position pos, @NotNull StickerBackType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(triggerAction, "triggerAction");
        Intrinsics.checkNotNullParameter(resPath, "resPath");
        Intrinsics.checkNotNullParameter(resPathMd5, "resPathMd5");
        Intrinsics.checkNotNullParameter(type, "type");
        return new StickerItemInfo(id5, name, frameCount, triggerAction, resPath, resPathMd5, pos, type);
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getFrameCount() {
        return this.frameCount;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TriggerAction getTriggerAction() {
        return this.triggerAction;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerItemInfo)) {
            return false;
        }
        StickerItemInfo stickerItemInfo = (StickerItemInfo) other;
        if (this.id == stickerItemInfo.id && Intrinsics.areEqual(this.name, stickerItemInfo.name) && this.frameCount == stickerItemInfo.frameCount && this.triggerAction == stickerItemInfo.triggerAction && Intrinsics.areEqual(this.resPath, stickerItemInfo.resPath) && Intrinsics.areEqual(this.resPathMd5, stickerItemInfo.resPathMd5) && Intrinsics.areEqual(this.pos, stickerItemInfo.pos) && this.type == stickerItemInfo.type) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getResPath() {
        return this.resPath;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getResPathMd5() {
        return this.resPathMd5;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Position getPos() {
        return this.pos;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.frameCount) * 31) + this.triggerAction.hashCode()) * 31) + this.resPath.hashCode()) * 31) + this.resPathMd5.hashCode()) * 31;
        Position position = this.pos;
        if (position == null) {
            hashCode = 0;
        } else {
            hashCode = position.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.type.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final StickerBackType getType() {
        return this.type;
    }

    public final int j() {
        return this.frameCount;
    }

    public final int k() {
        return this.id;
    }

    @NotNull
    public final String l() {
        return this.name;
    }

    @Nullable
    public final Position m() {
        return this.pos;
    }

    @NotNull
    public final String n() {
        return this.resPath;
    }

    @NotNull
    public final String o() {
        return this.resPathMd5;
    }

    @NotNull
    public final TriggerAction p() {
        return this.triggerAction;
    }

    @NotNull
    public final StickerBackType q() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "StickerItemInfo(id=" + this.id + ", name=" + this.name + ", frameCount=" + this.frameCount + ", triggerAction=" + this.triggerAction + ", resPath=" + this.resPath + ", resPathMd5=" + this.resPathMd5 + ", pos=" + this.pos + ", type=" + this.type + ')';
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "StickerItemInfo(resPath='" + this.resPath + "', resPathMd5='" + this.resPathMd5 + "')";
    }

    public /* synthetic */ StickerItemInfo(int i3, String str, int i16, TriggerAction triggerAction, String str2, String str3, Position position, StickerBackType stickerBackType, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, (i17 & 8) != 0 ? TriggerAction.DEFAULT_ACTION_LOOP : triggerAction, str2, (i17 & 32) != 0 ? "" : str3, (i17 & 64) != 0 ? null : position, (i17 & 128) != 0 ? StickerBackType.BACKGROUND : stickerBackType);
    }
}
