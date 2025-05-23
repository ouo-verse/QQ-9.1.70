package com.tencent.timi.game.teamlist.presenter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigKV;
import trpc.yes.common.YoloRoomOuterClass$ListParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListFilterUnitAdapter extends RecyclerView.Adapter {
    private String C;
    private String D;
    private String E;
    private String F;
    private ArrayList<YesGameInfoOuterClass$GameConfigKV> G = new ArrayList<>();
    private ArrayList<Boolean> H = new ArrayList<>();
    private boolean I = true;

    /* renamed from: m, reason: collision with root package name */
    private YesGameInfoOuterClass$GameConfigItem f379796m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379797d;

        a(int i3) {
            this.f379797d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            l.b("TeamListFilterUnitAdapter", "itemClick" + this.f379797d);
            boolean isChecked = ((CheckBox) view).isChecked();
            if (this.f379797d != 0) {
                TeamListFilterUnitAdapter.this.I = false;
                TeamListFilterUnitAdapter.this.H.set(this.f379797d, Boolean.valueOf(isChecked));
                TeamListFilterUnitAdapter.this.o0();
            } else if (isChecked) {
                TeamListFilterUnitAdapter.this.p0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TeamListFilterUnitAdapter(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, String str, String str2, String str3, String str4) {
        boolean z16;
        this.f379796m = yesGameInfoOuterClass$GameConfigItem;
        this.C = str;
        this.D = str2;
        this.E = str3;
        this.F = str4;
        for (int i3 = 0; i3 < this.f379796m.f437255kv.get().size(); i3++) {
            this.G.add(this.f379796m.f437255kv.get().get(i3));
            ArrayList<Boolean> arrayList = this.H;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList.add(Boolean.valueOf(z16));
        }
        Iterator<YesGameInfoOuterClass$GameConfigKV> it = this.G.iterator();
        while (it.hasNext()) {
            l.b("TeamListFilterUnitAdapter", it.next().key.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        new Handler().post(new Runnable() { // from class: com.tencent.timi.game.teamlist.presenter.TeamListFilterUnitAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                TeamListFilterUnitAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.I = true;
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            this.H.set(i3, Boolean.FALSE);
        }
        o0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.G.size();
    }

    public YoloRoomOuterClass$ListParam m0() {
        YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam = new YoloRoomOuterClass$ListParam();
        yoloRoomOuterClass$ListParam.index.set(this.f379796m.index.get());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            if (this.H.get(i3).booleanValue()) {
                arrayList.add(this.G.get(i3).value.get(0));
            }
        }
        yoloRoomOuterClass$ListParam.value.set(arrayList);
        return yoloRoomOuterClass$ListParam;
    }

    public void n0() {
        p0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof com.tencent.timi.game.teamlist.view.a) {
            com.tencent.timi.game.teamlist.view.a aVar = (com.tencent.timi.game.teamlist.view.a) viewHolder;
            aVar.l(this.C, this.D, this.E, this.F);
            if (i3 == 0) {
                aVar.E.setEnabled(!this.I);
                aVar.E.setChecked(this.I);
            } else {
                aVar.E.setChecked(this.H.get(i3).booleanValue());
            }
            aVar.E.setText(this.G.get(i3).key.get());
            if (aVar.E.isChecked()) {
                aVar.E.setTypeface(null, 1);
            } else {
                aVar.E.setTypeface(null, 0);
            }
            aVar.E.setClickable(true);
            aVar.E.setOnClickListener(new a(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        com.tencent.timi.game.teamlist.view.a aVar = new com.tencent.timi.game.teamlist.view.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f169137hy2, viewGroup, false));
        aVar.setIsRecyclable(false);
        return aVar;
    }
}
