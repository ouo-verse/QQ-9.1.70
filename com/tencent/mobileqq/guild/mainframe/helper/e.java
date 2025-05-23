package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.jump.GuildJumpAction;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.helper.jump.m;
import com.tencent.mobileqq.guild.mainframe.helper.jump.n;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends k {

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, com.tencent.mobileqq.guild.mainframe.helper.jump.c> f227430e;

    public e(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227430e = new ConcurrentHashMap<>();
        j(iVar);
    }

    private void j(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227276t), new com.tencent.mobileqq.guild.mainframe.helper.jump.i(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227277u), new com.tencent.mobileqq.guild.mainframe.helper.jump.i(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227279w), new m(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227278v), new com.tencent.mobileqq.guild.mainframe.helper.jump.h(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227280x), new com.tencent.mobileqq.guild.mainframe.helper.jump.k(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227281y), new com.tencent.mobileqq.guild.mainframe.helper.jump.j(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.f227282z), new com.tencent.mobileqq.guild.mainframe.helper.jump.j(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.A), new com.tencent.mobileqq.guild.mainframe.helper.jump.j(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.C), new com.tencent.mobileqq.guild.mainframe.helper.jump.j(iVar));
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.D), new n());
        this.f227430e.put(Integer.valueOf(GuildMainFrameConstants.E), new com.tencent.mobileqq.guild.mainframe.helper.jump.b(iVar));
    }

    public void i(Bundle bundle) {
        if (bundle == null) {
            QLog.e("Guild.jump.GuildMFJumpHelper", 1, "handleJumpAction jumpExtra is null");
            return;
        }
        int i3 = bundle.getInt("goto_guildtab_actiontype", 0);
        Bundle bundle2 = bundle.getBundle("goto_guildtab_actionextra");
        GuildJumpDebugUtils.a("Guild.jump.GuildMFJumpHelper", "GuildMFJumpHelper::handleJumpAction(): jumpExtra = ", bundle);
        if (i3 != 0) {
            if (this.f227430e.get(Integer.valueOf(i3)) != null) {
                this.f227430e.get(Integer.valueOf(i3)).a(bundle2);
            }
            QLog.i("Guild.jump.GuildMFJumpHelper", 1, "handleJumpAction actionType:" + i3);
            return;
        }
        if (bundle2 == null) {
            QLog.i("Guild.jump.GuildMFJumpHelper", 1, "handleJumpAction actionType:" + i3);
            return;
        }
        String string = bundle2.getString("appChannel", "");
        QLog.i("Guild.jump.GuildMFJumpHelper", 1, "handleJumpAction jump2GuildTab succ appChannel=" + string);
        if (!TextUtils.isEmpty(string)) {
            GuildJumpAction.U(new kh1.a(0, ""), string, bundle2.getString("url", ""));
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        super.onResume(z16);
    }
}
