package com.tencent.guild.aio.msglist.file;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 92\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010'\u001a\u00020\u0017\u00a2\u0006\u0004\b8\u0010&J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\r\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\"\u0010'\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/guild/aio/msglist/file/GuildFileContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "isMultiSelect", "", ICustomDataEditor.NUMBER_PARAM_1, "m1", "", "msg", "payload", "p1", "b1", "bindData", "Lkotlin/Function0;", "function", "o1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "root", "Landroid/widget/RelativeLayout;", h.F, "Lkotlin/Lazy;", "l1", "()Landroid/widget/RelativeLayout;", "contentView", "Lcom/tencent/guild/aio/msglist/file/GuildFileViewer;", "i", "Lcom/tencent/guild/aio/msglist/file/GuildFileViewer;", "guildFileViewer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/msglist/a;", "currentMsgItem", BdhLogUtil.LogTag.Tag_Conn, "Z", "curMultiSelect", "<init>", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildFileContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean curMultiSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFileViewer guildFileViewer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a currentMsgItem;

    public GuildFileContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.guild.aio.msglist.file.GuildFileContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                return new RelativeLayout(GuildFileContentComponent.this.getRoot().getContext());
            }
        });
        this.contentView = lazy;
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
                        p1("rich_media_state", fileTransNotifyInfo);
                    }
                }
                Object obj3 = map.get(GuildMsgItemPayloadType.STATUS_PAYLOAD);
                if (obj3 != null) {
                    p1("msg_send_status_state", obj3);
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads, boolean isMultiSelect) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        this.guildFileViewer = new GuildFileViewer(guildMsgItem, guildMsgItem.getFirstTypeElement(3), l1(), getMContext(), f1(), isMultiSelect, new Function3<MsgRecord, PicElement, View, Unit>() { // from class: com.tencent.guild.aio.msglist.file.GuildFileContentComponent$initUIState$1
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
                QLog.i("GuildFileContentComponent", 4, "on pic Clicked");
                GuildFileContentComponent.this.sendIntent(new a.j(msgRecord, picElement, clickedView));
            }
        });
    }

    private final void p1(String msg2, Object payload) {
        GuildFileViewer guildFileViewer = this.guildFileViewer;
        if (guildFileViewer != null) {
            guildFileViewer.D(msg2, payload);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildCombineUtil.f111919a.x(this.root, msgItem);
        if (m1(payloads)) {
            final boolean z16 = UIUtil.f112434a.z(payloads);
            o1(z16, msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.file.GuildFileContentComponent$bind$1
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
                    GuildFileContentComponent.this.n1(position, msgItem, payloads, z16);
                    GuildFileContentComponent.this.curMultiSelect = z16;
                    GuildFileContentComponent.this.currentMsgItem = msgItem;
                }
            });
        }
        GuildFileViewer guildFileViewer = this.guildFileViewer;
        if (guildFileViewer != null) {
            guildFileViewer.F(msgItem);
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
        return new c();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildFileContentComponent";
    }

    public final void o1(boolean isMultiSelect, @NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
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
                if (aVar2.isSameContent(bindData)) {
                    return;
                }
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
}
