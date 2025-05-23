package jq2;

import android.content.Context;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ljq2/a;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String title;

    public a(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }

    @Override // jq2.c
    public ArrayList<c> c() {
        return null;
    }

    @Override // jq2.c
    /* renamed from: e, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
