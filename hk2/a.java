package hk2;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.picker.MediaData;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.i;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.u;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\f"}, d2 = {"Lhk2/a;", "", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/picker/MediaData;", "mediaDatas", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "a", "mediaData", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "b", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f405214a = new a();

    a() {
    }

    @NotNull
    public final MediaModel a(@NotNull List<MediaData> mediaDatas) {
        Intrinsics.checkNotNullParameter(mediaDatas, "mediaDatas");
        List<MediaClip> b16 = b(mediaDatas);
        return new MediaModel(UUID.randomUUID().toString(), null, null, null, null, null, b16, null, null, i.d(b16, 0.0f, 2, null), null, null, null, null, null, null, null, null, null, 523710, null);
    }

    @NotNull
    public final List<MediaClip> b(@NotNull List<MediaData> mediaData) {
        boolean z16;
        MediaType mediaType;
        Intrinsics.checkNotNullParameter(mediaData, "mediaData");
        ArrayList arrayList = new ArrayList();
        for (MediaData mediaData2 : mediaData) {
            long duration = mediaData2.getDuration();
            String compressPath = mediaData2.getCompressPath();
            if (compressPath == null) {
                compressPath = " ";
            }
            if (compressPath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                compressPath = mediaData2.getMediaPath();
            }
            String str = compressPath;
            String uuid = UUID.randomUUID().toString();
            if (mediaData2.getType() == 1) {
                mediaType = MediaType.IMAGE;
            } else {
                mediaType = MediaType.VIDEO;
            }
            SizeF sizeF = new SizeF(mediaData2.getWidth(), mediaData2.getHeight(), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            arrayList.add(new MediaClip(new ResourceModel(uuid, str, duration, 0L, duration, 0L, duration, mediaType, sizeF, 1.0f, null, null, null, null, null, null, 64512, null), u.a(), null, null, null, null, null, 124, null));
        }
        return arrayList;
    }
}
