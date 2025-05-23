package com.tencent.mobileqq.vas.transit;

import bd3.e;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B+\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "Lbd3/e;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "", "getSmallHomeMasterUin", "toString", "Lcom/tencent/mobileqq/vas/transit/MasterInfo;", "component1", "Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "component2", "Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;", "component3", "Lcom/tencent/mobileqq/vas/transit/ExtInfo;", "component4", "masterInfo", "visitorInfo", DownloadInfo.spKey_Config, "extInfo", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/vas/transit/MasterInfo;", "getMasterInfo", "()Lcom/tencent/mobileqq/vas/transit/MasterInfo;", "Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "getVisitorInfo", "()Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;", "getConfig", "()Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;", "Lcom/tencent/mobileqq/vas/transit/ExtInfo;", "getExtInfo", "()Lcom/tencent/mobileqq/vas/transit/ExtInfo;", "<init>", "(Lcom/tencent/mobileqq/vas/transit/MasterInfo;Lcom/tencent/mobileqq/vas/transit/VisitorInfo;Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;Lcom/tencent/mobileqq/vas/transit/ExtInfo;)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class TransitPageInfo implements e, Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final TransitPageConfig config;

    @NotNull
    private final ExtInfo extInfo;

    @NotNull
    private final MasterInfo masterInfo;

    @NotNull
    private final VisitorInfo visitorInfo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/TransitPageInfo$a;", "", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "data", "", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.transit.TransitPageInfo$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull TransitPageInfo data) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(data, "data");
            String uin = data.getMasterInfo().getUin();
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            if (data.getConfig().getTransitType() == 1) {
                String guildId = data.getMasterInfo().getGuildId();
                if (guildId != null && guildId.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    return false;
                }
            }
            return true;
        }

        Companion() {
        }
    }

    public TransitPageInfo(@NotNull MasterInfo masterInfo, @NotNull VisitorInfo visitorInfo, @NotNull TransitPageConfig config, @NotNull ExtInfo extInfo) {
        Intrinsics.checkNotNullParameter(masterInfo, "masterInfo");
        Intrinsics.checkNotNullParameter(visitorInfo, "visitorInfo");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.masterInfo = masterInfo;
        this.visitorInfo = visitorInfo;
        this.config = config;
        this.extInfo = extInfo;
    }

    public static /* synthetic */ TransitPageInfo copy$default(TransitPageInfo transitPageInfo, MasterInfo masterInfo, VisitorInfo visitorInfo, TransitPageConfig transitPageConfig, ExtInfo extInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            masterInfo = transitPageInfo.masterInfo;
        }
        if ((i3 & 2) != 0) {
            visitorInfo = transitPageInfo.visitorInfo;
        }
        if ((i3 & 4) != 0) {
            transitPageConfig = transitPageInfo.config;
        }
        if ((i3 & 8) != 0) {
            extInfo = transitPageInfo.extInfo;
        }
        return transitPageInfo.copy(masterInfo, visitorInfo, transitPageConfig, extInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final MasterInfo getMasterInfo() {
        return this.masterInfo;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final VisitorInfo getVisitorInfo() {
        return this.visitorInfo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final TransitPageConfig getConfig() {
        return this.config;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @NotNull
    public final TransitPageInfo copy(@NotNull MasterInfo masterInfo, @NotNull VisitorInfo visitorInfo, @NotNull TransitPageConfig config, @NotNull ExtInfo extInfo) {
        Intrinsics.checkNotNullParameter(masterInfo, "masterInfo");
        Intrinsics.checkNotNullParameter(visitorInfo, "visitorInfo");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        return new TransitPageInfo(masterInfo, visitorInfo, config, extInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransitPageInfo)) {
            return false;
        }
        TransitPageInfo transitPageInfo = (TransitPageInfo) other;
        if (Intrinsics.areEqual(this.masterInfo, transitPageInfo.masterInfo) && Intrinsics.areEqual(this.visitorInfo, transitPageInfo.visitorInfo) && Intrinsics.areEqual(this.config, transitPageInfo.config) && Intrinsics.areEqual(this.extInfo, transitPageInfo.extInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TransitPageConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @NotNull
    public final MasterInfo getMasterInfo() {
        return this.masterInfo;
    }

    @Override // bd3.e
    @Nullable
    public String getSmallHomeMasterUin() {
        MasterInfo masterInfo = this.masterInfo;
        if (masterInfo != null) {
            return masterInfo.getUin();
        }
        return null;
    }

    @Override // bd3.e
    @Nullable
    public ZootopiaSource getSource() {
        return this.extInfo.getSource();
    }

    @NotNull
    public final VisitorInfo getVisitorInfo() {
        return this.visitorInfo;
    }

    public int hashCode() {
        return (((((this.masterInfo.hashCode() * 31) + this.visitorInfo.hashCode()) * 31) + this.config.hashCode()) * 31) + this.extInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "TransitPageInfo(masterInfo=" + this.masterInfo + ", visitorInfo=" + this.visitorInfo + ", config=" + this.config + ", extInfo=" + this.extInfo + ')';
    }

    public /* synthetic */ TransitPageInfo(MasterInfo masterInfo, VisitorInfo visitorInfo, TransitPageConfig transitPageConfig, ExtInfo extInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(masterInfo, visitorInfo, (i3 & 4) != 0 ? new TransitPageConfig() : transitPageConfig, (i3 & 8) != 0 ? new ExtInfo() : extInfo);
    }
}
