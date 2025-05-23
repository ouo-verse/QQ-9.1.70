package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001e\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StTimeLineEvent;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TimeLineNodeType;", "type", "Ljava/lang/Integer;", "", "title", "Ljava/lang/String;", "content", "attachInfo", "", "beginTime", "Ljava/lang/Long;", "endTime", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TimeLineBindingType;", "bindingType", "", "disable", "Ljava/lang/Boolean;", "itemCount", "isSpecialDayNode", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StTimeLineEvent extends j {
    public static final int $stable = 8;
    public String attachInfo;
    public Long beginTime;
    public Integer bindingType;
    public String content;
    public Boolean disable;
    public Long endTime;
    public Boolean isSpecialDayNode;
    public Integer itemCount;
    public String title;
    public Integer type;

    public StTimeLineEvent() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StTimeLineEvent(null, null, null, null, null, null, null, null, null, null, 1023, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.TimeLineNodeType }");
                this.type = (Integer) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.title = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.content = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.attachInfo = (String) v3;
                return;
            case 5:
            case 8:
            case 11:
            default:
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.beginTime = (Long) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.endTime = (Long) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.TimeLineBindingType }");
                this.bindingType = (Integer) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.disable = (Boolean) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.itemCount = (Integer) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isSpecialDayNode = (Boolean) v3;
                return;
        }
    }

    public /* synthetic */ StTimeLineEvent(Integer num, String str, String str2, String str3, Long l3, Long l16, Integer num2, Boolean bool, Integer num3, Boolean bool2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : l16, (i3 & 64) != 0 ? null : num2, (i3 & 128) != 0 ? null : bool, (i3 & 256) != 0 ? null : num3, (i3 & 512) == 0 ? bool2 : null);
    }

    public StTimeLineEvent(Integer num, String str, String str2, String str3, Long l3, Long l16, Integer num2, Boolean bool, Integer num3, Boolean bool2) {
        this.type = num;
        this.title = str;
        this.content = str2;
        this.attachInfo = str3;
        this.beginTime = l3;
        this.endTime = l16;
        this.bindingType = num2;
        this.disable = bool;
        this.itemCount = num3;
        this.isSpecialDayNode = bool2;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.type, new b.a(false))), TuplesKt.to(2, new h(2, this.title, new b.e.g(true))), TuplesKt.to(3, new h(3, this.content, new b.e.g(true))), TuplesKt.to(4, new h(4, this.attachInfo, new b.e.g(true))), TuplesKt.to(6, new h(6, this.beginTime, new b.e.f(true))), TuplesKt.to(7, new h(7, this.endTime, new b.e.f(true))), TuplesKt.to(9, new h(9, this.bindingType, new b.a(false))), TuplesKt.to(10, new h(10, this.disable, new b.e.a(true))), TuplesKt.to(12, new h(12, this.itemCount, new b.e.h(true))), TuplesKt.to(13, new h(13, this.isSpecialDayNode, new b.e.a(true))));
        return mapOf;
    }
}
