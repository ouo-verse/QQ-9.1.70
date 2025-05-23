package com.tencent.guild.aio.msglist.marketface;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.msglist.marketface.a;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010(\u001a\u00020\u0013\u00a2\u0006\u0004\b6\u00107J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\"H\u0016R\u0017\u0010(\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/msglist/marketface/GuildMarketFaceComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", "m1", "", "q1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", ICustomDataEditor.NUMBER_PARAM_1, "", "msgId", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "data", "p1", "Landroid/view/View;", "d1", "b1", "bindData", "Lkotlin/Function0;", "function", "o1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Lcom/tencent/image/URLImageView;", "i", "Lkotlin/Lazy;", "l1", "()Lcom/tencent/image/URLImageView;", "contentIv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/msglist/a;", "currentMsgItem", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMarketFaceComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a currentMsgItem;

    public GuildMarketFaceComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.container = new FrameLayout(root.getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<URLImageView>() { // from class: com.tencent.guild.aio.msglist.marketface.GuildMarketFaceComponent$contentIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final URLImageView invoke() {
                FrameLayout frameLayout;
                URLImageView uRLImageView = new URLImageView(GuildMarketFaceComponent.this.getRoot().getContext());
                GuildMarketFaceComponent guildMarketFaceComponent = GuildMarketFaceComponent.this;
                uRLImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                uRLImageView.setImageResource(R.drawable.c0i);
                frameLayout = guildMarketFaceComponent.container;
                frameLayout.addView(uRLImageView);
                return uRLImageView;
            }
        });
        this.contentIv = lazy;
    }

    private final URLImageView l1() {
        return (URLImageView) this.contentIv.getValue();
    }

    private final boolean m1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        MarketFaceElement marketFaceElement;
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(11);
        String str = null;
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        View findViewById = this.root.findViewById(R.id.f164907u83);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.lvj);
        }
        q1();
        int hashCode = hashCode();
        if (marketFaceElement != null) {
            str = marketFaceElement.faceName;
        }
        QLog.i("GuildMarketFaceComponent", 4, "HashCode=" + hashCode + "== bind position=" + position + " name=" + str);
        p1(guildMsgItem.getMsgRecord().msgId, marketFaceElement);
    }

    private final void p1(long msgId, MarketFaceElement data) {
        if (data != null && l1() != null) {
            URLImageView l16 = l1();
            if (l16 != null) {
                sendIntent(new a.C1204a(new IntentData(data, l16, msgId)));
                return;
            }
            return;
        }
        QLog.i("GuildMarketFaceComponent", 4, "data == null OR contentIv == null");
    }

    private final void q1() {
        l1().setImageResource(R.drawable.c0i);
        ViewGroup.LayoutParams layoutParams = l1().getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (m1(payloads)) {
            o1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.marketface.GuildMarketFaceComponent$bind$1
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
                    GuildMarketFaceComponent.this.n1(position, msgItem, payloads);
                    GuildMarketFaceComponent.this.currentMsgItem = msgItem;
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.container;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new GuildMarketFaceComponentVM();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildMarketFaceComponent";
    }

    public final void o1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        if (this.currentMsgItem == null) {
            function.invoke();
        } else {
            function.invoke();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        QLog.i("GuildMarketFaceComponent", 4, "onCreateView");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        QLog.i("GuildMarketFaceComponent", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
    }
}
