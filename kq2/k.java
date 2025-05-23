package kq2;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasFragment;
import com.tencent.mobileqq.vas.ar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lkq2/k;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "a", "b", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends jq2.c {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f412863d = ar.INSTANCE.b("kenaiyu", "2024-12-23", "vas_feature_120954470").isEnable(true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lkq2/k$b;", "Ljq2/c;", "", "e", "", tl.h.F, "title", "Landroid/content/Context;", "context", "id", "", "f", "c", "Ljava/lang/String;", "detailTitle", "<init>", "(Ljava/lang/String;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends jq2.c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String detailTitle;

        public b(String detailTitle) {
            Intrinsics.checkNotNullParameter(detailTitle, "detailTitle");
            this.detailTitle = detailTitle;
        }

        @Override // jq2.c
        public /* bridge */ /* synthetic */ ArrayList c() {
            return (ArrayList) h();
        }

        @Override // jq2.c
        /* renamed from: e, reason: from getter */
        public String getDetailTitle() {
            return this.detailTitle;
        }

        @Override // jq2.c
        public void f(String title, Context context, String id5) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public Void h() {
            return null;
        }
    }

    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayListOf;
        ArrayList<jq2.c> arrayListOf2;
        if (f412863d) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new b("\u4e3b\u9898\u98ce\u683c"), new b("\u5934\u50cf\u6302\u4ef6"), new b("\u5b57\u4f53\u6837\u5f0f"), new b("\u804a\u5929\u6c14\u6ce1"), new b("\u804a\u5929\u80cc\u666f"), new b("\u8fdb\u7fa4\u7279\u6548"), new b("\u540d\u7247"), new b("\u70b9\u8d5e"), new b("\u6d6e\u5c4f"), new b("\u52cb\u7ae0\u5899"), new b("\u4f1a\u5458\u94ed\u724c"), new b("\u4f1a\u5458\u5f69\u8272\u6635\u79f0"), new b("\u4f1a\u5458\u6807\u8bc6"), new b("\u4f1a\u5458\u79f0\u53f7&\u738b\u8005\u6bb5\u4f4d"), new b("\u9753\u53f7\u7fa4\u7fa4\u4e3b\u8eab\u4efd"), new b("APP\u4e2a\u6027\u56fe\u6807"), new b("\u4f1a\u5458\u4e13\u5c5e\u5c0a\u8d35\u5f00\u5c4f"));
            return arrayListOf2;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new b("\u4e3b\u9898\u98ce\u683c"), new b("\u5934\u50cf\u6302\u4ef6"), new b("\u5b57\u4f53\u6837\u5f0f"), new b("\u804a\u5929\u6c14\u6ce1"), new b("\u804a\u5929\u80cc\u666f"), new b("\u8fdb\u7fa4\u7279\u6548"), new b("\u540d\u7247"), new b("\u70b9\u8d5e"), new b("\u6d6e\u5c4f"), new b("\u52cb\u7ae0\u5899"), new b("\u4f1a\u5458\u94ed\u724c"), new b("\u7fa4\u804a\u5c55\u793a\u8eab\u4efd\u94ed\u724c"), new b("\u5c55\u793a\u6211\u7684\u94ed\u724c"), new b("\u4f1a\u5458\u5f69\u8272\u6635\u79f0"), new b("\u804a\u5929\u5217\u8868\u5c55\u793a\u5f69\u8272\u6635\u79f0"), new b("\u4f1a\u5458\u6807\u8bc6"), new b("\u4f1a\u5458\u79f0\u53f7&\u738b\u8005\u6bb5\u4f4d"), new b("\u9753\u53f7\u7fa4\u7fa4\u4e3b\u8eab\u4efd"), new b("APP\u4e2a\u6027\u56fe\u6807"), new b("\u4f1a\u5458\u4e13\u5c5e\u5c0a\u8d35\u5f00\u5c4f"));
        return arrayListOf;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        return "\u4e2a\u6027\u88c5\u626e\u4e0e\u7279\u6743\u5916\u663e";
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        ((IVasFragment) QRoute.api(IVasFragment.class)).startGHXSetting(context, title);
    }
}
