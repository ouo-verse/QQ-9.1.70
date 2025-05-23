package com.tencent.robot.profile.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u0082\u0001\u0003\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/profile/data/a;", "", "Lcom/tencent/robot/profile/data/AddToTroopItemType;", "a", "Lcom/tencent/robot/profile/data/AddToTroopItemType;", "b", "()Lcom/tencent/robot/profile/data/AddToTroopItemType;", "itemType", "", "Ljava/lang/String;", "()Ljava/lang/String;", "itemId", "<init>", "(Lcom/tencent/robot/profile/data/AddToTroopItemType;Ljava/lang/String;)V", "Lcom/tencent/robot/profile/data/b;", "Lcom/tencent/robot/profile/data/c;", "Lcom/tencent/robot/profile/data/q;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AddToTroopItemType itemType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String itemId;

    public /* synthetic */ a(AddToTroopItemType addToTroopItemType, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(addToTroopItemType, str);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public String getItemId() {
        return this.itemId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AddToTroopItemType getItemType() {
        return this.itemType;
    }

    a(AddToTroopItemType addToTroopItemType, String str) {
        this.itemType = addToTroopItemType;
        this.itemId = str;
    }
}
