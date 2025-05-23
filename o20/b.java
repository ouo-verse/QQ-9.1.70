package o20;

import com.tencent.mobileqq.data.Groups;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private Groups f421783c;

    /* renamed from: d, reason: collision with root package name */
    private String f421784d;

    public Groups e() {
        return this.f421783c;
    }

    public String f() {
        return this.f421784d;
    }

    public void g(Groups groups) {
        this.f421783c = groups;
    }

    public void h(String str) {
        this.f421784d = str;
    }

    @Override // o20.a
    public String toString() {
        return "QFSCommentAtDialogSearchItemInfo{mGroups=" + this.f421783c + "} " + super.toString();
    }
}
