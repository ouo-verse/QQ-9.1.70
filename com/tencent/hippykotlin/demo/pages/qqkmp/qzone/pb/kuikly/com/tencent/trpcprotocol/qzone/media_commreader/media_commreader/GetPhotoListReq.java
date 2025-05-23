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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0013\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0010R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetPhotoListReq;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "", "albumId", "Ljava/lang/String;", "attachInfo", "curLloc", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/MediaScene;", "scene", "Ljava/lang/Integer;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaSortType;", "sortType", "", "needPos", "Ljava/lang/Boolean;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumQuestion;", "questionAnswer", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumQuestion;", "count", "shareCiphertext", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumQuestion;Ljava/lang/Integer;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetPhotoListReq extends j {
    public String albumId;
    public String attachInfo;
    public Integer count;
    public String curLloc;
    public Boolean needPos;
    public StUser owner;
    public AlbumQuestion questionAnswer;
    public Integer scene;
    public String shareCiphertext;
    public Integer sortType;

    public GetPhotoListReq() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetPhotoListReq(null, null, null, null, null, null, null, null, null, null, 1023, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.owner = (StUser) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumId = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.attachInfo = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.curLloc = (String) v3;
                return;
            case 5:
            case 8:
            case 10:
            default:
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.Media_commreaderKt.MediaScene }");
                this.scene = (Integer) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.MediaSortType }");
                this.sortType = (Integer) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.needPos = (Boolean) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.AlbumQuestion");
                this.questionAnswer = (AlbumQuestion) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.count = (Integer) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.shareCiphertext = (String) v3;
                return;
        }
    }

    public /* synthetic */ GetPhotoListReq(StUser stUser, String str, String str2, String str3, Integer num, Integer num2, Boolean bool, AlbumQuestion albumQuestion, Integer num3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : stUser, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? null : bool, (i3 & 128) != 0 ? null : albumQuestion, (i3 & 256) != 0 ? null : num3, (i3 & 512) == 0 ? str4 : null);
    }

    public GetPhotoListReq(StUser stUser, String str, String str2, String str3, Integer num, Integer num2, Boolean bool, AlbumQuestion albumQuestion, Integer num3, String str4) {
        this.owner = stUser;
        this.albumId = str;
        this.attachInfo = str2;
        this.curLloc = str3;
        this.scene = num;
        this.sortType = num2;
        this.needPos = bool;
        this.questionAnswer = albumQuestion;
        this.count = num3;
        this.shareCiphertext = str4;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.owner, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(2, new h(2, this.albumId, new b.e.g(true))), TuplesKt.to(3, new h(3, this.attachInfo, new b.e.g(true))), TuplesKt.to(4, new h(4, this.curLloc, new b.e.g(true))), TuplesKt.to(6, new h(6, this.scene, new b.a(false))), TuplesKt.to(7, new h(7, this.sortType, new b.a(false))), TuplesKt.to(9, new h(9, this.needPos, new b.e.a(true))), TuplesKt.to(11, new h(11, this.questionAnswer, new b.d(new AlbumQuestion(null, null, null, 7, null)))), TuplesKt.to(12, new h(12, this.count, new b.e.h(true))), TuplesKt.to(13, new h(13, this.shareCiphertext, new b.e.g(true))));
        return mapOf;
    }
}
