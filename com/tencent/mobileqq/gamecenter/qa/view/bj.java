package com.tencent.mobileqq.gamecenter.qa.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class bj extends RecyclerView.Adapter<c> {
    private b C;
    private boolean D;

    /* renamed from: m, reason: collision with root package name */
    private List<GameStrategyTag> f213121m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GameStrategyTag f213122d;

        a(GameStrategyTag gameStrategyTag) {
            this.f213122d = gameStrategyTag;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bj.this.C.a(this.f213122d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(GameStrategyTag gameStrategyTag);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.ViewHolder {
        public final TextView E;

        public c(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f89024yn);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f213121m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        int i16;
        int i17;
        int c16;
        GameStrategyTag gameStrategyTag = this.f213121m.get(i3);
        boolean z16 = gameStrategyTag.isSelected;
        if (this.D) {
            i16 = R.color.cfq;
        } else {
            i16 = R.color.f157841cg3;
        }
        int c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i16);
        if (z16) {
            c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfv);
        }
        cVar.E.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.h(0, ViewUtils.dip2px(2.0f), -1, c17));
        cVar.E.setText(gameStrategyTag.mTagName);
        cVar.E.setOnClickListener(new a(gameStrategyTag));
        TextView textView = cVar.E;
        if (z16) {
            c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfp);
        } else {
            if (this.D) {
                i17 = R.color.f157842cg4;
            } else {
                i17 = R.color.f157838cg0;
            }
            c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i17);
        }
        textView.setTextColor(c16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ec6, viewGroup, false));
    }

    public void l0(b bVar) {
        this.C = bVar;
    }

    public void m0(boolean z16) {
        this.D = z16;
    }

    public void setData(List<GameStrategyTag> list) {
        this.f213121m = list;
        notifyDataSetChanged();
    }
}
