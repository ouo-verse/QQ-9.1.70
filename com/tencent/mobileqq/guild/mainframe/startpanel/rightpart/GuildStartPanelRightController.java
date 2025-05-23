package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.mainframe.util.j;
import com.tencent.mobileqq.guild.performance.report.m;
import com.tencent.qphone.base.util.QLog;
import gs1.b;
import gs1.c;
import hs1.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes14.dex */
public class GuildStartPanelRightController extends k {

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<c> f227652e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f227653f;

    /* renamed from: h, reason: collision with root package name */
    private int f227654h;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface RightFrameType {
    }

    public GuildStartPanelRightController(i iVar) {
        super(iVar);
        this.f227652e = new ArrayList<>();
        this.f227654h = 0;
        o();
    }

    private c j(int i3) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.k() == i3) {
                return next;
            }
        }
        return null;
    }

    private void o() {
        this.f227652e.add(new b(this.f227466d));
        this.f227652e.add(new a(this.f227466d));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().b(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k
    public void h(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            this.f227653f = viewGroup;
            Iterator<c> it = this.f227652e.iterator();
            while (it.hasNext()) {
                it.next().n(viewGroup);
            }
        }
    }

    public boolean i(String str) {
        c j3 = j(this.f227654h);
        if (j3 != null) {
            return j3.j(str);
        }
        QLog.w("Guild.MF.Rt.GuildStartPanelRightController", 1, "change2OtherChannelInCurrentGuild not find child by channelId. " + this.f227654h);
        return false;
    }

    public String k(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "NONE";
                    }
                    return PatternUtils.NO_MATCH;
                }
                return "ME";
            }
            return "DISCOVER";
        }
        return "CHANNEL_LIST";
    }

    public int l() {
        return this.f227654h;
    }

    public void m(GuildCenterPanelController.b bVar) {
        c j3 = j(this.f227654h);
        if (j3 != null) {
            j3.m(bVar);
        }
    }

    public void n(int i3, cs1.b bVar, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        c j3;
        if (guildAppReportSourceInfo == null) {
            guildAppReportSourceInfo = this.f227466d.f0();
        }
        j.c("KEY_RIGHT_PART_LOAD");
        if (this.f227653f == null) {
            QLog.w("Guild.MF.Rt.GuildStartPanelRightController", 1, "openGuildFrame frameType=" + k(i3) + " but not init view first");
            return;
        }
        QLog.d("Guild.MF.Rt.GuildStartPanelRightController", 1, "openGuildFrame mCurShowFrameType=" + k(this.f227654h) + this.f227654h + " newFrameType=" + k(i3) + " jumpSourceInfo=" + guildAppReportSourceInfo);
        if (i3 == 4) {
            this.f227466d.Z0().r();
        }
        if (i3 == this.f227654h && (j3 = j(i3)) != null && !j3.i(bVar, guildAppReportSourceInfo)) {
            return;
        }
        this.f227654h = i3;
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.k() == i3) {
                next.o(bVar, guildAppReportSourceInfo);
            } else {
                next.l();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onActivityResult(int i3, int i16, Intent intent) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onBeforeAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onResume(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStart() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStop() {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onTabChanged(boolean z16) {
        Iterator<c> it = this.f227652e.iterator();
        while (it.hasNext()) {
            it.next().onTabChanged(z16);
        }
    }

    public void p(int i3) {
        ViewGroup viewGroup = this.f227653f;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.rightMargin = i3;
            this.f227653f.setLayoutParams(layoutParams);
        }
    }

    public boolean q(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        c j3;
        if (guildMainFrameJumpParam.f227440d.f227443d != null) {
            j3 = j(3);
        } else {
            j3 = j(1);
        }
        if (j3 != null) {
            return j3.p(guildMainFrameJumpParam.f227440d, guildMainFrameJumpParam.f227441e);
        }
        QLog.w("Guild.MF.Rt.GuildStartPanelRightController", 1, "showCenterPanelAnyWay failed. curFrameType=" + this.f227654h + " param=" + guildMainFrameJumpParam);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param=", String.valueOf(guildMainFrameJumpParam));
        m.j().e("Guild.MF.Rt.GuildStartPanelRightControllershowCenterPanelAnyWay", hashMap);
        return false;
    }

    public boolean r(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        c j3 = j(this.f227654h);
        if (j3 != null) {
            return j3.q(guildMainFrameJumpParam);
        }
        QLog.w("Guild.MF.Rt.GuildStartPanelRightController", 1, "showTargetCenterPanel not find child. " + this.f227654h);
        return false;
    }
}
