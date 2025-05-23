package com.tencent.mobileqq.gamecenter.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends RecyclerView.Adapter<a> {
    private final ArrayList<GameFriendSelectorSvr$Friend> C = new ArrayList<>();
    private final b D;

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<w> f213309m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends RecyclerView.ViewHolder {
        Resources E;
        RoundRectImageView F;
        TextView G;
        TextView H;
        View I;
        ImageView J;
        TextView K;
        List<TextView> L;

        public a(@NonNull View view) {
            super(view);
            this.E = view.getResources();
            this.F = (RoundRectImageView) view.findViewById(R.id.f165909du3);
            this.G = (TextView) view.findViewById(R.id.f108016bz);
            this.H = (TextView) view.findViewById(R.id.f111006k2);
            this.I = view.findViewById(R.id.f222803a);
            this.J = (ImageView) view.findViewById(R.id.f165936y50);
            this.K = (TextView) view.findViewById(R.id.f108766e0);
            this.L = Arrays.asList(this.G, this.H, (TextView) view.findViewById(R.id.f109006en), (TextView) view.findViewById(R.id.f110766je));
            this.F.setCornerRadiusAndMode(com.tencent.mobileqq.gamecenter.util.a.a(20.0f, this.E), 1);
        }

        public void l() {
            int color;
            if (QQTheme.isNowThemeIsNight()) {
                color = this.E.getColor(R.color.bjv);
            } else {
                color = this.E.getColor(R.color.bju);
            }
            Iterator<TextView> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().setTextColor(color);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(@NonNull GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend);
    }

    public i(@NonNull Context context, @NonNull b bVar) {
        this.f213309m = ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).buildIntimacyStyle(context);
        this.D = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.D.a(gameFriendSelectorSvr$Friend);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        final GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.C.get(i3);
        aVar.F.setImageDrawable(URLDrawable.getDrawable(gameFriendSelectorSvr$Friend.avatar.get()));
        aVar.G.setText(gameFriendSelectorSvr$Friend.role_name.get());
        aVar.H.setText(gameFriendSelectorSvr$Friend.qq_nick.get());
        w wVar = this.f213309m.get(gameFriendSelectorSvr$Friend.intimacy_type.get());
        if (wVar != null) {
            aVar.I.setVisibility(0);
            aVar.I.setBackground(wVar.f213386c);
            aVar.J.setImageDrawable(wVar.f213387d);
            aVar.K.setText(wVar.a(gameFriendSelectorSvr$Friend.intimacy_value.get()));
            aVar.K.setTextColor(wVar.f213385b);
        } else {
            aVar.I.setVisibility(8);
        }
        aVar.l();
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.this.j0(gameFriendSelectorSvr$Friend, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eag, viewGroup, false));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @MainThread
    public void setData(List<GameFriendSelectorSvr$Friend> list) {
        this.C.clear();
        this.C.addAll(list);
        notifyDataSetChanged();
    }
}
