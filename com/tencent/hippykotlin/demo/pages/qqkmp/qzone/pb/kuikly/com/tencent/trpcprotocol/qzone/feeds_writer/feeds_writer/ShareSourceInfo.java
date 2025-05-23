package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ShareSourceInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "appid", "I", "subid", "", "title", "Ljava/lang/String;", "summary", "reason", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "images", "Ljava/util/List;", "url", "srcName", "urlInfoFrom", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ShareSourceInfo extends j {
    public int appid;
    public final List<StMedia> images;
    public String reason;
    public String srcName;
    public int subid;
    public String summary;
    public String title;
    public String url;
    public String urlInfoFrom;

    public ShareSourceInfo() {
        this(0, 0, null, null, null, null, null, null, null, 511, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new ShareSourceInfo(0, 0, null, null, null, null, null, null, null, 511, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.appid = ((Integer) v3).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.subid = ((Integer) v3).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.title = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.summary = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.reason = (String) v3;
                return;
            case 6:
                List<StMedia> list = this.images;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.url = (String) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.srcName = (String) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.urlInfoFrom = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ ShareSourceInfo(int i3, int i16, String str, String str2, String str3, List list, String str4, String str5, String str6, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) == 0 ? i16 : 0, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? "" : str3, (i17 & 32) != 0 ? new ArrayList() : list, (i17 & 64) != 0 ? "" : str4, (i17 & 128) != 0 ? "" : str5, (i17 & 256) == 0 ? str6 : "");
    }

    public ShareSourceInfo(int i3, int i16, String str, String str2, String str3, List<StMedia> list, String str4, String str5, String str6) {
        this.appid = i3;
        this.subid = i16;
        this.title = str;
        this.summary = str2;
        this.reason = str3;
        this.images = list;
        this.url = str4;
        this.srcName = str5;
        this.urlInfoFrom = str6;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.appid), new b.e.h(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.subid), new b.e.h(false))), TuplesKt.to(3, new h(3, this.title, new b.e.g(false))), TuplesKt.to(4, new h(4, this.summary, new b.e.g(false))), TuplesKt.to(5, new h(5, this.reason, new b.e.g(false))), TuplesKt.to(6, new h(6, this.images, new b.f(new b.d(new StMedia(null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(7, new h(7, this.url, new b.e.g(false))), TuplesKt.to(8, new h(8, this.srcName, new b.e.g(false))), TuplesKt.to(9, new h(9, this.urlInfoFrom, new b.e.g(false))));
        return mapOf;
    }
}
