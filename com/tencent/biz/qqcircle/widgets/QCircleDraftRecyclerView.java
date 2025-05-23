package com.tencent.biz.qqcircle.widgets;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.utils.cv;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDraftRecyclerView {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f92971a;

    /* renamed from: b, reason: collision with root package name */
    private DraftAdapter f92972b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DraftAdapter extends RecyclerView.Adapter<DraftViewHolder> {
        public static final int G = ImmersiveUtils.getScreenWidth() / 3;
        public static final Drawable H = new ColorDrawable(Color.parseColor("#F5F5F5"));
        private a D;
        private View.OnClickListener E;

        /* renamed from: m, reason: collision with root package name */
        public List<DraftBean> f92973m = new ArrayList();
        private int C = 0;
        private boolean F = true;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public static class DraftViewHolder extends RecyclerView.ViewHolder {
            private final URLImageView E;
            private final ImageView F;
            private final TextView G;
            private final CheckBox H;

            public DraftViewHolder(View view) {
                super(view);
                this.G = (TextView) view.findViewById(R.id.f107456ag);
                this.H = (CheckBox) view.findViewById(R.id.tpc);
                this.E = (URLImageView) view.findViewById(R.id.dv5);
                this.F = (ImageView) view.findViewById(R.id.y2i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q(final ImageView imageView, String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Option obtain = Option.obtain();
                Option requestHeight = obtain.setUrl(str).setTargetView(imageView).setPredecode(true).setRequestWidth(DraftAdapter.G).setRequestHeight(imageView.getHeight());
                Drawable drawable = DraftAdapter.H;
                requestHeight.setLoadingDrawable(drawable).setFailedDrawable(drawable);
                QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.1
                    @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                    public void onStateChange(LoadState loadState, Option option) {
                        if (loadState == LoadState.STATE_SUCCESS) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView2 = imageView;
                                    if (imageView2 != null) {
                                        imageView2.setImageDrawable(bitmapDrawable);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DraftViewHolder f92978d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ DraftBean f92979e;

            a(DraftViewHolder draftViewHolder, DraftBean draftBean) {
                this.f92978d = draftViewHolder;
                this.f92979e = draftBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f92978d.H.setChecked(!this.f92979e.isSelected());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class b implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DraftBean f92981d;

            b(DraftBean draftBean) {
                this.f92981d = draftBean;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                this.f92981d.setSelected(z16);
                Iterator<DraftBean> it = DraftAdapter.this.f92973m.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (it.next().isSelected()) {
                        i3++;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QCircleDraftRecyclerView", 1, "onCheckedChanged isChecked: ", Boolean.valueOf(z16), ", selectCount: ", Integer.valueOf(i3));
                }
                DraftAdapter.this.D.f5(i3, DraftAdapter.this.f92973m.size());
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        }

        DraftAdapter() {
        }

        private void p0(List<String> list) {
            ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(HostDataTransUtils.getLongAccountUin(), list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List<DraftBean> list = this.f92973m;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void j0() {
            boolean z16 = false;
            for (DraftBean draftBean : this.f92973m) {
                if (draftBean.isSelected()) {
                    draftBean.setSelected(false);
                    z16 = true;
                }
            }
            if (z16) {
                notifyDataSetChanged();
            }
        }

        public void k0() {
            List<DraftBean> list = this.f92973m;
            if (list != null) {
                list.clear();
            }
        }

        public void l0(URLImageView uRLImageView, DraftBean draftBean, int i3) {
            VideoReport.setElementId(uRLImageView, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PRODUCT);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_CREATE_TIME, new SimpleDateFormat("yyyy/MM/dd").format(Long.valueOf(draftBean.getCreateTime())));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_ID, draftBean.getMissionId());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_DELETE_TIME, "");
            buildElementParams.put("dt_pgstp", Integer.valueOf(i3));
            buildElementParams.put("dt_ref_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_DRAFTBOX_PAGE);
            VideoReport.setElementParams(uRLImageView, buildElementParams);
            VideoReport.setElementClickPolicy(uRLImageView, ClickPolicy.REPORT_ALL);
        }

        public void m0(View view) {
            String str;
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String format = simpleDateFormat.format(new Date());
            for (DraftBean draftBean : this.f92973m) {
                if (draftBean.isSelected()) {
                    sb5.append(simpleDateFormat.format(Long.valueOf(draftBean.getCreateTime())));
                    sb5.append(",");
                    sb6.append(draftBean.getMissionId());
                    sb6.append(",");
                    sb7.append(format);
                    sb7.append(",");
                }
            }
            String str3 = "";
            if (sb5.length() <= 0) {
                str = "";
            } else {
                str = sb5.substring(0, sb5.length() - 1);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_CREATE_TIME, str);
            if (sb6.length() <= 0) {
                str2 = "";
            } else {
                str2 = sb6.substring(0, sb6.length() - 1);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_ID, str2);
            if (sb7.length() > 0) {
                str3 = sb7.substring(0, sb7.length() - 1);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_DELETE_TIME, str3);
            buildElementParams.put("xsj_eid", "em_xsj_delete_button");
            VideoReport.setElementId(view, "em_xsj_delete_button");
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.reportEvent("ev_xsj_camera_action", view, buildElementParams);
        }

        public void n0() {
            int size;
            Iterator<DraftBean> it = this.f92973m.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                DraftBean next = it.next();
                if (next.isSelected()) {
                    it.remove();
                    arrayList.add(next.getMissionId());
                }
            }
            if (this.C < arrayList.size()) {
                size = 0;
            } else {
                size = this.C - arrayList.size();
            }
            this.C = size;
            notifyDataSetChanged();
            if (this.f92973m.size() == 0) {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleClosePageEvent());
            }
            p0(arrayList);
        }

        public void o0(String str) {
            Iterator<DraftBean> it = this.f92973m.iterator();
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DraftBean next = it.next();
                if (next.getMissionId().equals(str)) {
                    it.remove();
                    arrayList.add(next.getMissionId());
                    break;
                }
            }
            notifyDataSetChanged();
            p0(arrayList);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull DraftViewHolder draftViewHolder, int i3) {
            int i16;
            if (QLog.isColorLevel()) {
                QLog.d("QCircleDraftRecyclerView", 1, "onBindViewHolder draftViewHolder: " + draftViewHolder);
            }
            DraftBean draftBean = this.f92973m.get(i3);
            draftViewHolder.q(draftViewHolder.E, draftBean.getCoverUrl());
            draftViewHolder.E.setTag(draftBean);
            ImageView imageView = draftViewHolder.F;
            int i17 = 0;
            if (draftBean.getMediaType() == 0) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            if (this.F) {
                draftViewHolder.E.setOnClickListener(this.E);
                l0(draftViewHolder.E, draftBean, i3);
            } else {
                draftViewHolder.E.setOnClickListener(new a(draftViewHolder, draftBean));
            }
            draftViewHolder.G.setText(cv.f(draftBean.getCreateTime(), "\u00b7"));
            draftViewHolder.H.setTag(Integer.valueOf(i3));
            CheckBox checkBox = draftViewHolder.H;
            if (!draftBean.isCanSelect()) {
                i17 = 8;
            }
            checkBox.setVisibility(i17);
            draftViewHolder.H.setChecked(draftBean.isSelected());
            draftViewHolder.H.setOnCheckedChangeListener(new b(draftBean));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public DraftViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new DraftViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168623g34, viewGroup, false));
        }

        public void s0() {
            boolean z16 = false;
            for (DraftBean draftBean : this.f92973m) {
                if (!draftBean.isSelected()) {
                    z16 = true;
                    draftBean.setSelected(true);
                }
            }
            if (z16) {
                notifyDataSetChanged();
            }
        }

        public void setData(List<DraftBean> list) {
            this.f92973m.clear();
            this.f92973m.addAll(list);
            notifyDataSetChanged();
        }

        public void t0(View.OnClickListener onClickListener) {
            this.E = onClickListener;
        }

        public void u0(boolean z16) {
            this.F = z16;
            notifyDataSetChanged();
        }

        public void v0(a aVar) {
            this.D = aVar;
        }

        public void w0(boolean z16) {
            Iterator<DraftBean> it = this.f92973m.iterator();
            while (it.hasNext()) {
                it.next().setCanSelect(z16);
            }
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void f5(int i3, int i16);
    }

    public void a(List<DraftBean> list) {
        DraftAdapter draftAdapter;
        if (list != null && !list.isEmpty() && (draftAdapter = this.f92972b) != null) {
            draftAdapter.setData(list);
        }
    }

    public void b() {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.j0();
        }
    }

    public void c() {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.k0();
            this.f92972b = null;
        }
    }

    public void d(View view) {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.m0(view);
        }
    }

    public void e() {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.n0();
        }
    }

    public void f(String str) {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.o0(str);
        }
    }

    public void g(@NonNull View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f30970ps);
        this.f92971a = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        DraftAdapter draftAdapter = new DraftAdapter();
        this.f92972b = draftAdapter;
        this.f92971a.setAdapter(draftAdapter);
        this.f92971a.setItemAnimator(new DefaultItemAnimator());
    }

    public void h() {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.s0();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.t0(onClickListener);
        }
    }

    public void j(boolean z16) {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.u0(z16);
        }
    }

    public void k(a aVar) {
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.v0(aVar);
        }
    }

    public void l(boolean z16) {
        j(!z16);
        DraftAdapter draftAdapter = this.f92972b;
        if (draftAdapter != null) {
            draftAdapter.w0(z16);
        }
    }
}
