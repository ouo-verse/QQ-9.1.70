package com.tencent.biz.qqcircle.adapter;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import feedcloud.FeedCloudMeta$StImageUrl;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ao extends RecyclerView.Adapter<d> {
    private FeedCloudMeta$StTagInfo C;
    private RecyclerView D;
    private final ArrayList<FeedCloudMeta$StFeedAbstract> E = new ArrayList<>();
    private View.OnClickListener F;
    private String G;

    /* renamed from: m, reason: collision with root package name */
    private Pair<Integer, Integer> f82635m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Comparator<FeedCloudMeta$StImageUrl> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl, FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl2) {
            return feedCloudMeta$StImageUrl.levelType.get() - feedCloudMeta$StImageUrl2.levelType.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ao.this.D != null) {
                QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
                qCirclePolymerizationBean.setTagInfo(ao.this.C);
                qCirclePolymerizationBean.setPolymerizationType(7);
                com.tencent.biz.qqcircle.launcher.c.j0(ao.this.D.getContext(), qCirclePolymerizationBean);
                ao.this.o0(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.right = cx.a(2.0f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder {
        private final SquareImageView E;

        public d(View view) {
            super(view);
            this.E = (SquareImageView) view.findViewById(R.id.f54242eo);
        }
    }

    private void l0(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = ((Integer) n0().first).intValue();
            layoutParams.height = ((Integer) n0().second).intValue();
            view.setLayoutParams(layoutParams);
        }
    }

    private View.OnClickListener m0() {
        View.OnClickListener onClickListener = this.F;
        if (onClickListener != null) {
            return onClickListener;
        }
        b bVar = new b();
        this.F = bVar;
        return bVar;
    }

    private Pair<Integer, Integer> n0() {
        Pair<Integer, Integer> pair = this.f82635m;
        if (pair != null) {
            return pair;
        }
        int screenWidth = (int) (((ImmersiveUtils.getScreenWidth() - (cx.a(2.0f) * 3)) - (cx.a(16.0f) * 2)) / 4.0f);
        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(screenWidth));
        this.f82635m = pair2;
        return pair2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(View view) {
        if (this.C == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_topic_id", this.C.tagId.get());
        hashMap.put("xsj_topic_name", this.C.tagName.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.G);
        ua0.i.k(view, "em_xsj_topic_item", hashMap, this.C.hashCode());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.E.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull d dVar, int i3) {
        if (i3 <= 3 && this.E.get(i3) != null) {
            l0(dVar.E);
            FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = this.E.get(i3);
            String str = feedCloudMeta$StFeedAbstract.pic.picUrl.get();
            List<FeedCloudMeta$StImageUrl> list = feedCloudMeta$StFeedAbstract.pic.vecImageUrl.get();
            if (RFSafeListUtils.getSize(list) > 0) {
                Collections.sort(list, new a());
                str = list.get(0).url.get();
            }
            String uniKeyFromUrl = QCircleFeedPicLoader.getUniKeyFromUrl(str);
            String str2 = (String) dVar.E.getTag(R.id.f54242eo);
            if (str != null && !TextUtils.isEmpty(uniKeyFromUrl) && !uniKeyFromUrl.equals(str2)) {
                dVar.E.setTag(R.id.f54242eo, uniKeyFromUrl);
                dVar.E.setScaleType(ImageView.ScaleType.CENTER_CROP);
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(dVar.E).setUrl(str).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setRequestHeight(((Integer) n0().first).intValue()).setRequestWidth(((Integer) n0().second).intValue()));
            }
            dVar.E.setOnClickListener(m0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gs_, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(d dVar) {
        super.onViewAttachedToWindow(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(d dVar) {
        super.onViewDetachedFromWindow(dVar);
    }

    public void t0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        this.C = feedCloudMeta$StTagInfo;
        List<FeedCloudMeta$StFeedAbstract> list = feedCloudMeta$StTagInfo.feedList.get();
        if (list != null && list.size() != 0) {
            this.E.clear();
            this.E.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void u0(RecyclerView recyclerView) {
        this.D = recyclerView;
    }

    public void v0(String str) {
        this.G = str;
    }
}
