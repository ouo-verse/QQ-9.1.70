package jo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.QQGuildChannelItemView;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQGuildChannelEntry;
import com.tencent.mobileqq.data.QQGuildGuildEntry;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends com.tencent.mobileqq.adapter.c implements View.OnClickListener {
    private static final List<String> E = new ArrayList();
    private static final Comparator<IGProGuildInfo> F = new Comparator() { // from class: jo1.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i3;
            i3 = d.i((IGProGuildInfo) obj, (IGProGuildInfo) obj2);
            return i3;
        }
    };
    private final Context C;
    private Map<String, ArrayList<Entity>> D;

    /* renamed from: i, reason: collision with root package name */
    private final List<Entity> f410735i;

    /* renamed from: m, reason: collision with root package name */
    private final QQAppInterface f410736m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends k {

        /* renamed from: i, reason: collision with root package name */
        public Object f410737i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f410738a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f410739b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f410740c;

        /* renamed from: d, reason: collision with root package name */
        public int f410741d;

        protected b() {
        }
    }

    public static void g() {
        E.clear();
    }

    private List<Entity> h(int i3) {
        return this.D.get(((QQGuildGuildEntry) getGroup(i3)).guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(IGProGuildInfo iGProGuildInfo, IGProGuildInfo iGProGuildInfo2) {
        return iGProGuildInfo.getJoinTime() > iGProGuildInfo2.getJoinTime() ? -1 : 1;
    }

    private void j(b bVar, QQGuildGuildEntry qQGuildGuildEntry) {
        bVar.f410739b.setImageDrawable(((IQQGuildAvatarApi) this.f410736m.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(qQGuildGuildEntry.avatarUrl, 100, 100, (String) null));
        bVar.f410738a.setText(qQGuildGuildEntry.guildName);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        b bVar = (b) view.getTag();
        if (bVar == null) {
            bVar = new b();
            f(bVar, view);
        }
        j(bVar, (QQGuildGuildEntry) getGroup(i3));
        ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.f187153f.isGroupExpanded(i3));
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        return h(i3).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        if (h(i3) == null) {
            return 0;
        }
        return h(i3).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return this.f410735i.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f410735i.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return 0L;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return R.layout.ejz;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        return this.f410735i.isEmpty();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = (b) view.getTag();
        if (this.f187153f.isGroupExpanded(bVar.f410741d)) {
            this.f187153f.collapseGroup(bVar.f410741d);
            E.remove(((QQGuildGuildEntry) getGroup(bVar.f410741d)).guildId);
        } else {
            this.f187153f.expandGroup(bVar.f410741d);
            E.add(((QQGuildGuildEntry) getGroup(bVar.f410741d)).guildId);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ResultRecord resultRecord;
        a aVar;
        if (view == null) {
            QQGuildChannelItemView qQGuildChannelItemView = new QQGuildChannelItemView(this.C);
            aVar = new a();
            resultRecord = new ResultRecord();
            qQGuildChannelItemView.setTag(aVar);
        } else {
            QQGuildChannelItemView qQGuildChannelItemView2 = (QQGuildChannelItemView) view;
            a aVar2 = (a) qQGuildChannelItemView2.getTag();
            resultRecord = qQGuildChannelItemView2.D;
            aVar = aVar2;
        }
        QQGuildChannelEntry qQGuildChannelEntry = (QQGuildChannelEntry) getChild(i3, i16);
        aVar.f187211e = qQGuildChannelEntry.type;
        aVar.f187210d = qQGuildChannelEntry.uin;
        aVar.f410737i = qQGuildChannelEntry;
        resultRecord.init(qQGuildChannelEntry.uin, qQGuildChannelEntry.guildId, ((QQGuildGuildEntry) getGroup(i3)).avatarUrl, qQGuildChannelEntry.type, qQGuildChannelEntry.name);
        throw null;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.C).inflate(R.layout.ejz, viewGroup, false);
            bVar = new b();
            f(bVar, view);
            view.setOnClickListener(this);
            ((ImageView) view.findViewById(R.id.wim)).setImageResource(QQTheme.isNowThemeIsNight() ? R.drawable.jns : R.drawable.jnr);
        } else {
            bVar = (b) view.getTag();
        }
        QQGuildGuildEntry qQGuildGuildEntry = (QQGuildGuildEntry) getGroup(i3);
        j(bVar, qQGuildGuildEntry);
        bVar.f410741d = i3;
        ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.f187153f.isGroupExpanded(i3));
        if (AppSetting.f99565y) {
            view.setContentDescription(qQGuildGuildEntry.guildName);
        }
        return view;
    }

    private void f(b bVar, View view) {
        bVar.f410738a = (TextView) view.findViewById(R.id.group_name);
        bVar.f410739b = (ImageView) view.findViewById(R.id.icon);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.dv_);
        bVar.f410740c = checkBox;
        checkBox.setVisibility(0);
        view.setTag(bVar);
    }
}
