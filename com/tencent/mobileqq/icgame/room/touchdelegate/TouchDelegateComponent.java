package com.tencent.mobileqq.icgame.room.touchdelegate;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ComponentEvent(eventList = {b.class})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "p", "", "k", "i", "Landroid/content/res/Configuration;", "newConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "state", "r", "Lb42/b;", "qqLiveAudienceSupport", "Lb42/b;", "e", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateView;", "f", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateView;", "touchDelegateView", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class TouchDelegateComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy touchDelegateView;

    @InjectService(key = b42.b.class)
    @Nullable
    private final b42.b qqLiveAudienceSupport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchDelegateComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TouchDelegateView>() { // from class: com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateComponent$touchDelegateView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TouchDelegateView invoke() {
                b42.b bVar;
                bVar = TouchDelegateComponent.this.qqLiveAudienceSupport;
                if (bVar != null) {
                    return bVar.f();
                }
                return null;
            }
        });
        this.touchDelegateView = lazy;
    }

    private final TouchDelegateView n() {
        return (TouchDelegateView) this.touchDelegateView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TouchDelegateComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getComponentContext().w0(new b());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean p() {
        boolean c16;
        if (n() != null) {
            TouchDelegateView n3 = n();
            Intrinsics.checkNotNull(n3);
            if (n3.getWidth() > 0) {
                Context context = getComponentContext().getContext();
                TouchDelegateView n16 = n();
                Intrinsics.checkNotNull(n16);
                int width = n16.getWidth();
                TouchDelegateView n17 = n();
                Intrinsics.checkNotNull(n17);
                c16 = com.tencent.icgame.game.liveroom.impl.room.util.b.b(context, width, n17.getHeight());
                if (!this.isLandscape && !c16) {
                    return true;
                }
                return false;
            }
        }
        c16 = com.tencent.icgame.game.liveroom.impl.room.util.b.c(getComponentContext().getContext());
        if (!this.isLandscape) {
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        TouchDelegateView n3 = n();
        if (n3 != null) {
            n3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.touchdelegate.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouchDelegateComponent.o(TouchDelegateComponent.this, view);
                }
            });
        }
    }

    public final void q(@NotNull Configuration newConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLandscape = z16;
        TouchDelegateView n3 = n();
        if (n3 != null) {
            n3.setVisibility(8);
        }
    }

    public final void r(int state) {
        int i3;
        TouchDelegateView n3 = n();
        boolean z16 = false;
        if (n3 != null) {
            if (state != 1 && !p()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            n3.setVisibility(i3);
        }
        TouchDelegateView n16 = n();
        if (n16 != null) {
            if (state != 1) {
                z16 = true;
            }
            n16.setDisallowIntercept(z16);
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }
}
