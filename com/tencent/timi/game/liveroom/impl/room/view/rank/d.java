package com.tencent.timi.game.liveroom.impl.room.view.rank;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.avatar.QQLiveAvatarImageView;
import com.tencent.mobileqq.qqlive.widget.avatar.QQLivePendantImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import com.tencent.timi.game.liveroom.impl.room.medal.data.UserLevelInfo;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.rank.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity D;
    private Context E;
    private long F;
    private long G;
    private com.tencent.timi.game.liveroom.impl.room.view.rank.b J;

    /* renamed from: m, reason: collision with root package name */
    private long f378884m = 0;
    private List<d55.a> C = new ArrayList();
    private int H = 0;
    private int I = 1;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d55.a f378885d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f378886e;

        a(d55.a aVar, b bVar) {
            this.f378885d = aVar;
            this.f378886e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (d.this.p0()) {
                LiveUserInfo o06 = d.this.o0(this.f378885d);
                if (d.this.J != null) {
                    d.this.J.a(this.f378886e.N, d.this.D, d.this.F, d.this.G, o06, 4);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b extends RecyclerView.ViewHolder {
        private final TextView E;
        private final TextView F;
        private final TextView G;
        private final TextView H;
        private final QQLiveAvatarImageView I;
        private final ImageView J;
        private final ImageView K;
        private final ImageView L;
        private final ImageView M;
        private final ConstraintLayout N;
        private final ImageView P;
        private final QQLivePendantImageView Q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public class a extends com.tencent.timi.game.liveroom.impl.room.medal.g<UserLevelInfo> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ UserLevelInfo f378888b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserLevelInfo userLevelInfo, UserLevelInfo userLevelInfo2) {
                super(userLevelInfo);
                this.f378888b = userLevelInfo2;
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.medal.g
            public int b() {
                return this.f378888b.hashCode();
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.medal.g
            public int c() {
                return this.f378888b.getLevel();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.rank.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public class C9959b extends com.tencent.timi.game.liveroom.impl.room.medal.g<sr4.g> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ sr4.g f378890b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C9959b(sr4.g gVar, sr4.g gVar2) {
                super(gVar);
                this.f378890b = gVar2;
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.medal.g
            public int b() {
                return this.f378890b.hashCode();
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.medal.g
            public int c() {
                return this.f378890b.f434397m;
            }
        }

        public b(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f70333l6);
            this.F = (TextView) view.findViewById(R.id.f70343l7);
            this.G = (TextView) view.findViewById(R.id.f70303l3);
            this.H = (TextView) view.findViewById(R.id.f70353l8);
            this.I = (QQLiveAvatarImageView) view.findViewById(R.id.f70283l1);
            this.J = (ImageView) view.findViewById(R.id.f70293l2);
            this.K = (ImageView) view.findViewById(R.id.f70313l4);
            this.N = (ConstraintLayout) view.findViewById(R.id.f70323l5);
            this.L = (ImageView) view.findViewById(R.id.v0f);
            this.M = (ImageView) view.findViewById(R.id.f115506w8);
            this.P = (ImageView) view.findViewById(R.id.t1f);
            this.Q = (QQLivePendantImageView) view.findViewById(R.id.f70273l0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(com.tencent.timi.game.liveroom.impl.room.medal.g gVar, Drawable drawable) {
            if (drawable instanceof Drawable) {
                this.L.setVisibility(0);
                this.L.setImageDrawable(drawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(com.tencent.timi.game.liveroom.impl.room.medal.g gVar, Drawable drawable) {
            if (drawable instanceof Drawable) {
                this.M.setVisibility(0);
                this.M.setImageDrawable(drawable);
            }
        }

        public void A(d55.a aVar) {
            sr4.g[] gVarArr;
            sr4.g gVar;
            if (!UserLevelToggle.INSTANCE.f()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("ContentViewHolder", "renderUserLevelIcon is unenable by toggle");
                return;
            }
            if (aVar != null && (gVarArr = aVar.f393058j) != null && gVarArr.length != 0) {
                int i3 = 0;
                while (true) {
                    sr4.g[] gVarArr2 = aVar.f393058j;
                    if (i3 < gVarArr2.length) {
                        sr4.g gVar2 = gVarArr2[i3];
                        if (gVar2.f434388d == 7 && !TextUtils.isEmpty(gVar2.f434403s)) {
                            gVar = aVar.f393058j[i3];
                            break;
                        }
                        i3++;
                    } else {
                        gVar = null;
                        break;
                    }
                }
                if (gVar == null) {
                    this.M.setVisibility(8);
                    return;
                } else {
                    UserLevelInfo userLevelInfo = new UserLevelInfo(gVar.f434397m, gVar.f434387c);
                    new com.tencent.timi.game.liveroom.impl.room.medal.render.e().a(new a(userLevelInfo, userLevelInfo), new c.a() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.f
                        @Override // com.tencent.timi.game.liveroom.impl.room.medal.c.a
                        public final void a(com.tencent.timi.game.liveroom.impl.room.medal.g gVar3, Object obj) {
                            d.b.this.x(gVar3, (Drawable) obj);
                        }
                    });
                    return;
                }
            }
            this.M.setVisibility(8);
        }

        public void y(d55.a aVar) {
            if (aVar == null) {
                this.Q.setImageUrl(null);
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("ContentViewHolder", 1, "renderAvatarPendant: no audienceInfo. unknown uid.");
                return;
            }
            d55.f fVar = aVar.f393059k;
            if (fVar == null) {
                this.Q.setImageUrl(null);
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("ContentViewHolder", 1, "renderAvatarPendant: no pendant. audienceUid: " + aVar.f393049a);
                return;
            }
            String str = fVar.f393069a;
            if (TextUtils.isEmpty(str)) {
                this.Q.setImageUrl(null);
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("ContentViewHolder", 1, "renderAvatarPendant: no pendant url valid. audienceUid:" + aVar.f393049a);
                return;
            }
            this.Q.setImageUrl(str);
        }

        public void z(d55.a aVar) {
            sr4.g[] gVarArr;
            sr4.g gVar;
            if (aVar != null && (gVarArr = aVar.f393058j) != null && gVarArr.length != 0) {
                int i3 = 0;
                while (true) {
                    sr4.g[] gVarArr2 = aVar.f393058j;
                    if (i3 < gVarArr2.length) {
                        if (!TextUtils.isEmpty(gVarArr2[i3].A) || !TextUtils.isEmpty(aVar.f393058j[i3].f434407w)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        gVar = null;
                        break;
                    }
                }
                gVar = aVar.f393058j[i3];
                if (gVar == null) {
                    this.L.setVisibility(8);
                    return;
                } else {
                    new com.tencent.timi.game.liveroom.impl.room.medal.render.c().a(new C9959b(gVar, gVar), new c.a() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.e
                        @Override // com.tencent.timi.game.liveroom.impl.room.medal.c.a
                        public final void a(com.tencent.timi.game.liveroom.impl.room.medal.g gVar2, Object obj) {
                            d.b.this.w(gVar2, (Drawable) obj);
                        }
                    });
                    return;
                }
            }
            this.L.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.rank.d$d, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9960d extends RecyclerView.ViewHolder {
        public C9960d(@NonNull View view) {
            super(view);
        }
    }

    public d(Activity activity, Context context, long j3, long j16) {
        this.D = activity;
        this.E = context;
        this.F = j3;
        this.G = j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveUserInfo o0(d55.a aVar) {
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.headUrl = aVar.f393052d;
        liveUserInfo.nick = aVar.f393053e;
        liveUserInfo.sex = aVar.f393054f;
        liveUserInfo.uid = aVar.f393049a;
        return liveUserInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0() {
        return !BusConfigHelper.f378723a.f(7, this.F);
    }

    private int q0(int i3) {
        int i16;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = R.color.bvq;
                } else {
                    i16 = R.color.bvp;
                }
            } else {
                i16 = R.color.bvo;
            }
        } else {
            i16 = R.color.bvn;
        }
        return this.E.getResources().getColor(i16);
    }

    private int r0(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return -1;
                }
                return R.drawable.o8e;
            }
            return R.drawable.o8d;
        }
        return R.drawable.o8c;
    }

    private int s0(int i3) {
        if (i3 == 1) {
            return R.drawable.o7q;
        }
        return R.drawable.o7r;
    }

    private int t0(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return -1;
                }
                return R.drawable.o6r;
            }
            return R.drawable.o6q;
        }
        return R.drawable.o6p;
    }

    private boolean u0() {
        if (this.C.size() >= this.f378884m) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3;
        int size = this.C.size() + this.H;
        if (u0()) {
            i3 = this.I;
        } else {
            i3 = 0;
        }
        return size + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int i16 = this.H;
        if (i16 != 0 && i3 < i16) {
            return 0;
        }
        if (u0() && this.I != 0 && i3 >= this.H + this.C.size()) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        long j3;
        String str;
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            d55.a aVar = this.C.get(i3);
            if (aVar == null) {
                return;
            }
            if (aVar.f393050b != 0) {
                int i16 = i3 + 1;
                bVar.E.setText(String.valueOf(i16));
                bVar.E.setTextColor(q0(i16));
                bVar.E.setTextSize(com.tencent.timi.game.liveroom.impl.room.view.rank.c.d(r10));
            } else {
                bVar.E.setText("--");
                bVar.E.setTextColor(q0(-1));
                bVar.E.setTextSize(14.0f);
            }
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            boolean J = cVar.J(cVar.p(), 1);
            TextView textView = bVar.G;
            if (J) {
                j3 = aVar.f393057i;
            } else {
                j3 = aVar.f393050b;
            }
            textView.setText(com.tencent.timi.game.liveroom.impl.room.view.rank.c.b(j3));
            if (cVar.J(cVar.p(), 1)) {
                TextView textView2 = bVar.H;
                if (aVar.f393051c > 999) {
                    str = "999+\u5206\u949f";
                } else {
                    str = aVar.f393051c + "\u5206\u949f";
                }
                textView2.setText(str);
                bVar.H.setVisibility(0);
            } else {
                bVar.H.setVisibility(8);
            }
            bVar.F.setText(com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().b(this.F, aVar.f393053e, aVar.f393049a, this.G));
            if (!TextUtils.isEmpty(aVar.f393052d)) {
                bVar.I.setImageUrl(aVar.f393052d);
                int i17 = i3 + 1;
                int t06 = t0(i17);
                int r06 = r0(i17);
                if (t06 != -1 && r06 != -1 && aVar.f393050b != 0) {
                    bVar.P.setImageResource(t06);
                    bVar.J.setImageResource(r06);
                    bVar.P.setVisibility(0);
                    bVar.J.setVisibility(0);
                } else {
                    bVar.P.setVisibility(4);
                    bVar.J.setVisibility(4);
                }
            }
            bVar.K.setImageResource(s0(aVar.f393054f));
            bVar.z(aVar);
            bVar.A(aVar);
            bVar.N.setOnClickListener(new a(aVar, bVar));
            bVar.y(aVar);
            return;
        }
        if (viewHolder instanceof c) {
            ((TextView) ((c) viewHolder).itemView.findViewById(R.id.yyv)).setText(String.format(ht3.a.d("rank_list_max_num_wording", "\u4ec5\u663e\u793a\u524d%d\u540d\u5728\u7ebf\u89c2\u4f17"), Long.valueOf(this.f378884m)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hxy, viewGroup, false));
        }
        if (i3 == 2) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hxz, viewGroup, false));
        }
        return new C9960d(new View(viewGroup.getContext()));
    }

    public void v0(List<d55.a> list, long j3) {
        this.C.clear();
        this.C.addAll(list);
        this.f378884m = Math.max(100L, j3);
        notifyDataSetChanged();
    }

    public void w0(com.tencent.timi.game.liveroom.impl.room.view.rank.b bVar) {
        this.J = bVar;
    }
}
