package com.tencent.mobileqq.guild.homev2.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/c;", "Lkotlin/properties/ReadWriteProperty;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "value", "", "b", "Ljava/lang/String;", "guildId", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class c implements ReadWriteProperty<a, String> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    public c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getValue(@NotNull a thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        return this.guildId;
    }

    @Override // kotlin.properties.ReadWriteProperty
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void setValue(@NotNull a thisRef, @NotNull KProperty<?> property, @NotNull String value) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = this.guildId;
        this.guildId = value;
        thisRef.Z2(str);
    }
}
