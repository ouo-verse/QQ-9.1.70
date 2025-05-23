package com.tencent.qui.quilistitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qui.quilistitem.Group;
import com.tencent.qui.quilistitem.c.a;
import com.tencent.qui.quilistitem.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00020\u00060\u0005:\u000278B\u0017\u0012\u0006\u0010-\u001a\u00028\u0000\u0012\u0006\u00104\u001a\u00028\u0001\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0014J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014RT\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RT\u0010&\u001a4\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010-\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00028\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/qui/quilistitem/c;", "Lcom/tencent/qui/quilistitem/c$a;", "L", "Lcom/tencent/qui/quilistitem/c$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qui/quilistitem/t;", "Lcom/tencent/qui/quilistitem/QUIDoubleLineListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "w", "view", "", "position", "", "", "payloads", "", "v", "Lcom/tencent/qui/quilistitem/Group$b;", "outMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function2;", "Landroid/widget/ImageView;", "Lkotlin/ParameterName;", "name", "imageView", "", "url", "i", "Lkotlin/jvm/functions/Function2;", "t", "()Lkotlin/jvm/functions/Function2;", "setLoadImage", "(Lkotlin/jvm/functions/Function2;)V", "loadImage", "j", ReportConstant.COSTREPORT_PREFIX, "setLoadAvatar", "loadAvatar", "k", "Lcom/tencent/qui/quilistitem/c$a;", "r", "()Lcom/tencent/qui/quilistitem/c$a;", HippyTKDListViewAdapter.X, "(Lcom/tencent/qui/quilistitem/c$a;)V", "left", "l", "Lcom/tencent/qui/quilistitem/c$b;", "u", "()Lcom/tencent/qui/quilistitem/c$b;", "y", "(Lcom/tencent/qui/quilistitem/c$b;)V", "right", "<init>", "(Lcom/tencent/qui/quilistitem/c$a;Lcom/tencent/qui/quilistitem/c$b;)V", "a", "b", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class c<L extends a, R extends b> extends t<QUIDoubleLineListItem> {
    static IPatchRedirector $redirector_;

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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/c$a;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/qui/quilistitem/c$a$d;", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/c$a$a;", "Lcom/tencent/qui/quilistitem/c$a$d;", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9716a extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            @NotNull
            public final String c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/c$a$b;", "Lcom/tencent/qui/quilistitem/c$a$d;", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class b extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String imageUrl;

            @NotNull
            public final String c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.imageUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qui/quilistitem/c$a$c;", "Lcom/tencent/qui/quilistitem/c$a$d;", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", PhotoCategorySummaryInfo.AVATAR_URL, "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9717c extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String avatarUrl;

            @NotNull
            public final String c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (String) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.avatarUrl;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qui/quilistitem/c$a$d;", "Lcom/tencent/qui/quilistitem/c$a;", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "setDescription", "description", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static class d extends a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence text;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private CharSequence description;

            @NotNull
            public final CharSequence a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.description;
            }

            @NotNull
            public final CharSequence b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                return this.text;
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\b\t\n\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u0082\u0001\u0005\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b;", "", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "b", "c", "d", "e", "Lcom/tencent/qui/quilistitem/c$b$d;", "Lcom/tencent/qui/quilistitem/c$b$a;", "Lcom/tencent/qui/quilistitem/c$b$c;", "Lcom/tencent/qui/quilistitem/c$b$e;", "Lcom/tencent/qui/quilistitem/c$b$b;", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b$a;", "Lcom/tencent/qui/quilistitem/c$b;", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "setButtonText", "(Ljava/lang/CharSequence;)V", "buttonText", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "c", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "", "Z", "e", "()Z", "setShowCloseButton", "(Z)V", "showCloseButton", "d", "setCloseButtonClickListener", "closeButtonClickListener", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class a extends b {
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
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b$b;", "Lcom/tencent/qui/quilistitem/c$b;", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9718b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C9718b f363795a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10446);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f363795a = new C9718b();
                }
            }

            C9718b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b$c;", "Lcom/tencent/qui/quilistitem/c$b;", "", "a", "Z", "c", "()Z", "e", "(Z)V", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "b", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "listener", "d", "setEnabled", "isEnabled", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9719c extends b {
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
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b$d;", "Lcom/tencent/qui/quilistitem/c$b;", "", "a", "Ljava/lang/CharSequence;", "d", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "", "b", "Z", "()Z", "setShowArrow", "(Z)V", "showArrow", "c", "setShowRedPoint", "showRedPoint", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class d extends b {
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
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qui/quilistitem/c$b$e;", "Lcom/tencent/qui/quilistitem/c$b;", "", "a", "Z", "c", "()Z", "d", "(Z)V", "isSelected", "Lcom/tencent/qui/quilistitem/i;", "b", "Lcom/tencent/qui/quilistitem/i;", "()Lcom/tencent/qui/quilistitem/i;", "setListener", "(Lcom/tencent/qui/quilistitem/i;)V", "listener", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes25.dex */
        public static final class e extends b {
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

        b() {
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

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    public c(@NotNull L left, @NotNull R right) {
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
    public void k(@NotNull QUIDoubleLineListItem view, @NotNull Group.b outMargin) {
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
        if (l3 instanceof a.C9716a) {
            i16 = view.i().f().getLayoutParams().width;
        } else if (l3 instanceof a.C9717c) {
            i16 = view.i().h().getLayoutParams().width;
        } else if (l3 instanceof a.b) {
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
    public void m(@NotNull QUIDoubleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(position), payloads);
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
    public QUIDoubleLineListItem o(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUIDoubleLineListItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QUIDoubleLineListItem qUIDoubleLineListItem = new QUIDoubleLineListItem(context, null);
        qUIDoubleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return qUIDoubleLineListItem;
    }

    public final void x(@NotNull L l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "<set-?>");
            this.left = l3;
        }
    }

    public final void y(@NotNull R r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) r16);
        } else {
            Intrinsics.checkNotNullParameter(r16, "<set-?>");
            this.right = r16;
        }
    }
}
