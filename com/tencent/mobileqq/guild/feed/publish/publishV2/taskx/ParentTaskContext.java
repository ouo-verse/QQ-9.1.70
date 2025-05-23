package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "parentId", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "allowPreUploadNow", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ParentTaskContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String parentId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Boolean> allowPreUploadNow;

    public ParentTaskContext(@NotNull String parentId, @NotNull Function0<Boolean> allowPreUploadNow) {
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(allowPreUploadNow, "allowPreUploadNow");
        this.parentId = parentId;
        this.allowPreUploadNow = allowPreUploadNow;
    }

    @NotNull
    public final Function0<Boolean> a() {
        return this.allowPreUploadNow;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getParentId() {
        return this.parentId;
    }

    public /* synthetic */ ParentTaskContext(String str, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.ParentTaskContext.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        } : function0);
    }
}
