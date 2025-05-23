package com.tencent.mobileqq.qqvideoedit.zplan.parts;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R6\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/parts/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "", "S9", "", "R9", "P9", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Q9", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "D", "Ljava/util/HashMap;", "extraInfo", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends com.tencent.mobileqq.qqvideoedit.editor.d {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, String> extraInfo;

    private final void P9() {
        View findViewById;
        View findViewById2;
        View partRootView = getPartRootView();
        if (partRootView != null && (findViewById2 = partRootView.findViewById(R.id.zqg)) != null) {
            ((IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class)).setElementInfo(findViewById2, "em_zplan_makegif_edit_next", new LinkedHashMap());
        }
        View partRootView2 = getPartRootView();
        if (partRootView2 != null && (findViewById = partRootView2.findViewById(R.id.t9k)) != null) {
            ((IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class)).setElementInfo(findViewById, "em_zplan_makegif_edit_text", new LinkedHashMap());
        }
    }

    private final HashMap<String, String> Q9() {
        Serializable serializable;
        Intent intent;
        if (this.extraInfo == null) {
            Activity activity = getActivity();
            HashMap<String, String> hashMap = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                serializable = intent.getSerializableExtra(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO);
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            }
            this.extraInfo = hashMap;
            QLog.i(this.TAG, 2, "onAttach mExtraInfo " + hashMap);
        }
        HashMap<String, String> hashMap2 = this.extraInfo;
        if (hashMap2 == null) {
            return new HashMap<>();
        }
        return hashMap2;
    }

    private final String R9() {
        String str = Q9().get(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID);
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void S9() {
        Map<String, Object> mutableMapOf;
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.i(this.TAG, 1, "reportDaTongRegister mContentView == null , subPage: " + getTAG());
            return;
        }
        IZootopiaReportApi iZootopiaReportApi = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_makegif"), new Pair(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, R9()));
        iZootopiaReportApi.setPageInfo(this, partRootView, "pg_zplan_makegif_edit", mutableMapOf);
        QLog.i(this.TAG, 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: pg_zplan_makegif_edit");
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f1170770g;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        S9();
        P9();
    }
}
