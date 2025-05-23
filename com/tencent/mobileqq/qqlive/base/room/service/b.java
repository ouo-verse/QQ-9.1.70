package com.tencent.mobileqq.qqlive.base.room.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.c;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.d;
import com.tencent.mobileqq.qqlive.base.room.service.liveview.e;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tBG\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/b;", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/e;", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/c;", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/d;", "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/b;", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/d;", "Lcom/tencent/mobileqq/qqlive/base/room/service/fragment/b;", "", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "", "getRoomId", "roomInfoService", "actLifecycleService", "pageLifecycleService", "orientationChangeService", "closeRoomService", "backEventService", "fragmentService", "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/a;", "configuration", "<init>", "(Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/c;Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/d;Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/b;Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/e;Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/d;Lcom/tencent/mobileqq/qqlive/base/room/service/fragment/b;Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/a;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class b implements a, com.tencent.mobileqq.qqlive.base.room.service.roominfo.b, e, c, d, com.tencent.mobileqq.qqlive.base.room.service.orientation.b, com.tencent.mobileqq.qqlive.base.room.service.liveview.d, com.tencent.mobileqq.qqlive.base.room.service.fragment.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.base.room.service.roominfo.b f271117a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f271118b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ c f271119c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ d f271120d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.base.room.service.orientation.b f271121e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.base.room.service.liveview.d f271122f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.base.room.service.fragment.b f271123g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.base.room.service.orientation.a f271124h;

    public b(@NotNull com.tencent.mobileqq.qqlive.base.room.service.roominfo.b roomInfoService, @NotNull c actLifecycleService, @NotNull d pageLifecycleService, @NotNull com.tencent.mobileqq.qqlive.base.room.service.orientation.b orientationChangeService, @NotNull e closeRoomService, @NotNull com.tencent.mobileqq.qqlive.base.room.service.liveview.d backEventService, @NotNull com.tencent.mobileqq.qqlive.base.room.service.fragment.b fragmentService, @NotNull com.tencent.mobileqq.qqlive.base.room.service.orientation.a configuration) {
        Intrinsics.checkNotNullParameter(roomInfoService, "roomInfoService");
        Intrinsics.checkNotNullParameter(actLifecycleService, "actLifecycleService");
        Intrinsics.checkNotNullParameter(pageLifecycleService, "pageLifecycleService");
        Intrinsics.checkNotNullParameter(orientationChangeService, "orientationChangeService");
        Intrinsics.checkNotNullParameter(closeRoomService, "closeRoomService");
        Intrinsics.checkNotNullParameter(backEventService, "backEventService");
        Intrinsics.checkNotNullParameter(fragmentService, "fragmentService");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, roomInfoService, actLifecycleService, pageLifecycleService, orientationChangeService, closeRoomService, backEventService, fragmentService, configuration);
            return;
        }
        this.f271117a = roomInfoService;
        this.f271118b = closeRoomService;
        this.f271119c = actLifecycleService;
        this.f271120d = pageLifecycleService;
        this.f271121e = orientationChangeService;
        this.f271122f = backEventService;
        this.f271123g = fragmentService;
        this.f271124h = configuration;
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    @Nullable
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271117a.getAnchorRoomInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f271117a.getRoomId();
    }
}
