package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "text", "c", "btnCloseWindowText", "a", "btnRandomCreateText", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class CreateRoleRetentionConfig {

    @SerializedName("btnCloseWindowText")
    private final String btnCloseWindowText;

    @SerializedName("btnRandomCreateText")
    private final String btnRandomCreateText;

    @SerializedName("text")
    private final String text;

    @SerializedName("title")
    private final String title;

    public CreateRoleRetentionConfig() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getBtnCloseWindowText() {
        return this.btnCloseWindowText;
    }

    /* renamed from: b, reason: from getter */
    public final String getBtnRandomCreateText() {
        return this.btnRandomCreateText;
    }

    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.text.hashCode()) * 31) + this.btnCloseWindowText.hashCode()) * 31) + this.btnRandomCreateText.hashCode();
    }

    public String toString() {
        return "CreateRoleRetentionConfig(title=" + this.title + ", text=" + this.text + ", btnCloseWindowText=" + this.btnCloseWindowText + ", btnRandomCreateText=" + this.btnRandomCreateText + ')';
    }

    public CreateRoleRetentionConfig(String title, String text, String btnCloseWindowText, String btnRandomCreateText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(btnCloseWindowText, "btnCloseWindowText");
        Intrinsics.checkNotNullParameter(btnRandomCreateText, "btnRandomCreateText");
        this.title = title;
        this.text = text;
        this.btnCloseWindowText = btnCloseWindowText;
        this.btnRandomCreateText = btnRandomCreateText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateRoleRetentionConfig)) {
            return false;
        }
        CreateRoleRetentionConfig createRoleRetentionConfig = (CreateRoleRetentionConfig) other;
        return Intrinsics.areEqual(this.title, createRoleRetentionConfig.title) && Intrinsics.areEqual(this.text, createRoleRetentionConfig.text) && Intrinsics.areEqual(this.btnCloseWindowText, createRoleRetentionConfig.btnCloseWindowText) && Intrinsics.areEqual(this.btnRandomCreateText, createRoleRetentionConfig.btnRandomCreateText);
    }

    public /* synthetic */ CreateRoleRetentionConfig(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "\u653e\u5f03\u83b7\u53d6\u514d\u8d39\u670d\u88c5\uff1f" : str, (i3 & 2) != 0 ? "\u4f60\u4e5f\u53ef\u4ee5\u521b\u5efa\u968f\u673a\u5f62\u8c61\uff0c\u5f00\u542f\u8d85\u7ea7QQ\u79c0\u4e4b\u65c5\u3002" : str2, (i3 & 4) != 0 ? "\u6b8b\u5fcd\u79bb\u5f00" : str3, (i3 & 8) != 0 ? "\u968f\u673a\u521b\u5efa" : str4);
    }
}
