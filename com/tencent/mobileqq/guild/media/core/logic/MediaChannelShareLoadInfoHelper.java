package com.tencent.mobileqq.guild.media.core.logic;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelShareLoadInfoHelper;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", BdhLogUtil.LogTag.Tag_Req, "", "sessionId", "", "shareType", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "P", "queryParam", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "E0", "p", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "f", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchShareLoadInfoJob", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelShareLoadInfoHelper extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchShareLoadInfoJob;

    public MediaChannelShareLoadInfoHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b P(String sessionId, int shareType) {
        return CorountineFunKt.e(this.core.getCoroutineScope(), "doFetchShareLoadInfo", null, null, null, new MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1(sessionId, this, shareType, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(String queryParam, int shareType, String sessionId) {
        boolean z16;
        Throwable th5;
        JSONObject jSONObject;
        String E;
        boolean z17 = false;
        if (queryParam != null && queryParam.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        JSONObject jSONObject2 = null;
        String str = "";
        if (!z16) {
            try {
                jSONObject = new JSONObject(queryParam);
            } catch (Throwable th6) {
                th5 = th6;
                jSONObject = null;
            }
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("playAppInfo");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                String optString = optJSONObject.optString("channelId");
                if (optString != null) {
                    str = optString;
                }
            } catch (Throwable th7) {
                th5 = th7;
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "[FetchSessionIdCallback] parse json error " + th5;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.MediaChannelShareLoadInfoHelper", 1, (String) it.next(), th5);
                }
                jSONObject2 = jSONObject;
                E = com.tencent.mobileqq.guild.media.core.j.a().E();
                Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[handleSessionFetchCallback] currentChannelId " + E + ", shareType " + shareType + ", sessionId " + sessionId + ", queryParam " + queryParam);
                if (E.length() > 0) {
                }
                if (!z17) {
                } else {
                    return;
                }
            }
            jSONObject2 = jSONObject;
        }
        E = com.tencent.mobileqq.guild.media.core.j.a().E();
        Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[handleSessionFetchCallback] currentChannelId " + E + ", shareType " + shareType + ", sessionId " + sessionId + ", queryParam " + queryParam);
        if (E.length() > 0) {
            z17 = true;
        }
        if (!z17 && Intrinsics.areEqual(str, E)) {
            this.core.o0().q().setValue(new MediaShareLoadInfo(shareType, sessionId, jSONObject2, str));
        }
    }

    private final void R() {
        boolean z16;
        int i3;
        Job f16;
        boolean z17;
        boolean z18;
        Integer intOrNull;
        int i16;
        Map<String, String> reportInfoMap;
        String str;
        Map<String, String> reportInfoMap2;
        Bundle enterChannelExtraData = com.tencent.mobileqq.guild.media.core.j.c().getEnterChannelExtraData();
        if (enterChannelExtraData == null) {
            enterChannelExtraData = new Bundle();
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) enterChannelExtraData.getParcelable("GuildAppReportSourceInfo");
        boolean z19 = false;
        if (guildAppReportSourceInfo != null && guildAppReportSourceInfo.getStartFromGuildTab()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "";
        if (!z16) {
            String string = enterChannelExtraData.getString("sessionId");
            if (string == null) {
                string = "";
            }
            String string2 = enterChannelExtraData.getString("shareType");
            if (string2 == null) {
                string2 = "";
            }
            if (string.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && (guildAppReportSourceInfo == null || (reportInfoMap2 = guildAppReportSourceInfo.getReportInfoMap()) == null || (string = reportInfoMap2.get("sgrp_share_session_id")) == null)) {
                string = "";
            }
            if (string2.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                if (guildAppReportSourceInfo != null && (reportInfoMap = guildAppReportSourceInfo.getReportInfoMap()) != null && (str = reportInfoMap.get("sgrp_share_type")) != null) {
                    str2 = str;
                }
                string2 = str2;
            }
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string2);
            if (intOrNull != null) {
                i16 = intOrNull.intValue();
            } else {
                i16 = 0;
            }
            i3 = i16;
            str2 = string;
        } else {
            i3 = 0;
        }
        Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[handleShareLoadInfo onInvoke] sessionId " + ((Object) str2) + " shareType " + i3);
        if (str2.length() > 0) {
            z19 = true;
        }
        if (z19) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchShareLoadInfoJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            this.fetchShareLoadInfoJob = P(str2, i3);
            return;
        }
        this.core.o0().q().setValue(new MediaShareLoadInfo(i3, null, null, null, 14, null));
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[onEnterChannel] ");
        R();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[onEnterChannelForPreview] ");
        R();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        Job f16;
        Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[onExitChannel] ");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchShareLoadInfoJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }
}
