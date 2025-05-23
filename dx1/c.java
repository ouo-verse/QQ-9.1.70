package dx1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotFeatureInfo;
import cx1.y;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends RecyclerView.ViewHolder {
    View E;
    TextView F;
    TextView G;
    ImageView H;

    public c(@NonNull View view) {
        super(view);
        this.E = view;
        this.F = (TextView) view.findViewById(R.id.f106946_3);
        this.G = (TextView) view.findViewById(R.id.f106916_0);
        this.H = (ImageView) view.findViewById(R.id.y1q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(cx1.a aVar, GProGuildRobotFeatureInfo gProGuildRobotFeatureInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (aVar != null) {
            aVar.e(gProGuildRobotFeatureInfo, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void m(final GProGuildRobotFeatureInfo gProGuildRobotFeatureInfo, int i3, final cx1.a aVar) {
        if (gProGuildRobotFeatureInfo.getStatus() != 0) {
            this.H.setBackgroundResource(R.drawable.guild_robot_summary_instruct_noauth);
        }
        this.F.setText(gProGuildRobotFeatureInfo.getName());
        this.G.setText(gProGuildRobotFeatureInfo.getDesc());
        this.E.setOnClickListener(new View.OnClickListener() { // from class: dx1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.n(cx1.a.this, gProGuildRobotFeatureInfo, view);
            }
        });
        y.a(this.E, gProGuildRobotFeatureInfo.getId(), gProGuildRobotFeatureInfo.getName(), i3);
    }
}
