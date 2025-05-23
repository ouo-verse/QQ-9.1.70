package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.AddContactReportHelper;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.JoinStatus;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.o;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.troop.flock.QeventPB$Feed;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u001a(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t\u001a\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t\u001a\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;", "status", "", "e", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/o;", "holder", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "personItem", "", "recommendRank", "d", "troopItem", "Ltencent/im/troop/flock/QeventPB$Feed;", "flockData", "b", "c", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public /* synthetic */ class C7146a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180931a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50141);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[JoinStatus.values().length];
            try {
                iArr[JoinStatus.JOINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JoinStatus.JOINING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JoinStatus.NOT_JOIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f180931a = iArr;
        }
    }

    public static final void a(@NotNull o holder, @NotNull QeventPB$Feed flockData, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(flockData, "flockData");
        AddContactDataType addContactDataType = AddContactDataType.FLOCK;
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        addContactReportHelper.c(holder.i0(), "em_bas_event_entry", addContactReportHelper.j(addContactDataType, i3), addContactReportHelper.e(flockData, i3));
        AddContactReportHelper.d(addContactReportHelper, holder.o0(), "em_event_join", addContactReportHelper.l(addContactDataType, i3), null, 8, null);
        AddContactReportHelper.d(addContactReportHelper, holder.p0(), "em_event_join", addContactReportHelper.l(addContactDataType, i3), null, 8, null);
        addContactReportHelper.c(holder.j0(), "em_bas_activity_longer_recommend", addContactReportHelper.k(addContactDataType, i3), addContactReportHelper.e(flockData, i3));
    }

    public static final void b(@NotNull o holder, @NotNull RecommendTroopItem troopItem, @Nullable QeventPB$Feed qeventPB$Feed, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        AddContactDataType addContactDataType = AddContactDataType.f293812GROUP;
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        addContactReportHelper.c(holder.i0(), "em_bas_group_entry", addContactReportHelper.j(addContactDataType, i3), addContactReportHelper.g(troopItem, qeventPB$Feed, i3));
        addContactReportHelper.c(holder.o0(), "em_group_join", addContactReportHelper.l(addContactDataType, i3), addContactReportHelper.f(troopItem));
        addContactReportHelper.c(holder.p0(), "em_group_join", addContactReportHelper.l(addContactDataType, i3), addContactReportHelper.f(troopItem));
        addContactReportHelper.c(holder.j0(), "em_bas_group_longer_recommend", addContactReportHelper.k(addContactDataType, i3), addContactReportHelper.g(troopItem, qeventPB$Feed, i3));
    }

    public static final void c(@NotNull o holder, @NotNull RecommendTroopItem troopItem, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        AddContactDataType addContactDataType = AddContactDataType.GUILD;
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        addContactReportHelper.c(holder.i0(), "em_search_channel_entry", addContactReportHelper.j(addContactDataType, i3), addContactReportHelper.i(troopItem, i3));
        addContactReportHelper.c(holder.o0(), "em_bas_search_channel_enter", addContactReportHelper.l(addContactDataType, i3), addContactReportHelper.h(troopItem));
        addContactReportHelper.c(holder.p0(), "em_bas_search_channel_enter", addContactReportHelper.l(addContactDataType, i3), addContactReportHelper.h(troopItem));
        addContactReportHelper.c(holder.j0(), "em_bas_channel_longer_recommend", addContactReportHelper.k(addContactDataType, i3), addContactReportHelper.i(troopItem, i3));
    }

    public static final void d(@NotNull o holder, @NotNull MayKnowRecommend personItem, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(personItem, "personItem");
        AddContactDataType addContactDataType = AddContactDataType.PERSON;
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        addContactReportHelper.c(holder.i0(), "em_search_person_entry", addContactReportHelper.j(addContactDataType, i3), addContactReportHelper.n(personItem, i3));
        addContactReportHelper.c(holder.o0(), "em_bas_person_enter_button", addContactReportHelper.l(addContactDataType, i3), addContactReportHelper.m(personItem));
        addContactReportHelper.c(holder.j0(), "em_bas_person_longer_recommend", addContactReportHelper.k(addContactDataType, i3), addContactReportHelper.n(personItem, i3));
    }

    public static final void e(@NotNull RecommendTroopItem recommendTroopItem, @NotNull JoinStatus status) {
        Intrinsics.checkNotNullParameter(recommendTroopItem, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        int i3 = C7146a.f180931a[status.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    recommendTroopItem.privilege = -1;
                    recommendTroopItem.hasRequestJoin = false;
                    return;
                }
                return;
            }
            recommendTroopItem.hasRequestJoin = true;
            return;
        }
        recommendTroopItem.privilege = 0;
    }
}
