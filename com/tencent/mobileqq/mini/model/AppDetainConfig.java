package com.tencent.mobileqq.mini.model;

import com.tencent.luggage.wxa.xd.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JK\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u0019J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "", "content", "", "exitButton", "enterButton", t0.NAME, "openType", "exitPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEnterButton", "getExitButton", "getExitPage", "getOpenLink", "getOpenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "isValidItem", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class AppDetainConfig {
    private final String content;
    private final String enterButton;
    private final String exitButton;
    private final String exitPage;
    private final String openLink;
    private final String openType;

    public AppDetainConfig(String content, String exitButton, String enterButton, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(exitButton, "exitButton");
        Intrinsics.checkNotNullParameter(enterButton, "enterButton");
        this.content = content;
        this.exitButton = exitButton;
        this.enterButton = enterButton;
        this.openLink = str;
        this.openType = str2;
        this.exitPage = str3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExitButton() {
        return this.exitButton;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEnterButton() {
        return this.enterButton;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOpenLink() {
        return this.openLink;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOpenType() {
        return this.openType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getExitPage() {
        return this.exitPage;
    }

    public final AppDetainConfig copy(String content, String exitButton, String enterButton, String openLink, String openType, String exitPage) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(exitButton, "exitButton");
        Intrinsics.checkNotNullParameter(enterButton, "enterButton");
        return new AppDetainConfig(content, exitButton, enterButton, openLink, openType, exitPage);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEnterButton() {
        return this.enterButton;
    }

    public final String getExitButton() {
        return this.exitButton;
    }

    public final String getExitPage() {
        return this.exitPage;
    }

    public final String getOpenLink() {
        return this.openLink;
    }

    public final String getOpenType() {
        return this.openType;
    }

    public int hashCode() {
        int hashCode = ((((this.content.hashCode() * 31) + this.exitButton.hashCode()) * 31) + this.enterButton.hashCode()) * 31;
        String str = this.openLink;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.openType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.exitPage;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isValidItem() {
        if (this.content.length() > 0) {
            if (this.exitButton.length() > 0) {
                if (this.enterButton.length() > 0) {
                    String str = this.exitPage;
                    if (str == null) {
                        return true;
                    }
                    if (str.length() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return "AppDetainConfig(content=" + this.content + ", exitButton=" + this.exitButton + ", enterButton=" + this.enterButton + ", openLink=" + this.openLink + ", openType=" + this.openType + ", exitPage=" + this.exitPage + ")";
    }

    public static /* synthetic */ AppDetainConfig copy$default(AppDetainConfig appDetainConfig, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = appDetainConfig.content;
        }
        if ((i3 & 2) != 0) {
            str2 = appDetainConfig.exitButton;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = appDetainConfig.enterButton;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = appDetainConfig.openLink;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = appDetainConfig.openType;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = appDetainConfig.exitPage;
        }
        return appDetainConfig.copy(str, str7, str8, str9, str10, str6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppDetainConfig)) {
            return false;
        }
        AppDetainConfig appDetainConfig = (AppDetainConfig) other;
        return Intrinsics.areEqual(this.content, appDetainConfig.content) && Intrinsics.areEqual(this.exitButton, appDetainConfig.exitButton) && Intrinsics.areEqual(this.enterButton, appDetainConfig.enterButton) && Intrinsics.areEqual(this.openLink, appDetainConfig.openLink) && Intrinsics.areEqual(this.openType, appDetainConfig.openType) && Intrinsics.areEqual(this.exitPage, appDetainConfig.exitPage);
    }

    public /* synthetic */ AppDetainConfig(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6);
    }
}
