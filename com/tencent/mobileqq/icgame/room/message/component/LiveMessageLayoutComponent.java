package com.tencent.mobileqq.icgame.room.message.component;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.message.QQLiveChatMessageLayoutManager;
import com.tencent.mobileqq.icgame.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R#\u0010(\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010*R\u001d\u0010/\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/message/component/LiveMessageLayoutComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout;", "", "w", "y", "k", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup$LayoutParams;", "f", "Lz42/b;", UserInfo.SEX_FEMALE, "J", "", "isPageClosed", "I", "Landroid/content/res/Configuration;", "newConfig", "G", "Lcom/tencent/mobileqq/icgame/room/input/component/c;", "event", "H", "B", BdhLogUtil.LogTag.Tag_Conn, h.F, "defaultHeight", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lb42/b;", "audienceViewService", "Lb42/b;", "Lfu0/c;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "E", "()Lfu0/c;", "liveRoomService", "Lcom/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager;", "Lcom/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager;", "liveMessageLayoutManager", "Landroid/view/View;", "D", "()Landroid/view/View;", "bgView", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveMessageLayoutComponent extends SingleUIComponent<ChatMessageLayout> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy bgView;

    @InjectService(key = b42.b.class)
    private b42.b audienceViewService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int defaultHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveChatMessageLayoutManager liveMessageLayoutManager;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMessageLayoutComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.defaultHeight = o42.a.a(240);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.liveMessageLayoutManager = new QQLiveChatMessageLayoutManager();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutComponent$bgView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                b42.b bVar;
                bVar = LiveMessageLayoutComponent.this.audienceViewService;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audienceViewService");
                    bVar = null;
                }
                return bVar.e();
            }
        });
        this.bgView = lazy2;
    }

    private final View D() {
        return (View) this.bgView.getValue();
    }

    private final fu0.c E() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(LiveMessageLayoutComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQLiveChatMessageLayoutManager qQLiveChatMessageLayoutManager = this$0.liveMessageLayoutManager;
        h22.a aVar = this$0.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        qQLiveChatMessageLayoutManager.h0(aVar.getRoomId());
        this$0.w();
    }

    private final void w() {
        a.Companion companion = rt0.a.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        companion.k("ICGameAudienceView", "adjustMessageLayoutForNormalState", "roomId=" + aVar.getRoomId());
        p().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.message.component.d
            @Override // java.lang.Runnable
            public final void run() {
                LiveMessageLayoutComponent.x(LiveMessageLayoutComponent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LiveMessageLayoutComponent this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewParent parent = this$0.p().getParent();
        if (!(parent instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        h22.a aVar = null;
        if (com.tencent.icgame.game.liveroom.impl.room.util.b.c(this$0.getComponentContext().getContext())) {
            a.Companion companion = rt0.a.INSTANCE;
            h22.a aVar2 = this$0.qqLiveRoomService;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar2 = null;
            }
            companion.k("ICGameAudienceView", "adjustMessageLayoutForNormalState", "adjustMessageLayoutForFolderScreen roomId=" + aVar2.getRoomId());
            layoutParams2.width = ViewUtils.dpToPx(360.0f);
            layoutParams2.addRule(0, 0);
        } else {
            layoutParams2.width = -1;
            layoutParams2.rightMargin = 0;
            if (viewGroup.getHeight() > 0) {
                i3 = viewGroup.getHeight();
            } else {
                i3 = this$0.defaultHeight;
            }
            layoutParams2.height = i3;
            layoutParams2.addRule(2, R.id.sn5);
            layoutParams2.addRule(0, R.id.u67);
        }
        a.Companion companion2 = rt0.a.INSTANCE;
        h22.a aVar3 = this$0.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar3;
        }
        companion2.k("ICGameAudienceView", "adjustMessageLayoutForNormalState", "adjustMessageLayout roomid=" + aVar.getRoomId() + ", w=" + layoutParams2.width + ", h=" + layoutParams2.height);
        viewGroup.setLayoutParams(layoutParams2);
    }

    private final void y() {
        int i3;
        a.Companion companion = rt0.a.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        companion.k("ICGameAudienceView", "adjustMessageLayoutForShowInputState", "roomId=" + aVar.getRoomId());
        ViewParent parent = p().getParent();
        if (!(parent instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(viewGroup.getLayoutParams());
        if (viewGroup.getHeight() > 0) {
            i3 = viewGroup.getHeight();
        } else {
            i3 = this.defaultHeight;
        }
        layoutParams.height = i3;
        layoutParams.rightMargin = 0;
        layoutParams.addRule(3, 0);
        layoutParams.addRule(2, R.id.sn5);
        layoutParams.addRule(0, R.id.u67);
        viewGroup.setLayoutParams(layoutParams);
        p().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.message.component.c
            @Override // java.lang.Runnable
            public final void run() {
                LiveMessageLayoutComponent.z(LiveMessageLayoutComponent.this);
            }
        });
        companion.k("ICGameAudienceView", "adjustMessageLayoutForShowInputState", "w=" + layoutParams.width + ", h=" + layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(LiveMessageLayoutComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p().c(true);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ChatMessageLayout n() {
        return new ChatMessageLayout(getComponentContext().getContext());
    }

    public final void B() {
        long j3;
        LiveAnchorInfo liveAnchorInfo;
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        LiveInfo curLiveInfo = aVar3.getCurLiveInfo();
        if (curLiveInfo != null && (liveAnchorInfo = curLiveInfo.anchorInfo) != null) {
            j3 = liveAnchorInfo.uid;
        } else {
            j3 = 0;
        }
        QLog.i("ICGameAudienceView", 1, "enterRoom: getAnchorId is " + j3);
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar4;
        }
        int roomType = aVar2.getRoomType();
        IAudienceRoom N = E().N(roomId);
        if (N != null) {
            N.registerMessageSmoothConfig(new MessagePushConfig.Builder().addMessageType(MessagePushConfig.MessagePushType.CHAT).addMessageType(MessagePushConfig.MessagePushType.ENTER).build());
        }
        this.liveMessageLayoutManager.f0(roomId, j3, roomType);
    }

    public final void C() {
        QQLiveChatMessageLayoutManager qQLiveChatMessageLayoutManager = this.liveMessageLayoutManager;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        qQLiveChatMessageLayoutManager.g0(aVar.getRoomId());
    }

    @Nullable
    public final z42.b F() {
        return this.liveMessageLayoutManager.getMainLayout();
    }

    public final void G(@NotNull Configuration newConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        w();
        if (newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        b42.b bVar = null;
        if (z16 && !com.tencent.icgame.game.liveroom.impl.room.util.b.c(getComponentContext().getContext())) {
            b42.b bVar2 = this.audienceViewService;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceViewService");
            } else {
                bVar = bVar2;
            }
            View d16 = bVar.d();
            if (d16 != null) {
                d16.setVisibility(8);
            }
            this.liveMessageLayoutManager.l0(false, true);
            return;
        }
        b42.b bVar3 = this.audienceViewService;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceViewService");
        } else {
            bVar = bVar3;
        }
        View d17 = bVar.d();
        if (d17 != null) {
            d17.setVisibility(0);
        }
        this.liveMessageLayoutManager.l0(true, z16);
    }

    public final void H(@NotNull com.tencent.mobileqq.icgame.room.input.component.c event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#00111129"), Color.parseColor("#E6111129")});
        b42.b bVar = null;
        if (event.getState() != 1) {
            b42.b bVar2 = this.audienceViewService;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceViewService");
            } else {
                bVar = bVar2;
            }
            View d16 = bVar.d();
            if (d16 != null) {
                d16.setBackground(gradientDrawable);
            }
            y();
            View D = D();
            if (D != null) {
                D.setBackgroundColor(Color.parseColor("#E6111129"));
                return;
            }
            return;
        }
        b42.b bVar3 = this.audienceViewService;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceViewService");
            bVar3 = null;
        }
        View d17 = bVar3.d();
        if (d17 != null) {
            d17.setBackground(null);
        }
        w();
        View D2 = D();
        if (D2 != null) {
            D2.setBackgroundColor(0);
        }
    }

    public final void I(boolean isPageClosed) {
        if (!isPageClosed) {
            QQLiveChatMessageLayoutManager qQLiveChatMessageLayoutManager = this.liveMessageLayoutManager;
            h22.a aVar = this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            qQLiveChatMessageLayoutManager.h0(aVar.getRoomId());
        }
    }

    public final void J() {
        p().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.message.component.b
            @Override // java.lang.Runnable
            public final void run() {
                LiveMessageLayoutComponent.K(LiveMessageLayoutComponent.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent, com.tencent.mobileqq.icgame.framework.component.i
    @NotNull
    public ViewGroup.LayoutParams f() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        p().setHeightProportion(i42.a.c(getComponentContext().getContext(), false));
        this.liveMessageLayoutManager.J(p(), getComponentContext().getContext(), false);
        iw0.d.m0(this.liveMessageLayoutManager, true, false, 2, null);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.xcx;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }
}
