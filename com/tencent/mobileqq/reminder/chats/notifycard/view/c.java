package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0016B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0010\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0010\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/c;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardViewBase;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/a;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/a;", "Landroid/view/View;", "root", "", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;)V", "", "position", "", "isChecked", "o", "p", "oldSize", "newSize", "a", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mHeadSelectRv", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/b;", "G", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/b;", "mUserItemAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "H", "Landroidx/recyclerview/widget/GridLayoutManager;", "mGridLayoutManager", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;)V", "I", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends NotifyGuestCardViewBase implements com.tencent.mobileqq.reminder.chats.notifycard.rv.a<com.tencent.mobileqq.reminder.chats.notifycard.model.d>, com.tencent.mobileqq.reminder.chats.notifycard.manager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mHeadSelectRv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.reminder.chats.notifycard.rv.b mUserItemAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GridLayoutManager mGridLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/c$a;", "", "", "AVATAR_CHECKED", "I", "AVATAR_UNCHECKED", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.c$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21772);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull a card) {
        super(card);
        Intrinsics.checkNotNullParameter(card, "card");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) card);
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.manager.a
    public void a(int oldSize, int newSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(oldSize), Integer.valueOf(newSize));
            return;
        }
        b e16 = e();
        if (e16 != null) {
            if (newSize <= 0) {
                z16 = false;
            }
            e16.f(z16);
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase
    public void m(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.C().isEmpty()) {
            QLog.e("NotifyGuestCardMultiView", 1, "Invalid data! User list is empty!");
            return;
        }
        View j3 = j();
        if (j3 == null) {
            return;
        }
        TextView h16 = h();
        if (h16 != null) {
            h16.setText(data.l());
        }
        g().c(data.C());
        GridLayoutManager gridLayoutManager = this.mGridLayoutManager;
        if (gridLayoutManager == null) {
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(j3.getContext(), data.C().size());
            this.mGridLayoutManager = gridLayoutManager2;
            RecyclerView recyclerView = this.mHeadSelectRv;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(gridLayoutManager2);
            }
        } else if (gridLayoutManager != null) {
            gridLayoutManager.setSpanCount(data.C().size());
        }
        if (this.mUserItemAdapter == null) {
            com.tencent.mobileqq.reminder.chats.notifycard.rv.b bVar = new com.tencent.mobileqq.reminder.chats.notifycard.rv.b();
            this.mUserItemAdapter = bVar;
            bVar.m0(this);
            RecyclerView recyclerView2 = this.mHeadSelectRv;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.mUserItemAdapter);
            }
        }
        com.tencent.mobileqq.reminder.chats.notifycard.rv.b bVar2 = this.mUserItemAdapter;
        if (bVar2 != null) {
            bVar2.setData(data.C());
        }
        com.tencent.mobileqq.reminder.chats.notifycard.rv.b bVar3 = this.mUserItemAdapter;
        if (bVar3 != null) {
            bVar3.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase
    public void n(@Nullable View root) {
        RecyclerView recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) root);
            return;
        }
        if (root != null) {
            recyclerView = (RecyclerView) root.findViewById(R.id.zud);
        } else {
            recyclerView = null;
        }
        this.mHeadSelectRv = recyclerView;
        g().e(this);
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.rv.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void g0(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.d data, int position, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), Boolean.valueOf(isChecked));
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            g().b(data, isChecked);
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.rv.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.d data, int position) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.cardcontainer.e a16 = f().a();
        if (a16 != null) {
            if (data.d()) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            e.a.a(a16, i3, null, 2, null);
        }
    }
}
