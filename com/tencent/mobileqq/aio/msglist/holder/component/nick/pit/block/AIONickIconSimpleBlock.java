package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.block;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.report.AIONickIconDTReport;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/block/AIONickIconSimpleBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", BdhLogUtil.LogTag.Tag_Conn, "", "", "payloads", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "d", "i", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "H", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "iconData", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "iconImageView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;Landroid/content/Context;Landroid/widget/LinearLayout;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONickIconSimpleBlock extends LazyNickBlock {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private b iconData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView iconImageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/block/AIONickIconSimpleBlock$a;", "", "", "DEFAULT_ICON_WIDTH", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.block.AIONickIconSimpleBlock$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIONickIconSimpleBlock(@NotNull b iconData, @NotNull Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Intrinsics.checkNotNullParameter(iconData, "iconData");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iconData, context, rootView);
            return;
        }
        this.iconData = iconData;
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f)));
        this.iconImageView = imageView;
    }

    private final boolean A(AIOMsgItem msgItem) {
        b f16 = f();
        if (f16 == null) {
            f16 = this.iconData;
        }
        if (f16.a() != 6) {
            return true;
        }
        c p16 = msgItem.p();
        if (p16 == null) {
            return false;
        }
        if (p16.d() && p16.c() && p16.a() == 2) {
            return true;
        }
        return false;
    }

    private final boolean B(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.NICK_ICON_DATA) != null || map.get(AIOMsgItemPayloadType.APP_ICON_BIND_PAYLOAD) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIONickIconSimpleBlock", 2, "[handlePayload] NICK_ICON_DATA");
                    }
                    C(msgItem);
                }
            }
        }
        return true;
    }

    private final void C(final AIOMsgItem msgItem) {
        boolean z16;
        if (!A(msgItem)) {
            m();
            return;
        }
        final b f16 = f();
        if (f16 == null) {
            f16 = this.iconData;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.config.b d16 = com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.config.a.f191394a.d(f16.a(), f16.c());
        String a16 = d16.a();
        boolean z17 = false;
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String c16 = d16.c();
            if (c16 == null || c16.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                this.iconImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.block.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AIONickIconSimpleBlock.D(AIOMsgItem.this, f16, view);
                    }
                });
            }
            a.C1005a l3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.utils.a.f191403a);
            String a17 = d16.a();
            if (a17 == null) {
                a17 = "";
            }
            this.iconImageView.setImageDrawable(l3.k(a17).a());
            LazyNickBlock.x(this, this.iconImageView, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AIOMsgItem msgItem, b iconData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(iconData, "$iconData");
        AIONickIconDTReport.f191405a.c(String.valueOf(msgItem.getMsgRecord().msgId), String.valueOf(msgItem.getMsgRecord().senderUin), String.valueOf(iconData.a()), String.valueOf(iconData.c()));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.iconData.a();
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
        C(msgItem);
    }
}
