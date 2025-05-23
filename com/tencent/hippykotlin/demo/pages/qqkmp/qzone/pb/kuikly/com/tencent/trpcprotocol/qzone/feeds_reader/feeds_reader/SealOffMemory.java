package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "memoryTime", "I", "", "summary", "Ljava/lang/String;", "actionType", "actionUrl", "buttonText", "type", "noRightSummary", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class SealOffMemory extends j {
    public static final int $stable = 8;
    public int actionType;
    public String actionUrl;
    public String buttonText;
    public int memoryTime;
    public String noRightSummary;
    public String summary;
    public int type;

    public SealOffMemory() {
        this(0, null, 0, null, null, 0, null, 127, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new SealOffMemory(0, null, 0, null, null, 0, null, 127, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.memoryTime = ((Integer) v3).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.summary = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.actionType = ((Integer) v3).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.actionUrl = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.buttonText = (String) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.type = ((Integer) v3).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.noRightSummary = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ SealOffMemory(int i3, String str, int i16, String str2, String str3, int i17, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? "" : str2, (i18 & 16) != 0 ? "" : str3, (i18 & 32) == 0 ? i17 : 0, (i18 & 64) != 0 ? "" : str4);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.memoryTime), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.summary, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.actionType), new b.e.C0168e(false))), TuplesKt.to(4, new h(4, this.actionUrl, new b.e.g(false))), TuplesKt.to(5, new h(5, this.buttonText, new b.e.g(false))), TuplesKt.to(6, new h(6, Integer.valueOf(this.type), new b.e.C0168e(false))), TuplesKt.to(7, new h(7, this.noRightSummary, new b.e.g(false))));
        return mapOf;
    }

    public SealOffMemory(int i3, String str, int i16, String str2, String str3, int i17, String str4) {
        this.memoryTime = i3;
        this.summary = str;
        this.actionType = i16;
        this.actionUrl = str2;
        this.buttonText = str3;
        this.type = i17;
        this.noRightSummary = str4;
    }
}
