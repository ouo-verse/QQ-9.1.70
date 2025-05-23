package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\f0\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001e\u0010\r\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRight;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightFlagEnum;", "flag", "Ljava/util/List;", "", "whiteUins", "blackUins", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightQuestion;", "questions", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightGroupItem;", "whiteGroups", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneRight extends j {
    public final List<String> blackUins;
    public final List<Integer> flag;
    public final List<QzoneRightQuestion> questions;
    public final List<QzoneRightGroupItem> whiteGroups;
    public final List<String> whiteUins;

    public QzoneRight() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new QzoneRight(null, null, null, null, null, 31, null));
    }

    public /* synthetic */ QzoneRight(List list, List list2, List list3, List list4, List list5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2, (i3 & 4) != 0 ? new ArrayList() : list3, (i3 & 8) != 0 ? new ArrayList() : list4, (i3 & 16) != 0 ? new ArrayList() : list5);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.flag, new b.f(new b.a(false), false))), TuplesKt.to(2, new h(2, this.whiteUins, new b.f(new b.e.g(false), false))), TuplesKt.to(3, new h(3, this.blackUins, new b.f(new b.e.g(false), false))), TuplesKt.to(4, new h(4, this.questions, new b.f(new b.d(new QzoneRightQuestion(null, null, 3, null)), false))), TuplesKt.to(5, new h(5, this.whiteGroups, new b.f(new b.d(new QzoneRightGroupItem(null, null, null, null, 15, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            List<Integer> list = this.flag;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.RightKt.QzoneRightFlagEnum }>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
            return;
        }
        if (fieldNumber == 2) {
            List<String> list2 = this.whiteUins;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
            return;
        }
        if (fieldNumber == 3) {
            List<String> list3 = this.blackUins;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) v3);
        } else if (fieldNumber == 4) {
            List<QzoneRightQuestion> list4 = this.questions;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion>");
            CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) v3);
        } else {
            if (fieldNumber != 5) {
                return;
            }
            List<QzoneRightGroupItem> list5 = this.whiteGroups;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightGroupItem>");
            CollectionsKt__MutableCollectionsKt.addAll(list5, (Sequence) v3);
        }
    }

    public QzoneRight(List<Integer> list, List<String> list2, List<String> list3, List<QzoneRightQuestion> list4, List<QzoneRightGroupItem> list5) {
        this.flag = list;
        this.whiteUins = list2;
        this.blackUins = list3;
        this.questions = list4;
        this.whiteGroups = list5;
    }
}
