package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.base.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/e;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/l;", "", "getItemType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "", "areContentsTheSame", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements com.tencent.mobileqq.guild.discoveryv2.content.base.l {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f217110d = new e();

    e() {
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof e;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.a(this, hVar);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.b(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.d();
    }
}
