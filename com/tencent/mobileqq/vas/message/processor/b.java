package com.tencent.mobileqq.vas.message.processor;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.message.processor.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J_\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\t2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018H\u0016J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\"\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0013H\u0016R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/message/processor/b;", "Lcom/tencent/mobileqq/vas/message/processor/a;", "", "limitNum", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "d", "Lcom/tencent/mobileqq/app/QQAppInterface;", "runtime", "", "uin", "chatType", "", "e", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/os/Bundle;", "bundle", "f", "Lcom/tencent/state/square/api/MessageRecordType;", "type", "isReceiveNotify", "scene", "nickname", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "callback", "a", "openSettingsPage", "c", "includeUnNotifyMsg", "b", "messageRecordType", "getName", "Lx13/c;", "Lx13/c;", "converter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private x13.c converter = new x13.c();

    private final List<SquareBaseMessageRecord> d(int limitNum) {
        List emptyList;
        int collectionSizeOrDefault;
        List<SquareBaseMessageRecord> emptyList2;
        IKernelService iKernelService;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        aa aaVar = null;
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface != null && (iKernelService = (IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")) != null) {
            aaVar = iKernelService.getRecentContactService();
        }
        if (aaVar == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        List<RecentContactInfo> M = aaVar.M(11);
        if (M == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (Object obj : M) {
                RecentContactInfo recentContactInfo = (RecentContactInfo) obj;
                if (e(qQAppInterface, String.valueOf(recentContactInfo.peerUin), recentContactInfo.chatType)) {
                    emptyList.add(obj);
                }
            }
        }
        if (limitNum > 0 && emptyList.size() > limitNum) {
            emptyList = emptyList.subList(0, limitNum);
        }
        List list = emptyList;
        x13.c cVar = this.converter;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.a((RecentContactInfo) it.next()));
        }
        QLog.i("SquareFriendProcessor", 1, "getRecentFriendList " + arrayList + ", size " + arrayList.size());
        return arrayList;
    }

    private final boolean f(Fragment fragment, String uin, Bundle bundle) {
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        aVar.d(uid);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        String str = nameWithConfig == null ? uin : nameWithConfig;
        bundle.putString(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_NAME_STR, str);
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(fragment, uin, 0, str, bundle, 2);
        QLog.i("SquareFriendProcessor", 1, "openMiniMsgAio-openFriendAio " + uin);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void a(Fragment fragment, int scene, String uin, MessageRecordType type, Bundle bundle, String nickname, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (type != MessageRecordType.RECORD_TYPE_FRIEND) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
            }
        } else {
            boolean f16 = f(fragment, uin, bundle);
            if (callback != null) {
                callback.invoke(Boolean.valueOf(f16));
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public SquareBaseMessageRecord b(String uin, boolean includeUnNotifyMsg, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = null;
        if (type != MessageRecordType.RECORD_TYPE_FRIEND) {
            return null;
        }
        if (uin.length() == 0) {
            return null;
        }
        Iterator<T> it = d(-1).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((SquareBaseMessageRecord) next).getUin(), uin)) {
                obj = next;
                break;
            }
        }
        return (SquareBaseMessageRecord) obj;
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public List<SquareBaseMessageRecord> c(int limitNum, MessageRecordType type) {
        List<SquareBaseMessageRecord> emptyList;
        Intrinsics.checkNotNullParameter(type, "type");
        if (type != MessageRecordType.RECORD_TYPE_FRIEND) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return d(limitNum);
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public String getName(String uin, MessageRecordType messageRecordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(messageRecordType, "messageRecordType");
        if (messageRecordType == MessageRecordType.RECORD_TYPE_FRIEND) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            aVar.d(uid);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            return nameWithConfig == null ? uin : nameWithConfig;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public boolean isReceiveNotify(String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        if (type != MessageRecordType.RECORD_TYPE_FRIEND) {
            return true;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null) == null) {
            return true;
        }
        return !FriendsStatusUtil.k(uin, r4);
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void onSendMsgError(long j3, Contact contact, int i3, String str) {
        a.C8915a.a(this, j3, contact, i3, str);
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void openSettingsPage(Fragment fragment, int scene, String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    private final boolean e(QQAppInterface runtime, String uin, int chatType) {
        boolean isBlank;
        if (chatType != 1) {
            return false;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        boolean isFriend = iFriendsInfoService.isFriend(uid, "SquareFriendProcessor");
        boolean areEqual = Intrinsics.areEqual(runtime.getCurrentUin(), uin);
        isBlank = StringsKt__StringsJVMKt.isBlank(uin);
        return (isBlank ^ true) && isFriend && !areEqual;
    }
}
