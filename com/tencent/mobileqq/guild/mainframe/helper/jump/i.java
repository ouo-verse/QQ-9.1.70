package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.i f227459a;

    public i(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227459a = iVar;
    }

    private boolean b(Intent intent, Bundle bundle, String str) {
        boolean z16;
        if (intent != null) {
            z16 = intent.getBooleanExtra(str, false);
        } else {
            z16 = false;
        }
        if (!z16 && bundle != null) {
            return bundle.getBoolean(str, false);
        }
        return z16;
    }

    private Bundle c(Intent intent, Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (intent != null) {
            bundle2 = intent.getBundleExtra(str);
        }
        if (bundle2 == null && bundle != null) {
            return bundle.getBundle(str);
        }
        return bundle2;
    }

    private int d(Intent intent, Bundle bundle, String str) {
        int i3;
        if (intent != null) {
            i3 = intent.getIntExtra(str, 0);
        } else {
            i3 = 0;
        }
        if (i3 == 0 && bundle != null) {
            return bundle.getInt(str, 0);
        }
        return i3;
    }

    private String e(Intent intent, Bundle bundle, String str) {
        String str2;
        if (intent != null) {
            str2 = intent.getStringExtra(str);
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2) && bundle != null) {
            return bundle.getString(str);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(Bundle bundle) {
        com.tencent.mobileqq.guild.mainframe.i iVar = this.f227459a;
        if (iVar == null) {
            return;
        }
        Intent intent = iVar.getActivity().getIntent();
        LaunchGuildChatPieParam launchGuildChatPieParam = new LaunchGuildChatPieParam();
        launchGuildChatPieParam.f214354d = e(intent, bundle, "guild_id");
        launchGuildChatPieParam.f214355e = e(intent, bundle, "uin");
        launchGuildChatPieParam.f214357h = d(intent, bundle, "channel_type");
        launchGuildChatPieParam.f214356f = e(intent, bundle, "channel_name");
        launchGuildChatPieParam.E = 6;
        launchGuildChatPieParam.F = b(intent, bundle, "openGuildAioDisableReuse");
        launchGuildChatPieParam.G = c(intent, bundle, AppConstants.Key.GUILD_EXTRA);
        Bundle c16 = c(intent, bundle, "goto_guildtab_actionextra");
        if (c16 != null) {
            launchGuildChatPieParam.f214359m = c16.getBoolean("openAioWithoutAnimation");
            launchGuildChatPieParam.C = c16.getInt("openAioIn");
            launchGuildChatPieParam.f214358i = c16.getBoolean("keepOpenPos");
        }
        if (bundle.getInt("openGuildFrom") == 1) {
            launchGuildChatPieParam.E = 10;
            GuildAppReportSourceInfo f06 = this.f227459a.f0();
            f06.addReportItem("sgrp_stream_pgin_source_name", "qq_push");
            if (launchGuildChatPieParam.G == null) {
                launchGuildChatPieParam.G = new Bundle();
            }
            launchGuildChatPieParam.G.putParcelable("GuildAppReportSourceInfo", f06);
            if (intent != null) {
                launchGuildChatPieParam.G.putInt(AppConstants.Key.GUILD_PUSH_TYPE, intent.getIntExtra(AppConstants.Key.GUILD_PUSH_TYPE, 0));
                launchGuildChatPieParam.G.putLong(AppConstants.Key.GUILD_MSG_TIME, intent.getLongExtra(AppConstants.Key.GUILD_MSG_TIME, 0L));
            }
        }
        this.f227459a.c(launchGuildChatPieParam);
    }
}
