package ez;

import UserGrowth.stAcquisitionInfo;
import UserGrowth.stSimpleMetaFeed;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi.util.x;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lez/d;", "", "LUserGrowth/stSimpleMetaFeed;", "feed", "Lez/a;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f397443a = new d();

    d() {
    }

    @JvmStatic
    public static final a a(stSimpleMetaFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        stAcquisitionInfo stacquisitioninfo = feed.acquisitionInfo;
        if (stacquisitioninfo == null || stacquisitioninfo.businessIcon.type != 10000) {
            return null;
        }
        x.b("WSRichWidgetDataUtil", "convertRichWidgetData:" + new Gson().toJson(stacquisitioninfo));
        return new b(stacquisitioninfo.businessIcon, stacquisitioninfo.feedIconOpConf, 5);
    }
}
