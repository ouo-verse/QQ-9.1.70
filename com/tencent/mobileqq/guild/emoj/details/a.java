package com.tencent.mobileqq.guild.emoj.details;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int J = 0;
    private static int K = 1;
    private GuildEmojiDetailsData D;
    private Activity E;

    /* renamed from: m, reason: collision with root package name */
    private AppInterface f217895m;
    private List<com.tencent.mobileqq.guild.emoj.a> C = new ArrayList();
    private pi1.a F = null;
    private d G = null;
    private boolean H = true;
    private boolean I = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.emoj.details.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    class ViewOnClickListenerC7732a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f217896d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.emoj.a f217897e;

        ViewOnClickListenerC7732a(int i3, com.tencent.mobileqq.guild.emoj.a aVar) {
            this.f217896d = i3;
            this.f217897e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.F != null) {
                a.this.F.Z();
            }
            if (a.this.G != null) {
                a.this.G.a(this.f217896d, String.valueOf(this.f217897e.f217864b), view);
            }
            a.this.n0(String.valueOf(this.f217897e.f217864b));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b extends RecyclerView.ViewHolder {
        ImageView E;

        public b(View view) {
            super(view);
            this.E = null;
            this.E = (ImageView) view.findViewById(R.id.loading);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c extends RecyclerView.ViewHolder {
        LinearLayout E;
        public GuildUserAvatarView F;
        public TextView G;

        public c(View view) {
            super(view);
            this.E = null;
            this.F = null;
            this.G = null;
            this.E = (LinearLayout) view.findViewById(R.id.b9w);
            this.F = (GuildUserAvatarView) view.findViewById(R.id.icon);
            this.G = (TextView) view.findViewById(R.id.nickname);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface d {
        void a(int i3, String str, View view);
    }

    public a(AppInterface appInterface, Activity activity, GuildEmojiDetailsData guildEmojiDetailsData) {
        this.f217895m = null;
        this.f217895m = appInterface;
        this.E = activity;
        this.D = guildEmojiDetailsData;
        l0();
    }

    private void l0() {
        com.tencent.mobileqq.guild.emoj.a aVar = new com.tencent.mobileqq.guild.emoj.a();
        aVar.f217863a = true;
        this.C.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str) {
        if (this.D == null) {
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(this.D.c(), "", str, 0, 2);
        guildProfileData.getGuildBaseProfileData().r(this.D.a());
        GuildProfileCard.Mh(this.E, guildProfileData, null);
    }

    private void o0(String str, GuildUserAvatarView guildUserAvatarView) {
        if (!TextUtils.isEmpty(str) && guildUserAvatarView != null) {
            guildUserAvatarView.setAvatarTinyId(this.D.c(), str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.C.get(i3).f217863a) {
            return K;
        }
        return J;
    }

    public boolean m0() {
        return this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if (viewHolder instanceof c) {
            com.tencent.mobileqq.guild.emoj.a aVar = this.C.get(i3);
            c cVar = (c) viewHolder;
            o0(String.valueOf(aVar.f217864b), cVar.F);
            cVar.G.setText(aVar.f217865c);
            cVar.E.setOnClickListener(new ViewOnClickListenerC7732a(i3, aVar));
            return;
        }
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            ImageView imageView = bVar.E;
            if (this.H) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            if (this.H) {
                ImageView imageView2 = bVar.E;
                imageView2.setImageDrawable(com.tencent.mobileqq.guild.util.qqui.d.d(imageView2.getContext(), 2));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == J) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emd, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emc, viewGroup, false));
    }

    public void p0(boolean z16) {
        this.I = z16;
    }

    public void q0(boolean z16) {
        this.H = z16;
    }

    public void r0(d dVar) {
        this.G = dVar;
    }

    public void s0(pi1.a aVar) {
        this.F = aVar;
    }

    public void t0(List list, boolean z16) {
        if (list == null) {
            return;
        }
        if (z16) {
            this.C.clear();
            l0();
        }
        if (this.C.size() == 0) {
            this.C.addAll(list);
        } else {
            this.C.addAll(r3.size() - 1, list);
        }
        notifyDataSetChanged();
    }
}
