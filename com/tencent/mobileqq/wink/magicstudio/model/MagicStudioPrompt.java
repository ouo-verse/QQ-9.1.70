package com.tencent.mobileqq.wink.magicstudio.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\tH\u00c6\u0003J\t\u0010\r\u001a\u00020\tH\u00c6\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tH\u00c6\u0001J\t\u0010\u0013\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "promptID", "prompt", "defaultPromptInput", "defaultStyleId", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPromptID", "()Ljava/lang/String;", "getPrompt", "getDefaultPromptInput", "getDefaultStyleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioPrompt implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String defaultPromptInput;

    @NotNull
    private final String defaultStyleId;

    @NotNull
    private final String prompt;

    @NotNull
    private final String promptID;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MagicStudioPrompt> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MagicStudioPrompt createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MagicStudioPrompt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MagicStudioPrompt[] newArray(int size) {
            return new MagicStudioPrompt[size];
        }

        Companion() {
        }
    }

    public MagicStudioPrompt(@NotNull String promptID, @NotNull String prompt, @NotNull String defaultPromptInput, @NotNull String defaultStyleId) {
        Intrinsics.checkNotNullParameter(promptID, "promptID");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(defaultPromptInput, "defaultPromptInput");
        Intrinsics.checkNotNullParameter(defaultStyleId, "defaultStyleId");
        this.promptID = promptID;
        this.prompt = prompt;
        this.defaultPromptInput = defaultPromptInput;
        this.defaultStyleId = defaultStyleId;
    }

    public static /* synthetic */ MagicStudioPrompt copy$default(MagicStudioPrompt magicStudioPrompt, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = magicStudioPrompt.promptID;
        }
        if ((i3 & 2) != 0) {
            str2 = magicStudioPrompt.prompt;
        }
        if ((i3 & 4) != 0) {
            str3 = magicStudioPrompt.defaultPromptInput;
        }
        if ((i3 & 8) != 0) {
            str4 = magicStudioPrompt.defaultStyleId;
        }
        return magicStudioPrompt.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPromptID() {
        return this.promptID;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDefaultPromptInput() {
        return this.defaultPromptInput;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDefaultStyleId() {
        return this.defaultStyleId;
    }

    @NotNull
    public final MagicStudioPrompt copy(@NotNull String promptID, @NotNull String prompt, @NotNull String defaultPromptInput, @NotNull String defaultStyleId) {
        Intrinsics.checkNotNullParameter(promptID, "promptID");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(defaultPromptInput, "defaultPromptInput");
        Intrinsics.checkNotNullParameter(defaultStyleId, "defaultStyleId");
        return new MagicStudioPrompt(promptID, prompt, defaultPromptInput, defaultStyleId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioPrompt)) {
            return false;
        }
        MagicStudioPrompt magicStudioPrompt = (MagicStudioPrompt) other;
        if (Intrinsics.areEqual(this.promptID, magicStudioPrompt.promptID) && Intrinsics.areEqual(this.prompt, magicStudioPrompt.prompt) && Intrinsics.areEqual(this.defaultPromptInput, magicStudioPrompt.defaultPromptInput) && Intrinsics.areEqual(this.defaultStyleId, magicStudioPrompt.defaultStyleId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDefaultPromptInput() {
        return this.defaultPromptInput;
    }

    @NotNull
    public final String getDefaultStyleId() {
        return this.defaultStyleId;
    }

    @NotNull
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    public final String getPromptID() {
        return this.promptID;
    }

    public int hashCode() {
        return (((((this.promptID.hashCode() * 31) + this.prompt.hashCode()) * 31) + this.defaultPromptInput.hashCode()) * 31) + this.defaultStyleId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MagicStudioPrompt(promptID=" + this.promptID + ", prompt=" + this.prompt + ", defaultPromptInput=" + this.defaultPromptInput + ", defaultStyleId=" + this.defaultStyleId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.promptID);
        parcel.writeString(this.prompt);
        parcel.writeString(this.defaultPromptInput);
        parcel.writeString(this.defaultStyleId);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MagicStudioPrompt(@NotNull Parcel parcel) {
        this(r0, r2, r3, r5 != null ? r5 : "");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        readString2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        readString3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
    }
}
