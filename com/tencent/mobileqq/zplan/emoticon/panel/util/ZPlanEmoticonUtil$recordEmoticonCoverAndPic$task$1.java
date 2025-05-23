package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1", "Ljava/lang/Runnable;", "", "record2DEnd", "recordMemeEnd", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/ZPlanEmoticonUtil$a;", "reportDataMeme", "reportData2D", "", "total_3D", "total_3D_plus_2D", "", "b", TencentLocation.RUN_MODE, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f333209d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ List<ZPlanActionInfo> f333210e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f333211f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Priority f333212h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Priority f333213i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ boolean f333214m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1(int i3, List<ZPlanActionInfo> list, int i16, Priority priority, Priority priority2, boolean z16) {
        this.f333209d = i3;
        this.f333210e = list;
        this.f333211f = i16;
        this.f333212h = priority;
        this.f333213i = priority2;
        this.f333214m = z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean B;
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 == null) {
            return;
        }
        String selfUin = l3.getCurrentAccountUin();
        int i3 = this.f333209d;
        B = ZPlanEmoticonUtil.f333176e.B();
        QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "recordEmoticonCoverAndPic start, total:" + i3 + ", enableCloudRecord:" + B);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        List<ZPlanActionInfo> list = this.f333210e;
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ZPlanActionInfo) next).getOriginType() == 100) {
                arrayList.add(next);
            }
        }
        List<ZPlanActionInfo> list2 = this.f333210e;
        final ArrayList arrayList2 = new ArrayList();
        for (Object obj : list2) {
            if (((ZPlanActionInfo) obj).getOriginType() != 100) {
                arrayList2.add(obj);
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = arrayList.isEmpty();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = arrayList2.isEmpty();
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        zPlanEmoticonUtil.K(arrayList, selfUin, this.f333211f, new Function1<ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1$run$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanEmoticonUtil.EmotionTabRecordReportData emotionTabRecordReportData) {
                invoke2(emotionTabRecordReportData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZPlanEmoticonUtil.EmotionTabRecordReportData reportData) {
                Intrinsics.checkNotNullParameter(reportData, "reportData");
                QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "record2DEmoticon finish, isZPlanEmoticonPanelShown=" + ZPlanEmoticonUtil.f333176e.H() + ", reportData: " + reportData);
                objectRef.element = reportData;
                booleanRef.element = true;
                this.b(true, booleanRef2.element, objectRef2.element, reportData, arrayList2.size(), arrayList.size());
            }
        });
        zPlanEmoticonUtil.V(arrayList2, selfUin, this.f333212h, this.f333213i, this.f333211f, null, new Function1<ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$recordEmoticonCoverAndPic$task$1$run$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanEmoticonUtil.EmotionTabRecordReportData emotionTabRecordReportData) {
                invoke2(emotionTabRecordReportData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZPlanEmoticonUtil.EmotionTabRecordReportData reportData) {
                boolean B2;
                Intrinsics.checkNotNullParameter(reportData, "reportData");
                objectRef2.element = reportData;
                booleanRef2.element = true;
                this.b(booleanRef.element, true, reportData, objectRef.element, arrayList2.size(), arrayList.size());
                ZPlanEmoticonUtil zPlanEmoticonUtil2 = ZPlanEmoticonUtil.f333176e;
                B2 = zPlanEmoticonUtil2.B();
                if (B2) {
                    QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "recordEmoticonCoverAndPicByResourceCenter finish, isZPlanEmoticonPanelShown=" + zPlanEmoticonUtil2.H());
                    return;
                }
                QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "recordEmoticonCoverAndPicByMemeRecord finish, isZPlanEmoticonPanelShown=" + zPlanEmoticonUtil2.H());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean record2DEnd, boolean recordMemeEnd, ZPlanEmoticonUtil.EmotionTabRecordReportData reportDataMeme, ZPlanEmoticonUtil.EmotionTabRecordReportData reportData2D, int total_3D, int total_3D_plus_2D) {
        boolean B;
        String str;
        if (this.f333214m && record2DEnd && recordMemeEnd) {
            QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "reportDataMeme : " + reportDataMeme + ", reportData2D: " + reportData2D);
            ZPlanEmoticonUtil.EmotionTabRecordReportData emotionTabRecordReportData = new ZPlanEmoticonUtil.EmotionTabRecordReportData(this.f333209d, (reportData2D != null ? reportData2D.getCoverCacheNum() : 0) + (reportDataMeme != null ? reportDataMeme.getCoverCacheNum() : 0), (reportData2D != null ? reportData2D.getCoverCloudRecordNum() : 0) + (reportDataMeme != null ? reportDataMeme.getCoverCloudRecordNum() : 0), (reportData2D != null ? reportData2D.getCoverLocalRecordNum() : 0) + (reportDataMeme != null ? reportDataMeme.getCoverLocalRecordNum() : 0), (reportData2D != null ? reportData2D.getPicCacheNum() : 0) + (reportDataMeme != null ? reportDataMeme.getPicCacheNum() : 0), (reportData2D != null ? reportData2D.getPicCloudRecordNum() : 0) + (reportDataMeme != null ? reportDataMeme.getPicCloudRecordNum() : 0), (reportData2D != null ? reportData2D.getPicLocalRecordNum() : 0) + (reportDataMeme != null ? reportDataMeme.getPicLocalRecordNum() : 0), (reportData2D != null ? reportData2D.getCoverTimeCost() : 0L) + (reportDataMeme != null ? reportDataMeme.getCoverTimeCost() : 0L), (reportData2D != null ? reportData2D.getTimeCost() : 0L) + (reportDataMeme != null ? reportDataMeme.getTimeCost() : 0L), total_3D, total_3D_plus_2D);
            B = ZPlanEmoticonUtil.f333176e.B();
            if (B) {
                str = "ResourceCenter";
            } else {
                str = "MemeRecord";
            }
            emotionTabRecordReportData.j(str);
        }
    }
}
