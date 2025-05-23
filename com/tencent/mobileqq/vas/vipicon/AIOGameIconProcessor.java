package com.tencent.mobileqq.vas.vipicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AIOGameIconProcessor;", "Lcom/tencent/mobileqq/vas/vipicon/AIOVipIconProcessor;", "", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Landroid/graphics/drawable/Drawable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "P", "Lkotlin/Lazy;", "B", "()Landroid/widget/ImageView;", "iconView", "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "refreshFlag", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class AIOGameIconProcessor extends AIOVipIconProcessor {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy iconView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final AIOMsgItemPayloadType refreshFlag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOGameIconProcessor(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.vipicon.AIOGameIconProcessor$iconView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(context);
                IVipIconExFactory.Companion companion = IVipIconExFactory.INSTANCE;
                Resources resources = imageView.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                IVipIconFactory.Companion companion2 = IVipIconFactory.INSTANCE;
                int iconHeight = (int) companion2.getIconHeight(resources);
                Resources resources2 = imageView.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                imageView.setLayoutParams(new FrameLayout.LayoutParams(iconHeight, (int) companion2.getIconHeight(resources2)));
                return imageView;
            }
        });
        this.iconView = lazy;
        this.refreshFlag = AIOMsgItemPayloadType.GAME_ICON_PAYLOAD;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AIOVipIconProcessor
    @Nullable
    public Drawable A(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return msgItem.C0();
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AIOVipIconProcessor
    @NotNull
    public ImageView B() {
        return (ImageView) this.iconView.getValue();
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AIOVipIconProcessor
    @NotNull
    /* renamed from: C, reason: from getter */
    public AIOMsgItemPayloadType getRefreshFlag() {
        return this.refreshFlag;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AIOVipIconProcessor, com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        return 8;
    }
}
