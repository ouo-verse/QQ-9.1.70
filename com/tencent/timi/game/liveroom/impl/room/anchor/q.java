package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/q;", "Lcom/tencent/mobileqq/qqlive/base/room/service/connector/RoomConnector;", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/p;", "G", "", "Lcom/tencent/mobileqq/qqlive/framework/interfaceService/a;", "c", "Landroid/os/Bundle;", "arguments", "", "B", "u", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "Lfi2/b;", "cc", "<init>", "(Lfi2/b;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class q extends RoomConnector {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/q$a", "Lcom/tencent/mobileqq/qqlive/anchor/live/startlive/c;", "Landroid/widget/FrameLayout;", "b", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "d", "c", "Landroid/view/ViewGroup;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements com.tencent.mobileqq.qqlive.anchor.live.startlive.c {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.live.startlive.c
        @Nullable
        public ViewGroup a() {
            p pVar = (p) com.tencent.mobileqq.qqlive.base.room.c.d(q.this.b(), p.class);
            if (pVar != null) {
                return pVar.x();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.live.startlive.c
        @Nullable
        public FrameLayout b() {
            p pVar = (p) com.tencent.mobileqq.qqlive.base.room.c.d(q.this.b(), p.class);
            if (pVar != null) {
                return pVar.w();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.live.startlive.c
        public void c() {
            p pVar = (p) com.tencent.mobileqq.qqlive.base.room.c.d(q.this.b(), p.class);
            if (pVar != null) {
                pVar.y();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.live.startlive.c
        public void d(@NotNull String videoUrl) {
            Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
            p pVar = (p) com.tencent.mobileqq.qqlive.base.room.c.d(q.this.b(), p.class);
            if (pVar != null) {
                pVar.z(videoUrl);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull fi2.b cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    private final p G() {
        return (p) com.tencent.mobileqq.qqlive.base.room.c.d(b(), p.class);
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector
    protected void A() {
        p G = G();
        if (G != null) {
            G.onStop();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector
    protected void B(@Nullable Bundle arguments) {
        p G = G();
        if (G != null) {
            G.B(arguments);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector, com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    @NotNull
    public List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.anchor.live.startlive.c.class, new a()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector
    protected void r() {
        p G = G();
        if (G != null) {
            G.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector
    protected void u(@Nullable Bundle arguments) {
        p G = G();
        if (G != null) {
            G.A(arguments);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.connector.RoomConnector
    protected void y() {
        p G = G();
        if (G != null) {
            G.onResume();
        }
    }
}
