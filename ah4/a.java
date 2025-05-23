package ah4;

import com.tencent.timi.game.utils.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lah4/a;", "", "", "b", "", "size", "a", "", "J", "getEmoType", "()J", "emoType", "mInitTimeStamp", "<init>", "(J)V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long emoType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mInitTimeStamp;

    public a(long j3) {
        this.emoType = j3;
    }

    public final void a(int size) {
        Map<String, String> mapOf;
        if (this.mInitTimeStamp == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mInitTimeStamp;
        this.mInitTimeStamp = 0L;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("k_emo_type", String.valueOf(this.emoType)), TuplesKt.to("k_cost_time", String.valueOf(currentTimeMillis)), TuplesKt.to("k_emo_data_size", String.valueOf(size)));
        l.h("EmoReportHelper_", 1, "dataRefreshed emoType:" + this.emoType + ", map:" + mapOf);
        ((b) mm4.b.b(b.class)).e("e_emo_data_init_finish", mapOf);
    }

    public final void b() {
        this.mInitTimeStamp = System.currentTimeMillis();
    }
}
