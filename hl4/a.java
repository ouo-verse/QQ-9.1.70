package hl4;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR/\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lhl4/a;", "Landroid/text/style/ClickableSpan;", "", "c", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "d", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "msg", "", "e", "J", "anchorId", "f", "roomId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", h.F, "Lkotlin/jvm/functions/Function1;", "requestSuccess", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;JJLkotlin/jvm/functions/Function1;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.widget.chat.message.c msg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long anchorId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<com.tencent.mobileqq.qqlive.widget.chat.message.c, Unit> requestSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.c msg2, long j3, long j16, @NotNull Function1<? super com.tencent.mobileqq.qqlive.widget.chat.message.c, Unit> requestSuccess) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(requestSuccess, "requestSuccess");
        this.msg = msg2;
        this.anchorId = j3;
        this.roomId = j16;
        this.requestSuccess = requestSuccess;
    }

    private final void c() {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        if (wj4.c.a(this.roomId) == 2) {
            TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
            if (tGLiveFollowManager.r(this.roomId)) {
                tGLiveFollowManager.m(this.roomId, new C10451a());
                return;
            } else {
                tGLiveFollowManager.j(this.roomId, new b());
                return;
            }
        }
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            iQQLiveFollowMsgService = f16.getFollowMsgService();
        } else {
            iQQLiveFollowMsgService = null;
        }
        IQQLiveFollowMsgService iQQLiveFollowMsgService2 = iQQLiveFollowMsgService;
        if (iQQLiveFollowMsgService2 == null) {
            return;
        }
        TGLiveFollowManager tGLiveFollowManager2 = TGLiveFollowManager.f377684a;
        if (tGLiveFollowManager2.n(this.anchorId)) {
            tGLiveFollowManager2.k(iQQLiveFollowMsgService2, this.anchorId, this.roomId, new c());
        } else {
            tGLiveFollowManager2.h(iQQLiveFollowMsgService2, this.anchorId, this.roomId, new d());
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"hl4/a$a", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hl4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10451a implements IQQLiveFollowCallback {
        C10451a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            a.this.requestSuccess.invoke(a.this.msg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"hl4/a$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQLiveFollowCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            a.this.requestSuccess.invoke(a.this.msg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"hl4/a$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IQQLiveFollowCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            a.this.requestSuccess.invoke(a.this.msg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"hl4/a$d", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IQQLiveFollowCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            a.this.requestSuccess.invoke(a.this.msg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
