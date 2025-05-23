package dx1;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPanelListItem;
import cx1.y;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends RecyclerView.ViewHolder {
    View E;
    TextView F;
    TextView G;
    ImageView H;
    TextView I;

    public h(View view) {
        super(view);
        this.E = view;
        this.F = (TextView) view.findViewById(R.id.f111226kn);
        this.G = (TextView) view.findViewById(R.id.f111196kk);
        this.H = (ImageView) view.findViewById(R.id.f165967y92);
        this.I = (TextView) view.findViewById(R.id.f165968y93);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(cx1.a aVar, GProGuildRobotPanelListItem gProGuildRobotPanelListItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (aVar != null) {
            aVar.d(gProGuildRobotPanelListItem, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void m(final GProGuildRobotPanelListItem gProGuildRobotPanelListItem, final cx1.a aVar) {
        this.I.setVisibility(8);
        this.H.setVisibility(0);
        if (gProGuildRobotPanelListItem.getStatus() != 0) {
            this.I.setVisibility(0);
            this.H.setVisibility(8);
        }
        if (!aVar.h()) {
            this.H.setVisibility(8);
        }
        this.F.setText(gProGuildRobotPanelListItem.getOffInfo().getTitle());
        if (TextUtils.isEmpty(gProGuildRobotPanelListItem.getDesc())) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.G.setText(gProGuildRobotPanelListItem.getDesc());
        }
        this.E.setOnClickListener(new View.OnClickListener() { // from class: dx1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.n(cx1.a.this, gProGuildRobotPanelListItem, view);
            }
        });
        y.d(this.E, gProGuildRobotPanelListItem.getId(), gProGuildRobotPanelListItem.getOffInfo().getTitle());
    }
}
