package com.tencent.mobileqq.vas.message.processor;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.message.processor.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J_\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018H\u0016J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\"\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0013H\u0016R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/message/processor/f;", "Lcom/tencent/mobileqq/vas/message/processor/a;", "", "troopUin", "e", "", "limitNum", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "d", "uin", "chatType", "", "f", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/os/Bundle;", "bundle", "g", "Lcom/tencent/state/square/api/MessageRecordType;", "type", "isReceiveNotify", "scene", "nickname", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "callback", "a", "openSettingsPage", "c", "includeUnNotifyMsg", "b", "messageRecordType", "getName", "Lx13/f;", "Lx13/f;", "converter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final x13.f converter = new x13.f();

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
                if (f(String.valueOf(recentContactInfo.peerUin), recentContactInfo.chatType)) {
                    emptyList.add(obj);
                }
            }
        }
        if (limitNum > 0 && emptyList.size() > limitNum) {
            emptyList = emptyList.subList(0, limitNum);
        }
        List list = emptyList;
        x13.f fVar = this.converter;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(fVar.a((RecentContactInfo) it.next()));
        }
        QLog.i("SquareTroopProcessor", 1, "getRecentTroopList " + arrayList + ", size " + arrayList.size());
        return arrayList;
    }

    private final String e(String troopUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return troopUin;
        }
        try {
            String g06 = ac.g0(appInterface, troopUin, false);
            return g06 == null ? troopUin : g06;
        } catch (Exception unused) {
            QLog.e("SquareTroopProcessor", 1, "getTroopName error " + troopUin);
            return troopUin;
        }
    }

    private final boolean f(String uin, int chatType) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(uin);
        return (isBlank ^ true) && chatType == 2;
    }

    private final boolean g(Fragment fragment, String uin, Bundle bundle) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return false;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(uin);
        String str = findTroopInfo != null ? findTroopInfo.troopname : null;
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(fragment, uin, 1, str == null ? "" : str, bundle, 2);
        QLog.i("SquareTroopProcessor", 1, "openMiniMsgAio-openTroopAio " + uin);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void a(Fragment fragment, int scene, String uin, MessageRecordType type, Bundle bundle, String nickname, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (type != MessageRecordType.RECORD_TYPE_TROOP) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
            }
        } else {
            boolean g16 = g(fragment, uin, bundle);
            if (callback != null) {
                callback.invoke(Boolean.valueOf(g16));
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public SquareBaseMessageRecord b(String uin, boolean includeUnNotifyMsg, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = null;
        if (type != MessageRecordType.RECORD_TYPE_TROOP) {
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
        if (type != MessageRecordType.RECORD_TYPE_TROOP) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return d(limitNum);
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public String getName(String uin, MessageRecordType messageRecordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(messageRecordType, "messageRecordType");
        if (messageRecordType == MessageRecordType.RECORD_TYPE_TROOP) {
            return e(uin);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public boolean isReceiveNotify(String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        if (type != MessageRecordType.RECORD_TYPE_TROOP) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        return appInterface == null || ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(appInterface, uin) == GroupMsgMask.NOTIFY;
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
}
