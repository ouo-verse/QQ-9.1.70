package lo;

import jo.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Llo/d;", "Ljo/g;", "", "y", "", "streamName", "<init>", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String streamName) {
        super(streamName);
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        y();
        h(new jo.b());
    }

    public final void y() {
        g.d(w(), "START_REQUEST", null, 2, null).b("ON_FEED_DATA_CHANGE", "onFeedChange\u4e8b\u4ef6").b("REFRESH_FINISH", "\u8bf7\u6c42\u5b8c\u6210").b("SUBSIDIARY_REFRESH_FINISH", "\u9644\u5c5e\u4fe1\u606f\u89e3\u6790\u5b8c\u6210").j("ON_FEED_DATA_CHANGE", "REFRESH_FINISH", "SUBSIDIARY_REFRESH_FINISH");
    }
}
