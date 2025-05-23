package com.tencent.mobileqq.qqlive.sail.ui.more;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/ar;", "Lcom/tencent/mobileqq/qqlive/anchor/live/b;", "", "d", "", "switchCamera", "b", "", "index", "c", "startAudioRecord", "stopAudioRecord", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "a", "level", "e", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/preview/a;", "Lcom/tencent/mobileqq/qqlive/sail/ui/preview/a;", "beautyViewModel", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;Lcom/tencent/mobileqq/qqlive/sail/ui/preview/a;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ar implements com.tencent.mobileqq.qqlive.anchor.live.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoomViewModel roomViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.sail.ui.preview.a beautyViewModel;

    public ar(@NotNull RoomViewModel roomViewModel, @NotNull com.tencent.mobileqq.qqlive.sail.ui.preview.a beautyViewModel) {
        Intrinsics.checkNotNullParameter(roomViewModel, "roomViewModel");
        Intrinsics.checkNotNullParameter(beautyViewModel, "beautyViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomViewModel, (Object) beautyViewModel);
        } else {
            this.roomViewModel = roomViewModel;
            this.beautyViewModel = beautyViewModel;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    @NotNull
    public List<ResolutionLevelType> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.roomViewModel.c2();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.roomViewModel.l2();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void c(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, index);
        } else {
            this.beautyViewModel.L1().postValue(Integer.valueOf(index));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Boolean value = this.roomViewModel.W1().getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void e(@NotNull ResolutionLevelType level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) level);
        } else {
            Intrinsics.checkNotNullParameter(level, "level");
            this.roomViewModel.m2(level);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void startAudioRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.roomViewModel.W1().postValue(Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void stopAudioRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.roomViewModel.W1().postValue(Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.b
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.roomViewModel.k2();
        }
    }
}
