package com.tencent.mobileqq.aio.robot.menu;

import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e*\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0005:\u0001%B+\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001a\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/menu/RobotForwardMenuItem;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/menu/ui/d;", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "selectContent", "", "l", "", "f", "", "c", h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/base/mvvm/a;", "k", "()Lcom/tencent/aio/base/mvvm/a;", "vb", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "j", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "g", "Ljava/lang/String;", "title", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/base/mvvm/a;Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;)V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotForwardMenuItem<VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VB vb;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SelectableLinearLayout selectContent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    public /* synthetic */ RobotForwardMenuItem(Context context, com.tencent.aio.data.msglist.a aVar, a aVar2, SelectableLinearLayout selectableLinearLayout, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, aVar2, (i3 & 8) != 0 ? null : selectableLinearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (com.tencent.mobileqq.aio.utils.d.v(r1) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(SelectableLinearLayout selectContent) {
        MarketFaceElement marketFaceElement;
        if (selectContent != null) {
            if (selectContent.l() == selectContent.contentLength()) {
                AIOMsgItem msgItem = d();
                Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
            }
            VB vb5 = this.vb;
            String obj = selectContent.m().toString();
            AIOMsgItem msgItem2 = d();
            Intrinsics.checkNotNullExpressionValue(msgItem2, "msgItem");
            vb5.sendIntent(new p.d(obj, msgItem2));
            return;
        }
        if (d().getMsgRecord().msgType == 17) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("touin", d().getMsgRecord().peerUin);
            MsgElement firstTypeElement = d().getFirstTypeElement(11);
            Integer num = null;
            if (firstTypeElement != null) {
                marketFaceElement = firstTypeElement.marketFaceElement;
            } else {
                marketFaceElement = null;
            }
            if (marketFaceElement != null) {
                num = Integer.valueOf(marketFaceElement.emojiPackageId);
            }
            jSONObject.put("emoji_id", num);
            ((IMarketFaceTailConfigExt) QRoute.api(IMarketFaceTailConfigExt.class)).reportAction(QCircleDaTongConstant.ElementParamValue.LONG_PRESS, TransactionActivity.PREF_NAME_TRANSFER, "4", 102, jSONObject.toString());
        }
        VB vb6 = this.vb;
        AIOMsgItem msgItem3 = d();
        Intrinsics.checkNotNullExpressionValue(msgItem3, "msgItem");
        vb6.sendIntent(new p.c(msgItem3));
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        return R.drawable.jx7;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        return R.id.cjs;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        return "RobotForwardMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        com.tencent.aio.api.runtime.a aVar;
        BaseVM mUIModel = this.vb.getMUIModel();
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext();
        } else {
            aVar = null;
        }
        i81.a.a(aVar, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.robot.menu.RobotForwardMenuItem$onClickMenu$1
            final /* synthetic */ RobotForwardMenuItem<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                com.tencent.aio.api.runtime.a aVar2;
                j e16;
                FrameworkVM mUIModel2 = this.this$0.k().getMUIModel();
                if (mUIModel2 == null || (aVar2 = (com.tencent.aio.api.runtime.a) mUIModel2.getSafetyContext()) == null || (e16 = aVar2.e()) == null) {
                    return null;
                }
                AIOMsgItem msgItem = this.this$0.d();
                Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
                e16.h(new RobotMsgIntent.SingleMsgShare(msgItem));
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.robot.menu.RobotForwardMenuItem$onClickMenu$2
            final /* synthetic */ RobotForwardMenuItem<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RobotForwardMenuItem<VB> robotForwardMenuItem = this.this$0;
                robotForwardMenuItem.l(robotForwardMenuItem.getSelectContent());
            }
        });
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final SelectableLinearLayout getSelectContent() {
        return this.selectContent;
    }

    @NotNull
    public final VB k() {
        return this.vb;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotForwardMenuItem(@NotNull Context context, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull VB vb5, @Nullable SelectableLinearLayout selectableLinearLayout) {
        super((AIOMsgItem) msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        this.context = context;
        this.vb = vb5;
        this.selectContent = selectableLinearLayout;
        String string = context.getResources().getString(R.string.f170968bc0);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.forward)");
        this.title = string;
    }
}
