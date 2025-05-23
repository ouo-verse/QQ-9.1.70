package com.tencent.mobileqq.cardcontainer.framework;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001d2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000e2\n\u0010\f\u001a\u00060\u0003R\u00020\u0000H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter$b;", "Landroid/content/Context;", "context", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "", "m0", "getItemViewType", "l0", "o0", "Lcom/tencent/mobileqq/cardcontainer/framework/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/cardcontainer/framework/l;", "listener", "Lcom/tencent/mobileqq/cardcontainer/framework/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/cardcontainer/framework/j;", "reportHelper", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/framework/l;Lcom/tencent/mobileqq/cardcontainer/framework/j;)V", "D", "a", "b", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardsAdapter extends ListAdapter<com.tencent.mobileqq.cardcontainer.data.a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final j reportHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.CardsAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010\u0012\u001a\u00020\u0005R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/cardcontainer/e;", "", "customReportData", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "l", "F8", ZPlanPublishSource.FROM_SCHEME, "aa", "Ie", "", "clickPosition", "nc", Constants.MMCCID, "onRecycled", "Lcom/tencent/mobileqq/cardcontainer/d;", "E", "Lcom/tencent/mobileqq/cardcontainer/d;", "cardView", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/cardcontainer/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardData", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter;Lcom/tencent/mobileqq/cardcontainer/d;)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class b extends RecyclerView.ViewHolder implements com.tencent.mobileqq.cardcontainer.e {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.cardcontainer.d cardView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.cardcontainer.data.a cardData;
        final /* synthetic */ CardsAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull CardsAdapter cardsAdapter, com.tencent.mobileqq.cardcontainer.d cardView) {
            super(cardView.getView());
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            this.G = cardsAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cardsAdapter, (Object) cardView);
            } else {
                this.cardView = cardView;
            }
        }

        private final void n(String customReportData) {
            ContainerData containerData;
            com.tencent.mobileqq.cardcontainer.data.a aVar = this.cardData;
            if (aVar instanceof ContainerData) {
                containerData = (ContainerData) aVar;
            } else {
                containerData = null;
            }
            if (containerData != null) {
                this.G.reportHelper.d(containerData, customReportData);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.e
        public void F8() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CardContainer.CardsAdapter", 1, "[onCloseCard] position: " + getAdapterPosition());
            }
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                this.G.listener.b(adapterPosition);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.e
        public void G2(@Nullable String customReportData) {
            ContainerData containerData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) customReportData);
                return;
            }
            com.tencent.mobileqq.cardcontainer.data.a aVar = this.cardData;
            if (aVar instanceof ContainerData) {
                containerData = (ContainerData) aVar;
            } else {
                containerData = null;
            }
            if (containerData != null) {
                this.G.reportHelper.c(containerData, 1, customReportData);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.e
        public void Ie(@Nullable String customReportData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) customReportData);
            } else {
                n(customReportData);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.e
        public void aa(@NotNull String scheme) {
            boolean z16;
            ContainerData containerData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) scheme);
                return;
            }
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                this.G.listener.d(adapterPosition, scheme);
            }
            if (scheme.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.w("CardContainer.CardsAdapter", 1, "[doJumpAction] scheme is empty, cardItem:" + this.cardData);
                return;
            }
            com.tencent.mobileqq.cardcontainer.data.a aVar = this.cardData;
            if (aVar instanceof ContainerData) {
                containerData = (ContainerData) aVar;
            } else {
                containerData = null;
            }
            if (containerData == null) {
                QLog.w("CardContainer.CardsAdapter", 1, "[doJumpAction] cardData is not ContainerData, cardData:" + aVar);
                return;
            }
            com.tencent.mobileqq.cardcontainer.b bVar = com.tencent.mobileqq.cardcontainer.b.f201051a;
            Context context = this.cardView.getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "cardView.getView().context");
            if (bVar.c(context, scheme, containerData)) {
                return;
            }
            Context context2 = this.cardView.getView().getContext();
            Intent intent = new Intent(context2, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(scheme));
            context2.startActivity(intent);
        }

        public final void l(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            this.cardData = data;
            this.cardView.d(data, this);
        }

        @Nullable
        public final com.tencent.mobileqq.cardcontainer.data.a m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.cardcontainer.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.cardData;
        }

        @Override // com.tencent.mobileqq.cardcontainer.e
        public void nc(int clickPosition, @Nullable String customReportData) {
            ContainerData containerData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, clickPosition, (Object) customReportData);
                return;
            }
            com.tencent.mobileqq.cardcontainer.data.a aVar = this.cardData;
            if (aVar instanceof ContainerData) {
                containerData = (ContainerData) aVar;
            } else {
                containerData = null;
            }
            if (containerData != null) {
                this.G.reportHelper.c(containerData, clickPosition, customReportData);
            }
        }

        public final void onRecycled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                this.cardView.b();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardsAdapter(@NotNull l listener, @NotNull j reportHelper) {
        super(new m());
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener, (Object) reportHelper);
        } else {
            this.listener = listener;
            this.reportHelper = reportHelper;
        }
    }

    private final b k0(Context context) {
        CardsAdapter$createEmptyViewHolder$view$1 cardsAdapter$createEmptyViewHolder$view$1 = new CardsAdapter$createEmptyViewHolder$view$1(context);
        cardsAdapter$createEmptyViewHolder$view$1.setVisibility(8);
        return new b(this, cardsAdapter$createEmptyViewHolder$view$1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, position)).intValue();
        }
        return k.f201131a.b(getItem(position).c());
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.cardcontainer.data.a getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.cardcontainer.data.a) iPatchRedirector.redirect((short) 5, (Object) this, position);
        }
        Object item = super.getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "super.getItem(position)");
        return (com.tencent.mobileqq.cardcontainer.data.a) item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.cardcontainer.data.a item = getItem(position);
        try {
            holder.l(item);
        } catch (Exception e16) {
            QLog.w("CardContainer.CardsAdapter", 1, "[onBindViewHolder] failed to bind card data, position: " + position + " data:" + item + " exc:" + e16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.mobileqq.cardcontainer.d a16 = k.f201131a.a(viewType, parent);
        if (a16 == null) {
            QLog.w("CardContainer.CardsAdapter", 1, "[onCreateViewHolder] failed to create card view, viewType: " + viewType);
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return k0(context);
        }
        return new b(this, a16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull b holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        try {
            holder.onRecycled();
        } catch (Exception e16) {
            QLog.w("CardContainer.CardsAdapter", 1, "[onViewRecycled] failed to recycle card view, data:" + holder.m() + " exc:" + e16);
        }
    }
}
