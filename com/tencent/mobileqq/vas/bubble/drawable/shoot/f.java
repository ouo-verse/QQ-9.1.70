package com.tencent.mobileqq.vas.bubble.drawable.shoot;

import com.heytap.databaseengine.model.UserInfo;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/f;", "", "", "a", UserInfo.SEX_FEMALE, "()F", "c", "(F)V", com.tencent.luggage.wxa.c8.c.f123400v, "", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/g;", "b", "Ljava/util/Set;", "()Ljava/util/Set;", "d", "(Ljava/util/Set;)V", "xaRect", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float alpha;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Set<XARect> xaRect;

    /* renamed from: a, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final Set<XARect> b() {
        return this.xaRect;
    }

    public final void c(float f16) {
        this.alpha = f16;
    }

    public final void d(@Nullable Set<XARect> set) {
        this.xaRect = set;
    }
}
