package com.tencent.mobileqq.aio.msglist.holder.component.nick.robot;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/robot/NickNameRobotBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "B", "", "memberUin", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "d", "", "", "payloads", "i", "r", "H", "Ljava/lang/String;", "Landroid/widget/ImageView;", "I", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/ImageView;", "robotMarkView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NickNameRobotBlock extends LazyNickBlock {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String memberUin;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy robotMarkView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickNameRobotBlock(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.memberUin = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.robot.NickNameRobotBlock$robotMarkView$2
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
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f));
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                return imageView;
            }
        });
        this.robotMarkView = lazy;
    }

    private final boolean A(String memberUin) {
        if (Intrinsics.areEqual(memberUin, this.memberUin)) {
            return false;
        }
        this.memberUin = memberUin;
        return true;
    }

    private final void B(AIOMsgItem msgItem) {
        if (!A(String.valueOf(msgItem.getMsgRecord().senderUin))) {
            return;
        }
        int robotDrawableId = ((IAIOAnonymousApi) a.INSTANCE.a(IAIOAnonymousApi.class)).getRobotDrawableId(this.memberUin);
        if (robotDrawableId == 0) {
            m();
            return;
        }
        ImageView z16 = z();
        z16.setImageResource(robotDrawableId);
        LazyNickBlock.x(this, z16, null, 2, null);
    }

    private final ImageView z() {
        return (ImageView) this.robotMarkView.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void i(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            return;
        }
        B(msgItem);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public boolean r() {
        return true;
    }
}
