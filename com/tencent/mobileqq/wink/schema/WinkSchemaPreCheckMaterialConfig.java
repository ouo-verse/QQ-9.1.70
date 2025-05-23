package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckDataServiceHandler;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J?\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckMaterialConfig;", "", "", "jumpTarget", "Ljava/util/concurrent/ConcurrentHashMap;", "keyAttrs", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "", "d", "(Ljava/util/concurrent/ConcurrentHashMap;)[Ljava/lang/String;", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheckMaterialConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkSchemaPreCheckMaterialConfig f326295a = new WinkSchemaPreCheckMaterialConfig();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheckMaterialConfig$a", "Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;", "Ljava/util/HashMap;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/HashMap;", "materials", "", "a", "onFailed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements WinkSchemaPreCheckDataServiceHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<MetaMaterial>> f326296a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super List<MetaMaterial>> continuation) {
            this.f326296a = continuation;
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckDataServiceHandler.a
        public void a(@NotNull HashMap<String, MetaMaterial> materials) {
            List list;
            Intrinsics.checkNotNullParameter(materials, "materials");
            Continuation<List<MetaMaterial>> continuation = this.f326296a;
            Collection<MetaMaterial> values = materials.values();
            Intrinsics.checkNotNullExpressionValue(values, "materials.values");
            list = CollectionsKt___CollectionsKt.toList(values);
            continuation.resumeWith(Result.m476constructorimpl(list));
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckDataServiceHandler.a
        public void onFailed() {
            List emptyList;
            Continuation<List<MetaMaterial>> continuation = this.f326296a;
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            continuation.resumeWith(Result.m476constructorimpl(emptyList));
        }
    }

    WinkSchemaPreCheckMaterialConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(String str, ConcurrentHashMap<String, String> concurrentHashMap, String str2, Continuation<? super List<MetaMaterial>> continuation) {
        Continuation intercepted;
        boolean z16;
        Object coroutine_suspended;
        List emptyList;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkSchemaPreCheckMaterialConfig winkSchemaPreCheckMaterialConfig = f326295a;
        String e16 = winkSchemaPreCheckMaterialConfig.e(str, str2);
        String[] d16 = winkSchemaPreCheckMaterialConfig.d(concurrentHashMap);
        if (d16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList));
        } else {
            BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkSchemaPreCheckDataServiceHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckDataServiceHandler");
            WinkSchemaPreCheckDataServiceHandler winkSchemaPreCheckDataServiceHandler = (WinkSchemaPreCheckDataServiceHandler) businessHandler;
            winkSchemaPreCheckDataServiceHandler.r3(new a(safeContinuation));
            winkSchemaPreCheckDataServiceHandler.n3(e16, (String[]) Arrays.copyOf(d16, d16.length));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String[] d(ConcurrentHashMap<String, String> keyAttrs) {
        ArrayList arrayList = new ArrayList();
        String str = keyAttrs.get("filter");
        if (str != null) {
            arrayList.add(str);
        }
        String str2 = keyAttrs.get("template");
        if (str2 != null) {
            arrayList.add(str2);
        }
        String str3 = keyAttrs.get("sticker");
        if (str3 != null) {
            arrayList.add(str3);
        }
        String str4 = keyAttrs.get("meterial");
        if (str4 != null) {
            arrayList.add(str4);
        }
        String str5 = keyAttrs.get("libtemplate");
        if (str5 != null) {
            arrayList.add(str5);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    private final String e(String jumpTarget, String businessName) {
        String str;
        int hashCode = jumpTarget.hashCode();
        if (hashCode != 50) {
            if (hashCode != 51) {
                if (hashCode != 1572) {
                    if (hashCode != 1576) {
                        if (hashCode != 1598) {
                            switch (hashCode) {
                                case 53:
                                    if (!jumpTarget.equals("5")) {
                                        return "MqKuaishanEdit";
                                    }
                                    break;
                                case 54:
                                    if (!jumpTarget.equals("6")) {
                                        return "MqKuaishanEdit";
                                    }
                                    break;
                                case 55:
                                    str = "7";
                                    break;
                                default:
                                    return "MqKuaishanEdit";
                            }
                        } else if (!jumpTarget.equals("20")) {
                            return "MqKuaishanEdit";
                        }
                    } else if (!jumpTarget.equals("19")) {
                        return "MqKuaishanEdit";
                    }
                    return "QZonePhotoTemplate";
                }
                if (!jumpTarget.equals("15")) {
                    return "MqKuaishanEdit";
                }
                if (Intrinsics.areEqual(businessName, "QZONE")) {
                    return "qzoneMagicStudio";
                }
                return WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO;
            }
            str = "3";
            jumpTarget.equals(str);
            return "MqKuaishanEdit";
        }
        if (!jumpTarget.equals("2")) {
            return "MqKuaishanEdit";
        }
        return "MqKuaishanTemplate";
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull ConcurrentHashMap<String, String> concurrentHashMap, @Nullable String str2, @NotNull Continuation<? super List<MetaMaterial>> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2(str, concurrentHashMap, str2, null), continuation);
    }
}
