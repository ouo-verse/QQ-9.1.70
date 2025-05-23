package com.tencent.guild.aio.msglist.holder.component.mix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.component.mix.a;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.holder.state.MsgListCancelSendVideoMsgState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoSendState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoState;
import com.tencent.guild.aio.msglist.text.GuildTextContentUIState;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.msglist.video.GuildVideoViewer;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u0001:\u0001LB\u000f\u0012\u0006\u00101\u001a\u00020#\u00a2\u0006\u0004\bI\u0010JJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J$\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cJ\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0016\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0&0%H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u000bH\u0016J\b\u0010.\u001a\u00020\u0014H\u0016R\u0014\u00101\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/mix/GuildMixVideoBubbleComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "isMultiSelect", "", "p1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/ViewGroup;", "videoLayout", "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "m1", "o1", "", "msg", "payload", "r1", "Landroid/widget/RelativeLayout;", "l1", "b1", "bindData", "Lkotlin/Function0;", "function", "q1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "Landroid/view/View;", "d1", "", "Ljava/lang/Class;", "getObserverStates", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getTag", "f", "Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "contentView", "Lwq0/l;", "i", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_1, "()Lwq0/l;", "tv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "videoViewer", "Lcom/tencent/guild/aio/msglist/text/util/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/msglist/text/util/c;", "bubbleColorObserverDetachHandle", "D", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "E", "Z", "curMultiSelect", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMixVideoBubbleComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.text.util.c bubbleColorObserverDetachHandle;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean curMultiSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildVideoViewer videoViewer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/mix/GuildMixVideoBubbleComponent$b", "Lcom/tencent/guild/aio/msglist/holder/component/mix/a$a;", "Lcom/tencent/aio/api/runtime/a;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements a.InterfaceC1201a {
        b() {
        }

        @Override // com.tencent.guild.aio.msglist.holder.component.mix.a.InterfaceC1201a
        @Nullable
        public com.tencent.aio.api.runtime.a a() {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            GuildMixVideoBubbleComponent.this.sendIntent(new s.GetAioContext(aioContextWrapper));
            return aioContextWrapper.getContext();
        }
    }

    public GuildMixVideoBubbleComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        a aVar = a.f111557a;
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        LinearLayout a16 = aVar.a(context);
        this.contentView = a16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixVideoBubbleComponent$tv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                View view;
                BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
                view = GuildMixVideoBubbleComponent.this.root;
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                return BubbleTextViewUtil.f(bubbleTextViewUtil, context2, false, 2, null);
            }
        });
        this.tv = lazy;
        RelativeLayout l16 = l1();
        this.videoViewer = m1(l16);
        a16.addView(n1().getView());
        a16.addView(l16);
    }

    private final RelativeLayout l1() {
        RelativeLayout relativeLayout = new RelativeLayout(this.root.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.contentView.getChildCount() > 0) {
            layoutParams.topMargin = UIUtil.f112434a.v();
        }
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private final GuildVideoViewer m1(ViewGroup videoLayout) {
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        return new GuildVideoViewer(videoLayout, context, new Function4<Context, MsgRecord, View, Long, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixVideoBubbleComponent$createVideoViewer$1
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
                GuildMixVideoBubbleComponent.this.sendIntent(new a.m(context2, msgRecord, videoView, j3));
            }
        }, new Function3<Context, MsgRecord, Integer, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixVideoBubbleComponent$createVideoViewer$2
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
                    GuildMixVideoBubbleComponent.this.sendIntent(new a.p(msgRecord));
                } else if (i3 == 1) {
                    GuildMixVideoBubbleComponent.this.sendIntent(new a.n(msgRecord));
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    GuildMixVideoBubbleComponent.this.sendIntent(new a.o(msgRecord));
                }
            }
        });
    }

    private final l n1() {
        return (l) this.tv.getValue();
    }

    private final boolean o1(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(GuildMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null) {
                    r1("rich_media_state", obj2);
                }
                Object obj3 = map.get(GuildMsgItemPayloadType.STATUS_PAYLOAD);
                if (obj3 != null) {
                    r1("msg_send_status_state", obj3);
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads, boolean isMultiSelect) {
        Fragment c16;
        LifecycleOwner viewLifecycleOwner;
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.currentMsgItem = guildMsgItem;
            s1(guildMsgItem);
            ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            for (MsgElement element : arrayList) {
                IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (iGuildMsgElementApi.isVideoElem(element)) {
                    this.videoViewer.u(guildMsgItem);
                }
            }
            com.tencent.aio.api.runtime.a f16 = f1();
            if (f16 != null && (c16 = f16.c()) != null && (viewLifecycleOwner = c16.getViewLifecycleOwner()) != null) {
                this.bubbleColorObserverDetachHandle = GuildCombineUtil.f111919a.w(this.root, msgItem, viewLifecycleOwner);
            }
        }
    }

    private final void r1(String msg2, Object payload) {
        if (payload instanceof b.GuildMsgItemRichMediaPayload) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMixVideoBubbleMsgItemVB", 2, "updateBindUIState  RichMediaPayload , fileTransNotifyInfo = " + ((b.GuildMsgItemRichMediaPayload) payload).getFileTransNotifyInfo());
            }
            this.videoViewer.g0(msg2, ((b.GuildMsgItemRichMediaPayload) payload).getFileTransNotifyInfo());
            return;
        }
        if (payload instanceof b.GuildMsgItemStatusPayload) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMixVideoBubbleMsgItemVB", 2, "updateBindUIState  GuildMsgItemStatusPayload , sendStatus = " + ((b.GuildMsgItemStatusPayload) payload).getSendStatus());
            }
            this.videoViewer.g0(msg2, payload);
        }
    }

    private final void s1(GuildMsgItem msgItem) {
        b bVar = new b();
        a aVar = a.f111557a;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        aVar.b(context, msgItem, n1(), bVar);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (o1(payloads)) {
            final boolean z16 = UIUtil.f112434a.z(payloads);
            q1(z16, msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixVideoBubbleComponent$bind$1
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
                    GuildMixVideoBubbleComponent.this.p1(position, msgItem, payloads, z16);
                    GuildMixVideoBubbleComponent.this.curMultiSelect = z16;
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.contentView;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildTextContentUIState.PostThemeChangedState.class);
        return listOf;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildMixVideoBubbleMsgItemVB";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        GuildMsgItem guildMsgItem = null;
        if (state instanceof MsgListVideoSendState) {
            long msgId = ((MsgListVideoSendState) state).getMsgId();
            GuildMsgItem guildMsgItem2 = this.currentMsgItem;
            if (guildMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem2;
            }
            if (msgId == guildMsgItem.getMsgId()) {
                this.videoViewer.M();
                return;
            }
            return;
        }
        if (state instanceof MsgListVideoState) {
            MsgListVideoState msgListVideoState = (MsgListVideoState) state;
            this.videoViewer.k0(msgListVideoState.getPause(), msgListVideoState.getMute());
            return;
        }
        if (state instanceof MsgListCancelSendVideoMsgState) {
            long msgId2 = ((MsgListCancelSendVideoMsgState) state).getMsgId();
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem3;
            }
            if (msgId2 == guildMsgItem.getMsgId()) {
                this.videoViewer.L();
                return;
            }
            return;
        }
        if (state instanceof GuildTextContentUIState.PostThemeChangedState) {
            GuildMsgItem guildMsgItem4 = this.currentMsgItem;
            if (guildMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem4;
            }
            s1(guildMsgItem);
        }
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
        com.tencent.guild.aio.msglist.text.util.c cVar = this.bubbleColorObserverDetachHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.bubbleColorObserverDetachHandle = null;
    }

    public final void q1(boolean isMultiSelect, @NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            function.invoke();
            return;
        }
        if (isMultiSelect == this.curMultiSelect) {
            GuildMsgItem guildMsgItem2 = null;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            if (guildMsgItem.isSameItem(bindData)) {
                GuildMsgItem guildMsgItem3 = this.currentMsgItem;
                if (guildMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    guildMsgItem2 = guildMsgItem3;
                }
                if (guildMsgItem2.isSameContent(bindData)) {
                    return;
                }
            }
        }
        function.invoke();
    }
}
