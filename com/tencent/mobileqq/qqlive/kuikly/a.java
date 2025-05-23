package com.tencent.mobileqq.qqlive.kuikly;

import com.tencent.freesia.IConfigData;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/kuikly/a;", "Lcom/tencent/freesia/IConfigData;", "", "", "d", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "bundleList", "", "e", "J", "b", "()J", "c", "(J)V", "cooldown", "<init>", "()V", "f", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> bundleList = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long cooldown = 30000;

    @NotNull
    public final Set<String> a() {
        return this.bundleList;
    }

    /* renamed from: b, reason: from getter */
    public final long getCooldown() {
        return this.cooldown;
    }

    public final void c(long j3) {
        this.cooldown = j3;
    }
}
