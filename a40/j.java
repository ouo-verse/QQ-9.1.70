package a40;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends RecyclerView.Adapter<b> {
    private Context C;
    private RecyclerView D;
    private a E;
    private String F;
    private String G;

    /* renamed from: m, reason: collision with root package name */
    private List<e30.b> f25479m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public RoundCornerImageView E;
        public QCircleAsyncTextView F;
        public TextView G;
        public TextView H;
        public TextView I;

        public b(@NonNull View view) {
            super(view);
            this.E = (RoundCornerImageView) view.findViewById(R.id.f33740x_);
            this.F = (QCircleAsyncTextView) view.findViewById(R.id.f33750xa);
            this.G = (TextView) view.findViewById(R.id.f33690x5);
            this.H = (TextView) view.findViewById(R.id.f33700x6);
            this.I = (TextView) view.findViewById(R.id.f33720x8);
            this.F.setSpecialClickAreaColor(QFSQUIUtilsKt.d(view.getContext(), R.color.qui_common_text_primary), true);
        }
    }

    public j(Context context) {
        q0(context);
    }

    private void m0(RoundCornerImageView roundCornerImageView, e30.b bVar) {
        String str;
        int dip2px;
        int dip2px2;
        if (bVar.g().cover == null) {
            return;
        }
        String str2 = bVar.g().f398449id.get();
        roundCornerImageView.setCorner(ViewUtils.dpToPx(4.0f));
        String str3 = bVar.g().cover.picUrl.get();
        if (str3.isEmpty()) {
            roundCornerImageView.setImageDrawable(p0());
            return;
        }
        if (!(roundCornerImageView.getTag(R.id.f33740x_) instanceof String)) {
            str = "";
        } else {
            str = (String) roundCornerImageView.getTag(R.id.f33740x_);
        }
        roundCornerImageView.setTag(R.id.f33740x_, str2);
        if (!str.equals(str2) || "".equals(str3)) {
            if (roundCornerImageView.getLayoutParams() != null) {
                dip2px = roundCornerImageView.getLayoutParams().width;
            } else {
                dip2px = ViewUtils.dip2px(56.0f);
            }
            if (roundCornerImageView.getLayoutParams() != null) {
                dip2px2 = roundCornerImageView.getLayoutParams().height;
            } else {
                dip2px2 = ViewUtils.dip2px(74.0f);
            }
            Option obtain = Option.obtain();
            obtain.setUrl(str3).setTargetView(roundCornerImageView).setPredecode(true).setFailDrawable(p0()).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setRequestWidth(dip2px).setRequestHeight(dip2px2);
            QCircleFeedPicLoader.g().loadImage(obtain);
        }
    }

    private void n0(View view, e30.b bVar) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CP_WORKS);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", bVar.g().f398449id.get());
        String str = this.G;
        if (str != null && !str.isEmpty()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, this.G);
        }
        String str2 = this.F;
        if (str2 != null && !str2.isEmpty()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_SOURCE, this.F);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_CP_WORKS + "_" + bVar.g().f398449id.get());
    }

    private void o0() {
        RecyclerView recyclerView = this.D;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setItemAnimator(null);
    }

    private Drawable p0() {
        return com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw);
    }

    private void q0(Context context) {
        this.C = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(e30.b bVar, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.E;
        if (aVar != null) {
            aVar.a(bVar.g(), i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(e30.b bVar, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.E;
        if (aVar != null) {
            aVar.a(bVar.g(), i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(e30.b bVar, int i3, String str) {
        a aVar = this.E;
        if (aVar != null) {
            aVar.a(bVar.g(), i3);
        }
    }

    private void w0(QCircleAsyncTextView qCircleAsyncTextView, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo;
        String str = feedCloudMeta$StFeed.content.get();
        if (feedCloudMeta$StFeed.album_infos.get() != null && feedCloudMeta$StFeed.album_infos.get().size() > 0) {
            feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed.album_infos.get().get(0);
        } else {
            feedCloudMeta$FeedAlbumInfo = null;
        }
        if (feedCloudMeta$FeedAlbumInfo != null) {
            i3 = feedCloudMeta$FeedAlbumInfo.feed_serial_number.get();
        }
        if (TextUtils.isEmpty(str)) {
            qCircleAsyncTextView.setText(this.C.getResources().getString(R.string.f195764fh, Integer.valueOf(i3)), false);
            return;
        }
        String string = this.C.getResources().getString(R.string.f195754fg, Integer.valueOf(i3), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf("\uff5c");
        int i16 = indexOf + 1;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.C.getResources().getColor(R.color.qvideo_skin_color_text_secondary)), indexOf, i16, 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), indexOf, i16, 33);
        qCircleAsyncTextView.setText((CharSequence) spannableStringBuilder, false);
    }

    public List<e30.b> getData() {
        return this.f25479m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<e30.b> list = this.f25479m;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void l0(List<e30.b> list) {
        if (list != null) {
            int size = this.f25479m.size();
            this.f25479m.clear();
            this.f25479m.addAll(list);
            int size2 = this.f25479m.size();
            if (!this.D.isComputingLayout()) {
                notifyItemRangeInserted(size, size2 - size);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.D = recyclerView;
    }

    public void setData(List<e30.b> list) {
        if (list != null) {
            this.f25479m.clear();
            this.f25479m.addAll(list);
            if (!this.D.isComputingLayout()) {
                o0();
                notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, final int i3) {
        final e30.b bVar2 = this.f25479m.get(i3);
        if (bVar2 != null && bVar2.g() != null) {
            m0(bVar.E, bVar2);
            int i16 = bVar2.g().video.duration.get();
            if (i16 > 0) {
                bVar.G.setVisibility(0);
                bVar.G.setText(com.tencent.biz.qqcircle.utils.g.a(i16));
            } else {
                bVar.G.setVisibility(8);
            }
            bVar.I.setText(c40.a.e(bVar2.g()));
            bVar.H.setText(r.f(bVar2.g().likeInfo.count.get()));
            w0(bVar.F, bVar2.g(), i3);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.F.setLineHeight(cx.a(22.0f));
            }
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: a40.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.this.r0(bVar2, i3, view);
                }
            });
            bVar.F.setOnClickListener(new View.OnClickListener() { // from class: a40.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.this.s0(bVar2, i3, view);
                }
            });
            bVar.F.setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: a40.i
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
                public final void onClick(String str) {
                    j.this.t0(bVar2, i3, str);
                }
            });
            n0(bVar.itemView, bVar2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(this.C).inflate(R.layout.gle, viewGroup, false));
    }

    public void x0(a aVar) {
        this.E = aVar;
    }

    public void y0(String str, String str2) {
        this.F = str;
        this.G = str2;
    }
}
