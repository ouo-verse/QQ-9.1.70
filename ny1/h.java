package ny1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildWeekView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private final GuildScheduleCalendarHelper f421585m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends RecyclerView.ViewHolder {
        public GuildWeekView E;

        public a(@NonNull View view) {
            super(view);
            GuildWeekView guildWeekView = (GuildWeekView) view.findViewById(R.id.f165651x51);
            this.E = guildWeekView;
            guildWeekView.setHelper(h.this.f421585m);
        }
    }

    public h(GuildScheduleCalendarHelper guildScheduleCalendarHelper) {
        this.f421585m = guildScheduleCalendarHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.f421585m;
        if (guildScheduleCalendarHelper == null) {
            return 0;
        }
        return guildScheduleCalendarHelper.v(guildScheduleCalendarHelper.f233280w, guildScheduleCalendarHelper.f233281x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        aVar.E.setIndex(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f421585m.C).inflate(R.layout.ehd, viewGroup, false));
    }
}
