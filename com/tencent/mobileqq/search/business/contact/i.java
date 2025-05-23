package com.tencent.mobileqq.search.business.contact;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewModeParams;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.troop.BlockTroopForwardConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberProfileItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wn2.ContactSearchModelNtBuddy;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001\u001a\"\u0010\t\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u000b\u001a\u00020\u0006*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\u0015\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012\u001a\n\u0010\u0017\u001a\u00020\u0014*\u00020\u0006\u001a\n\u0010\u0018\u001a\u00020\u0014*\u00020\u0011\u001a\f\u0010\u001a\u001a\u00020\u0014*\u00020\u0019H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0014*\u00020\u0003H\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyItem;", "", "keyword", "", IProfileCardConst.KEY_FROM_TYPE, "rankInfo", "Lcom/tencent/mobileqq/search/model/k;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupMemberItem;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupItem;", "i", "Lcom/tencent/common/app/AppInterface;", "app", ForwardRecentActivity.KEY_SEARCH_SOURCE, "", "d", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "c", "g", "e", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "a", "f", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i {
    private static final boolean a(ContactsSearchViewModeParams contactsSearchViewModeParams) {
        if ((contactsSearchViewModeParams.getFromType() == 7 || contactsSearchViewModeParams.getFromType() == 8) && contactsSearchViewModeParams.getFilterBlockGroup() && BlockTroopForwardConfig.a()) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull ContactsSearchViewmodel contactsSearchViewmodel, @NotNull ContactsSearchItemData item) {
        String str;
        boolean contains;
        boolean z16;
        Intrinsics.checkNotNullParameter(contactsSearchViewmodel, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        ContactsSearchViewModeParams params = contactsSearchViewmodel.getParams();
        if (params != null) {
            Set<String> g16 = params.g();
            com.tencent.mobileqq.search.model.k model = item.getModel();
            String str2 = null;
            if (model != null) {
                str = model.getUin();
            } else {
                str = null;
            }
            contains = CollectionsKt___CollectionsKt.contains(g16, str);
            if (contains) {
                com.tencent.mobileqq.search.model.k model2 = item.getModel();
                if (model2 != null) {
                    str2 = model2.getUin();
                }
                QLog.d("SearchBuddyItemExt", 2, "hide uin " + str2);
                return false;
            }
            if (params.getFilterType() > 0 && (params.getFilterType() & 1) != 0) {
                com.tencent.mobileqq.search.model.k model3 = item.getModel();
                if (model3 != null && g(model3)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && SearchQQMC.INSTANCE.enableFilterTempConversation()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(@NotNull ContactsSearchViewmodel contactsSearchViewmodel, @NotNull ContactsSearchItemData item) {
        boolean z16;
        boolean z17;
        List<String> b16;
        boolean z18;
        boolean z19;
        boolean z26;
        String str;
        Intrinsics.checkNotNullParameter(contactsSearchViewmodel, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.search.model.k model = item.getModel();
        if (!(model instanceof ContactSearchModelNtTroop)) {
            QLog.d("SearchBuddyItemExt", 1, "filterContactsTroops item model = [" + model + "]");
            return true;
        }
        ContactsSearchViewModeParams params = contactsSearchViewmodel.getParams();
        if (params != null) {
            if (params.getFilterType() > 0 && (params.getFilterType() & 2) != 0) {
                ContactSearchModelNtTroop contactSearchModelNtTroop = (ContactSearchModelNtTroop) model;
                TroopInfo a16 = contactSearchModelNtTroop.a();
                if (a16 != null) {
                    AppInterface X1 = contactsSearchViewmodel.X1();
                    if (X1 != null) {
                        str = X1.getCurrentUin();
                    } else {
                        str = null;
                    }
                    if (a16.isTroopOwner(str)) {
                        z17 = true;
                        boolean areEqual = Intrinsics.areEqual(contactSearchModelNtTroop.getUin(), params.getMasterGroupUin());
                        b16 = params.b();
                        if (b16 == null && b16.contains(contactSearchModelNtTroop.getUin())) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (params.getFilterBlockGroup()) {
                            TroopInfo a17 = contactSearchModelNtTroop.a();
                            if (a17 != null && a17.isTroopBlocked) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z19 = true;
                                if (z17 || areEqual || z18 || z19) {
                                    return false;
                                }
                            }
                        }
                        z19 = false;
                        if (z17) {
                        }
                        return false;
                    }
                }
                z17 = false;
                boolean areEqual2 = Intrinsics.areEqual(contactSearchModelNtTroop.getUin(), params.getMasterGroupUin());
                b16 = params.b();
                if (b16 == null) {
                }
                z18 = false;
                if (params.getFilterBlockGroup()) {
                }
                z19 = false;
                if (z17) {
                }
                return false;
            }
            if (a(params)) {
                TroopInfo a18 = ((ContactSearchModelNtTroop) model).a();
                if (a18 != null && a18.isTroopBlocked) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return false;
                }
            }
            if (params.getFilterType() > 0 && (params.getFilterType() & 1) != 0 && g(item.getModel()) && SearchQQMC.INSTANCE.enableFilterTempConversation()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final List<com.tencent.mobileqq.search.model.k> d(@NotNull AppInterface app, @NotNull String keyword, int i3, int i16) {
        boolean z16;
        boolean z17;
        List<PhoneContact> list;
        List<PhoneContact> list2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if ((i3 & 256) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((i3 & 512) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !z16) {
            QLog.d("SearchBuddyItemExt", 1, "ignore phone contact");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        IRuntimeService runtimeService = app.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        List<List<PhoneContact>> contactListForDisplay = ((IPhoneContactService) runtimeService).getContactListForDisplay();
        if (contactListForDisplay != null && contactListForDisplay.size() > 0 && z16 && (list2 = contactListForDisplay.get(0)) != null) {
            Iterator<PhoneContact> it = list2.iterator();
            while (it.hasNext()) {
                wn2.m mVar = new wn2.m(app, i16, it.next());
                if (mVar.O(keyword) != Long.MIN_VALUE) {
                    arrayList2.add(mVar);
                }
            }
        }
        if (contactListForDisplay != null && contactListForDisplay.size() > 1 && z17 && (list = contactListForDisplay.get(1)) != null) {
            Iterator<PhoneContact> it5 = list.iterator();
            while (it5.hasNext()) {
                wn2.m mVar2 = new wn2.m(app, i16, it5.next());
                if (mVar2.O(keyword) != Long.MIN_VALUE) {
                    arrayList2.add(mVar2);
                }
            }
        }
        arrayList.addAll(arrayList2);
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger.f235387a.d().i("SearchBuddyItemExt", 1, "getPhoneContactBySearchSource cost " + (currentTimeMillis2 - currentTimeMillis));
        return arrayList;
    }

    public static final boolean e(@NotNull ContactsSearchViewmodel contactsSearchViewmodel) {
        Intrinsics.checkNotNullParameter(contactsSearchViewmodel, "<this>");
        ContactsSearchViewModeParams params = contactsSearchViewmodel.getParams();
        if (params != null) {
            return params.getIsDefaultSingleMode();
        }
        return false;
    }

    public static final boolean f(int i3) {
        if (i3 != -1 && i3 != 29) {
            return false;
        }
        return true;
    }

    public static final boolean g(@NotNull com.tencent.mobileqq.search.model.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        if (kVar.M() != 1000 && kVar.M() != 1004 && kVar.M() != 1003 && kVar.M() != 1006 && kVar.M() != 2016) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final com.tencent.mobileqq.search.model.k h(@NotNull SearchBuddyItem searchBuddyItem, @NotNull String keyword, int i3, @NotNull String rankInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(searchBuddyItem, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(rankInfo, "rankInfo");
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(i3, 0L);
        contactSearchModelNtBuddy.keyword = keyword;
        contactSearchModelNtBuddy.m0(searchBuddyItem.nickname + "/" + searchBuddyItem.remark);
        contactSearchModelNtBuddy.uin = String.valueOf(searchBuddyItem.uin);
        List<SearchHitInfo> list = searchBuddyItem.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str = searchBuddyItem.nickname;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.f0(str);
        List<SearchHitInfo> list2 = searchBuddyItem.nicknameHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str3 = searchBuddyItem.remark;
        if (str3 != null) {
            str2 = str3;
        }
        contactSearchModelNtBuddy.k0(str2);
        ArrayList<SearchHitInfo> arrayList = searchBuddyItem.remarkHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.remarkHits");
        contactSearchModelNtBuddy.l0(arrayList);
        if (contactSearchModelNtBuddy.uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(searchBuddyItem.uid);
            Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026).getUinFromUid(this.uid)");
            contactSearchModelNtBuddy.uin = uinFromUid;
            Logger.f235387a.d().i("SearchBuddyItemExt", 1, "createBuddyFrom " + searchBuddyItem + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(searchBuddyItem.chatType);
        String str4 = searchBuddyItem.categoryName;
        Intrinsics.checkNotNullExpressionValue(str4, "this.categoryName");
        contactSearchModelNtBuddy.c0(str4);
        contactSearchModelNtBuddy.i0(rankInfo);
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }

    @NotNull
    public static final com.tencent.mobileqq.search.model.k i(@NotNull SearchGroupItem searchGroupItem, @NotNull String keyword, int i3) {
        Serializable[] serializableArr;
        Intrinsics.checkNotNullParameter(searchGroupItem, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ContactSearchModelNtTroop contactSearchModelNtTroop = new ContactSearchModelNtTroop(i3, 0L);
        contactSearchModelNtTroop.keyword = keyword;
        String str = searchGroupItem.groupInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "this.groupInfo.groupName");
        contactSearchModelNtTroop.title = str;
        contactSearchModelNtTroop.Z(String.valueOf(searchGroupItem.groupInfo.groupCode));
        String str2 = searchGroupItem.groupInfo.remarkName;
        Intrinsics.checkNotNullExpressionValue(str2, "this.groupInfo.remarkName");
        contactSearchModelNtTroop.i0(str2);
        ArrayList<SearchHitInfo> arrayList = searchGroupItem.groupInfo.remarkNameHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.groupInfo.remarkNameHits");
        contactSearchModelNtTroop.j0(arrayList);
        String str3 = searchGroupItem.groupInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str3, "this.groupInfo.groupName");
        contactSearchModelNtTroop.b0(str3);
        ArrayList<SearchHitInfo> arrayList2 = searchGroupItem.groupInfo.groupNameHits;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "this.groupInfo.groupNameHits");
        contactSearchModelNtTroop.c0(arrayList2);
        ArrayList<SearchHitInfo> arrayList3 = searchGroupItem.groupInfo.groupCodeHits;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "this.groupInfo.groupCodeHits");
        contactSearchModelNtTroop.a0(arrayList3);
        contactSearchModelNtTroop.Y(searchGroupItem.groupInfo.isConf);
        contactSearchModelNtTroop.e0(searchGroupItem.groupInfo.noCodeFingerOpenFlag);
        contactSearchModelNtTroop.d0(searchGroupItem.groupInfo.memberCount);
        ArrayList<SearchGroupMemberProfileItem> arrayList4 = searchGroupItem.memberProfile;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "this.memberProfile");
        for (SearchGroupMemberProfileItem searchGroupMemberProfileItem : arrayList4) {
            Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.remarkHits, "profile.remarkHits");
            if (!r1.isEmpty()) {
                serializableArr = new Serializable[]{searchGroupMemberProfileItem.remark, searchGroupMemberProfileItem.remarkHits, 3};
            } else {
                Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.cardNameHits, "profile.cardNameHits");
                if (!r1.isEmpty()) {
                    serializableArr = new Serializable[]{searchGroupMemberProfileItem.cardName, searchGroupMemberProfileItem.cardNameHits, 1};
                } else {
                    Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.nickHits, "profile.nickHits");
                    if (!r1.isEmpty()) {
                        serializableArr = new Serializable[]{searchGroupMemberProfileItem.nick, searchGroupMemberProfileItem.nickHits, 2};
                    } else {
                        serializableArr = new Serializable[]{String.valueOf(searchGroupMemberProfileItem.uin), searchGroupMemberProfileItem.uinHits, 4};
                    }
                }
            }
            Serializable serializable = serializableArr[0];
            Serializable serializable2 = serializableArr[1];
            Serializable serializable3 = serializableArr[2];
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.String");
            Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo> }");
            Intrinsics.checkNotNull(serializable3, "null cannot be cast to non-null type kotlin.Int");
            contactSearchModelNtTroop.R((String) serializable, (ArrayList) serializable2, ((Integer) serializable3).intValue());
        }
        String rankInfo = searchGroupItem.getRankInfo();
        Intrinsics.checkNotNullExpressionValue(rankInfo, "this.getRankInfo()");
        contactSearchModelNtTroop.f0(rankInfo);
        contactSearchModelNtTroop.S();
        return contactSearchModelNtTroop;
    }

    @NotNull
    public static final com.tencent.mobileqq.search.model.k j(@NotNull SearchGroupMemberItem searchGroupMemberItem, @NotNull String keyword, int i3, @NotNull String rankInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(searchGroupMemberItem, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(rankInfo, "rankInfo");
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(i3, 0L);
        contactSearchModelNtBuddy.keyword = keyword;
        contactSearchModelNtBuddy.m0(searchGroupMemberItem.nick + "/" + searchGroupMemberItem.remark + "/" + searchGroupMemberItem.cardName);
        contactSearchModelNtBuddy.uin = String.valueOf(searchGroupMemberItem.uin);
        List<SearchHitInfo> list = searchGroupMemberItem.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str = searchGroupMemberItem.nick;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.f0(str);
        List<SearchHitInfo> list2 = searchGroupMemberItem.nickHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str3 = searchGroupMemberItem.remark;
        if (str3 != null) {
            str2 = str3;
        }
        contactSearchModelNtBuddy.k0(str2);
        ArrayList<SearchHitInfo> arrayList = searchGroupMemberItem.remarkHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.remarkHits");
        contactSearchModelNtBuddy.l0(arrayList);
        String str4 = searchGroupMemberItem.cardName;
        Intrinsics.checkNotNullExpressionValue(str4, "this.cardName");
        contactSearchModelNtBuddy.a0(str4);
        ArrayList<SearchHitInfo> arrayList2 = searchGroupMemberItem.cardNameHits;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "this.cardNameHits");
        contactSearchModelNtBuddy.b0(arrayList2);
        if (contactSearchModelNtBuddy.uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(searchGroupMemberItem.uid);
            Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026).getUinFromUid(this.uid)");
            contactSearchModelNtBuddy.uin = uinFromUid;
            Logger.f235387a.d().i("SearchBuddyItemExt", 1, "createBuddyFrom " + searchGroupMemberItem + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(2);
        String str5 = searchGroupMemberItem.groupName;
        Intrinsics.checkNotNullExpressionValue(str5, "this.groupName");
        contactSearchModelNtBuddy.c0(str5);
        contactSearchModelNtBuddy.e0(String.valueOf(searchGroupMemberItem.groupCode));
        contactSearchModelNtBuddy.i0(rankInfo);
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }
}
