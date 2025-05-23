package com.tencent.mobileqq.guild.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b\r\u0010\u000bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u001f\u0010\u000b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/data/d;", "", "", "g", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "guildId", "j", "channelId", "c", "l", "joinSign", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mainSource", "e", "f", "o", "subSource", "getC2cTinyId", "i", "c2cTinyId", "getC2cSrcName", tl.h.F, "c2cSrcName", DomainData.DOMAIN_NAME, "pginSource", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.d, reason: from toString */
/* loaded from: classes13.dex */
public class GuildJumpBaseData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String guildId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String channelId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String joinSign = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mainSource = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subSource = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String c2cTinyId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String c2cSrcName = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String pginSource = "";

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getJoinSign() {
        return this.joinSign;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMainSource() {
        return this.mainSource;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPginSource() {
        return this.pginSource;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSubSource() {
        return this.subSource;
    }

    public final boolean g() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.guildId, this.joinSign, this.mainSource, this.subSource);
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c2cSrcName = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c2cTinyId = str;
    }

    public final void j(@Nullable String str) {
        this.channelId = str;
    }

    public final void k(@Nullable String str) {
        this.guildId = str;
    }

    public final void l(@Nullable String str) {
        this.joinSign = str;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainSource = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pginSource = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subSource = str;
    }

    @NotNull
    public String toString() {
        return "GuildJumpBaseData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", joinSign=" + this.joinSign + ", mainSource='" + this.mainSource + "', subSource='" + this.subSource + "', c2cTinyId=" + this.c2cTinyId + ", c2cSrcName=" + this.c2cSrcName + ", pginSource=" + this.pginSource + ", )";
    }
}
