package pa2;

import android.content.Context;
import android.view.View;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryImageData;
import com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryImageInfo;
import com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryPreview;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJe\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b\u00a8\u0006\u001d"}, d2 = {"Lpa2/a;", "", "", "feedId", "", "tinyId", "name", PhotoCategorySummaryInfo.AVATAR_URL, "avatarDressBorderUrl", "Lop4/i;", "feed", "", "pageFrom", "Lorg/json/JSONObject;", "extJSON", "", "a", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lop4/i;ILorg/json/JSONObject;)V", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "id", "picUrl", "width", "height", "c", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f425847a = new a();

    a() {
    }

    public static /* synthetic */ void b(a aVar, String str, Long l3, String str2, String str3, String str4, i iVar, int i3, JSONObject jSONObject, int i16, Object obj) {
        String str5;
        String str6;
        String str7;
        i iVar2;
        JSONObject jSONObject2;
        if ((i16 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i16 & 8) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i16 & 16) != 0) {
            str7 = null;
        } else {
            str7 = str4;
        }
        if ((i16 & 32) != 0) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        if ((i16 & 128) != 0) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject;
        }
        aVar.a(str, l3, str5, str6, str7, iVar2, i3, jSONObject2);
    }

    public final void c(@NotNull Context context, @NotNull View view, @NotNull String id5, @Nullable String picUrl, int width, int height) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        if (StringUtil.isEmpty(picUrl)) {
            s.c("\u56fe\u7247\u94fe\u63a5\u4e3a\u7a7a");
            return;
        }
        Intrinsics.checkNotNull(picUrl);
        NBGalleryImageData nBGalleryImageData = new NBGalleryImageData(id5, new NBGalleryImageInfo(picUrl, width, height), new NBGalleryImageInfo(picUrl, width, height));
        NBGalleryPreview nBGalleryPreview = NBGalleryPreview.f253611a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(nBGalleryImageData);
        NBGalleryPreview.c(nBGalleryPreview, mutableListOf, view, context, null, 8, null);
    }

    public final void a(@Nullable String feedId, @Nullable Long tinyId, @Nullable String name, @Nullable String avatarUrl, @Nullable String avatarDressBorderUrl, @Nullable i feed, int pageFrom, @Nullable JSONObject extJSON) {
    }
}
