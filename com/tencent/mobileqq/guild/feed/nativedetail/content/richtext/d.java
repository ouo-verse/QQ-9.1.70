package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.guild.feed.GuildFeedForegroundColorSpan;
import com.tencent.mobileqq.guild.feed.a;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a<\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u001a#\u0010\u0010\u001a\u00020\u000f*\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001aQ\u0010\u0019\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00012\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u001c\u001a4\u0010&\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$\u001a=\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-\u001a\u001e\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b\u001a\f\u00103\u001a\u00020\u0006*\u00020\u0000H\u0000\u00a8\u00064"}, d2 = {"", "", "g", DomainData.DOMAIN_NAME, "previousChar", "Lkotlin/Function0;", "", "nextContentText", "", "nextContentType", "Lkotlin/Pair;", "e", "Landroid/text/SpannableStringBuilder;", "text", "color", "", "d", "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Ljava/lang/Integer;)V", "start", "disPlayText", "isUnderlineText", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/text/style/ClickableSpan;", NodeProps.ON_CLICK, "b", "(Landroid/text/SpannableStringBuilder;ILjava/lang/CharSequence;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function2;)V", "index", "Landroid/graphics/drawable/Drawable;", "drawable", "k", "l", "content", "length", "result", "highLightColor", "", "keywords", "f", "channelId", "channelType", "isSquare", "", "channelIconSize", h.F, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;IF)Landroid/graphics/drawable/Drawable;", "width", "height", "roundPx", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/d$a", "Lcom/tencent/mobileqq/guild/feed/a$a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/style/ClickableSpan;", TtmlNode.TAG_SPAN, "", "a", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements a.InterfaceC7734a {

        /* renamed from: a */
        final /* synthetic */ Function2<View, ClickableSpan, Unit> f221408a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super View, ? super ClickableSpan, Unit> function2) {
            this.f221408a = function2;
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public void a(@NotNull View r26, @NotNull ClickableSpan r36) {
            Intrinsics.checkNotNullParameter(r26, "widget");
            Intrinsics.checkNotNullParameter(r36, "span");
            this.f221408a.invoke(r26, r36);
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public boolean b(@NotNull View r26, @NotNull ClickableSpan r36) {
            Intrinsics.checkNotNullParameter(r26, "widget");
            Intrinsics.checkNotNullParameter(r36, "span");
            return false;
        }
    }

    public static final void b(@NotNull SpannableStringBuilder spannableStringBuilder, int i3, @NotNull CharSequence disPlayText, @Nullable Integer num, boolean z16, @NotNull Function2<? super View, ? super ClickableSpan, Unit> onClick) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(disPlayText, "disPlayText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        spannableStringBuilder.append(disPlayText);
        spannableStringBuilder.setSpan(new com.tencent.mobileqq.guild.feed.a(num, z16, new a(onClick)), i3, spannableStringBuilder.length(), 33);
    }

    public static /* synthetic */ void c(SpannableStringBuilder spannableStringBuilder, int i3, CharSequence charSequence, Integer num, boolean z16, Function2 function2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        b(spannableStringBuilder, i3, charSequence, num2, z16, function2);
    }

    public static final void d(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull String text, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) text);
        if (num != null) {
            spannableStringBuilder.setSpan(new GuildFeedForegroundColorSpan(num.intValue()), length, spannableStringBuilder.length(), 33);
        }
    }

    @NotNull
    public static final Pair<Boolean, Boolean> e(@Nullable CharSequence charSequence, @NotNull Function0<String> nextContentText, @NotNull Function0<Integer> nextContentType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(nextContentText, "nextContentText");
        Intrinsics.checkNotNullParameter(nextContentType, "nextContentType");
        boolean g16 = g(charSequence);
        Integer invoke = nextContentType.invoke();
        if (invoke != null && invoke.intValue() == 1) {
            z16 = n(nextContentText.invoke());
        } else {
            z16 = false;
        }
        return new Pair<>(Boolean.valueOf(g16), Boolean.valueOf(z16));
    }

    public static final void f(@NotNull String content, int i3, @NotNull SpannableStringBuilder result, int i16, @NotNull Collection<String> keywords) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        ArrayList<String> arrayList = new ArrayList();
        Iterator<T> it = keywords.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((String) next).length() <= 0) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        for (String str : arrayList) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) content, str, 0, true, 2, (Object) null);
            while (indexOf$default >= 0) {
                int length = str.length() + indexOf$default;
                result.setSpan(new ForegroundColorSpan(i16), indexOf$default + i3, i3 + length, 33);
                indexOf$default = StringsKt__StringsKt.indexOf((CharSequence) content, str, length, true);
            }
        }
    }

    public static final boolean g(@Nullable CharSequence charSequence) {
        boolean z16;
        char last;
        boolean isWhitespace;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            last = StringsKt___StringsKt.last(charSequence);
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(last);
            if (!isWhitespace) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Drawable h(@NotNull String channelId, @Nullable Integer num, @Nullable Boolean bool, int i3, float f16) {
        int d16;
        Drawable l3;
        boolean z16;
        Integer num2;
        int i16;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        int i17 = 512;
        if (num != null) {
            if (num.intValue() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                num2 = num;
            } else {
                num2 = null;
            }
            if (num2 != null) {
                int intValue = num2.intValue();
                QLog.i("RichTextExt", 1, "channelId:" + channelId + " isSquare:" + bool + " channelType:" + num);
                GuildChannelIconUtil guildChannelIconUtil = GuildChannelIconUtil.f235331a;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    i16 = 512;
                } else {
                    i16 = 16;
                }
                d16 = GuildChannelIconUtil.f(guildChannelIconUtil, channelId, i16, Integer.valueOf(intValue), null, null, 24, null);
                int dpToPx = ViewUtils.dpToPx(f16);
                l3 = l(ContextCompat.getDrawable(BaseApplication.getContext(), d16));
                if (l3 != null) {
                    return null;
                }
                l3.setBounds(0, 0, dpToPx, dpToPx);
                l3.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
                return l3;
            }
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            i17 = 16;
        }
        d16 = GuildChannelIconUtil.d(channelId, i17, null, 4, null);
        int dpToPx2 = ViewUtils.dpToPx(f16);
        l3 = l(ContextCompat.getDrawable(BaseApplication.getContext(), d16));
        if (l3 != null) {
        }
    }

    @NotNull
    public static final DownloadParams.DecodeHandler i(final int i3, final int i16, final int i17) {
        return new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.c
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap j3;
                j3 = d.j(i17, i3, i16, downloadParams, bitmap);
                return j3;
            }
        };
    }

    public static final Bitmap j(int i3, int i16, int i17, DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap != null) {
            return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, i16, i17);
        }
        return bitmap;
    }

    public static final void k(@NotNull SpannableStringBuilder spannableStringBuilder, int i3, @NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        spannableStringBuilder.setSpan(new u(drawable, 1), i3, i3 + 1, 33);
    }

    @Nullable
    public static final Drawable l(@Nullable Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    @NotNull
    public static final String m(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new Regex("\\s+\\n").replace(charSequence, "\n");
    }

    public static final boolean n(@Nullable CharSequence charSequence) {
        boolean z16;
        char first;
        boolean isWhitespace;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            first = StringsKt___StringsKt.first(charSequence);
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(first);
            if (!isWhitespace) {
                return false;
            }
        }
        return true;
    }
}
