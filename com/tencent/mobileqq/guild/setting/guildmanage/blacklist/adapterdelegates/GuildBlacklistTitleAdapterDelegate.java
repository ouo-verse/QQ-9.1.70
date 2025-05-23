package com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import fz1.b;
import fz1.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBlacklistTitleAdapterDelegate extends AbsListItemAdapterDelegate<c, b, a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView E;

        public a(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.x86);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull b bVar, @NonNull List<b> list, int i3) {
        return bVar instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull c cVar, @NonNull a aVar, @NonNull List<Object> list) {
        aVar.E.setText(cVar.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NonNull ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eh6, viewGroup, false));
    }
}
