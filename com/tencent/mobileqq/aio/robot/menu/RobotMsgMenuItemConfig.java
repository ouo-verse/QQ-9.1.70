package com.tencent.mobileqq.aio.robot.menu;

import a81.e;
import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.n;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.f;
import com.tencent.mobileqq.aio.msglist.holder.component.mix.AIOMixContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.utils.aa;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqaudio.audioplayer.c;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ac;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.ai;
import com.tencent.qqnt.aio.menu.am;
import com.tencent.qqnt.aio.menu.b;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.q;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.aio.menu.v;
import com.tencent.qqnt.aio.menu.y;
import com.tencent.qqnt.aio.menu.z;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0010JC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010JC\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0010JC\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0010JC\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0010JC\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0010JC\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0010JC\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0010JC\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0010R\u001b\u0010\u001d\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/robot/menu/RobotMsgMenuItemConfig;", "Lcom/tencent/qqnt/aio/menu/q;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "l", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Landroid/content/Context;", "context", "vb", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", "j", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)Ljava/util/List;", h.F, "i", "e", "g", "b", "k", "a", "d", "c", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "disableAutoHideTextSwitch", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotMsgMenuItemConfig extends q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy disableAutoHideTextSwitch;

    public RobotMsgMenuItemConfig() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.robot.menu.RobotMsgMenuItemConfig$disableAutoHideTextSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("ptt_disable_auto_hide_text_switch_9170_141743012", true));
            }
        });
        this.disableAutoHideTextSwitch = lazy;
    }

    private final boolean m() {
        return ((Boolean) this.disableAutoHideTextSwitch.getValue()).booleanValue();
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<d> a(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<d> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{new com.tencent.qqnt.aio.menu.d(context, msgItem), new k(context, msgItem, vb5, null, 8, null), new i(context, msgItem), new u(context, msgItem, vb5), new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5)});
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<d> b(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List listOf;
        ArkAppContainer arkAppContainer;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        ArrayList arrayList = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new ag(context, msgItem)});
        arrayList.addAll(listOf);
        if (msgItem instanceof ArkMsgItem) {
            ArkMsgItem arkMsgItem = (ArkMsgItem) msgItem;
            com.tencent.qqnt.msg.data.a t26 = arkMsgItem.t2();
            ArkAppConfig arkAppConfig = null;
            d.h hVar = new d.h(new d.e(null, 1, null));
            vb5.sendIntent(hVar);
            com.tencent.aio.api.runtime.a a16 = hVar.a().a();
            t b16 = t.INSTANCE.b(a16);
            if (b16 != null) {
                arkAppContainer = b16.o(msgItem.getMsgId());
            } else {
                arkAppContainer = null;
            }
            if (arkAppContainer != null) {
                arkAppConfig = arkAppContainer.e();
            }
            e.Companion companion = e.INSTANCE;
            if (companion.w(arkMsgItem)) {
                arrayList.add(0, new i(context, msgItem));
            }
            if (companion.o(t26, arkAppConfig)) {
                arrayList.add(new u(context, msgItem, vb5));
            }
            if (companion.n(t26, arkAppConfig, a16, arkMsgItem)) {
                arrayList.add(0, new k(context, msgItem, vb5, null, 8, null));
            }
            return arrayList;
        }
        if (msgItem instanceof TemplateMsgItem) {
            com.tencent.mobileqq.aio.msg.template.d n26 = ((TemplateMsgItem) msgItem).n2();
            if (n26 == null) {
                return arrayList;
            }
            com.tencent.mobileqq.aio.msglist.holder.component.template.common.k kVar = com.tencent.mobileqq.aio.msglist.holder.component.template.common.k.f191932a;
            if (kVar.c(n26)) {
                arrayList.add(new u(context, msgItem, vb5));
            }
            if (kVar.a(n26)) {
                arrayList.add(0, new i(context, msgItem));
            }
            if (kVar.b(n26)) {
                arrayList.add(0, new k(context, msgItem, vb5, null, 8, null));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> c(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        FileElement fileElement;
        int j3;
        int lastIndex;
        int lastIndex2;
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof FileMsgItem)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new u(context, msgItem, vb5));
        if (aa.f194101a.b(msgItem)) {
            mutableListOf.add(2, new i(context, msgItem));
        }
        FileMsgItem fileMsgItem = (FileMsgItem) msgItem;
        MsgElement q26 = fileMsgItem.q2();
        if (q26 != null && (fileElement = q26.fileElement) != null && (j3 = c81.a.j(fileElement)) != 0) {
            if (j3 != 2) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mutableListOf);
                mutableListOf.add(lastIndex, new ai(context, msgItem, vb5));
                lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(mutableListOf);
                mutableListOf.add(lastIndex2, new am(context, msgItem, vb5));
            } else if (c81.a.b(msgItem, fileMsgItem.n2())) {
                mutableListOf.add(0, new v(context, msgItem, vb5));
            }
        }
        return mutableListOf;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> d(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new b(context, msgItem, vb5), new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new u(context, msgItem, vb5), new ac(context, msgItem, vb5));
        return mutableListOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> e(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        ArrayList arrayListOf;
        com.tencent.aio.api.runtime.a aVar;
        Object obj;
        j e16;
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof MarkdownMsgItem)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        boolean z16 = false;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new f(context, (MarkdownMsgItem) msgItem), new RobotForwardMenuItem(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new u(context, msgItem, vb5), new ag(context, msgItem));
        BaseVM mUIModel = vb5.getMUIModel();
        e.f fVar = null;
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext();
        } else {
            aVar = null;
        }
        if (aVar != null && (e16 = aVar.e()) != null) {
            obj = e16.k(RobotMsgIntent.GetSupportNewInteraction.f188690d);
        } else {
            obj = null;
        }
        if (obj instanceof e.f) {
            fVar = (e.f) obj;
        }
        if (fVar != null && fVar.a()) {
            z16 = true;
        }
        if (z16) {
            arrayListOf.add(3, new RobotFavMenuItem(context, msgItem, vb5));
        }
        return arrayListOf;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> g(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        ArrayList arrayListOf;
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof o) || !(vb5 instanceof AIOMixContentComponent)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        SelectableLinearLayout x26 = ((AIOMixContentComponent) vb5).x2();
        if (((o) msgItem).v2()) {
            com.tencent.qqnt.aio.menu.e eVar = new com.tencent.qqnt.aio.menu.e(context, msgItem);
            eVar.l(x26);
            Unit unit = Unit.INSTANCE;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{eVar, new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5)});
            return listOf;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.aio.menu.e eVar2 = new com.tencent.qqnt.aio.menu.e(context, msgItem);
        eVar2.l(x26);
        Unit unit2 = Unit.INSTANCE;
        i iVar = new i(context, msgItem);
        iVar.i(x26);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(eVar2, new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), iVar, new u(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new ag(context, msgItem));
        arrayList.addAll(arrayListOf);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> h(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List listOf;
        List listOf2;
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof PicMsgItem)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        if (MsgExtKt.u(((PicMsgItem) msgItem).p2())) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new b(context, msgItem, vb5), new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new i(context, msgItem), new u(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new ac(context, msgItem, vb5), new ag(context, msgItem), new com.tencent.qqnt.aio.menu.o(context, msgItem)});
            arrayList.addAll(listOf2);
        } else {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new k(context, msgItem, vb5, null, 8, null), new af(context, msgItem, vb5), new i(context, msgItem), new u(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new b(context, msgItem, vb5), new ag(context, msgItem)});
            arrayList.addAll(listOf);
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> i(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        List listOf;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof PttMsgItem) || !(vb5 instanceof AIOPttContentComponent)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        boolean z16 = true;
        boolean z17 = !c.b(MobileQQ.sMobileQQ.peekAppRuntime());
        ArrayList arrayList = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new y(context, msgItem, vb5, z17), new af(context, msgItem, vb5), new i(context, msgItem), new u(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new ag(context, msgItem)});
        arrayList.addAll(listOf);
        if (m()) {
            areEqual = ((PttMsgItem) msgItem).p2().b();
        } else {
            d.i iVar = new d.i(msgItem.getMsgId(), null, 2, null);
            vb5.sendIntent(iVar);
            areEqual = Intrinsics.areEqual(iVar.b(), Boolean.TRUE);
        }
        if (!((PttMsgItem) msgItem).G2()) {
            arrayList.add(1, new z(context, msgItem, vb5, areEqual));
        }
        if (((AIOPttContentComponent) vb5).A2() != 1.0f) {
            z16 = false;
        }
        if (z16) {
            arrayList.add(2, new com.tencent.qqnt.aio.menu.aa(context, msgItem, vb5, 2.0f));
        } else {
            arrayList.add(2, new com.tencent.qqnt.aio.menu.aa(context, msgItem, vb5, 1.0f));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> j(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof ae) || !(vb5 instanceof AIOTextContentComponent)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        SelectableLinearLayout Z1 = ((AIOTextContentComponent) vb5).Z1();
        com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(context, msgItem);
        dVar.l(Z1);
        Unit unit = Unit.INSTANCE;
        i iVar = new i(context, msgItem);
        iVar.i(Z1);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{dVar, new k(context, msgItem, vb5, Z1), new af(context, msgItem, vb5), iVar, new u(context, msgItem, vb5), new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5), new ag(context, msgItem)});
        arrayList.addAll(listOf);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> k(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (!(msgItem instanceof ShortVideoMsgItem)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v(context, msgItem, vb5));
        arrayList.add(new k(context, msgItem, vb5, null, 8, null));
        ShortVideoMsgItem shortVideoMsgItem = (ShortVideoMsgItem) msgItem;
        if (shortVideoMsgItem.P2()) {
            arrayList.add(new af(context, msgItem, vb5));
        }
        if (!shortVideoMsgItem.O2() && !shortVideoMsgItem.Q2() && aa.f194101a.b(msgItem)) {
            arrayList.add(new i(context, msgItem));
        }
        arrayList.add(new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5));
        arrayList.add(new u(context, msgItem, vb5));
        arrayList.add(new ag(context, msgItem));
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    public boolean l(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        int i3 = msgItem.getMsgRecord().chatType;
        if (!((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(msgItem.getMsgRecord().peerUin), Integer.valueOf(i3))) {
            return false;
        }
        if (!(msgItem instanceof ae) && !(msgItem instanceof o) && !(msgItem instanceof PicMsgItem) && !(msgItem instanceof MarkdownMsgItem) && !(msgItem instanceof PttMsgItem) && !(msgItem instanceof ShortVideoMsgItem) && !(msgItem instanceof AniStickerMsgItem) && !(msgItem instanceof n) && !(msgItem instanceof ArkMsgItem) && !(msgItem instanceof TemplateMsgItem) && !(msgItem instanceof FileMsgItem)) {
            return false;
        }
        return true;
    }
}
