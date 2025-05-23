package com.tencent.mobileqq.vas.vipicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.report.AIONickIconDTReport;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.VasFeature;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconClick;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AIOVipIconProcessor;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Landroid/view/View$OnClickListener;", "", "", "payloads", "", "D", "", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "i", "Landroid/graphics/drawable/Drawable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "H", "Lkotlin/Lazy;", "B", "()Landroid/widget/ImageView;", "iconView", "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "I", "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "refreshFlag", "J", "Z", "isViewAdd", "", "K", "Ljava/lang/String;", "msgId", "L", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "M", "isStar", "N", "nameplateId", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class AIOVipIconProcessor extends LazyNickBlock implements View.OnClickListener {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy iconView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AIOMsgItemPayloadType refreshFlag;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isViewAdd;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String msgId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String senderUin;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isStar;

    /* renamed from: N, reason: from kotlin metadata */
    private int nameplateId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVipIconProcessor(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.vipicon.AIOVipIconProcessor$iconView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                String str;
                String str2;
                ImageView imageView = new ImageView(context);
                AIOVipIconProcessor aIOVipIconProcessor = this;
                IVipIconFactory iVipIconFactory = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
                Resources resources = imageView.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                str = aIOVipIconProcessor.senderUin;
                int iconWidth = iVipIconFactory.getIconWidth(resources, str);
                IVipIconFactory iVipIconFactory2 = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
                Resources resources2 = imageView.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                str2 = aIOVipIconProcessor.senderUin;
                imageView.setLayoutParams(new FrameLayout.LayoutParams(iconWidth, iVipIconFactory2.getIconHeight(resources2, str2)));
                imageView.setContentDescription("\u4f1a\u5458\u94ed\u724c");
                imageView.setOnClickListener(aIOVipIconProcessor);
                return imageView;
            }
        });
        this.iconView = lazy;
        this.refreshFlag = AIOMsgItemPayloadType.VIP_ICON_PAYLOAD;
        this.msgId = "";
        this.senderUin = "";
    }

    private final boolean D(List<Object> payloads) {
        Object obj;
        boolean z16;
        boolean z17;
        if (!payloads.isEmpty()) {
            Iterator<T> it = payloads.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    boolean z18 = obj instanceof HashMap;
                    if ((z18 && ((Map) obj).get(getRefreshFlag()) != null) || (z18 && ((Map) obj).get(AIOMsgItemPayloadType.NICK_ICON_DATA) != null)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public Drawable A(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return msgItem.D0();
    }

    @NotNull
    public ImageView B() {
        return (ImageView) this.iconView.getValue();
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public AIOMsgItemPayloadType getRefreshFlag() {
        return this.refreshFlag;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        return 3;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void i(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        VASPersonalNamePlate vASPersonalNamePlate;
        Integer num;
        int intValue;
        boolean z16;
        Integer num2;
        VASAIOPersonalElement vASAIOPersonalElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (VasFeature.INSTANCE.getVipIcon().isNotEnable() || !D(payloads)) {
            return;
        }
        Drawable A = A(msgItem);
        int i3 = 0;
        if (A == null) {
            if (this.isViewAdd) {
                VasLogNtReporter.INSTANCE.getAIODraw().reportDebug("[drawable null] msgId is " + msgItem.getMsgId() + " ");
                m();
                this.isViewAdd = false;
                return;
            }
            return;
        }
        B().setImageDrawable(A);
        this.msgId = String.valueOf(msgItem.getMsgRecord().msgId);
        this.senderUin = String.valueOf(msgItem.getMsgRecord().senderUin);
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo) != null) {
            vASPersonalNamePlate = vASAIOPersonalElement.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate = null;
        }
        if (vASPersonalNamePlate != null) {
            num = vASPersonalNamePlate.vipStarFlag;
        } else {
            num = null;
        }
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        if (intValue > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isStar = z16;
        if (vASPersonalNamePlate != null) {
            num2 = vASPersonalNamePlate.namePlateId;
        } else {
            num2 = null;
        }
        if (num2 != null) {
            i3 = num2.intValue();
        }
        this.nameplateId = i3;
        LazyNickBlock.x(this, B(), null, 2, null);
        this.isViewAdd = true;
    }

    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        ((IVipIconClick) QRoute.api(IVipIconClick.class)).onClick(v3, new IVipIconClick.Info(this.senderUin, 0, this.nameplateId, 0, this.isStar), "VIA_TROOP_AIO_MSG");
        com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b f16 = f();
        if (f16 != null) {
            AIONickIconDTReport.f191405a.c(this.msgId, this.senderUin, String.valueOf(f16.a()), String.valueOf(f16.c()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
