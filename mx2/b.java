package mx2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import mx2.b;
import mx2.d;
import org.light.utils.CollectionUtils;
import tvideo.TVideoChannelList$VideoChannelData;
import zt2.l;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends d {
    private a H;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends RecyclerView.ViewHolder {
        private final l.a E;
        View F;

        public a(@NonNull View view) {
            super(view);
            this.F = view;
            ImageView imageView = (ImageView) view.findViewById(R.id.f164551a35);
            l.a aVar = new l.a(imageView);
            this.E = aVar;
            l.e(imageView);
            zt2.e.f453199a.w(aVar);
            o(view, "myinfo");
            view.setOnClickListener(new View.OnClickListener() { // from class: mx2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.a.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            n(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        private void n(View view) {
            l.c(this.F.getContext(), false);
            VideoReport.reportEvent("clck", view, null);
        }

        private void o(View view, String str) {
            VideoReport.setElementParams(view, gy2.c.g());
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementId(view, str);
        }
    }

    public b(RecyclerView recyclerView) {
        super(recyclerView);
    }

    private TVideoChannelList$VideoChannelData p0() {
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = new TVideoChannelList$VideoChannelData();
        tVideoChannelList$VideoChannelData.channel_id.set(-1);
        tVideoChannelList$VideoChannelData.channel_title.set("\u6211\u7684");
        return tVideoChannelList$VideoChannelData;
    }

    @Override // mx2.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        return 0;
    }

    @Override // mx2.d
    protected int k0() {
        return 1;
    }

    @Override // mx2.d
    protected void m0(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, int i3) {
        VideoReport.reportEvent("imp", this.C, j0(tVideoChannelList$VideoChannelData, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168702gh2, viewGroup, false));
            this.H = aVar;
            return aVar;
        }
        return new d.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168700gh0, viewGroup, false));
    }

    @Override // mx2.d
    public void setData(List<TVideoChannelList$VideoChannelData> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        this.f417747m.clear();
        this.f417747m.add(p0());
        this.f417747m.addAll(list);
        ox2.b.e().b(list);
        notifyDataSetChanged();
    }
}
