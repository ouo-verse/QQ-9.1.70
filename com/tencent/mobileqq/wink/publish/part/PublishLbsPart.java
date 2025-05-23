package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.wink.publish.adapter.b;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes21.dex */
public class PublishLbsPart extends j implements m93.b {
    public static final String J = UploadConstants.TAG + "FSLbsPart";
    private ViewGroup C;
    private ImageView D;
    private TextView E;
    private com.tencent.mobileqq.wink.view.n F;
    private QQPermission H;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f325742d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.adapter.b f325743e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.o f325744f;

    /* renamed from: h, reason: collision with root package name */
    private PublishViewModel f325745h;

    /* renamed from: i, reason: collision with root package name */
    private PartsStateViewModel f325746i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f325747m;
    private boolean G = false;
    private final Runnable I = new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishLbsPart.1
        @Override // java.lang.Runnable
        public void run() {
            if (PublishLbsPart.this.F != null) {
                PublishLbsPart.this.F.dismiss();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements Observer<List<ha3.b>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f325748d;

        a(LiveData liveData) {
            this.f325748d = liveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<ha3.b> list) {
            this.f325748d.removeObserver(this);
            if (list == null || list.isEmpty() || i93.c.INSTANCE.a(PublishLbsPart.this.getActivity().getIntent())) {
                return;
            }
            ha3.b bVar = list.get(0);
            if (bVar.f404623h != null) {
                PublishLbsPart.this.f325744f.C.postValue(bVar.f404623h);
                PublishLbsPart.this.f325744f.G = bVar.f404623h;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            PublishLbsPart.this.f325744f.P1(PublishLbsPart.this.getHostFragment());
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.w(PublishLbsPart.J, 1, "jumpToPoiFragment... deny");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PublishLbsPart.this.getActivity().startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
        }
    }

    private boolean R9(LbsDataV2.PoiInfo poiInfo) {
        if (!V9()) {
            QLog.d(J, 1, "[selectFirstPoiInfo] current not gps permission.");
            return false;
        }
        if (i93.c.INSTANCE.a(getActivity().getIntent())) {
            QLog.d(J, 1, "[selectFirstPoiInfo] current cant select loc");
            return false;
        }
        if (this.f325742d.getVisibility() == 8) {
            this.f325742d.setVisibility(0);
        }
        if (poiInfo != null && !U9()) {
            QLog.d(J, 1, "[checkFirstPoiInfoSelected]");
            com.tencent.mobileqq.wink.publish.viewmodel.o oVar = this.f325744f;
            if (oVar != null) {
                oVar.G = poiInfo;
            }
            ua(poiInfo, false);
        }
        return true;
    }

    private void T9(LbsDataV2.PoiInfo poiInfo) {
        String str = poiInfo.poiId;
        if (str != null && str.equals("invalide_poi_id")) {
            com.tencent.mobileqq.wink.publish.viewmodel.o oVar = this.f325744f;
            if (oVar != null) {
                oVar.G = null;
            }
            com.tencent.mobileqq.wink.publish.adapter.b bVar = this.f325743e;
            if (bVar != null) {
                bVar.setData(null);
            }
            ViewGroup viewGroup = this.f325742d;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.C;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
        }
    }

    private boolean U9() {
        return com.tencent.mobileqq.wink.utils.ar.f326685a.c("key_sp_has_delete_loc", false);
    }

    private boolean V9() {
        if (((LocationManager) getActivity().getSystemService("location")).isProviderEnabled("gps") && S9()) {
            return true;
        }
        return false;
    }

    private void W9() {
        if (this.F == null) {
            this.F = new com.tencent.mobileqq.wink.view.n(getContext());
        }
    }

    private void X9() {
        if (!((LocationManager) getActivity().getSystemService("location")).isProviderEnabled("gps")) {
            ra();
            return;
        }
        if (!S9()) {
            QQPermission qQPermission = this.H;
            if (qQPermission == null) {
                return;
            }
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new b());
            return;
        }
        this.f325744f.P1(getHostFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(ArrayList arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "[onChanged] mediaInfos: ", arrayList);
        }
        if (arrayList != null && !arrayList.isEmpty() && V9()) {
            this.G = true;
            this.f325744f.S1(arrayList, true);
        } else {
            this.f325743e.e();
            this.f325742d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z9(PublishSettingItemState publishSettingItemState) {
        if (!publishSettingItemState.getSelectable()) {
            this.E.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
            oa();
        } else {
            this.E.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(List list) {
        QLog.d(J, 1, "onChanged... mPoiLiveData:");
        this.f325742d.setVisibility(0);
        this.f325743e.setData(list);
        if (i93.c.INSTANCE.a(getActivity().getIntent())) {
            this.f325742d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo != null) {
            QLog.d(J, 1, "onChanged... poiInfo: xx");
        }
        ua(poiInfo, true);
        this.f325742d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(LbsDataV2.PoiInfo poiInfo) {
        String str;
        QLog.d(J, 1, "[onChanged] mDefSelectPoiDataLiveData poiInfo: xx");
        if (poiInfo != null && (str = poiInfo.poiId) != null && !str.equals("invalide_poi_id") && this.G && R9(poiInfo)) {
            va();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        pa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        pa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        pa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        qa(i3);
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        oa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja() {
        if (!V9()) {
            QLog.i(J, 1, "[reloadPublishPoiData] current not gps permission.");
        } else {
            this.f325744f.S1(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la() {
        this.D.getLayoutParams().width = this.C.getWidth() / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma() {
        this.F.g(getActivity().getResources().getString(R.string.f183713jx));
        this.F.h(5);
        this.F.setWidth(-2);
        this.F.setHeight(-2);
        this.F.d(this.C, 1, 0, 0, 0);
        getMainHandler().postDelayed(this.I, 4000L);
        LocalConfig.putBool4Uin("key_sp_bubble_view_show", false, WinkCommonUtil.getCurrentAccountLong());
    }

    private void na() {
        this.f325744f.f326059m.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishLbsPart.this.aa((List) obj);
            }
        });
        this.f325744f.C.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishLbsPart.this.ba((LbsDataV2.PoiInfo) obj);
            }
        });
        this.f325744f.D.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishLbsPart.this.ca((LbsDataV2.PoiInfo) obj);
            }
        });
        this.f325745h.C.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishLbsPart.this.Y9((ArrayList) obj);
            }
        });
        this.f325746i.i2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishLbsPart.this.Z9((PublishSettingItemState) obj);
            }
        });
        wa();
    }

    private void oa() {
        ua(null, true);
        com.tencent.mobileqq.wink.publish.viewmodel.o oVar = this.f325744f;
        oVar.G = null;
        oVar.N = true;
        if (this.f325743e.getCount() == 0) {
            this.f325742d.setVisibility(8);
        } else {
            this.f325742d.setVisibility(0);
        }
        ta(true);
    }

    private void pa() {
        if (this.f325746i.i2().getValue().getSelectable()) {
            PublishContentPart publishContentPart = (PublishContentPart) getPartManager().getPart(PublishContentPart.class.getName());
            if (publishContentPart != null) {
                publishContentPart.Ua();
            }
            X9();
            return;
        }
        com.tencent.mobileqq.wink.publish.util.f.a(getContext(), this.f325746i.k2());
    }

    private void qa(int i3) {
        if (i3 == 0) {
            return;
        }
        if (!this.f325746i.i2().getValue().getSelectable()) {
            com.tencent.mobileqq.wink.publish.util.f.a(getContext(), this.f325746i.k2());
            return;
        }
        b.a item = this.f325743e.getItem(i3);
        if (!item.f325650c) {
            ua(item.f325648a, true);
            com.tencent.mobileqq.wink.publish.viewmodel.o oVar = this.f325744f;
            oVar.G = item.f325648a;
            oVar.N = true;
            this.f325742d.setVisibility(8);
            return;
        }
        X9();
    }

    private void ra() {
        try {
            com.tencent.mobileqq.wink.view.o.N(getContext(), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_title", "\u65e0\u6cd5\u5b9a\u4f4d"), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_content", "\u65e0\u6cd5\u83b7\u53d6\u5230\u4f60\u7684\u4f4d\u7f6e\u4fe1\u606f\uff0c\u8bf7\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u3002"), R.string.cancel, R.string.f171000bk1, new c(), new d()).show();
        } catch (Exception e16) {
            QLog.e(J, 1, "Exception:", e16);
        }
    }

    private void sa() {
        if (this.f325744f == null) {
            QLog.d(J, 1, "[reloadPublishPoiData] mPoiViewModel == null.");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.ao
                @Override // java.lang.Runnable
                public final void run() {
                    PublishLbsPart.this.ja();
                }
            });
        }
    }

    private void ta(boolean z16) {
        com.tencent.mobileqq.wink.utils.ar.f326685a.m("key_sp_has_delete_loc", z16);
    }

    private void ua(LbsDataV2.PoiInfo poiInfo, boolean z16) {
        if (this.f325743e == null) {
            QLog.d(J, 1, "[setPoiInfoSelected] poi adapter not is null.");
            return;
        }
        if (!this.f325746i.i2().getValue().getSelectable()) {
            this.f325744f.G = null;
            poiInfo = null;
        }
        this.f325743e.g(poiInfo);
        if (poiInfo == null) {
            ViewGroup viewGroup = this.C;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                this.f325746i.O2(false);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.C;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            this.f325746i.O2(true);
            TextView textView = this.f325747m;
            if (textView != null) {
                textView.setText(poiInfo.poiName);
                this.f325747m.post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishLbsPart.this.la();
                    }
                });
                if (z16) {
                    ta(false);
                }
            }
        }
    }

    private void va() {
        if (LocalConfig.getBool4Uin("key_sp_bubble_view_show", false, WinkCommonUtil.getCurrentAccountLong()) && this.F != null) {
            this.C.post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.aj
                @Override // java.lang.Runnable
                public final void run() {
                    PublishLbsPart.this.ma();
                }
            });
        }
    }

    private void wa() {
        if (U9()) {
            QLog.d(J, 1, "try2RecoverPosFromDraft, has delete loc ");
            return;
        }
        LiveData<List<ha3.b>> liveData = this.f325745h.H;
        if (liveData != null) {
            liveData.observe(getHostFragment(), new a(liveData));
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return J;
    }

    @Override // m93.b
    public void I2(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        QQPermission qQPermission = this.H;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(i3, strArr, iArr);
        }
    }

    public boolean S9() {
        QQPermission qQPermission = this.H;
        if (qQPermission == null || qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    @Override // m93.b
    public String d4() {
        return J;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 1208 && i16 == -1 && intent != null && intent.getExtras() != null) {
            this.f325744f.O1(intent);
            Parcelable parcelable = intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
            if (parcelable instanceof LbsDataV2.PoiInfo) {
                T9((LbsDataV2.PoiInfo) parcelable);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        long j3 = 500;
        ViewUtilsKt.e(view.findViewById(R.id.f31530ra), j3, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishLbsPart.this.da(view2);
            }
        });
        this.E = (TextView) view.findViewById(R.id.f31540rb);
        ViewUtilsKt.e(view.findViewById(R.id.f124167im), j3, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishLbsPart.this.ea(view2);
            }
        });
        ViewUtilsKt.e(view.findViewById(R.id.f123967i3), j3, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishLbsPart.this.ga(view2);
            }
        });
        if (this.f325742d != null) {
            QLog.d(J, 2, "[initPoiView] already inited");
            return;
        }
        this.f325742d = (ViewGroup) view.findViewById(R.id.f32450ts);
        HorizontalListView horizontalListView = (HorizontalListView) view.findViewById(R.id.f32460tt);
        com.tencent.mobileqq.wink.publish.adapter.b bVar = new com.tencent.mobileqq.wink.publish.adapter.b(getActivity());
        this.f325743e = bVar;
        horizontalListView.setAdapter((ListAdapter) bVar);
        ViewUtilsKt.g(horizontalListView, j3, new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.am
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i3, long j16) {
                PublishLbsPart.this.ha(adapterView, view2, i3, j16);
            }
        });
        this.C = (ViewGroup) view.findViewById(R.id.f32560u3);
        this.f325747m = (TextView) view.findViewById(R.id.mdl);
        this.C.setVisibility(8);
        ImageView imageView = (ImageView) view.findViewById(R.id.f165920y22);
        this.D = imageView;
        ViewUtilsKt.e(imageView, j3, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishLbsPart.this.ia(view2);
            }
        });
        W9();
        na();
        sa();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (this.f325744f == null) {
            this.f325744f = (com.tencent.mobileqq.wink.publish.viewmodel.o) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.o.class);
        }
        if (this.f325745h == null) {
            this.f325745h = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        if (this.H == null) {
            this.H = QQPermissionFactory.getQQPermission(getHostFragment());
        }
        if (this.f325746i == null) {
            this.f325746i = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        }
        m93.a.f416460b.b(this);
        SimpleEventBus.getInstance().registerReceiver(this.f325744f);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this.f325744f);
        m93.a.f416460b.c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
