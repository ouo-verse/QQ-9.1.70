package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.viewmodel.g;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import uc2.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusFriendListFragment extends QPublicBaseFragment implements g.a, q45.a, q45.c {
    private RecyclerView C;
    private uc2.f D;
    private com.tencent.mobileqq.onlinestatus.viewmodel.g E;

    @Nullable
    private q45.b F;
    private long G = 0;
    private boolean H = false;
    public Rect I = new Rect();

    private int getPageId() {
        return 0;
    }

    private void initUI() {
        this.D = new uc2.f(getContext());
        List<com.tencent.mobileqq.onlinestatus.model.i> value = this.E.P1().getValue();
        if (value != null && !value.isEmpty()) {
            this.D.k0(value);
        }
        this.D.D0(new f.b() { // from class: com.tencent.mobileqq.onlinestatus.view.at
            @Override // uc2.f.b
            public final void a(com.tencent.mobileqq.onlinestatus.model.d dVar, int i3) {
                OnlineStatusFriendListFragment.this.th(dVar, i3);
            }
        });
        RecyclerView recyclerView = this.C;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(this.D);
        recyclerView.addItemDecoration(new tc2.b(ViewUtils.dpToPx(10.0f)));
        q45.b bVar = this.F;
        if (bVar != null && bVar.Bc(getPageId())) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
    }

    private void initViewModel() {
        com.tencent.mobileqq.mvvm.d ph5 = QLifeCycleFragment.ph(getQBaseActivity());
        this.H = true;
        com.tencent.mobileqq.onlinestatus.viewmodel.g gVar = (com.tencent.mobileqq.onlinestatus.viewmodel.g) com.tencent.mobileqq.mvvm.h.b(ph5, new com.tencent.mobileqq.onlinestatus.viewmodel.h()).get(com.tencent.mobileqq.onlinestatus.viewmodel.g.class);
        this.E = gVar;
        gVar.U1(this);
        this.E.N1(ph5);
        q45.b bVar = this.F;
        if (bVar != null && bVar.Bc(getPageId())) {
            this.E.T1();
        }
    }

    private List<Long> sh(List<com.tencent.mobileqq.onlinestatus.model.i> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (com.tencent.mobileqq.onlinestatus.model.i iVar : list) {
                List<com.tencent.mobileqq.onlinestatus.model.d> list2 = iVar.f256029b;
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<com.tencent.mobileqq.onlinestatus.model.d> it = iVar.f256029b.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(it.next().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x()));
                    }
                }
            }
        } catch (NumberFormatException e16) {
            QLog.e("OnlineStatusFriendListFragment", 1, "[getNeedUpdateUinList]: exception is " + e16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(com.tencent.mobileqq.onlinestatus.model.d dVar, int i3) {
        int size;
        List<com.tencent.mobileqq.onlinestatus.model.d> O1 = this.E.O1();
        if (O1 != null && !O1.isEmpty() && i3 >= 0 && i3 < O1.size()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.G < 1000) {
                return;
            }
            if (OnlineStatusToggleUtils.n()) {
                com.tencent.mobileqq.onlinestatus.utils.w.a(com.tencent.mobileqq.onlinestatus.x.e(dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), dVar.getStatus().F()));
            }
            this.G = currentTimeMillis;
            com.tencent.mobileqq.onlinestatus.view.withAvatar.m.b(getQBaseActivity(), O1, i3, 4, new WeakReference(this));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("show dialog error! [ dataSize: ");
        if (O1 == null) {
            size = 0;
        } else {
            size = O1.size();
        }
        sb5.append(size);
        sb5.append(" flatIndex: ");
        sb5.append(i3);
        sb5.append(" ]");
        QLog.d("OnlineStatusFriendListFragment", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit uh(Boolean bool, Map map) {
        QLog.i("OnlineStatusFriendListFragment", 1, "[tryUpdateFriendListAvatarSwitch]: updateFriendSwitch result is " + bool);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(List list) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IOnlineStatusAvatarSwitchService iOnlineStatusAvatarSwitchService = (IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "");
        List<Long> sh5 = sh(list);
        if (sh5.isEmpty()) {
            return;
        }
        QLog.i("OnlineStatusFriendListFragment", 1, "tryUpdateFriendListAvatarSwitch size is " + sh5.size());
        iOnlineStatusAvatarSwitchService.updateFriendSwitchStatus(sh5, new Function2() { // from class: com.tencent.mobileqq.onlinestatus.view.au
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit uh5;
                uh5 = OnlineStatusFriendListFragment.uh((Boolean) obj, (Map) obj2);
                return uh5;
            }
        });
    }

    private void wh(final List<com.tencent.mobileqq.onlinestatus.model.i> list) {
        if (!this.H) {
            return;
        }
        this.H = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.as
            @Override // java.lang.Runnable
            public final void run() {
                OnlineStatusFriendListFragment.this.vh(list);
            }
        }, 16, null, true);
    }

    @Override // q45.c
    /* renamed from: if, reason: not valid java name */
    public void mo209if(int i3, int i16) {
        com.tencent.mobileqq.onlinestatus.viewmodel.g gVar;
        if (i3 == getPageId()) {
            if ((i16 == 0 || i16 == 1) && (gVar = this.E) != null) {
                gVar.T1();
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        uc2.f fVar;
        if (OnlineStatusToggleUtils.n() && (fVar = this.D) != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.viewmodel.g.a
    public void o3(List<com.tencent.mobileqq.onlinestatus.model.i> list) {
        if (this.D != null) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusFriendListFragment", 1, "size = " + list.size());
            }
            if (list.isEmpty()) {
                this.D.j0();
            } else {
                this.D.k0(list);
                wh(list);
            }
        }
    }

    @Override // q45.a
    public void ob(@NonNull q45.b bVar) {
        this.F = bVar;
        if (bVar != null) {
            bVar.sd(this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        getQBaseActivity().getSupportFragmentManager().popBackStack();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mobileqq.onlinestatus.utils.w.d(this.C, "pg_bas_friend_status_aggregation", null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        RecyclerView recyclerView = this.C;
        if (recyclerView != null) {
            if (recyclerView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.C.getParent()).removeView(this.C);
            }
        } else {
            this.C = new RecyclerView(layoutInflater.getContext());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            Rect rect = this.I;
            marginLayoutParams.setMargins(rect.left, rect.top, rect.right, rect.bottom);
            this.C.setLayoutParams(marginLayoutParams);
        }
        com.tencent.mobileqq.onlinestatus.utils.w.h(this.C, "pg_bas_friend_status_aggregation", null);
        RecyclerView recyclerView2 = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, recyclerView2);
        return recyclerView2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.F = null;
        com.tencent.mobileqq.onlinestatus.utils.w.e(this.C, "pg_bas_friend_status_aggregation", null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.tencent.mobileqq.onlinestatus.viewmodel.g gVar = this.E;
        if (gVar != null) {
            gVar.destroy();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViewModel();
        initUI();
    }
}
