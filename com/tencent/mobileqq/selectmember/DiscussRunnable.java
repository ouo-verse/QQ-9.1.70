package com.tencent.mobileqq.selectmember;

import QQService.AddDiscussMemberInfo;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.troopmemberlist.FetchDiffTroopMemberRunnable;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001&BI\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u000bj\b\u0012\u0004\u0012\u00020\u0019`\r\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u000bj\b\u0012\u0004\u0012\u00020\u0019`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/selectmember/DiscussRunnable;", "Ljava/lang/Runnable;", "", "e", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberMap", "f", "groupCode", "c", "Ljava/util/ArrayList;", "LQQService/AddDiscussMemberInfo;", "Lkotlin/collections/ArrayList;", h.F, "uin", "Lcom/tencent/mobileqq/data/Friends;", "g", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/common/app/AppInterface;", "d", "Ljava/lang/ref/WeakReference;", "appRef", "Ljava/lang/String;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Ljava/util/ArrayList;", "resultList", "", "I", "from", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/util/ArrayList;ILandroidx/lifecycle/LifecycleOwner;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DiscussRunnable implements Runnable {
    static IPatchRedirector $redirector_;
    private static final int C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<AppInterface> appRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String groupCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ResultRecord> resultList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LifecycleOwner lifecycleOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/selectmember/DiscussRunnable$a;", "", "", "LIMIT_SET_DISCUSSION_NAME", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectmember.DiscussRunnable$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/selectmember/DiscussRunnable$b", "Lcom/tencent/qqnt/troopmemberlist/e;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.qqnt.troopmemberlist.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussRunnable.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.e
        public void a(@NotNull Map<String, ? extends TroopMemberInfo> troopMemberList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
            if (QLog.isColorLevel()) {
                QLog.i("DiscussRunnable", 2, "[onFetchMembers] rSize:" + DiscussRunnable.this.resultList.size() + ", mapSize:" + troopMemberList.size());
            }
            DiscussRunnable.this.f(troopMemberList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(JsonGrayBusiId.TROOP_ADD_FRIEND_ACTIVE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            C = 48;
        }
    }

    public DiscussRunnable(@NotNull WeakReference<AppInterface> appRef, @Nullable String str, @NotNull ArrayList<ResultRecord> resultList, int i3, @Nullable LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(appRef, "appRef");
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRef, str, resultList, Integer.valueOf(i3), lifecycleOwner);
            return;
        }
        this.appRef = appRef;
        this.groupCode = str;
        this.resultList = resultList;
        this.from = i3;
        this.lifecycleOwner = lifecycleOwner;
    }

    private final void c(String groupCode) {
        IDiscussionHandlerService iDiscussionHandlerService;
        ArrayList<AddDiscussMemberInfo> h16 = h();
        AppInterface appInterface = this.appRef.get();
        if (appInterface != null) {
            iDiscussionHandlerService = (IDiscussionHandlerService) appInterface.getRuntimeService(IDiscussionHandlerService.class, "");
        } else {
            iDiscussionHandlerService = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussRunnable", 2, "[addDiscussMember]groupCode:" + this.groupCode + ", member count: " + h16.size());
        }
        if (iDiscussionHandlerService != null) {
            iDiscussionHandlerService.addDiscussMember(Long.parseLong(groupCode), h16);
        }
    }

    private final void e() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        boolean z17;
        QLog.i("DiscussRunnable", 1, "[createDiscuss] start");
        ArrayList<ResultRecord> arrayList = this.resultList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ResultRecord resultRecord = (ResultRecord) obj;
            boolean z18 = false;
            if (resultRecord.type == 1) {
                String str = resultRecord.groupUin;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String str2 = resultRecord.uin;
                    if (str2 != null && str2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        z18 = true;
                    }
                }
            }
            if (z18) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            f(new HashMap());
            return;
        }
        ArrayList<ResultRecord> arrayList3 = this.resultList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((ResultRecord) it.next()).groupUin);
        }
        ArrayList<ResultRecord> arrayList5 = this.resultList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((ResultRecord) it5.next()).uin);
        }
        new FetchDiffTroopMemberRunnable(arrayList4, arrayList6, this.lifecycleOwner, new b()).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a9, code lost:
    
        r3 = r7.substring(0, r15 - 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b3, code lost:
    
        r7 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(Map<String, ? extends TroopMemberInfo> troopMemberMap) {
        String str;
        IDiscussionHandlerService iDiscussionHandlerService;
        int length;
        long j3;
        String str2;
        Object obj;
        DiscussionMemberInfo discussionMemberInfo;
        String str3;
        boolean z16;
        IDiscussionService iDiscussionService;
        boolean z17;
        boolean z18;
        ArrayList<AddDiscussMemberInfo> h16 = h();
        ArrayList arrayList = new ArrayList();
        ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
        AppInterface appInterface = this.appRef.get();
        AppInterface appInterface2 = this.appRef.get();
        if (appInterface2 != null) {
            str = appInterface2.getCurrentAccountUin();
        } else {
            str = null;
        }
        String accountNickName = iSelectMemberRefatorHelperApi.getAccountNickName(appInterface, str);
        Iterator<ResultRecord> it = this.resultList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (next.type != 4) {
                try {
                    String str4 = next.uin;
                    Intrinsics.checkNotNullExpressionValue(str4, "rr.uin");
                    j3 = Long.parseLong(str4);
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DiscussRunnable", 2, "NumberFormatException!!! uin:" + next.uin);
                    }
                }
            } else {
                j3 = 0;
            }
            arrayList.add(String.valueOf(j3));
            String str5 = accountNickName + "\u3001";
            int i3 = next.type;
            if (i3 == 0) {
                String str6 = next.uin;
                Intrinsics.checkNotNullExpressionValue(str6, "rr.uin");
                Friends g16 = g(str6);
                if (g16 != null) {
                    str2 = g16.name;
                } else {
                    str2 = null;
                }
            } else {
                if (i3 == 1) {
                    String str7 = next.groupUin;
                    if (str7 != null && str7.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        String str8 = next.uin;
                        if (str8 != null && str8.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (!z18) {
                            String str9 = next.groupUin;
                            Intrinsics.checkNotNullExpressionValue(str9, "rr.groupUin");
                            String str10 = next.uin;
                            Intrinsics.checkNotNullExpressionValue(str10, "rr.uin");
                            TroopMemberInfo troopMemberInfo = troopMemberMap.get(com.tencent.qqnt.troopmemberlist.b.a(str9, str10));
                            if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.friendnick)) {
                                str2 = troopMemberInfo.friendnick;
                            }
                            str2 = null;
                        }
                    }
                }
                int i16 = next.type;
                if (i16 == 2) {
                    AppInterface appInterface3 = this.appRef.get();
                    if (appInterface3 != null && (iDiscussionService = (IDiscussionService) appInterface3.getRuntimeService(IDiscussionService.class, "")) != null) {
                        obj = iDiscussionService.getDiscussionMemberInfo(next.groupUin, next.uin);
                    } else {
                        obj = null;
                    }
                    if (obj instanceof DiscussionMemberInfo) {
                        discussionMemberInfo = (DiscussionMemberInfo) obj;
                    } else {
                        discussionMemberInfo = null;
                    }
                    if (discussionMemberInfo != null) {
                        str3 = discussionMemberInfo.inteRemark;
                    } else {
                        str3 = null;
                    }
                    if (str3 != null) {
                        String str11 = discussionMemberInfo.inteRemark;
                        Intrinsics.checkNotNullExpressionValue(str11, "info.inteRemark");
                        if (str11.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            str2 = discussionMemberInfo.inteRemark;
                        }
                    }
                    str2 = null;
                } else if (i16 == 3) {
                    str2 = next.name;
                } else {
                    if (i16 == 4) {
                        str2 = next.name;
                    }
                    str2 = null;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = next.uin;
            }
            accountNickName = str5 + str2;
        }
        try {
            Intrinsics.checkNotNull(accountNickName);
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = accountNickName.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            if (bytes.length > C && 1 <= (length = accountNickName.length())) {
                int i17 = 0;
                int i18 = 1;
                while (true) {
                    String substring = accountNickName.substring(i17, i18);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    Charset forName2 = Charset.forName("utf-8");
                    Intrinsics.checkNotNullExpressionValue(forName2, "forName(charsetName)");
                    byte[] bytes2 = substring.getBytes(forName2);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    if (bytes2.length <= C) {
                        if (i18 == length) {
                            break;
                        }
                        i18++;
                        i17 = 0;
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.i("DiscussRunnable", 1, "[createDiscussInner] line:" + accountNickName + ", member count:" + h16.size() + " ");
        SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
        AppInterface appInterface4 = this.appRef.get();
        if (appInterface4 != null && (iDiscussionHandlerService = (IDiscussionHandlerService) appInterface4.getRuntimeService(IDiscussionHandlerService.class, "")) != null) {
            iDiscussionHandlerService.createDiscuss(accountNickName, h16, this.from);
        }
    }

    private final Friends g(String uin) {
        IFriendDataService iFriendDataService;
        if (!Friends.isValidUin(uin)) {
            return null;
        }
        AppInterface appInterface = this.appRef.get();
        if (appInterface != null) {
            iFriendDataService = (IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "");
        } else {
            iFriendDataService = null;
        }
        if (iFriendDataService == null) {
            return null;
        }
        return iFriendDataService.getFriend(uin, true, true);
    }

    private final ArrayList<AddDiscussMemberInfo> h() {
        long j3;
        ArrayList<AddDiscussMemberInfo> arrayList = new ArrayList<>();
        Iterator<ResultRecord> it = this.resultList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            AddDiscussMemberInfo addDiscussMemberInfo = new AddDiscussMemberInfo();
            if (next.type == 4) {
                addDiscussMemberInfo.RefStr = next.uin;
            } else {
                try {
                    String str = next.uin;
                    long j16 = 0;
                    if (str != null) {
                        j3 = Long.parseLong(str);
                    } else {
                        j3 = 0;
                    }
                    addDiscussMemberInfo.Uin = j3;
                    String str2 = next.groupUin;
                    if (str2 != null) {
                        j16 = Long.parseLong(str2);
                    }
                    addDiscussMemberInfo.RefUin = j16;
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DiscussRunnable", 2, "NumberFormatException!!! uin:" + next.uin);
                    }
                }
            }
            addDiscussMemberInfo.Type = next.type;
            arrayList.add(addDiscussMemberInfo);
        }
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = this.groupCode;
        if (str == null) {
            e();
        } else {
            c(str);
        }
    }
}
