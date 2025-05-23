package com.tencent.mobileqq.guild.heartbeatreport.impl;

import com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi;
import com.tencent.mobileqq.guild.heartbeatreport.impl.j;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J?\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/FragmentStatusReportApiImpl;", "Lcom/tencent/mobileqq/guild/heartbeatreport/IFragmentStatusReportApi;", "", "nextReportInterval", "", "postDelay", "", "guildId", "channelId", "", JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE, "pginSourceName", "", "fromGuildTab", "reportResume", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "pause", "Ljava/lang/String;", "fromPageId", "I", "Ljava/lang/Runnable;", "reportRunnable", "Ljava/lang/Runnable;", "getReportRunnable", "()Ljava/lang/Runnable;", "setReportRunnable", "(Ljava/lang/Runnable;)V", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FragmentStatusReportApiImpl implements IFragmentStatusReportApi {

    @NotNull
    public static final String TAG = "Guild.report.online.FragmentStatusReportApiImpl";

    @Nullable
    private String channelId;
    private int fromPageId;

    @Nullable
    private String guildId;

    @NotNull
    private Runnable reportRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.d
        @Override // java.lang.Runnable
        public final void run() {
            FragmentStatusReportApiImpl.reportRunnable$lambda$2(FragmentStatusReportApiImpl.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void postDelay(long nextReportInterval) {
        Logger.f235387a.d().d(TAG, 1, "[postDelay] guildId:" + this.guildId + ", channelId:" + this.channelId + ", nextReportInterval:" + nextReportInterval);
        UiThreadUtil.runOnUiThread(this.reportRunnable, nextReportInterval * ((long) 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FragmentStatusReportApiImpl this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.guildId;
        String str2 = this$0.channelId;
        Logger.f235387a.d().i(TAG, 1, "[postDelay] guildId:" + str + ", channelId:" + str2);
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                j.g(j.f224700a, str, str2, TAG, 2, new FragmentStatusReportApiImpl$reportRunnable$1$3(this$0), 0, null, 64, null);
                return;
            }
        }
        Logger.b bVar = new Logger.b();
        String str3 = "[postDelay] param invalid guildId:" + str + ", channelId:" + str2;
        if (str3 instanceof String) {
            bVar.a().add(str3);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
        }
    }

    @NotNull
    public final Runnable getReportRunnable() {
        return this.reportRunnable;
    }

    @Override // com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi
    public void pause() {
        Logger.f235387a.d().d(TAG, 1, "[pause] guildId:" + this.guildId + ", channelId:" + this.channelId);
        UiThreadUtil.remove(this.reportRunnable);
    }

    @Override // com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi
    public void reportResume(@Nullable String guildId, @Nullable String channelId, @Nullable Integer channelOpenSource, @Nullable String pginSourceName, boolean fromGuildTab) {
        boolean z16;
        UiThreadUtil.remove(this.reportRunnable);
        this.guildId = guildId;
        this.channelId = channelId;
        this.fromPageId = j.a.f224701a.a(channelOpenSource, fromGuildTab);
        Logger.f235387a.d().i(TAG, 1, "[reportResume] guildId:" + guildId + ", channelId:" + channelId + " fromPageId:" + this.fromPageId + " channelOpenSource:" + channelOpenSource + " pginSourceName" + pginSourceName + " fromGuildTab:" + fromGuildTab);
        boolean z17 = false;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (channelId == null || channelId.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                j.g(j.f224700a, guildId, channelId, TAG, 2, new FragmentStatusReportApiImpl$reportResume$3(this), this.fromPageId, null, 64, null);
                return;
            }
        }
        Logger.b bVar = new Logger.b();
        String str = "[reportResume] param invalid guildId:" + guildId + ", channelId:" + channelId;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
        }
    }

    public final void setReportRunnable(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.reportRunnable = runnable;
    }
}
