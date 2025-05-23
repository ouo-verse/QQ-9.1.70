package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/ea;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "z9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "d", "J", "enterTimeMs", "<init>", "()V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ea extends u {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long enterTimeMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/ea$a;", "", "", "a", "", "EVENT_ID_CIRCLE_PUBLIC_ACCOUNT", "I", "OP_TYPE_ENTER", "OP_TYPE_EXIT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.ea$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a() {
            ArrayList arrayListOf;
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(1);
            attributeList.att_name.set("op_type");
            attributeList.att_value.set("0");
            QCirclePublicAccountRedDotType redDotTypeFromCached = ((IQCirclePublicAccountMessageService) QCircleServiceImpl.getAppInterface().getRuntimeService(IQCirclePublicAccountMessageService.class, "")).getRedDotTypeFromCached();
            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
            attributeList2.att_id.set(2);
            attributeList2.att_name.set("red_status");
            attributeList2.att_value.set(String.valueOf(redDotTypeFromCached.getType()));
            IReadInJoyReportUtils iReadInJoyReportUtils = (IReadInJoyReportUtils) QRoute.api(IReadInJoyReportUtils.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(attributeList, attributeList2);
            iReadInJoyReportUtils.reportPushEffectEvent(95, arrayListOf);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void x9() {
        INSTANCE.a();
    }

    private final void z9() {
        ArrayList arrayListOf;
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("op_type");
        attributeList.att_value.set("1");
        long currentTimeMillis = System.currentTimeMillis() - this.enterTimeMs;
        oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
        attributeList2.att_id.set(11);
        attributeList2.att_name.set("stayDuration");
        attributeList2.att_value.set(String.valueOf(currentTimeMillis));
        IReadInJoyReportUtils iReadInJoyReportUtils = (IReadInJoyReportUtils) QRoute.api(IReadInJoyReportUtils.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(attributeList, attributeList2);
        iReadInJoyReportUtils.reportPushEffectEvent(95, arrayListOf);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublicAccountReportPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ((IQCirclePublicAccountTechReporter) QRoute.api(IQCirclePublicAccountTechReporter.class)).onPageInit();
        this.enterTimeMs = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        z9();
    }
}
