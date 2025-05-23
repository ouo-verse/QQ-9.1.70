package com.tencent.mobileqq.zplan.resource.api.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.push.ZPlanProfileProcessor;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import dw4.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;
import qu4.h;
import qu4.j;
import qu4.m;
import qu4.t;
import r94.c;
import tv4.f;
import y84.d;
import zb3.FriendsDressUpData;
import zb3.FriendsRespData;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0016H\u0096\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/impl/ZPlanAvatarInfoHelperImpl;", "Lcom/tencent/mobileqq/zplan/resource/api/IZPlanAvatarInfoHelper;", "Lorg/json/JSONObject;", "fetchMyAvatarInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uin", "fetchOtherAvatarInfoCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOtherAvatarInfoWithUin", "", "byteValue", "getOtherAvatarInfoForLPlan", "", "friendUin", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/google/protobuf/nano/MessageNano;", "getSingleFriendZplanInfoReq", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "callback", "", "getSingleFriendZplanInfoRsp", "preloadUEAvatarSuitInfo", "<init>", "()V", "ZPlanAvatarInfoHelper", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarInfoHelperImpl implements IZPlanAvatarInfoHelper {
    private static final String TAG = "ZPlanAvatarInfoHelperImpl";
    private final /* synthetic */ Companion $$delegate_0 = INSTANCE;

    /* renamed from: ZPlanAvatarInfoHelper, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Map<String, b> mMemCache = new LinkedHashMap();
    private static final ArrayList<e<b>> dressInfoListener = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006J5\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0006J\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0006J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016J\u001e\u0010+\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\n\u0010-\u001a\u00020\u001a*\u00020,J\u0015\u0010.\u001a\u0004\u0018\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u001cJ\u001d\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0006J\u0015\u00100\u001a\u0004\u0018\u00010\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u001cJ\n\u00101\u001a\u00020\u0017*\u00020\u0007J\f\u00102\u001a\u0004\u0018\u00010\u0004*\u00020\u0007J\b\u00103\u001a\u00020\u0012H\u0016R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u00105R0\u00109\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070706j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000707`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R$\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/impl/ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper;", "Lcom/tencent/mobileqq/zplan/resource/api/IZPlanAvatarInfoHelper;", "", "uin", "Lqu4/a;", "fetchOtherAvatarInfoPbCacheWithUin", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldw4/b;", "getAvatarInfoCacheWithUin", "getAvatarInfoWithUin", "", "uins", "scene", "", "requestOthersDressInfo", "([Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromMemory", "rsp", "", "saveInMemory", "saveInMMKV", "readFromMMKV", "result", "", "cacheOtherDressInfo", "notifyAppearanceKeyChangeIfNeed", "Lorg/json/JSONObject;", "fetchMyAvatarInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOtherAvatarInfoWithUin", "fetchOtherAvatarInfoCache", "", "byteValue", "getOtherAvatarInfoForLPlan", "", "friendUin", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/google/protobuf/nano/MessageNano;", "getSingleFriendZplanInfoReq", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "callback", "getSingleFriendZplanInfoRsp", "Lqu4/t;", "toJson", "fetchMyAvatarInfoPb", "fetchOtherAvatarInfoPbWithUin", "getDressInfo", "isOk", "avatarCharacterByGender", "preloadUEAvatarSuitInfo", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lkotlin/collections/ArrayList;", "dressInfoListener", "Ljava/util/ArrayList;", "", "mMemCache", "Ljava/util/Map;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion implements IZPlanAvatarInfoHelper {

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/resource/api/impl/ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$a */
        /* loaded from: classes34.dex */
        public static final class a implements e<dw4.b> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Continuation<dw4.b> f335156d;

            /* JADX WARN: Multi-variable type inference failed */
            a(Continuation<? super dw4.b> continuation) {
                this.f335156d = continuation;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(dw4.b result) {
                Intrinsics.checkNotNullParameter(result, "result");
                try {
                    ZPlanAvatarInfoHelperImpl.dressInfoListener.remove(this);
                } catch (Exception e16) {
                    QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "getDressInfo onResultSuccess, remove error", e16);
                }
                this.f335156d.resumeWith(Result.m476constructorimpl(result));
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "getDressInfo fail. error:" + error + ", message:" + message);
                try {
                    ZPlanAvatarInfoHelperImpl.dressInfoListener.remove(this);
                } catch (Exception e16) {
                    QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "getDressInfo onResultFailure, remove error", e16);
                }
                this.f335156d.resumeWith(Result.m476constructorimpl(null));
            }
        }

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/resource/api/impl/ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$b", "Lak3/a;", "", "Ldw4/b;", "avatarInfos", "", "onSuccess", "", "errMsg", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$b */
        /* loaded from: classes34.dex */
        public static final class b implements ak3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation<List<dw4.b>> f335157a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String[] f335158b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f335159c;

            /* JADX WARN: Multi-variable type inference failed */
            b(Continuation<? super List<dw4.b>> continuation, String[] strArr, String str) {
                this.f335157a = continuation;
                this.f335158b = strArr;
                this.f335159c = str;
            }

            @Override // ak3.a
            public void onError(String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "requestOthersDressInfo failed, errMsg: " + errMsg);
                this.f335157a.resumeWith(Result.m476constructorimpl(null));
            }

            @Override // ak3.a
            public void onSuccess(List<dw4.b> avatarInfos) {
                Intrinsics.checkNotNullParameter(avatarInfos, "avatarInfos");
                if (avatarInfos.isEmpty()) {
                    QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "requestOthersDressInfo failed, callback info empty.");
                    this.f335157a.resumeWith(Result.m476constructorimpl(null));
                }
                String[] strArr = this.f335158b;
                String str = this.f335159c;
                int i3 = 0;
                for (Object obj : avatarInfos) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    dw4.b bVar = (dw4.b) obj;
                    if (strArr.length > i3) {
                        QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "requestOthersDressInfo scene=" + str + " hasChange=" + ZPlanAvatarInfoHelperImpl.INSTANCE.cacheOtherDressInfo(bVar, strArr[i3]) + " onResultSuccess dressKey=" + bVar.f395115b + " ");
                    }
                    i3 = i16;
                }
                QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "requestOthersDressInfo success.");
                this.f335157a.resumeWith(Result.m476constructorimpl(avatarInfos));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cacheOtherDressInfo(dw4.b result, String uin) {
            boolean z16;
            dw4.b readFromMemory = readFromMemory(uin);
            boolean z17 = true;
            if (readFromMemory != null) {
                h hVar = result.f395115b;
                Intrinsics.checkNotNullExpressionValue(hVar, "result.dressKey");
                if (g.d(hVar, readFromMemory.f395115b)) {
                    z16 = false;
                } else {
                    QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "refresh dressKey " + result.f395115b);
                    readFromMemory.f395115b = result.f395115b;
                    readFromMemory.f395118e = result.f395118e;
                    readFromMemory.f395117d = result.f395117d;
                    z16 = true;
                }
                if (readFromMemory.f395118e == null) {
                    QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "refresh femaleAvatarCharacter");
                    readFromMemory.f395118e = result.f395118e;
                    z16 = true;
                }
                if (readFromMemory.f395117d == null) {
                    QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "refresh maleAvatarCharacter");
                    readFromMemory.f395117d = result.f395117d;
                } else {
                    z17 = z16;
                }
                readFromMemory.f395121h = result.f395121h;
                readFromMemory.f395119f = result.f395119f;
                readFromMemory.f395122i = result.f395122i;
                readFromMemory.f395120g = result.f395120g;
                readFromMemory.f395116c = result.f395116c;
                readFromMemory.f395124k = result.f395124k;
                readFromMemory.f395114a = result.f395114a;
                readFromMemory.f395123j = result.f395123j;
                result = readFromMemory;
            }
            saveInMemory(result, uin);
            saveInMMKV(result, uin);
            if (z17) {
                notifyAppearanceKeyChangeIfNeed(result, uin);
            }
            return z17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object fetchOtherAvatarInfoPbCacheWithUin(String str, Continuation<? super qu4.a> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1;
            Object coroutine_suspended;
            int i3;
            Companion companion;
            dw4.b bVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.L$0 = this;
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.label = 1;
                        obj = getAvatarInfoCacheWithUin(str, zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else if (i3 == 1) {
                        companion = (Companion) zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (dw4.b) obj;
                    if (bVar == null) {
                        return companion.avatarCharacterByGender(bVar);
                    }
                    return null;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbCacheWithUin$1.label;
            if (i3 != 0) {
            }
            bVar = (dw4.b) obj2;
            if (bVar == null) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getAvatarInfoWithUin(String str, Continuation<? super dw4.b> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1;
            Object coroutine_suspended;
            int i3;
            List list;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1.label = i16 - Integer.MIN_VALUE;
                    ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12.label;
                    boolean z16 = true;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        }
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            List list2 = (List) obj;
                            list = list2;
                            if (list != null && !list.isEmpty()) {
                                z16 = false;
                            }
                            if (z16) {
                                return list2.get(0);
                            }
                            return null;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!(str == null || str.length() == 0) && !bb.f335811a.r(str)) {
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12.label = 2;
                        obj = requestOthersDressInfo$default(this, new String[]{str}, null, zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12, 2, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List list22 = (List) obj;
                        list = list22;
                        if (list != null) {
                            z16 = false;
                        }
                        if (z16) {
                        }
                    } else {
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12.label = 1;
                        obj = getDressInfo(zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$12);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1(this, continuation);
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$122 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$1;
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$122.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$getAvatarInfoWithUin$122.label;
            boolean z162 = true;
            if (i3 == 0) {
            }
        }

        private final void notifyAppearanceKeyChangeIfNeed(dw4.b result, String uin) {
            ZPlanProfileProcessor zPlanProfileProcessor;
            QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "notifyAppearanceKeyChangeIfNeed do notify");
            if (result.f395115b == null) {
                QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "notifyAppearanceKeyChangeIfNeed result.dressKey is null");
                return;
            }
            AppInterface c16 = bb.f335811a.c();
            if (c16 == null || (zPlanProfileProcessor = (ZPlanProfileProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(ZPlanProfileProcessor.class, c16)) == null) {
                return;
            }
            String str = result.f395115b.f429599c;
            Intrinsics.checkNotNullExpressionValue(str, "result.dressKey.dressKeyShort");
            ZPlanProfileProcessor.e(zPlanProfileProcessor, uin, str, false, 4, null);
            ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
            String str2 = result.f395115b.f429599c;
            Intrinsics.checkNotNullExpressionValue(str2, "result.dressKey.dressKeyShort");
            zplanDataRepository.G(uin, str2, result.f395123j, result.f395116c);
        }

        private final dw4.b readFromMMKV(String uin) {
            try {
                return dw4.b.d(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes("zplan_dresskey_" + uin, new byte[0]));
            } catch (Exception unused) {
                return null;
            }
        }

        private final dw4.b readFromMemory(String uin) {
            return (dw4.b) ZPlanAvatarInfoHelperImpl.mMemCache.get(uin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object requestOthersDressInfo(String[] strArr, String str, Continuation<? super List<dw4.b>> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "requestOthersDressInfo start");
            ak3.b.f26251a.c(strArr, new b(safeContinuation, strArr, str), str);
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        public final qu4.a avatarCharacterByGender(dw4.b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            int i3 = bVar.f395116c;
            if (i3 == 0) {
                AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
                Manager manager = qQAppInterface != null ? qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER) : null;
                FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
                Card t16 = friendsManager != null ? friendsManager.t(qQAppInterface.getCurrentAccountUin()) : null;
                if (t16 == null) {
                    QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "profileCard not be found in cache");
                } else {
                    QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "profileCard.shGender = " + ((int) t16.shGender));
                    short s16 = t16.shGender;
                    if (s16 == 0) {
                        i3 = 1;
                    } else if (s16 == 1) {
                        i3 = 2;
                    }
                }
            }
            if (i3 == 1) {
                qu4.a aVar = bVar.f395117d;
                if (aVar != null) {
                    return aVar;
                }
                QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "use maleDefaultAvatarCharacter.");
                return bVar.f395119f;
            }
            qu4.a aVar2 = bVar.f395118e;
            if (aVar2 != null) {
                return aVar2;
            }
            QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "use femaleDefaultAvatarCharacter");
            return bVar.f395120g;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object fetchMyAvatarInfo(Continuation<? super JSONObject> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1;
            Object coroutine_suspended;
            int i3;
            qu4.a aVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.label = 1;
                        obj = fetchMyAvatarInfoPb(zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (qu4.a) obj;
                    if (aVar == null) {
                        return c.h(aVar);
                    }
                    return null;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfo$1.label;
            if (i3 != 0) {
            }
            aVar = (qu4.a) obj2;
            if (aVar == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object fetchMyAvatarInfoPb(Continuation<? super qu4.a> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1;
            Object coroutine_suspended;
            int i3;
            Companion companion;
            dw4.b bVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.L$0 = this;
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.label = 1;
                        obj = getDressInfo(zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else if (i3 == 1) {
                        companion = (Companion) zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (dw4.b) obj;
                    if (bVar != null) {
                        return null;
                    }
                    qu4.a avatarCharacterByGender = companion.avatarCharacterByGender(bVar);
                    if (avatarCharacterByGender == null) {
                        QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "character is null");
                    }
                    return avatarCharacterByGender;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchMyAvatarInfoPb$1.label;
            if (i3 != 0) {
            }
            bVar = (dw4.b) obj2;
            if (bVar != null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object fetchOtherAvatarInfoCache(String str, Continuation<? super JSONObject> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1;
            Object coroutine_suspended;
            int i3;
            qu4.a aVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.label = 1;
                        obj = fetchOtherAvatarInfoPbCacheWithUin(str, zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (qu4.a) obj;
                    if (aVar == null) {
                        return c.h(aVar);
                    }
                    return null;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1.label;
            if (i3 != 0) {
            }
            aVar = (qu4.a) obj2;
            if (aVar == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object fetchOtherAvatarInfoPbWithUin(String str, Continuation<? super qu4.a> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1;
            Object coroutine_suspended;
            int i3;
            Companion companion;
            dw4.b bVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.L$0 = this;
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.label = 1;
                        obj = getAvatarInfoWithUin(str, zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else if (i3 == 1) {
                        companion = (Companion) zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (dw4.b) obj;
                    if (bVar == null) {
                        return companion.avatarCharacterByGender(bVar);
                    }
                    return null;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoPbWithUin$1.label;
            if (i3 != 0) {
            }
            bVar = (dw4.b) obj2;
            if (bVar == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object fetchOtherAvatarInfoWithUin(String str, Continuation<? super JSONObject> continuation) {
            ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1 zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1;
            Object coroutine_suspended;
            int i3;
            qu4.a aVar;
            if (continuation instanceof ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1) {
                zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1 = (ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1) continuation;
                int i16 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.label = 1;
                        obj = fetchOtherAvatarInfoPbWithUin(str, zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (qu4.a) obj;
                    if (aVar == null) {
                        return c.h(aVar);
                    }
                    return null;
                }
            }
            zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1 = new ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1(this, continuation);
            Object obj2 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = zPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoWithUin$1.label;
            if (i3 != 0) {
            }
            aVar = (qu4.a) obj2;
            if (aVar == null) {
            }
        }

        public final Object getDressInfo(Continuation<? super dw4.b> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            a aVar = new a(safeContinuation);
            ZPlanAvatarInfoHelperImpl.dressInfoListener.add(aVar);
            com.tencent.sqshow.dresskey.b.f369818a.k("filament_res_downloader", false, aVar);
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        public JSONObject getOtherAvatarInfoForLPlan(byte[] byteValue) {
            Intrinsics.checkNotNullParameter(byteValue, "byteValue");
            t zplanInfo = t.c(byteValue);
            Intrinsics.checkNotNullExpressionValue(zplanInfo, "zplanInfo");
            return toJson(zplanInfo);
        }

        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        public MessageNano getSingleFriendZplanInfoReq(long friendUin, AppRuntime appRuntime) {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            return d.f449567a.h(friendUin, appRuntime);
        }

        public final boolean isOk(dw4.b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            return (bVar.f395115b == null || bVar.f395117d == null || bVar.f395118e == null) ? false : true;
        }

        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        public void preloadUEAvatarSuitInfo() {
            ed3.a.f396118a.b();
        }

        public final JSONObject toJson(t tVar) {
            Intrinsics.checkNotNullParameter(tVar, "<this>");
            JSONObject jSONObject = new JSONObject();
            qu4.b avatarInfo = tVar.f429674a;
            if (avatarInfo != null) {
                Intrinsics.checkNotNullExpressionValue(avatarInfo, "avatarInfo");
                jSONObject.put("avatar_info", c.i(avatarInfo));
            }
            j faceInfoFemale = tVar.f429676c;
            if (faceInfoFemale != null) {
                if (tVar.f429679f == 2) {
                    Intrinsics.checkNotNullExpressionValue(faceInfoFemale, "faceInfoFemale");
                    jSONObject.put("face_info", c.n(faceInfoFemale));
                } else {
                    j faceInfoMale = tVar.f429675b;
                    Intrinsics.checkNotNullExpressionValue(faceInfoMale, "faceInfoMale");
                    jSONObject.put("face_info", c.n(faceInfoMale));
                }
            }
            m makeupInfo = tVar.f429677d;
            if (makeupInfo != null) {
                Intrinsics.checkNotNullExpressionValue(makeupInfo, "makeupInfo");
                jSONObject.put("makeup_info", c.q(makeupInfo));
            }
            qu4.c colorInfo = tVar.f429678e;
            if (colorInfo != null) {
                Intrinsics.checkNotNullExpressionValue(colorInfo, "colorInfo");
                jSONObject.put("color_info", c.j(colorInfo));
            }
            jSONObject.put("gender", tVar.f429679f);
            return jSONObject;
        }

        Companion() {
        }

        private final void saveInMMKV(dw4.b rsp, String uin) {
            QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "saveInDb");
            byte[] byteArray = MessageNano.toByteArray(rsp);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(rsp)");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBytesWithClean("zplan_dresskey_" + uin, byteArray, "zplan_dresskey_");
        }

        private final void saveInMemory(dw4.b rsp, String uin) {
            QLog.i(ZPlanAvatarInfoHelperImpl.TAG, 1, "saveInMemory");
            ZPlanAvatarInfoHelperImpl.mMemCache.put(uin, rsp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object getAvatarInfoCacheWithUin(String str, Continuation<? super dw4.b> continuation) {
            if (!(str == null || str.length() == 0) && !bb.f335811a.r(str)) {
                dw4.b readFromMemory = readFromMemory(str);
                if (readFromMemory != null && isOk(readFromMemory)) {
                    return readFromMemory;
                }
                dw4.b readFromMMKV = readFromMMKV(str);
                if (readFromMMKV == null || !isOk(readFromMMKV)) {
                    return null;
                }
                saveInMemory(readFromMMKV, str);
                return readFromMMKV;
            }
            return getDressInfo(continuation);
        }

        @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
        public void getSingleFriendZplanInfoRsp(byte[] byteValue, com.tencent.mobileqq.zootopia.d<FriendsRespData> callback) {
            List listOf;
            Intrinsics.checkNotNullParameter(byteValue, "byteValue");
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                f c16 = f.c(byteValue);
                tv4.b bVar = c16 != null ? c16.f437579a : null;
                tv4.a aVar = c16 != null ? c16.f437580b : null;
                if (bVar != null && aVar != null) {
                    long j3 = bVar.f437557a;
                    String str = bVar.f437558b;
                    Intrinsics.checkNotNullExpressionValue(str, "friendZPlanInfo.materialUrl");
                    String str2 = bVar.f437559c;
                    Intrinsics.checkNotNullExpressionValue(str2, "friendZPlanInfo.compressUrl");
                    String str3 = bVar.f437560d;
                    Intrinsics.checkNotNullExpressionValue(str3, "friendZPlanInfo.scheme");
                    String str4 = aVar.f437551b;
                    Intrinsics.checkNotNullExpressionValue(str4, "avatarAction.headMontagePath");
                    String str5 = aVar.f437552c;
                    Intrinsics.checkNotNullExpressionValue(str5, "avatarAction.bodyMontagePath");
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(new FriendsDressUpData(j3, str, str2, str3, str4, str5, aVar.f437553d, aVar.f437554e, aVar.f437555f));
                    long j16 = c16.f437581c;
                    String str6 = c16.f437582d;
                    Intrinsics.checkNotNullExpressionValue(str6, "rsp.svipFriendMaxVotesNotice");
                    callback.onResultSuccess(new FriendsRespData(0L, 0L, listOf, false, j16, str6));
                    return;
                }
                callback.onResultFailure(2000, "\u89e3\u6790\u8fd4\u56de\u6570\u636e\u5931\u8d25");
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e(ZPlanAvatarInfoHelperImpl.TAG, 1, "getSingleFriendZplanInfoRsp " + Unit.INSTANCE);
                callback.onResultFailure(-1, "parse pb info failed");
            }
        }

        static /* synthetic */ Object requestOthersDressInfo$default(Companion companion, String[] strArr, String str, Continuation continuation, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            return companion.requestOthersDressInfo(strArr, str, continuation);
        }
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public Object fetchMyAvatarInfo(Continuation<? super JSONObject> continuation) {
        return this.$$delegate_0.fetchMyAvatarInfo(continuation);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public Object fetchOtherAvatarInfoCache(String str, Continuation<? super JSONObject> continuation) {
        return this.$$delegate_0.fetchOtherAvatarInfoCache(str, continuation);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public Object fetchOtherAvatarInfoWithUin(String str, Continuation<? super JSONObject> continuation) {
        return this.$$delegate_0.fetchOtherAvatarInfoWithUin(str, continuation);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public JSONObject getOtherAvatarInfoForLPlan(byte[] byteValue) {
        Intrinsics.checkNotNullParameter(byteValue, "byteValue");
        return this.$$delegate_0.getOtherAvatarInfoForLPlan(byteValue);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public MessageNano getSingleFriendZplanInfoReq(long friendUin, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return this.$$delegate_0.getSingleFriendZplanInfoReq(friendUin, appRuntime);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public void getSingleFriendZplanInfoRsp(byte[] byteValue, com.tencent.mobileqq.zootopia.d<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(byteValue, "byteValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.getSingleFriendZplanInfoRsp(byteValue, callback);
    }

    @Override // com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper
    public void preloadUEAvatarSuitInfo() {
        this.$$delegate_0.preloadUEAvatarSuitInfo();
    }
}
