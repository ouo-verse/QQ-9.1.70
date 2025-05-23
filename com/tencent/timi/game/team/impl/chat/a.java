package com.tencent.timi.game.team.impl.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends BaseSlideUpDialog {
    private TextView T;
    private TextView U;
    private TextView V;
    private RecyclerView W;
    private RelativeLayout X;
    private h Y;
    private i Z;

    /* renamed from: a0, reason: collision with root package name */
    private f f379422a0;

    /* renamed from: b0, reason: collision with root package name */
    private e f379423b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.chat.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class ViewOnClickListenerC9972a implements View.OnClickListener {
        ViewOnClickListenerC9972a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.Z.a();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.Z.f379441a) {
                a.this.Z.c();
            } else {
                a.this.Z.d(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        String f379427a;

        /* renamed from: b, reason: collision with root package name */
        CommonOuterClass$QQUserId f379428b;

        public d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface e {
        void a(List<d> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f extends RecyclerView.Adapter {

        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.team.impl.chat.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class ViewOnClickListenerC9973a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f379431d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ YoloRoomOuterClass$YoloRoomSpeakingPosInfo f379432e;

            ViewOnClickListenerC9973a(RecyclerView.ViewHolder viewHolder, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo) {
                this.f379431d = viewHolder;
                this.f379432e = yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ((g) this.f379431d).E.performClick();
                d dVar = new d();
                dVar.f379427a = ((g) this.f379431d).G.h();
                dVar.f379428b = this.f379432e.user_id.get();
                if (((g) this.f379431d).E.isChecked()) {
                    a.this.Y.f379438b.add(dVar);
                } else {
                    a.this.Y.f379438b.remove(dVar);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f379434d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ YoloRoomOuterClass$YoloRoomSpeakingPosInfo f379435e;

            b(RecyclerView.ViewHolder viewHolder, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo) {
                this.f379434d = viewHolder;
                this.f379435e = yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                d dVar = new d();
                dVar.f379427a = ((g) this.f379434d).G.h();
                dVar.f379428b = this.f379435e.user_id.get();
                a.this.Y.f379438b.add(dVar);
                a.this.Z.c();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return a.this.Y.f379437a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            if (viewHolder instanceof g) {
                YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo = (YoloRoomOuterClass$YoloRoomSpeakingPosInfo) a.this.Y.f379437a.get(i3);
                g gVar = (g) viewHolder;
                gVar.F.setUserId(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.get());
                gVar.G.setUserId(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.get());
                if (a.this.Z.f379441a) {
                    gVar.E.setVisibility(0);
                    viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC9973a(viewHolder, yoloRoomOuterClass$YoloRoomSpeakingPosInfo));
                } else {
                    gVar.E.setVisibility(8);
                    viewHolder.itemView.setOnClickListener(new b(viewHolder, yoloRoomOuterClass$YoloRoomSpeakingPosInfo));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hwl, viewGroup, false));
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class g extends RecyclerView.ViewHolder {
        CheckBox E;
        AvatarRoundImageView F;
        AvatarTextView G;

        public g(@NonNull View view) {
            super(view);
            this.E = (CheckBox) view.findViewById(R.id.swj);
            this.F = (AvatarRoundImageView) view.findViewById(R.id.swi);
            this.G = (AvatarTextView) view.findViewById(R.id.swk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        private List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> f379437a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private List<d> f379438b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private CommonOuterClass$QQUserId f379439c = new CommonOuterClass$QQUserId();

        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        boolean f379441a = false;

        i() {
        }

        void a() {
            a.this.Y.f379438b.clear();
            c();
        }

        void b(long j3) {
            a.this.Y.f379437a.clear();
            a.this.Y.f379437a.addAll(((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).n());
            CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
            Iterator it = a.this.Y.f379437a.iterator();
            while (it.hasNext()) {
                YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo = (YoloRoomOuterClass$YoloRoomSpeakingPosInfo) it.next();
                if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get() == 0 || ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, E)) {
                    it.remove();
                }
            }
            a.this.Y.f379439c = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).R();
            a.this.f379422a0.notifyDataSetChanged();
        }

        void c() {
            a.this.dismiss();
            Iterator it = a.this.Y.f379438b.iterator();
            while (it.hasNext()) {
                l.i("TeamAtListView", ((d) it.next()).f379427a);
            }
            if (a.this.f379423b0 != null) {
                a.this.f379423b0.a(a.this.Y.f379438b);
            }
        }

        void d(boolean z16) {
            this.f379441a = z16;
            a.this.f379422a0.notifyDataSetChanged();
            if (z16) {
                a.this.V.setText("\u5b8c\u6210");
            } else {
                a.this.V.setText("\u591a\u9009");
            }
        }
    }

    a(Context context) {
        super(context);
        this.Y = new h();
        this.Z = new i();
        this.f379422a0 = new f();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tzt);
        this.T = textView;
        textView.setOnClickListener(new ViewOnClickListenerC9972a());
        this.U = (TextView) findViewById(R.id.jq_);
        TextView textView2 = (TextView) findViewById(R.id.u4j);
        this.V = textView2;
        textView2.setOnClickListener(new b());
        this.W = (RecyclerView) findViewById(R.id.swl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.W.setLayoutManager(linearLayoutManager);
        this.W.setAdapter(this.f379422a0);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.b8q);
        this.X = relativeLayout;
        e0(relativeLayout);
        f0();
        O(new c());
    }

    public static boolean p0() {
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(((fm4.g) mm4.b.b(fm4.g.class)).K0(z16.room_id.get()).n());
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo = (YoloRoomOuterClass$YoloRoomSpeakingPosInfo) it.next();
            if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, E) || ll4.b.b(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id)) {
                it.remove();
            }
        }
        if (arrayList.size() == 0) {
            return false;
        }
        return true;
    }

    public static a q0(e eVar) {
        l.i("TeamAtListView", "showAtList");
        QBaseActivity b16 = vf4.a.b();
        if (b16 == null) {
            return null;
        }
        a aVar = new a(b16);
        aVar.show();
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 != null) {
            aVar.o0(z16.room_id.get(), eVar);
        }
        return aVar;
    }

    public void o0(long j3, e eVar) {
        l.i("TeamAtListView", "bindAtList");
        this.f379423b0 = eVar;
        this.Z.b(j3);
        if (this.Y.f379437a.size() == 1) {
            this.V.setVisibility(8);
        } else {
            this.V.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwm);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements com.tencent.timi.game.ui.widget.g {
        c() {
        }

        @Override // com.tencent.timi.game.ui.widget.g
        public void onCancel(DialogInterface dialogInterface) {
            a.this.Z.a();
        }

        @Override // com.tencent.timi.game.ui.widget.g
        public void onDismiss(DialogInterface dialogInterface) {
        }

        @Override // com.tencent.timi.game.ui.widget.g
        public void onShow(DialogInterface dialogInterface) {
        }
    }
}
