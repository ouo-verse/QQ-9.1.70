package com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final InterfaceC7880a C;

    /* renamed from: m, reason: collision with root package name */
    private final List<b> f232294m = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC7880a {
        void a(View view, b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f232295a;

        /* renamed from: b, reason: collision with root package name */
        public String f232296b;

        /* renamed from: c, reason: collision with root package name */
        public String f232297c;

        /* renamed from: d, reason: collision with root package name */
        public String f232298d;

        public b(int i3, String str, String str2, String str3) {
            this.f232295a = i3;
            this.f232297c = str;
            this.f232296b = str2;
            this.f232298d = str3;
        }

        public String toString() {
            return "PreviewMemberUIData{mAvatarType=" + this.f232295a + ", mTinyId='" + this.f232296b + "', mGuildId='" + this.f232297c + "', mNickname='" + this.f232298d + "'}";
        }
    }

    public a(InterfaceC7880a interfaceC7880a) {
        this.C = interfaceC7880a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f232294m.size();
    }

    public void i0(List<b> list) {
        this.f232294m.clear();
        this.f232294m.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.rg.GuildRoleMemberPreviewAdapter", 4, "onBindViewHolder");
        }
        if (!(viewHolder instanceof com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.b)) {
            return;
        }
        ((com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.b) viewHolder).o(this.f232294m.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.rg.GuildRoleMemberPreviewAdapter", 4, "onCreateViewHolder");
        }
        return new com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6s, viewGroup, false), this.C);
    }
}
