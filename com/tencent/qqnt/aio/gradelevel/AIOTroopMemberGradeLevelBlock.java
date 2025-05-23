package com.tencent.qqnt.aio.gradelevel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import com.tencent.qqnt.aio.refresher.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/gradelevel/AIOTroopMemberGradeLevelBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", BdhLogUtil.LogTag.Tag_Conn, "forceUpdate", "", "D", "", "memberUin", "Lcom/tencent/qqnt/aio/nick/gradelevel/a;", "gradeLevelInfo", "Landroid/view/View;", "B", "troopUin", "memeberUin", "info", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "d", "i", "k", "H", "Ljava/lang/String;", "mMemberUin", "I", "mTroopUin", "J", "Lcom/tencent/qqnt/aio/nick/gradelevel/a;", "mCurrentInfo", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "K", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTroopMemberGradeLevelBlock extends LazyNickBlock {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
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
    private com.tencent.qqnt.aio.nick.gradelevel.a mCurrentInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/gradelevel/AIOTroopMemberGradeLevelBlock$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.gradelevel.AIOTroopMemberGradeLevelBlock$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOTroopMemberGradeLevelBlock(@NotNull Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
        } else {
            this.mMemberUin = "";
            this.mTroopUin = "";
        }
    }

    private final boolean A(AIOMsgItem msgItem) {
        c p16 = msgItem.p();
        if (p16 == null || !p16.d() || !p16.c() || p16.a() != 1) {
            return false;
        }
        return true;
    }

    private final View B(String memberUin, com.tencent.qqnt.aio.nick.gradelevel.a gradeLevelInfo) {
        r rVar = new r(memberUin, gradeLevelInfo.e(), gradeLevelInfo.c(), gradeLevelInfo.d(), null, 16, null);
        o(new d.ah(rVar));
        Drawable a16 = rVar.a();
        if (a16 != null) {
            ImageView imageView = new ImageView(e());
            int dpToPx = ViewUtils.dpToPx(14.0f);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dpToPx, dpToPx));
            imageView.setImageDrawable(a16);
            return imageView;
        }
        return null;
    }

    private final boolean C(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.GRADE_LEVEL_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTroopMemberGradeLevelBlock", 4, "[handlePayload]: memeberUin is " + msgItem.getMsgRecord().senderUin + ", troopUin is " + msgItem.getMsgRecord().peerUin + ", gradeLevelInfo is " + msgItem.E() + ", msgId is " + msgItem.getMsgId());
                    }
                    E(this, msgItem, false, 2, null);
                } else if (map.get(AIOMsgItemPayloadType.APP_ICON_BIND_PAYLOAD) != null) {
                    D(msgItem, true);
                }
            }
        }
        return true;
    }

    private final void D(AIOMsgItem msgItem, boolean forceUpdate) {
        com.tencent.qqnt.aio.nick.gradelevel.a E = msgItem.E();
        if (!forceUpdate && !G(String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), E)) {
            return;
        }
        m();
        if (A(msgItem) && msgItem.E() != null) {
            String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
            com.tencent.qqnt.aio.nick.gradelevel.a E2 = msgItem.E();
            Intrinsics.checkNotNull(E2);
            View B = B(valueOf, E2);
            if (B != null) {
                w(B, new View.OnClickListener() { // from class: com.tencent.qqnt.aio.gradelevel.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AIOTroopMemberGradeLevelBlock.F(AIOTroopMemberGradeLevelBlock.this, view);
                    }
                });
            }
        }
    }

    static /* synthetic */ void E(AIOTroopMemberGradeLevelBlock aIOTroopMemberGradeLevelBlock, AIOMsgItem aIOMsgItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aIOTroopMemberGradeLevelBlock.D(aIOMsgItem, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(AIOTroopMemberGradeLevelBlock this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAIONickIconServiceApi.a.a((IAIONickIconServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONickIconServiceApi.class), this$0.e(), this$0.mTroopUin, this$0.mMemberUin, null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean G(String troopUin, String memeberUin, com.tencent.qqnt.aio.nick.gradelevel.a info) {
        if (Intrinsics.areEqual(troopUin, this.mTroopUin) && Intrinsics.areEqual(memeberUin, this.mMemberUin) && Intrinsics.areEqual(info, this.mCurrentInfo)) {
            return false;
        }
        this.mTroopUin = troopUin;
        this.mMemberUin = memeberUin;
        this.mCurrentInfo = info;
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
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
        if (C(msgItem, payloads)) {
            return;
        }
        E(this, msgItem, false, 2, null);
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
}
