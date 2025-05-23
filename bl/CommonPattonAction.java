package bl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lbl/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "c", "(I)V", "actionType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "schemaUrl", "<init>", "(ILjava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonPattonAction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int actionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String schemaUrl;

    public CommonPattonAction() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: b, reason: from getter */
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final void c(int i3) {
        this.actionType = i3;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schemaUrl = str;
    }

    public int hashCode() {
        return (this.actionType * 31) + this.schemaUrl.hashCode();
    }

    public String toString() {
        return "CommonPattonAction(actionType=" + this.actionType + ", schemaUrl=" + this.schemaUrl + ")";
    }

    public CommonPattonAction(int i3, String schemaUrl) {
        Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
        this.actionType = i3;
        this.schemaUrl = schemaUrl;
    }

    public /* synthetic */ CommonPattonAction(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonPattonAction)) {
            return false;
        }
        CommonPattonAction commonPattonAction = (CommonPattonAction) other;
        return this.actionType == commonPattonAction.actionType && Intrinsics.areEqual(this.schemaUrl, commonPattonAction.schemaUrl);
    }
}
