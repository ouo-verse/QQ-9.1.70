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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellPermission;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "desc", "Ljava/lang/String;", "icon", "actionUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRight;", "right", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRight;", "dialogContext", "dialogConfirmContext", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRight;Ljava/lang/String;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StCellPermission extends j {
    public String actionUrl;
    public String desc;
    public String dialogConfirmContext;
    public String dialogContext;
    public String icon;
    public QzoneRight right;

    public StCellPermission() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StCellPermission(null, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.desc = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.icon = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.actionUrl = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRight");
                this.right = (QzoneRight) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.dialogContext = (String) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.dialogConfirmContext = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StCellPermission(String str, String str2, String str3, QzoneRight qzoneRight, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : qzoneRight, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5);
    }

    public StCellPermission(String str, String str2, String str3, QzoneRight qzoneRight, String str4, String str5) {
        this.desc = str;
        this.icon = str2;
        this.actionUrl = str3;
        this.right = qzoneRight;
        this.dialogContext = str4;
        this.dialogConfirmContext = str5;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.desc, new b.e.g(true))), TuplesKt.to(2, new h(2, this.icon, new b.e.g(true))), TuplesKt.to(3, new h(3, this.actionUrl, new b.e.g(true))), TuplesKt.to(4, new h(4, this.right, new b.d(new QzoneRight(null, null, null, null, null, 31, null)))), TuplesKt.to(5, new h(5, this.dialogContext, new b.e.g(true))), TuplesKt.to(6, new h(6, this.dialogConfirmContext, new b.e.g(true))));
        return mapOf;
    }
}
