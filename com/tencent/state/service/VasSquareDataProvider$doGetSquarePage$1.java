package com.tencent.state.service;

import android.util.SparseArray;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareDataProvider$doGetSquarePage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function5 $callback;
    final /* synthetic */ boolean $isNext;
    final /* synthetic */ VasSquareDataProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareDataProvider$doGetSquarePage$1(VasSquareDataProvider vasSquareDataProvider, boolean z16, Function5 function5) {
        super(0);
        this.this$0 = vasSquareDataProvider;
        this.$isNext = z16;
        this.$callback = function5;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        if (r0.getSquareItemList().isEmpty() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r4 = com.tencent.state.square.SquareBaseKt.getSquareLog();
        r8 = new java.lang.StringBuilder();
        r8.append("get page currentPage:");
        r9 = r12.this$0.currentPage;
        r8.append(r9);
        r8.append(", requirePage:");
        r8.append(r5);
        r8.append(", unreadList size:");
        r8.append(r3.size());
        r4.d("VasSquareDataProvider", r8.toString());
        r12.this$0.currentPage = r5;
        r6 = r12.$callback;
        r7 = r0.getSquareItemList();
        r8 = java.lang.Boolean.valueOf(r1);
        r9 = new com.tencent.state.data.Image("", r0.getMapSize());
        r11 = java.lang.Boolean.FALSE;
        r6.invoke(r7, r8, r9, r11, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a3, code lost:
    
        r0 = r12.this$0.getCurrentPageInfo();
        r8 = com.tencent.state.square.SquareBaseKt.getSquareLog();
        r9 = new java.lang.StringBuilder();
        r9.append("quire page isNext:");
        r9.append(r12.$isNext);
        r9.append(" currentPage:");
        r10 = r12.this$0.currentPage;
        r9.append(r10);
        r9.append(", requirePage:");
        r9.append(r5);
        r9.append(", unreadList size:");
        r9.append(r3.size());
        r9.append(", currentPageInfo:");
        r9.append(r0);
        r9.append(", mapid: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00eb, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ed, code lost:
    
        r2 = r0.getMapId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f3, code lost:
    
        r9.append(r2);
        r8.d("VasSquareDataProvider", r9.toString());
        r2 = com.tencent.state.service.VasStatusSquareService.INSTANCE;
        r6 = r12.this$0.sourceFrom;
        r7 = r12.this$0.getRecentUserList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x010b, code lost:
    
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x010d, code lost:
    
        r0 = r0.getMapId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0113, code lost:
    
        r2.getUserList(r6, r3, r7, r5, r0, new com.tencent.state.service.VasSquareDataProvider$doGetSquarePage$1$$special$$inlined$let$lambda$1(r5, r1, r3, r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0120, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0112, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f2, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0037, code lost:
    
        if (r5 > 1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        if (r5 < r2) goto L16;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2() {
        final List<? extends SquareBaseMessageRecord> list;
        int i3;
        int i16;
        SparseArray sparseArray;
        int i17;
        int i18;
        list = this.this$0.unreadMsgList;
        if (list == null) {
            return;
        }
        final boolean z16 = true;
        if (this.$isNext) {
            i18 = this.this$0.currentPage;
            i16 = i18 + 1;
        } else {
            i3 = this.this$0.currentPage;
            i16 = i3 - 1;
        }
        final int i19 = i16;
        sparseArray = this.this$0.squarePageInfoArray;
        SquarePageInfo squarePageInfo = (SquarePageInfo) sparseArray.get(i19);
        if (this.$isNext) {
            i17 = this.this$0.totalPage;
        }
    }
}
