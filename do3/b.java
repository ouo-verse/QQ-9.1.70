package do3;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.now.pkgame.linkscreen.PkAnotherAnchorView;
import com.tencent.now.pkgame.linkscreen.followbuttom.FollowLayout;
import com.tencent.now.pkgame.linkscreen.mutebutton.MuteButton;
import com.tencent.qqlive.common.api.AegisLogger;
import fo3.f;
import hn3.LinkScreenAnchorInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u001c\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J.\u0010\u0019\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010)\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00100\u00a8\u00064"}, d2 = {"Ldo3/b;", "", "", "c", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "e", "Lhn3/a;", "anchorInfo", "Lfo3/b;", "pageInParams", "Lfo3/a;", "enterRoomHelper", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "seiInfoSubscriber", "Lfo3/f;", "factory", "b", "Landroid/view/View;", "view", "a", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "g", "pkGameViewFactory", h.F, "i", "d", "", "f", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "J", "getRoomId", "()J", "roomId", "Z", "isSelfLive", "()Z", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "linkScreenContainer", "", "Ljava/util/List;", "viewList", "<init>", "(Landroid/content/Context;JZLandroid/widget/FrameLayout;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelfLive;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout linkScreenContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<View> viewList;

    public b(@NotNull Context context, long j3, boolean z16, @NotNull FrameLayout rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.context = context;
        this.roomId = j3;
        this.isSelfLive = z16;
        this.rootView = rootView;
        this.linkScreenContainer = new FrameLayout(context);
        this.viewList = new ArrayList();
        e(rootView);
    }

    private final void a(View view) {
        this.linkScreenContainer.addView(view);
        this.viewList.add(view);
    }

    private final void b(LinkScreenAnchorInfo anchorInfo, fo3.b pageInParams, fo3.a enterRoomHelper, com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoSubscriber, f factory) {
        PkAnotherAnchorView anotherAnchorView = factory.e(this.context, pageInParams.getRoomId(), anchorInfo, this.isSelfLive);
        anotherAnchorView.setEnterRoomHelper(enterRoomHelper);
        anotherAnchorView.setPageInParams(pageInParams);
        FollowLayout followLayout = factory.b(this.context, anchorInfo);
        MuteButton muteButton = factory.c(this.context, anchorInfo.getUin(), this.isSelfLive, pageInParams);
        muteButton.setSeiInfoSubs(seiInfoSubscriber);
        Intrinsics.checkNotNullExpressionValue(anotherAnchorView, "anotherAnchorView");
        a(anotherAnchorView);
        Intrinsics.checkNotNullExpressionValue(followLayout, "followLayout");
        a(followLayout);
        Intrinsics.checkNotNullExpressionValue(muteButton, "muteButton");
        a(muteButton);
    }

    private final void c() {
        for (KeyEvent.Callback callback : this.viewList) {
            if (callback instanceof a) {
                ((a) callback).unInit();
            }
        }
        this.viewList.clear();
        this.linkScreenContainer.removeAllViews();
    }

    private final void e(FrameLayout rootView) {
        this.linkScreenContainer = new FrameLayout(this.context);
        this.linkScreenContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        rootView.addView(this.linkScreenContainer);
    }

    public final void d() {
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenUIMgr", "endLinkScreen, roomId:" + this.roomId);
        c();
    }

    public final boolean f() {
        if (this.viewList.size() > 0) {
            return true;
        }
        return false;
    }

    public final void g(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.linkScreenContainer.setLayoutParams(layoutParams);
    }

    public final void h(@NotNull LinkScreenAnchorInfo anchorInfo, @NotNull fo3.b pageInParams, @NotNull fo3.a enterRoomHelper, @NotNull com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoSubscriber, @NotNull f pkGameViewFactory) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(pageInParams, "pageInParams");
        Intrinsics.checkNotNullParameter(enterRoomHelper, "enterRoomHelper");
        Intrinsics.checkNotNullParameter(seiInfoSubscriber, "seiInfoSubscriber");
        Intrinsics.checkNotNullParameter(pkGameViewFactory, "pkGameViewFactory");
        b(anchorInfo, pageInParams, enterRoomHelper, seiInfoSubscriber, pkGameViewFactory);
    }

    public final void i() {
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenUIMgr", "startLinkScreen, roomId:" + this.roomId);
    }
}
