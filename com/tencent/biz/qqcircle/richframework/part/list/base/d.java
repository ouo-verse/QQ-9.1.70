package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.helpers.QFSPublicListTabCommonHelper;
import com.tencent.biz.qqcircle.immersive.events.QFSLaunchToSelectedEvent;
import com.tencent.biz.qqcircle.immersive.views.h;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends Part {
    private ArrayList<BaseListBlock> C;
    private FrameLayout D;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private QCircleInitBean f91959d;

    /* renamed from: f, reason: collision with root package name */
    private List<QQCircleFeedBase$StTabInfo> f91961f;

    /* renamed from: h, reason: collision with root package name */
    protected TabLayoutCompat f91962h;

    /* renamed from: i, reason: collision with root package name */
    protected ArrayList<String> f91963i;

    /* renamed from: m, reason: collision with root package name */
    protected MultiTabViewPager f91964m;

    /* renamed from: e, reason: collision with root package name */
    private final List<h> f91960e = new CopyOnWriteArrayList();
    private final Map<Integer, Integer> E = new HashMap();
    private final Map<Integer, Boolean> F = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements TabLayoutCompat.j {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public void a(TabLayoutCompat.f fVar, @Nullable TabLayoutCompat.f fVar2, int i3) {
            d.this.E9(fVar, fVar2, i3);
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public View b(ViewGroup viewGroup, int i3) {
            return d.this.D9(viewGroup, i3);
        }
    }

    public d(ArrayList<BaseListBlock> arrayList) {
        this.C = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View D9(ViewGroup viewGroup, int i3) {
        QLog.d("NFT-PublicListTabCommonPart", 1, "[onCreateTab] position: " + i3);
        h hVar = new h(viewGroup);
        this.f91960e.add(hVar);
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = (QQCircleFeedBase$StTabInfo) RFSafeListUtils.get(this.f91961f, i3);
        if (qQCircleFeedBase$StTabInfo != null && !TextUtils.isEmpty(qQCircleFeedBase$StTabInfo.tabName.get())) {
            QLog.d("NFT-PublicListTabCommonPart", 1, "[onCreateTab] position: " + i3 + " | tab name: " + qQCircleFeedBase$StTabInfo.tabName.get());
            hVar.p(qQCircleFeedBase$StTabInfo.tabName.get());
        }
        hVar.g(this.f91962h, true);
        M9(hVar.a(), qQCircleFeedBase$StTabInfo);
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(TabLayoutCompat.f fVar, TabLayoutCompat.f fVar2, int i3) {
        boolean z16;
        int i16;
        QLog.d("NFT-PublicListTabCommonPart", 1, "[onTabSelected] tab: " + fVar + " | lastTab: " + fVar2 + " | status: " + i3);
        for (int i17 = 0; i17 < this.f91960e.size(); i17++) {
            h hVar = this.f91960e.get(i17);
            if (hVar == null) {
                QLog.d("NFT-PublicListTabCommonPart", 1, "[handlerTabSelected] tabView == null.");
                return;
            }
            if (fVar != null && hVar.a() != null && hVar.a() == fVar.b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            P9(hVar, z16);
            hVar.g(this.f91962h, true);
            if (z16) {
                O9(i17, 0);
                int c16 = QFSPublicListTabCommonHelper.c(i17, this.f91961f);
                if (c16 == -1) {
                    QLog.e("NFT-PublicListTabCommonPart", 1, "[onTabSelected] type is illegality, flow end.");
                    return;
                }
                if (this.E.containsKey(Integer.valueOf(c16))) {
                    i16 = this.E.get(Integer.valueOf(c16)).intValue();
                } else {
                    i16 = 0;
                }
                this.E.put(Integer.valueOf(c16), 0);
                if (fVar2 != null) {
                    L9(hVar.a(), fVar.e());
                }
                N9(c16, i16, false);
                SimpleEventBus.getInstance().dispatchEvent(new QFSLaunchToSelectedEvent(c16));
            }
        }
    }

    private void F9() {
        Intent intent;
        if (getActivity() == null) {
            intent = null;
        } else {
            intent = getActivity().getIntent();
        }
        if (intent != null && intent.hasExtra("public_list_block_class_array")) {
            this.f91963i = intent.getStringArrayListExtra("public_list_block_class_array");
        }
    }

    private void G9(View view) {
        Intent intent;
        if (this.f91964m == null) {
            QLog.w("NFT-PublicListTabCommonPart", 1, "[initTabs] current view pager should not be null.");
            return;
        }
        ArrayList<String> arrayList = this.f91963i;
        if (arrayList != null && arrayList.size() > 1) {
            if (getActivity() == null) {
                intent = null;
            } else {
                intent = getActivity().getIntent();
            }
            List<QQCircleFeedBase$StTabInfo> d16 = QFSPublicListTabCommonHelper.d(intent);
            this.f91961f = d16;
            if (d16 != null && d16.size() > 1) {
                J9(intent);
                TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) view.findViewById(R.id.f500424b);
                this.f91962h = tabLayoutCompat;
                tabLayoutCompat.setSelectedTabIndicatorWidth(DisplayUtil.dip2px(getContext(), 20.0f));
                this.f91962h.setSelectedTabIndicatorHeight(DisplayUtil.dip2px(getContext(), 2.0f));
                this.f91962h.setSelectedTabIndicatorPaddingBottom(DisplayUtil.dip2px(getContext(), 8.0f));
                this.f91962h.setupWithViewPager(this.f91964m);
                this.f91962h.setTabMode(0);
                this.f91962h.setScrollableTabMinWidth(-2);
                this.f91962h.setTabGravity(1);
                this.f91962h.setVisibility(0);
                this.f91962h.setViewPagerTabEventListener(new a());
                Q9(intent);
                return;
            }
            QLog.w("NFT-PublicListTabCommonPart", 1, "[initTabs] current block tab info length <= 1.");
            return;
        }
        QLog.w("NFT-PublicListTabCommonPart", 1, "[initTabs] current block name length <= 1.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(int i3, int i16) {
        QLog.d("NFT-PublicListTabCommonPart", 1, "[registerBlockRedPointReceive] tabType: " + i3 + " | total: " + i16);
        O9(QFSPublicListTabCommonHelper.h(this.f91961f, i3), i16);
        this.E.put(Integer.valueOf(i3), Integer.valueOf(i16));
        N9(i3, i16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(Intent intent) {
        TabLayoutCompat tabLayoutCompat;
        QCircleInitBean b16 = QFSPublicListTabCommonHelper.b(intent);
        this.f91959d = b16;
        if (b16 == null) {
            QLog.w("NFT-PublicListTabCommonPart", 1, "[updateTargetPageToPosition] init bean should not be null.");
            return;
        }
        if (this.f91964m == null) {
            QLog.w("NFT-PublicListTabCommonPart", 1, "[updateTargetPageToPosition] view pager should not be null.");
            return;
        }
        int g16 = QFSPublicListTabCommonHelper.g(b16.getSchemeAttrs(), this.f91961f);
        QLog.d("NFT-PublicListTabCommonPart", 1, "[updateTargetPageToPosition] selectedTabPosition: " + g16);
        this.f91964m.setCurrentItem(g16, false);
        if (g16 == 0 && (tabLayoutCompat = this.f91962h) != null) {
            E9(tabLayoutCompat.y(0), null, 0);
        }
    }

    private void J9(Intent intent) {
        HashMap<String, String> schemeAttrs;
        QCircleInitBean b16 = QFSPublicListTabCommonHelper.b(intent);
        this.f91959d = b16;
        if (b16 == null) {
            schemeAttrs = null;
        } else {
            schemeAttrs = b16.getSchemeAttrs();
        }
        if (schemeAttrs != null && !schemeAttrs.isEmpty()) {
            Iterator<String> it = schemeAttrs.keySet().iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + "key=" + schemeAttrs + " | value: " + schemeAttrs.get(it.next());
            }
            QLog.e("NFT-PublicListTabCommonPart", 1, "[printSchemaParam] schema param: " + str);
        }
    }

    private void K9(BaseListBlock baseListBlock, int i3) {
        HashMap<String, String> schemeAttrs;
        if (!(baseListBlock instanceof QFSMessageSecondListBlock)) {
            return;
        }
        QFSMessageSecondListBlock qFSMessageSecondListBlock = (QFSMessageSecondListBlock) baseListBlock;
        QCircleInitBean qCircleInitBean = this.f91959d;
        if (qCircleInitBean == null) {
            schemeAttrs = null;
        } else {
            schemeAttrs = qCircleInitBean.getSchemeAttrs();
        }
        int c16 = QFSPublicListTabCommonHelper.c(QFSPublicListTabCommonHelper.g(schemeAttrs, this.f91961f), this.f91961f);
        this.G = c16;
        qFSMessageSecondListBlock.setCurrentSelectedType(c16);
        qFSMessageSecondListBlock.registerBlockRedPointReceive(new QFSMessageSecondListBlock.b() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.b
            @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock.b
            public final void a(int i16, int i17) {
                d.this.H9(i16, i17);
            }
        });
    }

    private void L9(View view, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && getActivity() != null && !TextUtils.isEmpty(QFSPublicListTabCommonHelper.a(getActivity().getIntent()))) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, charSequence.toString());
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setPageId(this.D, QFSPublicListTabCommonHelper.a(getActivity().getIntent()));
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
        }
    }

    private void M9(View view, QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo) {
        if (view != null && qQCircleFeedBase$StTabInfo != null && getActivity() != null && !TextUtils.isEmpty(QFSPublicListTabCommonHelper.a(getActivity().getIntent()))) {
            QLog.d("NFT-PublicListTabCommonPart", 1, "[reportDTTopTab] pgid: " + QFSPublicListTabCommonHelper.a(getActivity().getIntent()));
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, qQCircleFeedBase$StTabInfo.tabName.get());
            VideoReport.setPageId(this.D, QFSPublicListTabCommonHelper.a(getActivity().getIntent()));
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }
    }

    private void N9(int i3, int i16, boolean z16) {
        String str;
        if (getActivity() != null && getActivity().getIntent() != null && getActivity() != null && !TextUtils.isEmpty(QFSPublicListTabCommonHelper.a(getActivity().getIntent())) && i3 != 0 && i16 > 0) {
            if (z16 && this.F.containsKey(Integer.valueOf(i3)) && this.F.get(Integer.valueOf(i3)).booleanValue()) {
                return;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB_RED_DOT);
            buildElementParams.put("xsj_custom_pgid", QFSPublicListTabCommonHelper.a(getActivity().getIntent()));
            buildElementParams.put("xsj_reddot_number", Integer.valueOf(i16));
            buildElementParams.put("xsj_msg_entrance_name_new", Integer.valueOf(i3));
            if (z16) {
                str = "ev_xsj_abnormal_imp";
            } else {
                str = "ev_xsj_abnormal_clck";
            }
            VideoReport.setPageId(this.D, QFSPublicListTabCommonHelper.a(getActivity().getIntent()));
            VideoReport.reportEvent(str, buildElementParams);
            if (z16) {
                this.F.put(Integer.valueOf(i3), Boolean.TRUE);
            }
        }
    }

    private void O9(int i3, int i16) {
        List<h> list = this.f91960e;
        if (list == null) {
            QLog.e("NFT-PublicListTabCommonPart", 1, "[updatePositionTabRedPoint] tab view list should not be null.");
            return;
        }
        h hVar = (h) RFSafeListUtils.get(list, i3);
        if (hVar == null) {
            QLog.e("NFT-PublicListTabCommonPart", 1, "[updatePositionTabRedPoint] tab view should not be null.");
            return;
        }
        if (this.f91964m.getCurrentItem() == i3) {
            hVar.d();
        } else if (i16 > 0) {
            hVar.l(i16);
        } else {
            hVar.d();
        }
    }

    private void P9(h hVar, boolean z16) {
        if (hVar != null && hVar.b() != null) {
            hVar.b().setSelected(z16);
        } else {
            QLog.d("NFT-PublicListTabCommonPart", 1, "[updateTabViewSelected] tab view or tab text view should not be null.");
        }
    }

    private void Q9(final Intent intent) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.I9(intent);
            }
        });
    }

    public String C9(int i3, String str) {
        PBStringField pBStringField;
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = (QQCircleFeedBase$StTabInfo) RFSafeListUtils.get(this.f91961f, i3);
        if (qQCircleFeedBase$StTabInfo != null && (pBStringField = qQCircleFeedBase$StTabInfo.tabName) != null && !TextUtils.isEmpty(pBStringField.get())) {
            return qQCircleFeedBase$StTabInfo.tabName.get();
        }
        return str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals(str, "public_list_tab_info")) {
            TabLayoutCompat tabLayoutCompat = this.f91962h;
            if (tabLayoutCompat == null) {
                return null;
            }
            return RFSafeListUtils.get(this.f91961f, tabLayoutCompat.x());
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        F9();
        this.f91964m = (MultiTabViewPager) view.findViewById(R.id.f12031798);
        this.D = (FrameLayout) view.findViewById(R.id.v8v);
        G9(view);
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            K9(this.C.get(i3), i3);
        }
    }
}
