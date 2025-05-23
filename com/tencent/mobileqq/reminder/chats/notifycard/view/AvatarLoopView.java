package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\r\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout;", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "E", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$a;", "mAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "c", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class AvatarLoopView extends GuildVoicingAvatarLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final a mAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$a;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$c;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$b;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "viewHolder", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$c;", "g", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$c;", "getViewHolderCreator", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$c;", "viewHolderCreator", "<init>", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$c;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a extends GuildVoicingAvatarLayout.c<b, String> {
        static IPatchRedirector $redirector_;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c viewHolderCreator;

        public a(@NotNull c viewHolderCreator) {
            Intrinsics.checkNotNullParameter(viewHolderCreator, "viewHolderCreator");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewHolderCreator);
            } else {
                this.viewHolderCreator = viewHolderCreator;
            }
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(@NotNull b viewHolder, @NotNull String data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(data, "data");
            viewHolder.b(data);
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b l(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            return this.viewHolderCreator.a(parent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$b;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$e;", "", "uin", "", "b", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getDefaultAvatarDrawable", "()Landroid/graphics/drawable/Drawable;", "defaultAvatarDrawable", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "avatarView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends GuildVoicingAvatarLayout.e {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable defaultAvatarDrawable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView avatarView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ImageView rootView, @Nullable Drawable drawable) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView, (Object) drawable);
            } else {
                this.defaultAvatarDrawable = drawable;
                this.avatarView = rootView;
            }
        }

        public final void b(@NotNull String uin) {
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Drawable drawable = this.defaultAvatarDrawable;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            AppInterface appInterface2 = appInterface;
            if (appInterface2 != null) {
                Drawable drawable2 = this.defaultAvatarDrawable;
                drawable = FaceDrawable.getFaceDrawable(appInterface2, 1, uin, 3, drawable2, drawable2, null);
            }
            this.avatarView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$c;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView$b;", "a", "", "I", "getAvatarSize", "()I", "avatarSize", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "getAvatarBg", "()Landroid/graphics/drawable/Drawable;", "avatarBg", "c", "getBorderWidth", NodeProps.BORDER_WIDTH, "d", "getDefaultAvatarDrawable", "defaultAvatarDrawable", "<init>", "(ILandroid/graphics/drawable/Drawable;ILandroid/graphics/drawable/Drawable;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int avatarSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable avatarBg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int borderWidth;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable defaultAvatarDrawable;

        public c(int i3, @Nullable Drawable drawable, int i16, @Nullable Drawable drawable2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), drawable, Integer.valueOf(i16), drawable2);
                return;
            }
            this.avatarSize = i3;
            this.avatarBg = drawable;
            this.borderWidth = i16;
            this.defaultAvatarDrawable = drawable2;
        }

        @NotNull
        public final b a(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            ImageView imageView = new ImageView(parent.getContext());
            int i3 = this.avatarSize;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i3, i3);
            int i16 = this.borderWidth;
            imageView.setPadding(i16, i16, i16, i16);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackground(this.avatarBg);
            return new b(imageView, this.defaultAvatarDrawable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarLoopView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cxa);
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        a aVar = new a(new c(this.C, ResourcesCompat.getDrawable(getResources(), R.drawable.f161148k50, null), dimensionPixelSize, defaultDrawable));
        this.mAdapter = aVar;
        setAdapter(aVar);
    }

    public final void E(@NotNull List<String> uinList) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        a aVar = this.mAdapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.j(emptyList, uinList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarLoopView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarLoopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cxa);
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        a aVar = new a(new c(this.C, ResourcesCompat.getDrawable(getResources(), R.drawable.f161148k50, null), dimensionPixelSize, defaultDrawable));
        this.mAdapter = aVar;
        setAdapter(aVar);
    }
}
