package ks2;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lks2/a;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "b", "folderId", "c", "inputStr", "errorMsg", "", "e", "I", "()I", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String folderId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String inputStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String errorMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public a(String str, String str2, String str3, String str4, int i3) {
        this.title = str;
        this.folderId = str2;
        this.inputStr = str3;
        this.errorMsg = str4;
        this.type = i3;
    }

    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: b, reason: from getter */
    public final String getFolderId() {
        return this.folderId;
    }

    /* renamed from: c, reason: from getter */
    public final String getInputStr() {
        return this.inputStr;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }
}
