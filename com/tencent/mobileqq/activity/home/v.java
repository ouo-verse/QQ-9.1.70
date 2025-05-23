package com.tencent.mobileqq.activity.home;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u00042\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/home/v;", "Landroidx/lifecycle/Observer;", "Lef1/a;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$e;", "", "progress", "", "J", "event", "a", "", NodeProps.VISIBLE, "onVisibleChanged", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class v implements Observer<ef1.a<IGuildLayoutApi.GuildState>>, IGuildLayoutApi.d, IGuildLayoutApi.e {
    static IPatchRedirector $redirector_;

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            GuildLayoutManager.f354256a.v(0.0f);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(progress));
        } else {
            GuildLayoutManager.f354256a.v(progress);
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onChanged(@NotNull ef1.a<IGuildLayoutApi.GuildState> event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        IGuildLayoutApi.GuildState a16 = event.a();
        GuildLayoutManager.f354256a.u(new GuildLayoutManager.GuildState(a16.getDisplayGuildId(), a16.getDisplayDiscovery()));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.e
    public void onVisibleChanged(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, visible);
        } else {
            GuildLayoutManager.f354256a.x(visible);
        }
    }
}
