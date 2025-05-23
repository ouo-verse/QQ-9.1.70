package com.tencent.mobileqq.vas.aio;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0018\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u001e\u001a\u00020\u001bH&J \u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H&J \u0010(\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010'\u001a\u00020&H&J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/a;", "", "", "friendUin", "Lcom/tencent/mobileqq/vas/aio/c;", "data", "", "o", "(Ljava/lang/Long;Lcom/tencent/mobileqq/vas/aio/c;)V", "", "type", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "uin", "themeStyle", "Lcom/tencent/mobileqq/vas/aio/f;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Ljava/lang/Runnable;", "runnable", tl.h.F, "b", "p", "hasShowStatus", "d", "", "l", "r", "a", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "", "url", "Lcom/tencent/image/GifDrawable$OnGIFPlayOnceListener;", "gifLisenter", "j", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apngListener", "k", "getDrawable", DomainData.DOMAIN_NAME, "e", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface a {
    boolean a();

    void b();

    int c(long friendUin);

    void d(int hasShowStatus);

    boolean e(long friendUin);

    @Nullable
    VasZplanAIOData f();

    @Nullable
    VasZplanAvatarIcon g(long uin, int themeStyle);

    @NotNull
    Drawable getDrawable(@NotNull String url);

    void h(@NotNull Runnable runnable);

    void i(int type);

    @NotNull
    Drawable j(@NotNull Drawable loadingDrawable, @NotNull String url, @NotNull GifDrawable.OnGIFPlayOnceListener gifLisenter);

    @NotNull
    Drawable k(@NotNull Drawable loadingDrawable, @NotNull String url, @NotNull ApngDrawable.OnPlayRepeatListener apngListener);

    boolean l(long friendUin);

    @NotNull
    VasZplanAIOData m();

    boolean n(long friendUin);

    void o(@Nullable Long friendUin, @NotNull VasZplanAIOData data);

    int p();

    void q();

    boolean r(long friendUin);
}
