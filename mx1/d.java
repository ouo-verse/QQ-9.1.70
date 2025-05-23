package mx1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.temp.api.IGuildAIORobotPanelApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineLayoutData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineRenderData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private AIOParam C;

    /* renamed from: d, reason: collision with root package name */
    private Context f417733d;

    /* renamed from: e, reason: collision with root package name */
    private final EditText f417734e;

    /* renamed from: f, reason: collision with root package name */
    private final ix1.a f417735f;

    /* renamed from: h, reason: collision with root package name */
    private List<GProGuildRobotInlineLayoutData> f417736h = Collections.emptyList();

    /* renamed from: i, reason: collision with root package name */
    private int f417737i;

    /* renamed from: m, reason: collision with root package name */
    private String f417738m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final RelativeLayout f417739a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f417740b;

        /* renamed from: c, reason: collision with root package name */
        private final TextView f417741c;

        /* renamed from: d, reason: collision with root package name */
        private final ImageView f417742d;

        /* renamed from: e, reason: collision with root package name */
        int f417743e;

        a(View view) {
            this.f417740b = (TextView) view.findViewById(R.id.md8);
            this.f417741c = (TextView) view.findViewById(R.id.f108876ea);
            this.f417739a = (RelativeLayout) view.findViewById(R.id.xo8);
            this.f417742d = (ImageView) view.findViewById(R.id.y55);
        }
    }

    public d(Context context, EditText editText, ix1.a aVar, int i3, String str, AIOParam aIOParam) {
        this.f417733d = context;
        this.f417734e = editText;
        this.f417735f = aVar;
        this.f417737i = i3;
        this.f417738m = str;
        this.C = aIOParam;
    }

    private void a(int i3, a aVar, View view) {
        GProGuildRobotInlineRenderData renderData = this.f417736h.get(i3).getRenderData();
        aVar.f417740b.setText(renderData.getTitle());
        aVar.f417741c.setText(renderData.getTips());
        aVar.f417743e = i3;
        aVar.f417739a.setOnClickListener(this);
        aVar.f417742d.setImageDrawable(com.tencent.mobileqq.guild.robot.utils.a.a(renderData.getCover(), aVar.f417742d.getWidth(), aVar.f417742d.getHeight(), null, false, true));
        kx1.b.e(i3, view, this.f417738m);
        kx1.b.b(i3, view, this.f417738m);
    }

    private void b(int i3, GProGuildRobotInlineLayoutData gProGuildRobotInlineLayoutData) {
        if (i3 == 0) {
            e(gProGuildRobotInlineLayoutData);
        }
    }

    private void d(View view) {
        b(this.f417737i, (GProGuildRobotInlineLayoutData) getItem(((a) view.getTag()).f417743e));
        this.f417734e.getText().clear();
        this.f417735f.z(true);
        kx1.b.a(view);
    }

    private void e(GProGuildRobotInlineLayoutData gProGuildRobotInlineLayoutData) {
        try {
            ((IGuildAIORobotPanelApi) QRoute.api(IGuildAIORobotPanelApi.class)).sendRobotInlineArk(new JSONObject(gProGuildRobotInlineLayoutData.getActionData()), com.tencent.guild.aio.util.a.b(this.C), com.tencent.guild.aio.util.a.g(this.C), 10014, String.valueOf(this.f417735f.F().getAppid()));
        } catch (JSONException e16) {
            QLog.e("GuildRobotTag:RobotCommandListAdapter", 1, e16, new Object[0]);
        }
    }

    public void c(ArrayList<GProGuildRobotInlineLayoutData> arrayList) {
        this.f417736h = arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("GuildRobotTag:RobotCommandListAdapter", 2, "notifySearchDataChanged start  " + System.currentTimeMillis());
        }
        notifyDataSetChanged();
        if (QLog.isColorLevel()) {
            QLog.d("GuildRobotTag:RobotCommandListAdapter", 2, "notifySearchDataChanged end  " + System.currentTimeMillis());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f417736h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f417736h.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f417733d).inflate(R.layout.f4z, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(i3, aVar, view);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        d(view);
        EventCollector.getInstance().onViewClicked(view);
    }
}
