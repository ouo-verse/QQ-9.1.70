package o9;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0012\u0010\u000fR2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lo9/f;", "", "", "a", "I", "d", "()I", h.F, "(I)V", "scene", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "groupId", "c", "e", "albumId", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "g", "(Ljava/util/ArrayList;)V", "mediaList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int scene = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CommonStMedia> mediaList = new ArrayList<>();

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final ArrayList<CommonStMedia> c() {
        return this.mediaList;
    }

    /* renamed from: d, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    public final void e(String str) {
        this.albumId = str;
    }

    public final void f(String str) {
        this.groupId = str;
    }

    public final void g(ArrayList<CommonStMedia> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mediaList = arrayList;
    }

    public final void h(int i3) {
        this.scene = i3;
    }
}
