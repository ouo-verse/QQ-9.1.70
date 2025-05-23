package com.tencent.guild.aio.msglist.holder.component.mix;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.component.mix.a;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.pic.GuildPicViewer;
import com.tencent.guild.aio.msglist.text.GuildTextContentUIState;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
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
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 J2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010-\u001a\u00020\u001c\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J$\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001f0\u001eH\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\rH\u0016R\u0017\u0010-\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/mix/GuildMixPicBubbleComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "p1", "", "", "payloads", ICustomDataEditor.NUMBER_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "isMultiSelect", "", "o1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "r1", "Landroid/widget/RelativeLayout;", "l1", "b1", "bindData", "Lkotlin/Function0;", "function", "q1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "Landroid/view/View;", "d1", "", "Ljava/lang/Class;", "getObserverStates", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "getTag", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "contentView", "Lwq0/l;", "i", "Lkotlin/Lazy;", "m1", "()Lwq0/l;", "tv", "", "", "Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "guildPicViewerMap", "Lcom/tencent/guild/aio/msglist/text/util/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/msglist/text/util/c;", "bubbleColorObserverDetachHandle", "D", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "E", "Z", "curMultiSelect", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMixPicBubbleComponent extends com.tencent.guild.aio.msglist.holder.component.a {

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
    private Map<Long, GuildPicViewer> guildPicViewerMap;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/mix/GuildMixPicBubbleComponent$b", "Lcom/tencent/guild/aio/msglist/holder/component/mix/a$a;", "Lcom/tencent/aio/api/runtime/a;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements a.InterfaceC1201a {
        b() {
        }

        @Override // com.tencent.guild.aio.msglist.holder.component.mix.a.InterfaceC1201a
        @Nullable
        public com.tencent.aio.api.runtime.a a() {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            GuildMixPicBubbleComponent.this.sendIntent(new s.GetAioContext(aioContextWrapper));
            return aioContextWrapper.getContext();
        }
    }

    public GuildMixPicBubbleComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        a aVar = a.f111557a;
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        LinearLayout a16 = aVar.a(context);
        this.contentView = a16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixPicBubbleComponent$tv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
                Context context2 = GuildMixPicBubbleComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                return BubbleTextViewUtil.f(bubbleTextViewUtil, context2, false, 2, null);
            }
        });
        this.tv = lazy;
        this.guildPicViewerMap = new LinkedHashMap();
        a16.addView(m1().getView());
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

    private final l m1() {
        return (l) this.tv.getValue();
    }

    private final boolean n1(List<Object> payloads) {
        b.GuildMsgItemRichMediaPayload guildMsgItemRichMediaPayload;
        FileTransNotifyInfo fileTransNotifyInfo;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get(GuildMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null) {
                    if (obj2 instanceof b.GuildMsgItemRichMediaPayload) {
                        guildMsgItemRichMediaPayload = (b.GuildMsgItemRichMediaPayload) obj2;
                    } else {
                        guildMsgItemRichMediaPayload = null;
                    }
                    if (guildMsgItemRichMediaPayload != null && (fileTransNotifyInfo = guildMsgItemRichMediaPayload.getFileTransNotifyInfo()) != null) {
                        Iterator<GuildPicViewer> it = this.guildPicViewerMap.values().iterator();
                        while (it.hasNext()) {
                            it.next().h(fileTransNotifyInfo);
                        }
                    }
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads, boolean isMultiSelect) {
        Fragment c16;
        LifecycleOwner viewLifecycleOwner;
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.currentMsgItem = guildMsgItem;
            r1(guildMsgItem);
            this.guildPicViewerMap.clear();
            ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            for (MsgElement element : arrayList) {
                IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (iGuildMsgElementApi.isPictureElem(element)) {
                    RelativeLayout l16 = l1();
                    this.guildPicViewerMap.put(Long.valueOf(element.elementId), new GuildPicViewer(guildMsgItem, element, l16, isMultiSelect, new Function3<MsgRecord, PicElement, View, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixPicBubbleComponent$initUIState$1$guildPicViewer$1
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
                            GuildMixPicBubbleComponent.this.sendIntent(new a.j(msgRecord, picElement, clickedView));
                        }
                    }));
                    this.contentView.addView(l16);
                }
            }
            com.tencent.aio.api.runtime.a f16 = f1();
            if (f16 != null && (c16 = f16.c()) != null && (viewLifecycleOwner = c16.getViewLifecycleOwner()) != null) {
                this.bubbleColorObserverDetachHandle = GuildCombineUtil.f111919a.w(this.root, msgItem, viewLifecycleOwner);
            }
        }
    }

    private final boolean p1() {
        Iterator<GuildPicViewer> it = this.guildPicViewerMap.values().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().i()) {
                z16 = true;
            }
        }
        return z16;
    }

    private final void r1(GuildMsgItem msgItem) {
        b bVar = new b();
        a aVar = a.f111557a;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        aVar.b(context, msgItem, m1(), bVar);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (n1(payloads)) {
            final boolean z16 = UIUtil.f112434a.z(payloads);
            q1(z16, msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.mix.GuildMixPicBubbleComponent$bind$1
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
                    LinearLayout linearLayout3;
                    linearLayout = GuildMixPicBubbleComponent.this.contentView;
                    if (linearLayout.getChildCount() > 1) {
                        linearLayout2 = GuildMixPicBubbleComponent.this.contentView;
                        linearLayout3 = GuildMixPicBubbleComponent.this.contentView;
                        linearLayout2.removeViews(1, linearLayout3.getChildCount() - 1);
                    }
                    GuildMixPicBubbleComponent.this.o1(position, msgItem, payloads, z16);
                    GuildMixPicBubbleComponent.this.curMultiSelect = z16;
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
        return new com.tencent.guild.aio.msglist.holder.component.mix.b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildTextContentUIState.PostThemeChangedState.class);
        return listOf;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildMixPicBubbleMsgItemVB";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildTextContentUIState.PostThemeChangedState) {
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            r1(guildMsgItem);
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
        com.tencent.guild.aio.msglist.text.util.c cVar = this.bubbleColorObserverDetachHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.bubbleColorObserverDetachHandle = null;
        super.onDestroy();
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
                if (guildMsgItem2.isSameContent(bindData) && !p1()) {
                    return;
                }
            }
        }
        function.invoke();
    }
}
