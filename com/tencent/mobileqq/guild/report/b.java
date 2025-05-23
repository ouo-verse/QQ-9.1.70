package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J$\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\fH\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0002R*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R*\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R*\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0019\u0010\u0013R*\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u0010\u0010\u0013R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/report/b;", "", "", "source", "from", "", "g", "inviteContentID", tl.h.F, "visitFrom", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "a", "<set-?>", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getPginSource$annotations", "()V", "pginSource", "f", "getVisitFrom$annotations", "e", "getSessionId$annotations", "sessionId", "getAttaContentId$annotations", "attaContentId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "channelPGInSourceList", "<init>", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f232005a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pginSource = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String visitFrom = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sessionId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String attaContentId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> channelPGInSourceList;

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL, "share_feed_channel", "qr_channel", "forum_qr_channel", "link_channel", "link_feed_channel");
        channelPGInSourceList = arrayListOf;
        Logger.f235387a.d().d("GuildSourceReportManage", 1, "init");
    }

    b() {
    }

    private final String a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int nextUInt = URandomKt.nextUInt(Random.INSTANCE);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentTimeMillis);
        sb5.append((Object) UInt.m615toStringimpl(nextUInt));
        return sb5.toString();
    }

    @NotNull
    public static final String b() {
        return attaContentId;
    }

    @NotNull
    public static final String c() {
        return pginSource;
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> d() {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_stream_pgin_source_name", pginSource), TuplesKt.to("sgrp_invite_content_id", attaContentId), TuplesKt.to("sgrp_visit_from", visitFrom), TuplesKt.to("sgrp_session_id", sessionId));
        return hashMapOf;
    }

    @NotNull
    public static final String e() {
        return sessionId;
    }

    @NotNull
    public static final String f() {
        return visitFrom;
    }

    @JvmStatic
    public static final void g(@NotNull String source, @NotNull String from) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(from, "from");
        h(source, from, "");
    }

    @JvmStatic
    public static final void h(@NotNull String source, @NotNull String from, @NotNull String inviteContentID) {
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(inviteContentID, "inviteContentID");
        pginSource = source;
        sessionId = f232005a.a();
        visitFrom = "";
        if (channelPGInSourceList.contains(source)) {
            boolean z17 = false;
            if (attaContentId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (inviteContentID.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    inviteContentID = attaContentId + ',' + inviteContentID;
                }
            }
        }
        attaContentId = inviteContentID;
        Logger.f235387a.d().d("GuildSourceReportManage", 1, "setPginSource source:" + source + " sid:" + e() + " from:" + from + ", attaContentId " + b());
    }

    @JvmStatic
    public static final void i(@NotNull String visitFrom2, @NotNull String from) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(visitFrom2, "visitFrom");
        Intrinsics.checkNotNullParameter(from, "from");
        visitFrom = visitFrom2;
        Logger.f235387a.d().d("GuildSourceReportManage", 1, "setVisitedFrom visitFrom:" + visitFrom2 + " sid:" + e() + " from:" + from + TokenParser.SP);
        isBlank = StringsKt__StringsJVMKt.isBlank(pginSource);
        if (isBlank) {
            s.g("GuildSourceReportManage", "\u5916\u90e8\u573a\u666f\u8fdb\u5165\u9891\u9053\uff0c\u9700\u5916\u6e20\u53c2\u6570");
        }
    }
}
