package jn2;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.net.view.j;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.ae;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import lo2.u;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends BaseAdapter {
    public static final String E = "g";
    public float C;
    public int D = 0;

    /* renamed from: d, reason: collision with root package name */
    public List<u> f410665d;

    /* renamed from: e, reason: collision with root package name */
    public ac f410666e;

    /* renamed from: f, reason: collision with root package name */
    public int f410667f;

    /* renamed from: h, reason: collision with root package name */
    public HorizontalListView f410668h;

    /* renamed from: i, reason: collision with root package name */
    public float f410669i;

    /* renamed from: m, reason: collision with root package name */
    public long f410670m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements HorizontalListView.OnScrollLinstener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HorizontalListView f410671a;

        a(HorizontalListView horizontalListView) {
            this.f410671a = horizontalListView;
        }

        @Override // com.tencent.widget.HorizontalListView.OnScrollLinstener
        public void onScroll() {
            float round = Math.round(((g.this.c(this.f410671a) - x.c(this.f410671a.getContext(), 13.5f)) + this.f410671a.getCurrentX()) / g.this.f410669i);
            for (int i3 = 0; i3 < round && i3 < g.this.f410665d.size(); i3++) {
                ae aeVar = (ae) g.this.f410665d.get(i3);
                HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
                if (hashMap.containsKey(aeVar)) {
                    SearchUtils.d dVar = hashMap.get(aeVar);
                    if (!dVar.f284979d) {
                        dVar.f284979d = true;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                            jSONObject.put("event_src", "client");
                            jSONObject.put("get_src", "web");
                            jSONObject.put("obj_lct", dVar.f284978c);
                            jSONObject.put("extra_info", aeVar.f415280d0);
                            jSONObject.put("tepl", aeVar.M);
                        } catch (JSONException e16) {
                            QLog.e(g.E, 2, "e = " + e16);
                        }
                        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                        com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(aeVar.J + "").obj2(aeVar.f415281e0).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(g.this.f410667f)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f410673d;

        b(ViewGroup viewGroup) {
            this.f410673d = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SearchUtils.Q0((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this.f410673d.getContext(), g.this.f410666e.f283474h0);
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
                jSONObject.put("get_src", "web");
            } catch (JSONException e16) {
                QLog.e(g.E, 2, "e = " + e16);
            }
            com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(g.this.f410670m + "").ver1(UniteSearchActivity.f282690h0).ver2(com.tencent.mobileqq.search.report.b.a(g.this.f410667f)).ver3("right").ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public g(ac acVar, int i3, HorizontalListView horizontalListView) {
        this.f410666e = acVar;
        this.f410667f = i3;
        this.f410668h = horizontalListView;
        horizontalListView.setOnScrollListener(new a(horizontalListView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float c(ViewGroup viewGroup) {
        if (viewGroup.getMeasuredWidth() > 10) {
            return viewGroup.getMeasuredWidth();
        }
        return (float) ah.Z();
    }

    protected void b(ae aeVar, View view, int i3) {
        if (!TextUtils.isEmpty(aeVar.f415280d0) && this.f410670m == 1105) {
            am.v(view, aeVar.f415280d0);
        }
        am.r(view, aeVar.u(), com.tencent.mobileqq.search.util.x.e(aeVar), aeVar.z(), i3, aeVar.e(), String.valueOf(aeVar.hashCode()), aeVar.getRecallReason());
    }

    public List<u> d() {
        return this.f410665d;
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public u getItem(int i3) {
        return this.f410665d.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f410665d == null) {
            return 0;
        }
        if (TextUtils.isEmpty(this.f410666e.f283474h0)) {
            return this.f410665d.size();
        }
        return this.f410665d.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (i3 == this.f410665d.size() && !TextUtils.isEmpty(this.f410666e.f283474h0)) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        j jVar;
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a0o, viewGroup, false);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) this.C);
                layoutParams.topMargin = x.c(viewGroup.getContext(), 6.0f);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.b8q);
                linearLayout.setLayoutParams(layoutParams);
                ImageView imageView = (ImageView) view.findViewById(R.id.f07);
                TextView textView = (TextView) view.findViewById(R.id.f0r);
                if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                    linearLayout.setBackgroundResource(R.drawable.f160534jf);
                    textView.setTextColor(Color.parseColor("#4A4A4A"));
                    imageView.setImageResource(R.drawable.f161401df1);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.f160533je);
                    textView.setTextColor(Color.parseColor("#737373"));
                    imageView.setImageResource(R.drawable.f161400df0);
                }
                textView.setText(this.f410666e.f283473g0);
                view.setOnClickListener(new b(viewGroup));
            }
        } else {
            ae aeVar = (ae) this.f410665d.get(i3);
            aeVar.d0(this.f410666e.f283472f0);
            if (view == null) {
                j jVar2 = new j(viewGroup, 0);
                View view2 = jVar2.getView();
                view2.setTag(jVar2);
                jVar = jVar2;
                view = view2;
            } else {
                jVar = (j) view.getTag();
            }
            float c16 = c(viewGroup);
            float c17 = (c16 - x.c(view.getContext(), 13.5f)) / (this.f410666e.f283472f0 + 0.5f);
            int i16 = this.f410666e.f283472f0;
            if (i16 == 5 || i16 == 6) {
                c17 = (c16 - x.c(view.getContext(), 32.0f)) / 3.0f;
                this.f410668h.setDividerWidth(10);
            }
            this.f410669i = x.c(this.f410668h.getContext(), 3.0f) + c17;
            switch (aeVar.U.f415229a) {
                case 8:
                    this.C = (136.0f * c17) / 220.0f;
                    break;
                case 9:
                    this.C = c17;
                    break;
                case 10:
                    this.C = (228.0f * c17) / 162.0f;
                    break;
                case 11:
                    this.C = c17;
                    break;
                default:
                    this.C = (136.0f * c17) / 220.0f;
                    break;
            }
            jVar.getView().setLayoutParams(new LinearLayout.LayoutParams((int) c17, -2));
            aeVar.W(jVar);
            aeVar.F(this.f410666e.C);
            jVar.getView().measure(1073741824, 0);
            this.D = Math.max(jVar.getView().getMeasuredHeight(), this.D);
            this.f410668h.getLayoutParams().height = this.D;
            this.f410670m = aeVar.J;
            b(aeVar, view, i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void setData(List<u> list) {
        this.f410665d = list;
        notifyDataSetChanged();
    }
}
