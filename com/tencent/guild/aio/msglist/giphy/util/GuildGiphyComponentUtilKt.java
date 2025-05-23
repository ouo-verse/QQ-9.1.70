package com.tencent.guild.aio.msglist.giphy.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.giphy.sdk.core.GPHCore;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.core.network.response.MediaResponse;
import com.giphy.sdk.ui.views.GPHMediaView;
import com.giphy.sdk.ui.views.GifView;
import com.tencent.guild.aio.msglist.giphy.GuildGiphyCacheManager;
import com.tencent.guild.aio.msglist.giphy.GuildGiphyRecyclerManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GiphyElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Landroid/content/Context;", "context", "Lcom/giphy/sdk/ui/views/GPHMediaView;", "b", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "ivPic", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GiphyElement;", "giphyElement", "", "c", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiphyComponentUtilKt {
    @NotNull
    public static final GPHMediaView a(@NotNull View parent, @NotNull MsgElement msgElement, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull GPHMediaView ivPic) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(ivPic, "ivPic");
        GiphyElement giphyElement = msgElement.giphyElement;
        int[] thumbSize = ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbSize(giphyElement.width, giphyElement.height, true);
        Intrinsics.checkNotNullExpressionValue(thumbSize, "getThumbSize(\n          \u2026           true\n        )");
        ivPic.setLayoutParams(new LinearLayout.LayoutParams(thumbSize[0], thumbSize[1]));
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildGiphyComponentUtil_applyAIOMsgGiphyView", null, null, null, new GuildGiphyComponentUtilKt$applyAIOMsgGiphyView$1$1(giphyElement, ivPic, null), 14, null);
        }
        return ivPic;
    }

    @NotNull
    public static final GPHMediaView b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GPHMediaView a16 = GuildGiphyRecyclerManager.f111293a.a().a();
        if (a16 == null) {
            a16 = new GPHMediaView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        a16.setAdjustViewBounds(true);
        a16.setCornerRadius(com.tencent.guild.aio.util.c.b(4));
        return a16;
    }

    public static final void c(@NotNull GiphyElement giphyElement, @NotNull final GPHMediaView ivPic) {
        Intrinsics.checkNotNullParameter(giphyElement, "giphyElement");
        Intrinsics.checkNotNullParameter(ivPic, "ivPic");
        GPHCore gPHCore = GPHCore.INSTANCE;
        String str = giphyElement.f359177id;
        Intrinsics.checkNotNullExpressionValue(str, "giphyElement.id");
        gPHCore.gifById(str, new Function2<MediaResponse, Throwable, Unit>() { // from class: com.tencent.guild.aio.msglist.giphy.util.GuildGiphyComponentUtilKt$fetchGifById$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(MediaResponse mediaResponse, Throwable th5) {
                invoke2(mediaResponse, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MediaResponse mediaResponse, @Nullable Throwable th5) {
                Media data;
                if (mediaResponse != null && (data = mediaResponse.getData()) != null) {
                    GifView.setMedia$default(ivPic, data, (RenditionType) null, (Drawable) null, 6, (Object) null);
                    GuildGiphyCacheManager.f111286a.b(data.getId(), data);
                }
                if (th5 != null) {
                    GPHMediaView gPHMediaView = ivPic;
                    if (QLog.isColorLevel()) {
                        QLog.e("GiphyContentComponent", 2, th5, new Object[0]);
                    }
                    gPHMediaView.setBackgroundResource(R.drawable.ogh);
                }
            }
        });
    }
}
