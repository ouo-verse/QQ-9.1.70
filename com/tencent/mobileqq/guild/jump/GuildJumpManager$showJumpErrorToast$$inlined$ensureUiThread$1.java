package com.tencent.mobileqq.guild.jump;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/util/ThreadUtils$ensureUiThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildJumpManager$showJumpErrorToast$$inlined$ensureUiThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f226372d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f226373e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f226374f;

    @Override // java.lang.Runnable
    public final void run() {
        QQToastUtil.showQQToast(this.f226372d, this.f226373e);
        GuildJumpLoadingFragment.INSTANCE.a();
        Logger.f235387a.d().w("Guild.jump.GuildJumpManager", 1, "showJumpErrorToast " + this.f226374f);
    }
}
