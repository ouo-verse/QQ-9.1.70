package com.tencent.timi.game.room.impl.doublecheck;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.j;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckPlayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RoomGameDoubleCheckDialog extends j {
    private View I;
    private View J;
    private TextView K;
    private RecyclerView L;
    private CommonButton M;
    private TextView N;
    private com.tencent.timi.game.room.impl.doublecheck.a P;
    private List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> Q;
    private long R;
    private long S;
    private Timer T;
    private TimerTask U;
    private d V;
    private long W;
    private boolean X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379204d;

        a(int i3) {
            this.f379204d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f379204d, 0, 0, 0);
            }
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
            YoloRoomManager j3 = com.tencent.timi.game.room.impl.d.g().j(RoomGameDoubleCheckDialog.this.W);
            if (j3 != null) {
                j3.f1(null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private Context f379207a;

        public c(Context context) {
            this.f379207a = context;
        }

        public RoomGameDoubleCheckDialog a(long j3, List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> list, long j16) {
            RoomGameDoubleCheckDialog roomGameDoubleCheckDialog = new RoomGameDoubleCheckDialog(this.f379207a);
            roomGameDoubleCheckDialog.X(j3);
            roomGameDoubleCheckDialog.c0(list, j16);
            roomGameDoubleCheckDialog.setCancelable(false);
            return roomGameDoubleCheckDialog;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface d {
        void a();
    }

    public RoomGameDoubleCheckDialog(@NonNull Context context) {
        this(context, R.style.au5);
    }

    private void U() {
        boolean z16;
        if (!this.X) {
            CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
            int i3 = 0;
            while (true) {
                if (i3 >= this.Q.size()) {
                    break;
                }
                YoloRoomOuterClass$YoloRoomDoubleCheckPlayer yoloRoomOuterClass$YoloRoomDoubleCheckPlayer = this.Q.get(i3);
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.user_id, E)) {
                    if (yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.is_check.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.X = z16;
                } else {
                    i3++;
                }
            }
            if (this.X) {
                this.M.setEnabled(false);
                this.M.setText("\u5df2\u786e\u8ba4");
                this.M.setTextColor(-7829368);
                this.M.setBackgroundResource(R.drawable.f162547lr2);
                this.M.setOnClickListener(null);
                return;
            }
            this.M.setEnabled(true);
            this.M.setText("\u786e\u8ba4");
            this.M.setTextColor(-1);
            this.M.setBackgroundResource(R.drawable.f162548lr3);
            this.M.setOnClickListener(new b());
        }
    }

    private void W() {
        Timer timer = this.T;
        if (timer != null) {
            timer.cancel();
            this.T.purge();
            this.T = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        int currentTimeMillis = (int) ((this.S - System.currentTimeMillis()) / 1000);
        this.N.setText(String.valueOf(currentTimeMillis));
        if (currentTimeMillis <= 0) {
            W();
            d dVar = this.V;
            if (dVar != null) {
                dVar.a();
            }
            if (isShowing()) {
                dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        int d16 = (int) ((this.R - yn4.d.d()) / 1000);
        this.K.setText("\u5373\u5c06\u5f00\u59cb " + d16 + "\u79d2");
        if (d16 <= 0) {
            W();
            if (isShowing()) {
                dismiss();
            }
        }
    }

    private void b0(d dVar) {
        this.V = dVar;
    }

    private void d0() {
        l.i("RoomGameDoubleCheckDialog", "startPrepareCoundDown ");
        W();
        this.T = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RoomGameDoubleCheckDialog.this.a0();
                    }
                });
            }
        };
        this.U = timerTask;
        this.T.schedule(timerTask, 1000L, 1000L);
        a0();
    }

    private void e0() {
        l.i("RoomGameDoubleCheckDialog", "switchToFinalLaunchGameCountDown ");
        this.S = System.currentTimeMillis() + 3000;
        this.I.setVisibility(8);
        this.J.setVisibility(0);
        W();
        this.T = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RoomGameDoubleCheckDialog.this.Z();
                    }
                });
            }
        };
        this.U = timerTask;
        this.T.schedule(timerTask, 1000L, 1000L);
        Z();
    }

    private void init(Context context) {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(Color.parseColor("#4C000000"));
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.hw7, (ViewGroup) null));
        this.I = findViewById(R.id.vkv);
        this.J = findViewById(R.id.vkr);
        this.K = (TextView) findViewById(R.id.vkx);
        this.L = (RecyclerView) findViewById(R.id.vky);
        this.M = (CommonButton) findViewById(R.id.vku);
        this.N = (TextView) findViewById(R.id.vkt);
        this.L.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.L.setHasFixedSize(true);
        this.L.addItemDecoration(new a(ViewUtils.dip2px(12.0f)));
        com.tencent.timi.game.room.impl.doublecheck.a aVar = new com.tencent.timi.game.room.impl.doublecheck.a(context, this.Q);
        this.P = aVar;
        this.L.setAdapter(aVar);
    }

    public void X(long j3) {
        this.W = j3;
    }

    public void Y(d dVar) {
        b0(dVar);
        e0();
    }

    public void c0(List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> list, long j3) {
        if (j3 > 0) {
            this.R = j3;
        }
        if (list != null && list.size() > 0) {
            this.Q.clear();
            for (YoloRoomOuterClass$YoloRoomDoubleCheckPlayer yoloRoomOuterClass$YoloRoomDoubleCheckPlayer : list) {
                if (yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.user_id.yes_uid.get() != 0) {
                    this.Q.add(yoloRoomOuterClass$YoloRoomDoubleCheckPlayer);
                }
            }
        }
        com.tencent.timi.game.room.impl.doublecheck.a aVar = this.P;
        if (aVar != null) {
            aVar.k0(this.Q, this.W);
        }
        U();
    }

    @Override // com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        W();
    }

    @Override // com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        d0();
    }

    public RoomGameDoubleCheckDialog(@NonNull Context context, int i3) {
        super(context, i3);
        this.Q = new ArrayList();
        this.X = false;
        init(context);
    }
}
