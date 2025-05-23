package com.tencent.mobileqq.guild.heartbeatreport.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.heartbeatreport.impl.j;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010*\u001a\u00020\u0006\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Je\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0004J*\u0010\u0014\u001a\u00020\u00042\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000fR\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/AvChannelReportHelper;", "", "", "nextReportInterval", "", tl.h.F, "", "guildId", "channelId", "", JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE, "pginSourceName", "", "startFromGuildTab", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportMap", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/util/HashMap;)V", "g", "k", "a", "Ljava/lang/String;", "TAG", "b", "c", "d", "I", "fromPageId", "e", "Ljava/util/HashMap;", "innerReportMap", "f", "Z", "hasPause", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getReportRunnable", "()Ljava/lang/Runnable;", "setReportRunnable", "(Ljava/lang/Runnable;)V", "reportRunnable", "roomType", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AvChannelReportHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int fromPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> innerReportMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasPause;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable reportRunnable;

    public AvChannelReportHelper(@NotNull String roomType) {
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        this.TAG = "Guild.report.online.AvChannelReportHelper." + roomType;
        this.innerReportMap = new HashMap<>();
        this.reportRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AvChannelReportHelper.j(AvChannelReportHelper.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(long nextReportInterval) {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().i(str, 1, "[postDelay] guildId:" + this.guildId + ", channelId:" + this.channelId + ", nextReportInterval:" + nextReportInterval);
        ThreadManagerV2.executeDelay(this.reportRunnable, 16, null, false, nextReportInterval * ((long) 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AvChannelReportHelper this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.guildId;
        String str2 = this$0.channelId;
        if (this$0.hasPause) {
            QLog.d(this$0.TAG, 1, "reportRunnable hasPause");
            return;
        }
        Logger logger = Logger.f235387a;
        String str3 = this$0.TAG;
        logger.d().i(str3, 1, "[postDelay] guildId:" + str + ", channelId:" + str2);
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
                if (this$0.innerReportMap.size() > 0) {
                    this$0.innerReportMap.put("user_type", String.valueOf(v.c(this$0.guildId)));
                    this$0.innerReportMap.put("playmodule", String.valueOf(MediaChannelUtils.m()));
                }
                j.f224700a.f(str, str2, this$0.TAG, 2, new AvChannelReportHelper$reportRunnable$1$3(this$0), 0, this$0.innerReportMap);
                return;
            }
        }
        String str4 = this$0.TAG;
        Logger.b bVar = new Logger.b();
        String str5 = "[postDelay] param invalid guildId:" + str + ", channelId:" + str2;
        if (str5 instanceof String) {
            bVar.a().add(str5);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(str4, 1, (String) it.next(), null);
        }
    }

    public final void g() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().i(str, 1, "pause guildId:" + this.guildId + ", channelId:" + this.channelId);
        this.innerReportMap.clear();
        this.hasPause = true;
        ThreadManagerV2.removeJob(this.reportRunnable, 16);
    }

    public final void i(@Nullable String guildId, @Nullable String channelId, @Nullable Integer channelOpenSource, @NotNull String pginSourceName, boolean startFromGuildTab, @Nullable HashMap<String, String> reportMap) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pginSourceName, "pginSourceName");
        ThreadManagerV2.removeJob(this.reportRunnable, 16);
        this.guildId = guildId;
        this.channelId = channelId;
        this.fromPageId = j.a.f224701a.a(channelOpenSource, startFromGuildTab);
        this.innerReportMap.clear();
        boolean z17 = false;
        this.hasPause = false;
        if (reportMap != null) {
            Set<String> keySet = reportMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "reportMap.keys");
            for (String it : keySet) {
                HashMap<String, String> hashMap = this.innerReportMap;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(it, String.valueOf(reportMap.get(it)));
            }
            this.innerReportMap.put("user_type", String.valueOf(v.c(guildId)));
            this.innerReportMap.put("playmodule", String.valueOf(MediaChannelUtils.m()));
        }
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().i(str, 1, "[reportResume] guildId:" + guildId + ", channelId:" + channelId + " fromPageId:" + this.fromPageId + " innerReportMap size: " + this.innerReportMap.size());
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
                j.f224700a.f(guildId, channelId, this.TAG, 2, new AvChannelReportHelper$reportResume$4(this), this.fromPageId, this.innerReportMap);
                return;
            }
        }
        String str2 = this.TAG;
        Logger.b bVar = new Logger.b();
        String str3 = "[reportResume] param invalid guildId:" + guildId + ", channelId:" + channelId + " fromPageId:" + this.fromPageId;
        if (str3 instanceof String) {
            bVar.a().add(str3);
        }
        Iterator<T> it5 = bVar.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e(str2, 1, (String) it5.next(), null);
        }
    }

    public final void k(@NotNull HashMap<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        if (!this.hasPause) {
            Set<String> keySet = reportMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "reportMap.keys");
            for (String it : keySet) {
                HashMap<String, String> hashMap = this.innerReportMap;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(it, String.valueOf(reportMap.get(it)));
            }
        }
    }
}
