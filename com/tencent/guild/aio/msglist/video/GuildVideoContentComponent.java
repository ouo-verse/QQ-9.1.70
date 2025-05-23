package com.tencent.guild.aio.msglist.video;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.state.MsgListCancelSendVideoMsgState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoSendState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoState;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010)\u001a\u00020\u001e\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J&\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\rH\u0016R\u0017\u0010)\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/msglist/video/GuildVideoContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "k1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "p1", "", "", "payloads", "", "m1", "", "msg", "payload", "o1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "position", "b1", "bindData", "Lkotlin/Function0;", "function", ICustomDataEditor.NUMBER_PARAM_1, "mviUIState", "handleUIState", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/RelativeLayout;", tl.h.F, "Lkotlin/Lazy;", "l1", "()Landroid/widget/RelativeLayout;", "contentView", "i", "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "videoViewer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/msglist/a;", "currentMsgItem", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildVideoContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildVideoViewer videoViewer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a currentMsgItem;

    public GuildVideoContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                return new RelativeLayout(GuildVideoContentComponent.this.getRoot().getContext());
            }
        });
        this.contentView = lazy;
        this.videoViewer = k1();
    }

    private final GuildVideoViewer k1() {
        RelativeLayout l16 = l1();
        Context context = l1().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
        return new GuildVideoViewer(l16, context, new Function4<Context, MsgRecord, View, Long, Unit>() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoContentComponent$createVideoViewer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Context context2, MsgRecord msgRecord, View view, Long l3) {
                invoke(context2, msgRecord, view, l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Context context2, @NotNull MsgRecord msgRecord, @NotNull View videoView, long j3) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                Intrinsics.checkNotNullParameter(videoView, "videoView");
                GuildVideoContentComponent.this.sendIntent(new a.m(context2, msgRecord, videoView, j3));
            }
        }, new Function3<Context, MsgRecord, Integer, Unit>() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoContentComponent$createVideoViewer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Context context2, MsgRecord msgRecord, Integer num) {
                invoke(context2, msgRecord, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Context context2, @NotNull MsgRecord msgRecord, int i3) {
                Intrinsics.checkNotNullParameter(context2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                if (i3 == 0) {
                    GuildVideoContentComponent.this.sendIntent(new a.p(msgRecord));
                } else if (i3 == 1) {
                    GuildVideoContentComponent.this.sendIntent(new a.n(msgRecord));
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    GuildVideoContentComponent.this.sendIntent(new a.o(msgRecord));
                }
            }
        });
    }

    private final RelativeLayout l1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final boolean m1(List<Object> payloads) {
        b.GuildMsgItemRichMediaPayload guildMsgItemRichMediaPayload;
        FileTransNotifyInfo fileTransNotifyInfo;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(GuildMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null) {
                    if (obj2 instanceof b.GuildMsgItemRichMediaPayload) {
                        guildMsgItemRichMediaPayload = (b.GuildMsgItemRichMediaPayload) obj2;
                    } else {
                        guildMsgItemRichMediaPayload = null;
                    }
                    if (guildMsgItemRichMediaPayload != null && (fileTransNotifyInfo = guildMsgItemRichMediaPayload.getFileTransNotifyInfo()) != null) {
                        o1("rich_media_state", fileTransNotifyInfo);
                    }
                }
                Object obj3 = map.get(GuildMsgItemPayloadType.STATUS_PAYLOAD);
                if (obj3 != null) {
                    o1("msg_send_status_state", obj3);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void o1(String msg2, Object payload) {
        this.videoViewer.g0(msg2, payload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(com.tencent.aio.data.msglist.a msgItem) {
        GuildVideoViewer guildVideoViewer = this.videoViewer;
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        guildVideoViewer.u((GuildMsgItem) msgItem);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (QLog.isColorLevel()) {
            QLog.d("GuildVideoContentComponent", 2, "bind, msgId: " + msgItem.getMsgId() + ", msgSeq: " + msgItem.getMsgSeq() + ", hashCode: " + hashCode());
        }
        if (m1(payloads)) {
            n1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoContentComponent$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildCombineUtil.f111919a.x(GuildVideoContentComponent.this.getRoot(), msgItem);
                    GuildVideoContentComponent.this.p1(msgItem);
                    GuildVideoContentComponent.this.currentMsgItem = msgItem;
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return l1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        c cVar = new c();
        if (QLog.isColorLevel()) {
            QLog.d("GuildVideoContentComponent", 2, "createVM, hashCode: " + hashCode() + ", vmHashCode: " + cVar.hashCode());
        }
        return cVar;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildVideoContentComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState mviUIState) {
        Intrinsics.checkNotNullParameter(mviUIState, "mviUIState");
        if (mviUIState instanceof MsgListVideoState) {
            MsgListVideoState msgListVideoState = (MsgListVideoState) mviUIState;
            this.videoViewer.k0(msgListVideoState.getPause(), msgListVideoState.getMute());
            return;
        }
        com.tencent.aio.data.msglist.a aVar = null;
        if (mviUIState instanceof MsgListVideoSendState) {
            long msgId = ((MsgListVideoSendState) mviUIState).getMsgId();
            com.tencent.aio.data.msglist.a aVar2 = this.currentMsgItem;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                aVar = aVar2;
            }
            if (msgId == aVar.getMsgId()) {
                this.videoViewer.M();
                return;
            }
            return;
        }
        if (mviUIState instanceof MsgListCancelSendVideoMsgState) {
            long msgId2 = ((MsgListCancelSendVideoMsgState) mviUIState).getMsgId();
            com.tencent.aio.data.msglist.a aVar3 = this.currentMsgItem;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                aVar = aVar3;
            }
            if (msgId2 == aVar.getMsgId()) {
                this.videoViewer.L();
            }
        }
    }

    public final void n1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        com.tencent.aio.data.msglist.a aVar = this.currentMsgItem;
        if (aVar == null) {
            function.invoke();
            return;
        }
        com.tencent.aio.data.msglist.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            aVar = null;
        }
        if (aVar.isSameItem(bindData)) {
            com.tencent.aio.data.msglist.a aVar3 = this.currentMsgItem;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                aVar2 = aVar3;
            }
            if (aVar2.isSameContent(bindData)) {
                return;
            }
        }
        function.invoke();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.videoViewer.U();
        this.currentMsgItem = new GuildMsgItem(new MsgRecord());
    }
}
