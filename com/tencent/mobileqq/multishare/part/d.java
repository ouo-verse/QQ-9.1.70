package com.tencent.mobileqq.multishare.part;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.multishare.p007const.MultiShareSelectStatus;
import com.tencent.mobileqq.multishare.part.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0014J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/d;", "Lcom/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart;", "", "X9", "Lcom/tencent/mobileqq/multishare/action/c;", QCircleAlphaUserReporter.KEY_USER, "", com.tencent.luggage.wxa.c8.c.G, "", "isSelected", "o4", "Lj92/f;", "I", "Lj92/f;", "recentUserFetcher", "J", "Z", "alwaysShowUserCheckbox", "<init>", "(Lj92/f;Z)V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends MultiShareRecentFriendsPart {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final j92.f recentUserFetcher;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean alwaysShowUserCheckbox;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/multishare/part/d$a", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f251793b;

        a(boolean z16) {
            this.f251793b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Boolean.valueOf(z16));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d this$0, boolean z16) {
            List list;
            List listOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.I9().size() <= 0) {
                this$0.J9().setVisibility(8);
                this$0.E9().setVisibility(8);
                return;
            }
            this$0.M9();
            this$0.J9().setVisibility(0);
            this$0.E9().setVisibility(0);
            this$0.J9().getLayoutParams().height = this$0.B9();
            this$0.J9().scrollToPosition(0);
            com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.i(context, this$0.J9());
            com.tencent.mobileqq.multishare.adapter.b K9 = this$0.K9();
            list = CollectionsKt___CollectionsKt.toList(this$0.I9());
            K9.setItems(list);
            if (z16) {
                com.tencent.mobileqq.multishare.adapter.a F9 = this$0.F9();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.multishare.item.b());
                F9.setItems(listOf);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> recentUserList) {
            com.tencent.mobileqq.multishare.viewmodel.a H9;
            MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1;
            List<com.tencent.mobileqq.multishare.bean.a> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentUserList);
                return;
            }
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
            ArrayList arrayList = new ArrayList();
            for (RecentUser recentUser : recentUserList) {
                String displayName = recentUser.displayName;
                Friends friendFromMemoryCache = iFriendDataService.getFriendFromMemoryCache(recentUser.uin);
                if (friendFromMemoryCache != null) {
                    if (TextUtils.isEmpty(friendFromMemoryCache.remark)) {
                        displayName = friendFromMemoryCache.name;
                    } else {
                        displayName = friendFromMemoryCache.remark;
                    }
                    if (TextUtils.isEmpty(displayName)) {
                        displayName = recentUser.uin;
                    }
                }
                String str = recentUser.uin;
                Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
                int i3 = recentUser.type;
                Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
                com.tencent.mobileqq.multishare.item.a aVar = new com.tencent.mobileqq.multishare.item.a(str, i3, displayName);
                aVar.j(recentUser.lastmsgtime);
                if (!TextUtils.isEmpty(recentUser.troopUin)) {
                    String str2 = recentUser.troopUin;
                    Intrinsics.checkNotNullExpressionValue(str2, "recentUser.troopUin");
                    aVar.h(str2);
                }
                arrayList.add(aVar);
            }
            d.this.I9().clear();
            d.this.I9().addAll(arrayList);
            Handler mainHandler = d.this.getMainHandler();
            final d dVar = d.this;
            final boolean z16 = this.f251793b;
            mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.multishare.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.b(d.this, z16);
                }
            });
            if ((!d.this.D9().isEmpty()) && (H9 = d.this.H9()) != null && (L1 = H9.L1()) != null) {
                list = CollectionsKt___CollectionsKt.toList(d.this.D9());
                L1.postValue(list);
            }
        }
    }

    public d(@NotNull j92.f recentUserFetcher, boolean z16) {
        Intrinsics.checkNotNullParameter(recentUserFetcher, "recentUserFetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recentUserFetcher, Boolean.valueOf(z16));
        } else {
            this.recentUserFetcher = recentUserFetcher;
            this.alwaysShowUserCheckbox = z16;
        }
    }

    @Override // com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart
    protected void X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.recentUserFetcher.a(new a(this.recentUserFetcher.hasMore()));
        }
    }

    @Override // com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart, i92.b
    public void o4(@NotNull com.tencent.mobileqq.multishare.action.c user, int pos, boolean isSelected) {
        List list;
        List<com.tencent.mobileqq.multishare.bean.a> list2;
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        List list3;
        MultiShareSelectStatus multiShareSelectStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, user, Integer.valueOf(pos), Boolean.valueOf(isSelected));
            return;
        }
        Intrinsics.checkNotNullParameter(user, "user");
        com.tencent.mobileqq.multishare.bean.a Y9 = Y9(user);
        if (isSelected) {
            D9().add(Y9);
        } else {
            P9(Y9);
        }
        if (D9().isEmpty()) {
            for (com.tencent.mobileqq.multishare.item.a aVar : I9()) {
                if (this.alwaysShowUserCheckbox) {
                    multiShareSelectStatus = MultiShareSelectStatus.SELECTING;
                } else {
                    multiShareSelectStatus = MultiShareSelectStatus.UNSELECTED;
                }
                aVar.k(multiShareSelectStatus);
            }
            com.tencent.mobileqq.multishare.adapter.b K9 = K9();
            list3 = CollectionsKt___CollectionsKt.toList(I9());
            K9.setItems(list3);
            U9(false);
        } else {
            W9(pos, isSelected);
            com.tencent.mobileqq.multishare.adapter.b K92 = K9();
            list = CollectionsKt___CollectionsKt.toList(I9());
            K92.setItems(list);
        }
        MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1 = H9().L1();
        list2 = CollectionsKt___CollectionsKt.toList(D9());
        L1.postValue(list2);
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            sh5.a(user, isSelected);
        }
    }
}
