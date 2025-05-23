package com.tencent.mobileqq.util.conversationtitlebutton;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "", "", "i", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "businessId", "I", "f", "()I", "redDotSet", "c", "e", "redDotAppId", "d", tl.h.F, "tipsSet", "g", "tipsAppId", "iconUrl", WadlProxyConsts.KEY_JUMP_URL, NodeProps.PROP_ACCESSIBILITY_LABEL, "<init>", "(Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.util.conversationtitlebutton.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class ConversationTitleBtnConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String businessId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redDotSet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redDotAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tipsSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tipsAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String accessibilityLabel;

    public ConversationTitleBtnConfig() {
        this(null, 0, 0, 0, 0, null, null, null, 255, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBusinessId() {
        return this.businessId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getRedDotAppId() {
        return this.redDotAppId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationTitleBtnConfig)) {
            return false;
        }
        ConversationTitleBtnConfig conversationTitleBtnConfig = (ConversationTitleBtnConfig) other;
        if (Intrinsics.areEqual(this.businessId, conversationTitleBtnConfig.businessId) && this.redDotSet == conversationTitleBtnConfig.redDotSet && this.redDotAppId == conversationTitleBtnConfig.redDotAppId && this.tipsSet == conversationTitleBtnConfig.tipsSet && this.tipsAppId == conversationTitleBtnConfig.tipsAppId && Intrinsics.areEqual(this.iconUrl, conversationTitleBtnConfig.iconUrl) && Intrinsics.areEqual(this.jumpUrl, conversationTitleBtnConfig.jumpUrl) && Intrinsics.areEqual(this.accessibilityLabel, conversationTitleBtnConfig.accessibilityLabel)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getRedDotSet() {
        return this.redDotSet;
    }

    /* renamed from: g, reason: from getter */
    public final int getTipsAppId() {
        return this.tipsAppId;
    }

    /* renamed from: h, reason: from getter */
    public final int getTipsSet() {
        return this.tipsSet;
    }

    public int hashCode() {
        return (((((((((((((this.businessId.hashCode() * 31) + this.redDotSet) * 31) + this.redDotAppId) * 31) + this.tipsSet) * 31) + this.tipsAppId) * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.accessibilityLabel.hashCode();
    }

    public final boolean i() {
        if (!TextUtils.isEmpty(this.businessId) && !TextUtils.isEmpty(this.iconUrl) && !TextUtils.isEmpty(this.jumpUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "ConversationTitleBtnConfig(businessId=" + this.businessId + ", redDotSet=" + this.redDotSet + ", redDotAppId=" + this.redDotAppId + ", tipsSet=" + this.tipsSet + ", tipsAppId=" + this.tipsAppId + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", accessibilityLabel=" + this.accessibilityLabel + ")";
    }

    public ConversationTitleBtnConfig(@NotNull String businessId, int i3, int i16, int i17, int i18, @NotNull String iconUrl, @NotNull String jumpUrl, @NotNull String accessibilityLabel) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(accessibilityLabel, "accessibilityLabel");
        this.businessId = businessId;
        this.redDotSet = i3;
        this.redDotAppId = i16;
        this.tipsSet = i17;
        this.tipsAppId = i18;
        this.iconUrl = iconUrl;
        this.jumpUrl = jumpUrl;
        this.accessibilityLabel = accessibilityLabel;
    }

    public /* synthetic */ ConversationTitleBtnConfig(String str, int i3, int i16, int i17, int i18, String str2, String str3, String str4, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? -1 : i3, (i19 & 4) != 0 ? -1 : i16, (i19 & 8) != 0 ? -1 : i17, (i19 & 16) == 0 ? i18 : -1, (i19 & 32) != 0 ? "" : str2, (i19 & 64) != 0 ? "" : str3, (i19 & 128) == 0 ? str4 : "");
    }
}
