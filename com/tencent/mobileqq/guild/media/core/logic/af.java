package com.tencent.mobileqq.guild.media.core.logic;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.guild.media.core.service.AudioForegroundService;
import com.tencent.mobileqq.guild.media.core.service.AudioProcForegroundService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/af;", "Lcom/tencent/mobileqq/guild/media/core/logic/n;", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "c", "", "b", "d", "isStart", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class af implements n {
    private final boolean b() {
        Class cls;
        List<ActivityManager.RunningServiceInfo> runningServices;
        if (d()) {
            cls = AudioForegroundService.class;
        } else {
            cls = AudioProcForegroundService.class;
        }
        String name = cls.getName();
        Object systemService = c().getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null && (systemService instanceof ActivityManager) && (runningServices = ((ActivityManager) systemService).getRunningServices(100)) != null && (!runningServices.isEmpty())) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                ComponentName componentName = runningServiceInfo.service;
                if (componentName != null && runningServiceInfo.process != null && Intrinsics.areEqual(componentName.getClassName(), name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final BaseApplication c() {
        return BaseApplication.getContext();
    }

    private final boolean d() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.n
    public void a(boolean isStart, @Nullable IGProGuildInfo guildInfo, @Nullable IGProChannelInfo channelInfo) {
        Class cls;
        Context applicationContext = c().getApplicationContext();
        if (d()) {
            cls = AudioForegroundService.class;
        } else {
            cls = AudioProcForegroundService.class;
        }
        Intent intent = new Intent(applicationContext, (Class<?>) cls);
        QLog.i("QGMC.AudioForegroundNotificationHelper", 1, "handleAudioForegroundService: isStart[" + isStart + "]");
        if (isStart) {
            if (b()) {
                c().getApplicationContext().stopService(intent);
                QLog.i("QGMC.AudioForegroundNotificationHelper", 1, "handleAudioForegroundService: service is running!");
                return;
            } else {
                intent.putExtra("guildInfo", guildInfo);
                intent.putExtra("channelInfo", channelInfo);
                c().getApplicationContext().startService(intent);
                return;
            }
        }
        c().getApplicationContext().stopService(intent);
    }
}
