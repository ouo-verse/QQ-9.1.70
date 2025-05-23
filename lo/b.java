package lo;

import jo.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Llo/b;", "Ljo/g;", "", "k", "Ljava/lang/String;", "getStreamName", "()Ljava/lang/String;", "setStreamName", "(Ljava/lang/String;)V", "streamName", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends g {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String streamName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String streamName) {
        super(streamName);
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        this.streamName = streamName;
    }
}
