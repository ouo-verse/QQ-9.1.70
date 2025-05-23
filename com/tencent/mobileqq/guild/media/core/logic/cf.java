package com.tencent.mobileqq.guild.media.core.logic;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/cf;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", ExifInterface.LATITUDE_SOUTH, "P", "E0", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "", "f", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Z", BdhLogUtil.LogTag.Tag_Req, "(Z)V", "showFirst", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class cf extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showFirst;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.notify.y mAudioRoomObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/cf$a", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends com.tencent.mobileqq.guild.media.core.notify.y {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void i() {
            if (cf.this.getShowFirst()) {
                cf.this.S(com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList(), com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo());
                cf.this.R(false);
            }
        }
    }

    public cf(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.showFirst = true;
        this.mAudioRoomObserver = new a();
    }

    private final com.tencent.mobileqq.guild.media.core.data.r P(com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        }
        com.tencent.mobileqq.guild.media.core.data.r d16 = userInfoList.d();
        d16.l(str);
        Intrinsics.checkNotNullExpressionValue(d16, "userInfoList.copy().appl\u2026hor(selfTinyId)\n        }");
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(com.tencent.mobileqq.guild.media.core.data.r userInfoList, IGProChannelInfo channelInfo) {
        boolean z16;
        boolean z17;
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        Integer num = null;
        boolean z18 = false;
        if (userInfoList != null) {
            if (channelInfo != null && channelInfo.getType() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.guild.media.core.data.r P = P(userInfoList);
                if (this.mediaChannelCore.o0().getStartParams().getFrom() == 3) {
                    IGProChannelInfo channelInfo2 = this.mediaChannelCore.getChannelInfo();
                    if (channelInfo2 != null && (voiceSpeakModeCfg = channelInfo2.getVoiceSpeakModeCfg()) != null) {
                        num = Integer.valueOf(voiceSpeakModeCfg.getSpeakMode());
                    }
                    if (num != null && num.intValue() == 2) {
                        if (P.k(1) == 0) {
                            com.tencent.mobileqq.guild.util.aa.d(R.string.f157481n1);
                            return;
                        }
                        return;
                    }
                    if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 1)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        List<com.tencent.mobileqq.guild.media.core.data.p> list = P.f228125a;
                        if (list == null || list.isEmpty()) {
                            z18 = true;
                        }
                        if (z18) {
                            com.tencent.mobileqq.guild.util.aa.d(R.string.f157481n1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (userInfoList == null) {
            z18 = true;
        }
        if (channelInfo != null) {
            num = Integer.valueOf(channelInfo.getType());
        }
        QLog.e("MediaSummonHelper", 1, "showSummonFinishToast: ill params list: " + z18 + " type: " + num);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        this.showFirst = true;
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
    }

    /* renamed from: Q, reason: from getter */
    public final boolean getShowFirst() {
        return this.showFirst;
    }

    public final void R(boolean z16) {
        this.showFirst = z16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
    }
}
