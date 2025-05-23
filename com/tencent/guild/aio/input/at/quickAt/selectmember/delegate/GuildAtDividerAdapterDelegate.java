package com.tencent.guild.aio.input.at.quickAt.selectmember.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildAtDividerAdapterDelegate extends AbsListItemAdapterDelegate<com.tencent.guild.aio.input.at.quickAt.selectmember.data.b, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a, a> {

    /* renamed from: d, reason: collision with root package name */
    private final d f110998d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    public GuildAtDividerAdapterDelegate(d dVar) {
        this.f110998d = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, @NonNull List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list, int i3) {
        return aVar instanceof com.tencent.guild.aio.input.at.quickAt.selectmember.data.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NonNull ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f110998d.getContext()).inflate(R.layout.ezj, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.b bVar, @NonNull a aVar, @NonNull List<Object> list) {
    }
}
