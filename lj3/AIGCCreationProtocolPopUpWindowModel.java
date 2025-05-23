package lj3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u45.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010\u00a8\u0006*"}, d2 = {"Llj3/a;", "", "Lu45/j;", "rsp", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setHeadPictureUrl", "(Ljava/lang/String;)V", "headPictureUrl", "getTitle", "setTitle", "title", "c", "getDescription", "setDescription", "description", "d", "getPrefix", "setPrefix", "prefix", "e", "setProtocolUrl", "protocolUrl", "f", "getProtocolName", "setProtocolName", "protocolName", "g", "getButtonText", "setButtonText", "buttonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lj3.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class AIGCCreationProtocolPopUpWindowModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String headPictureUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String description;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String prefix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String protocolUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String protocolName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String buttonText;

    public AIGCCreationProtocolPopUpWindowModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final AIGCCreationProtocolPopUpWindowModel a(j rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String str = rsp.f438247h;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.headPic");
        this.headPictureUrl = str;
        String str2 = rsp.f438241b;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.title");
        this.title = str2;
        String str3 = rsp.f438242c;
        Intrinsics.checkNotNullExpressionValue(str3, "rsp.description");
        this.description = str3;
        String str4 = rsp.f438243d;
        Intrinsics.checkNotNullExpressionValue(str4, "rsp.prefix");
        this.prefix = str4;
        String str5 = rsp.f438244e;
        Intrinsics.checkNotNullExpressionValue(str5, "rsp.protocolUrl");
        this.protocolUrl = str5;
        String str6 = rsp.f438245f;
        Intrinsics.checkNotNullExpressionValue(str6, "rsp.protocolName");
        this.protocolName = str6;
        String str7 = rsp.f438246g;
        Intrinsics.checkNotNullExpressionValue(str7, "rsp.buttonText");
        this.buttonText = str7;
        return this;
    }

    /* renamed from: b, reason: from getter */
    public final String getHeadPictureUrl() {
        return this.headPictureUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getProtocolUrl() {
        return this.protocolUrl;
    }

    public int hashCode() {
        return (((((((((((this.headPictureUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.prefix.hashCode()) * 31) + this.protocolUrl.hashCode()) * 31) + this.protocolName.hashCode()) * 31) + this.buttonText.hashCode();
    }

    public String toString() {
        return "AIGCCreationProtocolPopUpWindowModel(headPictureUrl=" + this.headPictureUrl + ", title=" + this.title + ", description=" + this.description + ", prefix=" + this.prefix + ", protocolUrl=" + this.protocolUrl + ", protocolName=" + this.protocolName + ", buttonText=" + this.buttonText + ")";
    }

    public AIGCCreationProtocolPopUpWindowModel(String headPictureUrl, String title, String description, String prefix, String protocolUrl, String protocolName, String buttonText) {
        Intrinsics.checkNotNullParameter(headPictureUrl, "headPictureUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(protocolUrl, "protocolUrl");
        Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.headPictureUrl = headPictureUrl;
        this.title = title;
        this.description = description;
        this.prefix = prefix;
        this.protocolUrl = protocolUrl;
        this.protocolName = protocolName;
        this.buttonText = buttonText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIGCCreationProtocolPopUpWindowModel)) {
            return false;
        }
        AIGCCreationProtocolPopUpWindowModel aIGCCreationProtocolPopUpWindowModel = (AIGCCreationProtocolPopUpWindowModel) other;
        return Intrinsics.areEqual(this.headPictureUrl, aIGCCreationProtocolPopUpWindowModel.headPictureUrl) && Intrinsics.areEqual(this.title, aIGCCreationProtocolPopUpWindowModel.title) && Intrinsics.areEqual(this.description, aIGCCreationProtocolPopUpWindowModel.description) && Intrinsics.areEqual(this.prefix, aIGCCreationProtocolPopUpWindowModel.prefix) && Intrinsics.areEqual(this.protocolUrl, aIGCCreationProtocolPopUpWindowModel.protocolUrl) && Intrinsics.areEqual(this.protocolName, aIGCCreationProtocolPopUpWindowModel.protocolName) && Intrinsics.areEqual(this.buttonText, aIGCCreationProtocolPopUpWindowModel.buttonText);
    }

    public /* synthetic */ AIGCCreationProtocolPopUpWindowModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7);
    }
}
