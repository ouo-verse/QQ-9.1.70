package com.tencent.biz.qqcircle.immersive.views.banner;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends k<a> {
    private ArrayList<String> G;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView E;

        public a(@NonNull ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }
    }

    public j(ArrayList<String> arrayList) {
        new ArrayList();
        this.G = arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        ArrayList<String> arrayList = this.G;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        ArrayList<String> arrayList = this.G;
        if (arrayList != null && aVar.E != null && arrayList.size() > i3) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.G.get(i3)).setTargetView(aVar.E).setLoadingDrawable(new ColorDrawable(aVar.E.getContext().getResources().getColor(R.color.black))).setPredecode(true));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(imageView);
    }
}
