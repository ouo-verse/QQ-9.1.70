package com.tencent.mobileqq.wink.templatelibrary;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.report.f;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter;
import com.tencent.mobileqq.wink.utils.q;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.utils.WinkDtParamsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_PICKER)
/* loaded from: classes21.dex */
public class WinkTemplatePreviewFragment extends ImmersivePartFragment implements View.OnClickListener, IWinkCrashReportCallback {
    private View C;
    private ViewPager2 D;
    private RecyclerView E;
    private MetaCategory F;
    private int G = -1;
    private int H = -1;
    private Map<String, String> I;
    private String J;
    private TemplatePreviewAdapter K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0 && WinkTemplatePreviewFragment.this.G != WinkTemplatePreviewFragment.this.H) {
                WinkTemplatePreviewFragment winkTemplatePreviewFragment = WinkTemplatePreviewFragment.this;
                winkTemplatePreviewFragment.Dh(winkTemplatePreviewFragment.G);
                WinkTemplatePreviewFragment winkTemplatePreviewFragment2 = WinkTemplatePreviewFragment.this;
                winkTemplatePreviewFragment2.Ch(winkTemplatePreviewFragment2.H);
                WinkTemplatePreviewFragment winkTemplatePreviewFragment3 = WinkTemplatePreviewFragment.this;
                winkTemplatePreviewFragment3.G = winkTemplatePreviewFragment3.H;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            WinkTemplatePreviewFragment.this.H = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(Object obj) {
        ArrayList<MetaMaterial> arrayList;
        QLog.i("WinkTemplatePreviewFrag", 1, "[onActivityCreated] got category");
        MetaCategory metaCategory = (MetaCategory) obj;
        this.F = metaCategory;
        if (this.I != null && metaCategory != null && (arrayList = metaCategory.materials) != null && arrayList.size() > 0) {
            Iterator<MetaMaterial> it = this.F.materials.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.wink.templatelibrary.a.a(this.F.f30532id, it.next().f30533id);
            }
        }
        this.G = getActivity().getIntent().getIntExtra("position", 0);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map Bh(String str) {
        MetaMaterial metaMaterial;
        if (!"pgin".equals(str) && !"pgout".equals(str)) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        List<MetaMaterial> wh5 = wh();
        if (wh5 != null) {
            int size = wh5.size();
            int i3 = this.G;
            if (size > i3 && i3 != -1 && (metaMaterial = wh5.get(i3)) != null) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            }
        }
        return hashMap;
    }

    private String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_TEMPLATE_PREVIEW_PAGE;
    }

    private static String getTraceId() {
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            return f16.getTraceId();
        }
        return "";
    }

    private void init() {
        View view = this.C;
        if (view == null) {
            QLog.e("WinkTemplatePreviewFrag", 1, "mContentView is NullPointException");
            return;
        }
        this.D = (ViewPager2) view.findViewById(R.id.kwk);
        List<MetaMaterial> wh5 = wh();
        TemplatePreviewAdapter templatePreviewAdapter = new TemplatePreviewAdapter(getContext(), wh5, this.G, this.J, this);
        this.K = templatePreviewAdapter;
        this.D.setAdapter(templatePreviewAdapter);
        this.D.setOrientation(1);
        if (!AppSetting.o(getHostActivity())) {
            QLog.d("WinkTemplatePreviewFrag", 4, "setOffscreenPageLimit");
            this.D.setOffscreenPageLimit(3);
        }
        if (this.E == null) {
            this.E = (RecyclerView) this.D.getChildAt(0);
        }
        this.D.registerOnPageChangeCallback(new a());
        this.D.setCurrentItem(this.G, false);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.btn_back);
        imageView.setImageResource(R.drawable.qui_chevron_left);
        imageView.setOnClickListener(this);
        registerDaTongReportPageId(this.C);
        com.tencent.mobileqq.wink.inspirationlibrary.d.f322989a.b(true, wh5, this.F, this.G);
    }

    private void registerDaTongReportPageId(View view) {
        Map<String, Object> a16 = f.f326266a.a(getActivity());
        if (a16 == null) {
            QLog.i("WinkTemplatePreviewFrag", 1, "reportDaTongRegister argsFromIntent == null , subPage: " + getTAG());
            return;
        }
        if (!a16.isEmpty()) {
            for (Map.Entry<String, Object> entry : a16.entrySet()) {
                WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
            }
        }
        Object obj = a16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE);
        if (obj == null || obj.equals("")) {
            a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        }
        Object obj2 = a16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID);
        if (obj2 == null || obj2.equals("")) {
            a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        }
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        WinkHomeReportHelper.f326257a.c(getActivity(), view, getPageId(), a16);
        VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.mobileqq.wink.templatelibrary.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Bh;
                Bh = WinkTemplatePreviewFragment.this.Bh(str);
                return Bh;
            }
        });
        QLog.i("WinkTemplatePreviewFrag", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + getPageId());
    }

    private List<MetaMaterial> wh() {
        MetaCategory metaCategory = this.F;
        if (metaCategory == null) {
            QLog.e("WinkTemplatePreviewFrag", 1, "[getData] invalid category");
            return new ArrayList();
        }
        return metaCategory.materials;
    }

    private TemplatePreviewAdapter.ViewHolder xh(int i3) {
        if (i3 < 0) {
            QLog.w("WinkTemplatePreviewFrag", 1, "[getViewHolder] invalid position, " + i3);
            return null;
        }
        if (this.E == null) {
            this.E = (RecyclerView) this.D.getChildAt(0);
        }
        View findViewByPosition = ((LinearLayoutManager) this.E.getLayoutManager()).findViewByPosition(i3);
        if (findViewByPosition == null) {
            return (TemplatePreviewAdapter.ViewHolder) this.E.findViewHolderForAdapterPosition(i3);
        }
        return (TemplatePreviewAdapter.ViewHolder) this.E.getChildViewHolder(findViewByPosition);
    }

    private void yh() {
        HashMap hashMap = (HashMap) getActivity().getIntent().getSerializableExtra("key_attrs");
        this.I = hashMap;
        WinkDtParamsUtils.initParamByKey(hashMap, "xsj_operation_activity_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(Subscriber subscriber) {
        try {
            QLog.i("WinkTemplatePreviewFrag", 1, "[onActivityCreated] get category");
            subscriber.onNext((MetaCategory) getActivity().getIntent().getSerializableExtra("category"));
        } catch (Exception e16) {
            QLog.e("WinkTemplatePreviewFrag", 1, "[onActivityCreated] ", e16);
            subscriber.onNext(null);
        }
    }

    public void Ch(int i3) {
        if (i3 < 0) {
            QLog.w("WinkTemplatePreviewFrag", 1, "[playNewVideo] invalid position, " + i3);
            return;
        }
        TemplatePreviewAdapter.ViewHolder xh5 = xh(i3);
        if (xh5 != null) {
            xh5.G0();
        }
    }

    public void Dh(int i3) {
        if (i3 < 0) {
            QLog.w("WinkTemplatePreviewFrag", 1, "[stopCurrentVideo] invalid position, " + i3);
            return;
        }
        TemplatePreviewAdapter.ViewHolder xh5 = xh(i3);
        if (xh5 != null) {
            xh5.L0();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkTemplatePreviewFrag";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.J = getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        if (TextUtils.isEmpty(this.J)) {
            this.J = getTraceId();
        }
        Observable.create(new Observable.OnSubscribe() { // from class: com.tencent.mobileqq.wink.templatelibrary.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                WinkTemplatePreviewFragment.this.zh((Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.tencent.mobileqq.wink.templatelibrary.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                WinkTemplatePreviewFragment.this.Ah(obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.btn_back && getActivity() != null) {
            com.tencent.mobileqq.wink.inspirationlibrary.d.f322989a.b(false, wh(), this.F, this.G);
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.C == null) {
            this.C = layoutInflater.inflate(R.layout.f169201i82, viewGroup, false);
        }
        this.C.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        yh();
        if (needAdjustImmersive() && !needSupportFullScreen() && ImmersiveUtils.isSupporImmersive() == 1) {
            q.a(getActivity(), getContext().getColor(R.color.qui_common_bg_bottom_light));
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
        }
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.d("WinkTemplatePreviewFrag", 1, "[onDestroyView] stop ue ");
        super.onDestroyView();
        for (int i3 = 0; i3 < wh().size(); i3++) {
            try {
                TemplatePreviewAdapter.ViewHolder xh5 = xh(i3);
                if (xh5 != null) {
                    QLog.d("WinkTemplatePreviewFrag", 1, "[onDestroyView] stop video " + i3);
                    xh5.L0();
                }
            } catch (Exception e16) {
                QLog.e("WinkTemplatePreviewFrag", 1, e16, new Object[0]);
                return;
            }
        }
        TemplatePreviewAdapter templatePreviewAdapter = this.K;
        if (templatePreviewAdapter != null) {
            templatePreviewAdapter.v0();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
        TemplatePreviewAdapter.ViewHolder xh5 = xh(this.G);
        if (xh5 != null) {
            xh5.F0();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        TemplatePreviewAdapter templatePreviewAdapter = this.K;
        if (templatePreviewAdapter != null) {
            templatePreviewAdapter.A0(i3, strArr, iArr);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onResumeReport();
        TemplatePreviewAdapter.ViewHolder xh5 = xh(this.G);
        if (xh5 != null) {
            xh5.G0();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        TemplatePreviewAdapter.ViewHolder xh5 = xh(this.G);
        if (xh5 != null) {
            xh5.L0();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }
}
