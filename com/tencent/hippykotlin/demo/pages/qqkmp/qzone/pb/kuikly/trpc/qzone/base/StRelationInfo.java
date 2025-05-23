package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRelationInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "id", "Ljava/lang/String;", "", IProfileProtocolConst.PARAM_IS_FRIEND, "Ljava/lang/Boolean;", "isUncare", "hasRight", "", "partFlag", "Ljava/lang/Long;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StRelationInfo extends j {
    public Boolean hasRight;
    public String id;
    public Boolean isFriend;
    public Boolean isUncare;
    public Long partFlag;

    public StRelationInfo() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StRelationInfo(null, null, null, null, null, 31, null));
    }

    public /* synthetic */ StRelationInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : bool2, (i3 & 8) != 0 ? null : bool3, (i3 & 16) != 0 ? null : l3);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.id, new b.e.g(true))), TuplesKt.to(2, new h(2, this.isFriend, new b.e.a(true))), TuplesKt.to(3, new h(3, this.isUncare, new b.e.a(true))), TuplesKt.to(4, new h(4, this.hasRight, new b.e.a(true))), TuplesKt.to(5, new h(5, this.partFlag, new b.e.i(true))));
        return mapOf;
    }

    public StRelationInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Long l3) {
        this.id = str;
        this.isFriend = bool;
        this.isUncare = bool2;
        this.hasRight = bool3;
        this.partFlag = l3;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
            this.id = (String) v3;
            return;
        }
        if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.isFriend = (Boolean) v3;
            return;
        }
        if (fieldNumber == 3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.isUncare = (Boolean) v3;
        } else if (fieldNumber == 4) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.hasRight = (Boolean) v3;
        } else {
            if (fieldNumber != 5) {
                return;
            }
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
            this.partFlag = (Long) v3;
        }
    }
}
