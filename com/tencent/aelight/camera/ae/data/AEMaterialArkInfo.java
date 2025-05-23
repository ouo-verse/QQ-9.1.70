package com.tencent.aelight.camera.ae.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aelight/camera/ae/data/AEMaterialArkInfo;", "", "type", "", "coverImageUrl", "prompt", "shareMsg", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverImageUrl", "()Ljava/lang/String;", "getPrompt", "getShareMsg", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "aelight_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final /* data */ class AEMaterialArkInfo {
    private final String coverImageUrl;
    private final String prompt;
    private final String shareMsg;
    private final String title;
    private final String type;

    public AEMaterialArkInfo(String type, String coverImageUrl, String prompt, String shareMsg, String title) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(coverImageUrl, "coverImageUrl");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(shareMsg, "shareMsg");
        Intrinsics.checkNotNullParameter(title, "title");
        this.type = type;
        this.coverImageUrl = coverImageUrl;
        this.prompt = prompt;
        this.shareMsg = shareMsg;
        this.title = title;
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getShareMsg() {
        return this.shareMsg;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final AEMaterialArkInfo copy(String type, String coverImageUrl, String prompt, String shareMsg, String title) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(coverImageUrl, "coverImageUrl");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(shareMsg, "shareMsg");
        Intrinsics.checkNotNullParameter(title, "title");
        return new AEMaterialArkInfo(type, coverImageUrl, prompt, shareMsg, title);
    }

    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getShareMsg() {
        return this.shareMsg;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.coverImageUrl.hashCode()) * 31) + this.prompt.hashCode()) * 31) + this.shareMsg.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "AEMaterialArkInfo(type=" + this.type + ", coverImageUrl=" + this.coverImageUrl + ", prompt=" + this.prompt + ", shareMsg=" + this.shareMsg + ", title=" + this.title + ")";
    }

    public static /* synthetic */ AEMaterialArkInfo copy$default(AEMaterialArkInfo aEMaterialArkInfo, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aEMaterialArkInfo.type;
        }
        if ((i3 & 2) != 0) {
            str2 = aEMaterialArkInfo.coverImageUrl;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = aEMaterialArkInfo.prompt;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = aEMaterialArkInfo.shareMsg;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = aEMaterialArkInfo.title;
        }
        return aEMaterialArkInfo.copy(str, str6, str7, str8, str5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AEMaterialArkInfo)) {
            return false;
        }
        AEMaterialArkInfo aEMaterialArkInfo = (AEMaterialArkInfo) other;
        return Intrinsics.areEqual(this.type, aEMaterialArkInfo.type) && Intrinsics.areEqual(this.coverImageUrl, aEMaterialArkInfo.coverImageUrl) && Intrinsics.areEqual(this.prompt, aEMaterialArkInfo.prompt) && Intrinsics.areEqual(this.shareMsg, aEMaterialArkInfo.shareMsg) && Intrinsics.areEqual(this.title, aEMaterialArkInfo.title);
    }
}
