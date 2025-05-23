package ey2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import tvideo.EpisodeListStyle;
import tvideo.Video;
import tvideo.VideoPlot;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Video C;
    private final boolean D;
    private final a E;

    /* renamed from: m, reason: collision with root package name */
    private final List<VideoPlot> f397404m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        int J();

        void k(VideoPlot videoPlot);
    }

    public n(Video video, boolean z16, a aVar) {
        this.C = video;
        this.D = z16;
        this.E = aVar;
    }

    private View i0(ViewGroup viewGroup) {
        int i3;
        a aVar = this.E;
        if (aVar != null) {
            i3 = aVar.J();
        } else {
            i3 = 0;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gge, viewGroup, false);
        if (i3 == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ggg, viewGroup, false);
        }
        return inflate;
    }

    private RecyclerView.ViewHolder j0(ViewGroup viewGroup) {
        return new b(i0(viewGroup), this.C, this.E);
    }

    private View k0(ViewGroup viewGroup) {
        int i3;
        a aVar = this.E;
        if (aVar != null) {
            i3 = aVar.J();
        } else {
            i3 = 0;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ggf, viewGroup, false);
        if (i3 == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ggh, viewGroup, false);
        }
        return inflate;
    }

    private RecyclerView.ViewHolder m0(ViewGroup viewGroup) {
        return new d(k0(viewGroup), this.C, this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f397404m.size();
    }

    public List<VideoPlot> l0() {
        return this.f397404m;
    }

    public void n0(Video video) {
        this.C = video;
    }

    public void o0(List<VideoPlot> list) {
        this.f397404m.clear();
        this.f397404m.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        VideoPlot videoPlot = this.f397404m.get(i3);
        if (videoPlot == null) {
            return;
        }
        if (viewHolder instanceof d) {
            ((d) viewHolder).m(videoPlot);
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).m(videoPlot);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (this.D) {
            return j0(viewGroup);
        }
        return m0(viewGroup);
    }
}
