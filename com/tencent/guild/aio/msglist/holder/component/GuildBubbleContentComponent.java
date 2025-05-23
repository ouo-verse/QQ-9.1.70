package com.tencent.guild.aio.msglist.holder.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import bq0.GuildHighlightParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.holder.state.MsgListCancelSendVideoMsgState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoSendState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoState;
import com.tencent.guild.aio.msglist.pic.GuildPicViewer;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.msglist.video.GuildVideoViewer;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001RB\u000f\u0012\u0006\u0010-\u001a\u00020!\u00a2\u0006\u0004\bO\u0010PJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\r\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J&\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u000bH\u0016R\u0017\u0010-\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020:0G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "isMultiSelect", "", "o1", ICustomDataEditor.NUMBER_PARAM_1, "", "msg", "payload", "r1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "isSelf", ICustomDataEditor.STRING_PARAM_1, "q1", "Landroid/widget/RelativeLayout;", "l1", "b1", "bindData", "Lkotlin/Function0;", "function", "p1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "Landroid/view/View;", "d1", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "contentView", "Lcom/tencent/guild/aio/msglist/text/util/c;", "i", "Lcom/tencent/guild/aio/msglist/text/util/c;", "bubbleColorObserverDetachHandle", "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "videoViewer", "Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", "guildPicViewer", "D", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", "m1", "()Landroid/widget/TextView;", "tv", "", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "guildPicViewerMap", "G", "Z", "curMultiSelect", "<init>", "(Landroid/view/View;)V", "H", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildBubbleContentComponent extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildPicViewer guildPicViewer;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy tv;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Map<Long, GuildPicViewer> guildPicViewerMap;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean curMultiSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.text.util.c bubbleColorObserverDetachHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildVideoViewer videoViewer;

    public GuildBubbleContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        LinearLayout linearLayout = new LinearLayout(root.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.contentView = linearLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent$tv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
                Context context = GuildBubbleContentComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                return bubbleTextViewUtil.c(context);
            }
        });
        this.tv = lazy;
        this.guildPicViewerMap = new LinkedHashMap();
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

    private final TextView m1() {
        return (TextView) this.tv.getValue();
    }

    private final boolean n1(List<Object> payloads) {
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
    public final void o1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads, boolean isMultiSelect) {
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.currentMsgItem = guildMsgItem;
            s1(guildMsgItem, msgItem.isSelf());
            this.videoViewer = null;
            this.guildPicViewerMap.clear();
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) msgItem;
            ArrayList<MsgElement> arrayList = guildMsgItem2.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            for (MsgElement element : arrayList) {
                IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (iGuildMsgElementApi.isPictureElem(element)) {
                    RelativeLayout l16 = l1();
                    GuildPicViewer guildPicViewer = new GuildPicViewer(guildMsgItem2, element, l16, isMultiSelect, new Function3<MsgRecord, PicElement, View, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent$initUIState$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MsgRecord msgRecord, PicElement picElement, View view) {
                            invoke2(msgRecord, picElement, view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull MsgRecord msgRecord, @Nullable PicElement picElement, @NotNull View clickedView) {
                            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
                            GuildBubbleContentComponent.this.sendIntent(new a.j(msgRecord, picElement, clickedView));
                        }
                    });
                    this.guildPicViewer = guildPicViewer;
                    this.guildPicViewerMap.put(Long.valueOf(element.elementId), guildPicViewer);
                    this.contentView.addView(l16);
                } else if (((IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class)).isVideoElem(element)) {
                    RelativeLayout l17 = l1();
                    if (this.videoViewer == null) {
                        this.videoViewer = new GuildVideoViewer(l17, getMContext(), new Function4<Context, MsgRecord, View, Long, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent$initUIState$1$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Context context, MsgRecord msgRecord, View view, Long l3) {
                                invoke(context, msgRecord, view, l3.longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View videoView, long j3) {
                                Intrinsics.checkNotNullParameter(context, "context");
                                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                                Intrinsics.checkNotNullParameter(videoView, "videoView");
                                GuildBubbleContentComponent.this.sendIntent(new a.m(context, msgRecord, videoView, j3));
                            }
                        }, new Function3<Context, MsgRecord, Integer, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent$initUIState$1$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Context context, MsgRecord msgRecord, Integer num) {
                                invoke(context, msgRecord, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull Context context, @NotNull MsgRecord msgRecord, int i3) {
                                Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                                if (i3 == 0) {
                                    GuildBubbleContentComponent.this.sendIntent(new a.p(msgRecord));
                                } else if (i3 == 1) {
                                    GuildBubbleContentComponent.this.sendIntent(new a.n(msgRecord));
                                } else {
                                    if (i3 != 2) {
                                        return;
                                    }
                                    GuildBubbleContentComponent.this.sendIntent(new a.o(msgRecord));
                                }
                            }
                        });
                    }
                    GuildVideoViewer guildVideoViewer = this.videoViewer;
                    if (guildVideoViewer != null) {
                        guildVideoViewer.u(guildMsgItem2);
                    }
                    this.contentView.addView(l17);
                }
            }
            com.tencent.aio.api.runtime.a f16 = f1();
            if (f16 == null) {
                return;
            }
            GuildCombineUtil guildCombineUtil = GuildCombineUtil.f111919a;
            View view = this.root;
            LifecycleOwner viewLifecycleOwner = f16.c().getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "aioContext.fragment.viewLifecycleOwner");
            this.bubbleColorObserverDetachHandle = guildCombineUtil.w(view, msgItem, viewLifecycleOwner);
        }
    }

    private final boolean q1(GuildMsgItem msgItem) {
        return !TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_article_is_main_msg", null, 2, null));
    }

    private final void r1(String msg2, Object payload) {
        if (payload instanceof b.GuildMsgItemRichMediaPayload) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildBubbleContentComponent", 2, "updateBindUIState  RichMediaPayload , fileTransNotifyInfo = " + ((b.GuildMsgItemRichMediaPayload) payload).getFileTransNotifyInfo());
            }
            GuildVideoViewer guildVideoViewer = this.videoViewer;
            if (guildVideoViewer != null) {
                guildVideoViewer.g0(msg2, ((b.GuildMsgItemRichMediaPayload) payload).getFileTransNotifyInfo());
                return;
            }
            return;
        }
        if (payload instanceof b.GuildMsgItemStatusPayload) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildBubbleContentComponent", 2, "updateBindUIState  GuildMsgItemStatusPayload , sendStatus = " + ((b.GuildMsgItemStatusPayload) payload).getSendStatus());
            }
            GuildVideoViewer guildVideoViewer2 = this.videoViewer;
            if (guildVideoViewer2 != null) {
                guildVideoViewer2.g0(msg2, payload);
            }
        }
    }

    private final void s1(GuildMsgItem msgItem, boolean isSelf) {
        boolean equals$default;
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        ArrayList arrayList2 = new ArrayList();
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement element = it.next();
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            if (iGuildMsgElementApi.isTextElem(element)) {
                arrayList2.add(element);
            }
        }
        if (arrayList2.size() <= 0) {
            return;
        }
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
        MsgRecord msgRecord = msgItem.getMsgRecord();
        TextView m16 = m1();
        GuildHighlightParams.GuildHighlightStyle h16 = bq0.e.f28951a.h(msgItem.isSelf(), true, q1(msgItem), 17.0f, 17.0f);
        com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
        boolean isSelf2 = msgItem.isSelf();
        equals$default = StringsKt__StringsJVMKt.equals$default(GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_article_is_main_msg", null, 2, null), "1", false, 2, null);
        m1().setText(TextBubbleContentParser.e(textBubbleContentParser, msgRecord, m16, arrayList2, h16, context, 0, isSelf2, equals$default, null, false, false, 1824, null));
        this.contentView.addView(m1());
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (n1(payloads)) {
            final boolean z16 = UIUtil.f112434a.z(payloads);
            p1(z16, msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent$bind$1
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
                    LinearLayout linearLayout;
                    LinearLayout linearLayout2;
                    linearLayout = GuildBubbleContentComponent.this.contentView;
                    if (linearLayout.getChildCount() > 0) {
                        linearLayout2 = GuildBubbleContentComponent.this.contentView;
                        linearLayout2.removeAllViews();
                    }
                    GuildBubbleContentComponent.this.o1(position, msgItem, payloads, z16);
                    GuildBubbleContentComponent.this.curMultiSelect = z16;
                }
            });
        }
        View findViewById = this.root.findViewById(R.id.f164907u83);
        if (msgItem.isSelf()) {
            if (findViewById != null) {
                findViewById.setBackgroundDrawable(getMContext().getResources().getDrawable(R.drawable.guild_aio_self_bubble_bg));
            }
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            TextView m16 = m1();
            com.tencent.guild.aio.msglist.text.util.f fVar = com.tencent.guild.aio.msglist.text.util.f.f111944a;
            guildUIUtils.b(m16, com.tencent.guild.aio.msglist.text.util.f.o(fVar, false, 1, null));
            m1().setLinkTextColor(fVar.j(getMContext()));
            return;
        }
        if (findViewById != null) {
            findViewById.setBackgroundDrawable(getMContext().getResources().getDrawable(R.drawable.guild_aio_friend_bubble_bg));
        }
        GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
        TextView m17 = m1();
        com.tencent.guild.aio.msglist.text.util.f fVar2 = com.tencent.guild.aio.msglist.text.util.f.f111944a;
        guildUIUtils2.b(m17, com.tencent.guild.aio.msglist.text.util.f.i(fVar2, false, 1, null));
        m1().setLinkTextColor(fVar2.j(getMContext()));
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
        return new l();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        GuildVideoViewer guildVideoViewer;
        GuildVideoViewer guildVideoViewer2;
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
            if (msgId == guildMsgItem.getMsgId() && (guildVideoViewer2 = this.videoViewer) != null) {
                guildVideoViewer2.M();
                return;
            }
            return;
        }
        if (state instanceof MsgListVideoState) {
            GuildVideoViewer guildVideoViewer3 = this.videoViewer;
            if (guildVideoViewer3 != null) {
                MsgListVideoState msgListVideoState = (MsgListVideoState) state;
                guildVideoViewer3.k0(msgListVideoState.getPause(), msgListVideoState.getMute());
                return;
            }
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
            if (msgId2 == guildMsgItem.getMsgId() && (guildVideoViewer = this.videoViewer) != null) {
                guildVideoViewer.L();
            }
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
        GuildVideoViewer guildVideoViewer = this.videoViewer;
        if (guildVideoViewer != null) {
            guildVideoViewer.U();
        }
        com.tencent.guild.aio.msglist.text.util.c cVar = this.bubbleColorObserverDetachHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.bubbleColorObserverDetachHandle = null;
    }

    public final void p1(boolean isMultiSelect, @NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
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
