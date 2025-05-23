package com.tencent.mobileqq.gamecenter.qa.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n extends PagerAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QBaseActivity> f213164d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.qa.model.b> f213165e;

    /* renamed from: f, reason: collision with root package name */
    private vd1.b f213166f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<GameQAUI> f213167h;

    public n(QBaseActivity qBaseActivity) {
        this.f213164d = new WeakReference<>(qBaseActivity);
    }

    public List<com.tencent.mobileqq.gamecenter.qa.model.b> d() {
        return this.f213165e;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public com.tencent.mobileqq.gamecenter.qa.model.b e(int i3) {
        List<com.tencent.mobileqq.gamecenter.qa.model.b> list = this.f213165e;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.f213165e.get(i3);
        }
        return null;
    }

    public void f(GameQAUI gameQAUI) {
        this.f213167h = new WeakReference<>(gameQAUI);
    }

    public void g(vd1.b bVar) {
        this.f213166f = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<com.tencent.mobileqq.gamecenter.qa.model.b> list = this.f213165e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        com.tencent.mobileqq.gamecenter.qa.model.c cVar;
        View inflate = View.inflate(this.f213164d.get(), R.layout.f167992ec2, null);
        viewGroup.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.f113266q6);
        com.tencent.mobileqq.gamecenter.qa.model.b bVar = this.f213165e.get(i3);
        if (bVar != null && (cVar = bVar.f212615a) != null) {
            textView.setText(cVar.f212622f);
        }
        inflate.setTag(bVar);
        inflate.setOnClickListener(this);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QBaseActivity qBaseActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f29780mk && (qBaseActivity = this.f213164d.get()) != null) {
            com.tencent.mobileqq.gamecenter.qa.model.b bVar = (com.tencent.mobileqq.gamecenter.qa.model.b) view.getTag();
            GameQAUtil.z(qBaseActivity, this.f213166f.f441458c, bVar.f212615a.f212617a);
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar2 = this.f213166f;
            gameStrategyChannelEntry.guildId = bVar2.f441456a;
            gameStrategyChannelEntry.channelId = bVar2.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907096", "20", String.valueOf(bVar2.f441458c), GameQAUtil.j(this.f213164d.get(), gameStrategyChannelEntry, bVar.f212615a.f212617a));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<com.tencent.mobileqq.gamecenter.qa.model.b> list) {
        this.f213165e = list;
    }
}
