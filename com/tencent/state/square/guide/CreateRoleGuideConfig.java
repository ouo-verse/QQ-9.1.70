package com.tencent.state.square.guide;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\t\u0010%\u001a\u00020\u000bH\u00c6\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\b\u0010+\u001a\u00020\u0007H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/guide/CreateRoleGuideConfig;", "", "alreadyCreateRole", "", "pagDisplayNum", "", "bornPagUrl", "", "createRolePageConfig", "Lcom/tencent/state/square/guide/CreateRolePageConfig;", "createRoleRedDotBubbleConfig", "Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;", "(ZJLjava/lang/String;Lcom/tencent/state/square/guide/CreateRolePageConfig;Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;)V", "getAlreadyCreateRole", "()Z", "setAlreadyCreateRole", "(Z)V", "getBornPagUrl", "()Ljava/lang/String;", "setBornPagUrl", "(Ljava/lang/String;)V", "getCreateRolePageConfig", "()Lcom/tencent/state/square/guide/CreateRolePageConfig;", "setCreateRolePageConfig", "(Lcom/tencent/state/square/guide/CreateRolePageConfig;)V", "getCreateRoleRedDotBubbleConfig", "()Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;", "setCreateRoleRedDotBubbleConfig", "(Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;)V", "getPagDisplayNum", "()J", "setPagDisplayNum", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CreateRoleGuideConfig {
    private boolean alreadyCreateRole;
    private String bornPagUrl;
    private CreateRolePageConfig createRolePageConfig;
    private CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig;
    private long pagDisplayNum;

    public CreateRoleGuideConfig() {
        this(false, 0L, null, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getAlreadyCreateRole() {
        return this.alreadyCreateRole;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPagDisplayNum() {
        return this.pagDisplayNum;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBornPagUrl() {
        return this.bornPagUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final CreateRolePageConfig getCreateRolePageConfig() {
        return this.createRolePageConfig;
    }

    /* renamed from: component5, reason: from getter */
    public final CreateRoleRedDotBubbleConfig getCreateRoleRedDotBubbleConfig() {
        return this.createRoleRedDotBubbleConfig;
    }

    public final CreateRoleGuideConfig copy(boolean alreadyCreateRole, long pagDisplayNum, String bornPagUrl, CreateRolePageConfig createRolePageConfig, CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig) {
        Intrinsics.checkNotNullParameter(bornPagUrl, "bornPagUrl");
        Intrinsics.checkNotNullParameter(createRolePageConfig, "createRolePageConfig");
        Intrinsics.checkNotNullParameter(createRoleRedDotBubbleConfig, "createRoleRedDotBubbleConfig");
        return new CreateRoleGuideConfig(alreadyCreateRole, pagDisplayNum, bornPagUrl, createRolePageConfig, createRoleRedDotBubbleConfig);
    }

    public final boolean getAlreadyCreateRole() {
        return this.alreadyCreateRole;
    }

    public final String getBornPagUrl() {
        return this.bornPagUrl;
    }

    public final CreateRolePageConfig getCreateRolePageConfig() {
        return this.createRolePageConfig;
    }

    public final CreateRoleRedDotBubbleConfig getCreateRoleRedDotBubbleConfig() {
        return this.createRoleRedDotBubbleConfig;
    }

    public final long getPagDisplayNum() {
        return this.pagDisplayNum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.alreadyCreateRole;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + c.a(this.pagDisplayNum)) * 31;
        String str = this.bornPagUrl;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        CreateRolePageConfig createRolePageConfig = this.createRolePageConfig;
        int hashCode2 = (hashCode + (createRolePageConfig != null ? createRolePageConfig.hashCode() : 0)) * 31;
        CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig = this.createRoleRedDotBubbleConfig;
        return hashCode2 + (createRoleRedDotBubbleConfig != null ? createRoleRedDotBubbleConfig.hashCode() : 0);
    }

    public final void setAlreadyCreateRole(boolean z16) {
        this.alreadyCreateRole = z16;
    }

    public final void setBornPagUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bornPagUrl = str;
    }

    public final void setCreateRolePageConfig(CreateRolePageConfig createRolePageConfig) {
        Intrinsics.checkNotNullParameter(createRolePageConfig, "<set-?>");
        this.createRolePageConfig = createRolePageConfig;
    }

    public final void setCreateRoleRedDotBubbleConfig(CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig) {
        Intrinsics.checkNotNullParameter(createRoleRedDotBubbleConfig, "<set-?>");
        this.createRoleRedDotBubbleConfig = createRoleRedDotBubbleConfig;
    }

    public final void setPagDisplayNum(long j3) {
        this.pagDisplayNum = j3;
    }

    public String toString() {
        return '{' + this.alreadyCreateRole + ", " + this.pagDisplayNum + ", " + this.bornPagUrl + ", " + this.createRolePageConfig + ", " + this.createRoleRedDotBubbleConfig + '}';
    }

    public CreateRoleGuideConfig(boolean z16, long j3, String bornPagUrl, CreateRolePageConfig createRolePageConfig, CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig) {
        Intrinsics.checkNotNullParameter(bornPagUrl, "bornPagUrl");
        Intrinsics.checkNotNullParameter(createRolePageConfig, "createRolePageConfig");
        Intrinsics.checkNotNullParameter(createRoleRedDotBubbleConfig, "createRoleRedDotBubbleConfig");
        this.alreadyCreateRole = z16;
        this.pagDisplayNum = j3;
        this.bornPagUrl = bornPagUrl;
        this.createRolePageConfig = createRolePageConfig;
        this.createRoleRedDotBubbleConfig = createRoleRedDotBubbleConfig;
    }

    public /* synthetic */ CreateRoleGuideConfig(boolean z16, long j3, String str, CreateRolePageConfig createRolePageConfig, CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 1L : j3, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? new CreateRolePageConfig(null, null, null, null, null, 31, null) : createRolePageConfig, (i3 & 16) != 0 ? new CreateRoleRedDotBubbleConfig(false, null, 0, null, 15, null) : createRoleRedDotBubbleConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateRoleGuideConfig)) {
            return false;
        }
        CreateRoleGuideConfig createRoleGuideConfig = (CreateRoleGuideConfig) other;
        return this.alreadyCreateRole == createRoleGuideConfig.alreadyCreateRole && this.pagDisplayNum == createRoleGuideConfig.pagDisplayNum && Intrinsics.areEqual(this.bornPagUrl, createRoleGuideConfig.bornPagUrl) && Intrinsics.areEqual(this.createRolePageConfig, createRoleGuideConfig.createRolePageConfig) && Intrinsics.areEqual(this.createRoleRedDotBubbleConfig, createRoleGuideConfig.createRoleRedDotBubbleConfig);
    }

    public static /* synthetic */ CreateRoleGuideConfig copy$default(CreateRoleGuideConfig createRoleGuideConfig, boolean z16, long j3, String str, CreateRolePageConfig createRolePageConfig, CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = createRoleGuideConfig.alreadyCreateRole;
        }
        if ((i3 & 2) != 0) {
            j3 = createRoleGuideConfig.pagDisplayNum;
        }
        long j16 = j3;
        if ((i3 & 4) != 0) {
            str = createRoleGuideConfig.bornPagUrl;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            createRolePageConfig = createRoleGuideConfig.createRolePageConfig;
        }
        CreateRolePageConfig createRolePageConfig2 = createRolePageConfig;
        if ((i3 & 16) != 0) {
            createRoleRedDotBubbleConfig = createRoleGuideConfig.createRoleRedDotBubbleConfig;
        }
        return createRoleGuideConfig.copy(z16, j16, str2, createRolePageConfig2, createRoleRedDotBubbleConfig);
    }
}
