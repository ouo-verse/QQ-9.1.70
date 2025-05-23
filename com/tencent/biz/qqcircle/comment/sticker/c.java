package com.tencent.biz.qqcircle.comment.sticker;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends RecyclerView.Adapter<C0857c> {
    private b C;
    private String D;
    private String E;

    /* renamed from: m, reason: collision with root package name */
    private final List<com.tencent.biz.qqcircle.comment.sticker.a> f83935m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f83936d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.comment.sticker.a f83937e;

        a(int i3, com.tencent.biz.qqcircle.comment.sticker.a aVar) {
            this.f83936d = i3;
            this.f83937e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.q0("ev_xsj_abnormal_clck", this.f83936d, this.f83937e.a());
            if (c.this.C != null) {
                c.this.C.a(this.f83936d, this.f83937e.a(), this.f83937e.f83934c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.sticker.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0857c extends RecyclerView.ViewHolder {
        public static final int G = cx.a(73.0f);
        private final RoundImageView E;
        private Animatable F;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.comment.sticker.c$c$a */
        /* loaded from: classes4.dex */
        public class a extends QCirclePicStateListener {
            a() {
            }

            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                if (!loadState.isFinishSuccess()) {
                    return;
                }
                C0857c.this.F = option.getAnimatable();
            }
        }

        public C0857c(View view) {
            super(view);
            this.E = (RoundImageView) view.findViewById(R.id.y7e);
        }

        public ImageView m() {
            return this.E;
        }

        public void o() {
            Animatable animatable = this.F;
            if (animatable != null && !animatable.isRunning()) {
                this.F.start();
            }
        }

        public void p(String str) {
            if (!TextUtils.isEmpty(str) && this.E != null) {
                Option url = Option.obtain().setUrl(str);
                int i3 = G;
                Option loadingDrawableColor = url.setRequestWidth(i3).setRequestHeight(i3).setTargetView(this.E).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(QFSQUIUtilsKt.c(this.E.getContext(), R.color.qui_common_fill_standard_secondary, 0.5f));
                loadingDrawableColor.setSupportRecycler(true);
                QCircleFeedPicLoader.g().loadImage(loadingDrawableColor, new a());
            }
        }

        public void q() {
            Animatable animatable = this.F;
            if (animatable != null && animatable.isRunning()) {
                this.F.stop();
            }
        }
    }

    private void m0(List<com.tencent.biz.qqcircle.comment.sticker.a> list) {
        if (list == null) {
            return;
        }
        Iterator<com.tencent.biz.qqcircle.comment.sticker.a> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().f83933b)) {
                QLog.e("QFSRecommendStickerAdapter", 1, "has empty sticker url. ");
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str, int i3, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_ASSOCIATE_EMOJI_PANEL);
        buildElementParams.put("xsj_item_index", Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_URL, str2);
        String str3 = this.D;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        buildElementParams.put("xsj_feed_id", str3);
        String str5 = this.E;
        if (str5 != null) {
            str4 = str5;
        }
        buildElementParams.put("xsj_custom_pgid", str4);
        VideoReport.reportEvent(str, buildElementParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f83935m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull C0857c c0857c, int i3) {
        com.tencent.biz.qqcircle.comment.sticker.a aVar = this.f83935m.get(i3);
        c0857c.p(aVar.a());
        q0("ev_xsj_abnormal_imp", i3, aVar.a());
        if (c0857c.m() == null) {
            return;
        }
        c0857c.m().setOnClickListener(new a(i3, aVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0857c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new C0857c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_8, viewGroup, false));
    }

    public void n0(String str) {
        this.E = str;
    }

    public void o0(String str) {
        this.D = str;
    }

    public void p0(b bVar) {
        this.C = bVar;
    }

    public void r0(List<com.tencent.biz.qqcircle.comment.sticker.a> list) {
        this.f83935m.clear();
        m0(list);
        this.f83935m.addAll(list);
        notifyDataSetChanged();
    }
}
