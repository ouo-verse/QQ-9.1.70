package com.tencent.mobileqq.guild.media.core.logic;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0003R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/bz;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", BdhLogUtil.LogTag.Tag_Req, "E0", "u", "T", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "Lor1/b;", "f", "Lor1/b;", "visitorTimer", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bz extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private or1.b visitorTimer;

    public bz(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
    }

    private final void P() {
        or1.b bVar = this.visitorTimer;
        if (bVar != null) {
            bVar.a();
        }
        this.visitorTimer = null;
    }

    private final void Q() {
        P();
        if (!com.tencent.mobileqq.guild.util.ch.j0(this.mediaChannelCore.getGuildID())) {
            Logger.f235387a.d().i("MediaChannelVisitorHelper", 1, "createVisitorTimer: not guest.");
            return;
        }
        JumpGuildParam R = R();
        String str = "media_" + this.mediaChannelCore.getGuildID() + "_" + this.mediaChannelCore.E();
        if (R == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "createVisitorTimer: but join param is null tag[" + str + "]";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("MediaChannelVisitorHelper", 1, (String) it.next(), null);
            }
            return;
        }
        this.visitorTimer = new or1.b(null, str, R);
    }

    private final JumpGuildParam R() {
        JumpGuildParam jumpGuildParam = this.mediaChannelCore.o0().getStartParams().getJumpGuildParam();
        if (jumpGuildParam == null) {
            Logger.f235387a.d().i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "getCachedJoinParams: visitor, but jumpGuildParam is null");
            return null;
        }
        jumpGuildParam.setChannelId(this.mediaChannelCore.E());
        return jumpGuildParam;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        Q();
    }

    public final void S() {
        Logger.f235387a.d().i("MediaChannelVisitorHelper", 1, "onChannelActivityPause: channelId[" + this.mediaChannelCore.E() + "]");
        or1.b bVar = this.visitorTimer;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void T() {
        Logger.f235387a.d().i("MediaChannelVisitorHelper", 1, "onChannelActivityResume: channelId[" + this.mediaChannelCore.E() + "]");
        or1.b bVar = this.visitorTimer;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        P();
    }
}
