package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u001e\u0010\u0017\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/QueryAlbumReq;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "albumId", "Ljava/lang/String;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumReqType;", "reqType", "Ljava/lang/Integer;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "accessKey", "shareCiphertext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/ReqSharedAlbumType;", "reqSharedAlbum", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QueryAlbumReq extends j {
    public String accessKey;
    public String albumId;
    public StUser owner;
    public Integer reqSharedAlbum;
    public Integer reqType;
    public String shareCiphertext;

    public QueryAlbumReq() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new QueryAlbumReq(null, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumId = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.Media_commreaderKt.AlbumReqType }");
                this.reqType = (Integer) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.owner = (StUser) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.accessKey = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.shareCiphertext = (String) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.Media_commreaderKt.ReqSharedAlbumType }");
                this.reqSharedAlbum = (Integer) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ QueryAlbumReq(String str, Integer num, StUser stUser, String str2, String str3, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : stUser, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : num2);
    }

    public QueryAlbumReq(String str, Integer num, StUser stUser, String str2, String str3, Integer num2) {
        this.albumId = str;
        this.reqType = num;
        this.owner = stUser;
        this.accessKey = str2;
        this.shareCiphertext = str3;
        this.reqSharedAlbum = num2;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.albumId, new b.e.g(true))), TuplesKt.to(2, new h(2, this.reqType, new b.a(false))), TuplesKt.to(3, new h(3, this.owner, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(4, new h(4, this.accessKey, new b.e.g(true))), TuplesKt.to(5, new h(5, this.shareCiphertext, new b.e.g(true))), TuplesKt.to(6, new h(6, this.reqSharedAlbum, new b.a(false))));
        return mapOf;
    }
}
