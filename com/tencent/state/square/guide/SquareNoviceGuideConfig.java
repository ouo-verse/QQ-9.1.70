package com.tencent.state.square.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "", "publishStatusGuideConfig", "Lcom/tencent/state/square/guide/PublishStatusGuideConfig;", "createRoleGuideConfig", "Lcom/tencent/state/square/guide/CreateRoleGuideConfig;", "(Lcom/tencent/state/square/guide/PublishStatusGuideConfig;Lcom/tencent/state/square/guide/CreateRoleGuideConfig;)V", "getCreateRoleGuideConfig", "()Lcom/tencent/state/square/guide/CreateRoleGuideConfig;", "setCreateRoleGuideConfig", "(Lcom/tencent/state/square/guide/CreateRoleGuideConfig;)V", "getPublishStatusGuideConfig", "()Lcom/tencent/state/square/guide/PublishStatusGuideConfig;", "setPublishStatusGuideConfig", "(Lcom/tencent/state/square/guide/PublishStatusGuideConfig;)V", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareNoviceGuideConfig {
    private CreateRoleGuideConfig createRoleGuideConfig;
    private PublishStatusGuideConfig publishStatusGuideConfig;

    public SquareNoviceGuideConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final CreateRoleGuideConfig getCreateRoleGuideConfig() {
        return this.createRoleGuideConfig;
    }

    public final PublishStatusGuideConfig getPublishStatusGuideConfig() {
        return this.publishStatusGuideConfig;
    }

    public final void setCreateRoleGuideConfig(CreateRoleGuideConfig createRoleGuideConfig) {
        Intrinsics.checkNotNullParameter(createRoleGuideConfig, "<set-?>");
        this.createRoleGuideConfig = createRoleGuideConfig;
    }

    public final void setPublishStatusGuideConfig(PublishStatusGuideConfig publishStatusGuideConfig) {
        Intrinsics.checkNotNullParameter(publishStatusGuideConfig, "<set-?>");
        this.publishStatusGuideConfig = publishStatusGuideConfig;
    }

    public String toString() {
        return "[rol:" + this.createRoleGuideConfig + ", sta:" + this.publishStatusGuideConfig + ']';
    }

    public SquareNoviceGuideConfig(PublishStatusGuideConfig publishStatusGuideConfig, CreateRoleGuideConfig createRoleGuideConfig) {
        Intrinsics.checkNotNullParameter(publishStatusGuideConfig, "publishStatusGuideConfig");
        Intrinsics.checkNotNullParameter(createRoleGuideConfig, "createRoleGuideConfig");
        this.publishStatusGuideConfig = publishStatusGuideConfig;
        this.createRoleGuideConfig = createRoleGuideConfig;
    }

    public /* synthetic */ SquareNoviceGuideConfig(PublishStatusGuideConfig publishStatusGuideConfig, CreateRoleGuideConfig createRoleGuideConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new PublishStatusGuideConfig(false, 0L, null, false, 15, null) : publishStatusGuideConfig, (i3 & 2) != 0 ? new CreateRoleGuideConfig(false, 0L, null, null, null, 31, null) : createRoleGuideConfig);
    }
}
