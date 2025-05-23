package aw1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f27060d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<String, b> f27061e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final h f27062f = new h();

    /* renamed from: h, reason: collision with root package name */
    private GuildBaseProfileData f27063h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Activity> f27064i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f27065a;

        /* renamed from: b, reason: collision with root package name */
        public int f27066b;

        /* renamed from: c, reason: collision with root package name */
        public String f27067c;

        /* renamed from: d, reason: collision with root package name */
        public int f27068d;

        /* renamed from: e, reason: collision with root package name */
        public String f27069e;

        /* renamed from: f, reason: collision with root package name */
        public String f27070f;

        /* renamed from: g, reason: collision with root package name */
        public String f27071g;

        /* renamed from: h, reason: collision with root package name */
        public int f27072h;

        /* renamed from: i, reason: collision with root package name */
        public int f27073i;

        /* renamed from: j, reason: collision with root package name */
        public int f27074j;

        /* renamed from: k, reason: collision with root package name */
        public int f27075k;

        /* renamed from: l, reason: collision with root package name */
        public int f27076l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f27077m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f27078n;

        public b(IGProGuildRoleInfo iGProGuildRoleInfo) {
            this.f27069e = "";
            this.f27070f = "";
            this.f27071g = "";
            this.f27067c = iGProGuildRoleInfo.getName();
            this.f27066b = iGProGuildRoleInfo.getColor() | (-16777216);
            this.f27065a = iGProGuildRoleInfo.getRoleId();
            this.f27068d = iGProGuildRoleInfo.getNameplate();
            this.f27069e = iGProGuildRoleInfo.getLevelIconUrl();
            this.f27072h = iGProGuildRoleInfo.getBackgroudColor1();
            this.f27073i = iGProGuildRoleInfo.getBackgroudColor2();
            this.f27074j = iGProGuildRoleInfo.getOutlineColor();
            this.f27070f = iGProGuildRoleInfo.getLevelSimpleDsc();
            this.f27071g = iGProGuildRoleInfo.getLevelDesc();
            this.f27075k = iGProGuildRoleInfo.getLevelSimpleDscColor();
            this.f27076l = iGProGuildRoleInfo.getLevelSplitLineColor();
            this.f27077m = iGProGuildRoleInfo.isLevelRole();
            this.f27078n = iGProGuildRoleInfo.getDisplayType() == 1;
        }

        public boolean a() {
            return this.f27078n;
        }

        public boolean b() {
            return this.f27077m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f27066b == bVar.f27066b && Objects.equals(this.f27065a, bVar.f27065a) && Objects.equals(this.f27067c, bVar.f27067c) && Objects.equals(Integer.valueOf(this.f27068d), Integer.valueOf(bVar.f27068d))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f27065a, Integer.valueOf(this.f27066b), this.f27067c);
        }
    }

    public k(Activity activity, GuildBaseProfileData guildBaseProfileData) {
        this.f27064i = new WeakReference<>(activity);
        this.f27063h = guildBaseProfileData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(aw1.a aVar, b bVar) {
        GuildBaseProfileData guildBaseProfileData;
        if (!(aVar instanceof d) || (guildBaseProfileData = this.f27063h) == null || !guildBaseProfileData.p()) {
            return;
        }
        WeakReference<Activity> weakReference = this.f27064i;
        if (weakReference == null) {
            QLog.e("Guild.profile.GuildProfileCardFlowLayoutAdapter", 1, "mWeakActivity is null");
            return;
        }
        Activity activity = weakReference.get();
        if (activity != null && !activity.isFinishing()) {
            if (ch.j0(this.f27063h.e())) {
                g(bVar.f27071g, bVar.f27069e);
                return;
            } else {
                GuildLevelRoleUtils.a(activity, this.f27063h.e(), 7);
                return;
            }
        }
        QLog.e("Guild.profile.GuildProfileCardFlowLayoutAdapter", 1, "mWeakActivity.get() is Finishing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit e(String str, String str2, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            com.tencent.mobileqq.guild.util.qqui.g.e(0, new BitmapDrawable(bitmap), R.string.f142820ke, str2);
            return null;
        }
        QLog.w("Guild.profile.GuildProfileCardFlowLayoutAdapter", 1, "showGuildAliveToast bitmap : " + bitmap + ",iconUrl: " + str);
        com.tencent.mobileqq.guild.util.qqui.g.d(0, R.string.f142820ke, str2);
        return null;
    }

    private void f(final aw1.a<b> aVar, final b bVar) {
        aVar.f(new a() { // from class: aw1.i
            @Override // aw1.k.a
            public final void a() {
                k.this.d(aVar, bVar);
            }
        });
    }

    private void g(final String str, final String str2) {
        GuildLevelRoleViewForProfileCard.u(str2, new Function1() { // from class: aw1.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e16;
                e16 = k.e(str2, str, (Bitmap) obj);
                return e16;
            }
        });
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b getItem(int i3) {
        if (i3 < this.f27060d.size()) {
            return this.f27060d.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f27060d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        b bVar = this.f27060d.get(i3);
        if (this.f27060d.size() == 0 || bVar == null || !bVar.b()) {
            return 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        aw1.a<b> aVar;
        View view2;
        View view3;
        int itemViewType = getItemViewType(i3);
        b item = getItem(i3);
        if (view == null) {
            aVar = this.f27062f.a(itemViewType);
            if (aVar == null) {
                QLog.e("Guild.profile.GuildProfileCardFlowLayoutAdapter", 1, "getView not support type: " + itemViewType + ", data: " + item);
                view2 = null;
                view3 = view;
                EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                return view2;
            }
            view = aVar.c(viewGroup);
            view.setTag(Integer.valueOf(aVar.d()));
            view.setTag(aVar.d(), aVar);
        } else {
            aVar = (aw1.a) view.getTag(((Integer) view.getTag()).intValue());
        }
        if (item != null) {
            aVar.a(item);
        }
        f(aVar, item);
        view2 = view;
        view3 = view2;
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<b> list) {
        this.f27060d.clear();
        this.f27061e.clear();
        for (b bVar : list) {
            if (this.f27061e.containsKey(bVar.f27065a)) {
                if (QLog.isColorLevel()) {
                    QLog.e("Guild.profile.GuildProfileCardFlowLayoutAdapter", 2, "same groupID:" + bVar.f27065a);
                }
            } else {
                this.f27060d.add(bVar);
                this.f27061e.put(bVar.f27065a, bVar);
            }
        }
        notifyDataSetChanged();
    }
}
