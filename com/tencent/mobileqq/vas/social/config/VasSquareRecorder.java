package com.tencent.mobileqq.vas.social.config;

import com.tencent.filament.zplan.record.SquareFilamentNativeAppRecorder;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SwitchKey;
import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.avatar.filament.FilamentReportHelper;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.SquareActionHelper;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.MemeResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J3\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00110\u001fH\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018H\u0017J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/VasSquareRecorder;", "Lcom/tencent/state/square/IZPlanRecorder;", "Lcom/tencent/state/square/data/Resource;", "resource", "Lcom/tencent/state/square/record/RecordIdentifier;", "recordIdentifier", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "d", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/record/RecordIdentifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/state/square/record/UserIdentifier;", "userIdentifiers", "Lcom/tencent/state/square/data/DressKeys;", "c", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "callback", "", "addRecordDoneCallback", "", "uin", "getCacheUserDressKey", "Lcom/tencent/state/square/data/AvatarAction;", "action", "", "forceCallback", "needAddToHead", "recordAvatarActions", "(Lcom/tencent/state/square/data/AvatarAction;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeRecordDoneCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "dressKey", "requestUserDressKey", "Lcom/tencent/zplan/meme/action/MemeAction;", "useSticker", "simpleRecordAction", "localPath", "isMp4FileValid", "canCodecReUse", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasSquareRecorder implements IZPlanRecorder {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310696a;

        static {
            int[] iArr = new int[RecordType.values().length];
            try {
                iArr[RecordType.MP4_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordType.FILAMENT_SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordType.FILAMENT_NEARBY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f310696a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/social/config/VasSquareRecorder$c", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f310697a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f310698b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super Boolean, ? super String, Unit> function2, String str) {
            this.f310697a = function2;
            this.f310698b = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        
            if ((r0.length() > 0) != false) goto L30;
         */
        @Override // com.tencent.mobileqq.zplan.servlet.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean success, Object result) {
            int i3;
            String str;
            Map map = result instanceof Map ? (Map) result : null;
            String str2 = "";
            if (map == null) {
                this.f310697a.invoke(Boolean.FALSE, "");
                return;
            }
            ZPlanUserInfo zPlanUserInfo = (ZPlanUserInfo) map.get(this.f310698b);
            if (zPlanUserInfo != null && (str = zPlanUserInfo.appearanceKey) != null) {
                str2 = str;
            }
            ZPlanUserInfo zPlanUserInfo2 = (ZPlanUserInfo) map.get(this.f310698b);
            boolean z16 = true;
            if (zPlanUserInfo2 == null || (i3 = zPlanUserInfo2.gender) == 0) {
                i3 = 1;
            }
            ZplanDataRepository.f334898a.I(this.f310698b, i3);
            Function2<Boolean, String, Unit> function2 = this.f310697a;
            if (success) {
            }
            z16 = false;
            function2.invoke(Boolean.valueOf(z16), str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(List<UserIdentifier> list, Continuation<? super DressKeys> continuation) {
        VasSquareRecorder$loadDressKeys$1 vasSquareRecorder$loadDressKeys$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Deferred async$default;
        Object firstOrNull;
        String str;
        Object orNull;
        if (continuation instanceof VasSquareRecorder$loadDressKeys$1) {
            vasSquareRecorder$loadDressKeys$1 = (VasSquareRecorder$loadDressKeys$1) continuation;
            int i16 = vasSquareRecorder$loadDressKeys$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasSquareRecorder$loadDressKeys$1.label = i16 - Integer.MIN_VALUE;
                Object obj = vasSquareRecorder$loadDressKeys$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasSquareRecorder$loadDressKeys$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<UserIdentifier> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VasSquareRecorder$loadDressKeys$deferredList$1$1((UserIdentifier) it.next(), null), 3, null);
                        arrayList.add(async$default);
                    }
                    vasSquareRecorder$loadDressKeys$1.label = 1;
                    obj = AwaitKt.awaitAll(arrayList, vasSquareRecorder$loadDressKeys$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List list3 = (List) obj;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
                str = (String) firstOrNull;
                if (str == null) {
                    str = "";
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(list3, 1);
                String str2 = (String) orNull;
                return new DressKeys(str, str2 != null ? str2 : "");
            }
        }
        vasSquareRecorder$loadDressKeys$1 = new VasSquareRecorder$loadDressKeys$1(this, continuation);
        Object obj2 = vasSquareRecorder$loadDressKeys$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasSquareRecorder$loadDressKeys$1.label;
        if (i3 != 0) {
        }
        List list32 = (List) obj2;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list32);
        str = (String) firstOrNull;
        if (str == null) {
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(list32, 1);
        String str22 = (String) orNull;
        return new DressKeys(str, str22 != null ? str22 : "");
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void addRecordDoneCallback(RecordSuccessListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).addRecordDoneListener(callback);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public boolean canCodecReUse() {
        return ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().b();
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public String getCacheUserDressKey(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZplanDataRepository.l(ZplanDataRepository.f334898a, uin, false, 2, null).appearanceKey;
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public boolean isMp4FileValid(String localPath) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.state.square.IZPlanRecorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object recordAvatarActions(AvatarAction avatarAction, RecordIdentifier recordIdentifier, boolean z16, boolean z17, Continuation<? super Boolean> continuation) {
        VasSquareRecorder$recordAvatarActions$1 vasSquareRecorder$recordAvatarActions$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        VasSquareRecorder vasSquareRecorder;
        boolean z18;
        if (continuation instanceof VasSquareRecorder$recordAvatarActions$1) {
            vasSquareRecorder$recordAvatarActions$1 = (VasSquareRecorder$recordAvatarActions$1) continuation;
            int i16 = vasSquareRecorder$recordAvatarActions$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasSquareRecorder$recordAvatarActions$1.label = i16 - Integer.MIN_VALUE;
                obj = vasSquareRecorder$recordAvatarActions$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasSquareRecorder$recordAvatarActions$1.label;
                boolean z19 = true;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("VasSquareRecorder", 1, "recordAvatarActions action:" + avatarAction);
                    Resource lookFront = avatarAction.getLookFront();
                    vasSquareRecorder$recordAvatarActions$1.L$0 = this;
                    vasSquareRecorder$recordAvatarActions$1.L$1 = avatarAction;
                    vasSquareRecorder$recordAvatarActions$1.L$2 = recordIdentifier;
                    vasSquareRecorder$recordAvatarActions$1.Z$0 = z16;
                    vasSquareRecorder$recordAvatarActions$1.Z$1 = z17;
                    vasSquareRecorder$recordAvatarActions$1.label = 1;
                    obj = recordAvatarActions(lookFront, recordIdentifier, z16, z17, vasSquareRecorder$recordAvatarActions$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vasSquareRecorder = this;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z18 = vasSquareRecorder$recordAvatarActions$1.Z$0;
                        ResultKt.throwOnFailure(obj);
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!z18 && !booleanValue) {
                            z19 = false;
                        }
                        return Boxing.boxBoolean(z19);
                    }
                    z17 = vasSquareRecorder$recordAvatarActions$1.Z$1;
                    z16 = vasSquareRecorder$recordAvatarActions$1.Z$0;
                    recordIdentifier = (RecordIdentifier) vasSquareRecorder$recordAvatarActions$1.L$2;
                    avatarAction = (AvatarAction) vasSquareRecorder$recordAvatarActions$1.L$1;
                    vasSquareRecorder = (VasSquareRecorder) vasSquareRecorder$recordAvatarActions$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                RecordIdentifier recordIdentifier2 = recordIdentifier;
                boolean z26 = z16;
                boolean z27 = z17;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                Resource unread = avatarAction.getUnread();
                vasSquareRecorder$recordAvatarActions$1.L$0 = null;
                vasSquareRecorder$recordAvatarActions$1.L$1 = null;
                vasSquareRecorder$recordAvatarActions$1.L$2 = null;
                vasSquareRecorder$recordAvatarActions$1.Z$0 = booleanValue2;
                vasSquareRecorder$recordAvatarActions$1.label = 2;
                obj = vasSquareRecorder.recordAvatarActions(unread, recordIdentifier2, z26, z27, vasSquareRecorder$recordAvatarActions$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                z18 = booleanValue2;
                boolean booleanValue3 = ((Boolean) obj).booleanValue();
                if (!z18) {
                    z19 = false;
                }
                return Boxing.boxBoolean(z19);
            }
        }
        vasSquareRecorder$recordAvatarActions$1 = new VasSquareRecorder$recordAvatarActions$1(this, continuation);
        obj = vasSquareRecorder$recordAvatarActions$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasSquareRecorder$recordAvatarActions$1.label;
        boolean z192 = true;
        if (i3 != 0) {
        }
        RecordIdentifier recordIdentifier22 = recordIdentifier;
        boolean z262 = z16;
        boolean z272 = z17;
        boolean booleanValue22 = ((Boolean) obj).booleanValue();
        Resource unread2 = avatarAction.getUnread();
        vasSquareRecorder$recordAvatarActions$1.L$0 = null;
        vasSquareRecorder$recordAvatarActions$1.L$1 = null;
        vasSquareRecorder$recordAvatarActions$1.L$2 = null;
        vasSquareRecorder$recordAvatarActions$1.Z$0 = booleanValue22;
        vasSquareRecorder$recordAvatarActions$1.label = 2;
        obj = vasSquareRecorder.recordAvatarActions(unread2, recordIdentifier22, z262, z272, vasSquareRecorder$recordAvatarActions$1);
        if (obj != coroutine_suspended) {
        }
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void removeRecordDoneCallback(RecordSuccessListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).removeRecordDoneListener(callback);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void requestUserDressKey(String uin, Function2<? super Boolean, ? super String, Unit> callback) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
        zplanDataRepository.w(listOf, new c(callback, uin));
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    @Deprecated(message = "just for test")
    public void simpleRecordAction(MemeAction action, boolean useSticker) {
        Intrinsics.checkNotNullParameter(action, "action");
        SocialActionRecordHelper.f310651d.E(action, useSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017c A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:12:0x003f, B:14:0x010f, B:15:0x0111, B:18:0x0131, B:21:0x013c, B:24:0x0176, B:26:0x017c, B:27:0x0182, B:33:0x005b, B:35:0x00f1, B:55:0x00c8, B:57:0x00d0, B:60:0x00f4), top: B:7:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(Resource resource, RecordIdentifier recordIdentifier, Continuation<? super SquareAvatarData> continuation) {
        VasSquareRecorder$loadSceneRecordParams$1 vasSquareRecorder$loadSceneRecordParams$1;
        Object coroutine_suspended;
        int i3;
        long parseLong;
        Long boxLong;
        Object loadPlayParams;
        Object loadMotionPlayParams;
        String uin;
        Triple triple;
        SquareAvatarData squareAvatarData;
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics;
        SquareAvatarData.AvatarData host;
        Resource resource2 = resource;
        try {
            if (continuation instanceof VasSquareRecorder$loadSceneRecordParams$1) {
                vasSquareRecorder$loadSceneRecordParams$1 = (VasSquareRecorder$loadSceneRecordParams$1) continuation;
                int i16 = vasSquareRecorder$loadSceneRecordParams$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    vasSquareRecorder$loadSceneRecordParams$1.label = i16 - Integer.MIN_VALUE;
                    VasSquareRecorder$loadSceneRecordParams$1 vasSquareRecorder$loadSceneRecordParams$12 = vasSquareRecorder$loadSceneRecordParams$1;
                    Object obj = vasSquareRecorder$loadSceneRecordParams$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = vasSquareRecorder$loadSceneRecordParams$12.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!(SquareBaseKt.getSquareCommon().enableZPlanFilamentBase() && SquareBaseKt.getSquareCommon().isSwitchOn(SwitchKey.filamentEnable, false))) {
                            QLog.i("VasSquareRecorder", 1, "loadSceneRecordParams filament is not enabled");
                            return null;
                        }
                        if (resource.getFilament().getUrl().length() == 0) {
                            QLog.i("VasSquareRecorder", 1, "loadSceneRecordParams filamentUrl is empty");
                            return null;
                        }
                        parseLong = Long.parseLong(recordIdentifier.getSender().getUin());
                        UserIdentifier receiver = recordIdentifier.getReceiver();
                        boxLong = (receiver == null || (uin = receiver.getUin()) == null) ? null : Boxing.boxLong(Long.parseLong(uin));
                        if (recordIdentifier.getType() == RecordType.FILAMENT_NEARBY) {
                            IAvatarService iAvatarService = (IAvatarService) QRoute.api(IAvatarService.class);
                            String url = resource.getFilament().getUrl();
                            vasSquareRecorder$loadSceneRecordParams$12.L$0 = resource2;
                            vasSquareRecorder$loadSceneRecordParams$12.L$1 = boxLong;
                            vasSquareRecorder$loadSceneRecordParams$12.J$0 = parseLong;
                            vasSquareRecorder$loadSceneRecordParams$12.label = 1;
                            loadMotionPlayParams = iAvatarService.loadMotionPlayParams(parseLong, boxLong, url, vasSquareRecorder$loadSceneRecordParams$12);
                            if (loadMotionPlayParams == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            triple = (Triple) loadMotionPlayParams;
                        } else {
                            SquareActionHelper squareActionHelper = SquareActionHelper.INSTANCE;
                            String url2 = resource.getFilament().getUrl();
                            vasSquareRecorder$loadSceneRecordParams$12.L$0 = resource2;
                            vasSquareRecorder$loadSceneRecordParams$12.L$1 = boxLong;
                            vasSquareRecorder$loadSceneRecordParams$12.J$0 = parseLong;
                            vasSquareRecorder$loadSceneRecordParams$12.label = 2;
                            loadPlayParams = squareActionHelper.loadPlayParams(parseLong, boxLong, url2, vasSquareRecorder$loadSceneRecordParams$12);
                            if (loadPlayParams == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            triple = (Triple) loadPlayParams;
                        }
                    } else if (i3 == 1) {
                        long j3 = vasSquareRecorder$loadSceneRecordParams$12.J$0;
                        Long l3 = (Long) vasSquareRecorder$loadSceneRecordParams$12.L$1;
                        Resource resource3 = (Resource) vasSquareRecorder$loadSceneRecordParams$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        parseLong = j3;
                        loadMotionPlayParams = obj;
                        boxLong = l3;
                        resource2 = resource3;
                        triple = (Triple) loadMotionPlayParams;
                    } else if (i3 == 2) {
                        long j16 = vasSquareRecorder$loadSceneRecordParams$12.J$0;
                        Long l16 = (Long) vasSquareRecorder$loadSceneRecordParams$12.L$1;
                        Resource resource4 = (Resource) vasSquareRecorder$loadSceneRecordParams$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        parseLong = j16;
                        loadPlayParams = obj;
                        boxLong = l16;
                        resource2 = resource4;
                        triple = (Triple) loadPlayParams;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    squareAvatarData = (SquareAvatarData) triple.component2();
                    loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) triple.component3();
                    host = squareAvatarData.getHost();
                    SquareAvatarData.AvatarData guest = squareAvatarData.getGuest();
                    if (host.getAvatarInfoStr().length() > 2 && (guest == null || guest.getAvatarInfoStr().length() > 2)) {
                        QLog.i("VasSquareRecorder", 1, "loadSceneRecordParams hostUin=" + parseLong + ", guestUin=" + boxLong + ", url=" + resource2.getFilament().getUrl() + " statistics:" + loadFilamentAssetsStatistics);
                        return squareAvatarData;
                    }
                    QLog.e("VasSquareRecorder", 1, "failed to load user avatar info: host=[" + host.getAvatarInfoStr() + "], guest=[" + (guest == null ? guest.getAvatarInfoStr() : null) + "]");
                    return null;
                }
            }
            if (i3 != 0) {
            }
            squareAvatarData = (SquareAvatarData) triple.component2();
            loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) triple.component3();
            host = squareAvatarData.getHost();
            SquareAvatarData.AvatarData guest2 = squareAvatarData.getGuest();
            if (host.getAvatarInfoStr().length() > 2) {
                QLog.i("VasSquareRecorder", 1, "loadSceneRecordParams hostUin=" + parseLong + ", guestUin=" + boxLong + ", url=" + resource2.getFilament().getUrl() + " statistics:" + loadFilamentAssetsStatistics);
                return squareAvatarData;
            }
            if (guest2 == null) {
            }
            QLog.e("VasSquareRecorder", 1, "failed to load user avatar info: host=[" + host.getAvatarInfoStr() + "], guest=[" + (guest2 == null ? guest2.getAvatarInfoStr() : null) + "]");
            return null;
        } catch (Exception e16) {
            QLog.e("VasSquareRecorder", 1, "loadSceneRecordParams error:" + e16);
            return null;
        }
        vasSquareRecorder$loadSceneRecordParams$1 = new VasSquareRecorder$loadSceneRecordParams$1(this, continuation);
        VasSquareRecorder$loadSceneRecordParams$1 vasSquareRecorder$loadSceneRecordParams$122 = vasSquareRecorder$loadSceneRecordParams$1;
        Object obj2 = vasSquareRecorder$loadSceneRecordParams$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasSquareRecorder$loadSceneRecordParams$122.label;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x023c, code lost:
    
        if ((r4.getDynamic().getUrl().length() == 0) != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0244 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c6  */
    @Override // com.tencent.state.square.IZPlanRecorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object recordAvatarActions(Resource resource, RecordIdentifier recordIdentifier, boolean z16, boolean z17, Continuation<? super Boolean> continuation) {
        VasSquareRecorder$recordAvatarActions$2 vasSquareRecorder$recordAvatarActions$2;
        Object coroutine_suspended;
        int i3;
        List<UserIdentifier> listOfNotNull;
        boolean z18;
        VasSquareRecorder vasSquareRecorder;
        Resource resource2;
        boolean z19;
        Object d16;
        boolean z26;
        DressKeys dressKeys;
        boolean z27;
        Resource resource3;
        RecordIdentifier recordIdentifier2;
        SquareAvatarData squareAvatarData;
        EngineType.Filament filament;
        AvatarCharacterInfo avatarCharacterInfo;
        AvatarCharacterInfo avatarCharacterInfo2;
        String recordPath;
        boolean z28;
        boolean z29;
        int i16;
        boolean z36;
        boolean isBlank;
        MemeResult.Cover cover;
        boolean isBlank2;
        SquareAvatarData.AvatarData guest;
        String avatarInfoStr;
        AvatarCharacterInfo avatarCharacterInfo3;
        JSONObject b16;
        gx4.a a16;
        SquareAvatarData.AvatarData host;
        String avatarInfoStr2;
        AvatarCharacterInfo avatarCharacterInfo4;
        JSONObject b17;
        gx4.a a17;
        RecordIdentifier recordIdentifier3 = recordIdentifier;
        if (continuation instanceof VasSquareRecorder$recordAvatarActions$2) {
            vasSquareRecorder$recordAvatarActions$2 = (VasSquareRecorder$recordAvatarActions$2) continuation;
            int i17 = vasSquareRecorder$recordAvatarActions$2.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                vasSquareRecorder$recordAvatarActions$2.label = i17 - Integer.MIN_VALUE;
                Object obj = vasSquareRecorder$recordAvatarActions$2.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasSquareRecorder$recordAvatarActions$2.label;
                boolean z37 = false;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("VasSquareRecorder", 1, "recordAvatarActions identifier=" + recordIdentifier3 + ", resource:" + resource);
                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new UserIdentifier[]{recordIdentifier.getSender(), recordIdentifier.getReceiver()});
                    vasSquareRecorder$recordAvatarActions$2.L$0 = this;
                    vasSquareRecorder$recordAvatarActions$2.L$1 = resource;
                    vasSquareRecorder$recordAvatarActions$2.L$2 = recordIdentifier3;
                    z18 = z16;
                    vasSquareRecorder$recordAvatarActions$2.Z$0 = z18;
                    vasSquareRecorder$recordAvatarActions$2.Z$1 = z17;
                    vasSquareRecorder$recordAvatarActions$2.label = 1;
                    obj = c(listOfNotNull, vasSquareRecorder$recordAvatarActions$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vasSquareRecorder = this;
                    resource2 = resource;
                    z19 = z17;
                } else if (i3 == 1) {
                    z19 = vasSquareRecorder$recordAvatarActions$2.Z$1;
                    boolean z38 = vasSquareRecorder$recordAvatarActions$2.Z$0;
                    RecordIdentifier recordIdentifier4 = (RecordIdentifier) vasSquareRecorder$recordAvatarActions$2.L$2;
                    resource2 = (Resource) vasSquareRecorder$recordAvatarActions$2.L$1;
                    vasSquareRecorder = (VasSquareRecorder) vasSquareRecorder$recordAvatarActions$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    z18 = z38;
                    recordIdentifier3 = recordIdentifier4;
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z39 = vasSquareRecorder$recordAvatarActions$2.Z$1;
                    boolean z46 = vasSquareRecorder$recordAvatarActions$2.Z$0;
                    DressKeys dressKeys2 = (DressKeys) vasSquareRecorder$recordAvatarActions$2.L$2;
                    recordIdentifier2 = (RecordIdentifier) vasSquareRecorder$recordAvatarActions$2.L$1;
                    resource3 = (Resource) vasSquareRecorder$recordAvatarActions$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    z26 = z39;
                    z27 = z46;
                    dressKeys = dressKeys2;
                    squareAvatarData = (SquareAvatarData) obj;
                    String str = null;
                    if (squareAvatarData == null) {
                        QLog.i("VasSquareRecorder", 1, "recordAvatarActions use Filament, sceneRecordParams:" + squareAvatarData);
                        filament = new EngineType.Filament(SquareFilamentNativeAppRecorder.class);
                    } else {
                        QLog.i("VasSquareRecorder", 1, "recordAvatarActions use UE");
                        filament = null;
                    }
                    com.tencent.mobileqq.vas.data.a aVar = new com.tencent.mobileqq.vas.data.a(resource3.getActionId(), resource3.getRecordSize().getWidth(), resource3.getRecordSize().getHeight(), resource3.getActionStyle(), recordIdentifier2.getType().toRecordMode());
                    String json = squareAvatarData == null ? squareAvatarData.toJson() : null;
                    FilamentResource filament2 = resource3.getFilament();
                    if (squareAvatarData != null || (host = squareAvatarData.getHost()) == null || (avatarInfoStr2 = host.getAvatarInfoStr()) == null) {
                        avatarCharacterInfo = null;
                    } else {
                        try {
                            b17 = com.tencent.zplan.common.utils.h.f385294a.b(avatarInfoStr2);
                        } catch (Exception unused) {
                        }
                        if (b17 != null && (a17 = fx4.a.a(b17)) != null) {
                            avatarCharacterInfo4 = new AvatarCharacterInfo(a17, dressKeys.getOwner());
                            avatarCharacterInfo = avatarCharacterInfo4;
                        }
                        avatarCharacterInfo4 = null;
                        avatarCharacterInfo = avatarCharacterInfo4;
                    }
                    if (squareAvatarData != null || (guest = squareAvatarData.getGuest()) == null || (avatarInfoStr = guest.getAvatarInfoStr()) == null) {
                        avatarCharacterInfo2 = null;
                    } else {
                        try {
                            b16 = com.tencent.zplan.common.utils.h.f385294a.b(avatarInfoStr);
                        } catch (Exception unused2) {
                        }
                        if (b16 != null && (a16 = fx4.a.a(b16)) != null) {
                            avatarCharacterInfo3 = new AvatarCharacterInfo(a16, dressKeys.getOther());
                            avatarCharacterInfo2 = avatarCharacterInfo3;
                        }
                        avatarCharacterInfo3 = null;
                        avatarCharacterInfo2 = avatarCharacterInfo3;
                    }
                    com.tencent.mobileqq.vas.data.b bVar = new com.tencent.mobileqq.vas.data.b(aVar, recordIdentifier2, dressKeys, 0L, z27, z26, filament, json, filament2, avatarCharacterInfo, avatarCharacterInfo2, 8, null);
                    SocialActionRecordHelper socialActionRecordHelper = SocialActionRecordHelper.f310651d;
                    MemeResult o16 = socialActionRecordHelper.o(bVar);
                    recordPath = o16 == null ? o16.getRecordPath() : null;
                    if (recordPath != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(recordPath);
                        if (!isBlank2) {
                            z28 = false;
                            if (!z28) {
                                if (o16 != null && (cover = o16.getCover()) != null) {
                                    str = cover.getPath();
                                }
                                if (str != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                    if (!isBlank) {
                                        z36 = false;
                                        if (!z36) {
                                            z29 = true;
                                            i16 = b.f310696a[recordIdentifier2.getType().ordinal()];
                                            if (i16 != 1) {
                                                if (!resource3.getIsDefault()) {
                                                }
                                                socialActionRecordHelper.F(bVar);
                                                z37 = true;
                                                if (squareAvatarData != null) {
                                                }
                                                QLog.i("VasSquareRecorder", 1, "recordAvatarActions recordStarted:" + z37);
                                                return Boxing.boxBoolean(z37);
                                            }
                                            if (i16 == 2) {
                                                if (!resource3.getFilament().isRecordCoverCorrect()) {
                                                    socialActionRecordHelper.F(bVar);
                                                    z37 = true;
                                                }
                                                if (squareAvatarData != null) {
                                                    FilamentReportHelper.INSTANCE.markUsedFilament();
                                                }
                                                QLog.i("VasSquareRecorder", 1, "recordAvatarActions recordStarted:" + z37);
                                                return Boxing.boxBoolean(z37);
                                            }
                                            if (i16 == 3) {
                                                if (squareAvatarData == null) {
                                                    QLog.e("VasSquareRecorder", 1, "recordAvatarActions FILAMENT_NEARBY sceneRecordParams is not null");
                                                    return Boxing.boxBoolean(false);
                                                }
                                                socialActionRecordHelper.F(bVar);
                                                z37 = true;
                                            }
                                            if (squareAvatarData != null && !z29 && z37) {
                                                FilamentReportHelper.INSTANCE.markUsedFilament();
                                            }
                                            QLog.i("VasSquareRecorder", 1, "recordAvatarActions recordStarted:" + z37);
                                            return Boxing.boxBoolean(z37);
                                        }
                                    }
                                }
                                z36 = true;
                                if (!z36) {
                                }
                            }
                            z29 = false;
                            i16 = b.f310696a[recordIdentifier2.getType().ordinal()];
                            if (i16 != 1) {
                            }
                        }
                    }
                    z28 = true;
                    if (!z28) {
                    }
                    z29 = false;
                    i16 = b.f310696a[recordIdentifier2.getType().ordinal()];
                    if (i16 != 1) {
                    }
                }
                DressKeys dressKeys3 = (DressKeys) obj;
                QLog.i("VasSquareRecorder", 1, "recordAvatarActions dressKeys:" + dressKeys3);
                vasSquareRecorder$recordAvatarActions$2.L$0 = resource2;
                vasSquareRecorder$recordAvatarActions$2.L$1 = recordIdentifier3;
                vasSquareRecorder$recordAvatarActions$2.L$2 = dressKeys3;
                vasSquareRecorder$recordAvatarActions$2.Z$0 = z18;
                vasSquareRecorder$recordAvatarActions$2.Z$1 = z19;
                vasSquareRecorder$recordAvatarActions$2.label = 2;
                d16 = vasSquareRecorder.d(resource2, recordIdentifier3, vasSquareRecorder$recordAvatarActions$2);
                if (d16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                z26 = z19;
                dressKeys = dressKeys3;
                obj = d16;
                z27 = z18;
                resource3 = resource2;
                recordIdentifier2 = recordIdentifier3;
                squareAvatarData = (SquareAvatarData) obj;
                String str2 = null;
                if (squareAvatarData == null) {
                }
                com.tencent.mobileqq.vas.data.a aVar2 = new com.tencent.mobileqq.vas.data.a(resource3.getActionId(), resource3.getRecordSize().getWidth(), resource3.getRecordSize().getHeight(), resource3.getActionStyle(), recordIdentifier2.getType().toRecordMode());
                if (squareAvatarData == null) {
                }
                FilamentResource filament22 = resource3.getFilament();
                if (squareAvatarData != null) {
                }
                avatarCharacterInfo = null;
                if (squareAvatarData != null) {
                }
                avatarCharacterInfo2 = null;
                com.tencent.mobileqq.vas.data.b bVar2 = new com.tencent.mobileqq.vas.data.b(aVar2, recordIdentifier2, dressKeys, 0L, z27, z26, filament, json, filament22, avatarCharacterInfo, avatarCharacterInfo2, 8, null);
                SocialActionRecordHelper socialActionRecordHelper2 = SocialActionRecordHelper.f310651d;
                MemeResult o162 = socialActionRecordHelper2.o(bVar2);
                if (o162 == null) {
                }
                if (recordPath != null) {
                }
                z28 = true;
                if (!z28) {
                }
                z29 = false;
                i16 = b.f310696a[recordIdentifier2.getType().ordinal()];
                if (i16 != 1) {
                }
            }
        }
        vasSquareRecorder$recordAvatarActions$2 = new VasSquareRecorder$recordAvatarActions$2(this, continuation);
        Object obj2 = vasSquareRecorder$recordAvatarActions$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasSquareRecorder$recordAvatarActions$2.label;
        boolean z372 = false;
        if (i3 != 0) {
        }
        DressKeys dressKeys32 = (DressKeys) obj2;
        QLog.i("VasSquareRecorder", 1, "recordAvatarActions dressKeys:" + dressKeys32);
        vasSquareRecorder$recordAvatarActions$2.L$0 = resource2;
        vasSquareRecorder$recordAvatarActions$2.L$1 = recordIdentifier3;
        vasSquareRecorder$recordAvatarActions$2.L$2 = dressKeys32;
        vasSquareRecorder$recordAvatarActions$2.Z$0 = z18;
        vasSquareRecorder$recordAvatarActions$2.Z$1 = z19;
        vasSquareRecorder$recordAvatarActions$2.label = 2;
        d16 = vasSquareRecorder.d(resource2, recordIdentifier3, vasSquareRecorder$recordAvatarActions$2);
        if (d16 != coroutine_suspended) {
        }
    }
}
