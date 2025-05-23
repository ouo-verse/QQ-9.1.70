package com.tencent.mobileqq.vas.message.processor;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.api.impl.VasSquareApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\bC\u0010DJO\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0002JW\u0010\u0016\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0002JZ\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000428\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\r0\u0018H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0002J2\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016J_\u0010-\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u00042#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\r\u0018\u00010\tH\u0016J(\u0010.\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016J\"\u00101\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J\u0018\u00103\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00102\u001a\u00020(H\u0016J,\u0010:\u001a\u00020\r2\u0006\u00105\u001a\u0002042\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010<R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010>R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vas/message/processor/SquareTempProcessor;", "Lcom/tencent/mobileqq/vas/message/processor/a;", "", "scene", "", "peerUin", "peerNickname", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uid", "", "cb", DomainData.DOMAIN_NAME, "peerUid", "", "sign", "myUid", "Lcom/tencent/qqnt/kernel/api/w;", "msgService", h.F, "myUin", "Lkotlin/Function2;", PreloadTRTCPlayerParams.KEY_SIG, "j", "limitNum", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "k", "uin", "chatType", "l", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/os/Bundle;", "bundle", "nickname", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/state/square/api/MessageRecordType;", "type", "isReceiveNotify", "success", "callback", "a", "openSettingsPage", "c", "includeUnNotifyMsg", "b", "messageRecordType", "getName", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "errorCode", "errorMsg", "onSendMsgError", "Lx13/e;", "Lx13/e;", "converter", "I", "lastAIOScene", "", "Ljava/util/Map;", "uid2UinMap", "<init>", "()V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareTempProcessor implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final x13.e converter = new x13.e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int lastAIOScene = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> uid2UinMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 cb5, String str, int i3, String str2) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("SquareTempProcessor", 2, "prepareTempChat: " + i3 + ", errMsg: " + str2);
        if (str == null) {
            str = "";
        }
        cb5.invoke(str);
    }

    private final void j(int scene, String myUin, String peerUin, final Function2<? super byte[], ? super String, Unit> cb5) {
        new VasSquareApiImpl().getSquareAioToken(scene, myUin, peerUin, new Function2<byte[], String, Unit>() { // from class: com.tencent.mobileqq.vas.message.processor.SquareTempProcessor$getAioSign$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, String str) {
                invoke2(bArr, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(byte[] bArr, String str) {
                if (bArr != null) {
                    cb5.invoke(bArr, str);
                }
            }
        });
    }

    private final List<SquareBaseMessageRecord> k(int limitNum) {
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
                if (l(String.valueOf(recentContactInfo.peerUin), recentContactInfo.chatType)) {
                    emptyList.add(obj);
                }
            }
        }
        if (limitNum > 0 && emptyList.size() > limitNum) {
            emptyList = emptyList.subList(0, limitNum);
        }
        List list = emptyList;
        x13.e eVar = this.converter;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(eVar.a((RecentContactInfo) it.next()));
        }
        QLog.i("SquareTempProcessor", 1, "getRecentTempList " + arrayList + ", size " + arrayList.size());
        return arrayList;
    }

    private final boolean l(String uin, int chatType) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(uin);
        return (isBlank ^ true) && chatType == 115;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(Fragment fragment, String uin, String uid, Bundle bundle, String nickname) {
        String uid2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        Intrinsics.checkNotNullExpressionValue(uid2, "uid");
        aVar.d(uid2);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        String str = nameWithConfig == null ? uin : nameWithConfig;
        bundle.putString("key_peerId", uid2);
        bundle.putInt("key_chat_type", 115);
        bundle.putString("key_chat_name", str);
        bundle.putBoolean("key_is_scale_chat", true);
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(fragment, uin, 10019, str, bundle, 2);
        QLog.i("SquareTempProcessor", 1, "openMiniMsgAio-openTempAio " + uin);
        return true;
    }

    private final void n(int scene, String peerUin, String peerNickname, boolean force, Function1<? super String, Unit> cb5) {
        w msgService;
        String currentUid;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null || (msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService()) == null || (currentUid = qQAppInterface.getCurrentUid()) == null) {
            return;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "mApp.currentUin");
        j(scene, currentUin, peerUin, new SquareTempProcessor$prepareTempChat$1(peerUin, force, this, peerNickname, currentUid, msgService, cb5));
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public SquareBaseMessageRecord b(String uin, boolean includeUnNotifyMsg, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = null;
        if (type != MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
            return null;
        }
        if (uin.length() == 0) {
            return null;
        }
        Iterator<T> it = k(-1).iterator();
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
        if (type != MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return k(limitNum);
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public String getName(String uin, MessageRecordType messageRecordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(messageRecordType, "messageRecordType");
        if (messageRecordType != MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
            return uin;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return uin;
        }
        try {
            String s16 = ac.s(qQAppInterface, uin, "", ac.w(10019), 3);
            return s16 == null ? uin : s16;
        } catch (Exception unused) {
            QLog.e("SquareTempProcessor", 1, "getName error " + uin);
            return uin;
        }
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public boolean isReceiveNotify(String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        MessageRecordType messageRecordType = MessageRecordType.RECORD_TYPE_NONE;
        return true;
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void openSettingsPage(final Fragment fragment, int scene, final String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        o(this, scene, uin, "", false, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.message.processor.SquareTempProcessor$openSettingsPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String uid) {
                Map map;
                Intrinsics.checkNotNullParameter(uid, "uid");
                map = SquareTempProcessor.this.uid2UinMap;
                map.put(uid, uin);
                Intent intent = new Intent();
                intent.putExtra("uin", uin);
                intent.putExtra("KEY_UID", uid);
                intent.putExtra("uintype", 10019);
                intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
                FragmentActivity activity = fragment.getActivity();
                if (activity != null) {
                    QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
                }
            }
        }, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final String peerUid, String peerNickname, byte[] sign, String myUid, w msgService, final Function1<? super String, Unit> cb5) {
        String str = peerNickname;
        QLog.i("SquareTempProcessor", 1, "prepareTempChat doPrepareTempChat: " + peerUid + ", " + peerNickname + ", " + sign + ", " + myUid);
        if (str == null) {
            str = "";
        }
        msgService.prepareTempChat(new TempChatPrepareInfo(115, peerUid, str, "", sign, myUid, "", new TempChatGameSession()), new IOperateCallback() { // from class: com.tencent.mobileqq.vas.message.processor.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                SquareTempProcessor.i(Function1.this, peerUid, i3, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void a(final Fragment fragment, int scene, final String uin, MessageRecordType type, final Bundle bundle, final String nickname, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.lastAIOScene = scene;
        if (type == MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
            o(this, scene, uin, nickname, false, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.message.processor.SquareTempProcessor$openMiniMsgAio$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String uid) {
                    Map map;
                    boolean m3;
                    Intrinsics.checkNotNullParameter(uid, "uid");
                    map = SquareTempProcessor.this.uid2UinMap;
                    map.put(uid, uin);
                    ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(uin, uid);
                    m3 = SquareTempProcessor.this.m(fragment, uin, uid, bundle, nickname);
                    Function1<Boolean, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf(m3));
                    }
                }
            }, 8, null);
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.vas.message.processor.a
    public void onSendMsgError(long msgId, Contact peer, int errorCode, String errorMsg) {
        Object orDefault;
        if (errorCode == 48) {
            Map<String, String> map = this.uid2UinMap;
            String str = peer != null ? peer.peerUid : null;
            Intrinsics.checkNotNull(str);
            orDefault = map.getOrDefault(str, "");
            n(this.lastAIOScene, (String) orDefault, "", true, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.message.processor.SquareTempProcessor$onSendMsgError$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    static /* synthetic */ void o(SquareTempProcessor squareTempProcessor, int i3, String str, String str2, boolean z16, Function1 function1, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        squareTempProcessor.n(i3, str, str2, z16, function1);
    }
}
