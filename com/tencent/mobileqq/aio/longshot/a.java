package com.tencent.mobileqq.aio.longshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import com.tencent.aio.data.AIOParam;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J$\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/a;", "Lcom/tencent/mobileqq/aio/longshot/b;", "Landroid/graphics/Bitmap;", "titleBar", "msgBitmap", "bottomBarBitmap", "o", "bottomBlurBitmap", "inputBarBitmap", "shortcutBarBitmap", "l", "", "width", "msgHeight", "watermarkBitmap", "k", "Landroid/graphics/Canvas;", "listCanvas", "height", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "j", "msgWidth", "a", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;)V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.longshot.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        super(context, aioContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aioContext);
        }
    }

    private final Bitmap k(int width, int msgHeight, Bitmap watermarkBitmap) {
        Bitmap c16 = c(width, msgHeight, Bitmap.Config.RGB_565);
        if (c16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(c16);
        m(canvas, width, msgHeight);
        n(canvas, watermarkBitmap, width, msgHeight);
        return c16;
    }

    private final Bitmap l(Bitmap bottomBlurBitmap, Bitmap inputBarBitmap, Bitmap shortcutBarBitmap) {
        int i3;
        if (inputBarBitmap == null) {
            return null;
        }
        int height = inputBarBitmap.getHeight();
        if (shortcutBarBitmap != null) {
            i3 = shortcutBarBitmap.getHeight();
        } else {
            i3 = 0;
        }
        int i16 = i3 + height;
        Bitmap createBitmap = Bitmap.createBitmap(inputBarBitmap.getWidth(), i16, inputBarBitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(inputBarBitmap, new Rect(0, 0, inputBarBitmap.getWidth(), inputBarBitmap.getHeight()), new Rect(0, 0, inputBarBitmap.getWidth(), inputBarBitmap.getHeight()), (Paint) null);
        if (shortcutBarBitmap != null) {
            canvas.drawBitmap(shortcutBarBitmap, new Rect(0, 0, shortcutBarBitmap.getWidth(), shortcutBarBitmap.getHeight()), new Rect(0, height, shortcutBarBitmap.getWidth(), shortcutBarBitmap.getHeight() + height), (Paint) null);
        }
        if (bottomBlurBitmap == null) {
            return createBitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bottomBlurBitmap.getWidth(), i16, bottomBlurBitmap.getConfig());
        Canvas canvas2 = new Canvas(createBitmap2);
        canvas2.drawBitmap(bottomBlurBitmap, new Rect(0, 0, bottomBlurBitmap.getWidth(), bottomBlurBitmap.getHeight()), new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), (Paint) null);
        if (createBitmap != null) {
            canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        }
        return createBitmap2;
    }

    private final void m(Canvas listCanvas, int width, int height) {
        View view = new View(f());
        IAIOChatBackgroundApi iAIOChatBackgroundApi = (IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class);
        String j3 = e().g().r().c().j();
        AIOParam g16 = e().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        Drawable currentChatBackgroundDrawable = iAIOChatBackgroundApi.getCurrentChatBackgroundDrawable(j3, su3.c.c(g16));
        int i3 = 0;
        if (currentChatBackgroundDrawable == null) {
            view.setBackgroundResource(R.drawable.qui_msg_list_bg);
            view.layout(0, 0, width, height);
            view.draw(listCanvas);
        } else {
            if (currentChatBackgroundDrawable.getIntrinsicWidth() > 0 && currentChatBackgroundDrawable.getIntrinsicHeight() > 0) {
                float intrinsicWidth = width / currentChatBackgroundDrawable.getIntrinsicWidth();
                Bitmap bitmap$default = DrawableKt.toBitmap$default(currentChatBackgroundDrawable, (int) (currentChatBackgroundDrawable.getIntrinsicWidth() * intrinsicWidth), (int) (intrinsicWidth * currentChatBackgroundDrawable.getIntrinsicHeight()), null, 4, null);
                bitmap$default.setDensity(listCanvas.getDensity());
                while (height > 0) {
                    listCanvas.drawBitmap(bitmap$default, 0.0f, i3 * bitmap$default.getHeight(), (Paint) null);
                    i3++;
                    height -= bitmap$default.getHeight();
                }
                return;
            }
            view.setBackgroundResource(R.drawable.qui_msg_list_bg);
            view.layout(0, 0, width, height);
            view.draw(listCanvas);
        }
    }

    private final void n(Canvas listCanvas, Bitmap watermarkBitmap, int width, int height) {
        if (watermarkBitmap != null && watermarkBitmap.getWidth() > 0 && watermarkBitmap.getHeight() > 0) {
            int i3 = 0;
            while (i3 < height) {
                listCanvas.drawBitmap(watermarkBitmap, new Rect(0, 0, watermarkBitmap.getWidth(), watermarkBitmap.getHeight()), new Rect(0, i3, width, watermarkBitmap.getHeight() + i3), (Paint) null);
                i3 += watermarkBitmap.getHeight();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Bitmap o(Bitmap titleBar, Bitmap msgBitmap, Bitmap bottomBarBitmap) {
        Canvas canvas = new Canvas(msgBitmap);
        if (titleBar != null) {
            titleBar.setDensity(canvas.getDensity());
            canvas.drawBitmap(titleBar, 0.0f, 0.0f, (Paint) null);
        }
        if (bottomBarBitmap != null) {
            bottomBarBitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bottomBarBitmap, 0.0f, msgBitmap.getHeight() - bottomBarBitmap.getHeight(), (Paint) null);
        }
        return msgBitmap;
    }

    @Override // com.tencent.mobileqq.aio.longshot.b
    @Nullable
    public Bitmap a(int msgWidth, int msgHeight) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(msgWidth), Integer.valueOf(msgHeight));
        }
        c g16 = g();
        if (g16 == null) {
            return null;
        }
        Bitmap f16 = g16.f();
        if (f16 != null) {
            i3 = f16.getHeight();
        } else {
            i3 = 0;
        }
        Bitmap l3 = l(g16.a(), g16.b(), g16.e());
        if (l3 != null) {
            i16 = l3.getHeight();
        }
        Bitmap k3 = k(msgWidth, msgHeight + i16 + i3, g16.g());
        if (k3 == null) {
            return null;
        }
        return o(f16, b(g16.c(), k3, i3), l3);
    }

    @Override // com.tencent.mobileqq.aio.longshot.b
    public void j(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
        } else {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            e().e().h(new AIOMsgListEvent.GetMsgListEvent(msgList));
        }
    }
}
