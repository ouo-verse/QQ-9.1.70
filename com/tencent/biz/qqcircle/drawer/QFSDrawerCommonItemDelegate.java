package com.tencent.biz.qqcircle.drawer;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import trpcprotocol.feedcloud.sidebar.Drawer;
import trpcprotocol.feedcloud.sidebar.DrawerType;
import trpcprotocol.feedcloud.sidebar.JumpInfo;
import trpcprotocol.feedcloud.sidebar.RedInfo;
import trpcprotocol.feedcloud.sidebar.RedType;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDrawerCommonItemDelegate extends AbsListItemAdapterDelegate<f, f, QFSDrawerCommonItemViewHolder> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QFSDrawerCommonItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView E;
        TextView F;
        TextView G;
        ImageView H;
        ImageView I;
        DragTextView J;
        int K;
        f L;
        private String M;

        public QFSDrawerCommonItemViewHolder(@NonNull View view) {
            super(view);
            this.M = "none";
            this.E = (ImageView) view.findViewById(R.id.f367115a);
            this.F = (TextView) view.findViewById(R.id.f3697160);
            this.G = (TextView) view.findViewById(R.id.f369615z);
            this.I = (ImageView) view.findViewById(R.id.f369315w);
            this.J = (DragTextView) view.findViewById(R.id.f368715q);
            this.H = (ImageView) view.findViewById(R.id.f368915s);
            view.setOnClickListener(this);
        }

        private void o() {
            f fVar = this.L;
            if (fVar != null) {
                fVar.g(true);
            }
            this.I.setVisibility(8);
            this.J.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p() {
            this.M = "none";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Object> q() {
            Drawer drawer;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            f fVar = this.L;
            if (fVar != null) {
                drawer = fVar.a();
            } else {
                drawer = null;
            }
            if (drawer != null) {
                buildElementParams.put("xsj_item_name", drawer.title);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, this.M);
            }
            return buildElementParams;
        }

        private String r() {
            RedInfo redInfo;
            f fVar = this.L;
            if (fVar != null) {
                redInfo = fVar.e();
            } else {
                redInfo = null;
            }
            if (redInfo == null) {
                return "none";
            }
            RedType redType = redInfo.redType;
            if (redType == RedType.RED_TYPE_SMALL) {
                return "dot";
            }
            if (redType == RedType.RED_TYPE_NUMBER) {
                return "number";
            }
            if (redType != RedType.RED_TYPE_TEXT) {
                return "none";
            }
            return QCircleDaTongConstant.ElementParamValue.OPERATION;
        }

        private void s(View view) {
            JumpInfo jumpInfo;
            if (view == null) {
                QLog.e("QFSDrawerCommonItemViewHolder", 1, "[handleItemClick] view is null");
                return;
            }
            f fVar = this.L;
            if (fVar != null) {
                jumpInfo = fVar.c();
            } else {
                jumpInfo = null;
            }
            if (jumpInfo != null && !TextUtils.isEmpty(jumpInfo.link)) {
                if (fb0.a.b("QFSDrawerCommonItemViewHolder_handleItemClick", 500L)) {
                    return;
                }
                if (this.L.a().f437281id == 14) {
                    k.a().j(QCircleCommonUtil.getCurrentAccount() + "_sp_key_drawer_find_friend_clicked", true);
                }
                com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), jumpInfo.link);
                o();
                return;
            }
            QLog.e("QFSDrawerCommonItemViewHolder", 1, "[handleItemClick] jump link is empty");
        }

        private void t() {
            Drawer drawer;
            VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_FUNCTION_ENTRANCE);
            f fVar = this.L;
            if (fVar != null) {
                drawer = fVar.a();
            } else {
                drawer = null;
            }
            if (drawer != null) {
                VideoReport.setElementReuseIdentifier(this.itemView, drawer.f437281id + "");
            }
            VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.itemView, EndExposurePolicy.REPORT_ALL);
            VideoReport.setEventDynamicParams(this.itemView, new a(this));
        }

        private void u() {
            Drawer drawer;
            f fVar = this.L;
            if (fVar != null) {
                drawer = fVar.a();
            } else {
                drawer = null;
            }
            if (drawer == null) {
                QLog.e("QFSDrawerCommonItemViewHolder", 1, "[updateLeftIcon] drawer is null");
                return;
            }
            QCirclePicStateListener qCirclePicStateListener = new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.drawer.QFSDrawerCommonItemDelegate.QFSDrawerCommonItemViewHolder.1
                @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                public void onStateChange(LoadState loadState, final Option option) {
                    super.onStateChange(loadState, option);
                    if (loadState.isFinishSuccess()) {
                        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.drawer.QFSDrawerCommonItemDelegate.QFSDrawerCommonItemViewHolder.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView imageView = QFSDrawerCommonItemViewHolder.this.E;
                                if (imageView != null && imageView.getContext() != null) {
                                    QFSDrawerCommonItemViewHolder.this.E.setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                                    ImageView imageView2 = QFSDrawerCommonItemViewHolder.this.E;
                                    imageView2.setColorFilter(QFSQUIUtilsKt.d(imageView2.getContext(), R.color.qui_common_icon_primary));
                                }
                            }
                        });
                    }
                }
            };
            ColorDrawable a16 = i.a(this.E.getContext());
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.E).setUrl(drawer.icon).setLoadingDrawable(a16).setFailDrawable(a16), qCirclePicStateListener);
        }

        private void v() {
            RedInfo redInfo;
            boolean z16;
            f fVar = this.L;
            if (fVar != null) {
                redInfo = fVar.e();
            } else {
                redInfo = null;
            }
            f fVar2 = this.L;
            if (fVar2 != null && fVar2.f()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (redInfo != null && !z16) {
                RedType redType = redInfo.redType;
                QLog.d("QFSDrawerCommonItemViewHolder", 1, "[updateRed] pos:" + this.K + ", redType:" + redType + ", num:" + redInfo.num + ", text:" + redInfo.text);
                if (redType == RedType.RED_TYPE_SMALL) {
                    this.I.setVisibility(0);
                    this.J.setVisibility(8);
                    return;
                }
                if (redType == RedType.RED_TYPE_NUMBER) {
                    this.I.setVisibility(8);
                    this.J.setVisibility(0);
                    this.J.setText(HostChatUtils.getMaxUnReadCountText(redInfo.num));
                    return;
                } else if (redType == RedType.RED_TYPE_TEXT) {
                    this.I.setVisibility(8);
                    this.J.setVisibility(0);
                    this.J.setText(redInfo.text);
                    return;
                } else {
                    this.I.setVisibility(8);
                    this.J.setVisibility(8);
                    return;
                }
            }
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            if (z16) {
                QLog.d("QFSDrawerCommonItemViewHolder", 1, "[updateRed] has clicked red point pos:" + this.K);
            }
        }

        private void w() {
            Drawer drawer;
            f fVar = this.L;
            if (fVar != null) {
                drawer = fVar.a();
            } else {
                drawer = null;
            }
            if (drawer == null) {
                QLog.e("QFSDrawerCommonItemViewHolder", 1, "[updateTitle] drawer is null");
            } else {
                this.F.setText(drawer.title);
                this.G.setText(drawer.subTitle);
            }
        }

        public void n(f fVar, int i3) {
            this.K = i3;
            this.L = fVar;
            if (fVar != null && fVar.a() != null) {
                u();
                w();
                v();
                this.M = r();
                t();
                return;
            }
            QLog.e("QFSDrawerCommonItemViewHolder", 1, "[bindData] mItemInfo == null, pos:" + i3);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                s(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSDrawerCommonItemViewHolder> f84381a;

        public a(QFSDrawerCommonItemViewHolder qFSDrawerCommonItemViewHolder) {
            this.f84381a = new WeakReference<>(qFSDrawerCommonItemViewHolder);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            QFSDrawerCommonItemViewHolder qFSDrawerCommonItemViewHolder = this.f84381a.get();
            if (qFSDrawerCommonItemViewHolder != null) {
                Map<String, Object> q16 = qFSDrawerCommonItemViewHolder.q();
                if (TextUtils.equals("clck", str)) {
                    qFSDrawerCommonItemViewHolder.p();
                }
                return q16;
            }
            return new QCircleDTParamBuilder().buildElementParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull f fVar, @NonNull List<f> list, int i3) {
        if (fVar.b() == DrawerType.DRAWER_TYPE_COMMON) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull f fVar, @NonNull QFSDrawerCommonItemViewHolder qFSDrawerCommonItemViewHolder, int i3, @NonNull List<Object> list) {
        qFSDrawerCommonItemViewHolder.n(fVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QFSDrawerCommonItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new QFSDrawerCommonItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_p, viewGroup, false));
    }
}
