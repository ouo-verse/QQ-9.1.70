package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/c;", "", "", "type", "filePath", "", "a", "path", "", "c", "Ljava/util/ArrayList;", "Lcom/tencent/tavcut/model/ClipSource;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "clipResourceList", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ClipSource> clipResourceList = new ArrayList<>();

    public final void a(String type, String filePath) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (Intrinsics.areEqual(type, "image")) {
            this.clipResourceList.add(od4.b.f422509e.m().a(filePath, new TimeRange(0L, 3000000L, null, 4, null)));
        } else if (Intrinsics.areEqual(type, "video")) {
            this.clipResourceList.add(od4.b.f422509e.m().b(filePath, new TimeRange(0L, c(filePath) * 1000, null, 4, null)));
        } else {
            ee4.b.b("WS_TavClipResource", "[addResource] no matched type");
        }
    }

    public final ArrayList<ClipSource> b() {
        return this.clipResourceList;
    }

    public final long c(String path) {
        if (!TextUtils.isEmpty(path)) {
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever2.setDataSource(path);
                        String extractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                        r1 = extractMetadata != null ? Long.parseLong(extractMetadata) : 0L;
                        mediaMetadataRetriever2.release();
                    } catch (Exception e16) {
                        e = e16;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        ee4.b.b("WS_TavClipResource", e.toString());
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return r1;
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        return r1;
    }
}
