package com.tencent.state.square.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/guide/CreateRolePageConfig;", "", "rolePagUrl", "", "firstText", "secondText", "buttonText", "buttonJumpSchema", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonJumpSchema", "()Ljava/lang/String;", "setButtonJumpSchema", "(Ljava/lang/String;)V", "getButtonText", "setButtonText", "getFirstText", "setFirstText", "getRolePagUrl", "setRolePagUrl", "getSecondText", "setSecondText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CreateRolePageConfig {
    private String buttonJumpSchema;
    private String buttonText;
    private String firstText;
    private String rolePagUrl;
    private String secondText;

    public CreateRolePageConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRolePagUrl() {
        return this.rolePagUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFirstText() {
        return this.firstText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSecondText() {
        return this.secondText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getButtonJumpSchema() {
        return this.buttonJumpSchema;
    }

    public final CreateRolePageConfig copy(String rolePagUrl, String firstText, String secondText, String buttonText, String buttonJumpSchema) {
        Intrinsics.checkNotNullParameter(rolePagUrl, "rolePagUrl");
        Intrinsics.checkNotNullParameter(firstText, "firstText");
        Intrinsics.checkNotNullParameter(secondText, "secondText");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(buttonJumpSchema, "buttonJumpSchema");
        return new CreateRolePageConfig(rolePagUrl, firstText, secondText, buttonText, buttonJumpSchema);
    }

    public final String getButtonJumpSchema() {
        return this.buttonJumpSchema;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getFirstText() {
        return this.firstText;
    }

    public final String getRolePagUrl() {
        return this.rolePagUrl;
    }

    public final String getSecondText() {
        return this.secondText;
    }

    public int hashCode() {
        String str = this.rolePagUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.secondText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.buttonText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.buttonJumpSchema;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setButtonJumpSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonJumpSchema = str;
    }

    public final void setButtonText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonText = str;
    }

    public final void setFirstText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstText = str;
    }

    public final void setRolePagUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rolePagUrl = str;
    }

    public final void setSecondText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondText = str;
    }

    public String toString() {
        return '{' + this.rolePagUrl + ", " + this.firstText + ", " + this.secondText + ", " + this.buttonText + ", " + this.buttonJumpSchema + '}';
    }

    public CreateRolePageConfig(String rolePagUrl, String firstText, String secondText, String buttonText, String buttonJumpSchema) {
        Intrinsics.checkNotNullParameter(rolePagUrl, "rolePagUrl");
        Intrinsics.checkNotNullParameter(firstText, "firstText");
        Intrinsics.checkNotNullParameter(secondText, "secondText");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(buttonJumpSchema, "buttonJumpSchema");
        this.rolePagUrl = rolePagUrl;
        this.firstText = firstText;
        this.secondText = secondText;
        this.buttonText = buttonText;
        this.buttonJumpSchema = buttonJumpSchema;
    }

    public /* synthetic */ CreateRolePageConfig(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "\u6b22\u8fce\u6765\u5230QQ\u52a8\u6001\u5e7f\u573a" : str2, (i3 & 4) != 0 ? "\u6253\u626e\u4e0b\u81ea\u5df1\uff0c\u548c\u670b\u53cb\u4eec\u4e00\u8d77\u73a9\u5427!" : str3, (i3 & 8) != 0 ? "\u7acb\u5373\u88c5\u626e" : str4, (i3 & 16) != 0 ? "" : str5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateRolePageConfig)) {
            return false;
        }
        CreateRolePageConfig createRolePageConfig = (CreateRolePageConfig) other;
        return Intrinsics.areEqual(this.rolePagUrl, createRolePageConfig.rolePagUrl) && Intrinsics.areEqual(this.firstText, createRolePageConfig.firstText) && Intrinsics.areEqual(this.secondText, createRolePageConfig.secondText) && Intrinsics.areEqual(this.buttonText, createRolePageConfig.buttonText) && Intrinsics.areEqual(this.buttonJumpSchema, createRolePageConfig.buttonJumpSchema);
    }

    public static /* synthetic */ CreateRolePageConfig copy$default(CreateRolePageConfig createRolePageConfig, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = createRolePageConfig.rolePagUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = createRolePageConfig.firstText;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = createRolePageConfig.secondText;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = createRolePageConfig.buttonText;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = createRolePageConfig.buttonJumpSchema;
        }
        return createRolePageConfig.copy(str, str6, str7, str8, str5);
    }
}
