package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/SendAlbumInvitationReq;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "receivers", "Ljava/util/List;", "", "groupList", "albumId", "Ljava/lang/String;", "albumOwner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "", "notSendArk", "Ljava/lang/Boolean;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class SendAlbumInvitationReq extends j {
    public String albumId;
    public StUser albumOwner;
    public final List<String> groupList;
    public Boolean notSendArk;
    public final List<StUser> receivers;

    public SendAlbumInvitationReq() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new SendAlbumInvitationReq(null, null, null, null, null, 31, null));
    }

    public /* synthetic */ SendAlbumInvitationReq(List list, List list2, String str, StUser stUser, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : stUser, (i3 & 16) == 0 ? bool : null);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.receivers, new b.f(new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)), false))), TuplesKt.to(2, new h(2, this.groupList, new b.f(new b.e.g(false), false))), TuplesKt.to(3, new h(3, this.albumId, new b.e.g(true))), TuplesKt.to(4, new h(4, this.albumOwner, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(5, new h(5, this.notSendArk, new b.e.a(true))));
        return mapOf;
    }

    public SendAlbumInvitationReq(List<StUser> list, List<String> list2, String str, StUser stUser, Boolean bool) {
        this.receivers = list;
        this.groupList = list2;
        this.albumId = str;
        this.albumOwner = stUser;
        this.notSendArk = bool;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            List<StUser> list = this.receivers;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
            return;
        }
        if (fieldNumber == 2) {
            List<String> list2 = this.groupList;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
        } else if (fieldNumber == 3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
            this.albumId = (String) v3;
        } else if (fieldNumber == 4) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
            this.albumOwner = (StUser) v3;
        } else {
            if (fieldNumber != 5) {
                return;
            }
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.notSendArk = (Boolean) v3;
        }
    }
}
