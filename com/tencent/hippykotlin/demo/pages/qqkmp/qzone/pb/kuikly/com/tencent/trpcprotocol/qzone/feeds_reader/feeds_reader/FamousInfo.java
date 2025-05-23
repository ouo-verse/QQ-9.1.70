package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FamousInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "fansNum", "J", "visitCount", "", ViewStickEventHelper.IS_SHOW, "Z", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(JJZ)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class FamousInfo extends j {
    public static final int $stable = 8;
    public long fansNum;
    public boolean isShow;
    public long visitCount;

    public FamousInfo() {
        this(0L, 0L, false, 7, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new FamousInfo(0L, 0L, false, 7, null));
    }

    public /* synthetic */ FamousInfo(long j3, long j16, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? false : z16);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.fansNum), new b.e.i(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.visitCount), new b.e.i(false))), TuplesKt.to(3, new h(3, Boolean.valueOf(this.isShow), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
            this.fansNum = ((Long) v3).longValue();
        } else if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
            this.visitCount = ((Long) v3).longValue();
        } else {
            if (fieldNumber != 3) {
                return;
            }
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.isShow = ((Boolean) v3).booleanValue();
        }
    }

    public FamousInfo(long j3, long j16, boolean z16) {
        this.fansNum = j3;
        this.visitCount = j16;
        this.isShow = z16;
    }
}
