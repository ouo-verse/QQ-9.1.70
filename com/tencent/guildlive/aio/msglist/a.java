package com.tencent.guildlive.aio.msglist;

import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.tencent.aio.api.b;
import com.tencent.aio.api.c;
import com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVB;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/a;", "Lcom/tencent/aio/api/b;", "Lcom/tencent/aio/api/c;", "parentPadding", "", "e", "d", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "", "c", "parentLeft", "parentTop", "parentRight", "parentBottom", "a", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB;", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB;", "msgListVb", "Lts0/a;", "b", "Lts0/a;", "liveAIOListener", "<init>", "(Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVB;Lts0/a;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements com.tencent.aio.api.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildLiveMsgListDataVB msgListVb;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    public a(@NotNull GuildLiveMsgListDataVB msgListVb, @Nullable ts0.a aVar) {
        Intrinsics.checkNotNullParameter(msgListVb, "msgListVb");
        this.msgListVb = msgListVb;
        this.liveAIOListener = aVar;
    }

    private final int d(c parentPadding) {
        if (this.msgListVb.getMLiveIsLandScreen()) {
            return 0;
        }
        return parentPadding.a();
    }

    private final int e(c parentPadding) {
        if (!this.msgListVb.getMPanelOrKeyboardShow() && !this.msgListVb.getMLiveIsLandScreen()) {
            ts0.a aVar = this.liveAIOListener;
            if (aVar != null) {
                return aVar.S();
            }
            return parentPadding.d();
        }
        return 0;
    }

    @Override // com.tencent.aio.api.b
    public void a(int parentLeft, int parentTop, int parentRight, int parentBottom, @NotNull c parentPadding) {
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        int i3 = parentRight - parentLeft;
        int e16 = e(parentPadding);
        int d16 = d(parentPadding);
        int i16 = (parentBottom - parentTop) - d16;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildLiveFirstLayoutImpl", "[layoutChildren] t:" + e16 + ", bottomPadding:" + d16 + ", b:" + i16);
        }
        try {
            this.msgListVb.getHostView().layout(0, e16, i3, i16);
        } catch (Exception e17) {
            Logger.f235387a.d().i("GuildLiveFirstLayoutImpl", 1, "[layoutChildren] " + e17);
        }
    }

    @Override // com.tencent.aio.api.b
    public void b(@Nullable Canvas canvas, @NotNull c cVar) {
        b.a.a(this, canvas, cVar);
    }

    @Override // com.tencent.aio.api.b
    public void c(int parentWidthMeasureSpec, int parentHeightMeasureSpec, @NotNull c parentPadding) {
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        View.MeasureSpec.getSize(parentWidthMeasureSpec);
        View.MeasureSpec.getSize(parentHeightMeasureSpec);
        int e16 = e(parentPadding);
        int d16 = d(parentPadding);
        parentPadding.a();
        View hostView = this.msgListVb.getHostView();
        com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, hostView, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, e16, d16, 116, null);
        hostView.getMeasuredHeight();
    }
}
