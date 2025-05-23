package com.tencent.mobileqq.reminder.chats.notifycard.rv;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010'\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/NotifyGuestUserItemVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", "data", "", "position", "", "p", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/a;", "listener", "r", "E", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", "mData", UserInfo.SEX_FEMALE, "I", "mPosition", "G", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/a;", "mItemListener", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "mHeadView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTitleTv", "J", "mSubtitleTv", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "K", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mSelectBox", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "L", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/graphics/drawable/Drawable;", "mDefaultHeadDrawable", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "M", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NotifyGuestUserItemVH extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.reminder.chats.notifycard.model.d mData;

    /* renamed from: F, reason: from kotlin metadata */
    private int mPosition;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> mItemListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView mHeadView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView mTitleTv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView mSubtitleTv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QUICheckBox mSelectBox;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDefaultHeadDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/NotifyGuestUserItemVH$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/NotifyGuestUserItemVH;", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.rv.NotifyGuestUserItemVH$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final NotifyGuestUserItemVH a(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NotifyGuestUserItemVH) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.fp7, parent, false);
            Intrinsics.checkNotNullExpressionValue(root, "root");
            return new NotifyGuestUserItemVH(root);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyGuestUserItemVH(@NotNull View root) {
        super(root);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) root);
            return;
        }
        this.mPosition = -1;
        View findViewById = root.findViewById(R.id.zuc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.notify_card_user_item_iv)");
        ImageView imageView = (ImageView) findViewById;
        this.mHeadView = imageView;
        View findViewById2 = root.findViewById(R.id.zuf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.n\u2026_card_user_item_title_tv)");
        this.mTitleTv = (TextView) findViewById2;
        View findViewById3 = root.findViewById(R.id.zue);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.n\u2026rd_user_item_subtitle_tv)");
        this.mSubtitleTv = (TextView) findViewById3;
        View findViewById4 = root.findViewById(R.id.t88);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.b\u2026day_card_user_item_check)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById4;
        this.mSelectBox = qUICheckBox;
        lazy = LazyKt__LazyJVMKt.lazy(NotifyGuestUserItemVH$mDefaultHeadDrawable$2.INSTANCE);
        this.mDefaultHeadDrawable = lazy;
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.rv.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NotifyGuestUserItemVH.n(NotifyGuestUserItemVH.this, compoundButton, z16);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.rv.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyGuestUserItemVH.o(NotifyGuestUserItemVH.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(NotifyGuestUserItemVH this$0, CompoundButton compoundButton, boolean z16) {
        a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> aVar;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.reminder.chats.notifycard.model.d dVar = this$0.mData;
        if (dVar != null && (aVar = this$0.mItemListener) != null) {
            Intrinsics.checkNotNull(dVar);
            aVar.g0(dVar, this$0.mPosition, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NotifyGuestUserItemVH this$0, View view) {
        a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectBox.setChecked(!r0.isChecked());
        com.tencent.mobileqq.reminder.chats.notifycard.model.d dVar = this$0.mData;
        if (dVar != null) {
            dVar.e(this$0.mSelectBox.isChecked());
        }
        com.tencent.mobileqq.reminder.chats.notifycard.model.d dVar2 = this$0.mData;
        if (dVar2 != null && (aVar = this$0.mItemListener) != null) {
            Intrinsics.checkNotNull(dVar2);
            aVar.L(dVar2, this$0.mPosition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable q() {
        return (Drawable) this.mDefaultHeadDrawable.getValue();
    }

    public final void p(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.d data, int position) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.mPosition = position;
        this.mTitleTv.setText(data.b());
        this.mSubtitleTv.setText(data.a());
        this.mSelectBox.setChecked(data.d());
        Drawable q16 = q();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        AppInterface appInterface2 = appInterface;
        if (appInterface2 != null) {
            q16 = FaceDrawable.getFaceDrawable(appInterface2, 1, String.valueOf(data.c()), 3, q(), q(), null);
        }
        this.mHeadView.setImageDrawable(q16);
    }

    public final void r(@Nullable a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.mItemListener = listener;
        }
    }
}
