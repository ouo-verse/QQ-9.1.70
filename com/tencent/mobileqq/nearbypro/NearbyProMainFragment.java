package com.tencent.mobileqq.nearbypro;

import ab2.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.debug.d;
import com.tencent.mobileqq.nearbypro.map.part.LocationPart;
import com.tencent.mobileqq.nearbypro.map.part.NearByProClusterPart;
import com.tencent.mobileqq.nearbypro.map.part.PreloadPart;
import com.tencent.mobileqq.nearbypro.map.part.b;
import com.tencent.mobileqq.nearbypro.map.part.f;
import com.tencent.mobileqq.nearbypro.part.MainTitlePart;
import com.tencent.mobileqq.nearbypro.part.PendantPart;
import com.tencent.mobileqq.nearbypro.part.StatusPublishPart;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.nearbypro.part.guide.NearbyProStudyGuidePart;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/NearbyProMainFragment;", "Lcom/tencent/mobileqq/nearbypro/arch/NearbyBaseFragment;", "Landroid/view/View;", "root", "", "key", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "sh", "onResume", "", "useArgusLifecycle", "", "Lcom/tencent/mobileqq/nearbypro/part/e;", "rh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "r3", "bh", "isWrapContent", "", UserInfo.SEX_FEMALE, "J", "startTs", "Landroid/content/BroadcastReceiver;", "G", "Landroid/content/BroadcastReceiver;", "kuiklyBroadcastReceiver", "<init>", "()V", "H", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProMainFragment extends NearbyBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private long startTs;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BroadcastReceiver kuiklyBroadcastReceiver;

    private final void sh(View root, String key, Map<String, ? extends Object> reportParams) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(reportParams);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setPageId(root, "pg_nearby_home_map");
        VideoReport.reportEvent(key, root, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void th(NearbyProMainFragment nearbyProMainFragment, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        nearbyProMainFragment.sh(view, str, map);
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, com.tencent.mobileqq.nearbypro.part.a
    public void bh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fnj;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Map<String, ? extends Object> mapOf;
        super.onDestroyView();
        j.e().a(getContext());
        if (this.kuiklyBroadcastReceiver != null) {
            getContext().unregisterReceiver(this.kuiklyBroadcastReceiver);
        }
        View view = getView();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(System.currentTimeMillis() - this.startTs)));
        sh(view, "dt_pgout", mapOf);
        ((IAvatarService) QRoute.api(IAvatarService.class)).cleanup();
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarImmersive();
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.startTs = System.currentTimeMillis();
        th(this, getView(), "dt_pgin", null, 4, null);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.nearbypro.NearbyProMainFragment$onViewCreated$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a16 = l.a(intent);
                JSONObject b16 = l.b(intent);
                if (b16.has("nearbyData")) {
                    NearbyProMainFragment.this.t5(a16, b16.get("nearbyData"));
                }
            }
        };
        this.kuiklyBroadcastReceiver = broadcastReceiver;
        l.c(getContext(), broadcastReceiver);
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, com.tencent.mobileqq.nearbypro.part.a
    public boolean r3() {
        boolean r36 = super.r3();
        j.c().e("NearbyProMainFragment", "back backResult=" + r36);
        if (r36) {
            t5("update_map_concise_action", Boolean.FALSE);
            return true;
        }
        bh();
        return true;
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment
    @NotNull
    public List<e> rh() {
        List<e> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new f(), new MainTitlePart(), new LocationPart(), new StatusPublishPart(), new b(), new com.tencent.mobileqq.nearbypro.part.guide.j(), new NearbyProStudyGuidePart(), new NearByProClusterPart(), new PreloadPart(), new PendantPart());
        if (!a.f25767a.s()) {
            mutableListOf.add(new d());
        }
        QRoute.api(IVasSquareApi.class);
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public boolean useArgusLifecycle() {
        return true;
    }
}
