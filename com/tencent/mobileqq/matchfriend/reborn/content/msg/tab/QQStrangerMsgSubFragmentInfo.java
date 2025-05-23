package com.tencent.mobileqq.matchfriend.reborn.content.msg.tab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerMsgSubFragmentType;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerMsgSubFragmentType;", "b", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerMsgSubFragmentType;", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "c", "getIcon", "icon", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerMsgSubFragmentType;Ljava/lang/String;Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.b, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerMsgSubFragmentInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final QQStrangerMsgSubFragmentType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String icon;

    public QQStrangerMsgSubFragmentInfo(QQStrangerMsgSubFragmentType type, String name, String icon) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.type = type;
        this.name = name;
        this.icon = icon;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final QQStrangerMsgSubFragmentType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "QQStrangerMsgSubFragmentInfo(type=" + this.type + ", name=" + this.name + ", icon=" + this.icon + ")";
    }

    public /* synthetic */ QQStrangerMsgSubFragmentInfo(QQStrangerMsgSubFragmentType qQStrangerMsgSubFragmentType, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(qQStrangerMsgSubFragmentType, str, (i3 & 4) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerMsgSubFragmentInfo)) {
            return false;
        }
        QQStrangerMsgSubFragmentInfo qQStrangerMsgSubFragmentInfo = (QQStrangerMsgSubFragmentInfo) other;
        return this.type == qQStrangerMsgSubFragmentInfo.type && Intrinsics.areEqual(this.name, qQStrangerMsgSubFragmentInfo.name) && Intrinsics.areEqual(this.icon, qQStrangerMsgSubFragmentInfo.icon);
    }
}
