package com.qzone.reborn.layer.part;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001NB\u000f\u0012\u0006\u0010D\u001a\u00020?\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u000eH\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\b\u00109\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\u001c\u0010>\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/qzone/reborn/layer/part/bz;", "Lcom/qzone/reborn/layer/part/ap;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "Lpk/b;", "", "getPageId", "", "", "M9", "N9", "", "O9", "Landroid/os/Bundle;", "bundle", "", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "onDoubleClick", "onDragClose", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "isPraise", "B7", "C3", "k8", "H3", "R5", "x4", "k9", Constants.BASE_IN_PLUGIN_VERSION, "u5", "j9", "N2", "v2", "l9", "V5", ICustomDataEditor.NUMBER_PARAM_9, "L6", "E3", "l1", "r2", ICustomDataEditor.NUMBER_PARAM_5, "V2", "o1", "e4", "x6", "E4", "shareToQQ", "w4", ServiceCreateTask.SERVICE_TYPE_X5, "j5", "getWord", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "c4", "g8", "view", "b1", "Lve/l;", "G", "Lve/l;", "getBuilder", "()Lve/l;", "builder", "H", "Ljava/lang/String;", "refer", "I", "Z", "isRequestFinished", "<init>", "(Lve/l;)V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bz extends ap implements ILayerOperationListener, pk.b {

    /* renamed from: G, reason: from kotlin metadata */
    private final ve.l builder;

    /* renamed from: H, reason: from kotlin metadata */
    private String refer;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isRequestFinished;

    public bz(ve.l builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.refer = String.valueOf(builder.a());
    }

    private final Map<String, Object> M9() {
        HashMap hashMap = new HashMap();
        hashMap.put("open_visit_state", Integer.valueOf(F9() ? 1 : 0));
        hashMap.put("group_uin", "");
        PhotoParam photoParam = this.f57988i;
        String str = photoParam != null ? photoParam.albumid : null;
        hashMap.put("albumid", str != null ? str : "");
        PhotoInfo photoInfo = this.f57984d;
        int i3 = 0;
        if (photoInfo != null && photoInfo.isVideo()) {
            i3 = 1;
        }
        hashMap.put("floating_layer_type", Integer.valueOf(i3));
        hashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, this.refer);
        return hashMap;
    }

    private final String N9() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        boolean z16 = false;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.isVideo()) {
            z16 = true;
        }
        if (z16) {
            return "2";
        }
        return "1";
    }

    private final boolean O9() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.noNeedToFetchPhotoList;
    }

    private final String getPageId() {
        return "pg_qz_dynamic_floating_layer";
    }

    @Override // pk.b
    public void C3() {
        LpReportInfo_pf00064.allReport(301, 19, 0, this.refer, N9());
    }

    @Override // pk.b
    public void D2() {
        LpReportInfo_pf00064.allReport(301, 37, 2, this.refer, N9());
    }

    @Override // pk.b
    public void E3() {
        LpReportInfo_pf00064.allReport(301, 34, 2, this.refer, N9());
    }

    @Override // pk.b
    public void E4() {
        LpReportInfo_pf00064.allReport(301, 5, 31, this.refer, N9());
    }

    @Override // pk.b
    public void H3() {
        LpReportInfo_pf00064.allReport(301, 36, 0, this.refer, N9());
    }

    @Override // pk.b
    public void L6() {
        LpReportInfo_pf00064.allReport(301, 34, 1, this.refer, N9());
    }

    @Override // pk.b
    public void N2() {
        LpReportInfo_pf00064.allReport(301, 12, 2, this.refer, N9());
    }

    @Override // pk.b
    public void R5() {
        LpReportInfo_pf00064.allReport(301, 14, 0, this.refer, N9());
    }

    @Override // pk.b
    public void V2() {
        LpReportInfo_pf00064.allReport(134, 1, 2, this.refer, N9());
    }

    @Override // pk.b
    public void V5() {
        LpReportInfo_pf00064.allReport(301, 31, 1, this.refer, N9());
    }

    @Override // pk.b
    public void b1(View view, View rootView) {
        fo.c.l(view, rootView);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.SHARING_DITCH, 12);
        fo.c.e(WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, "pg_qz_dynamic_floating_layer", view, hashMap);
    }

    @Override // pk.b
    public void e4() {
        LpReportInfo_pf00064.allReport(301, 5, 6, this.refer, N9());
    }

    @Override // pk.b
    public void getWord() {
        LpReportInfo_pf00064.allReport(301, 5, 33, this.refer, N9());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        super.initIntentData(bundle);
        LpReportInfo_pf00064.allReport(301, 1, 0, this.refer, N9());
    }

    @Override // pk.b
    public void j5() {
        LpReportInfo_pf00064.allReport(301, 5, 32, this.refer, N9());
    }

    @Override // pk.b
    public void j9() {
        LpReportInfo_pf00064.allReport(301, 12, 1, this.refer, N9());
    }

    @Override // pk.b
    public void k8() {
        LpReportInfo_pf00064.allReport(301, 4, 0, this.refer, N9());
    }

    @Override // pk.b
    public void k9() {
        LpReportInfo_pf00064.allReport(301, 37, 1, this.refer, N9());
    }

    @Override // pk.b
    public void l1() {
        LpReportInfo_pf00064.allReport(301, 5, 0, this.refer, N9());
    }

    @Override // pk.b
    public void l9() {
        LpReportInfo_pf00064.allReport(301, 31, 3, this.refer, N9());
    }

    @Override // pk.b
    public void n5() {
        LpReportInfo_pf00064.allReport(301, 5, 3, this.refer, N9());
    }

    @Override // pk.b
    public void n9() {
        LpReportInfo_pf00064.allReport(301, 31, 2, this.refer, N9());
    }

    @Override // pk.b
    public void o1() {
        LpReportInfo_pf00064.allReport(301, 5, 5, this.refer, N9());
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDragClose() {
        LpReportInfo_pf00064.allReport(301, 15, 0, this.refer, N9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, pk.b.class);
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, this);
        VideoReport.setPageId(rootView, getPageId());
        VideoReport.setPageParams(rootView, new fo.a().d("QZoneFeedxLayerFragment", M9()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (com.qzone.reborn.util.e.b(getTAG(), 200L)) {
            return;
        }
        RFWLog.i(getTAG(), RFWLog.USR, "report current pos " + C9(layerState));
        LpReportInfo_pf00064.allReport(301, 18, 0, this.refer, N9());
        if ((this.isRequestFinished || O9()) && C9(layerState) == D9(layerState)) {
            RFWLog.i(getTAG(), RFWLog.USR, "reach last page");
            LpReportInfo_pf00064.allReport(301, 20, 0, this.refer, N9());
        }
    }

    @Override // pk.b
    public void r2() {
        LpReportInfo_pf00064.allReport(301, 5, 2, this.refer, N9());
    }

    @Override // pk.b
    public void shareToQQ() {
        LpReportInfo_pf00064.allReport(301, 5, 29, this.refer, N9());
    }

    @Override // pk.b
    public void u5() {
        LpReportInfo_pf00064.allReport(301, 13, 0, this.refer, N9());
    }

    @Override // pk.b
    public void v2() {
        LpReportInfo_pf00064.allReport(301, 38, 0, this.refer, N9());
    }

    @Override // pk.b
    public void w4() {
        LpReportInfo_pf00064.allReport(301, 5, 30, this.refer, N9());
    }

    @Override // pk.b
    public void x4() {
        LpReportInfo_pf00064.allReport(301, 6, 0, this.refer, N9());
    }

    @Override // pk.b
    public void x5() {
        LpReportInfo_pf00064.allReport(301, 5, 34, this.refer, N9());
    }

    @Override // pk.b
    public void x6() {
        LpReportInfo_pf00064.allReport(301, 5, 36, this.refer, N9());
    }

    @Override // pk.b
    public void g8() {
        this.isRequestFinished = true;
        RFWLog.i(getTAG(), RFWLog.USR, "updateResponseState");
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onSingleClick(boolean isClickToExit) {
        if (isClickToExit) {
            LpReportInfo_pf00064.allReport(301, 16, 0, this.refer, N9());
        }
    }

    @Override // pk.b
    public void B7(boolean isPraise) {
        if (isPraise) {
            LpReportInfo_pf00064.allReport(301, 2, 2, this.refer, N9());
        } else {
            LpReportInfo_pf00064.allReport(301, 2, 1, this.refer, N9());
        }
    }

    @Override // pk.b
    public void c4(boolean isOpen) {
        LpReportInfo_pf00064.allReport(301, 30, isOpen ? 2 : 3, this.refer, N9());
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDoubleClick() {
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onZoomScaleChangeEnd() {
    }
}
