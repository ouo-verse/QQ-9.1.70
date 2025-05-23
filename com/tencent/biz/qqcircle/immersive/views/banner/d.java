package com.tencent.biz.qqcircle.immersive.views.banner;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.helpers.u;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends k<c> {
    private QCircleMultiTouchImageView G;
    private final boolean H;
    private final boolean I;
    private final boolean J;
    private final boolean K;
    private final List<QFSCommentPicInfo> L = new ArrayList();
    private b M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f90749d;

        a(c cVar) {
            this.f90749d = cVar;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_DOWNLOADING) {
                this.f90749d.I.setVisibility(0);
                ImageView imageView = this.f90749d.I;
                imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView.getContext(), 2));
            } else if (loadState == LoadState.STATE_SUCCESS) {
                this.f90749d.I.setVisibility(8);
                if (option.getAnimatable() instanceof r01.c) {
                    ((r01.c) option.getAnimatable()).setLoopCount(65535);
                    ((r01.c) option.getAnimatable()).start();
                }
            }
            if (loadState.isFinishError()) {
                QCircleToast.h(R.string.f184153l4, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void N0(int i3, QFSCommentPicInfo qFSCommentPicInfo);

        void Q5(int i3, QFSCommentPicInfo qFSCommentPicInfo);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        public final QCircleMultiTouchImageView E;
        public final ViewGroup F;
        public final ImageView G;
        public final TextView H;
        public final ImageView I;
        public final ViewGroup J;
        public final ViewGroup K;
        public final ViewGroup L;

        public c(@NonNull View view, boolean z16) {
            super(view);
            this.E = (QCircleMultiTouchImageView) view.findViewById(R.id.f360613j);
            this.F = (ViewGroup) view.findViewById(R.id.f360513i);
            this.H = (TextView) view.findViewById(R.id.f360313g);
            this.G = (ImageView) view.findViewById(R.id.f360413h);
            this.I = (ImageView) view.findViewById(R.id.f360713k);
            this.J = (ViewGroup) view.findViewById(R.id.f360213f);
            this.K = (ViewGroup) view.findViewById(R.id.f360113e);
            this.L = (ViewGroup) view.findViewById(R.id.f360013d);
        }

        public void l() {
            TextView textView = this.H;
            if (textView != null) {
                textView.setText(R.string.f1901741d);
                this.H.setAlpha(0.5f);
                this.H.setEnabled(false);
            }
        }
    }

    public d(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.H = z16;
        this.I = z17;
        this.J = z18;
        this.K = z19;
    }

    private void A0(c cVar, final int i3, final QFSCommentPicInfo qFSCommentPicInfo) {
        String favEmojiUrl = qFSCommentPicInfo.getFavEmojiUrl();
        if (ud2.a.f438849a.a() && !TextUtils.isEmpty(favEmojiUrl) && !RFWFileUtils.isLocalPath(favEmojiUrl)) {
            if (this.H) {
                if (!this.K) {
                    QLog.d("QFSCommentPicBannerAdapter", 1, "[initEmojiView] can not show add image icon");
                    cVar.J.setVisibility(8);
                    cVar.H.setVisibility(8);
                    return;
                } else {
                    cVar.H.setVisibility(0);
                    cVar.J.setVisibility(8);
                    cVar.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.this.B0(i3, qFSCommentPicInfo, view);
                        }
                    });
                    w0(cVar.H, qFSCommentPicInfo);
                    return;
                }
            }
            if (this.I) {
                cVar.H.setVisibility(8);
                cVar.J.setVisibility(0);
                H0(cVar, i3, qFSCommentPicInfo);
                I0(cVar, i3, qFSCommentPicInfo);
                return;
            }
            cVar.J.setVisibility(8);
            cVar.H.setVisibility(8);
            return;
        }
        QLog.d("QFSCommentPicBannerAdapter", 1, "[initEmojiView] emojiUrl=" + favEmojiUrl);
        cVar.H.setVisibility(8);
        cVar.J.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(int i3, QFSCommentPicInfo qFSCommentPicInfo, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSCommentPicBannerAdapter-FavEmoji") && (bVar = this.M) != null) {
            bVar.N0(i3, qFSCommentPicInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(int i3, QFSCommentPicInfo qFSCommentPicInfo, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSCommentPicBannerAdapter-downloadIcon") && (bVar = this.M) != null) {
            bVar.Q5(i3, qFSCommentPicInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(int i3, QFSCommentPicInfo qFSCommentPicInfo, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSCommentPicBannerAdapter-emojiIcon") && (bVar = this.M) != null) {
            bVar.N0(i3, qFSCommentPicInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void H0(c cVar, final int i3, final QFSCommentPicInfo qFSCommentPicInfo) {
        if (qFSCommentPicInfo.hasMaskPic() && this.J) {
            cVar.L.setVisibility(0);
            cVar.L.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.C0(i3, qFSCommentPicInfo, view);
                }
            });
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            VideoReport.setElementId(cVar.L, "em_xsj_save_button");
            VideoReport.setElementExposePolicy(cVar.L, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(cVar.L, ClickPolicy.REPORT_ALL);
            VideoReport.setElementParams(cVar.L, buildElementParams);
            return;
        }
        QLog.i("QFSCommentPicBannerAdapter", 1, "[tryShowDownloadIcon] no mask pic or cannot show icon, " + this.J);
        cVar.L.setVisibility(8);
    }

    private void I0(c cVar, final int i3, final QFSCommentPicInfo qFSCommentPicInfo) {
        if (TextUtils.isEmpty(qFSCommentPicInfo.getFavEmojiUrl())) {
            QLog.i("QFSCommentPicBannerAdapter", 1, "[tryShowEmojiIcon] no emoji url");
            cVar.K.setVisibility(8);
        } else {
            cVar.K.setVisibility(0);
            cVar.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.D0(i3, qFSCommentPicInfo, view);
                }
            });
            w0(cVar.K, qFSCommentPicInfo);
        }
    }

    private void w0(View view, QFSCommentPicInfo qFSCommentPicInfo) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (qFSCommentPicInfo.isEmojiPic()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, qFSCommentPicInfo.getExpressionSrcString());
        } else {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, "image");
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ADD_EMOJI_BUTTON);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private QFSCommentPicInfo z0(int i3) {
        if (i3 >= 0 && i3 < this.L.size()) {
            return this.L.get(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g9x, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new c(inflate, this.I);
    }

    public void F0(b bVar) {
        this.M = bVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        return this.L.size();
    }

    public void setData(List<QFSCommentPicInfo> list) {
        this.L.clear();
        if (list != null && list.size() > 0) {
            this.L.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void i0(c cVar, int i3) {
        ImageView imageView;
        int i16;
        QCircleMultiTouchImageView qCircleMultiTouchImageView;
        QFSCommentPicInfo z06 = z0(i3);
        if (z06 != null && z06.getImage() != null) {
            boolean z16 = this.H;
            if (z16) {
                imageView = cVar.G;
            } else {
                imageView = cVar.E;
            }
            ViewGroup viewGroup = cVar.F;
            int i17 = 0;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            viewGroup.setVisibility(i16);
            QCircleMultiTouchImageView qCircleMultiTouchImageView2 = cVar.E;
            if (this.H) {
                i17 = 8;
            }
            qCircleMultiTouchImageView2.setVisibility(i17);
            if (!this.H) {
                u.f84666a.b(imageView);
            }
            String str = z06.getImage().picUrl.get();
            LibraGroupKey libraGroupKey = new LibraGroupKey(str);
            libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(str).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw)).setLoadingDrawable(new ColorDrawable(cVar.itemView.getContext().getResources().getColor(R.color.black))).setRequestWidth(cx.g()).setRequestHeight(cx.f()).setGroupKey(libraGroupKey), new a(cVar));
            if (this.H) {
                qCircleMultiTouchImageView = null;
            } else {
                qCircleMultiTouchImageView = cVar.E;
            }
            this.G = qCircleMultiTouchImageView;
            A0(cVar, i3, z06);
        }
    }

    @Nullable
    public QCircleMultiTouchImageView y0() {
        return this.G;
    }
}
