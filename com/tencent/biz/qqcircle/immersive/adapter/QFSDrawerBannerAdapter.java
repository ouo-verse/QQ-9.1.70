package com.tencent.biz.qqcircle.immersive.adapter;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectMaskImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import trpcprotocol.feedcloud.sidebar.Navbar;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDrawerBannerAdapter extends com.tencent.biz.qqcircle.immersive.views.banner.k<QFSFeedPicBannerVH> {
    private List<Navbar> G = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QFSFeedPicBannerVH extends RecyclerView.ViewHolder {
        private final FrameLayout E;
        private final ImageView F;
        private TextView G;
        private Navbar H;
        private int I;

        public QFSFeedPicBannerVH(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
            super(frameLayout);
            this.E = frameLayout;
            this.F = imageView;
        }

        private void o() {
            TextView textView = this.G;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }

        private void p() {
            if (this.G != null) {
                return;
            }
            TextView textView = new TextView(this.E.getContext());
            this.G = textView;
            textView.setTextColor(QFSQUIUtilsKt.d(this.E.getContext(), R.color.qui_common_text_secondary_light));
            this.G.setTextSize(1, 14.0f);
            this.G.setText(this.E.getContext().getResources().getString(R.string.f1910743t));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.E.addView(this.G, layoutParams);
        }

        private void q() {
            String str;
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_DRAWER_BANNER);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_item_index", Integer.valueOf(this.I + 1));
            Navbar navbar = this.H;
            if (navbar != null) {
                str = navbar.clientReportInfo;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                buildElementParams.put("xsj_task_id", str);
            } else {
                QLog.e("QFSDrawerBannerAdapter", 1, "[reportBannerItemImpDT] taskId is empty");
            }
            VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.E, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
            VideoReport.setElementParams(this.E, buildElementParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            p();
            TextView textView = this.G;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }

        public void n(Navbar navbar, int i3) {
            String str;
            this.H = navbar;
            this.I = i3;
            o();
            QCirclePicStateListener qCirclePicStateListener = new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.immersive.adapter.QFSDrawerBannerAdapter.QFSFeedPicBannerVH.1
                @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                public void onStateChange(LoadState loadState, Option option) {
                    super.onStateChange(loadState, option);
                    if (loadState.isFinishError()) {
                        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.adapter.QFSDrawerBannerAdapter.QFSFeedPicBannerVH.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QFSFeedPicBannerVH.this.r();
                            }
                        });
                    }
                }
            };
            Navbar navbar2 = this.H;
            if (navbar2 != null) {
                str = navbar2.picture;
            } else {
                str = "";
            }
            int width = this.F.getWidth();
            int height = this.F.getHeight();
            ColorDrawable a16 = com.tencent.biz.qqcircle.drawer.i.a(this.F.getContext());
            Option predecode = Option.obtain().setTargetView(this.F).setUrl(str).setRequestWidth(width).setRequestHeight(height).setLoadingDrawable(a16).setFailDrawable(a16).setPredecode(true);
            predecode.setSupportRecycler(true);
            predecode.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            q50.b.e().q(predecode, false);
            QCircleFeedPicLoader.g().loadImage(predecode, qCirclePicStateListener);
            q();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        List<Navbar> list = this.G;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<Navbar> list) {
        List<Navbar> list2;
        if (list != null && (list2 = this.G) != null) {
            list2.clear();
            this.G.addAll(list);
            notifyDataSetChanged();
            return;
        }
        QLog.e("QFSDrawerBannerAdapter", 1, "[setData] -> infos == null ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(QFSFeedPicBannerVH qFSFeedPicBannerVH, int i3) {
        List<Navbar> list = this.G;
        if (list == null) {
            return;
        }
        if (list.size() > i3 && !this.G.isEmpty() && qFSFeedPicBannerVH.E != null) {
            qFSFeedPicBannerVH.n(this.G.get(i3), i3);
        } else {
            QLog.e("QFSDrawerBannerAdapter", 1, "[childBindViewHolder] -> mNavbars or itemView == null or isEmpty ");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public QFSFeedPicBannerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSPressEffectMaskImageView qFSPressEffectMaskImageView = new QFSPressEffectMaskImageView(viewGroup.getContext());
        qFSPressEffectMaskImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        qFSPressEffectMaskImageView.setLayoutParams(layoutParams);
        qFSPressEffectMaskImageView.setClickable(true);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(qFSPressEffectMaskImageView);
        return new QFSFeedPicBannerVH(frameLayout, qFSPressEffectMaskImageView);
    }
}
