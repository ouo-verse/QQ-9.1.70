package com.tencent.mobileqq.guild.setting.guildmanage.blacklist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates.GuildBlacklistLoadingAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates.GuildBlacklistMemberAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates.GuildBlacklistTitleAdapterDelegate;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<fz1.b> {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7894a extends DiffUtil.ItemCallback<fz1.b> {
        C7894a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull fz1.b bVar, @NonNull fz1.b bVar2) {
            return bVar.equals(bVar2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull fz1.b bVar, @NonNull fz1.b bVar2) {
            if (bVar.a() == bVar2.a()) {
                return true;
            }
            return false;
        }
    }

    public a(p pVar) {
        super(new C7894a());
        this.f236209m.c(new GuildBlacklistMemberAdapterDelegate(pVar)).c(new GuildBlacklistTitleAdapterDelegate()).c(new GuildBlacklistLoadingAdapterDelegate());
    }

    public void submitList(List<fz1.b> list) {
        this.C.submitList(list);
    }
}
