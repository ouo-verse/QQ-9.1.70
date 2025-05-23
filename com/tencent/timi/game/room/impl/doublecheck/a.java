package com.tencent.timi.game.room.impl.doublecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import fm4.g;
import java.util.ArrayList;
import java.util.List;
import mm4.b;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends RecyclerView.Adapter<C9964a> {
    private LayoutInflater C;
    private long D;
    protected List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> E = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private Context f379208m;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.room.impl.doublecheck.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9964a extends RecyclerView.ViewHolder {
        public AvatarRoundImageView E;
        public ImageView F;

        public C9964a(@NonNull View view) {
            super(view);
            this.E = (AvatarRoundImageView) view.findViewById(R.id.vkq);
            this.F = (ImageView) view.findViewById(R.id.vkp);
        }
    }

    public a(Context context, List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> list) {
        this.f379208m = context;
        this.C = LayoutInflater.from(context);
        this.E.clear();
        if (list != null && list.size() > 0) {
            this.E.addAll(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.E.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull C9964a c9964a, int i3) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        float f16;
        YoloRoomOuterClass$YoloRoomDoubleCheckPlayer yoloRoomOuterClass$YoloRoomDoubleCheckPlayer = this.E.get(i3);
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo L = ((g) b.b(g.class)).K0(this.D).L(yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.user_id);
        if (L != null) {
            commonOuterClass$QQUserId = L.user_id;
        } else {
            commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.user_id;
        }
        c9964a.E.setUserId(commonOuterClass$QQUserId);
        int i16 = 0;
        boolean z16 = true;
        if (yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.is_check.get() != 1) {
            z16 = false;
        }
        AvatarRoundImageView avatarRoundImageView = c9964a.E;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        avatarRoundImageView.setAlpha(f16);
        ImageView imageView = c9964a.F;
        if (!z16) {
            i16 = 4;
        }
        imageView.setVisibility(i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C9964a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new C9964a(this.C.inflate(R.layout.hw8, (ViewGroup) null, false));
    }

    public void k0(List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> list, long j3) {
        this.D = j3;
        this.E.clear();
        if (list != null && list.size() > 0) {
            this.E.addAll(list);
        }
        notifyDataSetChanged();
    }
}
