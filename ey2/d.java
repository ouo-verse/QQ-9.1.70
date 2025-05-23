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
public class d extends RecyclerView.ViewHolder {
    private final TextView E;
    private final ImageView F;
    private final Video G;
    private final n.a H;

    public d(@NonNull View view, Video video, n.a aVar) {
        super(view);
        this.E = (TextView) view.findViewById(R.id.f107776bb);
        this.F = (ImageView) view.findViewById(R.id.xds);
        this.H = aVar;
        this.G = video;
    }

    private void o() {
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(VideoPlot videoPlot, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n.a aVar = this.H;
        if (aVar != null) {
            aVar.k(videoPlot);
        }
        VideoReport.reportEvent("clck", this.E, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q(VideoPlot videoPlot) {
        Map<String, Object> h16 = gy2.c.h("episode_float");
        h16.put("episode_cid", videoPlot.video_base_info.cid);
        h16.put("episode_vid", videoPlot.video_base_info.vid);
        VideoReport.setElementParams(this.E, h16);
        VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.E, "episode_slct");
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
        Option targetView = Option.obtain().setUrl(markLabel.mark_image_url).setTargetView(this.F);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView, null);
        this.F.setVisibility(0);
    }

    private void t(final VideoPlot videoPlot) {
        if (jy2.g.x(this.G, videoPlot)) {
            this.E.setBackgroundResource(R.drawable.lyy);
            this.E.setTextColor(-39666);
        } else {
            this.E.setBackgroundResource(R.drawable.lyx);
            this.E.setTextColor(-1);
        }
        this.E.setText(videoPlot.video_base_info.episode_title);
        this.E.setOnClickListener(new View.OnClickListener() { // from class: ey2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.p(videoPlot, view);
            }
        });
    }

    public void m(VideoPlot videoPlot) {
        if (this.E != null && this.F != null && videoPlot != null) {
            t(videoPlot);
            r(videoPlot);
            q(videoPlot);
        }
    }
}
