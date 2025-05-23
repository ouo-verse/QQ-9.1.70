package com.tencent.mobileqq.onlinestatus.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache;
import com.tencent.mobileqq.onlinestatus.api.impl.q;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000b2#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0013R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/avatar/AvatarPreviewUtil;", "", "", "key", "Lcom/tencent/mobileqq/onlinestatus/api/impl/q;", "callback", "", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache$Key;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "imagePath", "", "d", "c", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarPreviewService;", "e", "", "Ljava/util/Map;", "mTaskList", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarPreviewUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarPreviewUtil f255541a = new AvatarPreviewUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, ArrayList<q>> mTaskList = new LinkedHashMap();

    AvatarPreviewUtil() {
    }

    private final synchronized boolean b(String key, q callback) {
        boolean containsKey;
        Map<String, ArrayList<q>> map = mTaskList;
        containsKey = map.containsKey(key);
        if (!containsKey) {
            QLog.i("AvatarPreviewUtil", 1, "[checkAndAddTask]: addDownloading Task, key is " + key);
            ArrayList<q> arrayList = new ArrayList<>();
            arrayList.add(callback);
            Unit unit = Unit.INSTANCE;
            map.put(key, arrayList);
        } else {
            ArrayList<q> arrayList2 = map.get(key);
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.add(callback);
        }
        return containsKey;
    }

    private final void d(final AvatarStatusPreviewCache.Key key, final Function1<? super String, Unit> callback) {
        try {
            e().getUrl(Long.parseLong(key.getUin()), new Function1<GetUrlResult, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.avatar.AvatarPreviewUtil$downloadPreview$1

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/onlinestatus/avatar/AvatarPreviewUtil$downloadPreview$1$a", "Lcom/tencent/mobileqq/onlinestatus/api/impl/q;", "", "path", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a implements q {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Function1<String, Unit> f255543a;

                    /* JADX WARN: Multi-variable type inference failed */
                    a(Function1<? super String, Unit> function1) {
                        this.f255543a = function1;
                    }

                    @Override // com.tencent.mobileqq.onlinestatus.api.impl.q
                    public void a(@Nullable String path) {
                        this.f255543a.invoke(path);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetUrlResult getUrlResult) {
                    invoke2(getUrlResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GetUrlResult getUrlResult) {
                    boolean equals;
                    if (getUrlResult == null) {
                        QLog.e("AvatarPreviewUtil", 1, "getUrl result is null");
                        callback.invoke(null);
                        return;
                    }
                    if (!TextUtils.isEmpty(getUrlResult.getDownloadUrl())) {
                        equals = StringsKt__StringsJVMKt.equals(key.c(), getUrlResult.getKey(), true);
                        if (!equals) {
                            QLog.i("AvatarPreviewUtil", 1, "getUrl: check key fail, serviceKey is " + getUrlResult.getKey());
                            callback.invoke(null);
                            return;
                        }
                        AvatarStatusPreviewCache.INSTANCE.a().e(getUrlResult.getDownloadUrl(), key, new a(callback), getUrlResult.getCheckMd5AndSha(), getUrlResult.getMd5(), getUrlResult.getSha1());
                        return;
                    }
                    QLog.i("AvatarPreviewUtil", 1, "getUrl: url is null");
                    callback.invoke(null);
                }
            });
        } catch (Error e16) {
            QLog.e("AvatarPreviewUtil", 1, "getUrl error: " + e16);
            callback.invoke(null);
        } catch (Exception e17) {
            QLog.e("AvatarPreviewUtil", 1, "getUrl exception: " + e17);
            callback.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized ArrayList<q> f(String key) {
        ArrayList<q> arrayList;
        Map<String, ArrayList<q>> map = mTaskList;
        if (map.containsKey(key)) {
            QLog.i("AvatarPreviewUtil", 1, "[checkAndAddTask]: remove Task, key is " + key);
            arrayList = map.get(key);
            map.remove(key);
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public final void c(@NotNull final AvatarStatusPreviewCache.Key key, @NotNull q callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (b(key.c(), callback)) {
            QLog.i("AvatarPreviewUtil", 1, "[checkAndDownloadPreview]: already hava downloadTask of key " + key.c());
            return;
        }
        d(key, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.avatar.AvatarPreviewUtil$checkAndDownloadPreview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                ArrayList f16;
                f16 = AvatarPreviewUtil.f255541a.f(AvatarStatusPreviewCache.Key.this.c());
                if (f16 != null) {
                    Iterator it = f16.iterator();
                    while (it.hasNext()) {
                        ((q) it.next()).a(str);
                    }
                }
            }
        });
    }

    @NotNull
    public final IAvatarPreviewService e() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IAvatarPreviewService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        return (IAvatarPreviewService) runtimeService;
    }
}
