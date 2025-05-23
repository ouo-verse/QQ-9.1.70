package com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import fz1.b;
import fz1.d;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBlacklistLoadingAdapterDelegate extends AbsListItemAdapterDelegate<d, b, a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        private ScanningLightView E;

        public a(@NonNull View view) {
            super(view);
            ScanningLightView scanningLightView = (ScanningLightView) view.findViewById(R.id.f79704_h);
            this.E = scanningLightView;
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            this.E.setLightColorRes(R.color.qui_common_fill_light_secondary);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull b bVar, @NonNull List<b> list, int i3) {
        return bVar instanceof d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NonNull ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eh7, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull d dVar, @NonNull a aVar, @NonNull List<Object> list) {
    }
}
