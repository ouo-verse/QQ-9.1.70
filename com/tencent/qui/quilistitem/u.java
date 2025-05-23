package com.tencent.qui.quilistitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qui.quilistitem.Group;
import com.tencent.qui.quilistitem.u.b;
import com.tencent.qui.quilistitem.u.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\b\u0016\u0018\u0000 7*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00020\u00060\u0005:\u000389:B\u0017\u0012\u0006\u0010-\u001a\u00028\u0000\u0012\u0006\u00104\u001a\u00028\u0001\u00a2\u0006\u0004\b5\u00106J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014RT\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RT\u0010&\u001a4\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010-\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00028\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/qui/quilistitem/u;", "Lcom/tencent/qui/quilistitem/u$b;", "L", "Lcom/tencent/qui/quilistitem/u$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qui/quilistitem/t;", "Lcom/tencent/qui/quilistitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "v", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "w", "Lcom/tencent/qui/quilistitem/Group$b;", "outMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function2;", "Landroid/widget/ImageView;", "Lkotlin/ParameterName;", "name", "imageView", "", "url", "i", "Lkotlin/jvm/functions/Function2;", "t", "()Lkotlin/jvm/functions/Function2;", "setLoadImage", "(Lkotlin/jvm/functions/Function2;)V", "loadImage", "j", ReportConstant.COSTREPORT_PREFIX, "setLoadAvatar", "loadAvatar", "k", "Lcom/tencent/qui/quilistitem/u$b;", "r", "()Lcom/tencent/qui/quilistitem/u$b;", "setLeft", "(Lcom/tencent/qui/quilistitem/u$b;)V", "left", "l", "Lcom/tencent/qui/quilistitem/u$c;", "u", "()Lcom/tencent/qui/quilistitem/u$c;", "setRight", "(Lcom/tencent/qui/quilistitem/u$c;)V", "right", "<init>", "(Lcom/tencent/qui/quilistitem/u$b;Lcom/tencent/qui/quilistitem/u$c;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "c", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class u<L extends b, R extends c> extends t<QUISingleLineListItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super ImageView, ? super String, Unit> loadImage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super ImageView, ? super String, Unit> loadAvatar;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private L left;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private R right;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qui/quilistitem/u$a;", "", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quilistitem.u$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/u$b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/qui/quilistitem/u$b$d;", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/u$b$a;", "Lcom/tencent/qui/quilistitem/u$b$d;", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class a extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            @NotNull
            public final String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/u$b$b;", "Lcom/tencent/qui/quilistitem/u$b$d;", "", "b", "I", "()I", "setIconDrawableResId", "(I)V", "iconDrawableResId", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.u$b$b, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9720b extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private int iconDrawableResId;

            public final int b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
                }
                return this.iconDrawableResId;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/u$b$c;", "Lcom/tencent/qui/quilistitem/u$b$d;", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class c extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String url;

            @NotNull
            public final String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.url;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/u$b$d;", "Lcom/tencent/qui/quilistitem/u$b;", "", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static class d extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            @NotNull
            public final CharSequence a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.text;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0005\b\t\n\u000b\f\r\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c;", "", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "b", "c", "d", "e", "f", "g", tl.h.F, "Lcom/tencent/qui/quilistitem/u$c$g;", "Lcom/tencent/qui/quilistitem/u$c$b;", "Lcom/tencent/qui/quilistitem/u$c$f;", "Lcom/tencent/qui/quilistitem/u$c$h;", "Lcom/tencent/qui/quilistitem/u$c$e;", "Lcom/tencent/qui/quilistitem/u$c$c;", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static abstract class c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$a;", "Lcom/tencent/qui/quilistitem/u$c$g;", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class a extends g {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            @NotNull
            public final String e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$b;", "Lcom/tencent/qui/quilistitem/u$c;", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "setButtonText", "(Ljava/lang/CharSequence;)V", "buttonText", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "c", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "", "Z", "e", "()Z", "setShowCloseButton", "(Z)V", "showCloseButton", "d", "setCloseButtonClickListener", "closeButtonClickListener", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class b extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence buttonText;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private View.OnClickListener clickListener;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean showCloseButton;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private View.OnClickListener closeButtonClickListener;

            @NotNull
            public final CharSequence b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.buttonText;
            }

            @Nullable
            public final View.OnClickListener c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (View.OnClickListener) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.clickListener;
            }

            @Nullable
            public final View.OnClickListener d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (View.OnClickListener) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return this.closeButtonClickListener;
            }

            public final boolean e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                return this.showCloseButton;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$c;", "Lcom/tencent/qui/quilistitem/u$c;", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.u$c$c, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9721c extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C9721c f363883a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18112);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f363883a = new C9721c();
                }
            }

            C9721c() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$d;", "Lcom/tencent/qui/quilistitem/u$c$g;", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class d extends g {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String imageUrl;

            @NotNull
            public final String e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.imageUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$e;", "Lcom/tencent/qui/quilistitem/u$c;", "Lcom/tencent/mobileqq/quibadge/c;", "a", "Lcom/tencent/mobileqq/quibadge/c;", "b", "()Lcom/tencent/mobileqq/quibadge/c;", "setRichRedPointModel", "(Lcom/tencent/mobileqq/quibadge/c;)V", "richRedPointModel", "<init>", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class e extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private com.tencent.mobileqq.quibadge.c richRedPointModel;

            public e() {
                this(null, 1, 0 == true ? 1 : 0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                    return;
                }
                iPatchRedirector.redirect((short) 5, (Object) this);
            }

            @Nullable
            public final com.tencent.mobileqq.quibadge.c b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (com.tencent.mobileqq.quibadge.c) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.richRedPointModel;
            }

            public e(@Nullable com.tencent.mobileqq.quibadge.c cVar) {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    this.richRedPointModel = cVar;
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
                }
            }

            public /* synthetic */ e(com.tencent.mobileqq.quibadge.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : cVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, this, cVar, Integer.valueOf(i3), defaultConstructorMarker);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$f;", "Lcom/tencent/qui/quilistitem/u$c;", "", "a", "Z", "c", "()Z", "e", "(Z)V", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "b", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "listener", "d", "setEnabled", "isEnabled", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class f extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private boolean isChecked;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private CompoundButton.OnCheckedChangeListener listener;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean isEnabled;

            @Nullable
            public final CompoundButton.OnCheckedChangeListener b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (CompoundButton.OnCheckedChangeListener) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.listener;
            }

            public final boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
                }
                return this.isChecked;
            }

            public final boolean d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                return this.isEnabled;
            }

            public final void e(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                } else {
                    this.isChecked = z16;
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$g;", "Lcom/tencent/qui/quilistitem/u$c;", "", "a", "Ljava/lang/CharSequence;", "d", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "", "b", "Z", "()Z", "setShowArrow", "(Z)V", "showArrow", "c", "setShowRedPoint", "showRedPoint", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static class g extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean showArrow;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean showRedPoint;

            public final boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return this.showArrow;
            }

            public final boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                return this.showRedPoint;
            }

            @NotNull
            public final CharSequence d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.text;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qui/quilistitem/u$c$h;", "Lcom/tencent/qui/quilistitem/u$c;", "", "a", "Z", "c", "()Z", "d", "(Z)V", "isSelected", "Lcom/tencent/qui/quilistitem/i;", "b", "Lcom/tencent/qui/quilistitem/i;", "()Lcom/tencent/qui/quilistitem/i;", "setListener", "(Lcom/tencent/qui/quilistitem/i;)V", "listener", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class h extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private boolean isSelected;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private i listener;

            @Nullable
            public final i b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (i) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.listener;
            }

            public final boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
                }
                return this.isSelected;
            }

            public final void d(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                } else {
                    this.isSelected = z16;
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public final void a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18348);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public u(@NotNull L left, @NotNull R right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) left, (Object) right);
        } else {
            this.left = left;
            this.right = right;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qui.quilistitem.t
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void k(@NotNull QUISingleLineListItem view, @NotNull Group.b outMargin) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.f159500da4);
        int a16 = outMargin.a();
        L l3 = this.left;
        if (l3 instanceof b.a) {
            i16 = view.i().f().getLayoutParams().width;
        } else if (l3 instanceof b.C9720b) {
            i16 = view.i().h().getLayoutParams().width;
        } else if (l3 instanceof b.c) {
            i16 = view.i().i().getLayoutParams().width;
        } else {
            i3 = 0;
            outMargin.c(a16 + i3);
        }
        i3 = i16 + dimensionPixelSize;
        outMargin.c(a16 + i3);
    }

    @NotNull
    public final L r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (L) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.left;
    }

    @Nullable
    public final Function2<ImageView, String, Unit> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.loadAvatar;
    }

    @Nullable
    public final Function2<ImageView, String, Unit> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Function2) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.loadImage;
    }

    @NotNull
    public final R u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (R) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qui.quilistitem.t
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        view.setConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qui.quilistitem.t
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public QUISingleLineListItem o(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUISingleLineListItem) iPatchRedirector.redirect((short) 6, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null);
        qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return qUISingleLineListItem;
    }
}
