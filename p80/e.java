package p80;

import android.util.Size;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.banner.k;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectMaskImageView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends k<a> {
    private final List<FeedCloudMeta$StImage> G = new ArrayList();
    private ImageView H;
    private Size I;

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        int g16;
        int i16;
        Size size = this.I;
        if (size != null) {
            g16 = size.getWidth();
            i16 = this.I.getHeight();
        } else {
            g16 = cx.g() - 24;
            i16 = (int) (g16 / 2.84f);
        }
        Option predecode = Option.obtain().setTargetView(aVar.E).setUrl(this.G.get(i3).picUrl.get()).setRequestWidth(g16).setRequestHeight(i16).setLoadingDrawableId(R.drawable.trans).setPredecode(true);
        predecode.setSupportRecycler(true);
        predecode.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        q50.b.e().q(predecode, false);
        QCircleFeedPicLoader.g().loadImage(predecode);
        this.H = aVar.E;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSPressEffectMaskImageView qFSPressEffectMaskImageView = new QFSPressEffectMaskImageView(viewGroup.getContext());
        qFSPressEffectMaskImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        qFSPressEffectMaskImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(qFSPressEffectMaskImageView);
    }

    public void v0(Collection<FeedCloudMeta$StImage> collection) {
        this.G.clear();
        if (collection != null && !collection.isEmpty()) {
            this.G.addAll(collection);
        } else {
            notifyDataSetChanged();
        }
    }

    public void w0(Size size) {
        this.I = size;
    }
}
