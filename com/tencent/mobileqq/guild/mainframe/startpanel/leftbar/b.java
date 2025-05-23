package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager;
import com.tencent.mobileqq.guild.widget.LeftBarAvatarFrameLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b implements DragFrameLayout.b, DragFrameLayout.a {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<GuildLeftBarListAdapter> f227618d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<View> f227619e = null;

    public b(GuildLeftBarListAdapter guildLeftBarListAdapter) {
        this.f227618d = new WeakReference<>(guildLeftBarListAdapter);
    }

    private void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof cs1.e) {
            cs1.e eVar = (cs1.e) tag;
            String t16 = GuildLeftBarRepo.t(eVar.f391795d, eVar.f391796e);
            if (this.f227618d.get() != null) {
                this.f227618d.get().p0(t16);
                d(eVar.f391796e, this.f227618d.get());
            }
            h(view, false);
            return;
        }
        if (tag instanceof String) {
            String str = (String) tag;
            if (TextUtils.equals(str, "GuildLeftBarPersonalView")) {
                if (this.f227618d.get() != null) {
                    c(this.f227618d.get());
                }
                h(view, false);
            } else if (TextUtils.equals(str, "GuildInboxTitleHeaderView")) {
                if (this.f227618d.get() != null) {
                    c(this.f227618d.get());
                    return;
                }
                return;
            }
            e(str);
        }
    }

    private void b(GuildLeftBarListAdapter guildLeftBarListAdapter) {
        GuildLeftBarViewModel mLeftBarViewModel = guildLeftBarListAdapter.getMLeftBarViewModel();
        if (mLeftBarViewModel == null) {
            return;
        }
        mLeftBarViewModel.l2((LinkedHashSet) guildLeftBarListAdapter.u0());
    }

    private void c(GuildLeftBarListAdapter guildLeftBarListAdapter) {
        GuildLeftBarViewModel mLeftBarViewModel = guildLeftBarListAdapter.getMLeftBarViewModel();
        if (mLeftBarViewModel == null) {
            return;
        }
        mLeftBarViewModel.n2();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarDragListener", 2, "dealDragInboxNodeRedDot");
        }
    }

    private void d(String str, GuildLeftBarListAdapter guildLeftBarListAdapter) {
        GuildLeftBarViewModel mLeftBarViewModel = guildLeftBarListAdapter.getMLeftBarViewModel();
        if (mLeftBarViewModel == null) {
            return;
        }
        mLeftBarViewModel.m2(str);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarDragListener", 2, "dealDragNormalGuildNodeRedDot guildId", str);
        }
    }

    private void e(String str) {
        GuildLeftBarListAdapter guildLeftBarListAdapter;
        if (!str.equals(com.tencent.mobileqq.activity.home.impl.b.f183056s) || (guildLeftBarListAdapter = this.f227618d.get()) == null) {
            return;
        }
        guildLeftBarListAdapter.o0();
        b(guildLeftBarListAdapter);
        c(guildLeftBarListAdapter);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarDragListener", 2, "dealDragTabRedDot");
        }
    }

    private boolean f(View view) {
        Object tag = view.getTag();
        if ((tag instanceof String) && TextUtils.equals((String) tag, com.tencent.mobileqq.activity.home.impl.b.f183056s)) {
            return true;
        }
        return false;
    }

    public void g() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onStartBornAll ");
        Object obj = this.f227619e;
        if (obj == null) {
            obj = "";
        }
        sb5.append(obj);
        sb5.append(" ");
        sb5.append(this.f227618d.get());
        QLog.i("Guild.MF.Lt.GuildLeftBarDragListener", 1, sb5.toString());
        WeakReference<View> weakReference = this.f227619e;
        if (weakReference != null && weakReference.get() != null) {
            a(this.f227619e.get());
        }
        com.tencent.mobileqq.guild.report.e.c("drag");
    }

    public void h(View view, boolean z16) {
        LeftBarAvatarFrameLayout leftBarAvatarFrameLayout = (LeftBarAvatarFrameLayout) ((ViewGroup) view.getParent()).findViewById(R.id.t18);
        if (leftBarAvatarFrameLayout != null) {
            leftBarAvatarFrameLayout.setUnreadPointHoleShow(z16);
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        boolean j3 = GuildMainFrameRedDragManager.i().j();
        Object obj = "";
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInGuildTab()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onChange isInGuildTab=false ");
            sb5.append(z16);
            sb5.append(" dragType=");
            sb5.append(i3);
            sb5.append(" from=");
            Object obj2 = qUIBadgeDragLayout;
            if (qUIBadgeDragLayout == null) {
                obj2 = "";
            }
            sb5.append(obj2);
            sb5.append(" isDragging=");
            sb5.append(j3);
            QLog.w("Guild.MF.Lt.GuildLeftBarDragListener", 1, sb5.toString());
            return;
        }
        Object[] objArr = new Object[8];
        objArr[0] = "onChange ";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = " dragType=";
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = " from=";
        if (qUIBadgeDragLayout != null) {
            obj = qUIBadgeDragLayout;
        }
        objArr[5] = obj;
        objArr[6] = " isDragging=";
        objArr[7] = Boolean.valueOf(j3);
        QLog.d("Guild.MF.Lt.GuildLeftBarDragListener", 1, objArr);
        if (j3) {
            GuildMainFrameRedDragManager.i().g("Guild.MF.Lt.GuildLeftBarDragListener onChange", z16);
        }
        if (!z16) {
            WeakReference<View> weakReference = this.f227619e;
            if (weakReference != null && weakReference.get() != null) {
                h(this.f227619e.get(), true);
                return;
            }
            return;
        }
        if (qUIBadgeDragLayout != null && qUIBadgeDragLayout.getDragView() != null && !f(qUIBadgeDragLayout.getDragView())) {
            a(qUIBadgeDragLayout.getDragView());
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float f16, float f17, int i3, View view) {
        Object obj;
        Object obj2 = "";
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInGuildTab()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onDrag isInGuildTab=false mode=");
            sb5.append(i3);
            sb5.append(" draggedView=");
            Object obj3 = view;
            if (view == null) {
                obj3 = "";
            }
            sb5.append(obj3);
            QLog.w("Guild.MF.Lt.GuildLeftBarDragListener", 1, sb5.toString());
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "onDrag mode=";
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = " draggedView=";
            if (view == null) {
                obj = "";
            } else {
                obj = view;
            }
            objArr[3] = obj;
            QLog.d("Guild.MF.Lt.GuildLeftBarDragListener", 1, objArr);
        }
        boolean j3 = GuildMainFrameRedDragManager.i().j();
        if (i3 != 1 && i3 != 2) {
            if (i3 == -1 && j3) {
                GuildMainFrameRedDragManager.i().f("Guild.MF.Lt.GuildLeftBarDragListener onDrag idle");
            }
        } else if (!j3) {
            GuildMainFrameRedDragManager i16 = GuildMainFrameRedDragManager.i();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Guild.MF.Lt.GuildLeftBarDragListener draggedView=");
            if (view != null) {
                obj2 = view;
            }
            sb6.append(obj2);
            i16.m(sb6.toString());
        }
        if (i3 == -1 && view != null) {
            this.f227619e = new WeakReference<>(view);
        } else if (view != null) {
            h(view, false);
        }
    }
}
