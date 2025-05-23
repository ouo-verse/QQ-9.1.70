package com.tencent.now.pkgame.linkscreen;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import do3.a;
import fo3.b;
import hn3.LinkScreenAnchorInfo;
import kk4.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/PkAnotherAnchorView;", "Landroid/view/View;", "Ldo3/a;", "Landroid/view/View$OnClickListener;", "", "a", "b", "Lfo3/a;", "enterPkAnchorRoomHelper", "setEnterRoomHelper", "Lfo3/b;", "pageInParams", "setPageInParams", "v", NodeProps.ON_CLICK, "unInit", "", "d", "J", "roomID", "Lhn3/a;", "e", "Lhn3/a;", "anchorInfo", "", "f", "Z", "isSelfLive", h.F, "Lfo3/a;", "i", "Lfo3/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;JLhn3/a;Z)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PkAnotherAnchorView extends View implements a, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkScreenAnchorInfo anchorInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelfLive;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fo3.a enterPkAnchorRoomHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b pageInParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PkAnotherAnchorView(@NotNull Context context, long j3, @NotNull LinkScreenAnchorInfo anchorInfo, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        this.roomID = j3;
        this.anchorInfo = anchorInfo;
        this.isSelfLive = z16;
        setOnClickListener(this);
    }

    private final void a() {
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.uid = this.anchorInfo.getUin();
        a.Companion companion = kk4.a.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.g(context, c.f272176a.G(), liveUserInfo, 5, true);
    }

    private final void b() {
        fo3.a aVar;
        b bVar = this.pageInParams;
        if (bVar != null && !bVar.f()) {
            ji4.a aVar2 = ji4.a.f409945a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (aVar2.a(context) && (aVar = this.enterPkAnchorRoomHelper) != null) {
                aVar.f();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (this.isSelfLive) {
            a();
        } else {
            b();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setEnterRoomHelper(@NotNull fo3.a enterPkAnchorRoomHelper) {
        Intrinsics.checkNotNullParameter(enterPkAnchorRoomHelper, "enterPkAnchorRoomHelper");
        this.enterPkAnchorRoomHelper = enterPkAnchorRoomHelper;
    }

    public final void setPageInParams(@NotNull b pageInParams) {
        Intrinsics.checkNotNullParameter(pageInParams, "pageInParams");
        this.pageInParams = pageInParams;
    }

    @Override // do3.a
    public void unInit() {
        fo3.a aVar = this.enterPkAnchorRoomHelper;
        if (aVar != null) {
            aVar.h();
        }
    }
}
