package com.tencent.timi.game.expand.hall.impl.teamtoast;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.timi.game.tim.api.message.d;
import com.tencent.timi.game.utils.l;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamToastViewModel extends ViewModel implements LifecycleEventObserver {
    private long E;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<com.tencent.timi.game.expand.hall.impl.teamtoast.a> f376957i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private b f376958m = new b();
    private int C = 3000;
    private volatile boolean D = true;
    private d F = new a();

    public TeamToastViewModel() {
        l.b("TeamToastViewModel", "Constructor call:" + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() throws InterruptedException {
        l.b("TeamToastViewModel", "executePostToUI");
        if (this.f376957i.hasObservers()) {
            com.tencent.timi.game.expand.hall.impl.teamtoast.a c16 = this.f376958m.c();
            while (c16 != null) {
                l.b("TeamToastViewModel", "executePostToUI \u53d1\u8f66\uff1a" + c16.b().uid.get());
                this.D = false;
                this.f376957i.postValue(c16);
                LockMethodProxy.sleep((long) this.C);
                c16 = this.f376958m.c();
            }
            l.b("TeamToastViewModel", "executePostToUI \u6240\u6709\u63d0\u9192\u5df2\u7ecf\u5904\u7406\u5b8c->idle");
            this.D = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction) {
        l.b("TeamToastViewModel", "onNewTeamToast:" + l.j(yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.owner_user_id.get().uid.get()) + "tips:" + yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.get().tips.get());
        this.f376958m.b(yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.owner_user_id.get(), yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.tips.get());
        if (this.D) {
            R1();
        }
    }

    private void R1() {
        new BaseThread(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.teamtoast.TeamToastViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TeamToastViewModel.this.O1();
                } catch (InterruptedException e16) {
                    l.e("TeamToastViewModel", e16.getMessage());
                }
            }
        }).start();
    }

    private void S1() {
        l.b("TeamToastViewModel", "regMessageListener");
        ((kn4.b) mm4.b.b(kn4.b.class)).r0(this.F);
    }

    private void U1() {
        l.b("TeamToastViewModel", "unRegMessageListener");
        ((kn4.b) mm4.b.b(kn4.b.class)).q2(this.F);
    }

    public MutableLiveData<com.tencent.timi.game.expand.hall.impl.teamtoast.a> P1() {
        return this.f376957i;
    }

    public void T1(long j3) {
        l.b("TeamToastViewModel", "setGroupID:" + j3);
        this.E = j3;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull @NotNull LifecycleOwner lifecycleOwner, @NonNull @NotNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            S1();
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            U1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void a(long j3, @NotNull MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody) {
            l.b("TeamToastViewModel", "groupId" + j3 + "msg type:" + messageOuterClass$TimMsgBody.msg_type.get() + "action type:" + messageOuterClass$TimMsgBody.content.yolo_room_action_msg.yolo_room_action.action_type.get());
            if (TeamToastViewModel.this.E == j3 && messageOuterClass$TimMsgBody.msg_type.get() == 49 && messageOuterClass$TimMsgBody.content.yolo_room_action_msg.yolo_room_action.action_type.get() == 152) {
                YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction = messageOuterClass$TimMsgBody.content.yolo_room_action_msg.yolo_room_action.yolo_game_room_team_create_tips_action.get();
                if (!TextUtils.isEmpty(yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.tips.get()) && yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.owner_user_id.uid.get() != 0) {
                    TeamToastViewModel.this.Q1(yoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction);
                }
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a aVar) {
        }
    }
}
