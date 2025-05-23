package com.tencent.mobileqq.guild.util;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'VIEW_TYPE_GROUP_NAME' uses external variables
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "VIEW_TYPE_INVALID", "VIEW_TYPE_CHANNEL_ITEM", "VIEW_TYPE_GROUP_NAME", "VIEW_TYPE_FEED_SQUARE", "VIEW_TYPE_FEED_SECTION", "VIEW_TYPE_FEED_DIVIDE", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class HashTagViewType {
    public static final HashTagViewType VIEW_TYPE_FEED_DIVIDE;
    public static final HashTagViewType VIEW_TYPE_GROUP_NAME;
    private final int value;
    public static final HashTagViewType VIEW_TYPE_INVALID = new HashTagViewType("VIEW_TYPE_INVALID", 0, 0, 1, null);
    public static final HashTagViewType VIEW_TYPE_CHANNEL_ITEM = new HashTagViewType("VIEW_TYPE_CHANNEL_ITEM", 1, 16);
    public static final HashTagViewType VIEW_TYPE_FEED_SQUARE = new HashTagViewType("VIEW_TYPE_FEED_SQUARE", 3, 512);
    public static final HashTagViewType VIEW_TYPE_FEED_SECTION = new HashTagViewType("VIEW_TYPE_FEED_SECTION", 4, 16);
    private static final /* synthetic */ HashTagViewType[] $VALUES = $values();

    private static final /* synthetic */ HashTagViewType[] $values() {
        return new HashTagViewType[]{VIEW_TYPE_INVALID, VIEW_TYPE_CHANNEL_ITEM, VIEW_TYPE_GROUP_NAME, VIEW_TYPE_FEED_SQUARE, VIEW_TYPE_FEED_SECTION, VIEW_TYPE_FEED_DIVIDE};
    }

    static {
        int i3 = 0;
        int i16 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        VIEW_TYPE_GROUP_NAME = new HashTagViewType("VIEW_TYPE_GROUP_NAME", 2, i3, i16, defaultConstructorMarker);
        VIEW_TYPE_FEED_DIVIDE = new HashTagViewType("VIEW_TYPE_FEED_DIVIDE", 5, i3, i16, defaultConstructorMarker);
    }

    HashTagViewType(String str, int i3, int i16) {
        this.value = i16;
    }

    public static HashTagViewType valueOf(String str) {
        return (HashTagViewType) Enum.valueOf(HashTagViewType.class, str);
    }

    public static HashTagViewType[] values() {
        return (HashTagViewType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    /* synthetic */ HashTagViewType(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i17 & 1) != 0 ? -1 : i16);
    }
}
