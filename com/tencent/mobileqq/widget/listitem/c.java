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
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.c.a;
import com.tencent.mobileqq.widget.listitem.c.b;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0002;<B\u0017\u0012\u0006\u0010\u001d\u001a\u00028\u0000\u0012\u0006\u0010$\u001a\u00028\u0001\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0014J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\"\u0010\u001d\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00028\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RT\u00101\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100RT\u00103\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b\u0002\u0010.\"\u0004\b\u0004\u00100RT\u00108\u001a4\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.\"\u0004\b7\u00100\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "L", "Lcom/tencent/mobileqq/widget/listitem/c$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/widget/listitem/QUIDoubleLineListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "P", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "J", "", BdhLogUtil.LogTag.Tag_Conn, "k", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "K", "()Lcom/tencent/mobileqq/widget/listitem/c$a;", "setLeft", "(Lcom/tencent/mobileqq/widget/listitem/c$a;)V", "left", "l", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "O", "()Lcom/tencent/mobileqq/widget/listitem/c$b;", "setRight", "(Lcom/tencent/mobileqq/widget/listitem/c$b;)V", "right", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "Lkotlin/ParameterName;", "name", "imageView", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "N", "()Lkotlin/jvm/functions/Function2;", ExifInterface.LATITUDE_SOUTH, "(Lkotlin/jvm/functions/Function2;)V", "loadImage", DomainData.DOMAIN_NAME, "loadAvatar", "drawableId", "o", "M", "setLoadIcon", "loadIcon", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/c$a;Lcom/tencent/mobileqq/widget/listitem/c$b;)V", "a", "b", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class c<L extends a, R extends b> extends w<QUIDoubleLineListItem> {

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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$a;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8992a extends g {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$b;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "c", "I", "e", "()I", "setIconDrawableResId", "(I)V", "iconDrawableResId", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "setIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "iconDrawable", "", "text", "description", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class b extends g {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private int iconDrawableResId;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private Drawable iconDrawable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull CharSequence text, @NotNull CharSequence description, @DrawableRes int i3) {
                super(text, description);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(description, "description");
                this.iconDrawableResId = i3;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final Drawable getIconDrawable() {
                return this.iconDrawable;
            }

            /* renamed from: e, reason: from getter */
            public final int getIconDrawableResId() {
                return this.iconDrawableResId;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl", "", "text", "description", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8993c extends g {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String imageUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8993c(@NotNull CharSequence text, @NotNull CharSequence description, @NotNull String imageUrl) {
                super(text, description);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                this.imageUrl = imageUrl;
            }

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getImageUrl() {
                return this.imageUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$d;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "", "text", "description", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class d extends g {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull CharSequence text, @NotNull CharSequence description, @NotNull String avatarUrl) {
                super(text, description);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
                this.avatarUrl = avatarUrl;
            }

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$e;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class e extends g {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String imageUrl;

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getImageUrl() {
                return this.imageUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$f;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "", "text", "description", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class f extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(@NotNull CharSequence text, @NotNull CharSequence description) {
                super(text, description);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(description, "description");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "c", "description", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static class g extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence description;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(@NotNull CharSequence text, @NotNull CharSequence description) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(description, "description");
                this.text = text;
                this.description = description;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final CharSequence getDescription() {
                return this.description;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final CharSequence getText() {
                return this.text;
            }

            public final void c(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.description = charSequence;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0005\u000b\f\rB\t\b\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u0082\u0001\u0004\u000e\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/mobileqq/widget/listitem/g;", "Lcom/tencent/mobileqq/widget/listitem/g;", "onBindViewListener", "<init>", "()V", "b", "c", "d", "Lcom/tencent/mobileqq/widget/listitem/c$b$a;", "Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "Lcom/tencent/mobileqq/widget/listitem/c$b$c;", "Lcom/tencent/mobileqq/widget/listitem/c$b$d;", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private g onBindViewListener;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u001b\u0010\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$b$a;", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "b", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "setButtonText", "(Ljava/lang/CharSequence;)V", "buttonText", "Landroid/view/View$OnClickListener;", "c", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "", "d", "Z", "f", "()Z", "setShowCloseButton", "(Z)V", "showCloseButton", "e", "setCloseButtonClickListener", "closeButtonClickListener", "g", "closeButtonDescription", "<init>", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;ZLandroid/view/View$OnClickListener;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends b {

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

            public /* synthetic */ a(CharSequence charSequence, View.OnClickListener onClickListener, boolean z16, View.OnClickListener onClickListener2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, onClickListener, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? null : onClickListener2);
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final CharSequence getButtonText() {
                return this.buttonText;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final View.OnClickListener getClickListener() {
                return this.clickListener;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final View.OnClickListener getCloseButtonClickListener() {
                return this.closeButtonClickListener;
            }

            @NotNull
            /* renamed from: e, reason: from getter */
            public final CharSequence getCloseButtonDescription() {
                return this.closeButtonDescription;
            }

            /* renamed from: f, reason: from getter */
            public final boolean getShowCloseButton() {
                return this.showCloseButton;
            }

            public final void g(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.closeButtonDescription = charSequence;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull CharSequence buttonText, @Nullable View.OnClickListener onClickListener, boolean z16, @Nullable View.OnClickListener onClickListener2) {
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
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$b$c;", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "b", "Ljava/lang/CharSequence;", "d", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "", "c", "Z", "()Z", "setShowArrow", "(Z)V", "showArrow", "e", "showRedPoint", "<init>", "(Ljava/lang/CharSequence;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8995c extends b {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean showArrow;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean showRedPoint;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8995c(@NotNull CharSequence text, boolean z16, boolean z17) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
                this.showArrow = z16;
                this.showRedPoint = z17;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getShowArrow() {
                return this.showArrow;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getShowRedPoint() {
                return this.showRedPoint;
            }

            @NotNull
            /* renamed from: d, reason: from getter */
            public final CharSequence getText() {
                return this.text;
            }

            public final void e(boolean z16) {
                this.showRedPoint = z16;
            }

            public /* synthetic */ C8995c(CharSequence charSequence, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? false : z17);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$b$d;", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "b", "Z", "c", "()Z", "e", "(Z)V", "isSelected", "Lcom/tencent/mobileqq/widget/listitem/h;", "Lcom/tencent/mobileqq/widget/listitem/h;", "()Lcom/tencent/mobileqq/widget/listitem/h;", "d", "(Lcom/tencent/mobileqq/widget/listitem/h;)V", "listener", "<init>", "(ZLcom/tencent/mobileqq/widget/listitem/h;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class d extends b {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isSelected;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private h listener;

            public d(boolean z16, @Nullable h hVar) {
                super(null);
                this.isSelected = z16;
                this.listener = hVar;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final h getListener() {
                return this.listener;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            public final void d(@Nullable h hVar) {
                this.listener = hVar;
            }

            public final void e(boolean z16) {
                this.isSelected = z16;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            g gVar = this.onBindViewListener;
            if (gVar != null) {
                gVar.M(view);
            }
        }

        b() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0013\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "b", "Z", "c", "()Z", "e", "(Z)V", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "f", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "listener", "d", "setEnabled", "isEnabled", "<init>", "(ZLandroid/widget/CompoundButton$OnCheckedChangeListener;Z)V", "(ZLandroid/widget/CompoundButton$OnCheckedChangeListener;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8994b extends b {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isChecked;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private CompoundButton.OnCheckedChangeListener listener;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean isEnabled;

            public C8994b(boolean z16, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener, boolean z17) {
                super(null);
                this.isChecked = z16;
                this.listener = onCheckedChangeListener;
                this.isEnabled = z17;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final CompoundButton.OnCheckedChangeListener getListener() {
                return this.listener;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }

            public final void e(boolean z16) {
                this.isChecked = z16;
            }

            public final void f(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
                this.listener = onCheckedChangeListener;
            }

            public C8994b(boolean z16, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
                this(z16, onCheckedChangeListener, true);
            }
        }
    }

    public c(@NotNull L left, @NotNull R right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.left = left;
        this.right = right;
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        L l3 = this.left;
        if (l3 instanceof a.g) {
            return ((a.g) l3).getText().toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull QUIDoubleLineListItem view, @NotNull Group.c outMargin) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int n3 = Utils.n(12.0f, view.getResources());
        int left = outMargin.getLeft();
        L l3 = this.left;
        if (l3 instanceof a.C8992a) {
            i16 = view.l().g().getLayoutParams().width;
        } else if (l3 instanceof a.d) {
            i16 = view.l().k().getLayoutParams().width;
        } else {
            if (l3 instanceof a.C8993c) {
                z16 = true;
            } else {
                z16 = l3 instanceof a.e;
            }
            if (z16) {
                i16 = view.l().j().getLayoutParams().width;
            } else if (l3 instanceof a.b) {
                i16 = view.l().i().getLayoutParams().width;
            } else {
                i3 = 0;
                outMargin.c(left + i3);
            }
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
    public void F(@NotNull QUIDoubleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.DoubleLineConfig<com.tencent.mobileqq.widget.listitem.DoubleLineConfig.Left, com.tencent.mobileqq.widget.listitem.DoubleLineConfig.Right>");
        view.setConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public QUIDoubleLineListItem H(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QUIDoubleLineListItem qUIDoubleLineListItem = new QUIDoubleLineListItem(context, null);
        qUIDoubleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return qUIDoubleLineListItem;
    }

    public final void R(@Nullable Function2<? super ImageView, ? super String, Unit> function2) {
        this.loadAvatar = function2;
    }

    public final void S(@Nullable Function2<? super ImageView, ? super String, Unit> function2) {
        this.loadImage = function2;
    }
}
