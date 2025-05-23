package k9;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lk9/b;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "stMedia", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f411905a = new b();

    b() {
    }

    public final String a(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (stMedia.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            return stMedia.getImage().getLloc();
        }
        return stMedia.getVideo().getCover().getLloc();
    }
}
