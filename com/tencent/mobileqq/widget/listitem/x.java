package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u0000 ;*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0003<=>B\u0017\u0012\u0006\u0010\u001d\u001a\u00028\u0000\u0012\u0006\u0010$\u001a\u00028\u0001\u00a2\u0006\u0004\b9\u0010:J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0014R\"\u0010\u001d\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00028\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RT\u00101\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100RT\u00103\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b\u0002\u0010.\"\u0004\b\u0004\u00100RT\u00108\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.\"\u0004\b7\u00100\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "J", "k", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "K", "()Lcom/tencent/mobileqq/widget/listitem/x$b;", "setLeft", "(Lcom/tencent/mobileqq/widget/listitem/x$b;)V", "left", "l", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "O", "()Lcom/tencent/mobileqq/widget/listitem/x$c;", "U", "(Lcom/tencent/mobileqq/widget/listitem/x$c;)V", "right", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "Lkotlin/ParameterName;", "name", "imageView", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "N", "()Lkotlin/jvm/functions/Function2;", "T", "(Lkotlin/jvm/functions/Function2;)V", "loadImage", DomainData.DOMAIN_NAME, "loadAvatar", "drawableId", "o", "M", ExifInterface.LATITUDE_SOUTH, "loadIcon", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c;)V", "p", "a", "b", "c", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class x<L extends b, R extends c> extends w<QUISingleLineListItem> {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private L left;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private R right;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super ImageView, ? super String, Unit> loadImage;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super ImageView, ? super String, Unit> loadAvatar;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super ImageView, ? super Integer, Unit> loadIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0007J(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$a;", "", "", "left", "right", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "a", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "c", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.widget.listitem.x$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ x b(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                charSequence2 = "";
            }
            return companion.a(charSequence, charSequence2);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final x<b.d, c.g> a(@NotNull CharSequence left, @NotNull CharSequence right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return new x<>(new b.d(left), new c.g(right, false, false, 6, null));
        }

        @JvmStatic
        @NotNull
        public final x<b.d, c.f> c(@NotNull CharSequence left, @Nullable CompoundButton.OnCheckedChangeListener listener) {
            Intrinsics.checkNotNullParameter(left, "left");
            return new x<>(new b.d(left), new c.f(false, listener));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$b$a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "", "text", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/String;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends d {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull CharSequence text, @NotNull String avatarUrl) {
                super(text);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
                this.avatarUrl = avatarUrl;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "", "b", "I", "d", "()I", "setIconDrawableResId", "(I)V", "iconDrawableResId", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "e", "(Landroid/graphics/drawable/Drawable;)V", "iconDrawable", "", "text", "<init>", "(Ljava/lang/CharSequence;I)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.x$b$b, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8996b extends d {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private int iconDrawableResId;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private Drawable iconDrawable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8996b(@NotNull CharSequence text, @DrawableRes int i3) {
                super(text);
                Intrinsics.checkNotNullParameter(text, "text");
                this.iconDrawableResId = i3;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final Drawable getIconDrawable() {
                return this.iconDrawable;
            }

            /* renamed from: d, reason: from getter */
            public final int getIconDrawableResId() {
                return this.iconDrawableResId;
            }

            public final void e(@Nullable Drawable drawable) {
                this.iconDrawable = drawable;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$b$c;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "", "text", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/String;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class c extends d {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull CharSequence text, @NotNull String url) {
                super(text);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getUrl() {
                return this.url;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "b", "(Ljava/lang/CharSequence;)V", "text", "<init>", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static class d extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull CharSequence text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final CharSequence getText() {
                return this.text;
            }

            public final void b(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.text = charSequence;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\b\u0004\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0001\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "Lcom/tencent/mobileqq/widget/listitem/g;", "listener", "b", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/mobileqq/widget/listitem/g;", "onBindViewListener", "<init>", "()V", "c", "d", "e", "f", "g", tl.h.F, "i", "Lcom/tencent/mobileqq/widget/listitem/x$c$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$c;", "Lcom/tencent/mobileqq/widget/listitem/x$c$e;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lcom/tencent/mobileqq/widget/listitem/x$c$h;", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.widget.listitem.g onBindViewListener;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$a;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "e", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "", "text", "", "showArrow", "showRedPoint", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/String;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends g {

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            public /* synthetic */ a(CharSequence charSequence, String str, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, str, (i3 & 4) != 0 ? true : z16, (i3 & 8) != 0 ? false : z17);
            }

            @NotNull
            /* renamed from: i, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }

            public final void j(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.avatarUrl = str;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull CharSequence text, @NotNull String avatarUrl, boolean z16, boolean z17) {
                super(text, z16, z17);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
                this.avatarUrl = avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "b", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "setButtonText", "(Ljava/lang/CharSequence;)V", "buttonText", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "d", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "", "Z", "g", "()Z", "setShowCloseButton", "(Z)V", "showCloseButton", "e", "setCloseButtonClickListener", "closeButtonClickListener", "f", "setCloseButtonDescription", "closeButtonDescription", "<init>", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;ZLandroid/view/View$OnClickListener;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class b extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence buttonText;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private View.OnClickListener clickListener;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean showCloseButton;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private View.OnClickListener closeButtonClickListener;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence closeButtonDescription;

            public /* synthetic */ b(CharSequence charSequence, View.OnClickListener onClickListener, boolean z16, View.OnClickListener onClickListener2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, (i3 & 2) != 0 ? null : onClickListener, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? null : onClickListener2);
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final CharSequence getButtonText() {
                return this.buttonText;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final View.OnClickListener getClickListener() {
                return this.clickListener;
            }

            @Nullable
            /* renamed from: e, reason: from getter */
            public final View.OnClickListener getCloseButtonClickListener() {
                return this.closeButtonClickListener;
            }

            @NotNull
            /* renamed from: f, reason: from getter */
            public final CharSequence getCloseButtonDescription() {
                return this.closeButtonDescription;
            }

            /* renamed from: g, reason: from getter */
            public final boolean getShowCloseButton() {
                return this.showCloseButton;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull CharSequence buttonText, @Nullable View.OnClickListener onClickListener, boolean z16, @Nullable View.OnClickListener onClickListener2) {
                super(null);
                Intrinsics.checkNotNullParameter(buttonText, "buttonText");
                this.buttonText = buttonText;
                this.clickListener = onClickListener;
                this.showCloseButton = z16;
                this.closeButtonClickListener = onClickListener2;
                this.closeButtonDescription = "\u5173\u95ed";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$c;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.x$c$c, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8997c extends c {

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            public static final C8997c f317072b = new C8997c();

            C8997c() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "e", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "imageUrl", "", "text", "", "showArrow", "showRedPoint", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/String;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class d extends g {

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String imageUrl;

            public /* synthetic */ d(CharSequence charSequence, String str, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, str, (i3 & 4) != 0 ? true : z16, (i3 & 8) != 0 ? false : z17);
            }

            @NotNull
            /* renamed from: i, reason: from getter */
            public final String getImageUrl() {
                return this.imageUrl;
            }

            public final void j(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.imageUrl = str;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull CharSequence text, @NotNull String imageUrl, boolean z16, boolean z17) {
                super(text, z16, z17);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                this.imageUrl = imageUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$e;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "Lcom/tencent/mobileqq/quibadge/c;", "b", "Lcom/tencent/mobileqq/quibadge/c;", "c", "()Lcom/tencent/mobileqq/quibadge/c;", "setRichRedPointModel", "(Lcom/tencent/mobileqq/quibadge/c;)V", "richRedPointModel", "<init>", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class e extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private com.tencent.mobileqq.quibadge.c richRedPointModel;

            public e() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final com.tencent.mobileqq.quibadge.c getRichRedPointModel() {
                return this.richRedPointModel;
            }

            public e(@Nullable com.tencent.mobileqq.quibadge.c cVar) {
                super(null);
                this.richRedPointModel = cVar;
            }

            public /* synthetic */ e(com.tencent.mobileqq.quibadge.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : cVar);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "b", "Ljava/lang/CharSequence;", "e", "()Ljava/lang/CharSequence;", tl.h.F, "(Ljava/lang/CharSequence;)V", "text", "", "c", "Z", "()Z", "f", "(Z)V", "showArrow", "d", "g", "showRedPoint", "<init>", "(Ljava/lang/CharSequence;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static class g extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean showArrow;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean showRedPoint;

            public /* synthetic */ g(CharSequence charSequence, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? false : z17);
            }

            /* renamed from: c, reason: from getter */
            public final boolean getShowArrow() {
                return this.showArrow;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getShowRedPoint() {
                return this.showRedPoint;
            }

            @NotNull
            /* renamed from: e, reason: from getter */
            public final CharSequence getText() {
                return this.text;
            }

            public final void f(boolean z16) {
                this.showArrow = z16;
            }

            public final void g(boolean z16) {
                this.showRedPoint = z16;
            }

            public final void h(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.text = charSequence;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(@NotNull CharSequence text, boolean z16, boolean z17) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
                this.showArrow = z16;
                this.showRedPoint = z17;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$h;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setRedPath", "(Ljava/lang/String;)V", "redPath", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class h extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String redPath;

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getRedPath() {
                return this.redPath;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$i;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "b", "Z", "d", "()Z", "f", "(Z)V", "isSelected", "Lcom/tencent/mobileqq/widget/listitem/h;", "c", "Lcom/tencent/mobileqq/widget/listitem/h;", "()Lcom/tencent/mobileqq/widget/listitem/h;", "e", "(Lcom/tencent/mobileqq/widget/listitem/h;)V", "listener", "<init>", "(ZLcom/tencent/mobileqq/widget/listitem/h;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class i extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isSelected;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private com.tencent.mobileqq.widget.listitem.h listener;

            public i(boolean z16, @Nullable com.tencent.mobileqq.widget.listitem.h hVar) {
                super(null);
                this.isSelected = z16;
                this.listener = hVar;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final com.tencent.mobileqq.widget.listitem.h getListener() {
                return this.listener;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            public final void e(@Nullable com.tencent.mobileqq.widget.listitem.h hVar) {
                this.listener = hVar;
            }

            public final void f(boolean z16) {
                this.isSelected = z16;
            }

            public /* synthetic */ i(boolean z16, com.tencent.mobileqq.widget.listitem.h hVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z16, (i3 & 2) != 0 ? null : hVar);
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            com.tencent.mobileqq.widget.listitem.g gVar = this.onBindViewListener;
            if (gVar != null) {
                gVar.M(view);
            }
        }

        @NotNull
        public final c b(@Nullable com.tencent.mobileqq.widget.listitem.g listener) {
            this.onBindViewListener = listener;
            return this;
        }

        c() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0014\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "b", "Z", "d", "()Z", "f", "(Z)V", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "c", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", tl.h.F, "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "listener", "e", "g", "isEnabled", "<init>", "(ZLandroid/widget/CompoundButton$OnCheckedChangeListener;Z)V", "(ZLandroid/widget/CompoundButton$OnCheckedChangeListener;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class f extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isChecked;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private CompoundButton.OnCheckedChangeListener listener;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean isEnabled;

            public f(boolean z16, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener, boolean z17) {
                super(null);
                this.isChecked = z16;
                this.listener = onCheckedChangeListener;
                this.isEnabled = z17;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final CompoundButton.OnCheckedChangeListener getListener() {
                return this.listener;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            /* renamed from: e, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }

            public final void f(boolean z16) {
                this.isChecked = z16;
            }

            public final void g(boolean z16) {
                this.isEnabled = z16;
            }

            public final void h(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
                this.listener = onCheckedChangeListener;
            }

            public /* synthetic */ f(boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z16, (i3 & 2) != 0 ? null : onCheckedChangeListener);
            }

            public f(boolean z16, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
                this(z16, onCheckedChangeListener, true);
            }
        }
    }

    public x(@NotNull L left, @NotNull R right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.left = left;
        this.right = right;
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        L l3 = this.left;
        if (l3 instanceof b.d) {
            return ((b.d) l3).getText().toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull QUISingleLineListItem view, @NotNull Group.c outMargin) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int n3 = Utils.n(12.0f, view.getResources());
        int left = outMargin.getLeft();
        L l3 = this.left;
        if (l3 instanceof b.a) {
            i16 = view.l().g().getLayoutParams().width;
        } else if (l3 instanceof b.C8996b) {
            i16 = view.l().i().getLayoutParams().width;
        } else if (l3 instanceof b.c) {
            i16 = view.l().j().getLayoutParams().width;
        } else {
            i3 = 0;
            outMargin.c(left + i3);
        }
        i3 = i16 + n3;
        outMargin.c(left + i3);
    }

    @NotNull
    public final L K() {
        return this.left;
    }

    @Nullable
    public final Function2<ImageView, String, Unit> L() {
        return this.loadAvatar;
    }

    @Nullable
    public final Function2<ImageView, Integer, Unit> M() {
        return this.loadIcon;
    }

    @Nullable
    public final Function2<ImageView, String, Unit> N() {
        return this.loadImage;
    }

    @NotNull
    public final R O() {
        return this.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<com.tencent.mobileqq.widget.listitem.SingleLineConfig.Left, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right>");
        view.setConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public QUISingleLineListItem H(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null);
        qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return qUISingleLineListItem;
    }

    public final void R(@Nullable Function2<? super ImageView, ? super String, Unit> function2) {
        this.loadAvatar = function2;
    }

    public final void S(@Nullable Function2<? super ImageView, ? super Integer, Unit> function2) {
        this.loadIcon = function2;
    }

    public final void T(@Nullable Function2<? super ImageView, ? super String, Unit> function2) {
        this.loadImage = function2;
    }

    public final void U(@NotNull R r16) {
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.right = r16;
    }
}
