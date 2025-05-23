package com.tencent.mobileqq.guild.media.core.logic;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.MediaBusinessState;
import com.tencent.mobileqq.guild.media.core.MediaBusinessType;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002\u001e\"\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ad;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "U", "X", "a0", "Y", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "type", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessState;", "state", "W", "Lcom/tencent/mobileqq/guild/media/core/d;", ExifInterface.LATITUDE_SOUTH, "E0", "u", "T", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "", "f", "Ljava/util/List;", "businessHelperList", "com/tencent/mobileqq/guild/media/core/logic/ad$b", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/ad$b;", "observer", "com/tencent/mobileqq/guild/media/core/logic/ad$c", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/ad$c;", "switchThemeObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;Ljava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.media.core.d> businessHelperList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c switchThemeObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ad$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (!Intrinsics.areEqual(channelUin, ad.this.mediaChannelCore.E())) {
                return;
            }
            Logger.f235387a.d().i("MediaChannelBusinessLoadHelper", 1, "onChannelInfoUpdated: channelId[" + channelUin + "]");
            ad.this.U();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ad$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            ad.this.U();
        }
    }

    public ad(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore, @NotNull List<com.tencent.mobileqq.guild.media.core.d> businessHelperList) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        Intrinsics.checkNotNullParameter(businessHelperList, "businessHelperList");
        this.mediaChannelCore = mediaChannelCore;
        this.businessHelperList = businessHelperList;
        this.observer = new b();
        this.switchThemeObserver = new c();
    }

    private final boolean Q() {
        return com.tencent.mobileqq.guild.media.core.j.a().d0().m1();
    }

    private final IGProChannelInfo R() {
        String guildID = this.mediaChannelCore.getGuildID();
        String E = this.mediaChannelCore.E();
        if (!TextUtils.isEmpty(guildID) && !TextUtils.isEmpty(E)) {
            AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
            Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
            return com.tencent.mobileqq.guild.util.ch.C(l3, guildID, E);
        }
        return null;
    }

    private final com.tencent.mobileqq.guild.media.core.d S(MediaBusinessType type) {
        boolean z16;
        for (com.tencent.mobileqq.guild.media.core.d dVar : this.businessHelperList) {
            if (dVar.O() == type) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return dVar;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        Y();
        X();
        a0();
    }

    private final void W(MediaBusinessType type, MediaBusinessState state) {
        Logger.f235387a.d().i("MediaChannelBusinessLoadHelper", 1, "updateMediaHelperState: type[" + type + "] state[" + state + "]");
        com.tencent.mobileqq.guild.media.core.d S = S(type);
        if (S.getState() != state) {
            MediaBusinessState mediaBusinessState = MediaBusinessState.ACTIVE;
            if (state == mediaBusinessState) {
                S.R();
            } else if (S.getState() == mediaBusinessState && state == MediaBusinessState.PAUSE) {
                S.S();
            }
            S.T(state);
        }
    }

    private final void X() {
        MediaBusinessState mediaBusinessState;
        boolean Q = Q();
        if (MediaChannelUtils.f228046a.u(this.mediaChannelCore.E()) && !Q) {
            mediaBusinessState = MediaBusinessState.ACTIVE;
        } else {
            mediaBusinessState = MediaBusinessState.PAUSE;
        }
        W(MediaBusinessType.MEDIA_MIC_QUEUE, mediaBusinessState);
        W(MediaBusinessType.MEDIA_AUDIO_QUEUE, mediaBusinessState);
    }

    private final void Y() {
        boolean z16;
        MediaBusinessState mediaBusinessState;
        boolean Q = Q();
        IGProChannelInfo R = R();
        if (R == null) {
            return;
        }
        boolean isAllowOtherRaiseHand = R.isAllowOtherRaiseHand();
        boolean z17 = true;
        if (R.getTalkPermission() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!isAllowOtherRaiseHand || !z16 || Q) {
            z17 = false;
        }
        if (z17) {
            mediaBusinessState = MediaBusinessState.ACTIVE;
        } else {
            mediaBusinessState = MediaBusinessState.PAUSE;
        }
        W(MediaBusinessType.MEDIA_RAISE_HAND, mediaBusinessState);
    }

    private final void a0() {
        MediaBusinessState mediaBusinessState;
        Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (value != null && value.intValue() == 6) {
            mediaBusinessState = MediaBusinessState.ACTIVE;
        } else {
            mediaBusinessState = MediaBusinessState.PAUSE;
        }
        W(MediaBusinessType.MEDIA_THIRD_APP, mediaBusinessState);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
        Iterator<T> it = this.businessHelperList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.core.d) it.next()).E0();
        }
        U();
        this.mediaChannelCore.getEventBus().V(SwitchThemeEvent.class, this.switchThemeObserver);
    }

    public final void T() {
        U();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
        Iterator<T> it = this.businessHelperList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.core.d) it.next()).u();
        }
        this.mediaChannelCore.getEventBus().j(SwitchThemeEvent.class, this.switchThemeObserver);
    }
}
