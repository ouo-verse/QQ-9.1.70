package com.tencent.qqnt.aio.mutualmark;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.report.AIONickIconDTReport;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u001b\u0010!\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/AIOTroopHonorNickBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", "D", "", BdhLogUtil.LogTag.Tag_Conn, "G", "", "troopUin", "uin", "", "Landroid/graphics/drawable/Drawable;", "drawableList", "E", "Lcom/tencent/qqnt/aio/mutualmark/TroopHonorView;", "B", "", "d", "i", "H", "Ljava/lang/String;", "msgId", "I", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "J", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/aio/mutualmark/TroopHonorView;", "mTroopHonorView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "K", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTroopHonorNickBlock extends LazyNickBlock {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String msgId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String senderUin;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTroopHonorView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/AIOTroopHonorNickBlock$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.mutualmark.AIOTroopHonorNickBlock$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOTroopHonorNickBlock(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
            return;
        }
        this.msgId = "";
        this.senderUin = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopHonorView>(context) { // from class: com.tencent.qqnt.aio.mutualmark.AIOTroopHonorNickBlock$mTroopHonorView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopHonorView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopHonorView(this.$context) : (TroopHonorView) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mTroopHonorView = lazy;
    }

    private final TroopHonorView A() {
        return (TroopHonorView) this.mTroopHonorView.getValue();
    }

    private final TroopHonorView B(List<? extends Drawable> drawableList) {
        TroopHonorView A = A();
        A.setHonorList(drawableList);
        A.setImportantForAccessibility(4);
        return A;
    }

    private final void C(AIOMsgItem msgItem) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOTroopHonorNickBlock", 4, "[handleMutualMaskChange]: mutualMaskInfo is " + msgItem.X() + ", peerUin is " + msgItem.getMsgRecord().peerUin + ", uin is " + msgItem.getMsgRecord().senderUin + " + msgId is " + msgItem.getMsgId());
        }
        G(msgItem);
    }

    private final boolean D(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.NICK_ICON_DATA) != null || map.get(AIOMsgItemPayloadType.MUTUAL_MASK_PAYLOAD) != null) {
                    C(msgItem);
                }
            }
        }
        return true;
    }

    private final void E(final String troopUin, final String uin, List<? extends Drawable> drawableList) {
        w(B(drawableList), new View.OnClickListener() { // from class: com.tencent.qqnt.aio.mutualmark.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTroopHonorNickBlock.F(AIOTroopHonorNickBlock.this, troopUin, uin, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(AIOTroopHonorNickBlock this$0, String troopUin, String uin, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        IAIONickIconServiceApi.a.a((IAIONickIconServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONickIconServiceApi.class), this$0.e(), troopUin, uin, null, 8, null);
        b f16 = this$0.f();
        if (f16 != null) {
            AIONickIconDTReport.f191405a.c(this$0.msgId, this$0.senderUin, String.valueOf(f16.a()), String.valueOf(f16.c()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G(AIOMsgItem msgItem) {
        boolean z16;
        Object first;
        ArrayList arrayList = new ArrayList();
        List<Drawable> W = msgItem.W();
        List<Drawable> list = W;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) W);
            arrayList.add(first);
        }
        if (!arrayList.isEmpty()) {
            E(String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), arrayList);
        } else {
            m();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void i(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (D(msgItem, payloads)) {
            return;
        }
        this.msgId = String.valueOf(msgItem.getMsgRecord().msgId);
        this.senderUin = String.valueOf(msgItem.getMsgRecord().senderUin);
        G(msgItem);
    }
}
