package com.tencent.mobileqq.guild.discoveryv2.content.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.discoveryv2.content.view.GradientImageView;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "url", "", "o", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "r", "imageUrl", "setImageUrl", "Landroid/graphics/Paint;", "paint", "", "height", "t", "Landroid/graphics/drawable/BitmapDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/BitmapDrawable;", "imgDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GradientImageView extends AppCompatImageView {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BitmapDrawable imgDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    private final void o(final String url) {
        final WeakReference weakReference = new WeakReference(this);
        post(new Runnable() { // from class: di1.a
            @Override // java.lang.Runnable
            public final void run() {
                GradientImageView.p(GradientImageView.this, url, weakReference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GradientImageView this$0, String url, final WeakReference weak) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(weak, "$weak");
        Option option = Option.obtain().setRequestWidth(0).setRequestHeight(0).setLifecycleOwner(ViewTreeLifecycleOwner.get(this$0)).setUrl(url);
        GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        guildFeedPicLoader.d(option, new IPicLoadStateListener() { // from class: di1.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                GradientImageView.q(weak, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WeakReference weak, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(weak, "$weak");
        GradientImageView gradientImageView = (GradientImageView) weak.get();
        if (gradientImageView != null) {
            gradientImageView.r(loadState, option);
        }
    }

    private final void r(LoadState state, Option option) {
        Bitmap bitmap;
        Bitmap.Config config;
        if (state == LoadState.STATE_SUCCESS) {
            if (option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                Bitmap resultBitMap = option.getResultBitMap();
                if (resultBitMap != null) {
                    config = resultBitMap.getConfig();
                } else {
                    config = null;
                }
                if (config != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), option.getResultBitMap());
                    this.imgDrawable = bitmapDrawable;
                    Bitmap bitmap2 = bitmapDrawable.getBitmap();
                    if (bitmap2 != null) {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        Paint paint = new Paint();
                        t(paint, height);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                        canvas.drawRect(0.0f, 0.0f, width, height, paint);
                        setImageBitmap(createBitmap);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setImageUrl(@Nullable String imageUrl) {
        boolean z16;
        boolean isBlank;
        setImageDrawable(b.f306350a);
        if (imageUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(imageUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.w("GradientImageView", 1, "setImageUrl, imageUrl is empty");
                    this.imgDrawable = null;
                    return;
                } else {
                    o(imageUrl);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public void t(@NotNull Paint paint, int height) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, Color.parseColor("#40FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP));
    }
}
