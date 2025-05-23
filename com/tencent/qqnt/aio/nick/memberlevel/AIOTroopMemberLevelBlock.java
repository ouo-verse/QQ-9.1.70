package com.tencent.qqnt.aio.nick.memberlevel;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.a;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.nick.e;
import com.tencent.qqnt.aio.nick.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0016H\u0016R\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/nick/memberlevel/AIOTroopMemberLevelBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/nick/f;", "info", "Lcom/tencent/qqnt/aio/nick/e;", "drawableInfo", "", "isMosaic", BdhLogUtil.LogTag.Tag_Conn, "", "", "payloads", "B", "G", "", "troopUin", "memeberUin", "E", "", "d", "i", "k", "r", "importance", "p", "H", "Ljava/lang/String;", "mMemberUin", "I", "mTroopUin", "J", "Lcom/tencent/qqnt/aio/nick/f;", "mCurrentInfo", "K", "Z", "mMosaic", "Landroid/view/View;", "L", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroid/view/View;", "mMemberLevelView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "M", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTroopMemberLevelBlock extends LazyNickBlock {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mMemberUin;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String mTroopUin;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private f mCurrentInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mMosaic;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberLevelView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/nick/memberlevel/AIOTroopMemberLevelBlock$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.nick.memberlevel.AIOTroopMemberLevelBlock$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOTroopMemberLevelBlock(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
            return;
        }
        this.mMemberUin = "";
        this.mTroopUin = "";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TroopMemberLevelView2>(context) { // from class: com.tencent.qqnt.aio.nick.memberlevel.AIOTroopMemberLevelBlock$mMemberLevelView$2
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
            public final TroopMemberLevelView2 invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopMemberLevelView2(this.$context) : (TroopMemberLevelView2) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mMemberLevelView = lazy;
    }

    private final View A() {
        return (View) this.mMemberLevelView.getValue();
    }

    private final boolean B(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.MEMBER_LEVEL_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTroopMemberLevelBlock", 4, "[handlePayload]: troopUin is " + msgItem.getMsgRecord().peerUin + ", memberUin is " + msgItem.getMsgRecord().senderUin + ", memberLevelInfo is " + msgItem.M() + ", msgId is " + msgItem.getMsgId());
                    }
                    F(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.SHOT_MOSAIC) != null) {
                    G(msgItem);
                }
            }
        }
        return true;
    }

    private final void C(f info, e drawableInfo, boolean isMosaic) {
        b bVar;
        KeyEvent.Callback A = A();
        if (A instanceof b) {
            bVar = (b) A;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.setTroopMemberLevel(info, drawableInfo);
            bVar.setMosaic(isMosaic);
        }
        w(A(), new View.OnClickListener() { // from class: com.tencent.qqnt.aio.nick.memberlevel.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTroopMemberLevelBlock.D(AIOTroopMemberLevelBlock.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AIOTroopMemberLevelBlock this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.mTroopUin;
        String str2 = this$0.mMemberUin;
        f fVar = this$0.mCurrentInfo;
        boolean z17 = true;
        if (fVar != null) {
            z16 = fVar.l();
        } else {
            z16 = true;
        }
        f fVar2 = this$0.mCurrentInfo;
        if (fVar2 != null) {
            z17 = fVar2.m();
        }
        this$0.o(new a.d(str, str2, z16, z17));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean E(String troopUin, String memeberUin, f info) {
        if (troopUin.equals(this.mTroopUin) && memeberUin.equals(this.mMemberUin) && info != null && info.a(this.mCurrentInfo)) {
            return false;
        }
        this.mTroopUin = troopUin;
        this.mMemberUin = memeberUin;
        this.mCurrentInfo = info;
        return true;
    }

    private final void F(AIOMsgItem msgItem) {
        f M = msgItem.M();
        if (QLog.isColorLevel()) {
            QLog.i("AIOTroopMemberLevelBlock", 1, "[updateMemberLevelView] memberLevelInfo = " + M + " d = " + msgItem + ".memberLevelDrawableInfo");
        }
        if (!E(String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), M)) {
            if (this.mMosaic != msgItem.L0()) {
                this.mMosaic = msgItem.L0();
                G(msgItem);
                return;
            }
            return;
        }
        e L = msgItem.L();
        if (M != null && L != null) {
            String str = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            M.o(str);
            String str2 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
            M.n(str2);
            C(M, L, msgItem.L0());
            return;
        }
        m();
    }

    private final void G(AIOMsgItem msgItem) {
        b bVar;
        if (u()) {
            KeyEvent.Callback A = A();
            if (A instanceof b) {
                bVar = (b) A;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.setMosaic(msgItem.L0());
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 5;
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
        if (B(msgItem, payloads)) {
            return;
        }
        F(msgItem);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.k();
        this.mTroopUin = "";
        this.mMemberUin = "";
        this.mCurrentInfo = null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void p(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, importance);
        } else if (u()) {
            A().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
