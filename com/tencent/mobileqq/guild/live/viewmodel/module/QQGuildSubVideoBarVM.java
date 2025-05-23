package com.tencent.mobileqq.guild.live.viewmodel.module;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.anchor.g;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import vh2.cb;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildSubVideoBarVM extends com.tencent.mobileqq.guild.live.viewmodel.a {
    private static final Map<Integer, Integer> C = new HashMap<Integer, Integer>() { // from class: com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildSubVideoBarVM.1
        {
            Integer valueOf = Integer.valueOf(R.string.f147740xp);
            put(1002, valueOf);
            put(1003, Integer.valueOf(R.string.f147750xq));
            put(1006, Integer.valueOf(R.string.f147720xn));
            put(1009, Integer.valueOf(R.string.f147730xo));
            put(1010, Integer.valueOf(R.string.f147760xr));
            put(1011, valueOf);
            put(1012, Integer.valueOf(R.string.f147710xm));
        }
    };
    private static final Set<Integer> D = new HashSet<Integer>(1) { // from class: com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildSubVideoBarVM.2
        {
            add(-1);
            add(999);
            add(1004);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final cn<String> f226969i = new cn<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f226970m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f226971d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildSubVideoBarVM$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public class C7815a implements Observer<QQLiveAnchorDataPrepare> {
            C7815a() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
                GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_SDK_PRE_PREPARE_ANCHOR_ROOM);
            }
        }

        a(g gVar) {
            this.f226971d = gVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_SDK_PRE_CREATE_ANCHOR_ROOM);
            if (bool == Boolean.TRUE) {
                GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_PRE_PREPARE_ANCHOR_ROOM);
                this.f226971d.z(null).observeForever(new C7815a());
            } else {
                QLog.e("QGL.QQGuildSubVideoBarVM", 1, "prepareRoom, create room fail.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f226974d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f226975e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f226976f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ e12.a f226977h;

        b(LiveData liveData, WeakReference weakReference, g gVar, e12.a aVar) {
            this.f226974d = liveData;
            this.f226975e = weakReference;
            this.f226976f = gVar;
            this.f226977h = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            this.f226974d.removeObserver(this);
            if (this.f226975e.get() == 0) {
                QLog.e("QGL.QQGuildSubVideoBarVM", 1, "weakRefAct.get() == null.");
                return;
            }
            if (bool == Boolean.TRUE) {
                GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_SDK_CREATE_ANCHOR_ROOM);
                QQGuildSubVideoBarVM.this.W1(this.f226976f, (Activity) this.f226975e.get(), this.f226977h);
            } else {
                QLog.e("QGL.QQGuildSubVideoBarVM", 1, "create room fail.");
                this.f226977h.setValue(Boolean.FALSE);
                QQGuildSubVideoBarVM.this.f226969i.setValue(HardCodeUtil.qqStr(R.string.f147700xl));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e12.a f226979d;

        c(e12.a aVar) {
            this.f226979d = aVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null) {
                QLog.i("QGL.QQGuildSubVideoBarVM", 1, "listenStartCheckEvent onChanged: " + bool);
                QQGuildSubVideoBarVM.this.f226970m = false;
                this.f226979d.removeObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements Observer<QQLiveAnchorDataPrepare> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f226981d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f226982e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e12.a f226983f;

        d(LiveData liveData, g gVar, e12.a aVar) {
            this.f226981d = liveData;
            this.f226982e = gVar;
            this.f226983f = aVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            this.f226981d.removeObserver(this);
            if (qQLiveAnchorDataPrepare.isSuccess) {
                GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_SDK_PREPARE_ANCHOR_ROOM);
                QQGuildSubVideoBarVM.this.Z1(String.valueOf(this.f226982e.I()), String.valueOf(this.f226982e.H()), this.f226983f);
                return;
            }
            QLog.e("QGL.QQGuildSubVideoBarVM", 1, "anchorPrepareRoom fail.");
            if (qQLiveAnchorDataPrepare.errorMsg != null) {
                QLog.e("QGL.QQGuildSubVideoBarVM", 1, "errorMsg=" + qQLiveAnchorDataPrepare.errorMsg.toString());
                QQGuildSubVideoBarVM.this.U1(qQLiveAnchorDataPrepare.errorMsg.originErrCode);
            } else {
                QQGuildSubVideoBarVM.this.f226969i.setValue(HardCodeUtil.qqStr(R.string.f147700xl));
            }
            this.f226983f.setValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements cb {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226985a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226986b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e12.a f226987c;

        e(String str, String str2, e12.a aVar) {
            this.f226985a = str;
            this.f226986b = str2;
            this.f226987c = aVar;
        }

        @Override // vh2.cb
        public void a(int i3, String str, int i16, String str2) {
            GuildTimeRecHelper.d(GuildLiveTimeEvent.REMOVE_BAN_BEFORE_BROADCAST);
            boolean z16 = true;
            QLog.i("QGL.QQGuildSubVideoBarVM", 1, "onRemoveBanBeforeBroadcast, uid:" + this.f226985a + " roomId:" + this.f226986b + " result:" + i3 + " removeBanText:" + str2);
            if (i3 != 0) {
                z16 = false;
            }
            this.f226987c.setValue(Boolean.valueOf(z16));
            if (!z16 && !TextUtils.isEmpty(str2)) {
                QQGuildSubVideoBarVM.this.f226969i.setValue(str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("result_code", String.valueOf(i16));
            hashMap.put("remove_ban_text", str2);
            l.g("live_room_remove_ban_callback", hashMap, i3, str);
        }
    }

    private void T1(e12.a<Boolean> aVar) {
        c cVar = new c(aVar);
        this.f226970m = true;
        aVar.observeForever(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(int i3) {
        Map<Integer, Integer> map = C;
        if (map.containsKey(Integer.valueOf(i3))) {
            this.f226969i.setValue(HardCodeUtil.qqStr(map.get(Integer.valueOf(i3)).intValue()));
        } else if (!D.contains(Integer.valueOf(i3))) {
            this.f226969i.setValue(HardCodeUtil.qqStr(R.string.f147700xl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(g gVar, Activity activity, e12.a<Boolean> aVar) {
        GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_PREPARE_ANCHOR_ROOM);
        LiveData<QQLiveAnchorDataPrepare> z16 = gVar.z(activity);
        z16.observeForever(new d(z16, gVar, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(String str, String str2, e12.a<Boolean> aVar) {
        GuildTimeRecHelper.g(GuildLiveTimeEvent.REMOVE_BAN_BEFORE_BROADCAST);
        l.c("live_room_remove_ban_start");
        ((IGPSService) L1().getRuntimeService(IGPSService.class, "")).removeBanBeforeBroadcast(str, str2, new e(str, str2, aVar));
    }

    public LiveData<Boolean> R1(Activity activity) {
        WeakReference weakReference = new WeakReference(activity);
        e12.a<Boolean> aVar = new e12.a<>();
        T1(aVar);
        AppRuntime L1 = L1();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (!h.m(L1, Constants.Business.QQ_GUILD_LIVE_AUTHOR, gLiveChannelCore.g())) {
            QLog.i("QGL.QQGuildSubVideoBarVM", 1, "requestAVFocus failure.");
            aVar.setValue(Boolean.FALSE);
            return aVar;
        }
        g n3 = gLiveChannelCore.n();
        QQLiveAnchorDataPrepare value = n3.f226767e.getValue();
        if (value != null && value.isSuccess) {
            QLog.i("QGL.QQGuildSubVideoBarVM", 1, "room had prepared, go to removeBanBeforeBroadcast.");
            Z1(String.valueOf(n3.I()), String.valueOf(n3.H()), aVar);
            return aVar;
        }
        GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_CREATE_ANCHOR_ROOM);
        LiveData<Boolean> E = n3.E();
        E.observeForever(new b(E, weakReference, n3, aVar));
        return aVar;
    }

    public LiveData<String> S1() {
        return this.f226969i;
    }

    public void X1() {
        if (this.f226970m) {
            QLog.i("QGL.QQGuildSubVideoBarVM", 1, "mIsUserChecking, ignore.");
            return;
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.s().isLiving()) {
            QLog.i("QGL.QQGuildSubVideoBarVM", 1, "prepareRoomInBackgroundIfNeed, room id is valid, ignore.");
            return;
        }
        boolean allowStartLive = gLiveChannelCore.s().getAllowStartLive();
        g n3 = gLiveChannelCore.n();
        QQLiveAnchorDataPrepare value = n3.f226767e.getValue();
        if (allowStartLive) {
            if (value == null || !value.isSuccess) {
                GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_PRE_CREATE_ANCHOR_ROOM);
                n3.E().observeForever(new a(n3));
            }
        }
    }
}
