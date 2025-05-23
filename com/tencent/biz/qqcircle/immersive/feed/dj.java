package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dj extends com.tencent.biz.qqcircle.immersive.feed.b implements View.OnClickListener {
    private c70.b S;
    private Observer<Set<String>> T;
    private Observer<UIStateData<Boolean>> U;
    private com.tencent.biz.qqcircle.immersive.adapter.e V;
    private QCircleLoadingDialog W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f86100a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f86101b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f86102c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f86103d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Map<String, String> f86104e0 = new HashMap();

    /* renamed from: f0, reason: collision with root package name */
    private boolean f86105f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            boolean z16;
            int i3;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int dpToPx = ViewUtils.dpToPx(6.0f);
            int i16 = 0;
            if (childAdapterPosition % 2 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = dpToPx;
            }
            rect.left = i3;
            if (z16) {
                i16 = dpToPx;
            }
            rect.right = i16;
            rect.bottom = dpToPx * 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<dj> f86107a;

        /* renamed from: b, reason: collision with root package name */
        private final int f86108b;

        public b(dj djVar, int i3) {
            this.f86107a = new WeakReference<>(djVar);
            this.f86108b = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            dj djVar = this.f86107a.get();
            if (djVar != null && djVar.Z != null && djVar.S != null) {
                if (this.f86108b == 1) {
                    if (djVar.Z.isEnabled()) {
                        str2 = "normal";
                    } else {
                        str2 = "disable";
                    }
                    buildElementParams.put("xsj_status", str2);
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAG_NAME, djVar.s1(djVar.S.Z1()));
                buildElementParams.put("xsj_amount", Integer.valueOf(djVar.S.Z1().size()));
            }
            return buildElementParams;
        }
    }

    private String A1(boolean z16) {
        String str;
        int i3;
        Map<String, String> map = this.f86104e0;
        if (z16) {
            str = WinkDaTongReportConstant.ElementParamKey.BUTTON_NAME;
        } else {
            str = "button_disable_name";
        }
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            if (z16) {
                i3 = R.string.f19116442;
            } else {
                i3 = R.string.f19117443;
            }
            return com.tencent.biz.qqcircle.utils.h.a(i3);
        }
        return str2;
    }

    private void B1(boolean z16) {
        int i3;
        if (z16) {
            i3 = R.string.f19120446;
        } else {
            i3 = R.string.f1911343z;
        }
        QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(i3), 0);
        this.f86103d0 = false;
        t1();
        if (z16) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshTabEvent(6, true));
            u1("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_TAG_SUCCESS_TOAST);
        }
    }

    private void C1(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f44851qa);
        if (imageView == null) {
            return;
        }
        String url = QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg");
        if (TextUtils.isEmpty(url)) {
            RFWLog.i("QFSHobbyLabelPresenter", RFWLog.USR, "[initBg] -> bgUrl is empty");
            return;
        }
        Option loadingDrawableColor = Option.obtain().setUrl(url).setRequestWidth(ViewUtils.getScreenWidth()).setRequestHeight(ViewUtils.getScreenHeight()).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    private void D1(@NonNull View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f40381e8);
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new SafeGridLayoutManager(recyclerView.getContext(), 2));
        com.tencent.biz.qqcircle.immersive.adapter.e eVar = new com.tencent.biz.qqcircle.immersive.adapter.e();
        this.V = eVar;
        recyclerView.setAdapter(eVar);
        recyclerView.addItemDecoration(new a());
    }

    private void E1(@NonNull View view) {
        TextView textView = (TextView) view.findViewById(R.id.f40391e9);
        this.Z = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    private void F1(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f40401e_);
        this.f86101b0 = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
    }

    private void G1() {
        if (this.W == null) {
            this.W = new QCircleLoadingDialog(m0());
        }
        this.W.Y(true);
        this.W.X(new QCircleLoadingDialog.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.dg
            @Override // com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog.b
            public final void onClick() {
                dj.this.K1();
            }
        });
        this.W.S(com.tencent.biz.qqcircle.utils.h.a(R.string.f19114440));
        this.W.showDialog();
        u1("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_TAG_LOADING_TOAST);
    }

    private void H1() {
        this.S = (c70.b) A0(c70.b.class);
        this.T = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.feed.dh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dj.this.L1((Set) obj);
            }
        };
        this.U = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.feed.di
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dj.this.M1((UIStateData) obj);
            }
        };
    }

    private void I1() {
        UIStateData<Boolean> value;
        c70.b bVar = this.S;
        if (bVar != null && (value = bVar.W1().getValue()) != null) {
            value.setState(6);
            value.setData(false, null);
            this.S.W1().setValue(value);
        }
    }

    private boolean J1(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1() {
        u1("dt_clck", QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_TAG_LOADING_TOAST_CLOSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(Set set) {
        boolean z16;
        if (this.Z == null) {
            return;
        }
        boolean J1 = J1(set);
        if (J1 != this.Z.isEnabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f86105f0 = z16;
        this.Z.setEnabled(J1);
        this.Z.setText(A1(J1));
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(UIStateData uIStateData) {
        int state = uIStateData.getState();
        if (state != 1) {
            if (state != 2 && state != 3) {
                if (state == 4) {
                    B1(false);
                    return;
                }
                return;
            }
            B1(true);
            return;
        }
        this.f86103d0 = true;
    }

    private void N1() {
        if (this.f86102c0 != null) {
            String str = this.f86104e0.get("more_video");
            TextView textView = this.f86102c0;
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19115441);
            }
            textView.setText(str);
        }
    }

    private void O1() {
        c70.b bVar;
        TextView textView = this.Z;
        if (textView != null && (bVar = this.S) != null) {
            textView.setText(A1(J1(bVar.Z1())));
        }
    }

    private void P1() {
        if (this.f86100a0 != null) {
            String str = this.f86104e0.get("more_label_choose");
            TextView textView = this.f86100a0;
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19118444);
            }
            textView.setText(str);
        }
    }

    private void Q1() {
        if (this.Y != null) {
            String str = this.f86104e0.get("subtitle");
            TextView textView = this.Y;
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19119445);
            }
            textView.setText(str);
        }
    }

    private void R1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudCommon$Entry> list = feedCloudMeta$StFeed.feedTextInfo.get();
        if (list.size() == 0) {
            return;
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            this.f86104e0.put(feedCloudCommon$Entry.key.get(), feedCloudCommon$Entry.value.get());
        }
        S1();
        Q1();
        O1();
        P1();
        N1();
    }

    private void S1() {
        if (this.X != null) {
            String str = this.f86104e0.get("title");
            TextView textView = this.X;
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19121447);
            }
            textView.setText(str);
        }
    }

    private String r1() {
        String str = this.f86104e0.get("button_link");
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSHobbyLabelPresenter", 1, "[createJumpSelectMoreUrl] prefix url is empty. ");
            str = "https://m.xsj.qq.com/h5/personalized/index?_wv=1";
        }
        String s16 = s1(this.S.Z1());
        if (TextUtils.isEmpty(s16)) {
            return str;
        }
        String str2 = new String(Base64.encode(s16.getBytes(), 8));
        try {
            str2 = URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("QFSHobbyLabelPresenter", 1, e16, new Object[0]);
        }
        return str + "&selectedTags=" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s1(@NonNull Set<String> set) {
        if (set.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("|");
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }

    private void t1() {
        QCircleLoadingDialog qCircleLoadingDialog = this.W;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.W.dismiss();
        }
    }

    private void u1(String str, String str2) {
        View view = new View(m0());
        VideoReport.setElementId(view, str2);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str2);
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_explore_page");
        VideoReport.setLogicParent(view, this.I);
        VideoReport.reportEvent(str, view, buildElementParams);
    }

    private void v1() {
        w1();
        y1();
    }

    private void w1() {
        TextView textView = this.Z;
        if (textView == null && this.S != null) {
            return;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_TAG_SUBMIT);
        VideoReport.setEventDynamicParams(this.Z, new b(this, 1));
    }

    private void x1() {
        TextView textView;
        String str;
        if (this.f86105f0 && (textView = this.Z) != null) {
            this.f86105f0 = false;
            VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_TAG_SUBMIT);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.Z.isEnabled()) {
                str = "normal";
            } else {
                str = "disable";
            }
            buildElementParams.put("xsj_status", str);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAG_NAME, s1(this.S.Z1()));
            buildElementParams.put("xsj_amount", Integer.valueOf(this.S.Z1().size()));
            VideoReport.reportEvent("ev_xsj_abnormal_imp", this.Z, buildElementParams);
        }
    }

    private void y1() {
        LinearLayout linearLayout = this.f86101b0;
        if (linearLayout != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_USER_INTEREST_TAG_MORE);
            VideoReport.setEventDynamicParams(this.f86101b0, new b(this, 2));
            VideoReport.setElementExposePolicy(this.f86101b0, ExposurePolicy.REPORT_NONE);
        }
    }

    private List<QQCircleDitto$StItemInfo> z1(QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew) {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer;
        if (qQCircleDitto$StCircleDittoDataNew != null && (qQCircleDitto$StItemContainer = qQCircleDitto$StCircleDittoDataNew.itemContainter) != null) {
            return qQCircleDitto$StItemContainer.items.get();
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.X = (TextView) view.findViewById(R.id.f40431ec);
        this.Y = (TextView) view.findViewById(R.id.f40421eb);
        this.f86100a0 = (TextView) view.findViewById(R.id.f40411ea);
        this.f86102c0 = (TextView) view.findViewById(R.id.f40371e7);
        E1(view);
        F1(view);
        D1(view);
        C1(view);
        H1();
        v1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        R1(feedCloudMeta$StFeed);
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()));
        com.tencent.biz.qqcircle.immersive.adapter.e eVar = this.V;
        if (eVar != null) {
            eVar.setDatas(z1(qQCircleDitto$StCircleDittoDataNew));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (!fb0.a.b("QFSHobbyLabelPresenter" + id5, 500L)) {
            if (id5 == R.id.f40391e9) {
                if (this.f86103d0) {
                    QLog.d("QFSHobbyLabelPresenter", 1, "request loading");
                } else {
                    G1();
                    this.S.b2();
                }
            } else if (id5 == R.id.f40401e_) {
                if (this.f86103d0) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19114440), 0);
                } else {
                    com.tencent.biz.qqcircle.launcher.c.g(m0(), r1());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        c70.b bVar = this.S;
        if (bVar != null) {
            bVar.X1().observeForever(this.T);
            this.S.W1().observeForever(this.U);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        c70.b bVar = this.S;
        if (bVar != null) {
            bVar.X1().removeObserver(this.T);
            this.S.W1().removeObserver(this.U);
        }
        I1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSHobbyLabelPresenter";
    }
}
