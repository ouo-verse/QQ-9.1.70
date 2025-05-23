package com.tencent.guild.aio.reserve2.busi.chosen.menu;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.aio.reserve2.busi.chosen.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/a;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d$a;", "data", "", "r", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends g<d.ChosenParams> {
    public a() {
        super(R.string.f1648126u);
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull d.ChosenParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return true;
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull d.ChosenParams data) {
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        Context context = view.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            Contact contact = new Contact();
            contact.guildId = data.getIoaParams().f();
            contact.peerUid = data.getIoaParams().j();
            sn0.b.f433994a.a(fragmentActivity, contact, 1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_aio");
        hashMap.put("sgrp_channel_id", data.getIoaParams().f());
        hashMap.put("sgrp_sub_channel_id", data.getIoaParams().j());
        hashMap.put("eid", "em_aio_selected_message");
        VideoReport.reportEvent("dt_clck", hashMap);
    }
}
