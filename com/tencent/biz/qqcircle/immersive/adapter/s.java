package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectMaskImageView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends com.tencent.biz.qqcircle.immersive.views.banner.k<a> {
    private List<QQCircleDitto$StItemInfo> G = new ArrayList();
    private ImageView H;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView E;

        public a(@NonNull ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        return this.G.size();
    }

    public void setData(List<QQCircleDitto$StItemInfo> list) {
        List<QQCircleDitto$StItemInfo> list2;
        if (list != null && (list2 = this.G) != null) {
            list2.clear();
            this.G.addAll(list);
            notifyDataSetChanged();
            return;
        }
        QLog.e("QFSMixFeedBannerAdapter", 1, "[setData] -> infos == null ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        if (this.G.size() > i3 && this.G.get(i3).images.size() >= 1 && aVar.E != null) {
            int g16 = cx.g() - 24;
            Option predecode = Option.obtain().setTargetView(aVar.E).setUrl(this.G.get(i3).images.get(0).picUrl.get()).setRequestWidth(g16).setRequestHeight((int) (g16 / 2.84f)).setLoadingDrawableId(R.drawable.trans).setPredecode(true);
            predecode.setSupportRecycler(true);
            predecode.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            q50.b.e().q(predecode, false);
            QCircleFeedPicLoader.g().loadImage(predecode);
            this.H = aVar.E;
            return;
        }
        QLog.e("QFSMixFeedBannerAdapter", 1, "[onBindViewHolder] -> mContainer == null ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSPressEffectMaskImageView qFSPressEffectMaskImageView = new QFSPressEffectMaskImageView(viewGroup.getContext());
        qFSPressEffectMaskImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        qFSPressEffectMaskImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        qFSPressEffectMaskImageView.setClickable(true);
        return new a(qFSPressEffectMaskImageView);
    }
}
