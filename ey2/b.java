package ey2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import ey2.n;
import java.util.List;
import java.util.Map;
import tvideo.MarkLabel;
import tvideo.MarkLabelList;
import tvideo.MarkLabelPosition;
import tvideo.MarkLabelType;
import tvideo.Video;
import tvideo.VideoPlot;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends RecyclerView.ViewHolder {
    private final View E;
    private final TextView F;
    private final ImageView G;
    private final Video H;
    private final n.a I;

    public b(@NonNull View view, Video video, n.a aVar) {
        super(view);
        this.F = (TextView) view.findViewById(R.id.f107776bb);
        this.G = (ImageView) view.findViewById(R.id.xds);
        this.E = view.findViewById(R.id.mfe);
        this.I = aVar;
        this.H = video;
    }

    private void o() {
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(VideoPlot videoPlot, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n.a aVar = this.I;
        if (aVar != null) {
            aVar.k(videoPlot);
        }
        VideoReport.reportEvent("clck", this.F, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q(VideoPlot videoPlot) {
        Map<String, Object> h16 = gy2.c.h("episode_float");
        h16.put("episode_cid", videoPlot.video_base_info.cid);
        h16.put("episode_vid", videoPlot.video_base_info.vid);
        VideoReport.setElementParams(this.F, h16);
        VideoReport.setElementExposePolicy(this.F, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.F, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.F, "episode_slct");
    }

    private void r(VideoPlot videoPlot) {
        List<MarkLabel> list;
        Map<Integer, MarkLabelList> map = videoPlot.mark_label_list_map;
        if (map == null) {
            o();
            return;
        }
        MarkLabelList markLabelList = map.get(0);
        if (markLabelList != null && (list = markLabelList.mark_label_list) != null && list.size() >= 1) {
            List<MarkLabel> list2 = markLabelList.mark_label_list;
            boolean z16 = false;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                MarkLabel markLabel = list2.get(i3);
                if (markLabel != null && markLabel.mark_label_type == MarkLabelType.MARK_LABEL_TYPE_IMAGE && markLabel.position == MarkLabelPosition.MARK_LABEL_POSITION_RIGHT_TOP.getValue()) {
                    s(markLabel);
                    z16 = true;
                }
            }
            if (!z16) {
                o();
                return;
            }
            return;
        }
        o();
    }

    private void s(MarkLabel markLabel) {
        Option targetView = Option.obtain().setUrl(markLabel.mark_image_url).setTargetView(this.G);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView, null);
        this.G.setVisibility(0);
    }

    private void t(final VideoPlot videoPlot) {
        if (jy2.g.x(this.H, videoPlot)) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
        this.F.setText(videoPlot.video_base_info.episode_title);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: ey2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.p(videoPlot, view);
            }
        });
    }

    public void m(VideoPlot videoPlot) {
        if (this.F != null && this.G != null && videoPlot != null) {
            t(videoPlot);
            r(videoPlot);
            q(videoPlot);
        }
    }
}
