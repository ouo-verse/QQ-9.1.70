package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u001b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/aa;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "H", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "g", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "getItemData", "()Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", tl.h.F, "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;Ljava/lang/String;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class aa extends t {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final t.ItemData itemData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageId;

    public aa() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final HashMap<String, Object> H(GuildMsgItem data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dt_pgid", this.pageId);
        hashMap.put("eid", "em_sgrp_aio_report_message");
        hashMap.put("sgrp_channel_id", data.getMsgRecord().guildId);
        hashMap.put("sgrp_sub_channel_id", data.getMsgRecord().channelId);
        return hashMap;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ReportActionItem", 4, "onItemClick");
        VideoReport.reportEvent("clck", H(data));
        zp0.b bVar = zp0.b.f452962a;
        com.tencent.aio.api.runtime.a h16 = h();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(data);
        zp0.b.v(bVar, h16, arrayListOf, 0, 4, null);
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.a
    /* renamed from: s */
    public void o(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.o(data);
        VideoReport.reportEvent("imp", H(data));
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!com.tencent.guild.api.data.msglist.a.c(data)) {
            return false;
        }
        return super.a(data);
    }

    public /* synthetic */ aa(t.ItemData itemData, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.guild_menu_icon_complaint, R.string.f139300aw) : itemData, (i3 & 2) != 0 ? "pg_sgrp_aio" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(@NotNull t.ItemData itemData, @NotNull String pageId) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.itemData = itemData;
        this.pageId = pageId;
    }
}
