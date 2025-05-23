package com.tencent.guild.aio.msglist.pic;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010#\u001a\u00020\u0018\u00a2\u0006\u0004\b4\u00105J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0017\u0010#\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/msglist/pic/GuildPicContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "isMultiSelect", "", "o1", "p1", ICustomDataEditor.NUMBER_PARAM_1, "b1", "bindData", "Lkotlin/Function0;", "function", "q1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/RelativeLayout;", h.F, "Lkotlin/Lazy;", "m1", "()Landroid/widget/RelativeLayout;", "contentView", "Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", "i", "Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", "guildPicView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/msglist/a;", "currentMsgItem", BdhLogUtil.LogTag.Tag_Conn, "Z", "curMultiSelect", "<init>", "(Landroid/view/View;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPicContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean curMultiSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildPicViewer guildPicView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a currentMsgItem;

    public GuildPicContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.guild.aio.msglist.pic.GuildPicContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                return new RelativeLayout(GuildPicContentComponent.this.getRoot().getContext());
            }
        });
        this.contentView = lazy;
    }

    private final RelativeLayout m1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final boolean n1(List<Object> payloads) {
        b.GuildMsgItemRichMediaPayload guildMsgItemRichMediaPayload;
        FileTransNotifyInfo fileTransNotifyInfo;
        GuildPicViewer guildPicViewer;
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
                    if (guildMsgItemRichMediaPayload != null && (fileTransNotifyInfo = guildMsgItemRichMediaPayload.getFileTransNotifyInfo()) != null && (guildPicViewer = this.guildPicView) != null) {
                        guildPicViewer.h(fileTransNotifyInfo);
                    }
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads, boolean isMultiSelect) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(2);
        GuildPicViewer guildPicViewer = this.guildPicView;
        if (guildPicViewer == null) {
            this.guildPicView = new GuildPicViewer(guildMsgItem, firstTypeElement, m1(), isMultiSelect, new Function3<MsgRecord, PicElement, View, Unit>() { // from class: com.tencent.guild.aio.msglist.pic.GuildPicContentComponent$initUIState$1
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
                    com.tencent.aio.data.msglist.a aVar;
                    Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                    Intrinsics.checkNotNullParameter(clickedView, "clickedView");
                    QLog.i("GuildPicContentComponent", 4, "on pic Clicked");
                    GuildPicContentComponent guildPicContentComponent = GuildPicContentComponent.this;
                    aVar = guildPicContentComponent.currentMsgItem;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        aVar = null;
                    }
                    guildPicContentComponent.sendIntent(new a.j(((GuildMsgItem) aVar).getMsgRecord(), picElement, clickedView));
                }
            });
        } else if (guildPicViewer != null) {
            guildPicViewer.b(firstTypeElement, guildMsgItem);
        }
    }

    private final boolean p1() {
        GuildPicViewer guildPicViewer = this.guildPicView;
        if (guildPicViewer == null || !guildPicViewer.i()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildCombineUtil.f111919a.x(this.root, msgItem);
        if (n1(payloads)) {
            final boolean z16 = UIUtil.f112434a.z(payloads);
            q1(z16, msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.pic.GuildPicContentComponent$bind$1
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
                    GuildPicContentComponent.this.o1(position, msgItem, payloads, z16);
                    GuildPicContentComponent.this.curMultiSelect = z16;
                    GuildPicContentComponent.this.currentMsgItem = msgItem;
                }
            });
        } else {
            this.currentMsgItem = msgItem;
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return m1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new b();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildPicContentComponent";
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    public final void q1(boolean isMultiSelect, @NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        com.tencent.aio.data.msglist.a aVar = this.currentMsgItem;
        if (aVar == null) {
            function.invoke();
            return;
        }
        if (isMultiSelect == this.curMultiSelect) {
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
                if (aVar2.isSameContent(bindData) && !p1()) {
                    return;
                }
            }
        }
        function.invoke();
    }
}
