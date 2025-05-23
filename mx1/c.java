package mx1;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.robot.slash.temp.UpdateRecentUsedRecordTempMsgIntent;
import hx1.e;
import hx1.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final Activity f417727d;

    /* renamed from: e, reason: collision with root package name */
    private final EditText f417728e;

    /* renamed from: f, reason: collision with root package name */
    public final ix1.a f417729f;

    /* renamed from: h, reason: collision with root package name */
    private CommonBotInfo f417730h;

    /* renamed from: i, reason: collision with root package name */
    private List<RobotFeatureItem> f417731i;

    /* renamed from: m, reason: collision with root package name */
    private List<f> f417732m = new ArrayList();
    public boolean C = false;

    public c(Activity activity, EditText editText, ix1.a aVar) {
        this.f417727d = activity;
        this.f417728e = editText;
        this.f417729f = aVar;
    }

    private void a(int i3, hx1.c cVar, View view) {
        CommonBotFeatureInfo commonBotFeatureInfo = this.f417732m.get(i3).f406566b;
        cVar.f406553b.setText(commonBotFeatureInfo.getName());
        cVar.f406554c.setText(commonBotFeatureInfo.getDesc());
        cVar.f406556e = i3;
        cVar.f406552a.setTag(cVar);
        cVar.f406552a.setOnClickListener(this);
        cVar.f406555d.setVisibility(8);
        kx1.a.h(i3, view, commonBotFeatureInfo);
        kx1.a.d(i3, view, commonBotFeatureInfo);
        kx1.a.f(i3, view, this.f417729f.F(), commonBotFeatureInfo);
        kx1.a.a(i3, view, this.f417729f.F(), commonBotFeatureInfo);
    }

    private void b(int i3, hx1.d dVar, View view) {
        CommonBotFeatureInfo commonBotFeatureInfo = this.f417732m.get(i3).f406566b;
        dVar.f406558b.setText(commonBotFeatureInfo.getName());
        dVar.f406560d = i3;
        dVar.f406557a.setTag(dVar);
        dVar.f406557a.setOnClickListener(this);
        dVar.f406559c.setVisibility(8);
        kx1.a.f(i3, view, this.f417729f.F(), commonBotFeatureInfo);
        kx1.a.a(i3, view, this.f417729f.F(), commonBotFeatureInfo);
    }

    private void c(int i3, e eVar, View view) {
        CommonBotInfo commonBotInfo = this.f417732m.get(i3).f406565a;
        hx1.b.h(eVar.f406563c, commonBotInfo, false);
        eVar.f406562b.setText(commonBotInfo.getName());
        eVar.f406564d = i3;
        eVar.f406561a.setTag(eVar);
        eVar.f406561a.setOnClickListener(this);
    }

    private View e(int i3, View view, ViewGroup viewGroup) {
        hx1.c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.f417727d).inflate(R.layout.f168855h23, viewGroup, false);
            cVar = new hx1.c(view);
            view.setTag(cVar);
        } else {
            cVar = (hx1.c) view.getTag();
        }
        a(i3, cVar, view);
        return view;
    }

    private View f(int i3, View view, ViewGroup viewGroup) {
        hx1.d dVar;
        if (view == null) {
            view = LayoutInflater.from(this.f417727d).inflate(R.layout.h2b, viewGroup, false);
            dVar = new hx1.d(view);
            view.setTag(dVar);
        } else {
            dVar = (hx1.d) view.getTag();
        }
        b(i3, dVar, view);
        return view;
    }

    private View g(int i3, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.f417727d).inflate(R.layout.h2c, viewGroup, false);
            eVar = new e(view);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        c(i3, eVar, view);
        return view;
    }

    private void i(View view) {
        f fVar = (f) getItem(((hx1.c) view.getTag()).f406556e);
        CommonBotFeatureInfo commonBotFeatureInfo = fVar.f406566b;
        if (commonBotFeatureInfo == null) {
            return;
        }
        String str = commonBotFeatureInfo.getName() + " ";
        Editable editableText = this.f417728e.getEditableText();
        int H = this.f417729f.H();
        if (H <= this.f417728e.getSelectionEnd()) {
            if (commonBotFeatureInfo.getName().equals("/\u641c\u7d22")) {
                str = str + ((Object) editableText.subSequence(H, this.f417728e.getSelectionEnd()));
            }
            if (H == -1) {
                editableText.insert(this.f417728e.getSelectionStart(), str);
            } else {
                editableText.replace(H, this.f417728e.getSelectionEnd(), str);
            }
        }
        n(fVar.f406565a, commonBotFeatureInfo, 1);
        kx1.a.c(view);
    }

    private void k(View view) {
        String str;
        CommonBotInfo commonBotInfo = this.f417730h;
        if (commonBotInfo != null) {
            str = String.valueOf(commonBotInfo.getTinyid());
        } else {
            str = "";
        }
        RobotInfoFragment.wh((FragmentActivity) this.f417727d, this.f417729f.C(), this.f417729f.D(), str, "", "0", false, 18);
    }

    private f l(RobotFeatureItem robotFeatureItem) {
        int i3 = 1;
        if (robotFeatureItem.getFeatureType() != 1) {
            i3 = 0;
        }
        return new f(this.f417730h, robotFeatureItem.getFeatureInfo(), false, i3);
    }

    private void n(CommonBotInfo commonBotInfo, CommonBotFeatureInfo commonBotFeatureInfo, int i3) {
        com.tencent.aio.api.runtime.a aVar;
        ix1.a aVar2 = this.f417729f;
        if (aVar2 != null) {
            aVar = aVar2.f408906d;
        } else {
            aVar = null;
        }
        if (aVar != null && commonBotInfo != null && commonBotFeatureInfo != null) {
            aVar.e().h(new UpdateRecentUsedRecordTempMsgIntent(commonBotInfo, commonBotFeatureInfo, i3));
        }
    }

    public int d(String str) {
        String str2;
        if (str.startsWith("/")) {
            str2 = str.replaceFirst("/", "");
        } else {
            str2 = str;
        }
        ArrayList arrayList = new ArrayList();
        for (RobotFeatureItem robotFeatureItem : this.f417731i) {
            if (sx1.f.h(str2, robotFeatureItem.getFeatureInfo().getName().replaceFirst("/", "")) || TextUtils.equals(str, "/") || h34.a.d(robotFeatureItem.getFeatureInfo())) {
                arrayList.add(robotFeatureItem);
            }
        }
        h(arrayList);
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f417732m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f417732m.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return this.f417732m.get(i3).f406568d;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        if (getItemViewType(i3) == 0) {
            view2 = e(i3, view, viewGroup);
        } else if (getItemViewType(i3) == 1) {
            view2 = f(i3, view, viewGroup);
        } else if (getItemViewType(i3) == 2) {
            view2 = g(i3, view, viewGroup);
        } else {
            view2 = null;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void h(List<RobotFeatureItem> list) {
        this.f417732m.clear();
        this.f417732m.add(new f(this.f417730h, false));
        Iterator<RobotFeatureItem> it = list.iterator();
        while (it.hasNext()) {
            this.f417732m.add(l(it.next()));
        }
        notifyDataSetChanged();
    }

    public void j(View view) {
        f fVar;
        CommonBotFeatureInfo commonBotFeatureInfo;
        if (this.f417727d == null || (commonBotFeatureInfo = (fVar = (f) getItem(((hx1.d) view.getTag()).f406560d)).f406566b) == null) {
            return;
        }
        int type = commonBotFeatureInfo.getType();
        String url = commonBotFeatureInfo.getUrl();
        if (type == 1) {
            hx1.b.k(this.f417727d, url);
        } else if (type == 0) {
            hx1.b.j(this.f417727d, url);
        } else {
            QQToast.makeText(this.f417727d, R.string.f143550md, 1).show();
        }
        n(fVar.f406565a, commonBotFeatureInfo, 2);
    }

    public void m(CommonBotInfo commonBotInfo, List<RobotFeatureItem> list) {
        this.f417730h = commonBotInfo;
        this.f417731i = list;
        h(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            this.f417729f.z(false);
            this.f417729f.P(4);
            if (view.getId() == R.id.u1b) {
                i(view);
            } else if (view.getId() == R.id.f83424ji) {
                j(view);
            } else if (view.getId() == R.id.f98655no) {
                k(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
