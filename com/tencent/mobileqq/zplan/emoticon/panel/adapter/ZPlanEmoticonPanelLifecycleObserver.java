package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.utils.z;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016RA\u0010\u0014\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonPanelLifecycleObserver;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/util/c;", "", "r", "", "getTag", "onShow", "", "position", "onPageSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tabName", "i", "Lkotlin/jvm/functions/Function1;", "getOnSetCurrentPage", "()Lkotlin/jvm/functions/Function1;", ReportConstant.COSTREPORT_PREFIX, "(Lkotlin/jvm/functions/Function1;)V", "onSetCurrentPage", "providerId", "<init>", "(I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonPanelLifecycleObserver extends com.tencent.mobileqq.zplan.emoticon.panel.util.c {

    /* renamed from: m, reason: collision with root package name */
    private static final a f333146m = new a(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super String, Unit> onSetCurrentPage;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonPanelLifecycleObserver$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public ZPlanEmoticonPanelLifecycleObserver(int i3) {
        super(i3);
    }

    private final void r() {
        QRouteApi api = QRoute.api(IZPlanEmoticonInfoHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanEmoticonInfoHelper::class.java)");
        IZPlanEmoticonInfoHelper iZPlanEmoticonInfoHelper = (IZPlanEmoticonInfoHelper) api;
        String emoticonNextOpenPage = iZPlanEmoticonInfoHelper.getEmoticonNextOpenPage();
        Function1<? super String, Unit> function1 = this.onSetCurrentPage;
        QLog.i("ZPlanEmoticonPanelLifecycleObserver", 1, "openTargetPage, nextOpenPage:" + emoticonNextOpenPage);
        if (function1 != null) {
            function1.invoke(emoticonNextOpenPage);
            iZPlanEmoticonInfoHelper.setEmoticonNextOpenPage(null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.panel.util.c, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        return "ZPlanEmoticonPanelLifecycleObserver";
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.panel.util.c, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int position) {
        Function1<? super String, Unit> function1;
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        Intrinsics.checkNotNullExpressionValue(panelDataList, "mPanelController.panelDataList");
        Integer a16 = z.a(panelDataList, new Function1<EmotionPanelInfo, Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonPanelLifecycleObserver$onPageSelected$pageIndex$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EmotionPanelInfo emotionPanelInfo) {
                return Boolean.valueOf(emotionPanelInfo.type == 17);
            }
        });
        if (a16 != null) {
            int intValue = a16.intValue();
            if ((position == intValue - 1 || position == intValue + 1) && (function1 = this.onSetCurrentPage) != null) {
                function1.invoke("\u8868\u60c5");
            }
            super.onPageSelected(position);
        }
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.panel.util.c, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        super.onShow();
        r();
    }

    public final void s(Function1<? super String, Unit> function1) {
        this.onSetCurrentPage = function1;
    }
}
