package ny1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildMonthView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private final GuildScheduleCalendarHelper f421584m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends RecyclerView.ViewHolder {
        public GuildMonthView E;

        public a(@NonNull View view) {
            super(view);
            GuildMonthView guildMonthView = (GuildMonthView) view;
            this.E = guildMonthView;
            guildMonthView.setHelper(g.this.f421584m);
        }
    }

    public g(GuildScheduleCalendarHelper guildScheduleCalendarHelper) {
        this.f421584m = guildScheduleCalendarHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.f421584m;
        if (guildScheduleCalendarHelper == null) {
            return 0;
        }
        return guildScheduleCalendarHelper.g(guildScheduleCalendarHelper.f233280w, guildScheduleCalendarHelper.f233281x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.f421584m;
        ViewCompat.setBackground(aVar.E, ResourcesCompat.getDrawable(guildScheduleCalendarHelper.C.getResources(), R.drawable.guild_schedule_calendar_bg, this.f421584m.C.getTheme()));
        aVar.E.setDate(guildScheduleCalendarHelper.f233280w + (i3 / 12), i3 % 12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f421584m.C).inflate(R.layout.eha, viewGroup, false));
    }
}
